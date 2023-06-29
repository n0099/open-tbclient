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
public class m26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n26 a;

    public m26(Context context, t26 t26Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, t26Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n26 n26Var = new n26(2);
        this.a = n26Var;
        n26Var.A = context;
        n26Var.a = t26Var;
    }

    public y26 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new y26(this.a);
        }
        return (y26) invokeV.objValue;
    }

    public m26 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.a.f1136T = z;
            return this;
        }
        return (m26) invokeZ.objValue;
    }

    public m26 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.a.R = z;
            return this;
        }
        return (m26) invokeZ.objValue;
    }

    public m26 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a.P = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.H = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.L = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 g(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) {
            this.a.e = calendar;
            return this;
        }
        return (m26) invokeL.objValue;
    }

    public m26 h(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            this.a.y = viewGroup;
            return this;
        }
        return (m26) invokeL.objValue;
    }

    public m26 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.a.O = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 l(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            this.a.Q = f;
            return this;
        }
        return (m26) invokeF.objValue;
    }

    public m26 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.a.N = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.a.M = i;
            return this;
        }
        return (m26) invokeI.objValue;
    }

    public m26 p(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zArr)) == null) {
            this.a.d = zArr;
            return this;
        }
        return (m26) invokeL.objValue;
    }

    public m26 j(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            n26 n26Var = this.a;
            n26Var.l = str;
            n26Var.m = str2;
            n26Var.n = str3;
            n26Var.o = str4;
            n26Var.p = str5;
            n26Var.q = str6;
            return this;
        }
        return (m26) invokeCommon.objValue;
    }

    public m26 k(int i, o26 o26Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, o26Var)) == null) {
            n26 n26Var = this.a;
            n26Var.x = i;
            n26Var.c = o26Var;
            return this;
        }
        return (m26) invokeIL.objValue;
    }

    public m26 o(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            n26 n26Var = this.a;
            n26Var.r = i;
            n26Var.s = i2;
            n26Var.t = i3;
            n26Var.u = i4;
            n26Var.v = i5;
            n26Var.w = i6;
            return this;
        }
        return (m26) invokeCommon.objValue;
    }
}
