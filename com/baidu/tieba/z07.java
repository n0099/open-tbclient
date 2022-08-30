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
public class z07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<pn> list) {
        n06 n06Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) || builder == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i = 0; i < count; i++) {
            pn pnVar = (pn) ListUtils.getItem(list, i);
            if ((pnVar instanceof n06) && (threadData = (n06Var = (n06) pnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(pg.g(threadData.getTid(), 0L))) != null) {
                n06Var.J(threadPersonalized.source);
                n06Var.M(threadPersonalized.weight);
                n06Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    n06Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    n06Var.feedBackReasonMap = sparseArray;
                    n06Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<pn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            pn pnVar = (pn) ListUtils.getItem(list, i);
            boolean z = pnVar instanceof c16;
            if (z) {
                ((c16) pnVar).d(true);
            }
            i++;
            pn pnVar2 = (pn) ListUtils.getItem(list, i);
            if (z && (pnVar2 instanceof c16)) {
                c16 c16Var = (c16) pnVar;
                c16 c16Var2 = (c16) pnVar2;
                if (c16Var.m()) {
                    c16Var2.d(false);
                    if (c16Var2 instanceof g17) {
                        c16Var.u(false);
                    }
                }
            }
            if (pnVar instanceof g17) {
                ((g17) pnVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
