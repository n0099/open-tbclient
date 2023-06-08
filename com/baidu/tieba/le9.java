package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class le9 extends in6<be9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public LinearLayout j;
    public LinearLayout k;
    public AutoBannerView l;
    public View m;
    public View n;
    public v75<kd9> o;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d079e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements v75<kd9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le9 a;

        public a(le9 le9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le9Var;
        }

        @Override // com.baidu.tieba.v75
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && this.a.l != null && str != null) {
                if (this.a.l.a(i)) {
                    TiebaStatic.log(new StatisticItem("c13247").param("obj_locate", i).param("obj_param1", str));
                }
                this.a.l.f();
                this.a.l.b(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v75
        /* renamed from: c */
        public void a(int i, kd9 kd9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, kd9Var) == null) && this.a.l != null && kd9Var != null && kd9Var.a() != null && this.a.l.a(i)) {
                TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_param1", kd9Var.a()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public le9(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.o = new a(this);
        this.n = h();
        int g = vi.g(this.c, R.dimen.M_W_X003);
        this.n.setPadding(g, 0, g, 0);
        this.j = (LinearLayout) this.n.findViewById(R.id.obfuscated_res_0x7f0928a2);
        this.k = (LinearLayout) this.n.findViewById(R.id.obfuscated_res_0x7f0915eb);
        AutoBannerView autoBannerView = (AutoBannerView) this.n.findViewById(R.id.obfuscated_res_0x7f091aea);
        this.l = autoBannerView;
        autoBannerView.getCoverFlowView().setAutoPlay(false);
        this.l.setMarqueenTime(3000L);
        this.l.getCoverFlowView().setCallback(this.o);
        this.m = this.n.findViewById(R.id.obfuscated_res_0x7f090406);
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || this.l.getCoverFlowView() == null) {
            return;
        }
        if (z) {
            this.l.getCoverFlowView().m();
        } else {
            this.l.getCoverFlowView().x();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            s(z);
        }
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.i != i) {
            AutoBannerView autoBannerView = this.l;
            if (autoBannerView != null) {
                autoBannerView.e(i);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            this.i = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: t */
    public void i(be9 be9Var) {
        List<kd9> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, be9Var) == null) {
            j(this.b, TbadkCoreApplication.getInst().getSkinType());
            if (this.j == null || be9Var == null || (list = be9Var.a) == null || this.l == null || list.size() == 0) {
                return;
            }
            this.l.d(be9Var.a);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s(false);
        }
    }
}
