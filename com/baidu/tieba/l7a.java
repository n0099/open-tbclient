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
/* loaded from: classes5.dex */
public class l7a {
    public static /* synthetic */ Interceptable $ic;
    public static final l7a f;
    public static final h7a g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<h7a> a;
    public final AtomicReference<j7a> b;
    public final AtomicReference<n7a> c;
    public final AtomicReference<g7a> d;
    public final AtomicReference<m7a> e;

    /* loaded from: classes5.dex */
    public static class a extends h7a {
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

    /* loaded from: classes5.dex */
    public class b extends g7a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(l7a l7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7aVar};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897171, "Lcom/baidu/tieba/l7a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897171, "Lcom/baidu/tieba/l7a;");
                return;
            }
        }
        f = new l7a();
        g = new a();
    }

    @Deprecated
    public static l7a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (l7a) invokeV.objValue;
    }

    public l7a() {
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

    public g7a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.get() == null) {
                Object e = e(g7a.class, System.getProperties());
                if (e == null) {
                    this.d.compareAndSet(null, new b(this));
                } else {
                    this.d.compareAndSet(null, (g7a) e);
                }
            }
            return this.d.get();
        }
        return (g7a) invokeV.objValue;
    }

    public h7a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e = e(h7a.class, System.getProperties());
                if (e == null) {
                    this.a.compareAndSet(null, g);
                } else {
                    this.a.compareAndSet(null, (h7a) e);
                }
            }
            return this.a.get();
        }
        return (h7a) invokeV.objValue;
    }

    public j7a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.get() == null) {
                Object e = e(j7a.class, System.getProperties());
                if (e == null) {
                    this.b.compareAndSet(null, k7a.f());
                } else {
                    this.b.compareAndSet(null, (j7a) e);
                }
            }
            return this.b.get();
        }
        return (j7a) invokeV.objValue;
    }

    public m7a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e.get() == null) {
                Object e = e(m7a.class, System.getProperties());
                if (e == null) {
                    this.e.compareAndSet(null, m7a.h());
                } else {
                    this.e.compareAndSet(null, (m7a) e);
                }
            }
            return this.e.get();
        }
        return (m7a) invokeV.objValue;
    }

    public n7a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.get() == null) {
                Object e = e(n7a.class, System.getProperties());
                if (e == null) {
                    this.c.compareAndSet(null, o7a.e());
                } else {
                    this.c.compareAndSet(null, (n7a) e);
                }
            }
            return this.c.get();
        }
        return (n7a) invokeV.objValue;
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
