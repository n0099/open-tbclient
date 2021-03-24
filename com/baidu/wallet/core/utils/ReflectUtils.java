package com.baidu.wallet.core.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class ReflectUtils {
    public static Object getProviderObject(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Constructor<?> constructor = cls.getConstructor(new Class[0]);
                Object newInstance = cls.newInstance();
                newInstance.getClass();
                return constructor != null ? constructor.newInstance(new Object[0]) : newInstance;
            }
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
