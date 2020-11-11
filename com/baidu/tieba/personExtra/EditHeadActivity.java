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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes24.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bCv;
    private View bCw;
    private TextView bCz;
    private int kmW;
    private String lXB;
    private ImageView lXE;
    private FrameLayout lXF;
    private RadioButton lXL;
    private RadioButton lXM;
    private int lXS;
    private HashMap<String, Bitmap> lXT;
    private HashMap<String, ImageView> lXU;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String lXA = "change";
    public static String FILE_NAME = "file_name";
    private float bCr = 1.0f;
    private EditHeadsImageView lXC = null;
    private EditHeadsImageTopLayerView lXD = null;
    private Bitmap mBitmap = null;
    private int kps = 0;
    private Button lXG = null;
    private Button lXH = null;
    private com.baidu.tbadk.core.view.a lXI = null;
    private b lXJ = null;
    private a lXK = null;
    private LinearLayout lXN = null;
    private LinearLayout lXO = null;
    private d lXP = null;
    private TextView mTitle = null;
    private Bitmap bCy = null;
    private c lXQ = null;
    private boolean fxR = true;
    private boolean lXR = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.kps = intent.getIntExtra("edit_type", 0);
        this.kmW = intent.getIntExtra("request", 0);
        this.fxR = intent.getBooleanExtra("need_upload", true);
        this.lXR = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.lXS = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bCr = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.lXB = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kmW == 12002 || this.kmW == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kmW, intent.getData(), au.bro().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kmW, null, au.bro().getPostImageSize(), 0, stringExtra);
            }
            cOm();
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
        due();
    }

    private void due() {
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bCv);
        getLayoutMode().onModeChanged(this.bCw);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        ap.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ap.setViewTextColor(this.bCz, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.lXJ != null) {
            this.lXJ.cancel();
        }
        this.lXC.setImageDrawable(null);
        duf();
    }

    private void duf() {
        if (this.lXU != null) {
            for (Map.Entry<String, ImageView> entry : this.lXU.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.lXU.clear();
            this.lXU = null;
        }
        if (this.lXT != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.lXT.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.lXT.clear();
            this.lXT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.lXJ != null) {
            this.lXJ.cancel();
        }
        this.lXJ = new b();
        this.lXJ.execute(new Object[0]);
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
        this.lXC.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.lXP != null) {
            this.lXP.cancel();
        }
        if (this.bCy != null && !this.bCy.isRecycled()) {
            this.bCy.recycle();
            this.bCy = null;
        }
        if (this.lXJ != null) {
            this.lXJ.cancel();
            this.lXJ = null;
        }
        this.lXI.setDialogVisiable(false);
        if (this.kmW == 12002 || this.kmW == 12001) {
            unregisterReceiver(this.lXQ);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        if (this.lXP != null) {
            this.lXP.cancel();
        }
        this.lXP = new d();
        this.lXP.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lXI = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lXI.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.lXI.setDialogVisiable(false);
            }
        });
        this.lXI.setDialogVisiable(false);
        this.lXD = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.lXB) && this.bCr != 1.0f) {
            this.lXD.setmCutHeightScale(this.bCr);
        }
        this.lXE = (ImageView) findViewById(R.id.preview_image);
        this.lXF = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.lXF.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.lXC = (EditHeadsImageView) findViewById(R.id.image);
        this.lXC.setCutImageHeightScale(this.bCr);
        if (this.mBitmap != null) {
            this.lXC.setImageBitmap(this.mBitmap);
        }
        this.lXC.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.lXF != null && EditHeadActivity.this.lXF.getVisibility() == 0) {
                    EditHeadActivity.this.lXE.setImageBitmap(EditHeadActivity.this.lXC.cJ(false));
                }
            }
        });
        this.lXC.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.lXF != null && EditHeadActivity.this.lXF.getVisibility() == 0) {
                    EditHeadActivity.this.lXE.setImageBitmap(EditHeadActivity.this.lXC.cJ(false));
                }
            }
        });
        this.bCv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.lXH = (Button) findViewById(R.id.show_button);
        this.lXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.lXO.setVisibility(0);
                EditHeadActivity.this.lXH.setVisibility(8);
                EditHeadActivity.this.lXM.setPadding(0, EditHeadActivity.this.lXM.getPaddingTop(), EditHeadActivity.this.lXM.getPaddingRight(), EditHeadActivity.this.lXM.getPaddingBottom());
                EditHeadActivity.this.lXM.setChecked(true);
                EditHeadActivity.this.lXL.setVisibility(8);
            }
        });
        this.lXG = (Button) findViewById(R.id.hide_button);
        this.lXG.setVisibility(0);
        this.lXG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.lXO.setVisibility(8);
                EditHeadActivity.this.lXH.setVisibility(0);
            }
        });
        this.bCw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.kps == 0) {
                    if (!EditHeadActivity.this.fxR) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap cJ = EditHeadActivity.this.lXC.cJ(EditHeadActivity.this.kps == 0 || EditHeadActivity.this.kps == 3);
                if (cJ != null && EditHeadActivity.this.c(str, cJ)) {
                    if (EditHeadActivity.this.kps == 0) {
                        if (EditHeadActivity.this.fxR) {
                            EditHeadActivity.this.dug();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(n.getFileDireciory(str), "head");
                    aVar.setServerResizeForIMImage();
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
                                        if (imageUploadResult.picInfo.originPic != null) {
                                            photoUrlData.setOriginPic(imageUploadResult.picInfo.originPic.picUrl);
                                        }
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.lXB)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.lXB)) {
                                        Intent intent3 = new Intent();
                                        intent3.setAction("com.tieba.action.ImagePickerPlugin");
                                        intent3.putExtra("pic_info", photoUrlData);
                                        EditHeadActivity.this.sendBroadcast(intent3);
                                    }
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.rA(EditHeadActivity.this.lXS);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bCw.setEnabled(false);
        this.bCz = (TextView) this.bCw.findViewById(R.id.save);
        this.bCz.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.lXB)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.lXB)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.lXO = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.lXN = (LinearLayout) findViewById(R.id.rotate);
        this.lXL = (RadioButton) findViewById(R.id.beautify_btn);
        this.lXM = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.lXL) {
                        EditHeadActivity.this.lXN.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.lXM) {
                        EditHeadActivity.this.lXN.setVisibility(0);
                    }
                }
            }
        };
        this.lXL.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lXM.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lXL.setChecked(true);
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
                if (!EditHeadActivity.this.lXI.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bCy != null) && view.getTag() != null) {
                        EditHeadActivity.this.Qt(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.lXB)) {
            this.lXF.setVisibility(0);
            this.lXH.setVisibility(8);
            this.lXD.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.lXD.setLineWidth(2);
        }
        if (!this.lXR) {
            this.lXH.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qt(String str) {
        if (this.lXK != null) {
            this.lXK.cancel();
        }
        this.lXK = new a();
        this.lXK.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (image.getWidth() > 1800 || image.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(image, 1800);
                        try {
                            image.recycle();
                            image = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (!isCancelled() || image == null || image.isRecycled()) {
                        return image;
                    }
                    image.recycle();
                    return null;
                } catch (Exception e2) {
                    bitmap = image;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.lXI.setDialogVisiable(true);
            EditHeadActivity.this.bCw.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.lXJ = null;
            EditHeadActivity.this.lXI.setDialogVisiable(false);
            EditHeadActivity.this.bCw.setClickable(true);
            EditHeadActivity.this.bCw.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.lXJ = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.lXI.setDialogVisiable(false);
            EditHeadActivity.this.bCw.setClickable(true);
            EditHeadActivity.this.bCw.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.lXC.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.lXC.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            n.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String lXW;
        private Boolean lXX = false;
        private Boolean lXY = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.lXI.setDialogVisiable(true);
            EditHeadActivity.this.bCw.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public Bitmap doInBackground(String... strArr) {
            this.lXW = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bCy == null) {
                return null;
            }
            if (this.lXW.equals("0") || this.lXW.equals("1")) {
                this.lXX = true;
            } else if (this.lXW.equals("2") || this.lXW.equals("3")) {
                this.lXY = true;
            }
            if (this.lXX.booleanValue() || this.lXY.booleanValue()) {
                if (EditHeadActivity.this.bCy != null) {
                    this.bitmap = EditHeadActivity.this.bCy.copy(EditHeadActivity.this.bCy.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.lXX.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.lXW));
            } else if (this.lXY.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.lXW));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bCy != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.lXI.setDialogVisiable(false);
            EditHeadActivity.this.bCw.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.lXI.setDialogVisiable(false);
            EditHeadActivity.this.bCw.setClickable(true);
            EditHeadActivity.this.bCw.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.lXX.booleanValue() || this.lXY.booleanValue()) {
                    EditHeadActivity.this.lXC.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.lXX.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.lXW));
                    } else if (this.lXY.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.lXW));
                    }
                } else {
                    EditHeadActivity.this.lXC.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bCy != null && !EditHeadActivity.this.bCy.isRecycled()) {
                    EditHeadActivity.this.bCy.recycle();
                }
                EditHeadActivity.this.bCy = bitmap;
            }
        }
    }

    private void cOm() {
        this.lXQ = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.lXQ, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
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
            EditHeadActivity.this.showToast(intent.getStringExtra(BdStatsConstant.StatsType.ERROR));
            if (EditHeadActivity.this.bCw != null) {
                EditHeadActivity.this.bCw.setEnabled(false);
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
    /* loaded from: classes24.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private aa mNetwork;

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
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.BP(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
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
            EditHeadActivity.this.lXP = null;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.lXB)) {
                        Intent intent2 = new Intent();
                        intent2.setAction("com.tieba.action.ImagePickerPlugin");
                        intent2.putExtra("isHeadImage", true);
                        EditHeadActivity.this.sendBroadcast(intent2);
                    }
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(R.string.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
