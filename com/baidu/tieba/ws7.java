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
public class ws7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<hn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<hn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            oz4 oz4Var = new oz4();
            oz4Var.t = threadData;
            oz4Var.position = i;
            if (z) {
                oz4Var.a = true;
            } else {
                oz4Var.r = true;
            }
            oz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(oz4Var);
        }
    }

    public static ArrayList<hn> c(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<hn> arrayList2 = new ArrayList<>();
            Iterator<hn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                hn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        oz4 oz4Var = new oz4();
                        oz4Var.t = threadData;
                        oz4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            oz4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            oz4Var.d = true;
                            oz4Var.u = imageWidthAndHeight[0];
                            oz4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            oz4Var.e = true;
                        } else {
                            oz4Var.b = true;
                        }
                        oz4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        oz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(oz4Var);
                        if (threadData.getItem() != null) {
                            oz4 oz4Var2 = new oz4();
                            oz4Var2.n = true;
                            oz4Var2.t = threadData;
                            oz4Var2.position = i;
                            oz4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            oz4 oz4Var3 = new oz4();
                            oz4Var3.t = threadData;
                            oz4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                oz4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                oz4Var3.q = true;
                            }
                            oz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(oz4Var3);
                        }
                        oz4 oz4Var4 = new oz4();
                        oz4Var4.m = true;
                        oz4Var4.t = threadData;
                        oz4Var4.position = i;
                        oz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(oz4Var4);
                        oz4 oz4Var5 = new oz4();
                        oz4Var5.g = true;
                        oz4Var5.t = threadData;
                        oz4Var5.position = i;
                        oz4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(oz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        oz4 oz4Var6 = new oz4();
                        oz4Var6.t = threadData;
                        oz4Var6.position = i;
                        oz4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        oz4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(oz4Var6);
                        if (threadData.getItem() != null) {
                            oz4 oz4Var7 = new oz4();
                            oz4Var7.n = true;
                            oz4Var7.t = threadData;
                            oz4Var7.position = i;
                            oz4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(oz4Var7);
                        }
                        oz4 oz4Var8 = new oz4();
                        oz4Var8.m = true;
                        oz4Var8.t = threadData;
                        oz4Var8.position = i;
                        oz4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(oz4Var8);
                        oz4 oz4Var9 = new oz4();
                        oz4Var9.g = true;
                        oz4Var9.t = threadData;
                        oz4Var9.position = i;
                        oz4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(oz4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (lh6.W(threadData)) {
                        lh6 lh6Var = new lh6(threadData);
                        lh6Var.g = threadData.getTid();
                        lh6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        lh6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(lh6Var);
                    } else {
                        oz4 oz4Var10 = new oz4();
                        oz4Var10.t = threadData;
                        oz4Var10.position = i;
                        oz4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(oz4Var10);
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
                hn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof oz4) {
                    threadData = ((oz4) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof lh6) {
                    threadData = ((lh6) item).a;
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

    public static void e(boolean z, ArrayList<hn> arrayList, jw4 jw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, jw4Var}) == null) && jw4Var != null && arrayList != null && (i = jw4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, jw4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
