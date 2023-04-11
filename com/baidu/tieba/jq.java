package com.baidu.tieba;

import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.PriorityQueue;
/* loaded from: classes5.dex */
public final class jq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a<T> implements Comparator<SubTaskState> {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(255093609, "Lcom/baidu/tieba/jq$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(255093609, "Lcom/baidu/tieba/jq$a;");
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(SubTaskState subTaskState, SubTaskState subTaskState2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, subTaskState, subTaskState2)) == null) {
                if (subTaskState.getTaskStatus().getCurActiveTime() - subTaskState2.getTaskStatus().getCurActiveTime() == 0) {
                    return 0;
                }
                if (subTaskState.getTaskStatus().getCurActiveTime() - subTaskState2.getTaskStatus().getCurActiveTime() > 0) {
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements Comparator<SubTaskState> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(255093640, "Lcom/baidu/tieba/jq$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(255093640, "Lcom/baidu/tieba/jq$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(SubTaskState subTaskState, SubTaskState subTaskState2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, subTaskState, subTaskState2)) == null) {
                if (subTaskState.getTaskStatus().getCurActiveTime() - subTaskState2.getTaskStatus().getCurActiveTime() == 0) {
                    return 0;
                }
                if (subTaskState.getTaskStatus().getCurActiveTime() - subTaskState2.getTaskStatus().getCurActiveTime() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    public static final PriorityQueue<SubTaskState> a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            return c(i);
        }
        return (PriorityQueue) invokeI.objValue;
    }

    public static final PriorityQueue<SubTaskState> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return new PriorityQueue<>(i + 1, b.a);
        }
        return (PriorityQueue) invokeI.objValue;
    }

    public static final PriorityQueue<SubTaskState> d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new PriorityQueue<>(i + 1, a.a);
        }
        return (PriorityQueue) invokeI.objValue;
    }

    public static final void b(PriorityQueue<SubTaskState> priorityQueue, SubTaskState subTaskState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, priorityQueue, subTaskState, i) == null) {
            priorityQueue.add(subTaskState);
            while (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }
}
