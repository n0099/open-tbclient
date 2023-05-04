package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m99 extends kh6<i89> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public i89 r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    @Override // com.baidu.tieba.kh6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c4 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m99 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m99 m99Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m99Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m99Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof pr9) {
                    pr9 pr9Var = (pr9) data;
                    if (pr9Var.a == this.a.r.f) {
                        if (pr9Var.b) {
                            this.a.r.i = true;
                            this.a.q.setVisibility(0);
                            this.a.A(true);
                        } else if (StringUtils.isNull(pr9Var.c)) {
                            ii.P(this.a.c, R.string.attention_fail);
                        } else {
                            ii.Q(this.a.c, pr9Var.c);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m99 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m99 m99Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m99Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m99Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof pr9) {
                    pr9 pr9Var = (pr9) data;
                    if (pr9Var.a == this.a.r.f) {
                        if (pr9Var.b) {
                            this.a.r.i = false;
                            this.a.q.setVisibility(0);
                            m99 m99Var = this.a;
                            m99Var.A(m99Var.r.i);
                            ii.P(this.a.c, R.string.unlike_success);
                            return;
                        }
                        ii.P(this.a.c, R.string.unlike_failure);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m99(TbPageContext tbPageContext) {
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
        this.u = new a(this, 2001437);
        this.v = new b(this, 2001438);
        x(h());
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.q.setText(this.c.getString(R.string.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.c.getString(R.string.focus_text));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f081074);
            this.q.setClickable(true);
        }
    }

    public void z(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    @Override // com.baidu.tieba.kh6
    public void j(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0108, 1);
                i89 i89Var = this.r;
                if (i89Var != null) {
                    A(i89Var.i);
                }
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (this.i == view2) {
                if (!this.t) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c).createNormalCfg(this.r.h, "")));
            } else if (this.q == view2) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.c);
                } else if (hi.isForumName(this.r.h)) {
                    i89 i89Var = this.r;
                    if (!i89Var.i) {
                        this.s.n0(i89Var.h, String.valueOf(i89Var.f));
                    }
                }
            }
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f0905e8);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e4);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e6);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905ec);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e5);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905ea);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e7);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905eb);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e9);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6
    /* renamed from: y */
    public void i(i89 i89Var) {
        int i;
        Context context;
        int i2;
        String string;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i89Var) == null) {
            if (i89Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = i89Var;
            this.t = i89Var.a;
            TextView textView = this.j;
            int i3 = 4;
            if (i89Var.c) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.k;
            if (i89Var.c) {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            this.j.setText(i89Var.e);
            this.k.setText(i89Var.d);
            TextView textView3 = this.l;
            if (i89Var.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0b86);
            } else {
                if (i89Var.b == 2) {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f126d;
                } else {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f08f4;
                }
                string = context.getString(i2);
            }
            textView3.setText(string);
            this.n.N(i89Var.g, 10, false);
            String str = i89Var.h;
            if (cs5.c(str) > 10) {
                str = cs5.k(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f58), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(i89Var.j);
            String numFormatOverWanNa2 = StringHelper.numFormatOverWanNa(i89Var.k);
            TextView textView4 = this.p;
            if (i89Var.a) {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f57), numFormatOverWanNa, numFormatOverWanNa2);
            } else {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f56), numFormatOverWanNa);
            }
            textView4.setText(format);
            if (!i89Var.i && !i89Var.a) {
                this.q.setVisibility(0);
                A(i89Var.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }
}
