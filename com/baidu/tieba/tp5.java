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
public class tp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<in> a(List<? extends in> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (in inVar : list) {
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        f05 f05Var = new f05();
                        f05Var.t = threadData;
                        f05Var.position = i;
                        f05Var.a = true;
                        f05Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(f05Var);
                        f05 f05Var2 = new f05();
                        f05Var2.t = threadData;
                        f05Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            f05Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            f05Var2.d = true;
                            f05Var2.u = imageWidthAndHeight[0];
                            f05Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            f05Var2.e = true;
                        } else {
                            f05Var2.b = true;
                        }
                        f05Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(f05Var2);
                        if (threadData.getItem() != null) {
                            f05 f05Var3 = new f05();
                            f05Var3.n = true;
                            f05Var3.t = threadData;
                            f05Var3.position = i;
                            f05Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(f05Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            f05 f05Var4 = new f05();
                            f05Var4.t = threadData;
                            f05Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                f05Var4.p = true;
                            } else {
                                f05Var4.q = true;
                            }
                            f05Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(f05Var4);
                        }
                        f05 f05Var5 = new f05();
                        f05Var5.m = true;
                        f05Var5.t = threadData;
                        f05Var5.position = i;
                        f05Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(f05Var5);
                        f05 f05Var6 = new f05();
                        f05Var6.g = true;
                        f05Var6.t = threadData;
                        f05Var6.position = i;
                        f05Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(f05Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        f05 f05Var7 = new f05();
                        f05Var7.t = threadData;
                        f05Var7.position = i;
                        f05Var7.a = true;
                        f05Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(f05Var7);
                        f05 f05Var8 = new f05();
                        f05Var8.t = threadData;
                        f05Var8.position = i;
                        f05Var8.i = true;
                        f05Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(f05Var8);
                        if (threadData.getItem() != null) {
                            f05 f05Var9 = new f05();
                            f05Var9.n = true;
                            f05Var9.t = threadData;
                            f05Var9.position = i;
                            f05Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(f05Var9);
                        }
                        f05 f05Var10 = new f05();
                        f05Var10.m = true;
                        f05Var10.t = threadData;
                        f05Var10.position = i;
                        f05Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(f05Var10);
                        f05 f05Var11 = new f05();
                        f05Var11.g = true;
                        f05Var11.t = threadData;
                        f05Var11.position = i;
                        f05Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(f05Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        f05 f05Var12 = new f05();
                        f05Var12.t = threadData;
                        f05Var12.position = i;
                        arrayList.add(f05Var12);
                    } else if (xi6.W(threadData)) {
                        xi6 xi6Var = new xi6(threadData);
                        xi6Var.g = threadData.getTid();
                        arrayList.add(xi6Var);
                    } else {
                        f05 f05Var13 = new f05();
                        f05Var13.t = threadData;
                        f05Var13.position = i;
                        arrayList.add(f05Var13);
                    }
                } else if (inVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) inVar).position = i;
                    arrayList.add(inVar);
                } else {
                    arrayList.add(inVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<in> list, ax4 ax4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, ax4Var) != null) || ax4Var == null || list == null || (i = ax4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    sp5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, ax4Var);
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
