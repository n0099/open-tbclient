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
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qe6 extends ln<se6, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public af6 b;
    public boolean c;
    public ye6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), se6.c);
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
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public AlaSubListLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new ye6(this.a, this.c);
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

    public void y(af6 af6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, af6Var) == null) {
            this.b = af6Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(se6 se6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, se6Var) != null) || se6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (se6Var.a != null) {
                ae6 b = ae6.b();
                ae6 b2 = ae6.b();
                int i2 = this.e;
                bc6 bc6Var = se6Var.a;
                b.a(b2.d(i2, "c12117", bc6Var.a, bc6Var.b, bc6Var.getThreadData()));
            }
            if (se6Var.b != null) {
                ae6 b3 = ae6.b();
                ae6 b4 = ae6.b();
                int i3 = this.e;
                bc6 bc6Var2 = se6Var.b;
                b3.a(b4.d(i3, "c12117", bc6Var2.a, bc6Var2.b, bc6Var2.getThreadData()));
            }
        } else if (i == 2) {
            bc6 bc6Var3 = se6Var.a;
            if (bc6Var3 != null && bc6Var3.getThreadData() != null && se6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = se6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", se6Var.a.b));
            }
            bc6 bc6Var4 = se6Var.b;
            if (bc6Var4 != null && bc6Var4.getThreadData() != null && se6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = se6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", se6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, se6 se6Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, se6Var, alaSubListLiveDoubleViewHolder})) == null) {
            s(se6Var);
            alaSubListLiveDoubleViewHolder.a.i(se6Var);
            alaSubListLiveDoubleViewHolder.a.s(this.b);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
