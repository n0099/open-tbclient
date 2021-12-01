package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import c.a.r0.h3.i0.b.d;
import c.a.r0.w1.o.k.a;
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
/* loaded from: classes11.dex */
public class AdCardSmallPicView extends AdSimpleCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public XfremodeRoundLayout f48664i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f48665j;

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
    public void fillCustomView(AdCard adCard) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard != null && (dVar = adCard.picInfo) != null && a.k(dVar.f17747c) >= 1) {
                String str = (String) a.d(adCard.picInfo.f17747c, 0);
                if (!TextUtils.isEmpty(str)) {
                    this.mCustomRoot.setVisibility(0);
                    this.f48665j.startLoad(str, 17, false);
                    return;
                }
                this.mCustomRoot.setVisibility(8);
                return;
            }
            this.mCustomRoot.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.ad_card_small_pic_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.card_small_pic_ad : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void initCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.f48664i = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
            this.f48665j = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f48664i.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
    }
}
