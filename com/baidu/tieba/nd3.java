package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key" : (String) invokeI.objValue;
    }

    public static String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5" : (String) invokeI.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) {
                if (cVar == null) {
                    return -1;
                }
                if (cVar2 == null) {
                    return 1;
                }
                return String.valueOf(cVar.a).compareTo(String.valueOf(cVar2.a));
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final nd3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-579132370, "Lcom/baidu/tieba/nd3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-579132370, "Lcom/baidu/tieba/nd3$b;");
                    return;
                }
            }
            a = new nd3(null);
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
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
            this.b = j2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("time", this.a);
                    jSONObject.put("version", this.b);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    if (tk1.a) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @NonNull
        public String toString() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.a));
                } catch (Exception e) {
                    if (tk1.a) {
                        e.printStackTrace();
                    }
                    str = null;
                }
                return str + " ---> " + this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    public nd3() {
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

    public static nd3 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (nd3) invokeV.objValue;
    }

    public /* synthetic */ nd3(a aVar) {
        this();
    }

    public static void h(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public void a(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            List<c> f = f(i);
            boolean z = false;
            if (f.size() >= 10) {
                f.remove(0);
            }
            Iterator<c> it = f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c next = it.next();
                if (next != null && next.b == j) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            f.add(new c(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (c cVar : f) {
                if (cVar != null) {
                    hashSet.add(cVar.a());
                }
            }
            xc3.a().putStringSet(b(i), hashSet);
        }
    }

    public String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            StringBuilder sb = new StringBuilder();
            String string = xc3.a().getString(d(i), "");
            if (!TextUtils.isEmpty(string)) {
                sb.append("md5: ");
                sb.append(string);
                sb.append("\n");
                sb.append("\n");
            }
            List<c> f = f(i);
            int size = f.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = f.get(i2);
                if (cVar != null) {
                    sb.append(cVar.toString());
                    if (i2 < size - 1) {
                        sb.append("\n");
                    }
                    z = true;
                }
            }
            if (!z) {
                sb.append(new c(System.currentTimeMillis(), rd3.f(i)).toString());
            } else {
                SwanCoreVersion M = wp2.U().M();
                c cVar2 = f.get(size - 1);
                if (cVar2 != null && M != null && M.swanCoreVersionCode > cVar2.b) {
                    sb.append("\n");
                    sb.append(new c(System.currentTimeMillis(), M.swanCoreVersionCode).toString());
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public final List<c> f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            Set<String> stringSet = xc3.a().getStringSet(b(i), null);
            if (stringSet != null && stringSet.size() != 0) {
                for (String str : stringSet) {
                    c g = g(str);
                    if (g != null) {
                        arrayList.add(g);
                    }
                }
                h(arrayList);
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final c g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optLong("time"), jSONObject.optLong("version"));
            } catch (JSONException e) {
                if (!tk1.a) {
                    return null;
                }
                e.printStackTrace();
                return null;
            }
        }
        return (c) invokeL.objValue;
    }
}
