package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ak4;
import com.baidu.tieba.qj4;
import com.baidu.tieba.xj4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class m72 implements qi2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b(int i);

        void c();
    }

    /* loaded from: classes5.dex */
    public static class a extends qb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ b b;
        public final /* synthetic */ Map c;

        public a(b bVar, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bVar;
            this.c = map;
            this.a = false;
        }

        @Override // com.baidu.tieba.qb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                b bVar = this.b;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.tieba.qb2
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                i();
                b bVar = this.b;
                if (bVar != null && !this.a) {
                    bVar.a();
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                for (String str : this.c.keySet()) {
                    j(str);
                }
            }
        }

        @Override // com.baidu.tieba.qb2
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.b(i);
                b bVar = this.b;
                if (bVar != null) {
                    if (i == 1010) {
                        bVar.a();
                    } else {
                        bVar.b(3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qb2
        public void c(@NonNull qj4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                super.c(aVar);
                j(aVar.b);
                mc2.c(aVar.b);
            }
        }

        @Override // com.baidu.tieba.qb2
        public void f(qh4 qh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, qh4Var) == null) {
                super.f(qh4Var);
                if (qh4Var.a != 1010) {
                    this.a = true;
                    b bVar = this.b;
                    if (bVar != null) {
                        bVar.b(3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qb2
        public void g(@NonNull wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, wh4Var) == null) {
                super.g(wh4Var);
                j(wh4Var.o);
            }
        }

        public final void j(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.c.containsKey(str)) {
                Set<String> set = (Set) this.c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        mc2.d(str, str2);
                    }
                    return;
                }
                mc2.c(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925505, "Lcom/baidu/tieba/m72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925505, "Lcom/baidu/tieba/m72;");
                return;
            }
        }
        a = gp1.a;
    }

    public static void a(@NonNull List<ak4.b> list, @Nullable String str, b bVar) {
        String[] i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, bVar) == null) {
            if (!c(kh3.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
                if (bVar != null) {
                    bVar.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (ak4.b bVar2 : list) {
                if (bVar2 != null) {
                    if (bVar2.i() != null && bVar2.i().length != 0) {
                        Set set = (Set) hashMap.get(bVar2.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z = false;
                        for (String str2 : bVar2.i()) {
                            if (mc2.f(bVar2.b(), str2) && !z) {
                                arrayList.add(bVar2);
                                z = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar2.b(), set);
                    } else if (mc2.e(bVar2.b())) {
                        arrayList.add(bVar2);
                        hashMap.put(bVar2.b(), null);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                if (a) {
                    Log.i("SwanPreDownload", "preDownload list empty");
                }
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            ak4 ak4Var = new ak4(arrayList, um3.b());
            ak4Var.e(str);
            ak4Var.d("1");
            tb2 tb2Var = new tb2(new a(bVar, hashMap));
            tb2Var.L(cc2.a(str));
            gg4.f(ak4Var, tb2Var);
        }
    }

    public static void b(@NonNull List<xj4.a> list, @NonNull String str, @NonNull qb2 qb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, qb2Var) == null) {
            if (!c(kh3.a().getString("predownload_network_switch", "1"))) {
                qb2Var.b(6);
                return;
            }
            List<xj4.a> i = mc2.i(list);
            if (i.isEmpty()) {
                qb2Var.d();
                return;
            }
            xj4 xj4Var = new xj4((List<? extends xj4.a>) i, (zl4) um3.b());
            xj4Var.d("1");
            xj4Var.e(str);
            tb2 tb2Var = new tb2(qb2Var);
            tb2Var.L(cc2.a(str));
            gg4.f(xj4Var, tb2Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.j(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            boolean z = true;
            if (!TextUtils.equals(str, "0")) {
                if (!TextUtils.equals(str, "1")) {
                    TextUtils.equals(str, "2");
                    z = false;
                }
                if (a) {
                    Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
                }
                return z;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
                return true;
            }
            ds2.g0().getSwitch("swan_game_feed_predownload", 0);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, bVar) == null) {
            ak4.b bVar2 = new ak4.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar2.l(new String[]{str2});
            }
            a(Collections.singletonList(bVar2), str3, bVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download swanAppId invalid");
                }
            } else if (!c(kh3.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new xj4.a(str));
                List<xj4.a> i = mc2.i(arrayList);
                if (i.isEmpty()) {
                    if (a) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                xj4 xj4Var = new xj4((List<? extends xj4.a>) i, (zl4) um3.b());
                xj4Var.e(str2);
                xj4Var.d("1");
                tb2 tb2Var = new tb2();
                tb2Var.L(cc2.a(str2));
                gg4.f(xj4Var, tb2Var);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, bVar}) == null) {
            if (a) {
                Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
            }
            if (z) {
                if (bVar != null) {
                    bVar.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.c();
                }
            } else if (!d(str2)) {
                if (bVar != null) {
                    bVar.b(6);
                }
            } else {
                String str5 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        Uri parse = Uri.parse(str4);
                        if (parse != null) {
                            str5 = om3.n(str, parse, false);
                        }
                    } catch (Exception e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                e(str, str5, str3, bVar);
            }
        }
    }
}
