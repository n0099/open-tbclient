package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n1.o.k.a;
import d.a.s0.w2.f0.b.c;
/* loaded from: classes5.dex */
public class AdCardSmallPicView extends AdSimpleCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public XfremodeRoundLayout z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardSmallPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void N(AdCard adCard) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard != null && (cVar = adCard.picInfo) != null && a.k(cVar.f69140c) >= 1) {
                String str = (String) a.d(adCard.picInfo.f69140c, 0);
                if (!TextUtils.isEmpty(str)) {
                    this.t.setVisibility(0);
                    this.A.M(str, 17, false);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void P(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            float dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.z = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
            this.A = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.z.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ad_card_small_pic_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.card_small_pic_ad : invokeV.intValue;
    }
}
