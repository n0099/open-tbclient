package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.f0.u.b;
import c.a.r0.q1.o.l.k;
import c.a.r0.q1.t.a;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BannerFlowView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f54033e;

    /* renamed from: f  reason: collision with root package name */
    public View f54034f;

    /* renamed from: g  reason: collision with root package name */
    public IndicatorView f54035g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.q1.t.b f54036h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.q1.t.a f54037i;

    /* renamed from: j  reason: collision with root package name */
    public c f54038j;

    /* loaded from: classes7.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BannerFlowView f54039a;

        public a(BannerFlowView bannerFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54039a = bannerFlowView;
        }

        @Override // c.a.r0.q1.o.l.k
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f54039a.f54038j == null) {
                return;
            }
            this.f54039a.f54038j.a(i2);
        }

        @Override // c.a.r0.q1.o.l.k
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.f54039a.f54038j == null) {
                return;
            }
            this.f54039a.f54038j.b(f2);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerFlowView f54040e;

        public b(BannerFlowView bannerFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54040e = bannerFlowView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f54040e.f54038j == null) {
                return;
            }
            this.f54040e.f54038j.onPageSelected(i2);
        }
    }

    /* loaded from: classes7.dex */
    public interface c extends k {
        void onPageSelected(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFlowView(Context context) {
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
        c(context);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f54034f, R.drawable.bg_pic_shadow);
            this.f54035g.setSelector(SkinManager.getDrawable(R.drawable.icon_diandian_white_s));
            this.f54035g.setDrawable(SkinManager.getDrawable(R.drawable.icon_diandian_white_n));
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f54033e = new ListViewPager(context);
            this.f54034f = new View(context);
            IndicatorView indicatorView = new IndicatorView(context);
            this.f54035g = indicatorView;
            indicatorView.setSpacing(0);
            b();
            this.f54036h = new c.a.r0.q1.t.b(context, this.f54033e, this.f54035g, null);
            this.f54037i = new c.a.r0.q1.t.a(context, c.a.q0.s.f0.u.d.a.f13971e);
            this.f54036h.m(5000L);
            this.f54036h.l(context, this.f54037i);
            this.f54036h.q(new b(this));
            addView(this.f54033e, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(context, R.dimen.ds80));
            layoutParams.gravity = 80;
            addView(this.f54034f, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 85;
            layoutParams2.setMargins(0, 0, l.g(context, R.dimen.ds20), l.g(context, R.dimen.ds16));
            addView(this.f54035g, layoutParams2);
        }
    }

    public void setAutoScrollIntervalTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f54036h.m(j2);
        }
    }

    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f54033e.removeAllViews();
            this.f54036h.n(list);
        }
    }

    public void setDescOnPic(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                View view = this.f54034f;
                if (view != null) {
                    if (z2) {
                        view.setVisibility(0);
                    } else {
                        view.setVisibility(4);
                    }
                }
                this.f54036h.o(null);
                return;
            }
            View view2 = this.f54034f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f54036h.o(new a(this));
        }
    }

    public void setDisableParentEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f54033e.setDisableParentEvent(z);
        }
    }

    public void setIndicatorViewPosition(int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (indicatorView = this.f54035g) == null) {
            return;
        }
        if (i2 == 0) {
            indicatorView.setVisibility(8);
        } else if (i2 == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
            layoutParams.gravity = 85;
            this.f54035g.setLayoutParams(layoutParams);
            this.f54035g.setVisibility(0);
        } else if (i2 != 2) {
            indicatorView.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) indicatorView.getLayoutParams();
            layoutParams2.gravity = 81;
            layoutParams2.rightMargin = 0;
            layoutParams2.rightMargin = 0;
            this.f54035g.setLayoutParams(layoutParams2);
            this.f54035g.setVisibility(0);
        }
    }

    public void setMaxScrollCountLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f54036h.p(i2);
        }
    }

    public void setOnItemClickListener(b.a<c.a.q0.s.f0.u.d.a, a.C1113a> aVar) {
        c.a.r0.q1.t.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (aVar2 = this.f54037i) == null) {
            return;
        }
        aVar2.g(aVar);
    }

    public void setOnPageSelected(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f54038j = cVar;
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f54033e.setSwipeControlInterface(cVar);
            if (cVar != null) {
                this.f54033e.setDisableParentEvent(false);
            }
        }
    }

    public void startAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f54036h.r();
        }
    }

    public void stopAutoScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f54036h.s();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFlowView(Context context, AttributeSet attributeSet) {
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
        c(context);
    }
}
