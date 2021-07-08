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
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23994a;

    /* renamed from: b  reason: collision with root package name */
    public static d f23995b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23996c;

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23997d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23998e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23999f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24000g;

    /* renamed from: h  reason: collision with root package name */
    public int f24001h;

    /* renamed from: i  reason: collision with root package name */
    public int f24002i;
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
        f23994a = d.class.getSimpleName();
        f23995b = null;
        f23996c = new byte[0];
        f23997d = CameraCtrl.getInstance();
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
        this.f23998e = null;
        this.o = 0L;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f23999f = i3;
        this.f24000g = i4;
        this.j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f23998e = cVar;
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
            synchronized (f23996c) {
                d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
                if (f23995b != null) {
                    if (dVar.equals(f23995b)) {
                        LogUtil.i(f23994a, "a TPreviewCallback object is already created");
                        return f23995b;
                    }
                    f23997d.destroy();
                    f23995b.f23998e.destroyCamera();
                }
                try {
                    if (!f23997d.init(i2, i3, i4, dVar.n, i6, i7)) {
                        LogUtil.errord(f23994a, "can not initialize camera");
                        f23995b = null;
                        return null;
                    }
                    dVar.f24001h = f23997d.getPreviewWidht();
                    dVar.f24002i = f23997d.getPreviewHeight();
                    f23995b = dVar;
                    dVar.a(cVar);
                    return f23995b;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f23995b = null;
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
                i2 = this.f24001h;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f23997d.pause();
        }
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f23997d.camera() : (b) invokeV.objValue;
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
                c cVar = dVar.f23998e;
                return (cVar == null || this.f23998e != null) && dVar.l == this.l && dVar.f24000g == this.f24000g && dVar.f23999f == this.f23999f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23998e);
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
            sb.append(this.f24000g);
            sb.append(this.f23999f);
            sb.append(this.n);
            sb.append(this.j);
            sb.append(this.k);
            sb.append(this.f23998e.hashCode());
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
                if (this.f23998e != null) {
                    try {
                        this.f23998e.processImage(bArr);
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
            f23997d.setPreviewDisplay(surfaceHolder);
        }
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i2 = this.f24002i;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            synchronized (f23996c) {
                if (cVar != null) {
                    if (this.f23998e != null && cVar != this.f23998e) {
                        LogUtil.w(f23994a, "VideoRequestor new ImageHandler is to add.");
                        this.f23998e.destroyCamera();
                    }
                    cVar.initCamera(this.f24001h, this.f24002i, this.j, this.k);
                    this.f23998e = cVar;
                } else {
                    if (this.f23998e != null) {
                        this.f23998e.destroyCamera();
                    }
                    this.f23998e = null;
                }
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, surfaceHolder)) == null) {
            if (surfaceHolder == null) {
                LogUtil.errord(f23994a, "The camera preview surface is null");
                return false;
            }
            f23997d.start(this, surfaceHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (f23996c) {
                f23997d.destroy();
                if (!z && this.f23998e != null) {
                    this.f23998e.destroyCamera();
                }
                this.f23998e = null;
                f23995b = null;
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
