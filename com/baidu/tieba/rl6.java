package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class rl6 extends nl6<qu6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public pl6 l;
    public ql6 m;
    public ql6 n;
    public nu6 o;
    public ou6 p;
    public ou6 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01bf : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl6(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.u = str;
        r(i());
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            pl6 pl6Var = this.l;
            if (pl6Var != null) {
                pl6Var.k(tbPageContext, i);
            }
            ql6 ql6Var = this.m;
            if (ql6Var != null) {
                ql6Var.k(tbPageContext, i);
            }
            ql6 ql6Var2 = this.n;
            if (ql6Var2 != null) {
                ql6Var2.k(tbPageContext, i);
            }
        }
    }

    public void y(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ou6 ou6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.i()) {
                nu6 nu6Var = this.o;
                if (nu6Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, nu6Var);
                }
                p(this.o.getThreadData());
            } else if (view2 == this.m.i()) {
                ou6 ou6Var2 = this.p;
                if (ou6Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, ou6Var2);
                }
                p(this.p.getThreadData());
            } else if (view2 != this.n.i() || (ou6Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, ou6Var);
                }
                p(this.q.getThreadData());
            }
        }
    }

    public final void p(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(h().getPageActivity()).createFromThreadCfg(threadData, null, xl6.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            xl6.a(threadData.getTid());
            h().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905fc);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cfd);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cfc);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f090959);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f09095a);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new pl6(this.b, null, null);
            }
            this.l.y(0, 0, 0, 0);
            this.l.z(8);
            this.l.A(8);
            if (this.l.i().getParent() != null) {
                ((ViewGroup) this.l.i().getParent()).removeView(this.l.i());
            }
            this.l.i().setOnClickListener(this);
            this.l.i().setVisibility(8);
            this.k.addView(this.l.i());
            if (this.m == null) {
                this.m = new ql6(this.b);
            }
            this.m.y(8);
            this.m.z(0, dimensionPixelSize, 0, 0);
            if (this.m.i().getParent() != null) {
                ((ViewGroup) this.m.i().getParent()).removeView(this.m.i());
            }
            this.m.i().setOnClickListener(this);
            this.m.i().setVisibility(8);
            this.k.addView(this.m.i());
            if (this.n == null) {
                this.n = new ql6(this.b);
            }
            this.n.y(8);
            this.n.z(0, dimensionPixelSize, 0, 0);
            if (this.n.i().getParent() != null) {
                ((ViewGroup) this.n.i().getParent()).removeView(this.n.i());
            }
            this.n.i().setOnClickListener(this);
            this.n.i().setVisibility(8);
            this.k.addView(this.n.i());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: s */
    public void j(qu6 qu6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, qu6Var) == null) && qu6Var != null && qu6Var.c() != null) {
            if (!TextUtils.isEmpty(qu6Var.c().b)) {
                this.j.setText(qu6Var.c().b);
            }
            List<ThreadData> list = qu6Var.c().a;
            if (ListUtils.getCount(list) >= 1) {
                nu6 nu6Var = new nu6();
                this.o = nu6Var;
                nu6Var.c(list.get(0));
                this.l.i().setVisibility(0);
                this.l.j(this.o);
            }
            if (ListUtils.getCount(list) >= 2) {
                ou6 ou6Var = new ou6();
                this.p = ou6Var;
                ou6Var.c(list.get(1));
                this.m.i().setVisibility(0);
                this.m.j(this.p);
                this.m.A(8);
            }
            if (ListUtils.getCount(list) >= 3) {
                ou6 ou6Var2 = new ou6();
                this.q = ou6Var2;
                ou6Var2.c(list.get(2));
                this.n.i().setVisibility(0);
                this.n.j(this.q);
                this.n.A(8);
            }
        }
    }
}
