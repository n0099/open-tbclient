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
/* loaded from: classes5.dex */
public class o92 extends zc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<yc2> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o92() {
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

    @Override // com.baidu.tieba.yc2
    public String c(w12 w12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w12Var)) == null) {
            if (w12Var == null || this.d.size() <= 0) {
                return null;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (yc2 yc2Var : this.d) {
                sb.append(yc2Var.d("event" + i, w12Var));
                i++;
            }
            if (yc2.b) {
                Log.d("JSEventDispatcher", "combine msg - " + sb.toString());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yc2
    public void h(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w12Var) == null) || w12Var == null || w12Var.isWebView() || this.d.size() <= 0) {
            return;
        }
        if (yc2.b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        for (yc2 yc2Var : this.d) {
            JSEvent e = yc2Var.e(w12Var);
            if (e != null) {
                j(w12Var, e);
                if (yc2.b) {
                    Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
                }
            }
        }
    }

    public o92 t(yc2 yc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yc2Var)) == null) {
            if (yc2Var != null && !this.d.contains(yc2Var)) {
                this.d.add(yc2Var);
            }
            return this;
        }
        return (o92) invokeL.objValue;
    }
}
