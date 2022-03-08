package com.baidu.wallet.base.widget.compromtion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class BasePromotionAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BasePromotionAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public CommonPromotionView createAdapterView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            CommonPromotionView commonPromotionView = new CommonPromotionView(context);
            commonPromotionView.setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl()).setDefRightDrawable(getDefRightDraw()).setBackGroundColor(getBackGround()).setCenText(getCenText()).setCenTextColor(getTextColor());
            return commonPromotionView;
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    public int getBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract CharSequence getCenText();

    public abstract View.OnClickListener getClickListener();

    public abstract Drawable getDefLeftDraw();

    public abstract Drawable getDefRightDraw();

    public abstract String getLeftUrl();

    public String getRightUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
