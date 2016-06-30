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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] ecR = null;
    private RadioButton edb;
    private RadioButton edc;
    private LinearLayout edm;
    private HashMap<String, Bitmap> edo;
    private HashMap<String, ImageView> edp;
    private View edq;
    private View fJG;
    private View fJH;
    private String fJL;
    private int requestCode;
    private ImageView aMe = null;
    private Bitmap mBitmap = null;
    private TextView fHG = null;
    private View Do = null;
    private HorizontalScrollView ecY = null;
    private ProgressBar cbl = null;
    private b fJI = null;
    private a fJJ = null;
    private RadioGroup EH = null;
    private LinearLayout edd = null;
    private LinearLayout ede = null;
    private TextView Dj = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap edg = null;
    private c fJK = null;
    private int edi = 0;
    private int edj = 0;
    private int mDisplaySize = 0;
    private boolean edk = true;
    private String edl = null;
    private boolean edn = false;
    private boolean dQZ = false;
    private final Handler mHandler = new Handler();
    private final Object fJM = new Object();
    private final View.OnClickListener fJN = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.c.e.cT().Z("motu_sdk") == 1 || PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.edk = false;
        } else {
            this.edk = true;
        }
        TbadkCoreApplication.m9getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(u.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.fJL = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.edk) {
            TbadkCoreApplication.m9getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.dQZ = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            nl();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), com.baidu.tbadk.core.util.bb.uf().ul(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, com.baidu.tbadk.core.util.bb.uf().ul(), this.mDisplaySize, stringExtra);
            }
            ajY();
        } else {
            nl();
            initData();
        }
        ecR = getResources().getStringArray(u.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fJI != null) {
            this.fJI.cancel();
        }
        this.aMe.setImageDrawable(null);
        aKl();
    }

    private void aKl() {
        synchronized (this.fJM) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fJI != null) {
            this.fJI.cancel();
        }
        this.fJI = new b(this, null);
        this.fJI.execute(new Object[0]);
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
        if (this.edg != null && !this.edg.isRecycled()) {
            this.edg.recycle();
            this.edg = null;
        }
        if (this.fJI != null) {
            this.fJI.cancel();
            this.fJI = null;
        }
        this.cbl.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.fJK);
        }
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.fJN.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.Do);
        com.baidu.tbadk.core.util.av.l(this.mNavigationBar, u.d.common_color_10222);
        com.baidu.tbadk.core.util.av.c(this.Dj, u.d.cp_cont_g, 1);
        if (this.fJH.isEnabled()) {
            this.fHG.setTextColor(getResources().getColor(u.d.navi_done_text));
        } else {
            this.fHG.setTextColor(getResources().getColor(u.d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        com.baidu.tbadk.core.util.av.a((ImageView) ((ViewGroup) this.fJG).getChildAt(0), u.f.icon_return_s, u.f.icon_return_s);
    }

    private void nl() {
        this.Do = findViewById(u.g.write_image_root_layout);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        this.cbl.setVisibility(8);
        this.aMe = (ImageView) findViewById(u.g.image);
        this.aMe.setOnClickListener(new bo(this));
        if (this.mBitmap != null) {
            this.aMe.setImageBitmap(this.mBitmap);
        }
        this.ecY = (HorizontalScrollView) findViewById(u.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.fJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bp(this));
        this.fJH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.image_activity_save_button, (View.OnClickListener) null);
        this.fJH.setOnClickListener(new bq(this));
        this.fHG = (TextView) this.fJH.findViewById(u.g.save);
        if (TextUtils.isEmpty(this.fJL)) {
            if (this.dQZ || this.requestCode != 12003) {
                this.fHG.setText(getPageContext().getString(u.j.done));
            } else {
                this.fHG.setText(getPageContext().getString(u.j.delete));
            }
        } else {
            this.fHG.setText(this.fJL);
        }
        this.edm = (LinearLayout) findViewById(u.g.filters);
        this.edi = com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Dj = this.mNavigationBar.setTitleText(getPageContext().getString(u.j.beautify));
        this.ede = (LinearLayout) findViewById(u.g.beautify_rotate);
        this.edd = (LinearLayout) findViewById(u.g.rotate);
        this.edb = (RadioButton) findViewById(u.g.beautify_btn);
        this.edc = (RadioButton) findViewById(u.g.rotate_btn);
        this.EH = (RadioGroup) findViewById(u.g.beautify_tabs);
        br brVar = new br(this);
        this.edb.setOnCheckedChangeListener(brVar);
        this.edc.setOnCheckedChangeListener(brVar);
        this.edb.setChecked(true);
        Button button = (Button) findViewById(u.g.rotate_left);
        Button button2 = (Button) findViewById(u.g.rotate_right);
        Button button3 = (Button) findViewById(u.g.rotate_left_right);
        Button button4 = (Button) findViewById(u.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bs bsVar = new bs(this);
        button.setOnClickListener(bsVar);
        button2.setOnClickListener(bsVar);
        button3.setOnClickListener(bsVar);
        button4.setOnClickListener(bsVar);
        this.ede.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.edk) {
            this.edc.setPadding(0, this.edc.getPaddingTop(), this.edc.getPaddingRight(), this.edc.getPaddingBottom());
            this.edc.setChecked(true);
            this.ecY.setVisibility(8);
            this.edb.setVisibility(8);
            this.EH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(String str) {
        if (this.fJJ != null) {
            this.fJJ.cancel();
        }
        this.fJJ = new a(this, null);
        this.fJJ.execute(str);
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
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap X = com.baidu.tbadk.core.util.m.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    if (X != null) {
                        int dip2px = com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.edk) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.fJM) {
                                        WriteImageActivity.this.edo = new HashMap();
                                        WriteImageActivity.this.edp = new HashMap();
                                        WriteImageActivity.this.edo.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
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
            WriteImageActivity.this.cbl.setVisibility(0);
            WriteImageActivity.this.fJH.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.fJI = null;
            WriteImageActivity.this.cbl.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.fJH.setEnabled(true);
            WriteImageActivity.this.fJI = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.cbl.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.aMe.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.edk) {
                    return;
                }
                WriteImageActivity.this.E(WriteImageActivity.ecR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rd(String str) {
        try {
            com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_PIC_DIR, str, this.edg, 90);
            this.aMe.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.edg, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.edj));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.edo != null && strArr != null) {
            this.edm.removeAllViews();
            this.ede.setVisibility(0);
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
                    imageView2.setOnClickListener(new bt(this, substring, i2));
                    this.edq = imageView2;
                } else {
                    imageView2.setOnClickListener(new bu(this, substring, i2));
                }
                this.edm.addView(inflate2);
                synchronized (this.fJM) {
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
            if (this.edl != null && (imageView = this.edp.get(this.edl)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.edi, this.edi, this.edi, this.edi);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.edp != null) {
                ImageView imageView2 = this.edp.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(u.f.bg_choose_filter);
                    imageView2.setPadding(this.edi, this.edi, this.edi, this.edi);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.edl = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean edv;
        private Boolean edw;
        private String mLabel;

        private a() {
            this.edv = false;
            this.edw = false;
        }

        /* synthetic */ a(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.edk) {
                PluginPackageManager.PluginStatus bs = PluginPackageManager.hH().bs(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bs != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bs == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new bv(this), 500L);
                        WriteImageActivity.this.showToast(u.j.plugin_config_not_found);
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.hH().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new bw(this), 500L);
                        cancel();
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.e.a.a(WriteImageActivity.this.getPageContext(), u.j.plugin_muto_not_install, new bx(this), new by(this));
                        WriteImageActivity.this.mHandler.postDelayed(new bz(this), 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.cbl.setVisibility(0);
            WriteImageActivity.this.fJH.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.edg == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.edv = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.edw = true;
            }
            if (!this.edv.booleanValue() && !this.edw.booleanValue()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else if (WriteImageActivity.this.edg == null || WriteImageActivity.this.edg.isRecycled()) {
                if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                    this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = WriteImageActivity.this.edg.copy(WriteImageActivity.this.edg.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.edv.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.edw.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.edg != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.cbl.setVisibility(8);
            WriteImageActivity.this.fJH.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.cbl.setVisibility(8);
            WriteImageActivity.this.fJH.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.edn = true;
                WriteImageActivity.this.aMe.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.edv.booleanValue() || this.edw.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.edv.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.edw.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.edg != null && !WriteImageActivity.this.edg.isRecycled()) {
                    WriteImageActivity.this.edg.recycle();
                }
                WriteImageActivity.this.edg = bitmap;
            }
        }
    }

    private void ajY() {
        this.fJK = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fJK, intentFilter);
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
            if (WriteImageActivity.this.fJH != null) {
                WriteImageActivity.this.fJH.setEnabled(false);
            }
        }
    }
}
