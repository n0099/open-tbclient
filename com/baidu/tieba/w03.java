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
import com.baidu.tieba.jx1;
import com.baidu.tieba.og4;
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
public class w03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements jx1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l13 a;

        public a(l13 l13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l13Var;
        }

        @Override // com.baidu.tieba.jx1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w03.r(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l13 a;

        public b(l13 l13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w03.c(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements b72<Boolean> {
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
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                h13.b("download plugin result = " + bool);
                i13.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216719, "Lcom/baidu/tieba/w03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216719, "Lcom/baidu/tieba/w03;");
                return;
            }
        }
        a = am1.a;
    }

    public static Set<og4.a> i(PMSAppInfo pMSAppInfo) {
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

    public static List<qe4> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return md4.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(l13 l13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, l13Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(l13Var), "requestDynamicLib", 2);
        }
    }

    public static void s(l13 l13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, l13Var) == null) {
            cx1.d().c(new jx1(new a(l13Var)));
        }
    }

    public static void c(l13 l13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, l13Var) == null) {
            if (l13Var != null && l13Var.a()) {
                String str = l13Var.a;
                String str2 = l13Var.b;
                long j = l13Var.c;
                zc4.g(new sg4(str, str2, j, l13Var.d), new v03(str, str2, j, new c(str)));
                return;
            }
            h13.b("plugin is invalid");
        }
    }

    public static File g(@Nullable qe4 qe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, qe4Var)) == null) {
            if (qe4Var == null) {
                return null;
            }
            File t = lo2.t(qe4Var.g, String.valueOf(qe4Var.i));
            if (t == null || !t.exists()) {
                return lo2.t(qe4Var.g, String.valueOf(ej3.c(qe4Var.j)));
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
            String i = n13.i("dependenciesPath", null);
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
                h13.b(Log.getStackTraceString(e));
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
            String i = n13.i("dynamicLibConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                h13.b(Log.getStackTraceString(e));
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

    public static List<ie4> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<j13> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = hq2.b(lo2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (j13 j13Var : b2.k.a) {
                ie4 ie4Var = new ie4();
                ie4Var.a = j13Var.a;
                ie4Var.b = j13Var.g;
                ie4Var.c = j13Var.c;
                ie4Var.e = j13Var.i;
                ie4Var.d = j13Var.h;
                arrayList.add(ie4Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static Set<og4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<ie4> l = ad4.b().l(str, j);
            if (l != null && !l.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (ie4 ie4Var : l) {
                    if (!ie4Var.b && vi4.b(ie4Var.a, ie4Var.d, ie4Var.e, arrayList) == null) {
                        og4.a aVar = new og4.a(ie4Var.a);
                        aVar.f(ie4Var.d, ie4Var.e);
                        hashSet.add(aVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    md4.i().g(arrayList);
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
            String i = n13.i("dependenciesConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                h13.b(Log.getStackTraceString(e));
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
                    h13.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<l13> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (fg2.m()) {
                    Iterator<l13> it = i.iterator();
                    while (it.hasNext()) {
                        l13 next = it.next();
                        Pair<Boolean, File> i2 = fg2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            p22.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                n13.c("dynamicLibPath", jSONObject3);
                n13.c("dynamicLibConfig", jSONObject4);
                return;
            }
            n13.c("dynamicLibPath", null);
            n13.c("dynamicLibConfig", null);
            if (a) {
                h13.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<l13> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        l13 l13Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            List<qe4> w = md4.i().w(n13.d(list));
            for (l13 l13Var2 : list) {
                File file2 = null;
                try {
                    l13Var = (l13) l13Var2.clone();
                } catch (CloneNotSupportedException e) {
                    if (a) {
                        h13.b(Log.getStackTraceString(e));
                    }
                    l13Var = l13Var2;
                }
                long j3 = 0;
                if (w != null) {
                    j = 0;
                    boolean z4 = false;
                    z3 = true;
                    boolean z5 = false;
                    for (qe4 qe4Var : w) {
                        if (l13Var2.a.equals(qe4Var.g)) {
                            h13.b("pluginName = " + l13Var2.a + " latestPlugin versionCode = " + qe4Var.i + " cur model versionCode = " + l13Var2.c);
                            long j4 = l13Var2.c;
                            if (j4 >= j3) {
                                c2 = qe4Var.i;
                            } else {
                                c2 = ej3.c(qe4Var.j);
                                j4 = ej3.c(l13Var2.b);
                            }
                            if (c2 > j4) {
                                file2 = g(qe4Var);
                                z5 = true;
                            }
                            if (z5) {
                                l13Var.b = qe4Var.j;
                                l13Var.c = qe4Var.i;
                            }
                            if (!qe4Var.c()) {
                                h13.b("plugin is new, not yet expired");
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
                    long j5 = l13Var2.c;
                    if (j5 < 0) {
                        j5 = ej3.c(l13Var2.b);
                    }
                    j2 = j5;
                } else {
                    j2 = j;
                }
                o(jSONObject, jSONObject2, file, l13Var2, j2);
                if (z3 && z) {
                    s(l13Var);
                }
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, l13 l13Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, l13Var, Long.valueOf(j)}) == null) && jSONObject != null && jSONObject2 != null && l13Var != null) {
            if (file != null && file.exists()) {
                str = file.getAbsolutePath();
                if (a) {
                    h13.b("apply path in workspace, name = " + l13Var.a);
                }
            } else {
                str = l13Var.e;
                if (a) {
                    h13.b("apply path inner swan app, name = " + l13Var.a);
                }
            }
            try {
                jSONObject.put(l13Var.a, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(l13Var.f)) {
                    File file2 = new File(str, l13Var.f);
                    if (file2.exists()) {
                        String E = sl4.E(file2);
                        if (a) {
                            h13.b("pages info = " + E);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(E));
                        jSONObject3.put(PushService.APP_VERSION_CODE, j);
                        jSONObject2.put(l13Var.a, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                if (a) {
                    h13.b(Log.getStackTraceString(e));
                }
            }
        }
    }

    public static qe4 p(String str, String str2, long j) {
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
            List<qe4> r = md4.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (qe4) invokeCommon.objValue;
    }
}
