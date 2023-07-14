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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class jl7 extends yh7<ThreadData, ThreadCardViewHolder<ThreadData>> implements sp6, kt7, t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public up6<ThreadData> n;
    public NEGFeedBackView.b o;

    @Override // com.baidu.tieba.sp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yh7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jl7 b;

        public a(jl7 jl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jl7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (view2 != null && threadData != null && !StringUtils.isNull(threadData.getTid())) {
                    if (view2.getId() == R.id.thread_card_root) {
                        jt7.k().h(kt7.q0, threadData, 13);
                    }
                    if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            ht7.e(threadData, 15, this.b.mPageId, kt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ht7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.thread_info_commont_container) {
                            ht7.e(threadData, 5, this.b.mPageId, kt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ht7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.share_num_container) {
                            ht7.e(threadData, 14, this.b.mPageId, kt7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_agree) {
                            ht7.e(threadData, 12, this.b.mPageId, kt7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_disagree) {
                            ht7.e(threadData, 13, this.b.mPageId, kt7.q0, this.b.t());
                            return;
                        } else {
                            ht7.e(threadData, 1, this.b.mPageId, kt7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                ht7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        }
                    }
                    ht7.e(threadData, 2, this.b.mPageId, kt7.q0, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(s35 s35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s35Var, compoundButton, z) == null) {
            }
        }

        public b(jl7 jl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, s35 s35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, s35Var) == null) && arrayList != null && s35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", s35Var.c()).param("tid", s35Var.f()).param("nid", s35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", s35Var.l).param("weight", s35Var.k).param("ab_tag", s35Var.p).param("extra", s35Var.m).param("card_type", s35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, s35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(s35 s35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", s35Var.c()).param("tid", s35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jl7 a;

        public c(jl7 jl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jl7Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            this.a.Y(view2, ynVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jl7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.sp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public final void Y(View view2, yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, ynVar) == null) && (ynVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) ynVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new xz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity());
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.r(this.mPageId);
            ayVar.C(this.c);
            bVar.o(ayVar);
            bVar.n(new yx(this.c.getPageActivity()));
            oz ozVar = new oz(this.c.getPageActivity());
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
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !xi.isEmpty(this.b.getForum().getId())) {
                z15Var.j = this.b.getForum().getId();
            }
            ozVar.D(z15Var);
            ozVar.G(3);
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) threadData, (ThreadData) threadCardViewHolder);
            if (threadData != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                jt7.k().c(kt7.q0, threadData);
                threadCardViewHolder.b().b(this.m);
                threadCardViewHolder.b().r(i);
                if (this.l == 1) {
                    threadCardViewHolder.q(true).s(this.o);
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

    @Override // com.baidu.tieba.kt7
    public it7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return kt7.q0;
        }
        return (it7) invokeV.objValue;
    }
}
