package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Camera f60398a;

    /* renamed from: com.baidu.wallet.base.camera.internal.b$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f60399a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-173617382, "Lcom/baidu/wallet/base/camera/internal/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-173617382, "Lcom/baidu/wallet/base/camera/internal/b$a;");
                    return;
                }
            }
            f60399a = new b(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f60399a : (b) invokeV.objValue;
    }

    public Camera b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f60398a == null) {
                synchronized (b.class) {
                    if (this.f60398a == null) {
                        this.f60398a = Camera.open();
                    }
                }
            }
            return this.f60398a;
        }
        return (Camera) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.stopPreview();
    }

    public Camera.Parameters d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f60398a != null) {
                return this.f60398a.getParameters();
            }
            return null;
        }
        return (Camera.Parameters) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.startPreview();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.release();
        this.f60398a = null;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.cancelAutoFocus();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Camera.Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parameters) == null) {
            if (parameters != null) {
                parameters.setRotation(0);
            }
            if (this.f60398a != null) {
                this.f60398a.setParameters(parameters);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, surfaceHolder) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.setPreviewDisplay(surfaceHolder);
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.addCallbackBuffer(bArr);
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, previewCallback) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.setPreviewCallbackWithBuffer(previewCallback);
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, autoFocusCallback) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.autoFocus(autoFocusCallback);
    }

    public void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, shutterCallback, pictureCallback, pictureCallback2, pictureCallback3) == null) || this.f60398a == null) {
            return;
        }
        this.f60398a.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, autoFocusCallback, str) == null) {
            g();
            Camera.Parameters d2 = d();
            List<String> supportedFocusModes = d2.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains(str)) {
                return;
            }
            d2.setFocusMode(str);
            a(d2);
            a(autoFocusCallback);
        }
    }
}
