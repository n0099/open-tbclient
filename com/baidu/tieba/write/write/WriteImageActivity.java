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
    private static String[] eqh = null;
    private LinearLayout eqC;
    private HashMap<String, Bitmap> eqE;
    private HashMap<String, ImageView> eqF;
    private View eqG;
    private RadioButton eqr;
    private RadioButton eqs;
    private View fDV;
    private View fDW;
    private String fEa;
    private int requestCode;
    private ImageView aUt = null;
    private Bitmap mBitmap = null;
    private TextView fBT = null;
    private View Ge = null;
    private HorizontalScrollView eqo = null;
    private ProgressBar ban = null;
    private b fDX = null;
    private a fDY = null;
    private RadioGroup Hv = null;
    private LinearLayout eqt = null;
    private LinearLayout equ = null;
    private TextView FZ = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap eqw = null;
    private c fDZ = null;
    private int eqy = 0;
    private int eqz = 0;
    private int mDisplaySize = 0;
    private boolean eqA = true;
    private String eqB = null;
    private boolean eqD = false;
    private boolean eby = false;
    private final Handler mHandler = new Handler();
    private final Object fEb = new Object();
    private final View.OnClickListener fEc = new bm(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.dN().ac("motu_sdk") == 1 || PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.eqA = false;
        } else {
            this.eqA = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(r.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fEa = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.eqA) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eby = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.aw.vm().vs(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.aw.vm().vs(), this.mDisplaySize, stringExtra);
            }
            amv();
        } else {
            initUI();
            initData();
        }
        eqh = getResources().getStringArray(r.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fDX != null) {
            this.fDX.cancel();
        }
        this.aUt.setImageDrawable(null);
        aOV();
    }

    private void aOV() {
        synchronized (this.fEb) {
            if (this.eqF != null) {
                for (Map.Entry<String, ImageView> entry : this.eqF.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.eqF.clear();
                this.eqF = null;
            }
            if (this.eqE != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.eqE.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.eqE.clear();
                this.eqE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fDX != null) {
            this.fDX.cancel();
        }
        this.fDX = new b(this, null);
        this.fDX.execute(new Object[0]);
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
        if (this.eqw != null && !this.eqw.isRecycled()) {
            this.eqw.recycle();
            this.eqw = null;
        }
        if (this.fDX != null) {
            this.fDX.cancel();
            this.fDX = null;
        }
        this.ban.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fDZ);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fEc.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.Ge);
        com.baidu.tbadk.core.util.ar.l(this.mNavigationBar, r.d.common_color_10222);
        com.baidu.tbadk.core.util.ar.c(this.FZ, r.d.cp_cont_g, 1);
        if (this.fDW.isEnabled()) {
            this.fBT.setTextColor(getResources().getColor(r.d.navi_done_text));
        } else {
            this.fBT.setTextColor(getResources().getColor(r.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.ar.b((ImageView) ((ViewGroup) this.fDV).getChildAt(0), r.f.icon_return_s, r.f.icon_return_s);
    }

    private void initUI() {
        this.Ge = findViewById(r.g.write_image_root_layout);
        this.ban = (ProgressBar) findViewById(r.g.progress);
        this.ban.setVisibility(8);
        this.aUt = (ImageView) findViewById(r.g.image);
        this.aUt.setOnClickListener(new bn(this));
        if (this.mBitmap != null) {
            this.aUt.setImageBitmap(this.mBitmap);
        }
        this.eqo = (HorizontalScrollView) findViewById(r.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.fDV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bo(this));
        this.fDW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.image_activity_save_button, (View.OnClickListener) null);
        this.fDW.setOnClickListener(new bp(this));
        this.fBT = (TextView) this.fDW.findViewById(r.g.save);
        if (TextUtils.isEmpty(this.fEa)) {
            if (this.eby || this.requestCode != 12003) {
                this.fBT.setText(getPageContext().getString(r.j.done));
            } else {
                this.fBT.setText(getPageContext().getString(r.j.delete));
            }
        } else {
            this.fBT.setText(this.fEa);
        }
        this.eqC = (LinearLayout) findViewById(r.g.filters);
        this.eqy = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.FZ = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.beautify));
        this.equ = (LinearLayout) findViewById(r.g.beautify_rotate);
        this.eqt = (LinearLayout) findViewById(r.g.rotate);
        this.eqr = (RadioButton) findViewById(r.g.beautify_btn);
        this.eqs = (RadioButton) findViewById(r.g.rotate_btn);
        this.Hv = (RadioGroup) findViewById(r.g.beautify_tabs);
        bq bqVar = new bq(this);
        this.eqr.setOnCheckedChangeListener(bqVar);
        this.eqs.setOnCheckedChangeListener(bqVar);
        this.eqr.setChecked(true);
        Button button = (Button) findViewById(r.g.rotate_left);
        Button button2 = (Button) findViewById(r.g.rotate_right);
        Button button3 = (Button) findViewById(r.g.rotate_left_right);
        Button button4 = (Button) findViewById(r.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        br brVar = new br(this);
        button.setOnClickListener(brVar);
        button2.setOnClickListener(brVar);
        button3.setOnClickListener(brVar);
        button4.setOnClickListener(brVar);
        this.equ.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.eqA) {
            this.eqs.setPadding(0, this.eqs.getPaddingTop(), this.eqs.getPaddingRight(), this.eqs.getPaddingBottom());
            this.eqs.setChecked(true);
            this.eqo.setVisibility(8);
            this.eqr.setVisibility(8);
            this.Hv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(String str) {
        if (this.fDY != null) {
            this.fDY.cancel();
        }
        this.fDY = new a(this, null);
        this.fDY.execute(str);
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
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.eqA) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fEb) {
                                        WriteImageActivity.this.eqE = new HashMap();
                                        WriteImageActivity.this.eqF = new HashMap();
                                        WriteImageActivity.this.eqE.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.ban.setVisibility(0);
            WriteImageActivity.this.fDW.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fDX = null;
            WriteImageActivity.this.ban.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fDW.setEnabled(true);
            WriteImageActivity.this.fDX = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.ban.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aUt.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.eqA) {
                    return;
                }
                WriteImageActivity.this.D(WriteImageActivity.eqh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rw(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.eqw, 90);
            this.aUt.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.eqw, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.eqz));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        if (this.eqE != null && strArr != null) {
            this.eqC.removeAllViews();
            this.equ.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eM(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                    this.eqG = imageView2;
                } else {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                }
                this.eqC.addView(inflate2);
                synchronized (this.fEb) {
                    this.eqF.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            oy(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oy(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.eqB != null && (imageView = this.eqF.get(this.eqB)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.eqy, this.eqy, this.eqy, this.eqy);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.eqF != null) {
                ImageView imageView2 = this.eqF.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(r.f.bg_choose_filter);
                    imageView2.setPadding(this.eqy, this.eqy, this.eqy, this.eqy);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.eqB = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean eqL;
        private Boolean eqM;
        private String mLabel;

        private a() {
            this.eqL = false;
            this.eqM = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.eqA) {
                PluginPackageManager.PluginStatus bu = PluginPackageManager.iB().bu(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bu != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bu == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        WriteImageActivity.this.showToast(r.j.plugin_config_not_found);
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iB().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        cancel();
                        return;
                    } else if (bu == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), r.j.plugin_muto_not_install, new bw(this), new bx(this));
                        WriteImageActivity.this.mHandler.postDelayed(new by(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.ban.setVisibility(0);
            WriteImageActivity.this.fDW.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.eqw == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.eqL = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.eqM = true;
            }
            if (!this.eqL.booleanValue() && !this.eqM.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.eqw == null || WriteImageActivity.this.eqw.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.eqw.copy(WriteImageActivity.this.eqw.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.eqL.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.eqM.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.eqw != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.ban.setVisibility(8);
            WriteImageActivity.this.fDW.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.ban.setVisibility(8);
            WriteImageActivity.this.fDW.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.eqD = true;
                WriteImageActivity.this.aUt.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.eqL.booleanValue() || this.eqM.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.eqL.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.eqM.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.eqw != null && !WriteImageActivity.this.eqw.isRecycled()) {
                    WriteImageActivity.this.eqw.recycle();
                }
                WriteImageActivity.this.eqw = bitmap;
            }
        }
    }

    private void amv() {
        this.fDZ = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fDZ, intentFilter);
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
            if (WriteImageActivity.this.fDW != null) {
                WriteImageActivity.this.fDW.setEnabled(false);
            }
        }
    }
}
