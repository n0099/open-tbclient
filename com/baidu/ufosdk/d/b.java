package com.baidu.ufosdk.d;

import android.text.TextUtils;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f3708a;
    private String b;
    private String c;

    public b(String str, Class cls) {
        String a2;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.b = str;
            this.f3708a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.b);
            sb.append(" initialization begin\");");
            sb.append("var a={queue:[],callback:function(){");
            sb.append("var d=Array.prototype.slice.call(arguments,0);");
            sb.append("var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (a2 = a(method)) != null) {
                    this.f3708a.put(a2, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.b);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++)");
            sb.append("{var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\")");
            sb.append("{var d=a.queue.length;a.queue[d]=c;f[h]=d}}");
            sb.append("var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));");
            sb.append("if(g.code!=200){throw\"");
            sb.append(this.b);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};");
            sb.append("Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];");
            sb.append("if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){");
            sb.append("return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.b);
            sb.append("=a;console.log(\"");
            sb.append(this.b);
            sb.append(" initialization end\")})(window);");
            this.c = sb.toString();
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("JsCallJava--> init js error:" + e.getMessage());
        }
    }

    private String a(String str, int i, Object obj) {
        String format = String.format("{\"code\": %d, \"result\": %s}", Integer.valueOf(i), obj == null ? "null" : obj instanceof String ? "\"" + ((Object) ((String) obj).replace("\"", "\\\"")) + "\"" : ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) ? String.valueOf(obj) : "null");
        com.baidu.ufosdk.f.c.a("JsCallJava--> " + this.b + " call json: " + str + " result:" + format);
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
        String str = name;
        for (int i = 1; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            str = cls == String.class ? str + "_S" : (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) ? str + "_N" : cls == Boolean.TYPE ? str + "_B" : cls == JSONObject.class ? str + "_O" : cls == c.class ? str + "_F" : str + "_P";
        }
        return str;
    }

    public final String a() {
        return this.c;
    }

    public final String a(WebView webView, String str) {
        String str2;
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
            int i2 = 0;
            objArr[0] = webView;
            int i3 = 0;
            while (i3 < length) {
                String optString = jSONArray.optString(i3);
                if ("string".equals(optString)) {
                    String str3 = string + "_S";
                    objArr[i3 + 1] = jSONArray2.isNull(i3) ? null : jSONArray2.getString(i3);
                    int i4 = i2;
                    str2 = str3;
                    i = i4;
                } else if ("number".equals(optString)) {
                    i = (i2 * 10) + i3 + 1;
                    str2 = string + "_N";
                } else if ("boolean".equals(optString)) {
                    objArr[i3 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i3));
                    int i5 = i2;
                    str2 = string + "_B";
                    i = i5;
                } else if ("object".equals(optString)) {
                    String str4 = string + "_O";
                    objArr[i3 + 1] = jSONArray2.isNull(i3) ? null : jSONArray2.getJSONObject(i3);
                    int i6 = i2;
                    str2 = str4;
                    i = i6;
                } else if ("function".equals(optString)) {
                    objArr[i3 + 1] = new c(webView, this.b, jSONArray2.getInt(i3));
                    int i7 = i2;
                    str2 = string + "_F";
                    i = i7;
                } else {
                    int i8 = i2;
                    str2 = string + "_P";
                    i = i8;
                }
                i3++;
                string = str2;
                i2 = i;
            }
            Method method = (Method) this.f3708a.get(string);
            if (method == null) {
                return a(str, 500, "not found method(" + string + ") with valid parameters");
            }
            if (i2 > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (i2 > 0) {
                    int i9 = i2 - ((i2 / 10) * 10);
                    Class<?> cls = parameterTypes[i9];
                    if (cls == Integer.TYPE) {
                        objArr[i9] = Integer.valueOf(jSONArray2.getInt(i9 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i9] = Long.valueOf(Long.parseLong(jSONArray2.getString(i9 - 1)));
                    } else {
                        objArr[i9] = Double.valueOf(jSONArray2.getDouble(i9 - 1));
                    }
                    i2 /= 10;
                }
            }
            return a(str, 200, method.invoke(null, objArr));
        } catch (Exception e) {
            return e.getCause() != null ? a(str, 500, "method execute error:" + e.getCause().getMessage()) : a(str, 500, "method execute error:" + e.getMessage());
        }
    }
}
