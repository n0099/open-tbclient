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
public class to7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<hn> a(List<ThreadData> list) {
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
                    oz4 oz4Var = new oz4();
                    oz4Var.t = threadData;
                    oz4Var.position = i;
                    oz4Var.r = true;
                    oz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(oz4Var);
                    oz4 oz4Var2 = new oz4();
                    oz4Var2.t = threadData;
                    oz4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        oz4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        oz4Var2.d = true;
                        oz4Var2.u = imageWidthAndHeight[0];
                        oz4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        oz4Var2.e = true;
                    } else {
                        oz4Var2.b = true;
                    }
                    oz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(oz4Var2);
                    d(threadData, arrayList, i);
                    oz4 oz4Var3 = new oz4();
                    oz4Var3.g = true;
                    oz4Var3.t = threadData;
                    oz4Var3.position = i;
                    oz4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(oz4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    oz4 oz4Var4 = new oz4();
                    oz4Var4.t = threadData;
                    oz4Var4.position = i;
                    oz4Var4.r = true;
                    oz4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(oz4Var4);
                    oz4 oz4Var5 = new oz4();
                    oz4Var5.t = threadData;
                    oz4Var5.position = i;
                    oz4Var5.i = true;
                    oz4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(oz4Var5);
                    d(threadData, arrayList, i);
                    oz4 oz4Var6 = new oz4();
                    oz4Var6.g = true;
                    oz4Var6.t = threadData;
                    oz4Var6.position = i;
                    oz4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(oz4Var6);
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

    public static List<hn> b(List<ThreadInfo> list) {
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

    public static List<hn> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<hn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            oz4 oz4Var = new oz4();
            oz4Var.s = true;
            oz4Var.t = threadData;
            oz4Var.position = i;
            oz4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(oz4Var);
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
