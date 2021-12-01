package com.baidu.tieba.videoplay.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.r0.j4.f;
import c.a.r0.j4.g;
import c.a.r0.j4.h;
import c.a.r0.j4.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class VideoChannelHeaderLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50153e;

    /* renamed from: f  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f50154f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50155g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50156h;

    /* renamed from: i  reason: collision with root package name */
    public View f50157i;

    /* renamed from: j  reason: collision with root package name */
    public ContinuousAnimationView f50158j;

    /* renamed from: k  reason: collision with root package name */
    public int f50159k;
    public d l;
    public int m;
    public ImageView mAlaEntranceBtn;
    public int n;
    public final Runnable[] o;
    public final Handler p;
    public boolean q;
    public final Animator.AnimatorListener r;

    /* loaded from: classes11.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f50160e;

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
            this.f50160e = videoChannelHeaderLayout;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f50160e.q) {
                return;
            }
            this.f50160e.q = true;
            this.f50160e.f50158j.setSpeed(1.0f);
            this.f50160e.f50158j.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements NewPagerSlidingTabBaseStrip.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelHeaderLayout a;

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
            this.a = videoChannelHeaderLayout;
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) && this.a.n == i2 && this.a.l != null) {
                this.a.l.a();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoChannelHeaderLayout f50162f;

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
            this.f50162f = videoChannelHeaderLayout;
            this.f50161e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50162f.onFinish(this.f50161e);
            }
        }
    }

    /* loaded from: classes11.dex */
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

    public void achieveRefresh(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            CustomMessage customMessage = new CustomMessage(2921574);
            customMessage.setTag(bdUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921574, Integer.valueOf(this.n));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            float f2 = (i2 * 1.0f) / this.f50159k;
            if (f2 > 0.6f) {
                this.mAlaEntranceBtn.setAlpha(0.0f);
            } else {
                this.mAlaEntranceBtn.setAlpha(1.0f - (f2 / 0.6f));
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.m >= 1) {
            return;
        }
        float f2 = 1.0f;
        float f3 = (i2 * 1.0f) / this.f50159k;
        if (f3 < 0.8f && f3 > 0.6f) {
            f2 = (f3 - 0.6f) / 0.2f;
        } else if (f3 <= 0.8f) {
            f2 = 0.0f;
        }
        this.f50157i.setAlpha(f2);
        this.f50158j.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            float f2 = (i2 * 1.0f) / this.f50159k;
            if (f2 > 0.6f) {
                this.f50154f.setAlpha(0.0f);
                this.f50155g.setAlpha(0.0f);
                if (f2 > 0.8f) {
                    this.f50156h.setAlpha(1.0f);
                    return;
                } else {
                    this.f50156h.setAlpha((f2 - 0.6f) / 0.2f);
                    return;
                }
            }
            float f3 = 1.0f - (f2 / 0.6f);
            this.f50154f.setAlpha(f3);
            this.f50155g.setAlpha(f3);
            this.f50156h.setAlpha(0.0f);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f50159k = (int) (getResources().getDisplayMetrics().density * 86.0f * 0.6f);
            LayoutInflater.from(context).inflate(g.video_channel_header, (ViewGroup) this, true);
            this.f50153e = findViewById(f.rootView);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) findViewById(f.tab_layout);
            this.f50154f = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setTextViewShadowStringArrayId(c.a.r0.j4.b.S_O_X001);
            this.f50154f.setDefaultSelectorColorResourceId(c.a.r0.j4.c.CAM_X0101);
            this.f50154f.setNormalSelectorColorResId(c.a.r0.j4.c.CAM_X0103);
            this.f50154f.setRectPaintColor(c.a.r0.j4.c.CAM_X0101);
            this.f50154f.init(l.f(context, c.a.r0.j4.d.T_X06), l.f(context, c.a.r0.j4.d.T_X04), l.f(context, c.a.r0.j4.d.tbds10), l.f(context, c.a.r0.j4.d.T_X04), true);
            this.f50154f.setIndicatorOffset(l.f(context, c.a.r0.j4.d.tbds64));
            this.f50154f.setIndicatorOvershot(l.f(context, c.a.r0.j4.d.tbds8));
            this.f50154f.setIndicatorRadius(l.f(context, c.a.r0.j4.d.tbds8));
            this.f50154f.setIndicatorMarginBottom(l.f(context, c.a.r0.j4.d.tbds10));
            this.f50154f.setmIndicatorWidth(l.f(context, c.a.r0.j4.d.tbds42));
            this.f50154f.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(l.f(context, c.a.r0.j4.d.tbds166), -1));
            this.f50154f.onChangeSkinType();
            this.f50154f.setOnTabItemClickListener(new b(this));
            TextView textView = (TextView) findViewById(f.attention_tag);
            this.f50155g = textView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.v(c.a.r0.j4.c.CAM_X0101);
            d2.z(c.a.r0.j4.d.T_X10);
            d2.A(i.F_X01);
            d2.n(i.J_X01);
            d2.f(c.a.r0.j4.c.CAM_X0301);
            TextView textView2 = (TextView) findViewById(f.pull_refresh_text);
            this.f50156h = textView2;
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(textView2);
            d3.v(c.a.r0.j4.c.CAM_X0101);
            d3.z(c.a.r0.j4.d.T_X07);
            d3.A(i.F_X02);
            View findViewById = findViewById(f.pull_refresh_leading_layout);
            this.f50157i = findViewById;
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMargins(0, -l.f(context, c.a.r0.j4.d.tbds20), 0, 0);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) findViewById(f.pull_refresh_leading_view);
            this.f50158j = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, h.lottie_common_pull_refresh);
            if (this.f50158j.isAnimating()) {
                this.f50158j.cancelAnimation();
            }
            this.f50158j.setMinAndMaxProgress(0.0f, 1.0f);
            this.f50158j.setFrame(0);
            this.f50158j.setSpeed(1.3f);
            this.f50157i.setAlpha(0.0f);
        }
    }

    public final void j() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (continuousAnimationView = this.f50158j) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.f50158j.cancelAnimation();
        }
        this.q = false;
        this.f50158j.loop(true);
        this.f50158j.setMinFrame(27);
        this.f50158j.setRepeatMode(1);
        this.f50158j.removeAllAnimatorListeners();
        this.f50158j.addAnimatorListener(this.r);
        this.f50158j.playAnimation();
        this.f50157i.setAlpha(1.0f);
        this.mAlaEntranceBtn.setVisibility(8);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public void onFinish(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int i3 = this.m - 1;
            this.m = i3;
            if (i3 < 1) {
                this.f50158j.cancelAnimation();
                this.f50158j.setMinAndMaxProgress(0.0f, 1.0f);
                this.f50158j.setFrame(0);
                this.f50158j.setSpeed(1.3f);
                this.f50157i.setAlpha(0.0f);
                this.mAlaEntranceBtn.setVisibility(0);
                this.m = 0;
            }
            Runnable[] runnableArr = this.o;
            if (runnableArr[i2] != null) {
                this.p.removeCallbacks(runnableArr[i2]);
            }
        }
    }

    public void onRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.m < 1) {
                j();
            }
            this.m++;
            Runnable[] runnableArr = this.o;
            if (runnableArr[i2] == null) {
                runnableArr[i2] = new c(this, i2);
            }
            this.p.postDelayed(this.o[i2], 3000L);
        }
    }

    public void onTopLayoutChange(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (!j.z()) {
                    l.J(getContext(), getResources().getString(i.neterror));
                    return;
                }
                d dVar = this.l;
                if (dVar != null) {
                    dVar.a();
                }
            }
            int i4 = i3 + i2;
            this.f50153e.scrollTo(0, -i4);
            h(i4);
            g(i4);
            f(i4);
        }
    }

    public void refreshAttentionRedTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f50155g.setText(str);
            this.f50155g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public void setOnAchieveRefresh(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void setPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setmAlaEntranceBtn(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, imageView) == null) {
            this.mAlaEntranceBtn = imageView;
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewPager) == null) {
            this.f50154f.setViewPager(viewPager);
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
