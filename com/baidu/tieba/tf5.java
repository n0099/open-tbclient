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
public class tf5 {
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
                        ot4 ot4Var = new ot4();
                        ot4Var.t = threadData;
                        ot4Var.position = i;
                        ot4Var.a = true;
                        ot4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(ot4Var);
                        ot4 ot4Var2 = new ot4();
                        ot4Var2.t = threadData;
                        ot4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ot4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ot4Var2.d = true;
                            ot4Var2.u = imageWidthAndHeight[0];
                            ot4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ot4Var2.e = true;
                        } else {
                            ot4Var2.b = true;
                        }
                        ot4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(ot4Var2);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var3 = new ot4();
                            ot4Var3.n = true;
                            ot4Var3.t = threadData;
                            ot4Var3.position = i;
                            ot4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ot4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            ot4 ot4Var4 = new ot4();
                            ot4Var4.t = threadData;
                            ot4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                ot4Var4.p = true;
                            } else {
                                ot4Var4.q = true;
                            }
                            ot4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ot4Var4);
                        }
                        ot4 ot4Var5 = new ot4();
                        ot4Var5.m = true;
                        ot4Var5.t = threadData;
                        ot4Var5.position = i;
                        ot4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ot4Var5);
                        ot4 ot4Var6 = new ot4();
                        ot4Var6.g = true;
                        ot4Var6.t = threadData;
                        ot4Var6.position = i;
                        ot4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(ot4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        ot4 ot4Var7 = new ot4();
                        ot4Var7.t = threadData;
                        ot4Var7.position = i;
                        ot4Var7.a = true;
                        ot4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(ot4Var7);
                        ot4 ot4Var8 = new ot4();
                        ot4Var8.t = threadData;
                        ot4Var8.position = i;
                        ot4Var8.i = true;
                        ot4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ot4Var8);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var9 = new ot4();
                            ot4Var9.n = true;
                            ot4Var9.t = threadData;
                            ot4Var9.position = i;
                            ot4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ot4Var9);
                        }
                        ot4 ot4Var10 = new ot4();
                        ot4Var10.m = true;
                        ot4Var10.t = threadData;
                        ot4Var10.position = i;
                        ot4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ot4Var10);
                        ot4 ot4Var11 = new ot4();
                        ot4Var11.g = true;
                        ot4Var11.t = threadData;
                        ot4Var11.position = i;
                        ot4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(ot4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        ot4 ot4Var12 = new ot4();
                        ot4Var12.t = threadData;
                        ot4Var12.position = i;
                        arrayList.add(ot4Var12);
                    } else if (j26.W(threadData)) {
                        j26 j26Var = new j26(threadData);
                        j26Var.g = threadData.getTid();
                        arrayList.add(j26Var);
                    } else {
                        ot4 ot4Var13 = new ot4();
                        ot4Var13.t = threadData;
                        ot4Var13.position = i;
                        arrayList.add(ot4Var13);
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

    public static void b(List<Cdo> list, lq4 lq4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, lq4Var) == null) || lq4Var == null || list == null || (i = lq4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    sf5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, lq4Var);
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
