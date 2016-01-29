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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private String cWD;
    private View cWF;
    private View cWG;
    private RadioButton cWM;
    private RadioButton cWN;
    private LinearLayout cWX;
    private HashMap<String, Bitmap> cWZ;
    private HashMap<String, ImageView> cXa;
    private View cXb;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String cWA = "change";
    public static String FILE_NAME = "file_name";
    private static String[] cWC = null;
    private float cWB = 1.0f;
    private EditHeadsImageView cWE = null;
    private Bitmap mBitmap = null;
    private int cfU = 0;
    private Button cWH = null;
    private Button cWI = null;
    private HorizontalScrollView cWJ = null;
    private ProgressBar aNo = null;
    private b cWK = null;
    private a cWL = null;
    private LinearLayout cWO = null;
    private LinearLayout cWP = null;
    private d cWQ = null;
    private TextView aPr = null;
    private Bitmap cWR = null;
    private c cWS = null;
    private int cWT = 0;
    private int cWU = 0;
    private boolean cWV = true;
    private String cWW = null;
    private boolean cWY = false;
    private boolean aCE = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gE().ai("motu_sdk") == 1 || PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.cWV = false;
        } else {
            this.cWV = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(t.h.edit_head_activity);
        Intent intent = getIntent();
        this.cfU = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.aCE = intent.getBooleanExtra("need_upload", true);
        this.cWB = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.cWD = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            qD();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.ax.wg().wm());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.ax.wg().wm(), 0, stringExtra);
            }
            Jq();
        } else {
            qD();
            initData();
        }
        cWC = getResources().getStringArray(t.b.fiter_name);
        if (this.cWV) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ar.l(this.mNavigationBar, t.d.alpha80_black);
        getLayoutMode().x(this.cWF);
        getLayoutMode().x(this.aPr);
        getLayoutMode().x(this.cWG);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.cWK != null) {
            this.cWK.cancel();
        }
        this.cWE.setImageDrawable(null);
        atn();
    }

    private void atn() {
        if (this.cXa != null) {
            for (Map.Entry<String, ImageView> entry : this.cXa.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.cXa.clear();
            this.cXa = null;
        }
        if (this.cWZ != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.cWZ.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.cWZ.clear();
            this.cWZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.cWK != null) {
            this.cWK.cancel();
        }
        this.cWK = new b(this, null);
        this.cWK.execute(new Object[0]);
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
        this.cWE.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.cWQ != null) {
            this.cWQ.cancel();
        }
        if (this.cWR != null && !this.cWR.isRecycled()) {
            this.cWR.recycle();
            this.cWR = null;
        }
        if (this.cWK != null) {
            this.cWK.cancel();
            this.cWK = null;
        }
        this.aNo.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.cWS);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ato() {
        if (this.cWQ != null) {
            this.cWQ.cancel();
        }
        this.cWQ = new d(this, null);
        this.cWQ.execute(new String[0]);
    }

    private void qD() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        this.aNo.setVisibility(8);
        this.cWE = (EditHeadsImageView) findViewById(t.g.image);
        this.cWE.setCutImageHeightScale(this.cWB);
        if (this.mBitmap != null) {
            this.cWE.setImageBitmap(this.mBitmap);
        }
        this.cWJ = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.cWF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.cWI = (Button) findViewById(t.g.show_button);
        this.cWI.setOnClickListener(new g(this));
        this.cWH = (Button) findViewById(t.g.hide_button);
        this.cWH.setVisibility(0);
        this.cWH.setOnClickListener(new h(this));
        this.cWG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.cWG.setOnClickListener(new i(this));
        this.cWG.setEnabled(false);
        ((TextView) this.cWG.findViewById(t.g.save)).setText(t.j.done);
        this.aPr = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        if (EditHeadActivityConfig.FROM_PHOTO_LIVE.equals(this.cWD)) {
            this.aPr.setText(t.j.choose_picture);
        }
        this.cWX = (LinearLayout) findViewById(t.g.filters);
        this.cWT = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.cWP = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.cWO = (LinearLayout) findViewById(t.g.rotate);
        this.cWM = (RadioButton) findViewById(t.g.beautify_btn);
        this.cWN = (RadioButton) findViewById(t.g.rotate_btn);
        k kVar = new k(this);
        this.cWM.setOnCheckedChangeListener(kVar);
        this.cWN.setOnCheckedChangeListener(kVar);
        this.cWM.setChecked(true);
        Button button = (Button) findViewById(t.g.rotate_left);
        Button button2 = (Button) findViewById(t.g.rotate_right);
        Button button3 = (Button) findViewById(t.g.rotate_left_right);
        Button button4 = (Button) findViewById(t.g.rotate_up_down);
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
        if (this.cWL != null) {
            this.cWL.cancel();
        }
        this.cWL = new a(z);
        this.cWL.execute(str);
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
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap W = com.baidu.tbadk.core.util.m.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (W.getWidth() > 750 || W.getHeight() > 750) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(W, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            W.recycle();
                            W = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cWV) {
                        return W;
                    }
                    Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(W, dip2px);
                    Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), W != resizedBitmap);
                    EditHeadActivity.this.cWZ = new HashMap();
                    EditHeadActivity.this.cXa = new HashMap();
                    EditHeadActivity.this.cWZ.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            EditHeadActivity.this.aNo.setVisibility(0);
            EditHeadActivity.this.cWG.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.cWK = null;
            EditHeadActivity.this.aNo.setVisibility(8);
            EditHeadActivity.this.cWG.setClickable(true);
            EditHeadActivity.this.cWG.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.cWK = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.aNo.setVisibility(8);
            EditHeadActivity.this.cWG.setClickable(true);
            EditHeadActivity.this.cWG.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.cWE.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.cWE.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.cWV) {
                    return;
                }
                EditHeadActivity.this.A(EditHeadActivity.cWC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.m.b(null, str, bitmap, 80);
            if (this.cWY) {
                new com.baidu.tbadk.core.util.ao("motu_pic", String.valueOf(this.cWU)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.cWZ != null && strArr != null) {
            this.cWX.removeAllViews();
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eC(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new m(this, substring, i2));
                    this.cXb = imageView2;
                } else {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                }
                this.cWX.addView(inflate2);
                if (this.cXa != null) {
                    this.cXa.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            kW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.cXa == null) {
                this.cXa = new HashMap<>();
            }
            if (this.cWW != null && (imageView = this.cXa.get(this.cWW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.cWT, this.cWT, this.cWT, this.cWT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.cXa.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(t.f.round_corner);
                imageView2.setPadding(this.cWT, this.cWT, this.cWT, this.cWT);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.cWW = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean cXe;
        private Boolean cXf = false;
        private Boolean cXg = false;
        private String mLabel;

        public a(boolean z) {
            this.cXe = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.cXe || AO()) {
                EditHeadActivity.this.aNo.setVisibility(0);
                EditHeadActivity.this.cWG.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.cWR == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.cXf = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.cXg = true;
            }
            if (!this.cXf.booleanValue() && !this.cXg.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.cWR == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.cWR.copy(EditHeadActivity.this.cWR.getConfig(), true);
            }
            if (this.cXf.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.cXg.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean AO() {
            PluginPackageManager.PluginStatus bB = PluginPackageManager.lD().bB(PluginCenter.NAME_MOTUSDK);
            if (bB == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bB == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), t.j.plugin_config_not_found);
                return false;
            } else if (bB == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lD().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bB == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), t.j.plugin_muto_not_install, new o(this), new p(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.cWR != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.aNo.setVisibility(8);
            EditHeadActivity.this.cWG.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.aNo.setVisibility(8);
            EditHeadActivity.this.cWG.setClickable(true);
            EditHeadActivity.this.cWG.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.cWY = true;
                if (this.cXf.booleanValue() || this.cXg.booleanValue()) {
                    EditHeadActivity.this.cWE.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.cXf.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.cXg.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.cWE.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.cWR != null && !EditHeadActivity.this.cWR.isRecycled()) {
                    EditHeadActivity.this.cWR.recycle();
                }
                EditHeadActivity.this.cWR = bitmap;
            }
        }
    }

    private void Jq() {
        this.cWS = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.cWS, intentFilter);
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
            if (EditHeadActivity.this.cWG != null) {
                EditHeadActivity.this.cWG.setEnabled(false);
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
        private com.baidu.tbadk.core.util.aa aiG;

        private d() {
            this.aiG = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(t.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.aiG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.aiG.dn(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiG.vB().ww().rl()) {
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
            EditHeadActivity.this.cWQ = null;
            if (this.aiG != null) {
                this.aiG.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.aiG != null) {
                if (this.aiG.vB().ww().rl()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(t.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.aiG.getErrorString());
            }
        }
    }
}
