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
/* loaded from: classes7.dex */
public class q78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<bn> list) {
        aq6 aq6Var;
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
                bn bnVar = (bn) ListUtils.getItem(list, i);
                if ((bnVar instanceof aq6) && (threadData = (aq6Var = (aq6) bnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    aq6Var.C(threadPersonalized.source);
                    aq6Var.F(threadPersonalized.weight);
                    aq6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        aq6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        aq6Var.feedBackReasonMap = sparseArray;
                        aq6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            bn bnVar = (bn) ListUtils.getItem(list, i);
            boolean z = bnVar instanceof pq6;
            if (z) {
                ((pq6) bnVar).j(true);
            }
            i++;
            bn bnVar2 = (bn) ListUtils.getItem(list, i);
            if (z && (bnVar2 instanceof pq6)) {
                pq6 pq6Var = (pq6) bnVar;
                pq6 pq6Var2 = (pq6) bnVar2;
                if (pq6Var.r()) {
                    pq6Var2.j(false);
                    if (pq6Var2 instanceof x78) {
                        pq6Var.I(false);
                    }
                }
            }
            if (bnVar instanceof x78) {
                ((x78) bnVar).I(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
