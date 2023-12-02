package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class y97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ThemeCardInUserData themeCardInUserData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeCardInUserData)) == null) {
            if (themeCardInUserData == null) {
                return false;
            }
            String cardImageUrlAndroid = themeCardInUserData.getCardImageUrlAndroid();
            if (cardImageUrlAndroid != null && cardImageUrlAndroid.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final ThemeCardInUserData b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject a = rn6.a.a(str);
            if (a == null) {
                return null;
            }
            ThemeCardInUserData themeCardInUserData = new ThemeCardInUserData();
            themeCardInUserData.parser(a);
            return themeCardInUserData;
        }
        return (ThemeCardInUserData) invokeL.objValue;
    }
}
