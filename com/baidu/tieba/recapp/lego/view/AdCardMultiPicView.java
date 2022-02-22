package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import c.a.u0.l3.i0.b.d;
import c.a.u0.z1.o.k.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView mAdvertAppImgCenter;
    public TbImageView mAdvertAppImgLeft;
    public TbImageView mAdvertAppImgRight;
    public XfremodeRoundLayout mRlImgCenter;
    public XfremodeRoundLayout mRlImgLeft;
    public XfremodeRoundLayout mRlImgRight;
    public float x;
    public float y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardMultiPicView(TbPageContext tbPageContext) {
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
        this.y = 0.0f;
    }

    public final void L(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, tbImageView, i2, i3) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void M(XfremodeRoundLayout xfremodeRoundLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xfremodeRoundLayout, i2) == null) {
            if (i2 == 1) {
                float f2 = this.x;
                float f3 = this.y;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
            } else if (i2 == 2) {
                float f4 = this.y;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else if (i2 != 3) {
                float f5 = this.x;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
            } else {
                float f6 = this.y;
                float f7 = this.x;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void fillCustomView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            d dVar = adCard.picInfo;
            List<String> list = dVar == null ? null : dVar.f19311c;
            if (!a.e(list) && dVar != null) {
                int k = a.k(dVar.f19311c);
                int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = dVar.f19313e;
                int i3 = dVar.f19312d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
                this.mAdvertAppImgLeft.setVisibility(4);
                this.mAdvertAppImgCenter.setVisibility(4);
                this.mAdvertAppImgRight.setVisibility(4);
                M(this.mRlImgLeft, 1);
                M(this.mRlImgCenter, 2);
                M(this.mRlImgRight, 3);
                L(this.mAdvertAppImgLeft, dimensionPixelSize, max);
                L(this.mAdvertAppImgCenter, dimensionPixelSize, max);
                L(this.mAdvertAppImgRight, dimensionPixelSize, max);
                if (k == 1) {
                    this.mAdvertAppImgLeft.startLoad((String) a.d(list, 0), 30, false);
                    this.mAdvertAppImgLeft.setVisibility(0);
                    M(this.mRlImgLeft, 4);
                } else if (k == 2) {
                    this.mAdvertAppImgLeft.startLoad((String) a.d(list, 0), 30, false);
                    this.mAdvertAppImgLeft.setVisibility(0);
                    this.mAdvertAppImgCenter.startLoad((String) a.d(list, 1), 30, false);
                    this.mAdvertAppImgCenter.setVisibility(0);
                    M(this.mRlImgCenter, 3);
                } else if (k >= 3) {
                    this.mAdvertAppImgLeft.startLoad((String) a.d(list, 0), 30, false);
                    this.mAdvertAppImgLeft.setVisibility(0);
                    this.mAdvertAppImgCenter.startLoad((String) a.d(list, 1), 30, false);
                    this.mAdvertAppImgCenter.setVisibility(0);
                    this.mAdvertAppImgRight.startLoad((String) a.d(list, 2), 30, false);
                    this.mAdvertAppImgRight.setVisibility(0);
                }
                this.mCustomRoot.setVisibility(0);
                return;
            }
            this.mCustomRoot.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.card_ad_multi_pic : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.card_ad : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void initCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.mRlImgLeft = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
            this.mAdvertAppImgLeft = (TbImageView) view.findViewById(R.id.advert_app_img_left);
            this.mRlImgCenter = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
            this.mAdvertAppImgCenter = (TbImageView) view.findViewById(R.id.advert_app_img_center);
            this.mRlImgRight = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
            this.mAdvertAppImgRight = (TbImageView) view.findViewById(R.id.advert_app_img_right);
            this.x = getRatioByResString(R.string.J_X05);
            this.mAdvertAppImgLeft.setPlaceHolder(2);
            this.mAdvertAppImgCenter.setPlaceHolder(2);
            this.mAdvertAppImgRight.setPlaceHolder(2);
        }
    }
}
