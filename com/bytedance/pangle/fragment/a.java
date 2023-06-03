package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public final class a {
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static void a(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) a(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field a = a(Fragment.class, "sClassMap");
            if (a != null) {
                ((SimpleArrayMap) a.get(null)).put(cls.getName(), cls);
                return;
            }
            Class a2 = a("androidx.fragment.app.FragmentFactory");
            if (a2 == null) {
                return;
            }
            Field a3 = a(a2, "sClassMap");
            if (a3 != null) {
                ((SimpleArrayMap) a3.get(null)).put(cls.getName(), cls);
                return;
            }
            Field a4 = a(a2, "sClassCacheMap");
            if (a4 != null) {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                simpleArrayMap.put(cls.getName(), cls);
                ((SimpleArrayMap) a4.get(null)).put(cls.getClassLoader(), simpleArrayMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
