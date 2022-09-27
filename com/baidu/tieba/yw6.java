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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yw6 extends qn<s26, ThreadCardViewHolder<s26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public jo d;
    public i26<s26> e;

    /* loaded from: classes6.dex */
    public class a extends i26<s26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw6 b;

        public a(yw6 yw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, s26 s26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, s26Var) == null) {
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (view2 == null || s26Var == null || s26Var.getThreadData() == null || StringUtils.isNull(s26Var.getThreadData().getTid())) {
                    return;
                }
                this.b.x(view2, s26Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw6 a;

        public b(yw6 yw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.u(view2, cdo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public final void u(View view2, Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, cdo) == null) && (cdo instanceof s26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            s26 s26Var = (s26) cdo;
            s26Var.f = 1;
            ThreadCardUtils.jumpToPB((yq4) s26Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new dz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public ThreadCardViewHolder<s26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity());
            jx jxVar = new jx(this.b.getPageActivity());
            jxVar.u(this.a);
            jxVar.w(this.b);
            bVar.o(jxVar);
            bVar.n(new hx(this.b.getPageActivity()));
            bVar.h(new qx(this.b.getPageActivity()));
            uy uyVar = new uy(this.b.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 1;
            er4Var.h = 1;
            uyVar.w(er4Var);
            uyVar.y(9);
            uyVar.D(4);
            uyVar.z(1);
            uyVar.x(false);
            bVar.m(uyVar);
            bVar.l().h(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<s26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, s26 s26Var, ThreadCardViewHolder<s26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, s26Var, threadCardViewHolder})) == null) {
            if (s26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            s26Var.I(s26Var.position + 1);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.c);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.j();
            threadCardViewHolder.e(s26Var);
            b26.b().a(s26Var.f("c12351"));
            threadCardViewHolder.a().p(this.e);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(View view2, s26 s26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, s26Var) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092180) {
                sw6.b(view2, s26Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f092488 || id == R.id.obfuscated_res_0x7f0924b6) {
                sw6.b(view2, s26Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090718 || id == R.id.obfuscated_res_0x7f0903f0) {
                sw6.b(view2, s26Var, 3);
            }
        }
    }

    public void y(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, joVar) == null) {
            this.d = joVar;
        }
    }
}
