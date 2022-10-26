package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class nb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList a;
    public final LinkedList b;
    public final LinkedList c;
    public final LinkedList d;
    public final LinkedList e;
    public final LinkedList f;
    public final LinkedList g;

    public nb() {
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
        this.a = new LinkedList();
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = new LinkedList();
        this.g = new LinkedList();
    }

    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jbVar) == null) {
            this.g.add(jbVar);
        }
    }

    public CustomResponsedMessage f(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customResponsedMessage)) == null) {
            return (CustomResponsedMessage) j(this.f, customResponsedMessage);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }

    public HttpResponsedMessage h(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpResponsedMessage)) == null) {
            return (HttpResponsedMessage) j(this.d, httpResponsedMessage);
        }
        return (HttpResponsedMessage) invokeL.objValue;
    }

    public SocketResponsedMessage l(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, socketResponsedMessage)) == null) {
            return (SocketResponsedMessage) j(this.e, socketResponsedMessage);
        }
        return (SocketResponsedMessage) invokeL.objValue;
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ((jb) this.g.get(i)).b(bdUniqueId);
            }
        }
    }

    public void b(kb kbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kbVar) != null) || kbVar == null) {
            return;
        }
        fj.c();
        if (kbVar instanceof ib) {
            FrameHelper.insert(this.a, (ib) kbVar);
        } else if (kbVar instanceof pb) {
            FrameHelper.insert(this.b, (pb) kbVar);
        } else if (kbVar instanceof gb) {
            FrameHelper.insert(this.c, (gb) kbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(lb lbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lbVar) != null) || lbVar == null) {
            return;
        }
        fj.c();
        if (lbVar instanceof hb) {
            FrameHelper.insert(this.d, (hb) lbVar);
        } else if (lbVar instanceof ob) {
            FrameHelper.insert(this.e, (ob) lbVar);
        } else if (lbVar instanceof fb) {
            FrameHelper.insert(this.f, (fb) lbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(kb kbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, kbVar) != null) || kbVar == null) {
            return;
        }
        fj.c();
        if (kbVar instanceof ib) {
            this.a.remove(kbVar);
        } else if (kbVar instanceof pb) {
            this.b.remove(kbVar);
        } else if (kbVar instanceof gb) {
            this.c.remove(kbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage e(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, customMessage, customMessageTask)) == null) {
            return (CustomMessage) i(this.c, customMessage, customMessageTask);
        }
        return (CustomMessage) invokeLL.objValue;
    }

    public HttpMessage g(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask)) == null) {
            return (HttpMessage) i(this.a, httpMessage, httpMessageTask);
        }
        return (HttpMessage) invokeLL.objValue;
    }

    public SocketMessage k(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, socketMessage, socketMessageTask)) == null) {
            return (SocketMessage) i(this.b, socketMessage, socketMessageTask);
        }
        return (SocketMessage) invokeLL.objValue;
    }

    public void m(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bdUniqueId) == null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((jb) this.g.get(i2)).a(i, bdUniqueId);
            }
        }
    }

    public final Message i(LinkedList linkedList, Message message, MessageTask messageTask) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedList, message, messageTask)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && message != null; i++) {
                try {
                    message = ((kb) linkedList.get(i)).rule(message, messageTask);
                } catch (Exception e) {
                    BdLog.e(e, true);
                }
            }
            return message;
        }
        return (Message) invokeLLL.objValue;
    }

    public final ResponsedMessage j(LinkedList linkedList, ResponsedMessage responsedMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linkedList, responsedMessage)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && responsedMessage != null; i++) {
                try {
                    responsedMessage = ((lb) linkedList.get(i)).b(responsedMessage);
                } catch (Exception e) {
                    BdLog.e("rule error = " + e.getMessage());
                }
            }
            return responsedMessage;
        }
        return (ResponsedMessage) invokeLL.objValue;
    }
}
