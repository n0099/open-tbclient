package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class x71 extends PathClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ClassLoader a;
    public Method b;
    public Method c;
    public Method d;
    public Method e;
    public Set<String> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x71(ClassLoader classLoader, ClassLoader classLoader2) {
        super("", "", classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader, classLoader2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (ClassLoader) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new HashSet();
        this.a = classLoader2;
        b(classLoader2);
        c(classLoader2);
        this.f.add("android.widget.ViewStub");
        this.f.add("android.widget.View");
        this.f.add("android.webkit.ViewStub");
        this.f.add("android.webkit.View");
        this.f.add("android.app.ViewStub");
        this.f.add("android.app.View");
        this.f.add("com.google.android.gms.net.PlayServicesCronetProvider");
        this.f.add("com.google.android.gms.net.GmsCoreCronetProvider");
        this.f.add("org.chromium.net.impl.JavaCronetProvider");
    }

    public final void a(String str, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, classLoader) == null) {
            try {
                Field b = j91.b(classLoader.getClass(), str);
                j91.h(b);
                j91.l(b, this, j91.g(b, classLoader));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public final void b(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, classLoader) == null) {
            a("pathList", classLoader);
        }
    }

    public final void c(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, classLoader) == null) {
            Class<?> cls = classLoader.getClass();
            Method c = j91.c(cls, "findResource", String.class);
            this.b = c;
            c.setAccessible(true);
            Method c2 = j91.c(cls, "findResources", String.class);
            this.c = c2;
            c2.setAccessible(true);
            Method c3 = j91.c(cls, "findLibrary", String.class);
            this.d = c3;
            c3.setAccessible(true);
            Method c4 = j91.c(cls, "getPackage", String.class);
            this.e = c4;
            c4.setAccessible(true);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? super.findClass(str) : (Class) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return (String) this.d.invoke(this.a, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return super.findLibrary(str);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return super.findLibrary(str);
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return super.findLibrary(str);
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return (URL) this.b.invoke(this.a, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return super.findResource(str);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return super.findResource(str);
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return super.findResource(str);
            }
        }
        return (URL) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return (Enumeration) this.c.invoke(this.a, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return super.findResources(str);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return super.findResources(str);
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return super.findResources(str);
            }
        }
        return (Enumeration) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Package getPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Package r0 = null;
            if (str != null && !str.isEmpty()) {
                try {
                    r0 = (Package) this.e.invoke(this.a, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                if (r0 == null) {
                    r0 = super.getPackage(str);
                }
                if (r0 == null) {
                    return definePackage(str, "Unknown", "0.0", "Unknown", "Unknown", "0.0", "Unknown", null);
                }
            }
            return r0;
        }
        return (Package) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> loadComponentClass;
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            try {
                return this.a.loadClass(str);
            } catch (ClassNotFoundException unused) {
                return (this.f.contains(str) || (loadComponentClass = NPSManager.getInstance().loadComponentClass(str)) == null) ? super.loadClass(str, z) : loadComponentClass;
            }
        }
        return (Class) invokeLZ.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return x71.class.getName() + "[mBase=" + this.a.toString() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
