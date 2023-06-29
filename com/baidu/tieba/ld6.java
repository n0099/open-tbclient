package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ld6 extends kn<nd6, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public wd6 b;
    public boolean c;
    public rd6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ld6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), nd6.c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public AlaSubListGameDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new rd6(this.a, this.c);
            return new AlaSubListGameDoubleViewHolder(this.d);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void y(wd6 wd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wd6Var) == null) {
            this.b = wd6Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(nd6 nd6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nd6Var) != null) || nd6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (nd6Var.a != null) {
                wc6 b = wc6.b();
                wc6 b2 = wc6.b();
                int i2 = this.e;
                xa6 xa6Var = nd6Var.a;
                b.a(b2.d(i2, "c12117", xa6Var.a, xa6Var.b, xa6Var.getThreadData()));
            }
            if (nd6Var.b != null) {
                wc6 b3 = wc6.b();
                wc6 b4 = wc6.b();
                int i3 = this.e;
                xa6 xa6Var2 = nd6Var.b;
                b3.a(b4.d(i3, "c12117", xa6Var2.a, xa6Var2.b, xa6Var2.getThreadData()));
            }
        } else if (i == 2) {
            xa6 xa6Var3 = nd6Var.a;
            if (xa6Var3 != null && xa6Var3.getThreadData() != null && nd6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = nd6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", nd6Var.a.b));
            }
            xa6 xa6Var4 = nd6Var.b;
            if (xa6Var4 != null && xa6Var4.getThreadData() != null && nd6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = nd6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", nd6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nd6 nd6Var, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nd6Var, alaSubListGameDoubleViewHolder})) == null) {
            s(nd6Var);
            alaSubListGameDoubleViewHolder.a.i(nd6Var);
            alaSubListGameDoubleViewHolder.a.s(this.b);
            return alaSubListGameDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
