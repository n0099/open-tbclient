package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes6.dex */
public interface yq0 extends Dns {
    public static final ServiceReference d = new ServiceReference("nad.core", "httpdns");

    /* loaded from: classes6.dex */
    public static class a implements yq0 {
        public static /* synthetic */ Interceptable $ic;
        public static final yq0 a;
        public static yq0 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-252295340, "Lcom/baidu/tieba/yq0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-252295340, "Lcom/baidu/tieba/yq0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static yq0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (b == null) {
                    synchronized (a.class) {
                        if (b == null) {
                            b = (yq0) ServiceManager.getService(yq0.d);
                        }
                        if (b == null) {
                            b = a;
                        }
                    }
                }
                return b;
            }
            return (yq0) invokeV.objValue;
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return Dns.SYSTEM.lookup(str);
            }
            return (List) invokeL.objValue;
        }
    }
}
