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
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class pz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                ThreadData threadData = (ThreadData) it.next();
                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                    threadData.position = i;
                    du4 du4Var = new du4();
                    du4Var.t = threadData;
                    du4Var.position = i;
                    du4Var.r = true;
                    du4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(du4Var);
                    du4 du4Var2 = new du4();
                    du4Var2.t = threadData;
                    du4Var2.position = i;
                    if (threadData.isBJHNormalThreadType()) {
                        du4Var2.f = true;
                    } else if (threadData.picCount() == 1) {
                        du4Var2.d = true;
                        du4Var2.u = imageWidthAndHeight[0];
                        du4Var2.v = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        du4Var2.e = true;
                    } else {
                        du4Var2.b = true;
                    }
                    du4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(du4Var2);
                    e(threadData, arrayList, i);
                    du4 du4Var3 = new du4();
                    du4Var3.g = true;
                    du4Var3.t = threadData;
                    du4Var3.position = i;
                    du4Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(du4Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    du4 du4Var4 = new du4();
                    du4Var4.t = threadData;
                    du4Var4.position = i;
                    du4Var4.r = true;
                    du4Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(du4Var4);
                    du4 du4Var5 = new du4();
                    du4Var5.t = threadData;
                    du4Var5.position = i;
                    du4Var5.i = true;
                    du4Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(du4Var5);
                    e(threadData, arrayList, i);
                    du4 du4Var6 = new du4();
                    du4Var6.g = true;
                    du4Var6.t = threadData;
                    du4Var6.position = i;
                    du4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(du4Var6);
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

    public static List b(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThreadData threadData = new ThreadData();
                threadData.isFromHotRankTab = true;
                threadData.parserProtobuf((ThreadInfo) it.next());
                f(threadData);
                arrayList.add(threadData);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List c(HotThreadListResIdl hotThreadListResIdl) {
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

    public static d07 d(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08a1);
            int i = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) it.next();
                    if (frsTabInfo != null && !ej.isEmpty(frsTabInfo.tab_code) && !ej.isEmpty(frsTabInfo.tab_name)) {
                        i++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new d07(frsTabInfoData);
        }
        return (d07) invokeL.objValue;
    }

    public static void e(ThreadData threadData, ArrayList arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            du4 du4Var = new du4();
            du4Var.s = true;
            du4Var.t = threadData;
            du4Var.position = i;
            du4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(du4Var);
        }
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
