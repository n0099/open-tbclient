package com.baidu.tieba;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k06 {
    public static /* synthetic */ Interceptable $ic;
    public static final float N;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public int J;
    public int K;
    public Rect L;
    public TbImageView.h M;
    public float a;
    public boolean b;
    public float c;
    public int d;
    public int e;
    public float f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public ImageView.ScaleType s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859320, "Lcom/baidu/tieba/k06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859320, "Lcom/baidu/tieba/k06;");
                return;
            }
        }
        N = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
    }

    public Rect b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.L;
        }
        return (Rect) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.t = true;
        }
    }

    public k06() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = true;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        this.f = 15.0f;
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.l = -16777216;
        this.m = 200;
        this.n = 200;
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = -9989158;
        this.s = ImageView.ScaleType.CENTER_CROP;
        this.t = false;
        this.w = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.x = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.z = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.A = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.B = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.C = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.D = 0;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = 0;
        this.I = false;
    }

    public k06(k06 k06Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k06Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = true;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        this.f = 15.0f;
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.l = -16777216;
        this.m = 200;
        this.n = 200;
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = -9989158;
        this.s = ImageView.ScaleType.CENTER_CROP;
        this.t = false;
        this.w = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.x = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.z = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.A = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.B = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.C = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.D = 0;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = 0;
        this.I = false;
        if (k06Var != null) {
            a(k06Var);
        }
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.D = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.y = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.o = i;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.H = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.G = i;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.E = i;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.F = i;
        }
    }

    public void o(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.a = f;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.n = i;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.m = i;
        }
    }

    public void s(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rect) == null) {
            this.L = rect;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.e = i;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.C = i;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.f = i;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.I = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.p = i;
        }
    }

    public void a(k06 k06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k06Var) == null) {
            this.a = k06Var.a;
            this.c = k06Var.c;
            this.d = k06Var.d;
            this.e = k06Var.e;
            this.f = k06Var.f;
            this.h = k06Var.h;
            this.i = k06Var.i;
            this.j = k06Var.j;
            this.k = k06Var.k;
            this.l = k06Var.l;
            this.m = k06Var.m;
            this.n = k06Var.n;
            this.o = k06Var.o;
            this.p = k06Var.p;
            this.q = k06Var.q;
            this.u = k06Var.u;
            this.r = k06Var.r;
            this.t = k06Var.t;
            this.v = k06Var.v;
            this.w = k06Var.w;
            this.x = k06Var.x;
            this.C = k06Var.C;
            this.D = k06Var.D;
            this.E = k06Var.E;
            this.F = k06Var.e;
            this.G = k06Var.G;
            this.z = k06Var.z;
            this.A = k06Var.A;
            this.B = k06Var.B;
            this.I = k06Var.I;
            this.L = k06Var.L;
        }
    }

    public void c(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, typedArray) == null) {
            this.e = typedArray.getDimensionPixelSize(7, 0);
            this.b = typedArray.getBoolean(3, true);
            this.d = typedArray.getDimensionPixelSize(11, 0);
            this.a = typedArray.getFloat(9, 1.12f);
            this.f = typedArray.getDimensionPixelSize(12, (int) this.f);
            this.l = typedArray.getColor(10, this.l);
            this.m = typedArray.getDimensionPixelSize(6, this.m);
            this.n = typedArray.getDimensionPixelSize(5, this.n);
            this.o = typedArray.getResourceId(0, 0);
            this.h = typedArray.getDimensionPixelSize(2, this.h);
            this.i = typedArray.getDimensionPixelSize(1, this.i);
            this.p = typedArray.getResourceId(13, 0);
            this.q = typedArray.getBoolean(8, false);
            this.F = this.e;
        }
    }

    public int[] f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048582, this, i, i2, i3, i4)) == null) {
            int[] imageResize = BdUtilHelper.getImageResize(i, i2, i3, i4);
            if (imageResize == null) {
                return null;
            }
            int[] iArr = {imageResize[0], imageResize[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (this.v && i3 > i5) {
                float f = N;
                if (f > 1.0f) {
                    float f2 = i5;
                    float f3 = i3;
                    if (f2 * f <= f3) {
                        float f4 = f3 * 0.68f;
                        if (f2 * f > f4) {
                            i3 = (int) f4;
                        } else {
                            i3 = (int) (f2 * f);
                        }
                    }
                    if (iArr[0] > 0) {
                        i6 = (iArr[1] * i3) / iArr[0];
                    }
                    i5 = i3;
                }
            }
            return new int[]{i5, i6};
        }
        return (int[]) invokeIIII.objValue;
    }

    public void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            this.h = i;
            this.i = i2;
        }
    }

    public void p(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.a = f2;
            this.c = f;
        }
    }

    public void t(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            this.w = i;
            this.x = i2;
        }
    }
}
