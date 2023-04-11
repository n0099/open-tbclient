package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
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
/* loaded from: classes5.dex */
public class m68 implements qh5 {
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

    /* loaded from: classes5.dex */
    public interface h {
        @MainThread
        void a(long j, @NonNull List<BaseMsg> list, @NonNull j jVar);
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(@NonNull BaseMsg baseMsg);
    }

    /* loaded from: classes5.dex */
    public interface k<T extends BaseSysMsg> {
        @MainThread
        void a(@NonNull T t);

        @MainThread
        void b(@NonNull ChatMsg chatMsg);
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TreeSet b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ i f;
        public final /* synthetic */ m68 g;

        public a(m68 m68Var, long j, TreeSet treeSet, boolean z, boolean z2, boolean z3, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = m68Var;
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ m68 f;

        public b(m68 m68Var, long j, List list, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = m68Var;
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

    /* loaded from: classes5.dex */
    public class c implements SizedSyncTreeSet.a<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ m68 b;

        public c(m68 m68Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m68Var;
            this.a = j;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
        public void a(boolean z, Collection<BaseMsg> collection) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, collection) != null) || z) {
                return;
            }
            SizedSyncTreeSet t = this.b.t(this.a);
            if (t.isEmpty()) {
                t.addAll(collection);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSysMsg a;
        public final /* synthetic */ m68 b;

        public d(m68 m68Var, BaseSysMsg baseSysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, baseSysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m68Var;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ m68 b;

        public e(m68 m68Var, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m68Var;
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

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ j c;
        public final /* synthetic */ m68 d;

        public f(m68 m68Var, long j, List list, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, Long.valueOf(j), list, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = m68Var;
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-650094377, "Lcom/baidu/tieba/m68$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-650094377, "Lcom/baidu/tieba/m68$g;");
                    return;
                }
            }
            int[] iArr = new int[Action.Op.values().length];
            a = iArr;
            try {
                iArr[Action.Op.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Action.Op.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Action.Op.EXEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;
        public final boolean c;

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
    }

    public m68() {
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

    public static void N(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, chatMsg) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                millis = System.currentTimeMillis();
            }
            chatMsg.setMsgTime(millis);
        }
    }

    public static TreeSet<ChatMsg> P(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            TreeSet<ChatMsg> treeSet = new TreeSet<>(gh5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public final void E(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatMsg) == null) {
            ng.c(new e(this, chatMsg));
        }
    }

    public final void F(@NonNull BaseSysMsg baseSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseSysMsg) == null) {
            ng.c(new d(this, baseSysMsg));
        }
    }

