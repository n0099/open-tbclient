package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jc9 extends ln<sc9, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yc9 a;
    public zc9 b;

    /* loaded from: classes6.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc9 a;

        public a(jc9 jc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ynVar instanceof sc9)) {
                return;
            }
            sc9 sc9Var = (sc9) ynVar;
            if (this.a.a != null) {
                this.a.a.d(sc9Var.a(), sc9Var.b(), i);
            }
            if (this.a.b != null) {
                this.a.b.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc9(Context context, BdUniqueId bdUniqueId) {
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

    public void A(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc9Var) == null) {
            this.b = zc9Var;
        }
    }

    public final void B(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestedForumStyleAMoreViewHolder) == null) {
            d85 d = d85.d(interestedForumStyleAMoreViewHolder.c);
            d.x(R.color.CAM_X0302);
            d.C(R.dimen.T_X07);
            d85.d(interestedForumStyleAMoreViewHolder.d).f(R.color.CAM_X0206);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public InterestedForumStyleAMoreViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new InterestedForumStyleAMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0460, viewGroup, false));
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public void z(yc9 yc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yc9Var) == null) {
            this.a = yc9Var;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sc9 sc9Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        x(i, view2, viewGroup, sc9Var, interestedForumStyleAMoreViewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, sc9 sc9Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sc9Var, interestedForumStyleAMoreViewHolder})) == null) {
            B(interestedForumStyleAMoreViewHolder);
            y(interestedForumStyleAMoreViewHolder, sc9Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, interestedForumStyleAMoreViewHolder, sc9Var) == null) {
            interestedForumStyleAMoreViewHolder.c.setText(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ad4));
            if (sc9Var.c()) {
                interestedForumStyleAMoreViewHolder.b.setVisibility(0);
            } else {
                interestedForumStyleAMoreViewHolder.b.setVisibility(8);
            }
        }
    }
}
