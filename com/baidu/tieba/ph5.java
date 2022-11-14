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
public class ph5 {
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
                        wu4 wu4Var = new wu4();
                        wu4Var.t = threadData;
                        wu4Var.position = i;
                        wu4Var.a = true;
                        wu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(wu4Var);
                        wu4 wu4Var2 = new wu4();
                        wu4Var2.t = threadData;
                        wu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            wu4Var2.d = true;
                            wu4Var2.u = imageWidthAndHeight[0];
                            wu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wu4Var2.e = true;
                        } else {
                            wu4Var2.b = true;
                        }
                        wu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(wu4Var2);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var3 = new wu4();
                            wu4Var3.n = true;
                            wu4Var3.t = threadData;
                            wu4Var3.position = i;
                            wu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wu4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            wu4 wu4Var4 = new wu4();
                            wu4Var4.t = threadData;
                            wu4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                wu4Var4.p = true;
                            } else {
                                wu4Var4.q = true;
                            }
                            wu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wu4Var4);
                        }
                        wu4 wu4Var5 = new wu4();
                        wu4Var5.m = true;
                        wu4Var5.t = threadData;
                        wu4Var5.position = i;
                        wu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wu4Var5);
                        wu4 wu4Var6 = new wu4();
                        wu4Var6.g = true;
                        wu4Var6.t = threadData;
                        wu4Var6.position = i;
                        wu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(wu4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        wu4 wu4Var7 = new wu4();
                        wu4Var7.t = threadData;
                        wu4Var7.position = i;
                        wu4Var7.a = true;
                        wu4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(wu4Var7);
                        wu4 wu4Var8 = new wu4();
                        wu4Var8.t = threadData;
                        wu4Var8.position = i;
                        wu4Var8.i = true;
                        wu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wu4Var8);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var9 = new wu4();
                            wu4Var9.n = true;
                            wu4Var9.t = threadData;
                            wu4Var9.position = i;
                            wu4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(wu4Var9);
                        }
                        wu4 wu4Var10 = new wu4();
                        wu4Var10.m = true;
                        wu4Var10.t = threadData;
                        wu4Var10.position = i;
                        wu4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(wu4Var10);
                        wu4 wu4Var11 = new wu4();
                        wu4Var11.g = true;
                        wu4Var11.t = threadData;
                        wu4Var11.position = i;
                        wu4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(wu4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        wu4 wu4Var12 = new wu4();
                        wu4Var12.t = threadData;
                        wu4Var12.position = i;
                        arrayList.add(wu4Var12);
                    } else if (z46.W(threadData)) {
                        z46 z46Var = new z46(threadData);
                        z46Var.g = threadData.getTid();
                        arrayList.add(z46Var);
                    } else {
                        wu4 wu4Var13 = new wu4();
                        wu4Var13.t = threadData;
                        wu4Var13.position = i;
                        arrayList.add(wu4Var13);
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

    public static void b(List<xn> list, sr4 sr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, sr4Var) != null) || sr4Var == null || list == null || (i = sr4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    oh5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, sr4Var);
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
