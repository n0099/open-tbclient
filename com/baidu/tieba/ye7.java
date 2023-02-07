package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ye7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, threadData, i, arrayList) == null) {
            if (threadData.getTabShowMode() == 1) {
                b(threadData, i, arrayList, true);
            } else if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                b(threadData, i, arrayList, false);
            } else {
                b(threadData, i, arrayList, true);
            }
        }
    }

    public static void b(ThreadData threadData, int i, ArrayList<Cdo> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            wz4 wz4Var = new wz4();
            wz4Var.t = threadData;
            wz4Var.position = i;
            if (z) {
                wz4Var.a = true;
            } else {
                wz4Var.r = true;
            }
            wz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(wz4Var);
        }
    }

    public static ArrayList<Cdo> c(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        wz4 wz4Var = new wz4();
                        wz4Var.t = threadData;
                        wz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            wz4Var.d = true;
                            wz4Var.u = imageWidthAndHeight[0];
                            wz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wz4Var.e = true;
                        } else {
                            wz4Var.b = true;
                        }
                        wz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        wz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wz4Var);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var2 = new wz4();
                            wz4Var2.n = true;
                            wz4Var2.t = threadData;
                            wz4Var2.position = i;
                            wz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            wz4 wz4Var3 = new wz4();
                            wz4Var3.t = threadData;
                            wz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                wz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                wz4Var3.q = true;
                            }
                            wz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(wz4Var3);
                        }
                        wz4 wz4Var4 = new wz4();
                        wz4Var4.m = true;
                        wz4Var4.t = threadData;
                        wz4Var4.position = i;
                        wz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(wz4Var4);
                        wz4 wz4Var5 = new wz4();
                        wz4Var5.g = true;
                        wz4Var5.t = threadData;
                        wz4Var5.position = i;
                        wz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        wz4 wz4Var6 = new wz4();
                        wz4Var6.t = threadData;
                        wz4Var6.position = i;
                        wz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        wz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(wz4Var6);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var7 = new wz4();
                            wz4Var7.n = true;
                            wz4Var7.t = threadData;
                            wz4Var7.position = i;
                            wz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(wz4Var7);
                        }
                        wz4 wz4Var8 = new wz4();
                        wz4Var8.m = true;
                        wz4Var8.t = threadData;
                        wz4Var8.position = i;
                        wz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(wz4Var8);
                        wz4 wz4Var9 = new wz4();
                        wz4Var9.g = true;
                        wz4Var9.t = threadData;
                        wz4Var9.position = i;
                        wz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(wz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (zd6.W(threadData)) {
                        zd6 zd6Var = new zd6(threadData);
                        zd6Var.g = threadData.getTid();
                        zd6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        zd6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(zd6Var);
                    } else {
                        wz4 wz4Var10 = new wz4();
                        wz4Var10.t = threadData;
                        wz4Var10.position = i;
                        wz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(wz4Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                Cdo E = bdTypeRecyclerView.E(i3);
                ThreadData threadData = null;
                if (E instanceof wz4) {
                    threadData = ((wz4) E).getThreadData();
                } else if (E instanceof ThreadData) {
                    threadData = (ThreadData) E;
                } else if (E instanceof zd6) {
                    threadData = ((zd6) E).a;
                }
                if (threadData != null && threadData.getTid().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void e(boolean z, ArrayList<Cdo> arrayList, sw4 sw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, sw4Var}) == null) && sw4Var != null && arrayList != null && (i = sw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, sw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
