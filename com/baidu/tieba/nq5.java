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
public class nq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<rq5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new rq5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<pn> b(rq5 rq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rq5Var)) == null) {
            List<ThreadInfo> list = rq5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    oq5 oq5Var = new oq5();
                    oq5Var.a = rq5Var.a;
                    oq5Var.b = rq5Var.b;
                    oq5Var.c = rq5Var.c;
                    oq5Var.parserProtobuf(threadInfo);
                    arrayList.add(oq5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<rq5> list, List<rq5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (rq5 rq5Var : list2) {
            if (rq5Var != null) {
                hashMap.put(e(rq5Var), rq5Var.e);
            }
        }
        for (rq5 rq5Var2 : list) {
            if (rq5Var2 != null && !ListUtils.isEmpty(rq5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < rq5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = rq5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(rq5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < rq5Var2.e.size()) {
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
                                    rq5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    rq5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<pn>, List<pn>> d(String str, List<rq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (rq5 rq5Var : list) {
                if (rq5Var != null && !ListUtils.isEmpty(rq5Var.e)) {
                    List<pn> b = b(rq5Var);
                    String str2 = rq5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        sq5 sq5Var = new sq5();
                        sq5Var.a = rq5Var.a;
                        sq5Var.b = str2;
                        sq5Var.c = rq5Var.c;
                        sq5Var.d = rq5Var.d;
                        int i = rq5Var.f;
                        sq5Var.e = rq5Var.g;
                        linkedList.add(sq5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        rq5Var.e = rq5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(rq5Var.d)) {
                                    bu5 bu5Var = new bu5();
                                    oq5 oq5Var = (oq5) b.get(i2);
                                    oq5 oq5Var2 = (oq5) b.get(i3);
                                    bu5Var.a = oq5Var;
                                    bu5Var.b = oq5Var2;
                                    arrayList.add(oq5Var);
                                    arrayList.add(oq5Var2);
                                    linkedList.add(bu5Var);
                                } else if ("16:9".equals(rq5Var.d)) {
                                    au5 au5Var = new au5();
                                    oq5 oq5Var3 = (oq5) b.get(i2);
                                    oq5 oq5Var4 = (oq5) b.get(i3);
                                    au5Var.a = oq5Var3;
                                    au5Var.b = oq5Var4;
                                    arrayList.add(oq5Var3);
                                    arrayList.add(oq5Var4);
                                    linkedList.add(au5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(rq5Var);
                    }
                } else {
                    arrayList2.add(rq5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(rq5 rq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rq5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(rq5Var.a + "_");
            sb.append(rq5Var.b + "_");
            sb.append(rq5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(rq5 rq5Var, List<rq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, rq5Var, list)) == null) {
            if (rq5Var != null && !ListUtils.isEmpty(list)) {
                for (rq5 rq5Var2 : list) {
                    if (rq5Var.a == rq5Var2.a && rq5Var.b.equals(rq5Var2.b) && rq5Var.c.equals(rq5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<rq5> g(List<rq5> list, List<rq5> list2, boolean z) {
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
            for (rq5 rq5Var : list2) {
                if (rq5Var != null && !ListUtils.isEmpty(rq5Var.e) && !TextUtils.isEmpty(rq5Var.b)) {
                    if (z) {
                        if (!f(rq5Var, list)) {
                            linkedList.add(rq5Var);
                        }
                    } else {
                        linkedList.add(rq5Var);
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
