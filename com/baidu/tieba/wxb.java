package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public class wxb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wxb c;
    public transient /* synthetic */ FieldHolder $fh;
    public TreeMap<Integer, a> a;
    public TreeMap<Integer, TreeSet<String>> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948287368, "Lcom/baidu/tieba/wxb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948287368, "Lcom/baidu/tieba/wxb;");
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;

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
                    return;
                }
            }
            this.a = false;
            this.b = false;
        }
    }

    public wxb() {
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
        this.a = new TreeMap<>();
        this.b = new TreeMap<>();
    }

    public static wxb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (wxb.class) {
                    if (c == null) {
                        c = new wxb();
                    }
                }
            }
            return c;
        }
        return (wxb) invokeV.objValue;
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.b.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int d() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                size = this.a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, TreeSet<String>> entry : this.b.entrySet()) {
                    i += entry.getValue().size();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, a> entry : this.a.entrySet()) {
                    if (entry.getValue().a && entry.getValue().b) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int i() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, a> entry : this.a.entrySet()) {
                    if (entry.getValue().a) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized void e(tvb tvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tvbVar) == null) {
            synchronized (this) {
                if (tvbVar != null) {
                    if (!this.a.containsKey(Integer.valueOf(tvbVar.hashCode()))) {
                        this.a.put(Integer.valueOf(tvbVar.hashCode()), new a());
                    }
                }
            }
        }
    }

    public synchronized void h(tvb tvbVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tvbVar) == null) {
            synchronized (this) {
                if (tvbVar != null) {
                    if (this.a.containsKey(Integer.valueOf(tvbVar.hashCode())) && (aVar = this.a.get(Integer.valueOf(tvbVar.hashCode()))) != null) {
                        aVar.a = false;
                        aVar.b = false;
                    }
                }
            }
        }
    }

    public synchronized void g(tvb tvbVar, int i, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tvbVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (tvbVar != null) {
                    if (this.a.containsKey(Integer.valueOf(tvbVar.hashCode())) && (aVar = this.a.get(Integer.valueOf(tvbVar.hashCode()))) != null) {
                        aVar.a = true;
                        aVar.b = z;
                    }
                }
            }
        }
    }
}
