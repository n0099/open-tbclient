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
public final class wt1 extends st1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wt1() {
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

    @Override // com.baidu.tieba.st1
    public yu1 c(@NonNull e22 e22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e22Var)) == null) {
            View q = gm2.i().q(e22Var);
            if (q == null) {
                return new yu1(1001);
            }
            return e(q);
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.st1
    public yu1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new yu1(1001) : (yu1) invokeI.objValue;
    }

    public final yu1 e(@NonNull View view2) {
        InterceptResult invokeL;
        yu1 yu1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                yu1Var = new yu1(0, b((int) (pg3.P(view2.getLeft()) + 0.5f), (int) (pg3.P(view2.getTop()) + 0.5f), (int) (pg3.P(view2.getRight()) + 0.5f), (int) (pg3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (st1.a) {
                    e.printStackTrace();
                }
                yu1Var = new yu1(1001, "result JSONException");
            }
            yz1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + yu1Var);
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }
}
