package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.g29;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.u2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout f0;
    public AdImageView g0;
    public XfremodeRoundLayout h0;
    public AdImageView i0;
    public XfremodeRoundLayout j0;
    public AdImageView r0;
    public float s0;
    public float t0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a0 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d019f : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("image");
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
        this.t0 = 0.0f;
    }

    public final void A0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, xfremodeRoundLayout, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        float f = this.s0;
                        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
                        return;
                    }
                    float f2 = this.t0;
                    float f3 = this.s0;
                    xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
                    return;
                }
                float f4 = this.t0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
                return;
            }
            float f5 = this.s0;
            float f6 = this.t0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void V(AdCard adCard) {
        List<String> list;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            u2a u2aVar = adCard.picInfo;
            if (u2aVar == null) {
                list = null;
            } else {
                list = u2aVar.c;
            }
            if (!g29.e(list) && u2aVar != null) {
                int i = g29.i(u2aVar.c);
                int dimensionPixelSize = (int) ((this.x - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = u2aVar.e;
                int i3 = u2aVar.d;
                if (i2 != 0 && i3 != 0) {
                    f = i2 / i3;
                } else {
                    f = 1.0f;
                }
                int max = (int) (dimensionPixelSize * Math.max(Math.min(f, 1.0f), 0.0f));
                this.g0.setVisibility(4);
                this.i0.setVisibility(4);
                this.r0.setVisibility(4);
                A0(this.f0, 1);
                A0(this.h0, 2);
                A0(this.j0, 3);
                z0(this.g0, dimensionPixelSize, max);
                z0(this.i0, dimensionPixelSize, max);
                z0(this.r0, dimensionPixelSize, max);
                if (i == 1) {
                    this.g0.b((String) g29.d(list, 0));
                    this.g0.setVisibility(0);
                    A0(this.f0, 4);
                } else if (i == 2) {
                    this.g0.b((String) g29.d(list, 0));
                    this.g0.setVisibility(0);
                    this.i0.b((String) g29.d(list, 1));
                    this.i0.setVisibility(0);
                    A0(this.h0, 3);
                } else if (i >= 3) {
                    this.g0.b((String) g29.d(list, 0));
                    this.g0.setVisibility(0);
                    this.i0.b((String) g29.d(list, 1));
                    this.i0.setVisibility(0);
                    this.r0.b((String) g29.d(list, 2));
                    this.r0.setVisibility(0);
                }
                this.o.setVisibility(0);
                this.o.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void d0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.f0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f6a);
            this.g0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090157);
            this.h0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f69);
            this.i0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090156);
            this.j0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f6b);
            this.r0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090158);
            this.s0 = X(R.string.J_X05)[0];
            this.g0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.i0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.r0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }

    public final void z0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048581, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        view2.setLayoutParams(layoutParams);
    }
}
