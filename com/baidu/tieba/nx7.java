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
public class nx7 {
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
                    l45 l45Var = new l45();
                    l45Var.t = threadData;
                    l45Var.position = i;
                    l45Var.r = true;
                    l45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(l45Var);
                    l45 l45Var2 = new l45();
                    l45Var2.t = threadData;
                    l45Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        l45Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        l45Var2.d = true;
                        l45Var2.u = imageWidthAndHeight[0];
                        l45Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        l45Var2.e = true;
                    } else {
                        l45Var2.b = true;
                    }
                    l45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(l45Var2);
                    d(threadData, arrayList, i);
                    l45 l45Var3 = new l45();
                    l45Var3.g = true;
                    l45Var3.t = threadData;
                    l45Var3.position = i;
                    l45Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(l45Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    l45 l45Var4 = new l45();
                    l45Var4.t = threadData;
                    l45Var4.position = i;
                    l45Var4.r = true;
                    l45Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(l45Var4);
                    l45 l45Var5 = new l45();
                    l45Var5.t = threadData;
                    l45Var5.position = i;
                    l45Var5.i = true;
                    l45Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(l45Var5);
                    d(threadData, arrayList, i);
                    l45 l45Var6 = new l45();
                    l45Var6.g = true;
                    l45Var6.t = threadData;
                    l45Var6.position = i;
                    l45Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(l45Var6);
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
            l45 l45Var = new l45();
            l45Var.s = true;
            l45Var.t = threadData;
            l45Var.position = i;
            l45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(l45Var);
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
