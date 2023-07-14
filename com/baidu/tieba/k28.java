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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k28 extends ln<lq6, AutoVideoCardViewHolder<lq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public eo c;
    public uz d;
    public int e;
    public up6<lq6> f;

    /* loaded from: classes6.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k28 b;

        public a(k28 k28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) {
                this.b.x(view2, lq6Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k28 a;

        public b(k28 k28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k28Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof lq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lq6 lq6Var = (lq6) ynVar;
                lq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), lq6Var);
                }
                u28.b(lq6Var, view2.getContext(), 18, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k28(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void x(View view2, lq6 lq6Var) {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, lq6Var) == null) && (uzVar = this.d) != null && uzVar.x() != null && this.d.x().getMainView() != null) {
            if (view2.getId() == this.d.x().getMainView().getId()) {
                u28.d(lq6Var, this.e);
            } else if (view2.getId() == R.id.thread_card_root) {
                u28.d(lq6Var, this.e);
            }
        }
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = i;
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eoVar) == null) {
            this.c = eoVar;
        }
    }

    public void onPause() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (uzVar = this.d) != null) {
            uzVar.A();
        }
    }

    public final av9 u(lq6 lq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, lq6Var)) == null) {
            if (lq6Var != null) {
                av9 av9Var = new av9();
                av9Var.a = "17";
                av9Var.c = lq6Var.g;
                if (lq6Var.getThreadData() != null) {
                    av9Var.d = String.valueOf(lq6Var.getThreadData().getFid());
                    if (lq6Var.getThreadData().getThreadVideoInfo() != null) {
                        av9Var.m = lq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        av9Var.p = String.valueOf(lq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                av9Var.k = lq6Var.e();
                av9Var.f = lq6Var.i();
                av9Var.l = lq6Var.c();
                av9Var.h = lq6Var.v();
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                av9Var.q = String.valueOf(lq6Var.h());
                av9Var.r = String.valueOf(this.e);
                return av9Var;
            }
            return null;
        }
        return (av9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.a.getPageActivity(), false);
            dz dzVar = new dz(this.a.getPageActivity());
            this.d = dzVar;
            dzVar.r(this.b);
            this.d.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
            this.d.setStageType("2001");
            bVar.n(this.d);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.b);
            k.q(this.f);
            k.s(18);
            setOnAdapterItemClickListener(new b(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, autoVideoCardViewHolder})) == null) {
            if (lq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            autoVideoCardViewHolder.b().r(i);
            u28.c(lq6Var, this.e);
            autoVideoCardViewHolder.y(u(lq6Var));
            autoVideoCardViewHolder.f(lq6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
