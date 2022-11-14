package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ow2 implements kp1, jp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ow2 b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public yi3<SwanAppPageInfo> a;

    /* loaded from: classes5.dex */
    public class a implements aj3<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public a(ow2 ow2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow2Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aj3
        /* renamed from: b */
        public Boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return Boolean.valueOf(TextUtils.isEmpty(this.a.optString(str)));
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements aj3<String, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public b(ow2 ow2Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow2Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
        @Override // com.baidu.tieba.aj3
        /* renamed from: b */
        public T a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return this.a;
            }
            return invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046591, "Lcom/baidu/tieba/ow2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046591, "Lcom/baidu/tieba/ow2;");
                return;
            }
        }
        boolean z = pk1.a;
        c = mn2.n().a();
        d = c + "_";
    }

    public ow2() {
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

    public static ow2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ow2.class) {
                    if (b == null) {
                        b = new ow2();
                    }
                }
            }
            return b;
        }
        return (ow2) invokeV.objValue;
    }

    public final cp2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            f43 b0 = f43.b0();
            if (b0 != null && b0.W() != null) {
                return b0.W();
            }
            return null;
        }
        return (cp2) invokeV.objValue;
    }

    public final n32 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            o32 V = sp2.U().V();
            if (V == null) {
                return null;
            }
            return V.o();
        }
        return (n32) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.jp1
    public void a(String str, gu2 gu2Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, gu2Var, context) == null) {
            if (gu2Var != null && e43.K().E()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "history");
                    jSONObject.put("url", gu2Var.i());
                    jSONObject.put("pageId", str);
                    c(jSONObject, gu2Var);
                    return;
                } catch (JSONException e) {
                    f12.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
                    return;
                }
            }
            f12.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by pageParam is null or !hasAppOccupied");
        }
    }

    @Override // com.baidu.tieba.kp1
    public void b(f43 f43Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f43Var, jSONObject) == null) {
            c(jSONObject, null);
        }
    }

    public final void c(@NonNull JSONObject jSONObject, @Nullable gu2 gu2Var) {
        String i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, gu2Var) == null) {
            String optString = jSONObject.optString("type");
            if (!d(optString)) {
                f12.o("SwanAppPageInfoHelper", "addPageHistory: ret by check type:" + optString);
                return;
            }
            n32 g = g();
            if (g == null) {
                f12.o("SwanAppPageInfoHelper", "addPageHistory: ret by null fragment");
                return;
            }
            gu2 N1 = g.N1();
            if (N1 == null) {
                f12.o("SwanAppPageInfoHelper", "addPageHistory: ret by null param");
                return;
            }
            if (gu2Var == null) {
                gu2Var = N1;
            }
            try {
                i = gu2Var.i();
                str = "";
                if (TextUtils.isEmpty(i)) {
                    i = "";
                }
                l(jSONObject, "url", i);
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    str = optString2;
                }
            } catch (JSONException e) {
                f12.o("SwanAppPageInfoHelper", "addPageHistory: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
            }
            if (!str.startsWith(i)) {
                f12.o("SwanAppPageInfoHelper", "addPageHistory: ret by isNotSamePage\n    fragmentUrl = " + i + "\n        dataUrl = " + str);
                return;
            }
            if (optString.startsWith(d)) {
                optString = optString.substring(d.length());
            }
            jSONObject.put("type", optString);
            l(jSONObject, "pageId", g.b0);
            l(jSONObject, "scheme", c + "://swan/" + e43.K().getAppId() + "/" + str);
            cp2 f = f();
            if (f != null) {
                l(jSONObject, "appName", f.K());
                l(jSONObject, "iconUrl", f.Q());
                l(jSONObject, "appDesc", f.e1());
            }
            h(jSONObject);
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && ("history".equals(str) || str.startsWith(d))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(SwanAppPageInfo swanAppPageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppPageInfo) == null) {
            f12.i("SwanAppPageInfoHelper", "notifyCallBackLocally: data = " + swanAppPageInfo);
            yi3<SwanAppPageInfo> yi3Var = this.a;
            if (yi3Var != null) {
                yi3Var.a(swanAppPageInfo);
            }
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            if (!SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                i(new SwanAppPageInfo(jSONObject));
                return;
            }
            m();
            Bundle bundle = new Bundle();
            bundle.putString(PageInfo.KEY, jSONObject.toString());
            v03.e().h(new x03(24, bundle));
        }
    }

    public final <T> JSONObject j(JSONObject jSONObject, String str, aj3<String, T> aj3Var, aj3<String, Boolean> aj3Var2) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, aj3Var, aj3Var2)) == null) {
            if (aj3Var2.a(str).booleanValue()) {
                jSONObject.put(str, aj3Var.a(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final <T> JSONObject k(JSONObject jSONObject, String str, T t, aj3<String, Boolean> aj3Var) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, jSONObject, str, t, aj3Var)) == null) {
            j(jSONObject, str, new b(this, t), aj3Var);
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final JSONObject l(JSONObject jSONObject, String str, String str2) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, jSONObject, str, str2)) == null) {
            k(jSONObject, str, str2, new a(this, jSONObject));
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
