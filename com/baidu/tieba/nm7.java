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
import com.baidu.tieba.mz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class nm7 extends yh7<z45, AutoVideoCardViewHolder<ThreadData>> implements sp6, kt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public it7 n;
    public boolean o;
    public up6<ThreadData> p;

    @Override // com.baidu.tieba.sp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm7 b;

        public a(nm7 nm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        ht7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        ht7.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().v1()) {
                            ht7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            ht7.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), this.b.m, false);
                        ht7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            ht7.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_agree) {
                            ht7.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_disagree) {
                            ht7.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                        } else {
                            ht7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            ht7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    ht7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
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
                            eda.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        jt7.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                jt7.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm7 a;

        public b(nm7 nm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm7Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((z45) ynVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new it7();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.sp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.yh7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final av9 S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            av9 av9Var = new av9();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                av9Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                av9Var.a = str;
            }
            av9Var.d = this.n.c;
            av9Var.c = threadData.getTid();
            av9Var.f = threadData.mRecomSource;
            av9Var.g = threadData.mRecomReason;
            av9Var.h = threadData.mRecomWeight;
            av9Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                av9Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return av9Var;
        }
        return (av9) invokeL.objValue;
    }

    public final void T(x45 x45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x45Var) == null) && x45Var != null && StringUtils.isNotNull(x45Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = xm6.a(this.mContext);
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + x45Var.r());
                bn6.a(a2, x45Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                h29 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + x45Var.r());
                cn6.c(x45Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: U */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity());
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.g(696);
            ayVar.r(this.mPageId);
            bVar.o(ayVar);
            ty tyVar = new ty(this.c.getPageActivity());
            tyVar.H(this.o);
            bVar.n(tyVar);
            wz wzVar = new wz(this.c.getPageActivity());
            wzVar.F(this.c);
            wzVar.E(3);
            bVar.h(wzVar);
            qy qyVar = new qy(this.c.getPageActivity());
            qyVar.F(this.c);
            qyVar.E(1);
            bVar.h(qyVar);
            bVar.h(new py(this.c.getPageActivity()));
            oy oyVar = new oy(this.c.getPageActivity());
            oyVar.G(1);
            bVar.h(oyVar);
            my myVar = new my(this.c.getPageActivity());
            myVar.F(this.o);
            myVar.E("frs");
            bVar.h(myVar);
            oz ozVar = new oz(this.c.getPageActivity(), false);
            z15 z15Var = new z15();
            if (100 == t().tabType) {
                z15Var.b = 25;
                ozVar.F(19);
                ozVar.L(14);
            } else {
                z15Var.b = 2;
                ozVar.F(2);
                ozVar.L(1);
            }
            z15Var.h = 2;
            ozVar.D(z15Var);
            ozVar.G(this.m);
            ozVar.g(16);
            ozVar.O();
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.j(this.mPageId);
            k.q(this.p);
            k.s(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.o();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    /* renamed from: V */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, autoVideoCardViewHolder})) == null) {
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
                z45Var.t.statFloor = (i + 1) - i2;
            }
            jt7.k().c(this.n, z45Var.t);
            ht7.p(z45Var.t, this.mPageId, this.n, t());
            x45 taskInfoData = z45Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof kj7) {
                    kj7 kj7Var = (kj7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = kj7Var.w();
                        String v = kj7Var.v();
                        String k = taskInfoData.k();
                        eda.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + z45Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", z45Var.t.getFid());
                statisticItem.param("tid", z45Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", z45Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    ht7.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, z45Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    T(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (z45Var != null) {
                z45Var.t.updateShowStatus();
                if (z45Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.y(S(z45Var.t));
                }
                xh7.i(autoVideoCardViewHolder.b().f(), this.b);
                autoVideoCardViewHolder.b().f().g(32);
                autoVideoCardViewHolder.f(z45Var.t);
                autoVideoCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.b().q(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.kt7
    public it7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (it7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yh7
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.x();
            this.l.clear();
        }
    }
}
