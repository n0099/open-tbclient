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
public class pd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<Cdo> a(List<ThreadData> list) {
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
                    d15 d15Var = new d15();
                    d15Var.t = threadData;
                    d15Var.position = i;
                    d15Var.r = true;
                    d15Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(d15Var);
                    d15 d15Var2 = new d15();
                    d15Var2.t = threadData;
                    d15Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        d15Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        d15Var2.d = true;
                        d15Var2.u = imageWidthAndHeight[0];
                        d15Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        d15Var2.e = true;
                    } else {
                        d15Var2.b = true;
                    }
                    d15Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(d15Var2);
                    d(threadData, arrayList, i);
                    d15 d15Var3 = new d15();
                    d15Var3.g = true;
                    d15Var3.t = threadData;
                    d15Var3.position = i;
                    d15Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(d15Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    d15 d15Var4 = new d15();
                    d15Var4.t = threadData;
                    d15Var4.position = i;
                    d15Var4.r = true;
                    d15Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(d15Var4);
                    d15 d15Var5 = new d15();
                    d15Var5.t = threadData;
                    d15Var5.position = i;
                    d15Var5.i = true;
                    d15Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(d15Var5);
                    d(threadData, arrayList, i);
                    d15 d15Var6 = new d15();
                    d15Var6.g = true;
                    d15Var6.t = threadData;
                    d15Var6.position = i;
                    d15Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(d15Var6);
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

    public static List<Cdo> b(List<ThreadInfo> list) {
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

    public static List<Cdo> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<Cdo> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            d15 d15Var = new d15();
            d15Var.s = true;
            d15Var.t = threadData;
            d15Var.position = i;
            d15Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(d15Var);
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
