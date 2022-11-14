package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class pa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<ra> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
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

    public static ra k(LinkedList<ra> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (ra) invokeL.objValue;
    }

    public static void b(LinkedList<ra> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, linkedList) != null) || linkedList == null) {
            return;
        }
        Iterator<ra> it = linkedList.iterator();
        while (it.hasNext()) {
            ra next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static ra f(LinkedList<ra> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.peek();
            }
            return null;
        }
        return (ra) invokeL.objValue;
    }

    public static ra l(LinkedList<ra> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.poll();
            }
            return null;
        }
        return (ra) invokeL.objValue;
    }

    public static int q(LinkedList<ra> linkedList) {
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

    public static boolean c(LinkedList<ra> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
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

    public static void m(LinkedList<ra> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) != null) || linkedList == null) {
            return;
        }
        Iterator<ra> it = linkedList.iterator();
        while (it.hasNext()) {
            ra next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean d(LinkedList<ra> linkedList, na naVar, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, naVar, i)) == null) {
            if (naVar == null) {
                return false;
            }
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && naVar.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<ra> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int g(ra raVar, LinkedList<ra> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, raVar, linkedList)) == null) {
            if (raVar != null && linkedList != null) {
                int size = linkedList.size();
                int i = 0;
                while (i < size && linkedList.get(i).n() <= raVar.n()) {
                    i++;
                }
                return i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void o(LinkedList<ra> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static ra p(int i, LinkedList<ra> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ra> it = linkedList.iterator();
            while (it.hasNext()) {
                ra next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (ra) invokeIL.objValue;
    }

    public static boolean h(ra raVar, LinkedList<ra> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, raVar, linkedList)) == null) {
            if (raVar == null || linkedList == null || (g = g(raVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, raVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<ra> linkedList, LinkedList<ra> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) == null) {
            if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
                return false;
            }
            while (true) {
                ra poll = linkedList2.poll();
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

    public static boolean n(ra raVar, LinkedList<ra> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, raVar, linkedList)) == null) {
            if (raVar != null && linkedList != null) {
                return linkedList.remove(raVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(LinkedList<ra> linkedList, LinkedList<ra> linkedList2, ra raVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, raVar)) == null) {
            if (raVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(raVar)) {
                return false;
            }
            linkedList2.add(raVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
