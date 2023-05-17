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
/* loaded from: classes8.dex */
public class CurrencySwitchUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isYyIsConvert(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    public CurrencySwitchUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public static Drawable getNormalSkinMoneyIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (isYyIsConvert()) {
                return SkinManager.getDrawable(0, (int) R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getDrawable(0, (int) R.drawable.icon_huobi_tdou);
        }
        return (Drawable) invokeV.objValue;
    }

    public static int getGiftMoneyIconResId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (isYyIsConvert(i)) {
                return R.drawable.icon_gift_my_ydou;
            }
            return R.drawable.icon_gift_my_tdou;
        }
        return invokeI.intValue;
    }

    public static Drawable getMoneyIcon(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (isYyIsConvert(i)) {
                return SkinManager.getDrawable(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        }
        return (Drawable) invokeI.objValue;
    }

    public static Bitmap getMoneyIconBitmap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (isYyIsConvert(i)) {
                return SkinManager.getBitmap(R.drawable.icon_huobi_ydou);
            }
            return SkinManager.getBitmap(R.drawable.icon_huobi_tdou);
        }
        return (Bitmap) invokeI.objValue;
    }

    public static boolean isNeedConfirmTDouToYBeanSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TbSingleton.getInstance() != null && TbSingleton.getInstance().getYYLiveConfig() != null) {
                return TbSingleton.getInstance().getYYLiveConfig().isYYPayNeedConfirm();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isYyIsConvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (TbSingleton.getInstance() != null && TbSingleton.getInstance().getYYLiveConfig() != null) {
                return TbSingleton.getInstance().getYYLiveConfig().isYyIsConvert();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
