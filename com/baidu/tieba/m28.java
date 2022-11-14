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
public class m28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public w48 b;
    public v48 c;
    public boolean d;

    public m28(PbFragment pbFragment) {
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
        v48 v48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (v48Var = this.c) != null) {
            v48Var.c(i);
        }
    }

    public void i(int i) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (w48Var = this.b) != null) {
            w48Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (w48Var = this.b) != null) {
            w48Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            w48 w48Var = this.b;
            if (w48Var != null) {
                return w48Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            w48 w48Var = this.b;
            if (w48Var != null) {
                bdTypeListView.removeHeaderView(w48Var.R());
            }
            v48 v48Var = this.c;
            if (v48Var != null) {
                v48Var.e(bdTypeListView);
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
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (w48Var = this.b) != null) {
            w48Var.r0(onClickListener);
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
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (w48Var = this.b) != null) {
            w48Var.O();
        }
    }

    public void b() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (w48Var = this.b) != null) {
            w48Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            w48 w48Var = this.b;
            if (w48Var != null) {
                return w48Var.P();
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
            w48 w48Var = this.b;
            if (w48Var != null) {
                return w48Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            w48 w48Var = this.b;
            if (w48Var != null && w48Var.X()) {
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
            w48 w48Var = this.b;
            if (w48Var != null) {
                return w48Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (w48Var = this.b) != null) {
            w48Var.f0();
        }
    }

    public void m() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (w48Var = this.b) != null) {
            w48Var.g0();
        }
    }

    public void t() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (w48Var = this.b) != null) {
            w48Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (w48Var = this.b) != null) {
            w48Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (w48Var = this.b) != null) {
            w48Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        w48 w48Var = this.b;
        if (w48Var != null && w48Var.P() != null) {
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
        w48 w48Var2 = this.b;
        if (w48Var2 != null) {
            pbLandscapeListView.removeHeaderView(w48Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.x(textView, 0);
        }
    }

    public void v(ox7 ox7Var, PostData postData, BdTypeListView bdTypeListView, l28 l28Var, FrameLayout frameLayout, u38 u38Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{ox7Var, postData, bdTypeListView, l28Var, frameLayout, u38Var, str, Long.valueOf(j)}) == null) && ox7Var != null && ox7Var.y0()) {
            w48 w48Var = this.b;
            if (w48Var == null) {
                w48 w48Var2 = new w48(this.a, u38Var, ox7Var.Q().getThreadVideoInfo(), j);
                this.b = w48Var2;
                w48Var2.U(ox7Var.Q().getThreadVideoInfo(), ox7Var.Q(), ox7Var.m());
                this.b.v0();
            } else if (this.d) {
                w48Var.U(ox7Var.Q().getThreadVideoInfo(), ox7Var.Q(), ox7Var.m());
                this.b.v0();
            } else {
                w48Var.w0(ox7Var.m());
            }
            p48.d(this.a.getUniqueId(), ox7Var, postData, 1, 1);
            if (ox7Var.M() != null && ox7Var.M().size() >= 1) {
                ThreadData threadData = ox7Var.M().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, ox7Var.Q(), ox7Var.U());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new v48(this.a.getBaseFragmentActivity());
            }
            this.c.d(ox7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            l28Var.F(bdTypeListView);
            l28Var.o(bdTypeListView, 2);
            if (this.b != null) {
                u38Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
