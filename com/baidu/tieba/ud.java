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
/* loaded from: classes8.dex */
public class ud {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(wd wdVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, wdVar, i)) == null) {
            Class<?> a = wdVar.a();
            if (a != List.class && a != ArrayList.class) {
                if (a == LinkedList.class) {
                    return new LinkedList();
                }
                Object h = dc.h(a, i);
                if (h == null) {
                    h = dc.g(a);
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

    public static final Queue<Object> c(wd wdVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, wdVar, i)) == null) {
            Class<?> a = wdVar.a();
            if (a == Queue.class) {
                return new LinkedList();
            }
            Object h = dc.h(a, i);
            if (h == null) {
                h = dc.g(a);
            }
            if (h instanceof Queue) {
                return (Queue) h;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(wd wdVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, wdVar, i)) == null) {
            Class<?> a = wdVar.a();
            if (a == Set.class) {
                return new HashSet();
            }
            Object h = dc.h(a, i);
            if (h == null) {
                h = dc.g(a);
            }
            if (h instanceof Set) {
                return (Set) h;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }

    public static final Map<String, Object> b(wd wdVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, wdVar, i)) == null) {
            Class<?> a = wdVar.a();
            Type[] b = wdVar.b();
            if (!dc.e(a, Map.class)) {
                return null;
            }
            if (b != null && b.length >= 2 && b[0] == String.class) {
                if (a == Map.class) {
                    return new HashMap(i);
                }
                Object h = dc.h(a, i);
                if (h == null) {
                    h = dc.g(a);
                }
                if (!(h instanceof Map)) {
                    return null;
                }
                return (Map) h;
            } else if (a == Map.class) {
                return new HashMap(i);
            } else {
                Object h2 = dc.h(a, i);
                if (h2 == null) {
                    h2 = dc.g(a);
                }
                if (!(h2 instanceof Map)) {
                    return null;
                }
                return (Map) h2;
            }
        }
        return (Map) invokeLI.objValue;
    }
}
