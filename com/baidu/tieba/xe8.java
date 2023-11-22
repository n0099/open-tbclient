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
public class xe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<oi> list) {
        gm6 gm6Var;
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
                if ((oiVar instanceof gm6) && (threadData = (gm6Var = (gm6) oiVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    gm6Var.C(threadPersonalized.source);
                    gm6Var.F(threadPersonalized.weight);
                    gm6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        gm6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        gm6Var.feedBackReasonMap = sparseArray;
                        gm6Var.y(threadPersonalized.extra);
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
            boolean z = oiVar instanceof vm6;
            if (z) {
                ((vm6) oiVar).j(true);
            }
            i++;
            oi oiVar2 = (oi) ListUtils.getItem(list, i);
            if (z && (oiVar2 instanceof vm6)) {
                vm6 vm6Var = (vm6) oiVar;
                vm6 vm6Var2 = (vm6) oiVar2;
                if (vm6Var.r()) {
                    vm6Var2.j(false);
                    if (vm6Var2 instanceof ef8) {
                        vm6Var.K(false);
                    }
                }
            }
            if (oiVar instanceof ef8) {
                ((ef8) oiVar).K(false);
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
