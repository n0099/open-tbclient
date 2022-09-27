package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class tl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ul5 a;

    public tl5(Context context, am5 am5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, am5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ul5 ul5Var = new ul5(2);
        this.a = ul5Var;
        ul5Var.A = context;
        ul5Var.a = am5Var;
    }

    public fm5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new fm5(this.a) : (fm5) invokeV.objValue;
    }

    public tl5 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.a.T = z;
            return this;
        }
        return (tl5) invokeZ.objValue;
    }

    public tl5 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.a.R = z;
            return this;
        }
        return (tl5) invokeZ.objValue;
    }

    public tl5 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a.P = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.H = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.L = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 g(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) {
            this.a.e = calendar;
            return this;
        }
        return (tl5) invokeL.objValue;
    }

    public tl5 h(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            this.a.y = viewGroup;
            return this;
        }
        return (tl5) invokeL.objValue;
    }

    public tl5 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.a.O = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 j(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            ul5 ul5Var = this.a;
            ul5Var.l = str;
            ul5Var.m = str2;
            ul5Var.n = str3;
            ul5Var.o = str4;
            ul5Var.p = str5;
            ul5Var.q = str6;
            return this;
        }
        return (tl5) invokeCommon.objValue;
    }

    public tl5 k(int i, vl5 vl5Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, vl5Var)) == null) {
            ul5 ul5Var = this.a;
            ul5Var.x = i;
            ul5Var.c = vl5Var;
            return this;
        }
        return (tl5) invokeIL.objValue;
    }

    public tl5 l(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            this.a.Q = f;
            return this;
        }
        return (tl5) invokeF.objValue;
    }

    public tl5 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.a.N = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.a.M = i;
            return this;
        }
        return (tl5) invokeI.objValue;
    }

    public tl5 o(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            ul5 ul5Var = this.a;
            ul5Var.r = i;
            ul5Var.s = i2;
            ul5Var.t = i3;
            ul5Var.u = i4;
            ul5Var.v = i5;
            ul5Var.w = i6;
            return this;
        }
        return (tl5) invokeCommon.objValue;
    }

    public tl5 p(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zArr)) == null) {
            this.a.d = zArr;
            return this;
        }
        return (tl5) invokeL.objValue;
    }
}
