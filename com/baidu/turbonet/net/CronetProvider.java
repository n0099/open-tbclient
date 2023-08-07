package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public abstract class CronetProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "CronetProvider";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-454808743, "Lcom/baidu/turbonet/net/CronetProvider;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-454808743, "Lcom/baidu/turbonet/net/CronetProvider;");
        }
    }

    public abstract TurbonetEngine.Builder b();

    public abstract String d();

    public abstract String e();

    public abstract boolean f();

    public CronetProvider(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.a = context;
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    public static boolean a(Context context, String str, Set<CronetProvider> set, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, set, Boolean.valueOf(z)})) == null) {
            try {
                set.add((CronetProvider) context.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                return true;
            } catch (ClassNotFoundException e) {
                g(str, z, e);
                try {
                    set.add((CronetProvider) CronetProvider.class.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                    return true;
                } catch (ClassNotFoundException e2) {
                    g(str, z, e2);
                    return false;
                } catch (IllegalAccessException e3) {
                    g(str, z, e3);
                    return false;
                } catch (InstantiationException e4) {
                    g(str, z, e4);
                    return false;
                } catch (NoSuchMethodException e5) {
                    g(str, z, e5);
                    return false;
                } catch (InvocationTargetException e6) {
                    g(str, z, e6);
                    return false;
                }
            } catch (IllegalAccessException e7) {
                g(str, z, e7);
                set.add((CronetProvider) CronetProvider.class.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                return true;
            } catch (InstantiationException e8) {
                g(str, z, e8);
                set.add((CronetProvider) CronetProvider.class.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                return true;
            } catch (NoSuchMethodException e9) {
                g(str, z, e9);
                set.add((CronetProvider) CronetProvider.class.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                return true;
            } catch (InvocationTargetException e10) {
                g(str, z, e10);
                set.add((CronetProvider) CronetProvider.class.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static List<CronetProvider> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            a(context, "com.baidu.turbonet.net.impl.NativeCronetProvider", linkedHashSet, false);
            a(context, "com.baidu.turbonet.net.impl.JavaCronetProvider", linkedHashSet, false);
            return Collections.unmodifiableList(new ArrayList(linkedHashSet));
        }
        return (List) invokeL.objValue;
    }

    public static void g(String str, boolean z, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Boolean.valueOf(z), exc}) == null) {
            if (z) {
                String str2 = b;
                Log.e(str2, "Unable to load provider class: " + str, exc);
            } else if (Log.isLoggable(b, 3)) {
                String str3 = b;
                Log.d(str3, "Tried to load " + str + " provider class but it wasn't included in the app classpath");
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "[class=" + getClass().getName() + ", name=" + d() + ", version=" + e() + ", enabled=" + f() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
