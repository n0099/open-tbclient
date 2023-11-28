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
public class us9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948221710, "Lcom/baidu/tieba/us9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948221710, "Lcom/baidu/tieba/us9;");
        }
    }

    public us9() {
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

    public void a(int i, ps9 ps9Var, int i2, List<pi> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<ns9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ps9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && ps9Var != null && (list2 = ps9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ns9> list3 = ps9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ns9 ns9Var : list3) {
                    if (ns9Var != null && i == ns9Var.b.intValue()) {
                        List<ts9> list4 = ns9Var.a;
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
                                            qs9 qs9Var = new qs9();
                                            qs9Var.l(ns9Var.b.intValue());
                                            qs9Var.k(recommendForumInfo.avatar);
                                            qs9Var.o(recommendForumInfo.forum_id.longValue());
                                            qs9Var.p(recommendForumInfo.forum_name);
                                            qs9Var.q(recommendForumInfo.member_count.intValue());
                                            qs9Var.u(recommendForumInfo.thread_count.intValue());
                                            qs9Var.t(recommendForumInfo.slogan);
                                            qs9Var.s(false);
                                            list.add(i2, qs9Var);
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

    public List<pi> b(List<ns9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ns9 ns9Var : list) {
                    if (ns9Var != null) {
                        ss9 ss9Var = new ss9();
                        ss9Var.d(ns9Var.b.intValue());
                        ss9Var.c(ns9Var.d);
                        ss9Var.e(ns9Var.c);
                        arrayList.add(ss9Var);
                        List<ts9> list2 = ns9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (ts9 ts9Var : list2) {
                                if (ts9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    qs9 qs9Var = new qs9();
                                    RecommendForumInfo recommendForumInfo = ts9Var.a;
                                    qs9Var.l(ns9Var.b.intValue());
                                    qs9Var.n(ns9Var.c);
                                    qs9Var.k(recommendForumInfo.avatar);
                                    qs9Var.o(recommendForumInfo.forum_id.longValue());
                                    qs9Var.p(recommendForumInfo.forum_name);
                                    qs9Var.q(recommendForumInfo.member_count.intValue());
                                    qs9Var.u(recommendForumInfo.thread_count.intValue());
                                    qs9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(qs9Var);
                                    a++;
                                }
                            }
                            rs9 rs9Var = new rs9();
                            rs9Var.d(ns9Var.b.intValue());
                            rs9Var.e(ns9Var.c);
                            arrayList.add(rs9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<pi> list2) {
        qs9 qs9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (pi piVar : list2) {
                if ((piVar instanceof qs9) && (qs9Var = (qs9) piVar) != null && qs9Var.b() == i) {
                    list.add(Long.valueOf(qs9Var.c()));
                }
            }
        }
    }

    public final void d(pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, piVar) == null) && (piVar instanceof rs9)) {
            ((rs9) piVar).f(false);
        }
    }
}
