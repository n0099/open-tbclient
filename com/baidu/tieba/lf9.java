package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
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
import tbclient.NamoaixudEntry;
/* loaded from: classes6.dex */
public class lf9 extends nn6<ve9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TBSpecificationBtn n;
    public View o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public TbImageView w;
    public NamoaixudEntry x;
    public View.OnClickListener y;

    @Override // com.baidu.tieba.nn6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0793 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf9 a;

        public a(lf9 lf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.l.getId()) {
                    if (this.a.x != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(ug.g(this.a.x.activity_timestamp, 0L));
                        this.a.v.setVisibility(8);
                        if ("1".equals(this.a.x.activity_link_type)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.activity_link_addr));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 2));
                } else if (view2.getId() == this.a.j.getId()) {
                    if (this.a.x != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.goto_button_url));
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf9(TbPageContext<?> tbPageContext) {
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
        this.y = new a(this);
        this.i = h();
        int g = wi.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0924ae);
        TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.l = textView;
        textView.setOnClickListener(this.y);
        View findViewById = this.i.findViewById(R.id.obfuscated_res_0x7f091b06);
        this.j = findViewById;
        findViewById.setOnClickListener(this.y);
        this.m = (ImageView) this.i.findViewById(R.id.img_arrow);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f0904b5);
        this.o = this.i.findViewById(R.id.obfuscated_res_0x7f0909ec);
        this.p = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909ed);
        this.q = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09255a);
        this.r = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090471);
        this.s = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090283);
        this.t = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09042e);
        this.u = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090284);
        this.v = this.i.findViewById(R.id.obfuscated_res_0x7f091dee);
        this.w = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0910bc);
        j(g(), this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nn6
    /* renamed from: x */
    public void i(ve9 ve9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ve9Var) == null) && ve9Var != null && ve9Var.c() != null) {
            NamoaixudEntry c = ve9Var.c();
            this.x = c;
            if ("1".equals(c.layout_type)) {
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setVisibility(8);
                this.u.setVisibility(0);
            } else {
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.u.setVisibility(8);
            }
            this.q.setText(this.x.tip);
            if (ug.g(this.x.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
            this.l.setText(this.x.activity_desc);
            this.s.setText(this.x.amount);
            this.u.setText(this.x.amount_msg);
            if (this.a == 0) {
                str = this.x.encourage_icon;
            } else {
                str = this.x.encourage_icon_dark;
            }
            this.w.N(str, 10, false);
            this.p.setText(this.x.encourage_desc);
            this.n.setText(this.x.goto_button_name);
            this.t.setText(this.x.amount_msg);
            j(g(), this.a);
            TiebaStatic.log("c14712");
        }
    }

    @Override // com.baidu.tieba.nn6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            p75 d = p75.d(this.j);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            p75 d2 = p75.d(this.k);
            d2.x(R.color.CAM_X0105);
            d2.D(R.string.F_X02);
            p75 d3 = p75.d(this.q);
            d3.x(R.color.CAM_X0109);
            d3.D(R.string.F_X01);
            p75 d4 = p75.d(this.r);
            d4.x(R.color.CAM_X0109);
            d4.D(R.string.F_X01);
            p75 d5 = p75.d(this.l);
            d5.x(R.color.CAM_X0107);
            d5.D(R.string.F_X01);
            p75 d6 = p75.d(this.s);
            d6.x(R.color.CAM_X0105);
            d6.D(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.n.k();
            p75 d7 = p75.d(this.o);
            d7.o(R.string.J_X04);
            d7.m(R.dimen.L_X01);
            d7.l(R.color.CAM_X0321);
            p75 d8 = p75.d(this.p);
            d8.x(R.color.CAM_X0321);
            d8.D(R.string.F_X01);
            p75 d9 = p75.d(this.u);
            d9.x(R.color.CAM_X0109);
            d9.D(R.string.F_X01);
            p75 d10 = p75.d(this.t);
            d10.x(R.color.CAM_X0105);
            d10.D(R.string.F_X01);
        }
    }
}
