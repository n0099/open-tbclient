package com.baidu.tieba.immessagecenter.chatgroup.dispatcher;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ho5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.s1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChatRoomDispatcher implements s1a {
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
                jSONObject.put(YunDialogManager.PAGE_PARAMS_KEY, jSONObject2);
            } catch (Exception e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    @Override // com.baidu.tieba.s1a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatch(JSONObject jSONObject, Context context) {
        Bundle bundle;
        JsonSyntaxException e;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("refre");
            long optLong = jSONObject.optLong("roomId");
            String optString2 = jSONObject.optString(IntentConfig.BACK_SCHEME);
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true);
            loginActivityConfig.setJumpToAfterDestroy(2);
            loginActivityConfig.setBackScheme("com.baidu.tieba://unidispatch/router/portal?" + BdUniDispatchSchemeController.PARAM_CHAT_ROOM_ID_CAMEL + "=" + getPageParmasObj(jSONObject).toString());
            if (!ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                return;
            }
            String optString3 = jSONObject.optString("ability");
            if (!TextUtils.isEmpty(optString3)) {
                try {
                    AbilityItem abilityItem = (AbilityItem) DataExt.toEntity(optString3, AbilityItem.class);
                    bundle = new Bundle();
                    try {
                        bundle.putSerializable("ability", abilityItem);
                    } catch (JsonSyntaxException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (jSONObject.optInt(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST) != 1) {
                        }
                        ho5.a().b(context, optString, optLong, -1, optString2, bundle, z);
                    }
                } catch (JsonSyntaxException e3) {
                    bundle = null;
                    e = e3;
                }
            } else {
                bundle = null;
            }
            if (jSONObject.optInt(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST) != 1) {
                z = true;
            } else {
                z = false;
            }
            ho5.a().b(context, optString, optLong, -1, optString2, bundle, z);
        }
    }
}
