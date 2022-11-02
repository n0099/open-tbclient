package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nx2 implements px2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public ox2 a;
    public SimpleDateFormat b;
    public HashMap<String, List<mx2>> c;
    public final Object d;
    public String e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public volatile ay2 j;

    /* loaded from: classes5.dex */
    public class a implements ox2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx2 a;

        public a(nx2 nx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx2Var;
        }

        @Override // com.baidu.tieba.ox2
        public boolean a(mx2 mx2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mx2Var)) == null) {
                if (mx2Var == null || mx2Var.c() < 0) {
                    return false;
                }
                if (nx2.k || mx2Var.b() == 0) {
                    return this.a.m(mx2Var.e());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017761, "Lcom/baidu/tieba/nx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017761, "Lcom/baidu/tieba/nx2;");
                return;
            }
        }
        k = ok1.a;
    }

    public nx2() {
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
        this.d = new Object();
    }

    @Override // com.baidu.tieba.px2
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || !rx2.h().k()) {
            return;
        }
        n();
        if (this.f) {
            o("aiapp start finish");
            return;
        }
        o("ubcReport enter");
        if (jSONObject != null && jSONObject.length() > 0) {
            String k2 = k(jSONObject);
            o("Id " + k2);
            if (!TextUtils.equals(k2, "786")) {
                return;
            }
            if (k) {
                Log.d("ApiCalledMarker", jSONObject.toString());
            }
            JSONObject j = j(jSONObject);
            if (j != null && j.length() > 0) {
                JSONObject optJSONObject = j.optJSONObject("ext");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    if (TextUtils.isEmpty(this.e)) {
                        this.e = optJSONObject.optString("swan");
                        o("current swan version " + this.e);
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        q(optJSONArray);
                        o("ubcReport over");
                        t(i());
                        return;
                    }
                    o("value-ext-list is empty");
                    return;
                }
                o("value-ext is empty");
                return;
            }
            o("value is empty");
            return;
        }
        o("json data is empty");
    }

    @Override // com.baidu.tieba.qx2
    public void end(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.g = true;
            this.i = j;
            t(i());
            o("launch end time-" + (this.h + this.i));
        }
    }

    public final void l(JSONObject jSONObject) {
        ay2 yx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) && this.j == null) {
            synchronized (this.d) {
                if (this.j == null) {
                    if (jSONObject.has("caller")) {
                        yx2Var = new zx2();
                    } else {
                        yx2Var = new yx2();
                    }
                    this.j = yx2Var;
                }
            }
        }
    }

    public String i() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.g || this.b == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.b.format(Long.valueOf(this.h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.b.format(Long.valueOf(this.h + this.i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.e);
            sb.append("\n");
            synchronized (this.d) {
                i = 0;
                i2 = 0;
                for (Map.Entry<String, List<mx2>> entry : this.c.entrySet()) {
                    List<mx2> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        for (mx2 mx2Var : value) {
                            if (this.a == null || this.a.a(mx2Var)) {
                                sb2.append("----- start time ");
                                sb2.append(this.b.format(Long.valueOf(mx2Var.e())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.b.format(Long.valueOf(mx2Var.d())));
                                sb2.append("\n");
                                sb2.append("----- cost time ");
                                sb2.append(mx2Var.c());
                                sb2.append("ms\n");
                                sb2.append("----------------------------\n");
                                i2++;
                                i3++;
                            }
                        }
                        if (i3 > 0) {
                            sb.append("\n===== ");
                            sb.append(entry.getKey());
                            sb.append(" ");
                            sb.append(i3);
                            sb.append(" times\n");
                            sb.append((CharSequence) sb2);
                            i++;
                        }
                    }
                }
            }
            sb.append("===== total: ");
            sb.append(i);
            sb.append(" apis, ");
            sb.append(i2);
            sb.append(" times");
            String sb3 = sb.toString();
            e12.b("ApiCalledMarker", sb3);
            return sb3;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject == null) {
                return jSONObject.optJSONObject("value");
            }
            return optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String k(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            String optString = jSONObject.optString("ubcId");
            if (TextUtils.isEmpty(optString)) {
                return jSONObject.optString("actionId");
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public final boolean m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            long j2 = this.h;
            if (j >= j2 && j <= j2 + this.i) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (!this.g || j <= this.h + this.i) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.qx2
    public void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            n();
            s();
            this.h = j;
            o("launch start time-" + j);
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ag3.j.update((zf3<String>) str);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.c != null) {
            return;
        }
        synchronized (this.d) {
            if (this.c == null) {
                this.c = new HashMap<>();
                this.b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.a = new a(this);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.c.size() > 0) {
                synchronized (this.d) {
                    this.c.clear();
                }
            }
            this.f = false;
            this.g = false;
            this.i = 0L;
            this.h = 0L;
            this.e = null;
            t("===== loading... =====");
        }
    }

    public final void q(JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONArray) == null) {
            o("start parse api info");
            int length = jSONArray.length();
            if (length > 0) {
                z = true;
            } else {
                z = false;
            }
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                    z &= !r(optJSONObject);
                }
            }
            this.f = z;
            o("start done " + this.f);
        }
    }

    public final boolean r(JSONObject jSONObject) {
        InterceptResult invokeL;
        List<mx2> a2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jSONObject)) == null) {
            l(jSONObject);
            String optString = jSONObject.optString("apiName");
            if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
                return true;
            }
            if (a2.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            synchronized (this.d) {
                List<mx2> list = this.c.get(optString);
                if (list == null) {
                    list = new ArrayList<>();
                    this.c.put(optString, list);
                }
                list.addAll(a2);
                for (mx2 mx2Var : a2) {
                    z &= p(mx2Var.e());
                }
            }
            if (k) {
                Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
            }
            return !z;
        }
        return invokeL.booleanValue;
    }
}
