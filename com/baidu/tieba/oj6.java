package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oj6 extends cj6<vk6> {
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
    public vk6 y;
    public String z;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.home_card_hot_topic_item : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(oj6 oj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj6Var};
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
                TopicListUtil.openWebTopicListPage();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oj6(TbPageContext<?> tbPageContext) {
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
        o(i());
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = i;
            this.w.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
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
                t(this.p, 0);
                t(this.q, 1);
                t(this.r, 2);
                t(this.s, 3);
            }
            this.a = i;
        }
    }

    public final void o(View view2) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            int i = JavaTypesHelper.toInt((String) view2.getTag(), -1);
            vk6 vk6Var = this.y;
            if (vk6Var != null && ListUtils.getItem(vk6Var.d, i) != null) {
                TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(i).b));
                if (i >= 0 && !kr5.b(h())) {
                    if (this.y.d.get(i).a() == 1) {
                        h().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(h().getPageActivity()).createNormalConfig(String.valueOf(this.y.d.get(i).a), this.y.d.get(i).b, "")));
                    } else {
                        wr5.f(this.b, String.valueOf(this.y.d.get(i).a), this.y.d.get(i).b);
                    }
                }
            }
        }
    }

    public final void t(TextView textView, int i) {
        vk6 vk6Var;
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, textView, i) != null) || (vk6Var = this.y) == null || ListUtils.getCount(vk6Var.d) < 4 || (uk6Var = (uk6) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = uk6Var.c;
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
    @Override // com.baidu.tieba.cj6
    /* renamed from: u */
    public void j(vk6 vk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vk6Var) == null) {
            int i = 8;
            if (vk6Var != null && !StringUtils.isNull(vk6Var.c) && ListUtils.getCount(vk6Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = vk6Var;
                View view2 = this.w;
                if (vk6Var.a) {
                    i = 0;
                }
                view2.setVisibility(i);
                A(this.y.b);
                this.j.setText(this.y.c.trim());
                z(this.p, 0);
                z(this.q, 1);
                z(this.r, 2);
                z(this.s, 3);
                t(this.p, 0);
                t(this.q, 1);
                t(this.r, 2);
                t(this.s, 3);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.z = str2;
        }
    }

    public final void z(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, textView, i) == null) {
            uk6 uk6Var = this.y.d.get(i);
            if (!StringUtils.isNull(uk6Var.b)) {
                textView.setText(uk6Var.b.trim());
            }
        }
    }
}
