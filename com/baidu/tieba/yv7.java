package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes9.dex */
public abstract class yv7 extends hs7<mz4, ThreadCardViewHolder<ThreadData>> implements km6, x38, e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public boolean o;
    public int p;
    public String q;
    public v38 r;
    public mm6<ThreadData> s;
    public NEGFeedBackView.NEGFeedbackEventCallback t;

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a extends mm6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv7 b;

        public a(yv7 yv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.b.O(view2, threadData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public b(yv7 yv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) && arrayList != null && negativeFeedBackData != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", negativeFeedBackData.getFid()).param("tid", negativeFeedBackData.getTid()).param("nid", negativeFeedBackData.getNid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", negativeFeedBackData.source).param("weight", negativeFeedBackData.weight).param("ab_tag", negativeFeedBackData.abTag).param("extra", negativeFeedBackData.extra).param("card_type", negativeFeedBackData.cardType).param(TiebaStatic.Params.OBJ_FLOOR, negativeFeedBackData.statFloor));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", negativeFeedBackData.getFid()).param("tid", negativeFeedBackData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(yv7 yv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rs.b
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) && fw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fw4Var.objType = 4;
                } else {
                    fw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm6 a;
        public final /* synthetic */ int b;

        public d(yv7 yv7Var, mm6 mm6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv7Var, mm6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm6Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) piVar).t;
                threadData.objType = 1;
                mm6 mm6Var = this.a;
                if (mm6Var != null) {
                    mm6Var.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.b, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.o = true;
        this.p = 3;
        this.r = new v38();
        this.s = new a(this);
        this.t = new b(this);
    }

    public ThreadCardViewHolder I(cu.b bVar, ViewGroup viewGroup, int i, mm6<ThreadData> mm6Var) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048576, this, bVar, viewGroup, i, mm6Var)) == null) {
            cu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this, mm6Var, i));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLLIL.objValue;
    }

    public void J(cu.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, z) == null) {
            dt dtVar = new dt(this.l.getPageActivity());
            dtVar.C(z);
            dtVar.B("frs");
            bVar.h(dtVar);
        }
    }

    public void K(cu.b bVar, @DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i) == null) {
            xt xtVar = new xt(this.l);
            xtVar.q(Boolean.FALSE);
            xtVar.setFrom("frs");
            xtVar.B(true);
            bVar.l().i(BdUtilHelper.getDimens(this.mContext, i));
            bVar.n(xtVar);
        }
    }

    public final void L(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            w38.k().d(threadData, this.m);
        }
    }

    public void N(cu.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            rs rsVar = new rs(this.l.getPageActivity());
            rsVar.b(4280);
            rsVar.o(this.mPageId);
            rsVar.x(new c(this));
            bVar.o(rsVar);
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.p = i;
        }
    }

    @Override // com.baidu.tieba.hs7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.tieba.hs7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o = z;
        }
    }

    public void M(cu.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            eu euVar = new eu(this.l.getPageActivity());
            lw4 lw4Var = new lw4();
            if (100 == u().tabType) {
                lw4Var.b = 25;
                euVar.E(19);
            } else {
                lw4Var.b = 2;
                euVar.E(2);
            }
            lw4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !rd.isEmpty(this.b.getForum().getId())) {
                lw4Var.j = this.b.getForum().getId();
            }
            euVar.C(lw4Var);
            euVar.J(1);
            euVar.F(2);
            euVar.b(16);
            euVar.M();
            bVar.m(euVar);
        }
    }

    public final void O(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, threadData) == null) && view2 != null && threadData != null) {
            if ("c13010".equals(this.q)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                if (view2 instanceof ThreadGodReplyLayout) {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        u38.c(threadData, this.b.getForum().getId());
                    }
                    u38.e(threadData, 15, this.mPageId, this.r, u());
                } else if (view2.getId() == R.id.thread_info_commont_container) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null && frsViewData2.getForum() != null) {
                        u38.c(threadData, this.b.getForum().getId());
                    }
                    u38.e(threadData, 5, this.mPageId, this.r, u());
                } else if (view2.getId() == R.id.share_num_container) {
                    u38.e(threadData, 14, this.mPageId, this.r, u());
                } else if (view2.getId() == R.id.img_agree) {
                    u38.e(threadData, 12, this.mPageId, this.r, u());
                } else if (view2.getId() == R.id.img_disagree) {
                    u38.e(threadData, 13, this.mPageId, this.r, u());
                } else {
                    FrsViewData frsViewData3 = this.b;
                    if (frsViewData3 != null && frsViewData3.getForum() != null) {
                        u38.c(threadData, this.b.getForum().getId());
                    }
                    u38.e(threadData, 1, this.mPageId, this.r, u());
                }
            } else {
                u38.e(threadData, 2, this.mPageId, this.r, u());
            }
            if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2 instanceof TbImageView) {
                    w38.k().h(this.r, threadData, 3);
                } else {
                    w38.k().h(this.r, threadData, 1);
                }
            } else {
                w38.k().h(this.r, threadData, 2);
            }
            if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                if (view2 instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", threadData.getTid());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", threadData.getTid());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: P */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            if (mz4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.n);
                }
                threadCardViewHolder.a().s(i);
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) threadCardViewHolder);
                gs7.j(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    mz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (mz4Var.t.getAuthor() != null && mz4Var.t.getAuthor().getUserId() != null && mz4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mz4Var.t.isSmartFrsThread() && mz4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.r(true).setNegEventCallback(this.t);
                }
                threadCardViewHolder.u();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().b(32);
                }
                threadCardViewHolder.e(mz4Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    mz4Var.t.statFloor = (mz4Var.position + 1) - i2;
                }
                w38.k().c(this.r, mz4Var.t);
                L(mz4Var.t);
                mz4Var.t.updateShowStatus();
                u38.p(mz4Var.t, this.mPageId, this.r, u());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    u38.n(mz4Var.t, u());
                    u38.o(mz4Var.t, this.b.getForum().getId());
                }
                ThreadData threadData = mz4Var.t;
                if (threadData != null) {
                    threadData.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.x38
    public v38 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (v38) invokeV.objValue;
    }
}
