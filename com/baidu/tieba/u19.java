package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.ci9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class u19 extends r19 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u19 F;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Camera.CameraInfo B;
    public Surface C;
    public MediaPlayer D;
    public byte[][] E;
    public Camera r;
    public Camera.Parameters s;
    public int t;
    public ci9.f u;
    public int v;
    public List<Camera.Area> w;
    public List<Camera.Area> x;
    public Matrix y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948158284, "Lcom/baidu/tieba/u19;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948158284, "Lcom/baidu/tieba/u19;");
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void s(ci9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u19 a;

        public a(u19 u19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u19Var;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) && this.a.u != null) {
                this.a.u.a(bArr, 1);
            }
        }
    }

    public u19(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = 0;
        this.a = tbPageContext;
        D();
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        arrayList.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
        ArrayList arrayList2 = new ArrayList();
        this.x = arrayList2;
        arrayList2.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
    }

    @Override // com.baidu.tieba.ci9.b
    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && this.r != null) {
            if ((i >= 1 || i <= -1) && this.z != -1) {
                try {
                    Camera.Parameters parameters = this.r.getParameters();
                    if (!parameters.isZoomSupported()) {
                        return;
                    }
                    int i2 = this.A + i;
                    if (i2 > this.z) {
                        i2 = this.z;
                    } else if (i2 < 0) {
                        i2 = 0;
                    }
                    if (this.A != i2) {
                        parameters.setZoom(i2);
                        this.r.setParameters(parameters);
                        this.A = i2;
                    }
                } catch (Exception e) {
                    cj9.g(e);
                }
            }
        }
    }

    public static u19 B(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (F == null) {
                synchronized (u19.class) {
                    if (F == null) {
                        F = new u19(tbPageContext);
                    } else if (tbPageContext != null) {
                        F.a = tbPageContext;
                    }
                }
            }
            return F;
        }
        return (u19) invokeL.objValue;
    }

    public static Camera.Size C(List<Camera.Size> list, int i, int i2) {
        InterceptResult invokeLII;
        Camera.Size size;
        Camera.Size size2;
        Camera.Size size3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, list, i, i2)) == null) {
            if (list != null) {
                int i3 = i * i2;
                int i4 = Integer.MAX_VALUE;
                float f = i / i2;
                float f2 = 2.1474836E9f;
                float f3 = Float.MAX_VALUE;
                Iterator<Camera.Size> it = list.iterator();
                size = null;
                size2 = null;
                while (true) {
                    if (it.hasNext()) {
                        size3 = it.next();
                        if (size3 != null) {
                            if (size3.width == i && size3.height == i2) {
                                break;
                            }
                            int abs = Math.abs(i3 - (size3.width * size3.height));
                            if (abs < i4) {
                                size = size3;
                                i4 = abs;
                            }
                            float abs2 = Math.abs((size3.width / size3.height) - f);
                            if (abs2 - f3 <= 0.001d) {
                                float f4 = abs;
                                if (f4 < f2) {
                                    size2 = size3;
                                    f2 = f4;
                                    f3 = abs2;
                                }
                            }
                        }
                    } else {
                        size3 = null;
                        break;
                    }
                }
            } else {
                size = null;
                size2 = null;
                size3 = null;
            }
            if (size3 != null) {
                return size3;
            }
            if (size2 != null) {
                return size2;
            }
            if (size == null) {
                return null;
            }
            return size;
        }
        return (Camera.Size) invokeLII.objValue;
    }

    public static void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            boolean z = false;
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(i, cameraInfo);
                    int i2 = cameraInfo.facing;
                    if (i2 == 1) {
                        r19.o = true;
                    } else if (i2 == 0) {
                        r19.p = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    kf9.b("getCameraInfo", e.getMessage());
                }
            }
            if (r19.o && !DeviceInfoUtil.isHuaweiMateX() && !DeviceInfoUtil.isOppN5207()) {
                z = true;
            }
            r19.o = z;
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                if (numberOfCameras == 1) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(0, cameraInfo);
                    this.B = cameraInfo;
                    return 0;
                }
                for (int i = 0; i < numberOfCameras; i++) {
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo2);
                    if (this.b && cameraInfo2.facing == 1) {
                        this.B = cameraInfo2;
                        return i;
                    } else if (!this.b && cameraInfo2.facing == 0) {
                        this.B = cameraInfo2;
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public void d(byte[] bArr) {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) && (camera = this.r) != null) {
            camera.addCallbackBuffer(bArr);
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void i(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if ((z && x()) || (!z && !w())) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.b = z2;
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.v = i;
        }
    }

    public final int[] E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<int[]> supportedPreviewFpsRange = this.r.getParameters().getSupportedPreviewFpsRange();
            int[] iArr = null;
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int i = Integer.MAX_VALUE;
                Iterator<int[]> it = supportedPreviewFpsRange.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int[] next = it.next();
                    if (next != null) {
                        int i3 = 1000;
                        if (next[1] < 1000) {
                            i3 = 1;
                        }
                        int i4 = next[0] / i3;
                        int i5 = next[1] / i3;
                        int i6 = this.k;
                        if (i6 >= i4 && i6 <= i5) {
                            iArr = next;
                            i2 = i6;
                            break;
                        }
                        int abs = Math.abs(i4 - this.k);
                        int abs2 = Math.abs(i5 - this.k);
                        if (abs <= abs2 && abs < i) {
                            iArr = next;
                            i2 = i4;
                            i = abs;
                        } else if (abs2 <= abs && abs2 < i) {
                            iArr = next;
                            i2 = i5;
                            i = abs2;
                        }
                    }
                }
                this.t = i2;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            List<Camera.Size> supportedPreviewSizes = this.r.getParameters().getSupportedPreviewSizes();
            Camera.Size C = C(supportedPreviewSizes, this.f, this.g);
            if (C != null) {
                this.d = C.width;
                this.e = C.height;
            }
            if (r19.q == null) {
                if (C == null || this.f != C.width || this.g != C.height) {
                    StringBuilder sb = new StringBuilder();
                    if (supportedPreviewSizes != null) {
                        for (Camera.Size size : supportedPreviewSizes) {
                            sb.append(size.width);
                            sb.append(',');
                            sb.append(size.height);
                            sb.append('=');
                            sb.append(size.height / size.width);
                            sb.append('\n');
                        }
                    }
                    r19.q = sb.toString();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void q() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (camera = this.r) != null) {
            try {
                camera.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
                String str = "stopPreview:" + e.getMessage();
            }
            try {
                this.r.setPreviewTexture(null);
                this.r.setPreviewCallbackWithBuffer(null);
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = "stopPreview:" + e2.getMessage();
            }
            try {
                this.r.release();
            } catch (Exception e3) {
                e3.printStackTrace();
                String str3 = "stopPreview:" + e3.getMessage();
            }
            this.z = 0;
            this.A = 0;
            this.y = null;
            this.r = null;
            Surface surface = this.C;
            if (surface != null) {
                surface.release();
            }
            MediaPlayer mediaPlayer = this.D;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.D.release();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.c && this.d < this.e) || (!this.c && this.d > this.e)) {
                this.h = this.e;
                this.i = this.d;
                return;
            }
            this.h = this.d;
            this.i = this.e;
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Camera camera = this.r;
            if (camera != null && this.a != null) {
                return camera.getParameters().getPreviewFormat();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return r19.q;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.r != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public void n() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.r != null && (tbPageContext = this.a) != null) {
            y19.h(tbPageContext, A(), this.r);
            G();
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Camera.CameraInfo cameraInfo = this.B;
            if ((cameraInfo != null && cameraInfo.facing == 1) || this.b) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            F = null;
            this.a = null;
            this.u = null;
            this.l = null;
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) && this.r != null && this.a != null) {
            try {
                z(i, i2, 1.0f, i3, i4, vj9.e(), vj9.d(), this.w.get(0).rect);
                z(i, i2, 1.5f, i3, i4, vj9.e(), vj9.d(), this.x.get(0).rect);
                this.r.cancelAutoFocus();
                Camera.Parameters parameters = this.r.getParameters();
                if (parameters.getSupportedFocusModes().contains("auto")) {
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(this.w);
                }
                parameters.setMeteringAreas(this.x);
                this.r.setParameters(parameters);
                this.r.autoFocus(null);
            } catch (Exception e) {
                cj9.g(e);
            }
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public void g(int i, int i2, int i3, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.f = Math.max(i, i2);
            this.g = Math.min(i, i2);
            if (i > i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.c = z2;
            this.k = i3;
            i(z);
        }
    }

    @Override // com.baidu.tieba.ci9.b
    public boolean k(SurfaceTexture surfaceTexture, ci9.f fVar) {
        InterceptResult invokeLL;
        float f;
        List<String> supportedAntibanding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, surfaceTexture, fVar)) == null) {
            this.l = surfaceTexture;
            this.u = fVar;
            try {
                q();
                int A = A();
                this.j = A;
                if (A >= 0) {
                    Camera open = Camera.open(A);
                    this.r = open;
                    if (open != null) {
                        F();
                        int[] E = E();
                        if (this.d > 0 && this.e > 0 && this.t != 0 && E != null && E.length == 2) {
                            Camera.Parameters parameters = this.r.getParameters();
                            this.s = parameters;
                            parameters.setPreviewSize(this.d, this.e);
                            if (t19.c && (supportedAntibanding = this.s.getSupportedAntibanding()) != null && supportedAntibanding.contains("50hz")) {
                                this.s.setAntibanding("50hz");
                            }
                            List<String> supportedFocusModes = this.s.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                this.s.setFocusMode("continuous-video");
                            }
                            this.s.setPreviewFpsRange(E[0], E[1]);
                            y19.g(this.v, this.j, this.r);
                            if (this.s.isVideoStabilizationSupported() && !this.s.getVideoStabilization()) {
                                this.s.setVideoStabilization(true);
                            }
                            try {
                                this.s.setExposureCompensation((int) (((this.s.getMaxExposureCompensation() - f) * 0.5d) + this.s.getMinExposureCompensation()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            this.z = y19.c(this.s);
                            this.r.setParameters(this.s);
                            if (this.E == null) {
                                this.E = (byte[][]) Array.newInstance(byte.class, 3, ((this.d * this.e) * 3) / 2);
                            }
                            a aVar = new a(this);
                            this.r.setPreviewCallbackWithBuffer(aVar);
                            for (int i = 0; i < 3; i++) {
                                this.r.addCallbackBuffer(this.E[i]);
                            }
                            this.r.setPreviewCallbackWithBuffer(aVar);
                            this.r.setPreviewTexture(this.l);
                            this.r.startPreview();
                            G();
                            t19.b.k(1);
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                e2.getMessage();
            }
            q();
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ci9.b
    public void t(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048595, this, i, i2, i3, i4) != null) || this.r == null || this.a == null) {
        }
    }

    public final void z(int i, int i2, float f, int i3, int i4, int i5, int i6, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), rect}) == null) {
            int i7 = (int) (i * f);
            int i8 = (int) (i2 * f);
            int a2 = y19.a(i3 - (i7 / 2), 0, i5 - i7);
            int a3 = y19.a(i4 - (i8 / 2), 0, i6 - i8);
            RectF rectF = new RectF(a2, a3, a2 + i7, a3 + i8);
            if (this.y == null) {
                this.y = new Matrix();
                Matrix matrix = new Matrix();
                TbPageContext tbPageContext = this.a;
                if (tbPageContext != null) {
                    y19.e(tbPageContext, this.j, matrix);
                }
                matrix.invert(this.y);
            }
            this.y.mapRect(rectF);
            y19.f(rectF, rect);
        }
    }
}
