package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.w2.b.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53461e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f53462f;
    public Camera mCamera;
    public c mDelegate;
    public Handler mHandler;
    public CameraPreview mPreview;
    public b.a.r0.w2.b.a.c mProcessDataTask;
    public ScanBoxView mScanBoxView;
    public boolean mSpotAble;

    /* loaded from: classes9.dex */
    public class a extends b.a.r0.w2.b.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Camera f53463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QRCodeView f53464f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QRCodeView qRCodeView, Camera camera, byte[] bArr, c.a aVar, int i2, Camera camera2) {
            super(camera, bArr, aVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView, camera, bArr, aVar, Integer.valueOf(i2), camera2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Camera) objArr2[0], (byte[]) objArr2[1], (c.a) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53464f = qRCodeView;
            this.f53463e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                QRCodeView qRCodeView = this.f53464f;
                if (qRCodeView.mSpotAble) {
                    try {
                        if (qRCodeView.mDelegate != null && !TextUtils.isEmpty(str)) {
                            this.f53464f.mDelegate.b(str);
                        } else {
                            this.f53463e.setOneShotPreviewCallback(this.f53464f);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QRCodeView f53465e;

        public b(QRCodeView qRCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53465e = qRCodeView;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView;
            Camera camera;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (camera = (qRCodeView = this.f53465e).mCamera) != null && qRCodeView.mSpotAble) {
                try {
                    camera.setOneShotPreviewCallback(qRCodeView);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a();

        void b(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            this.mPreview = new CameraPreview(getContext());
            ScanBoxView scanBoxView = new ScanBoxView(getContext());
            this.mScanBoxView = scanBoxView;
            scanBoxView.initCustomAttrs(context, attributeSet);
            this.mPreview.setId(R.id.bgaqrcode_camera_preview);
            addView(this.mPreview);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
            layoutParams.addRule(6, this.mPreview.getId());
            layoutParams.addRule(8, this.mPreview.getId());
            addView(this.mScanBoxView, layoutParams);
            this.f53461e = b.a.r0.w2.b.a.a.c(context);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                Camera open = Camera.open(i2);
                this.mCamera = open;
                this.mPreview.setCamera(open);
            } catch (Exception unused) {
                c cVar = this.mDelegate;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    public void cancelProcessDataTask() {
        b.a.r0.w2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.mProcessDataTask) == null) {
            return;
        }
        cVar.a();
        this.mProcessDataTask = null;
    }

    public void changeToScanBarcodeStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mScanBoxView.getIsBarcode()) {
            return;
        }
        this.mScanBoxView.setIsBarcode(true);
    }

    public void changeToScanQRCodeStyle() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mScanBoxView.getIsBarcode()) {
            this.mScanBoxView.setIsBarcode(false);
        }
    }

    public void closeFlashlight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mPreview.closeFlashlight();
        }
    }

    public boolean getIsScanBarcodeStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mScanBoxView.getIsBarcode() : invokeV.booleanValue;
    }

    public ScanBoxView getScanBoxView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mScanBoxView : (ScanBoxView) invokeV.objValue;
    }

    public void hiddenScanRect() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (scanBoxView = this.mScanBoxView) == null) {
            return;
        }
        scanBoxView.setVisibility(8);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            stopCamera();
            this.mHandler = null;
            this.mDelegate = null;
            this.f53462f = null;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, bArr, camera) == null) && this.mSpotAble) {
            cancelProcessDataTask();
            a aVar = new a(this, camera, bArr, this, this.f53461e, camera);
            aVar.c();
            this.mProcessDataTask = aVar;
        }
    }

    public void openFlashlight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mPreview.openFlashlight();
        }
    }

    @Override // b.a.r0.w2.b.a.c.a
    public abstract /* synthetic */ String processData(byte[] bArr, int i2, int i3, boolean z);

    public abstract /* synthetic */ String processData(int[] iArr, int i2, int i3);

    public void setDelegate(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.mDelegate = cVar;
        }
    }

    public void showScanRect() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (scanBoxView = this.mScanBoxView) == null) {
            return;
        }
        scanBoxView.setVisibility(0);
    }

    public void startCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            startCamera(0);
        }
    }

    public void startSpot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            startSpotDelay(1000);
        }
    }

    public void startSpotAndShowRect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            startSpot();
            showScanRect();
        }
    }

    public void startSpotDelay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mSpotAble = true;
            this.mHandler.removeCallbacks(this.f53462f);
            this.mHandler.postDelayed(this.f53462f, i2);
        }
    }

    public void stopCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                stopSpotAndHiddenRect();
                if (this.mCamera != null) {
                    this.mPreview.stopCameraPreview();
                    this.mPreview.setCamera(null);
                    this.mCamera.release();
                    this.mCamera = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void stopSpot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            cancelProcessDataTask();
            this.mSpotAble = false;
            Camera camera = this.mCamera;
            if (camera != null) {
                try {
                    camera.setOneShotPreviewCallback(null);
                } catch (Exception unused) {
                }
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.f53462f);
            }
        }
    }

    public void stopSpotAndHiddenRect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            stopSpot();
            hiddenScanRect();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSpotAble = false;
        this.f53462f = new b(this);
        this.mHandler = new Handler();
        a(context, attributeSet);
    }

    public void startCamera(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && this.mCamera == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
                Camera.getCameraInfo(i3, cameraInfo);
                if (cameraInfo.facing == i2) {
                    b(i3);
                    return;
                }
            }
        }
    }
}
