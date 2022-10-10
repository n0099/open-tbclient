package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class p68 extends i16<PersonVipCardData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public EMTextView k;
    public EMTextView l;
    public TBSpecificationBtn m;
    public TextView n;
    public TbPageContext o;
    public String p;
    public String q;
    public String r;
    public boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p68(TbPageContext<?> tbPageContext) {
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
        this.o = tbPageContext;
        View h = h();
        this.i = h;
        this.j = h.findViewById(R.id.obfuscated_res_0x7f091995);
        this.k = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091993);
        this.l = (EMTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091994);
        this.m = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091992);
        this.n = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091bbf);
        this.j.setOnClickListener(this);
        this.m.setOnClickListener(this);
        j(g(), this.a);
    }

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0707 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            hv4 d = hv4.d(this.j);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0205);
            hv4 d2 = hv4.d(this.k);
            d2.v(R.color.CAM_X0311);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            hv4 d3 = hv4.d(this.l);
            d3.v(R.color.CAM_X0311);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X08);
            if (this.n.getVisibility() == 0) {
                hv4 d4 = hv4.d(this.n);
                d4.z(R.dimen.T_X10);
                d4.v(R.color.CAM_X0101);
                d4.A(R.string.F_X01);
                d4.l(R.dimen.L_X02);
                d4.k(R.color.CAM_X0205);
                d4.n(R.string.J_X05);
                d4.f(R.color.CAM_X0301);
            }
            SkinManager.setBackgroundResource(this.j, R.drawable.bg_pic_wode_members_bg);
            my4 my4Var = new my4();
            my4Var.s(new int[]{ol8.a(SkinManager.getColor(i, (int) R.color.CAM_X0335), fv4.a(R.string.A_X06)), SkinManager.getColor(i, (int) R.color.CAM_X0335)});
            my4Var.q(R.color.CAM_X0117);
            this.m.setConfig(my4Var);
            this.m.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.m) {
            w();
            UrlManager.getInstance().dealOneLink(this.o, new String[]{this.q});
        } else if (view2 == this.j) {
            x();
            UrlManager.getInstance().dealOneLink(this.o, new String[]{this.p});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: r */
    public void i(PersonVipCardData personVipCardData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, personVipCardData) == null) || personVipCardData == null) {
            return;
        }
        this.k.setText(personVipCardData.getTitle());
        this.l.setText(personVipCardData.getSubTitle());
        this.m.setText(personVipCardData.getButtonLable());
        if (dj.isEmpty(personVipCardData.getBubble())) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(personVipCardData.getBubble());
        }
        this.p = personVipCardData.getUrl();
        this.q = personVipCardData.getButtonUrl();
        this.r = personVipCardData.getButtonLable();
        if (this.s) {
            this.s = false;
            y();
        }
        j(g(), this.a);
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

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VIP_CARD_BUTTON_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (StringHelper.equals(this.r, getContext().getString(R.string.obfuscated_res_0x7f0f0d13))) {
                statisticItem.param("obj_type", 1);
            } else if (StringHelper.equals(this.r, getContext().getString(R.string.obfuscated_res_0x7f0f0ff6))) {
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
