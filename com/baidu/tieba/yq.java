package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class yq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<wq> a;
    public final Set<Pair<Class<? extends uq>, vq<? extends uq>>> b;
    public TaskInfo c;

    public yq(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = taskInfo;
        this.a = new HashSet();
        this.b = new HashSet();
    }

    public final void b(vq<? extends uq> vqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vqVar) != null) || vqVar == null) {
            return;
        }
        Iterator<Pair<Class<? extends uq>, vq<? extends uq>>> it = this.b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getSecond(), vqVar)) {
                it.remove();
            }
        }
    }

    public final Set<wq> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return CollectionsKt___CollectionsKt.toSet(this.a);
        }
        return (Set) invokeV.objValue;
    }

    public final Set<Pair<Class<? extends uq>, vq<? extends uq>>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return CollectionsKt___CollectionsKt.toSet(this.b);
        }
        return (Set) invokeV.objValue;
    }

    public final TaskInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public final void c(wq wqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wqVar) != null) || wqVar == null) {
            return;
        }
        this.a.add(wqVar);
    }

    public final void d(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskInfo) == null) {
            this.c = taskInfo;
        }
    }

    public final void g(wq wqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, wqVar) != null) || wqVar == null) {
            return;
        }
        this.a.remove(wqVar);
    }

    public final <T extends uq> void e(Class<T> cls, vq<T> vqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, cls, vqVar) != null) || vqVar == null) {
            return;
        }
        this.b.add(new Pair<>(cls, vqVar));
    }
}
