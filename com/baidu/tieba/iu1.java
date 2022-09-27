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
/* loaded from: classes4.dex */
public final class iu1 extends fu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public iu1() {
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

    @Override // com.baidu.tieba.fu1
    public lv1 c(@NonNull r22 r22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r22Var)) == null) ? e() : (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fu1
    public lv1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? e() : (lv1) invokeI.objValue;
    }

    public lv1 e() {
        InterceptResult invokeV;
        lv1 lv1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = sm2.c();
            int i = (int) 28.4d;
            int P = (int) ch3.P(ch3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700ef));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (ch3.P(ch3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                lv1Var = new lv1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (fu1.a) {
                    e.printStackTrace();
                }
                lv1Var = new lv1(1001, "result JSONException");
            }
            l02.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + lv1Var);
            return lv1Var;
        }
        return (lv1) invokeV.objValue;
    }
}
