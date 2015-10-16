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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] cob = null;
    private View coA;
    private RadioButton col;

    /* renamed from: com  reason: collision with root package name */
    private RadioButton f128com;
    private LinearLayout cow;
    private HashMap<String, Bitmap> coy;
    private HashMap<String, ImageView> coz;
    private View dqm;
    private View dqn;
    private String dqr;
    private int requestCode;
    private ImageView aDq = null;
    private Bitmap mBitmap = null;
    private TextView dol = null;
    private View LS = null;
    private HorizontalScrollView coi = null;
    private ProgressBar mProgress = null;
    private b dqo = null;
    private a dqp = null;
    private RadioGroup MS = null;
    private LinearLayout con = null;
    private LinearLayout coo = null;
    private TextView LN = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap coq = null;
    private c dqq = null;
    private int cos = 0;
    private int cot = 0;
    private int mDisplaySize = 0;
    private boolean cou = true;
    private String cov = null;
    private boolean cox = false;
    private boolean cjx = false;
    private final Handler mHandler = new Handler();
    private final Object dqs = new Object();
    private final View.OnClickListener dqt = new bl(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.gv().ah("motu_sdk") == 1 || PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cou = false;
        } else {
            this.cou = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(i.g.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.dqr = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.cou) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.cjx = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.at.uJ().uP(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.at.uJ().uP(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cob = getResources().getStringArray(i.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.dqo != null) {
            this.dqo.cancel();
        }
        this.aDq.setImageDrawable(null);
        aig();
    }

    private void aig() {
        synchronized (this.dqs) {
            if (this.coz != null) {
                for (Map.Entry<String, ImageView> entry : this.coz.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.coz.clear();
                this.coz = null;
            }
            if (this.coy != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.coy.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.coy.clear();
                this.coy = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.dqo != null) {
            this.dqo.cancel();
        }
        this.dqo = new b(this, null);
        this.dqo.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.coq != null && !this.coq.isRecycled()) {
            this.coq.recycle();
            this.coq = null;
        }
        if (this.dqo != null) {
            this.dqo.cancel();
            this.dqo = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.dqq);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.dqt.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.LS);
        com.baidu.tbadk.core.util.an.j(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.dqm);
        getLayoutMode().k(this.LN);
        if (this.dqn.isEnabled()) {
            this.dol.setTextColor(getResources().getColor(i.c.navi_done_text));
        } else {
            this.dol.setTextColor(getResources().getColor(i.c.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void initUI() {
        this.LS = findViewById(i.f.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.aDq = (ImageView) findViewById(i.f.image);
        this.aDq.setOnClickListener(new bm(this));
        if (this.mBitmap != null) {
            this.aDq.setImageBitmap(this.mBitmap);
        }
        this.coi = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.dqm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bn(this));
        this.dqn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.dqn.setOnClickListener(new bo(this));
        this.dol = (TextView) this.dqn.findViewById(i.f.save);
        if (TextUtils.isEmpty(this.dqr)) {
            if (this.cjx || this.requestCode != 12003) {
                this.dol.setText(getPageContext().getString(i.h.done));
            } else {
                this.dol.setText(getPageContext().getString(i.h.delete));
            }
        } else {
            this.dol.setText(this.dqr);
        }
        this.cow = (LinearLayout) findViewById(i.f.filters);
        this.cos = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.LN = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.beautify));
        this.coo = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.con = (LinearLayout) findViewById(i.f.rotate);
        this.col = (RadioButton) findViewById(i.f.beautify_btn);
        this.f128com = (RadioButton) findViewById(i.f.rotate_btn);
        this.MS = (RadioGroup) findViewById(i.f.beautify_tabs);
        bp bpVar = new bp(this);
        this.col.setOnCheckedChangeListener(bpVar);
        this.f128com.setOnCheckedChangeListener(bpVar);
        this.col.setChecked(true);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bq bqVar = new bq(this);
        button.setOnClickListener(bqVar);
        button2.setOnClickListener(bqVar);
        button3.setOnClickListener(bqVar);
        button4.setOnClickListener(bqVar);
        this.coo.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.cou) {
            this.f128com.setPadding(0, this.f128com.getPaddingTop(), this.f128com.getPaddingRight(), this.f128com.getPaddingBottom());
            this.f128com.setChecked(true);
            this.coi.setVisibility(8);
            this.col.setVisibility(8);
            this.MS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(String str) {
        if (this.dqp != null) {
            this.dqp.cancel();
        }
        this.dqp = new a(this, null);
        this.dqp.execute(str);
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
                Bitmap aa = com.baidu.tbadk.core.util.n.aa(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && aa != null && !aa.isRecycled()) {
                        aa.recycle();
                        return null;
                    }
                    if (aa != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.cou) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(aa, dip2px);
                            if (g != null) {
                                if (g.equals(aa)) {
                                    aa = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(aa, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.dqs) {
                                        WriteImageActivity.this.coy = new HashMap();
                                        WriteImageActivity.this.coz = new HashMap();
                                        WriteImageActivity.this.coy.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                                    }
                                    return aa;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return aa;
                } catch (Exception e) {
                    bitmap = aa;
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
            WriteImageActivity.this.dqn.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.dqo = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.dqn.setEnabled(true);
            WriteImageActivity.this.dqo = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aDq.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.cou) {
                    return;
                }
                WriteImageActivity.this.w(WriteImageActivity.cob);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean my(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.coq, 90);
            this.aDq.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.coq, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.cot));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.coy != null && strArr != null) {
            this.cow.removeAllViews();
            this.coo.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(i.f.filter_immage);
            TextView textView = (TextView) inflate.findViewById(i.f.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(i.f.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(i.f.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eq(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new br(this, substring, i2));
                    this.coA = imageView2;
                } else {
                    imageView2.setOnClickListener(new bs(this, substring, i2));
                }
                this.cow.addView(inflate2);
                synchronized (this.dqs) {
                    this.coz.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            jY(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cov != null && (imageView = this.coz.get(this.cov)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cos, this.cos, this.cos, this.cos);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.coz != null) {
                ImageView imageView2 = this.coz.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(i.e.bg_choose_filter);
                    imageView2.setPadding(this.cos, this.cos, this.cos, this.cos);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.cov = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean coE;
        private Boolean coF;
        private String mLabel;

        private a() {
            this.coE = false;
            this.coF = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.cou) {
                PluginPackageManager.PluginStatus bw = PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bw != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bw == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bt(this), 500L);
                        WriteImageActivity.this.showToast(i.h.plugin_config_not_found);
                        return;
                    } else if (bw == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lR().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bu(this), 500L);
                        cancel();
                        return;
                    } else if (bw == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), i.h.plugin_muto_not_install, new bv(this), new bw(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bx(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dqn.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.coq == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.coE = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.coF = true;
            }
            if (!this.coE.booleanValue() && !this.coF.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.coq == null || WriteImageActivity.this.coq.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.coq.copy(WriteImageActivity.this.coq.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.coE.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.coF.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.coq != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dqn.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dqn.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.cox = true;
                WriteImageActivity.this.aDq.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.coE.booleanValue() || this.coF.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.coE.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.coF.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.coq != null && !WriteImageActivity.this.coq.isRecycled()) {
                    WriteImageActivity.this.coq.recycle();
                }
                WriteImageActivity.this.coq = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.dqq = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.dqq, intentFilter);
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
            if (WriteImageActivity.this.dqn != null) {
                WriteImageActivity.this.dqn.setEnabled(false);
            }
        }
    }
}
