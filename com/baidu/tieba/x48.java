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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x48 extends lh<sk6, AutoVideoCardViewHolder<sk6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public ei c;
    public st d;
    public f28 e;
    public bk6<sk6> f;

    /* loaded from: classes8.dex */
    public class a extends bk6<sk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x48 b;

        public a(x48 x48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, sk6 sk6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sk6Var) == null) && view2 != null && sk6Var != null && sk6Var.getThreadData() != null) {
                this.b.A(view2, sk6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !b08.b(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L))) {
                    b08.a(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L), sk6Var.u(), sk6Var.i(), sk6Var.h(), sk6Var.c(), JavaTypesHelper.toInt("3", 1), "video_tab", sk6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st a;
        public final /* synthetic */ x48 b;

        public b(x48 x48Var, st stVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x48Var, stVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x48Var;
            this.a = stVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jv4Var) != null) || jv4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jv4Var instanceof sk6) {
                jv4Var.objType = 5;
                f58.f((jk6) jv4Var);
                f58.c(jv4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            f58.f((jk6) jv4Var);
            f58.c(jv4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x48 a;

        public c(x48 x48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x48Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof sk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sk6 sk6Var = (sk6) yhVar;
                sk6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), sk6Var);
                }
                f58.c(sk6Var, view2.getContext(), 19, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x48(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, sk6 sk6Var) {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, sk6Var) == null) && (stVar = this.d) != null && stVar.u() != null && this.d.u().getMainView() != null) {
            if (view2.getId() == this.d.u().getMainView().getId()) {
                f58.h(sk6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                f58.f(sk6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f28Var) == null) {
            this.e = f28Var;
        }
    }

    public void F(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eiVar) == null) {
            this.c = eiVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: B */
    public AutoVideoCardViewHolder<sk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.a.getPageActivity(), false);
            cs csVar = new cs(this.a.getPageActivity());
            csVar.B(new b(this, csVar));
            this.d = csVar;
            csVar.q(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            kt k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.r(this.f);
            k.t(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sk6 sk6Var, AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sk6Var, autoVideoCardViewHolder})) == null) {
            if (sk6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            sk6Var.A(sk6Var.position + 1);
            autoVideoCardViewHolder.a().s(i);
            autoVideoCardViewHolder.y(z(sk6Var));
            f58.d(sk6Var);
            autoVideoCardViewHolder.e(sk6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (stVar = this.d) != null) {
            stVar.z();
        }
    }

    public final aw9 z(sk6 sk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sk6Var)) == null) {
            if (sk6Var != null) {
                aw9 aw9Var = new aw9();
                aw9Var.a = "19";
                aw9Var.c = sk6Var.g;
                if (sk6Var.getThreadData() != null) {
                    aw9Var.d = String.valueOf(sk6Var.getThreadData().getFid());
                    aw9Var.v = sk6Var.getThreadData().getNid();
                    if (sk6Var.getThreadData().getThreadVideoInfo() != null) {
                        aw9Var.m = sk6Var.getThreadData().getThreadVideoInfo().video_md5;
                        aw9Var.p = String.valueOf(sk6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                aw9Var.k = sk6Var.e();
                aw9Var.f = sk6Var.i();
                aw9Var.l = sk6Var.c();
                aw9Var.h = sk6Var.u();
                aw9Var.e = TbadkCoreApplication.getCurrentAccount();
                aw9Var.q = String.valueOf(sk6Var.h());
                if (sk6Var.getThreadData() != null && sk6Var.getThreadData().getBaijiahaoData() != null) {
                    aw9Var.t = sk6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    aw9Var.u = sk6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return aw9Var;
                }
                return aw9Var;
            }
            return null;
        }
        return (aw9) invokeL.objValue;
    }
}
