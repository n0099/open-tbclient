package com.bytedance.sdk.openadsdk.core.dynamic.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.b;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.q.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static String f30070e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f30071f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30072a;

    /* renamed from: b  reason: collision with root package name */
    public SSWebView f30073b;

    /* renamed from: c  reason: collision with root package name */
    public String f30074c;

    /* renamed from: d  reason: collision with root package name */
    public b f30075d;

    /* renamed from: com.bytedance.sdk.openadsdk.core.dynamic.c.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.dynamic.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0340a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30076a;

        public C0340a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30076a = aVar;
        }

        @JavascriptInterface
        public void calculateResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f30076a.c(str);
            }
        }

        @JavascriptInterface
        public String getDomSizeFromNative(String str, String str2, String str3, boolean z, boolean z2, int i2) {
            InterceptResult invokeCommon;
            double d2;
            double d3;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
                JSONObject jSONObject = new JSONObject();
                k.f("DynamicBaseWidget", "getDomSizeFromNative String brickType==" + str2);
                k.f("DynamicBaseWidget", "getDomSizeFromNative String str==" + str);
                if (!str.startsWith("<svg") && !a.f30071f.contains(str2)) {
                    if ("logo".equals(str2)) {
                        jSONObject.put("width", "union".equals(str) ? 10.0d : 20.0d);
                        jSONObject.put("height", 10.0d);
                        return jSONObject.toString();
                    }
                    JSONObject jSONObject2 = new JSONObject(str3);
                    int length = str.length();
                    float optDouble = (float) jSONObject2.optDouble("fontSize");
                    float optDouble2 = (float) jSONObject2.optDouble("letterSpacing");
                    float optDouble3 = (float) jSONObject2.optDouble("lineHeight");
                    float optDouble4 = (float) jSONObject2.optDouble("maxWidth");
                    double d4 = (length * (optDouble + optDouble2)) - optDouble2;
                    k.f("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + optDouble2 + ",lineHeight==" + optDouble3 + ",maxWidth ==" + optDouble4 + ",totalStrLength" + d4);
                    if (z) {
                        d3 = optDouble4;
                        int i4 = ((int) (d4 / d3)) + 1;
                        if (!z2 || i4 < (i3 = i2)) {
                            i3 = i4;
                        }
                        d2 = optDouble3 * optDouble * i3 * 1.2d;
                    } else {
                        d2 = optDouble3 * optDouble * 1.2d;
                        double d5 = optDouble4;
                        if (d4 > d5) {
                            d4 = d5;
                        }
                        d3 = d4;
                    }
                    jSONObject.put("width", d3);
                    jSONObject.put("height", d2);
                    k.f("DynamicBaseWidget", "getDomSizeFromNative fontSize==" + optDouble + ",width==" + d3 + ",height ==" + d2);
                    return jSONObject.toString();
                }
                jSONObject.put("width", 10.0d);
                jSONObject.put("height", 10.0d);
                return jSONObject.toString();
            }
            return (String) invokeCommon.objValue;
        }

        @JavascriptInterface
        public String jsCoreGlobal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", s.c(o.a(), s.c(this.f30076a.f30072a)));
                    jSONObject.put("height", s.c(o.a(), s.d(this.f30076a.f30072a)));
                    jSONObject.put(IAdRequestParam.OS, "Android");
                } catch (Exception unused) {
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public double systemFontSizeRatioNative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 1.2d;
            }
            return invokeV.doubleValue;
        }

        public /* synthetic */ C0340a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702928497, "Lcom/bytedance/sdk/openadsdk/core/dynamic/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(702928497, "Lcom/bytedance/sdk/openadsdk/core/dynamic/c/a;");
                return;
            }
        }
        f30071f = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", IntentConfig.CLOSE, "close-fill")));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30072a = context;
        SSWebView sSWebView = new SSWebView(this.f30072a);
        this.f30073b = sSWebView;
        sSWebView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f30073b.addJavascriptInterface(new C0340a(this, null), "JS_DYNAMIC_LAYOUT_OBJ");
        }
        this.f30073b.loadUrl("about:blank");
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (i() && Build.VERSION.SDK_INT >= 19) {
                String f2 = f();
                String h2 = h();
                if (TextUtils.isEmpty(h2)) {
                    c();
                    return;
                }
                SSWebView sSWebView = this.f30073b;
                sSWebView.evaluateJavascript(f2 + h2, null);
                return;
            }
            c();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String e2 = e();
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            j.a(this.f30073b, e2);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            j.a(this.f30073b, "javascript:var res = getLayoutInfo(" + this.f30074c + ");window.JS_DYNAMIC_LAYOUT_OBJ.calculateResult(JSON.stringify(res));");
        }
    }

    public static String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (TextUtils.isEmpty(f30070e)) {
                return null;
            }
            String f2 = f();
            if (i()) {
                str = "(function () {var se = document.createElement('script');se.type = 'text/javascript';se.src = '" + ("file//" + com.bytedance.sdk.openadsdk.core.widget.webview.a.b.e() + "/" + e.a(f30070e)) + "';document.body.appendChild(se);})();";
            } else {
                str = "(function () {var JS_TTDYNAMIC_URL = '" + f30070e + "';var xhrObj = new XMLHttpRequest();xhrObj.open('GET', JS_TTDYNAMIC_URL, false);xhrObj.send('');var se = document.createElement('script');se.type = 'text/javascript';se.text = xhrObj.responseText;document.getElementsByTagName('head')[0].appendChild(se);})();";
            }
            return "javascript:" + f2 + str;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return "var global = Function('return this')();global.jsCoreGlobal = {width:" + s.c(o.a(), s.c(o.a())) + ",height:" + s.c(o.a(), s.d(o.a())) + ",os:'Android'};global.systemFontSizeRatioNative = 1.2;";
        }
        return (String) invokeV.objValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            aa.a(this.f30072a, this.f30073b);
            aa.a(this.f30073b);
            this.f30073b = null;
        }
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            try {
                return com.bytedance.sdk.openadsdk.n.g.a.a(new FileInputStream(com.bytedance.sdk.openadsdk.core.widget.webview.a.b.e() + "/" + e.a(f30070e)));
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (TextUtils.isEmpty(f30070e)) {
                return false;
            }
            String a2 = e.a(f30070e);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return new File(com.bytedance.sdk.openadsdk.core.widget.webview.a.b.e(), a2).exists();
        }
        return invokeV.booleanValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f30070e = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            f fVar = new f();
            try {
                f.a(new JSONObject(str), fVar);
            } catch (Exception unused) {
                fVar = null;
            }
            b bVar = this.f30075d;
            if (bVar != null) {
                bVar.a(fVar);
            }
            g();
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f30075d = bVar;
        }
    }

    public void b(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f30074c = str;
            if (TextUtils.isEmpty(f30070e) && (bVar = this.f30075d) != null) {
                bVar.a(null);
                g();
            }
            d();
        }
    }
}
