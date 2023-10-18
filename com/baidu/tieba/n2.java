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
/* loaded from: classes7.dex */
public class n2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448310441, "Lcom/baidu/tieba/n2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448310441, "Lcom/baidu/tieba/n2;");
        }
    }

    public static void a(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (!a) {
                b(i, pixmap, i2, i3);
            } else if (y0.a.getType() != Application.ApplicationType.Android && y0.a.getType() != Application.ApplicationType.WebGL && y0.a.getType() != Application.ApplicationType.iOS) {
                c(i, pixmap, i2, i3);
            } else {
                d(i, pixmap);
            }
        }
    }

    public static void b(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            y0.c.o(i, 0, pixmap.g(), pixmap.k(), pixmap.i(), 0, pixmap.f(), pixmap.h(), pixmap.j());
            if (y0.d == null && i2 != i3) {
                throw new GdxRuntimeException("texture width and height must be square when using mipmapping.");
            }
            int k = pixmap.k() / 2;
            int i4 = pixmap.i() / 2;
            int i5 = 1;
            Pixmap pixmap2 = pixmap;
            while (k > 0 && i4 > 0) {
                Pixmap pixmap3 = new Pixmap(k, i4, pixmap2.e());
                pixmap3.l(Pixmap.Blending.None);
                pixmap3.c(pixmap2, 0, 0, pixmap2.k(), pixmap2.i(), 0, 0, k, i4);
                if (i5 > 1) {
                    pixmap2.dispose();
                }
                pixmap2 = pixmap3;
                y0.c.o(i, i5, pixmap3.g(), pixmap3.k(), pixmap3.i(), 0, pixmap3.f(), pixmap3.h(), pixmap3.j());
                k = pixmap2.k() / 2;
                i4 = pixmap2.i() / 2;
                i5++;
            }
        }
    }

    public static void c(int i, Pixmap pixmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), pixmap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (!y0.b.a("GL_ARB_framebuffer_object") && !y0.b.a("GL_EXT_framebuffer_object") && y0.e == null) {
                b(i, pixmap, i2, i3);
                return;
            }
            y0.c.o(i, 0, pixmap.g(), pixmap.k(), pixmap.i(), 0, pixmap.f(), pixmap.h(), pixmap.j());
            y0.d.x(i);
        }
    }

    public static void d(int i, Pixmap pixmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, pixmap) == null) {
            y0.c.o(i, 0, pixmap.g(), pixmap.k(), pixmap.i(), 0, pixmap.f(), pixmap.h(), pixmap.j());
            y0.d.x(i);
        }
    }
}
