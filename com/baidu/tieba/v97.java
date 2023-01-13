package com.baidu.tieba;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes6.dex */
public class v97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<yn> list) {
        g96 g96Var;
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
                yn ynVar = (yn) ListUtils.getItem(list, i);
                if ((ynVar instanceof g96) && (threadData = (g96Var = (g96) ynVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(yg.g(threadData.getTid(), 0L))) != null) {
                    g96Var.J(threadPersonalized.source);
                    g96Var.M(threadPersonalized.weight);
                    g96Var.D(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        g96Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        g96Var.feedBackReasonMap = sparseArray;
                        g96Var.G(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            yn ynVar = (yn) ListUtils.getItem(list, i);
            boolean z = ynVar instanceof u96;
            if (z) {
                ((u96) ynVar).d(true);
            }
            i++;
            yn ynVar2 = (yn) ListUtils.getItem(list, i);
            if (z && (ynVar2 instanceof u96)) {
                u96 u96Var = (u96) ynVar;
                u96 u96Var2 = (u96) ynVar2;
                if (u96Var.n()) {
                    u96Var2.d(false);
                    if (u96Var2 instanceof ba7) {
                        u96Var.A(false);
                    }
                }
            }
            if (ynVar instanceof ba7) {
                ((ba7) ynVar).A(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
