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
public class o78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<cn> list) {
        up6 up6Var;
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
                cn cnVar = (cn) ListUtils.getItem(list, i);
                if ((cnVar instanceof up6) && (threadData = (up6Var = (up6) cnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    up6Var.C(threadPersonalized.source);
                    up6Var.F(threadPersonalized.weight);
                    up6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        up6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        up6Var.feedBackReasonMap = sparseArray;
                        up6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            cn cnVar = (cn) ListUtils.getItem(list, i);
            boolean z = cnVar instanceof jq6;
            if (z) {
                ((jq6) cnVar).j(true);
            }
            i++;
            cn cnVar2 = (cn) ListUtils.getItem(list, i);
            if (z && (cnVar2 instanceof jq6)) {
                jq6 jq6Var = (jq6) cnVar;
                jq6 jq6Var2 = (jq6) cnVar2;
                if (jq6Var.r()) {
                    jq6Var2.j(false);
                    if (jq6Var2 instanceof v78) {
                        jq6Var.I(false);
                    }
                }
            }
            if (cnVar instanceof v78) {
                ((v78) cnVar).I(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
