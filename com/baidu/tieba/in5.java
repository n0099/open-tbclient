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
/* loaded from: classes5.dex */
public class in5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<Cdo> a(List<? extends Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Cdo cdo : list) {
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        wz4 wz4Var = new wz4();
                        wz4Var.t = threadData;
                        wz4Var.position = i;
                        wz4Var.a = true;
                        wz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(wz4Var);
                        wz4 wz4Var2 = new wz4();
                        wz4Var2.t = threadData;
                        wz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            wz4Var2.d = true;
                            wz4Var2.u = imageWidthAndHeight[0];
                            wz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wz4Var2.e = true;
                        } else {
                            wz4Var2.b = true;
                        }
                        wz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(wz4Var2);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var3 = new wz4();
                            wz4Var3.n = true;
                            wz4Var3.t = threadData;
                            wz4Var3.position = i;
                            wz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wz4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            wz4 wz4Var4 = new wz4();
                            wz4Var4.t = threadData;
                            wz4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                wz4Var4.p = true;
                            } else {
                                wz4Var4.q = true;
                            }
                            wz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wz4Var4);
                        }
                        wz4 wz4Var5 = new wz4();
                        wz4Var5.m = true;
                        wz4Var5.t = threadData;
                        wz4Var5.position = i;
                        wz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wz4Var5);
                        wz4 wz4Var6 = new wz4();
                        wz4Var6.g = true;
                        wz4Var6.t = threadData;
                        wz4Var6.position = i;
                        wz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(wz4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        wz4 wz4Var7 = new wz4();
                        wz4Var7.t = threadData;
                        wz4Var7.position = i;
                        wz4Var7.a = true;
                        wz4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(wz4Var7);
                        wz4 wz4Var8 = new wz4();
                        wz4Var8.t = threadData;
                        wz4Var8.position = i;
                        wz4Var8.i = true;
                        wz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wz4Var8);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var9 = new wz4();
                            wz4Var9.n = true;
                            wz4Var9.t = threadData;
                            wz4Var9.position = i;
                            wz4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wz4Var9);
                        }
                        wz4 wz4Var10 = new wz4();
                        wz4Var10.m = true;
                        wz4Var10.t = threadData;
                        wz4Var10.position = i;
                        wz4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wz4Var10);
                        wz4 wz4Var11 = new wz4();
                        wz4Var11.g = true;
                        wz4Var11.t = threadData;
                        wz4Var11.position = i;
                        wz4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(wz4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        wz4 wz4Var12 = new wz4();
                        wz4Var12.t = threadData;
                        wz4Var12.position = i;
                        arrayList.add(wz4Var12);
                    } else if (zd6.W(threadData)) {
                        zd6 zd6Var = new zd6(threadData);
                        zd6Var.g = threadData.getTid();
                        arrayList.add(zd6Var);
                    } else {
                        wz4 wz4Var13 = new wz4();
                        wz4Var13.t = threadData;
                        wz4Var13.position = i;
                        arrayList.add(wz4Var13);
                    }
                } else if (cdo instanceof BaseCardInfo) {
                    ((BaseCardInfo) cdo).position = i;
                    arrayList.add(cdo);
                } else {
                    arrayList.add(cdo);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<Cdo> list, sw4 sw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, sw4Var) != null) || sw4Var == null || list == null || (i = sw4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    hn5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, sw4Var);
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
