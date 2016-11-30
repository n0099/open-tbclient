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
    private static String[] eML = null;
    private RadioButton eMV;
    private RadioButton eMW;
    private LinearLayout eNg;
    private HashMap<String, Bitmap> eNi;
    private HashMap<String, ImageView> eNj;
    private View eNk;
    private String gpD;
    private View gpy;
    private View gpz;
    private int requestCode;
    private ImageView aVc = null;
    private Bitmap mBitmap = null;
    private TextView gnq = null;
    private View Ge = null;
    private HorizontalScrollView eMS = null;
    private ProgressBar cub = null;
    private b gpA = null;
    private a gpB = null;
    private RadioGroup Hw = null;
    private LinearLayout eMX = null;
    private LinearLayout eMY = null;
    private TextView FZ = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eNa = null;
    private c gpC = null;
    private int eNc = 0;
    private int eNd = 0;
    private int mDisplaySize = 0;
    private boolean eNe = true;
    private String eNf = null;
    private boolean eNh = false;
    private boolean exj = false;
    private final Handler mHandler = new Handler();
    private final Object gpE = new Object();
    private final View.OnClickListener gpF = new bo(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.dN().ac("motu_sdk") == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eNe = false;
        } else {
            this.eNe = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(r.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.gpD = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eNe) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.exj = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ay.vC().vI(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ay.vC().vI(), this.mDisplaySize, stringExtra);
            }
            arT();
        } else {
            initUI();
            initData();
        }
        eML = getResources().getStringArray(r.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gpA != null) {
            this.gpA.cancel();
        }
        this.aVc.setImageDrawable(null);
        aVl();
    }

    private void aVl() {
        synchronized (this.gpE) {
            if (this.eNj != null) {
                for (Map.Entry<String, ImageView> entry : this.eNj.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eNj.clear();
                this.eNj = null;
            }
            if (this.eNi != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eNi.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eNi.clear();
                this.eNi = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gpA != null) {
            this.gpA.cancel();
        }
        this.gpA = new b(this, null);
        this.gpA.execute(new Object[0]);
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
        if (this.eNa != null && !this.eNa.isRecycled()) {
            this.eNa.recycle();
            this.eNa = null;
        }
        if (this.gpA != null) {
            this.gpA.cancel();
            this.gpA = null;
        }
        this.cub.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gpC);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.gpF.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.Ge);
        com.baidu.tbadk.core.util.at.l(this.mNavigationBar, r.d.common_color_10222);
        com.baidu.tbadk.core.util.at.c(this.FZ, r.d.cp_cont_g, 1);
        if (this.gpz.isEnabled()) {
            this.gnq.setTextColor(getResources().getColor(r.d.navi_done_text));
        } else {
            this.gnq.setTextColor(getResources().getColor(r.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.at.b((ImageView) ((ViewGroup) this.gpy).getChildAt(0), r.f.icon_return_s, r.f.icon_return_s);
    }

    private void initUI() {
        this.Ge = findViewById(r.g.write_image_root_layout);
        this.cub = (ProgressBar) findViewById(r.g.progress);
        this.cub.setVisibility(8);
        this.aVc = (ImageView) findViewById(r.g.image);
        this.aVc.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.aVc.setImageBitmap(this.mBitmap);
        }
        this.eMS = (HorizontalScrollView) findViewById(r.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.gpy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.gpz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, (View.OnClickListener) null);
        this.gpz.setOnClickListener(new br(this));
        this.gnq = (TextView) this.gpz.findViewById(r.g.save);
        if (TextUtils.isEmpty(this.gpD)) {
            if (this.exj || this.requestCode != 12003) {
                this.gnq.setText(getPageContext().getString(r.j.done));
            } else {
                this.gnq.setText(getPageContext().getString(r.j.delete));
            }
        } else {
            this.gnq.setText(this.gpD);
        }
        this.eNg = (LinearLayout) findViewById(r.g.filters);
        this.eNc = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.FZ = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.beautify));
        this.eMY = (LinearLayout) findViewById(r.g.beautify_rotate);
        this.eMX = (LinearLayout) findViewById(r.g.rotate);
        this.eMV = (RadioButton) findViewById(r.g.beautify_btn);
        this.eMW = (RadioButton) findViewById(r.g.rotate_btn);
        this.Hw = (RadioGroup) findViewById(r.g.beautify_tabs);
        bs bsVar = new bs(this);
        this.eMV.setOnCheckedChangeListener(bsVar);
        this.eMW.setOnCheckedChangeListener(bsVar);
        this.eMV.setChecked(true);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bt btVar = new bt(this);
        button.setOnClickListener(btVar);
        button2.setOnClickListener(btVar);
        button3.setOnClickListener(btVar);
        button4.setOnClickListener(btVar);
        this.eMY.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eNe) {
            this.eMW.setPadding(0, this.eMW.getPaddingTop(), this.eMW.getPaddingRight(), this.eMW.getPaddingBottom());
            this.eMW.setChecked(true);
            this.eMS.setVisibility(8);
            this.eMV.setVisibility(8);
            this.Hw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(String str) {
        if (this.gpB != null) {
            this.gpB.cancel();
        }
        this.gpB = new a(this, null);
        this.gpB.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eNe) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.gpE) {
                                        WriteImageActivity.this.eNi = new HashMap();
                                        WriteImageActivity.this.eNj = new HashMap();
                                        WriteImageActivity.this.eNi.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.cub.setVisibility(0);
            WriteImageActivity.this.gpz.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.gpA = null;
            WriteImageActivity.this.cub.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.gpz.setEnabled(true);
            WriteImageActivity.this.gpA = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.cub.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aVc.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eNe) {
                    return;
                }
                WriteImageActivity.this.E(WriteImageActivity.eML);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tj(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.eNa, 90);
            this.aVc.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eNa, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eNd));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.eNi != null && strArr != null) {
            this.eNg.removeAllViews();
            this.eMY.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eQ(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                    this.eNk = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.eNg.addView(inflate2);
                synchronized (this.gpE) {
                    this.eNj.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eNf != null && (imageView = this.eNj.get(this.eNf)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eNc, this.eNc, this.eNc, this.eNc);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eNj != null) {
                ImageView imageView2 = this.eNj.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(r.f.bg_choose_filter);
                    imageView2.setPadding(this.eNc, this.eNc, this.eNc, this.eNc);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eNf = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eNp;
        private Boolean eNq;
        private String mLabel;

        private a() {
            this.eNp = false;
            this.eNq = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eNe) {
                PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bu != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bu == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        WriteImageActivity.this.showToast(r.j.plugin_config_not_found);
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), r.j.plugin_muto_not_install, new by(this), new bz(this));
                        WriteImageActivity.this.mHandler.postDelayed(new ca(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.cub.setVisibility(0);
            WriteImageActivity.this.gpz.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eNa == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eNp = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eNq = true;
            }
            if (!this.eNp.booleanValue() && !this.eNq.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eNa == null || WriteImageActivity.this.eNa.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eNa.copy(WriteImageActivity.this.eNa.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eNp.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eNq.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eNa != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.cub.setVisibility(8);
            WriteImageActivity.this.gpz.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.cub.setVisibility(8);
            WriteImageActivity.this.gpz.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eNh = true;
                WriteImageActivity.this.aVc.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eNp.booleanValue() || this.eNq.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eNp.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eNq.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eNa != null && !WriteImageActivity.this.eNa.isRecycled()) {
                    WriteImageActivity.this.eNa.recycle();
                }
                WriteImageActivity.this.eNa = bitmap;
            }
        }
    }

    private void arT() {
        this.gpC = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gpC, intentFilter);
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
            if (WriteImageActivity.this.gpz != null) {
                WriteImageActivity.this.gpz.setEnabled(false);
            }
        }
    }
}
