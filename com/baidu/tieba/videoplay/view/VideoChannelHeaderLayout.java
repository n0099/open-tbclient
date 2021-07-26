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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class VideoChannelHeaderLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f22136e;

    /* renamed from: f  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f22137f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22138g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22139h;

    /* renamed from: i  reason: collision with root package name */
    public View f22140i;
    public ContinuousAnimationView j;
    public int k;
    public d l;
    public int m;
    public int n;
    public final Runnable[] o;
    public final Handler p;
    public boolean q;
    public final Animator.AnimatorListener r;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f22141e;

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
            this.f22141e = videoChannelHeaderLayout;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f22141e.q) {
                return;
            }
            this.f22141e.q = true;
            this.f22141e.j.setSpeed(1.0f);
            this.f22141e.j.setMinAndMaxFrame(45, 105);
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
        public final /* synthetic */ VideoChannelHeaderLayout f22142a;

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
            this.f22142a = videoChannelHeaderLayout;
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) && this.f22142a.n == i2 && this.f22142a.l != null) {
                this.f22142a.l.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f22144f;

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
            this.f22144f = videoChannelHeaderLayout;
            this.f22143e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22144f.k(this.f22143e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();
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
        this.m = 0;
        this.n = 1;
        this.o = new Runnable[2];
        this.p = new Handler();
        this.q = false;
        this.r = new a(this);
        i(context);
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            CustomMessage customMessage = new CustomMessage(2921574);
            customMessage.setTag(bdUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921574, Integer.valueOf(this.n));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.m >= 1) {
            return;
        }
        float f2 = 1.0f;
        float f3 = (i2 * 1.0f) / this.k;
        if (f3 < 0.8f && f3 > 0.6f) {
            f2 = (f3 - 0.6f) / 0.2f;
        } else if (f3 <= 0.8f) {
            f2 = 0.0f;
        }
        this.f22140i.setAlpha(f2);
        this.j.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            float f2 = (i2 * 1.0f) / this.k;
            if (f2 > 0.6f) {
                this.f22137f.setAlpha(0.0f);
                this.f22138g.setAlpha(0.0f);
                if (f2 > 0.8f) {
                    this.f22139h.setAlpha(1.0f);
                    return;
                } else {
                    this.f22139h.setAlpha((f2 - 0.6f) / 0.2f);
                    return;
                }
            }
            float f3 = 1.0f - (f2 / 0.6f);
            this.f22137f.setAlpha(f3);
            this.f22138g.setAlpha(f3);
            this.f22139h.setAlpha(0.0f);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.k = (int) (getResources().getDisplayMetrics().density * 86.0f * 0.6f);
            LayoutInflater.from(context).inflate(R.layout.video_channel_header, (ViewGroup) this, true);
            this.f22136e = findViewById(R.id.rootView);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) findViewById(R.id.tab_layout);
            this.f22137f = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0101);
            this.f22137f.setNormalSelectorColorResId(R.color.CAM_X0103);
            this.f22137f.setRectPaintColor(R.color.CAM_X0101);
            this.f22137f.B(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), l.g(context, R.dimen.T_X04), true);
            this.f22137f.setIndicatorOffset(l.g(context, R.dimen.tbds64));
            this.f22137f.setIndicatorOvershot(l.g(context, R.dimen.tbds8));
            this.f22137f.setIndicatorRadius(l.g(context, R.dimen.tbds8));
            this.f22137f.setIndicatorMarginBottom(l.g(context, R.dimen.tbds10));
            this.f22137f.setmIndicatorWidth(l.g(context, R.dimen.tbds42));
            this.f22137f.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds166), -1));
            this.f22137f.G();
            this.f22137f.setOnTabItemClickListener(new b(this));
            TextView textView = (TextView) findViewById(R.id.attention_tag);
            this.f22138g = textView;
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
            d2.t(R.color.CAM_X0101);
            d2.x(R.dimen.T_X10);
            d2.y(R.string.F_X01);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0301);
            TextView textView2 = (TextView) findViewById(R.id.pull_refresh_text);
            this.f22139h = textView2;
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(textView2);
            d3.t(R.color.CAM_X0101);
            d3.x(R.dimen.T_X07);
            d3.y(R.string.F_X02);
            View findViewById = findViewById(R.id.pull_refresh_leading_layout);
            this.f22140i = findViewById;
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
            this.f22140i.setAlpha(0.0f);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = this.m - 1;
            this.m = i3;
            if (i3 < 1) {
                this.j.cancelAnimation();
                this.j.setMinAndMaxProgress(0.0f, 1.0f);
                this.j.setFrame(0);
                this.j.setSpeed(1.3f);
                this.f22140i.setAlpha(0.0f);
                this.m = 0;
            }
            Runnable[] runnableArr = this.o;
            if (runnableArr[i2] != null) {
                this.p.removeCallbacks(runnableArr[i2]);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.m < 1) {
                o();
            }
            this.m++;
            Runnable[] runnableArr = this.o;
            if (runnableArr[i2] == null) {
                runnableArr[i2] = new c(this, i2);
            }
            this.p.postDelayed(this.o[i2], 3000L);
        }
    }

    public void m(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (!j.z()) {
                    l.J(getContext(), getResources().getString(R.string.neterror));
                    return;
                }
                d dVar = this.l;
                if (dVar != null) {
                    dVar.a();
                }
            }
            int i4 = i3 + i2;
            this.f22136e.scrollTo(0, -i4);
            h(i4);
            g(i4);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f22138g.setText(str);
            this.f22138g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public final void o() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (continuousAnimationView = this.j) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.j.cancelAnimation();
        }
        this.q = false;
        this.j.loop(true);
        this.j.setMinFrame(27);
        this.j.setRepeatMode(1);
        this.j.removeAllAnimatorListeners();
        this.j.addAnimatorListener(this.r);
        this.j.playAnimation();
        this.f22140i.setAlpha(1.0f);
    }

    public void setOnAchieveRefresh(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void setPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewPager) == null) {
            this.f22137f.setViewPager(viewPager);
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
        this.m = 0;
        this.n = 1;
        this.o = new Runnable[2];
        this.p = new Handler();
        this.q = false;
        this.r = new a(this);
        i(context);
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
        this.m = 0;
        this.n = 1;
        this.o = new Runnable[2];
        this.p = new Handler();
        this.q = false;
        this.r = new a(this);
        i(context);
    }
}
