package com.baidu.ufosdk.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes10.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (com.baidu.ufosdk.b.ab == null) {
                com.baidu.ufosdk.b.ab = UfoSDK.getChineseMap();
            }
            return com.baidu.ufosdk.b.ab.containsKey(str) ? (String) com.baidu.ufosdk.b.ab.get(str) : "";
        }
        return (String) invokeL.objValue;
    }
}
