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
public final class ry1 extends oy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ry1() {
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

    @Override // com.baidu.tieba.oy1
    public uz1 c(@NonNull a72 a72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a72Var)) == null) {
            return e();
        }
        return (uz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oy1
    public uz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (uz1) invokeI.objValue;
    }

    public uz1 e() {
        InterceptResult invokeV;
        uz1 uz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = br2.c();
            int i = (int) 28.4d;
            int P = (int) ll3.P(ll3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ef));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (ll3.P(ll3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                uz1Var = new uz1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (oy1.a) {
                    e.printStackTrace();
                }
                uz1Var = new uz1(1001, "result JSONException");
            }
            u42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + uz1Var);
            return uz1Var;
        }
        return (uz1) invokeV.objValue;
    }
}
