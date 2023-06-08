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
public class x18 {
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
            n45 n45Var = new n45();
            n45Var.t = threadData;
            n45Var.position = i;
            if (z) {
                n45Var.a = true;
            } else {
                n45Var.r = true;
            }
            n45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(n45Var);
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
                        n45 n45Var = new n45();
                        n45Var.t = threadData;
                        n45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            n45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            n45Var.d = true;
                            n45Var.u = imageWidthAndHeight[0];
                            n45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            n45Var.e = true;
                        } else {
                            n45Var.b = true;
                        }
                        n45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        n45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(n45Var);
                        if (threadData.getItem() != null) {
                            n45 n45Var2 = new n45();
                            n45Var2.n = true;
                            n45Var2.t = threadData;
                            n45Var2.position = i;
                            n45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(n45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            n45 n45Var3 = new n45();
                            n45Var3.t = threadData;
                            n45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                n45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                n45Var3.q = true;
                            }
                            n45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(n45Var3);
                        }
                        n45 n45Var4 = new n45();
                        n45Var4.m = true;
                        n45Var4.t = threadData;
                        n45Var4.position = i;
                        n45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(n45Var4);
                        n45 n45Var5 = new n45();
                        n45Var5.g = true;
                        n45Var5.t = threadData;
                        n45Var5.position = i;
                        n45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(n45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        n45 n45Var6 = new n45();
                        n45Var6.t = threadData;
                        n45Var6.position = i;
                        n45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        n45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(n45Var6);
                        if (threadData.getItem() != null) {
                            n45 n45Var7 = new n45();
                            n45Var7.n = true;
                            n45Var7.t = threadData;
                            n45Var7.position = i;
                            n45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(n45Var7);
                        }
                        n45 n45Var8 = new n45();
                        n45Var8.m = true;
                        n45Var8.t = threadData;
                        n45Var8.position = i;
                        n45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(n45Var8);
                        n45 n45Var9 = new n45();
                        n45Var9.g = true;
                        n45Var9.t = threadData;
                        n45Var9.position = i;
                        n45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(n45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (vo6.X(threadData)) {
                        vo6 vo6Var = new vo6(threadData);
                        vo6Var.g = threadData.getTid();
                        vo6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        vo6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(vo6Var);
                    } else {
                        n45 n45Var10 = new n45();
                        n45Var10.t = threadData;
                        n45Var10.position = i;
                        n45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(n45Var10);
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
                if (item instanceof n45) {
                    threadData = ((n45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof vo6) {
                    threadData = ((vo6) item).a;
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

    public static void e(boolean z, ArrayList<vn> arrayList, h15 h15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, h15Var}) == null) && h15Var != null && arrayList != null && (i = h15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, h15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
