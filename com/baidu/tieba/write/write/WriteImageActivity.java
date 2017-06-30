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
    private static String[] eRF = null;
    private RadioButton eRP;
    private RadioButton eRQ;
    private LinearLayout eSa;
    private HashMap<String, Bitmap> eSc;
    private HashMap<String, ImageView> eSd;
    private View eSe;
    private View glU;
    private View glV;
    private String glZ;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView bYi = null;
    private View aWF = null;
    private HorizontalScrollView eRM = null;
    private ProgressBar mProgress = null;
    private b glW = null;
    private a glX = null;
    private RadioGroup eCT = null;
    private LinearLayout eRR = null;
    private LinearLayout eRS = null;
    private TextView bWL = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eRU = null;
    private c glY = null;
    private int eRW = 0;
    private int eRX = 0;
    private int mDisplaySize = 0;
    private boolean eRY = true;
    private String eRZ = null;
    private boolean eSb = false;
    private boolean eyC = false;
    private final Handler mHandler = new Handler();
    private final Object gma = new Object();
    private final View.OnClickListener gmb = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.eY().ad("motu_sdk") == 1 || PluginPackageManager.jw().bn(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eRY = false;
        } else {
            this.eRY = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(w.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.glZ = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eRY) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eyC = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ax.vA().vG(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ax.vA().vG(), this.mDisplaySize, stringExtra);
            }
            apx();
        } else {
            initUI();
            initData();
        }
        eRF = getResources().getStringArray(w.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.glW != null) {
            this.glW.cancel();
        }
        this.mImage.setImageDrawable(null);
        aUl();
    }

    private void aUl() {
        synchronized (this.gma) {
            if (this.eSd != null) {
                for (Map.Entry<String, ImageView> entry : this.eSd.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eSd.clear();
                this.eSd = null;
            }
            if (this.eSc != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eSc.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eSc.clear();
                this.eSc = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.glW != null) {
            this.glW.cancel();
        }
        this.glW = new b(this, null);
        this.glW.execute(new Object[0]);
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
        if (this.eRU != null && !this.eRU.isRecycled()) {
            this.eRU.recycle();
            this.eRU = null;
        }
        if (this.glW != null) {
            this.glW.cancel();
            this.glW = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.glY);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.gmb.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aWF);
        com.baidu.tbadk.core.util.as.k(this.mNavigationBar, w.e.common_color_10222);
        com.baidu.tbadk.core.util.as.c(this.bWL, w.e.cp_cont_g, 1);
        if (this.glV.isEnabled()) {
            this.bYi.setTextColor(getResources().getColor(w.e.navi_done_text));
        } else {
            this.bYi.setTextColor(getResources().getColor(w.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.as.b((ImageView) ((ViewGroup) this.glU).getChildAt(0), w.g.icon_return_s, w.g.icon_return_s);
    }

    private void initUI() {
        this.aWF = findViewById(w.h.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(w.h.image);
        this.mImage.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eRM = (HorizontalScrollView) findViewById(w.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.glU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.glV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, (View.OnClickListener) null);
        this.glV.setOnClickListener(new bq(this));
        this.bYi = (TextView) this.glV.findViewById(w.h.save);
        if (TextUtils.isEmpty(this.glZ)) {
            if (this.eyC || this.requestCode != 12003) {
                this.bYi.setText(getPageContext().getString(w.l.done));
            } else {
                this.bYi.setText(getPageContext().getString(w.l.delete));
            }
        } else {
            this.bYi.setText(this.glZ);
        }
        this.eSa = (LinearLayout) findViewById(w.h.filters);
        this.eRW = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bWL = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.beautify));
        this.eRS = (LinearLayout) findViewById(w.h.beautify_rotate);
        this.eRR = (LinearLayout) findViewById(w.h.rotate);
        this.eRP = (RadioButton) findViewById(w.h.beautify_btn);
        this.eRQ = (RadioButton) findViewById(w.h.rotate_btn);
        this.eCT = (RadioGroup) findViewById(w.h.beautify_tabs);
        br brVar = new br(this);
        this.eRP.setOnCheckedChangeListener(brVar);
        this.eRQ.setOnCheckedChangeListener(brVar);
        this.eRP.setChecked(true);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.eRS.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eRY) {
            this.eRQ.setPadding(0, this.eRQ.getPaddingTop(), this.eRQ.getPaddingRight(), this.eRQ.getPaddingBottom());
            this.eRQ.setChecked(true);
            this.eRM.setVisibility(8);
            this.eRP.setVisibility(8);
            this.eCT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA(String str) {
        if (this.glX != null) {
            this.glX.cancel();
        }
        this.glX = new a(this, null);
        this.glX.execute(str);
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
                Bitmap V = com.baidu.tbadk.core.util.n.V(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && V != null && !V.isRecycled()) {
                        V.recycle();
                        return null;
                    }
                    if (V != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eRY) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(V, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(V)) {
                                    V = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(V, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.gma) {
                                        WriteImageActivity.this.eSc = new HashMap();
                                        WriteImageActivity.this.eSd = new HashMap();
                                        WriteImageActivity.this.eSc.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                                    }
                                    return V;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return V;
                } catch (Exception e) {
                    bitmap = V;
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
            WriteImageActivity.this.glV.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.glW = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.glV.setEnabled(true);
            WriteImageActivity.this.glW = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eRY) {
                    return;
                }
                WriteImageActivity.this.A(WriteImageActivity.eRF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sB(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.eRU, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eRU, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eRX));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.eSc != null && strArr != null) {
            this.eSa.removeAllViews();
            this.eRS.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eV(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.eSe = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.eSa.addView(inflate2);
                synchronized (this.gma) {
                    this.eSd.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            pl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eRZ != null && (imageView = this.eSd.get(this.eRZ)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eRW, this.eRW, this.eRW, this.eRW);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eSd != null) {
                ImageView imageView2 = this.eSd.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(w.g.bg_choose_filter);
                    imageView2.setPadding(this.eRW, this.eRW, this.eRW, this.eRW);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eRZ = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eSj;
        private Boolean eSk;
        private String mLabel;

        private a() {
            this.eSj = false;
            this.eSk = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eRY) {
                PluginPackageManager.PluginStatus bn = PluginPackageManager.jw().bn(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bn != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bn == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(w.l.plugin_config_not_found);
                        return;
                    } else if (bn == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jw().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bn == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), w.l.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.glV.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eRU == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eSj = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eSk = true;
            }
            if (!this.eSj.booleanValue() && !this.eSk.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eRU == null || WriteImageActivity.this.eRU.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eRU.copy(WriteImageActivity.this.eRU.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eSj.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eSk.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eRU != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.glV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.glV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eSb = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eSj.booleanValue() || this.eSk.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eSj.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eSk.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eRU != null && !WriteImageActivity.this.eRU.isRecycled()) {
                    WriteImageActivity.this.eRU.recycle();
                }
                WriteImageActivity.this.eRU = bitmap;
            }
        }
    }

    private void apx() {
        this.glY = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.glY, intentFilter);
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
            if (WriteImageActivity.this.glV != null) {
                WriteImageActivity.this.glV.setEnabled(false);
            }
        }
    }
}
