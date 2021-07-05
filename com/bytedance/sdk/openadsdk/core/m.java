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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
/* loaded from: classes6.dex */
public class m extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f30241a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30242b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30243c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30244d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30245e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f30246f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f30247g;

    /* renamed from: h  reason: collision with root package name */
    public a f30248h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30249i;

    /* loaded from: classes6.dex */
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
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            try {
                if (this.f30247g != null && this.f30247g.getChildCount() > 0) {
                    View childAt = this.f30247g.getChildAt(0);
                    if (childAt instanceof NativeExpressView) {
                        NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                        if (nativeExpressView.p()) {
                            this.f30247g.setVisibility(0);
                            this.f30243c.setVisibility(8);
                            this.f30244d.setVisibility(8);
                            this.f30245e.setVisibility(8);
                            this.f30246f.setVisibility(8);
                            View findViewById = nativeExpressView.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_bu_close"));
                            if (findViewById != null) {
                                findViewById.setOnClickListener(new View.OnClickListener(this, findViewById) { // from class: com.bytedance.sdk.openadsdk.core.m.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ View f30252a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ m f30253b;

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
                                        this.f30253b = this;
                                        this.f30252a = findViewById;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f30253b.f30248h == null) {
                                            return;
                                        }
                                        this.f30253b.f30248h.a(this.f30252a);
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b();
            super.show();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NonNull Context context, @StyleRes int i2) {
        super(context, i2 == 0 ? com.bytedance.sdk.component.utils.r.g(context, "tt_wg_insert_dialog") : i2);
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
        this.f30249i = false;
        this.f30242b = context;
    }

    public void a(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, aVar) == null) {
            this.f30249i = z;
            this.f30248h = aVar;
            a();
            a aVar2 = this.f30248h;
            if (aVar2 != null) {
                aVar2.a(this.f30243c, this.f30244d, this.f30247g);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setCancelable(false);
            View inflate = LayoutInflater.from(this.f30242b).inflate(com.bytedance.sdk.component.utils.r.f(this.f30242b, "tt_insert_ad_layout"), (ViewGroup) null);
            this.f30241a = inflate;
            setContentView(inflate);
            this.f30243c = (ImageView) this.f30241a.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_insert_ad_img"));
            this.f30244d = (ImageView) this.f30241a.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_insert_dislike_icon_img"));
            this.f30245e = (ImageView) this.f30241a.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_insert_ad_logo"));
            this.f30246f = (TextView) this.f30241a.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_insert_ad_text"));
            this.f30247g = (FrameLayout) this.f30241a.findViewById(com.bytedance.sdk.component.utils.r.e(this.f30242b, "tt_insert_express_ad_fl"));
            int c2 = com.bytedance.sdk.openadsdk.r.q.c(this.f30242b);
            int i2 = c2 / 3;
            this.f30243c.setMaxWidth(c2);
            this.f30243c.setMinimumWidth(i2);
            this.f30243c.setMinimumHeight(i2);
            this.f30247g.setMinimumWidth(i2);
            this.f30247g.setMinimumHeight(i2);
            this.f30243c.setVisibility(this.f30249i ? 8 : 0);
            this.f30244d.setVisibility(0);
            this.f30245e.setVisibility(this.f30249i ? 8 : 0);
            this.f30246f.setVisibility(this.f30249i ? 8 : 0);
            this.f30247g.setVisibility(this.f30249i ? 0 : 8);
            int b2 = (int) com.bytedance.sdk.openadsdk.r.q.b(this.f30242b, 15.0f);
            com.bytedance.sdk.openadsdk.r.q.a(this.f30244d, b2, b2, b2, b2);
            this.f30244d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f30250a;

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
                    this.f30250a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f30250a.f30248h == null) {
                        return;
                    }
                    this.f30250a.f30248h.a(view);
                }
            });
            this.f30246f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f30251a;

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
                    this.f30251a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f30251a.f30248h == null) {
                        return;
                    }
                    this.f30251a.f30248h.b(view);
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            com.bytedance.sdk.openadsdk.r.p.a(this.f30245e, str);
        }
    }
}
