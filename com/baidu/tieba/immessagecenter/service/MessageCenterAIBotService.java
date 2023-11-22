package com.baidu.tieba.immessagecenter.service;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.br6;
import com.baidu.tieba.bu5;
import com.baidu.tieba.fu5;
import com.baidu.tieba.gt5;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.service.MessageCenterAIBotService;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pr8;
import com.baidu.tieba.sha;
import com.baidu.tieba.ts8;
import com.baidu.tieba.wq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tJ$\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0017J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/immessagecenter/service/MessageCenterAIBotService;", "Lcom/baidu/tieba/im/lib/socket/IMessageCenterAIBotService;", "()V", "checkIsAibot", "", "uidList", "", "", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "", "jumpToAiBotChatPage", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "context", "Landroid/content/Context;", "uniqueId", "Lcom/baidu/adp/BdUniqueId;", "markMsgRead", "userId", "notifyMsg", "msgList", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "updateAiBotInfo", "paid", "botUk", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MessageCenterAIBotService implements pr8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Lazy<MessageCenterAIBotService> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final MessageCenterAIBotService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (MessageCenterAIBotService) invokeV.objValue;
        }

        public final MessageCenterAIBotService b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (MessageCenterAIBotService) MessageCenterAIBotService.c.getValue();
            }
            return (MessageCenterAIBotService) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends bu5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List<String> a;

        public b(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bu5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                for (String str : this.a) {
                    if (ImAiBotDbService.a.a().d(str)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends bu5<Map<String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;

        public c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterShowItemData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bu5
        /* renamed from: a */
        public Map<String, String> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ImAiBotDbService a = ImAiBotDbService.a.a();
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.a;
                if (imMessageCenterShowItemData != null) {
                    str = imMessageCenterShowItemData.getFriendId();
                } else {
                    str = null;
                }
                return a.c(str);
            }
            return (Map) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-496040184, "Lcom/baidu/tieba/immessagecenter/service/MessageCenterAIBotService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-496040184, "Lcom/baidu/tieba/immessagecenter/service/MessageCenterAIBotService;");
                return;
            }
        }
        b = new a(null);
        c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) MessageCenterAIBotService$Companion$instance$2.INSTANCE);
    }

    public MessageCenterAIBotService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final void d(Function1 callback, Boolean it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, callback, it) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            callback.invoke(it);
        }
    }

    public static final void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            ImAiBotDbService.a.a().e(str, BIMManager.getBdUidFromBdUK(str2), str2);
        }
    }

    public final void c(List<String> uidList, final Function1<? super Boolean, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uidList, callback) == null) {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            fu5.b(new b(uidList), new gt5() { // from class: com.baidu.tieba.e79
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gt5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MessageCenterAIBotService.d(Function1.this, (Boolean) obj);
                    }
                }
            });
        }
    }

    public static final void f(Context context, Map map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, map) == null) {
            String str2 = null;
            if (map != null) {
                str = (String) map.get("paid");
            } else {
                str = null;
            }
            if (map != null) {
                str2 = (String) map.get("uk");
            }
            IMLog.getInstance().i("MessageCenterAIBotService", "jumpToAiBotChatPage paid:" + str + " uk:" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("page", "im/AISingleChat");
                jSONObject.put(YunDialogManager.PAGE_PARAMS_KEY, jSONObject2);
                jSONObject2.put("paid", str);
                jSONObject2.put("uk", str2);
                sha.a(context, new String[]{"tiebaapp://router/portal?params=" + jSONObject});
            }
        }
    }

    @Override // com.baidu.tieba.pr8
    @WorkerThread
    public void a(List<? extends ChatMsg> msgList) {
        PaInfo queryPaInfo;
        JSONObject jSONObject;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msgList) == null) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            ResponsePullMessage responsePullMessage = new ResponsePullMessage();
            GroupMsgData groupMsgData = new GroupMsgData(2012121);
            responsePullMessage.setGroupMsg(new ArrayList());
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = msgList.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((ChatMsg) next).getContacter() != 17592328994873L) {
                    z = true;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                String str2 = null;
                if (it2.hasNext()) {
                    ChatMsg chatMsg = (ChatMsg) it2.next();
                    try {
                        IMLog.getInstance().i("MessageCenterAIBotService", "notifyMsg msg:" + chatMsg);
                        groupMsgData.getGroupInfo().setCustomType(2);
                        queryPaInfo = PaInfoDBManager.getInstance(AppRuntime.getAppContext()).queryPaInfo(chatMsg.getContacter());
                        jSONObject = new JSONObject(chatMsg.getMsgContent());
                        if (jSONObject.has("extra")) {
                            if (Intrinsics.areEqual(new JSONObject(jSONObject.getString("extra")).getString("from"), CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_SERVER)) {
                                str = BIMManager.getBdUidFromBdUK(new JSONObject(chatMsg.getMsgContent()).getJSONObject("extra").getString("uk"));
                            } else {
                                str = ImAiBotDbService.a.a().b(String.valueOf(chatMsg.getContacter())).get("uid");
                            }
                        } else {
                            str = null;
                        }
                        if (ImAiBotDbService.a.a().d(str)) {
                            str2 = str;
                        }
                    } catch (Exception e) {
                        IMLog.getInstance().i("MessageCenterAIBotService", "notifyMsg error " + e);
                    }
                    if (str2 != null) {
                        groupMsgData.getGroupInfo().setGroupId(Long.parseLong(str2));
                        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
                        personalChatMessage.setUserId(Long.parseLong(str2));
                        personalChatMessage.setToUserId(Long.parseLong(str2));
                        UserData userData = new UserData();
                        userData.setUserName(queryPaInfo.getNickName());
                        userData.setUserId(str2.toString());
                        userData.setName_show(queryPaInfo.getNickName());
                        userData.setPortrait(queryPaInfo.getAvatar());
                        userData.setIsFriend(1);
                        personalChatMessage.setUserInfo(userData);
                        personalChatMessage.setToUserInfo(userData);
                        personalChatMessage.setTime(System.currentTimeMillis() / 1000);
                        personalChatMessage.setMsgType(1);
                        personalChatMessage.setIsFriend(1);
                        personalChatMessage.setContent(jSONObject.getString("text"));
                        LinkedList<ChatMessage> linkedList = new LinkedList<>();
                        String sendMsgId = chatMsg.getSendMsgId();
                        Intrinsics.checkNotNullExpressionValue(sendMsgId, "msg.sendMsgId");
                        personalChatMessage.setMsgId(Long.parseLong(sendMsgId));
                        linkedList.add(personalChatMessage);
                        groupMsgData.setListMessageData(linkedList);
                    } else {
                        throw new InvalidParameterException("MessageCenterAIBotService " + chatMsg + " no uid");
                        break;
                    }
                } else {
                    responsePullMessage.getGroupMsg().add(groupMsgData);
                    responsePullMessage.beforeDispatchInBackGround(0, (byte[]) null);
                    MessageManager.getInstance().dispatchResponsedMessage(responsePullMessage);
                    return;
                }
            }
        }
    }

    public final void e(ImMessageCenterShowItemData imMessageCenterShowItemData, final Context context, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterShowItemData, context, bdUniqueId) == null) {
            fu5.b(new c(imMessageCenterShowItemData), new gt5() { // from class: com.baidu.tieba.g79
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gt5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MessageCenterAIBotService.f(context, (Map) obj);
                    }
                }
            });
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("MessageCenterAIBotService", "markMsgRead userId:" + str);
            ImMessageCenterPojo h = ts8.n().h(str, 2);
            if (h != null) {
                h.setUnread_count(0);
                wq8.f().l(h, 2);
            }
        }
    }

    public final void h(final String str, final String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("MessageCenterAIBotService", "updateAiBotInfo paid:" + str + " botUk:" + str2);
            br6.a(new Runnable() { // from class: com.baidu.tieba.f79
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageCenterAIBotService.i(str, str2);
                    }
                }
            }, "ImAiBotUpdate", 1);
        }
    }
}
