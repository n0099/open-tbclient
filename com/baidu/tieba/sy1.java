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
public final class sy1 extends oy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sy1() {
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
            View q = cr2.i().q(a72Var);
            if (q == null) {
                return new uz1(1001);
            }
            return e(q);
        }
        return (uz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oy1
    public uz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new uz1(1001);
        }
        return (uz1) invokeI.objValue;
    }

    public final uz1 e(@NonNull View view2) {
        InterceptResult invokeL;
        uz1 uz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                uz1Var = new uz1(0, b((int) (ll3.P(view2.getLeft()) + 0.5f), (int) (ll3.P(view2.getTop()) + 0.5f), (int) (ll3.P(view2.getRight()) + 0.5f), (int) (ll3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (oy1.a) {
                    e.printStackTrace();
                }
                uz1Var = new uz1(1001, "result JSONException");
            }
            u42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + uz1Var);
            return uz1Var;
        }
        return (uz1) invokeL.objValue;
    }
}
