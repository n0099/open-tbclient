package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ File b;
        public final /* synthetic */ String c;

        public a(HashMap hashMap, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashMap, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hashMap;
            this.b = file;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qw1 u;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (u = jv2.u()) != null) {
                u.a(this.a, this.b, null, "error_js");
                if (wi3.a) {
                    Log.d("V8StabilityHelper", "extraData :" + this.a.toString());
                    Log.d("V8StabilityHelper", "filePath :" + this.c);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948271496, "Lcom/baidu/tieba/wi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948271496, "Lcom/baidu/tieba/wi3;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                if (a) {
                    Log.d("V8StabilityHelper", "empty exceptionInfo");
                    return;
                }
                return;
            }
            c(v8ExceptionInfo);
            d(v8ExceptionInfo);
        }
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8ExceptionInfo) == null) {
            if (!jv2.g0().A()) {
                if (a) {
                    Log.d("V8StabilityHelper", "stability switch off");
                    return;
                }
                return;
            }
            zw2.a aVar = null;
            cc3 M = cc3.M();
            if (M != null) {
                aVar = M.Y();
            }
            vn3 vn3Var = new vn3();
            vn3Var.k(5L);
            vn3Var.i(37L);
            dj3 dj3Var = new dj3();
            dj3Var.p(vn3Var);
            dj3Var.r(aVar);
            dj3Var.q(vi3.n(bc3.K().k()));
            dj3Var.m(cc3.g0());
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                    jSONObject.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                    jSONObject.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                    jSONObject.put("exceptionType", v8ExceptionInfo.exceptionType);
                }
                dj3Var.e(jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            vi3.R(dj3Var);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8ExceptionInfo) == null) {
            if (!jv2.g0().G()) {
                if (a) {
                    Log.d("V8StabilityHelper", "upload js switch off");
                }
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    if (a) {
                        Log.d("V8StabilityHelper", "file path start with js code prefix");
                        return;
                    }
                    return;
                }
                SwanCoreVersion e = hl3.e(bc3.K().k());
                if (e != null && !TextUtils.isEmpty(e.swanCorePath)) {
                    if (!str.startsWith(e.swanCorePath)) {
                        if (a) {
                            Log.d("V8StabilityHelper", "file path is not swan core path");
                            return;
                        }
                        return;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    cc3 M = cc3.M();
                    if (!TextUtils.isEmpty(cc3.g0())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, cc3.g0());
                    }
                    if (M != null && !TextUtils.isEmpty(M.k0())) {
                        hashMap.put("appVersion", M.k0());
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                        hashMap.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                        hashMap.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                        hashMap.put("exceptionType", v8ExceptionInfo.exceptionType);
                    }
                    wo3.k(new a(hashMap, file, str), "error_js");
                }
            }
        }
    }
}
