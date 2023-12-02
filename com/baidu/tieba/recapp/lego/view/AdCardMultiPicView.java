package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dg9;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.yia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d01aa : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a9 : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
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
                this.a.Z("image");
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

    public final void A0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048576, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        view2.setLayoutParams(layoutParams);
    }

    public final void B0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xfremodeRoundLayout, i) == null) {
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
    public void W(AdCard adCard) {
        List<String> list;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            yia yiaVar = adCard.picInfo;
            if (yiaVar == null) {
                list = null;
            } else {
                list = yiaVar.c;
            }
            if (!dg9.e(list) && yiaVar != null) {
                int i = dg9.i(yiaVar.c);
                int dimensionPixelSize = (int) ((this.x - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = yiaVar.e;
                int i3 = yiaVar.d;
                if (i2 != 0 && i3 != 0) {
                    f = i2 / i3;
                } else {
                    f = 1.0f;
                }
                int max = (int) (dimensionPixelSize * Math.max(Math.min(f, 1.0f), 0.0f));
                this.g0.setVisibility(4);
                this.i0.setVisibility(4);
                this.r0.setVisibility(4);
                B0(this.f0, 1);
                B0(this.h0, 2);
                B0(this.j0, 3);
                A0(this.g0, dimensionPixelSize, max);
                A0(this.i0, dimensionPixelSize, max);
                A0(this.r0, dimensionPixelSize, max);
                if (i == 1) {
                    this.g0.u((String) dg9.d(list, 0));
                    this.g0.setVisibility(0);
                    B0(this.f0, 4);
                } else if (i == 2) {
                    this.g0.u((String) dg9.d(list, 0));
                    this.g0.setVisibility(0);
                    this.i0.u((String) dg9.d(list, 1));
                    this.i0.setVisibility(0);
                    B0(this.h0, 3);
                } else if (i >= 3) {
                    this.g0.u((String) dg9.d(list, 0));
                    this.g0.setVisibility(0);
                    this.i0.u((String) dg9.d(list, 1));
                    this.i0.setVisibility(0);
                    this.r0.u((String) dg9.d(list, 2));
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
    public void e0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.f0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f09203e);
            this.g0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090169);
            this.h0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f09203d);
            this.i0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090168);
            this.j0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f09203f);
            this.r0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f09016a);
            this.s0 = Y(R.string.J_X05)[0];
            this.g0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.i0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.r0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }
}
