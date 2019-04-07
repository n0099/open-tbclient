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
    private int gqq;
    private String hMP;
    private ImageView hMS;
    private FrameLayout hMT;
    private View hMU;
    private View hMV;
    private RadioButton hNb;
    private RadioButton hNc;
    private HashMap<String, Bitmap> hNi;
    private HashMap<String, ImageView> hNj;
    private TextView hNk;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String hMN = "change";
    public static String FILE_NAME = "file_name";
    private float hMO = 1.0f;
    private EditHeadsImageView hMQ = null;
    private EditHeadsImageTopLayerView hMR = null;
    private Bitmap mBitmap = null;
    private int gsO = 0;
    private Button hMW = null;
    private Button hMX = null;
    private com.baidu.tbadk.core.view.b hMY = null;
    private b hMZ = null;
    private a hNa = null;
    private LinearLayout hNd = null;
    private LinearLayout hNe = null;
    private d hNf = null;
    private TextView mTitle = null;
    private Bitmap hNg = null;
    private c hNh = null;
    private boolean csL = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.edit_head_activity);
        Intent intent = getIntent();
        this.gsO = intent.getIntExtra("edit_type", 0);
        this.gqq = intent.getIntExtra("request", 0);
        this.csL = intent.getBooleanExtra("need_upload", true);
        this.hMO = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.hMP = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gqq == 12002 || this.gqq == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gqq, intent.getData(), ar.adm().ads());
            } else {
                TiebaPrepareImageService.StartService(this.gqq, null, ar.adm().ads(), 0, stringExtra);
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
        getLayoutMode().onModeChanged(this.hMU);
        getLayoutMode().onModeChanged(this.hMV);
        al.d(this.mTitle, d.C0277d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        al.d(this.hNk, d.C0277d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.hMZ != null) {
            this.hMZ.cancel();
        }
        this.hMQ.setImageDrawable(null);
        bQQ();
    }

    private void bQQ() {
        if (this.hNj != null) {
            for (Map.Entry<String, ImageView> entry : this.hNj.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.hNj.clear();
            this.hNj = null;
        }
        if (this.hNi != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.hNi.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.hNi.clear();
            this.hNi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.hMZ != null) {
            this.hMZ.cancel();
        }
        this.hMZ = new b();
        this.hMZ.execute(new Object[0]);
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
        this.hMQ.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.hNf != null) {
            this.hNf.cancel();
        }
        if (this.hNg != null && !this.hNg.isRecycled()) {
            this.hNg.recycle();
            this.hNg = null;
        }
        if (this.hMZ != null) {
            this.hMZ.cancel();
            this.hMZ = null;
        }
        this.hMY.dJ(false);
        if (this.gqq == 12002 || this.gqq == 12001) {
            unregisterReceiver(this.hNh);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQR() {
        if (this.hNf != null) {
            this.hNf.cancel();
        }
        this.hNf = new d();
        this.hNf.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.hMY = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hMY.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.hMY.dJ(false);
            }
        });
        this.hMY.dJ(false);
        this.hMR = (EditHeadsImageTopLayerView) findViewById(d.g.image_top_layer);
        this.hMS = (ImageView) findViewById(d.g.preview_image);
        this.hMT = (FrameLayout) findViewById(d.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.hMT.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(d.e.ds74)));
        this.hMQ = (EditHeadsImageView) findViewById(d.g.image);
        this.hMQ.setCutImageHeightScale(this.hMO);
        if (this.mBitmap != null) {
            this.hMQ.setImageBitmap(this.mBitmap);
        }
        this.hMQ.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.hMT != null && EditHeadActivity.this.hMT.getVisibility() == 0) {
                    EditHeadActivity.this.hMS.setImageBitmap(EditHeadActivity.this.hMQ.oC(false));
                }
            }
        });
        this.hMQ.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.hMT != null && EditHeadActivity.this.hMT.getVisibility() == 0) {
                    EditHeadActivity.this.hMS.setImageBitmap(EditHeadActivity.this.hMQ.oC(false));
                }
            }
        });
        this.hMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.hMX = (Button) findViewById(d.g.show_button);
        this.hMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNe.setVisibility(0);
                EditHeadActivity.this.hMX.setVisibility(8);
                EditHeadActivity.this.hNc.setPadding(0, EditHeadActivity.this.hNc.getPaddingTop(), EditHeadActivity.this.hNc.getPaddingRight(), EditHeadActivity.this.hNc.getPaddingBottom());
                EditHeadActivity.this.hNc.setChecked(true);
                EditHeadActivity.this.hNb.setVisibility(8);
            }
        });
        this.hMW = (Button) findViewById(d.g.hide_button);
        this.hMW.setVisibility(0);
        this.hMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNe.setVisibility(8);
                EditHeadActivity.this.hMX.setVisibility(0);
            }
        });
        this.hMV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.hMV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gsO == 0) {
                    if (!EditHeadActivity.this.csL) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap oC = EditHeadActivity.this.hMQ.oC(EditHeadActivity.this.gsO == 0 || EditHeadActivity.this.gsO == 3);
                if (oC != null && EditHeadActivity.this.f(str, oC)) {
                    if (EditHeadActivity.this.gsO == 0) {
                        if (EditHeadActivity.this.csL) {
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.hMP)) {
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
        this.hMV.setEnabled(false);
        this.hNk = (TextView) this.hMV.findViewById(d.g.save);
        this.hNk.setText(d.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hMP)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        }
        if ("from_photo_live".equals(this.hMP)) {
            this.mTitle.setText(d.j.choose_picture);
        }
        this.hNe = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.hNd = (LinearLayout) findViewById(d.g.rotate);
        this.hNb = (RadioButton) findViewById(d.g.beautify_btn);
        this.hNc = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.hNb) {
                        EditHeadActivity.this.hNd.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.hNc) {
                        EditHeadActivity.this.hNd.setVisibility(0);
                    }
                }
            }
        };
        this.hNb.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNc.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNb.setChecked(true);
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
                if (!EditHeadActivity.this.hMY.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.hNg != null) && view.getTag() != null) {
                        EditHeadActivity.this.Az(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hMP)) {
            this.hMT.setVisibility(0);
            this.hMX.setVisibility(8);
            this.hMR.setLinePaintColor(getResources().getColor(d.C0277d.white_alpha50));
            this.hMR.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az(String str) {
        if (this.hNa != null) {
            this.hNa.cancel();
        }
        this.hNa = new a();
        this.hNa.execute(str);
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
            EditHeadActivity.this.hMY.dJ(true);
            EditHeadActivity.this.hMV.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.hMZ = null;
            EditHeadActivity.this.hMY.dJ(false);
            EditHeadActivity.this.hMV.setClickable(true);
            EditHeadActivity.this.hMV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.hMZ = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.hMY.dJ(false);
            EditHeadActivity.this.hMV.setClickable(true);
            EditHeadActivity.this.hMV.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.hMQ.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.hMQ.setImageBitmap(bitmap);
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
        private String hNm;
        private Boolean hNn = false;
        private Boolean hNo = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.hMY.dJ(true);
            EditHeadActivity.this.hMV.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.hNm = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.hNg == null) {
                return null;
            }
            if (this.hNm.equals("0") || this.hNm.equals("1")) {
                this.hNn = true;
            } else if (this.hNm.equals("2") || this.hNm.equals("3")) {
                this.hNo = true;
            }
            if (this.hNn.booleanValue() || this.hNo.booleanValue()) {
                if (EditHeadActivity.this.hNg != null) {
                    this.bitmap = EditHeadActivity.this.hNg.copy(EditHeadActivity.this.hNg.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.hNn.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.hNm));
            } else if (this.hNo.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.hNm));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.hNg != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.hMY.dJ(false);
            EditHeadActivity.this.hMV.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.hMY.dJ(false);
            EditHeadActivity.this.hMV.setClickable(true);
            EditHeadActivity.this.hMV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.hNn.booleanValue() || this.hNo.booleanValue()) {
                    EditHeadActivity.this.hMQ.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.hNn.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNm));
                    } else if (this.hNo.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNm));
                    }
                } else {
                    EditHeadActivity.this.hMQ.q(bitmap);
                }
                if (EditHeadActivity.this.hNg != null && !EditHeadActivity.this.hNg.isRecycled()) {
                    EditHeadActivity.this.hNg.recycle();
                }
                EditHeadActivity.this.hNg = bitmap;
            }
        }
    }

    private void bpz() {
        this.hNh = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.hNh, intentFilter);
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
            if (EditHeadActivity.this.hMV != null) {
                EditHeadActivity.this.hMV.setEnabled(false);
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
            EditHeadActivity.this.hNf = null;
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
