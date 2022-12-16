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
/* loaded from: classes5.dex */
public class nb8 extends h46<PersonVipCardData> {
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
    public String s;
    public boolean t;

    @Override // com.baidu.tieba.h46
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0731 : invokeV.intValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nb8(TbPageContext<?> tbPageContext) {
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
        this.p = tbPageContext;
        this.i = h();
        int g = yi.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.j = this.i.findViewById(R.id.obfuscated_res_0x7f091a44);
        this.k = this.i.findViewById(R.id.obfuscated_res_0x7f091a45);
        this.l = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091a42);
        this.m = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091a43);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091a41);
        this.o = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c77);
        this.j.setOnClickListener(this);
        this.n.setOnClickListener(this);
        j(g(), this.a);
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.t = z;
        }
    }

    @Override // com.baidu.tieba.h46
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            rw4 d = rw4.d(this.j);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0205);
            rw4 d2 = rw4.d(this.l);
            d2.v(R.color.CAM_X0311);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            rw4 d3 = rw4.d(this.m);
            d3.v(R.color.CAM_X0311);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X08);
            if (this.o.getVisibility() == 0) {
                rw4 d4 = rw4.d(this.o);
                d4.z(R.dimen.T_X10);
                d4.v(R.color.CAM_X0101);
                d4.A(R.string.F_X01);
                d4.l(R.dimen.L_X02);
                d4.k(R.color.CAM_X0205);
                d4.n(R.string.J_X05);
                d4.f(R.color.CAM_X0301);
            }
            SkinManager.setBackgroundResource(this.j, R.drawable.bg_pic_wode_members_bg);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            rw4.d(this.i).p(new int[]{R.color.CAM_X0204, R.color.CAM_X0201}, Direction.BOTTOM);
            oz4 oz4Var = new oz4();
            oz4Var.s(new int[]{qq8.a(SkinManager.getColor(i, (int) R.color.CAM_X0335), pw4.b(R.string.A_X06)), SkinManager.getColor(i, (int) R.color.CAM_X0335)});
            oz4Var.q(R.color.CAM_X0117);
            this.n.setConfig(oz4Var);
            this.n.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.n) {
            w();
            UrlManager.getInstance().dealOneLink(this.p, new String[]{this.r});
        } else if (view2 == this.j) {
            x();
            UrlManager.getInstance().dealOneLink(this.p, new String[]{this.q});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h46
    /* renamed from: r */
    public void i(PersonVipCardData personVipCardData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, personVipCardData) == null) && personVipCardData != null) {
            this.l.setText(personVipCardData.getTitle());
            this.m.setText(personVipCardData.getSubTitle());
            this.n.setText(personVipCardData.getButtonLable());
            if (xi.isEmpty(personVipCardData.getBubble())) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.o.setText(personVipCardData.getBubble());
            }
            this.q = personVipCardData.getUrl();
            this.r = personVipCardData.getButtonUrl();
            this.s = personVipCardData.getButtonLable();
            if (this.t) {
                this.t = false;
                y();
            }
            j(g(), this.a);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_BUTTON_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (StringHelper.equals(this.s, getContext().getString(R.string.open_now))) {
                statisticItem.param("obj_type", 1);
            } else if (StringHelper.equals(this.s, getContext().getString(R.string.renew_now))) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }
}
