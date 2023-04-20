package com.baidu.tieba.personPolymeric.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.fd9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PersonPolymericDispatcher implements fd9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URI_PREFIX = "com.baidu.tieba://unidispatch/usercenter?";
    public transient /* synthetic */ FieldHolder $fh;

    public PersonPolymericDispatcher() {
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
            HashMap hashMap = new HashMap();
            hashMap.put("portrait", jSONObject.optString("portrait"));
            hashMap.put("source", jSONObject.optString("source"));
            if (jSONObject.optString("useMainState") != null && jSONObject.optString("useMainState").equals("1")) {
                hashMap.put("useMainState", "true");
            } else {
                hashMap.put("useMainState", "false");
            }
            String appendParams = UrlUtils.appendParams(URI_PREFIX, hashMap);
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(context);
            personPolymericActivityConfig.setUri(Uri.parse(appendParams));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
        }
    }
}
