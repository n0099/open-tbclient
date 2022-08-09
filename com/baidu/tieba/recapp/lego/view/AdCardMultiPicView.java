package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bf7;
import com.repackage.zc8;
import java.util.List;
/* loaded from: classes4.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout a0;
    public AdImageView b0;
    public XfremodeRoundLayout c0;
    public AdImageView d0;
    public XfremodeRoundLayout e0;
    public AdImageView f0;
    public float g0;
    public float h0;

    /* loaded from: classes4.dex */
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
        this.h0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            zc8 zc8Var = adCard.picInfo;
            List<String> list = zc8Var == null ? null : zc8Var.c;
            if (!bf7.e(list) && zc8Var != null) {
                int i = bf7.i(zc8Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = zc8Var.e;
                int i3 = zc8Var.d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
                this.b0.setVisibility(4);
                this.d0.setVisibility(4);
                this.f0.setVisibility(4);
                p0(this.a0, 1);
                p0(this.c0, 2);
                p0(this.e0, 3);
                o0(this.b0, dimensionPixelSize, max);
                o0(this.d0, dimensionPixelSize, max);
                o0(this.f0, dimensionPixelSize, max);
                if (i == 1) {
                    this.b0.g((String) bf7.d(list, 0));
                    this.b0.setVisibility(0);
                    p0(this.a0, 4);
                } else if (i == 2) {
                    this.b0.g((String) bf7.d(list, 0));
                    this.b0.setVisibility(0);
                    this.d0.g((String) bf7.d(list, 1));
                    this.d0.setVisibility(0);
                    p0(this.c0, 3);
                } else if (i >= 3) {
                    this.b0.g((String) bf7.d(list, 0));
                    this.b0.setVisibility(0);
                    this.d0.g((String) bf7.d(list, 1));
                    this.d0.setVisibility(0);
                    this.f0.g((String) bf7.d(list, 2));
                    this.f0.setVisibility(0);
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
            this.a0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c0d);
            this.b0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090147);
            this.c0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c0c);
            this.d0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090146);
            this.e0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c0e);
            this.f0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090148);
            this.g0 = P(R.string.J_X05);
            this.b0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.d0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.f0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0174 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0173 : invokeV.intValue;
    }

    public final void o0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, view2, i, i2) == null) || view2 == null) {
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
            if (i == 1) {
                float f = this.g0;
                float f2 = this.h0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f2, f2, f2, f2, f, f});
            } else if (i == 2) {
                float f3 = this.h0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f3, f3, f3, f3, f3, f3, f3, f3});
            } else if (i != 3) {
                float f4 = this.g0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else {
                float f5 = this.h0;
                float f6 = this.g0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
            }
        }
    }
}
