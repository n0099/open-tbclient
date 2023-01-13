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
public class qa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<sa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
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

    public static sa k(LinkedList<sa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (sa) invokeL.objValue;
    }

    public static void b(LinkedList<sa> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, linkedList) != null) || linkedList == null) {
            return;
        }
        Iterator<sa> it = linkedList.iterator();
        while (it.hasNext()) {
            sa next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static sa f(LinkedList<sa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.peek();
            }
            return null;
        }
        return (sa) invokeL.objValue;
    }

    public static sa l(LinkedList<sa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.poll();
            }
            return null;
        }
        return (sa) invokeL.objValue;
    }

    public static int q(LinkedList<sa> linkedList) {
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

    public static boolean c(LinkedList<sa> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
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

    public static void m(LinkedList<sa> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) != null) || linkedList == null) {
            return;
        }
        Iterator<sa> it = linkedList.iterator();
        while (it.hasNext()) {
            sa next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean d(LinkedList<sa> linkedList, oa oaVar, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, oaVar, i)) == null) {
            if (oaVar == null) {
                return false;
            }
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && oaVar.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<sa> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int g(sa saVar, LinkedList<sa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, saVar, linkedList)) == null) {
            if (saVar != null && linkedList != null) {
                int size = linkedList.size();
                int i = 0;
                while (i < size && linkedList.get(i).n() <= saVar.n()) {
                    i++;
                }
                return i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void o(LinkedList<sa> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static sa p(int i, LinkedList<sa> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<sa> it = linkedList.iterator();
            while (it.hasNext()) {
                sa next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (sa) invokeIL.objValue;
    }

    public static boolean h(sa saVar, LinkedList<sa> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, saVar, linkedList)) == null) {
            if (saVar == null || linkedList == null || (g = g(saVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, saVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<sa> linkedList, LinkedList<sa> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) == null) {
            if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
                return false;
            }
            while (true) {
                sa poll = linkedList2.poll();
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

    public static boolean n(sa saVar, LinkedList<sa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, saVar, linkedList)) == null) {
            if (saVar != null && linkedList != null) {
                return linkedList.remove(saVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(LinkedList<sa> linkedList, LinkedList<sa> linkedList2, sa saVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, saVar)) == null) {
            if (saVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(saVar)) {
                return false;
            }
            linkedList2.add(saVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
