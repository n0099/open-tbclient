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
/* loaded from: classes8.dex */
public abstract class vl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public abstract void m(Map<String, Object> map);

    /* loaded from: classes8.dex */
    public class a extends tl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 c;
        public final /* synthetic */ String d;

        public a(vl2 vl2Var, ta2 ta2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl2Var, ta2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ta2Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.tl2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.isDestroyed()) {
                    if (vl2.b) {
                        Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + this.d)));
                        return;
                    }
                    return;
                }
                this.c.evaluateJavascript(this.d, null);
                z43.a("postMessage", "dispatchJSEvent evaluateJavascript");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends tl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vl2 e;

        public b(vl2 vl2Var, ta2 ta2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl2Var, ta2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vl2Var;
            this.c = ta2Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.tl2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244557, "Lcom/baidu/tieba/vl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244557, "Lcom/baidu/tieba/vl2;");
                return;
            }
        }
        b = fs1.a;
    }

    public vl2() {
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

    public String c(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta2Var)) == null) {
            return d("event", ta2Var);
        }
        return (String) invokeL.objValue;
    }

    public boolean f(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ta2Var)) == null) {
            if (ta2Var != null && !ta2Var.isWebView() && (ta2Var instanceof fj2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ta2Var) != null) || ta2Var == null) {
            return;
        }
        z43.a("postMessage", "dispatchJSEvent start.");
        if (ul2.b) {
            r(ta2Var);
        } else {
            q(ta2Var);
        }
        z43.a("postMessage", "dispatchJSEvent buildEvent");
    }

    public final boolean p(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof String)) {
                return true;
            }
            return !TextUtils.isEmpty((String) obj);
        }
        return invokeL.booleanValue;
    }

    public final void r(@NonNull ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ta2Var) == null) {
            if (f(ta2Var)) {
                h(ta2Var);
            } else {
                i(ta2Var);
            }
        }
    }

    public String d(String str, ta2 ta2Var) {
        InterceptResult invokeLL;
        String format;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ta2Var)) == null) {
            if (ta2Var != null && !TextUtils.isEmpty(this.a)) {
                if (TextUtils.isEmpty(str)) {
                    str = "event";
                }
                Locale locale = Locale.getDefault();
                if (ta2Var.isWebView()) {
                    format = String.format(locale, "var %s = new Event('%s');", str, this.a);
                    b2 = "";
                } else {
                    format = String.format(locale, "var %s = new Object();", str);
                    b2 = rl2.b(str, "type", this.a);
                }
                return format + (b2 + o(str)) + String.format(locale, "%s.dispatchEvent(%s);", rl2.c(ta2Var), str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public JSEvent e(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ta2Var)) == null) {
            if (ta2Var != null && !TextUtils.isEmpty(this.a)) {
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
            return null;
        }
        return (JSEvent) invokeL.objValue;
    }

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

    public void h(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ta2Var) != null) || ta2Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        JSEvent e = e(ta2Var);
        if (e == null) {
            return;
        }
        j(ta2Var, e);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
        }
    }

    public final void q(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ta2Var) == null) {
            String c = c(ta2Var);
            if (TextUtils.isEmpty(c)) {
                return;
            }
            String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
            if (b) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format);
            }
            if (ta2Var.isWebView()) {
                sl2.b().c(new b(this, ta2Var, format), null);
            } else {
                l(ta2Var, format);
            }
        }
    }

    public void i(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, ta2Var) != null) || ta2Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on webView");
        }
        String c = c(ta2Var);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
        k(ta2Var, format);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action on webView: " + format);
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

    public void j(ta2 ta2Var, JSEvent jSEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ta2Var, jSEvent) != null) || ta2Var.isDestroyed()) {
            return;
        }
        if (ta2Var instanceof fj2) {
            ((fj2) ta2Var).dispatchEvent(jSEvent);
        }
        z43.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public void k(ta2 ta2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, ta2Var, str) == null) && ta2Var != null && !TextUtils.isEmpty(str)) {
            sl2.b().c(new a(this, ta2Var, str), null);
        }
    }

    public final void l(ta2 ta2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, ta2Var, str) == null) {
            if (ta2Var.isDestroyed()) {
                if (b) {
                    Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                    return;
                }
                return;
            }
            ta2Var.evaluateJavascript(str, null);
            z43.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }
}
