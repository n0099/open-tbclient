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
public class x57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<xn> list) {
        o56 o56Var;
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
                if ((xnVar instanceof o56) && (threadData = (o56Var = (o56) xnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(xg.g(threadData.getTid(), 0L))) != null) {
                    o56Var.J(threadPersonalized.source);
                    o56Var.M(threadPersonalized.weight);
                    o56Var.D(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        o56Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        o56Var.feedBackReasonMap = sparseArray;
                        o56Var.G(threadPersonalized.extra);
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
            boolean z = xnVar instanceof c66;
            if (z) {
                ((c66) xnVar).d(true);
            }
            i++;
            xn xnVar2 = (xn) ListUtils.getItem(list, i);
            if (z && (xnVar2 instanceof c66)) {
                c66 c66Var = (c66) xnVar;
                c66 c66Var2 = (c66) xnVar2;
                if (c66Var.n()) {
                    c66Var2.d(false);
                    if (c66Var2 instanceof d67) {
                        c66Var.A(false);
                    }
                }
            }
            if (xnVar instanceof d67) {
                ((d67) xnVar).A(false);
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
