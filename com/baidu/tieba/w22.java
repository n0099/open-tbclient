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
public final class w22 extends s22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w22() {
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

    @Override // com.baidu.tieba.s22
    public y32 c(@NonNull eb2 eb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eb2Var)) == null) {
            View q = gv2.i().q(eb2Var);
            if (q == null) {
                return new y32(1001);
            }
            return e(q);
        }
        return (y32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s22
    public y32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new y32(1001);
        }
        return (y32) invokeI.objValue;
    }

    public final y32 e(@NonNull View view2) {
        InterceptResult invokeL;
        y32 y32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                y32Var = new y32(0, b((int) (pp3.P(view2.getLeft()) + 0.5f), (int) (pp3.P(view2.getTop()) + 0.5f), (int) (pp3.P(view2.getRight()) + 0.5f), (int) (pp3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (s22.a) {
                    e.printStackTrace();
                }
                y32Var = new y32(1001, "result JSONException");
            }
            y82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + y32Var);
            return y32Var;
        }
        return (y32) invokeL.objValue;
    }
}
