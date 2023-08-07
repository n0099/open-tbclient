package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.aw5;
import com.baidu.tieba.cw5;
import com.baidu.tieba.d05;
import com.baidu.tieba.gj8;
import com.baidu.tieba.hn5;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.in5;
import com.baidu.tieba.jw5;
import com.baidu.tieba.lg;
import com.baidu.tieba.ln5;
import com.baidu.tieba.nw5;
import com.baidu.tieba.ob8;
import com.baidu.tieba.on5;
import com.baidu.tieba.ov5;
import com.baidu.tieba.ri8;
import com.baidu.tieba.sl8;
import com.baidu.tieba.sn5;
import com.baidu.tieba.tl8;
import com.baidu.tieba.w85;
import com.baidu.tieba.wm8;
import com.baidu.tieba.ym8;
import com.baidu.tieba.zm5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class GroupChatRepo implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> b;
    public final long c;
    @Nullable
    public FastRequest d;
    @NonNull
    public an5 e;
    public final ChatMsgProcessor f;
    @Nullable
    public FastRequest g;
    @Nullable
    public ChatRoomDetail h;
    public boolean i;
    public boolean j;
    public final ln5 k;
    @Nullable
    public u<TreeSet<ChatMsg>> l;
    @NonNull
    public final aw5<String> m;
    @NonNull
    public final w85<List<? extends ChatMsg>> n;
    public boolean o;
    @NonNull
    public final Counter p;

    /* loaded from: classes6.dex */
    public static class Counter {
        public static /* synthetic */ Interceptable $ic;
        public static final long f;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Timer a;
        public final AtomicInteger b;
        public final AtomicInteger c;
        public final List<d> d;
        public final String e;

        /* loaded from: classes6.dex */
        public interface d {
            @WorkerThread
            void a(int i);

            @MainThread
            void b(int i);

            @MainThread
            void c(int i);
        }

        /* loaded from: classes6.dex */
        public static class DayVisit implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int count;
            public long timestamp;

            public DayVisit() {
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

            public /* synthetic */ DayVisit(k kVar) {
                this();
            }
        }

        /* loaded from: classes6.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Counter a;

            public a(Counter counter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {counter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = counter;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    for (d dVar : this.a.d) {
                        dVar.a(this.a.b.incrementAndGet());
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DayVisit a;
            public final /* synthetic */ Counter b;

            public b(Counter counter, DayVisit dayVisit) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {counter, dayVisit};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = counter;
                this.a = dayVisit;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    for (d dVar : this.b.d) {
                        dVar.c(this.a.count);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Counter b;

            public c(Counter counter, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {counter, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = counter;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    for (d dVar : this.b.d) {
                        dVar.b(this.a);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260825879, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo$Counter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1260825879, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/GroupChatRepo$Counter;");
                    return;
                }
            }
            f = TimeUnit.SECONDS.toMillis(1L);
        }

        public synchronized void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.a != null) {
                        this.a.cancel();
                        this.a = null;
                    }
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                lg.h(new c(this, this.c.incrementAndGet()), 800L);
            }
        }

        public final int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.get();
            }
            return invokeV.intValue;
        }

        public Counter(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = new Timer();
            this.b = new AtomicInteger();
            this.c = new AtomicInteger();
            this.d = new ArrayList();
            this.e = SharedPrefHelper.getSharedPrefKeyWithAccount("KEY_GROUP_CHAT_COUNTER_CONTINUATION_DAY_VISIT_" + j);
        }

        public void f(@NonNull d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                this.d.add(dVar);
            }
        }

        public final synchronized void j() {
            DayVisit dayVisit;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    if (this.a == null) {
                        return;
                    }
                    this.a.scheduleAtFixedRate(new a(this), 0L, f);
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    String string = sharedPrefHelper.getString(this.e, null);
                    int i = 1;
                    if (string == null) {
                        dayVisit = new DayVisit(null);
                        dayVisit.timestamp = System.currentTimeMillis();
                        dayVisit.count = 1;
                        sharedPrefHelper.putString(this.e, DataExt.toJson(dayVisit));
                    } else {
                        dayVisit = (DayVisit) DataExt.toEntity(string, DayVisit.class);
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean isAdjacentDays = TimeHelper.isAdjacentDays(dayVisit.timestamp, currentTimeMillis);
                        boolean z = !TimeHelper.isSameDay(dayVisit.timestamp, currentTimeMillis);
                        if (isAdjacentDays || z) {
                            dayVisit.timestamp = System.currentTimeMillis();
                            if (isAdjacentDays) {
                                i = 1 + dayVisit.count;
                            }
                            dayVisit.count = i;
                            sharedPrefHelper.putString(this.e, DataExt.toJson(dayVisit));
                        }
                    }
                    lg.g(new b(this, dayVisit));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ u b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.g();
                }
            }
        }

        public b(GroupChatRepo groupChatRepo, ChatMsg chatMsg, u uVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, chatMsg, uVar, str};
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
            this.b = uVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.on5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.f.O(this.d.c);
                this.d.f.E(i, this.d.c, treeSet);
                if (this.a != null) {
                    this.d.f.G(this.d.c, 0, ChatMsgProcessor.T(this.a));
                }
                u uVar = this.b;
                if (uVar != null) {
                    this.d.J(uVar, i, str, treeSet, this.c);
                }
                if (this.b != null) {
                    lg.g(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements hn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hn5 a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ GroupChatRepo c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    cw5.b(this.a.c.h);
                    q qVar = this.a;
                    qVar.b.e(qVar.c.h);
                    this.a.c.p.j();
                }
            }
        }

        public q(GroupChatRepo groupChatRepo, hn5 hn5Var, FastRequest.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, hn5Var, bVar};
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
            this.a = hn5Var;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.hn5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            String prologue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.a(j, i, str, chatRoomInfo);
                if (i == 0) {
                    this.c.o = true;
                    this.c.d0();
                    lg.g(new a(this));
                    ChatMsg chatMsg = null;
                    if (this.c.h == null) {
                        prologue = null;
                    } else {
                        prologue = this.c.h.getPrologue();
                    }
                    if (prologue != null && !TextUtils.isEmpty(prologue)) {
                        chatMsg = this.c.f.n(j, prologue);
                    }
                    GroupChatRepo groupChatRepo = this.c;
                    groupChatRepo.S(groupChatRepo.l, chatMsg);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public a(GroupChatRepo groupChatRepo, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public c(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
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
                this.f.m.d(this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public d(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
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

        @Override // com.baidu.tieba.on5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.f.E(i, this.c.c, treeSet);
                }
                this.c.J(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public e(GroupChatRepo groupChatRepo, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
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

    /* loaded from: classes6.dex */
    public class f implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ u b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public f(GroupChatRepo groupChatRepo, boolean z, u uVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), uVar, str};
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
            this.b = uVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.on5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    if (treeSet.size() >= 5 && !this.d.f.C(this.d.c, treeSet)) {
                        if (this.a) {
                            this.d.f.k(this.d.c);
                        }
                    } else {
                        this.d.f.P(this.d.c, false);
                    }
                    this.d.f.E(i, this.d.c, treeSet);
                }
                u uVar = this.b;
                if (uVar == null) {
                    return;
                }
                this.d.J(uVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;
        public final /* synthetic */ Pair b;

        public g(GroupChatRepo groupChatRepo, v vVar, Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, vVar, pair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
            this.b = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f(((Integer) this.b.first).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ v b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public h(GroupChatRepo groupChatRepo, String str, v vVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, str, vVar, str2};
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
            this.b = vVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.on5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, treeSet) != null) {
                return;
            }
            this.d.c0(this.a, this.b, this.c, i, str, treeSet);
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ChatMsgProcessor.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupChatRepo b;

        public i(GroupChatRepo groupChatRepo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, str};
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
            this.a = str;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor.i
        public void a(@NonNull BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, baseMsg) == null) && TextUtils.equals(baseMsg.getCommonMsgField().getMsgKey(), this.a)) {
                this.b.k0(baseMsg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;

        public j(GroupChatRepo groupChatRepo, v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ln5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public k(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.ln5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                GroupChatRepo groupChatRepo = this.a;
                groupChatRepo.R(groupChatRepo.l, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements in5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.in5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                ri8.h(j, i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends jw5<GroupChatRoomPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public m(GroupChatRepo groupChatRepo) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jw5
        /* renamed from: a */
        public GroupChatRoomPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ob8.j().f(gj8.b(), this.a.c);
            }
            return (GroupChatRoomPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ov5<GroupChatRoomPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ hn5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ GroupChatRepo d;

        public n(GroupChatRepo groupChatRepo, FastRequest.b bVar, hn5 hn5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, hn5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatRepo;
            this.a = bVar;
            this.b = hn5Var;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ov5
        /* renamed from: a */
        public void onReturnDataInUI(GroupChatRoomPojo groupChatRoomPojo) {
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, groupChatRoomPojo) == null) {
                if (groupChatRoomPojo != null) {
                    j = groupChatRoomPojo.getLatestMsgId();
                    j2 = groupChatRoomPojo.getLastExitChatRoomTime();
                } else {
                    j = 0;
                    j2 = 0;
                }
                this.d.N(j, j2, this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ hn5 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ GroupChatRepo e;

        public o(GroupChatRepo groupChatRepo, FastRequest.b bVar, hn5 hn5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, hn5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = groupChatRepo;
            this.b = bVar;
            this.c = hn5Var;
            this.d = i;
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
                this.e.h = chatRoomDetail;
                if (!chatRoomDetail.isJumpH5() && !this.e.o) {
                    hn5 hn5Var = this.c;
                    if (hn5Var != null && (bVar = this.b) != null) {
                        this.e.O(hn5Var, bVar, this.d);
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

    /* loaded from: classes6.dex */
    public class p extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo b;

        public p(GroupChatRepo groupChatRepo) {
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
            this.b = groupChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) && chatRoomDetail.getUserInfo() != null && chatRoomDetail.getUserInfo().getBubbleInfo() != null && this.b.h != null) {
                this.b.h.getUserInfo().setBubbleInfo(chatRoomDetail.getUserInfo().getBubbleInfo());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements sn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public r(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.sn5
        public void a(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && GlobalBuildConfig.isDebug()) {
                BdUtilHelper.showLongToast(this.a.a, (int) R.string.obfuscated_res_0x7f0f0a52);
            }
        }

        @Override // com.baidu.tieba.sn5
        public void b(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && GlobalBuildConfig.isDebug()) {
                String string = this.a.a.getString(R.string.obfuscated_res_0x7f0f0a4f);
                Context context = this.a.a;
                BdUtilHelper.showLongToast(context, string + i + ":" + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatMsg a;
        public final /* synthetic */ GroupChatRepo b;

        public s(GroupChatRepo groupChatRepo, BaseChatMsg baseChatMsg) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.i0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public t(GroupChatRepo groupChatRepo) {
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
                this.a.l.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class u<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f();

        public abstract void g();

        public u() {
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

    /* loaded from: classes6.dex */
    public static abstract class v<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f(int i);

        public abstract void g(@NonNull FetchedEvent fetchedEvent);

        public v() {
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
        this.e = zm5.b();
        this.f = new ChatMsgProcessor();
        this.i = true;
        this.j = false;
        this.k = new k(this);
        this.m = aw5.c();
        this.b = tbPageContext;
        this.a = tbPageContext.getPageActivity();
        this.c = j2;
        w85<List<? extends ChatMsg>> w85Var = new w85<>(new sl8());
        this.n = w85Var;
        w85Var.g(new tl8(tbPageContext, w85Var));
        this.p = new Counter(j2);
    }

    public final void R(@Nullable u<TreeSet<ChatMsg>> uVar, boolean z) {
        BaseMsg v2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, uVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.m.a(str) || (v2 = this.f.v(this.c)) == null) {
                return;
            }
            if (uVar != null && !z) {
                lg.g(new e(this, uVar));
            }
            this.e.h(this.a, this.c, v2.getCommonMsgField().getMsgId(), 30, false, false, this.n, new f(this, z, uVar, str));
        }
    }

    public void e0(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, cls) == null) {
            this.f.M(i2, cls);
        }
    }

    public void f0(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, list, cls) == null) {
            this.f.N(list, cls);
        }
    }

    public void g0(@Nullable FastRequest.b<ChatRoomDetail> bVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048599, this, bVar, i2) != null) || !this.j) {
            return;
        }
        this.j = false;
        U(bVar, null, i2);
    }

    public void I(@NonNull Counter.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.p.f(dVar);
        }
    }

    public void Q(@Nullable u<TreeSet<ChatMsg>> uVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, uVar) == null) && this.f.B(this.c)) {
            R(uVar, false);
        }
    }

    public ChatMsg T(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, map)) == null) {
            return this.f.m(this.c, map);
        }
        return (ChatMsg) invokeL.objValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j = z;
        }
    }

    public void b0(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, chatMsg) == null) {
            this.f.G(this.c, 1, ChatMsgProcessor.T(chatMsg));
        }
    }

    public <T extends BaseChatMsg> void h0(@NonNull T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, t2) == null) {
            lg.e(new s(this, t2));
        }
    }

    public void j0(@Nullable u<TreeSet<ChatMsg>> uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, uVar) == null) {
            this.l = uVar;
        }
    }

    public final void k0(@NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, baseMsg) == null) {
            baseMsg.setShowLocatedColor(Boolean.TRUE);
        }
    }

    public void l0(@Nullable ChatMsgProcessor.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, hVar) == null) {
            this.f.Q(hVar);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.i = z;
        }
    }

    public void n0(@Nullable ChatMsgProcessor.k<? extends BaseSysMsg> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, kVar) == null) {
            this.f.S(kVar);
        }
    }

    public void U(@Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable hn5 hn5Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, bVar, hn5Var, i2) == null) {
            nw5.c(new m(this), new n(this, bVar, hn5Var, i2));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.p.g();
            this.e.a(this.c);
            if (this.i) {
                this.e.r(this.a, this.c, new l(this));
            }
            this.e.k(this.k);
            this.e.o(this.a, this.c, this.f);
            FastRequest fastRequest = this.d;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            FastRequest fastRequest2 = this.g;
            if (fastRequest2 != null) {
                fastRequest2.onDestroy();
            }
            this.n.onDestroy();
        }
    }

    public final void J(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            lg.g(new c(this, i2, bVar, treeSet, str, str2));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p.g();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            an5 a2 = zm5.a();
            this.e = a2;
            a2.k(this.k);
            this.e.o(this.a, this.c, this.f);
        }
    }

    @Nullable
    public BaseMsg V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f.v(this.c);
        }
        return (BaseMsg) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p.i();
        }
        return invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f.B(this.c);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (X()) {
                this.f.O(this.c);
                this.f.D(this.c, ChatMsgProcessor.j.b(true, false, false));
                return;
            }
            u<TreeSet<ChatMsg>> uVar = this.l;
            if (uVar != null) {
                uVar.f();
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.e.c(this.a, this.c, new r(this));
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            String continuousAccessTips = TbSingleton.getInstance().getContinuousAccessTips();
            if (!TextUtils.isEmpty(continuousAccessTips)) {
                this.f.G(this.c, 0, ChatMsgProcessor.T(this.f.q(this.c, continuousAccessTips)));
            }
        }
    }

    public final void N(long j2, long j3, @Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable hn5 hn5Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), bVar, hn5Var, Integer.valueOf(i2)}) == null) {
            if (this.d == null) {
                this.d = new FastRequest(this.b, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.d;
            fastRequest.O(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, String.valueOf(j2));
            fastRequest.O("last_time", String.valueOf(j3));
            fastRequest.O("chatroom_id", String.valueOf(this.c));
            fastRequest.Q(new o(this, bVar, hn5Var, i2));
            fastRequest.S(true);
            fastRequest.P();
        }
    }

    public final void O(@NonNull hn5 hn5Var, @NonNull FastRequest.b<ChatRoomDetail> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, hn5Var, bVar, i2) == null) {
            this.e.g(this.k);
            this.e.d(this.a, this.c, this.f);
            this.e.l(this.a, this.c, new q(this, hn5Var, bVar));
            ChatRoomDetail chatRoomDetail = this.h;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                ym8.c("c15089", TbadkCoreApplication.getCurrentAccount(), this.h.getBasicInfo().getForumId(), this.c, i2);
                wm8.b(this.h.getBasicInfo().getForumId());
            }
        }
    }

    public void P(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && this.m.b("fetchMsgFirst") && this.m.a("fetchHistoryMsg")) {
            BaseMsg t2 = this.f.t(this.c);
            if (t2 == null) {
                this.m.d("fetchHistoryMsg");
                return;
            }
            bVar.d();
            this.e.h(this.a, this.c, t2.getCommonMsgField().getMsgId(), 30, false, true, this.n, new d(this, bVar, "fetchHistoryMsg"));
        }
    }

    public void S(@Nullable u<TreeSet<ChatMsg>> uVar, @Nullable ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, uVar, chatMsg) != null) || !this.m.a("fetchMsgFirst")) {
            return;
        }
        if (uVar != null) {
            lg.g(new a(this, uVar));
        }
        this.e.h(this.a, this.c, 0L, 60, true, true, this.n, new b(this, chatMsg, uVar, "fetchMsgFirst"));
    }

    public void Z(long j2, @NonNull String str, @NonNull v<TreeSet<ChatMsg>> vVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), str, vVar}) != null) || !this.m.a("jumpToMsg")) {
            return;
        }
        ChatMsgProcessor.MemoryFlag x = this.f.x(this.c, j2);
        if (x.isMaster()) {
            Pair<Integer, BaseMsg> y = this.f.y(x, this.c, str);
            if (y != null && y.first.intValue() >= 0) {
                k0(y.second);
                vVar.f(y.first.intValue());
            } else {
                vVar.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.m.d("jumpToMsg");
        } else if (x.isTmp()) {
            Pair<Integer, BaseMsg> y2 = this.f.y(x, this.c, str);
            if (y2 != null && y2.first.intValue() >= 0) {
                k0(y2.second);
                this.f.O(this.c);
                ChatMsgProcessor.j c2 = ChatMsgProcessor.j.c();
                c2.e(new g(this, vVar, y2));
                this.f.D(this.c, c2);
            } else {
                vVar.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.m.d("jumpToMsg");
        } else {
            this.f.k(this.c);
            this.f.l(this.c);
            vVar.d();
            vVar.f(0);
            this.e.h(this.a, this.c, j2, 30, false, false, this.n, new h(this, "jumpToMsg", vVar, str));
        }
    }

    public final void c0(@NonNull String str, @NonNull v<TreeSet<ChatMsg>> vVar, @NonNull String str2, int i2, @NonNull String str3, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, vVar, str2, Integer.valueOf(i2), str3, treeSet}) == null) {
            if (i2 == 0) {
                this.f.F(i2, this.c, treeSet, new i(this, str2));
                if (this.f.z(treeSet, str2) < 0) {
                    lg.g(new j(this, vVar));
                }
            }
            J(vVar, i2, str3, treeSet, str);
        }
    }

    @WorkerThread
    public final <T extends BaseChatMsg> void i0(@NonNull T t2) {
        List<EnableDegradeUserData> enableDegradeUserDataList;
        List<EnableDegradeUserData> secondDegradeUserDataList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, t2) == null) {
            d05 t3 = d05.t();
            cw5.d(t3.C());
            cw5.b(this.h);
            ChatRoomDetail.UserInfo userInfo = this.h.getUserInfo();
            ChatRoomDetail.BasicInfo basicInfo = this.h.getBasicInfo();
            CommonMsgField commonMsgFieldNullable = t2.getCommonMsgFieldNullable();
            BubbleInfo bubbleInfo = null;
            if (commonMsgFieldNullable == null) {
                this.p.h();
                t2.setItemStatus(0);
                commonMsgFieldNullable = CommonMsgField.create(t3.j(), this.c);
                commonMsgFieldNullable.setUserName(t3.m());
                commonMsgFieldNullable.setPortrait(t3.r());
                commonMsgFieldNullable.setRole(userInfo.getIdentityRole());
                commonMsgFieldNullable.setLevel(userInfo.getForumLevel());
                bubbleInfo = userInfo.getBubbleInfo();
                enableDegradeUserDataList = userInfo.getEnableDegradeUserDataList();
                secondDegradeUserDataList = userInfo.getSecondDegradeUserDataList();
            } else {
                commonMsgFieldNullable.setMsgKey(CommonMsgField.generateMsgKey(commonMsgFieldNullable.getUserId(), this.c));
                enableDegradeUserDataList = null;
                secondDegradeUserDataList = null;
            }
            if (t2.needBubbleInfo() && bubbleInfo != null && !bubbleInfo.isExpired()) {
                commonMsgFieldNullable.setBubbleInfo(bubbleInfo);
            }
            commonMsgFieldNullable.setEnableDegradeUserDataList(enableDegradeUserDataList);
            commonMsgFieldNullable.setSecondDegradeUserDataList(secondDegradeUserDataList);
            commonMsgFieldNullable.setFromAndroid();
            commonMsgFieldNullable.setType(t2.getMsgType());
            commonMsgFieldNullable.setContent(DataExt.toMap(t2));
            commonMsgFieldNullable.setForumId(basicInfo.getForumId());
            commonMsgFieldNullable.setLocalMsgId(true);
            String json = DataExt.toJson(commonMsgFieldNullable);
            ChatMsg createSdkMsg = t2.createSdkMsg();
            t2.fillSdkMsg4Base(createSdkMsg);
            createSdkMsg.setCategory(4);
            createSdkMsg.setChatType(20);
            createSdkMsg.setMsgId(ChatMsgProcessor.o());
            createSdkMsg.setMsgKey(commonMsgFieldNullable.getMsgKey());
            createSdkMsg.setChatRoomContentExt(json);
            createSdkMsg.setSenderUid(String.valueOf(commonMsgFieldNullable.getUserId()));
            createSdkMsg.setNickName(commonMsgFieldNullable.getUserName());
            createSdkMsg.setPortrait(commonMsgFieldNullable.getPortrait());
            createSdkMsg.setFromUser(AccountManager.getUK(this.a));
            createSdkMsg.setContacter(commonMsgFieldNullable.getRoomId());
            createSdkMsg.setMsgTime(System.currentTimeMillis() / 1000);
            if (X()) {
                this.f.O(this.c);
                if (this.l != null) {
                    lg.g(new t(this));
                }
            }
            this.f.G(this.c, 0, ChatMsgProcessor.T(createSdkMsg));
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.g == null) {
                this.g = new FastRequest(this.b, CmdConfigHttp.CMD_REQUEST_CHAT_ROOM_UPDATE, TbConfig.UPDATE_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.g;
            fastRequest.O("chatroom_id", String.valueOf(this.c));
            fastRequest.Q(new p(this));
            fastRequest.P();
        }
    }
}
