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
/* loaded from: classes5.dex */
public class d extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f31014a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31015b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31016c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31017d;

    /* renamed from: e  reason: collision with root package name */
    public Button f31018e;

    /* renamed from: f  reason: collision with root package name */
    public Button f31019f;

    /* renamed from: g  reason: collision with root package name */
    public View f31020g;

    /* renamed from: h  reason: collision with root package name */
    public Context f31021h;

    /* renamed from: i  reason: collision with root package name */
    public String f31022i;
    public String j;
    public String k;
    public String l;
    public int m;
    public boolean n;

    /* loaded from: classes5.dex */
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
        this.f31021h = context;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f31019f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31023a;

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
                    this.f31023a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f31023a.f31014a) == null) {
                        return;
                    }
                    aVar.a();
                }
            });
            this.f31018e.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31024a;

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
                    this.f31024a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f31024a.f31014a) == null) {
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
            if (this.f31016c != null) {
                if (!TextUtils.isEmpty(this.j)) {
                    this.f31016c.setText(this.j);
                    this.f31016c.setVisibility(0);
                } else {
                    this.f31016c.setVisibility(8);
                }
            }
            if (this.f31017d != null && !TextUtils.isEmpty(this.f31022i)) {
                this.f31017d.setText(this.f31022i);
            }
            if (this.f31019f != null) {
                if (!TextUtils.isEmpty(this.k)) {
                    this.f31019f.setText(this.k);
                } else {
                    this.f31019f.setText("确定");
                }
            }
            if (this.f31018e != null) {
                if (!TextUtils.isEmpty(this.l)) {
                    this.f31018e.setText(this.l);
                } else {
                    this.f31018e.setText("取消");
                }
            }
            ImageView imageView = this.f31015b;
            if (imageView != null) {
                int i2 = this.m;
                if (i2 != -1) {
                    imageView.setImageResource(i2);
                    this.f31015b.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            View view = this.f31020g;
            if (view == null || (button = this.f31018e) == null) {
                return;
            }
            if (this.n) {
                view.setVisibility(8);
                this.f31018e.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            this.f31020g.setVisibility(0);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f31018e = (Button) findViewById(t.e(this.f31021h, "tt_negtive"));
            this.f31019f = (Button) findViewById(t.e(this.f31021h, "tt_positive"));
            this.f31016c = (TextView) findViewById(t.e(this.f31021h, "tt_title"));
            this.f31017d = (TextView) findViewById(t.e(this.f31021h, "tt_message"));
            this.f31015b = (ImageView) findViewById(t.e(this.f31021h, "tt_image"));
            this.f31020g = findViewById(t.e(this.f31021h, "tt_column_line"));
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
            setContentView(t.f(this.f31021h, "tt_custom_dailog_layout"));
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
            this.f31014a = aVar;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f31022i = str;
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
