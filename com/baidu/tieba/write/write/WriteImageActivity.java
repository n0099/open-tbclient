package com.baidu.tieba.write.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] exF = null;
    private RadioButton exP;
    private RadioButton exQ;
    private LinearLayout eya;
    private HashMap<String, Bitmap> eyc;
    private HashMap<String, ImageView> eyd;
    private View eye;
    private String fVC;
    private View fVx;
    private View fVy;
    private int requestCode;
    private ImageView aMY = null;
    private Bitmap mBitmap = null;
    private TextView fTx = null;
    private View DP = null;
    private HorizontalScrollView exM = null;
    private ProgressBar cdm = null;
    private b fVz = null;
    private a fVA = null;
    private RadioGroup Fh = null;
    private LinearLayout exR = null;
    private LinearLayout exS = null;
    private TextView DK = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap exU = null;
    private c fVB = null;
    private int exW = 0;
    private int exX = 0;
    private int mDisplaySize = 0;
    private boolean exY = true;
    private String exZ = null;
    private boolean eyb = false;
    private boolean edn = false;
    private final Handler mHandler = new Handler();
    private final Object fVD = new Object();
    private final View.OnClickListener fVE = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.cS().ab("motu_sdk") == 1 || PluginPackageManager.hG().bt(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.exY = false;
        } else {
            this.exY = true;
        }
        TbadkCoreApplication.m10getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(u.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fVC = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.exY) {
            TbadkCoreApplication.m10getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.edn = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bb.ue().ul(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bb.ue().ul(), this.mDisplaySize, stringExtra);
            }
            akI();
        } else {
            initUI();
            initData();
        }
        exF = getResources().getStringArray(u.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fVz != null) {
            this.fVz.cancel();
        }
        this.aMY.setImageDrawable(null);
        aOC();
    }

    private void aOC() {
        synchronized (this.fVD) {
            if (this.eyd != null) {
                for (Map.Entry<String, ImageView> entry : this.eyd.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eyd.clear();
                this.eyd = null;
            }
            if (this.eyc != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eyc.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eyc.clear();
                this.eyc = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fVz != null) {
            this.fVz.cancel();
        }
        this.fVz = new b(this, null);
        this.fVz.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        WriteImageActivityConfig.isActivityInStack = false;
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.exU != null && !this.exU.isRecycled()) {
            this.exU.recycle();
            this.exU = null;
        }
        if (this.fVz != null) {
            this.fVz.cancel();
            this.fVz = null;
        }
        this.cdm.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fVB);
        }
        TbadkCoreApplication.m10getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fVE.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.DP);
        com.baidu.tbadk.core.util.av.l(this.mNavigationBar, u.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.DK, u.d.cp_cont_g, 1);
        if (this.fVy.isEnabled()) {
            this.fTx.setTextColor(getResources().getColor(u.d.navi_done_text));
        } else {
            this.fTx.setTextColor(getResources().getColor(u.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.av.b((ImageView) ((ViewGroup) this.fVx).getChildAt(0), u.f.icon_return_s, u.f.icon_return_s);
    }

    private void initUI() {
        this.DP = findViewById(u.g.write_image_root_layout);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
        this.cdm.setVisibility(8);
        this.aMY = (ImageView) findViewById(u.g.image);
        this.aMY.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aMY.setImageBitmap(this.mBitmap);
        }
        this.exM = (HorizontalScrollView) findViewById(u.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.fVx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.fVy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.image_activity_save_button, (View.OnClickListener) null);
        this.fVy.setOnClickListener(new bq(this));
        this.fTx = (TextView) this.fVy.findViewById(u.g.save);
        if (TextUtils.isEmpty(this.fVC)) {
            if (this.edn || this.requestCode != 12003) {
                this.fTx.setText(getPageContext().getString(u.j.done));
            } else {
                this.fTx.setText(getPageContext().getString(u.j.delete));
            }
        } else {
            this.fTx.setText(this.fVC);
        }
        this.eya = (LinearLayout) findViewById(u.g.filters);
        this.exW = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.DK = this.mNavigationBar.setTitleText(getPageContext().getString(u.j.beautify));
        this.exS = (LinearLayout) findViewById(u.g.beautify_rotate);
        this.exR = (LinearLayout) findViewById(u.g.rotate);
        this.exP = (RadioButton) findViewById(u.g.beautify_btn);
        this.exQ = (RadioButton) findViewById(u.g.rotate_btn);
        this.Fh = (RadioGroup) findViewById(u.g.beautify_tabs);
        br brVar = new br(this);
        this.exP.setOnCheckedChangeListener(brVar);
        this.exQ.setOnCheckedChangeListener(brVar);
        this.exP.setChecked(true);
        Button button = (Button) findViewById(u.g.rotate_left);
        Button button2 = (Button) findViewById(u.g.rotate_right);
        Button button3 = (Button) findViewById(u.g.rotate_left_right);
        Button button4 = (Button) findViewById(u.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.exS.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.exY) {
            this.exQ.setPadding(0, this.exQ.getPaddingTop(), this.exQ.getPaddingRight(), this.exQ.getPaddingBottom());
            this.exQ.setChecked(true);
            this.exM.setVisibility(8);
            this.exP.setVisibility(8);
            this.Fh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(String str) {
        if (this.fVA != null) {
            this.fVA.cancel();
        }
        this.fVA = new a(this, null);
        this.fVA.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* synthetic */ b(WriteImageActivity writeImageActivity, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap X = com.baidu.tbadk.core.util.m.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    if (X != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.exY) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fVD) {
                                        WriteImageActivity.this.eyc = new HashMap();
                                        WriteImageActivity.this.eyd = new HashMap();
                                        WriteImageActivity.this.eyc.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                                    }
                                    return X;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return X;
                } catch (Exception e) {
                    bitmap = X;
                    e = e;
                    e.printStackTrace();
                    BdLog.e(e.toString());
                    return bitmap;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.cdm.setVisibility(0);
            WriteImageActivity.this.fVy.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fVz = null;
            WriteImageActivity.this.cdm.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fVy.setEnabled(true);
            WriteImageActivity.this.fVz = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.cdm.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aMY.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.exY) {
                    return;
                }
                WriteImageActivity.this.F(WriteImageActivity.exF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rN(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.exU, 90);
            this.aMY.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.exU, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m10getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.exX));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String[] strArr) {
        if (this.eyc != null && strArr != null) {
            this.eya.removeAllViews();
            this.exS.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(u.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(u.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(u.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(u.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eI(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.eye = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.eya.addView(inflate2);
                synchronized (this.fVD) {
                    this.eyd.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            oL(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.exZ != null && (imageView = this.eyd.get(this.exZ)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.exW, this.exW, this.exW, this.exW);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eyd != null) {
                ImageView imageView2 = this.eyd.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(u.f.bg_choose_filter);
                    imageView2.setPadding(this.exW, this.exW, this.exW, this.exW);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.exZ = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eyj;
        private Boolean eyk;
        private String mLabel;

        private a() {
            this.eyj = false;
            this.eyk = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.exY) {
                PluginPackageManager.PluginStatus bt = PluginPackageManager.hG().bt(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bt != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bt == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(u.j.plugin_config_not_found);
                        return;
                    } else if (bt == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.hG().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bt == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), u.j.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.cdm.setVisibility(0);
            WriteImageActivity.this.fVy.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.exU == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eyj = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eyk = true;
            }
            if (!this.eyj.booleanValue() && !this.eyk.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.exU == null || WriteImageActivity.this.exU.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.exU.copy(WriteImageActivity.this.exU.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eyj.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eyk.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else {
                    MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                    if (motuPlugin != null) {
                        this.bitmap = motuPlugin.createOneKeyFilterAndApply(WriteImageActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                    }
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.exU != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.cdm.setVisibility(8);
            WriteImageActivity.this.fVy.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.cdm.setVisibility(8);
            WriteImageActivity.this.fVy.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eyb = true;
                WriteImageActivity.this.aMY.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eyj.booleanValue() || this.eyk.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eyj.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eyk.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.exU != null && !WriteImageActivity.this.exU.isRecycled()) {
                    WriteImageActivity.this.exU.recycle();
                }
                WriteImageActivity.this.exU = bitmap;
            }
        }
    }

    private void akI() {
        this.fVB = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fVB, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(WriteImageActivity writeImageActivity, c cVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WriteImageActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                WriteImageActivity.this.initData();
                return;
            }
            WriteImageActivity.this.showToast(intent.getStringExtra("error"));
            if (WriteImageActivity.this.fVy != null) {
                WriteImageActivity.this.fVy.setEnabled(false);
            }
        }
    }
}
