package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
public class ip6 extends wo6<oq6> {
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
    public oq6 y;
    public String z;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.home_card_hot_topic_item : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ip6 ip6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                dla.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip6(TbPageContext<?> tbPageContext) {
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
        r(h());
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = i;
            this.w.setLayoutParams(layoutParams);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
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
            int e = wg.e((String) view2.getTag(), -1);
            oq6 oq6Var = this.y;
            if (oq6Var != null && ListUtils.getItem(oq6Var.d, e) != null) {
                TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(e).b));
                if (e >= 0 && !zx5.b(g())) {
                    if (this.y.d.get(e).a() != 1 && NewWebHotTopicPageSwitch.isOn()) {
                        my5.f(this.b, String.valueOf(this.y.d.get(e).a), this.y.d.get(e).b);
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
            this.i = view2.findViewById(R.id.home_card_hot_topic_root_view);
            this.j = (TextView) view2.findViewById(R.id.home_card_topic_title);
            this.k = (TextView) view2.findViewById(R.id.home_card_topic_more);
            this.l = (LinearLayout) view2.findViewById(R.id.home_card_topic_group_one);
            this.m = (LinearLayout) view2.findViewById(R.id.home_card_topic_group_two);
            this.n = (LinearLayout) view2.findViewById(R.id.home_card_topic_group_three);
            this.o = (LinearLayout) view2.findViewById(R.id.home_card_topic_group_four);
            this.p = (TextView) view2.findViewById(R.id.home_card_topic_one);
            this.q = (TextView) view2.findViewById(R.id.home_card_topic_two);
            this.r = (TextView) view2.findViewById(R.id.home_card_topic_three);
            this.s = (TextView) view2.findViewById(R.id.home_card_topic_four);
            this.t = view2.findViewById(R.id.home_top_div);
            this.u = view2.findViewById(R.id.home_top_topic_div_one);
            this.v = view2.findViewById(R.id.home_top_topic_div_two);
            this.w = view2.findViewById(R.id.home_card_top_divider_line);
            this.x = view2.findViewById(R.id.home_card_bottom_divider_line);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.k.setOnClickListener(new a(this));
        }
    }

    public final void s(TextView textView, int i) {
        oq6 oq6Var;
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i) != null) || (oq6Var = this.y) == null || ListUtils.getCount(oq6Var.d) < 4 || (nq6Var = (nq6) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = nq6Var.c;
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
    @Override // com.baidu.tieba.wo6
    /* renamed from: t */
    public void i(oq6 oq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oq6Var) == null) {
            int i = 8;
            if (oq6Var != null && !StringUtils.isNull(oq6Var.c) && ListUtils.getCount(oq6Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = oq6Var;
                View view2 = this.w;
                if (oq6Var.a) {
                    i = 0;
                }
                view2.setVisibility(i);
                z(this.y.b);
                this.j.setText(this.y.c.trim());
                y(this.p, 0);
                y(this.q, 1);
                y(this.r, 2);
                y(this.s, 3);
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

    public final void y(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i) == null) {
            nq6 nq6Var = this.y.d.get(i);
            if (!StringUtils.isNull(nq6Var.b)) {
                textView.setText(nq6Var.b.trim());
            }
        }
    }
}
