package com.baidu.tieba;

import android.util.Log;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class mg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) eoVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        du4 du4Var = new du4();
                        du4Var.t = threadData;
                        du4Var.position = i;
                        du4Var.a = true;
                        du4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(du4Var);
                        du4 du4Var2 = new du4();
                        du4Var2.t = threadData;
                        du4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            du4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            du4Var2.d = true;
                            du4Var2.u = imageWidthAndHeight[0];
                            du4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            du4Var2.e = true;
                        } else {
                            du4Var2.b = true;
                        }
                        du4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(du4Var2);
                        if (threadData.getItem() != null) {
                            du4 du4Var3 = new du4();
                            du4Var3.n = true;
                            du4Var3.t = threadData;
                            du4Var3.position = i;
                            du4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(du4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            du4 du4Var4 = new du4();
                            du4Var4.t = threadData;
                            du4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                du4Var4.p = true;
                            } else {
                                du4Var4.q = true;
                            }
                            du4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(du4Var4);
                        }
                        du4 du4Var5 = new du4();
                        du4Var5.m = true;
                        du4Var5.t = threadData;
                        du4Var5.position = i;
                        du4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(du4Var5);
                        du4 du4Var6 = new du4();
                        du4Var6.g = true;
                        du4Var6.t = threadData;
                        du4Var6.position = i;
                        du4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(du4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        du4 du4Var7 = new du4();
                        du4Var7.t = threadData;
                        du4Var7.position = i;
                        du4Var7.a = true;
                        du4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(du4Var7);
                        du4 du4Var8 = new du4();
                        du4Var8.t = threadData;
                        du4Var8.position = i;
                        du4Var8.i = true;
                        du4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(du4Var8);
                        if (threadData.getItem() != null) {
                            du4 du4Var9 = new du4();
                            du4Var9.n = true;
                            du4Var9.t = threadData;
                            du4Var9.position = i;
                            du4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(du4Var9);
                        }
                        du4 du4Var10 = new du4();
                        du4Var10.m = true;
                        du4Var10.t = threadData;
                        du4Var10.position = i;
                        du4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(du4Var10);
                        du4 du4Var11 = new du4();
                        du4Var11.g = true;
                        du4Var11.t = threadData;
                        du4Var11.position = i;
                        du4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(du4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        du4 du4Var12 = new du4();
                        du4Var12.t = threadData;
                        du4Var12.position = i;
                        arrayList.add(du4Var12);
                    } else if (d36.W(threadData)) {
                        d36 d36Var = new d36(threadData);
                        d36Var.g = threadData.getTid();
                        arrayList.add(d36Var);
                    } else {
                        du4 du4Var13 = new du4();
                        du4Var13.t = threadData;
                        du4Var13.position = i;
                        arrayList.add(du4Var13);
                    }
                } else if (eoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) eoVar).position = i;
                    arrayList.add(eoVar);
                } else {
                    arrayList.add(eoVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List list, ar4 ar4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, ar4Var) != null) || ar4Var == null || list == null || (i = ar4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (((eo) list.get(i3)) instanceof ThreadData) {
                if (i == i2) {
                    lg5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, ar4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public static List c(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf((ThreadInfo) it.next());
                threadData.insertItemToTitleOrAbstractText();
                arrayList.add(threadData);
            }
            Log.i("Template", "parserThreadList-> size = " + arrayList.size());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
