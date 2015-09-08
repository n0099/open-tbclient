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
    private static String[] ciu = null;
    private RadioButton ciE;
    private RadioButton ciF;
    private LinearLayout ciP;
    private HashMap<String, Bitmap> ciR;
    private HashMap<String, ImageView> ciS;
    private View ciT;
    private View ddU;
    private View ddV;
    private String ddZ;
    private int requestCode;
    private ImageView aEa = null;
    private Bitmap mBitmap = null;
    private TextView dbU = null;
    private View LR = null;
    private HorizontalScrollView ciB = null;
    private ProgressBar mProgress = null;
    private b ddW = null;
    private a ddX = null;
    private RadioGroup MS = null;
    private LinearLayout ciG = null;
    private LinearLayout ciH = null;
    private TextView LM = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap ciJ = null;
    private c ddY = null;
    private int ciL = 0;
    private int ciM = 0;
    private int mDisplaySize = 0;
    private boolean ciN = true;
    private String ciO = null;
    private boolean ciQ = false;
    private boolean ccY = false;
    private final Handler mHandler = new Handler();
    private final Object dea = new Object();
    private final View.OnClickListener deb = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.gv().ah("motu_sdk") == 1 || PluginPackageManager.lQ().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.ciN = false;
        } else {
            this.ciN = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(i.g.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.ddZ = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.ciN) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.ccY = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ar.uK().uQ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ar.uK().uQ(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        ciu = getResources().getStringArray(i.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ddW != null) {
            this.ddW.cancel();
        }
        this.aEa.setImageDrawable(null);
        agh();
    }

    private void agh() {
        synchronized (this.dea) {
            if (this.ciS != null) {
                for (Map.Entry<String, ImageView> entry : this.ciS.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.ciS.clear();
                this.ciS = null;
            }
            if (this.ciR != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.ciR.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.ciR.clear();
                this.ciR = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ddW != null) {
            this.ddW.cancel();
        }
        this.ddW = new b(this, null);
        this.ddW.execute(new Object[0]);
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
        if (this.ciJ != null && !this.ciJ.isRecycled()) {
            this.ciJ.recycle();
            this.ciJ = null;
        }
        if (this.ddW != null) {
            this.ddW.cancel();
            this.ddW = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.ddY);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.deb.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.LR);
        com.baidu.tbadk.core.util.al.i(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.ddU);
        getLayoutMode().k(this.LM);
        this.ddV.setBackgroundResource(i.e.title_icon_bg_for_image);
        if (this.ddV.isEnabled()) {
            this.dbU.setTextColor(getResources().getColor(i.c.navi_done_text));
        } else {
            this.dbU.setTextColor(getResources().getColor(i.c.navi_done_text_d));
        }
    }

    private void initUI() {
        this.LR = findViewById(i.f.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.aEa = (ImageView) findViewById(i.f.image);
        this.aEa.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.aEa.setImageBitmap(this.mBitmap);
        }
        this.ciB = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.ddU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.ddV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.ddV.setOnClickListener(new bo(this));
        this.dbU = (TextView) this.ddV.findViewById(i.f.save);
        if (TextUtils.isEmpty(this.ddZ)) {
            if (this.ccY || this.requestCode != 12003) {
                this.dbU.setText(getPageContext().getString(i.h.done));
            } else {
                this.dbU.setText(getPageContext().getString(i.h.delete));
            }
        } else {
            this.dbU.setText(this.ddZ);
        }
        this.ciP = (LinearLayout) findViewById(i.f.filters);
        this.ciL = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.LM = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.beautify));
        this.ciH = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.ciG = (LinearLayout) findViewById(i.f.rotate);
        this.ciE = (RadioButton) findViewById(i.f.beautify_btn);
        this.ciF = (RadioButton) findViewById(i.f.rotate_btn);
        this.MS = (RadioGroup) findViewById(i.f.beautify_tabs);
        bp bpVar = new bp(this);
        this.ciE.setOnCheckedChangeListener(bpVar);
        this.ciF.setOnCheckedChangeListener(bpVar);
        this.ciE.setChecked(true);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bq bqVar = new bq(this);
        button.setOnClickListener(bqVar);
        button2.setOnClickListener(bqVar);
        button3.setOnClickListener(bqVar);
        button4.setOnClickListener(bqVar);
        this.ciH.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.ciN) {
            this.ciF.setPadding(0, this.ciF.getPaddingTop(), this.ciF.getPaddingRight(), this.ciF.getPaddingBottom());
            this.ciF.setChecked(true);
            this.ciB.setVisibility(8);
            this.ciE.setVisibility(8);
            this.MS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(String str) {
        if (this.ddX != null) {
            this.ddX.cancel();
        }
        this.ddX = new a(this, null);
        this.ddX.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.ciN) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(ab, dip2px);
                            if (g != null) {
                                if (g.equals(ab)) {
                                    ab = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(ab, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.dea) {
                                        WriteImageActivity.this.ciR = new HashMap();
                                        WriteImageActivity.this.ciS = new HashMap();
                                        WriteImageActivity.this.ciR.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
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
            WriteImageActivity.this.ddV.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.ddW = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.ddV.setEnabled(true);
            WriteImageActivity.this.ddW = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aEa.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.ciN) {
                    return;
                }
                WriteImageActivity.this.x(WriteImageActivity.ciu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lN(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.ciJ, 90);
            this.aEa.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.ciJ, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.ciM));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String[] strArr) {
        if (this.ciR != null && strArr != null) {
            this.ciP.removeAllViews();
            this.ciH.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eo(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                    this.ciT = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.ciP.addView(inflate2);
                synchronized (this.dea) {
                    this.ciS.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            jD(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.ciO != null && (imageView = this.ciS.get(this.ciO)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.ciL, this.ciL, this.ciL, this.ciL);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.ciS != null) {
                ImageView imageView2 = this.ciS.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(i.e.bg_choose_filter);
                    imageView2.setPadding(this.ciL, this.ciL, this.ciL, this.ciL);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.ciO = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean ciX;
        private Boolean ciY;
        private String mLabel;

        private a() {
            this.ciX = false;
            this.ciY = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.ciN) {
                PluginPackageManager.PluginStatus bv = PluginPackageManager.lQ().bv(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bv != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bv == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(i.h.plugin_config_not_found);
                        return;
                    } else if (bv == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lQ().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        cancel();
                        return;
                    } else if (bv == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.util.a.a(WriteImageActivity.this.getPageContext(), i.h.plugin_muto_not_install, new bv(this), new bw(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.ddV.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.ciJ == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.ciX = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.ciY = true;
            }
            if (!this.ciX.booleanValue() && !this.ciY.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.ciJ == null || WriteImageActivity.this.ciJ.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.ciJ.copy(WriteImageActivity.this.ciJ.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.ciX.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.ciY.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.ciJ != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ddV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ddV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.ciQ = true;
                WriteImageActivity.this.aEa.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.ciX.booleanValue() || this.ciY.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.ciX.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.ciY.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.ciJ != null && !WriteImageActivity.this.ciJ.isRecycled()) {
                    WriteImageActivity.this.ciJ.recycle();
                }
                WriteImageActivity.this.ciJ = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.ddY = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ddY, intentFilter);
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
            if (WriteImageActivity.this.ddV != null) {
                WriteImageActivity.this.ddV.setEnabled(false);
            }
        }
    }
}
