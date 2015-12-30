package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private LinearLayout cND;
    private HashMap<String, Bitmap> cNF;
    private HashMap<String, ImageView> cNG;
    private View cNH;
    private String cNj;
    private View cNl;
    private View cNm;
    private RadioButton cNs;
    private RadioButton cNt;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String cNg = "change";
    public static String FILE_NAME = "file_name";
    private static String[] cNi = null;
    private float cNh = 1.0f;
    private EditHeadsImageView cNk = null;
    private Bitmap mBitmap = null;
    private int cbu = 0;
    private Button cNn = null;
    private Button cNo = null;
    private HorizontalScrollView cNp = null;
    private ProgressBar mProgress = null;
    private b cNq = null;
    private a cNr = null;
    private LinearLayout cNu = null;
    private LinearLayout cNv = null;
    private d cNw = null;
    private TextView aOn = null;
    private Bitmap cNx = null;
    private c cNy = null;
    private int cNz = 0;
    private int cNA = 0;
    private boolean cNB = true;
    private String cNC = null;
    private boolean cNE = false;
    private boolean aBO = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gw().aj("motu_sdk") == 1 || PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cNB = false;
        } else {
            this.cNB = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.h.edit_head_activity);
        Intent intent = getIntent();
        this.cbu = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.aBO = intent.getBooleanExtra("need_upload", true);
        this.cNh = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.cNj = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ay.va().vg());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ay.va().vg(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cNi = getResources().getStringArray(n.b.fiter_name);
        if (this.cNB) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.j(this.mNavigationBar, n.d.alpha80_black);
        getLayoutMode().k(this.cNl);
        getLayoutMode().k(this.aOn);
        getLayoutMode().k(this.cNm);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cNq != null) {
            this.cNq.cancel();
        }
        this.cNk.setImageDrawable(null);
        aow();
    }

    private void aow() {
        if (this.cNG != null) {
            for (Map.Entry<String, ImageView> entry : this.cNG.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.cNG.clear();
            this.cNG = null;
        }
        if (this.cNF != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.cNF.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.cNF.clear();
            this.cNF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cNq != null) {
            this.cNq.cancel();
        }
        this.cNq = new b(this, null);
        this.cNq.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.cNk.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.cNw != null) {
            this.cNw.cancel();
        }
        if (this.cNx != null && !this.cNx.isRecycled()) {
            this.cNx.recycle();
            this.cNx = null;
        }
        if (this.cNq != null) {
            this.cNq.cancel();
            this.cNq = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cNy);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.cNw != null) {
            this.cNw.cancel();
        }
        this.cNw = new d(this, null);
        this.cNw.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(n.g.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        this.mProgress.setVisibility(8);
        this.cNk = (EditHeadsImageView) findViewById(n.g.image);
        this.cNk.setCutImageHeightScale(this.cNh);
        if (this.mBitmap != null) {
            this.cNk.setImageBitmap(this.mBitmap);
        }
        this.cNp = (HorizontalScrollView) findViewById(n.g.filters_layout);
        this.cNl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.cNo = (Button) findViewById(n.g.show_button);
        this.cNo.setOnClickListener(new g(this));
        this.cNn = (Button) findViewById(n.g.hide_button);
        this.cNn.setVisibility(0);
        this.cNn.setOnClickListener(new h(this));
        this.cNm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.image_activity_save_button, (View.OnClickListener) null);
        this.cNm.setOnClickListener(new i(this));
        this.cNm.setEnabled(false);
        ((TextView) this.cNm.findViewById(n.g.save)).setText(n.j.done);
        this.aOn = this.mNavigationBar.setTitleText(getPageContext().getString(n.j.beautify));
        if (EditHeadActivityConfig.FROM_PHOTO_LIVE.equals(this.cNj)) {
            this.aOn.setText(n.j.choose_picture);
        }
        this.cND = (LinearLayout) findViewById(n.g.filters);
        this.cNz = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.cNv = (LinearLayout) findViewById(n.g.beautify_rotate);
        this.cNu = (LinearLayout) findViewById(n.g.rotate);
        this.cNs = (RadioButton) findViewById(n.g.beautify_btn);
        this.cNt = (RadioButton) findViewById(n.g.rotate_btn);
        k kVar = new k(this);
        this.cNs.setOnCheckedChangeListener(kVar);
        this.cNt.setOnCheckedChangeListener(kVar);
        this.cNs.setChecked(true);
        Button button = (Button) findViewById(n.g.rotate_left);
        Button button2 = (Button) findViewById(n.g.rotate_right);
        Button button3 = (Button) findViewById(n.g.rotate_left_right);
        Button button4 = (Button) findViewById(n.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        l lVar = new l(this);
        button.setOnClickListener(lVar);
        button2.setOnClickListener(lVar);
        button3.setOnClickListener(lVar);
        button4.setOnClickListener(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, boolean z) {
        if (this.cNr != null) {
            this.cNr.cancel();
        }
        this.cNr = new a(z);
        this.cNr.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* synthetic */ b(EditHeadActivity editHeadActivity, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap W = com.baidu.tbadk.core.util.n.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (W.getWidth() > 750 || W.getHeight() > 750) {
                        Bitmap d = com.baidu.tbadk.core.util.c.d(W, TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            W.recycle();
                            W = d;
                        } catch (Exception e) {
                            e = e;
                            bitmap = d;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cNB) {
                        return W;
                    }
                    Bitmap g = com.baidu.tbadk.core.util.c.g(W, dip2px);
                    Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), W != g);
                    EditHeadActivity.this.cNF = new HashMap();
                    EditHeadActivity.this.cNG = new HashMap();
                    EditHeadActivity.this.cNF.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                    return W;
                } catch (Exception e2) {
                    bitmap = W;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mProgress.setVisibility(0);
            EditHeadActivity.this.cNm.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.cNq = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cNm.setClickable(true);
            EditHeadActivity.this.cNm.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.cNq = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cNm.setClickable(true);
            EditHeadActivity.this.cNm.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.cNk.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.cNk.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cNB) {
                    return;
                }
                EditHeadActivity.this.w(EditHeadActivity.cNi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.n.a(null, str, bitmap, 80);
            if (this.cNE) {
                new com.baidu.tbadk.core.util.ap("motu_pic", String.valueOf(this.cNA)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.cNF != null && strArr != null) {
            this.cND.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(n.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(n.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(n.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(n.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eD(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                    this.cNH = imageView2;
                } else {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                }
                this.cND.addView(inflate2);
                if (this.cNG != null) {
                    this.cNG.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kP(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cNG == null) {
                this.cNG = new HashMap<>();
            }
            if (this.cNC != null && (imageView = this.cNG.get(this.cNC)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cNz, this.cNz, this.cNz, this.cNz);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.cNG.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(n.f.round_corner);
                imageView2.setPadding(this.cNz, this.cNz, this.cNz, this.cNz);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.cNC = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean cNK;
        private Boolean cNL = false;
        private Boolean cNM = false;
        private String mLabel;

        public a(boolean z) {
            this.cNK = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.cNK || zw()) {
                EditHeadActivity.this.mProgress.setVisibility(0);
                EditHeadActivity.this.cNm.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.cNx == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cNL = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cNM = true;
            }
            if (!this.cNL.booleanValue() && !this.cNM.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.cNx == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.cNx.copy(EditHeadActivity.this.cNx.getConfig(), true);
            }
            if (this.cNL.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.cNM.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean zw() {
            PluginPackageManager.PluginStatus bB = PluginPackageManager.ls().bB(PluginCenter.NAME_MOTUSDK);
            if (bB == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bB == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), n.j.plugin_config_not_found);
                return false;
            } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), n.j.plugin_muto_not_install, new o(this), new p(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.cNx != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cNm.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cNm.setClickable(true);
            EditHeadActivity.this.cNm.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.cNE = true;
                if (this.cNL.booleanValue() || this.cNM.booleanValue()) {
                    EditHeadActivity.this.cNk.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(EditHeadActivity.this.mBitmap, TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.cNL.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cNM.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.cNk.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.cNx != null && !EditHeadActivity.this.cNx.isRecycled()) {
                    EditHeadActivity.this.cNx.recycle();
                }
                EditHeadActivity.this.cNx = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.cNy = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cNy, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(EditHeadActivity editHeadActivity, c cVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EditHeadActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(intent.getStringExtra("error"));
            if (EditHeadActivity.this.cNm != null) {
                EditHeadActivity.this.cNm.setEnabled(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab ahV;

        private d() {
            this.ahV = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(n.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.ahV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.ahV.dr(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.ahV.uw().vq().qO()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.cNw = null;
            if (this.ahV != null) {
                this.ahV.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.ahV != null) {
                if (this.ahV.uw().vq().qO()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(n.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.ahV.getErrorString());
            }
        }
    }
}
