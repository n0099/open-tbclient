package com.baidu.tieba.write.write.work;

import android.content.Context;
import com.baidu.tieba.l1a;
import com.baidu.tieba.xc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WorkPublishDispatcher implements xc9 {
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

    @Override // com.baidu.tieba.xc9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("videoTopic");
            String optString2 = jSONObject.optString("topicId");
            String optString3 = jSONObject.optString("isVideo");
            int a = l1a.a();
            if (l1a.c(a)) {
                l1a.e(context, a, 0);
            }
            if (l1a.b()) {
                l1a.h(null, null, null, null, 0, Boolean.TRUE, optString, optString2, optString3);
            } else {
                l1a.k(false, false, null, null, null, null, 0, Boolean.TRUE, optString, optString2, optString3);
            }
        }
    }
}
