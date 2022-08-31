package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.jb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ya9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hb9 a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Object obj);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();

        int b();

        void c(int i, int i2, int i3, int i4);

        void d(byte[] bArr);

        String e();

        boolean f();

        void g(int i, int i2, int i3, boolean z);

        void h(boolean z);

        void i(boolean z);

        void j(boolean z);

        boolean k(SurfaceTexture surfaceTexture, f fVar);

        void l(int i);

        void m(boolean z);

        void n();

        boolean o();

        boolean p();

        void q();

        int r();

        void release();

        void s(a aVar);

        void t(int i, int i2, int i3, int i4);

        void u(int i);

        int v();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onBeautyEnableChanged(fd0 fd0Var);

        void onChangeGender(boolean z);

        void onLuaMessage(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes6.dex */
    public interface e extends jb9.b {
        void a(ICaptureResult iCaptureResult);

        void b();

        void c(int i);

        void d();

        void e();

        void f(int i, int i2);

        void g(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(byte[] bArr, int i);
    }

    public ya9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new hb9(context);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a0() : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.c0() : invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.X();
        }
    }

    public void D(int i) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.r(i);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.onDestroy();
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.q0() : (String) invokeV.objValue;
    }

    public void c(b bVar, int i, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.a.A(bVar, i, i2, z, str);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            hb9 hb9Var = this.a;
            if (hb9Var != null) {
                return hb9Var.p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.a.B(cVar);
            this.a.e0();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.onPause();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.onResume();
        }
    }

    public void h() {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.k0();
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.a.s(i, i2);
        }
    }

    public void j() {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.c();
    }

    public void k(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, duMixCallback) == null) {
            this.a.x(duMixCallback);
        }
    }

    public void l(Filter filter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, filter) == null) {
            this.a.y(filter);
        }
    }

    public void m(GLSurfaceView gLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gLSurfaceView) == null) {
            this.a.w(gLSurfaceView);
        }
    }

    public void n() {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.d();
    }

    public void o(boolean z) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.f0(z);
    }

    public void p(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onFrameAvailableListener) == null) {
            this.a.u(onFrameAvailableListener);
        }
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.a.C(dVar);
        }
    }

    public void r(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            this.a.D(eVar);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void t(boolean z) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.G(z);
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.a.T(z);
        }
    }

    public void w(boolean z) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.Y(z);
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.a.setSpeed(f2);
        }
    }

    public boolean y(Sticker sticker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, sticker, str)) == null) ? this.a.H(sticker, str) : invokeLL.booleanValue;
    }

    public void z(float f2) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048605, this, f2) == null) || (hb9Var = this.a) == null) {
            return;
        }
        hb9Var.q(f2);
    }
}
