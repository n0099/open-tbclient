package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import com.baidu.tieba.m59;
import com.baidu.tieba.p39;
import com.baidu.tieba.y5a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class YYLiveRoomDispatcher implements y5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "bdtiebalive://video/yylive/joinlive";
    public transient /* synthetic */ FieldHolder $fh;

    public YYLiveRoomDispatcher() {
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

    @Override // com.baidu.tieba.y5a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            m59.j().G(context, p39.a(PREFIX, jSONObject));
        }
    }
}
