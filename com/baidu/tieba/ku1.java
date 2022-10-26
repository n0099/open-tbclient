package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes4.dex */
public final class ku1 extends gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ku1() {
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

    @Override // com.baidu.tieba.gu1
    public mv1 c(s22 s22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s22Var)) == null) {
            View q = um2.i().q(s22Var);
            if (q == null) {
                return new mv1(1001);
            }
            return e(q);
        }
        return (mv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gu1
    public mv1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new mv1(1001);
        }
        return (mv1) invokeI.objValue;
    }

    public final mv1 e(View view2) {
        InterceptResult invokeL;
        mv1 mv1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                mv1Var = new mv1(0, b((int) (dh3.P(view2.getLeft()) + 0.5f), (int) (dh3.P(view2.getTop()) + 0.5f), (int) (dh3.P(view2.getRight()) + 0.5f), (int) (dh3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (gu1.a) {
                    e.printStackTrace();
                }
                mv1Var = new mv1(1001, "result JSONException");
            }
            m02.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + mv1Var);
            return mv1Var;
        }
        return (mv1) invokeL.objValue;
    }
}
