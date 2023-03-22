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
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
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
/* loaded from: classes5.dex */
public class nt7 extends jt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ChatRoomInfo> k;
    public ArrayList<ChatRoomInfo> l;
    public me<String> m;
    public TbPageContext n;
    @Nullable
    public FastRequest o;
    public boolean p;
    public String q;
    public boolean r;
    public ArrayList<Long> s;
    public h t;
    public CustomMessageListener u;

    /* loaded from: classes5.dex */
    public interface h {
        void a(@Nullable List<ImMessageCenterPojo> list, boolean z);

        void b(@Nullable List<ImMessageCenterPojo> list);
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nt7 nt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var, Integer.valueOf(i)};
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
            this.a = nt7Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && map.entrySet() != null && map.entrySet().iterator() != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null && !ListUtils.isEmpty(this.a.s) && this.a.s.contains(Long.valueOf(((ChatRoomInfo) entry.getValue()).getRoomId()))) {
                        arrayList.add(entry.getValue());
                    }
                }
                this.a.R(arrayList);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends wp5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt7 a;

        public b(nt7 nt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.m.get("group_chat_http_key");
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zo5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt7 a;

        public c(nt7 nt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !this.a.r) {
                return;
            }
            ChatGroupInfo I = this.a.I(str, false);
            if (I == null || ListUtils.isEmpty(I.getRoomInfoList())) {
                if (this.a.t != null) {
                    this.a.t.a(null, false);
                    return;
                }
                return;
            }
            List<ImMessageCenterPojo> C = this.a.C(I.getRoomInfoList());
            if (!ListUtils.isEmpty(C) && this.a.t != null) {
                this.a.t.a(C, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ nt7 b;

        public d(nt7 nt7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nt7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ox7.a().c(this.b.i(TbadkCoreApplication.getCurrentAccount()), this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements FastRequest.e<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt7 a;

        public e(nt7 nt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt7Var;
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
            return this.a.I(str, true);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends FastRequest.b<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt7 b;

        public f(nt7 nt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, chatGroupInfo) == null) {
                super.b(i, str, chatGroupInfo);
                if (this.b.t != null) {
                    this.b.t.a(null, false);
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
                this.b.r = false;
                if (this.b.t == null) {
                    return;
                }
                nt7 nt7Var = this.b;
                nt7Var.P(nt7Var.q);
                if (chatGroupInfo == null || ListUtils.isEmpty(chatGroupInfo.getRoomInfoList())) {
                    this.b.D(new ArrayList());
                    if (this.b.t != null) {
                        this.b.t.a(null, false);
                        return;
                    }
                    return;
                }
                this.b.D(chatGroupInfo.getRoomInfoList());
                List<ImMessageCenterPojo> C = this.b.C(chatGroupInfo.getRoomInfoList());
                if (!ListUtils.isEmpty(C) && this.b.t != null) {
                    this.b.t.a(C, true);
                }
                this.b.J(chatGroupInfo.getRoomInfoList());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nt7 b;

        public g(nt7 nt7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nt7Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.m.g("group_chat_http_key", this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt7(TbPageContext tbPageContext, h hVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hVar};
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
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = null;
        this.p = false;
        this.q = null;
        this.r = true;
        this.s = new ArrayList<>();
        this.u = new a(this, 2921766);
        this.n = tbPageContext;
        this.t = hVar;
        yz4.d();
        this.m = yz4.f("tb.im_group_chat_http", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().registerListener(this.u);
    }

    public final void D(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ng.d(new d(this, list));
        }
    }

    public String F(List<Map<String, Long>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
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

    public void O(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            q(j, 0);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && this.m != null) {
            ng.d(new g(this, str));
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            H();
        }
    }

    public final void R(List<ChatRoomInfo> list) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, list) == null) && !ListUtils.isEmpty(list) && this.t != null) {
            List<ImMessageCenterPojo> C = C(list);
            if (!ListUtils.isEmpty(C) && (hVar = this.t) != null) {
                hVar.b(C);
            }
        }
    }

    public void S(ChatRoomInfo chatRoomInfo) {
        ArrayList<ChatRoomInfo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, chatRoomInfo) == null) && chatRoomInfo != null && (arrayList = this.k) != null) {
            arrayList.clear();
            this.k.add(chatRoomInfo);
            R(this.k);
        }
    }

    public final ChatGroupInfo I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.q = null;
                return null;
            }
            if (z) {
                this.q = str;
            }
            ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
            try {
                chatGroupInfo.parse(new JSONObject(str));
                return chatGroupInfo;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (ChatGroupInfo) invokeLZ.objValue;
    }

    public final List<ImMessageCenterPojo> C(List<ChatRoomInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (ChatRoomInfo chatRoomInfo : list) {
                ImMessageCenterPojo K = K(chatRoomInfo);
                if (K != null) {
                    arrayList.add(K);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !this.p) {
            return;
        }
        f();
        this.p = false;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            H();
            l();
            this.p = true;
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.t != null && this.m != null) {
            this.r = true;
            aq5.b(new b(this), new c(this));
        }
    }

    @Override // com.baidu.tieba.jt7
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.k();
            FastRequest fastRequest = this.o;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            this.t = null;
            E();
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    public List<Map<String, Long>> G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ChatRoomInfo> i2 = i(TbadkCoreApplication.getCurrentAccount());
            if (ListUtils.isEmpty(i2)) {
                return null;
            }
            if (i != 0) {
                if (i == 1) {
                    for (ChatRoomInfo chatRoomInfo : i2) {
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
                for (ChatRoomInfo chatRoomInfo2 : i2) {
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

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.s.clear();
            List<ChatRoomInfo> i = i(TbadkCoreApplication.getCurrentAccount());
            if (!ListUtils.isEmpty(i)) {
                for (ChatRoomInfo chatRoomInfo : i) {
                    if (chatRoomInfo != null && chatRoomInfo.isSubscribe()) {
                        this.s.add(Long.valueOf(chatRoomInfo.getRoomId()));
                    }
                }
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !TbSingleton.getInstance().isNeedJoinChatRoom()) {
            return;
        }
        String F = F(G(0));
        if (this.o == null) {
            this.o = new FastRequest(this.n, CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST, TbConfig.GET_SUBSCRIBE_GROUP_CHAT_LIST);
        }
        FastRequest fastRequest = this.o;
        fastRequest.S("chatroom_new_msg", F);
        fastRequest.W(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.U(new f(this));
        fastRequest.X(new e(this));
        fastRequest.T();
    }

    public void J(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && TbSingleton.getInstance().isNeedJoinChatRoom() && this.l != null) {
            H();
            this.l.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null && chatRoomInfo.getIsShow() == 1) {
                    this.l.add(chatRoomInfo);
                }
            }
            j(this.l);
            this.p = true;
        }
    }

    public final ImMessageCenterPojo K(ChatRoomInfo chatRoomInfo) {
        InterceptResult invokeL;
        long msgTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatRoomInfo)) == null) {
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
            if (chatRoomInfo.getAtInfo() != null) {
                wx4 wx4Var = new wx4();
                wx4Var.b(chatRoomInfo.getAtInfo().getAllMsgCount());
                wx4Var.c(chatRoomInfo.getAtInfo().getCountAll());
                wx4Var.d(chatRoomInfo.getAtInfo().getSingleMsgCount());
                imMessageCenterPojo.setAtInfoData(wx4Var);
            }
            imMessageCenterPojo.setForumName(chatRoomInfo.getForumName());
            if (chatRoomInfo.getIsShow() == 0) {
                return null;
            }
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
            if (xq7.b().c(Long.valueOf(chatRoomInfo.getRoomId()), msgTime)) {
                imMessageCenterPojo.setIs_hidden(1);
            } else {
                imMessageCenterPojo.setIs_hidden(0);
            }
            imMessageCenterPojo.setLast_content_time(msgTime);
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }
}
