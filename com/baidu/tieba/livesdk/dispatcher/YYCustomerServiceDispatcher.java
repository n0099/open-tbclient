package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import com.baidu.tieba.j19;
import com.baidu.tieba.t1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class YYCustomerServiceDispatcher implements t1a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "bdtiebalive://video/yylive/customerservice";
    public transient /* synthetic */ FieldHolder $fh;

    public YYCustomerServiceDispatcher() {
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

    @Override // com.baidu.tieba.t1a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            j19.j().E(context, PREFIX);
        }
    }
}
