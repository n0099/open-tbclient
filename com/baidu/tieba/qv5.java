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
/* loaded from: classes7.dex */
public class qv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xn> a(List<? extends xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (xn xnVar : list) {
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        r45 r45Var = new r45();
                        r45Var.t = threadData;
                        r45Var.position = i;
                        r45Var.a = true;
                        r45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(r45Var);
                        r45 r45Var2 = new r45();
                        r45Var2.t = threadData;
                        r45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            r45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            r45Var2.d = true;
                            r45Var2.u = imageWidthAndHeight[0];
                            r45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            r45Var2.e = true;
                        } else {
                            r45Var2.b = true;
                        }
                        r45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(r45Var2);
                        if (threadData.getItem() != null) {
                            r45 r45Var3 = new r45();
                            r45Var3.n = true;
                            r45Var3.t = threadData;
                            r45Var3.position = i;
                            r45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(r45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            r45 r45Var4 = new r45();
                            r45Var4.t = threadData;
                            r45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                r45Var4.p = true;
                            } else {
                                r45Var4.q = true;
                            }
                            r45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(r45Var4);
                        }
                        r45 r45Var5 = new r45();
                        r45Var5.m = true;
                        r45Var5.t = threadData;
                        r45Var5.position = i;
                        r45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(r45Var5);
                        r45 r45Var6 = new r45();
                        r45Var6.g = true;
                        r45Var6.t = threadData;
                        r45Var6.position = i;
                        r45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(r45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        r45 r45Var7 = new r45();
                        r45Var7.t = threadData;
                        r45Var7.position = i;
                        r45Var7.a = true;
                        r45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(r45Var7);
                        r45 r45Var8 = new r45();
                        r45Var8.t = threadData;
                        r45Var8.position = i;
                        r45Var8.i = true;
                        r45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(r45Var8);
                        if (threadData.getItem() != null) {
                            r45 r45Var9 = new r45();
                            r45Var9.n = true;
                            r45Var9.t = threadData;
                            r45Var9.position = i;
                            r45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(r45Var9);
                        }
                        r45 r45Var10 = new r45();
                        r45Var10.m = true;
                        r45Var10.t = threadData;
                        r45Var10.position = i;
                        r45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(r45Var10);
                        r45 r45Var11 = new r45();
                        r45Var11.g = true;
                        r45Var11.t = threadData;
                        r45Var11.position = i;
                        r45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(r45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        r45 r45Var12 = new r45();
                        r45Var12.t = threadData;
                        r45Var12.position = i;
                        arrayList.add(r45Var12);
                    } else if (fp6.X(threadData)) {
                        fp6 fp6Var = new fp6(threadData);
                        fp6Var.g = threadData.getTid();
                        arrayList.add(fp6Var);
                    } else {
                        r45 r45Var13 = new r45();
                        r45Var13.t = threadData;
                        r45Var13.position = i;
                        arrayList.add(r45Var13);
                    }
                } else if (xnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) xnVar).position = i;
                    arrayList.add(xnVar);
                } else {
                    arrayList.add(xnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<xn> list, l15 l15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, l15Var) != null) || l15Var == null || list == null || (i = l15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    pv5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, l15Var);
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
