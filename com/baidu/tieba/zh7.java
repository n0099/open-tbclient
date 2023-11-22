package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.GeneralTabList.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public final class zh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<VideoItemData> a(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            List<ThreadInfo> list = dataRes.general_list;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (ThreadInfo threadInfo : list) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.buildWithThreadData(threadData);
                    arrayList.add(videoItemData);
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeL.objValue;
    }
}
