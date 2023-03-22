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
/* loaded from: classes6.dex */
public class qe6 extends me6<ok6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public oe6 l;
    public pe6 m;
    public pe6 n;
    public lk6 o;
    public mk6 p;
    public mk6 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    @Override // com.baidu.tieba.me6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d019c : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe6(TbPageContext<?> tbPageContext, String str) {
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
        s(h());
    }

    @Override // com.baidu.tieba.me6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            oe6 oe6Var = this.l;
            if (oe6Var != null) {
                oe6Var.m(tbPageContext, i);
            }
            pe6 pe6Var = this.m;
            if (pe6Var != null) {
                pe6Var.m(tbPageContext, i);
            }
            pe6 pe6Var2 = this.n;
            if (pe6Var2 != null) {
                pe6Var2.m(tbPageContext, i);
            }
        }
    }

    public void u(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        mk6 mk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.h()) {
                lk6 lk6Var = this.o;
                if (lk6Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, lk6Var);
                }
                r(this.o.getThreadData());
            } else if (view2 == this.m.h()) {
                mk6 mk6Var2 = this.p;
                if (mk6Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, mk6Var2);
                }
                r(this.p.getThreadData());
            } else if (view2 != this.n.h() || (mk6Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, mk6Var);
                }
                r(this.q.getThreadData());
            }
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(g().getPageActivity()).createFromThreadCfg(threadData, null, xe6.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            xe6.a(threadData.getTid());
            g().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09057c);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c25);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c24);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0908c2);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f0908c3);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new oe6(this.b, null, null);
            }
            this.l.u(0, 0, 0, 0);
            this.l.x(8);
            this.l.y(8);
            if (this.l.h().getParent() != null) {
                ((ViewGroup) this.l.h().getParent()).removeView(this.l.h());
            }
            this.l.h().setOnClickListener(this);
            this.l.h().setVisibility(8);
            this.k.addView(this.l.h());
            if (this.m == null) {
                this.m = new pe6(this.b);
            }
            this.m.u(8);
            this.m.x(0, dimensionPixelSize, 0, 0);
            if (this.m.h().getParent() != null) {
                ((ViewGroup) this.m.h().getParent()).removeView(this.m.h());
            }
            this.m.h().setOnClickListener(this);
            this.m.h().setVisibility(8);
            this.k.addView(this.m.h());
            if (this.n == null) {
                this.n = new pe6(this.b);
            }
            this.n.u(8);
            this.n.x(0, dimensionPixelSize, 0, 0);
            if (this.n.h().getParent() != null) {
                ((ViewGroup) this.n.h().getParent()).removeView(this.n.h());
            }
            this.n.h().setOnClickListener(this);
            this.n.h().setVisibility(8);
            this.k.addView(this.n.h());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.me6
    /* renamed from: t */
    public void l(ok6 ok6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ok6Var) == null) && ok6Var != null && ok6Var.c() != null) {
            if (!TextUtils.isEmpty(ok6Var.c().b)) {
                this.j.setText(ok6Var.c().b);
            }
            List<ThreadData> list = ok6Var.c().a;
            if (ListUtils.getCount(list) >= 1) {
                lk6 lk6Var = new lk6();
                this.o = lk6Var;
                lk6Var.c(list.get(0));
                this.l.h().setVisibility(0);
                this.l.l(this.o);
            }
            if (ListUtils.getCount(list) >= 2) {
                mk6 mk6Var = new mk6();
                this.p = mk6Var;
                mk6Var.c(list.get(1));
                this.m.h().setVisibility(0);
                this.m.l(this.p);
                this.m.y(8);
            }
            if (ListUtils.getCount(list) >= 3) {
                mk6 mk6Var2 = new mk6();
                this.q = mk6Var2;
                mk6Var2.c(list.get(2));
                this.n.h().setVisibility(0);
                this.n.l(this.q);
                this.n.y(8);
            }
        }
    }
}
