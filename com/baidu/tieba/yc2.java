package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class yc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes6.dex */
    public class a extends wc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w12 c;
        public final /* synthetic */ String d;

        public a(yc2 yc2Var, w12 w12Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc2Var, w12Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w12Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.wc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.isDestroyed()) {
                    if (yc2.b) {
                        Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + this.d)));
                        return;
                    }
                    return;
                }
                this.c.evaluateJavascript(this.d, null);
                cw2.a("postMessage", "dispatchJSEvent evaluateJavascript");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends wc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w12 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ yc2 e;

        public b(yc2 yc2Var, w12 w12Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc2Var, w12Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yc2Var;
            this.c = w12Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.wc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.l(this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325281, "Lcom/baidu/tieba/yc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325281, "Lcom/baidu/tieba/yc2;");
                return;
            }
        }
        b = ij1.a;
    }

    public yc2() {
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

    public final void b(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.put("type", this.a);
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String c(w12 w12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w12Var)) == null) ? d("event", w12Var) : (String) invokeL.objValue;
    }

    public String d(String str, w12 w12Var) {
        InterceptResult invokeLL;
        String format;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, w12Var)) == null) {
            if (w12Var == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                str = "event";
            }
            Locale locale = Locale.getDefault();
            if (w12Var.isWebView()) {
                format = String.format(locale, "var %s = new Event('%s');", str, this.a);
                b2 = "";
            } else {
                format = String.format(locale, "var %s = new Object();", str);
                b2 = uc2.b(str, "type", this.a);
            }
            return format + (b2 + o(str)) + String.format(locale, "%s.dispatchEvent(%s);", uc2.c(w12Var), str);
        }
        return (String) invokeLL.objValue;
    }

    public JSEvent e(w12 w12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, w12Var)) == null) {
            if (w12Var == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            JSEvent jSEvent = new JSEvent(this.a);
            JSONObject jSONObject = new JSONObject();
            try {
                n(jSONObject);
            } catch (Exception e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            b(jSONObject);
            jSEvent.data = jSONObject;
            return jSEvent;
        }
        return (JSEvent) invokeL.objValue;
    }

    public boolean f(w12 w12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, w12Var)) == null) ? (w12Var == null || w12Var.isWebView() || !(w12Var instanceof ia2)) ? false : true : invokeL.booleanValue;
    }

    public void g(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, w12Var) == null) || w12Var == null) {
            return;
        }
        cw2.a("postMessage", "dispatchJSEvent start.");
        if (xc2.b) {
            r(w12Var);
        } else {
            q(w12Var);
        }
        cw2.a("postMessage", "dispatchJSEvent buildEvent");
    }

    public void h(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, w12Var) == null) || w12Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        JSEvent e = e(w12Var);
        if (e == null) {
            return;
        }
        j(w12Var, e);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
        }
    }

    public void i(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, w12Var) == null) || w12Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on webView");
        }
        String c = c(w12Var);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
        k(w12Var, format);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action on webView: " + format);
        }
    }

    public void j(w12 w12Var, JSEvent jSEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w12Var, jSEvent) == null) || w12Var.isDestroyed()) {
            return;
        }
        if (w12Var instanceof ia2) {
            ((ia2) w12Var).dispatchEvent(jSEvent);
        }
        cw2.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public void k(w12 w12Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, w12Var, str) == null) || w12Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        vc2.b().c(new a(this, w12Var, str), null);
    }

    public final void l(w12 w12Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, w12Var, str) == null) {
            if (w12Var.isDestroyed()) {
                if (b) {
                    Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                    return;
                }
                return;
            }
            w12Var.evaluateJavascript(str, null);
            cw2.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }

    public abstract void m(Map<String, Object> map);

    public void n(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            m(hashMap);
            for (String str : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = hashMap.get(str);
                    if (p(obj)) {
                        jSONObject.put(str, obj);
                    }
                }
            }
        }
    }

    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Map<String, Object> hashMap = new HashMap<>();
            m(hashMap);
            StringBuilder sb = new StringBuilder();
            for (String str2 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = hashMap.get(str2);
                    if (p(obj)) {
                        if (obj instanceof String) {
                            obj = JSONObject.quote((String) obj);
                        }
                        sb.append(str);
                        sb.append(".");
                        sb.append(str2);
                        sb.append("=");
                        sb.append(obj);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean p(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof String) {
                return !TextUtils.isEmpty((String) obj);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, w12Var) == null) {
            String c = c(w12Var);
            if (TextUtils.isEmpty(c)) {
                return;
            }
            String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
            if (b) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format);
            }
            if (w12Var.isWebView()) {
                vc2.b().c(new b(this, w12Var, format), null);
            } else {
                l(w12Var, format);
            }
        }
    }

    public final void r(@NonNull w12 w12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, w12Var) == null) {
            if (f(w12Var)) {
                h(w12Var);
            } else {
                i(w12Var);
            }
        }
    }
}
