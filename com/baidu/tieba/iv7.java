package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iv7 extends lh<mk6, ThreadCardViewHolder<mk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ei d;
    public bk6<mk6> e;

    /* loaded from: classes6.dex */
    public class a extends bk6<mk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv7 b;

        public a(iv7 iv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, mk6 mk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mk6Var) == null) {
                tj6.b().d(true);
                wz5.c().h("page_recommend", "show_");
                if (view2 != null && mk6Var != null && mk6Var.getThreadData() != null && !StringUtils.isNull(mk6Var.getThreadData().getTid())) {
                    this.b.z(view2, mk6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv7 a;

        public b(iv7 iv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.u(view2, yhVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public void A(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eiVar) == null) {
            this.d = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final void u(View view2, yh yhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, yhVar) == null) && (yhVar instanceof mk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            mk6 mk6Var = (mk6) yhVar;
            mk6Var.f = 1;
            ThreadCardUtils.jumpToPB((jv4) mk6Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).a().q(new vt.a(1));
        }
    }

    public final void z(View view2, mk6 mk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, mk6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                dv7.b(view2, mk6Var, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    dv7.b(view2, mk6Var, 3);
                }
            } else {
                dv7.b(view2, mk6Var, 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: x */
    public ThreadCardViewHolder<mk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity());
            zr zrVar = new zr(this.b.getPageActivity());
            zrVar.q(this.a);
            zrVar.C(this.b);
            bVar.o(zrVar);
            bVar.n(new xr(this.b.getPageActivity()));
            bVar.h(new hs(this.b.getPageActivity()));
            mt mtVar = new mt(this.b.getPageActivity());
            pv4 pv4Var = new pv4();
            pv4Var.b = 1;
            pv4Var.h = 1;
            mtVar.E(pv4Var);
            mtVar.G(9);
            mtVar.L(4);
            mtVar.H(1);
            mtVar.F(false);
            bVar.m(mtVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            kt k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<mk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mk6 mk6Var, ThreadCardViewHolder<mk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mk6Var, threadCardViewHolder})) == null) {
            if (mk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                mk6Var.A(mk6Var.position + 1);
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.k();
                threadCardViewHolder.e(mk6Var);
                tj6.b().a(mk6Var.d("c12351"));
                threadCardViewHolder.a().r(this.e);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
