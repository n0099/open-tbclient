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
/* loaded from: classes6.dex */
public class ip6 extends d97<RecommendBannerCardView, i37> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip6() {
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

    @Override // com.baidu.tieba.d97, com.baidu.tieba.t97
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            RecommendBannerCardView recommendBannerCardView = new RecommendBannerCardView(viewGroup.getContext());
            recommendBannerCardView.a(viewGroup);
            hb7.i(recommendBannerCardView, Integer.valueOf(hb7.e() * 2));
            return recommendBannerCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t97
    /* renamed from: e */
    public void b(@NonNull RecommendBannerCardView recommendBannerCardView, @NonNull i37 i37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recommendBannerCardView, i37Var) == null) {
            Object obj = i37Var.a().a;
            if (obj instanceof a48) {
                recommendBannerCardView.setVisibility(0);
                recommendBannerCardView.update((a48) obj);
                return;
            }
            recommendBannerCardView.setVisibility(8);
        }
    }
}
