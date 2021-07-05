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
/* loaded from: classes6.dex */
public class y extends a {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f27711h;

    /* renamed from: i  reason: collision with root package name */
    public WebView f27712i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131109227, "Lcom/bytedance/sdk/component/a/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131109227, "Lcom/bytedance/sdk/component/a/y;");
                return;
            }
        }
        j = !y.class.desiredAssertionStatus();
    }

    public y() {
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
            Context context = jVar.f27651e;
            if (context != null) {
                return context;
            }
            WebView webView = jVar.f27647a;
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
            this.f27712i = jVar.f27647a;
            this.f27711h = jVar.f27649c;
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
            if (!j && this.f27712i == null) {
                throw new AssertionError();
            }
            this.f27712i.addJavascriptInterface(this, this.f27711h);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27712i.removeJavascriptInterface(this.f27711h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27712i.getUrl() : (String) invokeV.objValue;
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
    public void a(String str, @Nullable p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, pVar) == null) {
            if (pVar != null && !TextUtils.isEmpty(pVar.f27663h)) {
                String str2 = pVar.f27663h;
                a(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
                return;
            }
            super.a(str, pVar);
        }
    }

    @Override // com.bytedance.sdk.component.a.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a(str, "javascript:" + this.f27711h + "._handleMessageFromToutiao(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) || this.f27615f || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable(this, str2) { // from class: com.bytedance.sdk.component.a.y.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f27713a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y f27714b;

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
                this.f27714b = this;
                this.f27713a = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f27714b.f27615f) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    i.a("Invoking Jsb using evaluateJavascript: " + this.f27713a);
                    this.f27714b.f27712i.evaluateJavascript(this.f27713a, null);
                    return;
                }
                i.a("Invoking Jsb using loadUrl: " + this.f27713a);
                this.f27714b.f27712i.loadUrl(this.f27713a);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            i.a("Received call on sub-thread, posting to main thread: " + str2);
            this.f27613d.post(runnable);
            return;
        }
        runnable.run();
    }
}
