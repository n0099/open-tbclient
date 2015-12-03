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
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] cIS = null;
    private RadioButton cJc;
    private RadioButton cJd;
    private LinearLayout cJn;
    private HashMap<String, Bitmap> cJp;
    private HashMap<String, ImageView> cJq;
    private View cJr;
    private View dRi;
    private View dRj;
    private String dRn;
    private int requestCode;
    private ImageView aGW = null;
    private Bitmap mBitmap = null;
    private TextView dPd = null;
    private View Mk = null;
    private HorizontalScrollView cIZ = null;
    private ProgressBar mProgress = null;
    private b dRk = null;
    private a dRl = null;
    private RadioGroup Nk = null;
    private LinearLayout cJe = null;
    private LinearLayout cJf = null;
    private TextView Mf = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap cJh = null;
    private c dRm = null;
    private int cJj = 0;
    private int cJk = 0;
    private int mDisplaySize = 0;
    private boolean cJl = true;
    private String cJm = null;
    private boolean cJo = false;
    private boolean cDl = false;
    private final Handler mHandler = new Handler();
    private final Object dRo = new Object();
    private final View.OnClickListener dRp = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gw().aj("motu_sdk") == 1 || PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cJl = false;
        } else {
            this.cJl = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(n.g.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.dRn = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.cJl) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.cDl = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ay.vq().vw(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ay.vq().vw(), this.mDisplaySize, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cIS = getResources().getStringArray(n.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.dRk != null) {
            this.dRk.cancel();
        }
        this.aGW.setImageDrawable(null);
        anl();
    }

    private void anl() {
        synchronized (this.dRo) {
            if (this.cJq != null) {
                for (Map.Entry<String, ImageView> entry : this.cJq.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.cJq.clear();
                this.cJq = null;
            }
            if (this.cJp != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.cJp.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.cJp.clear();
                this.cJp = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.dRk != null) {
            this.dRk.cancel();
        }
        this.dRk = new b(this, null);
        this.dRk.execute(new Object[0]);
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
        if (this.cJh != null && !this.cJh.isRecycled()) {
            this.cJh.recycle();
            this.cJh = null;
        }
        if (this.dRk != null) {
            this.dRk.cancel();
            this.dRk = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.dRm);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.dRp.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.Mk);
        com.baidu.tbadk.core.util.as.j(this.mNavigationBar, n.c.alpha80_black);
        getLayoutMode().k(this.dRi);
        getLayoutMode().k(this.Mf);
        if (this.dRj.isEnabled()) {
            this.dPd.setTextColor(getResources().getColor(n.c.navi_done_text));
        } else {
            this.dPd.setTextColor(getResources().getColor(n.c.navi_done_text_d));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }

    private void initUI() {
        this.Mk = findViewById(n.f.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        this.mProgress.setVisibility(8);
        this.aGW = (ImageView) findViewById(n.f.image);
        this.aGW.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aGW.setImageBitmap(this.mBitmap);
        }
        this.cIZ = (HorizontalScrollView) findViewById(n.f.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.dRi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.dRj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.image_activity_save_button, (View.OnClickListener) null);
        this.dRj.setOnClickListener(new bq(this));
        this.dPd = (TextView) this.dRj.findViewById(n.f.save);
        if (TextUtils.isEmpty(this.dRn)) {
            if (this.cDl || this.requestCode != 12003) {
                this.dPd.setText(getPageContext().getString(n.i.done));
            } else {
                this.dPd.setText(getPageContext().getString(n.i.delete));
            }
        } else {
            this.dPd.setText(this.dRn);
        }
        this.cJn = (LinearLayout) findViewById(n.f.filters);
        this.cJj = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Mf = this.mNavigationBar.setTitleText(getPageContext().getString(n.i.beautify));
        this.cJf = (LinearLayout) findViewById(n.f.beautify_rotate);
        this.cJe = (LinearLayout) findViewById(n.f.rotate);
        this.cJc = (RadioButton) findViewById(n.f.beautify_btn);
        this.cJd = (RadioButton) findViewById(n.f.rotate_btn);
        this.Nk = (RadioGroup) findViewById(n.f.beautify_tabs);
        br brVar = new br(this);
        this.cJc.setOnCheckedChangeListener(brVar);
        this.cJd.setOnCheckedChangeListener(brVar);
        this.cJc.setChecked(true);
        Button button = (Button) findViewById(n.f.rotate_left);
        Button button2 = (Button) findViewById(n.f.rotate_right);
        Button button3 = (Button) findViewById(n.f.rotate_left_right);
        Button button4 = (Button) findViewById(n.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.cJf.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.cJl) {
            this.cJd.setPadding(0, this.cJd.getPaddingTop(), this.cJd.getPaddingRight(), this.cJd.getPaddingBottom());
            this.cJd.setChecked(true);
            this.cIZ.setVisibility(8);
            this.cJc.setVisibility(8);
            this.Nk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx(String str) {
        if (this.dRl != null) {
            this.dRl.cancel();
        }
        this.dRl = new a(this, null);
        this.dRl.execute(str);
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
                Bitmap X = com.baidu.tbadk.core.util.n.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    if (X != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.cJl) {
                            Bitmap g = com.baidu.tbadk.core.util.c.g(X, dip2px);
                            if (g != null) {
                                if (g.equals(X)) {
                                    X = com.baidu.tbadk.core.util.c.N(com.baidu.tbadk.core.util.c.e(X, 100));
                                }
                                Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (a != null) {
                                    synchronized (WriteImageActivity.this.dRo) {
                                        WriteImageActivity.this.cJp = new HashMap();
                                        WriteImageActivity.this.cJq = new HashMap();
                                        WriteImageActivity.this.cJp.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
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
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dRj.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.dRk = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.dRj.setEnabled(true);
            WriteImageActivity.this.dRk = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aGW.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.cJl) {
                    return;
                }
                WriteImageActivity.this.x(WriteImageActivity.cIS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ny(String str) {
        try {
            com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_PIC_DIR, str, this.cJh, 90);
            this.aGW.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap d = com.baidu.tbadk.core.util.c.d(this.cJh, i);
            if (d != null && com.baidu.tbadk.core.util.n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, d, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.cJk));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String[] strArr) {
        if (this.cJp != null && strArr != null) {
            this.cJn.removeAllViews();
            this.cJf.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(n.f.filter_immage);
            TextView textView = (TextView) inflate.findViewById(n.f.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(n.f.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(n.f.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eA(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.cJr = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.cJn.addView(inflate2);
                synchronized (this.dRo) {
                    this.cJq.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kS(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cJm != null && (imageView = this.cJq.get(this.cJm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cJj, this.cJj, this.cJj, this.cJj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.cJq != null) {
                ImageView imageView2 = this.cJq.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(n.e.bg_choose_filter);
                    imageView2.setPadding(this.cJj, this.cJj, this.cJj, this.cJj);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.cJm = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean cJv;
        private Boolean cJw;
        private String mLabel;

        private a() {
            this.cJv = false;
            this.cJw = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.cJl) {
                PluginPackageManager.PluginStatus by = PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && by != PluginPackageManager.PluginStatus.NROMAL) {
                    if (by == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(n.i.plugin_config_not_found);
                        return;
                    } else if (by == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lU().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (by == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), n.i.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.dRj.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.cJh == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cJv = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cJw = true;
            }
            if (!this.cJv.booleanValue() && !this.cJw.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.cJh == null || WriteImageActivity.this.cJh.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.cJh.copy(WriteImageActivity.this.cJh.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = com.baidu.tbadk.core.util.c.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
                }
                if (this.cJv.booleanValue()) {
                    this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.cJw.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.cJh != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dRj.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.dRj.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.cJo = true;
                WriteImageActivity.this.aGW.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.cJv.booleanValue() || this.cJw.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(WriteImageActivity.this.mBitmap, TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.cJv.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cJw.booleanValue()) {
                        WriteImageActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.cJh != null && !WriteImageActivity.this.cJh.isRecycled()) {
                    WriteImageActivity.this.cJh.recycle();
                }
                WriteImageActivity.this.cJh = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.dRm = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.dRm, intentFilter);
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
            if (WriteImageActivity.this.dRj != null) {
                WriteImageActivity.this.dRj.setEnabled(false);
            }
        }
    }
}
