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
public class ov7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<rn> list) {
        ck6 ck6Var;
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
                rn rnVar = (rn) ListUtils.getItem(list, i);
                if ((rnVar instanceof ck6) && (threadData = (ck6Var = (ck6) rnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(pg.g(threadData.getTid(), 0L))) != null) {
                    ck6Var.D(threadPersonalized.source);
                    ck6Var.I(threadPersonalized.weight);
                    ck6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        ck6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        ck6Var.feedBackReasonMap = sparseArray;
                        ck6Var.z(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<rn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            rn rnVar = (rn) ListUtils.getItem(list, i);
            boolean z = rnVar instanceof qk6;
            if (z) {
                ((qk6) rnVar).g(true);
            }
            i++;
            rn rnVar2 = (rn) ListUtils.getItem(list, i);
            if (z && (rnVar2 instanceof qk6)) {
                qk6 qk6Var = (qk6) rnVar;
                qk6 qk6Var2 = (qk6) rnVar2;
                if (qk6Var.v()) {
                    qk6Var2.g(false);
                    if (qk6Var2 instanceof uv7) {
                        qk6Var.N(false);
                    }
                }
            }
            if (rnVar instanceof uv7) {
                ((uv7) rnVar).N(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
