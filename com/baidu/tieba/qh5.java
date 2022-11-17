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
public class qh5 {
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
                        xu4 xu4Var = new xu4();
                        xu4Var.t = threadData;
                        xu4Var.position = i;
                        xu4Var.a = true;
                        xu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(xu4Var);
                        xu4 xu4Var2 = new xu4();
                        xu4Var2.t = threadData;
                        xu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            xu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            xu4Var2.d = true;
                            xu4Var2.u = imageWidthAndHeight[0];
                            xu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            xu4Var2.e = true;
                        } else {
                            xu4Var2.b = true;
                        }
                        xu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(xu4Var2);
                        if (threadData.getItem() != null) {
                            xu4 xu4Var3 = new xu4();
                            xu4Var3.n = true;
                            xu4Var3.t = threadData;
                            xu4Var3.position = i;
                            xu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(xu4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            xu4 xu4Var4 = new xu4();
                            xu4Var4.t = threadData;
                            xu4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                xu4Var4.p = true;
                            } else {
                                xu4Var4.q = true;
                            }
                            xu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(xu4Var4);
                        }
                        xu4 xu4Var5 = new xu4();
                        xu4Var5.m = true;
                        xu4Var5.t = threadData;
                        xu4Var5.position = i;
                        xu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(xu4Var5);
                        xu4 xu4Var6 = new xu4();
                        xu4Var6.g = true;
                        xu4Var6.t = threadData;
                        xu4Var6.position = i;
                        xu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(xu4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        xu4 xu4Var7 = new xu4();
                        xu4Var7.t = threadData;
                        xu4Var7.position = i;
                        xu4Var7.a = true;
                        xu4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(xu4Var7);
                        xu4 xu4Var8 = new xu4();
                        xu4Var8.t = threadData;
                        xu4Var8.position = i;
                        xu4Var8.i = true;
                        xu4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(xu4Var8);
                        if (threadData.getItem() != null) {
                            xu4 xu4Var9 = new xu4();
                            xu4Var9.n = true;
                            xu4Var9.t = threadData;
                            xu4Var9.position = i;
                            xu4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(xu4Var9);
                        }
                        xu4 xu4Var10 = new xu4();
                        xu4Var10.m = true;
                        xu4Var10.t = threadData;
                        xu4Var10.position = i;
                        xu4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(xu4Var10);
                        xu4 xu4Var11 = new xu4();
                        xu4Var11.g = true;
                        xu4Var11.t = threadData;
                        xu4Var11.position = i;
                        xu4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(xu4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        xu4 xu4Var12 = new xu4();
                        xu4Var12.t = threadData;
                        xu4Var12.position = i;
                        arrayList.add(xu4Var12);
                    } else if (a56.W(threadData)) {
                        a56 a56Var = new a56(threadData);
                        a56Var.g = threadData.getTid();
                        arrayList.add(a56Var);
                    } else {
                        xu4 xu4Var13 = new xu4();
                        xu4Var13.t = threadData;
                        xu4Var13.position = i;
                        arrayList.add(xu4Var13);
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

    public static void b(List<xn> list, tr4 tr4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, tr4Var) != null) || tr4Var == null || list == null || (i = tr4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    ph5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, tr4Var);
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
