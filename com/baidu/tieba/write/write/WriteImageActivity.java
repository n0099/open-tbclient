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
    private static String[] eAe = null;
    private HashMap<String, Bitmap> eAB;
    private HashMap<String, ImageView> eAC;
    private View eAD;
    private RadioButton eAo;
    private RadioButton eAp;
    private LinearLayout eAz;
    private View fMq;
    private View fMr;
    private String fMv;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView fKo = null;
    private View Fo = null;
    private HorizontalScrollView eAl = null;
    private ProgressBar bkd = null;
    private b fMs = null;
    private a fMt = null;
    private RadioGroup GF = null;
    private LinearLayout eAq = null;
    private LinearLayout eAr = null;
    private TextView Fj = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eAt = null;
    private c fMu = null;
    private int eAv = 0;
    private int eAw = 0;
    private int mDisplaySize = 0;
    private boolean eAx = true;
    private String eAy = null;
    private boolean eAA = false;
    private boolean ekp = false;
    private final Handler mHandler = new Handler();
    private final Object fMw = new Object();
    private final View.OnClickListener fMx = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.dL().ac("motu_sdk") == 1 || PluginPackageManager.iz().bt(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eAx = false;
        } else {
            this.eAx = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(r.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fMv = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eAx) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.ekp = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.au.vg().vm(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.au.vg().vm(), this.mDisplaySize, stringExtra);
            }
            anE();
        } else {
            initUI();
            initData();
        }
        eAe = getResources().getStringArray(r.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fMs != null) {
            this.fMs.cancel();
        }
        this.mImage.setImageDrawable(null);
        aQV();
    }

    private void aQV() {
        synchronized (this.fMw) {
            if (this.eAC != null) {
                for (Map.Entry<String, ImageView> entry : this.eAC.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eAC.clear();
                this.eAC = null;
            }
            if (this.eAB != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eAB.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eAB.clear();
                this.eAB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fMs != null) {
            this.fMs.cancel();
        }
        this.fMs = new b(this, null);
        this.fMs.execute(new Object[0]);
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
        if (this.eAt != null && !this.eAt.isRecycled()) {
            this.eAt.recycle();
            this.eAt = null;
        }
        if (this.fMs != null) {
            this.fMs.cancel();
            this.fMs = null;
        }
        this.bkd.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fMu);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fMx.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.Fo);
        com.baidu.tbadk.core.util.ap.k(this.mNavigationBar, r.e.common_color_10222);
        com.baidu.tbadk.core.util.ap.c(this.Fj, r.e.cp_cont_g, 1);
        if (this.fMr.isEnabled()) {
            this.fKo.setTextColor(getResources().getColor(r.e.navi_done_text));
        } else {
            this.fKo.setTextColor(getResources().getColor(r.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.ap.b((ImageView) ((ViewGroup) this.fMq).getChildAt(0), r.g.icon_return_s, r.g.icon_return_s);
    }

    private void initUI() {
        this.Fo = findViewById(r.h.write_image_root_layout);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
        this.bkd.setVisibility(8);
        this.mImage = (ImageView) findViewById(r.h.image);
        this.mImage.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eAl = (HorizontalScrollView) findViewById(r.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.fMq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.fMr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.image_activity_save_button, (View.OnClickListener) null);
        this.fMr.setOnClickListener(new bo(this));
        this.fKo = (TextView) this.fMr.findViewById(r.h.save);
        if (TextUtils.isEmpty(this.fMv)) {
            if (this.ekp || this.requestCode != 12003) {
                this.fKo.setText(getPageContext().getString(r.l.done));
            } else {
                this.fKo.setText(getPageContext().getString(r.l.delete));
            }
        } else {
            this.fKo.setText(this.fMv);
        }
        this.eAz = (LinearLayout) findViewById(r.h.filters);
        this.eAv = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Fj = this.mNavigationBar.setTitleText(getPageContext().getString(r.l.beautify));
        this.eAr = (LinearLayout) findViewById(r.h.beautify_rotate);
        this.eAq = (LinearLayout) findViewById(r.h.rotate);
        this.eAo = (RadioButton) findViewById(r.h.beautify_btn);
        this.eAp = (RadioButton) findViewById(r.h.rotate_btn);
        this.GF = (RadioGroup) findViewById(r.h.beautify_tabs);
        bp bpVar = new bp(this);
        this.eAo.setOnCheckedChangeListener(bpVar);
        this.eAp.setOnCheckedChangeListener(bpVar);
        this.eAo.setChecked(true);
        Button button = (Button) findViewById(r.h.rotate_left);
        Button button2 = (Button) findViewById(r.h.rotate_right);
        Button button3 = (Button) findViewById(r.h.rotate_left_right);
        Button button4 = (Button) findViewById(r.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bq bqVar = new bq(this);
        button.setOnClickListener(bqVar);
        button2.setOnClickListener(bqVar);
        button3.setOnClickListener(bqVar);
        button4.setOnClickListener(bqVar);
        this.eAr.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eAx) {
            this.eAp.setPadding(0, this.eAp.getPaddingTop(), this.eAp.getPaddingRight(), this.eAp.getPaddingBottom());
            this.eAp.setChecked(true);
            this.eAl.setVisibility(8);
            this.eAo.setVisibility(8);
            this.GF.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(String str) {
        if (this.fMt != null) {
            this.fMt.cancel();
        }
        this.fMt = new a(this, null);
        this.fMt.execute(str);
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
                Bitmap X = com.baidu.tbadk.core.util.l.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    if (X != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eAx) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fMw) {
                                        WriteImageActivity.this.eAB = new HashMap();
                                        WriteImageActivity.this.eAC = new HashMap();
                                        WriteImageActivity.this.eAB.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.bkd.setVisibility(0);
            WriteImageActivity.this.fMr.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fMs = null;
            WriteImageActivity.this.bkd.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fMr.setEnabled(true);
            WriteImageActivity.this.fMs = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.bkd.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eAx) {
                    return;
                }
                WriteImageActivity.this.C(WriteImageActivity.eAe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rP(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.eAt, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eAt, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eAw));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String[] strArr) {
        if (this.eAB != null && strArr != null) {
            this.eAz.removeAllViews();
            this.eAr.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.j.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(r.h.filter_immage);
            TextView textView = (TextView) inflate.findViewById(r.h.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.j.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(r.h.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(r.h.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eJ(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                    this.eAD = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.eAz.addView(inflate2);
                synchronized (this.fMw) {
                    this.eAC.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            oQ(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eAy != null && (imageView = this.eAC.get(this.eAy)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eAv, this.eAv, this.eAv, this.eAv);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eAC != null) {
                ImageView imageView2 = this.eAC.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(r.g.bg_choose_filter);
                    imageView2.setPadding(this.eAv, this.eAv, this.eAv, this.eAv);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eAy = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eAI;
        private Boolean eAJ;
        private String mLabel;

        private a() {
            this.eAI = false;
            this.eAJ = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eAx) {
                PluginPackageManager.PluginStatus bt = PluginPackageManager.iz().bt(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bt != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bt == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(r.l.plugin_config_not_found);
                        return;
                    } else if (bt == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iz().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        cancel();
                        return;
                    } else if (bt == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), r.l.plugin_muto_not_install, new bv(this), new bw(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.bkd.setVisibility(0);
            WriteImageActivity.this.fMr.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eAt == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eAI = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eAJ = true;
            }
            if (!this.eAI.booleanValue() && !this.eAJ.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eAt == null || WriteImageActivity.this.eAt.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eAt.copy(WriteImageActivity.this.eAt.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eAI.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eAJ.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eAt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.bkd.setVisibility(8);
            WriteImageActivity.this.fMr.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.bkd.setVisibility(8);
            WriteImageActivity.this.fMr.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eAA = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eAI.booleanValue() || this.eAJ.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eAI.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eAJ.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eAt != null && !WriteImageActivity.this.eAt.isRecycled()) {
                    WriteImageActivity.this.eAt.recycle();
                }
                WriteImageActivity.this.eAt = bitmap;
            }
        }
    }

    private void anE() {
        this.fMu = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fMu, intentFilter);
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
            if (WriteImageActivity.this.fMr != null) {
                WriteImageActivity.this.fMr.setEnabled(false);
            }
        }
    }
}
