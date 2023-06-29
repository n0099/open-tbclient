package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class qvb<E> extends AbstractQueue<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<LinkedQueueNode<E>> a;
    public final AtomicReference<LinkedQueueNode<E>> b;

    public qvb() {
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
        this.a = new AtomicReference<>();
        this.b = new AtomicReference<>();
    }

    public final LinkedQueueNode<E> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public final LinkedQueueNode<E> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public final LinkedQueueNode<E> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    public final LinkedQueueNode<E> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.get();
        }
        return (LinkedQueueNode) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (c() == d()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        InterceptResult invokeV;
        LinkedQueueNode<E> lvNext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedQueueNode<E> c = c();
            LinkedQueueNode<E> d = d();
            int i = 0;
            while (c != d && i < Integer.MAX_VALUE) {
                do {
                    lvNext = c.lvNext();
                } while (lvNext == null);
                i++;
                c = lvNext;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, linkedQueueNode) == null) {
            this.b.lazySet(linkedQueueNode);
        }
    }

    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, linkedQueueNode) == null) {
            this.a.lazySet(linkedQueueNode);
        }
    }
}
