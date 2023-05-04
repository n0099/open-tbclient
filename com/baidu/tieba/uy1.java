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
/* loaded from: classes6.dex */
public final class uy1 extends ry1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uy1() {
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

    @Override // com.baidu.tieba.ry1
    public xz1 c(@NonNull d72 d72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d72Var)) == null) {
            return e();
        }
        return (xz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ry1
    public xz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (xz1) invokeI.objValue;
    }

    public xz1 e() {
        InterceptResult invokeV;
        xz1 xz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = er2.c();
            int i = (int) 28.4d;
            int P = (int) ol3.P(ol3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ef));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (ol3.P(ol3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                xz1Var = new xz1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (ry1.a) {
                    e.printStackTrace();
                }
                xz1Var = new xz1(1001, "result JSONException");
            }
            x42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + xz1Var);
            return xz1Var;
        }
        return (xz1) invokeV.objValue;
    }
}
