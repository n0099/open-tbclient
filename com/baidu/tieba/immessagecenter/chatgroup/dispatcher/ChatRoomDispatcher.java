package com.baidu.tieba.immessagecenter.chatgroup.dispatcher;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.eh5;
import com.baidu.tieba.g39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChatRoomDispatcher implements g39 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OPEN_GROUPCHAT_SCHEME = "com.baidu.tieba://unidispatch/router/portal";
    public transient /* synthetic */ FieldHolder $fh;

    public ChatRoomDispatcher() {
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

    private JSONObject getPageParmasObj(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("roomId", jSONObject.optLong("roomId"));
                jSONObject2.put(IntentConfig.BACK_SCHEME, jSONObject.optLong(IntentConfig.BACK_SCHEME));
                jSONObject.put("pageParams", jSONObject2);
            } catch (Exception e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g39
    public void dispatch(JSONObject jSONObject, Context context) {
        long j;
        String str;
        boolean z;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            long optLong = jSONObject.optLong("roomId");
            String optString = jSONObject.optString(IntentConfig.BACK_SCHEME);
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true);
            loginActivityConfig.setJumpToAfterDestroy(2);
            loginActivityConfig.setBackScheme("com.baidu.tieba://unidispatch/router/portal?" + BdUniDispatchSchemeController.PARAM_CHAT_ROOM_ID_CAMEL + "=" + getPageParmasObj(jSONObject).toString());
            if (!ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                return;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ability");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("ability_conf")) != null) {
                String optString2 = optJSONObject.optString("bot_uk");
                j = optJSONObject.optLong("skill_id");
                str = optString2;
            } else {
                j = 0;
                str = "";
            }
            if (jSONObject.optInt(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST) == 1) {
                z = true;
            } else {
                z = false;
            }
            eh5.a().d(context, optLong, -1, optString, str, j, z);
        }
    }
}
