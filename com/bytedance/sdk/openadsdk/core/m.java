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
    public View f66568a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66569b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f66570c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f66571d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66572e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66573f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f66574g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66575h;

    /* renamed from: i  reason: collision with root package name */
    public a f66576i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66577j;

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
                if (this.f66574g != null && this.f66574g.getChildCount() > 0) {
                    View childAt = this.f66574g.getChildAt(0);
                    if (childAt instanceof NativeExpressView) {
                        NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                        if (nativeExpressView.n()) {
                            this.f66574g.setVisibility(0);
                            this.f66570c.setVisibility(8);
                            this.f66571d.setVisibility(8);
                            this.f66572e.setVisibility(8);
                            this.f66573f.setVisibility(8);
                            View findViewById = nativeExpressView.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_bu_close"));
                            if (findViewById != null) {
                                findViewById.setOnClickListener(new View.OnClickListener(this, findViewById) { // from class: com.bytedance.sdk.openadsdk.core.m.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ View f66580a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ m f66581b;

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
                                        this.f66581b = this;
                                        this.f66580a = findViewById;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66581b.f66576i == null) {
                                            return;
                                        }
                                        this.f66581b.f66576i.a(this.f66580a);
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
        this.f66577j = false;
        this.f66569b = context;
    }

    public void a(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, aVar) == null) {
            this.f66577j = z;
            this.f66576i = aVar;
            a();
            a aVar2 = this.f66576i;
            if (aVar2 != null) {
                aVar2.a(this.f66570c, this.f66571d, this.f66574g);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            this.f66575h = mVar;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setCancelable(false);
            View inflate = LayoutInflater.from(this.f66569b).inflate(com.bytedance.sdk.component.utils.t.f(this.f66569b, "tt_insert_ad_layout"), (ViewGroup) null);
            this.f66568a = inflate;
            setContentView(inflate);
            this.f66570c = (ImageView) this.f66568a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_insert_ad_img"));
            this.f66571d = (ImageView) this.f66568a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_insert_dislike_icon_img"));
            this.f66572e = (TextView) this.f66568a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_ad_logo"));
            this.f66573f = (TextView) this.f66568a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_insert_ad_text"));
            com.bytedance.sdk.openadsdk.q.s.a(this.f66572e, this.f66575h);
            this.f66574g = (FrameLayout) this.f66568a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66569b, "tt_insert_express_ad_fl"));
            int c2 = com.bytedance.sdk.openadsdk.q.s.c(this.f66569b);
            int i2 = c2 / 3;
            this.f66570c.setMaxWidth(c2);
            this.f66570c.setMinimumWidth(i2);
            this.f66570c.setMinimumHeight(i2);
            this.f66574g.setMinimumWidth(i2);
            this.f66574g.setMinimumHeight(i2);
            this.f66570c.setVisibility(this.f66577j ? 8 : 0);
            this.f66571d.setVisibility(0);
            this.f66572e.setVisibility(this.f66577j ? 8 : 0);
            this.f66573f.setVisibility(this.f66577j ? 8 : 0);
            this.f66574g.setVisibility(this.f66577j ? 0 : 8);
            int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66569b, 15.0f);
            com.bytedance.sdk.openadsdk.q.s.a(this.f66571d, b2, b2, b2, b2);
            this.f66571d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66578a;

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
                    this.f66578a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66578a.f66576i == null) {
                        return;
                    }
                    this.f66578a.f66576i.a(view);
                }
            });
            this.f66573f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66579a;

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
                    this.f66579a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66579a.f66576i == null) {
                        return;
                    }
                    this.f66579a.f66576i.b(view);
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            com.bytedance.sdk.openadsdk.q.r.a(this.f66572e, str);
        }
    }
}
