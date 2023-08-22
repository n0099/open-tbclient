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
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public abstract class mk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pk8 a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Nullable
    public wn5 f;
    @Nullable
    public xn5 g;
    @Nullable
    public yn5 h;
    @Nullable
    public yn5 i;
    @NonNull
    public final pn5 j;
    public zn5 k;
    public final CustomMessageListener l;

    public abstract int k();

    public abstract long l();

    /* loaded from: classes7.dex */
    public class a implements zn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        public a(mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk8Var;
        }

        @Override // com.baidu.tieba.zn5
        public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) && i == 0 && treeSet.size() > 0) {
                this.a.a.j(j, treeSet);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mk8 mk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var, Integer.valueOf(i)};
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
            this.a = mk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            mk8 mk8Var = this.a;
            mk8Var.e = mk8Var.d;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements wn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        public c(mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk8Var;
        }

        @Override // com.baidu.tieba.wn5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            wn5 wn5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) && (wn5Var = this.a.f) != null) {
                wn5Var.a(j, i, str, chatRoomInfo);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements xn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        public d(mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk8Var;
        }

        @Override // com.baidu.tieba.xn5
        public void a(long j, int i, @NonNull String str) {
            xn5 xn5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && (xn5Var = this.a.g) != null) {
                xn5Var.a(j, i, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements yn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        public e(mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk8Var;
        }

        @Override // com.baidu.tieba.yn5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                yn5 yn5Var = this.a.h;
                if (yn5Var != null) {
                    yn5Var.a(i, j, list, i2, str);
                }
                if (this.a.f != null) {
                    for (Long l : list) {
                        this.a.f.a(l.longValue(), i2, str, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements yn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk8 a;

        public f(mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk8Var;
        }

        @Override // com.baidu.tieba.yn5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                yn5 yn5Var = this.a.i;
                if (yn5Var != null) {
                    yn5Var.a(i, j, list, i2, str);
                }
                if (this.a.g != null) {
                    for (Long l : list) {
                        this.a.g.a(l.longValue(), i2, str);
                    }
                }
            }
        }
    }

    public mk8(@NonNull Context context, @NonNull ChatGroupSource chatGroupSource) {
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
        this.j = on5.b();
        this.k = new a(this);
        this.l = new b(this, 2921781);
        this.b = context;
        this.a = new pk8(chatGroupSource);
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
    public List<ChatRoomInfo> m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            List<GroupChatRoomPojo> l = je8.j().l(str);
            if (!ListUtils.isEmpty(l)) {
                return d(l);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void n(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.a.i(list);
            e();
            this.c = true;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.a.p(j);
        }
    }

    public void s(@Nullable yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yn5Var) == null) {
            this.h = yn5Var;
        }
    }

    public void t(@Nullable wn5 wn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wn5Var) == null) {
            this.f = wn5Var;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void v(@Nullable xn5 xn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, xn5Var) == null) {
            this.g = xn5Var;
        }
    }

    public void w(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.a.r(j, i);
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
                if (k() == -1) {
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
                if (k() == -1) {
                    j(g);
                } else {
                    i(g);
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.m();
            q();
            this.b = null;
            this.d = false;
            this.e = false;
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.c) {
            e();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h();
        }
    }

    public final void f(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.j(context, k(), l(), list, this.k);
            this.j.q(this.b, k(), l(), list, new e(this));
        }
    }

    public final void i(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.f(context, k(), l(), list, this.k);
            this.j.m(this.b, k(), l(), list, new f(this));
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
            chatRoomInfo.setNoDisturb(groupChatRoomPojo.O());
            chatRoomInfo.setIsSubscribe(groupChatRoomPojo.N());
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
