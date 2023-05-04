package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.gy;
import com.baidu.tieba.rw;
import com.baidu.tieba.ry;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wo7 extends vm<zi6, AutoVideoCardViewHolder<zi6>> implements qz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public on d;
    public oy e;
    public ji6<zi6> f;

    /* loaded from: classes6.dex */
    public class a extends ji6<zi6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo7 b;

        public a(wo7 wo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ji6
        /* renamed from: d */
        public void a(View view2, zi6 zi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zi6Var) == null) {
                ci6.b().d(true);
                oz5.c().h("page_recommend", "show_");
                if (zi6Var != null && zi6Var.getThreadData() != null && !StringUtils.isNull(zi6Var.getThreadData().getTid())) {
                    if (zi6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, zi6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zi6Var.J(zi6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy a;
        public final /* synthetic */ wo7 b;

        public b(wo7 wo7Var, oy oyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo7Var, oyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wo7Var;
            this.a = oyVar;
        }

        @Override // com.baidu.tieba.rw.a
        public void a(ax4 ax4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ax4Var) != null) || ax4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (ax4Var instanceof zi6) {
                ax4Var.objType = 5;
                ThreadCardUtils.jumpToPB(ax4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(ax4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo7 a;

        public c(wo7 wo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof zi6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zi6 zi6Var = (zi6) inVar;
                zi6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), zi6Var);
                }
                ThreadCardUtils.jumpToPB((ax4) zi6Var, view2.getContext(), 1, false, vw.a((on) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ry.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wo7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    }

    public final void z(View view2, zi6 zi6Var) {
        oy oyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, zi6Var) == null) && (oyVar = this.e) != null && oyVar.t() != null && this.e.t().getMainView() != null) {
            if (view2.getId() == this.e.t().getMainView().getId()) {
                vn7.b(view2, zi6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                vn7.b(view2, zi6Var, 2);
            }
        }
    }

    public void C(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onVar) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: A */
    public AutoVideoCardViewHolder<zi6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            gy.b bVar = new gy.b(this.b.getPageActivity(), false);
            nu7 nu7Var = new nu7(this.b.getPageActivity());
            nu7Var.C(this.a);
            nu7Var.setFrom("concern_tab");
            nu7Var.A(new b(this, nu7Var));
            this.e = nu7Var;
            bVar.n(nu7Var);
            oy oyVar = this.e;
            if (oyVar != null) {
                oyVar.setStageType("2001");
            }
            gy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<zi6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.f);
            k.s(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final va9 y(zi6 zi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zi6Var)) == null) {
            if (zi6Var != null) {
                va9 va9Var = new va9();
                va9Var.a = "7";
                va9Var.c = zi6Var.g;
                if (zi6Var.getThreadData() != null) {
                    va9Var.d = String.valueOf(zi6Var.getThreadData().getFid());
                    if (zi6Var.getThreadData().getThreadVideoInfo() != null) {
                        va9Var.m = zi6Var.getThreadData().getThreadVideoInfo().video_md5;
                        va9Var.p = String.valueOf(zi6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                va9Var.k = zi6Var.e();
                va9Var.f = zi6Var.j();
                va9Var.l = zi6Var.c();
                va9Var.h = zi6Var.v();
                va9Var.e = TbadkCoreApplication.getCurrentAccount();
                va9Var.q = String.valueOf(zi6Var.h());
                return va9Var;
            }
            return null;
        }
        return (va9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zi6 zi6Var, AutoVideoCardViewHolder<zi6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zi6Var, autoVideoCardViewHolder})) == null) {
            if (zi6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            zi6Var.B(zi6Var.position + 1);
            ci6.b().a(zi6Var.d("c12351"));
            autoVideoCardViewHolder.a().r(i);
            zi6Var.T = 0;
            autoVideoCardViewHolder.u(y(zi6Var));
            if (autoVideoCardViewHolder.a() instanceof pz5) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(zi6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
