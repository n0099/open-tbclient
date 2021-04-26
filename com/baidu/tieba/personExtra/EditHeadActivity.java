package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import d.a.i0.b0.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    public static final String ACCOUNTDATA = "account_data";
    public static String CHANGE_FLAG = "change";
    public static final int CHANNEL_AVATAR = 3;
    public static final int CHANNEL_COVER = 4;
    public static String DELET_FLAG = "delete";
    public static final String EDITTYPE = "edit_type";
    public static String FILE_NAME = "file_name";
    public static final String FILTER_NAME_NORMAL = "normal";
    public static final String FLUTTER_ACTION = "com.tieba.action.ImagePickerPlugin";
    public static final String FORUMID = "forumid";
    public static final String FORUMNAME = "foruimname";
    public static final String FROM = "from";
    public static final String FROMCODE = "request";
    public static final int GROUP_PHOTO_WALL = 2;
    public static final int GROUP_TYPE = 1;
    public static final int PERSON_TYPE = 0;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static final int PREVIEW_IMAGE_WIDTH = 300;
    public static final String THREADID = "threadid";
    public String fromWhere;
    public RadioButton mBtnBeautify;
    public RadioButton mBtnRotate;
    public TextView mDone;
    public ImageView mImagePreview;
    public NavigationBar mNavigationBar;
    public FrameLayout mPreviewLayout;
    public View mTitleLeftButton;
    public View mTitleRightButton;
    public HashMap<String, Bitmap> previewBitmaps;
    public HashMap<String, ImageView> previewImageView;
    public int requestCode;
    public int wasterMaskType;
    public float mCutImageHeightScale = 1.0f;
    public EditHeadsImageView mImage = null;
    public EditHeadsImageTopLayerView mTopLayerView = null;
    public Bitmap mBitmap = null;
    public int mEditType = 0;
    public Button mHide = null;
    public Button mShow = null;
    public d.a.i0.r.f0.a mProgress = null;
    public k mTask = null;
    public j mFilterTask = null;
    public LinearLayout mRotateView = null;
    public LinearLayout mBeautifyRotateView = null;
    public m mHeadModifyTask = null;
    public TextView mTitle = null;
    public Bitmap mPreparedBitmap = null;
    public l receiver = null;
    public boolean needUpload = true;
    public boolean needPaste = true;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            EditHeadActivity.this.mProgress.h(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DragImageView.k {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            if (EditHeadActivity.this.mPreviewLayout == null || EditHeadActivity.this.mPreviewLayout.getVisibility() != 0) {
                return;
            }
            EditHeadActivity.this.mImagePreview.setImageBitmap(EditHeadActivity.this.mImage.v0(false));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DragImageView.j {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.j
        public void a(DragImageView dragImageView, int i2, int i3) {
            if (EditHeadActivity.this.mPreviewLayout == null || EditHeadActivity.this.mPreviewLayout.getVisibility() != 0) {
                return;
            }
            EditHeadActivity.this.mImagePreview.setImageBitmap(EditHeadActivity.this.mImage.v0(false));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditHeadActivity.this.setResult(0);
            EditHeadActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditHeadActivity.this.mBeautifyRotateView.setVisibility(0);
            EditHeadActivity.this.mShow.setVisibility(8);
            EditHeadActivity.this.mBtnRotate.setPadding(0, EditHeadActivity.this.mBtnRotate.getPaddingTop(), EditHeadActivity.this.mBtnRotate.getPaddingRight(), EditHeadActivity.this.mBtnRotate.getPaddingBottom());
            EditHeadActivity.this.mBtnRotate.setChecked(true);
            EditHeadActivity.this.mBtnBeautify.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditHeadActivity.this.mBeautifyRotateView.setVisibility(8);
            EditHeadActivity.this.mShow.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements a.d {
            public a() {
            }

            @Override // d.a.i0.b0.a.d
            public void a(String str, ImageUploadResult imageUploadResult) {
                EditHeadActivity.this.closeLoadingDialog();
                Intent intent = EditHeadActivity.this.getIntent();
                if (imageUploadResult != null) {
                    if (imageUploadResult.error_code != 0) {
                        EditHeadActivity.this.showToast(R.string.upload_pic_error, false);
                    } else {
                        PhotoUrlData photoUrlData = new PhotoUrlData();
                        photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                        ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                        if (picinfo != null) {
                            ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.bigPic;
                            if (picDetailedInfo != null) {
                                photoUrlData.setBigurl(picDetailedInfo.picUrl);
                            }
                            ImageUploadResult.PicDetailedInfo picDetailedInfo2 = imageUploadResult.picInfo.smallPic;
                            if (picDetailedInfo2 != null) {
                                photoUrlData.setSmallurl(picDetailedInfo2.picUrl);
                            }
                            ImageUploadResult.PicDetailedInfo picDetailedInfo3 = imageUploadResult.picInfo.originPic;
                            if (picDetailedInfo3 != null) {
                                photoUrlData.setOriginPic(picDetailedInfo3.picUrl);
                            }
                            if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                            }
                        }
                        if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fromWhere)) {
                            EditHeadActivity.this.sendSetCoverSuccessMessage(photoUrlData);
                        }
                        intent.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                        intent.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.fromWhere)) {
                            Intent intent2 = new Intent();
                            intent2.setAction("com.tieba.action.ImagePickerPlugin");
                            intent2.putExtra("pic_info", photoUrlData);
                            EditHeadActivity.this.sendBroadcast(intent2);
                        }
                    }
                }
                EditHeadActivity.this.setResult(-1, intent);
                EditHeadActivity.this.finish();
            }
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (EditHeadActivity.this.mEditType != 0) {
                str = TbConfig.GROUP_HEAD_FILE;
            } else {
                str = !EditHeadActivity.this.needUpload ? TbConfig.PERSON_USER_PIC_TEMP_FILE : TbConfig.PERSON_HEAD_FILE;
            }
            Bitmap v0 = EditHeadActivity.this.mImage.v0(EditHeadActivity.this.mEditType == 0 || EditHeadActivity.this.mEditType == 3);
            if (v0 == null || !EditHeadActivity.this.saveFile(str, v0)) {
                return;
            }
            if (EditHeadActivity.this.mEditType == 0) {
                if (EditHeadActivity.this.needUpload) {
                    EditHeadActivity.this.modifyHead();
                    return;
                }
                Intent intent = EditHeadActivity.this.getIntent();
                intent.putExtra("upload_image_type", 2);
                EditHeadActivity.this.setResult(-1, intent);
                EditHeadActivity.this.closeActivity();
                return;
            }
            d.a.i0.b0.a aVar = new d.a.i0.b0.a(FileHelper.getFileDireciory(str), "head");
            aVar.j();
            aVar.l(new a());
            aVar.n(EditHeadActivity.this.wasterMaskType);
            aVar.g(false);
            EditHeadActivity editHeadActivity = EditHeadActivity.this;
            editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.uploading));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {
        public h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                if (compoundButton == EditHeadActivity.this.mBtnBeautify) {
                    EditHeadActivity.this.mRotateView.setVisibility(8);
                } else if (compoundButton == EditHeadActivity.this.mBtnRotate) {
                    EditHeadActivity.this.mRotateView.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EditHeadActivity.this.mProgress.c()) {
                return;
            }
            if ((EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.mPreparedBitmap == null) || view.getTag() == null) {
                return;
            }
            EditHeadActivity.this.startFilterTask(view.getTag().toString());
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<String, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f20493a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f20494b;

        /* renamed from: c  reason: collision with root package name */
        public Boolean f20495c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f20496d;

        public j() {
            Boolean bool = Boolean.FALSE;
            this.f20495c = bool;
            this.f20496d = bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            this.f20493a = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.mPreparedBitmap == null) {
                return null;
            }
            if (!this.f20493a.equals("0") && !this.f20493a.equals("1")) {
                if (this.f20493a.equals("2") || this.f20493a.equals("3")) {
                    this.f20496d = Boolean.TRUE;
                }
            } else {
                this.f20495c = Boolean.TRUE;
            }
            if (this.f20495c.booleanValue() || this.f20496d.booleanValue()) {
                if (EditHeadActivity.this.mPreparedBitmap != null) {
                    this.f20494b = EditHeadActivity.this.mPreparedBitmap.copy(EditHeadActivity.this.mPreparedBitmap.getConfig(), true);
                } else {
                    this.f20494b = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.f20494b = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.f20495c.booleanValue()) {
                this.f20494b = BitmapHelper.rotateBitmap(this.f20494b, Integer.parseInt(this.f20493a));
            } else if (this.f20496d.booleanValue()) {
                this.f20494b = BitmapHelper.reversalBitmap(this.f20494b, Integer.parseInt(this.f20493a));
            }
            return this.f20494b;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Bitmap bitmap = this.f20494b;
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmap2 = EditHeadActivity.this.mPreparedBitmap;
                Bitmap bitmap3 = this.f20494b;
                if (bitmap2 != bitmap3) {
                    bitmap3.recycle();
                }
            }
            this.f20494b = null;
            EditHeadActivity.this.mProgress.h(false);
            EditHeadActivity.this.mTitleRightButton.setClickable(true);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mProgress.h(true);
            EditHeadActivity.this.mTitleRightButton.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mProgress.h(false);
            EditHeadActivity.this.mTitleRightButton.setClickable(true);
            EditHeadActivity.this.mTitleRightButton.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            if (this.f20495c.booleanValue() || this.f20496d.booleanValue()) {
                EditHeadActivity.this.mImage.setImageBitmap(bitmap);
                if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                    EditHeadActivity editHeadActivity = EditHeadActivity.this;
                    editHeadActivity.mBitmap = BitmapHelper.resizeBitmap(editHeadActivity.mBitmap, 1800);
                }
                if (this.f20495c.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = EditHeadActivity.this;
                    editHeadActivity2.mBitmap = BitmapHelper.rotateBitmap(editHeadActivity2.mBitmap, Integer.parseInt(this.f20493a));
                } else if (this.f20496d.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = EditHeadActivity.this;
                    editHeadActivity3.mBitmap = BitmapHelper.reversalBitmap(editHeadActivity3.mBitmap, Integer.parseInt(this.f20493a));
                }
            } else {
                EditHeadActivity.this.mImage.m0(bitmap);
            }
            if (EditHeadActivity.this.mPreparedBitmap != null && !EditHeadActivity.this.mPreparedBitmap.isRecycled()) {
                EditHeadActivity.this.mPreparedBitmap.recycle();
            }
            EditHeadActivity.this.mPreparedBitmap = bitmap;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask<Object, Integer, Bitmap> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap;
            Exception e2;
            try {
                bitmap = FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (bitmap.getWidth() > 1800 || bitmap.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 1800);
                        try {
                            bitmap.recycle();
                            bitmap = resizeBitmap;
                        } catch (Exception e3) {
                            e2 = e3;
                            bitmap = resizeBitmap;
                            BdLog.e(e2.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                        return null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            } catch (Exception e5) {
                bitmap = null;
                e2 = e5;
            }
            return bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.mTask = null;
            EditHeadActivity.this.mProgress.h(false);
            EditHeadActivity.this.mTitleRightButton.setClickable(true);
            EditHeadActivity.this.mTitleRightButton.setEnabled(true);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mProgress.h(true);
            EditHeadActivity.this.mTitleRightButton.setClickable(false);
        }

        public /* synthetic */ k(EditHeadActivity editHeadActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((k) bitmap);
            EditHeadActivity.this.mTask = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mProgress.h(false);
            EditHeadActivity.this.mTitleRightButton.setClickable(true);
            EditHeadActivity.this.mTitleRightButton.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mImage.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mImage.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends BroadcastReceiver {
        public l() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EditHeadActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(intent.getStringExtra("error"));
            if (EditHeadActivity.this.mTitleRightButton != null) {
                EditHeadActivity.this.mTitleRightButton.setEnabled(false);
            }
        }

        public /* synthetic */ l(EditHeadActivity editHeadActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class m extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20499a;

        public m() {
            this.f20499a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.mHeadModifyTask = null;
            NetWork netWork = this.f20499a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity editHeadActivity = EditHeadActivity.this;
            editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Exception e2;
            String str;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            this.f20499a = netWork;
            try {
                str = netWork.uploadImage(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e3) {
                e2 = e3;
                str = null;
            }
            try {
            } catch (Exception e4) {
                e2 = e4;
                BdLog.e(e2.getMessage());
                return str;
            }
            if (this.f20499a.getNetContext().getResponse().isRequestSuccess()) {
                return str;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            NetWork netWork = this.f20499a;
            if (netWork != null) {
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.fromWhere)) {
                        Intent intent2 = new Intent();
                        intent2.setAction("com.tieba.action.ImagePickerPlugin");
                        intent2.putExtra("isHeadImage", true);
                        EditHeadActivity.this.sendBroadcast(intent2);
                    }
                    EditHeadActivity.this.finish();
                    EditHeadActivity editHeadActivity = EditHeadActivity.this;
                    editHeadActivity.showToast(editHeadActivity.getPageContext().getString(R.string.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.f20499a.getErrorString());
            }
        }

        public /* synthetic */ m(EditHeadActivity editHeadActivity, a aVar) {
            this();
        }
    }

    private void changeNavigationSkin() {
        SkinManager.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().j(this.mTitleLeftButton);
        getLayoutMode().j(this.mTitleRightButton);
        SkinManager.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        int i2 = R.drawable.icon_topbar_return_s;
        SkinManager.setNavbarIconSrc(backImageView, i2, i2, 0);
        SkinManager.setViewTextColor(this.mDone, R.color.CAM_X0111, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        k kVar = this.mTask;
        if (kVar != null) {
            kVar.cancel();
        }
        k kVar2 = new k(this, null);
        this.mTask = kVar2;
        kVar2.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
        }
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        d.a.i0.r.f0.a aVar = new d.a.i0.r.f0.a(getPageContext());
        this.mProgress = aVar;
        aVar.e(new a());
        this.mProgress.h(false);
        this.mTopLayerView = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.fromWhere)) {
            float f2 = this.mCutImageHeightScale;
            if (f2 != 1.0f) {
                this.mTopLayerView.setmCutHeightScale(f2);
            }
        }
        this.mImagePreview = (ImageView) findViewById(R.id.preview_image);
        this.mPreviewLayout = (FrameLayout) findViewById(R.id.preview_layout);
        int[] p = d.a.c.e.p.l.p(getPageContext().getPageActivity());
        this.mPreviewLayout.setY((int) (((p[1] - p[0]) * 0.4d) + p[0] + getResources().getDimensionPixelSize(R.dimen.ds74)));
        EditHeadsImageView editHeadsImageView = (EditHeadsImageView) findViewById(R.id.image);
        this.mImage = editHeadsImageView;
        editHeadsImageView.setCutImageHeightScale(this.mCutImageHeightScale);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mImage.setImageBitmap(bitmap);
        }
        this.mImage.setOnSizeChangedListener(new b());
        this.mImage.setOnImageScrollListener(new c());
        this.mTitleLeftButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        Button button = (Button) findViewById(R.id.show_button);
        this.mShow = button;
        button.setOnClickListener(new e());
        Button button2 = (Button) findViewById(R.id.hide_button);
        this.mHide = button2;
        button2.setVisibility(0);
        this.mHide.setOnClickListener(new f());
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.mTitleRightButton = addCustomView;
        addCustomView.setOnClickListener(new g());
        this.mTitleRightButton.setEnabled(false);
        TextView textView = (TextView) this.mTitleRightButton.findViewById(R.id.save);
        this.mDone = textView;
        textView.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.fromWhere)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.fromWhere)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mBeautifyRotateView = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mRotateView = (LinearLayout) findViewById(R.id.rotate);
        this.mBtnBeautify = (RadioButton) findViewById(R.id.beautify_btn);
        this.mBtnRotate = (RadioButton) findViewById(R.id.rotate_btn);
        h hVar = new h();
        this.mBtnBeautify.setOnCheckedChangeListener(hVar);
        this.mBtnRotate.setOnCheckedChangeListener(hVar);
        this.mBtnBeautify.setChecked(true);
        Button button3 = (Button) findViewById(R.id.rotate_left);
        Button button4 = (Button) findViewById(R.id.rotate_right);
        Button button5 = (Button) findViewById(R.id.rotate_left_right);
        Button button6 = (Button) findViewById(R.id.rotate_up_down);
        button3.setTag(0);
        button4.setTag(1);
        button5.setTag(2);
        button6.setTag(3);
        i iVar = new i();
        button3.setOnClickListener(iVar);
        button4.setOnClickListener(iVar);
        button5.setOnClickListener(iVar);
        button6.setOnClickListener(iVar);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.fromWhere)) {
            this.mPreviewLayout.setVisibility(0);
            this.mShow.setVisibility(8);
            this.mTopLayerView.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mTopLayerView.setLineWidth(2);
        }
        if (this.needPaste) {
            return;
        }
        this.mShow.setVisibility(8);
        this.mTitle.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyHead() {
        m mVar = this.mHeadModifyTask;
        if (mVar != null) {
            mVar.cancel();
        }
        m mVar2 = new m(this, null);
        this.mHeadModifyTask = mVar2;
        mVar2.execute(new String[0]);
    }

    private void regReceiver() {
        this.receiver = new l(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.receiver, intentFilter);
    }

    private void releasePreviewResouce() {
        HashMap<String, ImageView> hashMap = this.previewImageView;
        if (hashMap != null) {
            for (Map.Entry<String, ImageView> entry : hashMap.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.previewImageView.clear();
            this.previewImageView = null;
        }
        HashMap<String, Bitmap> hashMap2 = this.previewBitmaps;
        if (hashMap2 != null) {
            for (Map.Entry<String, Bitmap> entry2 : hashMap2.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.previewBitmaps.clear();
            this.previewBitmaps = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str, Bitmap bitmap) {
        try {
            FileHelper.SaveFile(null, str, bitmap, 80);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetCoverSuccessMessage(PhotoUrlData photoUrlData) {
        Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
        intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
        getPageContext().getPageActivity().sendBroadcast(intent);
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4, String str) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i2);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i4);
        intent.putExtra(FILE_NAME, str);
        intent.setData(uri);
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFilterTask(String str) {
        j jVar = this.mFilterTask;
        if (jVar != null) {
            jVar.cancel();
        }
        j jVar2 = new j();
        this.mFilterTask = jVar2;
        jVar2.execute(str);
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        changeNavigationSkin();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.mEditType = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.needUpload = intent.getBooleanExtra("need_upload", true);
        this.needPaste = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.wasterMaskType = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.mCutImageHeightScale = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fromWhere = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        int i2 = this.requestCode;
        if (i2 != 12002 && i2 != 12001) {
            initUI();
            initData();
            return;
        }
        initUI();
        if (intent.getData() != null) {
            TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), TbImageHelper.getInstance().getPostImageSize());
        } else {
            TiebaPrepareImageService.StartService(this.requestCode, null, TbImageHelper.getInstance().getPostImageSize(), 0, stringExtra);
        }
        regReceiver();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.mImage.c0();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        m mVar = this.mHeadModifyTask;
        if (mVar != null) {
            mVar.cancel();
        }
        Bitmap bitmap2 = this.mPreparedBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mPreparedBitmap.recycle();
            this.mPreparedBitmap = null;
        }
        k kVar = this.mTask;
        if (kVar != null) {
            kVar.cancel();
            this.mTask = null;
        }
        this.mProgress.h(false);
        int i2 = this.requestCode;
        if (i2 == 12002 || i2 == 12001) {
            unregisterReceiver(this.receiver);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        k kVar = this.mTask;
        if (kVar != null) {
            kVar.cancel();
        }
        this.mImage.setImageDrawable(null);
        releasePreviewResouce();
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i2);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i4);
        intent.setData(uri);
        activity.startActivityForResult(intent, i3);
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData) {
        startActivityForResult(activity, i2, i3, uri, accountData, 0);
    }
}
