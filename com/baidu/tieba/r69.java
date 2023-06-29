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
/* loaded from: classes7.dex */
public class r69 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948073716, "Lcom/baidu/tieba/r69;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948073716, "Lcom/baidu/tieba/r69;");
        }
    }

    public r69() {
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

    public void a(int i, m69 m69Var, int i2, List<xn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<k69> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), m69Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && m69Var != null && (list2 = m69Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<k69> list3 = m69Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (k69 k69Var : list3) {
                    if (k69Var != null && i == k69Var.b.intValue()) {
                        List<q69> list4 = k69Var.a;
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
                                            n69 n69Var = new n69();
                                            n69Var.l(k69Var.b.intValue());
                                            n69Var.k(recommendForumInfo.avatar);
                                            n69Var.n(recommendForumInfo.forum_id.longValue());
                                            n69Var.o(recommendForumInfo.forum_name);
                                            n69Var.p(recommendForumInfo.member_count.intValue());
                                            n69Var.t(recommendForumInfo.thread_count.intValue());
                                            n69Var.s(recommendForumInfo.slogan);
                                            n69Var.q(false);
                                            list.add(i2, n69Var);
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

    public List<xn> b(List<k69> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (k69 k69Var : list) {
                    if (k69Var != null) {
                        p69 p69Var = new p69();
                        p69Var.d(k69Var.b.intValue());
                        p69Var.c(k69Var.d);
                        p69Var.e(k69Var.c);
                        arrayList.add(p69Var);
                        List<q69> list2 = k69Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (q69 q69Var : list2) {
                                if (q69Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    n69 n69Var = new n69();
                                    RecommendForumInfo recommendForumInfo = q69Var.a;
                                    n69Var.l(k69Var.b.intValue());
                                    n69Var.m(k69Var.c);
                                    n69Var.k(recommendForumInfo.avatar);
                                    n69Var.n(recommendForumInfo.forum_id.longValue());
                                    n69Var.o(recommendForumInfo.forum_name);
                                    n69Var.p(recommendForumInfo.member_count.intValue());
                                    n69Var.t(recommendForumInfo.thread_count.intValue());
                                    n69Var.s(recommendForumInfo.slogan);
                                    arrayList.add(n69Var);
                                    a++;
                                }
                            }
                            o69 o69Var = new o69();
                            o69Var.d(k69Var.b.intValue());
                            o69Var.e(k69Var.c);
                            arrayList.add(o69Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<xn> list2) {
        n69 n69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (xn xnVar : list2) {
                if ((xnVar instanceof n69) && (n69Var = (n69) xnVar) != null && n69Var.b() == i) {
                    list.add(Long.valueOf(n69Var.c()));
                }
            }
        }
    }

    public final void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) && (xnVar instanceof o69)) {
            ((o69) xnVar).f(false);
        }
    }
}
