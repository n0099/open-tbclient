package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o47 extends kn<w56, ThreadCardViewHolder<w56>> implements hr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public Cdo d;
    public NEGFeedBackView.b e;
    public h56<w56> f;

    /* loaded from: classes5.dex */
    public class a extends h56<w56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o47 b;

        public a(o47 o47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, w56 w56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w56Var) == null) {
                a56.b().d(true);
                if (view2 != null && w56Var != null && w56Var.getThreadData() != null && !StringUtils.isNull(w56Var.getThreadData().getTid())) {
                    this.b.x(view2, w56Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o47 a;

        public b(o47 o47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o47Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof w56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                w56 w56Var = (w56) xnVar;
                w56Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), w56Var);
                }
                ThreadCardUtils.jumpToPB((vr4) w56Var, view2.getContext(), 2, false, ex.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o47(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.b = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.hr5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public void y(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void z(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cdo) == null) {
            this.d = cdo;
        }
    }

    public final void A(w56 w56Var, w56 w56Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, w56Var, w56Var2) == null) && (threadData = w56Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(w56Var2.a.getForumData().f())) {
            if (w56Var != null && (threadData2 = w56Var.a) != null && threadData2.getTid() != null && w56Var.a.getForumData() != null && w56Var.a.getForumData().f() != null && (!w56Var.a.getTid().equals(w56Var2.a.getTid()) || !w56Var.a.getForumData().f().equals(w56Var2.a.getForumData().f()))) {
                f67.f(w56Var2.a);
            }
            if (w56Var == null) {
                f67.f(w56Var2.a);
            }
        }
    }

    public final void x(View view2, w56 w56Var) {
        int i;
        StatisticItem v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, w56Var) == null) {
            int id = view2.getId();
            if (w56Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (w56Var.isVideoThreadType()) {
                    v = w56Var.y();
                } else {
                    v = w56Var.v();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(v));
                fr5.c().i("page_recommend", "clk_", v);
                i = 1;
                f67.b(w56Var.a, w56Var.o(), w56Var.m());
            } else {
                TiebaStatic.log(w56Var.i());
                fr5.c().i("page_recommend", "clk_", w56Var.i());
                i = 9;
            }
            if (i != 0) {
                f67.d(w56Var.a, this.a, w56Var.m(), i);
                f67.c(w56Var.a, w56Var.o(), w56Var.m(), 3);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w56.R = "c10705";
            w56.S = "c10730";
            w56.T = "c10731";
            w56.U = "c10704";
            w56.V = "c10755";
            w56.W = "c10710";
            w56.X = "c10736";
            w56.Y = "c10737";
            w56.Z = "c10711";
            w56.a0 = "c10758";
            w56.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: v */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity());
            bVar.o(new mx(this.b.getPageActivity()));
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w56 w56Var, ThreadCardViewHolder<w56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w56Var, threadCardViewHolder})) == null) {
            if (w56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w56Var.a != null) {
                w56Var.I(w56Var.position + 1);
                w56Var.a.statFloor = w56Var.m();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(w56Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                a56.b().a(w56Var.x());
                fr5.c().a(w56Var.x());
                f67.k(w56Var.a, this.a, w56Var.m());
                f67.j(w56Var.a, w56Var.o(), w56Var.m());
                A(threadCardViewHolder.a().h(), w56Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
