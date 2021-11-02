package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
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
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes10.dex */
public class d implements Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f57352a;

    /* renamed from: b  reason: collision with root package name */
    public static d f57353b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f57354c;

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f57355d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f57356e;

    /* renamed from: f  reason: collision with root package name */
    public final int f57357f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57358g;

    /* renamed from: h  reason: collision with root package name */
    public int f57359h;

    /* renamed from: i  reason: collision with root package name */
    public int f57360i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817695605, "Lcom/baidu/wallet/base/camera/internal/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(817695605, "Lcom/baidu/wallet/base/camera/internal/d;");
                return;
            }
        }
        f57352a = d.class.getSimpleName();
        f57353b = null;
        f57354c = new byte[0];
        f57355d = CameraCtrl.getInstance();
    }

    public d(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57356e = null;
        this.o = 0L;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f57357f = i3;
        this.f57358g = i4;
        this.j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f57356e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), cVar})) == null) {
            synchronized (f57354c) {
                d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
                if (f57353b != null) {
                    if (dVar.equals(f57353b)) {
                        LogUtil.i(f57352a, "a TPreviewCallback object is already created");
                        return f57353b;
                    }
                    f57355d.destroy();
                    f57353b.f57356e.destroyCamera();
                }
                try {
                    if (!f57355d.init(i2, i3, i4, dVar.n, i6, i7)) {
                        LogUtil.errord(f57352a, "can not initialize camera");
                        f57353b = null;
                        return null;
                    }
                    dVar.f57359h = f57355d.getPreviewWidht();
                    dVar.f57360i = f57355d.getPreviewHeight();
                    f57353b = dVar;
                    dVar.a(cVar);
                    return f57353b;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f57353b = null;
                    return null;
                }
            }
        }
        return (d) invokeCommon.objValue;
    }

    public synchronized int b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i2 = this.f57359h;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f57355d.pause();
        }
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f57355d.camera() : (b) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                c cVar = dVar.f57356e;
                return (cVar == null || this.f57356e != null) && dVar.l == this.l && dVar.f57358g == this.f57358g && dVar.f57357f == this.f57357f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f57356e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.l);
            sb.append(this.f57358g);
            sb.append(this.f57357f);
            sb.append(this.n);
            sb.append(this.j);
            sb.append(this.k);
            sb.append(this.f57356e.hashCode());
            return sb.hashCode();
        }
        return invokeV.intValue;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bArr, camera) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.o;
            if (0 == j) {
                this.o = currentTimeMillis;
            } else if (currentTimeMillis - j > this.m) {
                this.o = currentTimeMillis;
                if (this.f57356e != null) {
                    try {
                        this.f57356e.processImage(bArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            camera.addCallbackBuffer(bArr);
        }
    }

    public void b(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, surfaceHolder) == null) {
            f57355d.setPreviewDisplay(surfaceHolder);
        }
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i2 = this.f57360i;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            synchronized (f57354c) {
                if (cVar != null) {
                    if (this.f57356e != null && cVar != this.f57356e) {
                        LogUtil.w(f57352a, "VideoRequestor new ImageHandler is to add.");
                        this.f57356e.destroyCamera();
                    }
                    cVar.initCamera(this.f57359h, this.f57360i, this.j, this.k);
                    this.f57356e = cVar;
                } else {
                    if (this.f57356e != null) {
                        this.f57356e.destroyCamera();
                    }
                    this.f57356e = null;
                }
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, surfaceHolder)) == null) {
            if (surfaceHolder == null) {
                LogUtil.errord(f57352a, "The camera preview surface is null");
                return false;
            }
            f57355d.start(this, surfaceHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (f57354c) {
                f57355d.destroy();
                if (!z && this.f57356e != null) {
                    this.f57356e.destroyCamera();
                }
                this.f57356e = null;
                f57353b = null;
            }
        }
    }

    public static int a(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, activity, i2)) == null) {
            try {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (i2 == 1) {
                    return ((-defaultDisplay.getRotation()) * 90) - cameraInfo.orientation;
                }
                return ((-defaultDisplay.getRotation()) * 90) + cameraInfo.orientation;
            } catch (Throwable unused) {
                return a(activity);
            }
        }
        return invokeLI.intValue;
    }

    public static int a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                rotation = 1;
            } else if (rotation == 1) {
                rotation = 0;
            } else if (rotation == 2) {
                rotation = 3;
            } else if (rotation == 3) {
                rotation = 2;
            }
            return rotation * 90;
        }
        return invokeL.intValue;
    }
}
