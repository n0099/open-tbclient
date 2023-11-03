package com.baidu.tieba;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.MessageRule;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public abstract class u6<M extends Message<?>, T extends MessageTask, R extends MessageRule<?, ?>, N extends ResponsedMessage<?>> implements l5<M, T> {
    public static /* synthetic */ Interceptable $ic;
    public static r6<Message<?>> h;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageManager a;
    public final SparseArray<T> b;
    public final SparseArray<N> c;
    public final SparseArray<LinkedList<MessageListener<N>>> d;
    public a7 e;
    public boolean f;
    public final SparseIntArray g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448317292, "Lcom/baidu/tieba/u6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448317292, "Lcom/baidu/tieba/u6;");
        }
    }

    public abstract M m(M m, T t);

    public u6(MessageManager messageManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.d = new SparseArray<>();
        this.e = null;
        this.f = false;
        this.g = new SparseIntArray();
        this.a = messageManager;
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            BdUtilHelper.checkMainThread();
            if (bdUniqueId == null) {
                return;
            }
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.d.keyAt(i);
                Iterator<MessageListener<N>> it = this.d.valueAt(i).iterator();
                while (it.hasNext()) {
                    MessageListener<N> next = it.next();
                    if (next != null && next.getTag() == bdUniqueId) {
                        b(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public void u(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, messageListener) == null) {
            BdUtilHelper.checkMainThread();
            if (messageListener == null) {
                return;
            }
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.d.size();
                for (int i = 0; i < size; i++) {
                    LinkedList<MessageListener<N>> valueAt = this.d.valueAt(i);
                    int keyAt = this.d.keyAt(i);
                    if (valueAt.contains(messageListener)) {
                        b(keyAt);
                        valueAt.remove(messageListener);
                    }
                }
                return;
            }
            b(cmd);
            LinkedList<MessageListener<N>> linkedList = this.d.get(cmd);
            if (linkedList != null) {
                linkedList.remove(messageListener);
            }
        }
    }

    public static void q(r6<Message<?>> r6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, r6Var) == null) {
            h = r6Var;
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || !k(i)) {
            return;
        }
        throw new IllegalStateException("MessageListener locked");
    }

    public synchronized T g(int i) {
        InterceptResult invokeI;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                t = this.b.get(i);
            }
            return t;
        }
        return (T) invokeI.objValue;
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<MessageListener<N>> linkedList = this.d.get(i);
            if (linkedList != null && linkedList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final synchronized boolean k(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            synchronized (this) {
                z = false;
                if (this.g.get(i, 0) != 0) {
                    z = true;
                }
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final synchronized void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            synchronized (this) {
                this.g.put(i, this.g.get(i, 0) + 1);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && this.c.indexOfKey(i) < 0) {
            this.c.put(i, null);
        }
    }

    public synchronized void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            synchronized (this) {
                if (t == null) {
                    return;
                }
                int cmd = t.getCmd();
                FrameHelper.g(cmd);
                this.b.put(cmd, t);
            }
        }
    }

    public final synchronized void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            synchronized (this) {
                int i2 = this.g.get(i, 0);
                if (i2 <= 1) {
                    this.g.delete(i);
                } else {
                    this.g.put(i, i2 - 1);
                }
            }
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            BdUtilHelper.checkMainThread();
            if (i != 0) {
                b(i);
                this.d.remove(i);
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c.remove(i);
        }
    }

    public synchronized void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            synchronized (this) {
                this.b.remove(i);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
        }
    }

    public boolean c(M m, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m, t)) == null) {
            BdUtilHelper.checkMainThread();
            if (m == null) {
                return false;
            }
            int cmd = m.getCmd();
            if (t == null) {
                t = g(cmd);
            }
            if (t != null) {
                M m2 = m(m, t);
                if (this.e != null) {
                    if (t.getTimeOut() == null) {
                        t.setTimeOut(this.e.b());
                    }
                    if (t.getRetry() == 0) {
                        t.setRetry(this.e.a());
                    }
                }
                if (m2 != null) {
                    f(m2, t);
                    return true;
                }
                BdLog.d("message is trapped:" + cmd);
                return false;
            }
            r6<Message<?>> r6Var = h;
            if (r6Var != null) {
                r6Var.a(m);
            }
            BdLog.e("task not register:" + cmd);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void d(N n) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n) == null) {
            BdUtilHelper.checkMainThread();
            if (n == null) {
                return;
            }
            n.setProcessTime(System.currentTimeMillis());
            int cmd = n.getCmd();
            BdUniqueId bdUniqueId = null;
            Message<?> orginalMessage = n.getOrginalMessage();
            if (orginalMessage != null) {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.c.indexOfKey(cmd) >= 0) {
                this.c.put(cmd, n);
            }
            LinkedList<MessageListener<N>> linkedList = this.d.get(cmd);
            if (linkedList == null) {
                return;
            }
            this.f = false;
            l(cmd);
            try {
                try {
                    Iterator<MessageListener<N>> it = linkedList.iterator();
                    while (it.hasNext() && !this.f) {
                        MessageListener<N> next = it.next();
                        if (next != null && (!next.isSelfListener() || next.getTag() == bdUniqueId)) {
                            try {
                                next.onMessage(n);
                            } catch (Exception e) {
                                BdLog.detailException(n.getClass().getName(), e, true);
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(n.getClass().getName(), e2, true);
                }
            } finally {
                r(cmd);
            }
        }
    }

    public synchronized ArrayList<T> i() {
        InterceptResult invokeV;
        ArrayList<T> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(this.b.valueAt(i));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void n(int i, MessageListener<N> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, messageListener) == null) {
            BdUtilHelper.checkMainThread();
            if (messageListener == null) {
                return;
            }
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            FrameHelper.g(i);
            b(i);
            LinkedList<MessageListener<N>> linkedList = this.d.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.d.put(i, linkedList);
            }
            FrameHelper.f(linkedList, messageListener);
            N n = this.c.get(i);
            if (n != null) {
                messageListener.onMessage(n);
            }
        }
    }
}
