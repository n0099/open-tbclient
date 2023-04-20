package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class mg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger a;
    public static String b;
    public static JSONObject c;
    public static ArrayList<Long> d;
    public static final Hashtable<String, ArrayList<ng0<Integer, Integer>>> e;
    public static boolean f;
    public static final g11 g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-605080362, "Lcom/baidu/tieba/mg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-605080362, "Lcom/baidu/tieba/mg0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            mg0.g();
            mg0.n();
            mg0.i(false);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements pm0<br0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ File b;
        public final /* synthetic */ File c;

        public b(long j, File file, File file2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), file, file2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = file;
            this.c = file2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pm0
        /* renamed from: a */
        public final void accept(br0 res) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, res) == null) {
                Intrinsics.checkNotNullParameter(res, "res");
                boolean z = false;
                if (res.isSuccess()) {
                    mg0.d().i("iadex_sp_key_etag", res.a());
                    mg0.d().i("iadex_sp_key_modified_time", res.b());
                    mg0.d().h("iadex_last_update_time", this.a);
                    if (res.c() > 0 && e41.a(this.b, new File(this.c, "iadex.json")) > 0) {
                        z = true;
                    }
                } else {
                    this.b.deleteOnExit();
                }
                if (!z) {
                    return;
                }
                mg0.g();
                mg0.n();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947971571, "Lcom/baidu/tieba/mg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947971571, "Lcom/baidu/tieba/mg0;");
                return;
            }
        }
        a = new AtomicInteger(0);
        b = "";
        d = new ArrayList<>();
        e = new Hashtable<>();
        f = true;
        g11 b2 = j11.a().b("iad_sp_file");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().getSp(SP_FILE_NAME)");
        g = b2;
    }

    public static final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            Context context = ji0.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (!file.exists()) {
                return;
            }
            File file2 = new File(file, "iadex.json");
            if (file2.exists()) {
                String e2 = e41.e(file2);
                if (!TextUtils.isEmpty(e2)) {
                    synchronized (ng0.class) {
                        try {
                            c = new JSONObject(e2);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    public static final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList<Long> arrayList = d;
            if (w01.g(arrayList)) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                w01.b(arrayList2, String.valueOf(it.next().longValue()));
            }
            String join = TextUtils.join(",", arrayList2);
            Intrinsics.checkNotNullExpressionValue(join, "TextUtils.join(IADEX_DELIMITER, tmpFlag)");
            return join;
        }
        return (String) invokeV.objValue;
    }

    public static final g11 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return g;
        }
        return (g11) invokeV.objValue;
    }

    public static final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i) == null) {
            k(i, 0);
        }
    }

    public static final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            j(i, 0);
        }
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                b = h();
                if (a.compareAndSet(0, 1)) {
                    n21.c(a.a, "update_iad_ex", 3);
                }
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static final void f(PackageManager packageManager, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65542, null, packageManager, str, i, i2) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                j(i, i2);
            } catch (PackageManager.NameNotFoundException unused) {
                k(i, i2);
            }
        }
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = "";
            String string = g.getString("AD_IADEX", "");
            if (string != null) {
                str = string;
            }
            Intrinsics.checkNotNullExpressionValue(str, "sp.getString(IADEX_KEY, \"\") ?: \"\"");
            if (!TextUtils.isEmpty(str)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    for (String str2 : (String[]) array) {
                        w01.b(arrayList, Long.valueOf(str2));
                    }
                    d = arrayList;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static final void n() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && (jSONObject = c) != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            ArrayList<Long> arrayList = new ArrayList<>(d);
            int length = optJSONArray.length();
            int l = w01.l(arrayList);
            if (length != l) {
                if (length > l) {
                    while (l < length) {
                        w01.b(arrayList, 0L);
                        l++;
                    }
                } else {
                    for (int i = length; i < l; i++) {
                        w01.i(arrayList, i);
                    }
                }
            }
            d = arrayList;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String groupName = optJSONObject.optString("name");
                    int optInt = optJSONObject.optInt("interval");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("list");
                    Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
                    q(i2, groupName, optInt, optJSONArray2, f);
                } else {
                    return;
                }
            }
            if (f) {
                f = false;
            }
        }
    }

    public static final boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, null, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - g.getLong("iadex_last_update_time", 0L) < TimeUnit.HOURS.toMillis(g.getInt("cdn_expire", 12))) {
                return false;
            }
            String string = g.getString("iadex_sp_key_etag", "");
            String string2 = g.getString("iadex_sp_key_modified_time", "");
            Context context = ji0.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (!file.exists() && !file.mkdir()) {
                return false;
            }
            File file2 = new File(file, "iadex.json.temp");
            uq0 uq0Var = new uq0();
            ar0 ar0Var = new ar0();
            ar0Var.a = string;
            ar0Var.b = string2;
            ar0Var.c = z;
            uq0Var.a("https://pn.baidu.com/iad/os_type2_all.json", ar0Var, file2, new b(currentTimeMillis, file2, file, string));
            return true;
        }
        return invokeZ.booleanValue;
    }

    public static final void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i, i2) == null) {
            ArrayList<Long> arrayList = d;
            if (i < arrayList.size()) {
                Long l = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i, Long.valueOf(l.longValue() | (1 << i2)));
            }
        }
    }

    public static final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, null, i, i2) == null) {
            ArrayList<Long> arrayList = d;
            if (i < arrayList.size()) {
                Long l = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i, Long.valueOf(l.longValue() & (~(1 << i2))));
            }
        }
    }

    public static final void p(int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i, jSONArray) == null) {
            if (i >= d.size()) {
                Log.e("AD_IADEX", "group index should NOT greater or equal group size!!!");
                return;
            }
            Context context = ji0.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            PackageManager packageManager = context.getPackageManager();
            l(i);
            int i2 = 0;
            int length = jSONArray.length();
            while (i2 < length) {
                String packageName = jSONArray.optString(i2);
                i2++;
                ng0 ng0Var = new ng0(Integer.valueOf(i), Integer.valueOf(i2));
                ArrayList<ng0<Integer, Integer>> arrayList = e.get(packageName);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                w01.b(arrayList, ng0Var);
                e.put(packageName, arrayList);
                Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                f(packageManager, packageName, i, i2);
            }
            m(i);
            String o = o();
            b = o;
            g.i("AD_IADEX", o);
        }
    }

    public static final void q(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), jSONArray, Boolean.valueOf(z)}) == null) && i >= 0 && !TextUtils.isEmpty(str) && i2 >= 0 && jSONArray != null && jSONArray.length() != 0) {
            long time = new Date().getTime();
            String str2 = "AD_IADEX_" + str + "_TS";
            long j = g.getLong(str2, 0L);
            long millis = TimeUnit.MINUTES.toMillis(i2);
            boolean z3 = true;
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = (i3 <= 0 || time - j <= millis) ? false : false;
            if (z || z2 || z3) {
                g.h(str2, time);
                p(i, jSONArray);
            }
        }
    }
}
