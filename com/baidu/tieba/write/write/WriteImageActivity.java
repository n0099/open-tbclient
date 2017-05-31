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
    private static String[] eHR = null;
    private RadioButton eIb;
    private RadioButton eIc;
    private LinearLayout eIm;
    private HashMap<String, Bitmap> eIo;
    private HashMap<String, ImageView> eIp;
    private View eIq;
    private View gaW;
    private View gaX;
    private String gbb;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView fYN = null;
    private View aVm = null;
    private HorizontalScrollView eHY = null;
    private ProgressBar mProgress = null;
    private b gaY = null;
    private a gaZ = null;
    private RadioGroup etJ = null;
    private LinearLayout eId = null;
    private LinearLayout eIe = null;
    private TextView bPO = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eIg = null;
    private c gba = null;
    private int eIi = 0;
    private int eIj = 0;
    private int mDisplaySize = 0;
    private boolean eIk = true;
    private String eIl = null;
    private boolean eIn = false;
    private boolean eps = false;
    private final Handler mHandler = new Handler();
    private final Object gbc = new Object();
    private final View.OnClickListener gbd = new bp(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.eZ().Y("motu_sdk") == 1 || PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eIk = false;
        } else {
            this.eIk = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(w.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.gbb = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eIk) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eps = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.av.vl().vr(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.av.vl().vr(), this.mDisplaySize, stringExtra);
            }
            alM();
        } else {
            initUI();
            initData();
        }
        eHR = getResources().getStringArray(w.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gaY != null) {
            this.gaY.cancel();
        }
        this.mImage.setImageDrawable(null);
        aQl();
    }

    private void aQl() {
        synchronized (this.gbc) {
            if (this.eIp != null) {
                for (Map.Entry<String, ImageView> entry : this.eIp.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eIp.clear();
                this.eIp = null;
            }
            if (this.eIo != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eIo.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eIo.clear();
                this.eIo = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gaY != null) {
            this.gaY.cancel();
        }
        this.gaY = new b(this, null);
        this.gaY.execute(new Object[0]);
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
        if (this.eIg != null && !this.eIg.isRecycled()) {
            this.eIg.recycle();
            this.eIg = null;
        }
        if (this.gaY != null) {
            this.gaY.cancel();
            this.gaY = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gba);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.gbd.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aVm);
        com.baidu.tbadk.core.util.aq.k(this.mNavigationBar, w.e.common_color_10222);
        com.baidu.tbadk.core.util.aq.c(this.bPO, w.e.cp_cont_g, 1);
        if (this.gaX.isEnabled()) {
            this.fYN.setTextColor(getResources().getColor(w.e.navi_done_text));
        } else {
            this.fYN.setTextColor(getResources().getColor(w.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.aq.b((ImageView) ((ViewGroup) this.gaW).getChildAt(0), w.g.icon_return_s, w.g.icon_return_s);
    }

    private void initUI() {
        this.aVm = findViewById(w.h.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(w.h.image);
        this.mImage.setOnClickListener(new bq(this));
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.eHY = (HorizontalScrollView) findViewById(w.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.gaW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new br(this));
        this.gaX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.image_activity_save_button, (View.OnClickListener) null);
        this.gaX.setOnClickListener(new bs(this));
        this.fYN = (TextView) this.gaX.findViewById(w.h.save);
        if (TextUtils.isEmpty(this.gbb)) {
            if (this.eps || this.requestCode != 12003) {
                this.fYN.setText(getPageContext().getString(w.l.done));
            } else {
                this.fYN.setText(getPageContext().getString(w.l.delete));
            }
        } else {
            this.fYN.setText(this.gbb);
        }
        this.eIm = (LinearLayout) findViewById(w.h.filters);
        this.eIi = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bPO = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.beautify));
        this.eIe = (LinearLayout) findViewById(w.h.beautify_rotate);
        this.eId = (LinearLayout) findViewById(w.h.rotate);
        this.eIb = (RadioButton) findViewById(w.h.beautify_btn);
        this.eIc = (RadioButton) findViewById(w.h.rotate_btn);
        this.etJ = (RadioGroup) findViewById(w.h.beautify_tabs);
        bt btVar = new bt(this);
        this.eIb.setOnCheckedChangeListener(btVar);
        this.eIc.setOnCheckedChangeListener(btVar);
        this.eIb.setChecked(true);
        Button button = (Button) findViewById(w.h.rotate_left);
        Button button2 = (Button) findViewById(w.h.rotate_right);
        Button button3 = (Button) findViewById(w.h.rotate_left_right);
        Button button4 = (Button) findViewById(w.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bu buVar = new bu(this);
        button.setOnClickListener(buVar);
        button2.setOnClickListener(buVar);
        button3.setOnClickListener(buVar);
        button4.setOnClickListener(buVar);
        this.eIe.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eIk) {
            this.eIc.setPadding(0, this.eIc.getPaddingTop(), this.eIc.getPaddingRight(), this.eIc.getPaddingBottom());
            this.eIc.setChecked(true);
            this.eHY.setVisibility(8);
            this.eIb.setVisibility(8);
            this.etJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(String str) {
        if (this.gaZ != null) {
            this.gaZ.cancel();
        }
        this.gaZ = new a(this, null);
        this.gaZ.execute(str);
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
                Bitmap V = com.baidu.tbadk.core.util.l.V(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && V != null && !V.isRecycled()) {
                        V.recycle();
                        return null;
                    }
                    if (V != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eIk) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(V, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(V)) {
                                    V = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(V, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.gbc) {
                                        WriteImageActivity.this.eIo = new HashMap();
                                        WriteImageActivity.this.eIp = new HashMap();
                                        WriteImageActivity.this.eIo.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.gaX.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.gaY = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.gaX.setEnabled(true);
            WriteImageActivity.this.gaY = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eIk) {
                    return;
                }
                WriteImageActivity.this.A(WriteImageActivity.eHR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rB(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.eIg, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eIg, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eIj));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.eIo != null && strArr != null) {
            this.eIm.removeAllViews();
            this.eIe.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eB(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                    this.eIq = imageView2;
                } else {
                    imageView2.setOnClickListener(new bw(this, substring, i2));
                }
                this.eIm.addView(inflate2);
                synchronized (this.gbc) {
                    this.eIp.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            oq(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eIl != null && (imageView = this.eIp.get(this.eIl)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eIi, this.eIi, this.eIi, this.eIi);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eIp != null) {
                ImageView imageView2 = this.eIp.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(w.g.bg_choose_filter);
                    imageView2.setPadding(this.eIi, this.eIi, this.eIi, this.eIi);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eIl = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eIv;
        private Boolean eIw;
        private String mLabel;

        private a() {
            this.eIv = false;
            this.eIw = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eIk) {
                PluginPackageManager.PluginStatus bi = PluginPackageManager.jx().bi(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bi != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bi == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        WriteImageActivity.this.showToast(w.l.plugin_config_not_found);
                        return;
                    } else if (bi == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jx().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new by(this), 500L);
                        cancel();
                        return;
                    } else if (bi == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), w.l.plugin_muto_not_install, new bz(this), new ca(this));
                        WriteImageActivity.this.mHandler.postDelayed(new cb(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.gaX.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eIg == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eIv = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eIw = true;
            }
            if (!this.eIv.booleanValue() && !this.eIw.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eIg == null || WriteImageActivity.this.eIg.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eIg.copy(WriteImageActivity.this.eIg.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eIv.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eIw.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eIg != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.gaX.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.gaX.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eIn = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eIv.booleanValue() || this.eIw.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eIv.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eIw.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eIg != null && !WriteImageActivity.this.eIg.isRecycled()) {
                    WriteImageActivity.this.eIg.recycle();
                }
                WriteImageActivity.this.eIg = bitmap;
            }
        }
    }

    private void alM() {
        this.gba = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gba, intentFilter);
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
            if (WriteImageActivity.this.gaX != null) {
                WriteImageActivity.this.gaX.setEnabled(false);
            }
        }
    }
}
