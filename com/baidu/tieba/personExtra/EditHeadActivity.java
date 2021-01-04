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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bKH;
    private View bKI;
    private TextView bKL;
    private int kGs;
    private NavigationBar mNavigationBar;
    private int mrE;
    private HashMap<String, Bitmap> mrF;
    private HashMap<String, ImageView> mrG;
    private String mrm;
    private ImageView mrp;
    private FrameLayout mrq;
    private RadioButton mrx;
    private RadioButton mry;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String mrl = "change";
    public static String FILE_NAME = "file_name";
    private float bKD = 1.0f;
    private EditHeadsImageView mrn = null;
    private EditHeadsImageTopLayerView mro = null;
    private Bitmap mBitmap = null;
    private int mrr = 0;
    private Button mrs = null;
    private Button mrt = null;
    private com.baidu.tbadk.core.view.a mru = null;
    private b mrv = null;
    private a mrw = null;
    private LinearLayout mrz = null;
    private LinearLayout mrA = null;
    private d mrB = null;
    private TextView mTitle = null;
    private Bitmap bKK = null;
    private c mrC = null;
    private boolean fOz = true;
    private boolean mrD = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.mrr = intent.getIntExtra("edit_type", 0);
        this.kGs = intent.getIntExtra("request", 0);
        this.fOz = intent.getBooleanExtra("need_upload", true);
        this.mrD = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.mrE = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bKD = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.mrm = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kGs == 12002 || this.kGs == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kGs, intent.getData(), au.bwr().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kGs, null, au.bwr().getPostImageSize(), 0, stringExtra);
            }
            cWn();
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
        dyM();
    }

    private void dyM() {
        ao.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bKH);
        getLayoutMode().onModeChanged(this.bKI);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ao.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ao.setViewTextColor(this.bKL, R.color.CAM_X0111, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.mrv != null) {
            this.mrv.cancel();
        }
        this.mrn.setImageDrawable(null);
        dyN();
    }

    private void dyN() {
        if (this.mrG != null) {
            for (Map.Entry<String, ImageView> entry : this.mrG.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.mrG.clear();
            this.mrG = null;
        }
        if (this.mrF != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.mrF.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.mrF.clear();
            this.mrF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mrv != null) {
            this.mrv.cancel();
        }
        this.mrv = new b();
        this.mrv.execute(new Object[0]);
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
        this.mrn.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mrB != null) {
            this.mrB.cancel();
        }
        if (this.bKK != null && !this.bKK.isRecycled()) {
            this.bKK.recycle();
            this.bKK = null;
        }
        if (this.mrv != null) {
            this.mrv.cancel();
            this.mrv = null;
        }
        this.mru.setDialogVisiable(false);
        if (this.kGs == 12002 || this.kGs == 12001) {
            unregisterReceiver(this.mrC);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyO() {
        if (this.mrB != null) {
            this.mrB.cancel();
        }
        this.mrB = new d();
        this.mrB.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mru = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mru.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.mru.setDialogVisiable(false);
            }
        });
        this.mru.setDialogVisiable(false);
        this.mro = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.mrm) && this.bKD != 1.0f) {
            this.mro.setmCutHeightScale(this.bKD);
        }
        this.mrp = (ImageView) findViewById(R.id.preview_image);
        this.mrq = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.mrq.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.mrn = (EditHeadsImageView) findViewById(R.id.image);
        this.mrn.setCutImageHeightScale(this.bKD);
        if (this.mBitmap != null) {
            this.mrn.setImageBitmap(this.mBitmap);
        }
        this.mrn.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.mrq != null && EditHeadActivity.this.mrq.getVisibility() == 0) {
                    EditHeadActivity.this.mrp.setImageBitmap(EditHeadActivity.this.mrn.dc(false));
                }
            }
        });
        this.mrn.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.mrq != null && EditHeadActivity.this.mrq.getVisibility() == 0) {
                    EditHeadActivity.this.mrp.setImageBitmap(EditHeadActivity.this.mrn.dc(false));
                }
            }
        });
        this.bKH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.mrt = (Button) findViewById(R.id.show_button);
        this.mrt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mrA.setVisibility(0);
                EditHeadActivity.this.mrt.setVisibility(8);
                EditHeadActivity.this.mry.setPadding(0, EditHeadActivity.this.mry.getPaddingTop(), EditHeadActivity.this.mry.getPaddingRight(), EditHeadActivity.this.mry.getPaddingBottom());
                EditHeadActivity.this.mry.setChecked(true);
                EditHeadActivity.this.mrx.setVisibility(8);
            }
        });
        this.mrs = (Button) findViewById(R.id.hide_button);
        this.mrs.setVisibility(0);
        this.mrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mrA.setVisibility(8);
                EditHeadActivity.this.mrt.setVisibility(0);
            }
        });
        this.bKI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bKI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.mrr == 0) {
                    if (!EditHeadActivity.this.fOz) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap dc = EditHeadActivity.this.mrn.dc(EditHeadActivity.this.mrr == 0 || EditHeadActivity.this.mrr == 3);
                if (dc != null && EditHeadActivity.this.c(str, dc)) {
                    if (EditHeadActivity.this.mrr == 0) {
                        if (EditHeadActivity.this.fOz) {
                            EditHeadActivity.this.dyO();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.mrm)) {
                                        EditHeadActivity.this.a(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mrm)) {
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
                    aVar.sL(EditHeadActivity.this.mrE);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bKI.setEnabled(false);
        this.bKL = (TextView) this.bKI.findViewById(R.id.save);
        this.bKL.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mrm)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.mrm)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mrA = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mrz = (LinearLayout) findViewById(R.id.rotate);
        this.mrx = (RadioButton) findViewById(R.id.beautify_btn);
        this.mry = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.mrx) {
                        EditHeadActivity.this.mrz.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.mry) {
                        EditHeadActivity.this.mrz.setVisibility(0);
                    }
                }
            }
        };
        this.mrx.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mry.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mrx.setChecked(true);
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
                if (!EditHeadActivity.this.mru.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bKK != null) && view.getTag() != null) {
                        EditHeadActivity.this.QD(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mrm)) {
            this.mrq.setVisibility(0);
            this.mrt.setVisibility(8);
            this.mro.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mro.setLineWidth(2);
        }
        if (!this.mrD) {
            this.mrt.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD(String str) {
        if (this.mrw != null) {
            this.mrw.cancel();
        }
        this.mrw = new a();
        this.mrw.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Exception e;
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            try {
                Bitmap image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (image.getWidth() > 1800 || image.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(image, 1800);
                        try {
                            image.recycle();
                            bitmap = resizeBitmap;
                        } catch (Exception e2) {
                            e = e2;
                            bitmap2 = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap2;
                        }
                    } else {
                        bitmap = image;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap2 = image;
                }
                try {
                    if (!isCancelled() || bitmap == null || bitmap.isRecycled()) {
                        return bitmap;
                    }
                    bitmap.recycle();
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    bitmap2 = bitmap;
                    BdLog.e(e.toString());
                    return bitmap2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mru.setDialogVisiable(true);
            EditHeadActivity.this.bKI.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.mrv = null;
            EditHeadActivity.this.mru.setDialogVisiable(false);
            EditHeadActivity.this.bKI.setClickable(true);
            EditHeadActivity.this.bKI.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.mrv = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mru.setDialogVisiable(false);
            EditHeadActivity.this.bKI.setClickable(true);
            EditHeadActivity.this.bKI.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mrn.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mrn.setImageBitmap(bitmap);
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
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String mrI;
        private Boolean mrJ = false;
        private Boolean mrK = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mru.setDialogVisiable(true);
            EditHeadActivity.this.bKI.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            this.mrI = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bKK == null) {
                return null;
            }
            if (this.mrI.equals("0") || this.mrI.equals("1")) {
                this.mrJ = true;
            } else if (this.mrI.equals("2") || this.mrI.equals("3")) {
                this.mrK = true;
            }
            if (this.mrJ.booleanValue() || this.mrK.booleanValue()) {
                if (EditHeadActivity.this.bKK != null) {
                    this.bitmap = EditHeadActivity.this.bKK.copy(EditHeadActivity.this.bKK.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.mrJ.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mrI));
            } else if (this.mrK.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mrI));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bKK != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mru.setDialogVisiable(false);
            EditHeadActivity.this.bKI.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mru.setDialogVisiable(false);
            EditHeadActivity.this.bKI.setClickable(true);
            EditHeadActivity.this.bKI.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.mrJ.booleanValue() || this.mrK.booleanValue()) {
                    EditHeadActivity.this.mrn.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.mrJ.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mrI));
                    } else if (this.mrK.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mrI));
                    }
                } else {
                    EditHeadActivity.this.mrn.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bKK != null && !EditHeadActivity.this.bKK.isRecycled()) {
                    EditHeadActivity.this.bKK.recycle();
                }
                EditHeadActivity.this.bKK = bitmap;
            }
        }
    }

    private void cWn() {
        this.mrC = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.mrC, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            if (EditHeadActivity.this.bKI != null) {
                EditHeadActivity.this.bKI.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
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
    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private z mNetwork;

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
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.BU(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.mrB = null;
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
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mrm)) {
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
