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
    private static String[] cWC = null;
    private RadioButton cWM;
    private RadioButton cWN;
    private LinearLayout cWX;
    private HashMap<String, Bitmap> cWZ;
    private HashMap<String, ImageView> cXa;
    private View cXb;
    private String etA;
    private View etv;
    private View etw;
    private int requestCode;
    private ImageView aJB = null;
    private Bitmap mBitmap = null;
    private TextView erv = null;
    private View MQ = null;
    private HorizontalScrollView cWJ = null;
    private ProgressBar aNo = null;
    private b etx = null;
    private a ety = null;
    private RadioGroup Od = null;
    private LinearLayout cWO = null;
    private LinearLayout cWP = null;
    private TextView ML = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap cWR = null;
    private c etz = null;
    private int cWT = 0;
    private int cWU = 0;
    private int mDisplaySize = 0;
    private boolean cWV = true;
    private String cWW = null;
    private boolean cWY = false;
    private boolean cOF = false;
    private final Handler mHandler = new Handler();
    private final Object etB = new Object();
    private final View.OnClickListener etC = new bk(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gE().ai("motu_sdk") == 1 || PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cWV = false;
        } else {
            this.cWV = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(t.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.etA = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.cWV) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.cOF = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            qD();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ax.wg().wm(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ax.wg().wm(), this.mDisplaySize, stringExtra);
            }
            Jq();
        } else {
            qD();
            initData();
        }
        cWC = getResources().getStringArray(t.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.etx != null) {
            this.etx.cancel();
        }
        this.aJB.setImageDrawable(null);
        atn();
    }

    private void atn() {
        synchronized (this.etB) {
            if (this.cXa != null) {
                for (Map.Entry<String, ImageView> entry : this.cXa.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.cXa.clear();
                this.cXa = null;
            }
            if (this.cWZ != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.cWZ.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.cWZ.clear();
                this.cWZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.etx != null) {
            this.etx.cancel();
        }
        this.etx = new b(this, null);
        this.etx.execute(new Object[0]);
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
        if (this.cWR != null && !this.cWR.isRecycled()) {
            this.cWR.recycle();
            this.cWR = null;
        }
        if (this.etx != null) {
            this.etx.cancel();
            this.etx = null;
        }
        this.aNo.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.etz);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.etC.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.MQ);
        com.baidu.tbadk.core.util.ar.l(this.mNavigationBar, t.d.alpha80_black);
        getLayoutMode().x(this.etv);
        getLayoutMode().x(this.ML);
        if (this.etw.isEnabled()) {
            this.erv.setTextColor(getResources().getColor(t.d.navi_done_text));
        } else {
            this.erv.setTextColor(getResources().getColor(t.d.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void qD() {
        this.MQ = findViewById(t.g.write_image_root_layout);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        this.aNo.setVisibility(8);
        this.aJB = (ImageView) findViewById(t.g.image);
        this.aJB.setOnClickListener(new bl(this));
        if (this.mBitmap != null) {
            this.aJB.setImageBitmap(this.mBitmap);
        }
        this.cWJ = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.etv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bm(this));
        this.etw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.etw.setOnClickListener(new bn(this));
        this.erv = (TextView) this.etw.findViewById(t.g.save);
        if (TextUtils.isEmpty(this.etA)) {
            if (this.cOF || this.requestCode != 12003) {
                this.erv.setText(getPageContext().getString(t.j.done));
            } else {
                this.erv.setText(getPageContext().getString(t.j.delete));
            }
        } else {
            this.erv.setText(this.etA);
        }
        this.cWX = (LinearLayout) findViewById(t.g.filters);
        this.cWT = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.ML = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        this.cWP = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.cWO = (LinearLayout) findViewById(t.g.rotate);
        this.cWM = (RadioButton) findViewById(t.g.beautify_btn);
        this.cWN = (RadioButton) findViewById(t.g.rotate_btn);
        this.Od = (RadioGroup) findViewById(t.g.beautify_tabs);
        bo boVar = new bo(this);
        this.cWM.setOnCheckedChangeListener(boVar);
        this.cWN.setOnCheckedChangeListener(boVar);
        this.cWM.setChecked(true);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bp bpVar = new bp(this);
        button.setOnClickListener(bpVar);
        button2.setOnClickListener(bpVar);
        button3.setOnClickListener(bpVar);
        button4.setOnClickListener(bpVar);
        this.cWP.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.cWV) {
            this.cWN.setPadding(0, this.cWN.getPaddingTop(), this.cWN.getPaddingRight(), this.cWN.getPaddingBottom());
            this.cWN.setChecked(true);
            this.cWJ.setVisibility(8);
            this.cWM.setVisibility(8);
            this.Od.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(String str) {
        if (this.ety != null) {
            this.ety.cancel();
        }
        this.ety = new a(this, null);
        this.ety.execute(str);
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
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap W = com.baidu.tbadk.core.util.m.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    if (W != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.cWV) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(W, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(W)) {
                                    W = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(W, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.etB) {
                                        WriteImageActivity.this.cWZ = new HashMap();
                                        WriteImageActivity.this.cXa = new HashMap();
                                        WriteImageActivity.this.cWZ.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.aNo.setVisibility(0);
            WriteImageActivity.this.etw.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.etx = null;
            WriteImageActivity.this.aNo.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.etw.setEnabled(true);
            WriteImageActivity.this.etx = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.aNo.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aJB.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.cWV) {
                    return;
                }
                WriteImageActivity.this.A(WriteImageActivity.cWC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nO(String str) {
        try {
            com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_PIC_DIR, str, this.cWR, 90);
            this.aJB.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.cWR, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.b(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.cWU));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.cWZ != null && strArr != null) {
            this.cWX.removeAllViews();
            this.cWP.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eC(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bq(this, substring, i2));
                    this.cXb = imageView2;
                } else {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                }
                this.cWX.addView(inflate2);
                synchronized (this.etB) {
                    this.cXa.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cWW != null && (imageView = this.cXa.get(this.cWW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cWT, this.cWT, this.cWT, this.cWT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.cXa != null) {
                ImageView imageView2 = this.cXa.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(t.f.bg_choose_filter);
                    imageView2.setPadding(this.cWT, this.cWT, this.cWT, this.cWT);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.cWW = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean cXf;
        private Boolean cXg;
        private String mLabel;

        private a() {
            this.cXf = false;
            this.cXg = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.cWV) {
                PluginPackageManager.PluginStatus bB = PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bB != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bB == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bs(this), 500L);
                        WriteImageActivity.this.showToast(t.j.plugin_config_not_found);
                        return;
                    } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lD().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        cancel();
                        return;
                    } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), t.j.plugin_muto_not_install, new bu(this), new bv(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.aNo.setVisibility(0);
            WriteImageActivity.this.etw.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.cWR == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cXf = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cXg = true;
            }
            if (!this.cXf.booleanValue() && !this.cXg.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.cWR == null || WriteImageActivity.this.cWR.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.cWR.copy(WriteImageActivity.this.cWR.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.cXf.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.cXg.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.cWR != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.aNo.setVisibility(8);
            WriteImageActivity.this.etw.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.aNo.setVisibility(8);
            WriteImageActivity.this.etw.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.cWY = true;
                WriteImageActivity.this.aJB.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.cXf.booleanValue() || this.cXg.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.cXf.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cXg.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.cWR != null && !WriteImageActivity.this.cWR.isRecycled()) {
                    WriteImageActivity.this.cWR.recycle();
                }
                WriteImageActivity.this.cWR = bitmap;
            }
        }
    }

    private void Jq() {
        this.etz = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.etz, intentFilter);
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
            if (WriteImageActivity.this.etw != null) {
                WriteImageActivity.this.etw.setEnabled(false);
            }
        }
    }
}
