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
import com.baidu.tieba.cm4;
import com.baidu.tieba.w22;
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
/* loaded from: classes6.dex */
public class k63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements w22.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z63 a;

        public a(z63 z63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z63Var;
        }

        @Override // com.baidu.tieba.w22.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k63.r(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z63 a;

        public b(z63 z63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k63.c(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements pc2<Boolean> {
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
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                v63.b("download plugin result = " + bool);
                w63.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864993, "Lcom/baidu/tieba/k63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864993, "Lcom/baidu/tieba/k63;");
                return;
            }
        }
        a = nr1.a;
    }

    public static Set<cm4.a> i(PMSAppInfo pMSAppInfo) {
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

    public static List<ek4> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return aj4.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(z63 z63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, z63Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(z63Var), "requestDynamicLib", 2);
        }
    }

    public static void s(z63 z63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, z63Var) == null) {
            p22.d().c(new w22(new a(z63Var)));
        }
    }

    public static void c(z63 z63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, z63Var) == null) {
            if (z63Var != null && z63Var.a()) {
                String str = z63Var.a;
                String str2 = z63Var.b;
                long j = z63Var.c;
                ni4.g(new gm4(str, str2, j, z63Var.d), new j63(str, str2, j, new c(str)));
                return;
            }
            v63.b("plugin is invalid");
        }
    }

    public static File g(@Nullable ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, ek4Var)) == null) {
            if (ek4Var == null) {
                return null;
            }
            File t = zt2.t(ek4Var.g, String.valueOf(ek4Var.i));
            if (t == null || !t.exists()) {
                return zt2.t(ek4Var.g, String.valueOf(so3.c(ek4Var.j)));
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
            String i = b73.i("dependenciesPath", null);
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
                v63.b(Log.getStackTraceString(e));
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
            String i = b73.i("dynamicLibConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                v63.b(Log.getStackTraceString(e));
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

    public static List<wj4> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<x63> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = vv2.b(zt2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (x63 x63Var : b2.k.a) {
                wj4 wj4Var = new wj4();
                wj4Var.a = x63Var.a;
                wj4Var.b = x63Var.g;
                wj4Var.c = x63Var.c;
                wj4Var.e = x63Var.i;
                wj4Var.d = x63Var.h;
                arrayList.add(wj4Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static Set<cm4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<wj4> l = oi4.b().l(str, j);
            if (l != null && !l.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (wj4 wj4Var : l) {
                    if (!wj4Var.b && jo4.b(wj4Var.a, wj4Var.d, wj4Var.e, arrayList) == null) {
                        cm4.a aVar = new cm4.a(wj4Var.a);
                        aVar.f(wj4Var.d, wj4Var.e);
                        hashSet.add(aVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    aj4.i().g(arrayList);
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
            String i = b73.i("dependenciesConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                v63.b(Log.getStackTraceString(e));
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
                    v63.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<z63> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (tl2.m()) {
                    Iterator<z63> it = i.iterator();
                    while (it.hasNext()) {
                        z63 next = it.next();
                        Pair<Boolean, File> i2 = tl2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            d82.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                b73.c("dynamicLibPath", jSONObject3);
                b73.c("dynamicLibConfig", jSONObject4);
                return;
            }
            b73.c("dynamicLibPath", null);
            b73.c("dynamicLibConfig", null);
            if (a) {
                v63.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<z63> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        z63 z63Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            List<ek4> w = aj4.i().w(b73.d(list));
            for (z63 z63Var2 : list) {
                File file2 = null;
                try {
                    z63Var = (z63) z63Var2.clone();
                } catch (CloneNotSupportedException e) {
                    if (a) {
                        v63.b(Log.getStackTraceString(e));
                    }
                    z63Var = z63Var2;
                }
                long j3 = 0;
                if (w != null) {
                    j = 0;
                    boolean z4 = false;
                    z3 = true;
                    boolean z5 = false;
                    for (ek4 ek4Var : w) {
                        if (z63Var2.a.equals(ek4Var.g)) {
                            v63.b("pluginName = " + z63Var2.a + " latestPlugin versionCode = " + ek4Var.i + " cur model versionCode = " + z63Var2.c);
                            long j4 = z63Var2.c;
                            if (j4 >= j3) {
                                c2 = ek4Var.i;
                            } else {
                                c2 = so3.c(ek4Var.j);
                                j4 = so3.c(z63Var2.b);
                            }
                            if (c2 > j4) {
                                file2 = g(ek4Var);
                                z5 = true;
                            }
                            if (z5) {
                                z63Var.b = ek4Var.j;
                                z63Var.c = ek4Var.i;
                            }
                            if (!ek4Var.c()) {
                                v63.b("plugin is new, not yet expired");
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
                    long j5 = z63Var2.c;
                    if (j5 < 0) {
                        j5 = so3.c(z63Var2.b);
                    }
                    j2 = j5;
                } else {
                    j2 = j;
                }
                o(jSONObject, jSONObject2, file, z63Var2, j2);
                if (z3 && z) {
                    s(z63Var);
                }
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, z63 z63Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, z63Var, Long.valueOf(j)}) == null) && jSONObject != null && jSONObject2 != null && z63Var != null) {
            if (file != null && file.exists()) {
                str = file.getAbsolutePath();
                if (a) {
                    v63.b("apply path in workspace, name = " + z63Var.a);
                }
            } else {
                str = z63Var.e;
                if (a) {
                    v63.b("apply path inner swan app, name = " + z63Var.a);
                }
            }
            try {
                jSONObject.put(z63Var.a, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(z63Var.f)) {
                    File file2 = new File(str, z63Var.f);
                    if (file2.exists()) {
                        String E = hr4.E(file2);
                        if (a) {
                            v63.b("pages info = " + E);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(E));
                        jSONObject3.put(PushService.APP_VERSION_CODE, j);
                        jSONObject2.put(z63Var.a, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                if (a) {
                    v63.b(Log.getStackTraceString(e));
                }
            }
        }
    }

    public static ek4 p(String str, String str2, long j) {
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
            List<ek4> r = aj4.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (ek4) invokeCommon.objValue;
    }
}
