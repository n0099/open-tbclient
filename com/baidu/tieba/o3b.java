package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes5.dex */
public class o3b implements m1b {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<Object> a;
    public volatile Object b;

    static {
        InterceptResult invokeClinit;
        int i;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982731, "Lcom/baidu/tieba/o3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982731, "Lcom/baidu/tieba/o3b;");
                return;
            }
        }
        if (n3b.c()) {
            i = 16;
        } else {
            i = 128;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        c = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o3b() {
        this(new t3b(c), c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Queue) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public o3b(Queue<Object> queue, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {queue, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = queue;
    }

    public o3b(boolean z, int i) {
        Queue<Object> o4bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (z) {
            o4bVar = new g4b<>(i);
        } else {
            o4bVar = new o4b<>(i);
        }
        this.a = o4bVar;
    }

    public static o3b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c5b.b()) {
                return new o3b(true, c);
            }
            return new o3b();
        }
        return (o3b) invokeV.objValue;
    }

    public static o3b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c5b.b()) {
                return new o3b(false, c);
            }
            return new o3b();
        }
        return (o3b) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Queue<Object> queue = this.a;
            if (queue != null && !queue.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b == null) {
            this.b = NotificationLite.b();
        }
    }

    public Object h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Queue<Object> queue = this.a;
                if (queue == null) {
                    return null;
                }
                Object peek = queue.peek();
                Object obj = this.b;
                if (peek == null && obj != null && queue.peek() == null) {
                    peek = obj;
                }
                return peek;
            }
        }
        return invokeV.objValue;
    }

    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                Queue<Object> queue = this.a;
                if (queue == null) {
                    return null;
                }
                Object poll = queue.poll();
                Object obj = this.b;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.b = null;
                    poll = obj;
                }
                return poll;
            }
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
            }
        }
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            j();
        }
    }

    public Object c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return NotificationLite.e(obj);
        }
        return invokeL.objValue;
    }

    public boolean d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            return NotificationLite.f(obj);
        }
        return invokeL.booleanValue;
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                Queue<Object> queue = this.a;
                z = true;
                z2 = false;
                if (queue != null) {
                    z2 = !queue.offer(NotificationLite.h(obj));
                    z = false;
                }
            }
            if (!z) {
                if (!z2) {
                    return;
                }
                throw new MissingBackpressureException();
            }
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
    }
}
