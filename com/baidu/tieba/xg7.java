package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.kt;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xg7 extends ng7 implements zj6, io7, yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ xg7 b;

        public a(xg7 xg7Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg7Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg7Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                rr5.b(3, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ xg7 b;

        public b(xg7 xg7Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg7Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg7Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                rr5.b(3, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements au {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ xg7 b;

        public c(xg7 xg7Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg7Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg7Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.au
        public void a(jv4 jv4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (jv4Var.getThreadData().originalThreadData.r != null) {
                    if (jv4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                rr5.a(3, z, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    @Override // com.baidu.tieba.lh
    /* renamed from: T */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.l.getPageActivity());
            rt rtVar = new rt(this.l.getPageActivity());
            M(bVar);
            J(bVar, R.dimen.tbds38);
            ft ftVar = new ft(this.l);
            ftVar.s(Boolean.TRUE);
            ftVar.setFrom("frs");
            ftVar.D(true);
            ftVar.E(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(ftVar);
            ftVar.C(new a(this, rtVar));
            rtVar.s(Boolean.TRUE);
            rtVar.setFrom("frs");
            rtVar.D(new b(this, rtVar));
            rtVar.E(new c(this, rtVar));
            bVar.h(rtVar);
            I(bVar, this.o);
            L(bVar);
            ThreadCardViewHolder H = H(bVar, viewGroup, this.p, this.s);
            H.o();
            return H;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
