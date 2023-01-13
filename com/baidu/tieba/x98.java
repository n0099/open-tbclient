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
/* loaded from: classes6.dex */
public class x98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public hc8 b;
    public gc8 c;
    public boolean d;

    public x98(PbFragment pbFragment) {
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
        gc8 gc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (gc8Var = this.c) != null) {
            gc8Var.c(i);
        }
    }

    public void i(int i) {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (hc8Var = this.b) != null) {
            hc8Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (hc8Var = this.b) != null) {
            hc8Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            hc8 hc8Var = this.b;
            if (hc8Var != null) {
                return hc8Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            hc8 hc8Var = this.b;
            if (hc8Var != null) {
                bdTypeListView.removeHeaderView(hc8Var.R());
            }
            gc8 gc8Var = this.c;
            if (gc8Var != null) {
                gc8Var.e(bdTypeListView);
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
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (hc8Var = this.b) != null) {
            hc8Var.r0(onClickListener);
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
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hc8Var = this.b) != null) {
            hc8Var.O();
        }
    }

    public void b() {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hc8Var = this.b) != null) {
            hc8Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hc8 hc8Var = this.b;
            if (hc8Var != null) {
                return hc8Var.P();
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
            hc8 hc8Var = this.b;
            if (hc8Var != null) {
                return hc8Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hc8 hc8Var = this.b;
            if (hc8Var != null && hc8Var.X()) {
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
            hc8 hc8Var = this.b;
            if (hc8Var != null) {
                return hc8Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (hc8Var = this.b) != null) {
            hc8Var.f0();
        }
    }

    public void m() {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (hc8Var = this.b) != null) {
            hc8Var.g0();
        }
    }

    public void t() {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (hc8Var = this.b) != null) {
            hc8Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (hc8Var = this.b) != null) {
            hc8Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        hc8 hc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (hc8Var = this.b) != null) {
            hc8Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        hc8 hc8Var = this.b;
        if (hc8Var != null && hc8Var.P() != null) {
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
        hc8 hc8Var2 = this.b;
        if (hc8Var2 != null) {
            pbLandscapeListView.removeHeaderView(hc8Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.x(textView, 0);
        }
    }

    public void v(y48 y48Var, PostData postData, BdTypeListView bdTypeListView, w98 w98Var, FrameLayout frameLayout, fb8 fb8Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{y48Var, postData, bdTypeListView, w98Var, frameLayout, fb8Var, str, Long.valueOf(j)}) == null) && y48Var != null && y48Var.y0()) {
            hc8 hc8Var = this.b;
            if (hc8Var == null) {
                hc8 hc8Var2 = new hc8(this.a, fb8Var, y48Var.Q().getThreadVideoInfo(), j);
                this.b = hc8Var2;
                hc8Var2.U(y48Var.Q().getThreadVideoInfo(), y48Var.Q(), y48Var.m());
                this.b.v0();
            } else if (this.d) {
                hc8Var.U(y48Var.Q().getThreadVideoInfo(), y48Var.Q(), y48Var.m());
                this.b.v0();
            } else {
                hc8Var.w0(y48Var.m());
            }
            ac8.d(this.a.getUniqueId(), y48Var, postData, 1, 1);
            if (y48Var.M() != null && y48Var.M().size() >= 1) {
                ThreadData threadData = y48Var.M().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, y48Var.Q(), y48Var.U());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new gc8(this.a.getBaseFragmentActivity());
            }
            this.c.d(y48Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            w98Var.F(bdTypeListView);
            w98Var.o(bdTypeListView, 2);
            if (this.b != null) {
                fb8Var.J(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
