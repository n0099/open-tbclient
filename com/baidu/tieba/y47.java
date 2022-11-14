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
public class y47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<xn> list) {
        s46 s46Var;
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
                xn xnVar = (xn) ListUtils.getItem(list, i);
                if ((xnVar instanceof s46) && (threadData = (s46Var = (s46) xnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(xg.g(threadData.getTid(), 0L))) != null) {
                    s46Var.J(threadPersonalized.source);
                    s46Var.M(threadPersonalized.weight);
                    s46Var.F(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        s46Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        s46Var.feedBackReasonMap = sparseArray;
                        s46Var.G(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            xn xnVar = (xn) ListUtils.getItem(list, i);
            boolean z = xnVar instanceof g56;
            if (z) {
                ((g56) xnVar).d(true);
            }
            i++;
            xn xnVar2 = (xn) ListUtils.getItem(list, i);
            if (z && (xnVar2 instanceof g56)) {
                g56 g56Var = (g56) xnVar;
                g56 g56Var2 = (g56) xnVar2;
                if (g56Var.m()) {
                    g56Var2.d(false);
                    if (g56Var2 instanceof e57) {
                        g56Var.u(false);
                    }
                }
            }
            if (xnVar instanceof e57) {
                ((e57) xnVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
