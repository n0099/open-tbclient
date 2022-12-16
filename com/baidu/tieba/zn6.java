package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zn6 extends ck6<yu4, ThreadCardViewHolder<ThreadData>> implements f56, av6, hr5, g56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public h56<ThreadData> p;

    @Override // com.baidu.tieba.f56
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.g56
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends h56<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn6 b;

        public a(zn6 zn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, this.b.getType());
                }
                if ("c13010".equals(this.b.l)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        xu6.e(threadData, 5, this.b.mPageId, av6.p0, this.b.t());
                        lw6.g(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        xu6.e(threadData, 14, this.b.mPageId, av6.p0, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        xu6.e(threadData, 12, this.b.mPageId, av6.p0, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        xu6.e(threadData, 13, this.b.mPageId, av6.p0, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.p.a instanceof Boolean) {
                            if (((Boolean) this.b.p.a).booleanValue()) {
                                xu6.e(threadData, 1, this.b.mPageId, av6.p0, this.b.t());
                            } else {
                                xu6.e(threadData, 3, this.b.mPageId, av6.p0, this.b.t());
                            }
                        }
                        lw6.g(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        xu6.e(threadData, 15, this.b.mPageId, av6.p0, this.b.t());
                        lw6.g(threadData, this.b.b, 1);
                    } else {
                        xu6.e(threadData, 1, this.b.mPageId, av6.p0, this.b.t());
                        lw6.g(threadData, this.b.b, 1);
                    }
                } else {
                    xu6.e(threadData, 2, this.b.mPageId, av6.p0, this.b.t());
                }
                if (view2.getId() == R.id.thread_card_root && threadData.isVideoThreadType()) {
                    this.b.a0(threadData);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        lw6.a(av6.p0, threadData.getRecomReason());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.p.a instanceof Boolean) {
                            if (((Boolean) this.b.p.a).booleanValue()) {
                                zu6.k().h(av6.p0, threadData, 1);
                            } else {
                                zu6.k().h(av6.p0, threadData, 3);
                            }
                        }
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        zu6.k().h(av6.p0, threadData, 5);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().X() != null && threadData.getTopAgreePost().X().I() != null && threadData.getTopAgreePost().X().I().size() > 0) {
                            i = threadData.getTopAgreePost().N ? 9 : 8;
                        }
                        zu6.k().h(av6.p0, threadData, i);
                    } else {
                        zu6.k().h(av6.p0, threadData, 1);
                    }
                } else {
                    zu6.k().h(av6.p0, threadData, 2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox a;
        public final /* synthetic */ zn6 b;

        public b(zn6 zn6Var, ox oxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn6Var, oxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zn6Var;
            this.a = oxVar;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof yu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                if ((tj6.f().i() || sj6.h().j()) && !this.a.y()) {
                    ThreadData threadData = ((yu4) xnVar).t;
                    if (threadData == null) {
                        return;
                    }
                    if (!threadData.isMarkToDel() && tj6.f().i()) {
                        if (tj6.f().a(threadData)) {
                            threadData.setMarkToDel(true);
                        }
                    } else if (!threadData.isMarkToMove() && sj6.h().j()) {
                        if (sj6.h().a(threadData)) {
                            threadData.setMarkToMove(true);
                        }
                    } else {
                        tj6.f().l(threadData);
                        threadData.setMarkToDel(false);
                        sj6.h().l(threadData);
                        threadData.setMarkToMove(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, threadData));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData2 = ((yu4) xnVar).t;
                threadData2.objType = 1;
                if (this.b.p != null) {
                    this.b.p.a(threadCardViewHolder.getView(), threadData2);
                }
                ThreadCardUtils.jumpToPB((vr4) threadData2, view2.getContext(), this.b.o, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.n = true;
        this.o = 3;
        this.p = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.hr5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.f56
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.ck6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.baidu.tieba.ck6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: Y */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity(), false);
            ox oxVar = new ox(this.c.getPageActivity());
            bVar.h(oxVar);
            oxVar.B(this.n);
            oxVar.A("frs");
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new b(this, oxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    public final void a0(ThreadData threadData) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (u()) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_locate", i);
            if (threadData.getThreadAlaInfo() == null) {
                j = -1;
            } else {
                j = threadData.getThreadAlaInfo().live_id;
            }
            TiebaStatic.log(param2.param("obj_id", j).param("obj_type", 1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ck6, com.baidu.tieba.kn
    /* renamed from: Z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yu4 yu4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yu4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) yu4Var, (yu4) threadCardViewHolder);
            if (yu4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.m);
                threadCardViewHolder.a().r(i);
                bk6.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    yu4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                threadCardViewHolder.e(yu4Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.p);
                yu4Var.t.updateShowStatus();
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.av6
    public yu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return av6.p0;
        }
        return (yu6) invokeV.objValue;
    }
}
