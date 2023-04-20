package com.baidu.tieba.write.write.work;

import android.content.Context;
import com.baidu.tieba.fd9;
import com.baidu.tieba.t1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WorkPublishDispatcher implements fd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WorkPublishDispatcher() {
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

    @Override // com.baidu.tieba.fd9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("videoTopic");
            String optString2 = jSONObject.optString("topicId");
            String optString3 = jSONObject.optString("isVideo");
            int a = t1a.a();
            if (t1a.c(a)) {
                t1a.e(context, a, 0);
            }
            if (t1a.b()) {
                t1a.h(null, null, null, null, 0, Boolean.TRUE, optString, optString2, optString3);
            } else {
                t1a.k(false, false, null, null, null, null, 0, Boolean.TRUE, optString, optString2, optString3);
            }
        }
    }
}
