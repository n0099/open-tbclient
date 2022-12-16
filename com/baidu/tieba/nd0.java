package com.baidu.tieba;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nd0 implements Cloneable, Comparable<nd0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext a;
    public kd0 b;
    public jd0 c;
    public hd0 d;
    public ld0 e;
    public boolean f;
    public gd0 g;
    public md0 h;
    public int i;
    public boolean j;

    public nd0(EGLContext eGLContext, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eGLContext;
        this.i = i;
        this.j = z;
        this.b = new kd0();
        this.c = new jd0();
        this.d = new id0();
        this.e = new ld0();
        this.f = false;
        this.g = null;
        this.h = new md0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public nd0 clone() {
        nd0 nd0Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                nd0Var = (nd0) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                nd0Var = null;
            }
            if (nd0Var != null) {
                nd0Var.m(this.e.clone());
                nd0Var.p(this.h.clone());
            }
            return nd0Var;
        }
        return (nd0) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(nd0 nd0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd0Var)) == null) {
            if (this.i < nd0Var.d()) {
                return -1;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void m(ld0 ld0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ld0Var) == null) {
            this.e = ld0Var;
        }
    }

    public void n(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.a = eGLContext;
        }
    }

    public void o(gd0 gd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gd0Var) == null) {
            this.g = gd0Var;
        }
    }

    public void p(md0 md0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, md0Var) == null) {
            this.h = md0Var;
        }
    }

    public void q(kd0 kd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, kd0Var) == null) {
            this.b = kd0Var;
        }
    }

    public ld0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (ld0) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public hd0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (hd0) invokeV.objValue;
    }

    public EGLContext f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (EGLContext) invokeV.objValue;
    }

    public gd0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (gd0) invokeV.objValue;
    }

    public md0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (md0) invokeV.objValue;
    }

    public jd0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (jd0) invokeV.objValue;
    }

    public kd0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (kd0) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }
}
