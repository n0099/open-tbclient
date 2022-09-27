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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.floatCardView.AlaLiveTipView;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoChannelHeaderLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NewPagerSlidingTabBaseStrip b;
    public TextView c;
    public TextView d;
    public View e;
    public ContinuousAnimationView f;
    public int g;
    public AlaLiveTipView h;
    public d i;
    public int j;
    public int k;
    public final Runnable[] l;
    public final Handler m;
    public boolean n;
    public final Animator.AnimatorListener o;

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelHeaderLayout a;

        public a(VideoChannelHeaderLayout videoChannelHeaderLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelHeaderLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelHeaderLayout;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.a.n) {
                return;
            }
            this.a.n = true;
            this.a.f.setSpeed(1.0f);
            this.a.f.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelHeaderLayout;
        }

        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.c
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && this.a.k == i && this.a.i != null) {
                this.a.i.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ VideoChannelHeaderLayout b;

        public c(VideoChannelHeaderLayout videoChannelHeaderLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelHeaderLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoChannelHeaderLayout;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.l(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = 1;
        this.l = new Runnable[2];
        this.m = new Handler();
        this.n = false;
        this.o = new a(this);
        j(context);
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            CustomMessage customMessage = new CustomMessage(2921574);
            customMessage.setTag(bdUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921574, Integer.valueOf(this.k));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            float f = (i * 1.0f) / this.g;
            if (f > 0.6f) {
                this.h.setAlpha(0.0f);
            } else {
                this.h.setAlpha(1.0f - (f / 0.6f));
            }
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.j >= 1) {
            return;
        }
        float f = 1.0f;
        float f2 = (i * 1.0f) / this.g;
        if (f2 < 0.8f && f2 > 0.6f) {
            f = (f2 - 0.6f) / 0.2f;
        } else if (f2 <= 0.8f) {
            f = 0.0f;
        }
        this.e.setAlpha(f);
        this.f.setFrame((int) Math.min(27.0f, ((f * 27.0f) * 5.0f) / 3.0f));
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            float f = (i * 1.0f) / this.g;
            if (f > 0.6f) {
                this.b.setAlpha(0.0f);
                this.c.setAlpha(0.0f);
                if (f > 0.8f) {
                    this.d.setAlpha(1.0f);
                } else {
                    this.d.setAlpha((f - 0.6f) / 0.2f);
                }
                this.d.setVisibility(0);
                return;
            }
            float f2 = 1.0f - (f / 0.6f);
            this.b.setAlpha(f2);
            this.c.setAlpha(f2);
            this.d.setAlpha(0.0f);
            this.d.setVisibility(8);
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.g = (int) (getResources().getDisplayMetrics().density * 86.0f * 0.6f);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08cb, (ViewGroup) this, true);
            this.a = findViewById(R.id.obfuscated_res_0x7f091c6e);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) findViewById(R.id.obfuscated_res_0x7f092018);
            this.b = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setTextViewShadowStringArrayId(R.array.S_O_X001);
            this.b.setDefaultSelectorColorResourceId(R.color.CAM_X0101);
            this.b.setNormalSelectorColorResId(R.color.CAM_X0103);
            this.b.setRectPaintColor(R.color.CAM_X0101);
            this.b.B(ej.f(context, R.dimen.T_X06), ej.f(context, R.dimen.T_X04), ej.f(context, R.dimen.tbds10), ej.f(context, R.dimen.T_X04), true);
            this.b.setIndicatorOffset(ej.f(context, R.dimen.tbds64));
            this.b.setIndicatorOvershot(ej.f(context, R.dimen.tbds8));
            this.b.setIndicatorRadius(ej.f(context, R.dimen.tbds8));
            this.b.setIndicatorMarginBottom(ej.f(context, R.dimen.tbds10));
            this.b.setmIndicatorWidth(ej.f(context, R.dimen.tbds42));
            this.b.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(ej.f(context, R.dimen.tbds166), -1));
            this.b.G();
            this.b.setOnTabItemClickListener(new b(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0902e2);
            this.c = textView;
            hv4 d2 = hv4.d(textView);
            d2.v(R.color.CAM_X0101);
            d2.z(R.dimen.T_X10);
            d2.A(R.string.F_X01);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0301);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091af6);
            this.d = textView2;
            hv4 d3 = hv4.d(textView2);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X02);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091af4);
            this.e = findViewById;
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMargins(0, -ej.f(context, R.dimen.tbds20), 0, 0);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) findViewById(R.id.obfuscated_res_0x7f091af5);
            this.f = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_common_pull_refresh);
            if (this.f.isAnimating()) {
                this.f.cancelAnimation();
            }
            this.f.setMinAndMaxProgress(0.0f, 1.0f);
            this.f.setFrame(0);
            this.f.setSpeed(1.3f);
            this.e.setAlpha(0.0f);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m.removeCallbacksAndMessages(null);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int i2 = this.j - 1;
            this.j = i2;
            if (i2 < 1) {
                this.f.cancelAnimation();
                this.f.setMinAndMaxProgress(0.0f, 1.0f);
                this.f.setFrame(0);
                this.f.setSpeed(1.3f);
                this.e.setAlpha(0.0f);
                this.h.setVisibility(0);
                this.j = 0;
            }
            Runnable[] runnableArr = this.l;
            if (runnableArr[i] != null) {
                this.m.removeCallbacks(runnableArr[i]);
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (this.j < 1) {
                p();
            }
            this.j++;
            Runnable[] runnableArr = this.l;
            if (runnableArr[i] == null) {
                runnableArr[i] = new c(this, i);
            }
            this.m.postDelayed(this.l[i], 3000L);
        }
    }

    public void n(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ej.K(getContext(), getResources().getString(R.string.obfuscated_res_0x7f0f0c59));
                    return;
                }
                d dVar = this.i;
                if (dVar != null) {
                    dVar.a();
                }
            }
            int i3 = i2 + i;
            this.a.scrollTo(0, -i3);
            i(i3);
            h(i3);
            g(i3);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c.setText(str);
            this.c.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public final void p() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (continuousAnimationView = this.f) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.f.cancelAnimation();
        }
        this.n = false;
        this.f.loop(true);
        this.f.setMinFrame(27);
        this.f.setRepeatMode(1);
        this.f.removeAllAnimatorListeners();
        this.f.addAnimatorListener(this.o);
        this.f.playAnimation();
        this.e.setAlpha(1.0f);
        this.h.setVisibility(8);
    }

    public void setAlaEntranceBtn(AlaLiveTipView alaLiveTipView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, alaLiveTipView) == null) {
            this.h = alaLiveTipView;
        }
    }

    public void setOnAchieveRefresh(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.i = dVar;
        }
    }

    public void setPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.k = i;
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewPager) == null) {
            this.b.setViewPager(viewPager);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = 1;
        this.l = new Runnable[2];
        this.m = new Handler();
        this.n = false;
        this.o = new a(this);
        j(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = 1;
        this.l = new Runnable[2];
        this.m = new Handler();
        this.n = false;
        this.o = new a(this);
        j(context);
    }
}
