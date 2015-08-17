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
    private static String[] chA = null;
    private View cUQ;
    private View cUR;
    private String cUV;
    private RadioButton chJ;
    private RadioButton chK;
    private LinearLayout chU;
    private HashMap<String, Bitmap> chW;
    private HashMap<String, ImageView> chX;
    private View chY;
    private int requestCode;
    private ImageView aCs = null;
    private Bitmap mBitmap = null;
    private TextView cSX = null;
    private View LR = null;
    private HorizontalScrollView chG = null;
    private ProgressBar mProgress = null;
    private b cUS = null;
    private a cUT = null;
    private RadioGroup MU = null;
    private LinearLayout chL = null;
    private LinearLayout chM = null;
    private TextView LM = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap chO = null;
    private c cUU = null;
    private int chQ = 0;
    private int chR = 0;
    private int mDisplaySize = 0;
    private boolean chS = true;
    private String chT = null;
    private boolean chV = false;
    private boolean ccd = false;
    private final Handler mHandler = new Handler();
    private final Object cUW = new Object();
    private final View.OnClickListener cUX = new bh(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.gy().ah("motu_sdk") == 1 || PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.chS = false;
        } else {
            this.chS = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(i.g.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.cUV = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.chS) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.ccd = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ar.uE().uK(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ar.uE().uK(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        chA = getResources().getStringArray(i.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cUS != null) {
            this.cUS.cancel();
        }
        this.aCs.setImageDrawable(null);
        afR();
    }

    private void afR() {
        synchronized (this.cUW) {
            if (this.chX != null) {
                for (Map.Entry<String, ImageView> entry : this.chX.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.chX.clear();
                this.chX = null;
            }
            if (this.chW != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.chW.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.chW.clear();
                this.chW = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cUS != null) {
            this.cUS.cancel();
        }
        this.cUS = new b(this, null);
        this.cUS.execute(new Object[0]);
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
        if (this.chO != null && !this.chO.isRecycled()) {
            this.chO.recycle();
            this.chO = null;
        }
        if (this.cUS != null) {
            this.cUS.cancel();
            this.cUS = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cUU);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.cUX.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.LR);
        com.baidu.tbadk.core.util.al.j(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.cUQ);
        getLayoutMode().k(this.LM);
        this.cUR.setBackgroundResource(i.e.title_icon_bg_for_image);
        if (this.cUR.isEnabled()) {
            this.cSX.setTextColor(getResources().getColor(i.c.navi_done_text));
        } else {
            this.cSX.setTextColor(getResources().getColor(i.c.navi_done_text_d));
        }
    }

    private void initUI() {
        this.LR = findViewById(i.f.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.aCs = (ImageView) findViewById(i.f.image);
        this.aCs.setOnClickListener(new bi(this));
        if (this.mBitmap != null) {
            this.aCs.setImageBitmap(this.mBitmap);
        }
        this.chG = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.cUQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bj(this));
        this.cUR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.cUR.setOnClickListener(new bk(this));
        this.cSX = (TextView) this.cUR.findViewById(i.f.save);
        if (TextUtils.isEmpty(this.cUV)) {
            if (this.ccd || this.requestCode != 12003) {
                this.cSX.setText(getPageContext().getString(i.C0057i.done));
            } else {
                this.cSX.setText(getPageContext().getString(i.C0057i.delete));
            }
        } else {
            this.cSX.setText(this.cUV);
        }
        this.chU = (LinearLayout) findViewById(i.f.filters);
        this.chQ = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.LM = this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.beautify));
        this.chM = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.chL = (LinearLayout) findViewById(i.f.rotate);
        this.chJ = (RadioButton) findViewById(i.f.beautify_btn);
        this.chK = (RadioButton) findViewById(i.f.rotate_btn);
        this.MU = (RadioGroup) findViewById(i.f.beautify_tabs);
        bl blVar = new bl(this);
        this.chJ.setOnCheckedChangeListener(blVar);
        this.chK.setOnCheckedChangeListener(blVar);
        this.chJ.setChecked(true);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bm bmVar = new bm(this);
        button.setOnClickListener(bmVar);
        button2.setOnClickListener(bmVar);
        button3.setOnClickListener(bmVar);
        button4.setOnClickListener(bmVar);
        this.chM.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.chS) {
            this.chK.setPadding(0, this.chK.getPaddingTop(), this.chK.getPaddingRight(), this.chK.getPaddingBottom());
            this.chK.setChecked(true);
            this.chG.setVisibility(8);
            this.chJ.setVisibility(8);
            this.MU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(String str) {
        if (this.cUT != null) {
            this.cUT.cancel();
        }
        this.cUT = new a(this, null);
        this.cUT.execute(str);
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
                Bitmap ab = com.baidu.tbadk.core.util.n.ab(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && ab != null && !ab.isRecycled()) {
                        ab.recycle();
                        return null;
                    }
                    if (ab != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.chS) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(ab, dip2px);
                            if (g != null) {
                                if (g.equals(ab)) {
                                    ab = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(ab, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.cUW) {
                                        WriteImageActivity.this.chW = new HashMap();
                                        WriteImageActivity.this.chX = new HashMap();
                                        WriteImageActivity.this.chW.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return ab;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return ab;
                } catch (Exception e) {
                    bitmap = ab;
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
            WriteImageActivity.this.cUR.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.cUS = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.cUR.setEnabled(true);
            WriteImageActivity.this.cUS = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aCs.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.chS) {
                    return;
                }
                WriteImageActivity.this.w(WriteImageActivity.chA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lf(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.chO, 90);
            this.aCs.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.chO, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.chR));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.chW != null && strArr != null) {
            this.chU.removeAllViews();
            this.chM.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eh(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bn(this, substring, i2));
                    this.chY = imageView2;
                } else {
                    imageView2.setOnClickListener(new bo(this, substring, i2));
                }
                this.chU.addView(inflate2);
                synchronized (this.cUW) {
                    this.chX.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            jv(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.chT != null && (imageView = this.chX.get(this.chT)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.chQ, this.chQ, this.chQ, this.chQ);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.chX != null) {
                ImageView imageView2 = this.chX.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(i.e.bg_choose_filter);
                    imageView2.setPadding(this.chQ, this.chQ, this.chQ, this.chQ);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.chT = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean cic;
        private Boolean cie;
        private String mLabel;

        private a() {
            this.cic = false;
            this.cie = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.chS) {
                PluginPackageManager.PluginStatus bv = PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bv != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bv == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bp(this), 500L);
                        WriteImageActivity.this.showToast(i.C0057i.plugin_config_not_found);
                        return;
                    } else if (bv == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lT().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bq(this), 500L);
                        cancel();
                        return;
                    } else if (bv == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.util.a.a(WriteImageActivity.this.getPageContext(), i.C0057i.plugin_muto_not_install, new br(this), new bs(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.cUR.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.chO == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cic = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cie = true;
            }
            if (!this.cic.booleanValue() && !this.cie.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.chO == null || WriteImageActivity.this.chO.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.chO.copy(WriteImageActivity.this.chO.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.cic.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.cie.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.chO != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.cUR.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.cUR.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.chV = true;
                WriteImageActivity.this.aCs.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.cic.booleanValue() || this.cie.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.cic.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cie.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.chO != null && !WriteImageActivity.this.chO.isRecycled()) {
                    WriteImageActivity.this.chO.recycle();
                }
                WriteImageActivity.this.chO = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.cUU = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cUU, intentFilter);
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
            if (WriteImageActivity.this.cUR != null) {
                WriteImageActivity.this.cUR.setEnabled(false);
            }
        }
    }
}
