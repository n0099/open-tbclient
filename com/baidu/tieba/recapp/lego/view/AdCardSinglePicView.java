package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dja;
import com.baidu.tieba.eg9;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.zia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout f0;
    public AdImageView g0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ab : invokeV.intValue;
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Z("image");
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

    public boolean A0(View view2, AdCard adCard, @NonNull zia ziaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view2, adCard, ziaVar)) == null) {
            if (adCard == null || view2 == null) {
                return false;
            }
            double d = 1.0d;
            if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
                d = adCard.getPicScale();
            }
            int i = this.x;
            int i2 = (int) (i * d);
            int b = (int) (dja.b(i) * d);
            if (!adCard.isNeedResize()) {
                B0(view2, b, i2);
                return true;
            }
            int i3 = ziaVar.e;
            int i4 = ziaVar.d;
            if (i2 > 0 && i3 > 0 && i4 > 0) {
                int i5 = (i3 * i2) / i4;
                if (i5 > i2) {
                    return false;
                }
                B0(view2, i5, i2);
                return true;
            }
            int i6 = this.x;
            B0(view2, (int) (i6 * 0.75f), i6);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void B0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i2, i);
        } else {
            layoutParams.height = i;
            layoutParams.width = i2;
        }
        this.f0.setLayoutParams(layoutParams);
        view2.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void W(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            zia ziaVar = adCard.picInfo;
            if (ziaVar != null && !eg9.e(ziaVar.c)) {
                String str = ziaVar.c.get(0);
                boolean A0 = A0(this.g0, adCard, ziaVar);
                if (!TextUtils.isEmpty(str) && A0) {
                    this.o.setVisibility(0);
                    this.g0.u(str);
                } else {
                    this.o.setVisibility(8);
                }
                this.g0.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void e0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            float[] Y = Y(R.string.J_X05);
            if (view2 instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view2).setRoundLayoutRadius(Y);
            }
            this.f0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f092032);
            AdImageView adImageView = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f091963);
            this.g0 = adImageView;
            adImageView.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.f0.setRoundLayoutRadius(Y);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void setCustomViewRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fArr) == null) {
            View view2 = this.o;
            if (view2 instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view2).setRoundLayoutRadius(fArr);
            }
            this.f0.setRoundLayoutRadius(fArr);
            this.o.postInvalidate();
            this.f0.postInvalidate();
        }
    }
}
