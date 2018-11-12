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
    private int eQd;
    private LinearLayout gmG;
    private HashMap<String, Bitmap> gmI;
    private HashMap<String, ImageView> gmJ;
    private View gmK;
    private TextView gmL;
    private String gmi;
    private ImageView gml;
    private FrameLayout gmm;
    private View gmn;
    private View gmo;
    private RadioButton gmv;
    private RadioButton gmw;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gmf = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gmh = null;
    private float gmg = 1.0f;
    private EditHeadsImageView gmj = null;
    private EditHeadsImageTopLayerView gmk = null;
    private Bitmap mBitmap = null;
    private int eSC = 0;
    private Button gmp = null;
    private Button gmq = null;
    private HorizontalScrollView gmr = null;
    private com.baidu.tbadk.core.view.d gms = null;
    private b gmt = null;
    private a gmu = null;
    private LinearLayout gmx = null;
    private LinearLayout gmy = null;
    private d gmz = null;
    private TextView mTitle = null;
    private Bitmap gmA = null;
    private c gmB = null;
    private int gmC = 0;
    private int gmD = 0;
    private boolean gmE = true;
    private String gmF = null;
    private boolean gmH = false;
    private boolean beB = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") == 1 || PluginPackageManager.nb().cc(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gmE = false;
        } else {
            this.gmE = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.eSC = intent.getIntExtra("edit_type", 0);
        this.eQd = intent.getIntExtra("request", 0);
        this.beB = intent.getBooleanExtra("need_upload", true);
        this.gmg = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gmi = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.eQd == 12002 || this.eQd == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eQd, intent.getData(), aq.CN().CT());
            } else {
                TiebaPrepareImageService.StartService(this.eQd, null, aq.CN().CT(), 0, stringExtra);
            }
            aLS();
        } else {
            initUI();
            initData();
        }
        gmh = getResources().getStringArray(e.b.fiter_name);
        if (this.gmE) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bnh();
    }

    private void bnh() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gmn);
        getLayoutMode().onModeChanged(this.gmo);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.gmL, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gmt != null) {
            this.gmt.cancel();
        }
        this.gmj.setImageDrawable(null);
        bni();
    }

    private void bni() {
        if (this.gmJ != null) {
            for (Map.Entry<String, ImageView> entry : this.gmJ.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.gmJ.clear();
            this.gmJ = null;
        }
        if (this.gmI != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.gmI.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.gmI.clear();
            this.gmI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gmt != null) {
            this.gmt.cancel();
        }
        this.gmt = new b();
        this.gmt.execute(new Object[0]);
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
        this.gmj.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gmz != null) {
            this.gmz.cancel();
        }
        if (this.gmA != null && !this.gmA.isRecycled()) {
            this.gmA.recycle();
            this.gmA = null;
        }
        if (this.gmt != null) {
            this.gmt.cancel();
            this.gmt = null;
        }
        this.gms.bz(false);
        if (this.eQd == 12002 || this.eQd == 12001) {
            unregisterReceiver(this.gmB);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.gmz != null) {
            this.gmz.cancel();
        }
        this.gmz = new d();
        this.gmz.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gms = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gms.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gms.bz(false);
            }
        });
        this.gms.bz(false);
        this.gmk = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gml = (ImageView) findViewById(e.g.preview_image);
        this.gmm = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gmm.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0200e.ds74)));
        this.gmj = (EditHeadsImageView) findViewById(e.g.image);
        this.gmj.setCutImageHeightScale(this.gmg);
        if (this.mBitmap != null) {
            this.gmj.setImageBitmap(this.mBitmap);
        }
        this.gmj.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gmm != null && EditHeadActivity.this.gmm.getVisibility() == 0) {
                    EditHeadActivity.this.gml.setImageBitmap(EditHeadActivity.this.gmj.lZ(false));
                }
            }
        });
        this.gmj.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gmm != null && EditHeadActivity.this.gmm.getVisibility() == 0) {
                    EditHeadActivity.this.gml.setImageBitmap(EditHeadActivity.this.gmj.lZ(false));
                }
            }
        });
        this.gmr = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gmn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gmq = (Button) findViewById(e.g.show_button);
        this.gmq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gmy.setVisibility(0);
                EditHeadActivity.this.gmq.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gmE) {
                    EditHeadActivity.this.gmw.setPadding(0, EditHeadActivity.this.gmw.getPaddingTop(), EditHeadActivity.this.gmw.getPaddingRight(), EditHeadActivity.this.gmw.getPaddingBottom());
                    EditHeadActivity.this.gmw.setChecked(true);
                    EditHeadActivity.this.gmr.setVisibility(8);
                    EditHeadActivity.this.gmv.setVisibility(8);
                }
            }
        });
        this.gmp = (Button) findViewById(e.g.hide_button);
        this.gmp.setVisibility(0);
        this.gmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gmy.setVisibility(8);
                EditHeadActivity.this.gmq.setVisibility(0);
            }
        });
        this.gmo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gmo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eSC == 0) {
                    if (!EditHeadActivity.this.beB) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lZ = EditHeadActivity.this.gmj.lZ(EditHeadActivity.this.eSC == 0 || EditHeadActivity.this.eSC == 3);
                if (lZ != null && EditHeadActivity.this.c(str, lZ)) {
                    if (EditHeadActivity.this.eSC == 0) {
                        if (EditHeadActivity.this.beB) {
                            EditHeadActivity.this.bnj();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.eB(str), "head");
                    aVar.Mx();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gmi)) {
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
                    aVar.cz(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.uploading));
                }
            }
        });
        this.gmo.setEnabled(false);
        this.gmL = (TextView) this.gmo.findViewById(e.g.save);
        this.gmL.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gmi)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gmi)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.gmG = (LinearLayout) findViewById(e.g.filters);
        this.gmC = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gmy = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gmx = (LinearLayout) findViewById(e.g.rotate);
        this.gmv = (RadioButton) findViewById(e.g.beautify_btn);
        this.gmw = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gmv) {
                        EditHeadActivity.this.gmr.setVisibility(0);
                        EditHeadActivity.this.gmx.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gmw) {
                        EditHeadActivity.this.gmr.setVisibility(8);
                        EditHeadActivity.this.gmx.setVisibility(0);
                    }
                }
            }
        };
        this.gmv.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gmw.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gmv.setChecked(true);
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
                if (!EditHeadActivity.this.gms.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gmA != null) && view.getTag() != null) {
                        EditHeadActivity.this.gmH = false;
                        EditHeadActivity.this.W(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gmi)) {
            this.gmm.setVisibility(0);
            this.gmq.setVisibility(8);
            this.gmk.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gmk.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, boolean z) {
        if (this.gmu != null) {
            this.gmu.cancel();
        }
        this.gmu = new a(z);
        this.gmu.execute(str);
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
                Bitmap au = com.baidu.tbadk.core.util.l.au(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (au.getWidth() > 1800 || au.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(au, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            au.recycle();
                            au = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && au != null && !au.isRecycled()) {
                        au.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gmE) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(au, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), au != resizedBitmap);
                        EditHeadActivity.this.gmI = new HashMap();
                        EditHeadActivity.this.gmJ = new HashMap();
                        EditHeadActivity.this.gmI.put("normal", roundedCornerBitmap);
                    }
                    return au;
                } catch (Exception e2) {
                    bitmap = au;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gms.bz(true);
            EditHeadActivity.this.gmo.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gmt = null;
            EditHeadActivity.this.gms.bz(false);
            EditHeadActivity.this.gmo.setClickable(true);
            EditHeadActivity.this.gmo.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gmt = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gms.bz(false);
            EditHeadActivity.this.gmo.setClickable(true);
            EditHeadActivity.this.gmo.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gmj.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gmj.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gmE) {
                    EditHeadActivity.this.D(EditHeadActivity.gmh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gmH) {
                new ag("motu_pic", String.valueOf(this.gmD)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        if (this.gmI != null && strArr != null) {
            this.gmG.removeAllViews();
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
                imageView2.setImageResource(FiltersView.gM(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gms.isShowing()) {
                                EditHeadActivity.this.gmj.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gmH = false;
                                EditHeadActivity.this.ta(substring);
                                EditHeadActivity.this.gmD = i2;
                            }
                        }
                    });
                    this.gmK = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gms.isShowing() && !substring.equals(EditHeadActivity.this.gmF)) {
                                EditHeadActivity.this.W(substring, true);
                                EditHeadActivity.this.ta(substring);
                                EditHeadActivity.this.gmD = i2;
                            }
                        }
                    });
                }
                this.gmG.addView(inflate2);
                if (this.gmJ != null) {
                    this.gmJ.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            ta("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gmJ == null) {
                this.gmJ = new HashMap<>();
            }
            if (this.gmF != null && (imageView = this.gmJ.get(this.gmF)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gmC, this.gmC, this.gmC, this.gmC);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.gmJ.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gmC, this.gmC, this.gmC, this.gmC);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gmF = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean gmO;
        private String gmP;
        private Boolean gmQ = false;
        private Boolean gmR = false;

        public a(boolean z) {
            this.gmO = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.gmO || bnl()) {
                EditHeadActivity.this.gms.bz(true);
                EditHeadActivity.this.gmo.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gmP = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gmA == null) {
                return null;
            }
            if (this.gmP.equals("0") || this.gmP.equals("1")) {
                this.gmQ = true;
            } else if (this.gmP.equals("2") || this.gmP.equals("3")) {
                this.gmR = true;
            }
            if (this.gmQ.booleanValue() || this.gmR.booleanValue()) {
                if (EditHeadActivity.this.gmA != null) {
                    this.bitmap = EditHeadActivity.this.gmA.copy(EditHeadActivity.this.gmA.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gmQ.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gmP));
            } else if (this.gmR.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gmP));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.gmP, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bnl() {
            PluginPackageManager.PluginStatus cc = PluginPackageManager.nb().cc(PluginCenter.NAME_MOTUSDK);
            if (cc == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (cc == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), e.j.plugin_config_not_found);
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.nb().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.FORBIDDEN) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gmA != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gms.bz(false);
            EditHeadActivity.this.gmo.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gms.bz(false);
            EditHeadActivity.this.gmo.setClickable(true);
            EditHeadActivity.this.gmo.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gmH = true;
                if (this.gmQ.booleanValue() || this.gmR.booleanValue()) {
                    EditHeadActivity.this.gmj.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gmQ.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gmP));
                    } else if (this.gmR.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gmP));
                    }
                } else {
                    EditHeadActivity.this.gmj.j(bitmap);
                }
                if (EditHeadActivity.this.gmA != null && !EditHeadActivity.this.gmA.isRecycled()) {
                    EditHeadActivity.this.gmA.recycle();
                }
                EditHeadActivity.this.gmA = bitmap;
            }
        }
    }

    private void aLS() {
        this.gmB = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gmB, intentFilter);
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
            if (EditHeadActivity.this.gmo != null) {
                EditHeadActivity.this.gmo.setEnabled(false);
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
                str = this.mNetwork.fh(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Cf().De().isRequestSuccess()) {
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
            EditHeadActivity.this.gmz = null;
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
                if (this.mNetwork.Cf().De().isRequestSuccess()) {
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
