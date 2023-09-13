package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.tieba.ju6;
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
public class y19 extends bl1<ju6.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final Map<BdUniqueId, ConcurrentLinkedQueue<gu6>> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277448, "Lcom/baidu/tieba/y19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277448, "Lcom/baidu/tieba/y19;");
                return;
            }
        }
        a = new Object();
        b = new HashMap();
    }

    public y19() {
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
    @Override // com.baidu.tieba.bl1
    /* renamed from: c */
    public ju6.a createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ju6.a() { // from class: com.baidu.tieba.w19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ju6.a
                public final void a(BdUniqueId bdUniqueId) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdUniqueId) == null) {
                        y19.b(bdUniqueId);
                    }
                }
            };
        }
        return (ju6.a) invokeV.objValue;
    }

    public static void a(@NonNull gu6 gu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, gu6Var) == null) {
            BdUniqueId a2 = gu6Var.a();
            ConcurrentLinkedQueue<gu6> concurrentLinkedQueue = b.get(a2);
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
                concurrentLinkedQueue.add(gu6Var);
            }
        }
    }

    public static void b(BdUniqueId bdUniqueId) {
        ConcurrentLinkedQueue<gu6> concurrentLinkedQueue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, bdUniqueId) == null) && (concurrentLinkedQueue = b.get(bdUniqueId)) != null) {
            synchronized (a) {
                Iterator<gu6> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    BdEventBus.Companion.getDefault().unregister(it.next());
                }
                concurrentLinkedQueue.clear();
                b.remove(bdUniqueId);
            }
        }
    }

    public static void d(@NonNull gu6 gu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gu6Var) == null) {
            BdUniqueId a2 = gu6Var.a();
            ConcurrentLinkedQueue<gu6> concurrentLinkedQueue = b.get(a2);
            if (concurrentLinkedQueue == null) {
                synchronized (a) {
                    ConcurrentLinkedQueue<gu6> concurrentLinkedQueue2 = b.get(a2);
                    if (concurrentLinkedQueue2 != null) {
                        concurrentLinkedQueue2.remove(gu6Var);
                    }
                }
                return;
            }
            synchronized (a) {
                concurrentLinkedQueue.remove(gu6Var);
            }
        }
    }
}
