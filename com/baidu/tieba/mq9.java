package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mq9 extends wo6<PersonVipCardData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public View k;
    public EMTextView l;
    public EMTextView m;
    public TBSpecificationBtn n;
    public TextView o;
    public TbPageContext p;
    public String q;
    public String r;
    public boolean s;
    public final k29 t;
    public final j29 u;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d07c8 : invokeV.intValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mq9(TbPageContext<?> tbPageContext) {
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
        this.t = new k29("my_tab_vip_banner_bubble");
        this.u = new j29("my_tab_vip_banner_bubble");
        this.p = tbPageContext;
        this.i = h();
        int g = yi.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.j = this.i.findViewById(R.id.obfuscated_res_0x7f091c1a);
        this.k = this.i.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.l = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c18);
        this.m = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c19);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091c17);
        this.o = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091e6d);
        this.j.setOnClickListener(this);
        this.n.setOnClickListener(this);
        j(g(), this.a);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o.setVisibility(8);
            this.t.i();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            d85 d = d85.d(this.j);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0205);
            d85 d2 = d85.d(this.l);
            d2.x(R.color.CAM_X0311);
            d2.D(R.string.F_X02);
            d2.C(R.dimen.T_X07);
            d85 d3 = d85.d(this.m);
            d3.x(R.color.CAM_X0311);
            d3.D(R.string.F_X01);
            d3.C(R.dimen.T_X08);
            if (this.o.getVisibility() == 0) {
                d85 d4 = d85.d(this.o);
                d4.C(R.dimen.T_X10);
                d4.x(R.color.CAM_X0101);
                d4.D(R.string.F_X01);
                d4.m(R.dimen.L_X02);
                d4.l(R.color.CAM_X0205);
                d4.o(R.string.J_X05);
                d4.f(R.color.CAM_X0301);
            }
            SkinManager.setBackgroundResource(this.j, R.drawable.bg_pic_wode_members_bg);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            d85.d(this.i).q(new int[]{R.color.CAM_X0204, R.color.CAM_X0201}, Direction.BOTTOM);
            gb5 gb5Var = new gb5();
            gb5Var.u(new int[]{dba.a(SkinManager.getColor(i, (int) R.color.CAM_X0335), b85.b(R.string.A_X06)), SkinManager.getColor(i, (int) R.color.CAM_X0335)});
            gb5Var.s(R.color.CAM_X0117);
            this.n.setConfig(gb5Var);
            this.n.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.n) {
            z();
            rd9.b(this.p, 2001);
            r();
        } else if (view2 == this.j) {
            A();
            UrlManager.getInstance().dealOneLink(this.p, new String[]{this.q});
            r();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: s */
    public void i(PersonVipCardData personVipCardData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personVipCardData) == null) && personVipCardData != null) {
            this.l.setText(personVipCardData.getTitle());
            this.m.setText(personVipCardData.getSubTitle());
            this.n.setText(personVipCardData.getButtonLable());
            String bubble = personVipCardData.getBubble();
            boolean g = this.t.g(this.u.f(bubble));
            if (!xi.isEmpty(bubble) && !g) {
                this.o.setVisibility(0);
                this.o.setText(StringHelper.subString(bubble, 10));
                this.u.update(bubble);
            } else {
                this.o.setVisibility(8);
            }
            this.q = personVipCardData.getUrl();
            personVipCardData.getButtonUrl();
            this.r = personVipCardData.getButtonLable();
            if (this.s) {
                this.s = false;
                B();
            }
            j(g(), this.a);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_BUTTON_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (StringHelper.equals(this.r, getContext().getString(R.string.open_now))) {
                statisticItem.param("obj_type", 1);
            } else if (StringHelper.equals(this.r, getContext().getString(R.string.renew_now))) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
