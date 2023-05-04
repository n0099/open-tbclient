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
import com.baidu.tieba.gy;
import com.baidu.tieba.ry;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ts7 extends vm<yi6, ThreadCardViewHolder<yi6>> implements qz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public on d;
    public NEGFeedBackView.b e;
    public ji6<yi6> f;

    /* loaded from: classes6.dex */
    public class a extends ji6<yi6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts7 b;

        public a(ts7 ts7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ts7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ji6
        /* renamed from: d */
        public void a(View view2, yi6 yi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yi6Var) == null) {
                ci6.b().d(true);
                if (view2 != null && yi6Var != null && yi6Var.getThreadData() != null && !StringUtils.isNull(yi6Var.getThreadData().getTid())) {
                    this.b.z(view2, yi6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts7 a;

        public b(ts7 ts7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof yi6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yi6 yi6Var = (yi6) inVar;
                yi6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), yi6Var);
                }
                ThreadCardUtils.jumpToPB((ax4) yi6Var, view2.getContext(), 2, false, vw.a((on) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ry.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void B(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onVar) == null) {
            this.d = onVar;
        }
    }

    @Override // com.baidu.tieba.qz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public final void C(yi6 yi6Var, yi6 yi6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yi6Var, yi6Var2) == null) && (threadData = yi6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(yi6Var2.a.getForumData().g())) {
            if (yi6Var != null && (threadData2 = yi6Var.a) != null && threadData2.getTid() != null && yi6Var.a.getForumData() != null && yi6Var.a.getForumData().g() != null && (!yi6Var.a.getTid().equals(yi6Var2.a.getTid()) || !yi6Var.a.getForumData().g().equals(yi6Var2.a.getForumData().g()))) {
                iu7.h(yi6Var2.a);
            }
            if (yi6Var == null) {
                iu7.h(yi6Var2.a);
            }
        }
    }

    public final void z(View view2, yi6 yi6Var) {
        int i;
        StatisticItem p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, yi6Var) == null) {
            int id = view2.getId();
            if (yi6Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (yi6Var.isVideoThreadType()) {
                    p = yi6Var.t();
                } else {
                    p = yi6Var.p();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p));
                oz5.c().i("page_recommend", "clk_", p);
                i = 1;
                iu7.b(yi6Var.a, yi6Var.j(), yi6Var.h());
            } else {
                TiebaStatic.log(yi6Var.f());
                oz5.c().i("page_recommend", "clk_", yi6Var.f());
                i = 9;
            }
            if (i != 0) {
                iu7.d(yi6Var.a, this.a, yi6Var.h(), i);
                iu7.c(yi6Var.a, yi6Var.j(), yi6Var.h(), 3);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            yi6.S = "c10705";
            yi6.T = "c10730";
            yi6.U = "c10731";
            yi6.V = "c10704";
            yi6.W = "c10755";
            yi6.X = "c10710";
            yi6.Y = "c10736";
            yi6.Z = "c10737";
            yi6.a0 = "c10711";
            yi6.b0 = "c10758";
            yi6.c0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            gy.b bVar = new gy.b(this.b.getPageActivity());
            bVar.o(new dx(this.b.getPageActivity()));
            gy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yi6 yi6Var, ThreadCardViewHolder<yi6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yi6Var, threadCardViewHolder})) == null) {
            if (yi6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yi6Var.a != null) {
                if (i == 0) {
                    ki9.a("main", true);
                }
                yi6Var.B(yi6Var.position + 1);
                yi6Var.a.statFloor = yi6Var.h();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(yi6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                ci6.b().a(yi6Var.r());
                oz5.c().a(yi6Var.r());
                iu7.p(yi6Var.a, this.a, yi6Var.h());
                iu7.o(yi6Var.a, yi6Var.j(), yi6Var.h());
                C(threadCardViewHolder.a().h(), yi6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
