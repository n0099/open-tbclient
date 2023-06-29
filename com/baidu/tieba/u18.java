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
/* loaded from: classes8.dex */
public class u18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<xn> list) {
        yo6 yo6Var;
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
                if ((xnVar instanceof yo6) && (threadData = (yo6Var = (yo6) xnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(vg.g(threadData.getTid(), 0L))) != null) {
                    yo6Var.D(threadPersonalized.source);
                    yo6Var.I(threadPersonalized.weight);
                    yo6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        yo6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        yo6Var.feedBackReasonMap = sparseArray;
                        yo6Var.z(threadPersonalized.extra);
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
            boolean z = xnVar instanceof mp6;
            if (z) {
                ((mp6) xnVar).g(true);
            }
            i++;
            xn xnVar2 = (xn) ListUtils.getItem(list, i);
            if (z && (xnVar2 instanceof mp6)) {
                mp6 mp6Var = (mp6) xnVar;
                mp6 mp6Var2 = (mp6) xnVar2;
                if (mp6Var.v()) {
                    mp6Var2.g(false);
                    if (mp6Var2 instanceof b28) {
                        mp6Var.N(false);
                    }
                }
            }
            if (xnVar instanceof b28) {
                ((b28) xnVar).N(false);
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
