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
/* loaded from: classes6.dex */
public final class vy1 extends ry1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vy1() {
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
            View q = fr2.i().q(d72Var);
            if (q == null) {
                return new xz1(1001);
            }
            return e(q);
        }
        return (xz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ry1
    public xz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new xz1(1001);
        }
        return (xz1) invokeI.objValue;
    }

    public final xz1 e(@NonNull View view2) {
        InterceptResult invokeL;
        xz1 xz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                xz1Var = new xz1(0, b((int) (ol3.P(view2.getLeft()) + 0.5f), (int) (ol3.P(view2.getTop()) + 0.5f), (int) (ol3.P(view2.getRight()) + 0.5f), (int) (ol3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (ry1.a) {
                    e.printStackTrace();
                }
                xz1Var = new xz1(1001, "result JSONException");
            }
            x42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + xz1Var);
            return xz1Var;
        }
        return (xz1) invokeL.objValue;
    }
}
