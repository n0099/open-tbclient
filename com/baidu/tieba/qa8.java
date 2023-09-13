package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes7.dex */
public class qa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<cn> list2) {
        up6 up6Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, list, list2) == null) && list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : list) {
                if (threadPersonalized2 != null) {
                    hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
                }
            }
            int count = ListUtils.getCount(list2);
            for (int i = 0; i < count; i++) {
                cn cnVar = (cn) ListUtils.getItem(list2, i);
                if ((cnVar instanceof up6) && (threadData = (up6Var = (up6) cnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.getTid())) != null) {
                    up6Var.C(threadPersonalized.source);
                    up6Var.F(threadPersonalized.weight);
                    up6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        up6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                    if (list3 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list3) {
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

    public static void b(List<ThreadPersonalized> list, List<cn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
