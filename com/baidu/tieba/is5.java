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
public class is5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pi> a(List<? extends pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (pi piVar : list) {
                if (piVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) piVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        mz4 mz4Var = new mz4();
                        mz4Var.t = threadData;
                        mz4Var.position = i;
                        mz4Var.a = true;
                        mz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(mz4Var);
                        mz4 mz4Var2 = new mz4();
                        mz4Var2.t = threadData;
                        mz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            mz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            mz4Var2.d = true;
                            mz4Var2.u = imageWidthAndHeight[0];
                            mz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            mz4Var2.e = true;
                        } else {
                            mz4Var2.b = true;
                        }
                        mz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(mz4Var2);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var3 = new mz4();
                            mz4Var3.n = true;
                            mz4Var3.t = threadData;
                            mz4Var3.position = i;
                            mz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(mz4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            mz4 mz4Var4 = new mz4();
                            mz4Var4.t = threadData;
                            mz4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                mz4Var4.p = true;
                            } else {
                                mz4Var4.q = true;
                            }
                            mz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(mz4Var4);
                        }
                        mz4 mz4Var5 = new mz4();
                        mz4Var5.m = true;
                        mz4Var5.t = threadData;
                        mz4Var5.position = i;
                        mz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(mz4Var5);
                        mz4 mz4Var6 = new mz4();
                        mz4Var6.g = true;
                        mz4Var6.t = threadData;
                        mz4Var6.position = i;
                        mz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(mz4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        mz4 mz4Var7 = new mz4();
                        mz4Var7.t = threadData;
                        mz4Var7.position = i;
                        mz4Var7.a = true;
                        mz4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(mz4Var7);
                        mz4 mz4Var8 = new mz4();
                        mz4Var8.t = threadData;
                        mz4Var8.position = i;
                        mz4Var8.i = true;
                        mz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(mz4Var8);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var9 = new mz4();
                            mz4Var9.n = true;
                            mz4Var9.t = threadData;
                            mz4Var9.position = i;
                            mz4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(mz4Var9);
                        }
                        mz4 mz4Var10 = new mz4();
                        mz4Var10.m = true;
                        mz4Var10.t = threadData;
                        mz4Var10.position = i;
                        mz4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(mz4Var10);
                        mz4 mz4Var11 = new mz4();
                        mz4Var11.g = true;
                        mz4Var11.t = threadData;
                        mz4Var11.position = i;
                        mz4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(mz4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        mz4 mz4Var12 = new mz4();
                        mz4Var12.t = threadData;
                        mz4Var12.position = i;
                        arrayList.add(mz4Var12);
                    } else if (cn6.R(threadData)) {
                        cn6 cn6Var = new cn6(threadData);
                        cn6Var.g = threadData.getTid();
                        arrayList.add(cn6Var);
                    } else {
                        mz4 mz4Var13 = new mz4();
                        mz4Var13.t = threadData;
                        mz4Var13.position = i;
                        arrayList.add(mz4Var13);
                    }
                } else if (piVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) piVar).position = i;
                    arrayList.add(piVar);
                } else {
                    arrayList.add(piVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<pi> list, fw4 fw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, list, fw4Var) != null) || fw4Var == null || list == null || (i = fw4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    hs5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, fw4Var);
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
