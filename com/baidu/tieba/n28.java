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
/* loaded from: classes6.dex */
public class n28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<wn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<wn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            o45 o45Var = new o45();
            o45Var.t = threadData;
            o45Var.position = i;
            if (z) {
                o45Var.a = true;
            } else {
                o45Var.r = true;
            }
            o45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(o45Var);
        }
    }

    public static ArrayList<wn> c(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        o45 o45Var = new o45();
                        o45Var.t = threadData;
                        o45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            o45Var.d = true;
                            o45Var.u = imageWidthAndHeight[0];
                            o45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o45Var.e = true;
                        } else {
                            o45Var.b = true;
                        }
                        o45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        o45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o45Var);
                        if (threadData.getItem() != null) {
                            o45 o45Var2 = new o45();
                            o45Var2.n = true;
                            o45Var2.t = threadData;
                            o45Var2.position = i;
                            o45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            o45 o45Var3 = new o45();
                            o45Var3.t = threadData;
                            o45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                o45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                o45Var3.q = true;
                            }
                            o45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var3);
                        }
                        o45 o45Var4 = new o45();
                        o45Var4.m = true;
                        o45Var4.t = threadData;
                        o45Var4.position = i;
                        o45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(o45Var4);
                        o45 o45Var5 = new o45();
                        o45Var5.g = true;
                        o45Var5.t = threadData;
                        o45Var5.position = i;
                        o45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        o45 o45Var6 = new o45();
                        o45Var6.t = threadData;
                        o45Var6.position = i;
                        o45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        o45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o45Var6);
                        if (threadData.getItem() != null) {
                            o45 o45Var7 = new o45();
                            o45Var7.n = true;
                            o45Var7.t = threadData;
                            o45Var7.position = i;
                            o45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(o45Var7);
                        }
                        o45 o45Var8 = new o45();
                        o45Var8.m = true;
                        o45Var8.t = threadData;
                        o45Var8.position = i;
                        o45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(o45Var8);
                        o45 o45Var9 = new o45();
                        o45Var9.g = true;
                        o45Var9.t = threadData;
                        o45Var9.position = i;
                        o45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (ap6.X(threadData)) {
                        ap6 ap6Var = new ap6(threadData);
                        ap6Var.g = threadData.getTid();
                        ap6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        ap6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(ap6Var);
                    } else {
                        o45 o45Var10 = new o45();
                        o45Var10.t = threadData;
                        o45Var10.position = i;
                        o45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(o45Var10);
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
                wn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof o45) {
                    threadData = ((o45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof ap6) {
                    threadData = ((ap6) item).a;
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

    public static void e(boolean z, ArrayList<wn> arrayList, i15 i15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, i15Var}) == null) && i15Var != null && arrayList != null && (i = i15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, i15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
