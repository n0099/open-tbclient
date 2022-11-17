package com.baidu.tieba;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public x48 b;
    public w48 c;
    public boolean d;

    public n28(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = pbFragment;
    }

    public void h(int i) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (w48Var = this.c) != null) {
            w48Var.c(i);
        }
    }

    public void i(int i) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (x48Var = this.b) != null) {
            x48Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (x48Var = this.b) != null) {
            x48Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            x48 x48Var = this.b;
            if (x48Var != null) {
                return x48Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            x48 x48Var = this.b;
            if (x48Var != null) {
                bdTypeListView.removeHeaderView(x48Var.R());
            }
            w48 w48Var = this.c;
            if (w48Var != null) {
                w48Var.e(bdTypeListView);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (x48Var = this.b) != null) {
            x48Var.r0(onClickListener);
        }
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) && this.b != null) {
            TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
            this.b.s0();
            bdTypeListView.smoothScrollToPosition(0);
        }
    }

    public void a() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (x48Var = this.b) != null) {
            x48Var.O();
        }
    }

    public void b() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (x48Var = this.b) != null) {
            x48Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x48 x48Var = this.b;
            if (x48Var != null) {
                return x48Var.P();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View c = c();
            if (c != null) {
                return c.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            x48 x48Var = this.b;
            if (x48Var != null) {
                return x48Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            x48 x48Var = this.b;
            if (x48Var != null && x48Var.X()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            x48 x48Var = this.b;
            if (x48Var != null) {
                return x48Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (x48Var = this.b) != null) {
            x48Var.f0();
        }
    }

    public void m() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (x48Var = this.b) != null) {
            x48Var.g0();
        }
    }

    public void t() {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (x48Var = this.b) != null) {
            x48Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (x48Var = this.b) != null) {
            x48Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        x48 x48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (x48Var = this.b) != null) {
            x48Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        x48 x48Var = this.b;
        if (x48Var != null && x48Var.P() != null) {
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.setTextViewAdded(false);
            }
            if (i != 1) {
                pbLandscapeListView.removeHeaderView(this.b.R());
                pbLandscapeListView.x(this.b.R(), 0);
                return;
            }
            return;
        }
        x48 x48Var2 = this.b;
        if (x48Var2 != null) {
            pbLandscapeListView.removeHeaderView(x48Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.x(textView, 0);
        }
    }

    public void v(px7 px7Var, PostData postData, BdTypeListView bdTypeListView, m28 m28Var, FrameLayout frameLayout, v38 v38Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{px7Var, postData, bdTypeListView, m28Var, frameLayout, v38Var, str, Long.valueOf(j)}) == null) && px7Var != null && px7Var.y0()) {
            x48 x48Var = this.b;
            if (x48Var == null) {
                x48 x48Var2 = new x48(this.a, v38Var, px7Var.Q().getThreadVideoInfo(), j);
                this.b = x48Var2;
                x48Var2.U(px7Var.Q().getThreadVideoInfo(), px7Var.Q(), px7Var.m());
                this.b.v0();
            } else if (this.d) {
                x48Var.U(px7Var.Q().getThreadVideoInfo(), px7Var.Q(), px7Var.m());
                this.b.v0();
            } else {
                x48Var.w0(px7Var.m());
            }
            q48.d(this.a.getUniqueId(), px7Var, postData, 1, 1);
            if (px7Var.M() != null && px7Var.M().size() >= 1) {
                ThreadData threadData = px7Var.M().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, px7Var.Q(), px7Var.U());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new w48(this.a.getBaseFragmentActivity());
            }
            this.c.d(px7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            m28Var.F(bdTypeListView);
            m28Var.o(bdTypeListView, 2);
            if (this.b != null) {
                v38Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
