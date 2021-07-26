package com.bytedance.sdk.openadsdk.core.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.k;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes5.dex */
public class a extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public static k[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public NativeExpressView n;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a o;
    public int p;
    public Dialog q;
    public TextView r;
    public TextView s;
    public k t;
    public ImageView u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268088832, "Lcom/bytedance/sdk/openadsdk/core/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268088832, "Lcom/bytedance/sdk/openadsdk/core/d/a;");
                return;
            }
        }
        l = new k[]{new k(1, 1.0f, 300, 300), new k(2, 0.6666667f, 300, 450), new k(3, 1.5f, 300, 200)};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 1;
        this.f30478a = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.t = a(this.n.getExpectExpressWidth(), this.n.getExpectExpressHeight());
            if (this.n.getExpectExpressWidth() > 0 && this.n.getExpectExpressHeight() > 0) {
                if (this.n.getExpectExpressWidth() > this.n.getExpectExpressHeight()) {
                    this.f30483f = s.d(this.f30478a, this.n.getExpectExpressHeight() * this.t.f30593c);
                    this.f30484g = s.d(this.f30478a, this.n.getExpectExpressHeight());
                } else {
                    this.f30483f = s.d(this.f30478a, this.n.getExpectExpressWidth());
                    this.f30484g = s.d(this.f30478a, this.n.getExpectExpressWidth() / this.t.f30593c);
                }
            } else {
                this.f30483f = s.d(this.f30478a, this.t.f30594d);
                this.f30484g = s.d(this.f30478a, this.t.f30595e);
            }
            int i2 = this.f30483f;
            if (i2 > 0 && i2 > s.c(this.f30478a)) {
                float c2 = s.c(this.f30478a) / this.f30483f;
                this.f30483f = s.c(this.f30478a);
                this.f30484g = Float.valueOf(this.f30484g * c2).intValue();
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f30483f, this.f30484g);
            }
            layoutParams.width = this.f30483f;
            layoutParams.height = this.f30484g;
            setLayoutParams(layoutParams);
            int i3 = this.t.f30591a;
            if (i3 == 1) {
                c();
            } else if (i3 == 2) {
                d();
            } else if (i3 == 3) {
                e();
            } else {
                c();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View inflate = LayoutInflater.from(this.f30478a).inflate(t.f(this.f30478a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
            this.m = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.f30478a, "tt_ad_container"));
            ImageView imageView = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_img"));
            this.u = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_close"));
            ImageView imageView2 = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_icon"));
            this.r = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_title"));
            this.s = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_desc"));
            TextView textView = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_download"));
            TextView textView2 = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_dislike"));
            s.a((TextView) this.m.findViewById(t.e(this.f30478a, "tt_ad_logo")), this.f30479b);
            int b2 = (int) s.b(this.f30478a, 15.0f);
            s.a(this.u, b2, b2, b2, b2);
            b(this.u);
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30007a;

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
                    this.f30007a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30007a.a();
                    }
                }
            });
            if (!TextUtils.isEmpty(this.f30479b.aj())) {
                textView.setText(this.f30479b.aj());
            }
            if (this.f30479b.V() != null) {
                View videoView = getVideoView();
                if (videoView != null) {
                    frameLayout.removeAllViews();
                    int i2 = this.f30483f;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                    layoutParams.gravity = 17;
                    frameLayout.addView(videoView, 0, layoutParams);
                }
                s.a((View) imageView, 8);
                s.a((View) frameLayout, 0);
            } else {
                a(imageView);
                s.a((View) imageView, 0);
                s.a((View) frameLayout, 8);
            }
            ImageLoaderWrapper.from(this.f30479b.Y()).to(imageView2);
            this.r.setText(getTitle());
            this.s.setText(getDescription());
            a((View) this, true);
            a((View) textView, true);
            a((View) textView2, true);
            a(frameLayout);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            View inflate = LayoutInflater.from(this.f30478a).inflate(t.f(this.f30478a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
            this.m = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.f30478a, "tt_ad_container"));
            ImageView imageView = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_img"));
            this.u = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_close"));
            ImageView imageView2 = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_icon"));
            this.r = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_title"));
            this.s = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_desc"));
            TextView textView = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_download"));
            TextView textView2 = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_dislike"));
            s.a((TextView) this.m.findViewById(t.e(this.f30478a, "tt_ad_logo")), this.f30479b);
            int b2 = (int) s.b(this.f30478a, 15.0f);
            s.a(this.u, b2, b2, b2, b2);
            b(this.u);
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30009a;

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
                    this.f30009a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30009a.a();
                    }
                }
            });
            if (!TextUtils.isEmpty(this.f30479b.aj())) {
                textView.setText(this.f30479b.aj());
            }
            if (this.f30479b.V() != null) {
                View videoView = getVideoView();
                if (videoView != null) {
                    frameLayout.removeAllViews();
                    int i2 = this.f30483f;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                    layoutParams.gravity = 17;
                    frameLayout.addView(videoView, 0, layoutParams);
                }
                s.a((View) imageView, 8);
                s.a((View) frameLayout, 0);
            } else {
                a(imageView);
                s.a((View) imageView, 0);
                s.a((View) frameLayout, 8);
            }
            ImageLoaderWrapper.from(this.f30479b.Y()).to(imageView2);
            this.r.setText(getTitle());
            this.s.setText(getDescription());
            a((View) this, true);
            a((View) textView, true);
            a((View) textView2, true);
            a(frameLayout);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View inflate = LayoutInflater.from(this.f30478a).inflate(t.f(this.f30478a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
            this.m = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.f30478a, "tt_ad_container"));
            ImageView imageView = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_img"));
            this.u = (ImageView) this.m.findViewById(t.e(this.f30478a, "tt_bu_close"));
            this.s = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_desc"));
            TextView textView = (TextView) this.m.findViewById(t.e(this.f30478a, "tt_bu_dislike"));
            s.a((TextView) this.m.findViewById(t.e(this.f30478a, "tt_ad_logo")), this.f30479b);
            int b2 = (int) s.b(this.f30478a, 15.0f);
            s.a(this.u, b2, b2, b2, b2);
            b(this.u);
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30010a;

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
                    this.f30010a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30010a.a();
                    }
                }
            });
            if (this.f30479b.V() != null) {
                View videoView = getVideoView();
                if (videoView != null) {
                    frameLayout.removeAllViews();
                    int d2 = this.f30483f - s.d(this.f30478a, 12.0f);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d2, (d2 * 9) / 16);
                    layoutParams.gravity = 17;
                    frameLayout.addView(videoView, 0, layoutParams);
                }
                s.a((View) imageView, 8);
                s.a((View) frameLayout, 0);
            } else {
                a(imageView);
                s.a((View) imageView, 0);
                s.a((View) frameLayout, 8);
            }
            this.s.setText(getDescription());
            a((View) this, true);
            a(this.m, true);
            a((View) textView, true);
            a(frameLayout);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.t.f30591a == 3) {
                this.s.setTextColor(Color.parseColor("#3E3E3E"));
                this.u.setImageResource(t.d(getContext(), "tt_titlebar_close_press_for_dark"));
                return;
            }
            this.r.setTextColor(Color.parseColor("#FF333333"));
            this.s.setTextColor(Color.parseColor("#FF999999"));
            this.u.setImageResource(t.d(getContext(), "tt_dislike_icon"));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.t.f30591a == 3) {
                TextView textView = this.s;
                if (textView != null) {
                    textView.setTextColor(-1);
                }
            } else {
                TextView textView2 = this.r;
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                }
                TextView textView3 = this.s;
                if (textView3 != null) {
                    textView3.setTextColor(-1);
                }
            }
            this.u.setImageResource(t.d(getContext(), "tt_dislike_icon_inter_night"));
        }
    }

    public void a(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) {
            this.q = dialog;
        }
    }

    public void a(m mVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mVar, nativeExpressView, aVar) == null) {
            setBackgroundColor(-1);
            this.f30479b = mVar;
            this.n = nativeExpressView;
            this.o = aVar;
            this.f30482e = "interaction";
            b(this.f30485h);
            this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
            b();
            c(h.d().A());
        }
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, imageView) == null) {
            ImageLoaderWrapper.from(this.f30479b.ad().get(0)).to(imageView);
        }
    }

    private k a(int i2, int i3) {
        InterceptResult invokeII;
        k[] kVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            try {
                float floatValue = Float.valueOf(i2).floatValue() / Float.valueOf(i3).floatValue();
                k kVar = l[0];
                float f2 = Float.MAX_VALUE;
                for (k kVar2 : l) {
                    float abs = Math.abs(kVar2.f30593c - floatValue);
                    if (abs <= f2) {
                        kVar = kVar2;
                        f2 = abs;
                    }
                }
                return kVar;
            } catch (Throwable unused) {
                return l[0];
            }
        }
        return (k) invokeII.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, kVar) == null) || (nativeExpressView = this.n) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.a(i2);
            c(i2);
        }
    }

    private void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, view) == null) || view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.d.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30008a;

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
                this.f30008a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.f30008a.q == null) {
                    return;
                }
                this.f30008a.q.dismiss();
            }
        });
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            if (i2 == 1) {
                g();
                this.m.setBackgroundColor(Color.parseColor("#2c2c2c"));
                return;
            }
            f();
            this.m.setBackgroundColor(-1);
        }
    }
}
