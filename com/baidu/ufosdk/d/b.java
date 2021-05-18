package com.baidu.ufosdk.d;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f22571a;

    /* renamed from: b  reason: collision with root package name */
    public String f22572b;

    /* renamed from: c  reason: collision with root package name */
    public String f22573c;

    public b(String str, Class cls) {
        String a2;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f22572b = str;
            this.f22571a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.f22572b);
            sb.append(" initialization begin\");");
            sb.append("var a={queue:[],callback:function(){");
            sb.append("var d=Array.prototype.slice.call(arguments,0);");
            sb.append("var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (a2 = a(method)) != null) {
                    this.f22571a.put(a2, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.f22572b);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++)");
            sb.append("{var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\")");
            sb.append("{var d=a.queue.length;a.queue[d]=c;f[h]=d}}");
            sb.append("var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));");
            sb.append("if(g.code!=200){throw\"");
            sb.append(this.f22572b);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};");
            sb.append("Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];");
            sb.append("if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){");
            sb.append("return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.f22572b);
            sb.append("=a;console.log(\"");
            sb.append(this.f22572b);
            sb.append(" initialization end\")})(window);");
            this.f22573c = sb.toString();
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.d("JsCallJava--> init js error:" + e2.getMessage());
        }
    }

    private String a(String str, int i2, Object obj) {
        String str2 = StringUtil.NULL_STRING;
        if (obj != null) {
            if (obj instanceof String) {
                String replace = ((String) obj).replace("\"", "\\\"");
                str2 = "\"" + ((Object) replace) + "\"";
            } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) {
                str2 = String.valueOf(obj);
            }
        }
        String format = String.format("{\"code\": %d, \"result\": %s}", Integer.valueOf(i2), str2);
        com.baidu.ufosdk.f.c.a("JsCallJava--> " + this.f22572b + " call json: " + str + " result:" + format);
        return format;
    }

    public static String a(Method method) {
        StringBuilder sb;
        String str;
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length <= 0 || parameterTypes[0] != WebView.class) {
            com.baidu.ufosdk.f.c.c("JsCallJava-->method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        for (int i2 = 1; i2 < length; i2++) {
            Class<?> cls = parameterTypes[i2];
            if (cls == String.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_N";
            } else if (cls == Boolean.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_B";
            } else if (cls == JSONObject.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_O";
            } else if (cls == c.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_F";
            } else {
                sb = new StringBuilder();
                sb.append(name);
                str = "_P";
            }
            sb.append(str);
            name = sb.toString();
        }
        return name;
    }

    public final String a() {
        return this.f22573c;
    }

    public final String a(WebView webView, String str) {
        StringBuilder sb;
        String message;
        String sb2;
        if (TextUtils.isEmpty(str)) {
            sb2 = "call data empty";
        } else {
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
                while (true) {
                    Object obj = null;
                    if (i2 >= length) {
                        break;
                    }
                    String optString = jSONArray.optString(i2);
                    if ("string".equals(optString)) {
                        string = string + "_S";
                        int i4 = i2 + 1;
                        if (!jSONArray2.isNull(i2)) {
                            obj = jSONArray2.getString(i2);
                        }
                        objArr[i4] = obj;
                    } else if (IdCardActivity.KEY_NUMBER.equals(optString)) {
                        string = string + "_N";
                        i3 = (i3 * 10) + i2 + 1;
                    } else if ("boolean".equals(optString)) {
                        string = string + "_B";
                        objArr[i2 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i2));
                    } else if ("object".equals(optString)) {
                        string = string + "_O";
                        int i5 = i2 + 1;
                        if (!jSONArray2.isNull(i2)) {
                            obj = jSONArray2.getJSONObject(i2);
                        }
                        objArr[i5] = obj;
                    } else if ("function".equals(optString)) {
                        string = string + "_F";
                        objArr[i2 + 1] = new c(webView, this.f22572b, jSONArray2.getInt(i2));
                    } else {
                        string = string + "_P";
                    }
                    i2++;
                }
                Method method = (Method) this.f22571a.get(string);
                if (method == null) {
                    return a(str, 500, "not found method(" + string + ") with valid parameters");
                }
                if (i3 > 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    while (i3 > 0) {
                        int i6 = i3 - ((i3 / 10) * 10);
                        Class<?> cls = parameterTypes[i6];
                        if (cls == Integer.TYPE) {
                            objArr[i6] = Integer.valueOf(jSONArray2.getInt(i6 - 1));
                        } else if (cls == Long.TYPE) {
                            objArr[i6] = Long.valueOf(Long.parseLong(jSONArray2.getString(i6 - 1)));
                        } else {
                            objArr[i6] = Double.valueOf(jSONArray2.getDouble(i6 - 1));
                        }
                        i3 /= 10;
                    }
                }
                return a(str, 200, method.invoke(null, objArr));
            } catch (Exception e2) {
                if (e2.getCause() != null) {
                    sb = new StringBuilder("method execute error:");
                    message = e2.getCause().getMessage();
                } else {
                    sb = new StringBuilder("method execute error:");
                    message = e2.getMessage();
                }
                sb.append(message);
                sb2 = sb.toString();
            }
        }
        return a(str, 500, sb2);
    }
}
