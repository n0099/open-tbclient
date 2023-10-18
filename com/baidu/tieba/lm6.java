package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.compact.RecommendBannerCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lm6 extends q67<RecommendBannerCardView, r07> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm6() {
        super("recommend_banner");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.q67, com.baidu.tieba.g77
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            RecommendBannerCardView recommendBannerCardView = new RecommendBannerCardView(viewGroup.getContext());
            recommendBannerCardView.a(viewGroup);
            v87.i(recommendBannerCardView, Integer.valueOf(v87.e() * 2));
            return recommendBannerCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g77
    /* renamed from: e */
    public void b(@NonNull RecommendBannerCardView recommendBannerCardView, @NonNull r07 r07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recommendBannerCardView, r07Var) == null) {
            Object obj = r07Var.a().a;
            if (obj instanceof u18) {
                recommendBannerCardView.setVisibility(0);
                recommendBannerCardView.d((u18) obj);
                return;
            }
            recommendBannerCardView.setVisibility(8);
        }
    }
}
