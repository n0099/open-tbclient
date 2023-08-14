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
/* loaded from: classes6.dex */
public class jj7 extends hf7<w35, FrsCardVideoViewHolder<ik7>> implements an6, tq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public rq7 n;
    public cn6<ThreadData> o;

    public final String X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 5 ? "3" : i == 10 ? "10" : i == 15 ? "11" : "" : (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.an6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends cn6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj7 b;

        public a(jj7 jj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jj7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() == R.id.frame_video) {
                    this.b.W(threadData, "c11718");
                } else if (view2.getId() == R.id.layout_root) {
                    this.b.W(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                } else if (view2.getId() == R.id.image_user || view2.getId() == R.id.pendant_image_user) {
                    this.b.W(threadData, "c10241");
                } else if (view2.getId() == R.id.card_divider_tv) {
                    ot7.a(this.b.n, threadData.getRecomReason());
                }
                if (view2.getId() != R.id.card_home_page_normal_thread_user_name && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                    if (view2.getId() == R.id.frame_video) {
                        qq7.e(threadData, 4, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            qq7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else if (view2.getId() == R.id.thread_info_commont_container) {
                        qq7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            qq7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else {
                        qq7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            qq7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    }
                }
                qq7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.n = new rq7();
        this.o = new a(this);
        this.l = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: Z */
    public FrsCardVideoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ik7 ik7Var = new ik7(this.l, this.mPageId);
            ik7Var.W(this.mPageId);
            ik7Var.a(this.m);
            return new FrsCardVideoViewHolder(ik7Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.an6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    public final void W(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, threadData, str) != null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", X(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final tt9 Y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                tt9 tt9Var = new tt9();
                tt9Var.a = X(threadData.getInsertFloor());
                tt9Var.d = this.n.c;
                tt9Var.c = threadData.getTid();
                tt9Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    tt9Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return tt9Var;
            }
            return null;
        }
        return (tt9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hf7, com.baidu.tieba.lm
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w35 w35Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w35Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder != null && frsCardVideoViewHolder.b() != null) {
                frsCardVideoViewHolder.b().c0(Y(w35Var.t));
                frsCardVideoViewHolder.b().i(w35Var.t);
                frsCardVideoViewHolder.b().k(this.o);
                qq7.p(w35Var.t, this.mPageId, this.n, t());
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null) {
                    qq7.n(w35Var.t, t());
                    qq7.o(w35Var.t, this.b.getForum().getId());
                }
                return frsCardVideoViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tq7
    public rq7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (rq7) invokeV.objValue;
    }
}
