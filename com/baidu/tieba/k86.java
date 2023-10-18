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
/* loaded from: classes6.dex */
public class k86 extends lh<m86, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public u86 b;
    public boolean c;
    public s86 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k86(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), m86.c);
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
    @Override // com.baidu.tieba.lh
    /* renamed from: t */
    public AlaSubListLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new s86(this.a, this.c);
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

    public void y(u86 u86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u86Var) == null) {
            this.b = u86Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(m86 m86Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m86Var) != null) || m86Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (m86Var.a != null) {
                u76 b = u76.b();
                u76 b2 = u76.b();
                int i2 = this.e;
                v56 v56Var = m86Var.a;
                b.a(b2.d(i2, "c12117", v56Var.a, v56Var.b, v56Var.getThreadData()));
            }
            if (m86Var.b != null) {
                u76 b3 = u76.b();
                u76 b4 = u76.b();
                int i3 = this.e;
                v56 v56Var2 = m86Var.b;
                b3.a(b4.d(i3, "c12117", v56Var2.a, v56Var2.b, v56Var2.getThreadData()));
            }
        } else if (i == 2) {
            v56 v56Var3 = m86Var.a;
            if (v56Var3 != null && v56Var3.getThreadData() != null && m86Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = m86Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, m86Var.a.b));
            }
            v56 v56Var4 = m86Var.b;
            if (v56Var4 != null && v56Var4.getThreadData() != null && m86Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = m86Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, m86Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m86 m86Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m86Var, alaSubListLiveDoubleViewHolder})) == null) {
            s(m86Var);
            alaSubListLiveDoubleViewHolder.a.j(m86Var);
            alaSubListLiveDoubleViewHolder.a.t(this.b);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
