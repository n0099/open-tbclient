package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.controller.MessageRule;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class o6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<k6> a;
    public final LinkedList<q6> b;
    public final LinkedList<CustomRule> c;
    public final LinkedList<j6> d;
    public final LinkedList<p6> e;
    public final LinkedList<i6> f;
    public final LinkedList<l6> g;

    public o6() {
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

    public void a(l6 l6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l6Var) == null) {
            this.g.add(l6Var);
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
                this.g.get(i).h(bdUniqueId);
            }
        }
    }

    public void b(MessageRule<?, ?> messageRule) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageRule) != null) || messageRule == null) {
            return;
        }
        BdUtilHelper.checkMainThread();
        if (messageRule instanceof k6) {
            FrameHelper.f(this.a, (k6) messageRule);
        } else if (messageRule instanceof q6) {
            FrameHelper.f(this.b, (q6) messageRule);
        } else if (messageRule instanceof CustomRule) {
            FrameHelper.f(this.c, (CustomRule) messageRule);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(m6<?> m6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m6Var) != null) || m6Var == null) {
            return;
        }
        BdUtilHelper.checkMainThread();
        if (m6Var instanceof j6) {
            FrameHelper.f(this.d, (j6) m6Var);
        } else if (m6Var instanceof p6) {
            FrameHelper.f(this.e, (p6) m6Var);
        } else if (m6Var instanceof i6) {
            FrameHelper.f(this.f, (i6) m6Var);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(MessageRule<?, ?> messageRule) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, messageRule) != null) || messageRule == null) {
            return;
        }
        BdUtilHelper.checkMainThread();
        if (messageRule instanceof k6) {
            this.a.remove(messageRule);
        } else if (messageRule instanceof q6) {
            this.b.remove(messageRule);
        } else if (messageRule instanceof CustomRule) {
            this.c.remove(messageRule);
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
                this.g.get(i2).g(i, bdUniqueId);
            }
        }
    }

    public final <M extends Message<?>, T extends MessageTask> M i(LinkedList<? extends MessageRule<M, T>> linkedList, M m, T t) {
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

    public final <M extends ResponsedMessage<?>> M j(LinkedList<? extends m6<M>> linkedList, M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linkedList, m)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && m != null; i++) {
                try {
                    m = linkedList.get(i).h(m);
                } catch (Exception e) {
                    BdLog.e("rule error = " + e.getMessage());
                }
            }
            return m;
        }
        return (M) invokeLL.objValue;
    }
}
