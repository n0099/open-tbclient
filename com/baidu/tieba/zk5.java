package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class zk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;
    public final Rect b;
    public final RectF c;
    public final int d;
    public final int e;
    public float f;
    public final List<yk5> g;
    public final int h;
    public yk5 i;
    public final Rect j;
    public final Matrix k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948362853, "Lcom/baidu/tieba/zk5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948362853, "Lcom/baidu/tieba/zk5;");
        }
    }

    public zk5(int i, int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new RectF();
        this.b = new Rect();
        this.f = 1.0f;
        this.g = new ArrayList();
        this.k = new Matrix();
        this.e = i2;
        this.d = i;
        this.c = new RectF(0.0f, 0.0f, i, i2);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.h = i / 2;
    }

    public void a(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            int i = rect.right;
            int i2 = this.j.right;
            if (i > i2) {
                rect.right = i2;
            }
            int i3 = rect.bottom;
            int i4 = this.j.bottom;
            if (i3 > i4) {
                rect.bottom = i4;
            }
        }
    }

    public Rect g(yk5 yk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yk5Var)) == null) {
            if (yk5Var == null) {
                return null;
            }
            return yk5Var.e();
        }
        return (Rect) invokeL.objValue;
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.k.postScale(f, f);
        }
    }

    public void s(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            this.f = f;
        }
    }

    public void t(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bitmap) == null) && bitmap != null) {
            yk5 yk5Var = new yk5(bitmap);
            this.i = yk5Var;
            yk5Var.i(0, 0, this.d, this.e);
        }
    }

    public boolean b(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3)) == null) {
            if (i3 == k()) {
                return j(i, i2, i3).intersect(this.b);
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    public Rect j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            int i4 = this.h;
            int i5 = i4 * i3 * i2;
            int i6 = i4 * i3 * i;
            return new Rect(i5, i6, (i3 * i4) + i5, (i3 * i4) + i6);
        }
        return (Rect) invokeIII.objValue;
    }

    public void r(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.k.postScale(f, f, f2, f3);
        }
    }

    public yk5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new yk5(this.h);
        }
        return (yk5) invokeV.objValue;
    }

    public List<yk5> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (Rect) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = 1;
            while (i < Math.round(this.f)) {
                i *= 2;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public yk5 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (yk5) invokeV.objValue;
    }

    public Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.k.mapRect(this.a, this.c);
            u(this.b, this.a);
            return this.b;
        }
        return (Rect) invokeV.objValue;
    }

    public Point[] m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            o();
            int k = k();
            Rect rect = this.b;
            int i = this.h;
            int i2 = (rect.top / k) / i;
            int i3 = (rect.left / k) / i;
            Point point = new Point();
            point.y = i2;
            point.x = i3;
            Point point2 = new Point();
            point2.y = (((rect.bottom / k) / i) * k) + 1;
            point2.x = (((rect.right / k) / i) * k) + 1;
            return new Point[]{point, point2};
        }
        return (Point[]) invokeV.objValue;
    }

    public void p(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k.postTranslate(f, f2);
        }
    }

    public final void u(Rect rect, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, rect, rectF) == null) {
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }
}
