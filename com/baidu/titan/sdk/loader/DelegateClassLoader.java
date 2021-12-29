package com.baidu.titan.sdk.loader;

import dalvik.system.DexClassLoader;
/* loaded from: classes13.dex */
public class DelegateClassLoader extends DexClassLoader {
    public final ClassLoader mDelegateClassLoader;

    public DelegateClassLoader(String str, String str2, String str3, ClassLoader classLoader, ClassLoader classLoader2) {
        super(str, str2, str3, classLoader);
        this.mDelegateClassLoader = classLoader2;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return super.findClass(str);
        } catch (ClassNotFoundException unused) {
            ClassLoader classLoader = this.mDelegateClassLoader;
            if (classLoader != null) {
                return classLoader.loadClass(str);
            }
            throw new ClassNotFoundException("can not find class " + str);
        }
    }
}
