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
public class p18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<wn> list) {
        to6 to6Var;
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
                if ((wnVar instanceof to6) && (threadData = (to6Var = (to6) wnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(ug.g(threadData.getTid(), 0L))) != null) {
                    to6Var.D(threadPersonalized.source);
                    to6Var.I(threadPersonalized.weight);
                    to6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        to6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        to6Var.feedBackReasonMap = sparseArray;
                        to6Var.z(threadPersonalized.extra);
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
            boolean z = wnVar instanceof hp6;
            if (z) {
                ((hp6) wnVar).g(true);
            }
            i++;
            wn wnVar2 = (wn) ListUtils.getItem(list, i);
            if (z && (wnVar2 instanceof hp6)) {
                hp6 hp6Var = (hp6) wnVar;
                hp6 hp6Var2 = (hp6) wnVar2;
                if (hp6Var.v()) {
                    hp6Var2.g(false);
                    if (hp6Var2 instanceof w18) {
                        hp6Var.N(false);
                    }
                }
            }
            if (wnVar instanceof w18) {
                ((w18) wnVar).N(false);
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
