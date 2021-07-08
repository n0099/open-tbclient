package com.baidu.tieba.videoplay.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class VideoChannelHeaderLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21978e;

    /* renamed from: f  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f21979f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21980g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21981h;

    /* renamed from: i  reason: collision with root package name */
    public View f21982i;
    public ContinuousAnimationView j;
    public int k;
    public int l;
    public int m;
    public final Runnable[] n;
    public final Handler o;
    public boolean p;
    public final Animator.AnimatorListener q;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f21983e;

        public a(VideoChannelHeaderLayout videoChannelHeaderLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelHeaderLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21983e = videoChannelHeaderLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f21983e.p) {
                return;
            }
            this.f21983e.p = true;
            this.f21983e.j.setSpeed(1.0f);
            this.f21983e.j.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NewPagerSlidingTabBaseStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f21984a;

        public b(VideoChannelHeaderLayout videoChannelHeaderLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelHeaderLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21984a = videoChannelHeaderLayout;
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) && this.f21984a.m == i2) {
                this.f21984a.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f21986f;

        public c(VideoChannelHeaderLayout videoChannelHeaderLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelHeaderLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21986f = videoChannelHeaderLayout;
            this.f21985e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21986f.j(this.f21985e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelHeaderLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = 1;
        this.n = new Runnable[2];
        this.o = new Handler();
        this.p = false;
        this.q = new a(this);
        h(context);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921574, Integer.valueOf(this.m)));
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.l >= 1) {
            return;
        }
        float f2 = 1.0f;
        float f3 = (i2 * 1.0f) / this.k;
        if (f3 < 0.8f && f3 > 0.6f) {
            f2 = (f3 - 0.6f) / 0.2f;
        } else if (f3 <= 0.8f) {
            f2 = 0.0f;
        }
        this.f21982i.setAlpha(f2);
        this.j.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            float f2 = (i2 * 1.0f) / this.k;
            if (f2 > 0.6f) {
                this.f21979f.setAlpha(0.0f);
                this.f21980g.setAlpha(0.0f);
                if (f2 > 0.8f) {
                    this.f21981h.setAlpha(1.0f);
                    return;
                } else {
                    this.f21981h.setAlpha((f2 - 0.6f) / 0.2f);
                    return;
                }
            }
            float f3 = 1.0f - (f2 / 0.6f);
            this.f21979f.setAlpha(f3);
            this.f21980g.setAlpha(f3);
            this.f21981h.setAlpha(0.0f);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.k = (int) (getResources().getDisplayMetrics().density * 86.0f * 0.6f);
            LayoutInflater.from(context).inflate(R.layout.video_channel_header, (ViewGroup) this, true);
            this.f21978e = findViewById(R.id.rootView);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) findViewById(R.id.tab_layout);
            this.f21979f = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0101);
            this.f21979f.setNormalSelectorColorResId(R.color.CAM_X0103);
            this.f21979f.setRectPaintColor(R.color.CAM_X0101);
            this.f21979f.B(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), l.g(context, R.dimen.T_X04), true);
            this.f21979f.setIndicatorOffset(l.g(context, R.dimen.tbds64));
            this.f21979f.setIndicatorOvershot(l.g(context, R.dimen.tbds8));
            this.f21979f.setIndicatorRadius(l.g(context, R.dimen.tbds8));
            this.f21979f.setIndicatorMarginBottom(l.g(context, R.dimen.tbds10));
            this.f21979f.setmIndicatorWidth(l.g(context, R.dimen.tbds42));
            this.f21979f.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds166), -1));
            this.f21979f.G();
            this.f21979f.setOnTabItemClickListener(new b(this));
            TextView textView = (TextView) findViewById(R.id.attention_tag);
            this.f21980g = textView;
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(textView);
            d2.t(R.color.CAM_X0101);
            d2.x(R.dimen.T_X10);
            d2.y(R.string.F_X01);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0301);
            TextView textView2 = (TextView) findViewById(R.id.pull_refresh_text);
            this.f21981h = textView2;
            d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(textView2);
            d3.t(R.color.CAM_X0101);
            d3.x(R.dimen.T_X07);
            d3.y(R.string.F_X02);
            View findViewById = findViewById(R.id.pull_refresh_leading_layout);
            this.f21982i = findViewById;
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMargins(0, -l.g(context, R.dimen.tbds20), 0, 0);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) findViewById(R.id.pull_refresh_leading_view);
            this.j = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_common_pull_refresh);
            if (this.j.isAnimating()) {
                this.j.cancelAnimation();
            }
            this.j.setMinAndMaxProgress(0.0f, 1.0f);
            this.j.setFrame(0);
            this.j.setSpeed(1.3f);
            this.f21982i.setAlpha(0.0f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o.removeCallbacksAndMessages(null);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = this.l - 1;
            this.l = i3;
            if (i3 < 1) {
                this.j.cancelAnimation();
                this.j.setMinAndMaxProgress(0.0f, 1.0f);
                this.j.setFrame(0);
                this.j.setSpeed(1.3f);
                this.f21982i.setAlpha(0.0f);
                this.l = 0;
            }
            Runnable[] runnableArr = this.n;
            if (runnableArr[i2] != null) {
                this.o.removeCallbacks(runnableArr[i2]);
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.l < 1) {
                n();
            }
            this.l++;
            Runnable[] runnableArr = this.n;
            if (runnableArr[i2] == null) {
                runnableArr[i2] = new c(this, i2);
            }
            this.o.postDelayed(this.n[i2], 3000L);
        }
    }

    public void l(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (!j.z()) {
                    l.J(getContext(), getResources().getString(R.string.neterror));
                    return;
                }
                e();
            }
            int i4 = i3 + i2;
            this.f21978e.scrollTo(0, -i4);
            g(i4);
            f(i4);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f21980g.setText(str);
            this.f21980g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public final void n() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (continuousAnimationView = this.j) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.j.cancelAnimation();
        }
        this.p = false;
        this.j.loop(true);
        this.j.setMinFrame(27);
        this.j.setRepeatMode(1);
        this.j.removeAllAnimatorListeners();
        this.j.addAnimatorListener(this.q);
        this.j.playAnimation();
        this.f21982i.setAlpha(1.0f);
    }

    public void setPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewPager) == null) {
            this.f21979f.setViewPager(viewPager);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = 1;
        this.n = new Runnable[2];
        this.o = new Handler();
        this.p = false;
        this.q = new a(this);
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelHeaderLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.m = 1;
        this.n = new Runnable[2];
        this.o = new Handler();
        this.p = false;
        this.q = new a(this);
        h(context);
    }
}
