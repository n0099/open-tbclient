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
    private HashMap<String, Bitmap> drB;
    private HashMap<String, ImageView> drC;
    private View drD;
    private String drf;
    private View drh;
    private View dri;
    private RadioButton dro;
    private RadioButton drp;
    private LinearLayout drz;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String drc = "change";
    public static String FILE_NAME = "file_name";
    private static String[] dre = null;
    private float drd = 1.0f;
    private EditHeadsImageView drg = null;
    private Bitmap mBitmap = null;
    private int cqz = 0;
    private Button drj = null;
    private Button drk = null;
    private HorizontalScrollView drl = null;
    private ProgressBar aQj = null;
    private b drm = null;
    private a drn = null;
    private LinearLayout drq = null;
    private LinearLayout drr = null;
    private d drs = null;
    private TextView aSh = null;
    private Bitmap drt = null;
    private c dru = null;
    private int drv = 0;
    private int drw = 0;
    private boolean drx = true;
    private String dry = null;
    private boolean drA = false;
    private boolean aDC = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.gE().ai("motu_sdk") == 1 || PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.drx = false;
        } else {
            this.drx = true;
        }
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(t.h.edit_head_activity);
        Intent intent = getIntent();
        this.cqz = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.aDC = intent.getBooleanExtra("need_upload", true);
        this.drd = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.drf = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            pU();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.az.wz().wF());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.az.wz().wF(), 0, stringExtra);
            }
            KL();
        } else {
            pU();
            initData();
        }
        dre = getResources().getStringArray(t.b.fiter_name);
        if (this.drx) {
            TbadkCoreApplication.m411getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.at.l(this.mNavigationBar, t.d.alpha80_black);
        getLayoutMode().x(this.drh);
        getLayoutMode().x(this.aSh);
        getLayoutMode().x(this.dri);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.drm != null) {
            this.drm.cancel();
        }
        this.drg.setImageDrawable(null);
        aAT();
    }

    private void aAT() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.drm != null) {
            this.drm.cancel();
        }
        this.drm = new b(this, null);
        this.drm.execute(new Object[0]);
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
        this.drg.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.drs != null) {
            this.drs.cancel();
        }
        if (this.drt != null && !this.drt.isRecycled()) {
            this.drt.recycle();
            this.drt = null;
        }
        if (this.drm != null) {
            this.drm.cancel();
            this.drm = null;
        }
        this.aQj.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.dru);
        }
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAU() {
        if (this.drs != null) {
            this.drs.cancel();
        }
        this.drs = new d(this, null);
        this.drs.execute(new String[0]);
    }

    private void pU() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        this.aQj.setVisibility(8);
        this.drg = (EditHeadsImageView) findViewById(t.g.image);
        this.drg.setCutImageHeightScale(this.drd);
        if (this.mBitmap != null) {
            this.drg.setImageBitmap(this.mBitmap);
        }
        this.drl = (HorizontalScrollView) findViewById(t.g.filters_layout);
        this.drh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.drk = (Button) findViewById(t.g.show_button);
        this.drk.setOnClickListener(new g(this));
        this.drj = (Button) findViewById(t.g.hide_button);
        this.drj.setVisibility(0);
        this.drj.setOnClickListener(new h(this));
        this.dri = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.dri.setOnClickListener(new i(this));
        this.dri.setEnabled(false);
        ((TextView) this.dri.findViewById(t.g.save)).setText(t.j.done);
        this.aSh = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.beautify));
        if ("from_photo_live".equals(this.drf)) {
            this.aSh.setText(t.j.choose_picture);
        }
        this.drz = (LinearLayout) findViewById(t.g.filters);
        this.drv = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.drr = (LinearLayout) findViewById(t.g.beautify_rotate);
        this.drq = (LinearLayout) findViewById(t.g.rotate);
        this.dro = (RadioButton) findViewById(t.g.beautify_btn);
        this.drp = (RadioButton) findViewById(t.g.rotate_btn);
        k kVar = new k(this);
        this.dro.setOnCheckedChangeListener(kVar);
        this.drp.setOnCheckedChangeListener(kVar);
        this.dro.setChecked(true);
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
    public void F(String str, boolean z) {
        if (this.drn != null) {
            this.drn.cancel();
        }
        this.drn = new a(z);
        this.drn.execute(str);
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
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.drx) {
                        return Y;
                    }
                    Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                    Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), Y != resizedBitmap);
                    EditHeadActivity.this.drB = new HashMap();
                    EditHeadActivity.this.drC = new HashMap();
                    EditHeadActivity.this.drB.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            EditHeadActivity.this.aQj.setVisibility(0);
            EditHeadActivity.this.dri.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.drm = null;
            EditHeadActivity.this.aQj.setVisibility(8);
            EditHeadActivity.this.dri.setClickable(true);
            EditHeadActivity.this.dri.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.drm = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.aQj.setVisibility(8);
            EditHeadActivity.this.dri.setClickable(true);
            EditHeadActivity.this.dri.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.drg.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.drg.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.drx) {
                    return;
                }
                EditHeadActivity.this.C(EditHeadActivity.dre);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.m.b(null, str, bitmap, 80);
            if (this.drA) {
                new com.baidu.tbadk.core.util.aq("motu_pic", String.valueOf(this.drw)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String[] strArr) {
        if (this.drB != null && strArr != null) {
            this.drz.removeAllViews();
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
                    imageView2.setOnClickListener(new m(this, substring, i2));
                    this.drD = imageView2;
                } else {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                }
                this.drz.addView(inflate2);
                if (this.drC != null) {
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
            if (this.drC == null) {
                this.drC = new HashMap<>();
            }
            if (this.dry != null && (imageView = this.drC.get(this.dry)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.drv, this.drv, this.drv, this.drv);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.drC.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(t.f.round_corner);
                imageView2.setPadding(this.drv, this.drv, this.drv, this.drv);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.dry = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean drG;
        private Boolean drH = false;
        private Boolean drI = false;
        private String mLabel;

        public a(boolean z) {
            this.drG = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.drG || Br()) {
                EditHeadActivity.this.aQj.setVisibility(0);
                EditHeadActivity.this.dri.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.drt == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.drH = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.drI = true;
            }
            if (!this.drH.booleanValue() && !this.drI.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.drt == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.drt.copy(EditHeadActivity.this.drt.getConfig(), true);
            }
            if (this.drH.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.drI.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean Br() {
            PluginPackageManager.PluginStatus bz = PluginPackageManager.ls().bz(PluginCenter.NAME_MOTUSDK);
            if (bz == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bz == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), t.j.plugin_config_not_found);
                return false;
            } else if (bz == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.ls().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bz == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), t.j.plugin_muto_not_install, new o(this), new p(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.drt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.aQj.setVisibility(8);
            EditHeadActivity.this.dri.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.aQj.setVisibility(8);
            EditHeadActivity.this.dri.setClickable(true);
            EditHeadActivity.this.dri.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.drA = true;
                if (this.drH.booleanValue() || this.drI.booleanValue()) {
                    EditHeadActivity.this.drg.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.drH.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.drI.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.drg.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.drt != null && !EditHeadActivity.this.drt.isRecycled()) {
                    EditHeadActivity.this.drt.recycle();
                }
                EditHeadActivity.this.drt = bitmap;
            }
        }
    }

    private void KL() {
        this.dru = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.dru, intentFilter);
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
            if (EditHeadActivity.this.dri != null) {
                EditHeadActivity.this.dri.setEnabled(false);
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
        private com.baidu.tbadk.core.util.ab aiW;

        private d() {
            this.aiW = null;
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
            this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.aiW.dr(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.aiW.vU().wP().qC()) {
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
            EditHeadActivity.this.drs = null;
            if (this.aiW != null) {
                this.aiW.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.aiW != null) {
                if (this.aiW.vU().wP().qC()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(t.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.aiW.getErrorString());
            }
        }
    }
}
