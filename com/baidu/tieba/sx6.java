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
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sx6 extends qn<y26, AutoVideoCardViewHolder<y26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public jo e;
    public az f;
    public i26<y26> g;

    /* loaded from: classes5.dex */
    public class a extends i26<y26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx6 b;

        public a(sx6 sx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, y26 y26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, y26Var) == null) {
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (y26Var == null || y26Var.getThreadData() == null || StringUtils.isNull(y26Var.getThreadData().getTid())) {
                    return;
                }
                if (y26Var.getThreadData().middle_page_num <= 0) {
                    this.b.x(view2, y26Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(y26Var.N(y26Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ sx6 b;

        public b(sx6 sx6Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sx6Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(yq4Var instanceof y26)) {
                ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            yq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx6 a;

        public c(sx6 sx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof wn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wn wnVar = (wn) cdo;
                if (wnVar.c() instanceof y26) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    y26 y26Var = (y26) wnVar.c();
                    y26Var.f = 1;
                    if (this.a.g != null) {
                        this.a.g.a(threadCardViewHolder.getView(), y26Var);
                    }
                    ThreadCardUtils.jumpToPB((yq4) y26Var, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, y26 y26Var, AutoVideoCardViewHolder<y26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, y26Var, autoVideoCardViewHolder})) == null) {
            if (y26Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            y26Var.I(y26Var.position + 1);
            b26.b().a(y26Var.f("c12351"));
            autoVideoCardViewHolder.a().q(i);
            y26Var.T = 0;
            autoVideoCardViewHolder.u(w(y26Var));
            if (autoVideoCardViewHolder.a() instanceof so5) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(y26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, y26 y26Var, AutoVideoCardViewHolder<y26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, y26Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? p26.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? p26.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? p26.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            return bdUniqueId != null ? bdUniqueId : p26.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final ab8 w(y26 y26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, y26Var)) == null) {
            if (y26Var != null) {
                ab8 ab8Var = new ab8();
                ab8Var.a = "7";
                ab8Var.c = y26Var.g;
                if (y26Var.getThreadData() != null) {
                    ab8Var.d = String.valueOf(y26Var.getThreadData().getFid());
                    if (y26Var.getThreadData().getThreadVideoInfo() != null) {
                        ab8Var.m = y26Var.getThreadData().getThreadVideoInfo().video_md5;
                        ab8Var.p = String.valueOf(y26Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ab8Var.k = y26Var.h();
                ab8Var.f = y26Var.r();
                ab8Var.l = y26Var.c();
                ab8Var.h = y26Var.D();
                ab8Var.e = TbadkCoreApplication.getCurrentAccount();
                ab8Var.q = String.valueOf(y26Var.n());
                return ab8Var;
            }
            return null;
        }
        return (ab8) invokeL.objValue;
    }

    public final void x(View view2, y26 y26Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, y26Var) == null) || (azVar = this.f) == null || azVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            sw6.b(view2, y26Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092181) {
            sw6.b(view2, y26Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public AutoVideoCardViewHolder<y26> onCreateContentViewHolder(ViewGroup viewGroup, y26 y26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, y26Var)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity(), false);
            h37 h37Var = new h37(this.c.getPageActivity());
            h37Var.x(this.a);
            h37Var.u("concern_tab");
            h37Var.v(new b(this, h37Var));
            this.f = h37Var;
            bVar.n(h37Var);
            az azVar = this.f;
            if (azVar != null) {
                azVar.y("2001");
            }
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<y26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public AutoVideoCardViewHolder<y26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
