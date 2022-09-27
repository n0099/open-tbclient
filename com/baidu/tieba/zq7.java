package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zq7 extends rq7<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId c;
    public TbPageContext<?> d;
    public String e;
    public boolean f;
    public i26<x26> g;

    /* loaded from: classes6.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq7 b;

        public a(zq7 zq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) {
                oq7.b(this.b, x26Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(zq7 zq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(yq4 yq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yq4Var, view2) == null) || yq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092488) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq7 a;

        public c(zq7 zq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), x26Var);
                }
                ThreadCardUtils.jumpToPB(x26Var, view2.getContext(), 17, false, this.a.b.getOrignalPage().B1(), this.a.s() ? "3" : "2");
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zq7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = true;
        this.g = new a(this);
        this.d = tbPageContext;
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public ThreadCardViewHolder<x26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.d.getPageActivity());
            jx jxVar = new jx(this.d.getPageActivity());
            jxVar.u(this.c);
            jxVar.c(128);
            jxVar.d(1024);
            jxVar.t(new b(this));
            bVar.o(jxVar);
            xy xyVar = new xy(this.d.getPageActivity());
            bVar.n(xyVar);
            xyVar.v(2);
            bVar.h(new wy(this.d.getPageActivity()));
            bVar.h(new qx(this.d.getPageActivity()));
            ux uxVar = new ux(this.d.getPageActivity());
            uxVar.y(this.f);
            uxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(uxVar);
            uy uyVar = new uy(this.d.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 9;
            er4Var.h = 9;
            uyVar.w(er4Var);
            uyVar.y(9);
            uyVar.D(4);
            uyVar.z(17);
            uyVar.x(false);
            bVar.m(uyVar);
            sy i = bVar.i();
            i.r(17);
            ThreadCardViewHolder<x26> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.c);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x26 x26Var, ThreadCardViewHolder<x26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            threadCardViewHolder.a().b(this.e);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.d, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.g);
            oq7.c(this, x26Var);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
