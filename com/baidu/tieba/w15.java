package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class w15 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Dialog a;
    public TbWebView b;
    public boolean c;

    /* loaded from: classes8.dex */
    public static final class a implements rs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final w15 a;

        public a(w15 dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.a = dialog;
        }

        @Override // com.baidu.tieba.rs4
        public gxa a(WebView webView, String nextPage, String source) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, nextPage, source)) == null) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                Intrinsics.checkNotNullParameter(nextPage, "nextPage");
                Intrinsics.checkNotNullParameter(source, "source");
                this.a.g();
                return new gxa();
            }
            return (gxa) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.rs4
        public gxa b(WebView webView, String link, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, link, i)) == null) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                Intrinsics.checkNotNullParameter(link, "link");
                if (!TextUtils.isEmpty(link)) {
                    Context a = bj6.a(webView.getContext());
                    if (a == null) {
                        a = webView.getContext();
                    }
                    BrowserHelper.startWebActivity(a, link);
                    if (i == 1) {
                        this.a.g();
                    }
                }
                return new gxa();
            }
            return (gxa) invokeLLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w15 a;
        public final /* synthetic */ String b;

        public b(w15 w15Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w15Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w15Var;
            this.b = str;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view2, String url) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, url) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                super.onPageFinished(view2, url);
                if (!this.a.c) {
                    this.a.h();
                    TbWebView tbWebView = this.a.b;
                    Activity activity = null;
                    if (tbWebView != null) {
                        context = tbWebView.getContext();
                    } else {
                        context = null;
                    }
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                    if (activity == null) {
                        activity = TbadkCoreApplication.getInst().getCurrentActivity();
                    }
                    if (yb.i(this.a.a, activity)) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 真实渲染");
                        return;
                    }
                    YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 真实渲染失败");
                    return;
                }
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 已经关闭");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.a.g();
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 渲染结果：onReceivedError");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceResponse) == null) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                this.a.g();
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 渲染结果：onReceivedHttpError");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.a.g();
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗2 " + this.b + " 渲染结果：onReceivedSslError");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w15 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, w15 w15Var, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, w15Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w15Var;
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onDetachedFromWindow();
                this.a.g();
            }
        }
    }

    public w15() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public final void h() {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Dialog dialog = this.a;
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
            }
            i();
        }
    }

    public final void i() {
        Dialog dialog;
        Window window;
        WindowManager.LayoutParams attributes;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dialog = this.a) != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -1;
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
        }
    }

    public static final void k(w15 this$0, WebView webView) {
        cl6 cl6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, webView) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (webView instanceof cl6) {
                cl6Var = (cl6) webView;
            } else {
                cl6Var = null;
            }
            if (cl6Var != null) {
                cl6Var.setJSPromptRedirector(new a(this$0));
            }
        }
    }

    public final void j(String str, String str2) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && (tbWebView = this.b) != null) {
            tbWebView.setWebViewClient(new b(this, str));
            tbWebView.F(new gg6() { // from class: com.baidu.tieba.h15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gg6
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        w15.k(w15.this, (WebView) obj);
                    }
                }
            });
            tbWebView.loadUrl(str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
        if (r6 == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean n(w15 this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        InterceptResult invokeLLIL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65543, null, this$0, dialogInterface, i, keyEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z3 = true;
            if (i == 4) {
                TbWebView tbWebView = this$0.b;
                if (tbWebView != null) {
                    if (tbWebView.getVisibility() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                    }
                }
                z = false;
            }
            z3 = false;
            if (z3) {
                this$0.g();
            }
            return z3;
        }
        return invokeLLIL.booleanValue;
    }

    public static final void o(w15 this$0, String dialogName, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, this$0, dialogName, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dialogName, "$dialogName");
            TbWebView tbWebView = this$0.b;
            if (tbWebView != null) {
                tbWebView.onDestroy();
            }
            this$0.b = null;
            YunDialogManager.unMarkShowingDialogName(dialogName);
            YunDialogManager.markIsBackFromYunDialog(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921753, dialogName));
        }
    }

    @Override // com.baidu.tieba.j15
    public void a(Context context, x05 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String dialogName = data.a("yun_dialogName");
            String url = data.a("yun_dialogUrl");
            if (!TextUtils.isEmpty(dialogName) && !TextUtils.isEmpty(url)) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                Intrinsics.checkNotNullExpressionValue(dialogName, "dialogName");
                m(context, url, dialogName);
            }
        }
    }

    public final void l(Context context, final String str) {
        Dialog dialog;
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) && (dialog = this.a) != null) {
            dialog.requestWindowFeature(1);
            TbWebView tbWebView = this.b;
            if (tbWebView != null) {
                dialog.setContentView(tbWebView);
            }
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.g15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? w15.n(w15.this, dialogInterface, i, keyEvent) : invokeLIL.booleanValue;
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.e15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        w15.o(w15.this, str, dialogInterface);
                    }
                }
            });
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                activity = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            i();
            boolean i = yb.i(dialog, activity);
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗2 " + str + " 渲染结果：" + i);
            if (i) {
                Dialog dialog2 = this.a;
                if (dialog2 != null) {
                    dialog2.hide();
                }
                YunDialogManager.markShowingDialogName(str);
                return;
            }
            this.c = true;
        }
    }

    public final void m(Context context, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, str2) == null) {
            if (this.b == null) {
                this.b = new TbWebView(context);
            }
            if (this.a == null) {
                this.a = new c(context, this, R.style.obfuscated_res_0x7f1003b1);
            }
            if (StringsKt__StringsKt.indexOf$default((CharSequence) str, "?", 0, false, 6, (Object) null) > 0) {
                str3 = str + "&page_type=open_full_screen_opacity_web_page";
            } else {
                str3 = str + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
            }
            j(str2, str3);
            l(context, str2);
        }
    }
}
