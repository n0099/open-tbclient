package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ey1;
import com.baidu.tieba.jh4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class r13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements ey1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g23 a;

        public a(g23 g23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g23Var;
        }

        @Override // com.baidu.tieba.ey1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r13.r(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g23 a;

        public b(g23 g23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g23Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r13.c(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements w72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c23.b("download plugin result = " + bool);
                d23.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068725, "Lcom/baidu/tieba/r13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068725, "Lcom/baidu/tieba/r13;");
                return;
            }
        }
        a = vm1.a;
    }

    public static Set<jh4.a> i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return null;
            }
            return j(pMSAppInfo.appId, pMSAppInfo.versionCode);
        }
        return (Set) invokeL.objValue;
    }

    public static List<lf4> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return he4.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(g23 g23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, g23Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(g23Var), "requestDynamicLib", 2);
        }
    }

    public static void s(g23 g23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, g23Var) == null) {
            xx1.d().c(new ey1(new a(g23Var)));
        }
    }

    public static void c(g23 g23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, g23Var) == null) {
            if (g23Var != null && g23Var.a()) {
                String str = g23Var.a;
                String str2 = g23Var.b;
                long j = g23Var.c;
                ud4.g(new nh4(str, str2, j, g23Var.d), new q13(str, str2, j, new c(str)));
                return;
            }
            c23.b("plugin is invalid");
        }
    }

    public static File g(@Nullable lf4 lf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lf4Var)) == null) {
            if (lf4Var == null) {
                return null;
            }
            File t = gp2.t(lf4Var.g, String.valueOf(lf4Var.i));
            if (t == null || !t.exists()) {
                return gp2.t(lf4Var.g, String.valueOf(zj3.c(lf4Var.j)));
            }
            return t;
        }
        return (File) invokeL.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (TextUtils.isEmpty(h(str)) && TextUtils.isEmpty(f(str))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static File d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!str.startsWith("__dep__")) {
                return null;
            }
            String[] split = str.split("/");
            if (split.length < 2) {
                return null;
            }
            String str2 = split[1];
            int indexOf = str.indexOf(str2) + str2.length() + 1;
            if (indexOf >= str.length()) {
                return null;
            }
            String substring = str.substring(indexOf);
            String i = i23.i("dependenciesPath", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                String optString = new JSONObject(i).optString(str2);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                return new File(optString, substring + ".json");
            } catch (JSONException e) {
                c23.b(Log.getStackTraceString(e));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static String h(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (!str.startsWith("__dynamicLib__")) {
                return null;
            }
            String[] split = str.split("/");
            if (split.length < 2) {
                return null;
            }
            String str2 = split[1];
            int indexOf = str.indexOf(str2) + str2.length() + 1;
            if (indexOf >= str.length()) {
                return null;
            }
            String substring = str.substring(indexOf);
            String i = i23.i("dynamicLibConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                c23.b(Log.getStackTraceString(e));
            }
            if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject("config")) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.equals(substring, optJSONArray.optString(i2))) {
                        return str;
                    }
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static List<df4> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<e23> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = cr2.b(gp2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e23 e23Var : b2.k.a) {
                df4 df4Var = new df4();
                df4Var.a = e23Var.a;
                df4Var.b = e23Var.g;
                df4Var.c = e23Var.c;
                df4Var.e = e23Var.i;
                df4Var.d = e23Var.h;
                arrayList.add(df4Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static Set<jh4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<df4> l = vd4.b().l(str, j);
            if (l != null && !l.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (df4 df4Var : l) {
                    if (!df4Var.b && qj4.b(df4Var.a, df4Var.d, df4Var.e, arrayList) == null) {
                        jh4.a aVar = new jh4.a(df4Var.a);
                        aVar.f(df4Var.d, df4Var.e);
                        hashSet.add(aVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    he4.i().g(arrayList);
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeLJ.objValue;
    }

    public static String f(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!str.startsWith("__dep__")) {
                return null;
            }
            String[] split = str.split("/");
            if (split.length < 2) {
                return null;
            }
            String str2 = split[1];
            int indexOf = str.indexOf(str2) + str2.length() + 1;
            if (indexOf >= str.length()) {
                return null;
            }
            String substring = str.substring(indexOf);
            String i = i23.i("dependenciesConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                c23.b(Log.getStackTraceString(e));
            }
            if (optJSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
            if (l(substring, optJSONArray)) {
                return str;
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("module");
            if (optJSONObject3 == null || (optJSONObject2 = optJSONObject3.optJSONObject("paths")) == null) {
                return null;
            }
            Iterator<String> keys = optJSONObject2.keys();
            String str3 = null;
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null) {
                    if (substring.startsWith(next)) {
                        if (str3 != null && next.length() <= str3.length()) {
                        }
                        str3 = next;
                    }
                }
            }
            if (str3 == null) {
                return null;
            }
            String replaceFirst = substring.replaceFirst(str3, optJSONObject2.optString(str3));
            if (l(replaceFirst, optJSONArray)) {
                return str.replace(substring, replaceFirst);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean l(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    if (TextUtils.equals(str, jSONArray.optString(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(SwanAppConfigData swanAppConfigData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, swanAppConfigData, z) == null) {
            if (swanAppConfigData == null) {
                if (a) {
                    c23.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<g23> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (ah2.m()) {
                    Iterator<g23> it = i.iterator();
                    while (it.hasNext()) {
                        g23 next = it.next();
                        Pair<Boolean, File> i2 = ah2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            k32.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                i23.c("dynamicLibPath", jSONObject3);
                i23.c("dynamicLibConfig", jSONObject4);
                return;
            }
            i23.c("dynamicLibPath", null);
            i23.c("dynamicLibConfig", null);
            if (a) {
                c23.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<g23> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        g23 g23Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            List<lf4> w = he4.i().w(i23.d(list));
            for (g23 g23Var2 : list) {
                File file2 = null;
                try {
                    g23Var = (g23) g23Var2.clone();
                } catch (CloneNotSupportedException e) {
                    if (a) {
                        c23.b(Log.getStackTraceString(e));
                    }
                    g23Var = g23Var2;
                }
                long j3 = 0;
                if (w != null) {
                    j = 0;
                    boolean z4 = false;
                    z3 = true;
                    boolean z5 = false;
                    for (lf4 lf4Var : w) {
                        if (g23Var2.a.equals(lf4Var.g)) {
                            c23.b("pluginName = " + g23Var2.a + " latestPlugin versionCode = " + lf4Var.i + " cur model versionCode = " + g23Var2.c);
                            long j4 = g23Var2.c;
                            if (j4 >= j3) {
                                c2 = lf4Var.i;
                            } else {
                                c2 = zj3.c(lf4Var.j);
                                j4 = zj3.c(g23Var2.b);
                            }
                            if (c2 > j4) {
                                file2 = g(lf4Var);
                                z5 = true;
                            }
                            if (z5) {
                                g23Var.b = lf4Var.j;
                                g23Var.c = lf4Var.i;
                            }
                            if (!lf4Var.c()) {
                                c23.b("plugin is new, not yet expired");
                                z3 = false;
                            }
                            j = Math.max(c2, j4);
                            j3 = 0;
                            z4 = true;
                        }
                    }
                    file = file2;
                    z2 = z4;
                } else {
                    file = null;
                    z2 = false;
                    z3 = true;
                    j = 0;
                }
                if (!z2) {
                    long j5 = g23Var2.c;
                    if (j5 < 0) {
                        j5 = zj3.c(g23Var2.b);
                    }
                    j2 = j5;
                } else {
                    j2 = j;
                }
                o(jSONObject, jSONObject2, file, g23Var2, j2);
                if (z3 && z) {
                    s(g23Var);
                }
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, g23 g23Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, g23Var, Long.valueOf(j)}) == null) && jSONObject != null && jSONObject2 != null && g23Var != null) {
            if (file != null && file.exists()) {
                str = file.getAbsolutePath();
                if (a) {
                    c23.b("apply path in workspace, name = " + g23Var.a);
                }
            } else {
                str = g23Var.e;
                if (a) {
                    c23.b("apply path inner swan app, name = " + g23Var.a);
                }
            }
            try {
                jSONObject.put(g23Var.a, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(g23Var.f)) {
                    File file2 = new File(str, g23Var.f);
                    if (file2.exists()) {
                        String E = nm4.E(file2);
                        if (a) {
                            c23.b("pages info = " + E);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(E));
                        jSONObject3.put(PushService.APP_VERSION_CODE, j);
                        jSONObject2.put(g23Var.a, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                if (a) {
                    c23.b(Log.getStackTraceString(e));
                }
            }
        }
    }

    public static lf4 p(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String[] strArr;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (j >= 0) {
                strArr = new String[]{str, String.valueOf(j)};
                str3 = "bundle_id = ?  and version_code = ? ";
            } else if (!TextUtils.isEmpty(str2)) {
                String[] strArr2 = {str, str2};
                str3 = "bundle_id = ?  and version_name = ? ";
                strArr = strArr2;
            } else {
                strArr = new String[]{str};
                str3 = "bundle_id = ? ";
            }
            List<lf4> r = he4.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (lf4) invokeCommon.objValue;
    }
}
