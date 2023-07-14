package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes8.dex */
public final class t22 extends p22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t22() {
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
            View q = dv2.i().q(bb2Var);
            if (q == null) {
                return new v32(1001);
            }
            return e(q);
        }
        return (v32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p22
    public v32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new v32(1001);
        }
        return (v32) invokeI.objValue;
    }

    public final v32 e(@NonNull View view2) {
        InterceptResult invokeL;
        v32 v32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                v32Var = new v32(0, b((int) (mp3.P(view2.getLeft()) + 0.5f), (int) (mp3.P(view2.getTop()) + 0.5f), (int) (mp3.P(view2.getRight()) + 0.5f), (int) (mp3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (p22.a) {
                    e.printStackTrace();
                }
                v32Var = new v32(1001, "result JSONException");
            }
            v82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + v32Var);
            return v32Var;
        }
        return (v32) invokeL.objValue;
    }
}
