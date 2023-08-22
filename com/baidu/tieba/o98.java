package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o98 extends om<ap6, AutoVideoCardViewHolder<ap6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public hn c;
    public vy d;
    public h68 e;
    public jo6<ap6> f;

    /* loaded from: classes7.dex */
    public class a extends jo6<ap6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o98 b;

        public a(o98 o98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ap6 ap6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ap6Var) == null) && view2 != null && ap6Var != null && ap6Var.getThreadData() != null) {
                this.b.A(view2, ap6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !d48.b(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L))) {
                    d48.a(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L), ap6Var.u(), ap6Var.i(), ap6Var.h(), ap6Var.c(), JavaTypesHelper.toInt("3", 1), "video_tab", ap6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ o98 b;

        public b(o98 o98Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o98Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o98Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(w05 w05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, w05Var) != null) || w05Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (w05Var instanceof ap6) {
                w05Var.objType = 5;
                w98.f((ro6) w05Var);
                w98.c(w05Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            w98.f((ro6) w05Var);
            w98.c(w05Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o98 a;

        public c(o98 o98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o98Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof ap6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ap6 ap6Var = (ap6) bnVar;
                ap6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), ap6Var);
                }
                w98.c(ap6Var, view2.getContext(), 19, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o98(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, ap6 ap6Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, ap6Var) == null) && (vyVar = this.d) != null && vyVar.u() != null && this.d.u().getMainView() != null) {
            if (view2.getId() == this.d.u().getMainView().getId()) {
                w98.h(ap6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                w98.f(ap6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(h68 h68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h68Var) == null) {
            this.e = h68Var;
        }
    }

    public void F(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hnVar) == null) {
            this.c = hnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public AutoVideoCardViewHolder<ap6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.a.getPageActivity(), false);
            fx fxVar = new fx(this.a.getPageActivity());
            fxVar.B(new b(this, fxVar));
            this.d = fxVar;
            fxVar.q(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ap6 ap6Var, AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ap6Var, autoVideoCardViewHolder})) == null) {
            if (ap6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ap6Var.A(ap6Var.position + 1);
            autoVideoCardViewHolder.b().r(i);
            autoVideoCardViewHolder.y(z(ap6Var));
            w98.d(ap6Var);
            autoVideoCardViewHolder.f(ap6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vyVar = this.d) != null) {
            vyVar.z();
        }
    }

    public final yx9 z(ap6 ap6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ap6Var)) == null) {
            if (ap6Var != null) {
                yx9 yx9Var = new yx9();
                yx9Var.a = "19";
                yx9Var.c = ap6Var.g;
                if (ap6Var.getThreadData() != null) {
                    yx9Var.d = String.valueOf(ap6Var.getThreadData().getFid());
                    yx9Var.v = ap6Var.getThreadData().getNid();
                    if (ap6Var.getThreadData().getThreadVideoInfo() != null) {
                        yx9Var.m = ap6Var.getThreadData().getThreadVideoInfo().video_md5;
                        yx9Var.p = String.valueOf(ap6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                yx9Var.k = ap6Var.e();
                yx9Var.f = ap6Var.i();
                yx9Var.l = ap6Var.c();
                yx9Var.h = ap6Var.u();
                yx9Var.e = TbadkCoreApplication.getCurrentAccount();
                yx9Var.q = String.valueOf(ap6Var.h());
                if (ap6Var.getThreadData() != null && ap6Var.getThreadData().getBaijiahaoData() != null) {
                    yx9Var.t = ap6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    yx9Var.u = ap6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return yx9Var;
                }
                return yx9Var;
            }
            return null;
        }
        return (yx9) invokeL.objValue;
    }
}
