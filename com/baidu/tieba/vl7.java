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
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class vl7 extends fi7<ThreadData, ThreadCardViewHolder<ThreadData>> implements kp6, xt7, o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public mp6<ThreadData> n;
    public NEGFeedBackView.NEGFeedbackEventCallback o;

    @Override // com.baidu.tieba.kp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.fi7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl7 b;

        public a(vl7 vl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vl7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (view2 != null && threadData != null && !StringUtils.isNull(threadData.getTid())) {
                    if (view2.getId() == R.id.thread_card_root) {
                        wt7.k().h(xt7.q0, threadData, 13);
                    }
                    if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            ut7.e(threadData, 15, this.b.mPageId, xt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ut7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.thread_info_commont_container) {
                            ut7.e(threadData, 5, this.b.mPageId, xt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ut7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.share_num_container) {
                            ut7.e(threadData, 14, this.b.mPageId, xt7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_agree) {
                            ut7.e(threadData, 12, this.b.mPageId, xt7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_disagree) {
                            ut7.e(threadData, 13, this.b.mPageId, xt7.q0, this.b.t());
                            return;
                        } else {
                            ut7.e(threadData, 1, this.b.mPageId, xt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ut7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        }
                    }
                    ut7.e(threadData, 2, this.b.mPageId, xt7.q0, this.b.t());
                }
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

        public b(vl7 vl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl7Var};
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
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl7 a;

        public c(vl7 vl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl7Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            this.a.Y(view2, cnVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.kp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public final void Y(View view2, cn cnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, cnVar) == null) && (cnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) cnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new zy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.p(this.mPageId);
            dxVar.B(this.c);
            bVar.o(dxVar);
            bVar.n(new bx(this.c.getPageActivity()));
            qy qyVar = new qy(this.c.getPageActivity());
            h15 h15Var = new h15();
            if (100 == t().tabType) {
                h15Var.b = 25;
                qyVar.F(19);
                qyVar.K(14);
            } else {
                h15Var.b = 2;
                qyVar.F(2);
                qyVar.K(1);
            }
            h15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !ei.isEmpty(this.b.getForum().getId())) {
                h15Var.j = this.b.getForum().getId();
            }
            qyVar.D(h15Var);
            qyVar.G(3);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) threadData, (ThreadData) threadCardViewHolder);
            if (threadData != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                wt7.k().c(xt7.q0, threadData);
                threadCardViewHolder.a().b(this.m);
                threadCardViewHolder.a().r(i);
                if (this.l == 1) {
                    threadCardViewHolder.p(true).setNegEventCallback(this.o);
                }
                threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.e(threadData);
                threadCardViewHolder.a().q(this.n);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.xt7
    public vt7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return xt7.q0;
        }
        return (vt7) invokeV.objValue;
    }
}
