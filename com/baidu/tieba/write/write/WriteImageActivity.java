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
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] eDD = null;
    private RadioButton eDN;
    private RadioButton eDO;
    private LinearLayout eDY;
    private HashMap<String, Bitmap> eEa;
    private HashMap<String, ImageView> eEb;
    private View eEc;
    private View fQL;
    private View fQM;
    private String fQQ;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView fOH = null;
    private View aWX = null;
    private HorizontalScrollView eDK = null;
    private ProgressBar bqO = null;
    private b fQN = null;
    private a fQO = null;
    private RadioGroup erM = null;
    private LinearLayout eDP = null;
    private LinearLayout eDQ = null;
    private TextView bIN = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eDS = null;
    private c fQP = null;
    private int eDU = 0;
    private int eDV = 0;
    private int mDisplaySize = 0;
    private boolean eDW = true;
    private String eDX = null;
    private boolean eDZ = false;
    private boolean enm = false;
    private final Handler mHandler = new Handler();
    private final Object fQR = new Object();
    private final View.OnClickListener fQS = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.eT().ab("motu_sdk") == 1 || PluginPackageManager.jt().bn(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eDW = false;
        } else {
            this.eDW = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(w.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fQQ = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eDW) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.enm = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.av.vD().vJ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.av.vD().vJ(), this.mDisplaySize, stringExtra);
            }
            amY();
        } else {
            initUI();
            initData();
        }
        eDD = getResources().getStringArray(w.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fQN != null) {
            this.fQN.cancel();
        }
        this.mImage.setImageDrawable(null);
        aQy();
    }

    private void aQy() {
        synchronized (this.fQR) {
            if (this.eEb != null) {
                for (Map.Entry<String, ImageView> entry : this.eEb.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eEb.clear();
                this.eEb = null;
            }
            if (this.eEa != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eEa.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eEa.clear();
                this.eEa = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fQN != null) {
            this.fQN.cancel();
        }
        this.fQN = new b(this, null);
        this.fQN.execute(new Object[0]);
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
        if (this.eDS != null && !this.eDS.isRecycled()) {
            this.eDS.recycle();
            this.eDS = null;
        }
        if (this.fQN != null) {
            this.fQN.cancel();
            this.fQN = null;
        }
        this.bqO.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fQP);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fQS.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aWX);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.bIN, w.e.cp_cont_g, 1);
        if (this.fQM.isEnabled()) {
            this.fOH.setTextColor(getResources().getColor(w.e.navi_done_text));
        } else {
            this.fOH.setTextColor(getResources().getColor(w.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.aq.b((ImageView) ((ViewGroup) this.fQL).getChildAt(0), w.g.icon_return_s, w.g.icon_return_s);
    }

    private void initUI() {
        this.aWX = findViewById(w.h.write_image_root_layout);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
        this.bqO.setVisibility(8);
        this.mImage = (ImageView) findViewById(w.h.image);
        this.mImage.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eDK = (HorizontalScrollView) findViewById(w.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.fQL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.fQM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, (View.OnClickListener) null);
        this.fQM.setOnClickListener(new bo(this));
        this.fOH = (TextView) this.fQM.findViewById(w.h.save);
        if (TextUtils.isEmpty(this.fQQ)) {
            if (this.enm || this.requestCode != 12003) {
                this.fOH.setText(getPageContext().getString(w.l.done));
            } else {
                this.fOH.setText(getPageContext().getString(w.l.delete));
            }
        } else {
            this.fOH.setText(this.fQQ);
        }
        this.eDY = (LinearLayout) findViewById(w.h.filters);
        this.eDU = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bIN = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.beautify));
        this.eDQ = (LinearLayout) findViewById(w.h.beautify_rotate);
        this.eDP = (LinearLayout) findViewById(w.h.rotate);
        this.eDN = (RadioButton) findViewById(w.h.beautify_btn);
        this.eDO = (RadioButton) findViewById(w.h.rotate_btn);
        this.erM = (RadioGroup) findViewById(w.h.beautify_tabs);
        bp bpVar = new bp(this);
        this.eDN.setOnCheckedChangeListener(bpVar);
        this.eDO.setOnCheckedChangeListener(bpVar);
        this.eDN.setChecked(true);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bq bqVar = new bq(this);
        button.setOnClickListener(bqVar);
        button2.setOnClickListener(bqVar);
        button3.setOnClickListener(bqVar);
        button4.setOnClickListener(bqVar);
        this.eDQ.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eDW) {
            this.eDO.setPadding(0, this.eDO.getPaddingTop(), this.eDO.getPaddingRight(), this.eDO.getPaddingBottom());
            this.eDO.setChecked(true);
            this.eDK.setVisibility(8);
            this.eDN.setVisibility(8);
            this.erM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(String str) {
        if (this.fQO != null) {
            this.fQO.cancel();
        }
        this.fQO = new a(this, null);
        this.fQO.execute(str);
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
                Bitmap V = com.baidu.tbadk.core.util.l.V(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && V != null && !V.isRecycled()) {
                        V.recycle();
                        return null;
                    }
                    if (V != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eDW) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(V, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(V)) {
                                    V = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(V, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fQR) {
                                        WriteImageActivity.this.eEa = new HashMap();
                                        WriteImageActivity.this.eEb = new HashMap();
                                        WriteImageActivity.this.eEa.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                                    }
                                    return V;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return V;
                } catch (Exception e) {
                    bitmap = V;
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
            WriteImageActivity.this.bqO.setVisibility(0);
            WriteImageActivity.this.fQM.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fQN = null;
            WriteImageActivity.this.bqO.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fQM.setEnabled(true);
            WriteImageActivity.this.fQN = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.bqO.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eDW) {
                    return;
                }
                WriteImageActivity.this.B(WriteImageActivity.eDD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qX(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.eDS, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eDS, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eDV));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String[] strArr) {
        if (this.eEa != null && strArr != null) {
            this.eDY.removeAllViews();
            this.eDQ.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(w.h.filter_immage);
            TextView textView = (TextView) inflate.findViewById(w.h.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(w.h.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(w.h.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.ey(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                    this.eEc = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.eDY.addView(inflate2);
                synchronized (this.fQR) {
                    this.eEb.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            nY(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eDX != null && (imageView = this.eEb.get(this.eDX)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eDU, this.eDU, this.eDU, this.eDU);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eEb != null) {
                ImageView imageView2 = this.eEb.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(w.g.bg_choose_filter);
                    imageView2.setPadding(this.eDU, this.eDU, this.eDU, this.eDU);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eDX = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eEh;
        private Boolean eEi;
        private String mLabel;

        private a() {
            this.eEh = false;
            this.eEi = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eDW) {
                PluginPackageManager.PluginStatus bn = PluginPackageManager.jt().bn(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bn != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bn == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(w.l.plugin_config_not_found);
                        return;
                    } else if (bn == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jt().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        cancel();
                        return;
                    } else if (bn == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), w.l.plugin_muto_not_install, new bv(this), new bw(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.bqO.setVisibility(0);
            WriteImageActivity.this.fQM.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eDS == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eEh = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eEi = true;
            }
            if (!this.eEh.booleanValue() && !this.eEi.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eDS == null || WriteImageActivity.this.eDS.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eDS.copy(WriteImageActivity.this.eDS.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eEh.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eEi.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eDS != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.bqO.setVisibility(8);
            WriteImageActivity.this.fQM.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.bqO.setVisibility(8);
            WriteImageActivity.this.fQM.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eDZ = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eEh.booleanValue() || this.eEi.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eEh.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eEi.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eDS != null && !WriteImageActivity.this.eDS.isRecycled()) {
                    WriteImageActivity.this.eDS.recycle();
                }
                WriteImageActivity.this.eDS = bitmap;
            }
        }
    }

    private void amY() {
        this.fQP = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fQP, intentFilter);
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
            if (WriteImageActivity.this.fQM != null) {
                WriteImageActivity.this.fQM.setEnabled(false);
            }
        }
    }
}
