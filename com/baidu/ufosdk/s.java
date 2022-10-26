package com.baidu.ufosdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final s a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2041843919, "Lcom/baidu/ufosdk/s$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2041843919, "Lcom/baidu/ufosdk/s$b;");
                    return;
                }
            }
            a = new s();
        }
    }

    public s() {
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

    public final String a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("m", "Customer");
            hashMap.put("a", "coludSwitch");
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new a(this));
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
                sb.append("&");
            }
            sb.append("key=");
            sb.append("zjnmputbya!@%^g985%");
            return com.baidu.ufosdk.b.b(sb.toString(), false);
        }
        return (String) invokeL.objValue;
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        String a2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("category", "feedback_android");
                hashMap.put("os", "android");
                hashMap.put(Constants.KEY_PRODUCT_LINE, e0.a(context).d);
                hashMap.put("pkgname", c.a());
                hashMap.put("app_version", c.b());
                hashMap.put("sdk_version", "4.1.9.1");
                hashMap.put("cuid", com.baidu.ufosdk.b.f());
                hashMap.put("sign", a(hashMap));
                a2 = d0.a(s1.n, d0.a(hashMap));
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(a2);
            if (jSONObject.optInt("errno") != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return true;
            }
            if (!optJSONObject.isNull("host_error_repair") && (optJSONObject2 = optJSONObject.optJSONObject("host_error_repair")) != null) {
                u1.a(context.getSharedPreferences("feedback_switch_prefs", 0).edit().putInt("res_c_er_lim", optJSONObject2.optInt("count", 0)));
            }
            if (!optJSONObject.isNull("full_status_bar")) {
                u1.a(context.getSharedPreferences("feedback_switch_prefs", 0).edit().putBoolean("f_stu_b", optJSONObject.optBoolean("full_status_bar", false)));
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
