package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ah;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.ln5;
import com.baidu.tieba.vn5;
import com.baidu.tieba.wd8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChatMsgProcessor implements vn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Class<? extends BaseMsg>> a;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> b;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> c;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> d;
    @Nullable
    public h e;
    @Nullable
    public k f;

    /* loaded from: classes6.dex */
    public interface h {
        @MainThread
        void a(long j, @NonNull List<BaseMsg> list, @NonNull j jVar);
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a(@NonNull BaseMsg baseMsg);
    }

    /* loaded from: classes6.dex */
    public interface k<T extends BaseSysMsg> {
        @MainThread
        void a(@NonNull T t);

        @MainThread
        void b(@NonNull ChatMsg chatMsg);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class MemoryFlag {
        public static final /* synthetic */ MemoryFlag[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MemoryFlag AFTER_MASTER;
        public static final MemoryFlag BEFORE_MASTER;
        public static final MemoryFlag MASTER;
        public static final MemoryFlag TMP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363439906, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/ChatMsgProcessor$MemoryFlag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1363439906, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/ChatMsgProcessor$MemoryFlag;");
                    return;
                }
            }
            MASTER = new MemoryFlag("MASTER", 0);
            BEFORE_MASTER = new MemoryFlag("BEFORE_MASTER", 1);
            AFTER_MASTER = new MemoryFlag("AFTER_MASTER", 2);
            MemoryFlag memoryFlag = new MemoryFlag("TMP", 3);
            TMP = memoryFlag;
            $VALUES = new MemoryFlag[]{MASTER, BEFORE_MASTER, AFTER_MASTER, memoryFlag};
        }

        public MemoryFlag(String str, int i) {
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

        public static MemoryFlag valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MemoryFlag) Enum.valueOf(MemoryFlag.class, str);
            }
            return (MemoryFlag) invokeL.objValue;
        }

        public static MemoryFlag[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MemoryFlag[]) $VALUES.clone();
            }
            return (MemoryFlag[]) invokeV.objValue;
        }

        public boolean isAfterMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this == AFTER_MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isBeforeMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this == BEFORE_MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this == MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isTmp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this == TMP) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TreeSet b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ i f;
        public final /* synthetic */ ChatMsgProcessor g;

        public a(ChatMsgProcessor chatMsgProcessor, long j, TreeSet treeSet, boolean z, boolean z2, boolean z3, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = chatMsgProcessor;
            this.a = j;
            this.b = treeSet;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.g.g(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ ChatMsgProcessor f;

        public b(ChatMsgProcessor chatMsgProcessor, long j, List list, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = chatMsgProcessor;
            this.a = j;
            this.b = list;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f.e != null) {
                this.f.e.a(this.a, this.b, j.a(this.c, this.d, this.e));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SizedSyncTreeSet.a<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ChatMsgProcessor b;

        public c(ChatMsgProcessor chatMsgProcessor, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatMsgProcessor;
            this.a = j;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
        public void a(boolean z, Collection<BaseMsg> collection) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, collection) != null) || z) {
                return;
            }
            SizedSyncTreeSet v = this.b.v(this.a);
            if (v.isEmpty()) {
                v.addAll(collection);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSysMsg a;
        public final /* synthetic */ ChatMsgProcessor b;

        public d(ChatMsgProcessor chatMsgProcessor, BaseSysMsg baseSysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, baseSysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatMsgProcessor;
            this.a = baseSysMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.f != null) {
                this.b.f.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ ChatMsgProcessor b;

        public e(ChatMsgProcessor chatMsgProcessor, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatMsgProcessor;
            this.a = chatMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.f != null) {
                this.b.f.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ j c;
        public final /* synthetic */ ChatMsgProcessor d;

        public f(ChatMsgProcessor chatMsgProcessor, long j, List list, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j), list, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = chatMsgProcessor;
            this.a = j;
            this.b = list;
            this.c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.e != null) {
                this.d.e.a(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831621824, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/ChatMsgProcessor$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(831621824, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/ChatMsgProcessor$g;");
                    return;
                }
            }
            int[] iArr = new int[MemoryFlag.values().length];
            b = iArr;
            try {
                iArr[MemoryFlag.MASTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[MemoryFlag.TMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Action.Op.values().length];
            a = iArr2;
            try {
                iArr2[Action.Op.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Action.Op.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Action.Op.EXEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;
        public final boolean c;
        @Nullable
        public Runnable d;

        public j(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = z3;
        }

        @NonNull
        public static j a(boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                return new j(z, z2, z3);
            }
            return (j) invokeCommon.objValue;
        }

        @NonNull
        public static j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return a(true, false, false);
            }
            return (j) invokeV.objValue;
        }

        @Nullable
        public Runnable c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (Runnable) invokeV.objValue;
        }

        public void d(@Nullable Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                this.d = runnable;
            }
        }
    }

    public ChatMsgProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        new ConcurrentHashMap();
    }

    public static void P(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, chatMsg) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                millis = System.currentTimeMillis();
            }
            chatMsg.setMsgTime(millis);
        }
    }

    public static TreeSet<ChatMsg> R(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            TreeSet<ChatMsg> treeSet = new TreeSet<>(ln5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public boolean A(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            return !v(j2).isEmpty();
        }
        return invokeJ.booleanValue;
    }

    public final void G(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatMsg) == null) {
            ah.c(new e(this, chatMsg));
        }
    }

    public final void H(@NonNull BaseSysMsg baseSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, baseSysMsg) == null) {
            ah.c(new d(this, baseSysMsg));
        }
    }

    public void M(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            N(j2, true);
        }
    }

    public void O(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            this.e = hVar;
        }
    }

    public void Q(@Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            this.f = kVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            SizedSyncTreeSet<BaseMsg> v = v(j2);
            if (!v.isEmpty()) {
                return;
            }
            SizedSyncTreeSet<BaseMsg> q = q(j2);
            v.addAll(q);
            q.clear();
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            q(j2).clear();
        }
    }

    @Nullable
    public BaseMsg s(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048606, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> q = q(j2);
            if (q.isEmpty()) {
                return null;
            }
            return q.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg t(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048607, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> v = v(j2);
            if (v.isEmpty()) {
                return null;
            }
            return v.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public void C(long j2, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, jVar) == null) {
            ah.c(new f(this, j2, new ArrayList(q(j2)), jVar));
        }
    }

    public void F(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048581, this, j2, treeSet) == null) {
            h(j2, treeSet, true, false, false);
        }
    }

    public void K(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, cls) == null) {
            this.a.put(i2, cls);
        }
    }

    public void L(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, list, cls) == null) {
            for (Integer num : list) {
                this.a.put(num.intValue(), cls);
            }
        }
    }

    @NonNull
    public ChatMsg m(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048602, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("managerTips", str);
            return f(j2, -7014, n(), o(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    @NonNull
    public ChatMsg p(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048603, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("subscribeTips", str);
            return f(j2, -7015, n(), o(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public int y(@NonNull TreeSet<ChatMsg> treeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, treeSet, str)) == null) {
            Iterator<ChatMsg> it = treeSet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getMsgKey(), str)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    @NonNull
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return String.valueOf(n());
        }
        return (String) invokeV.objValue;
    }

    public boolean B(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, treeSet)) == null) {
            ChatMsg last = treeSet.last();
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(last.getMsgId(), last.getMsgKey());
            SizedSyncTreeSet<BaseMsg> v = v(j2);
            Iterator<ChatMsg> descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                ChatMsg next = descendingIterator.next();
                CommonMsgField commonMsgField = createShadowMsg.getCommonMsgField();
                commonMsgField.setMsgId(next.getMsgId());
                commonMsgField.setMsgKey(next.getMsgKey());
                if (v.contains(createShadowMsg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public void D(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, true, false);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void a(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, false, true);
        }
    }

    public void E(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet, iVar}) == null) {
            i(j2, treeSet, false, true, false, iVar);
        }
    }

    @NonNull
    public BaseMsg I(long j2, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, chatMsg)) == null) {
            CommonMsgField commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setRoomId(j2);
            commonMsgField.setUserId(Long.parseLong(chatMsg.getSenderUid()));
            commonMsgField.setUserName(chatMsg.getNickName());
            commonMsgField.setPortrait(chatMsg.getPortrait());
            if (commonMsgField.getContent() == null) {
                commonMsgField.setContent(new HashMap());
            }
            BaseChatMsg baseChatMsg = (BaseChatMsg) DataExt.toEntity(commonMsgField.getContent(), this.a.get(commonMsgField.getType()));
            baseChatMsg.parseSdkMsg4Base(chatMsg);
            baseChatMsg.fromSdkMsg(chatMsg);
            baseChatMsg.setCommonMsgField(commonMsgField);
            baseChatMsg.setSdkMsg(chatMsg);
            return baseChatMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }

    @NonNull
    public MemoryFlag w(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            BaseMsg t = t(j2);
            if (t != null && t.getCommonMsgField().getMsgId() <= j3) {
                return MemoryFlag.TMP;
            }
            BaseMsg u = u(j2);
            if (u != null && u.getCommonMsgField().getMsgId() < j3) {
                return MemoryFlag.AFTER_MASTER;
            }
            BaseMsg s = s(j2);
            if (s != null && s.getCommonMsgField().getMsgId() <= j3) {
                return MemoryFlag.MASTER;
            }
            return MemoryFlag.BEFORE_MASTER;
        }
        return (MemoryFlag) invokeCommon.objValue;
    }

    @NonNull
    public BaseSysMsg J(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        CommonMsgField commonMsgField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, chatMsg)) == null) {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            String optString = jSONObject.optString("service_info");
            if (this.a.get(optInt) == null) {
                optInt = TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS;
            }
            BaseSysMsg baseSysMsg = (BaseSysMsg) DataExt.toEntity(optString, this.a.get(optInt));
            if (-7017 == optInt) {
                baseSysMsg.setSysMsgType(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS);
            }
            baseSysMsg.parseSdkMsg4Base(chatMsg);
            baseSysMsg.setSdkMsg(chatMsg);
            baseSysMsg.setSysMsg(!baseSysMsg.isConvertToNormalMsg());
            if (!StringUtils.isNull(chatMsg.getChatRoomContentExt())) {
                commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            } else {
                commonMsgField = new CommonMsgField();
            }
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setType(optInt);
            commonMsgField.setRoomId(baseSysMsg.getRoomId());
            BaseSysMsg.User userFrom = baseSysMsg.getUserFrom();
            if (userFrom != null) {
                commonMsgField.setUserId(userFrom.getUserId());
                commonMsgField.setUserName(userFrom.getUsername());
                commonMsgField.setPortrait(userFrom.getPortrait());
                commonMsgField.setRole(userFrom.getRole());
                commonMsgField.setLevel(userFrom.getLevel());
            }
            baseSysMsg.setCommonMsgField(commonMsgField);
            return baseSysMsg;
        }
        return (BaseSysMsg) invokeL.objValue;
    }

    public void N(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            SizedSyncTreeSet<BaseMsg> v = v(j2);
            if (!v.isEmpty()) {
                SizedSyncTreeSet<BaseMsg> q = q(j2);
                if (z) {
                    q.clear();
                }
                q.addAll(v, true);
                v.clear();
            }
        }
    }

    @Nullable
    public final BaseMsg r(@NonNull SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, sizedSyncTreeSet, str)) == null) {
            Iterator<BaseMsg> descendingIterator = sizedSyncTreeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                BaseMsg next = descendingIterator.next();
                if (TextUtils.equals(next.getCommonMsgField().getMsgKey(), str)) {
                    BaseMsg shallowClone = next.shallowClone();
                    if (shallowClone != null) {
                        descendingIterator.remove();
                        sizedSyncTreeSet.add(shallowClone);
                    }
                    return shallowClone;
                }
            }
            return null;
        }
        return (BaseMsg) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (android.text.TextUtils.equals(r4, r11.getCommonMsgField().getMsgKey()) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean S(long j2, @NonNull BaseMsg baseMsg, @NonNull j jVar) {
        InterceptResult invokeCommon;
        Action provideAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), baseMsg, jVar})) == null) {
            boolean z = false;
            if (!jVar.c || (provideAction = baseMsg.provideAction()) == null) {
                return false;
            }
            Action.a b2 = provideAction.b();
            Action.Op c2 = provideAction.c();
            String e2 = provideAction.e();
            int i2 = g.a[c2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unexpected value: " + c2);
                    }
                } else {
                    baseMsg = r(z(j2), e2);
                    if (baseMsg == null) {
                        baseMsg = r(v(j2), e2);
                    }
                    if (baseMsg == null) {
                        baseMsg = r(q(j2), e2);
                        z = true;
                    }
                }
                if (b2 != null) {
                    b2.a(c2, baseMsg, jVar);
                }
                return z;
            }
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(provideAction.d(), e2);
            boolean remove = z(j2).remove(createShadowMsg);
            if (!remove) {
                remove = v(j2).remove(createShadowMsg);
            }
            if (!remove) {
                z = q(j2).remove(createShadowMsg);
            }
            baseMsg = null;
            if (b2 != null) {
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public final ChatMsg T(long j2, @NonNull ChatMsg chatMsg, @NonNull SortedSet<BaseMsg> sortedSet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), chatMsg, sortedSet})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                return null;
            }
            if (sortedSet.isEmpty()) {
                P(chatMsg);
            } else {
                P(chatMsg);
                ChatMsg sdkMsg = sortedSet.last().getSdkMsg();
                P(sdkMsg);
                long msgTime = chatMsg.getMsgTime() - sdkMsg.getMsgTime();
                String msgKey = chatMsg.getMsgKey();
                String msgKey2 = sortedSet.first().getCommonMsgField().getMsgKey();
                if (msgTime <= TimeUnit.MINUTES.toMillis(3L) && (msgTime >= 0 || !TextUtils.equals(msgKey, msgKey2))) {
                    chatMsg = null;
                }
            }
            if (chatMsg == null) {
                return null;
            }
            long msgTime2 = chatMsg.getMsgTime();
            long msgId = chatMsg.getMsgId();
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", Long.valueOf(msgTime2));
            return f(j2, -7013, msgId - 1, String.valueOf(msgTime2), hashMap);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @NonNull
    public final ChatMsg f(long j2, int i2, long j3, @NonNull String str, @NonNull Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, map})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, Integer.valueOf(i2));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("msg_type", Integer.valueOf(i2));
            hashMap2.put("chatroom_id", Long.valueOf(j2));
            hashMap2.putAll(map);
            hashMap.put("service_info", hashMap2);
            UnSupportedMsg unSupportedMsg = new UnSupportedMsg();
            unSupportedMsg.setMsgContent(DataExt.toJson(hashMap));
            unSupportedMsg.setMsgId(j3);
            unSupportedMsg.setMsgKey(str);
            unSupportedMsg.setNotifyCmd(109);
            return unSupportedMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @WorkerThread
    public final synchronized void g(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet;
        BaseMsg j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            synchronized (this) {
                SizedSyncTreeSet<BaseMsg> q = q(j2);
                SizedSyncTreeSet<BaseMsg> z4 = z(j2);
                SizedSyncTreeSet<BaseMsg> v = v(j2);
                z4.clear();
                j a2 = j.a(z, z2, z3);
                Iterator<ChatMsg> it = treeSet.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next != null) {
                        try {
                            BaseMsg j4 = j(j2, next, a2);
                            if (j4 != null) {
                                if (iVar != null) {
                                    iVar.a(j4);
                                }
                                if (z4.isEmpty()) {
                                    sizedSyncTreeSet = q;
                                } else {
                                    sizedSyncTreeSet = z4;
                                }
                                ChatMsg T2 = T(j2, next, sizedSyncTreeSet);
                                if (T2 != null && (j3 = j(j2, T2, a2)) != null) {
                                    z4.add(j3);
                                    j4.setPreTimestampMsg(j3);
                                }
                                z4.add(j4);
                            }
                        } catch (Exception e2) {
                            wd8.g("parse_msg_exception", j2, e2);
                        }
                    }
                }
                if (!z4.isEmpty()) {
                    if (!v.isEmpty() && z3) {
                        v.addAll(z4);
                    } else {
                        q.addAll(z4);
                        ah.c(new b(this, j2, new ArrayList(q), z, z2, z3));
                    }
                }
            }
        }
    }

    public final void h(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            i(j2, treeSet, z, z2, z3, null);
        }
    }

    public final void i(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            ah.d(new a(this, j2, treeSet, z, z2, z3, iVar));
        }
    }

    @Nullable
    public final BaseMsg j(long j2, @NonNull ChatMsg chatMsg, @NonNull j jVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j2), chatMsg, jVar})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                if (chatMsg.getNotifyCmd() == 109) {
                    BaseSysMsg J = J(chatMsg);
                    if (J.isIgnore()) {
                        return null;
                    }
                    if (J.isNoUISysMsg()) {
                        if (!jVar.b) {
                            H(J);
                            if (S(j2, J, jVar)) {
                                C(j2, jVar);
                            }
                        }
                        return null;
                    }
                    S(j2, J, jVar);
                    return J;
                }
                if (!jVar.b) {
                    G(chatMsg);
                }
                return null;
            }
            BaseMsg I = I(j2, chatMsg);
            S(j2, I, jVar);
            return I;
        }
        return (BaseMsg) invokeCommon.objValue;
    }

    @Nullable
    public Pair<Integer, BaseMsg> x(@NonNull MemoryFlag memoryFlag, long j2, @NonNull String str) {
        InterceptResult invokeCommon;
        SizedSyncTreeSet<BaseMsg> q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{memoryFlag, Long.valueOf(j2), str})) == null) {
            int i2 = g.b[memoryFlag.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    q = v(j2);
                } else {
                    throw new IllegalStateException("不支持的内存分区参数");
                }
            } else {
                q = q(j2);
            }
            Iterator<BaseMsg> it = q.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                BaseMsg next = it.next();
                if (TextUtils.equals(next.getCommonMsgField().getMsgKey(), str)) {
                    return Pair.create(Integer.valueOf(i3), next);
                }
                i3++;
            }
            return null;
        }
        return (Pair) invokeCommon.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> q(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.b.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                sizedSyncTreeSet2.setCallback(new c(this, j2));
                this.b.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> v(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.d.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                this.d.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> z(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048613, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.c.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                this.c.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg u(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048608, this, j2)) == null) {
            Iterator<BaseMsg> descendingIterator = q(j2).descendingIterator();
            while (descendingIterator.hasNext()) {
                BaseMsg next = descendingIterator.next();
                if (!(next instanceof BaseSysMsg)) {
                    return next;
                }
                BaseSysMsg baseSysMsg = (BaseSysMsg) next;
                int type = baseSysMsg.getCommonMsgField().getType();
                if (baseSysMsg.getMsgConf() != null && baseSysMsg.getMsgConf().isVisible()) {
                    z = true;
                } else {
                    z = false;
                }
                if (-7013 != type && -7014 != type && -7015 != type && z) {
                    return next;
                }
            }
            return null;
        }
        return (BaseMsg) invokeJ.objValue;
    }
}
