package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.bl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class rj2 implements vr1, bl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;
    public final String b;
    public uj2 c;
    public qj2 d;
    public ws1 e;
    public AtomicInteger f;
    public CopyOnWriteArrayList<String> g;
    public zj2 h;

    /* loaded from: classes7.dex */
    public interface d extends pj2 {
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj2 a;

        public a(rj2 rj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ou2.h0().c(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ bl2.b c;
        public final /* synthetic */ rj2 d;

        public b(rj2 rj2Var, List list, boolean z, bl2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj2Var, list, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rj2Var;
            this.a = list;
            this.b = z;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.h(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            HashSet hashSet;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    hashSet = lp3.a(bundle.getStringArray("key_exclude_ids"));
                    z = bundle.getBoolean("key_force_clean");
                    i = bundle.getInt("key_clean_scenes_type");
                } else {
                    hashSet = null;
                    i = 0;
                    z = false;
                }
                rj2 d = tj2.c().d();
                cl2 l = cl2.l();
                l.i(i);
                d.t(hashSet, z, l.k());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948123471, "Lcom/baidu/tieba/rj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948123471, "Lcom/baidu/tieba/rj2;");
                return;
            }
        }
        i = rr1.a;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(k());
        }
    }

    public final Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return c(100);
        }
        return (Set) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f.get() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            s(r());
        }
    }

    public final Set<String> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return c(103);
        }
        return (Set) invokeV.objValue;
    }

    public rj2(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = ProcessUtils.getCurProcessName();
        this.a = dVar;
        ExecutorUtilsExt.postOnElastic(new a(this), "addLoginStatusChangedListener", 2);
        this.f = new AtomicInteger(0);
        this.g = new CopyOnWriteArrayList<>();
        this.e = pu2.m();
        this.c = new uj2();
        ws1 ws1Var = this.e;
        if (ws1Var != null) {
            this.d = ws1Var.b();
        }
        this.h = new zj2();
        if (i) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    public final Set<String> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HashSet hashSet = new HashSet();
            LinkedHashSet<g83> q = i83.k().q();
            if (q.size() < 1) {
                return hashSet;
            }
            Iterator<g83> it = q.iterator();
            while (it.hasNext()) {
                g83 next = it.next();
                if (next.T() && (next.E() || next.Q())) {
                    hashSet.add(next.getAppId());
                    if (i) {
                        Log.i("SwanAppPurger", "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    x73 e = x73.e();
                    z73 z73Var = new z73(i2);
                    z73Var.b(next.b);
                    e.h(z73Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    @Override // com.baidu.tieba.vr1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String h = ou2.h0().h(this.a.a());
            if (i) {
                Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
                Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + h + ")  -> " + z);
            }
            if (z) {
                q();
            } else {
                j();
            }
        }
    }

    public final void l(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, set) == null) {
            zj3.j().g("aiapp_", set, true);
            String w = pi3.w();
            if (!TextUtils.isEmpty(w)) {
                lr4.k(w);
            }
            String y = pi3.y();
            if (!TextUtils.isEmpty(y)) {
                lr4.k(y);
            }
            String n = du2.n();
            if (!TextUtils.isEmpty(n)) {
                lr4.k(n);
            }
            ws1 ws1Var = this.e;
            if (ws1Var != null) {
                ws1Var.g();
                this.e.c();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.add(str);
    }

    public boolean n(Map<String, PMSAppInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, map)) == null) {
            if (map == null || map.size() <= 0) {
                return false;
            }
            if (map.size() == 1 && map.containsKey("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            zj3.j().g("aiapp_setting_", set, true);
        }
    }

    public final void d(String str, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            cl2.m(bVar).b(str);
            this.c.a(str);
            qj2 qj2Var = this.d;
            if (qj2Var != null) {
                qj2Var.a(str);
            }
            xe2.n(str);
        }
    }

    public void e(@Nullable String str, boolean z, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), bVar}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, bVar);
    }

    public void f(@Nullable List<String> list, boolean z, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), bVar}) == null) && list != null && !list.isEmpty()) {
            g(list, true, z, bVar);
        }
    }

    public void t(@Nullable Set<String> set, boolean z, bl2.b bVar) {
        zj2 zj2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{set, Boolean.valueOf(z), bVar}) == null) && (zj2Var = this.h) != null) {
            zj2Var.i(set, z, bVar);
        }
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), bVar}) == null) {
            if (!ProcessUtils.isMainProcess()) {
                if (i) {
                    Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                    return;
                }
                return;
            }
            h82.l("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
            if (z2) {
                i(list);
            }
            if (list != null && !list.isEmpty()) {
                o(list);
                ExecutorUtilsExt.postOnSerial(new b(this, list, z, bVar), "deleteSwanApp");
            }
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), bVar}) == null) {
            if (list == null) {
                if (i) {
                    Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                    return;
                }
                return;
            }
            this.f.incrementAndGet();
            if (z) {
                h82.k("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                this.c.g(list);
                int size = list.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = j32.a(list.get(i2));
                }
                mi2.b(strArr);
            }
            h82.k("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
            this.c.e(list);
            for (String str : list) {
                if (!this.g.contains(str) && !TextUtils.isEmpty(str)) {
                    if (i) {
                        Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                    }
                    h82.k("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                    p(str, bVar);
                } else {
                    h82.k("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                }
            }
            if (this.f.decrementAndGet() <= 0) {
                this.f.set(0);
                this.g.clear();
                wj2.a();
            }
            cl2.m(bVar).j();
        }
    }

    public final void i(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && !list.isEmpty()) {
            List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : i2) {
                hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
            }
            Set<String> i3 = ki2.i(AppRuntime.getAppContext().getContentResolver());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean contains = i3.contains(next);
                boolean containsKey = hashMap.containsKey(next);
                if (!contains && !containsKey) {
                    if (rr1.a) {
                        Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                    }
                } else {
                    if (rr1.a) {
                        Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
                    }
                    it.remove();
                }
            }
        }
    }

    public void o(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, list) == null) && list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                pj3 a2 = vj3.a();
                a2.putInt("bookshelf_insert" + it.next(), 0);
            }
        }
    }

    public final void p(String str, bl2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, bVar) == null) {
            if (xj2.a() && du2.f().contains(str)) {
                h82.k("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
            } else if (wj2.c(str)) {
                h82.k("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
            } else {
                d(str, bVar);
                h82.k("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                this.c.f(str);
                h82.k("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                this.c.d(str);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "Process<" + this.b + "> " + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{set, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (ProcessUtils.isMainProcess()) {
                cl2 l = cl2.l();
                l.i(i2);
                t(set, z, l.k());
                return;
            }
            Bundle bundle = new Bundle();
            if (set != null && set.size() > 0) {
                bundle.putStringArray("key_exclude_ids", (String[]) set.toArray(new String[0]));
            }
            bundle.putBoolean("key_force_clean", z);
            bundle.putInt("key_clean_scenes_type", i2);
            u73.c(c.class, bundle);
        }
    }
}
