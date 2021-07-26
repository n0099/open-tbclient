package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f20572e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20573f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20574g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.t2.b.a.b f20575h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f20576i;
    public Runnable j;
    public Camera.AutoFocusCallback k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f20577e;

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
            this.f20577e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20577e.f20572e != null && this.f20577e.f20573f && this.f20577e.f20574g) {
                try {
                    this.f20577e.f20572e.autoFocus(this.f20577e.k);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f20578a;

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
            this.f20578a = cameraPreview;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) {
                if (z) {
                    CameraPreview cameraPreview = this.f20578a;
                    cameraPreview.postDelayed(cameraPreview.j, 2000L);
                    return;
                }
                CameraPreview cameraPreview2 = this.f20578a;
                cameraPreview2.postDelayed(cameraPreview2.j, 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f20579e;

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
            this.f20579e = cameraPreview;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20579e.f();
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
        this.f20573f = false;
        this.f20574g = false;
        this.j = new a(this);
        this.k = new b(this);
        setSurfaceTextureListener(this);
    }

    public final void f() {
        SurfaceTexture surfaceTexture;
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (surfaceTexture = this.f20576i) == null || (camera = this.f20572e) == null) {
            return;
        }
        try {
            this.f20573f = true;
            camera.setPreviewTexture(surfaceTexture);
            this.f20575h.i(this.f20572e);
            this.f20572e.startPreview();
            this.f20572e.autoFocus(this.k);
        } catch (Exception e2) {
            Log.e(l, e2.toString(), e2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f20572e == null) {
            return;
        }
        try {
            removeCallbacks(this.j);
            this.f20573f = false;
            this.f20572e.cancelAutoFocus();
            this.f20572e.setOneShotPreviewCallback(null);
            this.f20572e.stopPreview();
        } catch (Exception e2) {
            Log.e(l, e2.toString(), e2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int defaultSize = TextureView.getDefaultSize(getSuggestedMinimumWidth(), i2);
            int defaultSize2 = TextureView.getDefaultSize(getSuggestedMinimumHeight(), i3);
            d.a.q0.t2.b.a.b bVar = this.f20575h;
            if (bVar != null && bVar.e() != null) {
                Point e2 = this.f20575h.e();
                float f2 = defaultSize;
                float f3 = defaultSize2;
                float f4 = e2.x;
                float f5 = e2.y;
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
        if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i2, i3) == null) {
            this.f20574g = true;
            this.f20576i = surfaceTexture;
            f();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
            this.f20574g = false;
            g();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i2, i3) == null) || surfaceTexture == null) {
            return;
        }
        g();
        post(new c(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
        }
    }

    public void setCamera(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, camera) == null) {
            this.f20572e = camera;
            if (camera != null) {
                d.a.q0.t2.b.a.b bVar = new d.a.q0.t2.b.a.b(getContext());
                this.f20575h = bVar;
                bVar.h(this.f20572e);
                if (this.f20573f) {
                    requestLayout();
                } else {
                    f();
                }
            }
        }
    }
}
