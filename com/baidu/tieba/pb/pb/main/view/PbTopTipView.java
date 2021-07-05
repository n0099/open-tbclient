package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.i0.a;
/* loaded from: classes5.dex */
public class PbTopTipView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19514e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19515f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19516g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19517h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f19518i;
    public d.a.s0.i0.b j;
    public a.b k;
    public Runnable l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19519e;

        public a(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19519e = pbTopTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19519e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19520a;

        public b(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19520a = pbTopTipView;
        }

        @Override // d.a.s0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && e(i3) && this.f19520a.f19515f) {
                this.f19520a.h();
            }
        }

        @Override // d.a.s0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 5.0f : invokeF.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19521e;

        public c(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19521e = pbTopTipView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f19521e.j.c(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19522a;

        public d(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19522a = pbTopTipView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f19522a.k();
                this.f19522a.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(this.f19522a.l, 600L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19523a;

        public e(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19523a = pbTopTipView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f19523a.f19514e <= 0) {
                return;
            }
            PbTopTipView pbTopTipView = this.f19523a;
            pbTopTipView.postDelayed(pbTopTipView.f19518i, this.f19523a.f19514e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbTopTipView f19524e;

        public f(PbTopTipView pbTopTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19524e = pbTopTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (viewGroup = (ViewGroup) this.f19524e.getParent()) == null) {
                return;
            }
            viewGroup.removeView(this.f19524e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopTipView(Context context) {
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
        this.f19514e = 3000;
        this.f19518i = new a(this);
        this.k = new b(this);
        this.l = new f(this);
        i();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19515f = false;
            k();
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19515f = false;
            removeCallbacks(this.f19518i);
            if (getParent() != null) {
                clearAnimation();
                startAnimation(this.f19516g);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.i0.b bVar = new d.a.s0.i0.b(getContext());
            this.j = bVar;
            bVar.d(this.k);
            setOnTouchListener(new c(this));
            setupPaddings();
            this.f19517h = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_in);
            this.f19516g = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_out);
            setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize30));
            this.f19516g.setAnimationListener(new d(this));
            this.f19517h.setDuration(400L);
            this.f19517h.setAnimationListener(new e(this));
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundResource(this, R.color.cp_link_tip_a_alpha95, i2);
            SkinManager.setViewTextColor(this, R.color.CAM_X0101, 1, i2);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeCallbacks(this.f19518i);
            clearAnimation();
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
    }

    public void l(RelativeLayout relativeLayout, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, relativeLayout, i2) == null) || relativeLayout == null) {
            return;
        }
        if (getParent() != null) {
            clearAnimation();
            ((ViewGroup) getParent()).removeView(this);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.addView(this, layoutParams);
        j(i2);
        startAnimation(this.f19517h);
        this.f19515f = true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            setupPaddings();
        }
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f19514e = i2;
        }
    }

    public void setupPaddings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ds30);
            int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
            int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.ds34);
            setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopTipView(Context context, AttributeSet attributeSet) {
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
        this.f19514e = 3000;
        this.f19518i = new a(this);
        this.k = new b(this);
        this.l = new f(this);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopTipView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f19514e = 3000;
        this.f19518i = new a(this);
        this.k = new b(this);
        this.l = new f(this);
        i();
    }
}
