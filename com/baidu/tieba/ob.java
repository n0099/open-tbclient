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
public class ob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<jb> a;
    public final LinkedList<qb> b;
    public final LinkedList<hb> c;
    public final LinkedList<ib> d;
    public final LinkedList<pb> e;
    public final LinkedList<gb> f;
    public final LinkedList<kb> g;

    public ob() {
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
        this.a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = new LinkedList<>();
        this.g = new LinkedList<>();
    }

    public void a(kb kbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kbVar) == null) {
            this.g.add(kbVar);
        }
    }

    public CustomResponsedMessage<?> f(CustomResponsedMessage<?> customResponsedMessage) {
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
                this.g.get(i).b(bdUniqueId);
            }
        }
    }

    public void b(lb<?, ?> lbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lbVar) != null) || lbVar == null) {
            return;
        }
        zi.c();
        if (lbVar instanceof jb) {
            FrameHelper.insert(this.a, (jb) lbVar);
        } else if (lbVar instanceof qb) {
            FrameHelper.insert(this.b, (qb) lbVar);
        } else if (lbVar instanceof hb) {
            FrameHelper.insert(this.c, (hb) lbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(mb<?> mbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mbVar) != null) || mbVar == null) {
            return;
        }
        zi.c();
        if (mbVar instanceof ib) {
            FrameHelper.insert(this.d, (ib) mbVar);
        } else if (mbVar instanceof pb) {
            FrameHelper.insert(this.e, (pb) mbVar);
        } else if (mbVar instanceof gb) {
            FrameHelper.insert(this.f, (gb) mbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(lb<?, ?> lbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, lbVar) != null) || lbVar == null) {
            return;
        }
        zi.c();
        if (lbVar instanceof jb) {
            this.a.remove(lbVar);
        } else if (lbVar instanceof qb) {
            this.b.remove(lbVar);
        } else if (lbVar instanceof hb) {
            this.c.remove(lbVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> e(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
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
                this.g.get(i2).a(i, bdUniqueId);
            }
        }
    }

    public final <M extends Message<?>, T extends MessageTask> M i(LinkedList<? extends lb<M, T>> linkedList, M m, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedList, m, t)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && m != null; i++) {
                try {
                    m = linkedList.get(i).rule(m, t);
                } catch (Exception e) {
                    BdLog.e(e, true);
                }
            }
            return m;
        }
        return (M) invokeLLL.objValue;
    }

    public final <M extends ResponsedMessage<?>> M j(LinkedList<? extends mb<M>> linkedList, M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linkedList, m)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && m != null; i++) {
                try {
                    m = linkedList.get(i).b(m);
                } catch (Exception e) {
                    BdLog.e("rule error = " + e.getMessage());
                }
            }
            return m;
        }
        return (M) invokeLL.objValue;
    }
}
