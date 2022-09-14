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
public class oa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<qa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
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

    public static void b(LinkedList<qa> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, linkedList) == null) || linkedList == null) {
            return;
        }
        Iterator<qa> it = linkedList.iterator();
        while (it.hasNext()) {
            qa next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<qa> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && (m = next.m()) != null) {
                    if (i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) {
                        return true;
                    }
                    if (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean d(LinkedList<qa> linkedList, ma maVar, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, maVar, i)) == null) {
            if (maVar == null) {
                return false;
            }
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && maVar.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<qa> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static qa f(LinkedList<qa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.peek();
        }
        return (qa) invokeL.objValue;
    }

    public static int g(qa qaVar, LinkedList<qa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, qaVar, linkedList)) == null) {
            if (qaVar == null || linkedList == null) {
                return -1;
            }
            int size = linkedList.size();
            int i = 0;
            while (i < size && linkedList.get(i).n() <= qaVar.n()) {
                i++;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static boolean h(qa qaVar, LinkedList<qa> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, qaVar, linkedList)) == null) {
            if (qaVar == null || linkedList == null || (g = g(qaVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, qaVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<qa> linkedList, LinkedList<qa> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) != null) {
            return invokeLL.booleanValue;
        }
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            qa poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<qa> linkedList, LinkedList<qa> linkedList2, qa qaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, qaVar)) == null) {
            if (qaVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(qaVar)) {
                return false;
            }
            linkedList2.add(qaVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static qa k(LinkedList<qa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (qa) invokeL.objValue;
    }

    public static qa l(LinkedList<qa> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.poll();
        }
        return (qa) invokeL.objValue;
    }

    public static void m(LinkedList<qa> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) == null) || linkedList == null) {
            return;
        }
        Iterator<qa> it = linkedList.iterator();
        while (it.hasNext()) {
            qa next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(qa qaVar, LinkedList<qa> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, qaVar, linkedList)) == null) {
            if (qaVar == null || linkedList == null) {
                return false;
            }
            return linkedList.remove(qaVar);
        }
        return invokeLL.booleanValue;
    }

    public static void o(LinkedList<qa> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static qa p(int i, LinkedList<qa> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<qa> it = linkedList.iterator();
            while (it.hasNext()) {
                qa next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (qa) invokeIL.objValue;
    }

    public static int q(LinkedList<qa> linkedList) {
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
}
