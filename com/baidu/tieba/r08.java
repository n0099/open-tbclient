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
public class r08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public b38 b;
    public a38 c;
    public boolean d;

    public r08(PbFragment pbFragment) {
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
        a38 a38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (a38Var = this.c) != null) {
            a38Var.c(i);
        }
    }

    public void i(int i) {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (b38Var = this.b) != null) {
            b38Var.c0(i);
        }
    }

    public void j(Configuration configuration) {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (b38Var = this.b) != null) {
            b38Var.d0(configuration);
        }
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            b38 b38Var = this.b;
            if (b38Var != null) {
                return b38Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) && bdTypeListView != null) {
            b38 b38Var = this.b;
            if (b38Var != null) {
                bdTypeListView.removeHeaderView(b38Var.R());
            }
            a38 a38Var = this.c;
            if (a38Var != null) {
                a38Var.e(bdTypeListView);
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
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (b38Var = this.b) != null) {
            b38Var.r0(onClickListener);
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
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b38Var = this.b) != null) {
            b38Var.O();
        }
    }

    public void b() {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (b38Var = this.b) != null) {
            b38Var.f0();
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b38 b38Var = this.b;
            if (b38Var != null) {
                return b38Var.P();
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
            b38 b38Var = this.b;
            if (b38Var != null) {
                return b38Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b38 b38Var = this.b;
            if (b38Var != null && b38Var.X()) {
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
            b38 b38Var = this.b;
            if (b38Var != null) {
                return b38Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (b38Var = this.b) != null) {
            b38Var.f0();
        }
    }

    public void m() {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (b38Var = this.b) != null) {
            b38Var.g0();
        }
    }

    public void t() {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (b38Var = this.b) != null) {
            b38Var.s0();
        }
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) && (b38Var = this.b) != null) {
            b38Var.h0(absListView, i);
        }
    }

    public void o(AbsListView absListView, int i) {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) && (b38Var = this.b) != null) {
            b38Var.i0(absListView, i);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) != null) || pbLandscapeListView == null) {
            return;
        }
        b38 b38Var = this.b;
        if (b38Var != null && b38Var.P() != null) {
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
        b38 b38Var2 = this.b;
        if (b38Var2 != null) {
            pbLandscapeListView.removeHeaderView(b38Var2.R());
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.x(textView, 0);
        }
    }

    public void v(uv7 uv7Var, PostData postData, BdTypeListView bdTypeListView, q08 q08Var, FrameLayout frameLayout, z18 z18Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{uv7Var, postData, bdTypeListView, q08Var, frameLayout, z18Var, str, Long.valueOf(j)}) == null) && uv7Var != null && uv7Var.x0()) {
            b38 b38Var = this.b;
            if (b38Var == null) {
                b38 b38Var2 = new b38(this.a, z18Var, uv7Var.P().getThreadVideoInfo(), j);
                this.b = b38Var2;
                b38Var2.U(uv7Var.P().getThreadVideoInfo(), uv7Var.P(), uv7Var.m());
                this.b.v0();
            } else if (this.d) {
                b38Var.U(uv7Var.P().getThreadVideoInfo(), uv7Var.P(), uv7Var.m());
                this.b.v0();
            } else {
                b38Var.w0(uv7Var.m());
            }
            u28.d(this.a.getUniqueId(), uv7Var, postData, 1, 1);
            if (uv7Var.L() != null && uv7Var.L().size() >= 1) {
                ThreadData threadData = (ThreadData) uv7Var.L().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, uv7Var.P(), uv7Var.T());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new a38(this.a.getBaseFragmentActivity());
            }
            this.c.d(uv7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            q08Var.E(bdTypeListView);
            q08Var.o(bdTypeListView, 2);
            if (this.b != null) {
                z18Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
