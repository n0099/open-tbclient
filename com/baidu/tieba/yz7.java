package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yz7 extends bi<kqa, FrsLikeRecommendHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kqa a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ FrsLikeRecommendHolder c;
        public final /* synthetic */ yz7 d;

        public a(yz7 yz7Var, kqa kqaVar, ViewGroup viewGroup, FrsLikeRecommendHolder frsLikeRecommendHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, kqaVar, viewGroup, frsLikeRecommendHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yz7Var;
            this.a = kqaVar;
            this.b = viewGroup;
            this.c = frsLikeRecommendHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.d.getOnAdapterItemClickListener() != null) {
                this.d.getOnAdapterItemClickListener().b(view2, this.a, kqa.g, this.b, this.c.getAdapterPosition(), view2.getId());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yz7(@NonNull Context context) {
        super(context, kqa.g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: t */
    public FrsLikeRecommendHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new FrsLikeRecommendHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d039b, viewGroup, false));
        }
        return (FrsLikeRecommendHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.bi
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kqa kqaVar, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        u(i, view2, viewGroup, kqaVar, frsLikeRecommendHolder);
        return view2;
    }

    public View u(int i, View view2, ViewGroup viewGroup, kqa kqaVar, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kqaVar, frsLikeRecommendHolder})) == null) {
            if (kqaVar != null && frsLikeRecommendHolder != null) {
                frsLikeRecommendHolder.a(kqaVar);
                frsLikeRecommendHolder.c(new a(this, kqaVar, viewGroup, frsLikeRecommendHolder));
                frsLikeRecommendHolder.b();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
