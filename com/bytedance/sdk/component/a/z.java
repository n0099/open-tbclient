package com.bytedance.sdk.component.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ boolean f64197j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f64198h;

    /* renamed from: i  reason: collision with root package name */
    public WebView f64199i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131109196, "Lcom/bytedance/sdk/component/a/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131109196, "Lcom/bytedance/sdk/component/a/z;");
                return;
            }
        }
        f64197j = !z.class.desiredAssertionStatus();
    }

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    @NonNull
    public Context a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            Context context = jVar.f64135e;
            if (context != null) {
                return context;
            }
            WebView webView = jVar.f64131a;
            if (webView != null) {
                return webView.getContext();
            }
            throw new IllegalStateException("WebView cannot be null!");
        }
        return (Context) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.a.a
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void b(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f64199i = jVar.f64131a;
            this.f64198h = jVar.f64133c;
            if (Build.VERSION.SDK_INT < 17 || jVar.n) {
                return;
            }
            c();
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!f64197j && this.f64199i == null) {
                throw new AssertionError();
            }
            this.f64199i.addJavascriptInterface(this, this.f64198h);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64199i.removeJavascriptInterface(this.f64198h);
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    @JavascriptInterface
    public void invokeMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            super.invokeMethod(str);
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64199i.getUrl() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b();
            d();
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    public void a(String str, @Nullable q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, qVar) == null) {
            if (qVar != null && !TextUtils.isEmpty(qVar.f64149h)) {
                String str2 = qVar.f64149h;
                a(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
                return;
            }
            super.a(str, qVar);
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a(str, "javascript:" + this.f64198h + "._handleMessageFromToutiao(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) || this.f64098f || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable(this, str2) { // from class: com.bytedance.sdk.component.a.z.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f64200a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ z f64201b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64201b = this;
                this.f64200a = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f64201b.f64098f) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    i.a("Invoking Jsb using evaluateJavascript: " + this.f64200a);
                    this.f64201b.f64199i.evaluateJavascript(this.f64200a, null);
                    return;
                }
                i.a("Invoking Jsb using loadUrl: " + this.f64200a);
                this.f64201b.f64199i.loadUrl(this.f64200a);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            i.a("Received call on sub-thread, posting to main thread: " + str2);
            this.f64096d.post(runnable);
            return;
        }
        runnable.run();
    }
}
