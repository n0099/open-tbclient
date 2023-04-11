package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dy;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nm7 extends um<mh6, ThreadCardViewHolder<mh6>> implements py5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public nn d;
    public NEGFeedBackView.b e;
    public xg6<mh6> f;

    /* loaded from: classes5.dex */
    public class a extends xg6<mh6> {
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
        @Override // com.baidu.tieba.xg6
        /* renamed from: d */
        public void a(View view2, mh6 mh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mh6Var) == null) {
                qg6.b().d(true);
                if (view2 != null && mh6Var != null && mh6Var.getThreadData() != null && !StringUtils.isNull(mh6Var.getThreadData().getTid())) {
                    this.b.z(view2, mh6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements rn {
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

        @Override // com.baidu.tieba.rn
        public void b(View view2, hn hnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, hnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (hnVar instanceof mh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                mh6 mh6Var = (mh6) hnVar;
                mh6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), mh6Var);
                }
                ThreadCardUtils.jumpToPB((jw4) mh6Var, view2.getContext(), 2, false, tw.a((nn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nnVar) == null) {
            this.d = nnVar;
        }
    }

    @Override // com.baidu.tieba.py5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mh6.S = "c10705";
            mh6.T = "c10730";
            mh6.U = "c10731";
            mh6.V = "c10704";
            mh6.W = "c10755";
            mh6.X = "c10710";
            mh6.Y = "c10736";
            mh6.Z = "c10737";
            mh6.a0 = "c10711";
            mh6.b0 = "c10758";
            mh6.c0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity());
            bVar.o(new bx(this.b.getPageActivity()));
            dy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mh6 mh6Var, ThreadCardViewHolder<mh6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mh6Var, threadCardViewHolder})) == null) {
            if (mh6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && mh6Var.a != null) {
                mh6Var.E(mh6Var.position + 1);
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.p(false, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(mh6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                qg6.b().a(mh6Var.u());
                ny5.c().a(mh6Var.u());
                ms7.p(mh6Var.a, this.a, mh6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, mh6 mh6Var) {
        int i;
        StatisticItem s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, mh6Var) == null) {
            int id = view2.getId();
            if (mh6Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (mh6Var.isVideoThreadType()) {
                    s = mh6Var.v();
                } else {
                    s = mh6Var.s();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(s));
                ny5.c().i("page_concern", "clk_", s);
                i = 1;
            } else {
                TiebaStatic.log(mh6Var.f());
                ny5.c().i("page_concern", "clk_", mh6Var.f());
                i = 9;
            }
            if (i != 0) {
                ms7.d(mh6Var.a, this.a, mh6Var.i(), i);
            }
        }
    }
}
