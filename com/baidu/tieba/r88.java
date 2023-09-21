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
public class r88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<bn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<bn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            h45 h45Var = new h45();
            h45Var.t = threadData;
            h45Var.position = i;
            if (z) {
                h45Var.a = true;
            } else {
                h45Var.r = true;
            }
            h45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(h45Var);
        }
    }

    public static ArrayList<bn> c(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        h45 h45Var = new h45();
                        h45Var.t = threadData;
                        h45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            h45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            h45Var.d = true;
                            h45Var.u = imageWidthAndHeight[0];
                            h45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            h45Var.e = true;
                        } else {
                            h45Var.b = true;
                        }
                        h45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        h45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var);
                        if (threadData.getItem() != null) {
                            h45 h45Var2 = new h45();
                            h45Var2.n = true;
                            h45Var2.t = threadData;
                            h45Var2.position = i;
                            h45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            h45 h45Var3 = new h45();
                            h45Var3.t = threadData;
                            h45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                h45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                h45Var3.q = true;
                            }
                            h45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var3);
                        }
                        h45 h45Var4 = new h45();
                        h45Var4.m = true;
                        h45Var4.t = threadData;
                        h45Var4.position = i;
                        h45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(h45Var4);
                        h45 h45Var5 = new h45();
                        h45Var5.g = true;
                        h45Var5.t = threadData;
                        h45Var5.position = i;
                        h45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(h45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        h45 h45Var6 = new h45();
                        h45Var6.t = threadData;
                        h45Var6.position = i;
                        h45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        h45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var6);
                        if (threadData.getItem() != null) {
                            h45 h45Var7 = new h45();
                            h45Var7.n = true;
                            h45Var7.t = threadData;
                            h45Var7.position = i;
                            h45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(h45Var7);
                        }
                        h45 h45Var8 = new h45();
                        h45Var8.m = true;
                        h45Var8.t = threadData;
                        h45Var8.position = i;
                        h45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(h45Var8);
                        h45 h45Var9 = new h45();
                        h45Var9.g = true;
                        h45Var9.t = threadData;
                        h45Var9.position = i;
                        h45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(h45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (hq6.R(threadData)) {
                        hq6 hq6Var = new hq6(threadData);
                        hq6Var.g = threadData.getTid();
                        hq6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        hq6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(hq6Var);
                    } else {
                        h45 h45Var10 = new h45();
                        h45Var10.t = threadData;
                        h45Var10.position = i;
                        h45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(h45Var10);
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
                bn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof h45) {
                    threadData = ((h45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof hq6) {
                    threadData = ((hq6) item).a;
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

    public static void e(boolean z, ArrayList<bn> arrayList, b15 b15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, b15Var}) == null) && b15Var != null && arrayList != null && (i = b15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, b15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
