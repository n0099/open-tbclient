package com.baidu.tieba;

import android.app.Application;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes8.dex */
public final class z22 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z22() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.w22
    public c42 c(@NonNull ib2 ib2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ib2Var)) == null) {
            return e();
        }
        return (c42) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w22
    public c42 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (c42) invokeI.objValue;
    }

    public c42 e() {
        InterceptResult invokeV;
        c42 c42Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = jv2.c();
            int i = (int) 28.4d;
            int P = (int) tp3.P(tp3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f6));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (tp3.P(tp3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                c42Var = new c42(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (w22.a) {
                    e.printStackTrace();
                }
                c42Var = new c42(1001, "result JSONException");
            }
            c92.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + c42Var);
            return c42Var;
        }
        return (c42) invokeV.objValue;
    }
}
