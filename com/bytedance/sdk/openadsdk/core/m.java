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
    public View f66748a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66749b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f66750c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f66751d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66752e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66753f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f66754g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66755h;

    /* renamed from: i  reason: collision with root package name */
    public a f66756i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66757j;

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
                if (this.f66754g != null && this.f66754g.getChildCount() > 0) {
                    View childAt = this.f66754g.getChildAt(0);
                    if (childAt instanceof NativeExpressView) {
                        NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                        if (nativeExpressView.n()) {
                            this.f66754g.setVisibility(0);
                            this.f66750c.setVisibility(8);
                            this.f66751d.setVisibility(8);
                            this.f66752e.setVisibility(8);
                            this.f66753f.setVisibility(8);
                            View findViewById = nativeExpressView.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_bu_close"));
                            if (findViewById != null) {
                                findViewById.setOnClickListener(new View.OnClickListener(this, findViewById) { // from class: com.bytedance.sdk.openadsdk.core.m.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ View f66760a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ m f66761b;

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
                                        this.f66761b = this;
                                        this.f66760a = findViewById;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66761b.f66756i == null) {
                                            return;
                                        }
                                        this.f66761b.f66756i.a(this.f66760a);
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
        this.f66757j = false;
        this.f66749b = context;
    }

    public void a(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, aVar) == null) {
            this.f66757j = z;
            this.f66756i = aVar;
            a();
            a aVar2 = this.f66756i;
            if (aVar2 != null) {
                aVar2.a(this.f66750c, this.f66751d, this.f66754g);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            this.f66755h = mVar;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setCancelable(false);
            View inflate = LayoutInflater.from(this.f66749b).inflate(com.bytedance.sdk.component.utils.t.f(this.f66749b, "tt_insert_ad_layout"), (ViewGroup) null);
            this.f66748a = inflate;
            setContentView(inflate);
            this.f66750c = (ImageView) this.f66748a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_insert_ad_img"));
            this.f66751d = (ImageView) this.f66748a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_insert_dislike_icon_img"));
            this.f66752e = (TextView) this.f66748a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_ad_logo"));
            this.f66753f = (TextView) this.f66748a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_insert_ad_text"));
            com.bytedance.sdk.openadsdk.q.s.a(this.f66752e, this.f66755h);
            this.f66754g = (FrameLayout) this.f66748a.findViewById(com.bytedance.sdk.component.utils.t.e(this.f66749b, "tt_insert_express_ad_fl"));
            int c2 = com.bytedance.sdk.openadsdk.q.s.c(this.f66749b);
            int i2 = c2 / 3;
            this.f66750c.setMaxWidth(c2);
            this.f66750c.setMinimumWidth(i2);
            this.f66750c.setMinimumHeight(i2);
            this.f66754g.setMinimumWidth(i2);
            this.f66754g.setMinimumHeight(i2);
            this.f66750c.setVisibility(this.f66757j ? 8 : 0);
            this.f66751d.setVisibility(0);
            this.f66752e.setVisibility(this.f66757j ? 8 : 0);
            this.f66753f.setVisibility(this.f66757j ? 8 : 0);
            this.f66754g.setVisibility(this.f66757j ? 0 : 8);
            int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66749b, 15.0f);
            com.bytedance.sdk.openadsdk.q.s.a(this.f66751d, b2, b2, b2, b2);
            this.f66751d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66758a;

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
                    this.f66758a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66758a.f66756i == null) {
                        return;
                    }
                    this.f66758a.f66756i.a(view);
                }
            });
            this.f66753f.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66759a;

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
                    this.f66759a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f66759a.f66756i == null) {
                        return;
                    }
                    this.f66759a.f66756i.b(view);
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            com.bytedance.sdk.openadsdk.q.r.a(this.f66752e, str);
        }
    }
}
