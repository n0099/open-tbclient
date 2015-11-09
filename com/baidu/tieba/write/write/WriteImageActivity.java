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
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] cpx = null;
    private RadioButton cpH;
    private RadioButton cpI;
    private LinearLayout cpS;
    private HashMap<String, Bitmap> cpU;
    private HashMap<String, ImageView> cpV;
    private View cpW;
    private View dse;
    private View dsf;
    private String dsj;
    private int requestCode;
    private ImageView aCk = null;
    private Bitmap mBitmap = null;
    private TextView dqa = null;
    private View LT = null;
    private HorizontalScrollView cpE = null;
    private ProgressBar mProgress = null;
    private b dsg = null;
    private a dsh = null;
    private RadioGroup MT = null;
    private LinearLayout cpJ = null;
    private LinearLayout cpK = null;
    private TextView LO = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap cpM = null;
    private c dsi = null;
    private int cpO = 0;
    private int cpP = 0;
    private int mDisplaySize = 0;
    private boolean cpQ = true;
    private String cpR = null;
    private boolean cpT = false;
    private boolean ckL = false;
    private final Handler mHandler = new Handler();
    private final Object dsk = new Object();
    private final View.OnClickListener dsl = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.gv().af("motu_sdk") == 1 || PluginPackageManager.lS().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cpQ = false;
        } else {
            this.cpQ = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(i.g.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.dsj = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.cpQ) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.ckL = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.at.uK().uQ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.at.uK().uQ(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cpx = getResources().getStringArray(i.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.dsg != null) {
            this.dsg.cancel();
        }
        this.aCk.setImageDrawable(null);
        aiI();
    }

    private void aiI() {
        synchronized (this.dsk) {
            if (this.cpV != null) {
                for (Map.Entry<String, ImageView> entry : this.cpV.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.cpV.clear();
                this.cpV = null;
            }
            if (this.cpU != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.cpU.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.cpU.clear();
                this.cpU = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.dsg != null) {
            this.dsg.cancel();
        }
        this.dsg = new b(this, null);
        this.dsg.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.cpM != null && !this.cpM.isRecycled()) {
            this.cpM.recycle();
            this.cpM = null;
        }
        if (this.dsg != null) {
            this.dsg.cancel();
            this.dsg = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.dsi);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.dsl.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.LT);
        com.baidu.tbadk.core.util.an.j(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.dse);
        getLayoutMode().k(this.LO);
        if (this.dsf.isEnabled()) {
            this.dqa.setTextColor(getResources().getColor(i.c.navi_done_text));
        } else {
            this.dqa.setTextColor(getResources().getColor(i.c.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void initUI() {
        this.LT = findViewById(i.f.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.aCk = (ImageView) findViewById(i.f.image);
        this.aCk.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aCk.setImageBitmap(this.mBitmap);
        }
        this.cpE = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.dse = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.dsf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.dsf.setOnClickListener(new bq(this));
        this.dqa = (TextView) this.dsf.findViewById(i.f.save);
        if (TextUtils.isEmpty(this.dsj)) {
            if (this.ckL || this.requestCode != 12003) {
                this.dqa.setText(getPageContext().getString(i.h.done));
            } else {
                this.dqa.setText(getPageContext().getString(i.h.delete));
            }
        } else {
            this.dqa.setText(this.dsj);
        }
        this.cpS = (LinearLayout) findViewById(i.f.filters);
        this.cpO = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.LO = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.beautify));
        this.cpK = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.cpJ = (LinearLayout) findViewById(i.f.rotate);
        this.cpH = (RadioButton) findViewById(i.f.beautify_btn);
        this.cpI = (RadioButton) findViewById(i.f.rotate_btn);
        this.MT = (RadioGroup) findViewById(i.f.beautify_tabs);
        br brVar = new br(this);
        this.cpH.setOnCheckedChangeListener(brVar);
        this.cpI.setOnCheckedChangeListener(brVar);
        this.cpH.setChecked(true);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.cpK.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.cpQ) {
            this.cpI.setPadding(0, this.cpI.getPaddingTop(), this.cpI.getPaddingRight(), this.cpI.getPaddingBottom());
            this.cpI.setChecked(true);
            this.cpE.setVisibility(8);
            this.cpH.setVisibility(8);
            this.MT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(String str) {
        if (this.dsh != null) {
            this.dsh.cancel();
        }
        this.dsh = new a(this, null);
        this.dsh.execute(str);
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
                Bitmap aa = com.baidu.tbadk.core.util.n.aa(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && aa != null && !aa.isRecycled()) {
                        aa.recycle();
                        return null;
                    }
                    if (aa != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.cpQ) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(aa, dip2px);
                            if (g != null) {
                                if (g.equals(aa)) {
                                    aa = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(aa, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.dsk) {
                                        WriteImageActivity.this.cpU = new HashMap();
                                        WriteImageActivity.this.cpV = new HashMap();
                                        WriteImageActivity.this.cpU.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return aa;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return aa;
                } catch (Exception e) {
                    bitmap = aa;
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
            WriteImageActivity.this.dsf.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.dsg = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.dsf.setEnabled(true);
            WriteImageActivity.this.dsg = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aCk.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.cpQ) {
                    return;
                }
                WriteImageActivity.this.w(WriteImageActivity.cpx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mC(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.cpM, 90);
            this.aCk.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.cpM, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.cpP));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.cpU != null && strArr != null) {
            this.cpS.removeAllViews();
            this.cpK.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(i.f.filter_immage);
            TextView textView = (TextView) inflate.findViewById(i.f.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(i.f.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(i.f.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eq(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.cpW = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.cpS.addView(inflate2);
                synchronized (this.dsk) {
                    this.cpV.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kb(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cpR != null && (imageView = this.cpV.get(this.cpR)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cpO, this.cpO, this.cpO, this.cpO);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.cpV != null) {
                ImageView imageView2 = this.cpV.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(i.e.bg_choose_filter);
                    imageView2.setPadding(this.cpO, this.cpO, this.cpO, this.cpO);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.cpR = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean cqa;
        private Boolean cqb;
        private String mLabel;

        private a() {
            this.cqa = false;
            this.cqb = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.cpQ) {
                PluginPackageManager.PluginStatus bu = PluginPackageManager.lS().bu(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bu != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bu == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(i.h.plugin_config_not_found);
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lS().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), i.h.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dsf.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.cpM == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cqa = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cqb = true;
            }
            if (!this.cqa.booleanValue() && !this.cqb.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.cpM == null || WriteImageActivity.this.cpM.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.cpM.copy(WriteImageActivity.this.cpM.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.cqa.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.cqb.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.cpM != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dsf.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dsf.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.cpT = true;
                WriteImageActivity.this.aCk.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.cqa.booleanValue() || this.cqb.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.cqa.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cqb.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.cpM != null && !WriteImageActivity.this.cpM.isRecycled()) {
                    WriteImageActivity.this.cpM.recycle();
                }
                WriteImageActivity.this.cpM = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.dsi = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.dsi, intentFilter);
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
            if (WriteImageActivity.this.dsf != null) {
                WriteImageActivity.this.dsf.setEnabled(false);
            }
        }
    }
}
