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
/* loaded from: classes7.dex */
public final class ow1 extends kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ow1() {
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

    @Override // com.baidu.tieba.kw1
    public qx1 c(@NonNull v42 v42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v42Var)) == null) {
            View q = xo2.i().q(v42Var);
            if (q == null) {
                return new qx1(1001);
            }
            return e(q);
        }
        return (qx1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kw1
    public qx1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new qx1(1001);
        }
        return (qx1) invokeI.objValue;
    }

    public final qx1 e(@NonNull View view2) {
        InterceptResult invokeL;
        qx1 qx1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                qx1Var = new qx1(0, b((int) (gj3.P(view2.getLeft()) + 0.5f), (int) (gj3.P(view2.getTop()) + 0.5f), (int) (gj3.P(view2.getRight()) + 0.5f), (int) (gj3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (kw1.a) {
                    e.printStackTrace();
                }
                qx1Var = new qx1(1001, "result JSONException");
            }
            p22.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + qx1Var);
            return qx1Var;
        }
        return (qx1) invokeL.objValue;
    }
}
