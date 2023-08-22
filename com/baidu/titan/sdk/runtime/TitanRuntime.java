package com.baidu.titan.sdk.runtime;

import com.baidu.titan.sdk.runtime.Log;
import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
@DisableIntercept
/* loaded from: classes9.dex */
public class TitanRuntime {
    public static Interceptable $ic;
    public static final ThreadLocal<WeakReference<InterceptResult>> sInterceptStorage = new ThreadLocal<>();
    public static final ThreadLocal<WeakReference<InitContext>> sInitContextStorage = new ThreadLocal<>();

    /* loaded from: classes9.dex */
    public interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }

    public static InitContext getInitContext() {
        return new InitContext();
    }

    public static InterceptResult getThreadInterceptResult() {
        InterceptResult interceptResult;
        WeakReference<InterceptResult> weakReference = sInterceptStorage.get();
        if (weakReference != null && (interceptResult = weakReference.get()) != null) {
            interceptResult.objValue = null;
            return interceptResult;
        }
        InterceptResult interceptResult2 = new InterceptResult();
        sInterceptStorage.set(new WeakReference<>(interceptResult2));
        return interceptResult2;
    }

    public static InitContext newInitContext() {
        return new InitContext();
    }

    public static Object getField(Object obj, Class cls, String str) {
        String str2;
        try {
            return getField(cls, str).get(obj);
        } catch (IllegalAccessException e) {
            Log.Logging logging = Log.logging;
            if (logging != null) {
                Level level = Level.SEVERE;
                Object[] objArr = new Object[2];
                if (obj == null) {
                    str2 = " static";
                } else {
                    str2 = "";
                }
                objArr[0] = str2;
                objArr[1] = str;
                logging.log(level, String.format("Exception during%1$s getField %2$s", objArr), e);
            }
            throw new RuntimeException(e);
        }
    }

    public static void trace(String str, String str2, String str3) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s %s", str, str2, str3));
        }
    }

    public static Field getField(Class cls, String str) {
        Field fieldByName = getFieldByName(cls, str);
        if (fieldByName != null) {
            fieldByName.setAccessible(true);
            return fieldByName;
        }
        throw new RuntimeException(new NoSuchElementException(str));
    }

    public static void trace(String str, String str2) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s", str, str2));
        }
    }

    public static Field getFieldByName(Class<?> cls, String str) {
        Log.Logging logging = Log.logging;
        if (logging != null && logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("getFieldByName:%s in %s", str, cls.getName()));
        }
        while (cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Method getMethodByName(Class<?> cls, String str, Class[] clsArr) {
        Log.Logging logging;
        if (cls == null) {
            return null;
        }
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
                if (cls != null && (logging = Log.logging) != null && logging.isLoggable(Level.FINE)) {
                    Log.logging.log(Level.FINE, String.format("getMethodByName:Looking in %s now", cls.getName()));
                }
            }
        }
        return null;
    }

    public static Object invokeInstanceMethod(Object obj, Object[] objArr, Class[] clsArr, String str) throws Throwable {
        Log.Logging logging = Log.logging;
        if (logging != null && logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("protectedMethod:%s on %s", str, obj));
        }
        try {
            Method methodByName = getMethodByName(obj.getClass(), str, clsArr);
            if (methodByName != null) {
                methodByName.setAccessible(true);
                return methodByName.invoke(obj, objArr);
            }
            throw new RuntimeException(new NoSuchMethodException(str));
        } catch (IllegalAccessException e) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", str), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getCause();
        }
    }

    public static Object invokeStaticMethod(Class cls, Object[] objArr, Class[] clsArr, String str) throws Throwable {
        Log.Logging logging = Log.logging;
        if (logging != null && logging.isLoggable(Level.FINE)) {
            Log.logging.log(Level.FINE, String.format("protectedStaticMethod:%s on %s", str, cls.getName()));
        }
        try {
            Method methodByName = getMethodByName(cls, str, clsArr);
            if (methodByName != null) {
                methodByName.setAccessible(true);
                return methodByName.invoke(null, objArr);
            }
            throw new RuntimeException(new NoSuchMethodException(str + " in class " + cls.getName()));
        } catch (IllegalAccessException e) {
            Log.logging.log(Level.SEVERE, String.format("Exception while invoking %s", str), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw e2.getCause();
        }
    }

    public static <T> T newForClass(Object[] objArr, Class[] clsArr, Class<T> cls) throws Throwable {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            try {
                return cls.cast(declaredConstructor.newInstance(objArr));
            } catch (IllegalAccessException e) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", cls), e);
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                Log.logging.log(Level.SEVERE, String.format("Exception while instantiating %s", cls), e2);
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw e3.getCause();
            }
        } catch (NoSuchMethodException e4) {
            Log.logging.log(Level.SEVERE, "Exception while resolving constructor", e4);
            throw new RuntimeException(e4);
        }
    }

    public static void setClassClinitInterceptor(ClassClinitInterceptable classClinitInterceptable) {
        ClassClinitInterceptorStorage.$ic = classClinitInterceptable;
    }

    public static void setLogger(final Logger logger) {
        Log.logging = new Log.Logging() { // from class: com.baidu.titan.sdk.runtime.TitanRuntime.1
            @Override // com.baidu.titan.sdk.runtime.Log.Logging
            public boolean isLoggable(Level level) {
                return logger.isLoggable(level);
            }

            @Override // com.baidu.titan.sdk.runtime.Log.Logging
            public void log(Level level, String str) {
                logger.log(level, str);
            }

            @Override // com.baidu.titan.sdk.runtime.Log.Logging
            public void log(Level level, String str, Throwable th) {
                logger.log(level, str, th);
            }
        };
    }

    public static void trace(String str) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, str);
        }
    }

    public static void setField(Object obj, Object obj2, Class cls, String str) {
        try {
            getField(cls, str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            Log.Logging logging = Log.logging;
            if (logging != null) {
                logging.log(Level.SEVERE, String.format("Exception during setPrivateField %s", str), e);
            }
            throw new RuntimeException(e);
        }
    }

    public static void trace(String str, String str2, String str3, String str4) {
        Log.Logging logging = Log.logging;
        if (logging != null) {
            logging.log(Level.FINE, String.format("%s %s %s %s", str, str2, str3, str4));
        }
    }
}
