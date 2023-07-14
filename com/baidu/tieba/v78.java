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
/* loaded from: classes8.dex */
public class v78 extends ln<jq6, CardViewHolder<ep6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ep6 d;
    public NEGFeedBackView.b e;
    public up6<jq6> f;

    /* loaded from: classes8.dex */
    public class a extends up6<jq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v78 b;

        public a(v78 v78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, jq6 jq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, jq6Var) == null) {
                int i = 2;
                if (this.b.d.w == view2) {
                    i = 1;
                } else if (view2 == this.b.d.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.d.M() == null || view2.getId() != this.b.d.M().getId()) && (this.b.d.O() == null || view2.getId() != this.b.d.O().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    x68.d(jq6Var.a, this.b.a, jq6Var.h(), i);
                }
                p78.k(view2, jq6Var, this.b.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v78(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public CardViewHolder<ep6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ep6 ep6Var = new ep6(this.b, this.a);
            this.d = ep6Var;
            ep6Var.E(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.d.Z(bdUniqueId);
            }
            return new CardViewHolder<>(this.d);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jq6 jq6Var, CardViewHolder<ep6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jq6Var, cardViewHolder})) == null) {
            jq6Var.B(jq6Var.position + 1);
            jq6Var.a.statFloor = jq6Var.h();
            ep6 b = cardViewHolder.b();
            b.c0(i + 1);
            b.i(jq6Var);
            b.k(this.f);
            b.D(this.e);
            x68.p(jq6Var.a, this.a, jq6Var.h());
            p78.r(jq6Var, this.c);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
