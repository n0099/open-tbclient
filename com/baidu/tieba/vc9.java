package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class vc9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948236125, "Lcom/baidu/tieba/vc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948236125, "Lcom/baidu/tieba/vc9;");
        }
    }

    public vc9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(int i, qc9 qc9Var, int i2, List<yn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<oc9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), qc9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && qc9Var != null && (list2 = qc9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<oc9> list3 = qc9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (oc9 oc9Var : list3) {
                    if (oc9Var != null && i == oc9Var.b.intValue()) {
                        List<uc9> list4 = oc9Var.a;
                        if (list4 != null && list4.size() > 0) {
                            for (int i4 = 0; i4 < list4.size(); i4++) {
                                if (list4.get(i4) != null) {
                                    if (arrayList.size() >= 20) {
                                        d(list.get(i2));
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else if (i3 >= 4) {
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else {
                                        if (i4 == list4.size() - 1) {
                                            d(list.get(i2));
                                        }
                                        RecommendForumInfo recommendForumInfo = list4.get(i4).a;
                                        if (!arrayList.contains(recommendForumInfo.forum_id)) {
                                            rc9 rc9Var = new rc9();
                                            rc9Var.k(oc9Var.b.intValue());
                                            rc9Var.i(recommendForumInfo.avatar);
                                            rc9Var.n(recommendForumInfo.forum_id.longValue());
                                            rc9Var.o(recommendForumInfo.forum_name);
                                            rc9Var.p(recommendForumInfo.member_count.intValue());
                                            rc9Var.t(recommendForumInfo.thread_count.intValue());
                                            rc9Var.r(recommendForumInfo.slogan);
                                            rc9Var.q(false);
                                            list.add(i2, rc9Var);
                                            arrayList.add(recommendForumInfo.forum_id);
                                            i2++;
                                            i3++;
                                        }
                                    }
                                }
                            }
                            bdTypeRecyclerView.setData(list);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public List<yn> b(List<oc9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (oc9 oc9Var : list) {
                    if (oc9Var != null) {
                        tc9 tc9Var = new tc9();
                        tc9Var.d(oc9Var.b.intValue());
                        tc9Var.c(oc9Var.d);
                        tc9Var.e(oc9Var.c);
                        arrayList.add(tc9Var);
                        List<uc9> list2 = oc9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (uc9 uc9Var : list2) {
                                if (uc9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    rc9 rc9Var = new rc9();
                                    RecommendForumInfo recommendForumInfo = uc9Var.a;
                                    rc9Var.k(oc9Var.b.intValue());
                                    rc9Var.m(oc9Var.c);
                                    rc9Var.i(recommendForumInfo.avatar);
                                    rc9Var.n(recommendForumInfo.forum_id.longValue());
                                    rc9Var.o(recommendForumInfo.forum_name);
                                    rc9Var.p(recommendForumInfo.member_count.intValue());
                                    rc9Var.t(recommendForumInfo.thread_count.intValue());
                                    rc9Var.r(recommendForumInfo.slogan);
                                    arrayList.add(rc9Var);
                                    a++;
                                }
                            }
                            sc9 sc9Var = new sc9();
                            sc9Var.d(oc9Var.b.intValue());
                            sc9Var.e(oc9Var.c);
                            arrayList.add(sc9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<yn> list2) {
        rc9 rc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (yn ynVar : list2) {
                if ((ynVar instanceof rc9) && (rc9Var = (rc9) ynVar) != null && rc9Var.b() == i) {
                    list.add(Long.valueOf(rc9Var.c()));
                }
            }
        }
    }

    public final void d(yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ynVar) == null) && (ynVar instanceof sc9)) {
            ((sc9) ynVar).f(false);
        }
    }
}
