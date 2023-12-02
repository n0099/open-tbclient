package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sa6 extends ci<ua6, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public cb6 b;
    public boolean c;
    public ab6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), ua6.c);
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

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: u */
    public AlaSubListLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            this.d = new ab6(this.a, this.c);
            return new AlaSubListLiveDoubleViewHolder(this.d);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public void z(cb6 cb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cb6Var) == null) {
            this.b = cb6Var;
        }
    }

    public final void t(ua6 ua6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ua6Var) != null) || ua6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (ua6Var.a != null) {
                ca6 b = ca6.b();
                ca6 b2 = ca6.b();
                int i2 = this.e;
                d86 d86Var = ua6Var.a;
                b.a(b2.d(i2, "c12117", d86Var.a, d86Var.b, d86Var.getThreadData()));
            }
            if (ua6Var.b != null) {
                ca6 b3 = ca6.b();
                ca6 b4 = ca6.b();
                int i3 = this.e;
                d86 d86Var2 = ua6Var.b;
                b3.a(b4.d(i3, "c12117", d86Var2.a, d86Var2.b, d86Var2.getThreadData()));
            }
        } else if (i == 2) {
            d86 d86Var3 = ua6Var.a;
            if (d86Var3 != null && d86Var3.getThreadData() != null && ua6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = ua6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, ua6Var.a.b));
            }
            d86 d86Var4 = ua6Var.b;
            if (d86Var4 != null && d86Var4.getThreadData() != null && ua6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = ua6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, ua6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ua6 ua6Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ua6Var, alaSubListLiveDoubleViewHolder})) == null) {
            t(ua6Var);
            alaSubListLiveDoubleViewHolder.a.j(ua6Var);
            alaSubListLiveDoubleViewHolder.a.r(this.b);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
