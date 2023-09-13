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
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xd6 extends pm<zd6, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public he6 b;
    public boolean c;
    public fe6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), zd6.c);
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
    public AlaSubListLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new fe6(this.a, this.c);
            return new AlaSubListLiveDoubleViewHolder(this.d);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
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

    public final void s(zd6 zd6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zd6Var) != null) || zd6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (zd6Var.a != null) {
                hd6 b = hd6.b();
                hd6 b2 = hd6.b();
                int i2 = this.e;
                ib6 ib6Var = zd6Var.a;
                b.a(b2.d(i2, "c12117", ib6Var.a, ib6Var.b, ib6Var.getThreadData()));
            }
            if (zd6Var.b != null) {
                hd6 b3 = hd6.b();
                hd6 b4 = hd6.b();
                int i3 = this.e;
                ib6 ib6Var2 = zd6Var.b;
                b3.a(b4.d(i3, "c12117", ib6Var2.a, ib6Var2.b, ib6Var2.getThreadData()));
            }
        } else if (i == 2) {
            ib6 ib6Var3 = zd6Var.a;
            if (ib6Var3 != null && ib6Var3.getThreadData() != null && zd6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = zd6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, zd6Var.a.b));
            }
            ib6 ib6Var4 = zd6Var.b;
            if (ib6Var4 != null && ib6Var4.getThreadData() != null && zd6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = zd6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, zd6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zd6 zd6Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zd6Var, alaSubListLiveDoubleViewHolder})) == null) {
            s(zd6Var);
            alaSubListLiveDoubleViewHolder.a.i(zd6Var);
            alaSubListLiveDoubleViewHolder.a.s(this.b);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
