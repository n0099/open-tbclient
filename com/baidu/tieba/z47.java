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
public class z47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<xn> list) {
        t46 t46Var;
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
                if ((xnVar instanceof t46) && (threadData = (t46Var = (t46) xnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(xg.g(threadData.getTid(), 0L))) != null) {
                    t46Var.J(threadPersonalized.source);
                    t46Var.M(threadPersonalized.weight);
                    t46Var.F(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        t46Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        t46Var.feedBackReasonMap = sparseArray;
                        t46Var.G(threadPersonalized.extra);
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
            boolean z = xnVar instanceof h56;
            if (z) {
                ((h56) xnVar).d(true);
            }
            i++;
            xn xnVar2 = (xn) ListUtils.getItem(list, i);
            if (z && (xnVar2 instanceof h56)) {
                h56 h56Var = (h56) xnVar;
                h56 h56Var2 = (h56) xnVar2;
                if (h56Var.m()) {
                    h56Var2.d(false);
                    if (h56Var2 instanceof f57) {
                        h56Var.u(false);
                    }
                }
            }
            if (xnVar instanceof f57) {
                ((f57) xnVar).u(false);
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
