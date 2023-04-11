package com.baidu.tieba;

import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: ApiReplaceUtil.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class q45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean $default$forceApi(ApiReplaceUtil.Getter.Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, action)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
