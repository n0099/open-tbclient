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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] cNi = null;
    private LinearLayout cND;
    private HashMap<String, Bitmap> cNF;
    private HashMap<String, ImageView> cNG;
    private View cNH;
    private RadioButton cNs;
    private RadioButton cNt;
    private View dYG;
    private View dYH;
    private String dYL;
    private int requestCode;
    private ImageView aIx = null;
    private Bitmap mBitmap = null;
    private TextView dWC = null;
    private View MA = null;
    private HorizontalScrollView cNp = null;
    private ProgressBar mProgress = null;
    private b dYI = null;
    private a dYJ = null;
    private RadioGroup NA = null;
    private LinearLayout cNu = null;
    private LinearLayout cNv = null;
    private TextView Mv = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap cNx = null;
    private c dYK = null;
    private int cNz = 0;
    private int cNA = 0;
    private int mDisplaySize = 0;
    private boolean cNB = true;
    private String cNC = null;
    private boolean cNE = false;
    private boolean cHa = false;
    private final Handler mHandler = new Handler();
    private final Object dYM = new Object();
    private final View.OnClickListener dYN = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gw().aj("motu_sdk") == 1 || PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cNB = false;
        } else {
            this.cNB = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(n.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.dYL = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.cNB) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.cHa = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ay.va().vg(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ay.va().vg(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cNi = getResources().getStringArray(n.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.dYI != null) {
            this.dYI.cancel();
        }
        this.aIx.setImageDrawable(null);
        aow();
    }

    private void aow() {
        synchronized (this.dYM) {
            if (this.cNG != null) {
                for (Map.Entry<String, ImageView> entry : this.cNG.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.cNG.clear();
                this.cNG = null;
            }
            if (this.cNF != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.cNF.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.cNF.clear();
                this.cNF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.dYI != null) {
            this.dYI.cancel();
        }
        this.dYI = new b(this, null);
        this.dYI.execute(new Object[0]);
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
        if (this.cNx != null && !this.cNx.isRecycled()) {
            this.cNx.recycle();
            this.cNx = null;
        }
        if (this.dYI != null) {
            this.dYI.cancel();
            this.dYI = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.dYK);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.dYN.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.MA);
        com.baidu.tbadk.core.util.as.j(this.mNavigationBar, n.d.alpha80_black);
        getLayoutMode().k(this.dYG);
        getLayoutMode().k(this.Mv);
        if (this.dYH.isEnabled()) {
            this.dWC.setTextColor(getResources().getColor(n.d.navi_done_text));
        } else {
            this.dWC.setTextColor(getResources().getColor(n.d.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void initUI() {
        this.MA = findViewById(n.g.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        this.mProgress.setVisibility(8);
        this.aIx = (ImageView) findViewById(n.g.image);
        this.aIx.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aIx.setImageBitmap(this.mBitmap);
        }
        this.cNp = (HorizontalScrollView) findViewById(n.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.dYG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.dYH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.image_activity_save_button, (View.OnClickListener) null);
        this.dYH.setOnClickListener(new bq(this));
        this.dWC = (TextView) this.dYH.findViewById(n.g.save);
        if (TextUtils.isEmpty(this.dYL)) {
            if (this.cHa || this.requestCode != 12003) {
                this.dWC.setText(getPageContext().getString(n.j.done));
            } else {
                this.dWC.setText(getPageContext().getString(n.j.delete));
            }
        } else {
            this.dWC.setText(this.dYL);
        }
        this.cND = (LinearLayout) findViewById(n.g.filters);
        this.cNz = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Mv = this.mNavigationBar.setTitleText(getPageContext().getString(n.j.beautify));
        this.cNv = (LinearLayout) findViewById(n.g.beautify_rotate);
        this.cNu = (LinearLayout) findViewById(n.g.rotate);
        this.cNs = (RadioButton) findViewById(n.g.beautify_btn);
        this.cNt = (RadioButton) findViewById(n.g.rotate_btn);
        this.NA = (RadioGroup) findViewById(n.g.beautify_tabs);
        br brVar = new br(this);
        this.cNs.setOnCheckedChangeListener(brVar);
        this.cNt.setOnCheckedChangeListener(brVar);
        this.cNs.setChecked(true);
        Button button = (Button) findViewById(n.g.rotate_left);
        Button button2 = (Button) findViewById(n.g.rotate_right);
        Button button3 = (Button) findViewById(n.g.rotate_left_right);
        Button button4 = (Button) findViewById(n.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.cNv.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.cNB) {
            this.cNt.setPadding(0, this.cNt.getPaddingTop(), this.cNt.getPaddingRight(), this.cNt.getPaddingBottom());
            this.cNt.setChecked(true);
            this.cNp.setVisibility(8);
            this.cNs.setVisibility(8);
            this.NA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(String str) {
        if (this.dYJ != null) {
            this.dYJ.cancel();
        }
        this.dYJ = new a(this, null);
        this.dYJ.execute(str);
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
                Bitmap W = com.baidu.tbadk.core.util.n.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    if (W != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.cNB) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(W, dip2px);
                            if (g != null) {
                                if (g.equals(W)) {
                                    W = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(W, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.dYM) {
                                        WriteImageActivity.this.cNF = new HashMap();
                                        WriteImageActivity.this.cNG = new HashMap();
                                        WriteImageActivity.this.cNF.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return W;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return W;
                } catch (Exception e) {
                    bitmap = W;
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
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dYH.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.dYI = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.dYH.setEnabled(true);
            WriteImageActivity.this.dYI = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aIx.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.cNB) {
                    return;
                }
                WriteImageActivity.this.w(WriteImageActivity.cNi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nw(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.cNx, 90);
            this.aIx.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.cNx, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.cNA));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.cNF != null && strArr != null) {
            this.cND.removeAllViews();
            this.cNv.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(n.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(n.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(n.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(n.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eD(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.cNH = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.cND.addView(inflate2);
                synchronized (this.dYM) {
                    this.cNG.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kP(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cNC != null && (imageView = this.cNG.get(this.cNC)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cNz, this.cNz, this.cNz, this.cNz);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.cNG != null) {
                ImageView imageView2 = this.cNG.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(n.f.bg_choose_filter);
                    imageView2.setPadding(this.cNz, this.cNz, this.cNz, this.cNz);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.cNC = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean cNL;
        private Boolean cNM;
        private String mLabel;

        private a() {
            this.cNL = false;
            this.cNM = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.cNB) {
                PluginPackageManager.PluginStatus bB = PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bB != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bB == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(n.j.plugin_config_not_found);
                        return;
                    } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), n.j.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dYH.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.cNx == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cNL = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cNM = true;
            }
            if (!this.cNL.booleanValue() && !this.cNM.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.cNx == null || WriteImageActivity.this.cNx.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.cNx.copy(WriteImageActivity.this.cNx.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.cNL.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.cNM.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.cNx != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dYH.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dYH.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.cNE = true;
                WriteImageActivity.this.aIx.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.cNL.booleanValue() || this.cNM.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.cNL.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cNM.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.cNx != null && !WriteImageActivity.this.cNx.isRecycled()) {
                    WriteImageActivity.this.cNx.recycle();
                }
                WriteImageActivity.this.cNx = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.dYK = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.dYK, intentFilter);
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
            if (WriteImageActivity.this.dYH != null) {
                WriteImageActivity.this.dYH.setEnabled(false);
            }
        }
    }
}
