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
import com.baidu.tieba.dh;
import com.baidu.tieba.ep5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.EmojiReplySysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.uo5;
import com.baidu.tieba.yk8;
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
public class ChatMsgProcessor implements ep5 {
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
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ i g;
        public final /* synthetic */ ChatMsgProcessor h;

        public a(ChatMsgProcessor chatMsgProcessor, long j, TreeSet treeSet, int i, boolean z, boolean z2, boolean z3, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j), treeSet, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = chatMsgProcessor;
            this.a = j;
            this.b = treeSet;
            this.c = i;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.h.g(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ ChatMsgProcessor g;

        public b(ChatMsgProcessor chatMsgProcessor, long j, List list, int i, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgProcessor, Long.valueOf(j), list, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = chatMsgProcessor;
            this.a = j;
            this.b = list;
            this.c = i;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.g.e != null) {
                this.g.e.a(this.a, this.b, j.a(this.c, this.d, this.e, this.f));
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
            SizedSyncTreeSet w = this.b.w(this.a);
            if (w.isEmpty()) {
                w.addAll(collection);
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
        public final int a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        @Nullable
        public Runnable e;

        public j(int i, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        @NonNull
        public static j a(int i, boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                return new j(i, z, z2, z3);
            }
            return (j) invokeCommon.objValue;
        }

        @NonNull
        public static j b(boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                return a(0, z, z2, z3);
            }
            return (j) invokeCommon.objValue;
        }

        @NonNull
        public static j c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return b(true, false, false);
            }
            return (j) invokeV.objValue;
        }

