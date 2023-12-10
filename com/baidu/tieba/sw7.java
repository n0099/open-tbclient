package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.NegFeedBackDecorItem;
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
/* loaded from: classes8.dex */
public class sw7 extends hs7<mz4, ThreadCardViewHolder<ThreadData>> implements km6, x38, e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public int o;
    public v38 p;
    public mm6<ThreadData> q;
    public NEGFeedBackView.NEGFeedbackEventCallback r;

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends mm6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw7 b;

        public a(sw7 sw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        u38.e(threadData, 5, this.b.mPageId, this.b.p, this.b.u());
                        a78.h(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        u38.e(threadData, 14, this.b.mPageId, this.b.p, this.b.u());
                    } else if (view2.getId() == R.id.img_agree) {
                        u38.e(threadData, 12, this.b.mPageId, this.b.p, this.b.u());
                    } else if (view2.getId() == R.id.img_disagree) {
                        u38.e(threadData, 13, this.b.mPageId, this.b.p, this.b.u());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.q.a instanceof Boolean) {
                            if (((Boolean) this.b.q.a).booleanValue()) {
                                u38.e(threadData, 1, this.b.mPageId, this.b.p, this.b.u());
                            } else {
                                u38.e(threadData, 3, this.b.mPageId, this.b.p, this.b.u());
                            }
                        }
                        a78.h(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        u38.e(threadData, 15, this.b.mPageId, this.b.p, this.b.u());
                        a78.h(threadData, this.b.b, 1);
                    } else {
                        u38.e(threadData, 1, this.b.mPageId, this.b.p, this.b.u());
                        a78.h(threadData, this.b.b, 1);
                    }
                } else {
                    u38.e(threadData, 2, this.b.mPageId, this.b.p, this.b.u());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else {
                        w38.k().h(this.b.p, threadData, 7);
                        return;
                    }
                }
                w38.k().h(this.b.p, threadData, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public b(sw7 sw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw7Var};
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

    /* loaded from: classes8.dex */
    public class c implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(sw7 sw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw7Var};
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

    /* loaded from: classes8.dex */
    public class d implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw7 a;

        public d(sw7 sw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw7Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) piVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new v38();
        this.q = new a(this);
        this.r = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.hs7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.l.getPageActivity());
            rs rsVar = new rs(this.l.getPageActivity());
            rsVar.o(this.mPageId);
            rsVar.b(4272);
            rsVar.x(new c(this));
            bVar.o(rsVar);
            bVar.n(new mt(this.l.getPageActivity()));
            dt dtVar = new dt(this.l.getPageActivity());
            dtVar.C(this.n);
            dtVar.B("frs");
            bVar.h(dtVar);
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
            euVar.J(this.o);
            euVar.F(this.o);
            euVar.b(48);
            bVar.m(euVar);
            cu j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.t(this.o);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.p();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            if (mz4Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) threadCardViewHolder);
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.m);
                }
                gs7.j(threadCardViewHolder.a().f(), this.b);
                int i2 = 0;
                if (mz4Var.t.getAuthor() != null && mz4Var.t.getAuthor().getUserId() != null && mz4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mz4Var.t.isSmartFrsThread() && mz4Var.t.getFeedBackReasonMap() != null && !z) {
                    NegFeedBackDecorItem r = threadCardViewHolder.r(true);
                    r.setNegEventCallback(this.r);
                    r.onBindDataToView(mz4Var.t.getNegFeedBackData());
                }
                threadCardViewHolder.u();
                threadCardViewHolder.e(mz4Var.t);
                threadCardViewHolder.h(this.q);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                if (this.p != null) {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null) {
                        i2 = frsViewData.getTopThreadSize();
                    }
                    mz4Var.t.statFloor = (mz4Var.position + 1) - i2;
                }
                w38.k().c(this.p, mz4Var.t);
                u38.p(mz4Var.t, this.mPageId, this.p, u());
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null && frsViewData2.getForum() != null) {
                    u38.n(mz4Var.t, u());
                    u38.o(mz4Var.t, this.b.getForum().getId());
                }
                if (mz4Var != null) {
                    mz4Var.t.updateShowStatus();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (v38) invokeV.objValue;
    }
}
