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
public class tv6 extends cn<u06, AutoVideoCardViewHolder<u06>> implements vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public vn e;
    public my f;
    public h06<u06> g;

    /* loaded from: classes6.dex */
    public class a extends h06<u06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv6 b;

        public a(tv6 tv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, u06 u06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, u06Var) == null) {
                a06.b().d(true);
                tl5.c().h("page_recommend", "show_");
                if (u06Var == null || u06Var.getThreadData() == null || StringUtils.isNull(u06Var.getThreadData().getTid())) {
                    return;
                }
                if (u06Var.getThreadData().middle_page_num <= 0) {
                    this.b.x(view2, u06Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(u06Var.N(u06Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ tv6 b;

        public b(tv6 tv6Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv6Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tv6Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.sw.a
        public void a(go4 go4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, go4Var) == null) || go4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(go4Var instanceof u06)) {
                ThreadCardUtils.jumpToPB(go4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            go4Var.objType = 5;
            ThreadCardUtils.jumpToPB(go4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv6 a;

        public c(tv6 tv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof in) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                in inVar = (in) pnVar;
                if (inVar.c() instanceof u06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    u06 u06Var = (u06) inVar.c();
                    u06Var.f = 1;
                    if (this.a.g != null) {
                        this.a.g.a(threadCardViewHolder.getView(), u06Var);
                    }
                    ThreadCardUtils.jumpToPB((go4) u06Var, view2.getContext(), 1, false, ww.a((vn) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new py.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tv6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, u06 u06Var, AutoVideoCardViewHolder<u06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u06Var, autoVideoCardViewHolder})) == null) {
            if (u06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            u06Var.I(u06Var.position + 1);
            a06.b().a(u06Var.f("c12351"));
            autoVideoCardViewHolder.a().q(i);
            u06Var.T = 0;
            autoVideoCardViewHolder.u(w(u06Var));
            if (autoVideoCardViewHolder.a() instanceof ul5) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(u06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u06 u06Var, AutoVideoCardViewHolder<u06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u06Var, autoVideoCardViewHolder})) == null) {
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

    @Override // com.baidu.tieba.vl5
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? l06.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l06.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l06.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            return bdUniqueId != null ? bdUniqueId : l06.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final e98 w(u06 u06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, u06Var)) == null) {
            if (u06Var != null) {
                e98 e98Var = new e98();
                e98Var.a = "7";
                e98Var.c = u06Var.g;
                if (u06Var.getThreadData() != null) {
                    e98Var.d = String.valueOf(u06Var.getThreadData().getFid());
                    if (u06Var.getThreadData().getThreadVideoInfo() != null) {
                        e98Var.m = u06Var.getThreadData().getThreadVideoInfo().video_md5;
                        e98Var.p = String.valueOf(u06Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                e98Var.k = u06Var.h();
                e98Var.f = u06Var.r();
                e98Var.l = u06Var.c();
                e98Var.h = u06Var.D();
                e98Var.e = TbadkCoreApplication.getCurrentAccount();
                e98Var.q = String.valueOf(u06Var.n());
                return e98Var;
            }
            return null;
        }
        return (e98) invokeL.objValue;
    }

    public final void x(View view2, u06 u06Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, u06Var) == null) || (myVar = this.f) == null || myVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            tu6.b(view2, u06Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
            tu6.b(view2, u06Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: y */
    public AutoVideoCardViewHolder<u06> onCreateContentViewHolder(ViewGroup viewGroup, u06 u06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, u06Var)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity(), false);
            m17 m17Var = new m17(this.c.getPageActivity());
            m17Var.x(this.a);
            m17Var.u("concern_tab");
            m17Var.v(new b(this, m17Var));
            this.f = m17Var;
            bVar.n(m17Var);
            my myVar = this.f;
            if (myVar != null) {
                myVar.y("2001");
            }
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<u06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
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
    public AutoVideoCardViewHolder<u06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
