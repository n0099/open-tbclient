package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448319183, "Lcom/baidu/tieba/w5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448319183, "Lcom/baidu/tieba/w5;");
        }
    }

    public static void a(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (!a) {
                b(i, pixmap, i2, i3);
            } else if (e1.a.getType() != Application.ApplicationType.Android && e1.a.getType() != Application.ApplicationType.WebGL && e1.a.getType() != Application.ApplicationType.iOS) {
                c(i, pixmap, i2, i3);
            } else {
                d(i, pixmap);
            }
        }
    }

    public static void b(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            e1.e.q(i, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            if (e1.f == null && i2 != i3) {
                throw new GdxRuntimeException("texture width and height must be square when using mipmapping.");
            }
            int n = pixmap.n() / 2;
            int l = pixmap.l() / 2;
            int i4 = 1;
            Pixmap pixmap2 = pixmap;
            while (n > 0 && l > 0) {
                Pixmap pixmap3 = new Pixmap(n, l, pixmap2.h());
                pixmap3.o(Pixmap.Blending.None);
                pixmap3.f(pixmap2, 0, 0, pixmap2.n(), pixmap2.l(), 0, 0, n, l);
                if (i4 > 1) {
                    pixmap2.dispose();
                }
                pixmap2 = pixmap3;
                e1.e.q(i, i4, pixmap3.j(), pixmap3.n(), pixmap3.l(), 0, pixmap3.i(), pixmap3.k(), pixmap3.m());
                n = pixmap2.n() / 2;
                l = pixmap2.l() / 2;
                i4++;
            }
        }
    }

    public static void c(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (!e1.b.a("GL_ARB_framebuffer_object") && !e1.b.a("GL_EXT_framebuffer_object") && e1.g == null) {
                b(i, pixmap, i2, i3);
                return;
            }
            e1.e.q(i, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            e1.f.F(i);
        }
    }

    public static void d(int i, Pixmap pixmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, pixmap) == null) {
            e1.e.q(i, 0, pixmap.j(), pixmap.n(), pixmap.l(), 0, pixmap.i(), pixmap.k(), pixmap.m());
            e1.f.F(i);
        }
    }
}
