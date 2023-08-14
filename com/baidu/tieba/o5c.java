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
/* loaded from: classes7.dex */
public class o5c {
    public static /* synthetic */ Interceptable $ic;
    public static final o5c f;
    public static final k5c g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<k5c> a;
    public final AtomicReference<m5c> b;
    public final AtomicReference<q5c> c;
    public final AtomicReference<j5c> d;
    public final AtomicReference<p5c> e;

    /* loaded from: classes7.dex */
    public static class a extends k5c {
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

    /* loaded from: classes7.dex */
    public class b extends j5c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(o5c o5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o5cVar};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947984684, "Lcom/baidu/tieba/o5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947984684, "Lcom/baidu/tieba/o5c;");
                return;
            }
        }
        f = new o5c();
        g = new a();
    }

    @Deprecated
    public static o5c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (o5c) invokeV.objValue;
    }

    public o5c() {
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

    public j5c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.get() == null) {
                Object e = e(j5c.class, System.getProperties());
                if (e == null) {
                    this.d.compareAndSet(null, new b(this));
                } else {
                    this.d.compareAndSet(null, (j5c) e);
                }
            }
            return this.d.get();
        }
        return (j5c) invokeV.objValue;
    }

    public k5c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e = e(k5c.class, System.getProperties());
                if (e == null) {
                    this.a.compareAndSet(null, g);
                } else {
                    this.a.compareAndSet(null, (k5c) e);
                }
            }
            return this.a.get();
        }
        return (k5c) invokeV.objValue;
    }

    public m5c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.get() == null) {
                Object e = e(m5c.class, System.getProperties());
                if (e == null) {
                    this.b.compareAndSet(null, n5c.f());
                } else {
                    this.b.compareAndSet(null, (m5c) e);
                }
            }
            return this.b.get();
        }
        return (m5c) invokeV.objValue;
    }

    public p5c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e.get() == null) {
                Object e = e(p5c.class, System.getProperties());
                if (e == null) {
                    this.e.compareAndSet(null, p5c.h());
                } else {
                    this.e.compareAndSet(null, (p5c) e);
                }
            }
            return this.e.get();
        }
        return (p5c) invokeV.objValue;
    }

    public q5c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.get() == null) {
                Object e = e(q5c.class, System.getProperties());
                if (e == null) {
                    this.c.compareAndSet(null, r5c.e());
                } else {
                    this.c.compareAndSet(null, (q5c) e);
                }
            }
            return this.c.get();
        }
        return (q5c) invokeV.objValue;
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
