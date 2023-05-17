package com.bytedance.pangle;

import android.os.Build;
import androidx.annotation.Keep;
import dalvik.system.DexClassLoader;
import java.util.HashSet;
import java.util.List;
@Keep
/* loaded from: classes8.dex */
public class PluginClassLoader extends DexClassLoader {
    public static final String TAG = "PluginClassLoader";
    public HashSet<String> allPluginClasses;
    public final ClassLoader hostClassLoader;
    public final List<ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(String str, String str2, String str3, List<ClassLoader> list) {
        super(str, str2, str3, DexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            classNotFoundException.addSuppressed(classNotFoundException2);
            return classNotFoundException;
        }
        sb.append(classNotFoundException2.getCause());
        sb.append("\n");
        return new ClassNotFoundException(sb.toString(), classNotFoundException2);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) {
        List<ClassLoader> list;
        HashSet<String> hashSet = this.allPluginClasses;
        Class<?> cls = null;
        if (hashSet != null && !hashSet.contains(str)) {
            e = null;
        } else {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (ClassNotFoundException e) {
                e = e;
            }
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            for (ClassLoader classLoader : list) {
                try {
                    cls = classLoader.loadClass(str);
                } catch (ClassNotFoundException e2) {
                    e = handleException(sb, e, e2);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e3) {
                e = handleException(sb, e, e3);
            }
        }
        if (cls == null) {
            if (e == null) {
                throw new ClassNotFoundException(str + " class not found in PluginClassLoader");
            }
            throw e;
        }
        return cls;
    }

    public void setAllPluginClasses(HashSet<String> hashSet) {
        this.allPluginClasses = hashSet;
    }
}
