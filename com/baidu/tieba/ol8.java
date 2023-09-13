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
public abstract class ol8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rl8 a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Nullable
    public po5 f;
    @Nullable
    public qo5 g;
    @Nullable
    public ro5 h;
    @Nullable
    public ro5 i;
    @NonNull
    public final io5 j;
    public so5 k;
    public final CustomMessageListener l;

    public abstract int k();

    public abstract long l();

    /* loaded from: classes7.dex */
    public class a implements so5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol8 a;

        public a(ol8 ol8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol8Var;
        }

        @Override // com.baidu.tieba.so5
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
        public final /* synthetic */ ol8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ol8 ol8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var, Integer.valueOf(i)};
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
            this.a = ol8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            ol8 ol8Var = this.a;
            ol8Var.e = ol8Var.d;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements po5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol8 a;

        public c(ol8 ol8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol8Var;
        }

        @Override // com.baidu.tieba.po5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            po5 po5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) && (po5Var = this.a.f) != null) {
                po5Var.a(j, i, str, chatRoomInfo);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements qo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol8 a;

        public d(ol8 ol8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol8Var;
        }

        @Override // com.baidu.tieba.qo5
        public void a(long j, int i, @NonNull String str) {
            qo5 qo5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && (qo5Var = this.a.g) != null) {
                qo5Var.a(j, i, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ro5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol8 a;

        public e(ol8 ol8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol8Var;
        }

        @Override // com.baidu.tieba.ro5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                ro5 ro5Var = this.a.h;
                if (ro5Var != null) {
                    ro5Var.a(i, j, list, i2, str);
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
    public class f implements ro5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol8 a;

        public f(ol8 ol8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol8Var;
        }

        @Override // com.baidu.tieba.ro5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                ro5 ro5Var = this.a.i;
                if (ro5Var != null) {
                    ro5Var.a(i, j, list, i2, str);
                }
                if (this.a.g != null) {
                    for (Long l : list) {
                        this.a.g.a(l.longValue(), i2, str);
                    }
                }
            }
        }
    }

    public ol8(@NonNull Context context, @NonNull ChatGroupSource chatGroupSource) {
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
        this.j = ho5.b();
        this.k = new a(this);
        this.l = new b(this, 2921781);
        this.b = context;
        this.a = new rl8(chatGroupSource);
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
            List<GroupChatRoomPojo> l = lf8.j().l(str);
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

    public void s(@Nullable ro5 ro5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ro5Var) == null) {
            this.h = ro5Var;
        }
    }

    public void t(@Nullable po5 po5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, po5Var) == null) {
            this.f = po5Var;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void v(@Nullable qo5 qo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, qo5Var) == null) {
            this.g = qo5Var;
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
            chatRoomInfo.setNoDisturb(groupChatRoomPojo.N());
            chatRoomInfo.setIsSubscribe(groupChatRoomPojo.M());
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
