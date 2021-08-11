package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.j.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.g;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.r;
import com.bytedance.sdk.openadsdk.q.s;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f65610a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f65611b;

    /* renamed from: c  reason: collision with root package name */
    public TTRoundRectImageView f65612c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65613d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65614e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65615f;

    /* renamed from: g  reason: collision with root package name */
    public TTRatingBar f65616g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65617h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f65618i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f65619j;
    public FrameLayout k;
    public boolean l;
    public int m;
    public final AtomicBoolean n;
    public Activity o;
    public m p;
    public String q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;

    public c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.l = true;
        this.m = 0;
        this.n = new AtomicBoolean(false);
        this.t = false;
        this.o = activity;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Activity activity = this.o;
            this.f65610a = activity.findViewById(t.e(activity, "tt_reward_root"));
            Activity activity2 = this.o;
            this.f65611b = (RelativeLayout) activity2.findViewById(t.e(activity2, "tt_video_reward_bar"));
            Activity activity3 = this.o;
            this.f65612c = (TTRoundRectImageView) activity3.findViewById(t.e(activity3, "tt_reward_ad_icon"));
            Activity activity4 = this.o;
            this.f65613d = (TextView) activity4.findViewById(t.e(activity4, "tt_reward_ad_appname"));
            Activity activity5 = this.o;
            this.f65614e = (TextView) activity5.findViewById(t.e(activity5, "tt_comment_vertical"));
            Activity activity6 = this.o;
            this.f65615f = (TextView) activity6.findViewById(t.e(activity6, "tt_reward_ad_download"));
            Activity activity7 = this.o;
            TTRatingBar tTRatingBar = (TTRatingBar) activity7.findViewById(t.e(activity7, "tt_rb_score"));
            this.f65616g = tTRatingBar;
            if (tTRatingBar != null) {
                tTRatingBar.setStarEmptyNum(1);
                this.f65616g.setStarFillNum(4);
                this.f65616g.setStarImageWidth(s.d(this.o, 15.0f));
                this.f65616g.setStarImageHeight(s.d(this.o, 14.0f));
                this.f65616g.setStarImagePadding(s.d(this.o, 4.0f));
                this.f65616g.a();
            }
            Activity activity8 = this.o;
            this.f65617h = (TextView) activity8.findViewById(t.e(activity8, "tt_ad_logo"));
            Activity activity9 = this.o;
            this.f65618i = (FrameLayout) activity9.findViewById(t.e(activity9, "tt_video_reward_container"));
            Activity activity10 = this.o;
            this.f65619j = (FrameLayout) activity10.findViewById(t.e(activity10, "tt_click_upper_non_content_layout"));
            Activity activity11 = this.o;
            this.k = (FrameLayout) activity11.findViewById(t.e(activity11, "tt_click_lower_non_content_layout"));
            s.a(this.f65617h, this.p);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int t = this.p.t();
            this.u = t;
            if (t == -200) {
                h h2 = o.h();
                this.u = h2.k(q.d(this.p.ao()) + "");
            }
            if (this.u == -1 && this.l) {
                b(0);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f65611b == null) {
            return;
        }
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f65611b, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:3|(1:5)|6|7|8|(2:12|(7:14|15|16|17|(1:20)|21|(1:23)(4:25|(2:27|(1:(1:30)(1:(1:32))))(2:38|(2:40|(2:48|(1:(1:53)(1:(1:55))))(1:(1:45)(1:(1:47)))))|(1:36)|37)))|60|15|16|17|(1:20)|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String j() {
        InterceptResult invokeV;
        boolean z;
        String str;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) != null) {
            return (String) invokeV.objValue;
        }
        String j2 = q.j(this.o);
        if (j2 == null) {
            j2 = "";
        }
        try {
        } catch (Throwable unused) {
            z = true;
        }
        if (!j2.equals(Locale.CHINESE.getLanguage()) && !j2.equals(Locale.CHINA.getLanguage())) {
            if (!j2.equals(Locale.TRADITIONAL_CHINESE.getLanguage())) {
                z = false;
                boolean z2 = j2.equals(Locale.ENGLISH.getLanguage());
                str = "下载";
                if (!z && z2) {
                    str = "Install";
                }
                mVar = this.p;
                if (mVar == null) {
                    return str;
                }
                if (TextUtils.isEmpty(mVar.aj())) {
                    if (this.p.X() != 4) {
                        if (z) {
                            str = "查看";
                        } else if (z2) {
                            str = "View";
                        }
                    }
                } else {
                    str = this.p.aj();
                    if (str != null) {
                        if (!q.k(str) || str.length() <= 2) {
                            if (!q.k(str) && str.length() > 7) {
                                if (z) {
                                    str = b(true);
                                } else if (z2) {
                                    str = b(false);
                                }
                            }
                        } else if (z) {
                            str = b(true);
                        } else if (z2) {
                            str = b(false);
                        }
                    }
                }
                if (z2 && !q.k(str)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65615f.getLayoutParams();
                    layoutParams.bottomMargin = s.d(this.o, 4.0f);
                    this.f65615f.setLayoutParams(layoutParams);
                }
                return str;
            }
        }
        z = true;
        boolean z22 = j2.equals(Locale.ENGLISH.getLanguage());
        str = "下载";
        if (!z) {
            str = "Install";
        }
        mVar = this.p;
        if (mVar == null) {
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.p == null) {
            return;
        }
        if (!this.l) {
            b(4);
        }
        try {
            if (this.r == 2 && this.p.k() == 1) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f65615f.getLayoutParams();
                layoutParams.height = (int) s.b(this.o, 55.0f);
                layoutParams.topMargin = (int) s.b(this.o, 20.0f);
                this.f65615f.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f65611b.getLayoutParams();
                layoutParams2.bottomMargin = (int) s.b(this.o, 12.0f);
                this.f65611b.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.p.k() != 1 || this.f65618i == null) {
            return;
        }
        int c2 = s.c((Context) this.o);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f65618i.getLayoutParams();
        layoutParams3.width = c2;
        int i2 = (c2 * 9) / 16;
        layoutParams3.height = i2;
        this.f65618i.setLayoutParams(layoutParams3);
        this.m = (s.d((Context) this.o) - i2) / 2;
        k.f("RewardFullVideoLayout", "NonContentAreaHeight:" + this.m);
    }

    public void a(m mVar, String str, int i2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mVar, str, Integer.valueOf(i2), Boolean.valueOf(z), str2}) == null) || this.t) {
            return;
        }
        this.t = true;
        this.p = mVar;
        this.q = str;
        this.r = i2;
        this.s = z;
        g();
        k();
        a(str2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f65612c != null) {
                l Y = this.p.Y();
                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                    ImageLoaderWrapper.from(Y).to(this.f65612c);
                } else {
                    this.f65612c.setImageResource(t.d(this.o, "tt_ad_logo_small"));
                }
            }
            if (this.f65613d != null) {
                if (this.r == 1 && this.p.al() != null && !TextUtils.isEmpty(this.p.al().c())) {
                    this.f65613d.setText(this.p.al().c());
                } else {
                    this.f65613d.setText(this.p.ah());
                }
            }
        }
    }

    public void c() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f65614e == null) {
            return;
        }
        int f2 = this.p.al() != null ? this.p.al().f() : 6870;
        String a2 = t.a(this.o, "tt_comment_num");
        if (f2 > 10000) {
            str = (f2 / 10000) + "万";
        } else {
            str = f2 + "";
        }
        this.f65614e.setText(String.format(a2, str));
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            s.a(this.f65618i, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f65618i : (FrameLayout) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.p.k() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            g.a e2 = new g.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(s.d(this.o, 17.0f)).d(0).e(s.d(this.o, 3.0f));
            Activity activity = this.o;
            g.a((LinearLayout) activity.findViewById(t.e(activity, "tt_reward_ad_download_layout")), e2);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            s.a((View) this.f65618i, 8);
            s.a((View) this.f65619j, 8);
            s.a((View) this.k, 8);
            s.a((View) this.f65611b, 8);
            s.a((View) this.f65613d, 8);
            s.a((View) this.f65612c, 8);
            s.a((View) this.f65614e, 8);
            s.a((View) this.f65616g, 8);
            s.a((View) this.f65615f, 8);
            s.a((View) this.f65617h, 8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            s.a(this.f65611b, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onTouchListener) == null) {
            s.a(this.f65611b, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            b();
            a(com.bytedance.sdk.openadsdk.core.e.o.j(this.p) ? 8 : 0);
            c();
            b(str);
            a(this.r, this.s);
            f();
            if (this.s) {
                h();
            }
            r.a(this.f65617h, this.p.aH());
        }
    }

    public void b(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (textView = this.f65615f) == null) {
            return;
        }
        if (this.p.k() == 3) {
            str = j();
        }
        textView.setText(str);
    }

    public void c(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (i3 = this.u) == -1 || i2 != i3 || this.n.get()) {
            return;
        }
        this.n.set(true);
        b(0);
        i();
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            s.a(this.f65615f, onClickListener, (String) null);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void b(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onTouchListener) == null) {
            s.a(this.f65615f, onTouchListener, (String) null);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            s.a((View) this.f65611b, i2);
        }
    }

    private String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            m mVar = this.p;
            if (mVar == null) {
                return null;
            }
            return z ? mVar.X() == 4 ? "下载" : "查看" : mVar.X() == 4 ? "Install" : "View";
        }
        return (String) invokeZ.objValue;
    }

    public RelativeLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65611b : (RelativeLayout) invokeV.objValue;
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                TextView textView = this.f65613d;
                if (textView != null) {
                    textView.setMaxWidth((int) s.b(this.o, 153.0f));
                }
            } else {
                TextView textView2 = this.f65613d;
                if (textView2 != null) {
                    textView2.setMaxWidth((int) s.b(this.o, 404.0f));
                }
            }
            if (z) {
                return;
            }
            b(0);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            s.a((View) this.f65617h, i2);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            s.a(this.f65611b, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
            s.a(this.f65613d, onClickListener, (String) null);
            s.a(this.f65612c, onClickListener, (String) null);
            s.a(this.f65614e, onClickListener, (String) null);
            s.a(this.f65616g, onClickListener, (String) null);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onTouchListener) == null) {
            s.a(this.f65611b, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
            s.a(this.f65613d, onTouchListener, (String) null);
            s.a(this.f65612c, onTouchListener, (String) null);
            s.a(this.f65614e, onTouchListener, (String) null);
            s.a(this.f65616g, onTouchListener, (String) null);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.l = z;
        }
    }

    public void a(View.OnClickListener onClickListener, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener2) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, onClickListener, onTouchListener, onClickListener2) == null) {
            m mVar = this.p;
            if (mVar != null && mVar.l() != null) {
                if (this.p.l().f66027e) {
                    b(onClickListener);
                    b(onTouchListener);
                } else {
                    b(onClickListener2);
                }
                if (this.p.k() == 1) {
                    if (this.p.l().f66023a) {
                        a(onClickListener);
                        a(onTouchListener);
                    } else {
                        a(onClickListener2);
                    }
                } else if (this.p.l().f66025c) {
                    c(onClickListener);
                    c(onTouchListener);
                } else {
                    c(onClickListener2);
                }
            }
            m mVar2 = this.p;
            if (mVar2 != null && mVar2.l() != null) {
                if (this.p.l().f66028f) {
                    d(onClickListener);
                } else {
                    d(onClickListener2);
                }
            }
            m mVar3 = this.p;
            if (mVar3 == null || mVar3.k() != 1) {
                return;
            }
            if (this.p.l() != null && (frameLayout2 = this.f65619j) != null) {
                s.a((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f65619j.getLayoutParams();
                layoutParams.height = this.m;
                this.f65619j.setLayoutParams(layoutParams);
                if (this.p.l().f66024b) {
                    this.f65619j.setOnClickListener(onClickListener);
                    this.f65619j.setOnTouchListener(onTouchListener);
                } else {
                    this.f65619j.setOnClickListener(onClickListener2);
                }
            }
            if (this.p.l() == null || (frameLayout = this.k) == null) {
                return;
            }
            s.a((View) frameLayout, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams2.height = this.m;
            this.k.setLayoutParams(layoutParams2);
            if (this.p.l().f66026d) {
                this.k.setOnClickListener(onClickListener);
                this.k.setOnTouchListener(onTouchListener);
                return;
            }
            this.k.setOnClickListener(onClickListener2);
        }
    }

    public int a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            int f2 = t.f(this.o, "tt_activity_full_video_default_style");
            int k = mVar.k();
            if (k != 0) {
                if (k != 1) {
                    return k != 3 ? f2 : t.f(this.o, "tt_activity_full_video_new_bar_style");
                }
                return com.bytedance.sdk.openadsdk.core.e.o.j(this.p) ? t.f(this.o, "tt_activity_full_video_default_style") : t.f(this.o, "tt_activity_full_video_no_bar_style");
            }
            return t.f(this.o, "tt_activity_full_video_default_style");
        }
        return invokeL.intValue;
    }
}
