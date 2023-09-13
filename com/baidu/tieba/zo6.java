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
/* loaded from: classes9.dex */
public class zo6 extends no6<gq6> {
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
    public gq6 y;
    public String z;

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.home_card_hot_topic_item : invokeV.intValue;
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(zo6 zo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo6Var};
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
    public zo6(TbPageContext<?> tbPageContext) {
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

    @Override // com.baidu.tieba.no6
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
            int i = JavaTypesHelper.toInt((String) view2.getTag(), -1);
            gq6 gq6Var = this.y;
            if (gq6Var != null && ListUtils.getItem(gq6Var.d, i) != null) {
                TiebaStatic.log(new StatisticItem(this.z).param("obj_locate", String.valueOf(this.y.f)).param("obj_name", this.y.d.get(i).b));
                if (i >= 0 && !bx5.b(g())) {
                    if (this.y.d.get(i).a() == 1) {
                        g().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(g().getPageActivity()).createNormalConfig(String.valueOf(this.y.d.get(i).a), this.y.d.get(i).b, "")));
                    } else {
                        nx5.f(this.b, String.valueOf(this.y.d.get(i).a), this.y.d.get(i).b);
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
        gq6 gq6Var;
        fq6 fq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i) != null) || (gq6Var = this.y) == null || ListUtils.getCount(gq6Var.d) < 4 || (fq6Var = (fq6) ListUtils.getItem(this.y.d, i)) == null) {
            return;
        }
        int i2 = fq6Var.c;
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
    @Override // com.baidu.tieba.no6
    /* renamed from: t */
    public void i(gq6 gq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gq6Var) == null) {
            int i = 8;
            if (gq6Var != null && !StringUtils.isNull(gq6Var.c) && ListUtils.getCount(gq6Var.d) >= 4) {
                if (this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
                this.y = gq6Var;
                View view2 = this.w;
                if (gq6Var.a) {
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
            fq6 fq6Var = this.y.d.get(i);
            if (!StringUtils.isNull(fq6Var.b)) {
                textView.setText(fq6Var.b.trim());
            }
        }
    }
}
