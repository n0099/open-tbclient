package com.baidu.tieba.wallet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class CurrencySwitchUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CurrencySwitchUtil() {
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

    public static int getGiftMoneyIconResId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (isYyIsConvert(i2)) {
                return R.drawable.icon_gift_my_ydou;
            }
            return R.drawable.icon_gift_my_tdou;
        }
        return invokeI.intValue;
    }

    public static Drawable getMoneyIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (isYyIsConvert()) {
                return SkinManager.getDrawable(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        }
        return (Drawable) invokeV.objValue;
    }

    public static Bitmap getMoneyIconBitmap(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if (isYyIsConvert(i2)) {
                return SkinManager.getBitmap(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getBitmap(R.drawable.icon_huobi_tdou);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static Drawable getNormalSkinMoneyIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (isYyIsConvert()) {
                return SkinManager.getDrawable(0, R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getDrawable(0, R.drawable.icon_huobi_tdou);
        }
        return (Drawable) invokeV.objValue;
    }

    public static boolean isNeedConfirmTDouToYBeanSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TbSingleton.getInstance() == null || TbSingleton.getInstance().getYYLiveConfig() == null) {
                return false;
            }
            return TbSingleton.getInstance().getYYLiveConfig().isYYPayNeedConfirm();
        }
        return invokeV.booleanValue;
    }

    public static boolean isYyIsConvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (TbSingleton.getInstance() == null || TbSingleton.getInstance().getYYLiveConfig() == null) {
                return false;
            }
            return TbSingleton.getInstance().getYYLiveConfig().isYyIsConvert();
        }
        return invokeV.booleanValue;
    }

    public static boolean isYyIsConvert(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 == 1 : invokeI.booleanValue;
    }

    public static Drawable getMoneyIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (isYyIsConvert(i2)) {
                return SkinManager.getDrawable(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        }
        return (Drawable) invokeI.objValue;
    }

    public static Bitmap getMoneyIconBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (isYyIsConvert()) {
                return SkinManager.getBitmap(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getBitmap(R.drawable.icon_huobi_tdou);
        }
        return (Bitmap) invokeV.objValue;
    }
}
