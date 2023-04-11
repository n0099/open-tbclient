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
public class zo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<hn> a(List<? extends hn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (hn hnVar : list) {
                if (hnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) hnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        oz4 oz4Var = new oz4();
                        oz4Var.t = threadData;
                        oz4Var.position = i;
                        oz4Var.a = true;
                        oz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(oz4Var);
                        oz4 oz4Var2 = new oz4();
                        oz4Var2.t = threadData;
                        oz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            oz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            oz4Var2.d = true;
                            oz4Var2.u = imageWidthAndHeight[0];
                            oz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            oz4Var2.e = true;
                        } else {
                            oz4Var2.b = true;
                        }
                        oz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(oz4Var2);
                        if (threadData.getItem() != null) {
                            oz4 oz4Var3 = new oz4();
                            oz4Var3.n = true;
                            oz4Var3.t = threadData;
                            oz4Var3.position = i;
                            oz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(oz4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            oz4 oz4Var4 = new oz4();
                            oz4Var4.t = threadData;
                            oz4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                oz4Var4.p = true;
                            } else {
                                oz4Var4.q = true;
                            }
                            oz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(oz4Var4);
                        }
                        oz4 oz4Var5 = new oz4();
                        oz4Var5.m = true;
                        oz4Var5.t = threadData;
                        oz4Var5.position = i;
                        oz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(oz4Var5);
                        oz4 oz4Var6 = new oz4();
                        oz4Var6.g = true;
                        oz4Var6.t = threadData;
                        oz4Var6.position = i;
                        oz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(oz4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        oz4 oz4Var7 = new oz4();
                        oz4Var7.t = threadData;
                        oz4Var7.position = i;
                        oz4Var7.a = true;
                        oz4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(oz4Var7);
                        oz4 oz4Var8 = new oz4();
                        oz4Var8.t = threadData;
                        oz4Var8.position = i;
                        oz4Var8.i = true;
                        oz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(oz4Var8);
                        if (threadData.getItem() != null) {
                            oz4 oz4Var9 = new oz4();
                            oz4Var9.n = true;
                            oz4Var9.t = threadData;
                            oz4Var9.position = i;
                            oz4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(oz4Var9);
                        }
                        oz4 oz4Var10 = new oz4();
                        oz4Var10.m = true;
                        oz4Var10.t = threadData;
                        oz4Var10.position = i;
                        oz4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(oz4Var10);
                        oz4 oz4Var11 = new oz4();
                        oz4Var11.g = true;
                        oz4Var11.t = threadData;
                        oz4Var11.position = i;
                        oz4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(oz4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        oz4 oz4Var12 = new oz4();
                        oz4Var12.t = threadData;
                        oz4Var12.position = i;
                        arrayList.add(oz4Var12);
                    } else if (lh6.W(threadData)) {
                        lh6 lh6Var = new lh6(threadData);
                        lh6Var.g = threadData.getTid();
                        arrayList.add(lh6Var);
                    } else {
                        oz4 oz4Var13 = new oz4();
                        oz4Var13.t = threadData;
                        oz4Var13.position = i;
                        arrayList.add(oz4Var13);
                    }
                } else if (hnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) hnVar).position = i;
                    arrayList.add(hnVar);
                } else {
                    arrayList.add(hnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<hn> list, jw4 jw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, jw4Var) != null) || jw4Var == null || list == null || (i = jw4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    yo5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, jw4Var);
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
