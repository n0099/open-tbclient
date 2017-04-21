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
    private static String[] eDQ = null;
    private RadioButton eEa;
    private RadioButton eEb;
    private LinearLayout eEl;
    private HashMap<String, Bitmap> eEn;
    private HashMap<String, ImageView> eEo;
    private View eEp;
    private View fUR;
    private View fUS;
    private String fUW;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView fSN = null;
    private View aXo = null;
    private HorizontalScrollView eDX = null;
    private ProgressBar mProgress = null;
    private b fUT = null;
    private a fUU = null;
    private RadioGroup esm = null;
    private LinearLayout eEc = null;
    private LinearLayout eEd = null;
    private TextView bKX = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eEf = null;
    private c fUV = null;
    private int eEh = 0;
    private int eEi = 0;
    private int mDisplaySize = 0;
    private boolean eEj = true;
    private String eEk = null;
    private boolean eEm = false;
    private boolean enL = false;
    private final Handler mHandler = new Handler();
    private final Object fUX = new Object();
    private final View.OnClickListener fUY = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.eZ().Y("motu_sdk") == 1 || PluginPackageManager.jy().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eEj = false;
        } else {
            this.eEj = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(w.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fUW = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eEj) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.enL = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.av.wa().wg(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.av.wa().wg(), this.mDisplaySize, stringExtra);
            }
            anT();
        } else {
            initUI();
            initData();
        }
        eDQ = getResources().getStringArray(w.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fUT != null) {
            this.fUT.cancel();
        }
        this.mImage.setImageDrawable(null);
        aRI();
    }

    private void aRI() {
        synchronized (this.fUX) {
            if (this.eEo != null) {
                for (Map.Entry<String, ImageView> entry : this.eEo.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eEo.clear();
                this.eEo = null;
            }
            if (this.eEn != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eEn.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eEn.clear();
                this.eEn = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fUT != null) {
            this.fUT.cancel();
        }
        this.fUT = new b(this, null);
        this.fUT.execute(new Object[0]);
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
        if (this.eEf != null && !this.eEf.isRecycled()) {
            this.eEf.recycle();
            this.eEf = null;
        }
        if (this.fUT != null) {
            this.fUT.cancel();
            this.fUT = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fUV);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fUY.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.aXo);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.bKX, w.e.cp_cont_g, 1);
        if (this.fUS.isEnabled()) {
            this.fSN.setTextColor(getResources().getColor(w.e.navi_done_text));
        } else {
            this.fSN.setTextColor(getResources().getColor(w.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.aq.b((ImageView) ((ViewGroup) this.fUR).getChildAt(0), w.g.icon_return_s, w.g.icon_return_s);
    }

    private void initUI() {
        this.aXo = findViewById(w.h.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(w.h.image);
        this.mImage.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eDX = (HorizontalScrollView) findViewById(w.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.fUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.fUS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, (View.OnClickListener) null);
        this.fUS.setOnClickListener(new bo(this));
        this.fSN = (TextView) this.fUS.findViewById(w.h.save);
        if (TextUtils.isEmpty(this.fUW)) {
            if (this.enL || this.requestCode != 12003) {
                this.fSN.setText(getPageContext().getString(w.l.done));
            } else {
                this.fSN.setText(getPageContext().getString(w.l.delete));
            }
        } else {
            this.fSN.setText(this.fUW);
        }
        this.eEl = (LinearLayout) findViewById(w.h.filters);
        this.eEh = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bKX = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.beautify));
        this.eEd = (LinearLayout) findViewById(w.h.beautify_rotate);
        this.eEc = (LinearLayout) findViewById(w.h.rotate);
        this.eEa = (RadioButton) findViewById(w.h.beautify_btn);
        this.eEb = (RadioButton) findViewById(w.h.rotate_btn);
        this.esm = (RadioGroup) findViewById(w.h.beautify_tabs);
        bp bpVar = new bp(this);
        this.eEa.setOnCheckedChangeListener(bpVar);
        this.eEb.setOnCheckedChangeListener(bpVar);
        this.eEa.setChecked(true);
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
        this.eEd.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eEj) {
            this.eEb.setPadding(0, this.eEb.getPaddingTop(), this.eEb.getPaddingRight(), this.eEb.getPaddingBottom());
            this.eEb.setChecked(true);
            this.eDX.setVisibility(8);
            this.eEa.setVisibility(8);
            this.esm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(String str) {
        if (this.fUU != null) {
            this.fUU.cancel();
        }
        this.fUU = new a(this, null);
        this.fUU.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eEj) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(W, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(W)) {
                                    W = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(W, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fUX) {
                                        WriteImageActivity.this.eEn = new HashMap();
                                        WriteImageActivity.this.eEo = new HashMap();
                                        WriteImageActivity.this.eEn.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.fUS.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fUT = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fUS.setEnabled(true);
            WriteImageActivity.this.fUT = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eEj) {
                    return;
                }
                WriteImageActivity.this.A(WriteImageActivity.eDQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rr(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.eEf, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eEf, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eEi));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.eEn != null && strArr != null) {
            this.eEl.removeAllViews();
            this.eEd.setVisibility(0);
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
                    this.eEp = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.eEl.addView(inflate2);
                synchronized (this.fUX) {
                    this.eEo.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            od(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eEk != null && (imageView = this.eEo.get(this.eEk)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eEh, this.eEh, this.eEh, this.eEh);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eEo != null) {
                ImageView imageView2 = this.eEo.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(w.g.bg_choose_filter);
                    imageView2.setPadding(this.eEh, this.eEh, this.eEh, this.eEh);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eEk = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eEu;
        private Boolean eEv;
        private String mLabel;

        private a() {
            this.eEu = false;
            this.eEv = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eEj) {
                PluginPackageManager.PluginStatus bi = PluginPackageManager.jy().bi(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bi != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bi == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(w.l.plugin_config_not_found);
                        return;
                    } else if (bi == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jy().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
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
            WriteImageActivity.this.fUS.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eEf == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eEu = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eEv = true;
            }
            if (!this.eEu.booleanValue() && !this.eEv.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eEf == null || WriteImageActivity.this.eEf.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eEf.copy(WriteImageActivity.this.eEf.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eEu.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eEv.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eEf != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.fUS.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.fUS.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eEm = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eEu.booleanValue() || this.eEv.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eEu.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eEv.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eEf != null && !WriteImageActivity.this.eEf.isRecycled()) {
                    WriteImageActivity.this.eEf.recycle();
                }
                WriteImageActivity.this.eEf = bitmap;
            }
        }
    }

    private void anT() {
        this.fUV = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fUV, intentFilter);
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
            if (WriteImageActivity.this.fUS != null) {
                WriteImageActivity.this.fUS.setEnabled(false);
            }
        }
    }
}
