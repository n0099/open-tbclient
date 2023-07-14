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
public final class s22 extends p22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s22() {
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

    @Override // com.baidu.tieba.p22
    public v32 c(@NonNull bb2 bb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bb2Var)) == null) {
            return e();
        }
        return (v32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p22
    public v32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return e();
        }
        return (v32) invokeI.objValue;
    }

    public v32 e() {
        InterceptResult invokeV;
        v32 v32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = cv2.c();
            int i = (int) 28.4d;
            int P = (int) mp3.P(mp3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f6));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (mp3.P(mp3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                v32Var = new v32(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (p22.a) {
                    e.printStackTrace();
                }
                v32Var = new v32(1001, "result JSONException");
            }
            v82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + v32Var);
            return v32Var;
        }
        return (v32) invokeV.objValue;
    }
}
