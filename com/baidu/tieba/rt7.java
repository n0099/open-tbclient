package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.bu;
import com.baidu.tieba.ns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rt7 extends ht7 implements vl6, c18, s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ rt7 b;

        public a(rt7 rt7Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt7Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rt7Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                lt5.b(3, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ rt7 b;

        public b(rt7 rt7Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt7Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rt7Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                lt5.b(3, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ru {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ rt7 b;

        public c(rt7 rt7Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt7Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rt7Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ru
        public void a(bw4 bw4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (bw4Var.getThreadData().originalThreadData.r != null) {
                    if (bw4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                lt5.a(3, z, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: U */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.l.getPageActivity());
            iu iuVar = new iu(this.l.getPageActivity());
            N(bVar);
            K(bVar, R.dimen.tbds38);
            wt wtVar = new wt(this.l);
            wtVar.q(Boolean.TRUE);
            wtVar.setFrom("frs");
            wtVar.B(true);
            wtVar.C(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(wtVar);
            wtVar.A(new a(this, iuVar));
            iuVar.q(Boolean.TRUE);
            iuVar.setFrom("frs");
            iuVar.B(new b(this, iuVar));
            iuVar.C(new c(this, iuVar));
            bVar.h(iuVar);
            J(bVar, this.o);
            M(bVar);
            ThreadCardViewHolder I = I(bVar, viewGroup, this.p, this.s);
            I.p();
            return I;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
