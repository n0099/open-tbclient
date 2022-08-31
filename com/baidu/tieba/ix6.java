package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class ix6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pn> a(List<ThreadData> list) {
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
                    jr4 jr4Var = new jr4();
                    jr4Var.t = threadData;
                    jr4Var.position = i;
                    jr4Var.r = true;
                    jr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(jr4Var);
                    jr4 jr4Var2 = new jr4();
                    jr4Var2.t = threadData;
                    jr4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        jr4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        jr4Var2.d = true;
                        jr4Var2.u = imageWidthAndHeight[0];
                        jr4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        jr4Var2.e = true;
                    } else {
                        jr4Var2.b = true;
                    }
                    jr4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(jr4Var2);
                    e(threadData, arrayList, i);
                    jr4 jr4Var3 = new jr4();
                    jr4Var3.g = true;
                    jr4Var3.t = threadData;
                    jr4Var3.position = i;
                    jr4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(jr4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    jr4 jr4Var4 = new jr4();
                    jr4Var4.t = threadData;
                    jr4Var4.position = i;
                    jr4Var4.r = true;
                    jr4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(jr4Var4);
                    jr4 jr4Var5 = new jr4();
                    jr4Var5.t = threadData;
                    jr4Var5.position = i;
                    jr4Var5.i = true;
                    jr4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(jr4Var5);
                    e(threadData, arrayList, i);
                    jr4 jr4Var6 = new jr4();
                    jr4Var6.g = true;
                    jr4Var6.t = threadData;
                    jr4Var6.position = i;
                    jr4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(jr4Var6);
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

    public static List<pn> b(List<ThreadInfo> list) {
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
                f(threadData);
                arrayList.add(threadData);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<pn> c(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
                return null;
            }
            return b(hotThreadListResIdl.data.thread_info);
        }
        return (List) invokeL.objValue;
    }

    public static wx6 d(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0882);
            int i = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !qi.isEmpty(frsTabInfo.tab_code) && !qi.isEmpty(frsTabInfo.tab_name)) {
                        i++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new wx6(frsTabInfoData);
        }
        return (wx6) invokeL.objValue;
    }

    public static void e(ThreadData threadData, ArrayList<pn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, arrayList, i) == null) || threadData == null || arrayList == null || (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) == null || TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            return;
        }
        jr4 jr4Var = new jr4();
        jr4Var.s = true;
        jr4Var.t = threadData;
        jr4Var.position = i;
        jr4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        arrayList.add(jr4Var);
    }

    public static void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + "   " + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }
}
