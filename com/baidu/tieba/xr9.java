package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.ay;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Scopes;
/* loaded from: classes8.dex */
public class xr9 extends ln<lq6, AutoVideoCardViewHolder<lq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public up6<lq6> g;

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) && view2 != null && lq6Var != null && lq6Var.getThreadData() != null) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                    if (id == R.id.operable_video_container) {
                        xq9.a(view2, lq6Var, 4);
                        return;
                    } else if (id == R.id.forum_name_text) {
                        xq9.a(view2, lq6Var, 7);
                        return;
                    } else {
                        return;
                    }
                }
                xq9.a(view2, lq6Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && view2 != null && t15Var != null && view2.getId() != -1) {
                int id = view2.getId();
                if (id == R.id.user_name || id == R.id.user_avatar) {
                    xq9.a(view2, t15Var, 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr9 a;

        public c(xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof lq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lq6 lq6Var = (lq6) ynVar;
                lq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), lq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) lq6Var, view2.getContext(), 4, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public d(xr9 xr9Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(by.a((eo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = 0;
        this.e = 0;
        this.g = new a(this);
        this.b = tbPageContext;
        t();
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.e = i;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            kq6.j0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.r(this.a);
            ayVar.h(1024);
            ayVar.h(32768);
            int i = this.d;
            if (i > 0) {
                ayVar.g(i);
            }
            ayVar.z(false);
            ayVar.D(false);
            ayVar.A(new b(this));
            bVar.o(ayVar);
            zt9 zt9Var = new zt9(this.b.getPageActivity());
            zt9Var.r(this.a);
            zt9Var.setFrom(Scopes.PROFILE);
            zt9Var.setStageType(null);
            bVar.n(zt9Var);
            bVar.l().i(yi.g(this.mContext, R.dimen.tbds25));
            uy uyVar = new uy(this.b.getPageActivity());
            uyVar.E(true);
            bVar.h(uyVar);
            bVar.h(new iz(this.b.getPageActivity()));
            bVar.h(new bz(this.b.getPageActivity()));
            bVar.h(new iy(this.b.getPageActivity()));
            oz ozVar = new oz(this.b.getPageActivity());
            ozVar.g(32);
            ozVar.E(false);
            z15 z15Var = new z15();
            z15Var.b = 3;
            z15Var.h = 3;
            ozVar.D(z15Var);
            ozVar.F(8);
            ozVar.M("personalize_page");
            ozVar.L(6);
            ozVar.G(4);
            bVar.m(ozVar);
            mz i2 = bVar.i();
            AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
            autoVideoCardViewHolder.j(this.a);
            i2.q(this.g);
            i2.s(4);
            autoVideoCardViewHolder.s(this.e);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, autoVideoCardViewHolder})) == null) {
            if (lq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().b(this.c);
            }
            if (!this.f) {
                autoVideoCardViewHolder.t();
            }
            if (autoVideoCardViewHolder.b().f() instanceof oz) {
                ((oz) autoVideoCardViewHolder.b().f()).J(new d(this, viewGroup, view2, i));
            }
            autoVideoCardViewHolder.f(lq6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.g);
            xq9.b(lq6Var);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
