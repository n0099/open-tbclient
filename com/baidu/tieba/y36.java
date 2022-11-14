package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y36 extends l36<e56> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public e56 y;
    public String z;

    @Override // com.baidu.tieba.l36
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0395 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y36 a;

        public a(y36 y36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !ri5.b(this.a.g())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(this.a.g().getPageActivity()).createNormalConfig("homepage", "all")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y36(TbPageContext<?> tbPageContext) {
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
        r(k());
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = i;
            this.w.setLayoutParams(layoutParams);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.l36
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.u, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.v, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.l, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.m, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.n, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.o, R.drawable.card_topic_click_selector);
                s(this.p, 0);
                s(this.q, 1);
                s(this.r, 2);
                s(this.s, 3);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            int e = xg.e((String) view2.getTag(), -1);
            e56 e56Var = this.y;
            if (e56Var != null && ListUtils.getItem(e56Var.d, e) != null) {
                TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(e).b));
                if (e >= 0 && !ri5.b(g())) {
                    if (this.y.d.get(e).a() != 1 && NewWebHotTopicPageSwitch.isOn()) {
                        ej5.e(this.b, String.valueOf(this.y.d.get(e).a), this.y.d.get(e).b);
                    } else {
                        g().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(g().getPageActivity()).createNormalConfig(String.valueOf(this.y.d.get(e).a), this.y.d.get(e).b, "")));
                    }
                }
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090dbb);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc5);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc2);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dbf);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dc1);
            this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dc0);
            this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dbe);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc3);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc6);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc4);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dbd);
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f090ddc);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f090ddd);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f090dde);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f090dbc);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f090dba);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.k.setOnClickListener(new a(this));
        }
    }

    public final void s(TextView textView, int i) {
        e56 e56Var;
        d56 d56Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i) != null) || (e56Var = this.y) == null || ListUtils.getCount(e56Var.d) < 4 || (d56Var = (d56) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = d56Var.c;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                }
                return;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l36
    /* renamed from: t */
    public void l(e56 e56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, e56Var) == null) {
            int i = 8;
            if (e56Var != null && !StringUtils.isNull(e56Var.c) && ListUtils.getCount(e56Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = e56Var;
                View view2 = this.w;
                if (e56Var.a) {
                    i = 0;
                }
                view2.setVisibility(i);
                x(this.y.b);
                this.j.setText(this.y.c.trim());
                w(this.p, 0);
                w(this.q, 1);
                w(this.r, 2);
                w(this.s, 3);
                s(this.p, 0);
                s(this.q, 1);
                s(this.r, 2);
                s(this.s, 3);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.z = str2;
        }
    }

    public final void w(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i) == null) {
            d56 d56Var = this.y.d.get(i);
            if (!StringUtils.isNull(d56Var.b)) {
                textView.setText(d56Var.b.trim());
            }
        }
    }
}
