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
/* loaded from: classes5.dex */
public final class k02 extends g02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k02() {
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

    @Override // com.baidu.tieba.g02
    public m12 c(@NonNull s82 s82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s82Var)) == null) {
            View q = us2.i().q(s82Var);
            if (q == null) {
                return new m12(1001);
            }
            return e(q);
        }
        return (m12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g02
    public m12 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return new m12(1001);
        }
        return (m12) invokeI.objValue;
    }

    public final m12 e(@NonNull View view2) {
        InterceptResult invokeL;
        m12 m12Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                m12Var = new m12(0, b((int) (dn3.P(view2.getLeft()) + 0.5f), (int) (dn3.P(view2.getTop()) + 0.5f), (int) (dn3.P(view2.getRight()) + 0.5f), (int) (dn3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (g02.a) {
                    e.printStackTrace();
                }
                m12Var = new m12(1001, "result JSONException");
            }
            m62.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + m12Var);
            return m12Var;
        }
        return (m12) invokeL.objValue;
    }
}
