package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rg7 extends ng7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext f;
    @Nullable
    public FastRequest g;
    public boolean h;
    public ArrayList<ChatRoomInfo> i;
    public ArrayList<ChatRoomInfo> j;
    public String k;
    public df<String> l;
    public f m;
    public CustomMessageListener n;

    /* loaded from: classes6.dex */
    public interface f {
        void a(@Nullable List<ImMessageCenterPojo> list, boolean z);

        void b(@Nullable List<ImMessageCenterPojo> list);
    }

    /* loaded from: classes6.dex */
    public class d extends FastRequest.b<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rg7 rg7Var = this.a.b;
                    rg7Var.l.g("group_chat_http_key", rg7Var.k);
                }
            }
        }

        public d(rg7 rg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, chatGroupInfo) == null) {
                super.b(i, str, chatGroupInfo);
                if (this.b.m != null) {
                    this.b.m.a(null, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, chatGroupInfo) == null) {
                super.e(chatGroupInfo);
                if (this.b.m == null) {
                    return;
                }
                if (chatGroupInfo != null && !ListUtils.isEmpty(chatGroupInfo.getRoomInfoList())) {
                    rg7 rg7Var = this.b;
                    if (rg7Var.l != null && !TextUtils.isEmpty(rg7Var.k)) {
                        eh.d(new a(this));
                    }
                    List<ImMessageCenterPojo> s = this.b.s(chatGroupInfo.getRoomInfoList());
                    if (!ListUtils.isEmpty(s)) {
                        this.b.m.a(s, true);
                    }
                    this.b.x(chatGroupInfo.getRoomInfoList());
                    return;
                }
                this.b.m.a(null, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ik5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 a;

        public a(rg7 rg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.l.get("group_chat_http_key");
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mj5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 a;

        public b(rg7 rg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ChatGroupInfo w = this.a.w(str);
                if (w != null && !ListUtils.isEmpty(w.getRoomInfoList())) {
                    List<ImMessageCenterPojo> s = this.a.s(w.getRoomInfoList());
                    if (!ListUtils.isEmpty(s)) {
                        this.a.m.a(s, true);
                        return;
                    }
                    return;
                }
                this.a.m.a(null, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements FastRequest.e<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 a;

        public c(rg7 rg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public ChatGroupInfo a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (ChatGroupInfo) invokeL.objValue;
            }
            return this.a.w(str);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(rg7 rg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg7Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && map.entrySet() != null && map.entrySet().iterator() != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        arrayList.add(entry.getValue());
                    }
                }
                this.a.D(arrayList);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rg7(TbPageContext tbPageContext, f fVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = null;
        this.l = null;
        this.n = new e(this, 2921766);
        this.f = tbPageContext;
        this.m = fVar;
        kv4.f();
        this.l = kv4.h("tb.im_group_chat_http", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().registerListener(this.n);
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            k(j, 0);
        }
    }

    public final void D(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list) && this.m != null) {
            List<ImMessageCenterPojo> s = s(list);
            if (!ListUtils.isEmpty(s)) {
                this.m.b(s);
            }
        }
    }

    public void E(ChatRoomInfo chatRoomInfo) {
        ArrayList<ChatRoomInfo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, chatRoomInfo) == null) && chatRoomInfo != null && (arrayList = this.i) != null) {
            arrayList.clear();
            this.i.add(chatRoomInfo);
            D(this.i);
        }
    }

    public String u(List<Map<String, Long>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            String json = DataExt.toJson(list);
            if (TextUtils.isEmpty(json)) {
                return "";
            }
            return json;
        }
        return (String) invokeL.objValue;
    }

    public final ChatGroupInfo w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.k = str;
            ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
            try {
                chatGroupInfo.parse(new JSONObject(str));
                return chatGroupInfo;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (ChatGroupInfo) invokeL.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.m != null && this.l != null) {
            mk5.b(new a(this), new b(this));
        }
    }

    @Override // com.baidu.tieba.ng7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FastRequest fastRequest = this.g;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            t();
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.h) {
            return;
        }
        d();
        this.h = false;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            i();
            this.h = true;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !TbSingleton.getInstance().isNeedJoinChatRoom()) {
            return;
        }
        String u = u(v(0));
        if (this.g == null) {
            this.g = new FastRequest(this.f, CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST, TbConfig.GET_SUBSCRIBE_GROUP_CHAT_LIST);
        }
        FastRequest fastRequest = this.g;
        fastRequest.H("chatroom_new_msg", u);
        fastRequest.K(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.J(new d(this));
        fastRequest.L(new c(this));
        fastRequest.I();
    }

    public final List<ImMessageCenterPojo> s(List<ChatRoomInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (ChatRoomInfo chatRoomInfo : list) {
                ImMessageCenterPojo y = y(chatRoomInfo);
                if (y != null) {
                    arrayList.add(y);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<Map<String, Long>> v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ChatRoomInfo> f2 = f(TbadkCoreApplication.getCurrentAccount());
            if (ListUtils.isEmpty(f2)) {
                return null;
            }
            if (i != 0) {
                if (i == 1) {
                    for (ChatRoomInfo chatRoomInfo : f2) {
                        if (!chatRoomInfo.isNoDisturb()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("room_id", Long.valueOf(chatRoomInfo.getRoomId()));
                            if (chatRoomInfo.getNewMessage() != null) {
                                hashMap.put("msg_id", Long.valueOf(chatRoomInfo.getNewMessage().getMsgId()));
                            } else {
                                hashMap.put("msg_id", 0L);
                            }
                            arrayList.add(hashMap);
                        }
                    }
                }
            } else {
                for (ChatRoomInfo chatRoomInfo2 : f2) {
                    HashMap hashMap2 = new HashMap();
                    if (chatRoomInfo2 != null && chatRoomInfo2.getLatestMsgId() != 0) {
                        hashMap2.put("room_id", Long.valueOf(chatRoomInfo2.getRoomId()));
                        if (chatRoomInfo2.getNewMessage() != null) {
                            hashMap2.put("msg_id", Long.valueOf(chatRoomInfo2.getNewMessage().getMsgId()));
                        } else {
                            hashMap2.put("msg_id", 0L);
                        }
                        arrayList.add(hashMap2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final ImMessageCenterPojo y(ChatRoomInfo chatRoomInfo) {
        InterceptResult invokeL;
        long msgTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, chatRoomInfo)) == null) {
            if (chatRoomInfo == null) {
                return null;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(chatRoomInfo.getRoomId()));
            imMessageCenterPojo.setGroup_head(chatRoomInfo.getAvatar());
            imMessageCenterPojo.setGroup_name(chatRoomInfo.getName());
            imMessageCenterPojo.setCustomGroupType(9);
            imMessageCenterPojo.setUnread_count(chatRoomInfo.getUnreadNum());
            imMessageCenterPojo.setGroupJumpUrl(chatRoomInfo.getJumpUrl());
            imMessageCenterPojo.setForumName(chatRoomInfo.getForumName());
            if (chatRoomInfo.getIsShow() == 0) {
                return null;
            }
            ne7.c().a(chatRoomInfo.getName(), chatRoomInfo.getAvatar(), chatRoomInfo.getForumId(), chatRoomInfo.getForumName(), chatRoomInfo.getRoomId(), chatRoomInfo.getLatestMsgId(), chatRoomInfo.getTimestamp());
            if (chatRoomInfo.getNewMessage() == null) {
                imMessageCenterPojo.setLast_user_name("");
                imMessageCenterPojo.setLast_content("");
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setLast_content_time(System.currentTimeMillis());
                return imMessageCenterPojo;
            }
            if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromUid()) && chatRoomInfo.getUnreadNum() == 1 && chatRoomInfo.getNewMessage().getFromUid().equals(TbadkCoreApplication.getCurrentAccount())) {
                imMessageCenterPojo.setUnread_count(0);
            }
            imMessageCenterPojo.setLast_user_name(chatRoomInfo.getNewMessage().getFromName());
            imMessageCenterPojo.setLast_content(chatRoomInfo.getNewMessage().getContent());
            if (String.valueOf(chatRoomInfo.getNewMessage().getMsgTime()).length() <= 10 && chatRoomInfo.getNewMessage().getMsgTime() != 0) {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime() * 1000;
            } else {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime();
            }
            if (ne7.c().d(Long.valueOf(chatRoomInfo.getRoomId()), msgTime)) {
                imMessageCenterPojo.setIs_hidden(1);
            } else {
                imMessageCenterPojo.setIs_hidden(0);
            }
            imMessageCenterPojo.setLast_content_time(msgTime);
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public void x(List<ChatRoomInfo> list) {
        ArrayList<ChatRoomInfo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && TbSingleton.getInstance().isNeedJoinChatRoom() && (arrayList = this.j) != null) {
            arrayList.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null && chatRoomInfo.getIsShow() == 1) {
                    this.j.add(chatRoomInfo);
                }
            }
            g(this.j);
            this.h = true;
        }
    }
}
