package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int gqr;
    private String hMQ;
    private ImageView hMT;
    private FrameLayout hMU;
    private View hMV;
    private View hMW;
    private RadioButton hNc;
    private RadioButton hNd;
    private HashMap<String, Bitmap> hNj;
    private HashMap<String, ImageView> hNk;
    private TextView hNl;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String hMO = "change";
    public static String FILE_NAME = "file_name";
    private float hMP = 1.0f;
    private EditHeadsImageView hMR = null;
    private EditHeadsImageTopLayerView hMS = null;
    private Bitmap mBitmap = null;
    private int gsP = 0;
    private Button hMX = null;
    private Button hMY = null;
    private com.baidu.tbadk.core.view.b hMZ = null;
    private b hNa = null;
    private a hNb = null;
    private LinearLayout hNe = null;
    private LinearLayout hNf = null;
    private d hNg = null;
    private TextView mTitle = null;
    private Bitmap hNh = null;
    private c hNi = null;
    private boolean csM = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.edit_head_activity);
        Intent intent = getIntent();
        this.gsP = intent.getIntExtra("edit_type", 0);
        this.gqr = intent.getIntExtra("request", 0);
        this.csM = intent.getBooleanExtra("need_upload", true);
        this.hMP = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.hMQ = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gqr == 12002 || this.gqr == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gqr, intent.getData(), ar.adm().ads());
            } else {
                TiebaPrepareImageService.StartService(this.gqr, null, ar.adm().ads(), 0, stringExtra);
            }
            bpz();
            return;
        }
        initUI();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bQP();
    }

    private void bQP() {
        al.l(this.mNavigationBar, d.C0277d.common_color_10222);
        getLayoutMode().onModeChanged(this.hMV);
        getLayoutMode().onModeChanged(this.hMW);
        al.d(this.mTitle, d.C0277d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        al.d(this.hNl, d.C0277d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.hNa != null) {
            this.hNa.cancel();
        }
        this.hMR.setImageDrawable(null);
        bQQ();
    }

    private void bQQ() {
        if (this.hNk != null) {
            for (Map.Entry<String, ImageView> entry : this.hNk.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.hNk.clear();
            this.hNk = null;
        }
        if (this.hNj != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.hNj.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.hNj.clear();
            this.hNj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.hNa != null) {
            this.hNa.cancel();
        }
        this.hNa = new b();
        this.hNa.execute(new Object[0]);
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
        this.hMR.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.hNg != null) {
            this.hNg.cancel();
        }
        if (this.hNh != null && !this.hNh.isRecycled()) {
            this.hNh.recycle();
            this.hNh = null;
        }
        if (this.hNa != null) {
            this.hNa.cancel();
            this.hNa = null;
        }
        this.hMZ.dJ(false);
        if (this.gqr == 12002 || this.gqr == 12001) {
            unregisterReceiver(this.hNi);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQR() {
        if (this.hNg != null) {
            this.hNg.cancel();
        }
        this.hNg = new d();
        this.hNg.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.hMZ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hMZ.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.hMZ.dJ(false);
            }
        });
        this.hMZ.dJ(false);
        this.hMS = (EditHeadsImageTopLayerView) findViewById(d.g.image_top_layer);
        this.hMT = (ImageView) findViewById(d.g.preview_image);
        this.hMU = (FrameLayout) findViewById(d.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.hMU.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(d.e.ds74)));
        this.hMR = (EditHeadsImageView) findViewById(d.g.image);
        this.hMR.setCutImageHeightScale(this.hMP);
        if (this.mBitmap != null) {
            this.hMR.setImageBitmap(this.mBitmap);
        }
        this.hMR.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.hMU != null && EditHeadActivity.this.hMU.getVisibility() == 0) {
                    EditHeadActivity.this.hMT.setImageBitmap(EditHeadActivity.this.hMR.oC(false));
                }
            }
        });
        this.hMR.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.hMU != null && EditHeadActivity.this.hMU.getVisibility() == 0) {
                    EditHeadActivity.this.hMT.setImageBitmap(EditHeadActivity.this.hMR.oC(false));
                }
            }
        });
        this.hMV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.hMY = (Button) findViewById(d.g.show_button);
        this.hMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNf.setVisibility(0);
                EditHeadActivity.this.hMY.setVisibility(8);
                EditHeadActivity.this.hNd.setPadding(0, EditHeadActivity.this.hNd.getPaddingTop(), EditHeadActivity.this.hNd.getPaddingRight(), EditHeadActivity.this.hNd.getPaddingBottom());
                EditHeadActivity.this.hNd.setChecked(true);
                EditHeadActivity.this.hNc.setVisibility(8);
            }
        });
        this.hMX = (Button) findViewById(d.g.hide_button);
        this.hMX.setVisibility(0);
        this.hMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNf.setVisibility(8);
                EditHeadActivity.this.hMY.setVisibility(0);
            }
        });
        this.hMW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.hMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gsP == 0) {
                    if (!EditHeadActivity.this.csM) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap oC = EditHeadActivity.this.hMR.oC(EditHeadActivity.this.gsP == 0 || EditHeadActivity.this.gsP == 3);
                if (oC != null && EditHeadActivity.this.f(str, oC)) {
                    if (EditHeadActivity.this.gsP == 0) {
                        if (EditHeadActivity.this.csM) {
                            EditHeadActivity.this.bQR();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.lQ(str), "head");
                    aVar.ant();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(d.j.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.hMQ)) {
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
                    aVar.eR(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.j.uploading));
                }
            }
        });
        this.hMW.setEnabled(false);
        this.hNl = (TextView) this.hMW.findViewById(d.g.save);
        this.hNl.setText(d.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hMQ)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        }
        if ("from_photo_live".equals(this.hMQ)) {
            this.mTitle.setText(d.j.choose_picture);
        }
        this.hNf = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.hNe = (LinearLayout) findViewById(d.g.rotate);
        this.hNc = (RadioButton) findViewById(d.g.beautify_btn);
        this.hNd = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.hNc) {
                        EditHeadActivity.this.hNe.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.hNd) {
                        EditHeadActivity.this.hNe.setVisibility(0);
                    }
                }
            }
        };
        this.hNc.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNd.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNc.setChecked(true);
        Button button = (Button) findViewById(d.g.rotate_left);
        Button button2 = (Button) findViewById(d.g.rotate_right);
        Button button3 = (Button) findViewById(d.g.rotate_left_right);
        Button button4 = (Button) findViewById(d.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.hMZ.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.hNh != null) && view.getTag() != null) {
                        EditHeadActivity.this.Az(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hMQ)) {
            this.hMU.setVisibility(0);
            this.hMY.setVisibility(8);
            this.hMS.setLinePaintColor(getResources().getColor(d.C0277d.white_alpha50));
            this.hMS.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az(String str) {
        if (this.hNb != null) {
            this.hNb.cancel();
        }
        this.hNb = new a();
        this.hNb.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
                Bitmap bF = m.bF(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (bF.getWidth() > 1800 || bF.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bF, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            bF.recycle();
                            bF = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (!isCancelled() || bF == null || bF.isRecycled()) {
                        return bF;
                    }
                    bF.recycle();
                    return null;
                } catch (Exception e2) {
                    bitmap = bF;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.hMZ.dJ(true);
            EditHeadActivity.this.hMW.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.hNa = null;
            EditHeadActivity.this.hMZ.dJ(false);
            EditHeadActivity.this.hMW.setClickable(true);
            EditHeadActivity.this.hMW.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.hNa = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.hMZ.dJ(false);
            EditHeadActivity.this.hMW.setClickable(true);
            EditHeadActivity.this.hMW.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.hMR.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.hMR.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, Bitmap bitmap) {
        try {
            m.a((String) null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String hNn;
        private Boolean hNo = false;
        private Boolean hNp = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.hMZ.dJ(true);
            EditHeadActivity.this.hMW.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.hNn = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.hNh == null) {
                return null;
            }
            if (this.hNn.equals("0") || this.hNn.equals("1")) {
                this.hNo = true;
            } else if (this.hNn.equals("2") || this.hNn.equals("3")) {
                this.hNp = true;
            }
            if (this.hNo.booleanValue() || this.hNp.booleanValue()) {
                if (EditHeadActivity.this.hNh != null) {
                    this.bitmap = EditHeadActivity.this.hNh.copy(EditHeadActivity.this.hNh.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.hNo.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.hNn));
            } else if (this.hNp.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.hNn));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.hNh != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.hMZ.dJ(false);
            EditHeadActivity.this.hMW.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.hMZ.dJ(false);
            EditHeadActivity.this.hMW.setClickable(true);
            EditHeadActivity.this.hMW.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.hNo.booleanValue() || this.hNp.booleanValue()) {
                    EditHeadActivity.this.hMR.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.hNo.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNn));
                    } else if (this.hNp.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNn));
                    }
                } else {
                    EditHeadActivity.this.hMR.q(bitmap);
                }
                if (EditHeadActivity.this.hNh != null && !EditHeadActivity.this.hNh.isRecycled()) {
                    EditHeadActivity.this.hNh.recycle();
                }
                EditHeadActivity.this.hNh = bitmap;
            }
        }
    }

    private void bpz() {
        this.hNi = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.hNi, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
            EditHeadActivity.this.showToast(intent.getStringExtra("error"));
            if (EditHeadActivity.this.hMW != null) {
                EditHeadActivity.this.hMW.setEnabled(false);
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
    /* loaded from: classes6.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.my(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
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
            EditHeadActivity.this.hNg = null;
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(d.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
