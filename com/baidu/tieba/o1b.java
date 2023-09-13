package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class o1b extends io6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbWebView d;
    public final HashSet<String> e;

    public abstract void i(WebView webView, String str);

    public abstract void j(WebView webView, String str);

    public o1b(TbWebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.d = webView;
        HashSet<String> hashSet = new HashSet<>();
        this.e = hashSet;
        hashSet.add("onPageStarted");
        this.e.add("onPageFinished");
        this.e.add("onAddView");
        this.e.add("onDraftLoad");
        this.d.n(this);
        c(new bn6() { // from class: com.baidu.tieba.k1b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bn6
            public final void c(WebView webView2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView2, str) == null) {
                    o1b.d(o1b.this, webView2, str);
                }
            }
        });
        b(new an6() { // from class: com.baidu.tieba.i1b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.an6
            public final void onPageFinished(WebView webView2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView2, str) == null) {
                    o1b.e(o1b.this, webView2, str);
                }
            }
        });
    }

    public static final void d(o1b this$0, WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this$0, webView, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j(webView, str);
            this$0.f("onPageStarted");
        }
    }

    public static final void e(o1b this$0, WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, webView, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i(webView, str);
            this$0.f("onPageFinished");
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e.remove(str);
            if (this.e.isEmpty()) {
                um6.a().i(this.d, "writePageNa.pageReady", new JSONObject());
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f("onAddView");
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f("onDraftLoad");
        }
    }
}
