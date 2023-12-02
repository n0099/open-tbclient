package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hh5 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.d g;
    public zv9 h;
    public View.OnClickListener i;
    public int j;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k0a a;

        public a(k0a k0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k0aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !(TbadkCoreApplication.getInst().getCurrentActivity() instanceof PbCommentFloatActivity) || ((PbCommentFloatActivity) TbadkCoreApplication.getInst().getCurrentActivity()).n2() || this.a.a == null) {
                return;
            }
            for (ue5 ue5Var : this.a.a.a().getAllTools()) {
                if (ue5Var != null) {
                    ve5 ve5Var = ue5Var.m;
                    if ((ve5Var instanceof PbNewInputContainer) && ((View) ve5Var).getVisibility() == 0 && !ue5Var.o) {
                        ue5Var.m.display();
                    }
                }
            }
            if (this.a.j < 5) {
                k0a.c(this.a);
                SafeHandler.getInst().postDelayed(this.a.k, 200L);
            }
        }
    }

    public k0a(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = new a(this);
        this.b = tbPageContext;
        this.c = relativeLayout;
        this.d = pbFakeFloorModel;
    }

    public static /* synthetic */ int c(k0a k0aVar) {
        int i = k0aVar.j;
        k0aVar.j = i + 1;
        return i;
    }

    public void l(int i) {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (hh5Var = this.a) != null && hh5Var.a() != null) {
            this.a.a().F(i);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f = str;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void q(int i) {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (hh5Var = this.a) != null) {
            hh5Var.T(i);
        }
    }

    public void r(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zv9Var) == null) {
            this.h = zv9Var;
        }
    }

    public void s(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.g = dVar;
            hh5 hh5Var = this.a;
            if (hh5Var != null) {
                hh5Var.U(dVar);
            }
        }
    }

    public final void e() {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null && (hh5Var = this.a) != null && hh5Var.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.c.addView(this.a.a(), layoutParams);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public hh5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (hh5) invokeV.objValue;
    }

    public void g() {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hh5Var = this.a) != null) {
            hh5Var.B();
            if (StringUtils.isNull(this.e)) {
                this.a.H();
            }
            this.a.a().I();
        }
    }

    public void h() {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hh5Var = this.a) != null && hh5Var.a() != null) {
            this.a.a().y();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hh5 hh5Var = this.a;
            if (hh5Var != null && hh5Var.a() != null) {
                return this.a.a().D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.k);
            hh5 hh5Var = this.a;
            if (hh5Var != null) {
                hh5Var.G();
            }
        }
    }

    public void n() {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (hh5Var = this.a) != null) {
            hh5Var.I();
        }
    }

    public final void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            ih5 ih5Var = new ih5(z);
            ih5Var.i(str);
            hh5 hh5Var = (hh5) ih5Var.a(this.b.getPageActivity());
            this.a = hh5Var;
            hh5Var.R(this.b);
            this.a.e0(this.d);
            this.a.S(1);
            zv9 zv9Var = this.h;
            if (zv9Var != null) {
                this.a.g0(zv9Var.R());
            }
            this.a.a().M(true);
            this.a.a().setOnCancelClickListener(this.i);
            this.a.C(this.b);
            e();
            this.a.U(this.g);
        }
    }

    public void k(int i, int i2, Intent intent) {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && (hh5Var = this.a) != null) {
            hh5Var.F(i, i2, intent);
        }
    }

    public void t(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            hh5 hh5Var = this.a;
            if (hh5Var == null) {
                i(str3, z);
            } else {
                hh5Var.e0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.C(this.b);
                }
            }
            this.a.a0(str);
            this.a.Z(str2, "");
            SafeHandler.getInst().postDelayed(this.k, 200L);
            this.a.q(this.f);
            if (this.a.A()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.x(null);
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
