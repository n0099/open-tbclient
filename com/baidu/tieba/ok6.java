package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ok6 extends qg6<ot4, FrsCardVideoViewHolder<ml6>> implements t16, pr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public nr6 n;
    public v16<ThreadData> o;

    /* loaded from: classes5.dex */
    public class a extends v16<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ok6 b;

        public a(ok6 ok6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ok6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ok6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090ad4) {
                this.b.U(threadData, "c11718");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0912a7) {
                this.b.U(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090ead || view2.getId() == R.id.obfuscated_res_0x7f0918bf) {
                this.b.U(threadData, "c10241");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090502) {
                ys6.a(this.b.n, threadData.getRecomReason());
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f09054e && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090ad4) {
                    mr6.e(threadData, 4, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    mr6.c(threadData, this.b.b.getForum().getId());
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092192) {
                    mr6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    mr6.c(threadData, this.b.b.getForum().getId());
                    return;
                } else {
                    mr6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                    if (this.b.b == null || this.b.b.getForum() == null) {
                        return;
                    }
                    mr6.c(threadData, this.b.b.getForum().getId());
                    return;
                }
            }
            mr6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new nr6();
        this.o = new a(this);
        this.l = tbPageContext;
    }

    public final void U(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", V(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String V(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 5 ? "3" : i == 10 ? "10" : i == 15 ? "11" : "" : (String) invokeI.objValue;
    }

    public final ma8 W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                ma8 ma8Var = new ma8();
                ma8Var.a = V(threadData.getInsertFloor());
                ma8Var.d = this.n.c;
                ma8Var.c = threadData.getTid();
                ma8Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    ma8Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return ma8Var;
            }
            return null;
        }
        return (ma8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: X */
    public FrsCardVideoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ml6 ml6Var = new ml6(this.l, this.mPageId);
            ml6Var.U(this.mPageId);
            ml6Var.a(this.m);
            return new FrsCardVideoViewHolder(ml6Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qg6, com.baidu.tieba.qn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ot4 ot4Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ot4Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.a() == null) {
                return null;
            }
            frsCardVideoViewHolder.a().a0(W(ot4Var.t));
            frsCardVideoViewHolder.a().i(ot4Var.t);
            frsCardVideoViewHolder.a().n(this.o);
            mr6.o(ot4Var.t, this.mPageId, this.n, t());
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                mr6.m(ot4Var.t, t());
                mr6.n(ot4Var.t, this.b.getForum().getId());
            }
            return frsCardVideoViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.pr6
    public nr6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (nr6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }
}
