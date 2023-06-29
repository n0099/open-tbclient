package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<la> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
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

    public static la k(LinkedList<la> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (la) invokeL.objValue;
    }

    public static void b(LinkedList<la> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, linkedList) != null) || linkedList == null) {
            return;
        }
        Iterator<la> it = linkedList.iterator();
        while (it.hasNext()) {
            la next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static la f(LinkedList<la> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.peek();
            }
            return null;
        }
        return (la) invokeL.objValue;
    }

    public static la l(LinkedList<la> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.poll();
            }
            return null;
        }
        return (la) invokeL.objValue;
    }

    public static int q(LinkedList<la> linkedList) {
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

    public static boolean c(LinkedList<la> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
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

    public static void m(LinkedList<la> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) != null) || linkedList == null) {
            return;
        }
        Iterator<la> it = linkedList.iterator();
        while (it.hasNext()) {
            la next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean d(LinkedList<la> linkedList, ha haVar, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, haVar, i)) == null) {
            if (haVar == null) {
                return false;
            }
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && haVar.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<la> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int g(la laVar, LinkedList<la> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, laVar, linkedList)) == null) {
            if (laVar != null && linkedList != null) {
                int size = linkedList.size();
                int i = 0;
                while (i < size && linkedList.get(i).n() <= laVar.n()) {
                    i++;
                }
                return i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void o(LinkedList<la> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static la p(int i, LinkedList<la> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<la> it = linkedList.iterator();
            while (it.hasNext()) {
                la next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (la) invokeIL.objValue;
    }

    public static boolean h(la laVar, LinkedList<la> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, laVar, linkedList)) == null) {
            if (laVar == null || linkedList == null || (g = g(laVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, laVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<la> linkedList, LinkedList<la> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) == null) {
            if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
                return false;
            }
            while (true) {
                la poll = linkedList2.poll();
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

    public static boolean n(la laVar, LinkedList<la> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, laVar, linkedList)) == null) {
            if (laVar != null && linkedList != null) {
                return linkedList.remove(laVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(LinkedList<la> linkedList, LinkedList<la> linkedList2, la laVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, laVar)) == null) {
            if (laVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(laVar)) {
                return false;
            }
            linkedList2.add(laVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
