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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j35;
import com.repackage.oi;
import com.repackage.xt4;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public String fromWhere;
    public LinearLayout mBeautifyRotateView;
    public Bitmap mBitmap;
    public RadioButton mBtnBeautify;
    public RadioButton mBtnRotate;
    public float mCutImageHeightScale;
    public TextView mDone;
    public int mEditType;
    public j mFilterTask;
    public m mHeadModifyTask;
    public Button mHide;
    public EditHeadsImageView mImage;
    public ImageView mImagePreview;
    public NavigationBar mNavigationBar;
    public Bitmap mPreparedBitmap;
    public FrameLayout mPreviewLayout;
    public xt4 mProgress;
    public LinearLayout mRotateView;
    public Button mShow;
    public k mTask;
    public TextView mTitle;
    public View mTitleLeftButton;
    public View mTitleRightButton;
    public EditHeadsImageTopLayerView mTopLayerView;
    public boolean needPaste;
    public boolean needUpload;
    public HashMap<String, Bitmap> previewBitmaps;
    public HashMap<String, ImageView> previewImageView;
    public l receiver;
    public int requestCode;
    public int wasterMaskType;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public a(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.mProgress.h(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public b(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a.mPreviewLayout != null && this.a.mPreviewLayout.getVisibility() == 0) {
                this.a.mImagePreview.setImageBitmap(this.a.mImage.v0(false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DragImageView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public c(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.j
        public void a(DragImageView dragImageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, dragImageView, i, i2) == null) && this.a.mPreviewLayout != null && this.a.mPreviewLayout.getVisibility() == 0) {
                this.a.mImagePreview.setImageBitmap(this.a.mImage.v0(false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public d(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public e(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mBeautifyRotateView.setVisibility(0);
                this.a.mShow.setVisibility(8);
                this.a.mBtnRotate.setPadding(0, this.a.mBtnRotate.getPaddingTop(), this.a.mBtnRotate.getPaddingRight(), this.a.mBtnRotate.getPaddingBottom());
                this.a.mBtnRotate.setChecked(true);
                this.a.mBtnBeautify.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public f(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mBeautifyRotateView.setVisibility(8);
                this.a.mShow.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        /* loaded from: classes3.dex */
        public class a implements j35.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.repackage.j35.d
            public void a(String str, ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                    this.a.a.closeLoadingDialog();
                    Intent intent = this.a.a.getIntent();
                    if (imageUploadResult != null) {
                        if (imageUploadResult.error_code != 0) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f149b, false);
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
                            if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(this.a.a.fromWhere)) {
                                this.a.a.sendSetCoverSuccessMessage(photoUrlData);
                            }
                            intent.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                            intent.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                            if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.a.a.fromWhere)) {
                                Intent intent2 = new Intent();
                                intent2.setAction(EditHeadActivity.FLUTTER_ACTION);
                                intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
                                intent2.putExtra("pic_info", photoUrlData);
                                this.a.a.sendBroadcast(intent2);
                            }
                        }
                    }
                    this.a.a.setResult(-1, intent);
                    this.a.a.finish();
                }
            }
        }

        public g(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mEditType == 4) {
                    TiebaStatic.log(new StatisticItem("c14449").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.a.mEditType != 0) {
                    str = TbConfig.GROUP_HEAD_FILE;
                } else {
                    str = !this.a.needUpload ? TbConfig.PERSON_USER_PIC_TEMP_FILE : TbConfig.PERSON_HEAD_FILE;
                }
                Bitmap v0 = this.a.mImage.v0(this.a.mEditType == 0 || this.a.mEditType == 3);
                if (v0 == null || !this.a.saveFile(str, v0)) {
                    return;
                }
                if (this.a.mEditType == 0) {
                    if (this.a.needUpload) {
                        this.a.modifyHead();
                        return;
                    }
                    Intent intent = this.a.getIntent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.closeActivity();
                    return;
                }
                j35 j35Var = new j35(FileHelper.getFileDireciory(str), "head");
                j35Var.j();
                j35Var.l(new a(this));
                j35Var.n(this.a.wasterMaskType);
                j35Var.g(false);
                EditHeadActivity editHeadActivity = this.a;
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f149d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public h(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.a.mBtnBeautify) {
                    this.a.mRotateView.setVisibility(8);
                } else if (compoundButton == this.a.mBtnRotate) {
                    this.a.mRotateView.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public i(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mProgress.c()) {
                return;
            }
            if ((this.a.mBitmap == null && this.a.mPreparedBitmap == null) || view2.getTag() == null) {
                return;
            }
            this.a.startFilterTask(view2.getTag().toString());
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<String, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Bitmap b;
        public Boolean c;
        public Boolean d;
        public final /* synthetic */ EditHeadActivity e;

        public j(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = editHeadActivity;
            Boolean bool = Boolean.FALSE;
            this.c = bool;
            this.d = bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = strArr[0];
                if (this.e.mBitmap == null && this.e.mPreparedBitmap == null) {
                    return null;
                }
                if (!this.a.equals("0") && !this.a.equals("1")) {
                    if (this.a.equals("2") || this.a.equals("3")) {
                        this.d = Boolean.TRUE;
                    }
                } else {
                    this.c = Boolean.TRUE;
                }
                if (this.c.booleanValue() || this.d.booleanValue()) {
                    if (this.e.mPreparedBitmap != null) {
                        this.b = this.e.mPreparedBitmap.copy(this.e.mPreparedBitmap.getConfig(), true);
                    } else {
                        this.b = this.e.mBitmap.copy(this.e.mBitmap.getConfig(), true);
                    }
                } else {
                    this.b = this.e.mBitmap.copy(this.e.mBitmap.getConfig(), true);
                }
                if (this.c.booleanValue()) {
                    this.b = BitmapHelper.rotateBitmap(this.b, Integer.parseInt(this.a));
                } else if (this.d.booleanValue()) {
                    this.b = BitmapHelper.reversalBitmap(this.b, Integer.parseInt(this.a));
                }
                return this.b;
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Bitmap bitmap = this.b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.e.mPreparedBitmap;
                    Bitmap bitmap3 = this.b;
                    if (bitmap2 != bitmap3) {
                        bitmap3.recycle();
                    }
                }
                this.b = null;
                this.e.mProgress.h(false);
                this.e.mTitleRightButton.setClickable(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.e.mProgress.h(true);
                this.e.mTitleRightButton.setEnabled(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.e.mProgress.h(false);
                this.e.mTitleRightButton.setClickable(true);
                this.e.mTitleRightButton.setEnabled(true);
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                if (this.c.booleanValue() || this.d.booleanValue()) {
                    this.e.mImage.setImageBitmap(bitmap);
                    if (this.e.mBitmap.getWidth() > 1800 || this.e.mBitmap.getHeight() > 1800) {
                        EditHeadActivity editHeadActivity = this.e;
                        editHeadActivity.mBitmap = BitmapHelper.resizeBitmap(editHeadActivity.mBitmap, 1800);
                    }
                    if (this.c.booleanValue()) {
                        EditHeadActivity editHeadActivity2 = this.e;
                        editHeadActivity2.mBitmap = BitmapHelper.rotateBitmap(editHeadActivity2.mBitmap, Integer.parseInt(this.a));
                    } else if (this.d.booleanValue()) {
                        EditHeadActivity editHeadActivity3 = this.e;
                        editHeadActivity3.mBitmap = BitmapHelper.reversalBitmap(editHeadActivity3.mBitmap, Integer.parseInt(this.a));
                    }
                } else {
                    this.e.mImage.m0(bitmap);
                }
                if (this.e.mPreparedBitmap != null && !this.e.mPreparedBitmap.isRecycled()) {
                    this.e.mPreparedBitmap.recycle();
                }
                this.e.mPreparedBitmap = bitmap;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity a;

        public k(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Bitmap bitmap;
            Exception e;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    bitmap = FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                    try {
                        if (bitmap.getWidth() > 1800 || bitmap.getHeight() > 1800) {
                            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bitmap, 1800);
                            try {
                                bitmap.recycle();
                                bitmap = resizeBitmap;
                            } catch (Exception e2) {
                                e = e2;
                                bitmap = resizeBitmap;
                                BdLog.e(e.toString());
                                return bitmap;
                            }
                        }
                        if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                            return null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    bitmap = null;
                    e = e4;
                }
                return bitmap;
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mTask = null;
                this.a.mProgress.h(false);
                this.a.mTitleRightButton.setClickable(true);
                this.a.mTitleRightButton.setEnabled(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.mProgress.h(true);
                this.a.mTitleRightButton.setClickable(false);
            }
        }

        public /* synthetic */ k(EditHeadActivity editHeadActivity, a aVar) {
            this(editHeadActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((k) bitmap);
                this.a.mTask = null;
                this.a.mBitmap = bitmap;
                this.a.mProgress.h(false);
                this.a.mTitleRightButton.setClickable(true);
                this.a.mTitleRightButton.setEnabled(true);
                if (bitmap == null || bitmap.isRecycled()) {
                    this.a.mImage.setImageDrawable(null);
                } else if (bitmap != null) {
                    this.a.mImage.setImageBitmap(bitmap);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadActivity this$0;

        public l(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = editHeadActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.releaseResouce();
                if (intent.getBooleanExtra("result", false)) {
                    this.this$0.initData();
                    return;
                }
                this.this$0.showToast(intent.getStringExtra("error"));
                if (this.this$0.mTitleRightButton != null) {
                    this.this$0.mTitleRightButton.setEnabled(false);
                }
            }
        }

        public /* synthetic */ l(EditHeadActivity editHeadActivity, a aVar) {
            this(editHeadActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class m extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ EditHeadActivity b;

        public m(EditHeadActivity editHeadActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = editHeadActivity;
            this.a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.closeLoadingDialog();
                this.b.mHeadModifyTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                EditHeadActivity editHeadActivity = this.b;
                editHeadActivity.showLoadingDialog(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1499));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Exception e;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.a = netWork;
                try {
                    str = netWork.uploadImage(TbConfig.PERSON_HEAD_FILE);
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    return str;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.b.closeLoadingDialog();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        Intent intent = new Intent();
                        intent.putExtra("upload_image_type", 1);
                        this.b.setResult(-1, intent);
                        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.b.fromWhere)) {
                            Intent intent2 = new Intent();
                            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
                            intent2.setAction(EditHeadActivity.FLUTTER_ACTION);
                            intent2.putExtra("isHeadImage", true);
                            this.b.sendBroadcast(intent2);
                        }
                        this.b.finish();
                        EditHeadActivity editHeadActivity = this.b;
                        editHeadActivity.showToast(editHeadActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f149a));
                        return;
                    }
                    this.b.showToast(this.a.getErrorString());
                }
            }
        }

        public /* synthetic */ m(EditHeadActivity editHeadActivity, a aVar) {
            this(editHeadActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-122681184, "Lcom/baidu/tieba/personExtra/EditHeadActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-122681184, "Lcom/baidu/tieba/personExtra/EditHeadActivity;");
        }
    }

    public EditHeadActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCutImageHeightScale = 1.0f;
        this.mImage = null;
        this.mTopLayerView = null;
        this.mBitmap = null;
        this.mEditType = 0;
        this.mHide = null;
        this.mShow = null;
        this.mProgress = null;
        this.mTask = null;
        this.mFilterTask = null;
        this.mRotateView = null;
        this.mBeautifyRotateView = null;
        this.mHeadModifyTask = null;
        this.mTitle = null;
        this.mPreparedBitmap = null;
        this.receiver = null;
        this.needUpload = true;
        this.needPaste = true;
    }

    private void changeNavigationSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            SkinManager.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
            getLayoutMode().j(this.mTitleLeftButton);
            getLayoutMode().j(this.mTitleRightButton);
            SkinManager.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
            SkinManager.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
            SkinManager.setViewTextColor(this.mDone, R.color.CAM_X0111, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
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
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091515);
            xt4 xt4Var = new xt4(getPageContext());
            this.mProgress = xt4Var;
            xt4Var.e(new a(this));
            this.mProgress.h(false);
            this.mTopLayerView = (EditHeadsImageTopLayerView) findViewById(R.id.obfuscated_res_0x7f090e80);
            if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.fromWhere)) {
                float f2 = this.mCutImageHeightScale;
                if (f2 != 1.0f) {
                    this.mTopLayerView.setmCutHeightScale(f2);
                }
            }
            this.mImagePreview = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d7);
            this.mPreviewLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0918d8);
            int[] p = oi.p(getPageContext().getPageActivity());
            this.mPreviewLayout.setY((int) (((p[1] - p[0]) * 0.4d) + p[0] + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ff)));
            EditHeadsImageView editHeadsImageView = (EditHeadsImageView) findViewById(R.id.obfuscated_res_0x7f090e68);
            this.mImage = editHeadsImageView;
            editHeadsImageView.setCutImageHeightScale(this.mCutImageHeightScale);
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                this.mImage.setImageBitmap(bitmap);
            }
            this.mImage.setOnSizeChangedListener(new b(this));
            this.mImage.setOnImageScrollListener(new c(this));
            this.mTitleLeftButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f091ce3);
            this.mShow = button;
            button.setOnClickListener(new e(this));
            Button button2 = (Button) findViewById(R.id.obfuscated_res_0x7f090d56);
            this.mHide = button2;
            button2.setVisibility(0);
            this.mHide.setOnClickListener(new f(this));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03d0, (View.OnClickListener) null);
            this.mTitleRightButton = addCustomView;
            addCustomView.setOnClickListener(new g(this));
            this.mTitleRightButton.setEnabled(false);
            TextView textView = (TextView) this.mTitleRightButton.findViewById(R.id.obfuscated_res_0x7f091bd9);
            this.mDone = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f04e7);
            if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.fromWhere)) {
                this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f02f3));
            }
            if ("from_photo_live".equals(this.fromWhere)) {
                this.mTitle.setText(R.string.obfuscated_res_0x7f0f03c0);
            }
            this.mBeautifyRotateView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09035b);
            this.mRotateView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ae0);
            this.mBtnBeautify = (RadioButton) findViewById(R.id.obfuscated_res_0x7f09035a);
            this.mBtnRotate = (RadioButton) findViewById(R.id.obfuscated_res_0x7f091ae1);
            h hVar = new h(this);
            this.mBtnBeautify.setOnCheckedChangeListener(hVar);
            this.mBtnRotate.setOnCheckedChangeListener(hVar);
            this.mBtnBeautify.setChecked(true);
            Button button3 = (Button) findViewById(R.id.obfuscated_res_0x7f091ae3);
            Button button4 = (Button) findViewById(R.id.obfuscated_res_0x7f091ae5);
            Button button5 = (Button) findViewById(R.id.obfuscated_res_0x7f091ae4);
            Button button6 = (Button) findViewById(R.id.obfuscated_res_0x7f091ae6);
            button3.setTag(0);
            button4.setTag(1);
            button5.setTag(2);
            button6.setTag(3);
            i iVar = new i(this);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyHead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            m mVar = this.mHeadModifyTask;
            if (mVar != null) {
                mVar.cancel();
            }
            m mVar2 = new m(this, null);
            this.mHeadModifyTask = mVar2;
            mVar2.execute(new String[0]);
        }
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.receiver = new l(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
            registerReceiver(this.receiver, intentFilter);
        }
    }

    private void releasePreviewResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, this, str, bitmap)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(null, str, bitmap, 80);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetCoverSuccessMessage(PhotoUrlData photoUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, photoUrlData) == null) {
            Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
            intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4), str}) == null) {
            Intent intent = new Intent(activity, EditHeadActivity.class);
            intent.putExtra("request", i2);
            intent.putExtra("account_data", accountData);
            intent.putExtra("edit_type", i4);
            intent.putExtra(FILE_NAME, str);
            intent.setData(uri);
            activity.startActivityForResult(intent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFilterTask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, str) == null) {
            j jVar = this.mFilterTask;
            if (jVar != null) {
                jVar.cancel();
            }
            j jVar2 = new j(this);
            this.mFilterTask = jVar2;
            jVar2.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            changeNavigationSkin();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.obfuscated_res_0x7f0d024f);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                closeLoadingDialog();
                setResult(0);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k kVar = this.mTask;
            if (kVar != null) {
                kVar.cancel();
            }
            this.mImage.setImageDrawable(null);
            releasePreviewResouce();
        }
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData, Integer.valueOf(i4)}) == null) {
            Intent intent = new Intent(activity, EditHeadActivity.class);
            intent.putExtra("request", i2);
            intent.putExtra("account_data", accountData);
            intent.putExtra("edit_type", i4);
            intent.setData(uri);
            activity.startActivityForResult(intent, i3);
        }
    }

    public static void startActivityForResult(Activity activity, int i2, int i3, Uri uri, AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), uri, accountData}) == null) {
            startActivityForResult(activity, i2, i3, uri, accountData, 0);
        }
    }
}
