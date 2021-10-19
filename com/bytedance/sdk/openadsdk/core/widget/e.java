package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
/* loaded from: classes9.dex */
public class e extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f67684a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67685b;

    /* renamed from: c  reason: collision with root package name */
    public Button f67686c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67687d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67688e;

    /* renamed from: f  reason: collision with root package name */
    public TTRoundRectImageView f67689f;

    /* renamed from: g  reason: collision with root package name */
    public Context f67690g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67691h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f67692i;

    /* renamed from: j  reason: collision with root package name */
    public String f67693j;
    public String k;
    public String l;
    public String m;
    public a n;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context, t.g(context, "tt_dialog_full"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f67690g = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.f67690g == null) {
                this.f67690g = o.a();
            }
            TextView textView = this.f67684a;
            if (textView != null) {
                textView.setText(this.f67693j);
            }
            if (this.f67689f != null && !TextUtils.isEmpty(this.l)) {
                ImageLoaderWrapper.from(this.l).to(this.f67689f);
            }
            if (this.f67692i != null) {
                String a2 = t.a(this.f67690g, "tt_open_app_detail_developer");
                this.f67692i.setText(TextUtils.isEmpty(this.m) ? String.format(a2, "补充中，可于应用官网查看") : String.format(a2, this.m));
            }
            if (this.f67685b != null) {
                String a3 = t.a(this.f67690g, "tt_open_app_version");
                this.f67685b.setText(TextUtils.isEmpty(this.k) ? String.format(a3, "暂无") : String.format(a3, this.k));
            }
        }
    }

    public e c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.c(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f67690g, "tt_common_download_dialog"));
            setCanceledOnTouchOutside(false);
            a();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.show();
            b();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f67684a = (TextView) findViewById(t.e(this.f67690g, "tt_download_title"));
            this.f67687d = (TextView) findViewById(t.e(this.f67690g, "tt_download_app_detail"));
            this.f67686c = (Button) findViewById(t.e(this.f67690g, "tt_download_btn"));
            this.f67685b = (TextView) findViewById(t.e(this.f67690g, "tt_download_app_version"));
            this.f67688e = (TextView) findViewById(t.e(this.f67690g, "tt_download_cancel"));
            this.f67691h = (TextView) findViewById(t.e(this.f67690g, "tt_download_app_privacy"));
            this.f67692i = (TextView) findViewById(t.e(this.f67690g, "tt_download_app_developer"));
            this.f67689f = (TTRoundRectImageView) findViewById(t.e(this.f67690g, "tt_download_icon"));
            this.f67686c.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67694a;

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
                    this.f67694a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67694a.n == null) {
                        return;
                    }
                    this.f67694a.n.a(this.f67694a);
                }
            });
            this.f67687d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67695a;

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
                    this.f67695a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67695a.n == null) {
                        return;
                    }
                    this.f67695a.n.b(this.f67695a);
                }
            });
            this.f67688e.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67696a;

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
                    this.f67696a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67696a.n == null) {
                        return;
                    }
                    this.f67696a.n.c(this.f67696a);
                }
            });
            this.f67691h.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f67697a;

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
                    this.f67697a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67697a.n == null) {
                        return;
                    }
                    this.f67697a.n.d(this.f67697a);
                }
            });
        }
    }

    public e a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f67693j = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.n = aVar;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (e) invokeL.objValue;
    }
}
