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
public class th2 extends el2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<dl2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public th2() {
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

    @Override // com.baidu.tieba.dl2
    public String c(ba2 ba2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ba2Var)) == null) {
            if (ba2Var != null && this.d.size() > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                for (dl2 dl2Var : this.d) {
                    sb.append(dl2Var.d("event" + i, ba2Var));
                    i++;
                }
                if (dl2.b) {
                    Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dl2
    public void h(ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ba2Var) == null) && ba2Var != null && !ba2Var.isWebView() && this.d.size() > 0) {
            if (dl2.b) {
                Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
            }
            for (dl2 dl2Var : this.d) {
                JSEvent e = dl2Var.e(ba2Var);
                if (e != null) {
                    j(ba2Var, e);
                    if (dl2.b) {
                        Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                    }
                }
            }
        }
    }

    public th2 t(dl2 dl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dl2Var)) == null) {
            if (dl2Var != null && !this.d.contains(dl2Var)) {
                this.d.add(dl2Var);
            }
            return this;
        }
        return (th2) invokeL.objValue;
    }
}
