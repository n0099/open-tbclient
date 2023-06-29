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
public class wn6 extends sn6<uv6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public un6 l;
    public vn6 m;
    public vn6 n;
    public rv6 o;
    public sv6 p;
    public sv6 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    @Override // com.baidu.tieba.sn6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ac : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn6(TbPageContext<?> tbPageContext, String str) {
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

    @Override // com.baidu.tieba.sn6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            un6 un6Var = this.l;
            if (un6Var != null) {
                un6Var.j(tbPageContext, i);
            }
            vn6 vn6Var = this.m;
            if (vn6Var != null) {
                vn6Var.j(tbPageContext, i);
            }
            vn6 vn6Var2 = this.n;
            if (vn6Var2 != null) {
                vn6Var2.j(tbPageContext, i);
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
        sv6 sv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.h()) {
                rv6 rv6Var = this.o;
                if (rv6Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, rv6Var);
                }
                r(this.o.getThreadData());
            } else if (view2 == this.m.h()) {
                sv6 sv6Var2 = this.p;
                if (sv6Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, sv6Var2);
                }
                r(this.p.getThreadData());
            } else if (view2 != this.n.h() || (sv6Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, sv6Var);
                }
                r(this.q.getThreadData());
            }
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(g().getPageActivity()).createFromThreadCfg(threadData, null, co6.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            co6.a(threadData.getTid());
            g().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905a1);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c72);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c71);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0908f9);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f0908fa);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new un6(this.b, null, null);
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
                this.m = new vn6(this.b);
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
                this.n = new vn6(this.b);
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
    @Override // com.baidu.tieba.sn6
    /* renamed from: t */
    public void i(uv6 uv6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, uv6Var) == null) && uv6Var != null && uv6Var.c() != null) {
            if (!TextUtils.isEmpty(uv6Var.c().b)) {
                this.j.setText(uv6Var.c().b);
            }
            List<ThreadData> list = uv6Var.c().a;
            if (ListUtils.getCount(list) >= 1) {
                rv6 rv6Var = new rv6();
                this.o = rv6Var;
                rv6Var.c(list.get(0));
                this.l.h().setVisibility(0);
                this.l.i(this.o);
            }
            if (ListUtils.getCount(list) >= 2) {
                sv6 sv6Var = new sv6();
                this.p = sv6Var;
                sv6Var.c(list.get(1));
                this.m.h().setVisibility(0);
                this.m.i(this.p);
                this.m.y(8);
            }
            if (ListUtils.getCount(list) >= 3) {
                sv6 sv6Var2 = new sv6();
                this.q = sv6Var2;
                sv6Var2.c(list.get(2));
                this.n.h().setVisibility(0);
                this.n.i(this.q);
                this.n.y(8);
            }
        }
    }
}
