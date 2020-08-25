package com.baidu.turbonet.base;

import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes10.dex */
public class JNIUtils {
    @CalledByNative
    public static Object getClassLoader() {
        return JNIUtils.class.getClassLoader();
    }
}
