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
public class ua2 extends fe2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ee2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua2() {
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

    @Override // com.baidu.tieba.ee2
    public String c(c32 c32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c32Var)) == null) {
            if (c32Var != null && this.d.size() > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                for (ee2 ee2Var : this.d) {
                    sb.append(ee2Var.d("event" + i, c32Var));
                    i++;
                }
                if (ee2.b) {
                    Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ee2
    public void h(c32 c32Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c32Var) == null) && c32Var != null && !c32Var.isWebView() && this.d.size() > 0) {
            if (ee2.b) {
                Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
            }
            for (ee2 ee2Var : this.d) {
                JSEvent e = ee2Var.e(c32Var);
                if (e != null) {
                    j(c32Var, e);
                    if (ee2.b) {
                        Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                    }
                }
            }
        }
    }

    public ua2 t(ee2 ee2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ee2Var)) == null) {
            if (ee2Var != null && !this.d.contains(ee2Var)) {
                this.d.add(ee2Var);
            }
            return this;
        }
        return (ua2) invokeL.objValue;
    }
}
