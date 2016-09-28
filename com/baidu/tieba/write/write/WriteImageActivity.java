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
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] eGm = null;
    private LinearLayout eGH;
    private HashMap<String, Bitmap> eGJ;
    private HashMap<String, ImageView> eGK;
    private View eGL;
    private RadioButton eGw;
    private RadioButton eGx;
    private View ghM;
    private View ghN;
    private String ghR;
    private int requestCode;
    private ImageView aTb = null;
    private Bitmap mBitmap = null;
    private TextView gfM = null;
    private View Gc = null;
    private HorizontalScrollView eGt = null;
    private ProgressBar coW = null;
    private b ghO = null;
    private a ghP = null;
    private RadioGroup Hu = null;
    private LinearLayout eGy = null;
    private LinearLayout eGz = null;
    private TextView FX = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eGB = null;
    private c ghQ = null;
    private int eGD = 0;
    private int eGE = 0;
    private int mDisplaySize = 0;
    private boolean eGF = true;
    private String eGG = null;
    private boolean eGI = false;
    private boolean erq = false;
    private final Handler mHandler = new Handler();
    private final Object ghS = new Object();
    private final View.OnClickListener ghT = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.dN().ac("motu_sdk") == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eGF = false;
        } else {
            this.eGF = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(r.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.ghR = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eGF) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.erq = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ba.vy().vE(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ba.vy().vE(), this.mDisplaySize, stringExtra);
            }
            apW();
        } else {
            initUI();
            initData();
        }
        eGm = getResources().getStringArray(r.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ghO != null) {
            this.ghO.cancel();
        }
        this.aTb.setImageDrawable(null);
        aTe();
    }

    private void aTe() {
        synchronized (this.ghS) {
            if (this.eGK != null) {
                for (Map.Entry<String, ImageView> entry : this.eGK.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eGK.clear();
                this.eGK = null;
            }
            if (this.eGJ != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eGJ.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eGJ.clear();
                this.eGJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ghO != null) {
            this.ghO.cancel();
        }
        this.ghO = new b(this, null);
        this.ghO.execute(new Object[0]);
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
        if (this.eGB != null && !this.eGB.isRecycled()) {
            this.eGB.recycle();
            this.eGB = null;
        }
        if (this.ghO != null) {
            this.ghO.cancel();
            this.ghO = null;
        }
        this.coW.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.ghQ);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.ghT.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.Gc);
        com.baidu.tbadk.core.util.av.l(this.mNavigationBar, r.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.FX, r.d.cp_cont_g, 1);
        if (this.ghN.isEnabled()) {
            this.gfM.setTextColor(getResources().getColor(r.d.navi_done_text));
        } else {
            this.gfM.setTextColor(getResources().getColor(r.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.av.b((ImageView) ((ViewGroup) this.ghM).getChildAt(0), r.f.icon_return_s, r.f.icon_return_s);
    }

    private void initUI() {
        this.Gc = findViewById(r.g.write_image_root_layout);
        this.coW = (ProgressBar) findViewById(r.g.progress);
        this.coW.setVisibility(8);
        this.aTb = (ImageView) findViewById(r.g.image);
        this.aTb.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aTb.setImageBitmap(this.mBitmap);
        }
        this.eGt = (HorizontalScrollView) findViewById(r.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.ghM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.ghN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, (View.OnClickListener) null);
        this.ghN.setOnClickListener(new bq(this));
        this.gfM = (TextView) this.ghN.findViewById(r.g.save);
        if (TextUtils.isEmpty(this.ghR)) {
            if (this.erq || this.requestCode != 12003) {
                this.gfM.setText(getPageContext().getString(r.j.done));
            } else {
                this.gfM.setText(getPageContext().getString(r.j.delete));
            }
        } else {
            this.gfM.setText(this.ghR);
        }
        this.eGH = (LinearLayout) findViewById(r.g.filters);
        this.eGD = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.FX = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.beautify));
        this.eGz = (LinearLayout) findViewById(r.g.beautify_rotate);
        this.eGy = (LinearLayout) findViewById(r.g.rotate);
        this.eGw = (RadioButton) findViewById(r.g.beautify_btn);
        this.eGx = (RadioButton) findViewById(r.g.rotate_btn);
        this.Hu = (RadioGroup) findViewById(r.g.beautify_tabs);
        br brVar = new br(this);
        this.eGw.setOnCheckedChangeListener(brVar);
        this.eGx.setOnCheckedChangeListener(brVar);
        this.eGw.setChecked(true);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.eGz.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eGF) {
            this.eGx.setPadding(0, this.eGx.getPaddingTop(), this.eGx.getPaddingRight(), this.eGx.getPaddingBottom());
            this.eGx.setChecked(true);
            this.eGt.setVisibility(8);
            this.eGw.setVisibility(8);
            this.Hu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(String str) {
        if (this.ghP != null) {
            this.ghP.cancel();
        }
        this.ghP = new a(this, null);
        this.ghP.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eGF) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.ghS) {
                                        WriteImageActivity.this.eGJ = new HashMap();
                                        WriteImageActivity.this.eGK = new HashMap();
                                        WriteImageActivity.this.eGJ.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.coW.setVisibility(0);
            WriteImageActivity.this.ghN.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.ghO = null;
            WriteImageActivity.this.coW.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.ghN.setEnabled(true);
            WriteImageActivity.this.ghO = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.coW.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aTb.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eGF) {
                    return;
                }
                WriteImageActivity.this.F(WriteImageActivity.eGm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sM(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.eGB, 90);
            this.aTb.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eGB, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eGE));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String[] strArr) {
        if (this.eGJ != null && strArr != null) {
            this.eGH.removeAllViews();
            this.eGz.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(r.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(r.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(r.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(r.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eO(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.eGL = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.eGH.addView(inflate2);
                synchronized (this.ghS) {
                    this.eGK.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            pJ(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eGG != null && (imageView = this.eGK.get(this.eGG)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eGD, this.eGD, this.eGD, this.eGD);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eGK != null) {
                ImageView imageView2 = this.eGK.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(r.f.bg_choose_filter);
                    imageView2.setPadding(this.eGD, this.eGD, this.eGD, this.eGD);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eGG = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eGQ;
        private Boolean eGR;
        private String mLabel;

        private a() {
            this.eGQ = false;
            this.eGR = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eGF) {
                PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bu != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bu == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(r.j.plugin_config_not_found);
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), r.j.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.coW.setVisibility(0);
            WriteImageActivity.this.ghN.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eGB == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eGQ = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eGR = true;
            }
            if (!this.eGQ.booleanValue() && !this.eGR.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eGB == null || WriteImageActivity.this.eGB.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eGB.copy(WriteImageActivity.this.eGB.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eGQ.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eGR.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eGB != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.coW.setVisibility(8);
            WriteImageActivity.this.ghN.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.coW.setVisibility(8);
            WriteImageActivity.this.ghN.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eGI = true;
                WriteImageActivity.this.aTb.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eGQ.booleanValue() || this.eGR.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eGQ.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eGR.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eGB != null && !WriteImageActivity.this.eGB.isRecycled()) {
                    WriteImageActivity.this.eGB.recycle();
                }
                WriteImageActivity.this.eGB = bitmap;
            }
        }
    }

    private void apW() {
        this.ghQ = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ghQ, intentFilter);
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
            if (WriteImageActivity.this.ghN != null) {
                WriteImageActivity.this.ghN.setEnabled(false);
            }
        }
    }
}
