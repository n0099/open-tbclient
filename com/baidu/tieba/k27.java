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
public class k27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xn> a(List<ThreadData> list) {
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
                    yu4 yu4Var = new yu4();
                    yu4Var.t = threadData;
                    yu4Var.position = i;
                    yu4Var.r = true;
                    yu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(yu4Var);
                    yu4 yu4Var2 = new yu4();
                    yu4Var2.t = threadData;
                    yu4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        yu4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        yu4Var2.d = true;
                        yu4Var2.u = imageWidthAndHeight[0];
                        yu4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        yu4Var2.e = true;
                    } else {
                        yu4Var2.b = true;
                    }
                    yu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(yu4Var2);
                    d(threadData, arrayList, i);
                    yu4 yu4Var3 = new yu4();
                    yu4Var3.g = true;
                    yu4Var3.t = threadData;
                    yu4Var3.position = i;
                    yu4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(yu4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    yu4 yu4Var4 = new yu4();
                    yu4Var4.t = threadData;
                    yu4Var4.position = i;
                    yu4Var4.r = true;
                    yu4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(yu4Var4);
                    yu4 yu4Var5 = new yu4();
                    yu4Var5.t = threadData;
                    yu4Var5.position = i;
                    yu4Var5.i = true;
                    yu4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(yu4Var5);
                    d(threadData, arrayList, i);
                    yu4 yu4Var6 = new yu4();
                    yu4Var6.g = true;
                    yu4Var6.t = threadData;
                    yu4Var6.position = i;
                    yu4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(yu4Var6);
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

    public static List<xn> b(List<ThreadInfo> list) {
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

    public static List<xn> c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static void d(ThreadData threadData, ArrayList<xn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            yu4 yu4Var = new yu4();
            yu4Var.s = true;
            yu4Var.t = threadData;
            yu4Var.position = i;
            yu4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(yu4Var);
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
