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
public class uw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yn> a(List<? extends yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (yn ynVar : list) {
                if (ynVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ynVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        z45 z45Var = new z45();
                        z45Var.t = threadData;
                        z45Var.position = i;
                        z45Var.a = true;
                        z45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(z45Var);
                        z45 z45Var2 = new z45();
                        z45Var2.t = threadData;
                        z45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            z45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            z45Var2.d = true;
                            z45Var2.u = imageWidthAndHeight[0];
                            z45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            z45Var2.e = true;
                        } else {
                            z45Var2.b = true;
                        }
                        z45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(z45Var2);
                        if (threadData.getItem() != null) {
                            z45 z45Var3 = new z45();
                            z45Var3.n = true;
                            z45Var3.t = threadData;
                            z45Var3.position = i;
                            z45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(z45Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            z45 z45Var4 = new z45();
                            z45Var4.t = threadData;
                            z45Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                z45Var4.p = true;
                            } else {
                                z45Var4.q = true;
                            }
                            z45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(z45Var4);
                        }
                        z45 z45Var5 = new z45();
                        z45Var5.m = true;
                        z45Var5.t = threadData;
                        z45Var5.position = i;
                        z45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(z45Var5);
                        z45 z45Var6 = new z45();
                        z45Var6.g = true;
                        z45Var6.t = threadData;
                        z45Var6.position = i;
                        z45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(z45Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        z45 z45Var7 = new z45();
                        z45Var7.t = threadData;
                        z45Var7.position = i;
                        z45Var7.a = true;
                        z45Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(z45Var7);
                        z45 z45Var8 = new z45();
                        z45Var8.t = threadData;
                        z45Var8.position = i;
                        z45Var8.i = true;
                        z45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(z45Var8);
                        if (threadData.getItem() != null) {
                            z45 z45Var9 = new z45();
                            z45Var9.n = true;
                            z45Var9.t = threadData;
                            z45Var9.position = i;
                            z45Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(z45Var9);
                        }
                        z45 z45Var10 = new z45();
                        z45Var10.m = true;
                        z45Var10.t = threadData;
                        z45Var10.position = i;
                        z45Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(z45Var10);
                        z45 z45Var11 = new z45();
                        z45Var11.g = true;
                        z45Var11.t = threadData;
                        z45Var11.position = i;
                        z45Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(z45Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        z45 z45Var12 = new z45();
                        z45Var12.t = threadData;
                        z45Var12.position = i;
                        arrayList.add(z45Var12);
                    } else if (jq6.X(threadData)) {
                        jq6 jq6Var = new jq6(threadData);
                        jq6Var.g = threadData.getTid();
                        arrayList.add(jq6Var);
                    } else {
                        z45 z45Var13 = new z45();
                        z45Var13.t = threadData;
                        z45Var13.position = i;
                        arrayList.add(z45Var13);
                    }
                } else if (ynVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) ynVar).position = i;
                    arrayList.add(ynVar);
                } else {
                    arrayList.add(ynVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<yn> list, t15 t15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, t15Var) != null) || t15Var == null || list == null || (i = t15Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    tw5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, t15Var);
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
