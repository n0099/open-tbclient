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
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.sw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vv6 extends cn<w06, AutoVideoCardViewHolder<w06>> implements xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public vn e;
    public my f;
    public j06<w06> g;

    /* loaded from: classes6.dex */
    public class a extends j06<w06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv6 b;

        public a(vv6 vv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, w06 w06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w06Var) == null) {
                c06.b().d(true);
                vl5.c().h("page_recommend", "show_");
                if (w06Var == null || w06Var.getThreadData() == null || StringUtils.isNull(w06Var.getThreadData().getTid())) {
                    return;
                }
                if (w06Var.getThreadData().middle_page_num <= 0) {
                    this.b.x(view2, w06Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(w06Var.N(w06Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ vv6 b;

        public b(vv6 vv6Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv6Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vv6Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.sw.a
        public void a(ho4 ho4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ho4Var) == null) || ho4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(ho4Var instanceof w06)) {
                ThreadCardUtils.jumpToPB(ho4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ho4Var.objType = 5;
            ThreadCardUtils.jumpToPB(ho4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv6 a;

        public c(vv6 vv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof in) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                in inVar = (in) pnVar;
                if (inVar.c() instanceof w06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    w06 w06Var = (w06) inVar.c();
                    w06Var.f = 1;
                    if (this.a.g != null) {
                        this.a.g.a(threadCardViewHolder.getView(), w06Var);
                    }
                    ThreadCardUtils.jumpToPB((ho4) w06Var, view2.getContext(), 1, false, ww.a((vn) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new py.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.c = tbPageContext;
        this.b = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: A */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, w06 w06Var, AutoVideoCardViewHolder<w06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w06Var, autoVideoCardViewHolder})) == null) {
            if (w06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            w06Var.I(w06Var.position + 1);
            c06.b().a(w06Var.f("c12351"));
            autoVideoCardViewHolder.a().q(i);
            w06Var.T = 0;
            autoVideoCardViewHolder.u(w(w06Var));
            if (autoVideoCardViewHolder.a() instanceof wl5) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(w06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w06 w06Var, AutoVideoCardViewHolder<w06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w06Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void C(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vnVar) == null) {
            this.e = vnVar;
        }
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? n06.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? n06.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? n06.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            return bdUniqueId != null ? bdUniqueId : n06.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final g98 w(w06 w06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, w06Var)) == null) {
            if (w06Var != null) {
                g98 g98Var = new g98();
                g98Var.a = "7";
                g98Var.c = w06Var.g;
                if (w06Var.getThreadData() != null) {
                    g98Var.d = String.valueOf(w06Var.getThreadData().getFid());
                    if (w06Var.getThreadData().getThreadVideoInfo() != null) {
                        g98Var.m = w06Var.getThreadData().getThreadVideoInfo().video_md5;
                        g98Var.p = String.valueOf(w06Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                g98Var.k = w06Var.h();
                g98Var.f = w06Var.r();
                g98Var.l = w06Var.c();
                g98Var.h = w06Var.D();
                g98Var.e = TbadkCoreApplication.getCurrentAccount();
                g98Var.q = String.valueOf(w06Var.n());
                return g98Var;
            }
            return null;
        }
        return (g98) invokeL.objValue;
    }

    public final void x(View view2, w06 w06Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, w06Var) == null) || (myVar = this.f) == null || myVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            vu6.b(view2, w06Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
            vu6.b(view2, w06Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: y */
    public AutoVideoCardViewHolder<w06> onCreateContentViewHolder(ViewGroup viewGroup, w06 w06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, w06Var)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity(), false);
            o17 o17Var = new o17(this.c.getPageActivity());
            o17Var.x(this.a);
            o17Var.u("concern_tab");
            o17Var.v(new b(this, o17Var));
            this.f = o17Var;
            bVar.n(o17Var);
            my myVar = this.f;
            if (myVar != null) {
                myVar.y("2001");
            }
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<w06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: z */
    public AutoVideoCardViewHolder<w06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
