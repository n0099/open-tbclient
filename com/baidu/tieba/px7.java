package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class px7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<vn> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ThreadData threadData : list) {
                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                    threadData.position = i;
                    n45 n45Var = new n45();
                    n45Var.t = threadData;
                    n45Var.position = i;
                    n45Var.r = true;
                    n45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(n45Var);
                    n45 n45Var2 = new n45();
                    n45Var2.t = threadData;
                    n45Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        n45Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        n45Var2.d = true;
                        n45Var2.u = imageWidthAndHeight[0];
                        n45Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        n45Var2.e = true;
                    } else {
                        n45Var2.b = true;
                    }
                    n45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(n45Var2);
                    d(threadData, arrayList, i);
                    n45 n45Var3 = new n45();
                    n45Var3.g = true;
                    n45Var3.t = threadData;
                    n45Var3.position = i;
                    n45Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(n45Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    n45 n45Var4 = new n45();
                    n45Var4.t = threadData;
                    n45Var4.position = i;
                    n45Var4.r = true;
                    n45Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(n45Var4);
                    n45 n45Var5 = new n45();
                    n45Var5.t = threadData;
                    n45Var5.position = i;
                    n45Var5.i = true;
                    n45Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(n45Var5);
                    d(threadData, arrayList, i);
                    n45 n45Var6 = new n45();
                    n45Var6.g = true;
                    n45Var6.t = threadData;
                    n45Var6.position = i;
                    n45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(n45Var6);
                } else {
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i++;
                threadData.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<vn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.isFromHotRankTab = true;
                threadData.parserProtobuf(threadInfo);
                e(threadData);
                arrayList.add(threadData);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<vn> c(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl != null && (dataRes = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes.thread_info)) {
                return b(hotThreadListResIdl.data.thread_info);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static void d(ThreadData threadData, ArrayList<vn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            n45 n45Var = new n45();
            n45Var.s = true;
            n45Var.t = threadData;
            n45Var.position = i;
            n45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(n45Var);
        }
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + "   " + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }
}
