package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.tieba.nu6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class wy8 extends pl1<nu6.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final Map<BdUniqueId, ConcurrentLinkedQueue<ku6>> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948287027, "Lcom/baidu/tieba/wy8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948287027, "Lcom/baidu/tieba/wy8;");
                return;
            }
        }
        a = new Object();
        b = new HashMap();
    }

    public wy8() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pl1
    /* renamed from: c */
    public nu6.a createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new nu6.a() { // from class: com.baidu.tieba.uy8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.nu6.a
                public final void a(BdUniqueId bdUniqueId) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdUniqueId) == null) {
                        wy8.b(bdUniqueId);
                    }
                }
            };
        }
        return (nu6.a) invokeV.objValue;
    }

    public static void a(@NonNull ku6 ku6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ku6Var) == null) {
            BdUniqueId a2 = ku6Var.a();
            ConcurrentLinkedQueue<ku6> concurrentLinkedQueue = b.get(a2);
            if (concurrentLinkedQueue == null) {
                synchronized (a) {
                    concurrentLinkedQueue = b.get(a2);
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        b.put(a2, concurrentLinkedQueue);
                    }
                }
            }
            synchronized (a) {
                concurrentLinkedQueue.add(ku6Var);
            }
        }
    }

    public static void b(BdUniqueId bdUniqueId) {
        ConcurrentLinkedQueue<ku6> concurrentLinkedQueue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, bdUniqueId) == null) && (concurrentLinkedQueue = b.get(bdUniqueId)) != null) {
            synchronized (a) {
                Iterator<ku6> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    BdEventBus.Companion.getDefault().unregister(it.next());
                }
                concurrentLinkedQueue.clear();
                b.remove(bdUniqueId);
            }
        }
    }

    public static void d(@NonNull ku6 ku6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ku6Var) == null) {
            BdUniqueId a2 = ku6Var.a();
            ConcurrentLinkedQueue<ku6> concurrentLinkedQueue = b.get(a2);
            if (concurrentLinkedQueue == null) {
                synchronized (a) {
                    ConcurrentLinkedQueue<ku6> concurrentLinkedQueue2 = b.get(a2);
                    if (concurrentLinkedQueue2 != null) {
                        concurrentLinkedQueue2.remove(ku6Var);
                    }
                }
                return;
            }
            synchronized (a) {
                concurrentLinkedQueue.remove(ku6Var);
            }
        }
    }
}
