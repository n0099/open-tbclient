package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
import d.a.q0.w2.f0.b.c;
import d.a.q0.w2.f0.c.a;
/* loaded from: classes4.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout n0;
    public TbImageView o0;

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

    public boolean J0(TbImageView tbImageView, AdCard adCard, @NonNull c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, tbImageView, adCard, cVar)) == null) {
            if (adCard == null || tbImageView == null) {
                return false;
            }
            double d2 = 1.0d;
            if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
                d2 = adCard.getPicScale();
            }
            int i2 = this.G;
            int i3 = (int) (i2 * d2);
            int b2 = (int) (a.b(i2) * d2);
            if (!adCard.isNeedResize()) {
                K0(tbImageView, b2, i3);
                return true;
            }
            int i4 = cVar.f66589e;
            int i5 = cVar.f66588d;
            if (i3 > 0 && i4 > 0 && i5 > 0) {
                int i6 = (i4 * i3) / i5;
                if (i6 > i3) {
                    return false;
                }
                K0(tbImageView, i6, i3);
                return true;
            }
            int i7 = this.G;
            K0(tbImageView, (int) (i7 * 0.75f), i7);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void K0(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, i2, i3) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i3, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i3;
        }
        this.n0.setLayoutParams(layoutParams);
        tbImageView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            c cVar = adCard.picInfo;
            if (cVar != null && !d.a.q0.n1.o.k.a.e(cVar.f66587c)) {
                String str = cVar.f66587c.get(0);
                boolean J0 = J0(this.o0, adCard, cVar);
                if (!TextUtils.isEmpty(str) && J0) {
                    this.t.setVisibility(0);
                    this.o0.M(str, 17, false);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.card_ad_single_pic : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.card_ad : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void j0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            float d0 = d0(R.string.J_X05);
            if (view instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{d0, d0, d0, d0, d0, d0, d0, d0});
            }
            this.n0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
            this.o0 = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.n0.setRoundLayoutRadius(new float[]{d0, d0, d0, d0, d0, d0, d0, d0});
        }
    }
}
