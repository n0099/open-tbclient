package com.baidu.tieba;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r77 implements uz6, d67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public TbImageView c;
    public Animation d;
    public Animation e;
    public int f;
    public boolean g;
    public LinearLayout h;
    public EntelechyPullUpRefreshView i;
    public EntelechyPullUpRefreshView j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r77 a;

        public a(r77 r77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            if (view2 == this.a.i) {
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (!this.a.a.E3() && this.a.a.u1() != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.a.O()).param("obj_locate", "3"));
                    this.a.a.u1().b2();
                }
            } else if (view2 == this.a.j && this.a.a.u1() != null && this.a.a.u1().g0() != null) {
                this.a.a.u1().g0().smoothScrollToPosition(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view2 = this.a) != null && view2.getAnimation() == animation) {
                this.a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (view2 = this.a) != null) {
                view2.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public c(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view2 = this.a) != null && view2.getAnimation() == animation) {
                this.a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (view2 = this.a) != null) {
                view2.setVisibility(0);
            }
        }
    }

    public r77(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.f = 3;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = true;
        this.l = new a(this);
        this.a = frsFragment;
        this.b = noPressedRelativeLayout;
        i();
        this.h = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cdd);
        this.j = (EntelechyPullUpRefreshView) this.b.findViewById(R.id.obfuscated_res_0x7f090cdc);
        this.i = (EntelechyPullUpRefreshView) this.b.findViewById(R.id.obfuscated_res_0x7f090cde);
        this.j.setOnClickListener(this.l);
        this.i.setOnClickListener(this.l);
        onChangeSkinType(this.f);
    }

    @Override // com.baidu.tieba.uz6
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g = z;
            if (this.i != null) {
                if (z) {
                    LinearLayout linearLayout = this.h;
                    if (linearLayout != null && linearLayout.getVisibility() == 0) {
                        l();
                        return;
                    }
                    return;
                }
                m();
            }
        }
    }

    @Override // com.baidu.tieba.uz6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.f != i) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i);
            }
            this.f = i;
        }
    }

    @Override // com.baidu.tieba.uz6
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.h.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.uz6
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d67
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (tbImageView = this.c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.c.setImageDrawable(null);
        this.c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (linearLayout = this.h) != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.d == null) {
                j();
            }
            Animation animation = this.d;
            if (animation == null) {
                return;
            }
            this.h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.e == null) {
                k();
            }
            if (this.e == null) {
                return;
            }
            this.h.setVisibility(0);
            this.h.startAnimation(this.e);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = new TbImageView(this.a.getPageContext().getPageActivity());
            int g = ej.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070261);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g;
            this.c.setLayoutParams(layoutParams);
            this.b.addView(this.c);
            this.c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !this.a.isAdded()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f01008a);
        this.d = loadAnimation;
        loadAnimation.setAnimationListener(new b(this.h));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.a.isAdded()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010089);
        this.e = loadAnimation;
        loadAnimation.setAnimationListener(new c(this.h));
    }
}
