package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nr9 extends cj6<PersonVipCardData> {
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
    public final g19 t;
    public final f19 u;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d07db : invokeV.intValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nr9(TbPageContext<?> tbPageContext) {
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
        this.t = new g19("my_tab_vip_banner_bubble");
        this.u = new f19("my_tab_vip_banner_bubble");
        this.p = tbPageContext;
        this.i = i();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.i.setPadding(dimens, 0, dimens, 0);
        this.j = this.i.findViewById(R.id.obfuscated_res_0x7f091c68);
        this.k = this.i.findViewById(R.id.obfuscated_res_0x7f091c69);
        this.l = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c66);
        this.m = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c67);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091c65);
        this.o = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091ec3);
        this.j.setOnClickListener(this);
        this.n.setOnClickListener(this);
        k(h(), this.a);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_BUTTON_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (StringHelper.equals(this.r, c().getString(R.string.open_now))) {
                statisticItem.param("obj_type", 1);
            } else if (StringHelper.equals(this.r, c().getString(R.string.renew_now))) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o.setVisibility(8);
            this.t.i();
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s = z;
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            EMManager.from(this.j).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0311).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0311).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            if (this.o.getVisibility() == 0) {
                EMManager.from(this.o).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0205).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0301);
            }
            SkinManager.setBackgroundResource(this.j, R.drawable.bg_pic_wode_members_bg);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            z45 z45Var = new z45();
            z45Var.u(new int[]{vca.a(SkinManager.getColor(i, (int) R.color.CAM_X0335), x15.b(R.string.A_X06)), SkinManager.getColor(i, (int) R.color.CAM_X0335)});
            z45Var.s(R.color.CAM_X0117);
            this.n.setConfig(z45Var);
            this.n.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.n) {
            A();
            PayPanelUtils.launchPayPanel(this.p, 2001);
            o();
        } else if (view2 == this.j) {
            B();
            UrlManager.getInstance().dealOneLink(this.p, new String[]{this.q});
            o();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: t */
    public void j(PersonVipCardData personVipCardData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, personVipCardData) == null) && personVipCardData != null) {
            this.l.setText(personVipCardData.getTitle());
            this.m.setText(personVipCardData.getSubTitle());
            this.n.setText(personVipCardData.getButtonLable());
            String bubble = personVipCardData.getBubble();
            boolean g = this.t.g(this.u.f(bubble));
            if (!ad.isEmpty(bubble) && !g) {
                this.o.setVisibility(0);
                this.o.setText(StringHelper.subString(bubble, 10));
                this.u.g(bubble);
            } else {
                this.o.setVisibility(8);
            }
            this.q = personVipCardData.getUrl();
            personVipCardData.getButtonUrl();
            this.r = personVipCardData.getButtonLable();
            if (this.s) {
                this.s = false;
                C();
            }
            k(h(), this.a);
        }
    }
}
