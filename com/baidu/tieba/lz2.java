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
import com.baidu.tieba.df4;
import com.baidu.tieba.xv1;
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
public class lz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements xv1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a03 a;

        public a(a03 a03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a03Var;
        }

        @Override // com.baidu.tieba.xv1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lz2.r(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a03 a;

        public b(a03 a03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lz2.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements q52<Boolean> {
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
        @Override // com.baidu.tieba.q52
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                wz2.b("download plugin result = " + bool);
                xz2.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947960101, "Lcom/baidu/tieba/lz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947960101, "Lcom/baidu/tieba/lz2;");
                return;
            }
        }
        a = ok1.a;
    }

    public static Set<df4.a> i(PMSAppInfo pMSAppInfo) {
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

    public static List<fd4> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return bc4.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(a03 a03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, a03Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(a03Var), "requestDynamicLib", 2);
        }
    }

    public static void s(a03 a03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, a03Var) == null) {
            qv1.d().c(new xv1(new a(a03Var)));
        }
    }

    public static void c(a03 a03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, a03Var) == null) {
            if (a03Var != null && a03Var.a()) {
                String str = a03Var.a;
                String str2 = a03Var.b;
                long j = a03Var.c;
                ob4.g(new hf4(str, str2, j, a03Var.d), new kz2(str, str2, j, new c(str)));
                return;
            }
            wz2.b("plugin is invalid");
        }
    }

    public static File g(@Nullable fd4 fd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fd4Var)) == null) {
            if (fd4Var == null) {
                return null;
            }
            File t = an2.t(fd4Var.g, String.valueOf(fd4Var.i));
            if (t == null || !t.exists()) {
                return an2.t(fd4Var.g, String.valueOf(th3.c(fd4Var.j)));
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
            String i = c03.i("dependenciesPath", null);
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
                wz2.b(Log.getStackTraceString(e));
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
            String i = c03.i("dynamicLibConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                wz2.b(Log.getStackTraceString(e));
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

    public static List<xc4> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<yz2> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = wo2.b(an2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (yz2 yz2Var : b2.k.a) {
                xc4 xc4Var = new xc4();
                xc4Var.a = yz2Var.a;
                xc4Var.b = yz2Var.g;
                xc4Var.c = yz2Var.c;
                xc4Var.e = yz2Var.i;
                xc4Var.d = yz2Var.h;
                arrayList.add(xc4Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static Set<df4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<xc4> l = pb4.b().l(str, j);
            if (l != null && !l.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (xc4 xc4Var : l) {
                    if (!xc4Var.b && kh4.b(xc4Var.a, xc4Var.d, xc4Var.e, arrayList) == null) {
                        df4.a aVar = new df4.a(xc4Var.a);
                        aVar.f(xc4Var.d, xc4Var.e);
                        hashSet.add(aVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    bc4.i().g(arrayList);
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
            String i = c03.i("dependenciesConfig", null);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            try {
                optJSONObject = new JSONObject(i).optJSONObject(str2);
            } catch (JSONException e) {
                wz2.b(Log.getStackTraceString(e));
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
                    wz2.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<a03> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (ue2.m()) {
                    Iterator<a03> it = i.iterator();
                    while (it.hasNext()) {
                        a03 next = it.next();
                        Pair<Boolean, File> i2 = ue2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            e12.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                c03.c("dynamicLibPath", jSONObject3);
                c03.c("dynamicLibConfig", jSONObject4);
                return;
            }
            c03.c("dynamicLibPath", null);
            c03.c("dynamicLibConfig", null);
            if (a) {
                wz2.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<a03> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        a03 a03Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            List<fd4> w = bc4.i().w(c03.d(list));
            for (a03 a03Var2 : list) {
                File file2 = null;
                try {
                    a03Var = (a03) a03Var2.clone();
                } catch (CloneNotSupportedException e) {
                    if (a) {
                        wz2.b(Log.getStackTraceString(e));
                    }
                    a03Var = a03Var2;
                }
                long j3 = 0;
                if (w != null) {
                    j = 0;
                    boolean z4 = false;
                    z3 = true;
                    boolean z5 = false;
                    for (fd4 fd4Var : w) {
                        if (a03Var2.a.equals(fd4Var.g)) {
                            wz2.b("pluginName = " + a03Var2.a + " latestPlugin versionCode = " + fd4Var.i + " cur model versionCode = " + a03Var2.c);
                            long j4 = a03Var2.c;
                            if (j4 >= j3) {
                                c2 = fd4Var.i;
                            } else {
                                c2 = th3.c(fd4Var.j);
                                j4 = th3.c(a03Var2.b);
                            }
                            if (c2 > j4) {
                                file2 = g(fd4Var);
                                z5 = true;
                            }
                            if (z5) {
                                a03Var.b = fd4Var.j;
                                a03Var.c = fd4Var.i;
                            }
                            if (!fd4Var.c()) {
                                wz2.b("plugin is new, not yet expired");
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
                    long j5 = a03Var2.c;
                    if (j5 < 0) {
                        j5 = th3.c(a03Var2.b);
                    }
                    j2 = j5;
                } else {
                    j2 = j;
                }
                o(jSONObject, jSONObject2, file, a03Var2, j2);
                if (z3 && z) {
                    s(a03Var);
                }
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, a03 a03Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, a03Var, Long.valueOf(j)}) == null) && jSONObject != null && jSONObject2 != null && a03Var != null) {
            if (file != null && file.exists()) {
                str = file.getAbsolutePath();
                if (a) {
                    wz2.b("apply path in workspace, name = " + a03Var.a);
                }
            } else {
                str = a03Var.e;
                if (a) {
                    wz2.b("apply path inner swan app, name = " + a03Var.a);
                }
            }
            try {
                jSONObject.put(a03Var.a, str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(a03Var.f)) {
                    File file2 = new File(str, a03Var.f);
                    if (file2.exists()) {
                        String E = ik4.E(file2);
                        if (a) {
                            wz2.b("pages info = " + E);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("config", new JSONObject(E));
                        jSONObject3.put(PushManager.APP_VERSION_CODE, j);
                        jSONObject2.put(a03Var.a, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                if (a) {
                    wz2.b(Log.getStackTraceString(e));
                }
            }
        }
    }

    public static fd4 p(String str, String str2, long j) {
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
            List<fd4> r = bc4.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (fd4) invokeCommon.objValue;
    }
}
