package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bg5;
import com.baidu.tieba.cg5;
import com.baidu.tieba.dp7;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.jg5;
import com.baidu.tieba.kg5;
import com.baidu.tieba.mx7;
import com.baidu.tieba.ng;
import com.baidu.tieba.ng5;
import com.baidu.tieba.np5;
import com.baidu.tieba.nx7;
import com.baidu.tieba.og5;
import com.baidu.tieba.pg5;
import com.baidu.tieba.pp5;
import com.baidu.tieba.qw7;
import com.baidu.tieba.rv4;
import com.baidu.tieba.vu7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class GroupChatRepo implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> b;
    public final long c;
    @NonNull
    public final List<Long> d;
    @Nullable
    public FastRequest e;
    @NonNull
    public cg5 f;
    public final qw7 g;
    public long h;
    @Nullable
    public ChatRoomDetail i;
    public boolean j;
    public boolean k;
    public final ng5 l;
    @Nullable
    public n<TreeSet<ChatMsg>> m;
    @NonNull
    public final np5<String> n;
    public int o;
    @NonNull
    public final pg5 p;
    public boolean q;

    /* loaded from: classes4.dex */
    public class c implements og5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
                }
            }
        }

        public c(GroupChatRepo groupChatRepo, String str, o oVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, str, oVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = str;
            this.b = oVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.og5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.d.g.z(i, this.d.c, treeSet);
                    if (this.d.g.t(treeSet, this.a) < 0) {
                        ng.e(new a(this));
                    }
                }
                this.d.o(this.b, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements jg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg5 a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ GroupChatRepo c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pp5.b(this.a.c.i);
                    g gVar = this.a;
                    gVar.b.e(gVar.c.i);
                }
            }
        }

        public g(GroupChatRepo groupChatRepo, jg5 jg5Var, FastRequest.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, jg5Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupChatRepo;
            this.a = jg5Var;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.jg5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            String prologue;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) != null) {
                return;
            }
            this.c.q = true;
            this.a.a(j, i, str, chatRoomInfo);
            ng.e(new a(this));
            if (i == 0) {
                ChatMsg chatMsg = null;
                if (this.c.i == null) {
                    prologue = null;
                } else {
                    prologue = this.c.i.getPrologue();
                }
                if (prologue != null && !TextUtils.isEmpty(prologue)) {
                    chatMsg = this.c.g.k(j, prologue);
                }
                GroupChatRepo groupChatRepo = this.c;
                groupChatRepo.C(groupChatRepo.m, chatMsg);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements og5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ n b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.g();
                }
            }
        }

        public k(GroupChatRepo groupChatRepo, ChatMsg chatMsg, n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, chatMsg, nVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = chatMsg;
            this.b = nVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.og5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.g.H(this.d.c);
                this.d.g.z(i, this.d.c, treeSet);
                if (this.a != null) {
                    this.d.g.A(this.d.c, qw7.M(this.a));
                }
                n nVar = this.b;
                if (nVar != null) {
                    this.d.o(nVar, i, str, treeSet, this.c);
                }
                if (this.b != null) {
                    ng.e(new a(this));
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FetchedEvent {
        public static final /* synthetic */ FetchedEvent[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FetchedEvent TARGET_MSG_NOT_EXIST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1874750416, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo$FetchedEvent;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1874750416, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo$FetchedEvent;");
                    return;
                }
            }
            FetchedEvent fetchedEvent = new FetchedEvent("TARGET_MSG_NOT_EXIST", 0);
            TARGET_MSG_NOT_EXIST = fetchedEvent;
            $VALUES = new FetchedEvent[]{fetchedEvent};
        }

        public static FetchedEvent[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FetchedEvent[]) $VALUES.clone();
            }
            return (FetchedEvent[]) invokeV.objValue;
        }

        public FetchedEvent(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FetchedEvent valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FetchedEvent) Enum.valueOf(FetchedEvent.class, str);
            }
            return (FetchedEvent) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(GroupChatRepo groupChatRepo, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
                this.a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements og5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ n b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public b(GroupChatRepo groupChatRepo, boolean z, n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), nVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = z;
            this.b = nVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.og5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    if (treeSet.size() >= 5 && !this.d.g.w(this.d.c, treeSet)) {
                        if (this.a) {
                            this.d.g.j(this.d.c);
                        }
                    } else {
                        this.d.g.I(this.d.c, false);
                    }
                    this.d.g.z(i, this.d.c, treeSet);
                }
                n nVar = this.b;
                if (nVar == null) {
                    return;
                }
                this.d.o(nVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements kg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(GroupChatRepo groupChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kg5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                vu7.h(j, i, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ng5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public e(GroupChatRepo groupChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRepo;
        }

        @Override // com.baidu.tieba.ng5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                GroupChatRepo groupChatRepo = this.a;
                groupChatRepo.B(groupChatRepo.m, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ jg5 c;
        public final /* synthetic */ GroupChatRepo d;

        public f(GroupChatRepo groupChatRepo, FastRequest.b bVar, jg5 jg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, jg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.b = bVar;
            this.c = jg5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.b(i, str, chatRoomDetail);
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                FastRequest.b bVar = this.b;
                if (bVar != null) {
                    bVar.d();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            FastRequest.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomDetail) == null) {
                super.e(chatRoomDetail);
                this.d.i = chatRoomDetail;
                if (!chatRoomDetail.isJumpH5() && !this.d.q) {
                    jg5 jg5Var = this.c;
                    if (jg5Var != null && (bVar = this.b) != null) {
                        this.d.u(jg5Var, bVar);
                        return;
                    }
                    return;
                }
                FastRequest.b bVar2 = this.b;
                if (bVar2 != null) {
                    bVar2.e(chatRoomDetail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatMsg a;
        public final /* synthetic */ GroupChatRepo b;

        public h(GroupChatRepo groupChatRepo, BaseChatMsg baseChatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, baseChatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatRepo;
            this.a = baseChatMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.S(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public i(GroupChatRepo groupChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRepo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public j(GroupChatRepo groupChatRepo, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
                this.a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public l(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Integer.valueOf(i), bVar, treeSet, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = groupChatRepo;
            this.a = i;
            this.b = bVar;
            this.c = treeSet;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == 0) {
                    this.b.e(this.c);
                } else {
                    this.b.b(i, this.d, null);
                }
                this.b.c();
                this.f.n.d(this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements og5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public m(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupChatRepo;
            this.a = bVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.og5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.g.z(i, this.c.c, treeSet);
                }
                this.c.o(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class n<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f();

        public abstract void g();

        public n() {
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
    }

    /* loaded from: classes4.dex */
    public static abstract class o<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f(int i);

        public abstract void g(@NonNull FetchedEvent fetchedEvent);

        public o() {
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
    }

    public GroupChatRepo(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = bg5.b();
        this.g = new qw7();
        this.j = true;
        this.k = false;
        this.l = new e(this);
        this.n = np5.c();
        this.b = tbPageContext;
        this.a = tbPageContext.getPageActivity();
        this.c = j2;
        this.d = Collections.singletonList(Long.valueOf(j2));
        this.p = new MsgContentMergerImpl(tbPageContext);
    }

    public final void B(@Nullable n<TreeSet<ChatMsg>> nVar, boolean z) {
        BaseMsg q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.n.a(str) || (q = this.g.q(this.c)) == null) {
                return;
            }
            if (nVar != null && !z) {
                ng.e(new a(this, nVar));
            }
            this.f.b(this.a, this.c, q.getCommonMsgField().getMsgId(), 30, false, false, this.p, new b(this, z, nVar, str));
        }
    }

    public void A(@Nullable n<TreeSet<ChatMsg>> nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && this.g.v(this.c)) {
            B(nVar, false);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void Q(@Nullable FastRequest.b<ChatRoomDetail> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, bVar) != null) || !this.k) {
            return;
        }
        this.k = false;
        D(bVar, null);
    }

    public <T extends BaseChatMsg> void R(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
            ng.d(new h(this, t));
        }
    }

    public void T(@Nullable n<TreeSet<ChatMsg>> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nVar) == null) {
            this.m = nVar;
        }
    }

    public void U(@Nullable qw7.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hVar) == null) {
            this.g.J(hVar);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j = z;
        }
    }

    public void W(@Nullable qw7.j<? extends BaseSysMsg> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jVar) == null) {
            this.g.L(jVar);
        }
    }

    public void O(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, cls) == null) {
            this.g.F(i2, cls);
        }
    }

    public void P(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, list, cls) == null) {
            this.g.G(list, cls);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.j) {
                this.f.f(this.a, "SCENE_GROUP_CHAT", this.d, new d(this));
            }
            this.f.g(this.l);
            this.f.a(this.a, this.d, this.g);
            FastRequest fastRequest = this.e;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            this.p.onDestroy();
        }
    }

    public void C(@Nullable n<TreeSet<ChatMsg>> nVar, @Nullable ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nVar, chatMsg) != null) || !this.n.a("fetchMsgFirst")) {
            return;
        }
        if (nVar != null) {
            ng.e(new j(this, nVar));
        }
        this.f.b(this.a, this.c, 0L, 60, true, true, this.p, new k(this, chatMsg, nVar, "fetchMsgFirst"));
    }

    public void D(@Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable jg5 jg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, jg5Var) == null) {
            GroupChatRoomPojo c2 = dp7.f().c(TbadkCoreApplication.getCurrentAccount(), this.c);
            if (c2 != null) {
                this.h = c2.getLatestMsgId();
            }
            if (this.e == null) {
                this.e = new FastRequest(this.b, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.e;
            fastRequest.S(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, String.valueOf(this.h));
            fastRequest.S("chatroom_id", String.valueOf(this.c));
            fastRequest.U(new f(this, bVar, jg5Var));
            fastRequest.T();
        }
    }

    public final void u(@NonNull jg5 jg5Var, @NonNull FastRequest.b<ChatRoomDetail> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jg5Var, bVar) == null) {
            this.f.e(this.l);
            this.f.c(this.a, this.d, this.g);
            this.f.d(this.a, "SCENE_GROUP_CHAT", this.d, new g(this, jg5Var, bVar));
            nx7.b("c15089", TbadkCoreApplication.getCurrentAccount(), this.i.getBasicInfo().getForumId(), this.c);
            ChatRoomDetail chatRoomDetail = this.i;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                mx7.b(this.i.getBasicInfo().getForumId());
            }
        }
    }

    @Nullable
    public BaseMsg E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g.q(this.c);
        }
        return (BaseMsg) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g.v(this.c);
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (G()) {
                this.g.H(this.c);
                this.g.y(this.c, qw7.i.a(true, false, false));
                return;
            }
            n<TreeSet<ChatMsg>> nVar = this.m;
            if (nVar != null) {
                nVar.f();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            cg5 a2 = bg5.a();
            this.f = a2;
            a2.g(this.l);
            this.f.a(this.a, this.d, this.g);
        }
    }

    public void J(long j2, @NonNull String str, @NonNull o<TreeSet<ChatMsg>> oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), str, oVar}) != null) || !this.n.a("jumpToMsg")) {
            return;
        }
        int s = this.g.s(this.c, str);
        if (s >= 0) {
            oVar.f(s);
            this.n.d("jumpToMsg");
        } else if (this.g.x(this.c, j2)) {
            oVar.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            this.n.d("jumpToMsg");
        } else {
            this.g.j(this.c);
            oVar.d();
            oVar.f(0);
            this.f.b(this.a, this.c, j2, 30, false, false, this.p, new c(this, str, oVar, "jumpToMsg"));
        }
    }

    @WorkerThread
    public final <T extends BaseChatMsg> void S(@NonNull T t) {
        BubbleInfo bubbleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, t) == null) {
            rv4 t2 = rv4.t();
            pp5.d(t2.C());
            pp5.b(this.i);
            ChatRoomDetail.UserInfo userInfo = this.i.getUserInfo();
            ChatRoomDetail.BasicInfo basicInfo = this.i.getBasicInfo();
            CommonMsgField commonMsgFieldNullable = t.getCommonMsgFieldNullable();
            if (commonMsgFieldNullable != null) {
                commonMsgFieldNullable.setMsgKey(CommonMsgField.generateMsgKey(commonMsgFieldNullable.getUserId(), this.c));
                bubbleInfo = null;
            } else {
                this.o++;
                t.setItemStatus(0);
                commonMsgFieldNullable = CommonMsgField.create(t2.j(), this.c);
                commonMsgFieldNullable.setUserName(t2.m());
                commonMsgFieldNullable.setPortrait(t2.r());
                commonMsgFieldNullable.setRole(userInfo.getIdentityRole());
                commonMsgFieldNullable.setLevel(userInfo.getForumLevel());
                bubbleInfo = userInfo.getBubbleInfo();
            }
            if (t.needBubbleInfo() && bubbleInfo != null && !bubbleInfo.isExpired()) {
                commonMsgFieldNullable.setBubbleInfo(bubbleInfo);
            }
            commonMsgFieldNullable.setFromAndroid();
            commonMsgFieldNullable.setType(t.getMsgType());
            commonMsgFieldNullable.setContent(DataExt.toMap(t));
            commonMsgFieldNullable.setForumId(basicInfo.getForumId());
            commonMsgFieldNullable.setLocalMsgId(true);
            String json = DataExt.toJson(commonMsgFieldNullable);
            ChatMsg createSdkMsg = t.createSdkMsg();
            t.fillSdkMsg4Base(createSdkMsg);
            createSdkMsg.setCategory(4);
            createSdkMsg.setChatType(20);
            createSdkMsg.setMsgId(qw7.l());
            createSdkMsg.setMsgKey(commonMsgFieldNullable.getMsgKey());
            createSdkMsg.setChatRoomContentExt(json);
            createSdkMsg.setSenderUid(String.valueOf(commonMsgFieldNullable.getUserId()));
            createSdkMsg.setNickName(commonMsgFieldNullable.getUserName());
            createSdkMsg.setPortrait(commonMsgFieldNullable.getPortrait());
            if (G()) {
                this.g.H(this.c);
                if (this.m != null) {
                    ng.e(new i(this));
                }
            }
            this.g.A(this.c, qw7.M(createSdkMsg));
        }
    }

    public final void o(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            ng.e(new l(this, i2, bVar, treeSet, str, str2));
        }
    }

    public void x(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) && this.n.b("fetchMsgFirst") && this.n.a("fetchHistoryMsg")) {
            BaseMsg p = this.g.p(this.c);
            if (p == null) {
                this.n.d("fetchHistoryMsg");
                return;
            }
            bVar.d();
            this.f.b(this.a, this.c, p.getCommonMsgField().getMsgId(), 30, false, true, this.p, new m(this, bVar, "fetchHistoryMsg"));
        }
    }
}
