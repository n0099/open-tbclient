package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.chromium.base.UnownedUserData;
import org.chromium.base.UnownedUserDataHost;
/* compiled from: UnownedUserData.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class qhc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean $default$informOnDetachmentFromHost(UnownedUserData unownedUserData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, unownedUserData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void $default$onDetachedFromHost(UnownedUserData unownedUserData, UnownedUserDataHost unownedUserDataHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, unownedUserData, unownedUserDataHost) == null) {
        }
    }
}
