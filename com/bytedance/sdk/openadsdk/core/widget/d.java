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
import com.bytedance.sdk.component.utils.r;
/* loaded from: classes5.dex */
public class d extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f30831a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30832b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30833c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30834d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30835e;

    /* renamed from: f  reason: collision with root package name */
    public Button f30836f;

    /* renamed from: g  reason: collision with root package name */
    public View f30837g;

    /* renamed from: h  reason: collision with root package name */
    public Context f30838h;

    /* renamed from: i  reason: collision with root package name */
    public String f30839i;
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
        super(context, r.g(context, "tt_custom_dialog"));
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
        this.f30838h = context;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f30836f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f30840a;

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
                    this.f30840a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f30840a.f30831a) == null) {
                        return;
                    }
                    aVar.a();
                }
            });
            this.f30835e.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f30841a;

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
                    this.f30841a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (aVar = this.f30841a.f30831a) == null) {
                        return;
                    }
                    aVar.b();
                }
            });
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!TextUtils.isEmpty(this.j)) {
                this.f30833c.setText(this.j);
                this.f30833c.setVisibility(0);
            } else {
                this.f30833c.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f30839i)) {
                this.f30834d.setText(this.f30839i);
            }
            if (!TextUtils.isEmpty(this.k)) {
                this.f30836f.setText(this.k);
            } else {
                this.f30836f.setText("确定");
            }
            if (!TextUtils.isEmpty(this.l)) {
                this.f30835e.setText(this.l);
            } else {
                this.f30835e.setText("取消");
            }
            int i2 = this.m;
            if (i2 != -1) {
                this.f30832b.setImageResource(i2);
                this.f30832b.setVisibility(0);
            } else {
                this.f30832b.setVisibility(8);
            }
            if (this.n) {
                this.f30837g.setVisibility(8);
                this.f30835e.setVisibility(8);
                return;
            }
            this.f30835e.setVisibility(0);
            this.f30837g.setVisibility(0);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f30835e = (Button) findViewById(r.e(this.f30838h, "tt_negtive"));
            this.f30836f = (Button) findViewById(r.e(this.f30838h, "tt_positive"));
            this.f30833c = (TextView) findViewById(r.e(this.f30838h, "tt_title"));
            this.f30834d = (TextView) findViewById(r.e(this.f30838h, "tt_message"));
            this.f30832b = (ImageView) findViewById(r.e(this.f30838h, "tt_image"));
            this.f30837g = findViewById(r.e(this.f30838h, "tt_column_line"));
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
            setContentView(r.f(this.f30838h, "tt_custom_dailog_layout"));
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
            this.f30831a = aVar;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f30839i = str;
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
