package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public class nz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948019683, "Lcom/baidu/tieba/nz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948019683, "Lcom/baidu/tieba/nz2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a(int i, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, str2, bundle}) == null) {
            mz2 b = b(str);
            if (b == null) {
                if (!a) {
                    c(i, str2, null);
                    return;
                }
                throw new RuntimeException("Messenger创建代理类失败");
            }
            if (a) {
                Log.d("MDelegate-Delegation", "exec call messenger delegation: " + str);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            b.a = bundle;
            b.b = i;
            b.c = str2;
            b.b(bundle);
        }
    }

    public static mz2 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.e("MDelegate-Delegation", "create delegation with null delegate name");
                }
                return null;
            }
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null) {
                    if (!a) {
                        return null;
                    }
                    throw new RuntimeException("Messenger代理类不存在：" + str);
                }
                int modifiers = cls.getModifiers();
                if (mz2.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    if (!(newInstance instanceof mz2)) {
                        if (!a) {
                            return null;
                        }
                        throw new RuntimeException("Messenger代理类不是:" + mz2.class.getName());
                    }
                    return (mz2) newInstance;
                }
                if (!a) {
                    return null;
                }
                throw new RuntimeException("Messenger代理类不合法：" + str);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                if (!a) {
                    return null;
                }
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return (mz2) invokeL.objValue;
    }

    public static void c(int i, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(65539, null, i, str, bundle) != null) || uz2.a(str)) {
            return;
        }
        if (a) {
            Log.d("MDelegate-Delegation", "send result to client: " + i + " observer: " + str);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_observer_id", str);
        if (bundle != null) {
            bundle2.putBundle("key_result_data", bundle);
        }
        if (i == -1000) {
            f03.f(bundle2);
        } else {
            f03.e(i, bundle2);
        }
    }
}
