package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
/* loaded from: classes9.dex */
public class d extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f67637a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f67638b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67639c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67640d;

    /* renamed from: e  reason: collision with root package name */
    public Button f67641e;

    /* renamed from: f  reason: collision with root package name */
    public Button f67642f;

    /* renamed from: g  reason: collision with root package name */
    public View f67643g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67644h;

    /* renamed from: i  reason: collision with root package name */
    public String f67645i;

    /* renamed from: j  reason: collision with root package name */
    public String f67646j;
    public String k;
    public String l;
    public int m;
    public boolean n;

    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, t.g(context, "tt_custom_dialog"));
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
        this.m = -1;
        this.n = false;
        this.f67644h = context;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f67642f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67647a;

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
                    this.f67647a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f67647a.f67637a) == null) {
                        return;
                    }
                    aVar.a();
                }
            });
            this.f67641e.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67648a;

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
                    this.f67648a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f67648a.f67637a) == null) {
                        return;
                    }
                    aVar.b();
                }
            });
        }
    }

    private void b() {
        Button button;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.f67639c != null) {
                if (!TextUtils.isEmpty(this.f67646j)) {
                    this.f67639c.setText(this.f67646j);
                    this.f67639c.setVisibility(0);
                } else {
                    this.f67639c.setVisibility(8);
                }
            }
            if (this.f67640d != null && !TextUtils.isEmpty(this.f67645i)) {
                this.f67640d.setText(this.f67645i);
            }
            if (this.f67642f != null) {
                if (!TextUtils.isEmpty(this.k)) {
                    this.f67642f.setText(this.k);
                } else {
                    this.f67642f.setText("确定");
                }
            }
            if (this.f67641e != null) {
                if (!TextUtils.isEmpty(this.l)) {
                    this.f67641e.setText(this.l);
                } else {
                    this.f67641e.setText("取消");
                }
            }
            ImageView imageView = this.f67638b;
            if (imageView != null) {
                int i2 = this.m;
                if (i2 != -1) {
                    imageView.setImageResource(i2);
                    this.f67638b.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            View view = this.f67643g;
            if (view == null || (button = this.f67641e) == null) {
                return;
            }
            if (this.n) {
                view.setVisibility(8);
                this.f67641e.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            this.f67643g.setVisibility(0);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f67641e = (Button) findViewById(t.e(this.f67644h, "tt_negtive"));
            this.f67642f = (Button) findViewById(t.e(this.f67644h, "tt_positive"));
            this.f67639c = (TextView) findViewById(t.e(this.f67644h, "tt_title"));
            this.f67640d = (TextView) findViewById(t.e(this.f67644h, "tt_message"));
            this.f67638b = (ImageView) findViewById(t.e(this.f67644h, "tt_image"));
            this.f67643g = findViewById(t.e(this.f67644h, "tt_column_line"));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f67644h, "tt_custom_dailog_layout"));
            setCanceledOnTouchOutside(false);
            c();
            b();
            a();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.show();
            b();
        }
    }

    public d a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.f67637a = aVar;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f67645i = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (d) invokeL.objValue;
    }
}
