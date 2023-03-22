package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tieba.c58;
import com.baidu.tieba.g39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class YYRouterDispatcher implements g39 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "bdtiebalive://video/yylive/router";
    public transient /* synthetic */ FieldHolder $fh;

    public YYRouterDispatcher() {
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

    @Override // com.baidu.tieba.g39
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            try {
                c58.d(context, "bdtiebalive://video/yylive/router?url=" + URLEncoder.encode(jSONObject.optString("url"), IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
