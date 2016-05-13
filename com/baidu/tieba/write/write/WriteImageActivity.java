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
    private static String[] duz = null;
    private RadioButton duJ;
    private RadioButton duK;
    private LinearLayout duU;
    private HashMap<String, Bitmap> duW;
    private HashMap<String, ImageView> duX;
    private View duY;
    private View fel;
    private View fem;
    private String feq;
    private int requestCode;
    private ImageView aIH = null;
    private Bitmap mBitmap = null;
    private TextView fcc = null;
    private View Dn = null;
    private HorizontalScrollView duG = null;
    private ProgressBar bDI = null;
    private b fen = null;
    private a feo = null;
    private RadioGroup EA = null;
    private LinearLayout duL = null;
    private LinearLayout duM = null;
    private TextView Di = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap duO = null;
    private c fep = null;
    private int duQ = 0;
    private int duR = 0;
    private int mDisplaySize = 0;
    private boolean duS = true;
    private String duT = null;
    private boolean duV = false;
    private boolean dlk = false;
    private final Handler mHandler = new Handler();
    private final Object fer = new Object();
    private final View.OnClickListener fes = new br(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.cS().Z("motu_sdk") == 1 || PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.duS = false;
        } else {
            this.duS = true;
        }
        TbadkCoreApplication.m11getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(t.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.feq = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.duS) {
            TbadkCoreApplication.m11getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.dlk = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            nq();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.az.ug().um(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.az.ug().um(), this.mDisplaySize, stringExtra);
            }
            abM();
        } else {
            nq();
            initData();
        }
        duz = getResources().getStringArray(t.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fen != null) {
            this.fen.cancel();
        }
        this.aIH.setImageDrawable(null);
        aBt();
    }

    private void aBt() {
        synchronized (this.fer) {
            if (this.duX != null) {
                for (Map.Entry<String, ImageView> entry : this.duX.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.duX.clear();
                this.duX = null;
            }
            if (this.duW != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.duW.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.duW.clear();
                this.duW = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fen != null) {
            this.fen.cancel();
        }
        this.fen = new b(this, null);
        this.fen.execute(new Object[0]);
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
        if (this.duO != null && !this.duO.isRecycled()) {
            this.duO.recycle();
            this.duO = null;
        }
        if (this.fen != null) {
            this.fen.cancel();
            this.fen = null;
        }
        this.bDI.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fep);
        }
        TbadkCoreApplication.m11getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fes.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.Dn);
        com.baidu.tbadk.core.util.at.l(this.mNavigationBar, t.d.alpha80_black);
        com.baidu.tbadk.core.util.at.c(this.Di, t.d.cp_cont_g, 1);
        if (this.fem.isEnabled()) {
            this.fcc.setTextColor(getResources().getColor(t.d.navi_done_text));
        } else {
            this.fcc.setTextColor(getResources().getColor(t.d.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.at.a((ImageView) ((ViewGroup) this.fel).getChildAt(0), t.f.icon_return_s, t.f.icon_return_s);
    }

    private void nq() {
        this.Dn = findViewById(t.g.write_image_root_layout);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
        this.bDI.setVisibility(8);
        this.aIH = (ImageView) findViewById(t.g.image);
        this.aIH.setOnClickListener(new bs(this));
        if (this.mBitmap != null) {
            this.aIH.setImageBitmap(this.mBitmap);
        }
        this.duG = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.fel = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bt(this));
        this.fem = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.fem.setOnClickListener(new bu(this));
        this.fcc = (TextView) this.fem.findViewById(t.g.save);
        if (TextUtils.isEmpty(this.feq)) {
            if (this.dlk || this.requestCode != 12003) {
                this.fcc.setText(getPageContext().getString(t.j.done));
            } else {
                this.fcc.setText(getPageContext().getString(t.j.delete));
            }
        } else {
            this.fcc.setText(this.feq);
        }
        this.duU = (LinearLayout) findViewById(t.g.filters);
        this.duQ = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Di = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        this.duM = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.duL = (LinearLayout) findViewById(t.g.rotate);
        this.duJ = (RadioButton) findViewById(t.g.beautify_btn);
        this.duK = (RadioButton) findViewById(t.g.rotate_btn);
        this.EA = (RadioGroup) findViewById(t.g.beautify_tabs);
        bv bvVar = new bv(this);
        this.duJ.setOnCheckedChangeListener(bvVar);
        this.duK.setOnCheckedChangeListener(bvVar);
        this.duJ.setChecked(true);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bw bwVar = new bw(this);
        button.setOnClickListener(bwVar);
        button2.setOnClickListener(bwVar);
        button3.setOnClickListener(bwVar);
        button4.setOnClickListener(bwVar);
        this.duM.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.duS) {
            this.duK.setPadding(0, this.duK.getPaddingTop(), this.duK.getPaddingRight(), this.duK.getPaddingBottom());
            this.duK.setChecked(true);
            this.duG.setVisibility(8);
            this.duJ.setVisibility(8);
            this.EA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(String str) {
        if (this.feo != null) {
            this.feo.cancel();
        }
        this.feo = new a(this, null);
        this.feo.execute(str);
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
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap Y = com.baidu.tbadk.core.util.m.Y(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && Y != null && !Y.isRecycled()) {
                        Y.recycle();
                        return null;
                    }
                    if (Y != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.duS) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(Y)) {
                                    Y = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(Y, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fer) {
                                        WriteImageActivity.this.duW = new HashMap();
                                        WriteImageActivity.this.duX = new HashMap();
                                        WriteImageActivity.this.duW.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                                    }
                                    return Y;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return Y;
                } catch (Exception e) {
                    bitmap = Y;
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
            WriteImageActivity.this.bDI.setVisibility(0);
            WriteImageActivity.this.fem.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fen = null;
            WriteImageActivity.this.bDI.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fem.setEnabled(true);
            WriteImageActivity.this.fen = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.bDI.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aIH.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.duS) {
                    return;
                }
                WriteImageActivity.this.E(WriteImageActivity.duz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pt(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.duO, 90);
            this.aIH.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.duO, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.duR));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.duW != null && strArr != null) {
            this.duU.removeAllViews();
            this.duM.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eG(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bx(this, substring, i2));
                    this.duY = imageView2;
                } else {
                    imageView2.setOnClickListener(new by(this, substring, i2));
                }
                this.duU.addView(inflate2);
                synchronized (this.fer) {
                    this.duX.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            mo(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.duT != null && (imageView = this.duX.get(this.duT)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.duQ, this.duQ, this.duQ, this.duQ);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.duX != null) {
                ImageView imageView2 = this.duX.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(t.f.bg_choose_filter);
                    imageView2.setPadding(this.duQ, this.duQ, this.duQ, this.duQ);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.duT = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean dvd;
        private Boolean dve;
        private String mLabel;

        private a() {
            this.dvd = false;
            this.dve = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.duS) {
                PluginPackageManager.PluginStatus bs = PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bs != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bs == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        WriteImageActivity.this.showToast(t.j.plugin_config_not_found);
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.hF().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new ca(this), 500L);
                        cancel();
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), t.j.plugin_muto_not_install, new cb(this), new cc(this));
                        WriteImageActivity.this.mHandler.postDelayed(new cd(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.bDI.setVisibility(0);
            WriteImageActivity.this.fem.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.duO == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.dvd = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.dve = true;
            }
            if (!this.dvd.booleanValue() && !this.dve.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.duO == null || WriteImageActivity.this.duO.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.duO.copy(WriteImageActivity.this.duO.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.dvd.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.dve.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.duO != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.bDI.setVisibility(8);
            WriteImageActivity.this.fem.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.bDI.setVisibility(8);
            WriteImageActivity.this.fem.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.duV = true;
                WriteImageActivity.this.aIH.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.dvd.booleanValue() || this.dve.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.dvd.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.dve.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.duO != null && !WriteImageActivity.this.duO.isRecycled()) {
                    WriteImageActivity.this.duO.recycle();
                }
                WriteImageActivity.this.duO = bitmap;
            }
        }
    }

    private void abM() {
        this.fep = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fep, intentFilter);
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
            if (WriteImageActivity.this.fem != null) {
                WriteImageActivity.this.fem.setEnabled(false);
            }
        }
    }
}
