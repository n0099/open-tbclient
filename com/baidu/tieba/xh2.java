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
/* loaded from: classes8.dex */
public class xh2 extends il2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<hl2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh2() {
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

    @Override // com.baidu.tieba.hl2
    public String c(fa2 fa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fa2Var)) == null) {
            if (fa2Var != null && this.d.size() > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                for (hl2 hl2Var : this.d) {
                    sb.append(hl2Var.d("event" + i, fa2Var));
                    i++;
                }
                if (hl2.b) {
                    Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hl2
    public void h(fa2 fa2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fa2Var) == null) && fa2Var != null && !fa2Var.isWebView() && this.d.size() > 0) {
            if (hl2.b) {
                Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
            }
            for (hl2 hl2Var : this.d) {
                JSEvent e = hl2Var.e(fa2Var);
                if (e != null) {
                    j(fa2Var, e);
                    if (hl2.b) {
                        Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                    }
                }
            }
        }
    }

    public xh2 t(hl2 hl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hl2Var)) == null) {
            if (hl2Var != null && !this.d.contains(hl2Var)) {
                this.d.add(hl2Var);
            }
            return this;
        }
        return (xh2) invokeL.objValue;
    }
}
