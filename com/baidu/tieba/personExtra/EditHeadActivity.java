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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int gNR;
    private String ilE;
    private ImageView ilH;
    private FrameLayout ilI;
    private View ilJ;
    private View ilK;
    private RadioButton ilQ;
    private RadioButton ilR;
    private HashMap<String, Bitmap> ilX;
    private HashMap<String, ImageView> ilY;
    private TextView ilZ;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String ilC = "change";
    public static String FILE_NAME = "file_name";
    private float ilD = 1.0f;
    private EditHeadsImageView ilF = null;
    private EditHeadsImageTopLayerView ilG = null;
    private Bitmap mBitmap = null;
    private int gQp = 0;
    private Button ilL = null;
    private Button ilM = null;
    private com.baidu.tbadk.core.view.b ilN = null;
    private b ilO = null;
    private a ilP = null;
    private LinearLayout ilS = null;
    private LinearLayout ilT = null;
    private d ilU = null;
    private TextView mTitle = null;
    private Bitmap ilV = null;
    private c ilW = null;
    private boolean cCn = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.gQp = intent.getIntExtra("edit_type", 0);
        this.gNR = intent.getIntExtra("request", 0);
        this.cCn = intent.getBooleanExtra("need_upload", true);
        this.ilD = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.ilE = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gNR == 12002 || this.gNR == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gNR, intent.getData(), as.ajo().aju());
            } else {
                TiebaPrepareImageService.StartService(this.gNR, null, as.ajo().aju(), 0, stringExtra);
            }
            bzT();
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
        cbE();
    }

    private void cbE() {
        am.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.ilJ);
        getLayoutMode().onModeChanged(this.ilK);
        am.f(this.mTitle, R.color.cp_cont_g, 1);
        am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_s, 0);
        am.f(this.ilZ, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ilO != null) {
            this.ilO.cancel();
        }
        this.ilF.setImageDrawable(null);
        cbF();
    }

    private void cbF() {
        if (this.ilY != null) {
            for (Map.Entry<String, ImageView> entry : this.ilY.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.ilY.clear();
            this.ilY = null;
        }
        if (this.ilX != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.ilX.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.ilX.clear();
            this.ilX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ilO != null) {
            this.ilO.cancel();
        }
        this.ilO = new b();
        this.ilO.execute(new Object[0]);
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
        this.ilF.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.ilU != null) {
            this.ilU.cancel();
        }
        if (this.ilV != null && !this.ilV.isRecycled()) {
            this.ilV.recycle();
            this.ilV = null;
        }
        if (this.ilO != null) {
            this.ilO.cancel();
            this.ilO = null;
        }
        this.ilN.ej(false);
        if (this.gNR == 12002 || this.gNR == 12001) {
            unregisterReceiver(this.ilW);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.ilU != null) {
            this.ilU.cancel();
        }
        this.ilU = new d();
        this.ilU.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.ilN = new com.baidu.tbadk.core.view.b(getPageContext());
        this.ilN.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.ilN.ej(false);
            }
        });
        this.ilN.ej(false);
        this.ilG = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.ilH = (ImageView) findViewById(R.id.preview_image);
        this.ilI = (FrameLayout) findViewById(R.id.preview_layout);
        int[] aj = l.aj(getPageContext().getPageActivity());
        this.ilI.setY((int) (aj[0] + ((aj[1] - aj[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.ilF = (EditHeadsImageView) findViewById(R.id.image);
        this.ilF.setCutImageHeightScale(this.ilD);
        if (this.mBitmap != null) {
            this.ilF.setImageBitmap(this.mBitmap);
        }
        this.ilF.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.ilI != null && EditHeadActivity.this.ilI.getVisibility() == 0) {
                    EditHeadActivity.this.ilH.setImageBitmap(EditHeadActivity.this.ilF.pG(false));
                }
            }
        });
        this.ilF.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.ilI != null && EditHeadActivity.this.ilI.getVisibility() == 0) {
                    EditHeadActivity.this.ilH.setImageBitmap(EditHeadActivity.this.ilF.pG(false));
                }
            }
        });
        this.ilJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.ilM = (Button) findViewById(R.id.show_button);
        this.ilM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ilT.setVisibility(0);
                EditHeadActivity.this.ilM.setVisibility(8);
                EditHeadActivity.this.ilR.setPadding(0, EditHeadActivity.this.ilR.getPaddingTop(), EditHeadActivity.this.ilR.getPaddingRight(), EditHeadActivity.this.ilR.getPaddingBottom());
                EditHeadActivity.this.ilR.setChecked(true);
                EditHeadActivity.this.ilQ.setVisibility(8);
            }
        });
        this.ilL = (Button) findViewById(R.id.hide_button);
        this.ilL.setVisibility(0);
        this.ilL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ilT.setVisibility(8);
                EditHeadActivity.this.ilM.setVisibility(0);
            }
        });
        this.ilK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.ilK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gQp == 0) {
                    if (!EditHeadActivity.this.cCn) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap pG = EditHeadActivity.this.ilF.pG(EditHeadActivity.this.gQp == 0 || EditHeadActivity.this.gQp == 3);
                if (pG != null && EditHeadActivity.this.f(str, pG)) {
                    if (EditHeadActivity.this.gQp == 0) {
                        if (EditHeadActivity.this.cCn) {
                            EditHeadActivity.this.cbG();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.nj(str), "head");
                    aVar.atD();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(R.string.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.ilE)) {
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
                    aVar.fr(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.ilK.setEnabled(false);
        this.ilZ = (TextView) this.ilK.findViewById(R.id.save);
        this.ilZ.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ilE)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.ilE)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.ilT = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.ilS = (LinearLayout) findViewById(R.id.rotate);
        this.ilQ = (RadioButton) findViewById(R.id.beautify_btn);
        this.ilR = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.ilQ) {
                        EditHeadActivity.this.ilS.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.ilR) {
                        EditHeadActivity.this.ilS.setVisibility(0);
                    }
                }
            }
        };
        this.ilQ.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ilR.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ilQ.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.ilN.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.ilV != null) && view.getTag() != null) {
                        EditHeadActivity.this.CE(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ilE)) {
            this.ilI.setVisibility(0);
            this.ilM.setVisibility(8);
            this.ilG.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.ilG.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE(String str) {
        if (this.ilP != null) {
            this.ilP.cancel();
        }
        this.ilP = new a();
        this.ilP.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap bP = m.bP(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (bP.getWidth() > 1800 || bP.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bP, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            bP.recycle();
                            bP = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (!isCancelled() || bP == null || bP.isRecycled()) {
                        return bP;
                    }
                    bP.recycle();
                    return null;
                } catch (Exception e2) {
                    bitmap = bP;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.ilN.ej(true);
            EditHeadActivity.this.ilK.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.ilO = null;
            EditHeadActivity.this.ilN.ej(false);
            EditHeadActivity.this.ilK.setClickable(true);
            EditHeadActivity.this.ilK.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.ilO = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.ilN.ej(false);
            EditHeadActivity.this.ilK.setClickable(true);
            EditHeadActivity.this.ilK.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.ilF.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.ilF.setImageBitmap(bitmap);
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
        private String imb;
        private Boolean imc = false;
        private Boolean imd = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.ilN.ej(true);
            EditHeadActivity.this.ilK.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.imb = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.ilV == null) {
                return null;
            }
            if (this.imb.equals("0") || this.imb.equals("1")) {
                this.imc = true;
            } else if (this.imb.equals("2") || this.imb.equals("3")) {
                this.imd = true;
            }
            if (this.imc.booleanValue() || this.imd.booleanValue()) {
                if (EditHeadActivity.this.ilV != null) {
                    this.bitmap = EditHeadActivity.this.ilV.copy(EditHeadActivity.this.ilV.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.imc.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.imb));
            } else if (this.imd.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.imb));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.ilV != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.ilN.ej(false);
            EditHeadActivity.this.ilK.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.ilN.ej(false);
            EditHeadActivity.this.ilK.setClickable(true);
            EditHeadActivity.this.ilK.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.imc.booleanValue() || this.imd.booleanValue()) {
                    EditHeadActivity.this.ilF.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.imc.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.imb));
                    } else if (this.imd.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.imb));
                    }
                } else {
                    EditHeadActivity.this.ilF.q(bitmap);
                }
                if (EditHeadActivity.this.ilV != null && !EditHeadActivity.this.ilV.isRecycled()) {
                    EditHeadActivity.this.ilV.recycle();
                }
                EditHeadActivity.this.ilV = bitmap;
            }
        }
    }

    private void bzT() {
        this.ilW = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ilW, intentFilter);
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
            if (EditHeadActivity.this.ilK != null) {
                EditHeadActivity.this.ilK.setEnabled(false);
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
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.nR(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
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
            EditHeadActivity.this.ilU = null;
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(R.string.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
