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
    private static String[] eBA = null;
    private RadioButton eBK;
    private RadioButton eBL;
    private LinearLayout eBV;
    private HashMap<String, Bitmap> eBX;
    private HashMap<String, ImageView> eBY;
    private View eBZ;
    private String fSA;
    private View fSv;
    private View fSw;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView fQr = null;
    private View aXl = null;
    private HorizontalScrollView eBH = null;
    private ProgressBar mProgress = null;
    private b fSx = null;
    private a fSy = null;
    private RadioGroup epV = null;
    private LinearLayout eBM = null;
    private LinearLayout eBN = null;
    private TextView bIG = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eBP = null;
    private c fSz = null;
    private int eBR = 0;
    private int eBS = 0;
    private int mDisplaySize = 0;
    private boolean eBT = true;
    private String eBU = null;
    private boolean eBW = false;
    private boolean elt = false;
    private final Handler mHandler = new Handler();
    private final Object fSB = new Object();
    private final View.OnClickListener fSC = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.eY().Y("motu_sdk") == 1 || PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eBT = false;
        } else {
            this.eBT = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(w.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fSA = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eBT) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.elt = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.av.wa().wg(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.av.wa().wg(), this.mDisplaySize, stringExtra);
            }
            amS();
        } else {
            initUI();
            initData();
        }
        eBA = getResources().getStringArray(w.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fSx != null) {
            this.fSx.cancel();
        }
        this.mImage.setImageDrawable(null);
        aQH();
    }

    private void aQH() {
        synchronized (this.fSB) {
            if (this.eBY != null) {
                for (Map.Entry<String, ImageView> entry : this.eBY.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eBY.clear();
                this.eBY = null;
            }
            if (this.eBX != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eBX.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eBX.clear();
                this.eBX = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fSx != null) {
            this.fSx.cancel();
        }
        this.fSx = new b(this, null);
        this.fSx.execute(new Object[0]);
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
        if (this.eBP != null && !this.eBP.isRecycled()) {
            this.eBP.recycle();
            this.eBP = null;
        }
        if (this.fSx != null) {
            this.fSx.cancel();
            this.fSx = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fSz);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fSC.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.aXl);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.bIG, w.e.cp_cont_g, 1);
        if (this.fSw.isEnabled()) {
            this.fQr.setTextColor(getResources().getColor(w.e.navi_done_text));
        } else {
            this.fQr.setTextColor(getResources().getColor(w.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.aq.b((ImageView) ((ViewGroup) this.fSv).getChildAt(0), w.g.icon_return_s, w.g.icon_return_s);
    }

    private void initUI() {
        this.aXl = findViewById(w.h.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(w.h.image);
        this.mImage.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eBH = (HorizontalScrollView) findViewById(w.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.fSv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.fSw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, (View.OnClickListener) null);
        this.fSw.setOnClickListener(new bo(this));
        this.fQr = (TextView) this.fSw.findViewById(w.h.save);
        if (TextUtils.isEmpty(this.fSA)) {
            if (this.elt || this.requestCode != 12003) {
                this.fQr.setText(getPageContext().getString(w.l.done));
            } else {
                this.fQr.setText(getPageContext().getString(w.l.delete));
            }
        } else {
            this.fQr.setText(this.fSA);
        }
        this.eBV = (LinearLayout) findViewById(w.h.filters);
        this.eBR = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bIG = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.beautify));
        this.eBN = (LinearLayout) findViewById(w.h.beautify_rotate);
        this.eBM = (LinearLayout) findViewById(w.h.rotate);
        this.eBK = (RadioButton) findViewById(w.h.beautify_btn);
        this.eBL = (RadioButton) findViewById(w.h.rotate_btn);
        this.epV = (RadioGroup) findViewById(w.h.beautify_tabs);
        bp bpVar = new bp(this);
        this.eBK.setOnCheckedChangeListener(bpVar);
        this.eBL.setOnCheckedChangeListener(bpVar);
        this.eBK.setChecked(true);
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
        this.eBN.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eBT) {
            this.eBL.setPadding(0, this.eBL.getPaddingTop(), this.eBL.getPaddingRight(), this.eBL.getPaddingBottom());
            this.eBL.setChecked(true);
            this.eBH.setVisibility(8);
            this.eBK.setVisibility(8);
            this.epV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp(String str) {
        if (this.fSy != null) {
            this.fSy.cancel();
        }
        this.fSy = new a(this, null);
        this.fSy.execute(str);
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
                Bitmap W = com.baidu.tbadk.core.util.l.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    if (W != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eBT) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(W, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(W)) {
                                    W = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(W, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fSB) {
                                        WriteImageActivity.this.eBX = new HashMap();
                                        WriteImageActivity.this.eBY = new HashMap();
                                        WriteImageActivity.this.eBX.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.fSw.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fSx = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fSw.setEnabled(true);
            WriteImageActivity.this.fSx = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eBT) {
                    return;
                }
                WriteImageActivity.this.B(WriteImageActivity.eBA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rq(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.eBP, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eBP, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eBS));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String[] strArr) {
        if (this.eBX != null && strArr != null) {
            this.eBV.removeAllViews();
            this.eBN.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eE(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                    this.eBZ = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.eBV.addView(inflate2);
                synchronized (this.fSB) {
                    this.eBY.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            oc(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eBU != null && (imageView = this.eBY.get(this.eBU)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eBR, this.eBR, this.eBR, this.eBR);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eBY != null) {
                ImageView imageView2 = this.eBY.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(w.g.bg_choose_filter);
                    imageView2.setPadding(this.eBR, this.eBR, this.eBR, this.eBR);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eBU = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eCe;
        private Boolean eCf;
        private String mLabel;

        private a() {
            this.eCe = false;
            this.eCf = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eBT) {
                PluginPackageManager.PluginStatus bi = PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bi != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bi == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(w.l.plugin_config_not_found);
                        return;
                    } else if (bi == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jx().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        cancel();
                        return;
                    } else if (bi == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), w.l.plugin_muto_not_install, new bv(this), new bw(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.fSw.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eBP == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eCe = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eCf = true;
            }
            if (!this.eCe.booleanValue() && !this.eCf.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eBP == null || WriteImageActivity.this.eBP.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eBP.copy(WriteImageActivity.this.eBP.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eCe.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eCf.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eBP != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.fSw.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.fSw.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eBW = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eCe.booleanValue() || this.eCf.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eCe.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eCf.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eBP != null && !WriteImageActivity.this.eBP.isRecycled()) {
                    WriteImageActivity.this.eBP.recycle();
                }
                WriteImageActivity.this.eBP = bitmap;
            }
        }
    }

    private void amS() {
        this.fSz = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fSz, intentFilter);
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
            if (WriteImageActivity.this.fSw != null) {
                WriteImageActivity.this.fSw.setEnabled(false);
            }
        }
    }
}
