package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class pq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<tq5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new tq5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<pn> b(tq5 tq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tq5Var)) == null) {
            List<ThreadInfo> list = tq5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    qq5 qq5Var = new qq5();
                    qq5Var.a = tq5Var.a;
                    qq5Var.b = tq5Var.b;
                    qq5Var.c = tq5Var.c;
                    qq5Var.parserProtobuf(threadInfo);
                    arrayList.add(qq5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<tq5> list, List<tq5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (tq5 tq5Var : list2) {
            if (tq5Var != null) {
                hashMap.put(e(tq5Var), tq5Var.e);
            }
        }
        for (tq5 tq5Var2 : list) {
            if (tq5Var2 != null && !ListUtils.isEmpty(tq5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < tq5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = tq5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(tq5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < tq5Var2.e.size()) {
                                ThreadInfo threadInfo2 = null;
                                Iterator it = list4.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ThreadInfo threadInfo3 = (ThreadInfo) it.next();
                                    if (threadInfo3 != null && !list3.contains(threadInfo3.ala_info.live_id) && !arrayList2.contains(threadInfo3.ala_info.live_id) && !arrayList3.contains(threadInfo3.ala_info.live_id)) {
                                        threadInfo2 = threadInfo3;
                                        break;
                                    }
                                }
                                if (threadInfo2 != null) {
                                    arrayList3.add(threadInfo2.ala_info.live_id);
                                    tq5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    tq5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<pn>, List<pn>> d(String str, List<tq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (tq5 tq5Var : list) {
                if (tq5Var != null && !ListUtils.isEmpty(tq5Var.e)) {
                    List<pn> b = b(tq5Var);
                    String str2 = tq5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        uq5 uq5Var = new uq5();
                        uq5Var.a = tq5Var.a;
                        uq5Var.b = str2;
                        uq5Var.c = tq5Var.c;
                        uq5Var.d = tq5Var.d;
                        int i = tq5Var.f;
                        uq5Var.e = tq5Var.g;
                        linkedList.add(uq5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        tq5Var.e = tq5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(tq5Var.d)) {
                                    du5 du5Var = new du5();
                                    qq5 qq5Var = (qq5) b.get(i2);
                                    qq5 qq5Var2 = (qq5) b.get(i3);
                                    du5Var.a = qq5Var;
                                    du5Var.b = qq5Var2;
                                    arrayList.add(qq5Var);
                                    arrayList.add(qq5Var2);
                                    linkedList.add(du5Var);
                                } else if ("16:9".equals(tq5Var.d)) {
                                    cu5 cu5Var = new cu5();
                                    qq5 qq5Var3 = (qq5) b.get(i2);
                                    qq5 qq5Var4 = (qq5) b.get(i3);
                                    cu5Var.a = qq5Var3;
                                    cu5Var.b = qq5Var4;
                                    arrayList.add(qq5Var3);
                                    arrayList.add(qq5Var4);
                                    linkedList.add(cu5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(tq5Var);
                    }
                } else {
                    arrayList2.add(tq5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(tq5 tq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tq5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(tq5Var.a + "_");
            sb.append(tq5Var.b + "_");
            sb.append(tq5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(tq5 tq5Var, List<tq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, tq5Var, list)) == null) {
            if (tq5Var != null && !ListUtils.isEmpty(list)) {
                for (tq5 tq5Var2 : list) {
                    if (tq5Var.a == tq5Var2.a && tq5Var.b.equals(tq5Var2.b) && tq5Var.c.equals(tq5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<tq5> g(List<tq5> list, List<tq5> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, list, list2, z)) == null) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 == null || list2.isEmpty()) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (tq5 tq5Var : list2) {
                if (tq5Var != null && !ListUtils.isEmpty(tq5Var.e) && !TextUtils.isEmpty(tq5Var.b)) {
                    if (z) {
                        if (!f(tq5Var, list)) {
                            linkedList.add(tq5Var);
                        }
                    } else {
                        linkedList.add(tq5Var);
                    }
                }
            }
            if (z) {
                linkedList.addAll(0, list);
            }
            return linkedList;
        }
        return (List) invokeLLZ.objValue;
    }
}
