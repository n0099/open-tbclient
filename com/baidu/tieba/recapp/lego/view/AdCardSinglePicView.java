package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.r0.p1.o.k.a;
import c.a.r0.y2.i0.b.d;
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
/* loaded from: classes7.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout x;
    public TbImageView y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardSinglePicView(TbPageContext tbPageContext) {
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

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void fillCustomView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            d dVar = adCard.picInfo;
            if (dVar != null && !a.e(dVar.f29498c)) {
                String str = dVar.f29498c.get(0);
                boolean resizeImage = resizeImage(this.y, adCard, dVar);
                if (!TextUtils.isEmpty(str) && resizeImage) {
                    this.mCustomRoot.setVisibility(0);
                    this.y.startLoad(str, 17, false);
                    return;
                }
                this.mCustomRoot.setVisibility(8);
                return;
            }
            this.mCustomRoot.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.card_ad_single_pic : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.card_ad : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void initCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            float ratioByResString = getRatioByResString(R.string.J_X05);
            if (view instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString});
            }
            this.x = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
            this.y = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.x.setRoundLayoutRadius(new float[]{ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString});
        }
    }

    public boolean resizeImage(TbImageView tbImageView, AdCard adCard, @NonNull d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, tbImageView, adCard, dVar)) == null) {
            if (adCard == null || tbImageView == null) {
                return false;
            }
            double d2 = 1.0d;
            if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
                d2 = adCard.getPicScale();
            }
            int i2 = this.mMaxWidth;
            int i3 = (int) (i2 * d2);
            int b2 = (int) (c.a.r0.y2.i0.c.a.b(i2) * d2);
            if (!adCard.isNeedResize()) {
                setImageViewSize(tbImageView, b2, i3);
                return true;
            }
            int i4 = dVar.f29500e;
            int i5 = dVar.f29499d;
            if (i3 > 0 && i4 > 0 && i5 > 0) {
                int i6 = (i4 * i3) / i5;
                if (i6 > i3) {
                    return false;
                }
                setImageViewSize(tbImageView, i6, i3);
                return true;
            }
            int i7 = this.mMaxWidth;
            setImageViewSize(tbImageView, (int) (i7 * 0.75f), i7);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void setImageViewSize(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, tbImageView, i2, i3) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i3, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i3;
        }
        this.x.setLayoutParams(layoutParams);
        tbImageView.setLayoutParams(layoutParams);
    }
}
