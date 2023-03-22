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
public class vw8 extends me6<rv8> {
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
    public rv8 r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    @Override // com.baidu.tieba.me6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c1 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vw8 vw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw8Var, Integer.valueOf(i)};
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
            this.a = vw8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof be9) {
                    be9 be9Var = (be9) data;
                    if (be9Var.a == this.a.r.f) {
                        if (be9Var.b) {
                            this.a.r.i = true;
                            this.a.q.setVisibility(0);
                            this.a.A(true);
                        } else if (StringUtils.isNull(be9Var.c)) {
                            hi.P(this.a.c, R.string.attention_fail);
                        } else {
                            hi.Q(this.a.c, be9Var.c);
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
        public final /* synthetic */ vw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vw8 vw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw8Var, Integer.valueOf(i)};
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
            this.a = vw8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof be9) {
                    be9 be9Var = (be9) data;
                    if (be9Var.a == this.a.r.f) {
                        if (be9Var.b) {
                            this.a.r.i = false;
                            this.a.q.setVisibility(0);
                            vw8 vw8Var = this.a;
                            vw8Var.A(vw8Var.r.i);
                            hi.P(this.a.c, R.string.unlike_success);
                            return;
                        }
                        hi.P(this.a.c, R.string.unlike_failure);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vw8(TbPageContext tbPageContext) {
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
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f081059);
            this.q.setClickable(true);
        }
    }

    public void z(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    @Override // com.baidu.tieba.me6
    public void m(TbPageContext tbPageContext, int i) {
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
                rv8 rv8Var = this.r;
                if (rv8Var != null) {
                    A(rv8Var.i);
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
                } else if (gi.isForumName(this.r.h)) {
                    rv8 rv8Var = this.r;
                    if (!rv8Var.i) {
                        this.s.j0(rv8Var.h, String.valueOf(rv8Var.f));
                    }
                }
            }
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f0905e1);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905dd);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905df);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e5);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905de);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905e3);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e0);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e4);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e2);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.me6
    /* renamed from: y */
    public void l(rv8 rv8Var) {
        int i;
        Context context;
        int i2;
        String string;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rv8Var) == null) {
            if (rv8Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = rv8Var;
            this.t = rv8Var.a;
            TextView textView = this.j;
            int i3 = 4;
            if (rv8Var.c) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.k;
            if (rv8Var.c) {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            this.j.setText(rv8Var.e);
            this.k.setText(rv8Var.d);
            TextView textView3 = this.l;
            if (rv8Var.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0b75);
            } else {
                if (rv8Var.b == 2) {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f125e;
                } else {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f08e6;
                }
                string = context.getString(i2);
            }
            textView3.setText(string);
            this.n.M(rv8Var.g, 10, false);
            String str = rv8Var.h;
            if (dq5.d(str) > 10) {
                str = dq5.l(str, 0, 10) + StringHelper.STRING_MORE;
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f47), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(rv8Var.j);
            String numFormatOverWanNa2 = StringHelper.numFormatOverWanNa(rv8Var.k);
            TextView textView4 = this.p;
            if (rv8Var.a) {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f46), numFormatOverWanNa, numFormatOverWanNa2);
            } else {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0f45), numFormatOverWanNa);
            }
            textView4.setText(format);
            if (!rv8Var.i && !rv8Var.a) {
                this.q.setVisibility(0);
                A(rv8Var.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }
}
