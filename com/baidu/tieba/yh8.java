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
/* loaded from: classes9.dex */
public class yh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<pi> list) {
        um6 um6Var;
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
                pi piVar = (pi) ListUtils.getItem(list, i);
                if ((piVar instanceof um6) && (threadData = (um6Var = (um6) piVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    um6Var.C(threadPersonalized.source);
                    um6Var.F(threadPersonalized.weight);
                    um6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        um6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        um6Var.feedBackReasonMap = sparseArray;
                        um6Var.z(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            pi piVar = (pi) ListUtils.getItem(list, i);
            boolean z = piVar instanceof kn6;
            if (z) {
                ((kn6) piVar).i(true);
            }
            i++;
            pi piVar2 = (pi) ListUtils.getItem(list, i);
            if (z && (piVar2 instanceof kn6)) {
                kn6 kn6Var = (kn6) piVar;
                kn6 kn6Var2 = (kn6) piVar2;
                if (kn6Var.r()) {
                    kn6Var2.i(false);
                    if (kn6Var2 instanceof fi8) {
                        kn6Var.K(false);
                    }
                }
            }
            if (piVar instanceof fi8) {
                ((fi8) piVar).K(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
