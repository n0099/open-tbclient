package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w57 extends qn<y26, AutoVideoCardViewHolder<y26>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public jo c;
    public az d;
    public y27 e;
    public i26<y26> f;

    /* loaded from: classes6.dex */
    public class a extends i26<y26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w57 b;

        public a(w57 w57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, y26 y26Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, y26Var) == null) || view2 == null || y26Var == null || y26Var.getThreadData() == null) {
                return;
            }
            this.b.y(view2, y26Var);
            if (this.b.e == null || !(view2.getTag() instanceof String) || c17.b(dh.g(y26Var.getThreadData().getTid(), 0L))) {
                return;
            }
            c17.a(dh.g(y26Var.getThreadData().getTid(), 0L));
            this.b.e.e(dh.g(y26Var.getThreadData().getTid(), 0L), y26Var.D(), y26Var.r(), y26Var.n(), y26Var.c(), dh.e("3", 1), "video_tab", y26Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ w57 b;

        public b(w57 w57Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w57Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w57Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (yq4Var instanceof y26) {
                yq4Var.objType = 5;
                e67.f((p26) yq4Var);
                e67.c(yq4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            e67.f((p26) yq4Var);
            e67.c(yq4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w57 a;

        public c(w57 w57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w57Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof y26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                y26 y26Var = (y26) cdo;
                y26Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), y26Var);
                }
                e67.c(y26Var, view2.getContext(), 19, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w57(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, y26 y26Var, AutoVideoCardViewHolder<y26> autoVideoCardViewHolder) {
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
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(x(y26Var));
            e67.d(y26Var);
            autoVideoCardViewHolder.e(y26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(y27 y27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y27Var) == null) {
            this.e = y27Var;
        }
    }

    public void D(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, joVar) == null) {
            this.c = joVar;
        }
    }

    public void onPause() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (azVar = this.d) == null) {
            return;
        }
        azVar.s();
    }

    public final ab8 x(y26 y26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, y26Var)) == null) {
            if (y26Var != null) {
                ab8 ab8Var = new ab8();
                ab8Var.a = "19";
                ab8Var.c = y26Var.g;
                if (y26Var.getThreadData() != null) {
                    ab8Var.d = String.valueOf(y26Var.getThreadData().getFid());
                    ab8Var.v = y26Var.getThreadData().getNid();
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
                if (y26Var.getThreadData() == null || y26Var.getThreadData().getBaijiahaoData() == null) {
                    return ab8Var;
                }
                ab8Var.t = y26Var.getThreadData().getBaijiahaoData().oriUgcNid;
                ab8Var.u = y26Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return ab8Var;
            }
            return null;
        }
        return (ab8) invokeL.objValue;
    }

    public final void y(View view2, y26 y26Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, y26Var) == null) || (azVar = this.d) == null || azVar.p() == null || this.d.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.d.p().getMainView().getId()) {
            e67.h(y26Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092181) {
            e67.f(y26Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public AutoVideoCardViewHolder<y26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.a.getPageActivity(), false);
            mx mxVar = new mx(this.a.getPageActivity());
            mxVar.v(new b(this, mxVar));
            this.d = mxVar;
            mxVar.x(this.b);
            this.d.u("video_tab");
            this.d.y("2001");
            bVar.n(this.d);
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<y26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.p(this.f);
            k.r(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
