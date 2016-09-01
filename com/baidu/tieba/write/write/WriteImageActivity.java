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
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] eEi = null;
    private LinearLayout eED;
    private HashMap<String, Bitmap> eEF;
    private HashMap<String, ImageView> eEG;
    private View eEH;
    private RadioButton eEs;
    private RadioButton eEt;
    private View gfC;
    private View gfD;
    private String gfH;
    private int requestCode;
    private ImageView aSs = null;
    private Bitmap mBitmap = null;
    private TextView gdC = null;
    private View Gc = null;
    private HorizontalScrollView eEp = null;
    private ProgressBar coz = null;
    private b gfE = null;
    private a gfF = null;
    private RadioGroup Hu = null;
    private LinearLayout eEu = null;
    private LinearLayout eEv = null;
    private TextView FX = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eEx = null;
    private c gfG = null;
    private int eEz = 0;
    private int eEA = 0;
    private int mDisplaySize = 0;
    private boolean eEB = true;
    private String eEC = null;
    private boolean eEE = false;
    private boolean eps = false;
    private final Handler mHandler = new Handler();
    private final Object gfI = new Object();
    private final View.OnClickListener gfJ = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.dN().ac("motu_sdk") == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eEB = false;
        } else {
            this.eEB = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(t.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.gfH = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eEB) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eps = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bb.vk().vq(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bb.vk().vq(), this.mDisplaySize, stringExtra);
            }
            apx();
        } else {
            initUI();
            initData();
        }
        eEi = getResources().getStringArray(t.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gfE != null) {
            this.gfE.cancel();
        }
        this.aSs.setImageDrawable(null);
        aSG();
    }

    private void aSG() {
        synchronized (this.gfI) {
            if (this.eEG != null) {
                for (Map.Entry<String, ImageView> entry : this.eEG.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eEG.clear();
                this.eEG = null;
            }
            if (this.eEF != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eEF.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eEF.clear();
                this.eEF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gfE != null) {
            this.gfE.cancel();
        }
        this.gfE = new b(this, null);
        this.gfE.execute(new Object[0]);
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
        if (this.eEx != null && !this.eEx.isRecycled()) {
            this.eEx.recycle();
            this.eEx = null;
        }
        if (this.gfE != null) {
            this.gfE.cancel();
            this.gfE = null;
        }
        this.coz.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gfG);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.gfJ.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.Gc);
        com.baidu.tbadk.core.util.av.l(this.mNavigationBar, t.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.FX, t.d.cp_cont_g, 1);
        if (this.gfD.isEnabled()) {
            this.gdC.setTextColor(getResources().getColor(t.d.navi_done_text));
        } else {
            this.gdC.setTextColor(getResources().getColor(t.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.av.b((ImageView) ((ViewGroup) this.gfC).getChildAt(0), t.f.icon_return_s, t.f.icon_return_s);
    }

    private void initUI() {
        this.Gc = findViewById(t.g.write_image_root_layout);
        this.coz = (ProgressBar) findViewById(t.g.progress);
        this.coz.setVisibility(8);
        this.aSs = (ImageView) findViewById(t.g.image);
        this.aSs.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aSs.setImageBitmap(this.mBitmap);
        }
        this.eEp = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.gfC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.gfD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.gfD.setOnClickListener(new bq(this));
        this.gdC = (TextView) this.gfD.findViewById(t.g.save);
        if (TextUtils.isEmpty(this.gfH)) {
            if (this.eps || this.requestCode != 12003) {
                this.gdC.setText(getPageContext().getString(t.j.done));
            } else {
                this.gdC.setText(getPageContext().getString(t.j.delete));
            }
        } else {
            this.gdC.setText(this.gfH);
        }
        this.eED = (LinearLayout) findViewById(t.g.filters);
        this.eEz = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.FX = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        this.eEv = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.eEu = (LinearLayout) findViewById(t.g.rotate);
        this.eEs = (RadioButton) findViewById(t.g.beautify_btn);
        this.eEt = (RadioButton) findViewById(t.g.rotate_btn);
        this.Hu = (RadioGroup) findViewById(t.g.beautify_tabs);
        br brVar = new br(this);
        this.eEs.setOnCheckedChangeListener(brVar);
        this.eEt.setOnCheckedChangeListener(brVar);
        this.eEs.setChecked(true);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.eEv.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eEB) {
            this.eEt.setPadding(0, this.eEt.getPaddingTop(), this.eEt.getPaddingRight(), this.eEt.getPaddingBottom());
            this.eEt.setChecked(true);
            this.eEp.setVisibility(8);
            this.eEs.setVisibility(8);
            this.Hu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(String str) {
        if (this.gfF != null) {
            this.gfF.cancel();
        }
        this.gfF = new a(this, null);
        this.gfF.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eEB) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.gfI) {
                                        WriteImageActivity.this.eEF = new HashMap();
                                        WriteImageActivity.this.eEG = new HashMap();
                                        WriteImageActivity.this.eEF.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.coz.setVisibility(0);
            WriteImageActivity.this.gfD.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.gfE = null;
            WriteImageActivity.this.coz.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.gfD.setEnabled(true);
            WriteImageActivity.this.gfE = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.coz.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aSs.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eEB) {
                    return;
                }
                WriteImageActivity.this.F(WriteImageActivity.eEi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sx(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.eEx, 90);
            this.aSs.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eEx, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eEA));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String[] strArr) {
        if (this.eEF != null && strArr != null) {
            this.eED.removeAllViews();
            this.eEv.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(t.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(t.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(t.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(t.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eL(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.eEH = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.eED.addView(inflate2);
                synchronized (this.gfI) {
                    this.eEG.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            px(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eEC != null && (imageView = this.eEG.get(this.eEC)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eEz, this.eEz, this.eEz, this.eEz);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eEG != null) {
                ImageView imageView2 = this.eEG.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(t.f.bg_choose_filter);
                    imageView2.setPadding(this.eEz, this.eEz, this.eEz, this.eEz);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eEC = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eEM;
        private Boolean eEN;
        private String mLabel;

        private a() {
            this.eEM = false;
            this.eEN = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eEB) {
                PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bu != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bu == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(t.j.plugin_config_not_found);
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), t.j.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.coz.setVisibility(0);
            WriteImageActivity.this.gfD.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eEx == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eEM = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eEN = true;
            }
            if (!this.eEM.booleanValue() && !this.eEN.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eEx == null || WriteImageActivity.this.eEx.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eEx.copy(WriteImageActivity.this.eEx.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eEM.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eEN.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eEx != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.coz.setVisibility(8);
            WriteImageActivity.this.gfD.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.coz.setVisibility(8);
            WriteImageActivity.this.gfD.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eEE = true;
                WriteImageActivity.this.aSs.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eEM.booleanValue() || this.eEN.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eEM.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eEN.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eEx != null && !WriteImageActivity.this.eEx.isRecycled()) {
                    WriteImageActivity.this.eEx.recycle();
                }
                WriteImageActivity.this.eEx = bitmap;
            }
        }
    }

    private void apx() {
        this.gfG = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gfG, intentFilter);
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
            if (WriteImageActivity.this.gfD != null) {
                WriteImageActivity.this.gfD.setEnabled(false);
            }
        }
    }
}
