package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
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
/* loaded from: classes9.dex */
public class yx2 implements vq1, uq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yx2 b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public ik3<SwanAppPageInfo> a;

    /* loaded from: classes9.dex */
    public class a implements kk3<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public a(yx2 yx2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var, jSONObject};
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
        @Override // com.baidu.tieba.kk3
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

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes9.dex */
    public class b<T> implements kk3<String, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public b(yx2 yx2Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var, obj};
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
        @Override // com.baidu.tieba.kk3
        /* renamed from: b */
        public T a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return (T) this.a;
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948345462, "Lcom/baidu/tieba/yx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948345462, "Lcom/baidu/tieba/yx2;");
                return;
            }
        }
        boolean z = am1.a;
        c = wo2.n().a();
        d = c + "_";
    }

    public yx2() {
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

    public static yx2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (yx2.class) {
                    if (b == null) {
                        b = new yx2();
                    }
                }
            }
            return b;
        }
        return (yx2) invokeV.objValue;
    }

    public final mq2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p53 c0 = p53.c0();
            if (c0 != null && c0.X() != null) {
                return c0.X();
            }
            return null;
        }
        return (mq2) invokeV.objValue;
    }

    public final x42 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            y42 W = cr2.V().W();
            if (W == null) {
                return null;
            }
            return W.o();
        }
        return (x42) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.uq1
    public void a(String str, qv2 qv2Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, qv2Var, context) == null) {
            if (qv2Var != null && o53.K().E()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "history");
                    jSONObject.put("url", qv2Var.i());
                    jSONObject.put(IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID, str);
                    c(jSONObject, qv2Var);
                    return;
                } catch (JSONException e) {
                    p22.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
                    return;
                }
            }
            p22.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by pageParam is null or !hasAppOccupied");
        }
    }

    @Override // com.baidu.tieba.vq1
    public void b(p53 p53Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p53Var, jSONObject) == null) {
            c(jSONObject, null);
        }
    }

    public final void c(@NonNull JSONObject jSONObject, @Nullable qv2 qv2Var) {
        String i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, qv2Var) == null) {
            String optString = jSONObject.optString("type");
            if (!d(optString)) {
                p22.o("SwanAppPageInfoHelper", "addPageHistory: ret by check type:" + optString);
                return;
            }
            x42 g = g();
            if (g == null) {
                p22.o("SwanAppPageInfoHelper", "addPageHistory: ret by null fragment");
                return;
            }
            qv2 T1 = g.T1();
            if (T1 == null) {
                p22.o("SwanAppPageInfoHelper", "addPageHistory: ret by null param");
                return;
            }
            if (qv2Var == null) {
                qv2Var = T1;
            }
            try {
                i = qv2Var.i();
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
                p22.o("SwanAppPageInfoHelper", "addPageHistory: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
            }
            if (!str.startsWith(i)) {
                p22.o("SwanAppPageInfoHelper", "addPageHistory: ret by isNotSamePage\n    fragmentUrl = " + i + "\n        dataUrl = " + str);
                return;
            }
            if (optString.startsWith(d)) {
                optString = optString.substring(d.length());
            }
            jSONObject.put("type", optString);
            l(jSONObject, IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID, g.b0);
            l(jSONObject, "scheme", c + "://swan/" + o53.K().getAppId() + "/" + str);
            mq2 f = f();
            if (f != null) {
                l(jSONObject, "appName", f.L());
                l(jSONObject, GameAssistConstKt.KEY_ICONURL, f.R());
                l(jSONObject, "appDesc", f.f1());
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
            p22.i("SwanAppPageInfoHelper", "notifyCallBackLocally: data = " + swanAppPageInfo);
            ik3<SwanAppPageInfo> ik3Var = this.a;
            if (ik3Var != null) {
                ik3Var.a(swanAppPageInfo);
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
            f23.e().h(new h23(24, bundle));
        }
    }

    public final <T> JSONObject j(JSONObject jSONObject, String str, kk3<String, T> kk3Var, kk3<String, Boolean> kk3Var2) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, kk3Var, kk3Var2)) == null) {
            if (kk3Var2.a(str).booleanValue()) {
                jSONObject.put(str, kk3Var.a(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final <T> JSONObject k(JSONObject jSONObject, String str, T t, kk3<String, Boolean> kk3Var) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, jSONObject, str, t, kk3Var)) == null) {
            j(jSONObject, str, new b(this, t), kk3Var);
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
