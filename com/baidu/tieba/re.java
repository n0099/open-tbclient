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
/* loaded from: classes5.dex */
public class re {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList arrayList, se seVar) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, seVar)) == null) {
            if (arrayList != null && seVar != null) {
                Class a5 = seVar.a();
                Type[] b = seVar.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = we.a(it.next()).a(new se(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (sc.e(a5, List.class)) {
                    List a7 = qe.a(seVar, arrayList.size());
                    if (a7 != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ce a8 = we.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new se(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (sc.e(a5, Queue.class)) {
                    Queue c = qe.c(seVar, arrayList.size());
                    if (c != null) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            ce a9 = we.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new se(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (sc.e(a5, Set.class)) {
                    Set d = qe.d(seVar, arrayList.size());
                    if (d != null) {
                        Iterator it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            ce a10 = we.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new se(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (sc.e(a5, Map.class)) {
                    Map b2 = qe.b(seVar, arrayList.size());
                    if (b2 != null) {
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            ce a11 = we.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new se(b[1]));
                            } else {
                                a = a11.a(new se(String.class));
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
                    Iterator it6 = arrayList.iterator();
                    int i2 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        ce a12 = we.a(next);
                        if (b != null && b.length >= 1 && a12.a(new se(b[0])) != null) {
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

    public static final Object b(Object obj, se seVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, seVar)) == null) {
            if (obj == null || seVar == null || !obj.getClass().isArray()) {
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
            return a(arrayList, seVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List list, se seVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, seVar)) == null) {
            if (list != null && seVar != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, seVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue queue, se seVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, seVar)) == null) {
            if (queue != null && seVar != null) {
                ArrayList arrayList = new ArrayList(queue.size());
                for (Object obj : queue) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, seVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set set, se seVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, seVar)) == null) {
            if (set != null && seVar != null) {
                ArrayList arrayList = new ArrayList(set.size());
                for (Object obj : set) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, seVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray sparseArray, se seVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, seVar)) == null) {
            if (sparseArray != null && seVar != null) {
                ArrayList arrayList = new ArrayList(sparseArray.size());
                for (int i = 0; i < sparseArray.size(); i++) {
                    Object obj = sparseArray.get(sparseArray.keyAt(i));
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, seVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
