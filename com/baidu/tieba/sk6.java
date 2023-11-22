package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MonitorWebView a;
    public lj6 b;
    public kj6 c;

    public sk6() {
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
            lj6 lj6Var = this.b;
            if (lj6Var != null) {
                c(lj6Var);
            }
            kj6 kj6Var = this.c;
            if (kj6Var != null) {
                b(kj6Var);
            }
        }
    }

    public void b(@NonNull kj6 kj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kj6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.c = kj6Var;
            } else if (monitorWebView.v >= 2) {
                kj6Var.onPageFinished(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageFinishedListener(kj6Var);
            } else {
                monitorWebView.setOnPageFinishedListener(kj6Var);
            }
        }
    }

    public void c(@NonNull lj6 lj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lj6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.b = lj6Var;
            } else if (monitorWebView.v >= 1) {
                lj6Var.a(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageStartedListener(lj6Var);
            } else {
                monitorWebView.setOnPageStartedListener(lj6Var);
            }
        }
    }
}
