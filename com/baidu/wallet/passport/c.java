package com.baidu.wallet.passport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, sapiWebView) == null) {
            d(context, sapiWebView);
        }
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, sapiWebView) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtils.layout(context, "wallet_login_sapi_exception"), (ViewGroup) null);
            inflate.findViewById(ResUtils.id(context, "exception_try_again")).setOnClickListener(new View.OnClickListener(inflate, sapiWebView) { // from class: com.baidu.wallet.passport.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f25725a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SapiWebView f25726b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {inflate, sapiWebView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25725a = inflate;
                    this.f25726b = sapiWebView;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f25725a.setVisibility(4);
                        this.f25726b.reload();
                    }
                }
            });
            inflate.findViewById(ResUtils.id(context, "exception_try_again")).setVisibility(8);
            sapiWebView.setNoNetworkView(inflate);
        }
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, sapiWebView) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtils.layout(context, "wallet_login_sapi_exception"), (ViewGroup) null);
            Button button = (Button) inflate.findViewById(ResUtils.id(context, "exception_try_again"));
            button.setOnClickListener(new View.OnClickListener(sapiWebView, inflate) { // from class: com.baidu.wallet.passport.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SapiWebView f25727a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f25728b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sapiWebView, inflate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25727a = sapiWebView;
                    this.f25728b = inflate;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f25727a.post(new Runnable(this) { // from class: com.baidu.wallet.passport.c.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f25729a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25729a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f25729a.f25728b.setVisibility(4);
                                    this.f25729a.f25727a.reload();
                                }
                            }
                        });
                    }
                }
            });
            button.setVisibility(8);
            sapiWebView.setTimeoutView(inflate);
        }
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, context, sapiWebView) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 4, 0, 0));
            sapiWebView.setProgressBar(progressBar);
        }
    }
}
