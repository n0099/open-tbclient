package com.baidu.wallet.base.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.d;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public abstract class CameraBaseActivity extends BaseActivity implements SurfaceHolder.Callback, com.baidu.wallet.base.camera.internal.c {
    public static final int MSG_PROBE_OPEN_STATE = 1;
    public static final int RequestCode = 132;
    public static final int ResultCodeExit = 1243;
    public static final int ResultCodeStay = 1244;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_RAW = 0;
    public com.baidu.wallet.base.camera.internal.a mAutoFocusCb;
    public ViewGroup mContentView;
    public IImageProcess mImageProcessor;
    public OnCameraChangeListener mOnCameraChange;
    public d mPreviewCb;
    public SurfaceView mPreviewView;
    public int mRotation;
    public com.baidu.wallet.base.camera.util.c mThreadPool;
    public CountDownTimer mTimer;
    public View mTitleBarMargin;
    public RelativeLayout mTitle_bar;
    public static final String Tag = CameraBaseActivity.class.getSimpleName();
    public static int REQUEST_PERMISSION_CAMERA = 1;
    public SurfaceHolder mSurfaceHolder = null;
    public final AtomicBoolean mDone = new AtomicBoolean(false);
    public float mScaleCoefficient = 1.0f;
    public float mFocusDataYXRatial = 1.0f;
    public Rect mBmpDataRect = new Rect();
    public Rect mFocusViewRect = new Rect();
    public int[] mScreeSize = new int[2];
    public int[] mImageSize = new int[2];
    public a[] mDetectors = null;
    public final AtomicInteger mDetectorState = new AtomicInteger(0);
    public Handler mMiscEvtHandler = null;
    public AtomicBoolean mIsCameraMalfunctioned = new AtomicBoolean(false);
    public boolean mCanRequestCameraPermission = true;
    public boolean mInCaptureProgresses = false;
    public AtomicBoolean mInCaptureTimeOut = new AtomicBoolean(false);
    public final Handler mAutoFocusHandler = new Handler(Looper.myLooper()) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int id = ResUtils.id(CameraBaseActivity.this.getActivity(), "wallet_auto_focus");
            if (id == message.what) {
                if (CameraBaseActivity.this.mPreviewCb != null) {
                    CameraBaseActivity.this.mAutoFocusCb.a(this, id);
                    com.baidu.wallet.base.camera.internal.b d2 = CameraBaseActivity.this.mPreviewCb.d();
                    if (d2 != null) {
                        try {
                            d2.a(CameraBaseActivity.this.mAutoFocusCb);
                            return;
                        } catch (Exception unused) {
                            LogUtil.w(CameraBaseActivity.Tag, "mAutoFocusHandler.handleMessage()");
                            return;
                        }
                    }
                    return;
                }
                CameraBaseActivity.this.mAutoFocusCb.a(null, id);
                return;
            }
            super.handleMessage(message);
        }
    };
    public b mFlashController = new b();
    public int cameraId = 0;
    public Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.7

        /* renamed from: b  reason: collision with root package name */
        public int f23545b;

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (CameraBaseActivity.this.mPreviewCb == null || CameraBaseActivity.this.mPreviewCb.d() == null) {
                return;
            }
            CameraBaseActivity cameraBaseActivity = CameraBaseActivity.this;
            if (cameraBaseActivity.mInCaptureProgresses) {
                return;
            }
            com.baidu.wallet.base.camera.internal.b d2 = cameraBaseActivity.mPreviewCb.d();
            if (z) {
                this.f23545b = 0;
                CameraBaseActivity.this.takePictureWithoutAutoFocus(d2);
                return;
            }
            int i = this.f23545b + 1;
            this.f23545b = i;
            if (i <= 1) {
                d2.a(CameraBaseActivity.this.autoFocusCallback, "auto");
            } else {
                CameraBaseActivity.this.takePictureWithoutAutoFocus(d2);
            }
        }
    };

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f23556b;

        public b() {
        }

        public void a(boolean z) {
            this.f23556b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraBaseActivity.this.updateFlashLightUi(this.f23556b);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CameraBaseActivity> f23557a;

        public c(CameraBaseActivity cameraBaseActivity) {
            this.f23557a = new WeakReference<>(cameraBaseActivity);
        }

        private boolean a() {
            a[] aVarArr;
            CameraBaseActivity cameraBaseActivity = this.f23557a.get();
            if (cameraBaseActivity == null) {
                return false;
            }
            if (cameraBaseActivity.mDetectors != null && cameraBaseActivity.mDetectors.length != 0) {
                for (a aVar : cameraBaseActivity.mDetectors) {
                    if (aVar != null && aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            CameraBaseActivity cameraBaseActivity = this.f23557a.get();
            if (cameraBaseActivity == null) {
                return;
            }
            while (!a()) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            cameraBaseActivity.mImageProcessor.destroyProcessor();
            cameraBaseActivity.mDetectors = null;
        }
    }

    private synchronized a getAvailableDetector() {
        if (this.mDetectors == null) {
            a[] aVarArr = new a[com.baidu.wallet.base.camera.util.a.a()];
            this.mDetectors = aVarArr;
            aVarArr[0] = new a();
            return this.mDetectors[0];
        }
        for (int i = 0; i < this.mDetectors.length; i++) {
            if (this.mDetectors[i] == null) {
                this.mDetectors[i] = new a();
                return this.mDetectors[i];
            } else if (!this.mDetectors[i].a()) {
                return this.mDetectors[i];
            }
        }
        return null;
    }

    public static String getToken() {
        return SafePay.getInstance().getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        onPermissionDenied();
        showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
    }

    private boolean isFlashOn() {
        if (this.mPreviewCb != null) {
            return CameraCtrl.getInstance().isFlashOn();
        }
        return false;
    }

    private void setFlashLightOn(boolean z) {
        if (this.mPreviewCb != null) {
            CameraCtrl cameraCtrl = CameraCtrl.getInstance();
            if (cameraCtrl.isFlashOn() != z) {
                cameraCtrl.setFlashOn(z);
            }
            switchFlashOnMainThread(cameraCtrl.isFlashOn());
        }
    }

    private void startCountDown() {
        stopCountDown();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(SdkInitResponse.getInstance().getTakePicWaitTime(), SdkInitResponse.getInstance().getTakePicWaitTime()) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.8
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (CameraBaseActivity.this.mTimer != null) {
                    CameraBaseActivity.this.mTimer.cancel();
                    CameraBaseActivity.this.mInCaptureTimeOut.set(true);
                    CameraBaseActivity.this.mInCaptureProgresses = false;
                    LogUtil.d(CameraBaseActivity.Tag, com.alipay.sdk.data.a.i);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.mTimer = countDownTimer2;
        countDownTimer2.start();
    }

    private boolean startScan() {
        d dVar;
        if (this.mPreviewCb == null) {
            int a2 = d.a(getActivity(), this.cameraId);
            this.mRotation = a2;
            int i = this.cameraId;
            int[] iArr = this.mScreeSize;
            d a3 = d.a(i, iArr[0], iArr[1], a2, 17, 10, this);
            this.mPreviewCb = a3;
            if (a3 == null) {
                handleNoCamaraPermission();
                return false;
            }
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null && (dVar = this.mPreviewCb) != null) {
            dVar.a(surfaceHolder);
            com.baidu.wallet.base.camera.internal.a aVar = new com.baidu.wallet.base.camera.internal.a();
            this.mAutoFocusCb = aVar;
            aVar.a(getAutoFocusDelay());
            this.mAutoFocusCb.b(getFirstFocusDelay());
            this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
            try {
                Camera.Size previewSize = this.mPreviewCb.d().d().getPreviewSize();
                this.mImageSize[0] = previewSize.width;
                this.mImageSize[1] = previewSize.height;
                int[] iArr2 = this.mScreeSize;
                int[] iArr3 = this.mImageSize;
                this.mScaleCoefficient = ((iArr2[1] * iArr3[1]) / iArr2[0]) / iArr3[0];
                String str = Tag;
                LogUtil.i(str, "ratio:" + this.mScaleCoefficient);
                relayoutUi();
                setFocusRectValue(this.mFocusViewRect);
                mapViewDataBoundary(this.mBmpDataRect);
            } catch (Throwable unused) {
                showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
                return false;
            }
        }
        this.mDone.set(false);
        this.mIsCameraMalfunctioned.set(true);
        Handler handler = this.mMiscEvtHandler;
        if (handler == null) {
            this.mMiscEvtHandler = new Handler() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.5
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (1 == message.what && CameraBaseActivity.this.mIsCameraMalfunctioned.get()) {
                        CameraBaseActivity.this.showBaseDialog(3, ResUtils.getString(CameraBaseActivity.this.getActivity(), "wallet_camera_error"));
                    }
                }
            };
        } else {
            handler.removeMessages(1);
        }
        this.mMiscEvtHandler.sendEmptyMessageDelayed(1, 1500L);
        return true;
    }

    private void switchFlashOnMainThread(boolean z) {
        this.mFlashController.a(z);
        getActivity().runOnUiThread(this.mFlashController);
    }

    public void autoFoucus() {
        com.baidu.wallet.base.camera.internal.b d2;
        d dVar = this.mPreviewCb;
        if (dVar == null || (d2 = dVar.d()) == null) {
            return;
        }
        try {
            d2.a(this.mAutoFocusCb);
        } catch (Throwable unused) {
            LogUtil.w(Tag, "autoFocus exception");
        }
    }

    @Override // com.baidu.wallet.base.camera.internal.c
    public void destroyCamera() {
        LogUtil.i(Tag, "destroyCamera()");
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener != null) {
            onCameraChangeListener.onCameraClose();
        }
        if (this.mDetectors == null) {
            return;
        }
        int i = 0;
        while (true) {
            a[] aVarArr = this.mDetectors;
            if (i < aVarArr.length) {
                aVarArr[i] = null;
                i++;
            } else {
                this.mDetectors = null;
                return;
            }
        }
    }

    public String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public long getAutoFocusDelay() {
        return 500L;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract View getCustomizedView();

    public long getFirstFocusDelay() {
        return 500L;
    }

    public abstract float getFocusDataYXRatioal();

    public abstract IImageProcess getImageProcessor();

    @Override // com.baidu.wallet.base.camera.internal.c
    public boolean initCamera(int i, int i2, int i3, int i4) {
        String str = Tag;
        LogUtil.i(str, "initCamera(" + i + FieldBuilder.SE + i2 + FieldBuilder.SE + i3 + FieldBuilder.SE + i4 + SmallTailInfo.EMOTION_SUFFIX);
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener != null) {
            onCameraChangeListener.onCameraOpen();
            return true;
        }
        return true;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isStatusbarTextColorBlack() {
        return false;
    }

    public void mapViewDataBoundary(Rect rect) {
        float focusDataYXRatioal = getFocusDataYXRatioal();
        this.mFocusDataYXRatial = focusDataYXRatioal;
        if (0.0f >= focusDataYXRatioal) {
            this.mFocusDataYXRatial = 1.0f;
        }
        int round = Math.round(this.mImageSize[1] * (this.mFocusViewRect.left / this.mScreeSize[0]));
        rect.top = round;
        int[] iArr = this.mImageSize;
        rect.bottom = iArr[1] - round;
        rect.left = Math.round(iArr[0] * (this.mFocusViewRect.top / this.mScreeSize[1]));
        rect.right = Math.round((rect.height() * this.mFocusDataYXRatial) + rect.left);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (132 != i || i2 == 1244) {
            restartScan();
        } else if (i2 == 1243) {
            finish();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_camera_detection"), null);
        this.mContentView = viewGroup;
        setContentView(viewGroup);
        IImageProcess imageProcessor = getImageProcessor();
        this.mImageProcessor = imageProcessor;
        if (imageProcessor == null) {
            LogUtil.e(Tag, "onCreate() failed to get ImageProcessor", null);
            finish();
        }
        this.mContentView.addView(getCustomizedView(), 1);
        View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
        this.mTitleBarMargin = findViewById;
        setTop(findViewById);
        setIsShowMultiWindowTips(true);
        setIsMultiWindowAvailable(false);
        setMultiWindowTipsId("wallet_base_multi_window_close");
        SurfaceView surfaceView = (SurfaceView) findViewById(ResUtils.id(getActivity(), "surfaceview"));
        this.mPreviewView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setKeepScreenOn(true);
        holder.setType(3);
        holder.addCallback(this);
        com.baidu.wallet.base.camera.util.c a2 = com.baidu.wallet.base.camera.util.c.a(com.baidu.wallet.base.camera.util.a.a(), "ImageProcessor");
        this.mThreadPool = a2;
        a2.a(new Runnable() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.1
            @Override // java.lang.Runnable
            public void run() {
                CameraBaseActivity.this.mDetectorState.set(CameraBaseActivity.this.mImageProcessor.initProcessor() ? 1 : 0);
            }
        });
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LogUtil.i(Tag, "onDestroy()");
        this.mDone.set(true);
        Handler handler = this.mMiscEvtHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mMiscEvtHandler = null;
        }
        stopCamera();
        if (this.mImageProcessor != null) {
            new c(this).start();
        }
        com.baidu.wallet.base.camera.util.c cVar = this.mThreadPool;
        if (cVar != null) {
            cVar.a();
            this.mThreadPool = null;
        }
        updateFlashLightUi(false);
        super.onDestroy();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LogUtil.i(Tag, "onPause()");
        super.onPause();
    }

    public abstract void onPermissionDenied();

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        if (i == 3) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    WalletGlobalUtils.showStr = "";
                    CameraCtrl cameraCtrl = CameraCtrl.getInstance();
                    if (cameraCtrl != null) {
                        cameraCtrl.reset();
                    }
                    CameraBaseActivity.this.finish();
                }
            });
        }
    }

    public abstract void onProcessImageOk(Object[] objArr);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == REQUEST_PERMISSION_CAMERA) {
            this.mCanRequestCameraPermission = true;
            if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i2]) && iArr != null && iArr.length > i2) {
                        if (iArr[i2] == 0) {
                            relayoutUi();
                            setFocusRectValue(this.mFocusViewRect);
                            startScan();
                        } else if (-1 == iArr[i2]) {
                            handleNoCamaraPermission();
                        }
                    }
                }
                return;
            }
            handleNoCamaraPermission();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        LogUtil.i(Tag, "onResume()");
        super.onResume();
    }

    public void pauseCamera() {
        if (this.mAutoFocusCb != null) {
            this.mAutoFocusCb.a(null, ResUtils.id(getActivity(), "wallet_auto_focus"));
        }
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.c();
            setFlashLightOn(false);
        }
    }

    @Override // com.baidu.wallet.base.camera.internal.c
    public void processImage(byte[] bArr) {
        a availableDetector;
        if (this.mDone.get() || 1 != this.mDetectorState.get() || (availableDetector = getAvailableDetector()) == null || this.mPreviewCb == null || this.mDone.get()) {
            return;
        }
        int[] iArr = this.mImageSize;
        availableDetector.a(bArr, iArr[0], iArr[1], this.mBmpDataRect);
        this.mThreadPool.a(availableDetector);
        if (this.mIsCameraMalfunctioned.get()) {
            for (byte b2 : bArr) {
                if (b2 != 0) {
                    this.mIsCameraMalfunctioned.compareAndSet(true, false);
                    Handler handler = this.mMiscEvtHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public abstract void relayoutUi();

    public void restartScan() {
        this.mDone.set(false);
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.a(this.mPreviewView.getHolder());
            this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
            return;
        }
        startScan();
    }

    public abstract void setFocusRectValue(Rect rect);

    public void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        this.mOnCameraChange = onCameraChangeListener;
    }

    public void setTop(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
            ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
        }
    }

    public void stopCamera() {
        d dVar = this.mPreviewCb;
        if (dVar != null) {
            dVar.a(false);
            this.mPreviewCb = null;
        }
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
            this.mInCaptureTimeOut.set(false);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtil.i(Tag, "surfaceChanged");
        int[] iArr = this.mScreeSize;
        iArr[0] = i2;
        iArr[1] = i3;
        this.mSurfaceHolder = surfaceHolder;
        if (PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            startScan();
        } else if (this.mCanRequestCameraPermission) {
            BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.4
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        CameraBaseActivity.this.mCanRequestCameraPermission = false;
                        if (PermissionManager.checkCallingOrSelfPermission(CameraBaseActivity.this.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, CameraBaseActivity.REQUEST_PERMISSION_CAMERA)) {
                            return;
                        }
                        CameraBaseActivity.this.handleNoCamaraPermission();
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        CameraBaseActivity.this.onRequestPermissionsResult(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str, Boolean bool) {
                }
            });
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        String str = Tag;
        LogUtil.i(str, "surfaceCreated()" + surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.i(Tag, "surfaceDestroyed");
        switchFlashOnMainThread(false);
        this.mSurfaceHolder = null;
        stopCamera();
    }

    public void switchCamera() {
        if (CameraCtrl.getInstance().isSupportMultiCamera()) {
            int i = this.cameraId;
            if (i == 0) {
                this.cameraId = 1;
            } else if (i == 1) {
                this.cameraId = 0;
            }
            restartScan();
        }
    }

    public void takePicture() {
        com.baidu.wallet.base.camera.internal.b d2;
        LogUtil.d(Tag, "takePic");
        startCountDown();
        d dVar = this.mPreviewCb;
        if (dVar == null || (d2 = dVar.d()) == null) {
            return;
        }
        d2.a(this.autoFocusCallback);
    }

    public void takePictureWithoutAutoFocus(com.baidu.wallet.base.camera.internal.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mInCaptureProgresses = true;
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            bVar.a(null, null, null, new Camera.PictureCallback() { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.6
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    CameraBaseActivity cameraBaseActivity;
                    IImageProcess iImageProcess;
                    String str = CameraBaseActivity.Tag;
                    LogUtil.d(str, "takepic callback Timeout = " + CameraBaseActivity.this.mInCaptureTimeOut);
                    DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_TAKEPIC_CALLBACK_INTERVAL, Arrays.asList(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_SELF_DEFINE_TAKEPIC_CALLBACK_INTERVAL, String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (!CameraBaseActivity.this.mInCaptureTimeOut.get() && (iImageProcess = (cameraBaseActivity = CameraBaseActivity.this).mImageProcessor) != null) {
                        int[] iArr = cameraBaseActivity.mImageSize;
                        Object[] processImageJpegData = iImageProcess.processImageJpegData(bArr, iArr[0], iArr[1]);
                        if (processImageJpegData != null && CameraBaseActivity.this.mDone.compareAndSet(false, true)) {
                            CameraBaseActivity.this.pauseCamera();
                            CameraBaseActivity.this.onProcessImageOk(processImageJpegData);
                        }
                    } else {
                        CameraBaseActivity.this.pauseCamera();
                        CameraBaseActivity.this.restartScan();
                    }
                    CameraBaseActivity.this.mInCaptureProgresses = false;
                }
            });
        } catch (Throwable th) {
            this.mInCaptureTimeOut.set(true);
            this.mInCaptureProgresses = false;
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_TAKE_PICTURE_FAILED, Arrays.asList(th.getMessage()));
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_SELF_DEFINE_TAKE_PICTURE_FAILED, th.getMessage());
        }
    }

    public void triggerFlash() {
        setFlashLightOn(!isFlashOn());
    }

    public abstract void updateFlashLightUi(boolean z);

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        public byte[] f23549c;

        /* renamed from: e  reason: collision with root package name */
        public int f23551e;

        /* renamed from: f  reason: collision with root package name */
        public int f23552f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f23553g;

        /* renamed from: b  reason: collision with root package name */
        public final String f23548b = a.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public byte[] f23550d = null;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f23554h = new AtomicBoolean(false);

        public a() {
        }

        public void a(byte[] bArr, int i, int i2, Rect rect) {
            this.f23549c = bArr;
            this.f23551e = i;
            this.f23552f = i2;
            this.f23553g = rect;
            int recycledBufSize = CameraBaseActivity.this.mImageProcessor.getRecycledBufSize(rect.width(), rect.height());
            byte[] bArr2 = this.f23550d;
            if (bArr2 == null || bArr2.length != recycledBufSize) {
                this.f23550d = new byte[recycledBufSize];
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraBaseActivity.this.mDone.get()) {
                this.f23554h.set(false);
            } else if (!this.f23554h.compareAndSet(false, true)) {
                LogUtil.e(this.f23548b, "internal error", null);
            } else {
                Object[] processImage = CameraBaseActivity.this.mImageProcessor.processImage(this.f23549c, this.f23551e, this.f23552f, this.f23553g, this.f23550d);
                if (processImage != null && CameraBaseActivity.this.mDone.compareAndSet(false, true)) {
                    CameraBaseActivity.this.pauseCamera();
                    CameraBaseActivity.this.onProcessImageOk(processImage);
                }
                this.f23554h.set(false);
            }
        }

        public boolean a() {
            return this.f23554h.get();
        }
    }
}
