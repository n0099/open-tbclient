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
/* loaded from: classes7.dex */
public class o68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<yn> list) {
        cq6 cq6Var;
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
                if ((ynVar instanceof cq6) && (threadData = (cq6Var = (cq6) ynVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(wg.g(threadData.getTid(), 0L))) != null) {
                    cq6Var.C(threadPersonalized.source);
                    cq6Var.H(threadPersonalized.weight);
                    cq6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        cq6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cq6Var.feedBackReasonMap = sparseArray;
                        cq6Var.z(threadPersonalized.extra);
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
            boolean z = ynVar instanceof qq6;
            if (z) {
                ((qq6) ynVar).j(true);
            }
            i++;
            yn ynVar2 = (yn) ListUtils.getItem(list, i);
            if (z && (ynVar2 instanceof qq6)) {
                qq6 qq6Var = (qq6) ynVar;
                qq6 qq6Var2 = (qq6) ynVar2;
                if (qq6Var.w()) {
                    qq6Var2.j(false);
                    if (qq6Var2 instanceof v68) {
                        qq6Var.O(false);
                    }
                }
            }
            if (ynVar instanceof v68) {
                ((v68) ynVar).O(false);
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
