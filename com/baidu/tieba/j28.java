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
/* loaded from: classes6.dex */
public class j28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<bn> a(List<ThreadData> list) {
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
                    c45 c45Var = new c45();
                    c45Var.t = threadData;
                    c45Var.position = i;
                    c45Var.r = true;
                    c45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(c45Var);
                    c45 c45Var2 = new c45();
                    c45Var2.t = threadData;
                    c45Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        c45Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        c45Var2.d = true;
                        c45Var2.u = imageWidthAndHeight[0];
                        c45Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        c45Var2.e = true;
                    } else {
                        c45Var2.b = true;
                    }
                    c45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(c45Var2);
                    d(threadData, arrayList, i);
                    c45 c45Var3 = new c45();
                    c45Var3.g = true;
                    c45Var3.t = threadData;
                    c45Var3.position = i;
                    c45Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(c45Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    c45 c45Var4 = new c45();
                    c45Var4.t = threadData;
                    c45Var4.position = i;
                    c45Var4.r = true;
                    c45Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(c45Var4);
                    c45 c45Var5 = new c45();
                    c45Var5.t = threadData;
                    c45Var5.position = i;
                    c45Var5.i = true;
                    c45Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(c45Var5);
                    d(threadData, arrayList, i);
                    c45 c45Var6 = new c45();
                    c45Var6.g = true;
                    c45Var6.t = threadData;
                    c45Var6.position = i;
                    c45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(c45Var6);
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

    public static List<bn> b(List<ThreadInfo> list) {
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

    public static List<bn> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<bn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            c45 c45Var = new c45();
            c45Var.s = true;
            c45Var.t = threadData;
            c45Var.position = i;
            c45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(c45Var);
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
