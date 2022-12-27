package com.baidu.tieba;

import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
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
/* loaded from: classes7.dex */
public class yh7 implements hb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Class<? extends BaseMsg>> a;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> b;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> c;
    @NonNull
    public final ConcurrentHashMap<Long, Boolean> d;
    @Nullable
    public f e;
    @Nullable
    public h f;

    /* loaded from: classes7.dex */
    public interface f {
        @MainThread
        void a(long j, @NonNull List<BaseMsg> list, @NonNull g gVar);
    }

    /* loaded from: classes7.dex */
    public interface h<T extends BaseSysMsg> {
        @MainThread
        void a(@NonNull T t);

        @MainThread
        void b(@NonNull ChatMsg chatMsg);
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TreeSet b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ yh7 f;

        public a(yh7 yh7Var, long j, TreeSet treeSet, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var, Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yh7Var;
            this.a = j;
            this.b = treeSet;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.i(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ yh7 f;

        public b(yh7 yh7Var, long j, List list, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yh7Var;
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
                this.f.e.a(this.a, this.b, g.b(this.c, this.d, this.e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SizedSyncTreeSet.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ yh7 b;

        public c(yh7 yh7Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh7Var;
            this.a = j;
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !z) {
                this.b.d.put(Long.valueOf(this.a), Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSysMsg a;
        public final /* synthetic */ yh7 b;

        public d(yh7 yh7Var, BaseSysMsg baseSysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var, baseSysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh7Var;
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

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ yh7 b;

        public e(yh7 yh7Var, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yh7Var;
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

    /* loaded from: classes7.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;

        public g(boolean z, boolean z2, boolean z3) {
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
            this.b = z3;
        }

        @NonNull
        public static g b(boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                return new g(z, z2, z3);
            }
            return (g) invokeCommon.objValue;
        }
    }

    public yh7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
    }

    public static void E(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, chatMsg) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                millis = System.currentTimeMillis();
            }
            chatMsg.setMsgTime(millis);
        }
    }

    public static TreeSet<ChatMsg> G(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            TreeSet<ChatMsg> treeSet = new TreeSet<>(cb5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public void D(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void F(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            this.f = hVar;
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            o(j).clear();
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.d.put(Long.valueOf(j), Boolean.FALSE);
        }
    }

    @Nullable
    public BaseMsg p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            SizedSyncTreeSet<BaseMsg> o = o(j);
            if (o.isEmpty()) {
                return null;
            }
            return o.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg q(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            SizedSyncTreeSet<BaseMsg> o = o(j);
            if (o.isEmpty()) {
                return null;
            }
            return o.last();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public boolean t(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            Boolean bool = this.d.get(Long.valueOf(j));
            if (bool != null && bool.booleanValue()) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.d.put(Long.valueOf(j), Boolean.TRUE);
        }
    }

    public final void x(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, chatMsg) == null) {
            eh.c(new e(this, chatMsg));
        }
    }

    public final void y(@NonNull BaseSysMsg baseSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, baseSysMsg) == null) {
            eh.c(new d(this, baseSysMsg));
        }
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

    @NonNull
    public final BaseSysMsg A(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMsg)) == null) {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            BaseSysMsg baseSysMsg = (BaseSysMsg) DataExt.toEntity(jSONObject.optString("service_info"), this.a.get(optInt));
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

    public void B(int i, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cls) == null) {
            this.a.put(i, cls);
        }
    }

    public void C(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, cls) == null) {
            for (Integer num : list) {
                this.a.put(num.intValue(), cls);
            }
        }
    }

    @NonNull
    public ChatMsg l(long j, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("managerTips", str);
            return f(j, -7014, m(), n(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public void w(long j, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048598, this, j, treeSet) == null) {
            j(j, treeSet, true, false, false);
        }
    }

    @Nullable
    public final ChatMsg H(long j, @NonNull ChatMsg chatMsg, @NonNull SortedSet<BaseMsg> sortedSet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), chatMsg, sortedSet})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                return null;
            }
            if (sortedSet.isEmpty()) {
                E(chatMsg);
            } else {
                E(chatMsg);
                ChatMsg sdkMsg = sortedSet.last().getSdkMsg();
                E(sdkMsg);
                if (chatMsg.getMsgTime() - sdkMsg.getMsgTime() <= TimeUnit.MINUTES.toMillis(3L)) {
                    chatMsg = null;
                }
            }
            if (chatMsg == null) {
                return null;
            }
            long msgTime = chatMsg.getMsgTime();
            long msgId = chatMsg.getMsgId();
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", Long.valueOf(msgTime));
            return f(j, -7013, msgId - 1, String.valueOf(msgTime), hashMap);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.hb5
    public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) {
            j(j, treeSet, false, false, true);
        }
    }

    public void v(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) {
            j(j, treeSet, false, true, false);
        }
    }

    @NonNull
    public final ChatMsg f(long j, int i, long j2, @NonNull String str, @NonNull Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, map})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, Integer.valueOf(i));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("msg_type", Integer.valueOf(i));
            hashMap2.put("chatroom_id", Long.valueOf(j));
            hashMap2.putAll(map);
            hashMap.put("service_info", hashMap2);
            UnSupportedMsg unSupportedMsg = new UnSupportedMsg();
            unSupportedMsg.setMsgContent(DataExt.toJson(hashMap));
            unSupportedMsg.setMsgId(j2);
            unSupportedMsg.setMsgKey(str);
            unSupportedMsg.setNotifyCmd(109);
            return unSupportedMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @WorkerThread
    public final void i(long j, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        boolean z4;
        SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet;
        BaseMsg k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            SizedSyncTreeSet<BaseMsg> o = o(j);
            SizedSyncTreeSet<BaseMsg> s = s(j);
            s.clear();
            if (z3 && t(j)) {
                z4 = true;
            } else {
                z4 = false;
            }
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (next != null) {
                    try {
                        BaseMsg k2 = k(j, next, z4, z2);
                        if (k2 != null) {
                            if (s.isEmpty()) {
                                sizedSyncTreeSet = o;
                            } else {
                                sizedSyncTreeSet = s;
                            }
                            try {
                                ChatMsg H = H(j, next, sizedSyncTreeSet);
                                if (H != null && (k = k(j, H, z4, z2)) != null) {
                                    s.add(k);
                                }
                                s.add(k2);
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e(e);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            }
            if (!s.isEmpty()) {
                o.addAll(s);
                eh.c(new b(this, j, new ArrayList(o), z, z2, z3));
            }
        }
    }

    public final void j(long j, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            eh.d(new a(this, j, treeSet, z, z2, z3));
        }
    }

    @Nullable
    public final BaseMsg k(long j, @NonNull ChatMsg chatMsg, boolean z, boolean z2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), chatMsg, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BaseSysMsg baseSysMsg = null;
            if (chatMsg.getMsgType() == 10000) {
                if (chatMsg.getNotifyCmd() == 109) {
                    BaseSysMsg A = A(chatMsg);
                    if (A.isNoUISysMsg()) {
                        if (!z2) {
                            y(A);
                        }
                        return null;
                    }
                    if (!z) {
                        baseSysMsg = A;
                    }
                    BaseMsg tryCreateRecalledMsgShadow = A.tryCreateRecalledMsgShadow();
                    if (tryCreateRecalledMsgShadow != null) {
                        o(j).remove(tryCreateRecalledMsgShadow);
                        return A;
                    }
                    return baseSysMsg;
                }
                if (!z2) {
                    x(chatMsg);
                }
                return null;
            } else if (z) {
                return null;
            } else {
                return z(j, chatMsg);
            }
        }
        return (BaseMsg) invokeCommon.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.b.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                sizedSyncTreeSet = new SizedSyncTreeSet<>(600, new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                sizedSyncTreeSet.setCallback(new c(this, j));
            }
            this.b.put(Long.valueOf(j), sizedSyncTreeSet);
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            Iterator<BaseMsg> descendingIterator = o(j).descendingIterator();
            while (descendingIterator.hasNext()) {
                BaseMsg next = descendingIterator.next();
                if (next.getSdkMsg().getMsgType() != 10000) {
                    return next;
                }
            }
            return null;
        }
        return (BaseMsg) invokeJ.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> s(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.c.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                sizedSyncTreeSet = new SizedSyncTreeSet<>(new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
            }
            this.c.put(Long.valueOf(j), sizedSyncTreeSet);
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @NonNull
    public final BaseMsg z(long j, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048601, this, j, chatMsg)) == null) {
            CommonMsgField commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setRoomId(j);
            commonMsgField.setUserId(Long.parseLong(chatMsg.getSenderUid()));
            commonMsgField.setUserName(chatMsg.getNickName());
            commonMsgField.setPortrait(chatMsg.getPortrait());
            if (commonMsgField.getContent() == null) {
                commonMsgField.setContent(new HashMap());
            }
            BaseChatMsg baseChatMsg = (BaseChatMsg) DataExt.toEntity(commonMsgField.getContent(), this.a.get(commonMsgField.getType()));
            baseChatMsg.fromSdkMsg(chatMsg);
            baseChatMsg.setCommonMsgField(commonMsgField);
            baseChatMsg.setSdkMsg(chatMsg);
            return baseChatMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }
}
