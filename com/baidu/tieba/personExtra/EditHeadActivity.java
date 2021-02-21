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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.o;
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
    private View bJF;
    private View bJG;
    private TextView bJJ;
    private int kKg;
    private NavigationBar mNavigationBar;
    private String mvW;
    private ImageView mvZ;
    private FrameLayout mwa;
    private RadioButton mwh;
    private RadioButton mwi;
    private int mwo;
    private HashMap<String, Bitmap> mwp;
    private HashMap<String, ImageView> mwq;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String mvV = "change";
    public static String FILE_NAME = "file_name";
    private float bJB = 1.0f;
    private EditHeadsImageView mvX = null;
    private EditHeadsImageTopLayerView mvY = null;
    private Bitmap mBitmap = null;
    private int mwb = 0;
    private Button mwc = null;
    private Button mwd = null;
    private com.baidu.tbadk.core.view.a mwe = null;
    private b mwf = null;
    private a mwg = null;
    private LinearLayout mwj = null;
    private LinearLayout mwk = null;
    private d mwl = null;
    private TextView mTitle = null;
    private Bitmap bJI = null;
    private c mwm = null;
    private boolean fMd = true;
    private boolean mwn = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.mwb = intent.getIntExtra("edit_type", 0);
        this.kKg = intent.getIntExtra("request", 0);
        this.fMd = intent.getBooleanExtra("need_upload", true);
        this.mwn = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.mwo = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bJB = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.mvW = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kKg == 12002 || this.kKg == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kKg, intent.getData(), av.bsS().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kKg, null, av.bsS().getPostImageSize(), 0, stringExtra);
            }
            cUB();
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
        dxl();
    }

    private void dxl() {
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bJF);
        getLayoutMode().onModeChanged(this.bJG);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ap.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ap.setViewTextColor(this.bJJ, R.color.CAM_X0111, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.mwf != null) {
            this.mwf.cancel();
        }
        this.mvX.setImageDrawable(null);
        dxm();
    }

    private void dxm() {
        if (this.mwq != null) {
            for (Map.Entry<String, ImageView> entry : this.mwq.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.mwq.clear();
            this.mwq = null;
        }
        if (this.mwp != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.mwp.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.mwp.clear();
            this.mwp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mwf != null) {
            this.mwf.cancel();
        }
        this.mwf = new b();
        this.mwf.execute(new Object[0]);
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
        this.mvX.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mwl != null) {
            this.mwl.cancel();
        }
        if (this.bJI != null && !this.bJI.isRecycled()) {
            this.bJI.recycle();
            this.bJI = null;
        }
        if (this.mwf != null) {
            this.mwf.cancel();
            this.mwf = null;
        }
        this.mwe.setDialogVisiable(false);
        if (this.kKg == 12002 || this.kKg == 12001) {
            unregisterReceiver(this.mwm);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxn() {
        if (this.mwl != null) {
            this.mwl.cancel();
        }
        this.mwl = new d();
        this.mwl.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mwe = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mwe.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.mwe.setDialogVisiable(false);
            }
        });
        this.mwe.setDialogVisiable(false);
        this.mvY = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.mvW) && this.bJB != 1.0f) {
            this.mvY.setmCutHeightScale(this.bJB);
        }
        this.mvZ = (ImageView) findViewById(R.id.preview_image);
        this.mwa = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.mwa.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.mvX = (EditHeadsImageView) findViewById(R.id.image);
        this.mvX.setCutImageHeightScale(this.bJB);
        if (this.mBitmap != null) {
            this.mvX.setImageBitmap(this.mBitmap);
        }
        this.mvX.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.mwa != null && EditHeadActivity.this.mwa.getVisibility() == 0) {
                    EditHeadActivity.this.mvZ.setImageBitmap(EditHeadActivity.this.mvX.dg(false));
                }
            }
        });
        this.mvX.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.mwa != null && EditHeadActivity.this.mwa.getVisibility() == 0) {
                    EditHeadActivity.this.mvZ.setImageBitmap(EditHeadActivity.this.mvX.dg(false));
                }
            }
        });
        this.bJF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.mwd = (Button) findViewById(R.id.show_button);
        this.mwd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mwk.setVisibility(0);
                EditHeadActivity.this.mwd.setVisibility(8);
                EditHeadActivity.this.mwi.setPadding(0, EditHeadActivity.this.mwi.getPaddingTop(), EditHeadActivity.this.mwi.getPaddingRight(), EditHeadActivity.this.mwi.getPaddingBottom());
                EditHeadActivity.this.mwi.setChecked(true);
                EditHeadActivity.this.mwh.setVisibility(8);
            }
        });
        this.mwc = (Button) findViewById(R.id.hide_button);
        this.mwc.setVisibility(0);
        this.mwc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mwk.setVisibility(8);
                EditHeadActivity.this.mwd.setVisibility(0);
            }
        });
        this.bJG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.mwb == 0) {
                    if (!EditHeadActivity.this.fMd) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap dg = EditHeadActivity.this.mvX.dg(EditHeadActivity.this.mwb == 0 || EditHeadActivity.this.mwb == 3);
                if (dg != null && EditHeadActivity.this.c(str, dg)) {
                    if (EditHeadActivity.this.mwb == 0) {
                        if (EditHeadActivity.this.fMd) {
                            EditHeadActivity.this.dxn();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(o.getFileDireciory(str), "head");
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.mvW)) {
                                        EditHeadActivity.this.a(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mvW)) {
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
                    aVar.rk(EditHeadActivity.this.mwo);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bJG.setEnabled(false);
        this.bJJ = (TextView) this.bJG.findViewById(R.id.save);
        this.bJJ.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mvW)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.mvW)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mwk = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mwj = (LinearLayout) findViewById(R.id.rotate);
        this.mwh = (RadioButton) findViewById(R.id.beautify_btn);
        this.mwi = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.mwh) {
                        EditHeadActivity.this.mwj.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.mwi) {
                        EditHeadActivity.this.mwj.setVisibility(0);
                    }
                }
            }
        };
        this.mwh.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mwi.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mwh.setChecked(true);
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
                if (!EditHeadActivity.this.mwe.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bJI != null) && view.getTag() != null) {
                        EditHeadActivity.this.Qn(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mvW)) {
            this.mwa.setVisibility(0);
            this.mwd.setVisibility(8);
            this.mvY.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mvY.setLineWidth(2);
        }
        if (!this.mwn) {
            this.mwd.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn(String str) {
        if (this.mwg != null) {
            this.mwg.cancel();
        }
        this.mwg = new a();
        this.mwg.execute(str);
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
                Bitmap image = o.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
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
            EditHeadActivity.this.mwe.setDialogVisiable(true);
            EditHeadActivity.this.bJG.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.mwf = null;
            EditHeadActivity.this.mwe.setDialogVisiable(false);
            EditHeadActivity.this.bJG.setClickable(true);
            EditHeadActivity.this.bJG.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.mwf = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mwe.setDialogVisiable(false);
            EditHeadActivity.this.bJG.setClickable(true);
            EditHeadActivity.this.bJG.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mvX.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mvX.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            o.a(null, str, bitmap, 80);
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
        private String mws;
        private Boolean mwt = false;
        private Boolean mwu = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mwe.setDialogVisiable(true);
            EditHeadActivity.this.bJG.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            this.mws = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bJI == null) {
                return null;
            }
            if (this.mws.equals("0") || this.mws.equals("1")) {
                this.mwt = true;
            } else if (this.mws.equals("2") || this.mws.equals("3")) {
                this.mwu = true;
            }
            if (this.mwt.booleanValue() || this.mwu.booleanValue()) {
                if (EditHeadActivity.this.bJI != null) {
                    this.bitmap = EditHeadActivity.this.bJI.copy(EditHeadActivity.this.bJI.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.mwt.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mws));
            } else if (this.mwu.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mws));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bJI != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mwe.setDialogVisiable(false);
            EditHeadActivity.this.bJG.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mwe.setDialogVisiable(false);
            EditHeadActivity.this.bJG.setClickable(true);
            EditHeadActivity.this.bJG.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.mwt.booleanValue() || this.mwu.booleanValue()) {
                    EditHeadActivity.this.mvX.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.mwt.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mws));
                    } else if (this.mwu.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mws));
                    }
                } else {
                    EditHeadActivity.this.mvX.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bJI != null && !EditHeadActivity.this.bJI.isRecycled()) {
                    EditHeadActivity.this.bJI.recycle();
                }
                EditHeadActivity.this.bJI = bitmap;
            }
        }
    }

    private void cUB() {
        this.mwm = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.mwm, intentFilter);
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
            if (EditHeadActivity.this.bJG != null) {
                EditHeadActivity.this.bJG.setEnabled(false);
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
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.AZ(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                if (this.mNetwork.bsr().btb().isRequestSuccess()) {
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
            EditHeadActivity.this.mwl = null;
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
                if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mvW)) {
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
