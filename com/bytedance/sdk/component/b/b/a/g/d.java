package com.bytedance.sdk.component.b.b.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f65138a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65139b;

    /* renamed from: c  reason: collision with root package name */
    public final Class[] f65140c;

    public d(Class<?> cls, String str, Class... clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, str, clsArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65138a = cls;
        this.f65139b = str;
        this.f65140c = clsArr;
    }

    public boolean a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? a(t.getClass()) != null : invokeL.booleanValue;
    }

    public Object b(T t, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, objArr)) == null) {
            try {
                return a(t, objArr);
            } catch (InvocationTargetException e2) {
                Throwable targetException = e2.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                AssertionError assertionError = new AssertionError("Unexpected exception");
                assertionError.initCause(targetException);
                throw assertionError;
            }
        }
        return invokeLL.objValue;
    }

    public Object c(T t, Object... objArr) throws InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t, objArr)) == null) {
            Method a2 = a(t.getClass());
            if (a2 != null) {
                try {
                    return a2.invoke(t, objArr);
                } catch (IllegalAccessException e2) {
                    AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
                    assertionError.initCause(e2);
                    throw assertionError;
                }
            }
            throw new AssertionError("Method " + this.f65139b + " not supported for object " + t);
        }
        return invokeLL.objValue;
    }

    public Object d(T t, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, t, objArr)) == null) {
            try {
                return c(t, objArr);
            } catch (InvocationTargetException e2) {
                Throwable targetException = e2.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                AssertionError assertionError = new AssertionError("Unexpected exception");
                assertionError.initCause(targetException);
                throw assertionError;
            }
        }
        return invokeLL.objValue;
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, objArr)) == null) {
            Method a2 = a(t.getClass());
            if (a2 == null) {
                return null;
            }
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }

    private Method a(Class<?> cls) {
        InterceptResult invokeL;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            String str = this.f65139b;
            if (str != null) {
                Method a2 = a(cls, str, this.f65140c);
                if (a2 == null || (cls2 = this.f65138a) == null || cls2.isAssignableFrom(a2.getReturnType())) {
                    return a2;
                }
                return null;
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                try {
                    if ((method.getModifiers() & 1) == 0) {
                        return null;
                    }
                } catch (NoSuchMethodException unused) {
                }
                return method;
            } catch (NoSuchMethodException unused2) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }
}
