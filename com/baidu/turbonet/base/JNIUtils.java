package com.baidu.turbonet.base;

import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes19.dex */
public class JNIUtils {
    @CalledByNative
    public static Object getClassLoader() {
        return JNIUtils.class.getClassLoader();
    }
}
