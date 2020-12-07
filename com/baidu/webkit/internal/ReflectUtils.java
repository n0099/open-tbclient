package com.baidu.webkit.internal;

import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class ReflectUtils implements INoProGuard {
    private static String sReflectErrorDetail = "none";

    public static void expandPathList(File file, Class<?> cls) {
        try {
            Object pathList = getPathList((BaseDexClassLoader) cls.getClassLoader());
            Field declaredField = pathList.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField.setAccessible(true);
            File[] fileArr = (File[]) declaredField.get(pathList);
            Object newInstance = Array.newInstance(File.class, fileArr.length + 1);
            Array.set(newInstance, 0, file);
            for (int i = 1; i < fileArr.length + 1; i++) {
                Array.set(newInstance, i, fileArr[i - 1]);
            }
            declaredField.set(pathList, newInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void expandPathList(String str, Class<?> cls) {
        if (str != null) {
            expandPathList(new File(str), cls);
        }
    }

    public static Object getField(Object obj, Class cls, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Field getField(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            setReflectErrorDetail(th.toString());
            return null;
        }
    }

    public static Method getMethod(Class cls, String str, Class... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Throwable th) {
            setReflectErrorDetail(th.toString());
            return null;
        }
    }

    private static Object getPathList(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return getField(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    public static String getReflectErrorDetailAndReset() {
        String str = sReflectErrorDetail;
        sReflectErrorDetail = "none";
        return str == null ? "none" : str;
    }

    private static void setReflectErrorDetail(String str) {
        sReflectErrorDetail = str;
    }
}
