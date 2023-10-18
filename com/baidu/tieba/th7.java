package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.switchs.HeadlinesPreRenderSwitch;
import com.baidu.tbadk.switchs.HeadlinesPrefetchSwitch;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kt;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class th7 extends yc7<py4, AutoVideoCardViewHolder<ThreadData>> implements zj6, io7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public go7 n;
    public boolean o;
    public bk6<ThreadData> p;

    @Override // com.baidu.tieba.zj6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends bk6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th7 b;

        public a(th7 th7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = th7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        fo7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        fo7.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().z1()) {
                            fo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            fo7.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), this.b.m, false);
                        fo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            fo7.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_agree) {
                            fo7.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_disagree) {
                            fo7.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                        } else {
                            fo7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            fo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    fo7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_card_root) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String e = threadData.getTaskInfoData().e();
                            if (StringUtils.isNull(e)) {
                                e = threadData.getTaskInfoData().h();
                            }
                            String str = e;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String k = threadData.getTaskInfoData().k();
                            vea.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        ho7.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                ho7.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th7 a;

        public b(th7 th7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof py4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((py4) yhVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public th7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
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
        this.m = 3;
        this.n = new go7();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.zj6
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.yc7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final aw9 R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            aw9 aw9Var = new aw9();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                aw9Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                aw9Var.a = str;
            }
            aw9Var.d = this.n.c;
            aw9Var.c = threadData.getTid();
            aw9Var.f = threadData.mRecomSource;
            aw9Var.g = threadData.mRecomReason;
            aw9Var.h = threadData.mRecomWeight;
            aw9Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                aw9Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return aw9Var;
        }
        return (aw9) invokeL.objValue;
    }

    public final void S(ny4 ny4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ny4Var) == null) && ny4Var != null && StringUtils.isNotNull(ny4Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = vg6.a(this.mContext);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + ny4Var.r());
                zg6.a(a2, ny4Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + ny4Var.r());
                ah6.c(ny4Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: T */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.c.getPageActivity());
            zr zrVar = new zr(this.c.getPageActivity());
            zrVar.e(696);
            zrVar.q(this.mPageId);
            bVar.o(zrVar);
            ss ssVar = new ss(this.c.getPageActivity());
            ssVar.G(this.o);
            bVar.n(ssVar);
            ut utVar = new ut(this.c.getPageActivity());
            utVar.E(this.c);
            utVar.D(3);
            bVar.h(utVar);
            ps psVar = new ps(this.c.getPageActivity());
            psVar.E(this.c);
            psVar.D(1);
            bVar.h(psVar);
            bVar.h(new os(this.c.getPageActivity()));
            ns nsVar = new ns(this.c.getPageActivity());
            nsVar.F(1);
            bVar.h(nsVar);
            ls lsVar = new ls(this.c.getPageActivity());
            lsVar.E(this.o);
            lsVar.D("frs");
            bVar.h(lsVar);
            mt mtVar = new mt(this.c.getPageActivity(), false);
            pv4 pv4Var = new pv4();
            if (100 == t().tabType) {
                pv4Var.b = 25;
                mtVar.G(19);
                mtVar.L(14);
            } else {
                pv4Var.b = 2;
                mtVar.G(2);
                mtVar.L(1);
            }
            pv4Var.h = 2;
            mtVar.E(pv4Var);
            mtVar.H(this.m);
            mtVar.e(16);
            mtVar.O();
            bVar.m(mtVar);
            kt k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.r(this.p);
            k.t(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.o();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yc7, com.baidu.tieba.lh
    /* renamed from: U */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, py4 py4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            char c = 1;
            if (this.n != null) {
                int i2 = 0;
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    i2 = frsViewData.getTopThreadSize();
                }
                py4Var.t.statFloor = (i + 1) - i2;
            }
            ho7.k().c(this.n, py4Var.t);
            fo7.p(py4Var.t, this.mPageId, this.n, t());
            ny4 taskInfoData = py4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof ke7) {
                    ke7 ke7Var = (ke7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = ke7Var.w();
                        String v = ke7Var.v();
                        String k = taskInfoData.k();
                        vea.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + py4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", py4Var.t.getFid());
                statisticItem.param("tid", py4Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", py4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    fo7.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, py4Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    S(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (py4Var != null) {
                py4Var.t.updateShowStatus();
                if (py4Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.y(R(py4Var.t));
                }
                xc7.i(autoVideoCardViewHolder.a().f(), this.b);
                autoVideoCardViewHolder.a().f().e(32);
                autoVideoCardViewHolder.e(py4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().r(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.io7
    public go7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (go7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc7
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.x();
            this.l.clear();
        }
    }
}
