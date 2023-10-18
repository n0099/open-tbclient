package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MonitorWebView a;
    public oh6 b;
    public nh6 c;

    public vi6() {
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
            oh6 oh6Var = this.b;
            if (oh6Var != null) {
                c(oh6Var);
            }
            nh6 nh6Var = this.c;
            if (nh6Var != null) {
                b(nh6Var);
            }
        }
    }

    public void b(@NonNull nh6 nh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nh6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.c = nh6Var;
            } else if (monitorWebView.q >= 2) {
                nh6Var.onPageFinished(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageFinishedListener(nh6Var);
            } else {
                monitorWebView.setOnPageFinishedListener(nh6Var);
            }
        }
    }

    public void c(@NonNull oh6 oh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oh6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.b = oh6Var;
            } else if (monitorWebView.q >= 1) {
                oh6Var.a(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageStartedListener(oh6Var);
            } else {
                monitorWebView.setOnPageStartedListener(oh6Var);
            }
        }
    }
}
