package com.baidu.tieba;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes6.dex */
public abstract class vb implements ha {
    public static /* synthetic */ Interceptable $ic;
    public static rb h;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageManager a;
    public final SparseArray b;
    public final SparseArray c;
    public final SparseArray d;
    public bc e;
    public boolean f;
    public final SparseIntArray g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448319617, "Lcom/baidu/tieba/vb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448319617, "Lcom/baidu/tieba/vb;");
        }
    }

    public abstract Message m(Message message, MessageTask messageTask);

    public vb(MessageManager messageManager) {
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
        this.b = new SparseArray();
        this.c = new SparseArray();
        this.d = new SparseArray();
        this.e = null;
        this.f = false;
        this.g = new SparseIntArray();
        this.a = messageManager;
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            fj.c();
            if (bdUniqueId == null) {
                return;
            }
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.d.keyAt(i);
                Iterator it = ((LinkedList) this.d.valueAt(i)).iterator();
                while (it.hasNext()) {
                    MessageListener messageListener = (MessageListener) it.next();
                    if (messageListener != null && messageListener.getTag() == bdUniqueId) {
                        b(keyAt);
                        it.remove();
                    }
                }
            }
        }
    }

    public void t(MessageListener messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, messageListener) == null) {
            fj.c();
            if (messageListener == null) {
                return;
            }
            int cmd = messageListener.getCmd();
            if (cmd == 0) {
                int size = this.d.size();
                for (int i = 0; i < size; i++) {
                    LinkedList linkedList = (LinkedList) this.d.valueAt(i);
                    int keyAt = this.d.keyAt(i);
                    if (linkedList.contains(messageListener)) {
                        b(keyAt);
                        linkedList.remove(messageListener);
                    }
                }
                return;
            }
            b(cmd);
            LinkedList linkedList2 = (LinkedList) this.d.get(cmd);
            if (linkedList2 != null) {
                linkedList2.remove(messageListener);
            }
        }
    }

    public static void q(rb rbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, rbVar) == null) {
            h = rbVar;
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || !k(i)) {
            return;
        }
        throw new IllegalStateException("MessageListener locked");
    }

    public synchronized MessageTask g(int i) {
        InterceptResult invokeI;
        MessageTask messageTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                messageTask = (MessageTask) this.b.get(i);
            }
            return messageTask;
        }
        return (MessageTask) invokeI.objValue;
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList linkedList = (LinkedList) this.d.get(i);
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

    public synchronized void p(MessageTask messageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, messageTask) == null) {
            synchronized (this) {
                if (messageTask == null) {
                    return;
                }
                int cmd = messageTask.getCmd();
                FrameHelper.f(cmd);
                this.b.put(cmd, messageTask);
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

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.c.remove(i);
        }
    }

    public synchronized void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
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

    public boolean c(Message message, MessageTask messageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, message, messageTask)) == null) {
            fj.c();
            if (message == null) {
                return false;
            }
            int cmd = message.getCmd();
            if (messageTask == null) {
                messageTask = g(cmd);
            }
            if (messageTask != null) {
                Message m = m(message, messageTask);
                if (this.e != null) {
                    if (messageTask.getTimeOut() == null) {
                        messageTask.setTimeOut(this.e.b());
                    }
                    if (messageTask.getRetry() == 0) {
                        messageTask.setRetry(this.e.a());
                    }
                }
                if (m != null) {
                    f(m, messageTask);
                    return true;
                }
                BdLog.d("message is trapped:" + cmd);
                return false;
            }
            rb rbVar = h;
            if (rbVar != null) {
                rbVar.a(message);
            }
            BdLog.e("task not register:" + cmd);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void d(ResponsedMessage responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, responsedMessage) == null) {
            fj.c();
            if (responsedMessage == null) {
                return;
            }
            responsedMessage.setProcessTime(System.currentTimeMillis());
            int cmd = responsedMessage.getCmd();
            BdUniqueId bdUniqueId = null;
            Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            if (orginalMessage != null) {
                bdUniqueId = orginalMessage.getTag();
            }
            if (this.c.indexOfKey(cmd) >= 0) {
                this.c.put(cmd, responsedMessage);
            }
            LinkedList linkedList = (LinkedList) this.d.get(cmd);
            if (linkedList == null) {
                return;
            }
            this.f = false;
            l(cmd);
            try {
                try {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext() && !this.f) {
                        MessageListener messageListener = (MessageListener) it.next();
                        if (messageListener != null && (!messageListener.isSelfListener() || messageListener.getTag() == bdUniqueId)) {
                            try {
                                messageListener.onMessage(responsedMessage);
                            } catch (Exception e) {
                                BdLog.detailException(responsedMessage.getClass().getName(), e, true);
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(responsedMessage.getClass().getName(), e2, true);
                }
            } finally {
                r(cmd);
            }
        }
    }

    public synchronized ArrayList i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add((MessageTask) this.b.valueAt(i));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void n(int i, MessageListener messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, messageListener) == null) {
            fj.c();
            if (messageListener == null) {
                return;
            }
            if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = messageListener.getCmd();
            }
            FrameHelper.f(i);
            b(i);
            LinkedList linkedList = (LinkedList) this.d.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.d.put(i, linkedList);
            }
            FrameHelper.insert(linkedList, messageListener);
            ResponsedMessage responsedMessage = (ResponsedMessage) this.c.get(i);
            if (responsedMessage != null) {
                messageListener.onMessage(responsedMessage);
            }
        }
    }
}
