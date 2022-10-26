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
public class q68 extends p16 {
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

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06fd : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q68 a;

        public a(q68 q68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.k.getId()) {
                    if (this.a.w != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(eh.g(this.a.w.activity_timestamp, 0L));
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
    public q68(TbPageContext tbPageContext) {
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
        View k = k();
        int f = fj.f(this.c, R.dimen.M_W_X003);
        k.setPadding(f, 0, f, 0);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092203);
        TextView textView = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092125);
        this.k = textView;
        textView.setOnClickListener(this.x);
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f0918e5);
        this.i = findViewById;
        findViewById.setOnClickListener(this.x);
        this.l = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090ebc);
        this.m = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f090442);
        this.n = k.findViewById(R.id.obfuscated_res_0x7f0908fd);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0908fe);
        this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09229e);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090409);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090275);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0903dd);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090276);
        this.u = k.findViewById(R.id.obfuscated_res_0x7f091bb9);
        this.v = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090eeb);
        m(g(), this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: v */
    public void l(b68 b68Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, b68Var) == null) && b68Var != null && b68Var.c() != null) {
            DuxiaomanEntry c = b68Var.c();
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
            if (eh.g(this.w.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            this.k.setText(this.w.activity_desc);
            this.r.setText(this.w.amount);
            this.t.setText(this.w.amount_msg);
            if (this.a == 0) {
                str = this.w.encourage_icon;
            } else {
                str = this.w.encourage_icon_dark;
            }
            this.v.L(str, 10, false);
            this.o.setText(this.w.encourage_desc);
            this.m.setText(this.w.goto_button_name);
            this.s.setText(this.w.amount_msg);
            m(g(), this.a);
            TiebaStatic.log("c14712");
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            nv4 d = nv4.d(this.i);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            nv4 d2 = nv4.d(this.j);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            nv4 d3 = nv4.d(this.p);
            d3.v(R.color.CAM_X0109);
            d3.A(R.string.F_X01);
            nv4 d4 = nv4.d(this.q);
            d4.v(R.color.CAM_X0109);
            d4.A(R.string.F_X01);
            nv4 d5 = nv4.d(this.k);
            d5.v(R.color.CAM_X0107);
            d5.A(R.string.F_X01);
            nv4 d6 = nv4.d(this.r);
            d6.v(R.color.CAM_X0105);
            d6.A(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.m.k();
            nv4 d7 = nv4.d(this.n);
            d7.n(R.string.J_X04);
            d7.l(R.dimen.L_X01);
            d7.k(R.color.CAM_X0321);
            nv4 d8 = nv4.d(this.o);
            d8.v(R.color.CAM_X0321);
            d8.A(R.string.F_X01);
            nv4 d9 = nv4.d(this.t);
            d9.v(R.color.CAM_X0109);
            d9.A(R.string.F_X01);
            nv4 d10 = nv4.d(this.s);
            d10.v(R.color.CAM_X0105);
            d10.A(R.string.F_X01);
        }
    }
}
