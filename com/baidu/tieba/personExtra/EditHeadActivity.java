package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int faw;
    private String gwT;
    private ImageView gwW;
    private FrameLayout gwX;
    private View gwY;
    private View gwZ;
    private RadioButton gxg;
    private RadioButton gxh;
    private LinearLayout gxr;
    private HashMap<String, Bitmap> gxt;
    private HashMap<String, ImageView> gxu;
    private View gxv;
    private TextView gxw;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gwQ = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gwS = null;
    private float gwR = 1.0f;
    private EditHeadsImageView gwU = null;
    private EditHeadsImageTopLayerView gwV = null;
    private Bitmap mBitmap = null;
    private int fcV = 0;
    private Button gxa = null;
    private Button gxb = null;
    private HorizontalScrollView gxc = null;
    private com.baidu.tbadk.core.view.d gxd = null;
    private b gxe = null;
    private a gxf = null;
    private LinearLayout gxi = null;
    private LinearLayout gxj = null;
    private d gxk = null;
    private TextView mTitle = null;
    private Bitmap gxl = null;
    private c gxm = null;
    private int gxn = 0;
    private int gxo = 0;
    private boolean gxp = true;
    private String gxq = null;
    private boolean gxs = false;
    private boolean biO = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") == 1 || PluginPackageManager.nd().cd(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gxp = false;
        } else {
            this.gxp = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.fcV = intent.getIntExtra("edit_type", 0);
        this.faw = intent.getIntExtra("request", 0);
        this.biO = intent.getBooleanExtra("need_upload", true);
        this.gwR = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gwT = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.faw == 12002 || this.faw == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.faw, intent.getData(), aq.Ee().Ek());
            } else {
                TiebaPrepareImageService.StartService(this.faw, null, aq.Ee().Ek(), 0, stringExtra);
            }
            aOX();
        } else {
            initUI();
            initData();
        }
        gwS = getResources().getStringArray(e.b.fiter_name);
        if (this.gxp) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bqu();
    }

    private void bqu() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gwY);
        getLayoutMode().onModeChanged(this.gwZ);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.gxw, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gxe != null) {
            this.gxe.cancel();
        }
        this.gwU.setImageDrawable(null);
        bqv();
    }

    private void bqv() {
        if (this.gxu != null) {
            for (Map.Entry<String, ImageView> entry : this.gxu.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.gxu.clear();
            this.gxu = null;
        }
        if (this.gxt != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.gxt.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.gxt.clear();
            this.gxt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gxe != null) {
            this.gxe.cancel();
        }
        this.gxe = new b();
        this.gxe.execute(new Object[0]);
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
        this.gwU.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gxk != null) {
            this.gxk.cancel();
        }
        if (this.gxl != null && !this.gxl.isRecycled()) {
            this.gxl.recycle();
            this.gxl = null;
        }
        if (this.gxe != null) {
            this.gxe.cancel();
            this.gxe = null;
        }
        this.gxd.bB(false);
        if (this.faw == 12002 || this.faw == 12001) {
            unregisterReceiver(this.gxm);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqw() {
        if (this.gxk != null) {
            this.gxk.cancel();
        }
        this.gxk = new d();
        this.gxk.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gxd = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gxd.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gxd.bB(false);
            }
        });
        this.gxd.bB(false);
        this.gwV = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gwW = (ImageView) findViewById(e.g.preview_image);
        this.gwX = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gwX.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0210e.ds74)));
        this.gwU = (EditHeadsImageView) findViewById(e.g.image);
        this.gwU.setCutImageHeightScale(this.gwR);
        if (this.mBitmap != null) {
            this.gwU.setImageBitmap(this.mBitmap);
        }
        this.gwU.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gwX != null && EditHeadActivity.this.gwX.getVisibility() == 0) {
                    EditHeadActivity.this.gwW.setImageBitmap(EditHeadActivity.this.gwU.mf(false));
                }
            }
        });
        this.gwU.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gwX != null && EditHeadActivity.this.gwX.getVisibility() == 0) {
                    EditHeadActivity.this.gwW.setImageBitmap(EditHeadActivity.this.gwU.mf(false));
                }
            }
        });
        this.gxc = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gxb = (Button) findViewById(e.g.show_button);
        this.gxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gxj.setVisibility(0);
                EditHeadActivity.this.gxb.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gxp) {
                    EditHeadActivity.this.gxh.setPadding(0, EditHeadActivity.this.gxh.getPaddingTop(), EditHeadActivity.this.gxh.getPaddingRight(), EditHeadActivity.this.gxh.getPaddingBottom());
                    EditHeadActivity.this.gxh.setChecked(true);
                    EditHeadActivity.this.gxc.setVisibility(8);
                    EditHeadActivity.this.gxg.setVisibility(8);
                }
            }
        });
        this.gxa = (Button) findViewById(e.g.hide_button);
        this.gxa.setVisibility(0);
        this.gxa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gxj.setVisibility(8);
                EditHeadActivity.this.gxb.setVisibility(0);
            }
        });
        this.gwZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.fcV == 0) {
                    if (!EditHeadActivity.this.biO) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap mf = EditHeadActivity.this.gwU.mf(EditHeadActivity.this.fcV == 0 || EditHeadActivity.this.fcV == 3);
                if (mf != null && EditHeadActivity.this.e(str, mf)) {
                    if (EditHeadActivity.this.fcV == 0) {
                        if (EditHeadActivity.this.biO) {
                            EditHeadActivity.this.bqw();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.fc(str), "head");
                    aVar.NT();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(e.j.upload_pic_error, false);
                                } else {
                                    PhotoUrlData photoUrlData = new PhotoUrlData();
                                    photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                                    if (imageUploadResult.picInfo != null) {
                                        if (imageUploadResult.picInfo.bigPic != null) {
                                            photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                                        }
                                        if (imageUploadResult.picInfo.smallPic != null) {
                                            photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                                        }
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gwT)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.cD(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.uploading));
                }
            }
        });
        this.gwZ.setEnabled(false);
        this.gxw = (TextView) this.gwZ.findViewById(e.g.save);
        this.gxw.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gwT)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gwT)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.gxr = (LinearLayout) findViewById(e.g.filters);
        this.gxn = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gxj = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gxi = (LinearLayout) findViewById(e.g.rotate);
        this.gxg = (RadioButton) findViewById(e.g.beautify_btn);
        this.gxh = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gxg) {
                        EditHeadActivity.this.gxc.setVisibility(0);
                        EditHeadActivity.this.gxi.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gxh) {
                        EditHeadActivity.this.gxc.setVisibility(8);
                        EditHeadActivity.this.gxi.setVisibility(0);
                    }
                }
            }
        };
        this.gxg.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gxh.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gxg.setChecked(true);
        Button button = (Button) findViewById(e.g.rotate_left);
        Button button2 = (Button) findViewById(e.g.rotate_right);
        Button button3 = (Button) findViewById(e.g.rotate_left_right);
        Button button4 = (Button) findViewById(e.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.gxd.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gxl != null) && view.getTag() != null) {
                        EditHeadActivity.this.gxs = false;
                        EditHeadActivity.this.X(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gwT)) {
            this.gwX.setVisibility(0);
            this.gxb.setVisibility(8);
            this.gwV.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gwV.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str, boolean z) {
        if (this.gxf != null) {
            this.gxf.cancel();
        }
        this.gxf = new a(z);
        this.gxf.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap ay = com.baidu.tbadk.core.util.l.ay(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (ay.getWidth() > 1800 || ay.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ay, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            ay.recycle();
                            ay = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && ay != null && !ay.isRecycled()) {
                        ay.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gxp) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ay, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ay != resizedBitmap);
                        EditHeadActivity.this.gxt = new HashMap();
                        EditHeadActivity.this.gxu = new HashMap();
                        EditHeadActivity.this.gxt.put("normal", roundedCornerBitmap);
                    }
                    return ay;
                } catch (Exception e2) {
                    bitmap = ay;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gxd.bB(true);
            EditHeadActivity.this.gwZ.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gxe = null;
            EditHeadActivity.this.gxd.bB(false);
            EditHeadActivity.this.gwZ.setClickable(true);
            EditHeadActivity.this.gwZ.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gxe = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gxd.bB(false);
            EditHeadActivity.this.gwZ.setClickable(true);
            EditHeadActivity.this.gwZ.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gwU.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gwU.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gxp) {
                    EditHeadActivity.this.E(EditHeadActivity.gwS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gxs) {
                new ag("motu_pic", String.valueOf(this.gxo)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String[] strArr) {
        if (this.gxt != null && strArr != null) {
            this.gxr.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(e.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(e.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(e.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(e.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(FiltersView.ht(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gxd.isShowing()) {
                                EditHeadActivity.this.gwU.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gxs = false;
                                EditHeadActivity.this.tV(substring);
                                EditHeadActivity.this.gxo = i2;
                            }
                        }
                    });
                    this.gxv = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gxd.isShowing() && !substring.equals(EditHeadActivity.this.gxq)) {
                                EditHeadActivity.this.X(substring, true);
                                EditHeadActivity.this.tV(substring);
                                EditHeadActivity.this.gxo = i2;
                            }
                        }
                    });
                }
                this.gxr.addView(inflate2);
                if (this.gxu != null) {
                    this.gxu.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            tV("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gxu == null) {
                this.gxu = new HashMap<>();
            }
            if (this.gxq != null && (imageView = this.gxu.get(this.gxq)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gxn, this.gxn, this.gxn, this.gxn);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.gxu.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gxn, this.gxn, this.gxn, this.gxn);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gxq = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String gxA;
        private Boolean gxB = false;
        private Boolean gxC = false;
        private boolean gxz;

        public a(boolean z) {
            this.gxz = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.gxz || bqy()) {
                EditHeadActivity.this.gxd.bB(true);
                EditHeadActivity.this.gwZ.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gxA = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gxl == null) {
                return null;
            }
            if (this.gxA.equals("0") || this.gxA.equals("1")) {
                this.gxB = true;
            } else if (this.gxA.equals("2") || this.gxA.equals("3")) {
                this.gxC = true;
            }
            if (this.gxB.booleanValue() || this.gxC.booleanValue()) {
                if (EditHeadActivity.this.gxl != null) {
                    this.bitmap = EditHeadActivity.this.gxl.copy(EditHeadActivity.this.gxl.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gxB.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gxA));
            } else if (this.gxC.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gxA));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.gxA, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bqy() {
            PluginPackageManager.PluginStatus cd = PluginPackageManager.nd().cd(PluginCenter.NAME_MOTUSDK);
            if (cd == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (cd == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), e.j.plugin_config_not_found);
                return false;
            } else if (cd == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.nd().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (cd == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), e.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
                        aVar.dismiss();
                    }
                }, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gxl != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gxd.bB(false);
            EditHeadActivity.this.gwZ.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gxd.bB(false);
            EditHeadActivity.this.gwZ.setClickable(true);
            EditHeadActivity.this.gwZ.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gxs = true;
                if (this.gxB.booleanValue() || this.gxC.booleanValue()) {
                    EditHeadActivity.this.gwU.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gxB.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gxA));
                    } else if (this.gxC.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gxA));
                    }
                } else {
                    EditHeadActivity.this.gwU.j(bitmap);
                }
                if (EditHeadActivity.this.gxl != null && !EditHeadActivity.this.gxl.isRecycled()) {
                    EditHeadActivity.this.gxl.recycle();
                }
                EditHeadActivity.this.gxl = bitmap;
            }
        }
    }

    private void aOX() {
        this.gxm = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gxm, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EditHeadActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(intent.getStringExtra(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            if (EditHeadActivity.this.gwZ != null) {
                EditHeadActivity.this.gwZ.setEnabled(false);
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
    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.fM(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
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
            EditHeadActivity.this.gxk = null;
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(e.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
