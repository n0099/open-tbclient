package com.baidu.tieba;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes8.dex */
public class t8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, u8 u8Var) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, u8Var)) == null) {
            if (arrayList != null && u8Var != null) {
                Class<?> a5 = u8Var.a();
                Type[] b = u8Var.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = y8.a(it.next()).a(new u8(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (b7.e(a5, List.class)) {
                    List<Object> a7 = s8.a(u8Var, arrayList.size());
                    if (a7 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            e8 a8 = y8.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new u8(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (b7.e(a5, Queue.class)) {
                    Queue<Object> c = s8.c(u8Var, arrayList.size());
                    if (c != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            e8 a9 = y8.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new u8(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (b7.e(a5, Set.class)) {
                    Set<Object> d = s8.d(u8Var, arrayList.size());
                    if (d != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            e8 a10 = y8.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new u8(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (b7.e(a5, Map.class)) {
                    Map<String, Object> b2 = s8.b(u8Var, arrayList.size());
                    if (b2 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            e8 a11 = y8.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new u8(b[1]));
                            } else {
                                a = a11.a(new u8(String.class));
                            }
                            if (a != null) {
                                b2.put(String.valueOf(i), a);
                            }
                            i++;
                        }
                    }
                    return b2;
                } else if (a5 == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray();
                    Iterator<Object> it6 = arrayList.iterator();
                    int i2 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        e8 a12 = y8.a(next);
                        if (b != null && b.length >= 1 && a12.a(new u8(b[0])) != null) {
                            sparseArray.put(i2, next);
                        }
                        i2++;
                    }
                    return sparseArray;
                } else if (a5 == Bundle.class) {
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object b(Object obj, u8 u8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, u8Var)) == null) {
            if (obj == null || u8Var == null || !obj.getClass().isArray()) {
                return null;
            }
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            return a(arrayList, u8Var);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, u8 u8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, u8Var)) == null) {
            if (list != null && u8Var != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, u8Var);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, u8 u8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, u8Var)) == null) {
            if (queue != null && u8Var != null) {
                ArrayList arrayList = new ArrayList(queue.size());
                for (Object obj : queue) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, u8Var);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, u8 u8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, u8Var)) == null) {
            if (set != null && u8Var != null) {
                ArrayList arrayList = new ArrayList(set.size());
                for (Object obj : set) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, u8Var);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, u8 u8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, u8Var)) == null) {
            if (sparseArray != null && u8Var != null) {
                ArrayList arrayList = new ArrayList(sparseArray.size());
                for (int i = 0; i < sparseArray.size(); i++) {
                    Object obj = sparseArray.get(sparseArray.keyAt(i));
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, u8Var);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
