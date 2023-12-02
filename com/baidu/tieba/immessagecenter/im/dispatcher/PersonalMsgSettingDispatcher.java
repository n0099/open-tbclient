package com.baidu.tieba.immessagecenter.im.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tieba.immessagecenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.oma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PersonalMsgSettingDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERSONAL_FRIEND_NAME = "friend_name";
    public static final String PERSONAL_FRIEND_UK = "friend_uk";
    public static final String PERSONAL_PORTRAIT_URL = "portrait_url";
    public static final String PERSONAL_ROBOT_ROLE = "robot_role";
    public transient /* synthetic */ FieldHolder $fh;

    public PersonalMsgSettingDispatcher() {
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

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(jSONObject.optString(PERSONAL_FRIEND_UK));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(context, Long.parseLong(bdUidFromBdUK), jSONObject.optString(PERSONAL_ROBOT_ROLE))));
        }
    }
}
