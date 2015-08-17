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
import com.baidu.tbadk.widget.EditHeadsImageView;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View chC;
    private View chD;
    private RadioButton chJ;
    private RadioButton chK;
    private LinearLayout chU;
    private HashMap<String, Bitmap> chW;
    private HashMap<String, ImageView> chX;
    private View chY;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String chy = "change";
    public static String FILE_NAME = "file_name";
    private static String[] chA = null;
    private float chz = 1.0f;
    private EditHeadsImageView chB = null;
    private Bitmap mBitmap = null;
    private int bDY = 0;
    private Button chE = null;
    private Button chF = null;
    private HorizontalScrollView chG = null;
    private ProgressBar mProgress = null;
    private b chH = null;
    private a chI = null;
    private LinearLayout chL = null;
    private LinearLayout chM = null;
    private d chN = null;
    private TextView aPV = null;
    private Bitmap chO = null;
    private c chP = null;
    private int chQ = 0;
    private int chR = 0;
    private boolean chS = true;
    private String chT = null;
    private boolean chV = false;
    private boolean ayV = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.e.gy().ah("motu_sdk") == 1 || PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.chS = false;
        } else {
            this.chS = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.edit_head_activity);
        Intent intent = getIntent();
        this.bDY = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.ayV = intent.getBooleanExtra("need_upload", true);
        this.chz = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ar.uE().uK());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ar.uE().uK(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        chA = getResources().getStringArray(i.b.fiter_name);
        if (this.chS) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.j(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.chC);
        getLayoutMode().k(this.aPV);
        getLayoutMode().k(this.chD);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.chH != null) {
            this.chH.cancel();
        }
        this.chB.setImageDrawable(null);
        afR();
    }

    private void afR() {
        if (this.chX != null) {
            for (Map.Entry<String, ImageView> entry : this.chX.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.chX.clear();
            this.chX = null;
        }
        if (this.chW != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.chW.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.chW.clear();
            this.chW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.chH != null) {
            this.chH.cancel();
        }
        this.chH = new b(this, null);
        this.chH.execute(new Object[0]);
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
        this.chB.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.chN != null) {
            this.chN.cancel();
        }
        if (this.chO != null && !this.chO.isRecycled()) {
            this.chO.recycle();
            this.chO = null;
        }
        if (this.chH != null) {
            this.chH.cancel();
            this.chH = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.chP);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afS() {
        if (this.chN != null) {
            this.chN.cancel();
        }
        this.chN = new d(this, null);
        this.chN.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.chB = (EditHeadsImageView) findViewById(i.f.image);
        this.chB.setCutImageHeightScale(this.chz);
        if (this.mBitmap != null) {
            this.chB.setImageBitmap(this.mBitmap);
        }
        this.chG = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.chC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.chF = (Button) findViewById(i.f.show_button);
        this.chF.setOnClickListener(new f(this));
        this.chE = (Button) findViewById(i.f.hide_button);
        this.chE.setVisibility(0);
        this.chE.setOnClickListener(new g(this));
        this.chD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.chD.setOnClickListener(new h(this));
        this.chD.setEnabled(false);
        ((TextView) this.chD.findViewById(i.f.save)).setText(i.C0057i.done);
        this.aPV = this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.beautify));
        this.chU = (LinearLayout) findViewById(i.f.filters);
        this.chQ = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.chM = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.chL = (LinearLayout) findViewById(i.f.rotate);
        this.chJ = (RadioButton) findViewById(i.f.beautify_btn);
        this.chK = (RadioButton) findViewById(i.f.rotate_btn);
        j jVar = new j(this);
        this.chJ.setOnCheckedChangeListener(jVar);
        this.chK.setOnCheckedChangeListener(jVar);
        this.chJ.setChecked(true);
        Button button = (Button) findViewById(i.f.rotate_left);
        Button button2 = (Button) findViewById(i.f.rotate_right);
        Button button3 = (Button) findViewById(i.f.rotate_left_right);
        Button button4 = (Button) findViewById(i.f.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        k kVar = new k(this);
        button.setOnClickListener(kVar);
        button2.setOnClickListener(kVar);
        button3.setOnClickListener(kVar);
        button4.setOnClickListener(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z) {
        if (this.chI != null) {
            this.chI.cancel();
        }
        this.chI = new a(z);
        this.chI.execute(str);
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
                Bitmap ab = com.baidu.tbadk.core.util.n.ab(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (ab.getWidth() > 750 || ab.getHeight() > 750) {
                        Bitmap d = com.baidu.tbadk.core.util.c.d(ab, TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            ab.recycle();
                            ab = d;
                        } catch (Exception e) {
                            e = e;
                            bitmap = d;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && ab != null && !ab.isRecycled()) {
                        ab.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.chS) {
                        return ab;
                    }
                    Bitmap g = com.baidu.tbadk.core.util.c.g(ab, dip2px);
                    Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ab != g);
                    EditHeadActivity.this.chW = new HashMap();
                    EditHeadActivity.this.chX = new HashMap();
                    EditHeadActivity.this.chW.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                    return ab;
                } catch (Exception e2) {
                    bitmap = ab;
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
            EditHeadActivity.this.chD.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.chH = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.chD.setClickable(true);
            EditHeadActivity.this.chD.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.chH = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.chD.setClickable(true);
            EditHeadActivity.this.chD.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.chB.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.chB.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.chS) {
                    return;
                }
                EditHeadActivity.this.w(EditHeadActivity.chA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.n.a(null, str, bitmap, 80);
            if (this.chV) {
                new com.baidu.tbadk.core.util.aj("motu_pic", String.valueOf(this.chR)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.chW != null && strArr != null) {
            this.chU.removeAllViews();
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.d.eh(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new l(this, substring, i2));
                    this.chY = imageView2;
                } else {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                }
                this.chU.addView(inflate2);
                if (this.chX != null) {
                    this.chX.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            jv(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.chX == null) {
                this.chX = new HashMap<>();
            }
            if (this.chT != null && (imageView = this.chX.get(this.chT)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.chQ, this.chQ, this.chQ, this.chQ);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.chX.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(i.e.round_corner);
                imageView2.setPadding(this.chQ, this.chQ, this.chQ, this.chQ);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.chT = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean cib;
        private Boolean cic = false;
        private Boolean cie = false;
        private String mLabel;

        public a(boolean z) {
            this.cib = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.cib || yW()) {
                EditHeadActivity.this.mProgress.setVisibility(0);
                EditHeadActivity.this.chD.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.chO == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cic = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cie = true;
            }
            if (!this.cic.booleanValue() && !this.cie.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.chO == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.chO.copy(EditHeadActivity.this.chO.getConfig(), true);
            }
            if (this.cic.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.cie.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean yW() {
            PluginPackageManager.PluginStatus bv = PluginPackageManager.lT().bv(PluginCenter.NAME_MOTUSDK);
            if (bv == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bv == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), i.C0057i.plugin_config_not_found);
                return false;
            } else if (bv == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lT().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bv == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.util.a.a(EditHeadActivity.this.getPageContext(), i.C0057i.plugin_muto_not_install, new n(this), new o(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.chO != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.chD.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.chD.setClickable(true);
            EditHeadActivity.this.chD.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.chV = true;
                if (this.cic.booleanValue() || this.cie.booleanValue()) {
                    EditHeadActivity.this.chB.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(EditHeadActivity.this.mBitmap, TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.cic.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cie.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.chB.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.chO != null && !EditHeadActivity.this.chO.isRecycled()) {
                    EditHeadActivity.this.chO.recycle();
                }
                EditHeadActivity.this.chO = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.chP = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.chP, intentFilter);
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
            if (EditHeadActivity.this.chD != null) {
                EditHeadActivity.this.chD.setEnabled(false);
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
        private com.baidu.tbadk.core.util.v afJ;

        private d() {
            this.afJ = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(i.C0057i.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.afJ = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.afJ.cU(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afJ.ue().uW().rb()) {
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
            EditHeadActivity.this.chN = null;
            if (this.afJ != null) {
                this.afJ.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.afJ != null) {
                if (this.afJ.ue().uW().rb()) {
                    EditHeadActivity.this.setResult(-1);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(i.C0057i.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.afJ.getErrorString());
            }
        }
    }
}
