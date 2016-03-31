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
    private static String[] dre = null;
    private HashMap<String, Bitmap> drB;
    private HashMap<String, ImageView> drC;
    private View drD;
    private RadioButton dro;
    private RadioButton drp;
    private LinearLayout drz;
    private View eNm;
    private View eNn;
    private String eNr;
    private int requestCode;
    private ImageView aMx = null;
    private Bitmap mBitmap = null;
    private TextView eLp = null;
    private View MW = null;
    private HorizontalScrollView drl = null;
    private ProgressBar aQj = null;
    private b eNo = null;
    private a eNp = null;
    private RadioGroup Ok = null;
    private LinearLayout drq = null;
    private LinearLayout drr = null;
    private TextView MR = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap drt = null;
    private c eNq = null;
    private int drv = 0;
    private int drw = 0;
    private int mDisplaySize = 0;
    private boolean drx = true;
    private String dry = null;
    private boolean drA = false;
    private boolean diQ = false;
    private final Handler mHandler = new Handler();
    private final Object eNs = new Object();
    private final View.OnClickListener eNt = new bo(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gE().ai("motu_sdk") == 1 || PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.drx = false;
        } else {
            this.drx = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(t.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.eNr = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.drx) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.diQ = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            pU();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.az.wz().wF(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.az.wz().wF(), this.mDisplaySize, stringExtra);
            }
            KL();
        } else {
            pU();
            initData();
        }
        dre = getResources().getStringArray(t.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.eNo != null) {
            this.eNo.cancel();
        }
        this.aMx.setImageDrawable(null);
        aAT();
    }

    private void aAT() {
        synchronized (this.eNs) {
            if (this.drC != null) {
                for (Map.Entry<String, ImageView> entry : this.drC.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.drC.clear();
                this.drC = null;
            }
            if (this.drB != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.drB.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.drB.clear();
                this.drB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.eNo != null) {
            this.eNo.cancel();
        }
        this.eNo = new b(this, null);
        this.eNo.execute(new Object[0]);
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
        if (this.drt != null && !this.drt.isRecycled()) {
            this.drt.recycle();
            this.drt = null;
        }
        if (this.eNo != null) {
            this.eNo.cancel();
            this.eNo = null;
        }
        this.aQj.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.eNq);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.eNt.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.MW);
        com.baidu.tbadk.core.util.at.l(this.mNavigationBar, t.d.alpha80_black);
        getLayoutMode().x(this.eNm);
        getLayoutMode().x(this.MR);
        if (this.eNn.isEnabled()) {
            this.eLp.setTextColor(getResources().getColor(t.d.navi_done_text));
        } else {
            this.eLp.setTextColor(getResources().getColor(t.d.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void pU() {
        this.MW = findViewById(t.g.write_image_root_layout);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        this.aQj.setVisibility(8);
        this.aMx = (ImageView) findViewById(t.g.image);
        this.aMx.setOnClickListener(new bp(this));
        if (this.mBitmap != null) {
            this.aMx.setImageBitmap(this.mBitmap);
        }
        this.drl = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.eNm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bq(this));
        this.eNn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.eNn.setOnClickListener(new br(this));
        this.eLp = (TextView) this.eNn.findViewById(t.g.save);
        if (TextUtils.isEmpty(this.eNr)) {
            if (this.diQ || this.requestCode != 12003) {
                this.eLp.setText(getPageContext().getString(t.j.done));
            } else {
                this.eLp.setText(getPageContext().getString(t.j.delete));
            }
        } else {
            this.eLp.setText(this.eNr);
        }
        this.drz = (LinearLayout) findViewById(t.g.filters);
        this.drv = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.MR = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        this.drr = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.drq = (LinearLayout) findViewById(t.g.rotate);
        this.dro = (RadioButton) findViewById(t.g.beautify_btn);
        this.drp = (RadioButton) findViewById(t.g.rotate_btn);
        this.Ok = (RadioGroup) findViewById(t.g.beautify_tabs);
        bs bsVar = new bs(this);
        this.dro.setOnCheckedChangeListener(bsVar);
        this.drp.setOnCheckedChangeListener(bsVar);
        this.dro.setChecked(true);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bt btVar = new bt(this);
        button.setOnClickListener(btVar);
        button2.setOnClickListener(btVar);
        button3.setOnClickListener(btVar);
        button4.setOnClickListener(btVar);
        this.drr.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.drx) {
            this.drp.setPadding(0, this.drp.getPaddingTop(), this.drp.getPaddingRight(), this.drp.getPaddingBottom());
            this.drp.setChecked(true);
            this.drl.setVisibility(8);
            this.dro.setVisibility(8);
            this.Ok.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(String str) {
        if (this.eNp != null) {
            this.eNp.cancel();
        }
        this.eNp = new a(this, null);
        this.eNp.execute(str);
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
                Bitmap Y = com.baidu.tbadk.core.util.m.Y(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && Y != null && !Y.isRecycled()) {
                        Y.recycle();
                        return null;
                    }
                    if (Y != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.drx) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(Y)) {
                                    Y = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(Y, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.eNs) {
                                        WriteImageActivity.this.drB = new HashMap();
                                        WriteImageActivity.this.drC = new HashMap();
                                        WriteImageActivity.this.drB.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.aQj.setVisibility(0);
            WriteImageActivity.this.eNn.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.eNo = null;
            WriteImageActivity.this.aQj.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.eNn.setEnabled(true);
            WriteImageActivity.this.eNo = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.aQj.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aMx.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.drx) {
                    return;
                }
                WriteImageActivity.this.C(WriteImageActivity.dre);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pd(String str) {
        try {
            com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_PIC_DIR, str, this.drt, 90);
            this.aMx.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.drt, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.b(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.drw));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String[] strArr) {
        if (this.drB != null && strArr != null) {
            this.drz.removeAllViews();
            this.drr.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eJ(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                    this.drD = imageView2;
                } else {
                    imageView2.setOnClickListener(new bv(this, substring, i2));
                }
                this.drz.addView(inflate2);
                synchronized (this.eNs) {
                    this.drC.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            mk(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.dry != null && (imageView = this.drC.get(this.dry)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.drv, this.drv, this.drv, this.drv);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.drC != null) {
                ImageView imageView2 = this.drC.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(t.f.bg_choose_filter);
                    imageView2.setPadding(this.drv, this.drv, this.drv, this.drv);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.dry = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean drH;
        private Boolean drI;
        private String mLabel;

        private a() {
            this.drH = false;
            this.drI = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.drx) {
                PluginPackageManager.PluginStatus bz = PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bz != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bz == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        WriteImageActivity.this.showToast(t.j.plugin_config_not_found);
                        return;
                    } else if (bz == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    } else if (bz == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), t.j.plugin_muto_not_install, new by(this), new bz(this));
                        WriteImageActivity.this.mHandler.postDelayed(new ca(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.aQj.setVisibility(0);
            WriteImageActivity.this.eNn.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.drt == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.drH = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.drI = true;
            }
            if (!this.drH.booleanValue() && !this.drI.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.drt == null || WriteImageActivity.this.drt.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.drt.copy(WriteImageActivity.this.drt.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.drH.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.drI.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.drt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.aQj.setVisibility(8);
            WriteImageActivity.this.eNn.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.aQj.setVisibility(8);
            WriteImageActivity.this.eNn.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.drA = true;
                WriteImageActivity.this.aMx.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.drH.booleanValue() || this.drI.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.drH.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.drI.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.drt != null && !WriteImageActivity.this.drt.isRecycled()) {
                    WriteImageActivity.this.drt.recycle();
                }
                WriteImageActivity.this.drt = bitmap;
            }
        }
    }

    private void KL() {
        this.eNq = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.eNq, intentFilter);
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
            if (WriteImageActivity.this.eNn != null) {
                WriteImageActivity.this.eNn.setEnabled(false);
            }
        }
    }
}
