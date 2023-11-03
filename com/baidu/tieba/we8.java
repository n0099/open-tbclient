package com.baidu.tieba;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes8.dex */
public class we8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<oi> list) {
        fm6 fm6Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) && builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = ListUtils.getCount(list);
            for (int i = 0; i < count; i++) {
                oi oiVar = (oi) ListUtils.getItem(list, i);
                if ((oiVar instanceof fm6) && (threadData = (fm6Var = (fm6) oiVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    fm6Var.C(threadPersonalized.source);
                    fm6Var.F(threadPersonalized.weight);
                    fm6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        fm6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        fm6Var.feedBackReasonMap = sparseArray;
                        fm6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            oi oiVar = (oi) ListUtils.getItem(list, i);
            boolean z = oiVar instanceof um6;
            if (z) {
                ((um6) oiVar).j(true);
            }
            i++;
            oi oiVar2 = (oi) ListUtils.getItem(list, i);
            if (z && (oiVar2 instanceof um6)) {
                um6 um6Var = (um6) oiVar;
                um6 um6Var2 = (um6) oiVar2;
                if (um6Var.r()) {
                    um6Var2.j(false);
                    if (um6Var2 instanceof df8) {
                        um6Var.K(false);
                    }
                }
            }
            if (oiVar instanceof df8) {
                ((df8) oiVar).K(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
