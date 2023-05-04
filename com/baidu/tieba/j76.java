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
/* loaded from: classes5.dex */
public class j76 extends vm<l76, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public u76 b;
    public boolean c;
    public p76 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j76(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), l76.c);
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
    @Override // com.baidu.tieba.vm
    /* renamed from: t */
    public AlaSubListGameDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new p76(this.a, this.c);
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

    public void y(u76 u76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u76Var) == null) {
            this.b = u76Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(l76 l76Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l76Var) != null) || l76Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (l76Var.a != null) {
                u66 b = u66.b();
                u66 b2 = u66.b();
                int i2 = this.e;
                v46 v46Var = l76Var.a;
                b.a(b2.d(i2, "c12117", v46Var.a, v46Var.b, v46Var.getThreadData()));
            }
            if (l76Var.b != null) {
                u66 b3 = u66.b();
                u66 b4 = u66.b();
                int i3 = this.e;
                v46 v46Var2 = l76Var.b;
                b3.a(b4.d(i3, "c12117", v46Var2.a, v46Var2.b, v46Var2.getThreadData()));
            }
        } else if (i == 2) {
            v46 v46Var3 = l76Var.a;
            if (v46Var3 != null && v46Var3.getThreadData() != null && l76Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = l76Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", l76Var.a.b));
            }
            v46 v46Var4 = l76Var.b;
            if (v46Var4 != null && v46Var4.getThreadData() != null && l76Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = l76Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", l76Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l76 l76Var, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l76Var, alaSubListGameDoubleViewHolder})) == null) {
            s(l76Var);
            alaSubListGameDoubleViewHolder.a.i(l76Var);
            alaSubListGameDoubleViewHolder.a.s(this.b);
            return alaSubListGameDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
