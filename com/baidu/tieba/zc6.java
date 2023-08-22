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
/* loaded from: classes9.dex */
public class zc6 extends om<bd6, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public jd6 b;
    public boolean c;
    public hd6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), bd6.c);
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
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public AlaSubListLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new hd6(this.a, this.c);
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

    public void y(jd6 jd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jd6Var) == null) {
            this.b = jd6Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(bd6 bd6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bd6Var) != null) || bd6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (bd6Var.a != null) {
                jc6 b = jc6.b();
                jc6 b2 = jc6.b();
                int i2 = this.e;
                ka6 ka6Var = bd6Var.a;
                b.a(b2.d(i2, "c12117", ka6Var.a, ka6Var.b, ka6Var.getThreadData()));
            }
            if (bd6Var.b != null) {
                jc6 b3 = jc6.b();
                jc6 b4 = jc6.b();
                int i3 = this.e;
                ka6 ka6Var2 = bd6Var.b;
                b3.a(b4.d(i3, "c12117", ka6Var2.a, ka6Var2.b, ka6Var2.getThreadData()));
            }
        } else if (i == 2) {
            ka6 ka6Var3 = bd6Var.a;
            if (ka6Var3 != null && ka6Var3.getThreadData() != null && bd6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = bd6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, bd6Var.a.b));
            }
            ka6 ka6Var4 = bd6Var.b;
            if (ka6Var4 != null && ka6Var4.getThreadData() != null && bd6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = bd6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param(MainEntrance.GOTO_TYPE, bd6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd6 bd6Var, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bd6Var, alaSubListLiveDoubleViewHolder})) == null) {
            s(bd6Var);
            alaSubListLiveDoubleViewHolder.a.i(bd6Var);
            alaSubListLiveDoubleViewHolder.a.s(this.b);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
