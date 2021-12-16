package com.baidu.wallet.base.widget.compromtion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class CommonPromotionView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public NetImageView leftDraw;
    public View mView;
    public TextView promotionTxt;
    public ImageView rigthDraw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPromotionView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 33;
        initViews();
    }

    public String getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "wallet_base_promotion_layout" : (String) invokeV.objValue;
    }

    public int getMarginLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 33;
        }
        return invokeV.intValue;
    }

    public int getMarginRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 33;
        }
        return invokeV.intValue;
    }

    public void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(getContext(), ResUtils.layout(getContext(), getLayout()), null);
            this.mView = inflate;
            inflate.setBackgroundColor(ResUtils.getColor(inflate.getContext(), "wallet_base_promotion_bg"));
            View view = this.mView;
            NetImageView netImageView = (NetImageView) view.findViewById(ResUtils.id(view.getContext(), "wallet_charge_promotion_img"));
            this.leftDraw = netImageView;
            netImageView.setVisibility(8);
            View view2 = this.mView;
            ImageView imageView = (ImageView) view2.findViewById(ResUtils.id(view2.getContext(), "wallet_charge_promotion_image_del"));
            this.rigthDraw = imageView;
            imageView.setVisibility(8);
            View view3 = this.mView;
            this.promotionTxt = (TextView) view3.findViewById(ResUtils.id(view3.getContext(), "wallet_promotion_txt"));
            addView(this.mView);
        }
    }

    public CommonPromotionView setBackGroundColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mView.setBackgroundColor(i2);
            return this;
        }
        return (CommonPromotionView) invokeI.objValue;
    }

    public CommonPromotionView setCenText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequence)) == null) {
            this.promotionTxt.setText(Html.fromHtml(charSequence.toString()));
            return this;
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    public CommonPromotionView setCenTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.promotionTxt.setTextColor(i2);
            return this;
        }
        return (CommonPromotionView) invokeI.objValue;
    }

    public CommonPromotionView setClickRightImgToClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            setRightImgClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.compromtion.CommonPromotionView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CommonPromotionView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.setVisibility(8);
                    }
                }
            });
            return this;
        }
        return (CommonPromotionView) invokeV.objValue;
    }

    public CommonPromotionView setDefLeftDrawable(Drawable drawable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable, str)) == null) {
            if (drawable == null) {
                return this;
            }
            this.leftDraw.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.promotionTxt.getLayoutParams();
            layoutParams.setMargins(DisplayUtils.dip2px(this.mView.getContext(), getMarginLeft()), 0, layoutParams.rightMargin, 0);
            this.leftDraw.setImageDrawable(drawable);
            if (!TextUtils.isEmpty(str)) {
                this.leftDraw.setImageUrl(str);
            }
            return this;
        }
        return (CommonPromotionView) invokeLL.objValue;
    }

    public CommonPromotionView setDefRightDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, drawable)) == null) {
            if (drawable == null) {
                return this;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.promotionTxt.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, DisplayUtils.dip2px(this.mView.getContext(), getMarginRight()), 0);
            this.rigthDraw.setImageDrawable(drawable);
            this.rigthDraw.setVisibility(0);
            return this;
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    public CommonPromotionView setRightImgClickListener(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onClickListener)) == null) {
            if (onClickListener != null) {
                this.rigthDraw.setOnClickListener(onClickListener);
            }
            return this;
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    public CommonPromotionView setTextClickListener(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onClickListener)) == null) {
            if (onClickListener == null) {
                return this;
            }
            this.mView.setOnClickListener(onClickListener);
            return this;
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 33;
        initViews();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonPromotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 33;
        initViews();
    }
}
