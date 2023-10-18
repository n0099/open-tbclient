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
public class yb9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948324537, "Lcom/baidu/tieba/yb9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948324537, "Lcom/baidu/tieba/yb9;");
        }
    }

    public yb9() {
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

    public void a(int i, tb9 tb9Var, int i2, List<yh> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<rb9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tb9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && tb9Var != null && (list2 = tb9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<rb9> list3 = tb9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (rb9 rb9Var : list3) {
                    if (rb9Var != null && i == rb9Var.b.intValue()) {
                        List<xb9> list4 = rb9Var.a;
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
                                            ub9 ub9Var = new ub9();
                                            ub9Var.l(rb9Var.b.intValue());
                                            ub9Var.i(recommendForumInfo.avatar);
                                            ub9Var.o(recommendForumInfo.forum_id.longValue());
                                            ub9Var.p(recommendForumInfo.forum_name);
                                            ub9Var.q(recommendForumInfo.member_count.intValue());
                                            ub9Var.u(recommendForumInfo.thread_count.intValue());
                                            ub9Var.t(recommendForumInfo.slogan);
                                            ub9Var.r(false);
                                            list.add(i2, ub9Var);
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

    public List<yh> b(List<rb9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (rb9 rb9Var : list) {
                    if (rb9Var != null) {
                        wb9 wb9Var = new wb9();
                        wb9Var.d(rb9Var.b.intValue());
                        wb9Var.c(rb9Var.d);
                        wb9Var.e(rb9Var.c);
                        arrayList.add(wb9Var);
                        List<xb9> list2 = rb9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (xb9 xb9Var : list2) {
                                if (xb9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    ub9 ub9Var = new ub9();
                                    RecommendForumInfo recommendForumInfo = xb9Var.a;
                                    ub9Var.l(rb9Var.b.intValue());
                                    ub9Var.m(rb9Var.c);
                                    ub9Var.i(recommendForumInfo.avatar);
                                    ub9Var.o(recommendForumInfo.forum_id.longValue());
                                    ub9Var.p(recommendForumInfo.forum_name);
                                    ub9Var.q(recommendForumInfo.member_count.intValue());
                                    ub9Var.u(recommendForumInfo.thread_count.intValue());
                                    ub9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(ub9Var);
                                    a++;
                                }
                            }
                            vb9 vb9Var = new vb9();
                            vb9Var.d(rb9Var.b.intValue());
                            vb9Var.e(rb9Var.c);
                            arrayList.add(vb9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<yh> list2) {
        ub9 ub9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (yh yhVar : list2) {
                if ((yhVar instanceof ub9) && (ub9Var = (ub9) yhVar) != null && ub9Var.b() == i) {
                    list.add(Long.valueOf(ub9Var.c()));
                }
            }
        }
    }

    public final void d(yh yhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, yhVar) == null) && (yhVar instanceof vb9)) {
            ((vb9) yhVar).f(false);
        }
    }
}
