package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
/* loaded from: classes9.dex */
public class m extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66368a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66369b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f66370c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f66371d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66372e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66373f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f66374g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66375h;

    /* renamed from: i  reason: collision with root package name */
    public a f66376i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66377j;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);

        void b(View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(@NonNull Context context) {
        this(context, 0);
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
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.f66374g != null && this.f66374g.getChildCount() > 0) {
                    View childAt = this.f66374g.getChildAt(0);
                    if (childAt instanceof NativeExpressView) {
                        NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                        if (nativeExpressView.n()) {
                            this.f66374g.setVisibility(0);
                            this.f66370c.setVisibility(8);
                            this.f66371d.setVisibility(8);
                            this.f66372e.setVisibility(8);
                            this.f66373f.setVisibility(8);
                            View findViewById = nativeExpressView.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_bu_close"));
                            if (findViewById != null) {
                                findViewById.setOnClickListener(new View.OnClickListener(this, findViewById) { // from class: com.bytedance.sdk.openadsdk.core.m.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ View f66380a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ m f66381b;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, findViewById};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f66381b = this;
                                        this.f66380a = findViewById;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66381b.f66376i == null) {
                                            return;
                                        }
                                        this.f66381b.f66376i.a(this.f66380a);
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b();
            try {
                super.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NonNull Context context, @StyleRes int i2) {
        super(context, i2 == 0 ? com.bytedance.sdk.component.utils.t.g(context, "tt_wg_insert_dialog") : i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66377j = false;
        this.f66369b = context;
    }

    public void a(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, aVar) == null) {
            this.f66377j = z;
            this.f66376i = aVar;
            a();
            a aVar2 = this.f66376i;
            if (aVar2 != null) {
                aVar2.a(this.f66370c, this.f66371d, this.f66374g);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            this.f66375h = mVar;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setCancelable(false);
            View inflate = LayoutInflater.from(this.f66369b).inflate(com.bytedance.sdk.component.utils.t.f(this.f66369b, "tt_insert_ad_layout"), (ViewGroup) null);
            this.f66368a = inflate;
            setContentView(inflate);
            this.f66370c = (ImageView) this.f66368a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_insert_ad_img"));
            this.f66371d = (ImageView) this.f66368a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_insert_dislike_icon_img"));
            this.f66372e = (TextView) this.f66368a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_ad_logo"));
            this.f66373f = (TextView) this.f66368a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_insert_ad_text"));
            com.bytedance.sdk.openadsdk.q.s.a(this.f66372e, this.f66375h);
            this.f66374g = (FrameLayout) this.f66368a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66369b, "tt_insert_express_ad_fl"));
            int c2 = com.bytedance.sdk.openadsdk.q.s.c(this.f66369b);
            int i2 = c2 / 3;
            this.f66370c.setMaxWidth(c2);
            this.f66370c.setMinimumWidth(i2);
            this.f66370c.setMinimumHeight(i2);
            this.f66374g.setMinimumWidth(i2);
            this.f66374g.setMinimumHeight(i2);
            this.f66370c.setVisibility(this.f66377j ? 8 : 0);
            this.f66371d.setVisibility(0);
            this.f66372e.setVisibility(this.f66377j ? 8 : 0);
            this.f66373f.setVisibility(this.f66377j ? 8 : 0);
            this.f66374g.setVisibility(this.f66377j ? 0 : 8);
            int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66369b, 15.0f);
            com.bytedance.sdk.openadsdk.q.s.a(this.f66371d, b2, b2, b2, b2);
            this.f66371d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66378a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66378a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66378a.f66376i == null) {
                        return;
                    }
                    this.f66378a.f66376i.a(view);
                }
            });
            this.f66373f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66379a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66379a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66379a.f66376i == null) {
                        return;
                    }
                    this.f66379a.f66376i.b(view);
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            com.bytedance.sdk.openadsdk.q.r.a(this.f66372e, str);
        }
    }
}
