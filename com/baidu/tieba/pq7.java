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
/* loaded from: classes5.dex */
public class pq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<in> a(List<ThreadData> list) {
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
                    f05 f05Var = new f05();
                    f05Var.t = threadData;
                    f05Var.position = i;
                    f05Var.r = true;
                    f05Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(f05Var);
                    f05 f05Var2 = new f05();
                    f05Var2.t = threadData;
                    f05Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        f05Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        f05Var2.d = true;
                        f05Var2.u = imageWidthAndHeight[0];
                        f05Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        f05Var2.e = true;
                    } else {
                        f05Var2.b = true;
                    }
                    f05Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(f05Var2);
                    d(threadData, arrayList, i);
                    f05 f05Var3 = new f05();
                    f05Var3.g = true;
                    f05Var3.t = threadData;
                    f05Var3.position = i;
                    f05Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(f05Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    f05 f05Var4 = new f05();
                    f05Var4.t = threadData;
                    f05Var4.position = i;
                    f05Var4.r = true;
                    f05Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(f05Var4);
                    f05 f05Var5 = new f05();
                    f05Var5.t = threadData;
                    f05Var5.position = i;
                    f05Var5.i = true;
                    f05Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(f05Var5);
                    d(threadData, arrayList, i);
                    f05 f05Var6 = new f05();
                    f05Var6.g = true;
                    f05Var6.t = threadData;
                    f05Var6.position = i;
                    f05Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(f05Var6);
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

    public static List<in> b(List<ThreadInfo> list) {
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

    public static List<in> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<in> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            f05 f05Var = new f05();
            f05Var.s = true;
            f05Var.t = threadData;
            f05Var.position = i;
            f05Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(f05Var);
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
