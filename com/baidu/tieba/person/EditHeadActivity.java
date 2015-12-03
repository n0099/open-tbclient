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
    private String cIT;
    private View cIV;
    private View cIW;
    private RadioButton cJc;
    private RadioButton cJd;
    private LinearLayout cJn;
    private HashMap<String, Bitmap> cJp;
    private HashMap<String, ImageView> cJq;
    private View cJr;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String cIQ = "change";
    public static String FILE_NAME = "file_name";
    private static String[] cIS = null;
    private float cIR = 1.0f;
    private EditHeadsImageView cIU = null;
    private Bitmap mBitmap = null;
    private int bXu = 0;
    private Button cIX = null;
    private Button cIY = null;
    private HorizontalScrollView cIZ = null;
    private ProgressBar mProgress = null;
    private b cJa = null;
    private a cJb = null;
    private LinearLayout cJe = null;
    private LinearLayout cJf = null;
    private d cJg = null;
    private TextView aUB = null;
    private Bitmap cJh = null;
    private c cJi = null;
    private int cJj = 0;
    private int cJk = 0;
    private boolean cJl = true;
    private String cJm = null;
    private boolean cJo = false;
    private boolean aAh = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gw().aj("motu_sdk") == 1 || PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cJl = false;
        } else {
            this.cJl = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.g.edit_head_activity);
        Intent intent = getIntent();
        this.bXu = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.aAh = intent.getBooleanExtra("need_upload", true);
        this.cIR = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.cIT = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ay.vq().vw());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ay.vq().vw(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        cIS = getResources().getStringArray(n.b.fiter_name);
        if (this.cJl) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.j(this.mNavigationBar, n.c.alpha80_black);
        getLayoutMode().k(this.cIV);
        getLayoutMode().k(this.aUB);
        getLayoutMode().k(this.cIW);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cJa != null) {
            this.cJa.cancel();
        }
        this.cIU.setImageDrawable(null);
        anl();
    }

    private void anl() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cJa != null) {
            this.cJa.cancel();
        }
        this.cJa = new b(this, null);
        this.cJa.execute(new Object[0]);
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
        this.cIU.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.cJg != null) {
            this.cJg.cancel();
        }
        if (this.cJh != null && !this.cJh.isRecycled()) {
            this.cJh.recycle();
            this.cJh = null;
        }
        if (this.cJa != null) {
            this.cJa.cancel();
            this.cJa = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cJi);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anm() {
        if (this.cJg != null) {
            this.cJg.cancel();
        }
        this.cJg = new d(this, null);
        this.cJg.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        this.mProgress.setVisibility(8);
        this.cIU = (EditHeadsImageView) findViewById(n.f.image);
        this.cIU.setCutImageHeightScale(this.cIR);
        if (this.mBitmap != null) {
            this.cIU.setImageBitmap(this.mBitmap);
        }
        this.cIZ = (HorizontalScrollView) findViewById(n.f.filters_layout);
        this.cIV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.cIY = (Button) findViewById(n.f.show_button);
        this.cIY.setOnClickListener(new g(this));
        this.cIX = (Button) findViewById(n.f.hide_button);
        this.cIX.setVisibility(0);
        this.cIX.setOnClickListener(new h(this));
        this.cIW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.image_activity_save_button, (View.OnClickListener) null);
        this.cIW.setOnClickListener(new i(this));
        this.cIW.setEnabled(false);
        ((TextView) this.cIW.findViewById(n.f.save)).setText(n.i.done);
        this.aUB = this.mNavigationBar.setTitleText(getPageContext().getString(n.i.beautify));
        if (EditHeadActivityConfig.FROM_PHOTO_LIVE.equals(this.cIT)) {
            this.aUB.setText(n.i.choose_picture);
        }
        this.cJn = (LinearLayout) findViewById(n.f.filters);
        this.cJj = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.cJf = (LinearLayout) findViewById(n.f.beautify_rotate);
        this.cJe = (LinearLayout) findViewById(n.f.rotate);
        this.cJc = (RadioButton) findViewById(n.f.beautify_btn);
        this.cJd = (RadioButton) findViewById(n.f.rotate_btn);
        k kVar = new k(this);
        this.cJc.setOnCheckedChangeListener(kVar);
        this.cJd.setOnCheckedChangeListener(kVar);
        this.cJc.setChecked(true);
        Button button = (Button) findViewById(n.f.rotate_left);
        Button button2 = (Button) findViewById(n.f.rotate_right);
        Button button3 = (Button) findViewById(n.f.rotate_left_right);
        Button button4 = (Button) findViewById(n.f.rotate_up_down);
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
    public void F(String str, boolean z) {
        if (this.cJb != null) {
            this.cJb.cancel();
        }
        this.cJb = new a(z);
        this.cJb.execute(str);
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
                Bitmap X = com.baidu.tbadk.core.util.n.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (X.getWidth() > 750 || X.getHeight() > 750) {
                        Bitmap d = com.baidu.tbadk.core.util.c.d(X, TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            X.recycle();
                            X = d;
                        } catch (Exception e) {
                            e = e;
                            bitmap = d;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cJl) {
                        return X;
                    }
                    Bitmap g = com.baidu.tbadk.core.util.c.g(X, dip2px);
                    Bitmap a = com.baidu.tbadk.core.util.c.a(g, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), X != g);
                    EditHeadActivity.this.cJp = new HashMap();
                    EditHeadActivity.this.cJq = new HashMap();
                    EditHeadActivity.this.cJp.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                    return X;
                } catch (Exception e2) {
                    bitmap = X;
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
            EditHeadActivity.this.cIW.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.cJa = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cIW.setClickable(true);
            EditHeadActivity.this.cIW.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.cJa = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cIW.setClickable(true);
            EditHeadActivity.this.cIW.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.cIU.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.cIU.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cJl) {
                    return;
                }
                EditHeadActivity.this.x(EditHeadActivity.cIS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.n.a(null, str, bitmap, 80);
            if (this.cJo) {
                new com.baidu.tbadk.core.util.ap("motu_pic", String.valueOf(this.cJk)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String[] strArr) {
        if (this.cJp != null && strArr != null) {
            this.cJn.removeAllViews();
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
                    imageView2.setOnClickListener(new m(this, substring, i2));
                    this.cJr = imageView2;
                } else {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                }
                this.cJn.addView(inflate2);
                if (this.cJq != null) {
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
            if (this.cJq == null) {
                this.cJq = new HashMap<>();
            }
            if (this.cJm != null && (imageView = this.cJq.get(this.cJm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cJj, this.cJj, this.cJj, this.cJj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.cJq.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(n.e.round_corner);
                imageView2.setPadding(this.cJj, this.cJj, this.cJj, this.cJj);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.cJm = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean cJu;
        private Boolean cJv = false;
        private Boolean cJw = false;
        private String mLabel;

        public a(boolean z) {
            this.cJu = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.cJu || zK()) {
                EditHeadActivity.this.mProgress.setVisibility(0);
                EditHeadActivity.this.cIW.setEnabled(false);
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
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.cJh == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cJv = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cJw = true;
            }
            if (!this.cJv.booleanValue() && !this.cJw.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.cJh == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.cJh.copy(EditHeadActivity.this.cJh.getConfig(), true);
            }
            if (this.cJv.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.h(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.cJw.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.c.j(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean zK() {
            PluginPackageManager.PluginStatus by = PluginPackageManager.lU().by(PluginCenter.NAME_MOTUSDK);
            if (by == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (by == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), n.i.plugin_config_not_found);
                return false;
            } else if (by == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lU().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (by == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), n.i.plugin_muto_not_install, new o(this), new p(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.cJh != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cIW.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mProgress.setVisibility(8);
            EditHeadActivity.this.cIW.setClickable(true);
            EditHeadActivity.this.cIW.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.cJo = true;
                if (this.cJv.booleanValue() || this.cJw.booleanValue()) {
                    EditHeadActivity.this.cIU.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.d(EditHeadActivity.this.mBitmap, TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.cJv.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.h(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cJw.booleanValue()) {
                        EditHeadActivity.this.mBitmap = com.baidu.tbadk.core.util.c.j(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.cIU.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.cJh != null && !EditHeadActivity.this.cJh.isRecycled()) {
                    EditHeadActivity.this.cJh.recycle();
                }
                EditHeadActivity.this.cJh = bitmap;
            }
        }
    }

    private void regReceiver() {
        this.cJi = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cJi, intentFilter);
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
            if (EditHeadActivity.this.cIW != null) {
                EditHeadActivity.this.cIW.setEnabled(false);
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
        private com.baidu.tbadk.core.util.ab agS;

        private d() {
            this.agS = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(n.i.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.agS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.agS.dn(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.agS.uM().vG().rf()) {
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
            EditHeadActivity.this.cJg = null;
            if (this.agS != null) {
                this.agS.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.agS != null) {
                if (this.agS.uM().vG().rf()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(n.i.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.agS.getErrorString());
            }
        }
    }
}
