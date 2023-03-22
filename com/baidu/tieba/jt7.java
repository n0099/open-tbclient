package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class jt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mt7 a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Nullable
    public jg5 f;
    @Nullable
    public kg5 g;
    @NonNull
    public final cg5 h;
    public mg5 i;
    public final CustomMessageListener j;

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SCENE_CHAT_LIST" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements mg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt7 a;

        public a(jt7 jt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt7Var;
        }

        @Override // com.baidu.tieba.mg5
        public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) && i == 0 && treeSet.size() > 0) {
                this.a.a.h(j, treeSet);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jt7 jt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt7Var, Integer.valueOf(i)};
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
            this.a = jt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            jt7 jt7Var = this.a;
            jt7Var.e = jt7Var.d;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt7 a;

        public c(jt7 jt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt7Var;
        }

        @Override // com.baidu.tieba.jg5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            jg5 jg5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) && (jg5Var = this.a.f) != null) {
                jg5Var.a(j, i, str, chatRoomInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements kg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt7 a;

        public d(jt7 jt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt7Var;
        }

        @Override // com.baidu.tieba.kg5
        public void a(long j, int i, @NonNull String str) {
            kg5 kg5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && (kg5Var = this.a.g) != null) {
                kg5Var.a(j, i, str);
            }
        }
    }

    public jt7(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.h = bg5.b();
        this.i = new a(this);
        this.j = new b(this, 2921781);
        this.b = context;
        this.a = new mt7(context);
        MessageManager.getInstance().registerListener(this.j);
    }

    @NonNull
    public final List<ChatRoomInfo> d(@NonNull List<GroupChatRoomPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                GroupChatRoomPojo groupChatRoomPojo = list.get(i);
                if (groupChatRoomPojo != null) {
                    arrayList.add(s(groupChatRoomPojo));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public List<ChatRoomInfo> i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<GroupChatRoomPojo> h = dp7.f().h(str);
            if (!ListUtils.isEmpty(h)) {
                return d(h);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void j(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.g(list);
            e();
            this.c = true;
        }
    }

    public void n(@Nullable jg5 jg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jg5Var) == null) {
            this.f = jg5Var;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public void p(@Nullable kg5 kg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, kg5Var) == null) {
            this.g = kg5Var;
        }
    }

    @Nullable
    public List<ChatRoomInfo> g(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            List<GroupChatRoomPojo> e = dp7.f().e(str, str2);
            if (!ListUtils.isEmpty(e)) {
                return d(e);
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public void q(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.a.n(j, i);
        }
    }

    public final void e() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e) {
                this.e = false;
                return;
            }
            List<Long> f = this.a.f();
            if (!ListUtils.isEmpty(f) && (context = this.b) != null) {
                this.h.c(context, f, this.i);
                this.h.d(this.b, h(), f, new c(this));
            }
        }
    }

    public void f() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            List<Long> f = this.a.f();
            if (!ListUtils.isEmpty(f) && (context = this.b) != null) {
                this.h.a(context, f, this.i);
                this.h.f(this.b, h(), f, new d(this));
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.k();
            m();
            this.b = null;
            this.d = false;
            this.e = false;
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.c) {
            e();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f();
        }
    }

    @Nullable
    public String r(@NonNull List<ChatRoomInfo> list, @Nullable List<Long> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, list, list2)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list2)) {
                for (int i = 0; i < list.size(); i++) {
                    ChatRoomInfo chatRoomInfo = list.get(i);
                    HashMap hashMap = new HashMap();
                    hashMap.put("room_id", Long.valueOf(chatRoomInfo.getRoomId()));
                    hashMap.put("msg_id", String.valueOf(chatRoomInfo.getLatestMsgId()));
                    arrayList.add(hashMap);
                }
            } else {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    long longValue = list2.get(i2).longValue();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        ChatRoomInfo chatRoomInfo2 = list.get(i3);
                        if (longValue == chatRoomInfo2.getRoomId()) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("room_id", Long.valueOf(chatRoomInfo2.getRoomId()));
                            hashMap2.put("msg_id", String.valueOf(chatRoomInfo2.getLatestMsgId()));
                            arrayList.add(hashMap2);
                        }
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            return DataExt.toJson(arrayList);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public final ChatRoomInfo s(@NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, groupChatRoomPojo)) == null) {
            ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
            chatRoomInfo.setRoomId(groupChatRoomPojo.getRoomId());
            chatRoomInfo.setName(groupChatRoomPojo.getName());
            chatRoomInfo.setForumId(groupChatRoomPojo.getForumId());
            chatRoomInfo.setForumName(groupChatRoomPojo.getForumName());
            chatRoomInfo.setAvatar(groupChatRoomPojo.getAvatar());
            chatRoomInfo.setDeleteTime(groupChatRoomPojo.getDeleteTime());
            chatRoomInfo.setTopTime(groupChatRoomPojo.getTopTime());
            chatRoomInfo.setNoDisturb(groupChatRoomPojo.S());
            chatRoomInfo.setIsSubscribe(groupChatRoomPojo.R());
            ChatNewMessage chatNewMessage = new ChatNewMessage();
            chatNewMessage.setMsgId(String.valueOf(groupChatRoomPojo.getLatestMsgId()));
            chatNewMessage.setMsgTime(String.valueOf(groupChatRoomPojo.getTimestamp()));
            chatRoomInfo.setNewMessage(chatNewMessage);
            return chatRoomInfo;
        }
        return (ChatRoomInfo) invokeL.objValue;
    }
}
