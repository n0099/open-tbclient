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
public final class x22 extends t22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x22() {
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

    @Override // com.baidu.tieba.t22
    public z32 c(@NonNull fb2 fb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fb2Var)) == null) {
            View q = hv2.i().q(fb2Var);
            if (q == null) {
                return new z32(1001);
            }
            return e(q);
        }
        return (z32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t22
    public z32 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new z32(1001);
        }
        return (z32) invokeI.objValue;
    }

    public final z32 e(@NonNull View view2) {
        InterceptResult invokeL;
        z32 z32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                z32Var = new z32(0, b((int) (qp3.P(view2.getLeft()) + 0.5f), (int) (qp3.P(view2.getTop()) + 0.5f), (int) (qp3.P(view2.getRight()) + 0.5f), (int) (qp3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (t22.a) {
                    e.printStackTrace();
                }
                z32Var = new z32(1001, "result JSONException");
            }
            z82.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + z32Var);
            return z32Var;
        }
        return (z32) invokeL.objValue;
    }
}
