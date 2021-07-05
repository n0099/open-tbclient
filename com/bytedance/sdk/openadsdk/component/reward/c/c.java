package com.bytedance.sdk.openadsdk.component.reward.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.component.reward.view.RatioImageView;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.r.o;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes6.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View l;
    public boolean m;
    public int n;
    public RatioImageView o;
    public TTRoundRectImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TTRatingBar t;
    public TextView u;
    public m v;
    public String w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Activity activity, m mVar, int i2, int i3, int i4, float f2) {
        super(activity, mVar, i2, i3, i4, f2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (m) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = 33;
        this.w = "fullscreen_interstitial_ad";
        this.v = mVar;
        this.n = mVar.ap();
        this.m = this.f29370e == 2;
    }

    public static boolean c(m mVar) {
        InterceptResult invokeL;
        int ap;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mVar)) == null) ? (mVar == null || (ap = mVar.ap()) == 5 || ap == 15 || mVar.aJ() != 100.0f) ? false : true : invokeL.booleanValue;
    }

    private void d(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, mVar) == null) || mVar == null) {
            return;
        }
        RatioImageView ratioImageView = this.o;
        if (ratioImageView != null) {
            int i2 = this.n;
            if (i2 == 33) {
                ratioImageView.setRatio(1.0f);
            } else if (i2 == 3) {
                ratioImageView.setRatio(1.91f);
            } else {
                ratioImageView.setRatio(0.56f);
            }
            a((ImageView) this.o);
        }
        if (this.p != null) {
            com.bytedance.sdk.openadsdk.l.e.b().a(this.v.Y().a(), this.p);
        }
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(a(this.v));
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setText(b(this.v));
        }
        m();
        n();
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            boolean z = this.f29370e == 2;
            this.m = z;
            if (z) {
                int i2 = this.n;
                if (i2 == 3) {
                    g();
                    return;
                } else if (i2 != 33) {
                    k();
                    return;
                } else {
                    i();
                    return;
                }
            }
            int i3 = this.n;
            if (i3 == 3) {
                f();
            } else if (i3 != 33) {
                j();
            } else {
                h();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.l = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_3_191_v"), (ViewGroup) null, true);
            l();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View inflate = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_3_191_h"), (ViewGroup) null, true);
            this.l = inflate;
            this.o = (RatioImageView) inflate.findViewById(r.e(this.f29366a, "tt_ratio_image_view"));
            this.p = (TTRoundRectImageView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_icon"));
            this.q = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_app_name"));
            this.r = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_desc"));
            this.s = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_comment"));
            this.u = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_download"));
            a((View) this.o);
            a((View) this.p);
            a(this.q);
            a(this.r);
            a(this.s);
            a(this.u);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.l = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_33_v"), (ViewGroup) null, true);
            l();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.l = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_33_h"), (ViewGroup) null, true);
            l();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View inflate = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_173_v"), (ViewGroup) null, true);
            this.l = inflate;
            this.o = (RatioImageView) inflate.findViewById(r.e(this.f29366a, "tt_ratio_image_view"));
            this.p = (TTRoundRectImageView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_icon"));
            this.q = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_app_name"));
            this.r = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_desc"));
            this.u = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_download"));
            a((View) this.o);
            a((View) this.p);
            a(this.q);
            a(this.r);
            a(this.u);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.l = LayoutInflater.from(this.f29366a).inflate(r.f(this.f29366a, "tt_activity_full_image_model_173_h"), (ViewGroup) null, true);
            l();
        }
    }

    private void l() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (view = this.l) == null) {
            return;
        }
        this.o = (RatioImageView) view.findViewById(r.e(this.f29366a, "tt_ratio_image_view"));
        this.p = (TTRoundRectImageView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_icon"));
        this.q = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_app_name"));
        this.r = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_desc"));
        this.s = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_comment"));
        this.t = (TTRatingBar) this.l.findViewById(r.e(this.f29366a, "tt_full_rb_score"));
        this.u = (TextView) this.l.findViewById(r.e(this.f29366a, "tt_full_ad_download"));
        a((View) this.o);
        a((View) this.p);
        a(this.q);
        a(this.r);
        a(this.s);
        a(this.t);
        a(this.u);
    }

    private void m() {
        TTRatingBar tTRatingBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (tTRatingBar = this.t) == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.t.setStarFillNum(4);
        this.t.setStarImageWidth(q.d(this.f29366a, 16.0f));
        this.t.setStarImageHeight(q.d(this.f29366a, 16.0f));
        this.t.setStarImagePadding(q.d(this.f29366a, 4.0f));
        this.t.a();
    }

    private void n() {
        m mVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.s == null || (mVar = this.v) == null) {
            return;
        }
        int f2 = mVar.al() != null ? this.v.al().f() : 6870;
        String a2 = r.a(this.f29366a, "tt_comment_num_backup");
        if (f2 > 10000) {
            str = (f2 / 10000) + "万";
        } else {
            str = f2 + "";
        }
        this.s.setText(String.format(a2, str));
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            m mVar = this.v;
            return mVar != null && mVar.d() == 2;
        }
        return invokeV.booleanValue;
    }

    public String a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            if (mVar == null) {
                return "";
            }
            if (mVar.al() != null && !TextUtils.isEmpty(mVar.al().c())) {
                return mVar.al().c();
            }
            if (TextUtils.isEmpty(mVar.W())) {
                return !TextUtils.isEmpty(mVar.ah()) ? mVar.ah() : "";
            }
            return mVar.W();
        }
        return (String) invokeL.objValue;
    }

    public String b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mVar)) == null) {
            if (mVar == null) {
                return "";
            }
            if (TextUtils.isEmpty(mVar.ah())) {
                return !TextUtils.isEmpty(mVar.ai()) ? mVar.ai() : "";
            }
            return mVar.ah();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? o() : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? o() : invokeV.booleanValue;
    }

    private void a(ImageView imageView) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, imageView) == null) || (mVar = this.v) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.b().a(mVar.ad().get(0).a(), imageView);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a e(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f29366a, mVar, this.w);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.f29366a == null || this.v == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.f29373h;
        if (aVar == null) {
            Activity activity = this.f29366a;
            m mVar = this.v;
            String str = this.w;
            aVar = new com.bytedance.sdk.openadsdk.core.b.a(activity, mVar, str, o.a(str));
            aVar.a(e(this.v));
        }
        view.setOnTouchListener(aVar);
        view.setOnClickListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
            e();
            d(this.v);
            frameLayout.addView(this.l);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void a(com.bytedance.sdk.openadsdk.component.reward.view.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            cVar.a(8);
            cVar.b(8);
            this.f29374i.c(false);
            this.f29374i.d(false);
            if (this.f29367b.d() == 2) {
                this.f29374i.a(false);
                this.f29374i.e(false);
                return;
            }
            this.f29374i.a(this.f29367b.aM());
            this.f29374i.e(true);
        }
    }
}
