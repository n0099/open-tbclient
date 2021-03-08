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
/* loaded from: classes7.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bLf;
    private View bLg;
    private TextView bLj;
    private int kMi;
    private NavigationBar mNavigationBar;
    private String mxY;
    private ImageView myb;
    private FrameLayout myc;
    private RadioButton myj;
    private RadioButton myk;
    private int myq;
    private HashMap<String, Bitmap> myr;
    private HashMap<String, ImageView> mys;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String mxX = "change";
    public static String FILE_NAME = "file_name";
    private float bLb = 1.0f;
    private EditHeadsImageView mxZ = null;
    private EditHeadsImageTopLayerView mya = null;
    private Bitmap mBitmap = null;
    private int myd = 0;
    private Button mye = null;
    private Button myf = null;
    private com.baidu.tbadk.core.view.a myg = null;
    private b myh = null;
    private a myi = null;
    private LinearLayout myl = null;
    private LinearLayout mym = null;
    private d myn = null;
    private TextView mTitle = null;
    private Bitmap bLi = null;
    private c myo = null;
    private boolean fND = true;
    private boolean myp = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.myd = intent.getIntExtra("edit_type", 0);
        this.kMi = intent.getIntExtra("request", 0);
        this.fND = intent.getBooleanExtra("need_upload", true);
        this.myp = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.myq = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bLb = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.mxY = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kMi == 12002 || this.kMi == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kMi, intent.getData(), av.bsV().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kMi, null, av.bsV().getPostImageSize(), 0, stringExtra);
            }
            cUI();
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
        dxu();
    }

    private void dxu() {
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bLf);
        getLayoutMode().onModeChanged(this.bLg);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ap.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ap.setViewTextColor(this.bLj, R.color.CAM_X0111, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.myh != null) {
            this.myh.cancel();
        }
        this.mxZ.setImageDrawable(null);
        dxv();
    }

    private void dxv() {
        if (this.mys != null) {
            for (Map.Entry<String, ImageView> entry : this.mys.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.mys.clear();
            this.mys = null;
        }
        if (this.myr != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.myr.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.myr.clear();
            this.myr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.myh != null) {
            this.myh.cancel();
        }
        this.myh = new b();
        this.myh.execute(new Object[0]);
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
        this.mxZ.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.myn != null) {
            this.myn.cancel();
        }
        if (this.bLi != null && !this.bLi.isRecycled()) {
            this.bLi.recycle();
            this.bLi = null;
        }
        if (this.myh != null) {
            this.myh.cancel();
            this.myh = null;
        }
        this.myg.setDialogVisiable(false);
        if (this.kMi == 12002 || this.kMi == 12001) {
            unregisterReceiver(this.myo);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxw() {
        if (this.myn != null) {
            this.myn.cancel();
        }
        this.myn = new d();
        this.myn.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.myg = new com.baidu.tbadk.core.view.a(getPageContext());
        this.myg.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.myg.setDialogVisiable(false);
            }
        });
        this.myg.setDialogVisiable(false);
        this.mya = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.mxY) && this.bLb != 1.0f) {
            this.mya.setmCutHeightScale(this.bLb);
        }
        this.myb = (ImageView) findViewById(R.id.preview_image);
        this.myc = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.myc.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.mxZ = (EditHeadsImageView) findViewById(R.id.image);
        this.mxZ.setCutImageHeightScale(this.bLb);
        if (this.mBitmap != null) {
            this.mxZ.setImageBitmap(this.mBitmap);
        }
        this.mxZ.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.myc != null && EditHeadActivity.this.myc.getVisibility() == 0) {
                    EditHeadActivity.this.myb.setImageBitmap(EditHeadActivity.this.mxZ.dg(false));
                }
            }
        });
        this.mxZ.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.myc != null && EditHeadActivity.this.myc.getVisibility() == 0) {
                    EditHeadActivity.this.myb.setImageBitmap(EditHeadActivity.this.mxZ.dg(false));
                }
            }
        });
        this.bLf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.myf = (Button) findViewById(R.id.show_button);
        this.myf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mym.setVisibility(0);
                EditHeadActivity.this.myf.setVisibility(8);
                EditHeadActivity.this.myk.setPadding(0, EditHeadActivity.this.myk.getPaddingTop(), EditHeadActivity.this.myk.getPaddingRight(), EditHeadActivity.this.myk.getPaddingBottom());
                EditHeadActivity.this.myk.setChecked(true);
                EditHeadActivity.this.myj.setVisibility(8);
            }
        });
        this.mye = (Button) findViewById(R.id.hide_button);
        this.mye.setVisibility(0);
        this.mye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mym.setVisibility(8);
                EditHeadActivity.this.myf.setVisibility(0);
            }
        });
        this.bLg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.myd == 0) {
                    if (!EditHeadActivity.this.fND) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap dg = EditHeadActivity.this.mxZ.dg(EditHeadActivity.this.myd == 0 || EditHeadActivity.this.myd == 3);
                if (dg != null && EditHeadActivity.this.c(str, dg)) {
                    if (EditHeadActivity.this.myd == 0) {
                        if (EditHeadActivity.this.fND) {
                            EditHeadActivity.this.dxw();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.mxY)) {
                                        EditHeadActivity.this.a(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mxY)) {
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
                    aVar.rl(EditHeadActivity.this.myq);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bLg.setEnabled(false);
        this.bLj = (TextView) this.bLg.findViewById(R.id.save);
        this.bLj.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mxY)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.mxY)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mym = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.myl = (LinearLayout) findViewById(R.id.rotate);
        this.myj = (RadioButton) findViewById(R.id.beautify_btn);
        this.myk = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.myj) {
                        EditHeadActivity.this.myl.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.myk) {
                        EditHeadActivity.this.myl.setVisibility(0);
                    }
                }
            }
        };
        this.myj.setOnCheckedChangeListener(onCheckedChangeListener);
        this.myk.setOnCheckedChangeListener(onCheckedChangeListener);
        this.myj.setChecked(true);
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
                if (!EditHeadActivity.this.myg.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bLi != null) && view.getTag() != null) {
                        EditHeadActivity.this.Qt(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mxY)) {
            this.myc.setVisibility(0);
            this.myf.setVisibility(8);
            this.mya.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mya.setLineWidth(2);
        }
        if (!this.myp) {
            this.myf.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qt(String str) {
        if (this.myi != null) {
            this.myi.cancel();
        }
        this.myi = new a();
        this.myi.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
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
            EditHeadActivity.this.myg.setDialogVisiable(true);
            EditHeadActivity.this.bLg.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.myh = null;
            EditHeadActivity.this.myg.setDialogVisiable(false);
            EditHeadActivity.this.bLg.setClickable(true);
            EditHeadActivity.this.bLg.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.myh = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.myg.setDialogVisiable(false);
            EditHeadActivity.this.bLg.setClickable(true);
            EditHeadActivity.this.bLg.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mxZ.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mxZ.setImageBitmap(bitmap);
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
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String myu;
        private Boolean myv = false;
        private Boolean myw = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.myg.setDialogVisiable(true);
            EditHeadActivity.this.bLg.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            this.myu = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bLi == null) {
                return null;
            }
            if (this.myu.equals("0") || this.myu.equals("1")) {
                this.myv = true;
            } else if (this.myu.equals("2") || this.myu.equals("3")) {
                this.myw = true;
            }
            if (this.myv.booleanValue() || this.myw.booleanValue()) {
                if (EditHeadActivity.this.bLi != null) {
                    this.bitmap = EditHeadActivity.this.bLi.copy(EditHeadActivity.this.bLi.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.myv.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.myu));
            } else if (this.myw.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.myu));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bLi != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.myg.setDialogVisiable(false);
            EditHeadActivity.this.bLg.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.myg.setDialogVisiable(false);
            EditHeadActivity.this.bLg.setClickable(true);
            EditHeadActivity.this.bLg.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.myv.booleanValue() || this.myw.booleanValue()) {
                    EditHeadActivity.this.mxZ.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.myv.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.myu));
                    } else if (this.myw.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.myu));
                    }
                } else {
                    EditHeadActivity.this.mxZ.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bLi != null && !EditHeadActivity.this.bLi.isRecycled()) {
                    EditHeadActivity.this.bLi.recycle();
                }
                EditHeadActivity.this.bLi = bitmap;
            }
        }
    }

    private void cUI() {
        this.myo = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.myo, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
            if (EditHeadActivity.this.bLg != null) {
                EditHeadActivity.this.bLg.setEnabled(false);
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
    /* loaded from: classes7.dex */
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
                str = this.mNetwork.Bg(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                if (this.mNetwork.bsu().bte().isRequestSuccess()) {
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
            EditHeadActivity.this.myn = null;
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
                if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mxY)) {
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
