package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.g09;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.wz9;
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
    public XfremodeRoundLayout j0;
    public AdImageView r0;
    public XfremodeRoundLayout s0;
    public AdImageView t0;
    public XfremodeRoundLayout u0;
    public AdImageView v0;
    public float w0;
    public float x0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d019a : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0199 : invokeV.intValue;
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
        this.x0 = 0.0f;
    }

    public final void A0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, xfremodeRoundLayout, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        float f = this.w0;
                        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
                        return;
                    }
                    float f2 = this.x0;
                    float f3 = this.w0;
                    xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
                    return;
                }
                float f4 = this.x0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
                return;
            }
            float f5 = this.w0;
            float f6 = this.x0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void V(AdCard adCard) {
        List<String> list;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) {
            wz9 wz9Var = adCard.picInfo;
            if (wz9Var == null) {
                list = null;
            } else {
                list = wz9Var.c;
            }
            if (!g09.e(list) && wz9Var != null) {
                int i = g09.i(wz9Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = wz9Var.e;
                int i3 = wz9Var.d;
                if (i2 != 0 && i3 != 0) {
                    f = i2 / i3;
                } else {
                    f = 1.0f;
                }
                int max = (int) (dimensionPixelSize * Math.max(Math.min(f, 1.0f), 0.0f));
                this.r0.setVisibility(4);
                this.t0.setVisibility(4);
                this.v0.setVisibility(4);
                A0(this.j0, 1);
                A0(this.s0, 2);
                A0(this.u0, 3);
                z0(this.r0, dimensionPixelSize, max);
                z0(this.t0, dimensionPixelSize, max);
                z0(this.v0, dimensionPixelSize, max);
                if (i == 1) {
                    this.r0.o((String) g09.d(list, 0));
                    this.r0.setVisibility(0);
                    A0(this.j0, 4);
                } else if (i == 2) {
                    this.r0.o((String) g09.d(list, 0));
                    this.r0.setVisibility(0);
                    this.t0.o((String) g09.d(list, 1));
                    this.t0.setVisibility(0);
                    A0(this.s0, 3);
                } else if (i >= 3) {
                    this.r0.o((String) g09.d(list, 0));
                    this.r0.setVisibility(0);
                    this.t0.o((String) g09.d(list, 1));
                    this.t0.setVisibility(0);
                    this.v0.o((String) g09.d(list, 2));
                    this.v0.setVisibility(0);
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
            this.j0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f2a);
            this.r0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090154);
            this.s0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f29);
            this.t0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090153);
            this.u0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f2b);
            this.v0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090155);
            this.w0 = X(R.string.J_X05)[0];
            this.r0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.t0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.v0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
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
