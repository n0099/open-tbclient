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
public final class ty1 extends py1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ty1() {
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

    @Override // com.baidu.tieba.py1
    public vz1 c(@NonNull b72 b72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b72Var)) == null) {
            View q = dr2.i().q(b72Var);
            if (q == null) {
                return new vz1(1001);
            }
            return e(q);
        }
        return (vz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.py1
    public vz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new vz1(1001);
        }
        return (vz1) invokeI.objValue;
    }

    public final vz1 e(@NonNull View view2) {
        InterceptResult invokeL;
        vz1 vz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                vz1Var = new vz1(0, b((int) (ml3.P(view2.getLeft()) + 0.5f), (int) (ml3.P(view2.getTop()) + 0.5f), (int) (ml3.P(view2.getRight()) + 0.5f), (int) (ml3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (py1.a) {
                    e.printStackTrace();
                }
                vz1Var = new vz1(1001, "result JSONException");
            }
            v42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + vz1Var);
            return vz1Var;
        }
        return (vz1) invokeL.objValue;
    }
}
