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
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ah;
import com.baidu.tieba.c88;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.jh8;
import com.baidu.tieba.kh8;
import com.baidu.tieba.kn5;
import com.baidu.tieba.l95;
import com.baidu.tieba.ln5;
import com.baidu.tieba.p05;
import com.baidu.tieba.sn5;
import com.baidu.tieba.tn5;
import com.baidu.tieba.wd8;
import com.baidu.tieba.wn5;
import com.baidu.tieba.xn5;
import com.baidu.tieba.xw5;
import com.baidu.tieba.yn5;
import com.baidu.tieba.zw5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    @NonNull
    public final List<Long> d;
    @Nullable
    public FastRequest e;
    @NonNull
    public ln5 f;
    public final ChatMsgProcessor g;
    public long h;
    @Nullable
    public FastRequest i;
    @Nullable
    public ChatRoomDetail j;
    public boolean k;
    public boolean l;
    public final wn5 m;
    @Nullable
    public r<TreeSet<ChatMsg>> n;
    @NonNull
    public final xw5<String> o;
    @NonNull
    public final yn5 p;
    public boolean q;
    @NonNull
    public final Counter r;

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

            public /* synthetic */ DayVisit(i iVar) {
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
                ah.f(new c(this, this.c.incrementAndGet()), 800L);
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
            this.e = l95.q("KEY_GROUP_CHAT_COUNTER_CONTINUATION_DAY_VISIT_" + j);
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
                    l95 m = l95.m();
                    String s = m.s(this.e, null);
                    int i = 1;
                    if (s == null) {
                        dayVisit = new DayVisit(null);
                        dayVisit.timestamp = System.currentTimeMillis();
                        dayVisit.count = 1;
                        m.B(this.e, DataExt.toJson(dayVisit));
                    } else {
                        dayVisit = (DayVisit) DataExt.toEntity(s, DayVisit.class);
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean isAdjacentDays = TimeHelper.isAdjacentDays(dayVisit.timestamp, currentTimeMillis);
                        boolean z = !TimeHelper.isSameDay(dayVisit.timestamp, currentTimeMillis);
                        if (isAdjacentDays || z) {
                            dayVisit.timestamp = System.currentTimeMillis();
                            if (isAdjacentDays) {
                                i = 1 + dayVisit.count;
                            }
                            dayVisit.count = i;
                            m.B(this.e, DataExt.toJson(dayVisit));
                        }
                    }
                    ah.e(new b(this, dayVisit));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements sn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn5 a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ GroupChatRepo c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    zw5.b(this.a.c.j);
                    l lVar = this.a;
                    lVar.b.e(lVar.c.j);
                    this.a.c.r.j();
                }
            }
        }

        public l(GroupChatRepo groupChatRepo, sn5 sn5Var, FastRequest.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, sn5Var, bVar};
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
            this.a = sn5Var;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.sn5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            String prologue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.a(j, i, str, chatRoomInfo);
                if (i != 0) {
                    return;
                }
                this.c.q = true;
                ah.e(new a(this));
                ChatMsg chatMsg = null;
                if (this.c.j == null) {
                    prologue = null;
                } else {
                    prologue = this.c.j.getPrologue();
                }
                if (prologue != null && !TextUtils.isEmpty(prologue)) {
                    chatMsg = this.c.g.m(j, prologue);
                }
                GroupChatRepo groupChatRepo = this.c;
                groupChatRepo.M(groupChatRepo.n, chatMsg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements xn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ r b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.g();
                }
            }
        }

        public p(GroupChatRepo groupChatRepo, ChatMsg chatMsg, r rVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, chatMsg, rVar, str};
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
            this.b = rVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.xn5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.g.M(this.d.c);
                this.d.g.D(i, this.d.c, treeSet);
                if (this.a != null) {
                    this.d.g.F(this.d.c, ChatMsgProcessor.R(this.a));
                }
                r rVar = this.b;
                if (rVar != null) {
                    this.d.D(rVar, i, str, treeSet, this.c);
                }
                if (this.b != null) {
                    ah.e(new a(this));
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
    public class a implements xn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public a(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
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

        @Override // com.baidu.tieba.xn5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.g.D(i, this.c.c, treeSet);
                }
                this.c.D(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public b(GroupChatRepo groupChatRepo, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
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
    public class c implements xn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ r b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public c(GroupChatRepo groupChatRepo, boolean z, r rVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), rVar, str};
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
            this.b = rVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.xn5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    if (treeSet.size() >= 5 && !this.d.g.B(this.d.c, treeSet)) {
                        if (this.a) {
                            this.d.g.k(this.d.c);
                        }
                    } else {
                        this.d.g.N(this.d.c, false);
                    }
                    this.d.g.D(i, this.d.c, treeSet);
                }
                r rVar = this.b;
                if (rVar == null) {
                    return;
                }
                this.d.D(rVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ Pair b;

        public d(GroupChatRepo groupChatRepo, s sVar, Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, sVar, pair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
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
    public class e implements xn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public e(GroupChatRepo groupChatRepo, String str, s sVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, str, sVar, str2};
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
            this.b = sVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.xn5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, treeSet) != null) {
                return;
            }
            this.d.V(this.a, this.b, this.c, i, str, treeSet);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ChatMsgProcessor.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupChatRepo b;

        public f(GroupChatRepo groupChatRepo, String str) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, baseMsg) != null) || !TextUtils.equals(baseMsg.getCommonMsgField().getMsgKey(), this.a)) {
                return;
            }
            this.b.c0(baseMsg);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public g(GroupChatRepo groupChatRepo, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
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
    public class h implements tn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.tn5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                wd8.h(j, i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements wn5 {
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

        @Override // com.baidu.tieba.wn5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                GroupChatRepo groupChatRepo = this.a;
                groupChatRepo.L(groupChatRepo.n, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ sn5 c;
        public final /* synthetic */ GroupChatRepo d;

        public j(GroupChatRepo groupChatRepo, FastRequest.b bVar, sn5 sn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, sn5Var};
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
            this.c = sn5Var;
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
                this.d.j = chatRoomDetail;
                if (!chatRoomDetail.isJumpH5() && !this.d.q) {
                    sn5 sn5Var = this.c;
                    if (sn5Var != null && (bVar = this.b) != null) {
                        this.d.H(sn5Var, bVar);
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
    public class k extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo b;

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
            this.b = groupChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) && chatRoomDetail.getUserInfo() != null && chatRoomDetail.getUserInfo().getBubbleInfo() != null && this.b.j != null) {
                this.b.j.getUserInfo().setBubbleInfo(chatRoomDetail.getUserInfo().getBubbleInfo());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatMsg a;
        public final /* synthetic */ GroupChatRepo b;

        public m(GroupChatRepo groupChatRepo, BaseChatMsg baseChatMsg) {
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
            this.b.a0(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public n(GroupChatRepo groupChatRepo) {
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
                this.a.n.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public o(GroupChatRepo groupChatRepo, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
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
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public q(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
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
                this.f.o.d(this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class r<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f();

        public abstract void g();

        public r() {
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
    public static abstract class s<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void f(int i);

        public abstract void g(@NonNull FetchedEvent fetchedEvent);

        public s() {
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
        this.f = kn5.b();
        this.g = new ChatMsgProcessor();
        this.k = true;
        this.l = false;
        this.m = new i(this);
        this.o = xw5.c();
        this.b = tbPageContext;
        this.a = tbPageContext.getPageActivity();
        this.c = j2;
        this.d = Collections.singletonList(Long.valueOf(j2));
        this.p = new MsgContentMergerImpl(tbPageContext);
        this.r = new Counter(j2);
    }

    public final void L(@Nullable r<TreeSet<ChatMsg>> rVar, boolean z) {
        BaseMsg u;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, rVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.o.a(str) || (u = this.g.u(this.c)) == null) {
                return;
            }
            if (rVar != null && !z) {
                ah.e(new b(this, rVar));
            }
            this.f.b(this.a, this.c, u.getCommonMsgField().getMsgId(), 30, false, false, this.p, new c(this, z, rVar, str));
        }
    }

    public void C(@NonNull Counter.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.r.f(dVar);
        }
    }

    public void J(@Nullable r<TreeSet<ChatMsg>> rVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, rVar) == null) && this.g.A(this.c)) {
            L(rVar, false);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.l = z;
        }
    }

    public void Y(@Nullable FastRequest.b<ChatRoomDetail> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, bVar) != null) || !this.l) {
            return;
        }
        this.l = false;
        N(bVar, null);
    }

    public <T extends BaseChatMsg> void Z(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, t) == null) {
            ah.d(new m(this, t));
        }
    }

    public void b0(@Nullable r<TreeSet<ChatMsg>> rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rVar) == null) {
            this.n = rVar;
        }
    }

    public final void c0(@NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, baseMsg) == null) {
            baseMsg.setShowLocatedColor(Boolean.TRUE);
        }
    }

    public void d0(@Nullable ChatMsgProcessor.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, hVar) == null) {
            this.g.O(hVar);
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.k = z;
        }
    }

    public void f0(@Nullable ChatMsgProcessor.k<? extends BaseSysMsg> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, kVar) == null) {
            this.g.Q(kVar);
        }
    }

    public void W(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, cls) == null) {
            this.g.K(i2, cls);
        }
    }

    public void X(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, list, cls) == null) {
            this.g.L(list, cls);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.r.g();
            if (this.k) {
                this.f.f(this.a, "SCENE_GROUP_CHAT", this.d, new h(this));
            }
            this.f.g(this.m);
            this.f.a(this.a, this.d, this.g);
            FastRequest fastRequest = this.e;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            FastRequest fastRequest2 = this.i;
            if (fastRequest2 != null) {
                fastRequest2.onDestroy();
            }
            this.p.onDestroy();
        }
    }

    public final void D(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            ah.e(new q(this, i2, bVar, treeSet, str, str2));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r.g();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ln5 a2 = kn5.a();
            this.f = a2;
            a2.g(this.m);
            this.f.a(this.a, this.d, this.g);
        }
    }

    @Nullable
    public BaseMsg O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g.u(this.c);
        }
        return (BaseMsg) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r.i();
        }
        return invokeV.intValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g.A(this.c);
        }
        return invokeV.booleanValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (R()) {
                this.g.M(this.c);
                this.g.C(this.c, ChatMsgProcessor.j.a(true, false, false));
                return;
            }
            r<TreeSet<ChatMsg>> rVar = this.n;
            if (rVar != null) {
                rVar.f();
            }
        }
    }

    public final void H(@NonNull sn5 sn5Var, @NonNull FastRequest.b<ChatRoomDetail> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sn5Var, bVar) == null) {
            this.f.e(this.m);
            this.f.c(this.a, this.d, this.g);
            this.f.d(this.a, "SCENE_GROUP_CHAT", this.d, new l(this, sn5Var, bVar));
            kh8.c("c15089", TbadkCoreApplication.getCurrentAccount(), this.j.getBasicInfo().getForumId(), this.c);
            ChatRoomDetail chatRoomDetail = this.j;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                jh8.b(this.j.getBasicInfo().getForumId());
            }
        }
    }

    public void N(@Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable sn5 sn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, sn5Var) == null) {
            GroupChatRoomPojo c2 = c88.f().c(TbadkCoreApplication.getCurrentAccount(), this.c);
            if (c2 != null) {
                this.h = c2.getLatestMsgId();
            }
            if (this.e == null) {
                this.e = new FastRequest(this.b, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.e;
            fastRequest.V(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, String.valueOf(this.h));
            fastRequest.V("chatroom_id", String.valueOf(this.c));
            fastRequest.X(new j(this, bVar, sn5Var));
            fastRequest.W();
        }
    }

    public void I(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && this.o.b("fetchMsgFirst") && this.o.a("fetchHistoryMsg")) {
            BaseMsg s2 = this.g.s(this.c);
            if (s2 == null) {
                this.o.d("fetchHistoryMsg");
                return;
            }
            bVar.d();
            this.f.b(this.a, this.c, s2.getCommonMsgField().getMsgId(), 30, false, true, this.p, new a(this, bVar, "fetchHistoryMsg"));
        }
    }

    public void M(@Nullable r<TreeSet<ChatMsg>> rVar, @Nullable ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar, chatMsg) != null) || !this.o.a("fetchMsgFirst")) {
            return;
        }
        if (rVar != null) {
            ah.e(new o(this, rVar));
        }
        this.f.b(this.a, this.c, 0L, 60, true, true, this.p, new p(this, chatMsg, rVar, "fetchMsgFirst"));
    }

    public void T(long j2, @NonNull String str, @NonNull s<TreeSet<ChatMsg>> sVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), str, sVar}) != null) || !this.o.a("jumpToMsg")) {
            return;
        }
        ChatMsgProcessor.MemoryFlag w = this.g.w(this.c, j2);
        if (w.isMaster()) {
            Pair<Integer, BaseMsg> x = this.g.x(w, this.c, str);
            if (x != null && x.first.intValue() >= 0) {
                c0(x.second);
                sVar.f(x.first.intValue());
            } else {
                sVar.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.o.d("jumpToMsg");
        } else if (w.isTmp()) {
            Pair<Integer, BaseMsg> x2 = this.g.x(w, this.c, str);
            if (x2 != null && x2.first.intValue() >= 0) {
                c0(x2.second);
                this.g.M(this.c);
                ChatMsgProcessor.j b2 = ChatMsgProcessor.j.b();
                b2.d(new d(this, sVar, x2));
                this.g.C(this.c, b2);
            } else {
                sVar.g(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.o.d("jumpToMsg");
        } else {
            this.g.k(this.c);
            this.g.l(this.c);
            sVar.d();
            sVar.f(0);
            this.f.b(this.a, this.c, j2, 30, false, false, this.p, new e(this, "jumpToMsg", sVar, str));
        }
    }

    public final void V(@NonNull String str, @NonNull s<TreeSet<ChatMsg>> sVar, @NonNull String str2, int i2, @NonNull String str3, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, sVar, str2, Integer.valueOf(i2), str3, treeSet}) == null) {
            if (i2 == 0) {
                this.g.E(i2, this.c, treeSet, new f(this, str2));
                if (this.g.y(treeSet, str2) < 0) {
                    ah.e(new g(this, sVar));
                }
            }
            D(sVar, i2, str3, treeSet, str);
        }
    }

    @WorkerThread
    public final <T extends BaseChatMsg> void a0(@NonNull T t) {
        List<EnableDegradeUserData> enableDegradeUserDataList;
        List<EnableDegradeUserData> secondDegradeUserDataList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, t) == null) {
            p05 t2 = p05.t();
            zw5.d(t2.C());
            zw5.b(this.j);
            ChatRoomDetail.UserInfo userInfo = this.j.getUserInfo();
            ChatRoomDetail.BasicInfo basicInfo = this.j.getBasicInfo();
            CommonMsgField commonMsgFieldNullable = t.getCommonMsgFieldNullable();
            BubbleInfo bubbleInfo = null;
            if (commonMsgFieldNullable == null) {
                this.r.h();
                t.setItemStatus(0);
                commonMsgFieldNullable = CommonMsgField.create(t2.j(), this.c);
                commonMsgFieldNullable.setUserName(t2.m());
                commonMsgFieldNullable.setPortrait(t2.r());
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
            if (t.needBubbleInfo() && bubbleInfo != null && !bubbleInfo.isExpired()) {
                commonMsgFieldNullable.setBubbleInfo(bubbleInfo);
            }
            commonMsgFieldNullable.setEnableDegradeUserDataList(enableDegradeUserDataList);
            commonMsgFieldNullable.setSecondDegradeUserDataList(secondDegradeUserDataList);
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
            createSdkMsg.setMsgId(ChatMsgProcessor.n());
            createSdkMsg.setMsgKey(commonMsgFieldNullable.getMsgKey());
            createSdkMsg.setChatRoomContentExt(json);
            createSdkMsg.setSenderUid(String.valueOf(commonMsgFieldNullable.getUserId()));
            createSdkMsg.setNickName(commonMsgFieldNullable.getUserName());
            createSdkMsg.setPortrait(commonMsgFieldNullable.getPortrait());
            if (R()) {
                this.g.M(this.c);
                if (this.n != null) {
                    ah.e(new n(this));
                }
            }
            this.g.F(this.c, ChatMsgProcessor.R(createSdkMsg));
        }
    }

    public void g0() {
        ChatMsg chatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String continuousAccessTips = TbSingleton.getInstance().getContinuousAccessTips();
            if (continuousAccessTips != null && !TextUtils.isEmpty(continuousAccessTips)) {
                chatMsg = this.g.p(this.c, continuousAccessTips);
            } else {
                chatMsg = null;
            }
            this.g.F(this.c, ChatMsgProcessor.R(chatMsg));
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.i == null) {
                this.i = new FastRequest(this.b, CmdConfigHttp.CMD_REQUEST_CHAT_ROOM_UPDATE, TbConfig.UPDATE_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.i;
            fastRequest.V("chatroom_id", String.valueOf(this.c));
            fastRequest.X(new k(this));
            fastRequest.W();
        }
    }
}
