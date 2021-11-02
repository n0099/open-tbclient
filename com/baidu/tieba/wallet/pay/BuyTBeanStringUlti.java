package com.baidu.tieba.wallet.pay;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BuyTBeanStringUlti {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BuyTBeanStringUlti() {
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

    public static String formatTBeanNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            String valueOf = String.valueOf(i2);
            if (i2 >= 1000000) {
                float f2 = i2 / 10000.0f;
                int i3 = i2 / 10000;
                if (f2 > i3) {
                    return String.format("%.1f", Float.valueOf(f2));
                }
                return i3 + "";
            }
            return valueOf;
        }
        return (String) invokeI.objValue;
    }

    public static void setSpan(SpannableString spannableString, String str, String str2, CharacterStyle characterStyle) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, spannableString, str, str2, characterStyle) == null) || spannableString == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || characterStyle == null || (indexOf = str.indexOf(str2)) < 0) {
            return;
        }
        spannableString.setSpan(characterStyle, indexOf, str2.length() + indexOf, 33);
    }
}
