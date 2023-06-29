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
public class s28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<xn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<xn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            r45 r45Var = new r45();
            r45Var.t = threadData;
            r45Var.position = i;
            if (z) {
                r45Var.a = true;
            } else {
                r45Var.r = true;
            }
            r45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(r45Var);
        }
    }

    public static ArrayList<xn> c(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        r45 r45Var = new r45();
                        r45Var.t = threadData;
                        r45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            r45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            r45Var.d = true;
                            r45Var.u = imageWidthAndHeight[0];
                            r45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            r45Var.e = true;
                        } else {
                            r45Var.b = true;
                        }
                        r45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        r45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(r45Var);
                        if (threadData.getItem() != null) {
                            r45 r45Var2 = new r45();
                            r45Var2.n = true;
                            r45Var2.t = threadData;
                            r45Var2.position = i;
                            r45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(r45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            r45 r45Var3 = new r45();
                            r45Var3.t = threadData;
                            r45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                r45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                r45Var3.q = true;
                            }
                            r45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(r45Var3);
                        }
                        r45 r45Var4 = new r45();
                        r45Var4.m = true;
                        r45Var4.t = threadData;
                        r45Var4.position = i;
                        r45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(r45Var4);
                        r45 r45Var5 = new r45();
                        r45Var5.g = true;
                        r45Var5.t = threadData;
                        r45Var5.position = i;
                        r45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(r45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        r45 r45Var6 = new r45();
                        r45Var6.t = threadData;
                        r45Var6.position = i;
                        r45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        r45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(r45Var6);
                        if (threadData.getItem() != null) {
                            r45 r45Var7 = new r45();
                            r45Var7.n = true;
                            r45Var7.t = threadData;
                            r45Var7.position = i;
                            r45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(r45Var7);
                        }
                        r45 r45Var8 = new r45();
                        r45Var8.m = true;
                        r45Var8.t = threadData;
                        r45Var8.position = i;
                        r45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(r45Var8);
                        r45 r45Var9 = new r45();
                        r45Var9.g = true;
                        r45Var9.t = threadData;
                        r45Var9.position = i;
                        r45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(r45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (fp6.X(threadData)) {
                        fp6 fp6Var = new fp6(threadData);
                        fp6Var.g = threadData.getTid();
                        fp6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        fp6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(fp6Var);
                    } else {
                        r45 r45Var10 = new r45();
                        r45Var10.t = threadData;
                        r45Var10.position = i;
                        r45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(r45Var10);
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
                xn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof r45) {
                    threadData = ((r45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof fp6) {
                    threadData = ((fp6) item).a;
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

    public static void e(boolean z, ArrayList<xn> arrayList, l15 l15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, l15Var}) == null) && l15Var != null && arrayList != null && (i = l15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, l15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
