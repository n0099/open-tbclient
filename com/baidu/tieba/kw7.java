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
import com.baidu.tieba.lz;
import com.baidu.tieba.wx;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kw7 extends kn<hp6, AutoVideoCardViewHolder<hp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public Cdo d;
    public tz e;
    public qo6<hp6> f;

    /* loaded from: classes6.dex */
    public class a extends qo6<hp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw7 b;

        public a(kw7 kw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, hp6 hp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hp6Var) == null) {
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (hp6Var != null && hp6Var.getThreadData() != null && !StringUtils.isNull(hp6Var.getThreadData().getTid())) {
                    if (hp6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, hp6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(hp6Var.J(hp6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ kw7 b;

        public b(kw7 kw7Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kw7Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l15Var) != null) || l15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (l15Var instanceof hp6) {
                l15Var.objType = 5;
                ThreadCardUtils.jumpToPB(l15Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(l15Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw7 a;

        public c(kw7 kw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kw7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof hp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                hp6 hp6Var = (hp6) xnVar;
                hp6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), hp6Var);
                }
                ThreadCardUtils.jumpToPB((l15) hp6Var, view2.getContext(), 1, false, ay.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kw7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void z(View view2, hp6 hp6Var) {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, hp6Var) == null) && (tzVar = this.e) != null && tzVar.t() != null && this.e.t().getMainView() != null) {
            if (view2.getId() == this.e.t().getMainView().getId()) {
                kv7.b(view2, hp6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                kv7.b(view2, hp6Var, 2);
            }
        }
    }

    public void C(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cdo) == null) {
            this.d = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public AutoVideoCardViewHolder<hp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            j28 j28Var = new j28(this.b.getPageActivity());
            j28Var.C(this.a);
            j28Var.setFrom("concern_tab");
            j28Var.A(new b(this, j28Var));
            this.e = j28Var;
            bVar.n(j28Var);
            tz tzVar = this.e;
            if (tzVar != null) {
                tzVar.setStageType("2001");
            }
            lz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.f);
            k.s(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final to9 y(hp6 hp6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hp6Var)) == null) {
            if (hp6Var != null) {
                to9 to9Var = new to9();
                to9Var.a = "7";
                to9Var.c = hp6Var.g;
                if (hp6Var.getThreadData() != null) {
                    to9Var.d = String.valueOf(hp6Var.getThreadData().getFid());
                    if (hp6Var.getThreadData().getThreadVideoInfo() != null) {
                        to9Var.m = hp6Var.getThreadData().getThreadVideoInfo().video_md5;
                        to9Var.p = String.valueOf(hp6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                to9Var.k = hp6Var.e();
                to9Var.f = hp6Var.k();
                to9Var.l = hp6Var.c();
                to9Var.h = hp6Var.w();
                to9Var.e = TbadkCoreApplication.getCurrentAccount();
                to9Var.q = String.valueOf(hp6Var.i());
                return to9Var;
            }
            return null;
        }
        return (to9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hp6 hp6Var, AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hp6Var, autoVideoCardViewHolder})) == null) {
            if (hp6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hp6Var.B(hp6Var.position + 1);
            jo6.b().a(hp6Var.d("c12351"));
            autoVideoCardViewHolder.a().r(i);
            hp6Var.f1115T = 0;
            autoVideoCardViewHolder.x(y(hp6Var));
            if (autoVideoCardViewHolder.a() instanceof o56) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(hp6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
