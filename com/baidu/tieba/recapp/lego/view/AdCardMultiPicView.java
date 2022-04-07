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
import com.repackage.dc8;
import com.repackage.gd7;
import java.util.List;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout j0;
    public TbImageView k0;
    public XfremodeRoundLayout l0;
    public TbImageView m0;
    public XfremodeRoundLayout n0;
    public TbImageView o0;
    public float p0;
    public float q0;

    /* loaded from: classes3.dex */
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
                this.a.R("image");
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
        this.q0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void P(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            dc8 dc8Var = adCard.picInfo;
            List<String> list = dc8Var == null ? null : dc8Var.c;
            if (!gd7.e(list) && dc8Var != null) {
                int k = gd7.k(dc8Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i = dc8Var.e;
                int i2 = dc8Var.d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i == 0 || i2 == 0) ? 1.0f : i / i2, 1.0f), 0.0f));
                this.k0.setVisibility(4);
                this.m0.setVisibility(4);
                this.o0.setVisibility(4);
                t0(this.j0, 1);
                t0(this.l0, 2);
                t0(this.n0, 3);
                s0(this.k0, dimensionPixelSize, max);
                s0(this.m0, dimensionPixelSize, max);
                s0(this.o0, dimensionPixelSize, max);
                if (k == 1) {
                    this.k0.K((String) gd7.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    t0(this.j0, 4);
                } else if (k == 2) {
                    this.k0.K((String) gd7.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    this.m0.K((String) gd7.d(list, 1), 30, false);
                    this.m0.setVisibility(0);
                    t0(this.l0, 3);
                } else if (k >= 3) {
                    this.k0.K((String) gd7.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    this.m0.K((String) gd7.d(list, 1), 30, false);
                    this.m0.setVisibility(0);
                    this.o0.K((String) gd7.d(list, 2), 30, false);
                    this.o0.setVisibility(0);
                }
                this.o.setVisibility(0);
                this.o.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void V(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.j0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091abc);
            this.k0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014d);
            this.l0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091abb);
            this.m0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014c);
            this.n0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091abd);
            this.o0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.p0 = Q(R.string.J_X05);
            this.k0.setPlaceHolder(2);
            this.m0.setPlaceHolder(2);
            this.o0.setPlaceHolder(2);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d017d : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d017c : invokeV.intValue;
    }

    public final void s0(TbImageView tbImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, tbImageView, i, i2) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void t0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, xfremodeRoundLayout, i) == null) {
            if (i == 1) {
                float f = this.p0;
                float f2 = this.q0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f2, f2, f2, f2, f, f});
            } else if (i == 2) {
                float f3 = this.q0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f3, f3, f3, f3, f3, f3, f3, f3});
            } else if (i != 3) {
                float f4 = this.p0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else {
                float f5 = this.q0;
                float f6 = this.p0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
            }
        }
    }
}
