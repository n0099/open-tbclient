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
/* loaded from: classes6.dex */
public class d implements Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23884a;

    /* renamed from: b  reason: collision with root package name */
    public static d f23885b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23886c;

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23887d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23888e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23889f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23890g;

    /* renamed from: h  reason: collision with root package name */
    public int f23891h;

    /* renamed from: i  reason: collision with root package name */
    public int f23892i;
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
        f23884a = d.class.getSimpleName();
        f23885b = null;
        f23886c = new byte[0];
        f23887d = CameraCtrl.getInstance();
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
        this.f23888e = null;
        this.o = 0L;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f23889f = i3;
        this.f23890g = i4;
        this.j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f23888e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), cVar})) == null) {
            synchronized (f23886c) {
                d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
                if (f23885b != null) {
                    if (dVar.equals(f23885b)) {
                        LogUtil.i(f23884a, "a TPreviewCallback object is already created");
                        return f23885b;
                    }
                    f23887d.destroy();
                    f23885b.f23888e.destroyCamera();
                }
                try {
                    if (!f23887d.init(i2, i3, i4, dVar.n, i6, i7)) {
                        LogUtil.errord(f23884a, "can not initialize camera");
                        f23885b = null;
                        return null;
                    }
                    dVar.f23891h = f23887d.getPreviewWidht();
                    dVar.f23892i = f23887d.getPreviewHeight();
                    f23885b = dVar;
                    dVar.a(cVar);
                    return f23885b;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    f23885b = null;
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
                i2 = this.f23891h;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f23887d.pause();
        }
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f23887d.camera() : (b) invokeV.objValue;
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
                c cVar = dVar.f23888e;
                return (cVar == null || this.f23888e != null) && dVar.l == this.l && dVar.f23890g == this.f23890g && dVar.f23889f == this.f23889f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23888e);
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
            sb.append(this.f23890g);
            sb.append(this.f23889f);
            sb.append(this.n);
            sb.append(this.j);
            sb.append(this.k);
            sb.append(this.f23888e.hashCode());
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
                if (this.f23888e != null) {
                    try {
                        this.f23888e.processImage(bArr);
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
            f23887d.setPreviewDisplay(surfaceHolder);
        }
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i2 = this.f23892i;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            synchronized (f23886c) {
                if (cVar != null) {
                    if (this.f23888e != null && cVar != this.f23888e) {
                        LogUtil.w(f23884a, "VideoRequestor new ImageHandler is to add.");
                        this.f23888e.destroyCamera();
                    }
                    cVar.initCamera(this.f23891h, this.f23892i, this.j, this.k);
                    this.f23888e = cVar;
                } else {
                    if (this.f23888e != null) {
                        this.f23888e.destroyCamera();
                    }
                    this.f23888e = null;
                }
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, surfaceHolder)) == null) {
            if (surfaceHolder == null) {
                LogUtil.errord(f23884a, "The camera preview surface is null");
                return false;
            }
            f23887d.start(this, surfaceHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (f23886c) {
                f23887d.destroy();
                if (!z && this.f23888e != null) {
                    this.f23888e.destroyCamera();
                }
                this.f23888e = null;
                f23885b = null;
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
