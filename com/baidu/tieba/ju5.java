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
public class ju5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ym> a(List<? extends ym> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ym ymVar : list) {
                if (ymVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ymVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        w35 w35Var = new w35();
                        w35Var.t = threadData;
                        w35Var.position = i;
                        w35Var.a = true;
                        w35Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(w35Var);
                        w35 w35Var2 = new w35();
                        w35Var2.t = threadData;
                        w35Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            w35Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            w35Var2.d = true;
                            w35Var2.u = imageWidthAndHeight[0];
                            w35Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            w35Var2.e = true;
                        } else {
                            w35Var2.b = true;
                        }
                        w35Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(w35Var2);
                        if (threadData.getItem() != null) {
                            w35 w35Var3 = new w35();
                            w35Var3.n = true;
                            w35Var3.t = threadData;
                            w35Var3.position = i;
                            w35Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(w35Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            w35 w35Var4 = new w35();
                            w35Var4.t = threadData;
                            w35Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                w35Var4.p = true;
                            } else {
                                w35Var4.q = true;
                            }
                            w35Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(w35Var4);
                        }
                        w35 w35Var5 = new w35();
                        w35Var5.m = true;
                        w35Var5.t = threadData;
                        w35Var5.position = i;
                        w35Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(w35Var5);
                        w35 w35Var6 = new w35();
                        w35Var6.g = true;
                        w35Var6.t = threadData;
                        w35Var6.position = i;
                        w35Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(w35Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        w35 w35Var7 = new w35();
                        w35Var7.t = threadData;
                        w35Var7.position = i;
                        w35Var7.a = true;
                        w35Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(w35Var7);
                        w35 w35Var8 = new w35();
                        w35Var8.t = threadData;
                        w35Var8.position = i;
                        w35Var8.i = true;
                        w35Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(w35Var8);
                        if (threadData.getItem() != null) {
                            w35 w35Var9 = new w35();
                            w35Var9.n = true;
                            w35Var9.t = threadData;
                            w35Var9.position = i;
                            w35Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(w35Var9);
                        }
                        w35 w35Var10 = new w35();
                        w35Var10.m = true;
                        w35Var10.t = threadData;
                        w35Var10.position = i;
                        w35Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(w35Var10);
                        w35 w35Var11 = new w35();
                        w35Var11.g = true;
                        w35Var11.t = threadData;
                        w35Var11.position = i;
                        w35Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(w35Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        w35 w35Var12 = new w35();
                        w35Var12.t = threadData;
                        w35Var12.position = i;
                        arrayList.add(w35Var12);
                    } else if (rn6.R(threadData)) {
                        rn6 rn6Var = new rn6(threadData);
                        rn6Var.g = threadData.getTid();
                        arrayList.add(rn6Var);
                    } else {
                        w35 w35Var13 = new w35();
                        w35Var13.t = threadData;
                        w35Var13.position = i;
                        arrayList.add(w35Var13);
                    }
                } else if (ymVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) ymVar).position = i;
                    arrayList.add(ymVar);
                } else {
                    arrayList.add(ymVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<ym> list, q05 q05Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, q05Var) != null) || q05Var == null || list == null || (i = q05Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    iu5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, q05Var);
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
