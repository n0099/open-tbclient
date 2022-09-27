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
import com.baidu.tieba.ev1;
import com.baidu.tieba.ke4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class sy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ev1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;

        public a(hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz2Var;
        }

        @Override // com.baidu.tieba.ev1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sy2.r(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;

        public b(hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sy2.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements x42<Boolean> {
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
        @Override // com.baidu.tieba.x42
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                dz2.b("download plugin result = " + bool);
                ez2.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948167677, "Lcom/baidu/tieba/sy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948167677, "Lcom/baidu/tieba/sy2;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void c(hz2 hz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hz2Var) == null) {
            if (hz2Var != null && hz2Var.a()) {
                String str = hz2Var.a;
                String str2 = hz2Var.b;
                long j = hz2Var.c;
                va4.g(new oe4(str, str2, j, hz2Var.d), new ry2(str, str2, j, new c(str)));
                return;
            }
            dz2.b("plugin is invalid");
        }
    }

    public static File d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.startsWith("__dep__")) {
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
                String i = jz2.i("dependenciesPath", null);
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
                    dz2.b(Log.getStackTraceString(e));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static List<ec4> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<fz2> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = do2.b(hm2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (fz2 fz2Var : b2.k.a) {
                ec4 ec4Var = new ec4();
                ec4Var.a = fz2Var.a;
                ec4Var.b = fz2Var.g;
                ec4Var.c = fz2Var.c;
                ec4Var.e = fz2Var.i;
                ec4Var.d = fz2Var.h;
                arrayList.add(ec4Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static String f(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.startsWith("__dep__")) {
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
                String i = jz2.i("dependenciesConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    dz2.b(Log.getStackTraceString(e));
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
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static File g(@Nullable mc4 mc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mc4Var)) == null) {
            if (mc4Var == null) {
                return null;
            }
            File t = hm2.t(mc4Var.g, String.valueOf(mc4Var.i));
            return (t == null || !t.exists()) ? hm2.t(mc4Var.g, String.valueOf(ah3.c(mc4Var.j))) : t;
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
            if (str.startsWith("__dynamicLib__")) {
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
                String i = jz2.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    dz2.b(Log.getStackTraceString(e));
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
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static Set<ke4.a> i(PMSAppInfo pMSAppInfo) {
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

    public static Set<ke4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<ec4> l = wa4.b().l(str, j);
            if (l == null || l.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (ec4 ec4Var : l) {
                if (!ec4Var.b && rg4.b(ec4Var.a, ec4Var.d, ec4Var.e, arrayList) == null) {
                    ke4.a aVar = new ke4.a(ec4Var.a);
                    aVar.f(ec4Var.d, ec4Var.e);
                    hashSet.add(aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                ib4.i().g(arrayList);
            }
            return hashSet;
        }
        return (Set) invokeLJ.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return (TextUtils.isEmpty(h(str)) && TextUtils.isEmpty(f(str))) ? false : true;
        }
        return invokeL.booleanValue;
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
                    dz2.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<hz2> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (be2.m()) {
                    Iterator<hz2> it = i.iterator();
                    while (it.hasNext()) {
                        hz2 next = it.next();
                        Pair<Boolean, File> i2 = be2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            l02.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                jz2.c("dynamicLibPath", jSONObject3);
                jz2.c("dynamicLibConfig", jSONObject4);
                return;
            }
            jz2.c("dynamicLibPath", null);
            jz2.c("dynamicLibConfig", null);
            if (a) {
                dz2.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<hz2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        hz2 hz2Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) || list == null || list.size() == 0) {
            return;
        }
        List<mc4> w = ib4.i().w(jz2.d(list));
        for (hz2 hz2Var2 : list) {
            File file2 = null;
            try {
                hz2Var = (hz2) hz2Var2.clone();
            } catch (CloneNotSupportedException e) {
                if (a) {
                    dz2.b(Log.getStackTraceString(e));
                }
                hz2Var = hz2Var2;
            }
            long j3 = 0;
            if (w != null) {
                j = 0;
                boolean z4 = false;
                z3 = true;
                boolean z5 = false;
                for (mc4 mc4Var : w) {
                    if (hz2Var2.a.equals(mc4Var.g)) {
                        dz2.b("pluginName = " + hz2Var2.a + " latestPlugin versionCode = " + mc4Var.i + " cur model versionCode = " + hz2Var2.c);
                        long j4 = hz2Var2.c;
                        if (j4 >= j3) {
                            c2 = mc4Var.i;
                        } else {
                            c2 = ah3.c(mc4Var.j);
                            j4 = ah3.c(hz2Var2.b);
                        }
                        if (c2 > j4) {
                            file2 = g(mc4Var);
                            z5 = true;
                        }
                        if (z5) {
                            hz2Var.b = mc4Var.j;
                            hz2Var.c = mc4Var.i;
                        }
                        if (!mc4Var.c()) {
                            dz2.b("plugin is new, not yet expired");
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
            if (z2) {
                j2 = j;
            } else {
                long j5 = hz2Var2.c;
                if (j5 < 0) {
                    j5 = ah3.c(hz2Var2.b);
                }
                j2 = j5;
            }
            o(jSONObject, jSONObject2, file, hz2Var2, j2);
            if (z3 && z) {
                s(hz2Var);
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, hz2 hz2Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, hz2Var, Long.valueOf(j)}) == null) || jSONObject == null || jSONObject2 == null || hz2Var == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (a) {
                dz2.b("apply path in workspace, name = " + hz2Var.a);
            }
        } else {
            str = hz2Var.e;
            if (a) {
                dz2.b("apply path inner swan app, name = " + hz2Var.a);
            }
        }
        try {
            jSONObject.put(hz2Var.a, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(hz2Var.f)) {
                return;
            }
            File file2 = new File(str, hz2Var.f);
            if (file2.exists()) {
                String E = pj4.E(file2);
                if (a) {
                    dz2.b("pages info = " + E);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("config", new JSONObject(E));
                jSONObject3.put(PushManager.APP_VERSION_CODE, j);
                jSONObject2.put(hz2Var.a, jSONObject3);
            }
        } catch (JSONException e) {
            if (a) {
                dz2.b(Log.getStackTraceString(e));
            }
        }
    }

    public static mc4 p(String str, String str2, long j) {
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
            } else if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str};
                str3 = "bundle_id = ? ";
            } else {
                String[] strArr2 = {str, str2};
                str3 = "bundle_id = ?  and version_name = ? ";
                strArr = strArr2;
            }
            List<mc4> r = ib4.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (mc4) invokeCommon.objValue;
    }

    public static List<mc4> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ib4.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(hz2 hz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, hz2Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(hz2Var), "requestDynamicLib", 2);
        }
    }

    public static void s(hz2 hz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, hz2Var) == null) {
            xu1.d().c(new ev1(new a(hz2Var)));
        }
    }
}
