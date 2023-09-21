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
/* loaded from: classes6.dex */
public class lh9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947943020, "Lcom/baidu/tieba/lh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947943020, "Lcom/baidu/tieba/lh9;");
        }
    }

    public lh9() {
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

    public void a(int i, gh9 gh9Var, int i2, List<bn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<eh9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), gh9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && gh9Var != null && (list2 = gh9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<eh9> list3 = gh9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (eh9 eh9Var : list3) {
                    if (eh9Var != null && i == eh9Var.b.intValue()) {
                        List<kh9> list4 = eh9Var.a;
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
                                            hh9 hh9Var = new hh9();
                                            hh9Var.l(eh9Var.b.intValue());
                                            hh9Var.i(recommendForumInfo.avatar);
                                            hh9Var.o(recommendForumInfo.forum_id.longValue());
                                            hh9Var.p(recommendForumInfo.forum_name);
                                            hh9Var.q(recommendForumInfo.member_count.intValue());
                                            hh9Var.u(recommendForumInfo.thread_count.intValue());
                                            hh9Var.t(recommendForumInfo.slogan);
                                            hh9Var.s(false);
                                            list.add(i2, hh9Var);
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

    public List<bn> b(List<eh9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (eh9 eh9Var : list) {
                    if (eh9Var != null) {
                        jh9 jh9Var = new jh9();
                        jh9Var.d(eh9Var.b.intValue());
                        jh9Var.c(eh9Var.d);
                        jh9Var.e(eh9Var.c);
                        arrayList.add(jh9Var);
                        List<kh9> list2 = eh9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (kh9 kh9Var : list2) {
                                if (kh9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    hh9 hh9Var = new hh9();
                                    RecommendForumInfo recommendForumInfo = kh9Var.a;
                                    hh9Var.l(eh9Var.b.intValue());
                                    hh9Var.m(eh9Var.c);
                                    hh9Var.i(recommendForumInfo.avatar);
                                    hh9Var.o(recommendForumInfo.forum_id.longValue());
                                    hh9Var.p(recommendForumInfo.forum_name);
                                    hh9Var.q(recommendForumInfo.member_count.intValue());
                                    hh9Var.u(recommendForumInfo.thread_count.intValue());
                                    hh9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(hh9Var);
                                    a++;
                                }
                            }
                            ih9 ih9Var = new ih9();
                            ih9Var.d(eh9Var.b.intValue());
                            ih9Var.e(eh9Var.c);
                            arrayList.add(ih9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<bn> list2) {
        hh9 hh9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (bn bnVar : list2) {
                if ((bnVar instanceof hh9) && (hh9Var = (hh9) bnVar) != null && hh9Var.b() == i) {
                    list.add(Long.valueOf(hh9Var.c()));
                }
            }
        }
    }

    public final void d(bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bnVar) == null) && (bnVar instanceof ih9)) {
            ((ih9) bnVar).f(false);
        }
    }
}
