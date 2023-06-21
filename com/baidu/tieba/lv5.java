package com.baidu.tieba;

import android.util.Log;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class lv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<wn> a(List<? extends wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (wn wnVar : list) {
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        o45 o45Var = new o45();
                        o45Var.t = threadData;
                        o45Var.position = i;
                        o45Var.a = true;
                        o45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(o45Var);
                        o45 o45Var2 = new o45();
                        o45Var2.t = threadData;
                        o45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            o45Var2.d = true;
                            o45Var2.u = imageWidthAndHeight[0];
                            o45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o45Var2.e = true;
                        } else {
                            o45Var2.b = true;
                        }
                        o45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(o45Var2);
                        if (threadData.getItem() != null) {
                            o45 o45Var3 = new o45();
                            o45Var3.n = true;
                            o45Var3.t = threadData;
                            o45Var3.position = i;
                            o45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            o45 o45Var4 = new o45();
                            o45Var4.t = threadData;
                            o45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                o45Var4.p = true;
                            } else {
                                o45Var4.q = true;
                            }
                            o45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o45Var4);
                        }
                        o45 o45Var5 = new o45();
                        o45Var5.m = true;
                        o45Var5.t = threadData;
                        o45Var5.position = i;
                        o45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o45Var5);
                        o45 o45Var6 = new o45();
                        o45Var6.g = true;
                        o45Var6.t = threadData;
                        o45Var6.position = i;
                        o45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(o45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        o45 o45Var7 = new o45();
                        o45Var7.t = threadData;
                        o45Var7.position = i;
                        o45Var7.a = true;
                        o45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(o45Var7);
                        o45 o45Var8 = new o45();
                        o45Var8.t = threadData;
                        o45Var8.position = i;
                        o45Var8.i = true;
                        o45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o45Var8);
                        if (threadData.getItem() != null) {
                            o45 o45Var9 = new o45();
                            o45Var9.n = true;
                            o45Var9.t = threadData;
                            o45Var9.position = i;
                            o45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(o45Var9);
                        }
                        o45 o45Var10 = new o45();
                        o45Var10.m = true;
                        o45Var10.t = threadData;
                        o45Var10.position = i;
                        o45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(o45Var10);
                        o45 o45Var11 = new o45();
                        o45Var11.g = true;
                        o45Var11.t = threadData;
                        o45Var11.position = i;
                        o45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(o45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        o45 o45Var12 = new o45();
                        o45Var12.t = threadData;
                        o45Var12.position = i;
                        arrayList.add(o45Var12);
                    } else if (ap6.X(threadData)) {
                        ap6 ap6Var = new ap6(threadData);
                        ap6Var.g = threadData.getTid();
                        arrayList.add(ap6Var);
                    } else {
                        o45 o45Var13 = new o45();
                        o45Var13.t = threadData;
                        o45Var13.position = i;
                        arrayList.add(o45Var13);
                    }
                } else if (wnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) wnVar).position = i;
                    arrayList.add(wnVar);
                } else {
                    arrayList.add(wnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<wn> list, i15 i15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, i15Var) != null) || i15Var == null || list == null || (i = i15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    kv5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, i15Var);
                    return;
                }
                i2++;
            }
        }
    }

    public static List<ThreadData> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                arrayList.add(threadData);
            }
            Log.i("Template", "parserThreadList-> size = " + arrayList.size());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
