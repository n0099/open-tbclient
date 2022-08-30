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
public class md5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pn> a(List<? extends pn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (pn pnVar : list) {
                if (pnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) pnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        kr4 kr4Var = new kr4();
                        kr4Var.t = threadData;
                        kr4Var.position = i;
                        kr4Var.a = true;
                        kr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(kr4Var);
                        kr4 kr4Var2 = new kr4();
                        kr4Var2.t = threadData;
                        kr4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            kr4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            kr4Var2.d = true;
                            kr4Var2.u = imageWidthAndHeight[0];
                            kr4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            kr4Var2.e = true;
                        } else {
                            kr4Var2.b = true;
                        }
                        kr4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(kr4Var2);
                        if (threadData.getItem() != null) {
                            kr4 kr4Var3 = new kr4();
                            kr4Var3.n = true;
                            kr4Var3.t = threadData;
                            kr4Var3.position = i;
                            kr4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(kr4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            kr4 kr4Var4 = new kr4();
                            kr4Var4.t = threadData;
                            kr4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                kr4Var4.p = true;
                            } else {
                                kr4Var4.q = true;
                            }
                            kr4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(kr4Var4);
                        }
                        kr4 kr4Var5 = new kr4();
                        kr4Var5.m = true;
                        kr4Var5.t = threadData;
                        kr4Var5.position = i;
                        kr4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(kr4Var5);
                        kr4 kr4Var6 = new kr4();
                        kr4Var6.g = true;
                        kr4Var6.t = threadData;
                        kr4Var6.position = i;
                        kr4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(kr4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        kr4 kr4Var7 = new kr4();
                        kr4Var7.t = threadData;
                        kr4Var7.position = i;
                        kr4Var7.a = true;
                        kr4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(kr4Var7);
                        kr4 kr4Var8 = new kr4();
                        kr4Var8.t = threadData;
                        kr4Var8.position = i;
                        kr4Var8.i = true;
                        kr4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(kr4Var8);
                        if (threadData.getItem() != null) {
                            kr4 kr4Var9 = new kr4();
                            kr4Var9.n = true;
                            kr4Var9.t = threadData;
                            kr4Var9.position = i;
                            kr4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(kr4Var9);
                        }
                        kr4 kr4Var10 = new kr4();
                        kr4Var10.m = true;
                        kr4Var10.t = threadData;
                        kr4Var10.position = i;
                        kr4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(kr4Var10);
                        kr4 kr4Var11 = new kr4();
                        kr4Var11.g = true;
                        kr4Var11.t = threadData;
                        kr4Var11.position = i;
                        kr4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(kr4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        kr4 kr4Var12 = new kr4();
                        kr4Var12.t = threadData;
                        kr4Var12.position = i;
                        arrayList.add(kr4Var12);
                    } else if (u06.W(threadData)) {
                        u06 u06Var = new u06(threadData);
                        u06Var.g = threadData.getTid();
                        arrayList.add(u06Var);
                    } else {
                        kr4 kr4Var13 = new kr4();
                        kr4Var13.t = threadData;
                        kr4Var13.position = i;
                        arrayList.add(kr4Var13);
                    }
                } else if (pnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) pnVar).position = i;
                    arrayList.add(pnVar);
                } else {
                    arrayList.add(pnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<pn> list, ho4 ho4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, ho4Var) == null) || ho4Var == null || list == null || (i = ho4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    ld5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, ho4Var);
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
