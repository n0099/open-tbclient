package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.DuxiaomanEntry;
/* loaded from: classes5.dex */
public class m48 extends hz5<y38> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public TBSpecificationBtn m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View u;
    public TbImageView v;
    public DuxiaomanEntry w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public a(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.k.getId()) {
                    if (this.a.w != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(pg.g(this.a.w.activity_timestamp, 0L));
                        this.a.u.setVisibility(8);
                        if ("1".equals(this.a.w.activity_link_type)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.w.activity_link_addr));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 2));
                } else if (view2.getId() == this.a.i.getId()) {
                    if (this.a.w != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.w.goto_button_url));
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m48(TbPageContext<?> tbPageContext) {
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
        this.x = new a(this);
        View h = h();
        this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0921c3);
        TextView textView = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0920d2);
        this.k = textView;
        textView.setOnClickListener(this.x);
        View findViewById = h.findViewById(R.id.obfuscated_res_0x7f0918b8);
        this.i = findViewById;
        findViewById.setOnClickListener(this.x);
        this.l = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090ead);
        this.m = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f09042b);
        this.n = h.findViewById(R.id.obfuscated_res_0x7f0908de);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0908df);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09225d);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0903f4);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09026d);
        this.s = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0903c9);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09026e);
        this.u = h.findViewById(R.id.obfuscated_res_0x7f091b78);
        this.v = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f090edc);
        j(g(), this.a);
    }

    @Override // com.baidu.tieba.hz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06e6 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.hz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            ns4 d = ns4.d(this.i);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            ns4 d2 = ns4.d(this.j);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            ns4 d3 = ns4.d(this.p);
            d3.v(R.color.CAM_X0109);
            d3.A(R.string.F_X01);
            ns4 d4 = ns4.d(this.q);
            d4.v(R.color.CAM_X0109);
            d4.A(R.string.F_X01);
            ns4 d5 = ns4.d(this.k);
            d5.v(R.color.CAM_X0107);
            d5.A(R.string.F_X01);
            ns4 d6 = ns4.d(this.r);
            d6.v(R.color.CAM_X0105);
            d6.A(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.m.k();
            ns4 d7 = ns4.d(this.n);
            d7.n(R.string.J_X04);
            d7.l(R.dimen.L_X01);
            d7.k(R.color.CAM_X0321);
            ns4 d8 = ns4.d(this.o);
            d8.v(R.color.CAM_X0321);
            d8.A(R.string.F_X01);
            ns4 d9 = ns4.d(this.t);
            d9.v(R.color.CAM_X0109);
            d9.A(R.string.F_X01);
            ns4 d10 = ns4.d(this.s);
            d10.v(R.color.CAM_X0105);
            d10.A(R.string.F_X01);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hz5
    /* renamed from: v */
    public void i(y38 y38Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, y38Var) == null) || y38Var == null || y38Var.c() == null) {
            return;
        }
        DuxiaomanEntry c = y38Var.c();
        this.w = c;
        if ("1".equals(c.layout_type)) {
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        }
        this.p.setText(this.w.tip);
        if (pg.g(this.w.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        this.k.setText(this.w.activity_desc);
        this.r.setText(this.w.amount);
        this.t.setText(this.w.amount_msg);
        this.v.K(this.a == 0 ? this.w.encourage_icon : this.w.encourage_icon_dark, 10, false);
        this.o.setText(this.w.encourage_desc);
        this.m.setText(this.w.goto_button_name);
        this.s.setText(this.w.amount_msg);
        j(g(), this.a);
        TiebaStatic.log("c14712");
    }
}
