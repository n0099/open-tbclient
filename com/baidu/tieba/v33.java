package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
public class v33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189811, "Lcom/baidu/tieba/v33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189811, "Lcom/baidu/tieba/v33;");
                return;
            }
        }
        a = eo1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void a(int i, String str, String str2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, str2, bundle}) == null) {
            u33 b = b(str);
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

    @SuppressLint({"BDThrowableCheck"})
    public static u33 b(@Nullable String str) {
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
                if (u33.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    if (!(newInstance instanceof u33)) {
                        if (!a) {
                            return null;
                        }
                        throw new RuntimeException("Messenger代理类不是:" + u33.class.getName());
                    }
                    return (u33) newInstance;
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
        return (u33) invokeL.objValue;
    }

    public static void c(int i, String str, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(65539, null, i, str, bundle) != null) || c43.a(str)) {
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
            n43.f(bundle2);
        } else {
            n43.e(i, bundle2);
        }
    }
}
