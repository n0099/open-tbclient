package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.MoreTreasureTrove.DataRes;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class ot7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<rn> a(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.isFromLowFlowsPage = true;
                arrayList.add(threadData);
            }
            return cs7.a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<rn> b(MoreTreasureTroveResIdl moreTreasureTroveResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, moreTreasureTroveResIdl)) == null) {
            if (moreTreasureTroveResIdl != null && (dataRes = moreTreasureTroveResIdl.data) != null && !ListUtils.isEmpty(dataRes.hot_thread_info)) {
                return a(moreTreasureTroveResIdl.data.hot_thread_info);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
