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
public class o08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ym> a(List<ThreadData> list) {
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
                    w35 w35Var = new w35();
                    w35Var.t = threadData;
                    w35Var.position = i;
                    w35Var.r = true;
                    w35Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(w35Var);
                    w35 w35Var2 = new w35();
                    w35Var2.t = threadData;
                    w35Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        w35Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        w35Var2.d = true;
                        w35Var2.u = imageWidthAndHeight[0];
                        w35Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        w35Var2.e = true;
                    } else {
                        w35Var2.b = true;
                    }
                    w35Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(w35Var2);
                    d(threadData, arrayList, i);
                    w35 w35Var3 = new w35();
                    w35Var3.g = true;
                    w35Var3.t = threadData;
                    w35Var3.position = i;
                    w35Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(w35Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    w35 w35Var4 = new w35();
                    w35Var4.t = threadData;
                    w35Var4.position = i;
                    w35Var4.r = true;
                    w35Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(w35Var4);
                    w35 w35Var5 = new w35();
                    w35Var5.t = threadData;
                    w35Var5.position = i;
                    w35Var5.i = true;
                    w35Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(w35Var5);
                    d(threadData, arrayList, i);
                    w35 w35Var6 = new w35();
                    w35Var6.g = true;
                    w35Var6.t = threadData;
                    w35Var6.position = i;
                    w35Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(w35Var6);
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

    public static List<ym> b(List<ThreadInfo> list) {
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

    public static List<ym> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<ym> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            w35 w35Var = new w35();
            w35Var.s = true;
            w35Var.t = threadData;
            w35Var.position = i;
            w35Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(w35Var);
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
