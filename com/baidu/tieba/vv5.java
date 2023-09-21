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
/* loaded from: classes8.dex */
public class vv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<bn> a(List<? extends bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (bn bnVar : list) {
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        h45 h45Var = new h45();
                        h45Var.t = threadData;
                        h45Var.position = i;
                        h45Var.a = true;
                        h45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(h45Var);
                        h45 h45Var2 = new h45();
                        h45Var2.t = threadData;
                        h45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            h45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            h45Var2.d = true;
                            h45Var2.u = imageWidthAndHeight[0];
                            h45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            h45Var2.e = true;
                        } else {
                            h45Var2.b = true;
                        }
                        h45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(h45Var2);
                        if (threadData.getItem() != null) {
                            h45 h45Var3 = new h45();
                            h45Var3.n = true;
                            h45Var3.t = threadData;
                            h45Var3.position = i;
                            h45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(h45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            h45 h45Var4 = new h45();
                            h45Var4.t = threadData;
                            h45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                h45Var4.p = true;
                            } else {
                                h45Var4.q = true;
                            }
                            h45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(h45Var4);
                        }
                        h45 h45Var5 = new h45();
                        h45Var5.m = true;
                        h45Var5.t = threadData;
                        h45Var5.position = i;
                        h45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(h45Var5);
                        h45 h45Var6 = new h45();
                        h45Var6.g = true;
                        h45Var6.t = threadData;
                        h45Var6.position = i;
                        h45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(h45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        h45 h45Var7 = new h45();
                        h45Var7.t = threadData;
                        h45Var7.position = i;
                        h45Var7.a = true;
                        h45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(h45Var7);
                        h45 h45Var8 = new h45();
                        h45Var8.t = threadData;
                        h45Var8.position = i;
                        h45Var8.i = true;
                        h45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(h45Var8);
                        if (threadData.getItem() != null) {
                            h45 h45Var9 = new h45();
                            h45Var9.n = true;
                            h45Var9.t = threadData;
                            h45Var9.position = i;
                            h45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(h45Var9);
                        }
                        h45 h45Var10 = new h45();
                        h45Var10.m = true;
                        h45Var10.t = threadData;
                        h45Var10.position = i;
                        h45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(h45Var10);
                        h45 h45Var11 = new h45();
                        h45Var11.g = true;
                        h45Var11.t = threadData;
                        h45Var11.position = i;
                        h45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(h45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        h45 h45Var12 = new h45();
                        h45Var12.t = threadData;
                        h45Var12.position = i;
                        arrayList.add(h45Var12);
                    } else if (hq6.R(threadData)) {
                        hq6 hq6Var = new hq6(threadData);
                        hq6Var.g = threadData.getTid();
                        arrayList.add(hq6Var);
                    } else {
                        h45 h45Var13 = new h45();
                        h45Var13.t = threadData;
                        h45Var13.position = i;
                        arrayList.add(h45Var13);
                    }
                } else if (bnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) bnVar).position = i;
                    arrayList.add(bnVar);
                } else {
                    arrayList.add(bnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<bn> list, b15 b15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, b15Var) != null) || b15Var == null || list == null || (i = b15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    uv5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, b15Var);
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
