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
/* loaded from: classes5.dex */
public class n47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<wn> list) {
        g46 g46Var;
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
                wn wnVar = (wn) ListUtils.getItem(list, i);
                if ((wnVar instanceof g46) && (threadData = (g46Var = (g46) wnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(wg.g(threadData.getTid(), 0L))) != null) {
                    g46Var.J(threadPersonalized.source);
                    g46Var.M(threadPersonalized.weight);
                    g46Var.F(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        g46Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        g46Var.feedBackReasonMap = sparseArray;
                        g46Var.G(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            wn wnVar = (wn) ListUtils.getItem(list, i);
            boolean z = wnVar instanceof u46;
            if (z) {
                ((u46) wnVar).d(true);
            }
            i++;
            wn wnVar2 = (wn) ListUtils.getItem(list, i);
            if (z && (wnVar2 instanceof u46)) {
                u46 u46Var = (u46) wnVar;
                u46 u46Var2 = (u46) wnVar2;
                if (u46Var.m()) {
                    u46Var2.d(false);
                    if (u46Var2 instanceof t47) {
                        u46Var.u(false);
                    }
                }
            }
            if (wnVar instanceof t47) {
                ((t47) wnVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
