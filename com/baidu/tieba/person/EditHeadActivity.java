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
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private String ecS;
    private View ecU;
    private View ecV;
    private RadioButton edb;
    private RadioButton edc;
    private LinearLayout edm;
    private HashMap<String, Bitmap> edo;
    private HashMap<String, ImageView> edp;
    private View edq;
    private TextView edr;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String ecP = "change";
    public static String FILE_NAME = "file_name";
    private static String[] ecR = null;
    private float ecQ = 1.0f;
    private EditHeadsImageView ecT = null;
    private Bitmap mBitmap = null;
    private int cWM = 0;
    private Button ecW = null;
    private Button ecX = null;
    private HorizontalScrollView ecY = null;
    private ProgressBar cbl = null;
    private b ecZ = null;
    private a eda = null;
    private LinearLayout edd = null;
    private LinearLayout ede = null;
    private d edf = null;
    private TextView aSd = null;
    private Bitmap edg = null;
    private c edh = null;
    private int edi = 0;
    private int edj = 0;
    private boolean edk = true;
    private String edl = null;
    private boolean edn = false;
    private boolean aAy = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.cT().Z("motu_sdk") == 1 || PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.edk = false;
        } else {
            this.edk = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity(this);
        setContentView(u.h.edit_head_activity);
        Intent intent = getIntent();
        this.cWM = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.aAy = intent.getBooleanExtra("need_upload", true);
        this.ecQ = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.ecS = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            nl();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bb.uf().ul());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bb.uf().ul(), 0, stringExtra);
            }
            ajY();
        } else {
            nl();
            initData();
        }
        ecR = getResources().getStringArray(u.b.fiter_name);
        if (this.edk) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aup();
    }

    private void aup() {
        com.baidu.tbadk.core.util.av.l(this.mNavigationBar, u.d.common_color_10222);
        getLayoutMode().w(this.ecU);
        getLayoutMode().w(this.ecV);
        com.baidu.tbadk.core.util.av.c(this.aSd, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.a(this.mNavigationBar.getBackImageView(), u.f.icon_return_s, u.f.icon_return_s, 0);
        com.baidu.tbadk.core.util.av.c(this.edr, u.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ecZ != null) {
            this.ecZ.cancel();
        }
        this.ecT.setImageDrawable(null);
        aKl();
    }

    private void aKl() {
        if (this.edp != null) {
            for (Map.Entry<String, ImageView> entry : this.edp.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.edp.clear();
            this.edp = null;
        }
        if (this.edo != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.edo.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.edo.clear();
            this.edo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ecZ != null) {
            this.ecZ.cancel();
        }
        this.ecZ = new b(this, null);
        this.ecZ.execute(new Object[0]);
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
        this.ecT.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.edf != null) {
            this.edf.cancel();
        }
        if (this.edg != null && !this.edg.isRecycled()) {
            this.edg.recycle();
            this.edg = null;
        }
        if (this.ecZ != null) {
            this.ecZ.cancel();
            this.ecZ = null;
        }
        this.cbl.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.edh);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKm() {
        if (this.edf != null) {
            this.edf.cancel();
        }
        this.edf = new d(this, null);
        this.edf.execute(new String[0]);
    }

    private void nl() {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.navigation_bar);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        this.cbl.setVisibility(8);
        this.ecT = (EditHeadsImageView) findViewById(u.g.image);
        this.ecT.setCutImageHeightScale(this.ecQ);
        if (this.mBitmap != null) {
            this.ecT.setImageBitmap(this.mBitmap);
        }
        this.ecY = (HorizontalScrollView) findViewById(u.g.filters_layout);
        this.ecU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.ecX = (Button) findViewById(u.g.show_button);
        this.ecX.setOnClickListener(new h(this));
        this.ecW = (Button) findViewById(u.g.hide_button);
        this.ecW.setVisibility(0);
        this.ecW.setOnClickListener(new i(this));
        this.ecV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.image_activity_save_button, (View.OnClickListener) null);
        this.ecV.setOnClickListener(new j(this));
        this.ecV.setEnabled(false);
        this.edr = (TextView) this.ecV.findViewById(u.g.save);
        this.edr.setText(u.j.done);
        this.aSd = this.mNavigationBar.setTitleText(getPageContext().getString(u.j.beautify));
        if ("from_photo_live".equals(this.ecS)) {
            this.aSd.setText(u.j.choose_picture);
        }
        this.edm = (LinearLayout) findViewById(u.g.filters);
        this.edi = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.ede = (LinearLayout) findViewById(u.g.beautify_rotate);
        this.edd = (LinearLayout) findViewById(u.g.rotate);
        this.edb = (RadioButton) findViewById(u.g.beautify_btn);
        this.edc = (RadioButton) findViewById(u.g.rotate_btn);
        l lVar = new l(this);
        this.edb.setOnCheckedChangeListener(lVar);
        this.edc.setOnCheckedChangeListener(lVar);
        this.edb.setChecked(true);
        Button button = (Button) findViewById(u.g.rotate_left);
        Button button2 = (Button) findViewById(u.g.rotate_right);
        Button button3 = (Button) findViewById(u.g.rotate_left_right);
        Button button4 = (Button) findViewById(u.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        m mVar = new m(this);
        button.setOnClickListener(mVar);
        button2.setOnClickListener(mVar);
        button3.setOnClickListener(mVar);
        button4.setOnClickListener(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, boolean z) {
        if (this.eda != null) {
            this.eda.cancel();
        }
        this.eda = new a(z);
        this.eda.execute(str);
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
                Bitmap X = com.baidu.tbadk.core.util.m.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (X.getWidth() > 750 || X.getHeight() > 750) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(X, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            X.recycle();
                            X = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.edk) {
                        return X;
                    }
                    Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                    Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), X != resizedBitmap);
                    EditHeadActivity.this.edo = new HashMap();
                    EditHeadActivity.this.edp = new HashMap();
                    EditHeadActivity.this.edo.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            EditHeadActivity.this.cbl.setVisibility(0);
            EditHeadActivity.this.ecV.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.ecZ = null;
            EditHeadActivity.this.cbl.setVisibility(8);
            EditHeadActivity.this.ecV.setClickable(true);
            EditHeadActivity.this.ecV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.ecZ = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.cbl.setVisibility(8);
            EditHeadActivity.this.ecV.setClickable(true);
            EditHeadActivity.this.ecV.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.ecT.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.ecT.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.edk) {
                    return;
                }
                EditHeadActivity.this.E(EditHeadActivity.ecR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.m.a(null, str, bitmap, 80);
            if (this.edn) {
                new com.baidu.tbadk.core.util.ar("motu_pic", String.valueOf(this.edj)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.edo != null && strArr != null) {
            this.edm.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(u.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(u.g.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(u.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(u.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.c.eK(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new n(this, substring, i2));
                    this.edq = imageView2;
                } else {
                    imageView2.setOnClickListener(new o(this, substring, i2));
                }
                this.edm.addView(inflate2);
                if (this.edp != null) {
                    this.edp.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            nT(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nT(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.edp == null) {
                this.edp = new HashMap<>();
            }
            if (this.edl != null && (imageView = this.edp.get(this.edl)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.edi, this.edi, this.edi, this.edi);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.edp.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(u.f.round_corner);
                imageView2.setPadding(this.edi, this.edi, this.edi, this.edi);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.edl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean edu;
        private Boolean edv = false;
        private Boolean edw = false;
        private String mLabel;

        public a(boolean z) {
            this.edu = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.edu || zr()) {
                EditHeadActivity.this.cbl.setVisibility(0);
                EditHeadActivity.this.ecV.setEnabled(false);
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
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.edg == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.edv = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.edw = true;
            }
            if (!this.edv.booleanValue() && !this.edw.booleanValue()) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else if (EditHeadActivity.this.edg == null) {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = EditHeadActivity.this.edg.copy(EditHeadActivity.this.edg.getConfig(), true);
            }
            if (this.edv.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.edw.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean zr() {
            PluginPackageManager.PluginStatus bs = PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK);
            if (bs == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bs == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), u.j.plugin_config_not_found);
                return false;
            } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.hH().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.e.a.a(EditHeadActivity.this.getPageContext(), u.j.plugin_muto_not_install, new p(this), new q(this));
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.edg != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.cbl.setVisibility(8);
            EditHeadActivity.this.ecV.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.cbl.setVisibility(8);
            EditHeadActivity.this.ecV.setClickable(true);
            EditHeadActivity.this.ecV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.edn = true;
                if (this.edv.booleanValue() || this.edw.booleanValue()) {
                    EditHeadActivity.this.ecT.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 750 || EditHeadActivity.this.mBitmap.getHeight() > 750) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.edv.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.edw.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.ecT.f(bitmap);
                }
                if (EditHeadActivity.this.edg != null && !EditHeadActivity.this.edg.isRecycled()) {
                    EditHeadActivity.this.edg.recycle();
                }
                EditHeadActivity.this.edg = bitmap;
            }
        }
    }

    private void ajY() {
        this.edh = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.edh, intentFilter);
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
            if (EditHeadActivity.this.ecV != null) {
                EditHeadActivity.this.ecV.setEnabled(false);
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
        private com.baidu.tbadk.core.util.ab afj;

        private d() {
            this.afj = null;
        }

        /* synthetic */ d(EditHeadActivity editHeadActivity, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(u.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.afj = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.afj.dm(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.afj.ty().uv().nU()) {
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
            EditHeadActivity.this.edf = null;
            if (this.afj != null) {
                this.afj.dm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.afj != null) {
                if (this.afj.ty().uv().nU()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(u.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.afj.getErrorString());
            }
        }
    }
}
