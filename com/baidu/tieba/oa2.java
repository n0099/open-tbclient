package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.cn4;
import com.baidu.tieba.sm4;
import com.baidu.tieba.zm4;
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
/* loaded from: classes7.dex */
public final class oa2 implements sl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b(int i);

        void c();
    }

    /* loaded from: classes7.dex */
    public static class a extends se2 {
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

        @Override // com.baidu.tieba.se2
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

        @Override // com.baidu.tieba.se2
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

        @Override // com.baidu.tieba.se2
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

        @Override // com.baidu.tieba.se2
        public void c(@NonNull sm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                super.c(aVar);
                j(aVar.b);
                of2.c(aVar.b);
            }
        }

        @Override // com.baidu.tieba.se2
        public void f(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sk4Var) == null) {
                super.f(sk4Var);
                if (sk4Var.a != 1010) {
                    this.a = true;
                    b bVar = this.b;
                    if (bVar != null) {
                        bVar.b(3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.se2
        public void g(@NonNull yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, yk4Var) == null) {
                super.g(yk4Var);
                j(yk4Var.o);
            }
        }

        public final void j(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.c.containsKey(str)) {
                Set<String> set = (Set) this.c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        of2.d(str, str2);
                    }
                    return;
                }
                of2.c(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948025449, "Lcom/baidu/tieba/oa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948025449, "Lcom/baidu/tieba/oa2;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a(@NonNull List<cn4.b> list, @Nullable String str, b bVar) {
        String[] i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, bVar) == null) {
            if (!c(mk3.a().getString("predownload_network_switch", "1"))) {
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
            for (cn4.b bVar2 : list) {
                if (bVar2 != null) {
                    if (bVar2.i() != null && bVar2.i().length != 0) {
                        Set set = (Set) hashMap.get(bVar2.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z = false;
                        for (String str2 : bVar2.i()) {
                            if (of2.f(bVar2.b(), str2) && !z) {
                                arrayList.add(bVar2);
                                z = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar2.b(), set);
                    } else if (of2.e(bVar2.b())) {
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
            cn4 cn4Var = new cn4(arrayList, wp3.b());
            cn4Var.e(str);
            cn4Var.d("1");
            ve2 ve2Var = new ve2(new a(bVar, hashMap));
            ve2Var.L(ef2.a(str));
            ij4.f(cn4Var, ve2Var);
        }
    }

    public static void b(@NonNull List<zm4.a> list, @NonNull String str, @NonNull se2 se2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, se2Var) == null) {
            if (!c(mk3.a().getString("predownload_network_switch", "1"))) {
                se2Var.b(6);
                return;
            }
            List<zm4.a> i = of2.i(list);
            if (i.isEmpty()) {
                se2Var.d();
                return;
            }
            zm4 zm4Var = new zm4((List<? extends zm4.a>) i, (bp4) wp3.b());
            zm4Var.d("1");
            zm4Var.e(str);
            ve2 ve2Var = new ve2(se2Var);
            ve2Var.L(ef2.a(str));
            ij4.f(zm4Var, ve2Var);
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
            fv2.g0().getSwitch("swan_game_feed_predownload", 0);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, bVar) == null) {
            cn4.b bVar2 = new cn4.b(str);
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
            } else if (!c(mk3.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new zm4.a(str));
                List<zm4.a> i = of2.i(arrayList);
                if (i.isEmpty()) {
                    if (a) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                zm4 zm4Var = new zm4((List<? extends zm4.a>) i, (bp4) wp3.b());
                zm4Var.e(str2);
                zm4Var.d("1");
                ve2 ve2Var = new ve2();
                ve2Var.L(ef2.a(str2));
                ij4.f(zm4Var, ve2Var);
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
                            str5 = qp3.n(str, parse, false);
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
