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
public final class w12 extends s12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w12() {
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

    @Override // com.baidu.tieba.s12
    public y22 c(@NonNull ea2 ea2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ea2Var)) == null) {
            View q = gu2.i().q(ea2Var);
            if (q == null) {
                return new y22(1001);
            }
            return e(q);
        }
        return (y22) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s12
    public y22 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new y22(1001);
        }
        return (y22) invokeI.objValue;
    }

    public final y22 e(@NonNull View view2) {
        InterceptResult invokeL;
        y22 y22Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                y22Var = new y22(0, b((int) (po3.P(view2.getLeft()) + 0.5f), (int) (po3.P(view2.getTop()) + 0.5f), (int) (po3.P(view2.getRight()) + 0.5f), (int) (po3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (s12.a) {
                    e.printStackTrace();
                }
                y22Var = new y22(1001, "result JSONException");
            }
            y72.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + y22Var);
            return y22Var;
        }
        return (y22) invokeL.objValue;
    }
}
