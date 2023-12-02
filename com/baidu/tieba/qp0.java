package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qp0 extends up0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hv0 O;
    public int P;
    @Nullable
    public xu0 Q;

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 23;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tp0
    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sp0
    @NonNull
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "CyberSysPlayer" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tp0
    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099384, "Lcom/baidu/tieba/qp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099384, "Lcom/baidu/tieba/qp0;");
                return;
            }
        }
        rp0.f();
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            av0 av0Var = new av0();
            this.O = av0Var;
            b(av0Var);
        }
    }

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
        }
    }

    @Override // com.baidu.tieba.sp0
    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return T();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tp0
    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.P;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && U()) {
            super.j0();
        }
    }

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qp0(@NonNull kt0 kt0Var, @Nullable Context context) {
        super(kt0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kt0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((kt0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P = 0;
    }

    @Override // com.baidu.tieba.fq0, com.baidu.tieba.sp0
    public void E0(@Nullable Context context) {
        bv0 bv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            b(new pv0());
            if (context instanceof Activity) {
                bv0Var = new bv0((Activity) context);
            } else {
                bv0Var = new bv0();
            }
            b(bv0Var);
            b(new ov0());
            F1();
            b(new jv0());
            E1("ad_video_tail_frame_layer");
        }
    }

    public void E1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            cv0 cv0Var = new cv0(str);
            this.Q = cv0Var;
            b(cv0Var);
        }
    }

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public void G0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.G0(context);
        }
    }

    @Override // com.baidu.tieba.tp0, com.baidu.tieba.sp0
    public void d0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && !U() && !Y()) {
            super.d0(i);
        }
    }
}
