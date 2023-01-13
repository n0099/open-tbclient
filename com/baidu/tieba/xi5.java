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
public class xi5 {
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
                        jv4 jv4Var = new jv4();
                        jv4Var.t = threadData;
                        jv4Var.position = i;
                        jv4Var.a = true;
                        jv4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jv4Var);
                        jv4 jv4Var2 = new jv4();
                        jv4Var2.t = threadData;
                        jv4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jv4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jv4Var2.d = true;
                            jv4Var2.u = imageWidthAndHeight[0];
                            jv4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jv4Var2.e = true;
                        } else {
                            jv4Var2.b = true;
                        }
                        jv4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(jv4Var2);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var3 = new jv4();
                            jv4Var3.n = true;
                            jv4Var3.t = threadData;
                            jv4Var3.position = i;
                            jv4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jv4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            jv4 jv4Var4 = new jv4();
                            jv4Var4.t = threadData;
                            jv4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                jv4Var4.p = true;
                            } else {
                                jv4Var4.q = true;
                            }
                            jv4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jv4Var4);
                        }
                        jv4 jv4Var5 = new jv4();
                        jv4Var5.m = true;
                        jv4Var5.t = threadData;
                        jv4Var5.position = i;
                        jv4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jv4Var5);
                        jv4 jv4Var6 = new jv4();
                        jv4Var6.g = true;
                        jv4Var6.t = threadData;
                        jv4Var6.position = i;
                        jv4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jv4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jv4 jv4Var7 = new jv4();
                        jv4Var7.t = threadData;
                        jv4Var7.position = i;
                        jv4Var7.a = true;
                        jv4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(jv4Var7);
                        jv4 jv4Var8 = new jv4();
                        jv4Var8.t = threadData;
                        jv4Var8.position = i;
                        jv4Var8.i = true;
                        jv4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jv4Var8);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var9 = new jv4();
                            jv4Var9.n = true;
                            jv4Var9.t = threadData;
                            jv4Var9.position = i;
                            jv4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(jv4Var9);
                        }
                        jv4 jv4Var10 = new jv4();
                        jv4Var10.m = true;
                        jv4Var10.t = threadData;
                        jv4Var10.position = i;
                        jv4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(jv4Var10);
                        jv4 jv4Var11 = new jv4();
                        jv4Var11.g = true;
                        jv4Var11.t = threadData;
                        jv4Var11.position = i;
                        jv4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(jv4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        jv4 jv4Var12 = new jv4();
                        jv4Var12.t = threadData;
                        jv4Var12.position = i;
                        arrayList.add(jv4Var12);
                    } else if (n96.W(threadData)) {
                        n96 n96Var = new n96(threadData);
                        n96Var.g = threadData.getTid();
                        arrayList.add(n96Var);
                    } else {
                        jv4 jv4Var13 = new jv4();
                        jv4Var13.t = threadData;
                        jv4Var13.position = i;
                        arrayList.add(jv4Var13);
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

    public static void b(List<yn> list, fs4 fs4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, fs4Var) != null) || fs4Var == null || list == null || (i = fs4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    wi5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, fs4Var);
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
