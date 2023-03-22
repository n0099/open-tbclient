package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ol8 extends bl8<pl8, PbListAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ki8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol8(wp8 wp8Var) {
        super(wp8Var, pl8.o);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wp8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: u */
    public PbListAlaRecommendVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbListAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d072e, (ViewGroup) null), this.a.M());
        }
        return (PbListAlaRecommendVH) invokeL.objValue;
    }

    public void y(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ki8Var) == null) {
            this.g = ki8Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pl8 pl8Var, PbListAlaRecommendVH pbListAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pl8Var, pbListAlaRecommendVH})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) pl8Var, (pl8) pbListAlaRecommendVH);
            if (pl8Var == null) {
                return null;
            }
            pbListAlaRecommendVH.b(pl8Var);
            pbListAlaRecommendVH.g(this.g);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
