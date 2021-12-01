package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
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
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class IdCardDetectionH5Activity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic = null;
    public static int mSteps = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public Bundle mBundle;
    public View mCameraCtrlArea;
    public View mCameraSwitchIcon;
    public LinearLayout mChooseOicLayout;
    public String mCurrentFileName;
    public View mFlashIcon;
    public Bitmap mIamgeBp;
    public Bitmap mImageBp4Result;
    public Bitmap mImageBp4TP;
    public ImageView mPicView;
    public TextView mRestartTakePic;
    public ImageView mTakePic;
    public LinearLayout mTakePicLayout;
    public TextView mTakePicOk;
    public TextView mTitle;
    public AtomicBoolean mToTakePhoto;
    public TextView tipsView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1189882368, "Lcom/baidu/wallet/base/iddetect/IdCardDetectionH5Activity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1189882368, "Lcom/baidu/wallet/base/iddetect/IdCardDetectionH5Activity;");
        }
    }

    public IdCardDetectionH5Activity() {
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
        this.TAG = IdCardDetectionH5Activity.class.getSimpleName();
        this.mCameraSwitchIcon = null;
        this.mFlashIcon = null;
        this.mTakePicLayout = null;
        this.mChooseOicLayout = null;
        this.tipsView = null;
        this.mTakePicOk = null;
        this.mPicView = null;
        this.mRestartTakePic = null;
        this.mTakePic = null;
        this.mToTakePhoto = new AtomicBoolean(false);
        this.mCurrentFileName = "";
        this.mBundle = new Bundle();
    }

    private void chage2TakePicView(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, bool) == null) {
            if (bool.booleanValue()) {
                Activity activity = getActivity();
                Bitmap bitmap = this.mImageBp4Result;
                this.mCurrentFileName = ImageUtils.saveBitmapToCache(activity, bitmap, System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
            }
            this.tipsView.setVisibility(0);
            this.mCameraCtrlArea.setVisibility(0);
            this.mTitle.setText(getString(ResUtils.string(getActivity(), "wallet_base_h5_idcard_title_take_pic")));
            this.mTakePicLayout.setVisibility(0);
            this.mChooseOicLayout.setVisibility(8);
            this.mPicView.setVisibility(8);
            onResume();
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_h5_detection_activity"), null) : (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            return 0;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            int id = view.getId();
            if (ResUtils.id(getActivity(), "idcards_flash_light_switch") == id) {
                triggerFlash();
            } else if (ResUtils.id(getActivity(), "idcards_take_pic_start") == id) {
                if (this.mToTakePhoto.compareAndSet(false, true)) {
                    view.setClickable(false);
                    takePicture();
                }
            } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
                int i2 = mSteps;
                String str = "pic2";
                switch (i2) {
                    case 1:
                        this.mBundle.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
                        mSteps++;
                        chage2TakePicView(Boolean.TRUE);
                        this.mBundle.putString("pic1", this.mCurrentFileName);
                        return;
                    case 2:
                        String saveBitmapToCache = ImageUtils.saveBitmapToCache(getActivity(), this.mImageBp4Result, System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
                        this.mCurrentFileName = saveBitmapToCache;
                        this.mBundle.putString("pic2", saveBitmapToCache);
                        mSteps = 1;
                        IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                        finishWithoutAnim();
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.mBundle.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
                        this.mCurrentFileName = ImageUtils.saveBitmapToCache(getActivity(), this.mImageBp4Result, System.currentTimeMillis() + "");
                        Bundle bundle = this.mBundle;
                        int i3 = mSteps;
                        bundle.putString((i3 == 5 || i3 == 6) ? "pic1" : "pic1", this.mCurrentFileName);
                        mSteps = 1;
                        IdCardDetectionController.getInstance().IdCardDeteSuccess(this.mBundle);
                        finishWithoutAnim();
                        return;
                    default:
                        finishWithoutAnim();
                        return;
                }
            } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
                chage2TakePicView(Boolean.FALSE);
            } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
                IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
                finishWithoutAnim();
            } else if (view == this.mCameraSwitchIcon) {
                stopCamera();
                switchCamera();
                if (!CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                    this.mFlashIcon.setVisibility(4);
                } else if (this.cameraId == 1) {
                    this.mFlashIcon.setVisibility(4);
                    this.mFlashIcon.setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_base_camera_flashlight_off_btn"));
                } else {
                    this.mFlashIcon.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, com.baidu.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                mSteps = extras.getInt(ShaderParams.VALUE_TYPE_STEP);
            }
            this.mFlashIcon = findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
            this.mCameraSwitchIcon = findViewById(ResUtils.id(getActivity(), "idcards_camera_switch"));
            this.tipsView = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
            this.mCameraCtrlArea = findViewById(ResUtils.id(getActivity(), "wallet_camera_control_area"));
            this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "TextView1"));
            this.mTakePicLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
            this.mChooseOicLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
            this.mRestartTakePic = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
            this.mTakePicOk = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
            this.mPicView = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.mFlashIcon.setOnClickListener(this);
                this.mFlashIcon.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.mFlashIcon, "打开闪光灯");
            } else {
                this.mFlashIcon.setVisibility(4);
            }
            this.mCameraSwitchIcon.setVisibility(CameraCtrl.getInstance().isSupportMultiCamera() ? 0 : 8);
            this.mCameraSwitchIcon.setOnClickListener(this);
            this.mRestartTakePic.setOnClickListener(this);
            this.mTakePicOk.setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
            this.mTakePic = imageView;
            imageView.setOnClickListener(this);
            this.mPreviewView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdCardDetectionH5Activity this$0;

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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, objArr) == null) {
            runOnUiThread(new Runnable(this, objArr) { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdCardDetectionH5Activity this$0;
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
                        this.this$0.tipsView.setVisibility(8);
                        this.this$0.mCameraCtrlArea.setVisibility(8);
                        TextView textView = this.this$0.mTitle;
                        IdCardDetectionH5Activity idCardDetectionH5Activity = this.this$0;
                        textView.setText(idCardDetectionH5Activity.getString(ResUtils.string(idCardDetectionH5Activity.getActivity(), "wallet_base_h5_idcard_title2")));
                        this.this$0.mTakePicLayout.setVisibility(8);
                        this.this$0.mChooseOicLayout.setVisibility(0);
                        this.this$0.mPicView.setVisibility(0);
                        this.this$0.mImageBp4Result = (Bitmap) this.val$result[0];
                        this.this$0.mPicView.setImageBitmap(this.this$0.mImageBp4Result);
                        this.this$0.restartScan();
                        this.this$0.mToTakePhoto.compareAndSet(true, false);
                        this.this$0.mTakePic.setClickable(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            switch (mSteps) {
                case 1:
                case 3:
                case 5:
                    this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                    return;
                case 2:
                case 4:
                    this.tipsView.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                    return;
                case 6:
                    this.tipsView.setText("");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
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
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, bArr, i2, i3)) == null) {
            if (this.mToTakePhoto.get()) {
                LogUtil.d(this.TAG, "takepic process");
                Bitmap decodeSampledBitmapFromByteArray = BitmapUtil.decodeSampledBitmapFromByteArray(bArr, i2, i3);
                this.mImageBp4TP = decodeSampledBitmapFromByteArray;
                if (decodeSampledBitmapFromByteArray != null) {
                    if (this.cameraId == 1) {
                        this.mImageBp4TP = ImageUtils.rotateAReversalBitmap(270, decodeSampledBitmapFromByteArray);
                    } else {
                        this.mImageBp4TP = ImageUtils.rotateBitmap(90, decodeSampledBitmapFromByteArray);
                    }
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
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rect) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.mFlashIcon == null) {
            return;
        }
        this.mFlashIcon.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.mFlashIcon, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
