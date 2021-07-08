package com.baidu.titan.sdk.runtime;

import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
@DisableIntercept
/* loaded from: classes4.dex */
public interface ClassClinitInterceptable {
    InterceptResult invokeClinit(int i2, String str);

    InterceptResult invokePostClinit(int i2, String str);
}
