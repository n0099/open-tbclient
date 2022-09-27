package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ly7 extends ay7<my7, PbImageAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId g;
    public jv7 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly7(t28 t28Var, BdUniqueId bdUniqueId) {
        super(t28Var, my7.q);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t28) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdUniqueId;
    }

    @Override // com.baidu.tieba.ay7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v(i, view2, viewGroup, (my7) obj, (PbImageAlaRecommendVH) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public PbImageAlaRecommendVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbImageAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06ca, viewGroup, false), this.a.getPageContext(), this.g) : (PbImageAlaRecommendVH) invokeL.objValue;
    }

    public View v(int i, View view2, ViewGroup viewGroup, my7 my7Var, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, my7Var, pbImageAlaRecommendVH})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, my7Var, pbImageAlaRecommendVH);
            if (pbImageAlaRecommendVH != null) {
                pbImageAlaRecommendVH.c(my7Var);
                pbImageAlaRecommendVH.h(this.h);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void w(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jv7Var) == null) {
            this.h = jv7Var;
        }
    }
}
