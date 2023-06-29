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
import com.baidu.tieba.du8;
import com.baidu.tieba.ot9;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.st9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout j0;
    public AdImageView r0;

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d019b : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0199 : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
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
                this.a.X("image");
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
    public void U(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            ot9 ot9Var = adCard.picInfo;
            if (ot9Var != null && !du8.e(ot9Var.c)) {
                String str = ot9Var.c.get(0);
                boolean y0 = y0(this.r0, adCard, ot9Var);
                if (!TextUtils.isEmpty(str) && y0) {
                    this.o.setVisibility(0);
                    this.r0.o(str);
                } else {
                    this.o.setVisibility(8);
                }
                this.r0.setOnClickListener(new a(this));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            float[] W = W(R.string.J_X05);
            if (view2 instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view2).setRoundLayoutRadius(W);
            }
            this.j0 = (XfremodeRoundLayout) view2.findViewById(R.id.obfuscated_res_0x7f091eec);
            AdImageView adImageView = (AdImageView) view2.findViewById(R.id.obfuscated_res_0x7f091841);
            this.r0 = adImageView;
            adImageView.setPlaceHolderDrawable(SkinManager.getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_40_n)));
            this.j0.setRoundLayoutRadius(W);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void setCustomViewRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fArr) == null) {
            View view2 = this.o;
            if (view2 instanceof XfremodeRoundLayout) {
                ((XfremodeRoundLayout) view2).setRoundLayoutRadius(fArr);
            }
            this.j0.setRoundLayoutRadius(fArr);
            this.o.postInvalidate();
            this.j0.postInvalidate();
        }
    }

    public boolean y0(View view2, AdCard adCard, @NonNull ot9 ot9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, view2, adCard, ot9Var)) == null) {
            if (adCard == null || view2 == null) {
                return false;
            }
            double d = 1.0d;
            if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
                d = adCard.getPicScale();
            }
            int i = this.B;
            int i2 = (int) (i * d);
            int b = (int) (st9.b(i) * d);
            if (!adCard.isNeedResize()) {
                z0(view2, b, i2);
                return true;
            }
            int i3 = ot9Var.e;
            int i4 = ot9Var.d;
            if (i2 > 0 && i3 > 0 && i4 > 0) {
                int i5 = (i3 * i2) / i4;
                if (i5 > i2) {
                    return false;
                }
                z0(view2, i5, i2);
                return true;
            }
            int i6 = this.B;
            z0(view2, (int) (i6 * 0.75f), i6);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void z0(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048582, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i2, i);
        } else {
            layoutParams.height = i;
            layoutParams.width = i2;
        }
        this.j0.setLayoutParams(layoutParams);
        view2.setLayoutParams(layoutParams);
    }
}
