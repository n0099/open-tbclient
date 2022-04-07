package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class PersonalChatActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonalChatActivityStaticAutoGenerateUrlCollectorImpl() {
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

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            new ArrayList();
            hashMap.put("2002001", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2002005", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2001275", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2005016", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2008001", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2005016", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2001143", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2001146", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("2001149", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            hashMap.put("3001000", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add("PersonalMsgImageActivityConfig");
            arrayList.add("MessageCenterActivityConfig");
            arrayList.add("AtMessageActivityConfig");
            arrayList.add("AtMessageActivityConfig");
            arrayList.add("InviteFriendListActivityConfig");
            arrayList.add("PersonalTalkSettingActivityConfig");
            arrayList.add("SelectFriendActivityConfig");
            arrayList.add("StrangerListActivityConfig");
            arrayList.add("AddFriendActivityConfig");
            arrayList.add("ReplyMeActivityConfig");
            arrayList.add("OfficialNotificationActivityConfig");
            arrayList.add(UrlSchemaHelper.GOTO_PERSONAL_CHAT);
            arrayList.add(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT);
            hashMap.put("com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic", arrayList);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
