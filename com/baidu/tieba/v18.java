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
/* loaded from: classes8.dex */
public class v18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<vn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<vn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            l45 l45Var = new l45();
            l45Var.t = threadData;
            l45Var.position = i;
            if (z) {
                l45Var.a = true;
            } else {
                l45Var.r = true;
            }
            l45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(l45Var);
        }
    }

    public static ArrayList<vn> c(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<vn> arrayList2 = new ArrayList<>();
            Iterator<vn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        l45 l45Var = new l45();
                        l45Var.t = threadData;
                        l45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            l45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            l45Var.d = true;
                            l45Var.u = imageWidthAndHeight[0];
                            l45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            l45Var.e = true;
                        } else {
                            l45Var.b = true;
                        }
                        l45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        l45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(l45Var);
                        if (threadData.getItem() != null) {
                            l45 l45Var2 = new l45();
                            l45Var2.n = true;
                            l45Var2.t = threadData;
                            l45Var2.position = i;
                            l45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            l45 l45Var3 = new l45();
                            l45Var3.t = threadData;
                            l45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                l45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                l45Var3.q = true;
                            }
                            l45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var3);
                        }
                        l45 l45Var4 = new l45();
                        l45Var4.m = true;
                        l45Var4.t = threadData;
                        l45Var4.position = i;
                        l45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(l45Var4);
                        l45 l45Var5 = new l45();
                        l45Var5.g = true;
                        l45Var5.t = threadData;
                        l45Var5.position = i;
                        l45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(l45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        l45 l45Var6 = new l45();
                        l45Var6.t = threadData;
                        l45Var6.position = i;
                        l45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        l45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(l45Var6);
                        if (threadData.getItem() != null) {
                            l45 l45Var7 = new l45();
                            l45Var7.n = true;
                            l45Var7.t = threadData;
                            l45Var7.position = i;
                            l45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(l45Var7);
                        }
                        l45 l45Var8 = new l45();
                        l45Var8.m = true;
                        l45Var8.t = threadData;
                        l45Var8.position = i;
                        l45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(l45Var8);
                        l45 l45Var9 = new l45();
                        l45Var9.g = true;
                        l45Var9.t = threadData;
                        l45Var9.position = i;
                        l45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(l45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (to6.X(threadData)) {
                        to6 to6Var = new to6(threadData);
                        to6Var.g = threadData.getTid();
                        to6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        to6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(to6Var);
                    } else {
                        l45 l45Var10 = new l45();
                        l45Var10.t = threadData;
                        l45Var10.position = i;
                        l45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(l45Var10);
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
                vn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof l45) {
                    threadData = ((l45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof to6) {
                    threadData = ((to6) item).a;
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

    public static void e(boolean z, ArrayList<vn> arrayList, f15 f15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, f15Var}) == null) && f15Var != null && arrayList != null && (i = f15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, f15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
