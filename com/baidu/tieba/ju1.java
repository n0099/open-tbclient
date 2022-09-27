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
/* loaded from: classes4.dex */
public final class ju1 extends fu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ju1() {
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

    @Override // com.baidu.tieba.fu1
    public lv1 c(@NonNull r22 r22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r22Var)) == null) {
            View q = tm2.i().q(r22Var);
            if (q == null) {
                return new lv1(1001);
            }
            return e(q);
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fu1
    public lv1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new lv1(1001) : (lv1) invokeI.objValue;
    }

    public final lv1 e(@NonNull View view2) {
        InterceptResult invokeL;
        lv1 lv1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                lv1Var = new lv1(0, b((int) (ch3.P(view2.getLeft()) + 0.5f), (int) (ch3.P(view2.getTop()) + 0.5f), (int) (ch3.P(view2.getRight()) + 0.5f), (int) (ch3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (fu1.a) {
                    e.printStackTrace();
                }
                lv1Var = new lv1(1001, "result JSONException");
            }
            l02.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + lv1Var);
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }
}
