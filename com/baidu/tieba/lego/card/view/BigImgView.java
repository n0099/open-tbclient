package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45562f;

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

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            this.f45562f = tbImageView;
            return tbImageView;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(BigImgCard bigImgCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bigImgCard, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(BigImgCard bigImgCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bigImgCard) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f45562f.getLayoutParams();
            if (bigImgCard.getRatio() > 0.0d) {
                int ratio = (int) (bigImgCard.getRatio() * n.k(getContext()));
                if (Math.abs(ratio - layoutParams.height) > 10) {
                    layoutParams.height = ratio;
                    this.f45562f.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams.height = (int) ((n.k(getContext()) * 0.5f) + 0.5f);
                this.f45562f.setLayoutParams(layoutParams);
            }
            this.f45562f.startLoad(bigImgCard.getUrl(), 10, false);
        }
    }
}
