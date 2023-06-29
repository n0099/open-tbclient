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
/* loaded from: classes6.dex */
public class l43 implements hx1, gx1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l43 b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public vq3<SwanAppPageInfo> a;

    /* loaded from: classes6.dex */
    public class a implements xq3<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public a(l43 l43Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l43Var, jSONObject};
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
        @Override // com.baidu.tieba.xq3
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
    /* loaded from: classes6.dex */
    public class b<T> implements xq3<String, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public b(l43 l43Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l43Var, obj};
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
        @Override // com.baidu.tieba.xq3
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892862, "Lcom/baidu/tieba/l43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892862, "Lcom/baidu/tieba/l43;");
                return;
            }
        }
        boolean z = ms1.a;
        c = jv2.n().a();
        d = c + "_";
    }

    public l43() {
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

    public static l43 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (l43.class) {
                    if (b == null) {
                        b = new l43();
                    }
                }
            }
            return b;
        }
        return (l43) invokeV.objValue;
    }

    public final zw2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 != null && b0.W() != null) {
                return b0.W();
            }
            return null;
        }
        return (zw2) invokeV.objValue;
    }

    public final kb2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lb2 U = px2.T().U();
            if (U == null) {
                return null;
            }
            return U.o();
        }
        return (kb2) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.gx1
    public void a(String str, d23 d23Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, d23Var, context) == null) {
            if (d23Var != null && bc3.K().E()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "history");
                    jSONObject.put("url", d23Var.i());
                    jSONObject.put(IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID, str);
                    c(jSONObject, d23Var);
                    return;
                } catch (JSONException e) {
                    c92.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
                    return;
                }
            }
            c92.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by pageParam is null or !hasAppOccupied");
        }
    }

    @Override // com.baidu.tieba.hx1
    public void b(cc3 cc3Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cc3Var, jSONObject) == null) {
            c(jSONObject, null);
        }
    }

    public final void c(@NonNull JSONObject jSONObject, @Nullable d23 d23Var) {
        String i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, d23Var) == null) {
            String optString = jSONObject.optString("type");
            if (!d(optString)) {
                c92.o("SwanAppPageInfoHelper", "addPageHistory: ret by check type:" + optString);
                return;
            }
            kb2 g = g();
            if (g == null) {
                c92.o("SwanAppPageInfoHelper", "addPageHistory: ret by null fragment");
                return;
            }
            d23 P1 = g.P1();
            if (P1 == null) {
                c92.o("SwanAppPageInfoHelper", "addPageHistory: ret by null param");
                return;
            }
            if (d23Var == null) {
                d23Var = P1;
            }
            try {
                i = d23Var.i();
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
                c92.o("SwanAppPageInfoHelper", "addPageHistory: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
            }
            if (!str.startsWith(i)) {
                c92.o("SwanAppPageInfoHelper", "addPageHistory: ret by isNotSamePage\n    fragmentUrl = " + i + "\n        dataUrl = " + str);
                return;
            }
            if (optString.startsWith(d)) {
                optString = optString.substring(d.length());
            }
            jSONObject.put("type", optString);
            l(jSONObject, IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID, g.b0);
            l(jSONObject, "scheme", c + "://swan/" + bc3.K().getAppId() + "/" + str);
            zw2 f = f();
            if (f != null) {
                l(jSONObject, "appName", f.K());
                l(jSONObject, GameAssistConstKt.KEY_ICONURL, f.Q());
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
            c92.i("SwanAppPageInfoHelper", "notifyCallBackLocally: data = " + swanAppPageInfo);
            vq3<SwanAppPageInfo> vq3Var = this.a;
            if (vq3Var != null) {
                vq3Var.a(swanAppPageInfo);
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
            s83.e().h(new u83(24, bundle));
        }
    }

    public final <T> JSONObject j(JSONObject jSONObject, String str, xq3<String, T> xq3Var, xq3<String, Boolean> xq3Var2) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, xq3Var, xq3Var2)) == null) {
            if (xq3Var2.a(str).booleanValue()) {
                jSONObject.put(str, xq3Var.a(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final <T> JSONObject k(JSONObject jSONObject, String str, T t, xq3<String, Boolean> xq3Var) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, jSONObject, str, t, xq3Var)) == null) {
            j(jSONObject, str, new b(this, t), xq3Var);
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
