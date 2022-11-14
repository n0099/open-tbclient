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
/* loaded from: classes6.dex */
public class wb8 extends l36<sa8> {
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
    public sa8 r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    @Override // com.baidu.tieba.l36
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b2 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wb8 wb8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb8Var, Integer.valueOf(i)};
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
            this.a = wb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof kr8) {
                    kr8 kr8Var = (kr8) data;
                    if (kr8Var.a == this.a.r.f) {
                        if (kr8Var.b) {
                            this.a.r.i = true;
                            this.a.q.setVisibility(0);
                            this.a.y(true);
                        } else if (StringUtils.isNull(kr8Var.c)) {
                            yi.O(this.a.c, R.string.obfuscated_res_0x7f0f02ba);
                        } else {
                            yi.P(this.a.c, kr8Var.c);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wb8 wb8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb8Var, Integer.valueOf(i)};
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
            this.a = wb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof kr8) {
                    kr8 kr8Var = (kr8) data;
                    if (kr8Var.a == this.a.r.f) {
                        if (kr8Var.b) {
                            this.a.r.i = false;
                            this.a.q.setVisibility(0);
                            wb8 wb8Var = this.a;
                            wb8Var.y(wb8Var.r.i);
                            yi.O(this.a.c, R.string.obfuscated_res_0x7f0f151e);
                            return;
                        }
                        yi.O(this.a.c, R.string.obfuscated_res_0x7f0f151d);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wb8(TbPageContext tbPageContext) {
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
        v(k());
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1010));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.c.getString(R.string.obfuscated_res_0x7f0f065c));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f080ff8);
            this.q.setClickable(true);
        }
    }

    public void x(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    @Override // com.baidu.tieba.l36
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0108, 1);
                sa8 sa8Var = this.r;
                if (sa8Var != null) {
                    y(sa8Var.i);
                }
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (this.i == view2) {
                if (!this.t) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c).createNormalCfg(this.r.h, "")));
            } else if (this.q == view2) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.c);
                } else if (xi.isForumName(this.r.h)) {
                    sa8 sa8Var = this.r;
                    if (!sa8Var.i) {
                        this.s.Q(sa8Var.h, String.valueOf(sa8Var.f));
                    }
                }
            }
        }
    }

    public final void v(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f09058b);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090587);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090589);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09058f);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090588);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09058d);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09058a);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09058e);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09058c);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l36
    /* renamed from: w */
    public void l(sa8 sa8Var) {
        int i;
        Context context;
        int i2;
        String string;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sa8Var) == null) {
            if (sa8Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = sa8Var;
            this.t = sa8Var.a;
            TextView textView = this.j;
            int i3 = 4;
            if (sa8Var.c) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.k;
            if (sa8Var.c) {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            this.j.setText(sa8Var.e);
            this.k.setText(sa8Var.d);
            TextView textView3 = this.l;
            if (sa8Var.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0adf);
            } else {
                if (sa8Var.b == 2) {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f11cb;
                } else {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f0865;
                }
                string = context.getString(i2);
            }
            textView3.setText(string);
            this.n.K(sa8Var.g, 10, false);
            String str = sa8Var.h;
            if (tj5.b(str) > 10) {
                str = tj5.j(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0eac), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(sa8Var.j);
            String numFormatOverWanNa2 = StringHelper.numFormatOverWanNa(sa8Var.k);
            TextView textView4 = this.p;
            if (sa8Var.a) {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0eab), numFormatOverWanNa, numFormatOverWanNa2);
            } else {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0eaa), numFormatOverWanNa);
            }
            textView4.setText(format);
            if (!sa8Var.i && !sa8Var.a) {
                this.q.setVisibility(0);
                y(sa8Var.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }
}
