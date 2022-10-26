package com.baidu.tieba;

import android.app.Application;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes4.dex */
public final class ju1 extends gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ju1() {
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

    @Override // com.baidu.tieba.gu1
    public mv1 c(s22 s22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s22Var)) == null) {
            return e();
        }
        return (mv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gu1
    public mv1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (mv1) invokeI.objValue;
    }

    public mv1 e() {
        InterceptResult invokeV;
        mv1 mv1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = tm2.c();
            int i = (int) 28.4d;
            int P = (int) dh3.P(dh3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ef));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (dh3.P(dh3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                mv1Var = new mv1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (gu1.a) {
                    e.printStackTrace();
                }
                mv1Var = new mv1(1001, "result JSONException");
            }
            m02.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + mv1Var);
            return mv1Var;
        }
        return (mv1) invokeV.objValue;
    }
}
