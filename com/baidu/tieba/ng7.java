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
import com.baidu.tieba.kt;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vt;
import com.baidu.tieba.zr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public abstract class ng7 extends yc7<py4, ThreadCardViewHolder<ThreadData>> implements zj6, io7, yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public boolean o;
    public int p;
    public String q;
    public go7 r;
    public bk6<ThreadData> s;
    public NEGFeedBackView.NEGFeedbackEventCallback t;

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.zj6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends bk6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng7 b;

        public a(ng7 ng7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ng7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.b.N(view2, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public b(ng7 ng7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng7Var};
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

    /* loaded from: classes7.dex */
    public class c implements zr.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ng7 ng7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zr.b
        public void a(jv4 jv4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, jv4Var, view2) == null) && jv4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    jv4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    jv4Var.objType = 4;
                } else {
                    jv4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk6 a;
        public final /* synthetic */ int b;

        public d(ng7 ng7Var, bk6 bk6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng7Var, bk6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk6Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof py4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((py4) yhVar).t;
                threadData.objType = 1;
                bk6 bk6Var = this.a;
                if (bk6Var != null) {
                    bk6Var.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), this.b, false);
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ng7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.r = new go7();
        this.s = new a(this);
        this.t = new b(this);
    }

    public ThreadCardViewHolder H(kt.b bVar, ViewGroup viewGroup, int i, bk6<ThreadData> bk6Var) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048576, this, bVar, viewGroup, i, bk6Var)) == null) {
            kt k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this, bk6Var, i));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLLIL.objValue;
    }

    public void I(kt.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, z) == null) {
            ls lsVar = new ls(this.l.getPageActivity());
            lsVar.E(z);
            lsVar.D("frs");
            bVar.h(lsVar);
        }
    }

    public void J(kt.b bVar, @DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i) == null) {
            ft ftVar = new ft(this.l);
            ftVar.s(Boolean.FALSE);
            ftVar.setFrom("frs");
            ftVar.D(true);
            bVar.l().i(BdUtilHelper.getDimens(this.mContext, i));
            bVar.n(ftVar);
        }
    }

    public final void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            ho7.k().d(threadData, this.m);
        }
    }

    public void M(kt.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            zr zrVar = new zr(this.l.getPageActivity());
            zrVar.e(4280);
            zrVar.q(this.mPageId);
            zrVar.z(new c(this));
            bVar.o(zrVar);
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.zj6
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.p = i;
        }
    }

    @Override // com.baidu.tieba.yc7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.tieba.yc7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o = z;
        }
    }

    public void L(kt.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            mt mtVar = new mt(this.l.getPageActivity());
            pv4 pv4Var = new pv4();
            if (100 == t().tabType) {
                pv4Var.b = 25;
                mtVar.G(19);
            } else {
                pv4Var.b = 2;
                mtVar.G(2);
            }
            pv4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !ad.isEmpty(this.b.getForum().getId())) {
                pv4Var.j = this.b.getForum().getId();
            }
            mtVar.E(pv4Var);
            mtVar.L(1);
            mtVar.H(2);
            mtVar.e(16);
            mtVar.O();
            bVar.m(mtVar);
        }
    }

    public final void N(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, threadData) == null) && view2 != null && threadData != null) {
            if ("c13010".equals(this.q)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                if (view2 instanceof ThreadGodReplyLayout) {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        fo7.c(threadData, this.b.getForum().getId());
                    }
                    fo7.e(threadData, 15, this.mPageId, this.r, t());
                } else if (view2.getId() == R.id.thread_info_commont_container) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null && frsViewData2.getForum() != null) {
                        fo7.c(threadData, this.b.getForum().getId());
                    }
                    fo7.e(threadData, 5, this.mPageId, this.r, t());
                } else if (view2.getId() == R.id.share_num_container) {
                    fo7.e(threadData, 14, this.mPageId, this.r, t());
                } else if (view2.getId() == R.id.img_agree) {
                    fo7.e(threadData, 12, this.mPageId, this.r, t());
                } else if (view2.getId() == R.id.img_disagree) {
                    fo7.e(threadData, 13, this.mPageId, this.r, t());
                } else {
                    FrsViewData frsViewData3 = this.b;
                    if (frsViewData3 != null && frsViewData3.getForum() != null) {
                        fo7.c(threadData, this.b.getForum().getId());
                    }
                    fo7.e(threadData, 1, this.mPageId, this.r, t());
                }
            } else {
                fo7.e(threadData, 2, this.mPageId, this.r, t());
            }
            if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2 instanceof TbImageView) {
                    ho7.k().h(this.r, threadData, 3);
                } else {
                    ho7.k().h(this.r, threadData, 1);
                }
            } else {
                ho7.k().h(this.r, threadData, 2);
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
    @Override // com.baidu.tieba.yc7, com.baidu.tieba.lh
    /* renamed from: O */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, py4 py4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py4Var, threadCardViewHolder})) == null) {
            if (py4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                if (threadCardViewHolder.a() instanceof xz5) {
                    threadCardViewHolder.a().b(this.n);
                }
                threadCardViewHolder.a().s(i);
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) py4Var, (py4) threadCardViewHolder);
                xc7.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    py4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (py4Var.t.getAuthor() != null && py4Var.t.getAuthor().getUserId() != null && py4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (py4Var.t.isSmartFrsThread() && py4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.q(true).setNegEventCallback(this.t);
                }
                threadCardViewHolder.t();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().e(32);
                }
                threadCardViewHolder.e(py4Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    py4Var.t.statFloor = (py4Var.position + 1) - i2;
                }
                ho7.k().c(this.r, py4Var.t);
                K(py4Var.t);
                py4Var.t.updateShowStatus();
                fo7.p(py4Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    fo7.n(py4Var.t, t());
                    fo7.o(py4Var.t, this.b.getForum().getId());
                }
                ThreadData threadData = py4Var.t;
                if (threadData != null) {
                    threadData.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.io7
    public go7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (go7) invokeV.objValue;
    }
}
