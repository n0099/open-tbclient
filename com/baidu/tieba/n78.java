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
public class n78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<yn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<yn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            z45 z45Var = new z45();
            z45Var.t = threadData;
            z45Var.position = i;
            if (z) {
                z45Var.a = true;
            } else {
                z45Var.r = true;
            }
            z45Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(z45Var);
        }
    }

    public static ArrayList<yn> c(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        z45 z45Var = new z45();
                        z45Var.t = threadData;
                        z45Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            z45Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            z45Var.d = true;
                            z45Var.u = imageWidthAndHeight[0];
                            z45Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            z45Var.e = true;
                        } else {
                            z45Var.b = true;
                        }
                        z45Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        z45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var);
                        if (threadData.getItem() != null) {
                            z45 z45Var2 = new z45();
                            z45Var2.n = true;
                            z45Var2.t = threadData;
                            z45Var2.position = i;
                            z45Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            z45 z45Var3 = new z45();
                            z45Var3.t = threadData;
                            z45Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                z45Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                z45Var3.q = true;
                            }
                            z45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(z45Var3);
                        }
                        z45 z45Var4 = new z45();
                        z45Var4.m = true;
                        z45Var4.t = threadData;
                        z45Var4.position = i;
                        z45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z45Var4);
                        z45 z45Var5 = new z45();
                        z45Var5.g = true;
                        z45Var5.t = threadData;
                        z45Var5.position = i;
                        z45Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(z45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        z45 z45Var6 = new z45();
                        z45Var6.t = threadData;
                        z45Var6.position = i;
                        z45Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        z45Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var6);
                        if (threadData.getItem() != null) {
                            z45 z45Var7 = new z45();
                            z45Var7.n = true;
                            z45Var7.t = threadData;
                            z45Var7.position = i;
                            z45Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(z45Var7);
                        }
                        z45 z45Var8 = new z45();
                        z45Var8.m = true;
                        z45Var8.t = threadData;
                        z45Var8.position = i;
                        z45Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z45Var8);
                        z45 z45Var9 = new z45();
                        z45Var9.g = true;
                        z45Var9.t = threadData;
                        z45Var9.position = i;
                        z45Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(z45Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (jq6.X(threadData)) {
                        jq6 jq6Var = new jq6(threadData);
                        jq6Var.g = threadData.getTid();
                        jq6Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        jq6Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jq6Var);
                    } else {
                        z45 z45Var10 = new z45();
                        z45Var10.t = threadData;
                        z45Var10.position = i;
                        z45Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(z45Var10);
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
                yn item = bdTypeRecyclerView.getItem(i3);
                ThreadData threadData = null;
                if (item instanceof z45) {
                    threadData = ((z45) item).getThreadData();
                } else if (item instanceof ThreadData) {
                    threadData = (ThreadData) item;
                } else if (item instanceof jq6) {
                    threadData = ((jq6) item).a;
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

    public static void e(boolean z, ArrayList<yn> arrayList, t15 t15Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, t15Var}) == null) && t15Var != null && arrayList != null && (i = t15Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, t15Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
