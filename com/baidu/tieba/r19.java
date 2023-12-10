package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
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
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public abstract class r19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u19 a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Nullable
    public zk5 f;
    @Nullable
    public al5 g;
    @Nullable
    public bl5 h;
    @Nullable
    public bl5 i;
    @NonNull
    public final sk5 j;
    public cl5 k;
    public final CustomMessageListener l;

    public abstract int l();

    public abstract long m();

    /* loaded from: classes8.dex */
    public class a implements cl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        public a(r19 r19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r19Var;
        }

        @Override // com.baidu.tieba.cl5
        public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) && i == 0 && treeSet.size() > 0) {
                this.a.a.j(j, treeSet);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r19 r19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var, Integer.valueOf(i)};
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
            this.a = r19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            r19 r19Var = this.a;
            r19Var.e = r19Var.d;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        public c(r19 r19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r19Var;
        }

        @Override // com.baidu.tieba.zk5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            zk5 zk5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) && (zk5Var = this.a.f) != null) {
                zk5Var.a(j, i, str, chatRoomInfo);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements al5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        public d(r19 r19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r19Var;
        }

        @Override // com.baidu.tieba.al5
        public void a(long j, int i, @NonNull String str) {
            al5 al5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && (al5Var = this.a.g) != null) {
                al5Var.a(j, i, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements bl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        public e(r19 r19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r19Var;
        }

        @Override // com.baidu.tieba.bl5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                bl5 bl5Var = this.a.h;
                if (bl5Var != null) {
                    bl5Var.a(i, j, list, i2, str);
                }
                if (this.a.f != null) {
                    for (Long l : list) {
                        this.a.f.a(l.longValue(), i2, str, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements bl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r19 a;

        public f(r19 r19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r19Var;
        }

        @Override // com.baidu.tieba.bl5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                bl5 bl5Var = this.a.i;
                if (bl5Var != null) {
                    bl5Var.a(i, j, list, i2, str);
                }
                if (this.a.g != null) {
                    for (Long l : list) {
                        this.a.g.a(l.longValue(), i2, str);
                    }
                }
            }
        }
    }

    public r19(@NonNull Context context, @NonNull ChatGroupSource chatGroupSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatGroupSource};
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
        this.j = rk5.b();
        this.k = new a(this);
        this.l = new b(this, 2921781);
        this.b = context;
        this.a = new u19(chatGroupSource);
        MessageManager.getInstance().registerListener(this.l);
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
                    arrayList.add(x(groupChatRoomPojo));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    @WorkerThread
    public List<ChatRoomInfo> n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            List<GroupChatRoomPojo> l = bu8.j().l(str);
            if (!ListUtils.isEmpty(l)) {
                return d(l);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void o(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.a.i(list);
            e();
            this.c = true;
        }
    }

    public void s(@Nullable bl5 bl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bl5Var) == null) {
            this.h = bl5Var;
        }
    }

    public void t(@Nullable zk5 zk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zk5Var) == null) {
            this.f = zk5Var;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void v(@Nullable al5 al5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, al5Var) == null) {
            this.g = al5Var;
        }
    }

    public void w(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.a.q(j, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e) {
                this.e = false;
                return;
            }
            List<Long> g = this.a.g();
            if (!ListUtils.isEmpty(g)) {
                if (l() == -1) {
                    g(g);
                } else {
                    f(g);
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            List<Long> g = this.a.g();
            if (!ListUtils.isEmpty(g)) {
                if (l() == -1) {
                    j(g);
                } else {
                    i(g);
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.m();
            r();
            this.b = null;
            this.d = false;
            this.e = false;
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.c) {
            e();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            h();
        }
    }

    public final void f(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.j(context, l(), m(), list, this.k);
            this.j.q(this.b, l(), m(), list, new e(this));
        }
    }

    public final void i(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.f(context, l(), m(), list, this.k);
            this.j.m(this.b, l(), m(), list, new f(this));
        }
    }

    public final void g(@NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && this.b != null && this.k != null) {
            for (Long l : list) {
                this.j.d(this.b, l.longValue(), this.k);
                this.j.l(this.b, l.longValue(), new c(this));
            }
        }
    }

    public final void j(@NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && this.b != null && this.k != null) {
            for (Long l : list) {
                this.j.o(this.b, l.longValue(), this.k);
                this.j.r(this.b, l.longValue(), new d(this));
            }
        }
    }

    public Map<Long, ChatRoomInfo> k(@NonNull Map<Long, ChatRoomInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, map)) == null) {
            HashMap hashMap = new HashMap();
            List<Long> g = this.a.g();
            if (!ListUtils.isEmpty(g)) {
                for (int i = 0; i < g.size(); i++) {
                    long longValue = g.get(i).longValue();
                    ChatRoomInfo chatRoomInfo = map.get(Long.valueOf(longValue));
                    if (chatRoomInfo != null) {
                        hashMap.put(Long.valueOf(longValue), chatRoomInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @NonNull
    public final ChatRoomInfo x(@NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, groupChatRoomPojo)) == null) {
            ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
            chatRoomInfo.setRoomId(groupChatRoomPojo.getRoomId());
            chatRoomInfo.setName(groupChatRoomPojo.getName());
            chatRoomInfo.setForumId(groupChatRoomPojo.getForumId());
            chatRoomInfo.setForumName(groupChatRoomPojo.getForumName());
            chatRoomInfo.setAvatar(groupChatRoomPojo.getAvatar());
            chatRoomInfo.setDeleteTime(groupChatRoomPojo.getDeleteTime());
            chatRoomInfo.setTopTime(groupChatRoomPojo.getTopTime());
            chatRoomInfo.setNoDisturb(groupChatRoomPojo.P());
            chatRoomInfo.setIsSubscribe(groupChatRoomPojo.O());
            ChatNewMessage chatNewMessage = new ChatNewMessage();
            chatNewMessage.setMsgId(String.valueOf(groupChatRoomPojo.getLatestMsgId()));
            chatNewMessage.setMsgTime(String.valueOf(groupChatRoomPojo.getTimestamp()));
            chatNewMessage.setLastExitChatRoomTime(groupChatRoomPojo.getLastExitChatRoomTime());
            chatRoomInfo.setNewMessage(chatNewMessage);
            return chatRoomInfo;
        }
        return (ChatRoomInfo) invokeL.objValue;
    }
}
