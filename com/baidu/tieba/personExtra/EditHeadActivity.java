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
    private int gqD;
    private String hNd;
    private ImageView hNg;
    private FrameLayout hNh;
    private View hNi;
    private View hNj;
    private RadioButton hNp;
    private RadioButton hNq;
    private HashMap<String, Bitmap> hNw;
    private HashMap<String, ImageView> hNx;
    private TextView hNy;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String hNb = "change";
    public static String FILE_NAME = "file_name";
    private float hNc = 1.0f;
    private EditHeadsImageView hNe = null;
    private EditHeadsImageTopLayerView hNf = null;
    private Bitmap mBitmap = null;
    private int gtb = 0;
    private Button hNk = null;
    private Button hNl = null;
    private com.baidu.tbadk.core.view.b hNm = null;
    private b hNn = null;
    private a hNo = null;
    private LinearLayout hNr = null;
    private LinearLayout hNs = null;
    private d hNt = null;
    private TextView mTitle = null;
    private Bitmap hNu = null;
    private c hNv = null;
    private boolean csJ = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.edit_head_activity);
        Intent intent = getIntent();
        this.gtb = intent.getIntExtra("edit_type", 0);
        this.gqD = intent.getIntExtra("request", 0);
        this.csJ = intent.getBooleanExtra("need_upload", true);
        this.hNc = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.hNd = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gqD == 12002 || this.gqD == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gqD, intent.getData(), ar.adp().adv());
            } else {
                TiebaPrepareImageService.StartService(this.gqD, null, ar.adp().adv(), 0, stringExtra);
            }
            bpC();
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
        bQT();
    }

    private void bQT() {
        al.l(this.mNavigationBar, d.C0277d.common_color_10222);
        getLayoutMode().onModeChanged(this.hNi);
        getLayoutMode().onModeChanged(this.hNj);
        al.d(this.mTitle, d.C0277d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        al.d(this.hNy, d.C0277d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.hNn != null) {
            this.hNn.cancel();
        }
        this.hNe.setImageDrawable(null);
        bQU();
    }

    private void bQU() {
        if (this.hNx != null) {
            for (Map.Entry<String, ImageView> entry : this.hNx.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.hNx.clear();
            this.hNx = null;
        }
        if (this.hNw != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.hNw.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.hNw.clear();
            this.hNw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.hNn != null) {
            this.hNn.cancel();
        }
        this.hNn = new b();
        this.hNn.execute(new Object[0]);
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
        this.hNe.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.hNt != null) {
            this.hNt.cancel();
        }
        if (this.hNu != null && !this.hNu.isRecycled()) {
            this.hNu.recycle();
            this.hNu = null;
        }
        if (this.hNn != null) {
            this.hNn.cancel();
            this.hNn = null;
        }
        this.hNm.dJ(false);
        if (this.gqD == 12002 || this.gqD == 12001) {
            unregisterReceiver(this.hNv);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQV() {
        if (this.hNt != null) {
            this.hNt.cancel();
        }
        this.hNt = new d();
        this.hNt.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.hNm = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hNm.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.hNm.dJ(false);
            }
        });
        this.hNm.dJ(false);
        this.hNf = (EditHeadsImageTopLayerView) findViewById(d.g.image_top_layer);
        this.hNg = (ImageView) findViewById(d.g.preview_image);
        this.hNh = (FrameLayout) findViewById(d.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.hNh.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(d.e.ds74)));
        this.hNe = (EditHeadsImageView) findViewById(d.g.image);
        this.hNe.setCutImageHeightScale(this.hNc);
        if (this.mBitmap != null) {
            this.hNe.setImageBitmap(this.mBitmap);
        }
        this.hNe.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.hNh != null && EditHeadActivity.this.hNh.getVisibility() == 0) {
                    EditHeadActivity.this.hNg.setImageBitmap(EditHeadActivity.this.hNe.oC(false));
                }
            }
        });
        this.hNe.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.hNh != null && EditHeadActivity.this.hNh.getVisibility() == 0) {
                    EditHeadActivity.this.hNg.setImageBitmap(EditHeadActivity.this.hNe.oC(false));
                }
            }
        });
        this.hNi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.hNl = (Button) findViewById(d.g.show_button);
        this.hNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNs.setVisibility(0);
                EditHeadActivity.this.hNl.setVisibility(8);
                EditHeadActivity.this.hNq.setPadding(0, EditHeadActivity.this.hNq.getPaddingTop(), EditHeadActivity.this.hNq.getPaddingRight(), EditHeadActivity.this.hNq.getPaddingBottom());
                EditHeadActivity.this.hNq.setChecked(true);
                EditHeadActivity.this.hNp.setVisibility(8);
            }
        });
        this.hNk = (Button) findViewById(d.g.hide_button);
        this.hNk.setVisibility(0);
        this.hNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.hNs.setVisibility(8);
                EditHeadActivity.this.hNl.setVisibility(0);
            }
        });
        this.hNj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.hNj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gtb == 0) {
                    if (!EditHeadActivity.this.csJ) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap oC = EditHeadActivity.this.hNe.oC(EditHeadActivity.this.gtb == 0 || EditHeadActivity.this.gtb == 3);
                if (oC != null && EditHeadActivity.this.f(str, oC)) {
                    if (EditHeadActivity.this.gtb == 0) {
                        if (EditHeadActivity.this.csJ) {
                            EditHeadActivity.this.bQV();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.lP(str), "head");
                    aVar.anw();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.hNd)) {
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
        this.hNj.setEnabled(false);
        this.hNy = (TextView) this.hNj.findViewById(d.g.save);
        this.hNy.setText(d.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hNd)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        }
        if ("from_photo_live".equals(this.hNd)) {
            this.mTitle.setText(d.j.choose_picture);
        }
        this.hNs = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.hNr = (LinearLayout) findViewById(d.g.rotate);
        this.hNp = (RadioButton) findViewById(d.g.beautify_btn);
        this.hNq = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.hNp) {
                        EditHeadActivity.this.hNr.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.hNq) {
                        EditHeadActivity.this.hNr.setVisibility(0);
                    }
                }
            }
        };
        this.hNp.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNq.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNp.setChecked(true);
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
                if (!EditHeadActivity.this.hNm.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.hNu != null) && view.getTag() != null) {
                        EditHeadActivity.this.AA(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.hNd)) {
            this.hNh.setVisibility(0);
            this.hNl.setVisibility(8);
            this.hNf.setLinePaintColor(getResources().getColor(d.C0277d.white_alpha50));
            this.hNf.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(String str) {
        if (this.hNo != null) {
            this.hNo.cancel();
        }
        this.hNo = new a();
        this.hNo.execute(str);
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
            EditHeadActivity.this.hNm.dJ(true);
            EditHeadActivity.this.hNj.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.hNn = null;
            EditHeadActivity.this.hNm.dJ(false);
            EditHeadActivity.this.hNj.setClickable(true);
            EditHeadActivity.this.hNj.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.hNn = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.hNm.dJ(false);
            EditHeadActivity.this.hNj.setClickable(true);
            EditHeadActivity.this.hNj.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.hNe.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.hNe.setImageBitmap(bitmap);
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
        private String hNA;
        private Boolean hNB = false;
        private Boolean hNC = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.hNm.dJ(true);
            EditHeadActivity.this.hNj.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.hNA = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.hNu == null) {
                return null;
            }
            if (this.hNA.equals("0") || this.hNA.equals("1")) {
                this.hNB = true;
            } else if (this.hNA.equals("2") || this.hNA.equals("3")) {
                this.hNC = true;
            }
            if (this.hNB.booleanValue() || this.hNC.booleanValue()) {
                if (EditHeadActivity.this.hNu != null) {
                    this.bitmap = EditHeadActivity.this.hNu.copy(EditHeadActivity.this.hNu.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.hNB.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.hNA));
            } else if (this.hNC.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.hNA));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.hNu != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.hNm.dJ(false);
            EditHeadActivity.this.hNj.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.hNm.dJ(false);
            EditHeadActivity.this.hNj.setClickable(true);
            EditHeadActivity.this.hNj.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.hNB.booleanValue() || this.hNC.booleanValue()) {
                    EditHeadActivity.this.hNe.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.hNB.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNA));
                    } else if (this.hNC.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.hNA));
                    }
                } else {
                    EditHeadActivity.this.hNe.q(bitmap);
                }
                if (EditHeadActivity.this.hNu != null && !EditHeadActivity.this.hNu.isRecycled()) {
                    EditHeadActivity.this.hNu.recycle();
                }
                EditHeadActivity.this.hNu = bitmap;
            }
        }
    }

    private void bpC() {
        this.hNv = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.hNv, intentFilter);
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
            if (EditHeadActivity.this.hNj != null) {
                EditHeadActivity.this.hNj.setEnabled(false);
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
                str = this.mNetwork.mx(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
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
            EditHeadActivity.this.hNt = null;
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
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
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
