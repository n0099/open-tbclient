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
public class jo6 extends ja7<RecommendBannerCardView, t27> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo6() {
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

    @Override // com.baidu.tieba.ja7, com.baidu.tieba.za7
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            RecommendBannerCardView recommendBannerCardView = new RecommendBannerCardView(viewGroup.getContext());
            recommendBannerCardView.a(viewGroup);
            sc7.i(recommendBannerCardView, Integer.valueOf(sc7.e() * 2));
            return recommendBannerCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za7
    /* renamed from: e */
    public void b(@NonNull RecommendBannerCardView recommendBannerCardView, @NonNull t27 t27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recommendBannerCardView, t27Var) == null) {
            Object obj = t27Var.a().a;
            if (obj instanceof qe8) {
                recommendBannerCardView.setVisibility(0);
                recommendBannerCardView.c((qe8) obj);
                return;
            }
            recommendBannerCardView.setVisibility(8);
        }
    }
}
