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
import com.repackage.db7;
import com.repackage.q88;
import java.util.List;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout V;
    public AdImageView W;
    public XfremodeRoundLayout g0;
    public AdImageView h0;
    public XfremodeRoundLayout i0;
    public AdImageView j0;
    public float k0;
    public float l0;

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
        this.l0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            q88 q88Var = adCard.picInfo;
            List<String> list = q88Var == null ? null : q88Var.c;
            if (!db7.e(list) && q88Var != null) {
                int i = db7.i(q88Var.c);
                int dimensionPixelSize = (int) ((this.B - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
                int i2 = q88Var.e;
                int i3 = q88Var.d;
                int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
                this.W.setVisibility(4);
                this.h0.setVisibility(4);
                this.j0.setVisibility(4);
                o0(this.V, 1);
                o0(this.g0, 2);
                o0(this.i0, 3);
                n0(this.W, dimensionPixelSize, max);
                n0(this.h0, dimensionPixelSize, max);
                n0(this.j0, dimensionPixelSize, max);
                if (i == 1) {
                    this.W.n((String) db7.d(list, 0));
                    this.W.setVisibility(0);
                    o0(this.V, 4);
                } else if (i == 2) {
                    this.W.n((String) db7.d(list, 0));
                    this.W.setVisibility(0);
                    this.h0.n((String) db7.d(list, 1));
                    this.h0.setVisibility(0);
                    o0(this.g0, 3);
                } else if (i >= 3) {
                    this.W.n((String) db7.d(list, 0));
                    this.W.setVisibility(0);
                    this.h0.n((String) db7.d(list, 1));
                    this.h0.setVisibility(0);
                    this.j0.n((String) db7.d(list, 2));
                    this.j0.setVisibility(0);
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
            this.V = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091aba);
            this.W = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090140);
            this.g0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ab9);
            this.h0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f09013f);
            this.i0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091abb);
            this.j0 = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f090141);
            this.k0 = P(R.string.J_X05);
            this.W.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.h0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.j0.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0176 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0175 : invokeV.intValue;
    }

    public final void n0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, view2, i, i2) == null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        view2.setLayoutParams(layoutParams);
    }

    public final void o0(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, xfremodeRoundLayout, i) == null) {
            if (i == 1) {
                float f = this.k0;
                float f2 = this.l0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f, f, f2, f2, f2, f2, f, f});
            } else if (i == 2) {
                float f3 = this.l0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f3, f3, f3, f3, f3, f3, f3, f3});
            } else if (i != 3) {
                float f4 = this.k0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
            } else {
                float f5 = this.l0;
                float f6 = this.k0;
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f6, f6, f6, f6, f5, f5});
            }
        }
    }
}
