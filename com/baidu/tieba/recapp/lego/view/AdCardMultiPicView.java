package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import c.a.p0.l3.j0.b.e;
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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
        this.q0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            e eVar = adCard.picInfo;
            List<String> list = eVar == null ? null : eVar.f16234c;
            if (!c.a.p0.b2.o.k.a.e(list) && eVar != null) {
                int k = c.a.p0.b2.o.k.a.k(eVar.f16234c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i = eVar.f16236e;
                int i2 = eVar.f16235d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i == 0 || i2 == 0) ? 1.0f : i / i2, 1.0f), 0.0f));
                this.k0.setVisibility(4);
                this.m0.setVisibility(4);
                this.o0.setVisibility(4);
                r0(this.j0, 1);
                r0(this.l0, 2);
                r0(this.n0, 3);
                q0(this.k0, dimensionPixelSize, max);
                q0(this.m0, dimensionPixelSize, max);
                q0(this.o0, dimensionPixelSize, max);
                if (k == 1) {
                    this.k0.J((String) c.a.p0.b2.o.k.a.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    r0(this.j0, 4);
                } else if (k == 2) {
                    this.k0.J((String) c.a.p0.b2.o.k.a.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    this.m0.J((String) c.a.p0.b2.o.k.a.d(list, 1), 30, false);
                    this.m0.setVisibility(0);
                    r0(this.l0, 3);
                } else if (k >= 3) {
                    this.k0.J((String) c.a.p0.b2.o.k.a.d(list, 0), 30, false);
                    this.k0.setVisibility(0);
                    this.m0.J((String) c.a.p0.b2.o.k.a.d(list, 1), 30, false);
                    this.m0.setVisibility(0);
                    this.o0.J((String) c.a.p0.b2.o.k.a.d(list, 2), 30, false);
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
    public void U(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.j0 = (XfremodeRoundLayout) view.findViewById(R.id.obfuscated_res_0x7f091acc);
            this.k0 = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090144);
            this.l0 = (XfremodeRoundLayout) view.findViewById(R.id.obfuscated_res_0x7f091acb);
            this.m0 = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090143);
            this.n0 = (XfremodeRoundLayout) view.findViewById(R.id.obfuscated_res_0x7f091acd);
            this.o0 = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090145);
            this.p0 = P(R.string.J_X05);
            this.k0.setPlaceHolder(2);
            this.m0.setPlaceHolder(2);
            this.o0.setPlaceHolder(2);
        }
    }

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

    public final void q0(TbImageView tbImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, tbImageView, i, i2) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void r0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, xfremodeRoundLayout, i) == null) {
            if (i == 1) {
                float f2 = this.p0;
                float f3 = this.q0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
            } else if (i == 2) {
                float f4 = this.q0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else if (i != 3) {
                float f5 = this.p0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
            } else {
                float f6 = this.q0;
                float f7 = this.p0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
            }
        }
    }
}
