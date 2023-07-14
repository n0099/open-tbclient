package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return "fun_ad_card_" + AdvertAppInfo.I.getId();
        }
        return (String) invokeV.objValue;
    }

    public static String b(@NonNull BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdUniqueId)) == null) {
            return "fun_ad_card_" + bdUniqueId.getId();
        }
        return (String) invokeL.objValue;
    }
}
