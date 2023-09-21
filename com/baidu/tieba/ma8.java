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
public class ma8 extends om<jq6, AutoVideoCardViewHolder<jq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public hn c;
    public vy d;
    public u78 e;
    public sp6<jq6> f;

    /* loaded from: classes7.dex */
    public class a extends sp6<jq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma8 b;

        public a(ma8 ma8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ma8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sp6
        /* renamed from: d */
        public void a(View view2, jq6 jq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, jq6Var) == null) && view2 != null && jq6Var != null && jq6Var.getThreadData() != null) {
                this.b.A(view2, jq6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !q58.b(JavaTypesHelper.toLong(jq6Var.getThreadData().getTid(), 0L))) {
                    q58.a(JavaTypesHelper.toLong(jq6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(JavaTypesHelper.toLong(jq6Var.getThreadData().getTid(), 0L), jq6Var.u(), jq6Var.i(), jq6Var.h(), jq6Var.c(), JavaTypesHelper.toInt("3", 1), "video_tab", jq6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ ma8 b;

        public b(ma8 ma8Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ma8Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, b15Var) != null) || b15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (b15Var instanceof jq6) {
                b15Var.objType = 5;
                ua8.f((aq6) b15Var);
                ua8.c(b15Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            ua8.f((aq6) b15Var);
            ua8.c(b15Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma8 a;

        public c(ma8 ma8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma8Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof jq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                jq6 jq6Var = (jq6) bnVar;
                jq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), jq6Var);
                }
                ua8.c(jq6Var, view2.getContext(), 19, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ma8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, jq6 jq6Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, jq6Var) == null) && (vyVar = this.d) != null && vyVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                ua8.h(jq6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                ua8.f(jq6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(u78 u78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u78Var) == null) {
            this.e = u78Var;
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
    public AutoVideoCardViewHolder<jq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.a.getPageActivity(), false);
            fx fxVar = new fx(this.a.getPageActivity());
            fxVar.A(new b(this, fxVar));
            this.d = fxVar;
            fxVar.p(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<jq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
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
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jq6 jq6Var, AutoVideoCardViewHolder<jq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jq6Var, autoVideoCardViewHolder})) == null) {
            if (jq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            jq6Var.B(jq6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.x(z(jq6Var));
            ua8.d(jq6Var);
            autoVideoCardViewHolder.e(jq6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vyVar = this.d) != null) {
            vyVar.y();
        }
    }

    public final n1a z(jq6 jq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jq6Var)) == null) {
            if (jq6Var != null) {
                n1a n1aVar = new n1a();
                n1aVar.a = "19";
                n1aVar.c = jq6Var.g;
                if (jq6Var.getThreadData() != null) {
                    n1aVar.d = String.valueOf(jq6Var.getThreadData().getFid());
                    n1aVar.v = jq6Var.getThreadData().getNid();
                    if (jq6Var.getThreadData().getThreadVideoInfo() != null) {
                        n1aVar.m = jq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        n1aVar.p = String.valueOf(jq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                n1aVar.k = jq6Var.e();
                n1aVar.f = jq6Var.i();
                n1aVar.l = jq6Var.c();
                n1aVar.h = jq6Var.u();
                n1aVar.e = TbadkCoreApplication.getCurrentAccount();
                n1aVar.q = String.valueOf(jq6Var.h());
                if (jq6Var.getThreadData() != null && jq6Var.getThreadData().getBaijiahaoData() != null) {
                    n1aVar.t = jq6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    n1aVar.u = jq6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return n1aVar;
                }
                return n1aVar;
            }
            return null;
        }
        return (n1a) invokeL.objValue;
    }
}
