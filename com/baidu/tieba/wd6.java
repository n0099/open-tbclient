package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wd6 extends pm<yd6, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public he6 b;
    public boolean c;
    public ce6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), yd6.c);
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
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public AlaSubListGameDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new ce6(this.a, this.c);
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

    public void y(he6 he6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, he6Var) == null) {
            this.b = he6Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(yd6 yd6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yd6Var) != null) || yd6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (yd6Var.a != null) {
                hd6 b = hd6.b();
                hd6 b2 = hd6.b();
                int i2 = this.e;
                ib6 ib6Var = yd6Var.a;
                b.a(b2.d(i2, "c12117", ib6Var.a, ib6Var.b, ib6Var.getThreadData()));
            }
            if (yd6Var.b != null) {
                hd6 b3 = hd6.b();
                hd6 b4 = hd6.b();
                int i3 = this.e;
                ib6 ib6Var2 = yd6Var.b;
                b3.a(b4.d(i3, "c12117", ib6Var2.a, ib6Var2.b, ib6Var2.getThreadData()));
            }
        } else if (i == 2) {
            ib6 ib6Var3 = yd6Var.a;
            if (ib6Var3 != null && ib6Var3.getThreadData() != null && yd6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = yd6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, yd6Var.a.b));
            }
            ib6 ib6Var4 = yd6Var.b;
            if (ib6Var4 != null && ib6Var4.getThreadData() != null && yd6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = yd6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, yd6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yd6 yd6Var, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yd6Var, alaSubListGameDoubleViewHolder})) == null) {
            s(yd6Var);
            alaSubListGameDoubleViewHolder.a.i(yd6Var);
            alaSubListGameDoubleViewHolder.a.s(this.b);
            return alaSubListGameDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
