package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.al5;
import com.baidu.tieba.b55;
import com.baidu.tieba.bu8;
import com.baidu.tieba.bw8;
import com.baidu.tieba.c59;
import com.baidu.tieba.cl5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.dv8;
import com.baidu.tieba.eu5;
import com.baidu.tieba.gl5;
import com.baidu.tieba.gu5;
import com.baidu.tieba.hz8;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSubscribeSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTipsSysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.BubbleInfo;
import com.baidu.tieba.im.lib.socket.msg.data.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.kl5;
import com.baidu.tieba.nu5;
import com.baidu.tieba.nv8;
import com.baidu.tieba.rk5;
import com.baidu.tieba.rp8;
import com.baidu.tieba.ru5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.st5;
import com.baidu.tieba.u49;
import com.baidu.tieba.uq8;
import com.baidu.tieba.v49;
import com.baidu.tieba.vv8;
import com.baidu.tieba.zk5;
import com.baidu.tieba.zv8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
/* loaded from: classes6.dex */
public class GroupChatRepo extends rp8 implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context b;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> c;
    public final long d;
    @Nullable
    public FastRequest e;
    @NonNull
    public sk5 f;
    @Nullable
    public FastRequest g;
    @Nullable
    public ChatRoomDetail h;
    public boolean i;
    public boolean j;
    public final dl5 k;
    @Nullable
    public t<TreeSet<ChatMsg>> l;
    @NonNull
    public final eu5<String> m;
    @NonNull
    public final b55<List<? extends ChatMsg>> n;
    public boolean o;
    @NonNull
    public final Counter p;
    public final v q;
    public final MsgProcessor r;

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
                UiUtils.runOnUiThreadDelay(new c(this, this.c.incrementAndGet()), 800L);
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
                    UiUtils.runOnUiThread(new b(this, dayVisit));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements gl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTipsSysMsg a;
        public final /* synthetic */ t b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0343a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0343a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.m();
                }
            }
        }

        public a(GroupChatRepo groupChatRepo, TbTipsSysMsg tbTipsSysMsg, t tVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, tbTipsSysMsg, tVar, str};
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
            this.a = tbTipsSysMsg;
            this.b = tVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.gl5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                this.d.r.H(this.d.d);
                this.d.r.y(i, this.d.q.b(treeSet));
                if (this.a != null) {
                    this.d.r.B(this.a);
                }
                t tVar = this.b;
                if (tVar != null) {
                    this.d.Z(tVar, i, str, treeSet, this.c);
                }
                if (this.b != null) {
                    UiUtils.runOnUiThread(new RunnableC0343a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements zk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk5 a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ GroupChatRepo c;

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
                    gu5.b(this.a.c.h);
                    p pVar = this.a;
                    pVar.b.i(pVar.c.h);
                    this.a.c.p.j();
                }
            }
        }

        public p(GroupChatRepo groupChatRepo, zk5 zk5Var, FastRequest.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, zk5Var, bVar};
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
            this.a = zk5Var;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.zk5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            String prologue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                this.a.a(j, i, str, chatRoomInfo);
                if (i != 0) {
                    return;
                }
                this.c.o = true;
                this.c.q0();
                UiUtils.runOnUiThread(new a(this));
                TbTipsSysMsg tbTipsSysMsg = null;
                if (this.c.h == null) {
                    prologue = null;
                } else {
                    prologue = this.c.h.getPrologue();
                }
                if (prologue != null && !TextUtils.isEmpty(prologue)) {
                    tbTipsSysMsg = TbTipsSysMsg.createManagerTips(prologue);
                }
                GroupChatRepo groupChatRepo = this.c;
                groupChatRepo.h0(groupChatRepo.l, tbTipsSysMsg);
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
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FastRequest.b b;
        public final /* synthetic */ TreeSet c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ GroupChatRepo f;

        public b(GroupChatRepo groupChatRepo, int i, FastRequest.b bVar, TreeSet treeSet, String str, String str2) {
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
                    this.b.i(this.c);
                } else {
                    this.b.f(i, this.d, null);
                }
                this.b.g();
                this.f.m.d(this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements gl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupChatRepo c;

        public c(GroupChatRepo groupChatRepo, FastRequest.b bVar, String str) {
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

        @Override // com.baidu.tieba.gl5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    this.c.r.y(i, this.c.q.b(treeSet));
                }
                this.c.Z(this.a, i, str, treeSet, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public d(GroupChatRepo groupChatRepo, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements gl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public e(GroupChatRepo groupChatRepo, boolean z, t tVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, Boolean.valueOf(z), tVar, str};
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
            this.b = tVar;
            this.c = str;
        }

        @Override // com.baidu.tieba.gl5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, treeSet) == null) {
                if (i == 0) {
                    TreeSet<TbBaseMsg> b = this.d.q.b(treeSet);
                    if (b.size() >= 5 && !this.d.r.v(this.d.d, b)) {
                        if (this.a) {
                            this.d.r.i(this.d.d);
                        }
                    } else {
                        this.d.r.I(this.d.d, false);
                    }
                    this.d.r.y(i, b);
                }
                t tVar = this.b;
                if (tVar == null) {
                    return;
                }
                this.d.Z(tVar, i, str, treeSet, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;
        public final /* synthetic */ Pair b;

        public f(GroupChatRepo groupChatRepo, u uVar, Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, uVar, pair};
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
            this.b = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l(((Integer) this.b.getFirst()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements gl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ u b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupChatRepo d;

        public g(GroupChatRepo groupChatRepo, String str, u uVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, str, uVar, str2};
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
            this.b = uVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.gl5
        public void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, treeSet) != null) {
                return;
            }
            this.d.p0(this.a, this.b, this.c, i, str, treeSet);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements MsgProcessor.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupChatRepo b;

        public h(GroupChatRepo groupChatRepo, String str) {
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

        @Override // com.baidu.tieba.im.base.core.repo.MsgProcessor.c
        public void a(@NonNull BaseItem<? extends TbBaseMsg> baseItem) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, baseItem) != null) || !TextUtils.equals(baseItem.getTbMsg().getMsgKey(), this.a)) {
                return;
            }
            this.b.t0(baseItem);
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public i(GroupChatRepo groupChatRepo, u uVar) {
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
                this.a.m(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements al5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.al5
        public void a(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                uq8.h(j, i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements dl5 {
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

        @Override // com.baidu.tieba.dl5
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                GroupChatRepo groupChatRepo = this.a;
                groupChatRepo.g0(groupChatRepo.l, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends nu5<GroupChatRoomPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

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
                    return;
                }
            }
            this.a = groupChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public GroupChatRoomPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return bu8.j().f(zv8.b(), this.a.d);
            }
            return (GroupChatRoomPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements st5<GroupChatRoomPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b a;
        public final /* synthetic */ zk5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ GroupChatRepo d;

        public m(GroupChatRepo groupChatRepo, FastRequest.b bVar, zk5 zk5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, zk5Var, Integer.valueOf(i)};
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
            this.b = zk5Var;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
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
                this.d.c0(j, j2, this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b d;
        public final /* synthetic */ zk5 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ GroupChatRepo g;

        public n(GroupChatRepo groupChatRepo, FastRequest.b bVar, zk5 zk5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, bVar, zk5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = groupChatRepo;
            this.d = bVar;
            this.e = zk5Var;
            this.f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void e(int i, @NonNull String str, @Nullable Exception exc, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, exc, chatRoomDetail}) == null) {
                super.e(i, str, exc, chatRoomDetail);
                FastRequest.b bVar = this.d;
                if (bVar != null) {
                    bVar.e(i, str, exc, chatRoomDetail);
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.g();
                FastRequest.b bVar = this.d;
                if (bVar != null) {
                    bVar.g();
                }
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.h();
                FastRequest.b bVar = this.d;
                if (bVar != null) {
                    bVar.h();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull ChatRoomDetail chatRoomDetail) {
            FastRequest.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomDetail) == null) {
                super.i(chatRoomDetail);
                this.g.h = chatRoomDetail;
                if (!chatRoomDetail.isJumpH5() && !this.g.o) {
                    zk5 zk5Var = this.e;
                    if (zk5Var == null || (bVar = this.d) == null) {
                        return;
                    }
                    this.g.d0(zk5Var, bVar, this.f);
                    return;
                }
                FastRequest.b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.i(chatRoomDetail);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo d;

        public o(GroupChatRepo groupChatRepo) {
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
            this.d = groupChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void i(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) && chatRoomDetail.getUserInfo() != null && chatRoomDetail.getUserInfo().getBubbleInfo() != null && this.d.h != null) {
                this.d.h.getUserInfo().setBubbleInfo(chatRoomDetail.getUserInfo().getBubbleInfo());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements kl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public q(GroupChatRepo groupChatRepo) {
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

        @Override // com.baidu.tieba.kl5
        public void a(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && GlobalBuildConfig.isDebug()) {
                BdUtilHelper.showLongToast(this.a.b, (int) R.string.obfuscated_res_0x7f0f0a8a);
            }
        }

        @Override // com.baidu.tieba.kl5
        public void b(long j, int i, @NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && GlobalBuildConfig.isDebug()) {
                String string = this.a.b.getString(R.string.obfuscated_res_0x7f0f0a87);
                Context context = this.a.b;
                BdUtilHelper.showLongToast(context, string + i + ":" + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public s(GroupChatRepo groupChatRepo, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRepo, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class t<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void l();

        public abstract void m();

        public t() {
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
    public static abstract class u<T> extends FastRequest.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void l(int i);

        public abstract void m(@NonNull FetchedEvent fetchedEvent);

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
    public class v implements cl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRepo a;

        public v(GroupChatRepo groupChatRepo) {
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

        public /* synthetic */ v(GroupChatRepo groupChatRepo, k kVar) {
            this(groupChatRepo);
        }

        @Override // com.baidu.tieba.cl5
        public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) {
                this.a.r.a(i, b(treeSet));
            }
        }

        public TreeSet<TbBaseMsg> b(@NonNull TreeSet<ChatMsg> treeSet) {
            InterceptResult invokeL;
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, treeSet)) == null) {
                TreeSet<TbBaseMsg> treeSet2 = new TreeSet<>(TbBaseMsg.COMPARATOR);
                Iterator<ChatMsg> it = treeSet.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    vv8<?, ?> a = dv8.c.a(next.getClass());
                    if (a != null && (tbBaseMsg = (TbBaseMsg) bw8.b(a, nv8.a, next)) != null) {
                        treeSet2.add(tbBaseMsg);
                    }
                }
                return treeSet2;
            }
            return (TreeSet) invokeL.objValue;
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
        this.f = rk5.b();
        this.i = true;
        this.j = false;
        this.k = new k(this);
        this.m = eu5.c();
        this.q = new v(this, null);
        this.c = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.d = j2;
        b55<List<? extends ChatMsg>> b55Var = new b55<>(new u49());
        this.n = b55Var;
        b55Var.g(new v49(tbPageContext, b55Var));
        this.p = new Counter(j2);
        this.r = b();
    }

    public void Y(@NonNull Counter.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.p.f(dVar);
        }
    }

    public void f0(@Nullable t<TreeSet<ChatMsg>> tVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, tVar) == null) && this.r.u(this.d)) {
            g0(tVar, false);
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.j = z;
        }
    }

    public void s0(@Nullable t<TreeSet<ChatMsg>> tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, tVar) == null) {
            this.l = tVar;
        }
    }

    public final void t0(@NonNull BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, baseItem) == null) {
            baseItem.setShowLocatedColor(true);
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.i = z;
        }
    }

    public void i0(@Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable zk5 zk5Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, bVar, zk5Var, i2) == null) {
            ru5.c(new l(this), new m(this, bVar, zk5Var, i2));
        }
    }

    public void r0(@Nullable FastRequest.b<ChatRoomDetail> bVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048602, this, bVar, i2) != null) || !this.j) {
            return;
        }
        this.j = false;
        i0(bVar, null, i2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f.a(this.d);
            this.p.g();
            if (this.i) {
                this.f.r(this.b, this.d, new j(this));
            }
            this.f.k(this.k);
            this.f.o(this.b, this.d, this.q);
            FastRequest fastRequest = this.e;
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

    public final void Z(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar, int i2, @NonNull String str, TreeSet<ChatMsg> treeSet, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Integer.valueOf(i2), str, treeSet, str2}) == null) {
            UiUtils.runOnUiThread(new b(this, i2, bVar, treeSet, str, str2));
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p.g();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sk5 a2 = rk5.a();
            this.f = a2;
            a2.k(this.k);
            this.f.o(this.b, this.d, this.q);
        }
    }

    @Override // com.baidu.tieba.rp8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d();
            this.p.h();
            if (l0()) {
                this.r.H(this.d);
                if (this.l != null) {
                    UiUtils.runOnUiThread(new r(this));
                }
            }
        }
    }

    @Override // com.baidu.tieba.rp8
    @Nullable
    public BubbleInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            gu5.b(this.h);
            return this.h.getUserInfo().getBubbleInfo();
        }
        return (BubbleInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rp8
    @Nullable
    public List<EnableDegradeUserData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            gu5.b(this.h);
            return this.h.getUserInfo().getEnableDegradeUserDataList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rp8
    @Nullable
    public TbBaseMsg.c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gu5.b(this.h);
            return new TbBaseMsg.c(this.h.getUserInfo().getForumLevel(), this.h.getBasicInfo().getForumId());
        }
        return (TbBaseMsg.c) invokeV.objValue;
    }

    @Nullable
    public BaseItem<? extends TbBaseMsg> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.r.o(this.d);
        }
        return (BaseItem) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.p.i();
        }
        return invokeV.intValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.r.u(this.d);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rp8
    @Nullable
    public List<EnableDegradeUserData> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            gu5.b(this.h);
            return this.h.getUserInfo().getSecondDegradeUserDataList();
        }
        return (List) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (l0()) {
                this.r.H(this.d);
                this.r.w(this.d, MsgProcessor.d.a());
                return;
            }
            t<TreeSet<ChatMsg>> tVar = this.l;
            if (tVar != null) {
                tVar.l();
            }
        }
    }

    @Override // com.baidu.tieba.rp8
    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.rp8
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            gu5.b(this.h);
            return this.h.getUserInfo().getIdentityRole();
        }
        return invokeV.intValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f.c(this.b, this.d, new q(this));
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String continuousAccessTips = TbSingleton.getInstance().getContinuousAccessTips();
            if (!TextUtils.isEmpty(continuousAccessTips)) {
                u(TbSubscribeSysMsg.create(continuousAccessTips));
            }
        }
    }

    public final void c0(long j2, long j3, @Nullable FastRequest.b<ChatRoomDetail> bVar, @Nullable zk5 zk5Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), bVar, zk5Var, Integer.valueOf(i2)}) == null) {
            if (this.e == null) {
                this.e = new FastRequest(this.c, CmdConfigHttp.CMD_HTTP_CHAT_ROOM_DETAIL, TbConfig.GET_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.e;
            fastRequest.P(TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_ID, String.valueOf(j2));
            fastRequest.P("last_time", String.valueOf(j3));
            fastRequest.P("chatroom_id", String.valueOf(this.d));
            fastRequest.R(new n(this, bVar, zk5Var, i2));
            fastRequest.T(true);
            fastRequest.Q();
        }
    }

    public final void d0(@NonNull zk5 zk5Var, @NonNull FastRequest.b<ChatRoomDetail> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, zk5Var, bVar, i2) == null) {
            this.f.g(this.k);
            this.f.d(this.b, this.d, this.q);
            this.f.l(this.b, this.d, new p(this, zk5Var, bVar));
            ChatRoomDetail chatRoomDetail = this.h;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                hz8.c("c15089", TbadkCoreApplication.getCurrentAccount(), this.h.getBasicInfo().getForumId(), this.d, i2);
                c59.b(this.h.getBasicInfo().getForumId());
            }
        }
    }

    public void e0(@NonNull FastRequest.b<TreeSet<ChatMsg>> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.m.b("fetchMsgFirst") && this.m.a("fetchHistoryMsg")) {
            BaseItem<? extends TbBaseMsg> m2 = this.r.m(this.d);
            if (m2 == null) {
                this.m.d("fetchHistoryMsg");
                return;
            }
            bVar.h();
            this.f.h(this.b, this.d, m2.getTbMsg().getMsgId(), 30, false, true, this.n, new c(this, bVar, "fetchHistoryMsg"));
        }
    }

    public final void g0(@Nullable t<TreeSet<ChatMsg>> tVar, boolean z) {
        BaseItem<? extends TbBaseMsg> o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, tVar, z) == null) {
            String str = "fetchLatestMsg" + z;
            if (!this.m.a(str) || (o2 = this.r.o(this.d)) == null) {
                return;
            }
            if (tVar != null && !z) {
                UiUtils.runOnUiThread(new d(this, tVar));
            }
            this.f.h(this.b, this.d, o2.getTbMsg().getMsgId(), 30, false, false, this.n, new e(this, z, tVar, str));
        }
    }

    public void h0(@Nullable t<TreeSet<ChatMsg>> tVar, @Nullable TbTipsSysMsg tbTipsSysMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, tVar, tbTipsSysMsg) != null) || !this.m.a("fetchMsgFirst")) {
            return;
        }
        if (tVar != null) {
            UiUtils.runOnUiThread(new s(this, tVar));
        }
        this.f.h(this.b, this.d, 0L, 60, true, true, this.n, new a(this, tbTipsSysMsg, tVar, "fetchMsgFirst"));
    }

    public void n0(long j2, @NonNull String str, @NonNull u<TreeSet<ChatMsg>> uVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), str, uVar}) != null) || !this.m.a("jumpToMsg")) {
            return;
        }
        MsgProcessor.MemoryFlag q2 = this.r.q(this.d, j2);
        if (q2.isMaster()) {
            Pair<Integer, BaseItem<? extends TbBaseMsg>> r2 = this.r.r(q2, this.d, str);
            if (r2 != null && r2.getFirst().intValue() >= 0) {
                t0(r2.getSecond());
                uVar.l(r2.getFirst().intValue());
            } else {
                uVar.m(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.m.d("jumpToMsg");
        } else if (q2.isTmp()) {
            Pair<Integer, BaseItem<? extends TbBaseMsg>> r3 = this.r.r(q2, this.d, str);
            if (r3 != null && r3.getFirst().intValue() >= 0) {
                t0(r3.getSecond());
                this.r.H(this.d);
                MsgProcessor.d a2 = MsgProcessor.d.a();
                a2.k(new f(this, uVar, r3));
                this.r.w(this.d, a2);
            } else {
                uVar.m(FetchedEvent.TARGET_MSG_NOT_EXIST);
            }
            this.m.d("jumpToMsg");
        } else {
            this.r.i(this.d);
            this.r.j(this.d);
            uVar.h();
            uVar.l(0);
            this.f.h(this.b, this.d, j2, 30, false, false, this.n, new g(this, "jumpToMsg", uVar, str));
        }
    }

    public final void p0(@NonNull String str, @NonNull u<TreeSet<ChatMsg>> uVar, @NonNull String str2, int i2, @NonNull String str3, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, uVar, str2, Integer.valueOf(i2), str3, treeSet}) == null) {
            if (i2 == 0) {
                this.r.z(i2, this.q.b(treeSet), new h(this, str2));
                if (this.r.s(treeSet, str2) < 0) {
                    UiUtils.runOnUiThread(new i(this, uVar));
                }
            }
            Z(uVar, i2, str3, treeSet, str);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.g == null) {
                this.g = new FastRequest(this.c, CmdConfigHttp.CMD_REQUEST_CHAT_ROOM_UPDATE, TbConfig.UPDATE_CHAT_ROOM_DETAIL);
            }
            FastRequest fastRequest = this.g;
            fastRequest.P("chatroom_id", String.valueOf(this.d));
            fastRequest.R(new o(this));
            fastRequest.Q();
        }
    }
}
