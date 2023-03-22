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
public final class ry1 extends ny1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ry1() {
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

    @Override // com.baidu.tieba.ny1
    public tz1 c(@NonNull z62 z62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, z62Var)) == null) {
            View q = br2.i().q(z62Var);
            if (q == null) {
                return new tz1(1001);
            }
            return e(q);
        }
        return (tz1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ny1
    public tz1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new tz1(1001);
        }
        return (tz1) invokeI.objValue;
    }

    public final tz1 e(@NonNull View view2) {
        InterceptResult invokeL;
        tz1 tz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                tz1Var = new tz1(0, b((int) (kl3.P(view2.getLeft()) + 0.5f), (int) (kl3.P(view2.getTop()) + 0.5f), (int) (kl3.P(view2.getRight()) + 0.5f), (int) (kl3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (ny1.a) {
                    e.printStackTrace();
                }
                tz1Var = new tz1(1001, "result JSONException");
            }
            t42.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + tz1Var);
            return tz1Var;
        }
        return (tz1) invokeL.objValue;
    }
}
