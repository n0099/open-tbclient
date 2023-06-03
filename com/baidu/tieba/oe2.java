package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oe2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile oe2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<a> a;
    public final Set<a> b;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;

        public a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
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
            this.b = String.valueOf(j);
        }

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                this.b = null;
                this.a = null;
                return;
            }
            this.a = jSONObject.optString("appKey");
            this.b = jSONObject.optString("version");
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && TextUtils.equals(this.b, aVar.b)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.a;
                int i = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                String str2 = this.b;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return (hashCode * 31) + i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.a + "', version='" + this.b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029293, "Lcom/baidu/tieba/oe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029293, "Lcom/baidu/tieba/oe2;");
                return;
            }
        }
        c = is1.a;
    }

    public static oe2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (oe2.class) {
                    if (d == null) {
                        d = new oe2();
                    }
                }
            }
            return d;
        }
        return (oe2) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(true);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public oe2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cq3.a(new a[0]);
        this.b = cq3.a(new a[0]);
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (c) {
                Log.d("PreloadAppsRecorder", "clear all");
            }
            synchronized (this.a) {
                this.a.clear();
                this.b.clear();
            }
            if (z) {
                k();
            }
        }
    }

    public boolean f(a aVar) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            synchronized (this.a) {
                contains = this.a.contains(aVar);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(a aVar) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            synchronized (this.a) {
                contains = this.b.contains(aVar);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public Set<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashSet a2 = cq3.a(new String[0]);
            synchronized (this.a) {
                for (a aVar : this.a) {
                    a2.add(aVar.a);
                }
                for (a aVar2 : this.b) {
                    a2.add(aVar2.a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            j83 w = k83.Q("swan_multi_preload_on_server").A("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).w("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            w.K(true);
            w.call();
            if (c) {
                Log.d("PreloadAppsRecorder", "send all prefetch records to server");
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.a) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<a> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) && jSONObject != null && jSONObject.length() > 0) {
            if (c) {
                Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
            }
            synchronized (this.a) {
                b(false);
                JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    for (int i = 0; i < length; i++) {
                        i(new a(optJSONArray.optJSONObject(i)), true);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("loading");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    i(new a(optJSONObject), false);
                }
            }
            k();
        }
    }

    public void i(a aVar, boolean z) {
        Set<a> set;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, aVar, z) == null) && aVar != null && aVar.a()) {
            if (c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                if (z) {
                    str = "loaded";
                } else {
                    str = "loading";
                }
                sb.append(str);
                Log.d("PreloadAppsRecorder", sb.toString());
                Log.d("PreloadAppsRecorder", "record one app - " + aVar);
            }
            synchronized (this.a) {
                if (z) {
                    set = this.a;
                } else {
                    set = this.b;
                }
                set.add(aVar);
            }
        }
    }
}
