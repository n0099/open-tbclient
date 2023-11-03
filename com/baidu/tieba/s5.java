package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class s5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<u5> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && next.i()) {
                    next.g();
                    if (next.o() >= next.l()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static u5 k(LinkedList<u5> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (u5) invokeL.objValue;
    }

    public static void b(LinkedList<u5> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, linkedList) != null) || linkedList == null) {
            return;
        }
        Iterator<u5> it = linkedList.iterator();
        while (it.hasNext()) {
            u5 next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static u5 f(LinkedList<u5> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.peek();
            }
            return null;
        }
        return (u5) invokeL.objValue;
    }

    public static u5 l(LinkedList<u5> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.poll();
            }
            return null;
        }
        return (u5) invokeL.objValue;
    }

    public static int q(LinkedList<u5> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, linkedList)) == null) {
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeL.intValue;
    }

    public static boolean c(LinkedList<u5> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && (m = next.m()) != null) {
                    if (i == 0 || m.getTag() != bdUniqueId || i != m.getCmd()) {
                        if (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void m(LinkedList<u5> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) != null) || linkedList == null) {
            return;
        }
        Iterator<u5> it = linkedList.iterator();
        while (it.hasNext()) {
            u5 next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean d(LinkedList<u5> linkedList, q5 q5Var, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, q5Var, i)) == null) {
            if (q5Var == null) {
                return false;
            }
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && q5Var.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<u5> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int g(u5 u5Var, LinkedList<u5> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, u5Var, linkedList)) == null) {
            if (u5Var != null && linkedList != null) {
                int size = linkedList.size();
                int i = 0;
                while (i < size && linkedList.get(i).n() <= u5Var.n()) {
                    i++;
                }
                return i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void o(LinkedList<u5> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static u5 p(int i, LinkedList<u5> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<u5> it = linkedList.iterator();
            while (it.hasNext()) {
                u5 next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (u5) invokeIL.objValue;
    }

    public static boolean h(u5 u5Var, LinkedList<u5> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, u5Var, linkedList)) == null) {
            if (u5Var == null || linkedList == null || (g = g(u5Var, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, u5Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<u5> linkedList, LinkedList<u5> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) == null) {
            if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
                return false;
            }
            while (true) {
                u5 poll = linkedList2.poll();
                if (poll != null) {
                    h(poll, linkedList);
                } else {
                    return true;
                }
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static boolean n(u5 u5Var, LinkedList<u5> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, u5Var, linkedList)) == null) {
            if (u5Var != null && linkedList != null) {
                return linkedList.remove(u5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(LinkedList<u5> linkedList, LinkedList<u5> linkedList2, u5 u5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, u5Var)) == null) {
            if (u5Var == null || linkedList == null || linkedList2 == null || !linkedList.remove(u5Var)) {
                return false;
            }
            linkedList2.add(u5Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
