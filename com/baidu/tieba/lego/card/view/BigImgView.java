package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigImgView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: H */
    public void v(BigImgCard bigImgCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bigImgCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void w(BigImgCard bigImgCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigImgCard) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
            if (bigImgCard.getRatio() > 0.0d) {
                int ratio = (int) (bigImgCard.getRatio() * l.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.r.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
                this.r.setLayoutParams(layoutParams);
            }
            this.r.M(bigImgCard.getUrl(), 10, false);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            this.r = tbImageView;
            return tbImageView;
        }
        return (View) invokeV.objValue;
    }
}
