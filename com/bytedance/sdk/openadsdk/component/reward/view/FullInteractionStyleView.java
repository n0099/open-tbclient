package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class FullInteractionStyleView extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public View q;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a r;
    public View s;
    public FrameLayout t;
    public e u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullInteractionStyleView(@NonNull Context context, String str) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 1;
        this.f66397a = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f66402f = s.d(this.f66397a, this.n);
            this.f66403g = s.d(this.f66397a, this.o);
            int i2 = (int) (this.l * 1000.0f);
            if (this.p == 1) {
                if (i2 == 666) {
                    e();
                } else if (i2 == 1000) {
                    c();
                } else if (i2 == 1500) {
                    k();
                } else if (i2 != 1777) {
                    a(0.562f);
                    l();
                } else {
                    m();
                }
            } else if (i2 == 562) {
                i();
            } else if (i2 == 666) {
                g();
            } else if (i2 == 1000) {
                c();
            } else if (i2 != 1500) {
                a(1.777f);
                j();
            } else {
                h();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_1_1"), (ViewGroup) this, true);
            d();
            f();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.t = (FrameLayout) this.q.findViewById(t.e(this.f66397a, "tt_ad_container"));
            ImageView imageView = (ImageView) this.q.findViewById(t.e(this.f66397a, "tt_full_img"));
            TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) this.q.findViewById(t.e(this.f66397a, "tt_full_ad_icon"));
            TextView textView = (TextView) this.q.findViewById(t.e(this.f66397a, "tt_full_ad_app_name"));
            TextView textView2 = (TextView) this.q.findViewById(t.e(this.f66397a, "tt_full_ad_download"));
            TextView textView3 = (TextView) this.q.findViewById(t.e(this.f66397a, "tt_ad_logo"));
            if (!TextUtils.isEmpty(this.f66398b.aj())) {
                textView2.setText(this.f66398b.aj());
            }
            a(this.t, imageView);
            ImageLoaderWrapper.from(this.f66398b.Y().a()).to(tTRoundRectImageView);
            textView.setText(getTitle());
            b(this.t);
            b(imageView);
            b(tTRoundRectImageView);
            b(textView);
            b(textView2);
            s.a(textView3, this.f66398b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_2_3"), (ViewGroup) this, true);
            d();
            f();
        }
    }

    private void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (textView = (TextView) this.q.findViewById(t.e(this.f66397a, "tt_full_ad_desc"))) == null) {
            return;
        }
        textView.setText(getDescription());
        b(textView);
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_2_3_h"), (ViewGroup) this, true);
            d();
            f();
        }
    }

    private float getHeightDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? s.c(this.f66397a, s.g(this.f66397a)) : invokeV.floatValue;
    }

    private float getWidthDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? s.c(this.f66397a, s.h(this.f66397a)) : invokeV.floatValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_3_2_h"), (ViewGroup) this, true);
            d();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_9_16_h"), (ViewGroup) this, true);
            d();
            f();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_16_9_h"), (ViewGroup) this, true);
            d();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            View inflate = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_3_2"), (ViewGroup) this, true);
            this.q = inflate;
            this.t = (FrameLayout) inflate.findViewById(t.e(this.f66397a, "tt_ad_container"));
            ImageView imageView = (ImageView) this.q.findViewById(t.e(this.f66397a, "tt_bu_img"));
            TextView textView = (TextView) this.q.findViewById(t.e(this.f66397a, "tt_bu_desc"));
            a(this.t, imageView);
            textView.setText(getDescription());
            b(this.t);
            b(imageView);
            b(textView);
            s.a((TextView) this.q.findViewById(t.e(this.f66397a, "tt_ad_logo")), this.f66398b);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_9_16_v"), (ViewGroup) this, true);
            d();
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.q = LayoutInflater.from(this.f66397a).inflate(t.f(this.f66397a, "tt_interaction_style_16_9_v"), (ViewGroup) this, true);
            d();
            f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
        }
    }

    public void a(m mVar, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, float f2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mVar, aVar, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.l = f2;
            this.p = i2;
            this.f66398b = mVar;
            this.r = aVar;
            this.f66401e = "fullscreen_interstitial_ad";
            this.n = i3;
            this.o = i4;
            b(this.f66404h);
            b();
        }
    }

    public View getInteractionStyleRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public FrameLayout getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (FrameLayout) invokeV.objValue;
    }

    public void setDownloadListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void setIsMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
            View view = this.s;
            if (view != null && (view instanceof NativeVideoTsView)) {
                ((NativeVideoTsView) view).setIsQuiet(z);
            }
        }
    }

    private void a(FrameLayout frameLayout, ImageView imageView) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, frameLayout, imageView) == null) || (mVar = this.f66398b) == null) {
            return;
        }
        int ap = mVar.ap();
        boolean z = ap == 5 || ap == 15;
        if (this.f66398b.V() != null && z) {
            s.a((View) imageView, 8);
            s.a((View) frameLayout, 0);
            return;
        }
        a(imageView);
        s.a((View) imageView, 0);
        s.a((View) frameLayout, 8);
    }

    private void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, view) == null) || view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.u;
        if (aVar == null) {
            Context context = this.f66397a;
            m mVar = this.f66398b;
            String str = this.f66401e;
            aVar = new com.bytedance.sdk.openadsdk.core.b.a(context, mVar, str, q.a(str));
            aVar.a(a(this.f66398b, this.f66397a));
        }
        view.setOnTouchListener(aVar);
        view.setOnClickListener(aVar);
    }

    private void a(ImageView imageView) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, imageView) == null) || (mVar = this.f66398b) == null) {
            return;
        }
        ImageLoaderWrapper.from(mVar.ad().get(0).a()).to(imageView);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, mVar, context)) == null) {
            if (mVar != null && mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(context, mVar, this.f66401e);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeLL.objValue;
    }

    private void a(float f2) {
        float min;
        float max;
        int max2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            float heightDp = getHeightDp();
            float widthDp = getWidthDp();
            if (this.p == 2) {
                min = Math.max(heightDp, widthDp);
                max = Math.min(heightDp, widthDp);
            } else {
                min = Math.min(heightDp, widthDp);
                max = Math.max(heightDp, widthDp);
            }
            if (this.p != 2 && s.b((Activity) this.f66397a)) {
                Context context = this.f66397a;
                max -= s.c(context, s.i(context));
            }
            int i3 = 20;
            int i4 = 0;
            if (this.p != 2) {
                if (f2 != 0.0f && f2 != 100.0f) {
                    float f3 = 20;
                    i2 = (int) Math.max((max - (((min - f3) - f3) / f2)) / 2.0f, 0.0f);
                    i3 = i2;
                    max2 = 20;
                    i4 = 20;
                }
                i2 = 0;
                max2 = 0;
                i3 = 0;
            } else {
                if (f2 != 0.0f && f2 != 100.0f) {
                    float f4 = 20;
                    max2 = (int) Math.max((min - (((max - f4) - f4) * f2)) / 2.0f, 0.0f);
                    i4 = max2;
                    i2 = 20;
                }
                i2 = 0;
                max2 = 0;
                i3 = 0;
            }
            ((Activity) this.f66397a).getWindow().getDecorView().setPadding(s.d(this.f66397a, i4), s.d(this.f66397a, i3), s.d(this.f66397a, max2), s.d(this.f66397a, i2));
        }
    }
}
