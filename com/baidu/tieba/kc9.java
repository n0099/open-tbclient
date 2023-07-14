package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleATitleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc9 extends ln<tc9, InterestedForumStyleATitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(kc9 kc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ynVar instanceof tc9)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kc9(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.mContext = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: s */
    public InterestedForumStyleATitleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new InterestedForumStyleATitleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0461, viewGroup, false));
        }
        return (InterestedForumStyleATitleViewHolder) invokeL.objValue;
    }

    public final void x(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interestedForumStyleATitleViewHolder) == null) {
            d85 d = d85.d(interestedForumStyleATitleViewHolder.c);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X06);
            d.D(R.string.F_X02);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tc9 tc9Var, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        t(i, view2, viewGroup, tc9Var, interestedForumStyleATitleViewHolder);
        return view2;
    }

    public View t(int i, View view2, ViewGroup viewGroup, tc9 tc9Var, InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tc9Var, interestedForumStyleATitleViewHolder})) == null) {
            if (tc9Var == null) {
                return view2;
            }
            x(interestedForumStyleATitleViewHolder);
            u(interestedForumStyleATitleViewHolder, tc9Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void u(InterestedForumStyleATitleViewHolder interestedForumStyleATitleViewHolder, tc9 tc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleATitleViewHolder, tc9Var) == null) {
            interestedForumStyleATitleViewHolder.b.setDefaultResource(R.drawable.obfuscated_res_0x7f08094a);
            interestedForumStyleATitleViewHolder.b.N(tc9Var.a(), 10, false);
            interestedForumStyleATitleViewHolder.c.setText(tc9Var.b());
        }
    }
}