        @Nullable
        public Runnable d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return (Runnable) invokeV.objValue;
        }

        public void e(@Nullable Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                this.e = runnable;
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

    public static void R(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, chatMsg) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                millis = System.currentTimeMillis();
            }
            chatMsg.setMsgTime(millis);
        }
    }

    public static TreeSet<ChatMsg> T(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            TreeSet<ChatMsg> treeSet = new TreeSet<>(uo5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public boolean B(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            return !w(j2).isEmpty();
        }
        return invokeJ.booleanValue;
    }

    public final void H(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatMsg) == null) {
            dh.c(new e(this, chatMsg));
        }
    }

    public final void I(@NonNull BaseSysMsg baseSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseSysMsg) == null) {
            dh.c(new d(this, baseSysMsg));
        }
    }

    public void O(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            P(j2, true);
        }
    }

    public void Q(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hVar) == null) {
            this.e = hVar;
        }
    }

    public void S(@Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            this.f = kVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            SizedSyncTreeSet<BaseMsg> w = w(j2);
            if (!w.isEmpty()) {
                return;
            }
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            w.addAll(r);
            r.clear();
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            r(j2).clear();
        }
    }

    @Nullable
    public BaseMsg t(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            if (r.isEmpty()) {
                return null;
            }
            return r.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg u(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> w = w(j2);
            if (w.isEmpty()) {
                return null;
            }
            return w.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public void D(long j2, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, jVar) == null) {
            dh.c(new f(this, j2, new ArrayList(r(j2)), jVar));
        }
    }

    public void M(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, cls) == null) {
            this.a.put(i2, cls);
        }
    }

    public void N(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, cls) == null) {
            for (Integer num : list) {
                this.a.put(num.intValue(), cls);
            }
        }
    }

    public ChatMsg m(long j2, @NonNull Map<String, Object> map) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048604, this, j2, map)) == null) {
            return f(j2, 20000, o(), p(), map, 110);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    @NonNull
    public ChatMsg n(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048605, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("managerTips", str);
            return f(j2, -7014, o(), p(), hashMap, 109);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    @NonNull
    public ChatMsg q(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048606, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("subscribeTips", str);
            return f(j2, -7015, o(), p(), hashMap, 109);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public int z(@NonNull TreeSet<ChatMsg> treeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, treeSet, str)) == null) {
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

    public static long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    @NonNull
    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return String.valueOf(o());
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> A(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
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

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048607, this, j2)) == null) {
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
    public final SizedSyncTreeSet<BaseMsg> w(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048612, this, j2)) == null) {
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

    public boolean C(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, treeSet)) == null) {
            ChatMsg last = treeSet.last();
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(last.getMsgId(), last.getMsgKey());
            SizedSyncTreeSet<BaseMsg> w = w(j2);
            Iterator<ChatMsg> descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                ChatMsg next = descendingIterator.next();
                CommonMsgField commonMsgField = createShadowMsg.getCommonMsgField();
                commonMsgField.setMsgId(next.getMsgId());
                commonMsgField.setMsgKey(next.getMsgKey());
                if (w.contains(createShadowMsg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public void E(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, 0, false, true, false);
        }
    }

    public void G(long j2, int i2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), treeSet}) == null) {
            h(j2, treeSet, i2, true, false, false);
        }
    }

    @Override // com.baidu.tieba.ep5
    public void a(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, 0, false, false, true);
        }
    }

    public void F(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet, iVar}) == null) {
            i(j2, treeSet, 0, false, true, false, iVar);
        }
    }

    @NonNull
    public final BaseSysMsg J(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        CommonMsgField commonMsgField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, chatMsg)) == null) {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            String optString = jSONObject.optString("service_info");
            long optLong = jSONObject.optLong("room_id");
            if (this.a.get(optInt) == null) {
                optInt = TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS;
            }
            EmojiReplySysMsg emojiReplySysMsg = (EmojiReplySysMsg) DataExt.toEntity(optString, this.a.get(optInt));
            if (-7017 == optInt) {
                emojiReplySysMsg.setSysMsgType(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS);
            }
            emojiReplySysMsg.parseSdkMsg4Base(chatMsg);
            emojiReplySysMsg.setSdkMsg(chatMsg);
            emojiReplySysMsg.setSysMsg(!emojiReplySysMsg.isConvertToNormalMsg());
            if (!StringUtils.isNull(chatMsg.getChatRoomContentExt())) {
                commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            } else {
                commonMsgField = new CommonMsgField();
            }
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setType(optInt);
            commonMsgField.setRoomId(optLong);
            commonMsgField.setEmojiList(emojiReplySysMsg.getEmojiData());
            emojiReplySysMsg.setCommonMsgField(commonMsgField);
            BaseSysMsg.User user = new BaseSysMsg.User();
            user.setBduk(emojiReplySysMsg.getOriEmojiRepliedMsgSenderBdUk());
            emojiReplySysMsg.setUserFrom(user);
            return emojiReplySysMsg;
        }
        return (BaseSysMsg) invokeL.objValue;
    }

    @NonNull
    public BaseSysMsg L(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        CommonMsgField commonMsgField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, chatMsg)) == null) {
            if (chatMsg.getNotifyCmd() == 110) {
                return J(chatMsg);
            }
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

    @NonNull
    public BaseMsg K(long j2, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j2, chatMsg)) == null) {
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
    public MemoryFlag x(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            BaseMsg u = u(j2);
            if (u != null && u.getCommonMsgField().getMsgId() <= j3) {
                return MemoryFlag.TMP;
            }
            BaseMsg v = v(j2);
            if (v != null && v.getCommonMsgField().getMsgId() < j3) {
                return MemoryFlag.AFTER_MASTER;
            }
            BaseMsg t = t(j2);
            if (t != null && t.getCommonMsgField().getMsgId() <= j3) {
                return MemoryFlag.MASTER;
            }
            return MemoryFlag.BEFORE_MASTER;
        }
        return (MemoryFlag) invokeCommon.objValue;
    }

    public void P(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            SizedSyncTreeSet<BaseMsg> w = w(j2);
            if (!w.isEmpty()) {
                SizedSyncTreeSet<BaseMsg> r = r(j2);
                if (z) {
                    r.clear();
                }
                r.addAll(w, true);
                w.clear();
            }
        }
    }

    @Nullable
    public final BaseMsg s(@NonNull SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, sizedSyncTreeSet, str)) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (android.text.TextUtils.equals(r5, r12.getCommonMsgField().getMsgKey()) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean U(long j2, @NonNull BaseMsg baseMsg, @NonNull j jVar) {
        InterceptResult invokeCommon;
        boolean z;
        Action provideAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), baseMsg, jVar})) == null) {
            boolean z2 = false;
            if (!jVar.d && (!jVar.b || jVar.a != 1)) {
                z = false;
            } else {
                z = true;
            }
            if (!z || (provideAction = baseMsg.provideAction()) == null) {
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
                    baseMsg = s(A(j2), e2);
                    if (baseMsg == null) {
                        baseMsg = s(w(j2), e2);
                    }
                    if (baseMsg == null) {
                        baseMsg = s(r(j2), e2);
                        z2 = true;
                    }
                }
                if (b2 != null) {
                    b2.a(c2, baseMsg, jVar);
                }
                return z2;
            }
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(provideAction.d(), e2);
            boolean remove = A(j2).remove(createShadowMsg);
            if (!remove) {
                remove = w(j2).remove(createShadowMsg);
            }
            if (!remove) {
                z2 = r(j2).remove(createShadowMsg);
            }
            baseMsg = null;
            if (b2 != null) {
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public final ChatMsg V(long j2, @NonNull ChatMsg chatMsg, @NonNull SortedSet<BaseMsg> sortedSet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), chatMsg, sortedSet})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                return null;
            }
            if (sortedSet.isEmpty()) {
                R(chatMsg);
            } else {
                R(chatMsg);
                ChatMsg sdkMsg = sortedSet.last().getSdkMsg();
                R(sdkMsg);
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
            return f(j2, -7013, msgId - 1, String.valueOf(msgTime2), hashMap, 109);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @NonNull
    public final ChatMsg f(long j2, int i2, long j3, @NonNull String str, @NonNull Map<String, Object> map, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, map, Integer.valueOf(i3)})) == null) {
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
            unSupportedMsg.setNotifyCmd(i3);
            return unSupportedMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @WorkerThread
    public final synchronized void g(long j2, @NonNull TreeSet<ChatMsg> treeSet, int i2, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet;
        BaseMsg j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), treeSet, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            synchronized (this) {
                SizedSyncTreeSet<BaseMsg> r = r(j2);
                SizedSyncTreeSet<BaseMsg> A = A(j2);
                SizedSyncTreeSet<BaseMsg> w = w(j2);
                A.clear();
                j a2 = j.a(i2, z, z2, z3);
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
                                if (A.isEmpty()) {
                                    sizedSyncTreeSet = r;
                                } else {
                                    sizedSyncTreeSet = A;
                                }
                                ChatMsg V = V(j2, next, sizedSyncTreeSet);
                                if (V != null && (j3 = j(j2, V, a2)) != null) {
                                    A.add(j3);
                                    j4.setPreTimestampMsg(j3);
                                }
                                A.add(j4);
                            }
                        } catch (Exception e2) {
                            yk8.g("parse_msg_exception", j2, e2);
                        }
                    }
                }
                if (!A.isEmpty()) {
                    if (!w.isEmpty() && z3) {
                        w.addAll(A);
                    } else {
                        r.addAll(A);
                        dh.c(new b(this, j2, new ArrayList(r), i2, z, z2, z3));
                    }
                }
            }
        }
    }

    public final void h(long j2, @NonNull TreeSet<ChatMsg> treeSet, int i2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j2), treeSet, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            i(j2, treeSet, i2, z, z2, z3, null);
        }
    }

    public final void i(long j2, @NonNull TreeSet<ChatMsg> treeSet, int i2, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), treeSet, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            dh.e(new a(this, j2, treeSet, i2, z, z2, z3, iVar));
        }
    }

    @Nullable
    public final BaseMsg j(long j2, @NonNull ChatMsg chatMsg, @NonNull j jVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), chatMsg, jVar})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                if (chatMsg.getNotifyCmd() != 109 && chatMsg.getNotifyCmd() != 110) {
                    if (!jVar.c) {
                        H(chatMsg);
                    }
                    return null;
                }
                BaseSysMsg L = L(chatMsg);
                if (L.isIgnore()) {
                    return null;
                }
                if (L.isNoUISysMsg()) {
                    if (!jVar.c) {
                        I(L);
                        if (U(j2, L, jVar)) {
                            D(j2, jVar);
                        }
                    }
                    return null;
                }
                U(j2, L, jVar);
                return L;
            }
            BaseMsg K = K(j2, chatMsg);
            U(j2, K, jVar);
            return K;
        }
        return (BaseMsg) invokeCommon.objValue;
    }

    @Nullable
    public Pair<Integer, BaseMsg> y(@NonNull MemoryFlag memoryFlag, long j2, @NonNull String str) {
        InterceptResult invokeCommon;
        SizedSyncTreeSet<BaseMsg> r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{memoryFlag, Long.valueOf(j2), str})) == null) {
            int i2 = g.b[memoryFlag.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    r = w(j2);
                } else {
                    throw new IllegalStateException("不支持的内存分区参数");
                }
            } else {
                r = r(j2);
            }
            Iterator<BaseMsg> it = r.iterator();
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

    @Nullable
    public BaseMsg v(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048611, this, j2)) == null) {
            Iterator<BaseMsg> descendingIterator = r(j2).descendingIterator();
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
