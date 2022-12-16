package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.em7;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.zj8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout b0;
    public AdImageView c0;
    public XfremodeRoundLayout d0;
    public AdImageView e0;
    public XfremodeRoundLayout f0;
    public AdImageView g0;
    public float h0;
    public float i0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0179 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0178 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardMultiPicView a;

        public a(AdCardMultiPicView adCardMultiPicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardMultiPicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardMultiPicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q("image");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        List<String> list;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            zj8 zj8Var = adCard.picInfo;
            if (zj8Var == null) {
                list = null;
            } else {
                list = zj8Var.c;
            }
            if (!em7.e(list) && zj8Var != null) {
                int i = em7.i(zj8Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = zj8Var.e;
                int i3 = zj8Var.d;
                if (i2 != 0 && i3 != 0) {
                    f = i2 / i3;
                } else {
                    f = 1.0f;
                }
                int max = (int) (dimensionPixelSize * Math.max(Math.min(f, 1.0f), 0.0f));
                this.c0.setVisibility(4);
                this.e0.setVisibility(4);
                this.g0.setVisibility(4);
                p0(this.b0, 1);
                p0(this.d0, 2);
                p0(this.f0, 3);
                o0(this.c0, dimensionPixelSize, max);
                o0(this.e0, dimensionPixelSize, max);
                o0(this.g0, dimensionPixelSize, max);
                if (i == 1) {
                    this.c0.g((String) em7.d(list, 0));
                    this.c0.setVisibility(0);
                    p0(this.b0, 4);
                } else if (i == 2) {
                    this.c0.g((String) em7.d(list, 0));
                    this.c0.setVisibility(0);
                    this.e0.g((String) em7.d(list, 1));
                    this.e0.setVisibility(0);
                    p0(this.d0, 3);
                } else if (i >= 3) {
                    this.c0.g((String) em7.d(list, 0));
                    this.c0.setVisibility(0);
                    this.e0.g((String) em7.d(list, 1));
                    this.e0.setVisibility(0);
                    this.g0.g((String) em7.d(list, 2));
                    this.g0.setVisibility(0);
                }
                this.o.setVisibility(0);
                this.o.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.b0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d17);
            this.c0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014f);
            this.d0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d16);
            this.e0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.f0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d18);
            this.g0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090150);
            this.h0 = P(R.string.J_X05);
            this.c0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.e0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.g0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }

    public final void o0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048580, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        view2.setLayoutParams(layoutParams);
    }

    public final void p0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, xfremodeRoundLayout, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        float f = this.h0;
                        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
                        return;
                    }
                    float f2 = this.i0;
                    float f3 = this.h0;
                    xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
                    return;
                }
                float f4 = this.i0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
                return;
            }
            float f5 = this.h0;
            float f6 = this.i0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
        }
    }
}
