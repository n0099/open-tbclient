package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jz6 extends ou6<q06, ThreadCardViewHolder<q06>> implements xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.b e;
    public vn f;
    public j06<q06> g;

    /* loaded from: classes4.dex */
    public class a extends j06<q06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 b;

        public a(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, q06 q06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, q06Var) == null) {
                c06.b().d(true);
                vl5.c().h("page_recommend", "show_");
                if (view2 == null || q06Var == null || q06Var.getThreadData() == null || StringUtils.isNull(q06Var.getThreadData().getTid())) {
                    return;
                }
                this.b.y(view2, q06Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 a;

        public b(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.v(view2, pnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jz6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.c = tbPageContext;
    }

    public void A(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vnVar) == null) {
            this.f = vnVar;
        }
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public final void v(View view2, pn pnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, pnVar) == null) && (pnVar instanceof q06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            q06 q06Var = (q06) pnVar;
            q06Var.f = 1;
            ThreadCardUtils.jumpToPB((ho4) q06Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new py.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: w */
    public ThreadCardViewHolder<q06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity());
            vw vwVar = new vw(this.c.getPageActivity());
            vwVar.u(this.b);
            vwVar.w(this.c);
            bVar.o(vwVar);
            bVar.n(new tw(this.c.getPageActivity()));
            bVar.h(new cx(this.c.getPageActivity()));
            gy gyVar = new gy(this.c.getPageActivity());
            no4 no4Var = new no4();
            no4Var.b = 1;
            no4Var.h = 1;
            gyVar.w(no4Var);
            gyVar.y(1);
            gyVar.D(3);
            gyVar.z(2);
            gyVar.x(false);
            bVar.m(gyVar);
            bVar.l().h(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            ey k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder<q06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, q06 q06Var, ThreadCardViewHolder<q06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q06Var, threadCardViewHolder})) == null) {
            if (q06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            q06Var.I(q06Var.position + 1);
            q06Var.a.statFloor = q06Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.d);
            threadCardViewHolder.o(true).u(this.e);
            threadCardViewHolder.k(q06Var.showFollowBtn(), this.a);
            threadCardViewHolder.e(q06Var);
            threadCardViewHolder.a().p(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            c06.b().a(q06Var.B());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(View view2, q06 q06Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048583, this, view2, q06Var) != null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09212d) {
            TiebaStatic.log(q06Var.A());
        } else if (id == R.id.obfuscated_res_0x7f09242b || id == R.id.obfuscated_res_0x7f092459) {
            i = 2;
            if (i == 0) {
                j17.d(q06Var.a, this.b, q06Var.n(), i);
                return;
            }
            return;
        }
        i = 0;
        if (i == 0) {
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.e = bVar;
        }
    }
}
