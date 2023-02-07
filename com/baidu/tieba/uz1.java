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
public final class uz1 extends qz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uz1() {
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

    @Override // com.baidu.tieba.qz1
    public w02 c(@NonNull c82 c82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c82Var)) == null) {
            View q = es2.i().q(c82Var);
            if (q == null) {
                return new w02(1001);
            }
            return e(q);
        }
        return (w02) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qz1
    public w02 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new w02(1001);
        }
        return (w02) invokeI.objValue;
    }

    public final w02 e(@NonNull View view2) {
        InterceptResult invokeL;
        w02 w02Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                w02Var = new w02(0, b((int) (nm3.P(view2.getLeft()) + 0.5f), (int) (nm3.P(view2.getTop()) + 0.5f), (int) (nm3.P(view2.getRight()) + 0.5f), (int) (nm3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (qz1.a) {
                    e.printStackTrace();
                }
                w02Var = new w02(1001, "result JSONException");
            }
            w52.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + w02Var);
            return w02Var;
        }
        return (w02) invokeL.objValue;
    }
}
