package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f47499e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47500f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47501g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.h3.b.a.b f47502h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f47503i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f47504j;
    public Camera.AutoFocusCallback k;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47505e;

        public a(CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47505e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47505e.f47499e != null && this.f47505e.f47500f && this.f47505e.f47501g) {
                try {
                    this.f47505e.f47499e.autoFocus(this.f47505e.k);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;

        public b(CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraPreview;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) {
                if (z) {
                    CameraPreview cameraPreview = this.a;
                    cameraPreview.postDelayed(cameraPreview.f47504j, 2000L);
                    return;
                }
                CameraPreview cameraPreview2 = this.a;
                cameraPreview2.postDelayed(cameraPreview2.f47504j, 500L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47506e;

        public c(CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47506e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47506e.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-956029045, "Lcom/baidu/tieba/qrcode/lib/core/CameraPreview;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-956029045, "Lcom/baidu/tieba/qrcode/lib/core/CameraPreview;");
                return;
            }
        }
        l = CameraPreview.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPreview(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47500f = false;
        this.f47501g = false;
        this.f47504j = new a(this);
        this.k = new b(this);
        setSurfaceTextureListener(this);
    }

    public void closeFlashlight() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f()) {
            this.f47502h.b(this.f47499e);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47499e != null && this.f47500f && this.f47501g && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash") : invokeV.booleanValue;
    }

    public final void g() {
        SurfaceTexture surfaceTexture;
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (surfaceTexture = this.f47503i) == null || (camera = this.f47499e) == null) {
            return;
        }
        try {
            this.f47500f = true;
            camera.setPreviewTexture(surfaceTexture);
            this.f47502h.l(this.f47499e);
            this.f47499e.startPreview();
            this.f47499e.autoFocus(this.k);
        } catch (Exception e2) {
            e2.toString();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int defaultSize = TextureView.getDefaultSize(getSuggestedMinimumWidth(), i2);
            int defaultSize2 = TextureView.getDefaultSize(getSuggestedMinimumHeight(), i3);
            c.a.t0.h3.b.a.b bVar = this.f47502h;
            if (bVar != null && bVar.g() != null) {
                Point g2 = this.f47502h.g();
                float f2 = defaultSize;
                float f3 = defaultSize2;
                float f4 = g2.x;
                float f5 = g2.y;
                float f6 = (f4 * 1.0f) / f5;
                if ((f2 * 1.0f) / f3 < f6) {
                    defaultSize = (int) ((f3 / ((f5 * 1.0f) / f4)) + 0.5f);
                } else {
                    defaultSize2 = (int) ((f2 / f6) + 0.5f);
                }
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, surfaceTexture, i2, i3) == null) {
            this.f47501g = true;
            this.f47503i = surfaceTexture;
            g();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, surfaceTexture)) == null) {
            this.f47501g = false;
            stopCameraPreview();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048582, this, surfaceTexture, i2, i3) == null) || surfaceTexture == null) {
            return;
        }
        stopCameraPreview();
        post(new c(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, surfaceTexture) == null) {
        }
    }

    public void openFlashlight() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f()) {
            this.f47502h.k(this.f47499e);
        }
    }

    public void setCamera(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, camera) == null) {
            this.f47499e = camera;
            if (camera != null) {
                c.a.t0.h3.b.a.b bVar = new c.a.t0.h3.b.a.b(getContext());
                this.f47502h = bVar;
                bVar.j(this.f47499e);
                if (this.f47500f) {
                    requestLayout();
                } else {
                    g();
                }
            }
        }
    }

    public void stopCameraPreview() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f47499e == null) {
            return;
        }
        try {
            removeCallbacks(this.f47504j);
            this.f47500f = false;
            this.f47499e.cancelAutoFocus();
            this.f47499e.setOneShotPreviewCallback(null);
            this.f47499e.stopPreview();
        } catch (Exception e2) {
            e2.toString();
        }
    }
}
