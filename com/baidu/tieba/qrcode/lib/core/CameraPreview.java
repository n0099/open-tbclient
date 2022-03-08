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
/* loaded from: classes6.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f46053e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46054f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46055g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.g3.b.a.b f46056h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f46057i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f46058j;
    public Camera.AutoFocusCallback k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f46059e;

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
            this.f46059e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46059e.f46053e != null && this.f46059e.f46054f && this.f46059e.f46055g) {
                try {
                    this.f46059e.f46053e.autoFocus(this.f46059e.k);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    cameraPreview.postDelayed(cameraPreview.f46058j, 2000L);
                    return;
                }
                CameraPreview cameraPreview2 = this.a;
                cameraPreview2.postDelayed(cameraPreview2.f46058j, 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f46060e;

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
            this.f46060e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46060e.g();
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
        this.f46054f = false;
        this.f46055g = false;
        this.f46058j = new a(this);
        this.k = new b(this);
        setSurfaceTextureListener(this);
    }

    public void closeFlashlight() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f()) {
            this.f46056h.b(this.f46053e);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46053e != null && this.f46054f && this.f46055g && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash") : invokeV.booleanValue;
    }

    public final void g() {
        SurfaceTexture surfaceTexture;
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (surfaceTexture = this.f46057i) == null || (camera = this.f46053e) == null) {
            return;
        }
        try {
            this.f46054f = true;
            camera.setPreviewTexture(surfaceTexture);
            this.f46056h.l(this.f46053e);
            this.f46053e.startPreview();
            this.f46053e.autoFocus(this.k);
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
            c.a.r0.g3.b.a.b bVar = this.f46056h;
            if (bVar != null && bVar.g() != null) {
                Point g2 = this.f46056h.g();
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
            this.f46055g = true;
            this.f46057i = surfaceTexture;
            g();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, surfaceTexture)) == null) {
            this.f46055g = false;
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
            this.f46056h.k(this.f46053e);
        }
    }

    public void setCamera(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, camera) == null) {
            this.f46053e = camera;
            if (camera != null) {
                c.a.r0.g3.b.a.b bVar = new c.a.r0.g3.b.a.b(getContext());
                this.f46056h = bVar;
                bVar.j(this.f46053e);
                if (this.f46054f) {
                    requestLayout();
                } else {
                    g();
                }
            }
        }
    }

    public void stopCameraPreview() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f46053e == null) {
            return;
        }
        try {
            removeCallbacks(this.f46058j);
            this.f46054f = false;
            this.f46053e.cancelAutoFocus();
            this.f46053e.setOneShotPreviewCallback(null);
            this.f46053e.stopPreview();
        } catch (Exception e2) {
            e2.toString();
        }
    }
}
