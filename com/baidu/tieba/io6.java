package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class io6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MonitorWebView a;
    public bn6 b;
    public an6 c;

    public io6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void a(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, monitorWebView) == null) {
            this.a = monitorWebView;
            bn6 bn6Var = this.b;
            if (bn6Var != null) {
                c(bn6Var);
            }
            an6 an6Var = this.c;
            if (an6Var != null) {
                b(an6Var);
            }
        }
    }

    public void b(@NonNull an6 an6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.c = an6Var;
            } else if (monitorWebView.q >= 2) {
                an6Var.onPageFinished(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageFinishedListener(an6Var);
            } else {
                monitorWebView.setOnPageFinishedListener(an6Var);
            }
        }
    }

    public void c(@NonNull bn6 bn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bn6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.b = bn6Var;
            } else if (monitorWebView.q >= 1) {
                bn6Var.c(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageStartedListener(bn6Var);
            } else {
                monitorWebView.setOnPageStartedListener(bn6Var);
            }
        }
    }
}
