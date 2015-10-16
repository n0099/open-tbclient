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
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View coA;
    private String coc;
    private View coe;
    private View cof;
    private RadioButton col;

    /* renamed from: com  reason: collision with root package name */
    private RadioButton f127com;
    private LinearLayout cow;
    private HashMap<String, Bitmap> coy;
    private HashMap<String, ImageView> coz;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String cnZ = "change";
    public static String FILE_NAME = "file_name";
    private static String[] cob = null;
    private float coa = 1.0f;
    private EditHeadsImageView cod = null;
    private Bitmap mBitmap = null;
    private int bHT = 0;
    private Button cog = null;
    private Button coh = null;
    private HorizontalScrollView coi = null;
    private ProgressBar mProgress = null;
    private b coj = null;
    private a cok = null;
    private LinearLayout con = null;
    private LinearLayout coo = null;
    private d cop = null;
    private TextView aPq = null;
    private Bitmap coq = null;
    private c cor = null;
    private int cos = 0;
    private int cot = 0;
    private boolean cou = true;
    private String cov = null;
    private boolean cox = false;
    private boolean azp = true;
    private final Handler mHandler = new Handler();

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
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.edit_head_activity);
        Intent intent = getIntent();
        this.bHT = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.azp = intent.getBooleanExtra("need_upload", true);
        this.coa = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.coc = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.at.uJ().uP());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.at.uJ().uP(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cob = getResources().getStringArray(i.b.fiter_name);
        if (this.cou) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.an.j(this.mNavigationBar, i.c.alpha80_black);
        getLayoutMode().k(this.coe);
        getLayoutMode().k(this.aPq);
        getLayoutMode().k(this.cof);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.coj != null) {
            this.coj.cancel();
        }
        this.cod.setImageDrawable(null);
        aig();
    }

    private void aig() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.coj != null) {
            this.coj.cancel();
        }
        this.coj = new b(this, null);
        this.coj.execute(new Object[0]);
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
        this.cod.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.cop != null) {
            this.cop.cancel();
        }
        if (this.coq != null && !this.coq.isRecycled()) {
            this.coq.recycle();
            this.coq = null;
        }
        if (this.coj != null) {
            this.coj.cancel();
            this.coj = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cor);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aih() {
        if (this.cop != null) {
            this.cop.cancel();
        }
        this.cop = new d(this, null);
        this.cop.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mProgress.setVisibility(8);
        this.cod = (EditHeadsImageView) findViewById(i.f.image);
        this.cod.setCutImageHeightScale(this.coa);
        if (this.mBitmap != null) {
            this.cod.setImageBitmap(this.mBitmap);
        }
        this.coi = (HorizontalScrollView) findViewById(i.f.filters_layout);
        this.coe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.coh = (Button) findViewById(i.f.show_button);
        this.coh.setOnClickListener(new f(this));
        this.cog = (Button) findViewById(i.f.hide_button);
        this.cog.setVisibility(0);
        this.cog.setOnClickListener(new g(this));
        this.cof = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.cof.setOnClickListener(new h(this));
        this.cof.setEnabled(false);
        ((TextView) this.cof.findViewById(i.f.save)).setText(i.h.done);
        this.aPq = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.beautify));
        if ("from_photo_live".equals(this.coc)) {
            this.aPq.setText(i.h.choose_picture);
        }
        this.cow = (LinearLayout) findViewById(i.f.filters);
        this.cos = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.coo = (LinearLayout) findViewById(i.f.beautify_rotate);
        this.con = (LinearLayout) findViewById(i.f.rotate);
        this.col = (RadioButton) findViewById(i.f.beautify_btn);
        this.f127com = (RadioButton) findViewById(i.f.rotate_btn);
        j jVar = new j(this);
        this.col.setOnCheckedChangeListener(jVar);
        this.f127com.setOnCheckedChangeListener(jVar);
        this.col.setChecked(true);
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
    public void D(String str, boolean z) {
        if (this.cok != null) {
            this.cok.cancel();
        }
        this.cok = new a(z);
        this.cok.execute(str);
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
                Bitmap aa = com.baidu.tbadk.core.util.n.aa(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (aa.getWidth() > 750 || aa.getHeight() > 750) {
                        Bitmap d = com.baidu.tbadk.core.util.c.d(aa, TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            aa.recycle();
                            aa = d;
                        } catch (Exception e) {
                            e = e;
                            bitmap = d;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && aa != null && !aa.isRecycled()) {
                        aa.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cou) {
                        return aa;
                    }
                    Bitmap g = com.baidu.tbadk.core.util.c.g(aa, dip2px);
                    Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), aa != g);
                    EditHeadActivity.this.coy = new HashMap();
                    EditHeadActivity.this.coz = new HashMap();
                    EditHeadActivity.this.coy.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                    return aa;
                } catch (Exception e2) {
                    bitmap = aa;
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
            EditHeadActivity.this.cof.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.coj = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cof.setClickable(true);
            EditHeadActivity.this.cof.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.coj = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cof.setClickable(true);
            EditHeadActivity.this.cof.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.cod.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.cod.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cou) {
                    return;
                }
                EditHeadActivity.this.w(EditHeadActivity.cob);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.n.a(null, str, bitmap, 80);
            if (this.cox) {
                new com.baidu.tbadk.core.util.ak("motu_pic", String.valueOf(this.cot)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String[] strArr) {
        if (this.coy != null && strArr != null) {
            this.cow.removeAllViews();
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
                    imageView2.setOnClickListener(new l(this, substring, i2));
                    this.coA = imageView2;
                } else {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                }
                this.cow.addView(inflate2);
                if (this.coz != null) {
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
            if (this.coz == null) {
                this.coz = new HashMap<>();
            }
            if (this.cov != null && (imageView = this.coz.get(this.cov)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cos, this.cos, this.cos, this.cos);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.coz.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(i.e.round_corner);
                imageView2.setPadding(this.cos, this.cos, this.cos, this.cos);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.cov = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean coD;
        private Boolean coE = false;
        private Boolean coF = false;
        private String mLabel;

        public a(boolean z) {
            this.coD = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.coD || yM()) {
                EditHeadActivity.this.mProgress.setVisibility(0);
                EditHeadActivity.this.cof.setEnabled(false);
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
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.coq == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.coE = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.coF = true;
            }
            if (!this.coE.booleanValue() && !this.coF.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.coq == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.coq.copy(EditHeadActivity.this.coq.getConfig(), true);
            }
            if (this.coE.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.coF.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean yM() {
            PluginPackageManager.PluginStatus bw = PluginPackageManager.lR().bw(PluginCenter.NAME_MOTUSDK);
            if (bw == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bw == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), i.h.plugin_config_not_found);
                return false;
            } else if (bw == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lR().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bw == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), i.h.plugin_muto_not_install, new n(this), new o(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.coq != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cof.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cof.setClickable(true);
            EditHeadActivity.this.cof.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.cox = true;
                if (this.coE.booleanValue() || this.coF.booleanValue()) {
                    EditHeadActivity.this.cod.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(EditHeadActivity.this.mBitmap, TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.coE.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.coF.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.cod.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.coq != null && !EditHeadActivity.this.coq.isRecycled()) {
                    EditHeadActivity.this.coq.recycle();
                }
                EditHeadActivity.this.coq = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.cor = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cor, intentFilter);
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
            if (EditHeadActivity.this.cof != null) {
                EditHeadActivity.this.cof.setEnabled(false);
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
        private com.baidu.tbadk.core.util.w afh;

        private d() {
            this.afh = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(i.h.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.afh = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.afh.de(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afh.uh().uZ().qV()) {
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
            EditHeadActivity.this.cop = null;
            if (this.afh != null) {
                this.afh.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.afh != null) {
                if (this.afh.uh().uZ().qV()) {
                    EditHeadActivity.this.setResult(-1);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(i.h.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.afh.getErrorString());
            }
        }
    }
}
