package com.baidu.ufosdk.d;

import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f5370a;

    /* renamed from: b  reason: collision with root package name */
    private String f5371b;
    private String c;

    public b(String str, Class cls) {
        String a2;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f5371b = str;
            this.f5370a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.f5371b);
            sb.append(" initialization begin\");");
            sb.append("var a={queue:[],callback:function(){");
            sb.append("var d=Array.prototype.slice.call(arguments,0);");
            sb.append("var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (a2 = a(method)) != null) {
                    this.f5370a.put(a2, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.f5371b);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++)");
            sb.append("{var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\")");
            sb.append("{var d=a.queue.length;a.queue[d]=c;f[h]=d}}");
            sb.append("var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));");
            sb.append("if(g.code!=200){throw\"");
            sb.append(this.f5371b);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};");
            sb.append("Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];");
            sb.append("if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){");
            sb.append("return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.f5371b);
            sb.append("=a;console.log(\"");
            sb.append(this.f5371b);
            sb.append(" initialization end\")})(window);");
            this.c = sb.toString();
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("JsCallJava--> init js error:" + e.getMessage());
        }
    }

    private String a(String str, int i, Object obj) {
        String format = String.format("{\"code\": %d, \"result\": %s}", Integer.valueOf(i), obj == null ? "null" : obj instanceof String ? "\"" + ((Object) ((String) obj).replace("\"", "\\\"")) + "\"" : ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) ? String.valueOf(obj) : "null");
        com.baidu.ufosdk.f.c.a("JsCallJava--> " + this.f5371b + " call json: " + str + " result:" + format);
        return format;
    }

    private static String a(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length <= 0 || parameterTypes[0] != WebView.class) {
            com.baidu.ufosdk.f.c.c("JsCallJava-->method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        for (int i = 1; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            name = cls == String.class ? name + "_S" : (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) ? name + "_N" : cls == Boolean.TYPE ? name + "_B" : cls == JSONObject.class ? name + "_O" : cls == c.class ? name + "_F" : name + "_P";
        }
        return name;
    }

    public final String a() {
        return this.c;
    }

    public final String a(WebView webView, String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return a(str, 500, "call data empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method");
            JSONArray jSONArray = jSONObject.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = webView;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String optString = jSONArray.optString(i2);
                if ("string".equals(optString)) {
                    string = string + "_S";
                    objArr[i2 + 1] = jSONArray2.isNull(i2) ? null : jSONArray2.getString(i2);
                    i = i3;
                } else if ("number".equals(optString)) {
                    string = string + "_N";
                    i = (i3 * 10) + i2 + 1;
                } else if ("boolean".equals(optString)) {
                    string = string + "_B";
                    objArr[i2 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i2));
                    i = i3;
                } else if ("object".equals(optString)) {
                    string = string + "_O";
                    objArr[i2 + 1] = jSONArray2.isNull(i2) ? null : jSONArray2.getJSONObject(i2);
                    i = i3;
                } else if ("function".equals(optString)) {
                    string = string + "_F";
                    objArr[i2 + 1] = new c(webView, this.f5371b, jSONArray2.getInt(i2));
                    i = i3;
                } else {
                    string = string + "_P";
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            Method method = (Method) this.f5370a.get(string);
            if (method == null) {
                return a(str, 500, "not found method(" + string + ") with valid parameters");
            }
            if (i3 > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (i3 > 0) {
                    int i4 = i3 - ((i3 / 10) * 10);
                    Class<?> cls = parameterTypes[i4];
                    if (cls == Integer.TYPE) {
                        objArr[i4] = Integer.valueOf(jSONArray2.getInt(i4 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i4] = Long.valueOf(Long.parseLong(jSONArray2.getString(i4 - 1)));
                    } else {
                        objArr[i4] = Double.valueOf(jSONArray2.getDouble(i4 - 1));
                    }
                    i3 /= 10;
                }
            }
            return a(str, 200, method.invoke(null, objArr));
        } catch (Exception e) {
            return e.getCause() != null ? a(str, 500, "method execute error:" + e.getCause().getMessage()) : a(str, 500, "method execute error:" + e.getMessage());
        }
    }
}
