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
/* loaded from: classes7.dex */
public final class nw1 extends kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nw1() {
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

    @Override // com.baidu.tieba.kw1
    public qx1 c(@NonNull v42 v42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v42Var)) == null) {
            return e();
        }
        return (qx1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kw1
    public qx1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (qx1) invokeI.objValue;
    }

    public qx1 e() {
        InterceptResult invokeV;
        qx1 qx1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = wo2.c();
            int i = (int) 28.4d;
            int P = (int) gj3.P(gj3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f6));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (gj3.P(gj3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                qx1Var = new qx1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (kw1.a) {
                    e.printStackTrace();
                }
                qx1Var = new qx1(1001, "result JSONException");
            }
            p22.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + qx1Var);
            return qx1Var;
        }
        return (qx1) invokeV.objValue;
    }
}
