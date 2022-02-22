package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.camera.util.ImageUtils;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.iddetect.statistics.IdCardDetectStatistics;
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.base.iddetect.view.MistViewForIdCard;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import com.kuaishou.weapon.un.s;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes13.dex */
public class IdentityCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic = null;
    public static int mSteps = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int ID_REQUST_STORAGE_PERMISSION;
    public final int SELECT_PICTURE_FROM_ALBUM;
    public final String TAG;
    public Bundle mBundle;
    public RelativeLayout mChooseOicLayout;
    public String mCurrentFileName;
    public ImageView mFlashIcon;
    public View mFocusView;
    public ImageView mGuoHuiPicView;
    public Bitmap mIamgeBp;
    public Bitmap mImageBp4TP;
    public MistViewForIdCard mMistView;
    public TextView mOpenAlbum;
    public FrameLayout mPicDisplayView;
    public ImageView mPicView;
    public ImageView mRenTouPicView;
    public TextView mRestartTakePic;
    public ImageView mTakePic;
    public RelativeLayout mTakePicLayout;
    public TextView mTakePicOk;
    public AtomicBoolean mToTakePhoto;
    public String ready2UseFileName;
    public boolean showAlbum;
    public TextView tipsView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-501821520, "Lcom/baidu/wallet/base/iddetect/IdentityCardDetectionActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-501821520, "Lcom/baidu/wallet/base/iddetect/IdentityCardDetectionActivity;");
        }
    }

    public IdentityCardDetectionActivity() {
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
        this.TAG = IdentityCardDetectionActivity.class.getSimpleName();
        this.SELECT_PICTURE_FROM_ALBUM = 17;
        this.ID_REQUST_STORAGE_PERMISSION = 18;
        this.mFocusView = null;
        this.mFlashIcon = null;
        this.mTakePicLayout = null;
        this.mChooseOicLayout = null;
        this.tipsView = null;
        this.mTakePicOk = null;
        this.mPicView = null;
        this.mPicDisplayView = null;
        this.mRenTouPicView = null;
        this.mGuoHuiPicView = null;
        this.mRestartTakePic = null;
        this.mOpenAlbum = null;
        this.mTakePic = null;
        this.mToTakePhoto = new AtomicBoolean(false);
        this.mCurrentFileName = "";
        this.ready2UseFileName = "";
        this.mBundle = new Bundle();
        this.showAlbum = true;
    }

    private void chage2TakePicView(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, bool) == null) {
            if (bool.booleanValue()) {
                this.mCurrentFileName = this.ready2UseFileName;
            }
            this.mFocusView.setVisibility(0);
            this.tipsView.setVisibility(0);
            this.mTakePicLayout.setVisibility(0);
            this.mChooseOicLayout.setVisibility(8);
            this.mPicDisplayView.setVisibility(8);
            this.mPicView.setImageDrawable(null);
            onResume();
        }
    }

    private void gotoSysAlbum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.OPENABLE");
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
            intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
            startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoStoragePermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            restartScan();
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_permission_open_album_error"));
        }
    }

    private void openSysAlbum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (PermissionManager.checkCallingPermission(getActivity(), s.f55460i)) {
                gotoSysAlbum();
            } else {
                BaiduWalletUtils.requestPermissionsDialog("", this, new String[]{s.f55460i}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IdentityCardDetectionActivity this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                if (PermissionManager.checkCallingOrSelfPermission(this.this$0.getActivity(), new String[]{s.f55460i}, 18)) {
                                    return;
                                }
                                this.this$0.handleNoStoragePermission();
                            } else if (Build.VERSION.SDK_INT >= 23) {
                                this.this$0.onRequestPermissionsResult(1, new String[]{s.f55460i}, new int[]{-1});
                            }
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool) == null) {
                        }
                    }
                });
            }
        }
    }

    public void deleteReady2USeFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File file = new File(this.ready2UseFileName);
            if (file.exists()) {
                file.delete();
            }
            this.ready2UseFileName = "";
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MistViewForIdCard mistViewForIdCard = (MistViewForIdCard) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_card_detection_activity"), null);
            this.mMistView = mistViewForIdCard;
            return mistViewForIdCard;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0.62416106f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    public void getPicFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = mSteps;
            if (i2 == 1) {
                this.mBundle.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
                mSteps++;
                chage2TakePicView(Boolean.TRUE);
                this.mBundle.putString("pic1", this.mCurrentFileName);
                restartScan();
            } else if (i2 == 2) {
                String str = this.ready2UseFileName;
                this.mCurrentFileName = str;
                this.mBundle.putString("pic2", str);
                mSteps = 1;
                IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                finishWithoutAnim();
            } else if (i2 != 3 && i2 != 4) {
                finishWithoutAnim();
            } else {
                this.mBundle.putInt(ShaderParams.VALUE_TYPE_STEP, mSteps);
                this.mCurrentFileName = this.ready2UseFileName;
                this.mBundle.putString(mSteps != 3 ? "pic2" : "pic1", this.mCurrentFileName);
                mSteps = 1;
                IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                finishWithoutAnim();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            return 0;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) && i3 == -1 && i2 == 17) {
            pauseCamera();
            Uri uri = null;
            if (intent != null && intent.getData() != null) {
                uri = intent.getData();
            }
            if (uri == null) {
                return;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = ImageUtils.calSampleSize(getActivity(), uri);
                Bitmap bitmapFromUri = ImageUtils.getBitmapFromUri(getActivity(), uri, options);
                Activity activity = getActivity();
                this.ready2UseFileName = ImageUtils.saveBitmapToCache(activity, bitmapFromUri, System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX, 90);
                if (bitmapFromUri != null) {
                    bitmapFromUri.recycle();
                }
                if (mSteps == 1) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_idcard_promo_f_album_tips"));
                }
                getPicFinished();
            } catch (Exception e2) {
                e2.printStackTrace();
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_GET_SELECT_PIC_FAILED, Arrays.asList(e2.getMessage()));
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            int id = view.getId();
            if (ResUtils.id(getActivity(), "idcards_flash_light_switch") == id) {
                triggerFlash();
            } else if (ResUtils.id(getActivity(), "idcards_take_pic_start") == id) {
                DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_SHUTTER);
                if (this.mToTakePhoto.compareAndSet(false, true)) {
                    view.setClickable(false);
                    takePicture();
                }
            } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
                int i2 = mSteps;
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_COMPLETE);
                }
                getPicFinished();
            } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
                DXMSdkSAUtils.onEvent(IdCardDetectStatistics.IDCARD_PHOTO_RESET);
                deleteReady2USeFile();
                chage2TakePicView(Boolean.FALSE);
                restartScan();
            } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
                IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
                finishWithoutAnim();
            } else if (ResUtils.id(getActivity(), "idcards_open_album") != id || CheckUtils.isFastDoubleClick()) {
            } else {
                openSysAlbum();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                mSteps = extras.getInt(ShaderParams.VALUE_TYPE_STEP);
                this.showAlbum = extras.getBoolean("show_album");
            }
            this.mFocusView = findViewById(ResUtils.id(getActivity(), "focus_view"));
            this.mFlashIcon = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
            this.tipsView = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
            this.mTakePicLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
            this.mChooseOicLayout = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
            this.mRestartTakePic = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
            this.mTakePicOk = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
            this.mPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
            this.mPicDisplayView = (FrameLayout) findViewById(ResUtils.id(getActivity(), "img_display_layout"));
            this.mGuoHuiPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_b"));
            this.mRenTouPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_f"));
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "idcards_open_album"));
            this.mOpenAlbum = textView;
            textView.setOnClickListener(this);
            if (!this.showAlbum) {
                this.mOpenAlbum.setVisibility(8);
            }
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.mFlashIcon.setOnClickListener(this);
                this.mFlashIcon.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.mFlashIcon, "打开闪光灯");
            } else {
                this.mFlashIcon.setVisibility(4);
            }
            this.mRestartTakePic.setOnClickListener(this);
            this.mTakePicOk.setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
            this.mTakePic = imageView;
            imageView.setOnClickListener(this);
            this.mPreviewView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdentityCardDetectionActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.this$0.autoFoucus();
                            return true;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            Bitmap bitmap = this.mIamgeBp;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.mIamgeBp.recycle();
            this.mIamgeBp = null;
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, objArr) == null) {
            runOnUiThread(new Runnable(this, objArr) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdentityCardDetectionActivity this$0;
                public final /* synthetic */ Object[] val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = objArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mGuoHuiPicView.getVisibility() == 0) {
                            this.this$0.mGuoHuiPicView.setVisibility(8);
                        }
                        if (this.this$0.mRenTouPicView.getVisibility() == 0) {
                            this.this$0.mRenTouPicView.setVisibility(8);
                        }
                        this.this$0.tipsView.setVisibility(8);
                        this.this$0.mTakePicLayout.setVisibility(8);
                        this.this$0.mChooseOicLayout.setVisibility(0);
                        long currentTimeMillis = System.currentTimeMillis();
                        IdentityCardDetectionActivity identityCardDetectionActivity = this.this$0;
                        identityCardDetectionActivity.ready2UseFileName = ImageUtils.saveBitmapToCache(identityCardDetectionActivity.getActivity(), (Bitmap) this.val$result[0], System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX, 90);
                        Bitmap bPfromsdcard = ImageUtils.getBPfromsdcard(this.this$0.ready2UseFileName);
                        LogUtil.i("IdentityCardDetectionActivity", "re save and show time:" + (System.currentTimeMillis() - currentTimeMillis));
                        this.this$0.mPicView.setImageBitmap(bPfromsdcard);
                        this.this$0.pauseCamera();
                        this.this$0.mToTakePhoto.compareAndSet(true, false);
                        this.this$0.mTakePic.setClickable(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == 18) {
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (s.f55460i.equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                            if (iArr[i3] == 0) {
                                gotoSysAlbum();
                            } else if (-1 == iArr[i3]) {
                                handleNoStoragePermission();
                            }
                        }
                    }
                    return;
                }
                handleNoStoragePermission();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            int i2 = mSteps;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return;
                        }
                    }
                }
                this.mTakePicOk.setText(ResUtils.string(getActivity(), "wallet_base_idcard_retake_pic_finish"));
                this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_b"));
                this.mGuoHuiPicView.setVisibility(0);
                this.mRenTouPicView.setVisibility(8);
                return;
            }
            this.mTakePicOk.setText(ResUtils.string(getActivity(), "wallet_base_idcard_take_another"));
            this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_f"));
            this.mGuoHuiPicView.setVisibility(8);
            this.mRenTouPicView.setVisibility(0);
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
                LogUtil.d(this.TAG, "preview process");
                if (this.mToTakePhoto.get()) {
                    rect.set(0, 0, i2, i3);
                    if (this.mIamgeBp == null) {
                        this.mIamgeBp = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
                    }
                    Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, this.mIamgeBp);
                    return new Bitmap[]{this.mIamgeBp};
                }
            }
            return null;
        }
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, bArr, i2, i3)) == null) {
            if (this.mToTakePhoto.get()) {
                LogUtil.d(this.TAG, "takepic process");
                Bitmap decodeSampledBitmapFromByteArray = BitmapUtil.decodeSampledBitmapFromByteArray(bArr, i2, i3);
                this.mImageBp4TP = decodeSampledBitmapFromByteArray;
                if (decodeSampledBitmapFromByteArray != null) {
                    this.mImageBp4TP = ImageUtils.rotateBitmap(90, decodeSampledBitmapFromByteArray);
                }
                return new Bitmap[]{this.mImageBp4TP};
            }
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mFocusView.getLayoutParams();
            int width = this.mFocusView.getWidth();
            layoutParams.width = width;
            layoutParams.height = (int) (width * getFocusDataYXRatioal() * this.mScaleCoefficient);
            this.mFocusView.post(new Runnable(this, layoutParams) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdentityCardDetectionActivity this$0;
                public final /* synthetic */ ViewGroup.LayoutParams val$lp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$lp = layoutParams;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mFocusView.setLayoutParams(this.val$lp);
                    }
                }
            });
            int[] iArr = new int[2];
            getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            int[] iArr2 = new int[2];
            this.mPreviewView.getLocationOnScreen(iArr2);
            this.mFocusView.getLocationOnScreen(iArr);
            Rect rect = this.mFocusViewRect;
            int i2 = iArr[0] - iArr2[0];
            rect.left = i2;
            rect.right = i2 + layoutParams.width;
            int i3 = iArr[1] - iArr2[1];
            rect.top = i3;
            rect.bottom = i3 + layoutParams.height;
            this.mMistView.getFocusFrame().set(this.mFocusViewRect);
            ViewGroup.LayoutParams layoutParams2 = this.mPicView.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            this.mPicView.setLayoutParams(layoutParams2);
            this.mPicView.requestLayout();
            ((FrameLayout.LayoutParams) this.tipsView.getLayoutParams()).topMargin = this.mFocusViewRect.bottom + DisplayUtils.dip2px(getActivity(), 25.0f);
            this.tipsView.requestLayout();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rect) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.mFlashIcon == null) {
            return;
        }
        this.mFlashIcon.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.mFlashIcon, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
