package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f27736a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(f27736a)) {
                String str = "miitmdid(sdkv_" + sysParamters.a().c() + SmallTailInfo.EMOTION_SUFFIX;
                f27736a = str;
                return str;
            }
            return f27736a;
        }
        return (String) invokeV.objValue;
    }
}
