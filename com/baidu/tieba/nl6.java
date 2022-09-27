package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nl6 extends dh6<bu4, ThreadCardViewHolder<ThreadData>> implements g26, ds6, to5, h26, no {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public int n;
    public i26<ThreadData> o;

    /* loaded from: classes5.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl6 b;

        public a(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.l)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            as6.e(threadData, 1, this.b.mPageId, ds6.p0, this.b.t());
            if (this.b.b != null && this.b.b.getForum() != null) {
                as6.c(threadData, this.b.b.getForum().getId());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092180 && threadData.isVideoThreadType()) {
                this.b.P(threadData);
            }
            if (view2 instanceof VoteView) {
                t16.a(threadData.getTid());
            } else {
                cs6.k().h(ds6.p0, threadData, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.o = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: N */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity(), false);
            cz czVar = new cz(this.c.getPageActivity());
            czVar.y(this.c);
            czVar.x(3);
            bVar.h(czVar);
            sy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.n(false);
            setOnAdapterItemClickListener(this);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    /* renamed from: O */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, bu4Var, threadCardViewHolder);
            if (bu4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.e(bu4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.o);
            bu4Var.t.updateShowStatus();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void P(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", u() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.no
    public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            ThreadData threadData = ((bu4) cdo).t;
            threadData.objType = 1;
            i26<ThreadData> i26Var = this.o;
            if (i26Var != null) {
                i26Var.a(threadCardViewHolder.getView(), threadData);
            }
            ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), this.n, false);
            threadCardViewHolder.a().o(new dz.a(1));
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.ds6
    public bs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ds6.p0 : (bs6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.dh6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.l = str;
        }
    }
}
