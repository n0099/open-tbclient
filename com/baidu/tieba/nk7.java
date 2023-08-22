package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
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
/* loaded from: classes7.dex */
public class nk7 extends yg7<ThreadData, ThreadCardViewHolder<ThreadData>> implements ho6, os7, s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public jo6<ThreadData> n;
    public NEGFeedBackView.NEGFeedbackEventCallback o;

    @Override // com.baidu.tieba.ho6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yg7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends jo6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 b;

        public a(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (view2 != null && threadData != null && !StringUtils.isNull(threadData.getTid())) {
                    if (view2.getId() == R.id.thread_card_root) {
                        ns7.k().h(os7.q0, threadData, 13);
                    }
                    if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            ls7.e(threadData, 15, this.b.mPageId, os7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ls7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.thread_info_commont_container) {
                            ls7.e(threadData, 5, this.b.mPageId, os7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ls7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.share_num_container) {
                            ls7.e(threadData, 14, this.b.mPageId, os7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_agree) {
                            ls7.e(threadData, 12, this.b.mPageId, os7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_disagree) {
                            ls7.e(threadData, 13, this.b.mPageId, os7.q0, this.b.t());
                            return;
                        } else {
                            ls7.e(threadData, 1, this.b.mPageId, os7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ls7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        }
                    }
                    ls7.e(threadData, 2, this.b.mPageId, os7.q0, this.b.t());
                }
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

        public b(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
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
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 a;

        public c(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk7Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            this.a.Y(view2, bnVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nk7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.l = 3;
        this.n = new a(this);
        this.o = new b(this);
        this.c = tbPageContext;
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.ho6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public final void Y(View view2, bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, bnVar) == null) && (bnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) bnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((w05) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new yy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.q(this.mPageId);
            cxVar.B(this.c);
            bVar.o(cxVar);
            bVar.n(new ax(this.c.getPageActivity()));
            py pyVar = new py(this.c.getPageActivity());
            c15 c15Var = new c15();
            if (100 == t().tabType) {
                c15Var.b = 25;
                pyVar.E(19);
                pyVar.J(14);
            } else {
                c15Var.b = 2;
                pyVar.E(2);
                pyVar.J(1);
            }
            c15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !di.isEmpty(this.b.getForum().getId())) {
                c15Var.j = this.b.getForum().getId();
            }
            pyVar.C(c15Var);
            pyVar.F(3);
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yg7, com.baidu.tieba.om
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) threadData, (ThreadData) threadCardViewHolder);
            if (threadData != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                ns7.k().c(os7.q0, threadData);
                threadCardViewHolder.b().b(this.m);
                threadCardViewHolder.b().r(i);
                if (this.l == 1) {
                    threadCardViewHolder.q(true).setNegEventCallback(this.o);
                }
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.f(threadData);
                threadCardViewHolder.b().q(this.n);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
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
