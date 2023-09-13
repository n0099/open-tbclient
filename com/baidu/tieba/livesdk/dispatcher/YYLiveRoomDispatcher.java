package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import com.baidu.tieba.o69;
import com.baidu.tieba.r49;
import com.baidu.tieba.s7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class YYLiveRoomDispatcher implements s7a {
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

    @Override // com.baidu.tieba.s7a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            o69.j().G(context, r49.a(PREFIX, jSONObject));
        }
    }
}
