package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ns9 extends ci<ws9, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ct9 a;
    public dt9 b;

    /* loaded from: classes7.dex */
    public class a implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ns9 a;

        public a(ns9 ns9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ns9Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(piVar instanceof ws9)) {
                return;
            }
            ws9 ws9Var = (ws9) piVar;
            if (this.a.a != null) {
                this.a.a.d(ws9Var.a(), ws9Var.b(), i);
            }
            if (this.a.b != null) {
                this.a.b.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns9(Context context, BdUniqueId bdUniqueId) {
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

    public void A(ct9 ct9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ct9Var) == null) {
            this.a = ct9Var;
        }
    }

    public void B(dt9 dt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dt9Var) == null) {
            this.b = dt9Var;
        }
    }

    public final void C(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interestedForumStyleAMoreViewHolder) == null) {
            EMManager.from(interestedForumStyleAMoreViewHolder.c).setTextColor(R.color.CAM_X0302).setTextSize(R.dimen.T_X07);
            EMManager.from(interestedForumStyleAMoreViewHolder.d).setBackGroundColor(R.color.CAM_X0206);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public InterestedForumStyleAMoreViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new InterestedForumStyleAMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d048b, viewGroup, false));
        }
        return (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ws9 ws9Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        y(i, view2, viewGroup, ws9Var, interestedForumStyleAMoreViewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, ws9 ws9Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ws9Var, interestedForumStyleAMoreViewHolder})) == null) {
            C(interestedForumStyleAMoreViewHolder);
            z(interestedForumStyleAMoreViewHolder, ws9Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, ws9 ws9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, interestedForumStyleAMoreViewHolder, ws9Var) == null) {
            interestedForumStyleAMoreViewHolder.c.setText(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0b11));
            if (ws9Var.c()) {
                interestedForumStyleAMoreViewHolder.b.setVisibility(0);
            } else {
                interestedForumStyleAMoreViewHolder.b.setVisibility(8);
            }
        }
    }
}
