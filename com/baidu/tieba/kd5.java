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
/* loaded from: classes4.dex */
public class kd5 {
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
                        jr4 jr4Var = new jr4();
                        jr4Var.t = threadData;
                        jr4Var.position = i;
                        jr4Var.a = true;
                        jr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jr4Var);
                        jr4 jr4Var2 = new jr4();
                        jr4Var2.t = threadData;
                        jr4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jr4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jr4Var2.d = true;
                            jr4Var2.u = imageWidthAndHeight[0];
                            jr4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jr4Var2.e = true;
                        } else {
                            jr4Var2.b = true;
                        }
                        jr4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(jr4Var2);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var3 = new jr4();
                            jr4Var3.n = true;
                            jr4Var3.t = threadData;
                            jr4Var3.position = i;
                            jr4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jr4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            jr4 jr4Var4 = new jr4();
                            jr4Var4.t = threadData;
                            jr4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                jr4Var4.p = true;
                            } else {
                                jr4Var4.q = true;
                            }
                            jr4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jr4Var4);
                        }
                        jr4 jr4Var5 = new jr4();
                        jr4Var5.m = true;
                        jr4Var5.t = threadData;
                        jr4Var5.position = i;
                        jr4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jr4Var5);
                        jr4 jr4Var6 = new jr4();
                        jr4Var6.g = true;
                        jr4Var6.t = threadData;
                        jr4Var6.position = i;
                        jr4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jr4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jr4 jr4Var7 = new jr4();
                        jr4Var7.t = threadData;
                        jr4Var7.position = i;
                        jr4Var7.a = true;
                        jr4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jr4Var7);
                        jr4 jr4Var8 = new jr4();
                        jr4Var8.t = threadData;
                        jr4Var8.position = i;
                        jr4Var8.i = true;
                        jr4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jr4Var8);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var9 = new jr4();
                            jr4Var9.n = true;
                            jr4Var9.t = threadData;
                            jr4Var9.position = i;
                            jr4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jr4Var9);
                        }
                        jr4 jr4Var10 = new jr4();
                        jr4Var10.m = true;
                        jr4Var10.t = threadData;
                        jr4Var10.position = i;
                        jr4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jr4Var10);
                        jr4 jr4Var11 = new jr4();
                        jr4Var11.g = true;
                        jr4Var11.t = threadData;
                        jr4Var11.position = i;
                        jr4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jr4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        jr4 jr4Var12 = new jr4();
                        jr4Var12.t = threadData;
                        jr4Var12.position = i;
                        arrayList.add(jr4Var12);
                    } else if (s06.W(threadData)) {
                        s06 s06Var = new s06(threadData);
                        s06Var.g = threadData.getTid();
                        arrayList.add(s06Var);
                    } else {
                        jr4 jr4Var13 = new jr4();
                        jr4Var13.t = threadData;
                        jr4Var13.position = i;
                        arrayList.add(jr4Var13);
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

    public static void b(List<pn> list, go4 go4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, go4Var) == null) || go4Var == null || list == null || (i = go4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    jd5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, go4Var);
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
