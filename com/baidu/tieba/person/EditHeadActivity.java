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
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private String duA;
    private View duC;
    private View duD;
    private RadioButton duJ;
    private RadioButton duK;
    private LinearLayout duU;
    private HashMap<String, Bitmap> duW;
    private HashMap<String, ImageView> duX;
    private View duY;
    private TextView duZ;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String dux = "change";
    public static String FILE_NAME = "file_name";
    private static String[] duz = null;
    private float duy = 1.0f;
    private EditHeadsImageView duB = null;
    private Bitmap mBitmap = null;
    private int crw = 0;
    private Button duE = null;
    private Button duF = null;
    private HorizontalScrollView duG = null;
    private ProgressBar bDI = null;
    private b duH = null;
    private a duI = null;
    private LinearLayout duL = null;
    private LinearLayout duM = null;
    private d duN = null;
    private TextView aOG = null;
    private Bitmap duO = null;
    private c duP = null;
    private int duQ = 0;
    private int duR = 0;
    private boolean duS = true;
    private String duT = null;
    private boolean duV = false;
    private boolean azG = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.cS().Z("motu_sdk") == 1 || PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.duS = false;
        } else {
            this.duS = true;
        }
        TbadkCoreApplication.m11getInst().addRemoteActivity(this);
        setContentView(t.h.edit_head_activity);
        Intent intent = getIntent();
        this.crw = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.azG = intent.getBooleanExtra("need_upload", true);
        this.duy = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.duA = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            nq();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.az.ug().um());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.az.ug().um(), 0, stringExtra);
            }
            abM();
        } else {
            nq();
            initData();
        }
        duz = getResources().getStringArray(t.b.fiter_name);
        if (this.duS) {
            TbadkCoreApplication.m11getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        amd();
    }

    private void amd() {
        com.baidu.tbadk.core.util.at.l(this.mNavigationBar, t.d.alpha80_black);
        getLayoutMode().x(this.duC);
        getLayoutMode().x(this.duD);
        com.baidu.tbadk.core.util.at.c(this.aOG, t.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.at.a(this.mNavigationBar.getBackImageView(), t.f.icon_return_s, t.f.icon_return_s, 0);
        com.baidu.tbadk.core.util.at.c(this.duZ, t.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.duH != null) {
            this.duH.cancel();
        }
        this.duB.setImageDrawable(null);
        aBt();
    }

    private void aBt() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.duH != null) {
            this.duH.cancel();
        }
        this.duH = new b(this, null);
        this.duH.execute(new Object[0]);
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
        this.duB.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.duN != null) {
            this.duN.cancel();
        }
        if (this.duO != null && !this.duO.isRecycled()) {
            this.duO.recycle();
            this.duO = null;
        }
        if (this.duH != null) {
            this.duH.cancel();
            this.duH = null;
        }
        this.bDI.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.duP);
        }
        TbadkCoreApplication.m11getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.duN != null) {
            this.duN.cancel();
        }
        this.duN = new d(this, null);
        this.duN.execute(new String[0]);
    }

    private void nq() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
        this.bDI.setVisibility(8);
        this.duB = (EditHeadsImageView) findViewById(t.g.image);
        this.duB.setCutImageHeightScale(this.duy);
        if (this.mBitmap != null) {
            this.duB.setImageBitmap(this.mBitmap);
        }
        this.duG = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.duC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.duF = (Button) findViewById(t.g.show_button);
        this.duF.setOnClickListener(new g(this));
        this.duE = (Button) findViewById(t.g.hide_button);
        this.duE.setVisibility(0);
        this.duE.setOnClickListener(new h(this));
        this.duD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.duD.setOnClickListener(new i(this));
        this.duD.setEnabled(false);
        this.duZ = (TextView) this.duD.findViewById(t.g.save);
        this.duZ.setText(t.j.done);
        this.aOG = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        if ("from_photo_live".equals(this.duA)) {
            this.aOG.setText(t.j.choose_picture);
        }
        this.duU = (LinearLayout) findViewById(t.g.filters);
        this.duQ = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.duM = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.duL = (LinearLayout) findViewById(t.g.rotate);
        this.duJ = (RadioButton) findViewById(t.g.beautify_btn);
        this.duK = (RadioButton) findViewById(t.g.rotate_btn);
        k kVar = new k(this);
        this.duJ.setOnCheckedChangeListener(kVar);
        this.duK.setOnCheckedChangeListener(kVar);
        this.duJ.setChecked(true);
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
    public void H(String str, boolean z) {
        if (this.duI != null) {
            this.duI.cancel();
        }
        this.duI = new a(z);
        this.duI.execute(str);
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
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap Y = com.baidu.tbadk.core.util.m.Y(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (Y.getWidth() > 750 || Y.getHeight() > 750) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(Y, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            Y.recycle();
                            Y = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && Y != null && !Y.isRecycled()) {
                        Y.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.duS) {
                        return Y;
                    }
                    Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                    Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), Y != resizedBitmap);
                    EditHeadActivity.this.duW = new HashMap();
                    EditHeadActivity.this.duX = new HashMap();
                    EditHeadActivity.this.duW.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                    return Y;
                } catch (Exception e2) {
                    bitmap = Y;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.bDI.setVisibility(0);
            EditHeadActivity.this.duD.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.duH = null;
            EditHeadActivity.this.bDI.setVisibility(8);
            EditHeadActivity.this.duD.setClickable(true);
            EditHeadActivity.this.duD.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.duH = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.bDI.setVisibility(8);
            EditHeadActivity.this.duD.setClickable(true);
            EditHeadActivity.this.duD.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.duB.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.duB.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.duS) {
                    return;
                }
                EditHeadActivity.this.E(EditHeadActivity.duz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.m.a(null, str, bitmap, 80);
            if (this.duV) {
                new com.baidu.tbadk.core.util.aq("motu_pic", String.valueOf(this.duR)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.duW != null && strArr != null) {
            this.duU.removeAllViews();
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
                    imageView2.setOnClickListener(new m(this, substring, i2));
                    this.duY = imageView2;
                } else {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                }
                this.duU.addView(inflate2);
                if (this.duX != null) {
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
            if (this.duX == null) {
                this.duX = new HashMap<>();
            }
            if (this.duT != null && (imageView = this.duX.get(this.duT)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.duQ, this.duQ, this.duQ, this.duQ);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.duX.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(t.f.round_corner);
                imageView2.setPadding(this.duQ, this.duQ, this.duQ, this.duQ);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.duT = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean dvc;
        private Boolean dvd = false;
        private Boolean dve = false;
        private String mLabel;

        public a(boolean z) {
            this.dvc = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.dvc || zm()) {
                EditHeadActivity.this.bDI.setVisibility(0);
                EditHeadActivity.this.duD.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.duO == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.dvd = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.dve = true;
            }
            if (!this.dvd.booleanValue() && !this.dve.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.duO == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.duO.copy(EditHeadActivity.this.duO.getConfig(), true);
            }
            if (this.dvd.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.dve.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean zm() {
            PluginPackageManager.PluginStatus bs = PluginPackageManager.hF().bs(PluginCenter.NAME_MOTUSDK);
            if (bs == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bs == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), t.j.plugin_config_not_found);
                return false;
            } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.hF().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), t.j.plugin_muto_not_install, new o(this), new p(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.duO != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.bDI.setVisibility(8);
            EditHeadActivity.this.duD.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.bDI.setVisibility(8);
            EditHeadActivity.this.duD.setClickable(true);
            EditHeadActivity.this.duD.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.duV = true;
                if (this.dvd.booleanValue() || this.dve.booleanValue()) {
                    EditHeadActivity.this.duB.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.dvd.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.dve.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.duB.f(bitmap);
                }
                if (EditHeadActivity.this.duO != null && !EditHeadActivity.this.duO.isRecycled()) {
                    EditHeadActivity.this.duO.recycle();
                }
                EditHeadActivity.this.duO = bitmap;
            }
        }
    }

    private void abM() {
        this.duP = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.duP, intentFilter);
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
            if (EditHeadActivity.this.duD != null) {
                EditHeadActivity.this.duD.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PhotoUrlData photoUrlData) {
        Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
        intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
        getPageContext().getPageActivity().sendBroadcast(intent);
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
        private com.baidu.tbadk.core.util.ab aeI;

        private d() {
            this.aeI = null;
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.aeI = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.aeI.m13do(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aeI.tB().uw().nZ()) {
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
            EditHeadActivity.this.duN = null;
            if (this.aeI != null) {
                this.aeI.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eo */
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.aeI != null) {
                if (this.aeI.tB().uw().nZ()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(t.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.aeI.getErrorString());
            }
        }
    }
}
