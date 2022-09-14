package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes5.dex */
public class pe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(re reVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, reVar, i)) == null) {
            Class<?> a = reVar.a();
            if (a != List.class && a != ArrayList.class) {
                if (a == LinkedList.class) {
                    return new LinkedList();
                }
                Object h = rc.h(a, i);
                if (h == null) {
                    h = rc.g(a);
                }
                if (h instanceof List) {
                    return (List) h;
                }
                return null;
            }
            return new ArrayList(i);
        }
        return (List) invokeLI.objValue;
    }

    public static final Map<String, Object> b(re reVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, reVar, i)) == null) {
            Class<?> a = reVar.a();
            Type[] b = reVar.b();
            if (rc.e(a, Map.class)) {
                if (b != null && b.length >= 2 && b[0] == String.class) {
                    if (a == Map.class) {
                        return new HashMap(i);
                    }
                    Object h = rc.h(a, i);
                    if (h == null) {
                        h = rc.g(a);
                    }
                    if (h instanceof Map) {
                        return (Map) h;
                    }
                    return null;
                } else if (a == Map.class) {
                    return new HashMap(i);
                } else {
                    Object h2 = rc.h(a, i);
                    if (h2 == null) {
                        h2 = rc.g(a);
                    }
                    if (h2 instanceof Map) {
                        return (Map) h2;
                    }
                    return null;
                }
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }

    public static final Queue<Object> c(re reVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, reVar, i)) == null) {
            Class<?> a = reVar.a();
            if (a == Queue.class) {
                return new LinkedList();
            }
            Object h = rc.h(a, i);
            if (h == null) {
                h = rc.g(a);
            }
            if (h instanceof Queue) {
                return (Queue) h;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(re reVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, reVar, i)) == null) {
            Class<?> a = reVar.a();
            if (a == Set.class) {
                return new HashSet();
            }
            Object h = rc.h(a, i);
            if (h == null) {
                h = rc.g(a);
            }
            if (h instanceof Set) {
                return (Set) h;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }
}