    public void K(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            L(j2, true);
        }
    }

    public void M(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
            this.e = hVar;
        }
    }

    public void O(@Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, kVar) == null) {
            this.f = kVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            SizedSyncTreeSet<BaseMsg> t = t(j2);
            if (!t.isEmpty()) {
                return;
            }
            SizedSyncTreeSet<BaseMsg> p = p(j2);
            t.addAll(p);
            p.clear();
        }
    }

    @Nullable
    public BaseMsg r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> p = p(j2);
            if (p.isEmpty()) {
                return null;
            }
            return p.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public boolean x(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j2)) == null) {
            return !t(j2).isEmpty();
        }
        return invokeJ.booleanValue;
    }

    public void A(long j2, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, jVar) == null) {
            ng.c(new f(this, j2, new ArrayList(p(j2)), jVar));
        }
    }

    public void D(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, treeSet) == null) {
            h(j2, treeSet, true, false, false);
        }
    }

    public void I(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, cls) == null) {
            this.a.put(i2, cls);
        }
    }

    public void J(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, list, cls) == null) {
            for (Integer num : list) {
                this.a.put(num.intValue(), cls);
            }
        }
    }

    @NonNull
    public ChatMsg l(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048599, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("managerTips", str);
            return f(j2, -7014, m(), n(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    @NonNull
    public ChatMsg o(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("subscribeTips", str);
            return f(j2, -7015, m(), n(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public int v(@NonNull TreeSet<ChatMsg> treeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, treeSet, str)) == null) {
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

    public static long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    @NonNull
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return String.valueOf(m());
        }
        return (String) invokeV.objValue;
    }

    public void B(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, true, false);
        }
    }

    @Override // com.baidu.tieba.qh5
    public void a(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, false, true);
        }
    }

    public void C(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet, iVar}) == null) {
            i(j2, treeSet, false, true, false, iVar);
        }
    }

    @NonNull
    public BaseMsg G(long j2, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j2, chatMsg)) == null) {
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
    public BaseSysMsg H(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, chatMsg)) == null) {
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
            CommonMsgField commonMsgField = new CommonMsgField();
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

    public void L(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            SizedSyncTreeSet<BaseMsg> t = t(j2);
            if (!t.isEmpty()) {
                SizedSyncTreeSet<BaseMsg> p = p(j2);
                if (z) {
                    p.clear();
                }
                p.addAll(t, true);
                t.clear();
            }
        }
    }

    @Nullable
    public final BaseMsg q(@NonNull SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, sizedSyncTreeSet, str)) == null) {
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

    @Nullable
    public Pair<Integer, BaseMsg> u(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048606, this, j2, str)) == null) {
            Iterator<BaseMsg> it = p(j2).iterator();
            int i2 = 0;
            while (it.hasNext()) {
                BaseMsg next = it.next();
                if (TextUtils.equals(next.getCommonMsgField().getMsgKey(), str)) {
                    return Pair.create(Integer.valueOf(i2), next);
                }
                i2++;
            }
            return null;
        }
        return (Pair) invokeJL.objValue;
    }

    public boolean z(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            BaseMsg r = r(j2);
            if (r == null || r.getCommonMsgField().getMsgId() > j3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (android.text.TextUtils.equals(r4, r11.getCommonMsgField().getMsgKey()) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Q(long j2, @NonNull BaseMsg baseMsg, @NonNull j jVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), baseMsg, jVar})) == null) {
            Action provideAction = baseMsg.provideAction();
            boolean z = false;
            if (provideAction == null) {
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
                    baseMsg = q(w(j2), e2);
                    if (baseMsg == null) {
                        baseMsg = q(t(j2), e2);
                    }
                    if (baseMsg == null) {
                        baseMsg = q(p(j2), e2);
                        z = true;
                    }
                }
                if (b2 != null) {
                    b2.a(c2, baseMsg, jVar);
                }
                return z;
            }
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(provideAction.d(), e2);
            boolean remove = w(j2).remove(createShadowMsg);
            if (!remove) {
                remove = t(j2).remove(createShadowMsg);
            }
            if (!remove) {
                z = p(j2).remove(createShadowMsg);
            }
            baseMsg = null;
            if (b2 != null) {
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public final ChatMsg R(long j2, @NonNull ChatMsg chatMsg, @NonNull SortedSet<BaseMsg> sortedSet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), chatMsg, sortedSet})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                return null;
            }
            if (sortedSet.isEmpty()) {
                N(chatMsg);
            } else {
                N(chatMsg);
                ChatMsg sdkMsg = sortedSet.last().getSdkMsg();
                N(sdkMsg);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, map})) == null) {
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
    public final void g(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet;
        BaseMsg j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            SizedSyncTreeSet<BaseMsg> p = p(j2);
            SizedSyncTreeSet<BaseMsg> w = w(j2);
            SizedSyncTreeSet<BaseMsg> t = t(j2);
            w.clear();
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
                            if (w.isEmpty()) {
                                sizedSyncTreeSet = p;
                            } else {
                                sizedSyncTreeSet = w;
                            }
                            ChatMsg R = R(j2, next, sizedSyncTreeSet);
                            if (R != null && (j3 = j(j2, R, a2)) != null) {
                                w.add(j3);
                                j4.setPreTimestampMsg(j3);
                            }
                            w.add(j4);
                        }
                    } catch (Exception e2) {
                        r48.g("parse_msg_exception", j2, e2);
                    }
                }
            }
            if (!w.isEmpty()) {
                if (!t.isEmpty() && z3) {
                    t.addAll(w);
                    return;
                }
                p.addAll(w);
                ng.c(new b(this, j2, new ArrayList(p), z, z2, z3));
            }
        }
    }

    public final void h(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            i(j2, treeSet, z, z2, z3, null);
        }
    }

    public final void i(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3, @Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), iVar}) == null) {
            ng.d(new a(this, j2, treeSet, z, z2, z3, iVar));
        }
    }

    @Nullable
    public final BaseMsg j(long j2, @NonNull ChatMsg chatMsg, @NonNull j jVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), chatMsg, jVar})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                if (chatMsg.getNotifyCmd() == 109) {
                    BaseSysMsg H = H(chatMsg);
                    if (H.isIgnore()) {
                        return null;
                    }
                    if (H.isNoUISysMsg()) {
                        if (!jVar.b) {
                            F(H);
                            if (Q(j2, H, jVar)) {
                                A(j2, jVar);
                            }
                        }
                        return null;
                    }
                    Q(j2, H, jVar);
                    return H;
                }
                if (!jVar.b) {
                    E(chatMsg);
                }
                return null;
            }
            BaseMsg G = G(j2, chatMsg);
            Q(j2, G, jVar);
            return G;
        }
        return (BaseMsg) invokeCommon.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> p(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j2)) == null) {
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
    public final SizedSyncTreeSet<BaseMsg> t(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j2)) == null) {
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
    public final SizedSyncTreeSet<BaseMsg> w(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048608, this, j2)) == null) {
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
    public BaseMsg s(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j2)) == null) {
            Iterator<BaseMsg> descendingIterator = p(j2).descendingIterator();
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

    public boolean y(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048610, this, j2, treeSet)) == null) {
            ChatMsg last = treeSet.last();
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(last.getMsgId(), last.getMsgKey());
            SizedSyncTreeSet<BaseMsg> t = t(j2);
            Iterator<ChatMsg> descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                ChatMsg next = descendingIterator.next();
                CommonMsgField commonMsgField = createShadowMsg.getCommonMsgField();
                commonMsgField.setMsgId(next.getMsgId());
                commonMsgField.setMsgKey(next.getMsgKey());
                if (t.contains(createShadowMsg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
