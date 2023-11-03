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
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mu;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class nu7 extends pp7<hz4, AutoVideoCardViewHolder<ThreadData>> implements vl6, c18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public a18 n;
    public boolean o;
    public xl6<ThreadData> p;

    @Override // com.baidu.tieba.vl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends xl6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu7 b;

        public a(nu7 nu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        z08.e(threadData, 5, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        z08.e(threadData, 3, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().B1()) {
                            z08.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            z08.e(threadData, 15, this.b.mPageId, this.b.n, this.b.u());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((bw4) threadData, view2.getContext(), this.b.m, false);
                        z08.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            z08.e(threadData, 14, this.b.mPageId, this.b.n, this.b.u());
                        } else if (view2.getId() == R.id.img_agree) {
                            z08.e(threadData, 12, this.b.mPageId, this.b.n, this.b.u());
                        } else if (view2.getId() == R.id.img_disagree) {
                            z08.e(threadData, 13, this.b.mPageId, this.b.n, this.b.u());
                        } else {
                            z08.e(threadData, 1, this.b.mPageId, this.b.n, this.b.u());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((bw4) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            z08.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    z08.e(threadData, 2, this.b.mPageId, this.b.n, this.b.u());
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
                            asa.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        b18.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                b18.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu7 a;

        public b(nu7 nu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu7Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof hz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((hz4) oiVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((bw4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new a18();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.vl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.pp7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final f9a S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            f9a f9aVar = new f9a();
            String str = "3";
            if (100 == u().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                f9aVar.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                f9aVar.a = str;
            }
            f9aVar.d = this.n.c;
            f9aVar.c = threadData.getTid();
            f9aVar.f = threadData.mRecomSource;
            f9aVar.g = threadData.mRecomReason;
            f9aVar.h = threadData.mRecomWeight;
            f9aVar.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                f9aVar.m = threadData.getThreadVideoInfo().video_md5;
            }
            return f9aVar;
        }
        return (f9a) invokeL.objValue;
    }

    public final void T(fz4 fz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fz4Var) == null) && fz4Var != null && StringUtils.isNotNull(fz4Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = ri6.a(this.mContext);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + fz4Var.r());
                vi6.a(a2, fz4Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + fz4Var.r());
                wi6.c(fz4Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: U */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.c.getPageActivity());
            qs qsVar = new qs(this.c.getPageActivity());
            qsVar.b(696);
            qsVar.o(this.mPageId);
            bVar.o(qsVar);
            jt jtVar = new jt(this.c.getPageActivity());
            jtVar.E(this.o);
            bVar.n(jtVar);
            lu luVar = new lu(this.c.getPageActivity());
            luVar.C(this.c);
            luVar.B(3);
            bVar.h(luVar);
            gt gtVar = new gt(this.c.getPageActivity());
            gtVar.C(this.c);
            gtVar.B(1);
            bVar.h(gtVar);
            bVar.h(new ft(this.c.getPageActivity()));
            et etVar = new et(this.c.getPageActivity());
            etVar.D(1);
            bVar.h(etVar);
            ct ctVar = new ct(this.c.getPageActivity());
            ctVar.C(this.o);
            ctVar.B("frs");
            bVar.h(ctVar);
            du duVar = new du(this.c.getPageActivity(), false);
            hw4 hw4Var = new hw4();
            if (100 == u().tabType) {
                hw4Var.b = 25;
                duVar.E(19);
                duVar.J(14);
            } else {
                hw4Var.b = 2;
                duVar.E(2);
                duVar.J(1);
            }
            hw4Var.h = 2;
            duVar.C(hw4Var);
            duVar.F(this.m);
            duVar.b(16);
            duVar.M();
            bVar.m(duVar);
            bu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.r(this.p);
            k.t(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.p();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pp7, com.baidu.tieba.bi
    /* renamed from: V */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hz4 hz4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hz4Var, autoVideoCardViewHolder})) == null) {
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
                hz4Var.t.statFloor = (i + 1) - i2;
            }
            b18.k().c(this.n, hz4Var.t);
            z08.p(hz4Var.t, this.mPageId, this.n, u());
            fz4 taskInfoData = hz4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof br7) {
                    br7 br7Var = (br7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = br7Var.w();
                        String v = br7Var.v();
                        String k = taskInfoData.k();
                        asa.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + hz4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", hz4Var.t.getFid());
                statisticItem.param("tid", hz4Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", hz4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    z08.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, hz4Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    T(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (hz4Var != null) {
                hz4Var.t.updateShowStatus();
                if (hz4Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.z(S(hz4Var.t));
                }
                op7.i(autoVideoCardViewHolder.a().f(), this.b);
                autoVideoCardViewHolder.a().f().b(32);
                autoVideoCardViewHolder.e(hz4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().r(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.c18
    public a18 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (a18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pp7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.y();
            this.l.clear();
        }
    }
}
