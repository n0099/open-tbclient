package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.f29;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.v38;
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
    public XfremodeRoundLayout i0;
    public AdImageView j0;
    public XfremodeRoundLayout r0;
    public AdImageView s0;
    public XfremodeRoundLayout t0;
    public AdImageView u0;
    public float v0;
    public float w0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d018a : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0189 : invokeV.intValue;
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
                this.a.X("image");
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
        this.w0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(AdCard adCard) {
        List<String> list;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            f29 f29Var = adCard.picInfo;
            if (f29Var == null) {
                list = null;
            } else {
                list = f29Var.c;
            }
            if (!v38.e(list) && f29Var != null) {
                int i = v38.i(f29Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = f29Var.e;
                int i3 = f29Var.d;
                if (i2 != 0 && i3 != 0) {
                    f = i2 / i3;
                } else {
                    f = 1.0f;
                }
                int max = (int) (dimensionPixelSize * Math.max(Math.min(f, 1.0f), 0.0f));
                this.j0.setVisibility(4);
                this.s0.setVisibility(4);
                this.u0.setVisibility(4);
                z0(this.i0, 1);
                z0(this.r0, 2);
                z0(this.t0, 3);
                y0(this.j0, dimensionPixelSize, max);
                y0(this.s0, dimensionPixelSize, max);
                y0(this.u0, dimensionPixelSize, max);
                if (i == 1) {
                    this.j0.o((String) v38.d(list, 0));
                    this.j0.setVisibility(0);
                    z0(this.i0, 4);
                } else if (i == 2) {
                    this.j0.o((String) v38.d(list, 0));
                    this.j0.setVisibility(0);
                    this.s0.o((String) v38.d(list, 1));
                    this.s0.setVisibility(0);
                    z0(this.r0, 3);
                } else if (i >= 3) {
                    this.j0.o((String) v38.d(list, 0));
                    this.j0.setVisibility(0);
                    this.s0.o((String) v38.d(list, 1));
                    this.s0.setVisibility(0);
                    this.u0.o((String) v38.d(list, 2));
                    this.u0.setVisibility(0);
                }
                this.o.setVisibility(0);
                this.o.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.i0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e07);
            this.j0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090149);
            this.r0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e06);
            this.s0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090148);
            this.t0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e08);
            this.u0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014a);
            this.v0 = W(R.string.J_X05)[0];
            this.j0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.s0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.u0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }

    public final void y0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048580, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        view2.setLayoutParams(layoutParams);
    }

    public final void z0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, xfremodeRoundLayout, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        float f = this.v0;
                        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
                        return;
                    }
                    float f2 = this.w0;
                    float f3 = this.v0;
                    xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
                    return;
                }
                float f4 = this.w0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
                return;
            }
            float f5 = this.v0;
            float f6 = this.w0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
        }
    }
}
