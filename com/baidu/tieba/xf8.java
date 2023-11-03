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
/* loaded from: classes9.dex */
public class xf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<oi> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<oi> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            hz4 hz4Var = new hz4();
            hz4Var.t = threadData;
            hz4Var.position = i;
            if (z) {
                hz4Var.a = true;
            } else {
                hz4Var.r = true;
            }
            hz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(hz4Var);
        }
    }

    public static ArrayList<oi> c(ArrayList<oi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<oi> arrayList2 = new ArrayList<>();
            Iterator<oi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                oi next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        hz4 hz4Var = new hz4();
                        hz4Var.t = threadData;
                        hz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            hz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            hz4Var.d = true;
                            hz4Var.u = imageWidthAndHeight[0];
                            hz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            hz4Var.e = true;
                        } else {
                            hz4Var.b = true;
                        }
                        hz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        hz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(hz4Var);
                        if (threadData.getItem() != null) {
                            hz4 hz4Var2 = new hz4();
                            hz4Var2.n = true;
                            hz4Var2.t = threadData;
                            hz4Var2.position = i;
                            hz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(hz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            hz4 hz4Var3 = new hz4();
                            hz4Var3.t = threadData;
                            hz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                hz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                hz4Var3.q = true;
                            }
                            hz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(hz4Var3);
                        }
                        hz4 hz4Var4 = new hz4();
                        hz4Var4.m = true;
                        hz4Var4.t = threadData;
                        hz4Var4.position = i;
                        hz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(hz4Var4);
                        hz4 hz4Var5 = new hz4();
                        hz4Var5.g = true;
                        hz4Var5.t = threadData;
                        hz4Var5.position = i;
                        hz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(hz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        hz4 hz4Var6 = new hz4();
                        hz4Var6.t = threadData;
                        hz4Var6.position = i;
                        hz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        hz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(hz4Var6);
                        if (threadData.getItem() != null) {
                            hz4 hz4Var7 = new hz4();
                            hz4Var7.n = true;
                            hz4Var7.t = threadData;
                            hz4Var7.position = i;
                            hz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(hz4Var7);
                        }
                        hz4 hz4Var8 = new hz4();
                        hz4Var8.m = true;
                        hz4Var8.t = threadData;
                        hz4Var8.position = i;
                        hz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(hz4Var8);
                        hz4 hz4Var9 = new hz4();
                        hz4Var9.g = true;
                        hz4Var9.t = threadData;
                        hz4Var9.position = i;
                        hz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(hz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (mm6.R(threadData)) {
                        mm6 mm6Var = new mm6(threadData);
                        mm6Var.g = threadData.getTid();
                        mm6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        mm6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(mm6Var);
                    } else {
                        hz4 hz4Var10 = new hz4();
                        hz4Var10.t = threadData;
                        hz4Var10.position = i;
                        hz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(hz4Var10);
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
                oi item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof hz4) {
                    threadData = ((hz4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof mm6) {
                    threadData = ((mm6) item).a;
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

    public static void e(boolean z, ArrayList<oi> arrayList, bw4 bw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, bw4Var}) == null) && bw4Var != null && arrayList != null && (i = bw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, bw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
