package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class li2 extends wl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<vl2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li2() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.vl2
    public String c(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ta2Var)) == null) {
            if (ta2Var != null && this.d.size() > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                for (vl2 vl2Var : this.d) {
                    sb.append(vl2Var.d("event" + i, ta2Var));
                    i++;
                }
                if (vl2.b) {
                    Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vl2
    public void h(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta2Var) == null) && ta2Var != null && !ta2Var.isWebView() && this.d.size() > 0) {
            if (vl2.b) {
                Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
            }
            for (vl2 vl2Var : this.d) {
                JSEvent e = vl2Var.e(ta2Var);
                if (e != null) {
                    j(ta2Var, e);
                    if (vl2.b) {
                        Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                    }
                }
            }
        }
    }

    public li2 t(vl2 vl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vl2Var)) == null) {
            if (vl2Var != null && !this.d.contains(vl2Var)) {
                this.d.add(vl2Var);
            }
            return this;
        }
        return (li2) invokeL.objValue;
    }
}
