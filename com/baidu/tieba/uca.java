package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class uca {
    public static /* synthetic */ Interceptable $ic;
    public static final uca f;
    public static final qca g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<qca> a;
    public final AtomicReference<sca> b;
    public final AtomicReference<wca> c;
    public final AtomicReference<pca> d;
    public final AtomicReference<vca> e;

    /* loaded from: classes6.dex */
    public static class a extends qca {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends pca {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(uca ucaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ucaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207574, "Lcom/baidu/tieba/uca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207574, "Lcom/baidu/tieba/uca;");
                return;
            }
        }
        f = new uca();
        g = new a();
    }

    @Deprecated
    public static uca c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (uca) invokeV.objValue;
    }

    public uca() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicReference<>();
        this.b = new AtomicReference<>();
        this.c = new AtomicReference<>();
        this.d = new AtomicReference<>();
        this.e = new AtomicReference<>();
    }

    public pca a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.get() == null) {
                Object e = e(pca.class, System.getProperties());
                if (e == null) {
                    this.d.compareAndSet(null, new b(this));
                } else {
                    this.d.compareAndSet(null, (pca) e);
                }
            }
            return this.d.get();
        }
        return (pca) invokeV.objValue;
    }

    public qca b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e = e(qca.class, System.getProperties());
                if (e == null) {
                    this.a.compareAndSet(null, g);
                } else {
                    this.a.compareAndSet(null, (qca) e);
                }
            }
            return this.a.get();
        }
        return (qca) invokeV.objValue;
    }

    public sca d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.get() == null) {
                Object e = e(sca.class, System.getProperties());
                if (e == null) {
                    this.b.compareAndSet(null, tca.f());
                } else {
                    this.b.compareAndSet(null, (sca) e);
                }
            }
            return this.b.get();
        }
        return (sca) invokeV.objValue;
    }

    public vca f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e.get() == null) {
                Object e = e(vca.class, System.getProperties());
                if (e == null) {
                    this.e.compareAndSet(null, vca.h());
                } else {
                    this.e.compareAndSet(null, (vca) e);
                }
            }
            return this.e.get();
        }
        return (vca) invokeV.objValue;
    }

    public wca g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.get() == null) {
                Object e = e(wca.class, System.getProperties());
                if (e == null) {
                    this.c.compareAndSet(null, xca.e());
                } else {
                    this.c.compareAndSet(null, (wca) e);
                }
            }
            return this.c.get();
        }
        return (wca) invokeV.objValue;
    }

    public static Object e(Class<?> cls, Properties properties) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, properties)) == null) {
            Properties properties2 = (Properties) properties.clone();
            String simpleName = cls.getSimpleName();
            String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
            if (property == null) {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                        String property2 = properties2.getProperty(str);
                        if (property2 != null) {
                            property = property2;
                        } else {
                            throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                        }
                    }
                }
            }
            if (property != null) {
                try {
                    return Class.forName(property).asSubclass(cls).newInstance();
                } catch (ClassCastException e) {
                    throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e);
                } catch (ClassNotFoundException e2) {
                    throw new IllegalStateException(simpleName + " implementation class not found: " + property, e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e3);
                } catch (InstantiationException e4) {
                    throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e4);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
