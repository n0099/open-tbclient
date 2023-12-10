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
/* loaded from: classes9.dex */
public class zs9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948370665, "Lcom/baidu/tieba/zs9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948370665, "Lcom/baidu/tieba/zs9;");
        }
    }

    public zs9() {
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

    public void a(int i, us9 us9Var, int i2, List<pi> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<ss9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), us9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && us9Var != null && (list2 = us9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ss9> list3 = us9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ss9 ss9Var : list3) {
                    if (ss9Var != null && i == ss9Var.b.intValue()) {
                        List<ys9> list4 = ss9Var.a;
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
                                            vs9 vs9Var = new vs9();
                                            vs9Var.l(ss9Var.b.intValue());
                                            vs9Var.k(recommendForumInfo.avatar);
                                            vs9Var.o(recommendForumInfo.forum_id.longValue());
                                            vs9Var.p(recommendForumInfo.forum_name);
                                            vs9Var.q(recommendForumInfo.member_count.intValue());
                                            vs9Var.u(recommendForumInfo.thread_count.intValue());
                                            vs9Var.t(recommendForumInfo.slogan);
                                            vs9Var.s(false);
                                            list.add(i2, vs9Var);
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

    public List<pi> b(List<ss9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ss9 ss9Var : list) {
                    if (ss9Var != null) {
                        xs9 xs9Var = new xs9();
                        xs9Var.d(ss9Var.b.intValue());
                        xs9Var.c(ss9Var.d);
                        xs9Var.e(ss9Var.c);
                        arrayList.add(xs9Var);
                        List<ys9> list2 = ss9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (ys9 ys9Var : list2) {
                                if (ys9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    vs9 vs9Var = new vs9();
                                    RecommendForumInfo recommendForumInfo = ys9Var.a;
                                    vs9Var.l(ss9Var.b.intValue());
                                    vs9Var.n(ss9Var.c);
                                    vs9Var.k(recommendForumInfo.avatar);
                                    vs9Var.o(recommendForumInfo.forum_id.longValue());
                                    vs9Var.p(recommendForumInfo.forum_name);
                                    vs9Var.q(recommendForumInfo.member_count.intValue());
                                    vs9Var.u(recommendForumInfo.thread_count.intValue());
                                    vs9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(vs9Var);
                                    a++;
                                }
                            }
                            ws9 ws9Var = new ws9();
                            ws9Var.d(ss9Var.b.intValue());
                            ws9Var.e(ss9Var.c);
                            arrayList.add(ws9Var);
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
        vs9 vs9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (pi piVar : list2) {
                if ((piVar instanceof vs9) && (vs9Var = (vs9) piVar) != null && vs9Var.b() == i) {
                    list.add(Long.valueOf(vs9Var.c()));
                }
            }
        }
    }

    public final void d(pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, piVar) == null) && (piVar instanceof ws9)) {
            ((ws9) piVar).f(false);
        }
    }
}
