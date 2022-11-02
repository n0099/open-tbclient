package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m57 extends jn<n46, CardViewHolder<i36>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public i36 d;
    public NEGFeedBackView.b e;
    public z36<n46> f;

    /* loaded from: classes5.dex */
    public class a extends z36<n46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m57 b;

        public a(m57 m57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, n46 n46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n46Var) == null) {
                int i = 2;
                if (this.b.d.w == view2) {
                    i = 1;
                } else if (view2 == this.b.d.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.d.K() == null || view2.getId() != this.b.d.K().getId()) && (this.b.d.M() == null || view2.getId() != this.b.d.M().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    v47.d(n46Var.a, this.b.a, n46Var.n(), i);
                }
                g57.k(view2, n46Var, this.b.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m57(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.e = null;
        this.f = new a(this);
        this.b = tbPageContext;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public CardViewHolder<i36> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            i36 i36Var = new i36(this.b, this.a);
            this.d = i36Var;
            i36Var.C(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.d.X(bdUniqueId);
            }
            return new CardViewHolder<>(this.d);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n46 n46Var, CardViewHolder<i36> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n46Var, cardViewHolder})) == null) {
            n46Var.I(n46Var.position + 1);
            n46Var.a.statFloor = n46Var.n();
            i36 a2 = cardViewHolder.a();
            a2.a0(i + 1);
            a2.l(n46Var);
            a2.n(this.f);
            a2.B(this.e);
            v47.i(n46Var.a, this.a, n46Var.n());
            g57.r(n46Var, this.c);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
