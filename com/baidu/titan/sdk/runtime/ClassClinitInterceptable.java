package com.baidu.titan.sdk.runtime;
/* loaded from: classes6.dex */
public interface ClassClinitInterceptable {
    InterceptResult invokeClinit(int i, String str);

    InterceptResult invokePostClinit(int i, String str);
}
