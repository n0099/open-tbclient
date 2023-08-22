package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class zk7 extends yg7<c45, ThreadCardViewHolder<ThreadData>> implements ho6, os7, s46, io6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public int p;
    public jo6<ThreadData> q;
    public NEGFeedBackView.NEGFeedbackEventCallback r;

    @Override // com.baidu.tieba.ho6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a extends jo6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk7 b;

        public a(zk7 zk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, this.b.getType());
                }
                if ("c13010".equals(this.b.m)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        ls7.e(threadData, 5, this.b.mPageId, os7.q0, this.b.t());
                        jv7.h(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        ls7.e(threadData, 14, this.b.mPageId, os7.q0, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        ls7.e(threadData, 12, this.b.mPageId, os7.q0, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        ls7.e(threadData, 13, this.b.mPageId, os7.q0, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.q.a instanceof Boolean) {
                            if (((Boolean) this.b.q.a).booleanValue()) {
                                ls7.e(threadData, 1, this.b.mPageId, os7.q0, this.b.t());
                            } else {
                                ls7.e(threadData, 3, this.b.mPageId, os7.q0, this.b.t());
                            }
                        }
                        jv7.h(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        ls7.e(threadData, 15, this.b.mPageId, os7.q0, this.b.t());
                        jv7.h(threadData, this.b.b, 1);
                    } else {
                        ls7.e(threadData, 1, this.b.mPageId, os7.q0, this.b.t());
                        jv7.h(threadData, this.b.b, 1);
                    }
                } else {
                    ls7.e(threadData, 2, this.b.mPageId, os7.q0, this.b.t());
                }
                if (view2.getId() == R.id.thread_card_root && threadData.isVideoThreadType()) {
                    this.b.c0(threadData);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        jv7.a(os7.q0, threadData.getRecomReason());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.q.a instanceof Boolean) {
                            if (((Boolean) this.b.q.a).booleanValue()) {
                                ns7.k().h(os7.q0, threadData, 1);
                            } else {
                                ns7.k().h(os7.q0, threadData, 3);
                            }
                        }
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        ns7.k().h(os7.q0, threadData, 5);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().e0() != null && threadData.getTopAgreePost().e0().P() != null && threadData.getTopAgreePost().e0().P().size() > 0) {
                            i = threadData.getTopAgreePost().N ? 9 : 8;
                        }
                        ns7.k().h(os7.q0, threadData, i);
                    } else {
                        ns7.k().h(os7.q0, threadData, 1);
                    }
                } else {
                    ns7.k().h(os7.q0, threadData, 2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk7 a;

        public b(zk7 zk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk7Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof c45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((c45) bnVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((w05) threadData, view2.getContext(), this.a.o, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ c45 d;

        public c(zk7 zk7Var, ViewGroup viewGroup, View view2, int i, c45 c45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk7Var, viewGroup, view2, Integer.valueOf(i), c45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = c45Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(dx.a((hn) this.a, this.b, this.c));
                }
                CardLinkageManager.INSTANCE.cancelHighLight((hn) this.a, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public d(zk7 zk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk7Var};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.l = false;
        this.o = 3;
        this.p = 13;
        this.q = new a(this);
        this.r = new d(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.io6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    @Override // com.baidu.tieba.ho6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.yg7, com.baidu.tieba.go6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.m = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: a0 */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity(), false);
            py pyVar = new py(this.c.getPageActivity(), false);
            c15 c15Var = new c15();
            int i = 10;
            if (100 == t().tabType) {
                if (!this.l) {
                    i = 25;
                }
                c15Var.b = i;
                pyVar.E(19);
                pyVar.J(14);
            } else {
                if (!this.l) {
                    i = 2;
                }
                c15Var.b = i;
                if ("a070".equals(t().locatePage)) {
                    pyVar.E(13);
                } else {
                    pyVar.E(2);
                }
                if (TbSingleton.getInstance().getFrsCurTabType() == this.p) {
                    pyVar.J(15);
                } else {
                    pyVar.J(1);
                }
            }
            c15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !di.isEmpty(this.b.getForum().getId())) {
                c15Var.j = this.b.getForum().getId();
            }
            pyVar.C(c15Var);
            pyVar.K("frs_page");
            pyVar.F(3);
            pyVar.f(48);
            pyVar.M();
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            threadCardViewHolder.p(true);
            threadCardViewHolder.h(4, bVar.l());
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yg7, com.baidu.tieba.om
    /* renamed from: b0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, c45 c45Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, c45Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) c45Var, (c45) threadCardViewHolder);
            if (c45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.b().b(this.n);
                threadCardViewHolder.b().r(i);
                xg7.i(threadCardViewHolder.b().f(), this.b);
                if (c45Var.t.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    threadCardViewHolder.b().f().f(128);
                } else {
                    threadCardViewHolder.b().f().g(128);
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    c45Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                threadCardViewHolder.r(false, Align.ALIGN_RIGHT_BOTTOM, this.r);
                if (threadCardViewHolder.b().f() instanceof py) {
                    ((py) threadCardViewHolder.b().f()).I(new c(this, viewGroup, view2, i, c45Var));
                }
                threadCardViewHolder.f(c45Var.t);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.q);
                c45Var.t.updateShowStatus();
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void c0(ThreadData threadData) {
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

    @Override // com.baidu.tieba.os7
    public ms7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return os7.q0;
        }
        return (ms7) invokeV.objValue;
    }
}
