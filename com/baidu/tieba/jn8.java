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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public tp8 b;
    public sp8 c;
    public boolean d;

    public jn8(PbFragment pbFragment) {
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
        sp8 sp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (sp8Var = this.c) != null) {
            sp8Var.c(i);
        }
    }

    public void i(int i) {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (tp8Var = this.b) != null) {
            tp8Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (tp8Var = this.b) != null) {
            tp8Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            tp8 tp8Var = this.b;
            if (tp8Var != null) {
                return tp8Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            tp8 tp8Var = this.b;
            if (tp8Var != null) {
                bdTypeListView.removeHeaderView(tp8Var.R());
            }
            sp8 sp8Var = this.c;
            if (sp8Var != null) {
                sp8Var.e(bdTypeListView);
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
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (tp8Var = this.b) != null) {
            tp8Var.r0(onClickListener);
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
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tp8Var = this.b) != null) {
            tp8Var.O();
        }
    }

    public void b() {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tp8Var = this.b) != null) {
            tp8Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            tp8 tp8Var = this.b;
            if (tp8Var != null) {
                return tp8Var.P();
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
            tp8 tp8Var = this.b;
            if (tp8Var != null) {
                return tp8Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tp8 tp8Var = this.b;
            if (tp8Var != null && tp8Var.X()) {
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
            tp8 tp8Var = this.b;
            if (tp8Var != null) {
                return tp8Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tp8Var = this.b) != null) {
            tp8Var.f0();
        }
    }

    public void m() {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (tp8Var = this.b) != null) {
            tp8Var.g0();
        }
    }

    public void t() {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (tp8Var = this.b) != null) {
            tp8Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (tp8Var = this.b) != null) {
            tp8Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        tp8 tp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (tp8Var = this.b) != null) {
            tp8Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        tp8 tp8Var = this.b;
        if (tp8Var != null && tp8Var.P() != null) {
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.setTextViewAdded(false);
            }
            if (i != 1) {
                pbLandscapeListView.removeHeaderView(this.b.R());
                pbLandscapeListView.w(this.b.R(), 0);
                return;
            }
            return;
        }
        tp8 tp8Var2 = this.b;
        if (tp8Var2 != null) {
            pbLandscapeListView.removeHeaderView(tp8Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.w(textView, 0);
        }
    }

    public void v(ki8 ki8Var, bc9 bc9Var, BdTypeListView bdTypeListView, in8 in8Var, FrameLayout frameLayout, ro8 ro8Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{ki8Var, bc9Var, bdTypeListView, in8Var, frameLayout, ro8Var, str, Long.valueOf(j)}) == null) && ki8Var != null && ki8Var.y0()) {
            tp8 tp8Var = this.b;
            if (tp8Var == null) {
                tp8 tp8Var2 = new tp8(this.a, ro8Var, ki8Var.Q().getThreadVideoInfo(), j);
                this.b = tp8Var2;
                tp8Var2.U(ki8Var.Q().getThreadVideoInfo(), ki8Var.Q(), ki8Var.m());
                this.b.v0();
            } else if (this.d) {
                tp8Var.U(ki8Var.Q().getThreadVideoInfo(), ki8Var.Q(), ki8Var.m());
                this.b.v0();
            } else {
                tp8Var.w0(ki8Var.m());
            }
            mp8.d(this.a.getUniqueId(), ki8Var, bc9Var, 1, 1);
            if (ki8Var.M() != null && ki8Var.M().size() >= 1) {
                ThreadData threadData = ki8Var.M().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(bc9Var, ki8Var.Q(), ki8Var.U());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.w(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new sp8(this.a.getBaseFragmentActivity());
            }
            this.c.d(ki8Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.w(this.c.b(), 1);
            in8Var.F(bdTypeListView);
            in8Var.o(bdTypeListView, 2);
            if (this.b != null) {
                ro8Var.J(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
