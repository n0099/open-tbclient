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
/* loaded from: classes4.dex */
public class m16 extends i16<c76> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public k16 l;
    public l16 m;
    public l16 n;
    public z66 o;
    public a76 p;
    public a76 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m16(TbPageContext<?> tbPageContext, String str) {
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

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018a : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            k16 k16Var = this.l;
            if (k16Var != null) {
                k16Var.j(tbPageContext, i);
            }
            l16 l16Var = this.m;
            if (l16Var != null) {
                l16Var.j(tbPageContext, i);
            }
            l16 l16Var2 = this.n;
            if (l16Var2 != null) {
                l16Var2.j(tbPageContext, i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.h()) {
                z66 z66Var = this.o;
                if (z66Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, z66Var);
                }
                r(this.o.getThreadData());
            } else if (view2 == this.m.h()) {
                a76 a76Var2 = this.p;
                if (a76Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, a76Var2);
                }
                r(this.p.getThreadData());
            } else if (view2 != this.n.h() || (a76Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, a76Var);
                }
                r(this.q.getThreadData());
            }
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(g().getPageActivity()).createFromThreadCfg(threadData, null, t16.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            t16.a(threadData.getTid());
            g().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090509);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b1e);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b1d);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f09080d);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f09080e);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new k16(this.b, null, null);
            }
            this.l.u(0, 0, 0, 0);
            this.l.v(8);
            this.l.w(8);
            if (this.l.h().getParent() != null) {
                ((ViewGroup) this.l.h().getParent()).removeView(this.l.h());
            }
            this.l.h().setOnClickListener(this);
            this.l.h().setVisibility(8);
            this.k.addView(this.l.h());
            if (this.m == null) {
                this.m = new l16(this.b);
            }
            this.m.u(8);
            this.m.v(0, dimensionPixelSize, 0, 0);
            if (this.m.h().getParent() != null) {
                ((ViewGroup) this.m.h().getParent()).removeView(this.m.h());
            }
            this.m.h().setOnClickListener(this);
            this.m.h().setVisibility(8);
            this.k.addView(this.m.h());
            if (this.n == null) {
                this.n = new l16(this.b);
            }
            this.n.u(8);
            this.n.v(0, dimensionPixelSize, 0, 0);
            if (this.n.h().getParent() != null) {
                ((ViewGroup) this.n.h().getParent()).removeView(this.n.h());
            }
            this.n.h().setOnClickListener(this);
            this.n.h().setVisibility(8);
            this.k.addView(this.n.h());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: t */
    public void i(c76 c76Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, c76Var) == null) || c76Var == null || c76Var.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(c76Var.c().b)) {
            this.j.setText(c76Var.c().b);
        }
        List<ThreadData> list = c76Var.c().a;
        if (ListUtils.getCount(list) >= 1) {
            z66 z66Var = new z66();
            this.o = z66Var;
            z66Var.c(list.get(0));
            this.l.h().setVisibility(0);
            this.l.i(this.o);
        }
        if (ListUtils.getCount(list) >= 2) {
            a76 a76Var = new a76();
            this.p = a76Var;
            a76Var.c(list.get(1));
            this.m.h().setVisibility(0);
            this.m.i(this.p);
            this.m.w(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            a76 a76Var2 = new a76();
            this.q = a76Var2;
            a76Var2.c(list.get(2));
            this.n.h().setVisibility(0);
            this.n.i(this.q);
            this.n.w(8);
        }
    }

    public void u(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }
}
