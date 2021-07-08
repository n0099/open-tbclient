package com.baidu.webkit.internal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f27385a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f27386b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f27387c;

    /* renamed from: d  reason: collision with root package name */
    public String f27388d;
    @SuppressLint({"SdCardPath"})

    /* renamed from: e  reason: collision with root package name */
    public String f27389e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27390f;

    /* renamed from: g  reason: collision with root package name */
    public String f27391g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27392h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27393i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1520748685, "Lcom/baidu/webkit/internal/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1520748685, "Lcom/baidu/webkit/internal/a;");
                return;
            }
        }
        f27385a = WebChromeClient.MSG_PROMPT_HEADER.toLowerCase();
    }

    public a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27389e = "/data/data/";
        this.f27390f = true;
        this.f27392h = true;
        this.f27393i = true;
        this.f27387c = webView;
        try {
            this.f27389e += webView.getContext().getPackageName();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(StringBuilder sb, Object obj, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, sb, obj, str) == null) || obj == null || TextUtils.isEmpty(str)) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window." + str + ")=='undefined'){");
        sb.append("window.");
        sb.append(str);
        sb.append("={");
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet();
        for (Method method : methods) {
            if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) != null) {
                String name = method.getName();
                if (!hashSet.contains(name)) {
                    hashSet.add(name);
                    sb.append(name);
                    sb.append(":function(){");
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("return ");
                    }
                    sb.append("prompt('");
                    sb.append(f27385a);
                    sb.append("'+");
                    sb.append("JSON.stringify({");
                    sb.append("obj:'");
                    sb.append(str);
                    sb.append("',");
                    sb.append("func:'");
                    sb.append(name);
                    sb.append("',");
                    sb.append("args:Array.prototype.slice.call(arguments)");
                    sb.append("})");
                    sb.append(");");
                    sb.append("},");
                }
            }
        }
        int length = sb.length() - 1;
        if (sb.charAt(length) == ',') {
            sb.deleteCharAt(length);
        }
        sb.append("};");
        sb.append("}");
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 17 : invokeV.booleanValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || !this.f27393i || str == null || str.startsWith("javascript")) {
            return;
        }
        this.f27391g = str;
        WebView webView = this.f27387c;
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        if (!this.f27391g.startsWith("file://")) {
            this.f27387c.getSettings().setJavaScriptEnabled(true);
            return;
        }
        boolean z = false;
        try {
            if (WebViewFactory.hasProvider()) {
                z = ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:".concat(String.valueOf(th)));
        }
        this.f27387c.getSettings().setJavaScriptEnabled(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z == this.f27390f) {
            return;
        }
        if (z) {
            throw new RuntimeException("can not reverse!!");
        }
        this.f27390f = z;
        for (String str : d().keySet()) {
            this.f27387c.addJavascriptInterface(d().get(str), str, false);
        }
        HashMap<String, Object> hashMap = this.f27386b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f27388d = null;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27390f && (g() ^ true) : invokeV.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f27392h = z;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27392h : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f27392h && a()) {
            String str = this.f27388d;
            if (str != null) {
                this.f27387c.execJavaScript(str);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str2 : d().keySet()) {
                try {
                    a(sb, d().get(str2), str2);
                } catch (JSONException unused) {
                }
            }
            sb.append("}");
            sb.append(")()");
            String sb2 = sb.toString();
            this.f27388d = sb2;
            this.f27387c.execJavaScript(sb2);
        }
    }

    public final HashMap<String, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f27386b == null) {
                this.f27386b = new HashMap<>();
            }
            return this.f27386b;
        }
        return (HashMap) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (g()) {
                return false;
            }
            this.f27387c.removeJavascriptInterface("searchBoxJavaBridge_");
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && e()) {
            new Thread(new Runnable(this) { // from class: com.baidu.webkit.internal.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f27394a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27394a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i2 = 0; i2 < 100; i2++) {
                            try {
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (this.f27394a.f27387c != null && !this.f27394a.f27387c.isDestroyed()) {
                                this.f27394a.e();
                                Thread.sleep(20L);
                            }
                            return;
                        }
                    }
                }
            }, "T7@removeSearchBoxImpl").start();
        }
    }
}
