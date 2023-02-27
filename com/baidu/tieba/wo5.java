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
public class wo5 {
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
                        d15 d15Var = new d15();
                        d15Var.t = threadData;
                        d15Var.position = i;
                        d15Var.a = true;
                        d15Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(d15Var);
                        d15 d15Var2 = new d15();
                        d15Var2.t = threadData;
                        d15Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            d15Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            d15Var2.d = true;
                            d15Var2.u = imageWidthAndHeight[0];
                            d15Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            d15Var2.e = true;
                        } else {
                            d15Var2.b = true;
                        }
                        d15Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(d15Var2);
                        if (threadData.getItem() != null) {
                            d15 d15Var3 = new d15();
                            d15Var3.n = true;
                            d15Var3.t = threadData;
                            d15Var3.position = i;
                            d15Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d15Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            d15 d15Var4 = new d15();
                            d15Var4.t = threadData;
                            d15Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                d15Var4.p = true;
                            } else {
                                d15Var4.q = true;
                            }
                            d15Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d15Var4);
                        }
                        d15 d15Var5 = new d15();
                        d15Var5.m = true;
                        d15Var5.t = threadData;
                        d15Var5.position = i;
                        d15Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d15Var5);
                        d15 d15Var6 = new d15();
                        d15Var6.g = true;
                        d15Var6.t = threadData;
                        d15Var6.position = i;
                        d15Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(d15Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        d15 d15Var7 = new d15();
                        d15Var7.t = threadData;
                        d15Var7.position = i;
                        d15Var7.a = true;
                        d15Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(d15Var7);
                        d15 d15Var8 = new d15();
                        d15Var8.t = threadData;
                        d15Var8.position = i;
                        d15Var8.i = true;
                        d15Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d15Var8);
                        if (threadData.getItem() != null) {
                            d15 d15Var9 = new d15();
                            d15Var9.n = true;
                            d15Var9.t = threadData;
                            d15Var9.position = i;
                            d15Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(d15Var9);
                        }
                        d15 d15Var10 = new d15();
                        d15Var10.m = true;
                        d15Var10.t = threadData;
                        d15Var10.position = i;
                        d15Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(d15Var10);
                        d15 d15Var11 = new d15();
                        d15Var11.g = true;
                        d15Var11.t = threadData;
                        d15Var11.position = i;
                        d15Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(d15Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        d15 d15Var12 = new d15();
                        d15Var12.t = threadData;
                        d15Var12.position = i;
                        arrayList.add(d15Var12);
                    } else if (lg6.W(threadData)) {
                        lg6 lg6Var = new lg6(threadData);
                        lg6Var.g = threadData.getTid();
                        arrayList.add(lg6Var);
                    } else {
                        d15 d15Var13 = new d15();
                        d15Var13.t = threadData;
                        d15Var13.position = i;
                        arrayList.add(d15Var13);
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

    public static void b(List<Cdo> list, zx4 zx4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, zx4Var) != null) || zx4Var == null || list == null || (i = zx4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    vo5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, zx4Var);
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
