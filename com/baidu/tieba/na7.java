package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
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
/* loaded from: classes5.dex */
public class na7 {
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
            jv4 jv4Var = new jv4();
            jv4Var.t = threadData;
            jv4Var.position = i;
            if (z) {
                jv4Var.a = true;
            } else {
                jv4Var.r = true;
            }
            jv4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(jv4Var);
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
                        jv4 jv4Var = new jv4();
                        jv4Var.t = threadData;
                        jv4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jv4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            jv4Var.d = true;
                            jv4Var.u = imageWidthAndHeight[0];
                            jv4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jv4Var.e = true;
                        } else {
                            jv4Var.b = true;
                        }
                        jv4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jv4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jv4Var);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var2 = new jv4();
                            jv4Var2.n = true;
                            jv4Var2.t = threadData;
                            jv4Var2.position = i;
                            jv4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jv4 jv4Var3 = new jv4();
                            jv4Var3.t = threadData;
                            jv4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jv4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jv4Var3.q = true;
                            }
                            jv4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var3);
                        }
                        jv4 jv4Var4 = new jv4();
                        jv4Var4.m = true;
                        jv4Var4.t = threadData;
                        jv4Var4.position = i;
                        jv4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jv4Var4);
                        jv4 jv4Var5 = new jv4();
                        jv4Var5.g = true;
                        jv4Var5.t = threadData;
                        jv4Var5.position = i;
                        jv4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jv4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        jv4 jv4Var6 = new jv4();
                        jv4Var6.t = threadData;
                        jv4Var6.position = i;
                        jv4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        jv4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jv4Var6);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var7 = new jv4();
                            jv4Var7.n = true;
                            jv4Var7.t = threadData;
                            jv4Var7.position = i;
                            jv4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(jv4Var7);
                        }
                        jv4 jv4Var8 = new jv4();
                        jv4Var8.m = true;
                        jv4Var8.t = threadData;
                        jv4Var8.position = i;
                        jv4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(jv4Var8);
                        jv4 jv4Var9 = new jv4();
                        jv4Var9.g = true;
                        jv4Var9.t = threadData;
                        jv4Var9.position = i;
                        jv4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jv4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (n96.W(threadData)) {
                        n96 n96Var = new n96(threadData);
                        n96Var.g = threadData.getTid();
                        n96Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        n96Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(n96Var);
                    } else {
                        jv4 jv4Var10 = new jv4();
                        jv4Var10.t = threadData;
                        jv4Var10.position = i;
                        jv4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jv4Var10);
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

    public static String d(z55 z55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, z55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return z55Var.a();
                }
                return z55Var.b();
            }
            return z55Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(z55 z55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, z55Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return z55Var.d();
                }
                return z55Var.e();
            }
            return z55Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static z55 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (z55 z55Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(z55Var.g()) && z55Var.g().equals(str)) {
                        return z55Var;
                    }
                }
            }
            return null;
        }
        return (z55) invokeL.objValue;
    }

    public static List<Integer> g(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                yn E = bdTypeRecyclerView.E(i3);
                ThreadData threadData = null;
                if (E instanceof jv4) {
                    threadData = ((jv4) E).getThreadData();
                } else if (E instanceof ThreadData) {
                    threadData = (ThreadData) E;
                } else if (E instanceof n96) {
                    threadData = ((n96) E).a;
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

    public static void h(boolean z, ArrayList<yn> arrayList, fs4 fs4Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, fs4Var}) == null) && fs4Var != null && arrayList != null && (i = fs4Var.floorPosition) >= 0) {
            if (i != 0 || z) {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayList.get(i3) instanceof ThreadData) {
                        if (i == i2) {
                            ListUtils.add(arrayList, i3, fs4Var);
                            return;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
