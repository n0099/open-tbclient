package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
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
import d.a.p0.n1.o.k.a;
import d.a.p0.w2.f0.b.c;
import java.util.List;
/* loaded from: classes4.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout n0;
    public TbImageView o0;
    public XfremodeRoundLayout p0;
    public TbImageView q0;
    public XfremodeRoundLayout r0;
    public TbImageView s0;
    public float t0;
    public float u0;

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
        this.u0 = 0.0f;
    }

    public final void J0(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, tbImageView, i2, i3) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void K0(XfremodeRoundLayout xfremodeRoundLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xfremodeRoundLayout, i2) == null) {
            if (i2 == 1) {
                float f2 = this.t0;
                float f3 = this.u0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
            } else if (i2 == 2) {
                float f4 = this.u0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else if (i2 != 3) {
                float f5 = this.t0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
            } else {
                float f6 = this.u0;
                float f7 = this.t0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            c cVar = adCard.picInfo;
            List<String> list = cVar == null ? null : cVar.f65912c;
            if (!a.e(list) && cVar != null) {
                int k = a.k(cVar.f65912c);
                int dimensionPixelSize = (int) ((this.G - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = cVar.f65914e;
                int i3 = cVar.f65913d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
                this.o0.setVisibility(4);
                this.q0.setVisibility(4);
                this.s0.setVisibility(4);
                K0(this.n0, 1);
                K0(this.p0, 2);
                K0(this.r0, 3);
                J0(this.o0, dimensionPixelSize, max);
                J0(this.q0, dimensionPixelSize, max);
                J0(this.s0, dimensionPixelSize, max);
                if (k == 1) {
                    this.o0.M((String) a.d(list, 0), 30, false);
                    this.o0.setVisibility(0);
                    K0(this.n0, 4);
                } else if (k == 2) {
                    this.o0.M((String) a.d(list, 0), 30, false);
                    this.o0.setVisibility(0);
                    this.q0.M((String) a.d(list, 1), 30, false);
                    this.q0.setVisibility(0);
                    K0(this.p0, 3);
                } else if (k >= 3) {
                    this.o0.M((String) a.d(list, 0), 30, false);
                    this.o0.setVisibility(0);
                    this.q0.M((String) a.d(list, 1), 30, false);
                    this.q0.setVisibility(0);
                    this.s0.M((String) a.d(list, 2), 30, false);
                    this.s0.setVisibility(0);
                }
                this.t.setVisibility(0);
                return;
            }
            this.t.setVisibility(8);
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
    public void j0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.n0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
            this.o0 = (TbImageView) view.findViewById(R.id.advert_app_img_left);
            this.p0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
            this.q0 = (TbImageView) view.findViewById(R.id.advert_app_img_center);
            this.r0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
            this.s0 = (TbImageView) view.findViewById(R.id.advert_app_img_right);
            this.t0 = d0(R.string.J_X05);
            this.o0.setPlaceHolder(2);
            this.q0.setPlaceHolder(2);
            this.s0.setPlaceHolder(2);
        }
    }
}
