package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.p0.l3.j0.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout j0;
    public TbImageView k0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardSinglePicView a;

        public a(AdCardSinglePicView adCardSinglePicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardSinglePicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardSinglePicView;
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
    public AdCardSinglePicView(TbPageContext tbPageContext) {
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
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            e eVar = adCard.picInfo;
            if (eVar != null && !c.a.p0.b2.o.k.a.e(eVar.f16234c)) {
                String str = eVar.f16234c.get(0);
                boolean q0 = q0(this.k0, adCard, eVar);
                if (!TextUtils.isEmpty(str) && q0) {
                    this.o.setVisibility(0);
                    this.k0.J(str, 17, false);
                } else {
                    this.o.setVisibility(8);
                }
                this.k0.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void U(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            float P = P(R.string.J_X05);
            if (view instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{P, P, P, P, P, P, P, P});
            }
            this.j0 = (XfremodeRoundLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac5);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0900a9);
            this.k0 = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.j0.setRoundLayoutRadius(new float[]{P, P, P, P, P, P, P, P});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d017a : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0178 : invokeV.intValue;
    }

    public boolean q0(TbImageView tbImageView, AdCard adCard, @NonNull e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, tbImageView, adCard, eVar)) == null) {
            if (adCard == null || tbImageView == null) {
                return false;
            }
            double d2 = 1.0d;
            if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
                d2 = adCard.getPicScale();
            }
            int i = this.B;
            int i2 = (int) (i * d2);
            int b2 = (int) (c.a.p0.l3.j0.c.a.b(i) * d2);
            if (!adCard.isNeedResize()) {
                r0(tbImageView, b2, i2);
                return true;
            }
            int i3 = eVar.f16236e;
            int i4 = eVar.f16235d;
            if (i2 > 0 && i3 > 0 && i4 > 0) {
                int i5 = (i3 * i2) / i4;
                if (i5 > i2) {
                    return false;
                }
                r0(tbImageView, i5, i2);
                return true;
            }
            int i6 = this.B;
            r0(tbImageView, (int) (i6 * 0.75f), i6);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r0(TbImageView tbImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, tbImageView, i, i2) == null) || tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i2, i);
        } else {
            layoutParams.height = i;
            layoutParams.width = i2;
        }
        this.j0.setLayoutParams(layoutParams);
        tbImageView.setLayoutParams(layoutParams);
    }
}
