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
public final class jx1 extends fx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jx1() {
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

    @Override // com.baidu.tieba.fx1
    public ly1 c(@NonNull q52 q52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q52Var)) == null) {
            View q = sp2.i().q(q52Var);
            if (q == null) {
                return new ly1(1001);
            }
            return e(q);
        }
        return (ly1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fx1
    public ly1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new ly1(1001);
        }
        return (ly1) invokeI.objValue;
    }

    public final ly1 e(@NonNull View view2) {
        InterceptResult invokeL;
        ly1 ly1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                ly1Var = new ly1(0, b((int) (bk3.P(view2.getLeft()) + 0.5f), (int) (bk3.P(view2.getTop()) + 0.5f), (int) (bk3.P(view2.getRight()) + 0.5f), (int) (bk3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (fx1.a) {
                    e.printStackTrace();
                }
                ly1Var = new ly1(1001, "result JSONException");
            }
            k32.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + ly1Var);
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }
}
