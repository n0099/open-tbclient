package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class y9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<aa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
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

    public static aa k(LinkedList<aa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (aa) invokeL.objValue;
    }

    public static void b(LinkedList<aa> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, linkedList) != null) || linkedList == null) {
            return;
        }
        Iterator<aa> it = linkedList.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static aa f(LinkedList<aa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.peek();
            }
            return null;
        }
        return (aa) invokeL.objValue;
    }

    public static aa l(LinkedList<aa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() > 0) {
                return linkedList.poll();
            }
            return null;
        }
        return (aa) invokeL.objValue;
    }

    public static int q(LinkedList<aa> linkedList) {
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

    public static boolean c(LinkedList<aa> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
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

    public static void m(LinkedList<aa> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) != null) || linkedList == null) {
            return;
        }
        Iterator<aa> it = linkedList.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean d(LinkedList<aa> linkedList, w9 w9Var, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, w9Var, i)) == null) {
            if (w9Var == null) {
                return false;
            }
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && w9Var.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<aa> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int g(aa aaVar, LinkedList<aa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, aaVar, linkedList)) == null) {
            if (aaVar != null && linkedList != null) {
                int size = linkedList.size();
                int i = 0;
                while (i < size && linkedList.get(i).n() <= aaVar.n()) {
                    i++;
                }
                return i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void o(LinkedList<aa> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static aa p(int i, LinkedList<aa> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<aa> it = linkedList.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (aa) invokeIL.objValue;
    }

    public static boolean h(aa aaVar, LinkedList<aa> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, aaVar, linkedList)) == null) {
            if (aaVar == null || linkedList == null || (g = g(aaVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, aaVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<aa> linkedList, LinkedList<aa> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) == null) {
            if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
                return false;
            }
            while (true) {
                aa poll = linkedList2.poll();
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

    public static boolean n(aa aaVar, LinkedList<aa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, aaVar, linkedList)) == null) {
            if (aaVar != null && linkedList != null) {
                return linkedList.remove(aaVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(LinkedList<aa> linkedList, LinkedList<aa> linkedList2, aa aaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, aaVar)) == null) {
            if (aaVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(aaVar)) {
                return false;
            }
            linkedList2.add(aaVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
