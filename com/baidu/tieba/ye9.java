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
public class ye9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948327420, "Lcom/baidu/tieba/ye9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948327420, "Lcom/baidu/tieba/ye9;");
        }
    }

    public ye9() {
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

    public void a(int i, te9 te9Var, int i2, List<bn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<re9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), te9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && te9Var != null && (list2 = te9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<re9> list3 = te9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (re9 re9Var : list3) {
                    if (re9Var != null && i == re9Var.b.intValue()) {
                        List<xe9> list4 = re9Var.a;
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
                                            ue9 ue9Var = new ue9();
                                            ue9Var.l(re9Var.b.intValue());
                                            ue9Var.i(recommendForumInfo.avatar);
                                            ue9Var.n(recommendForumInfo.forum_id.longValue());
                                            ue9Var.o(recommendForumInfo.forum_name);
                                            ue9Var.q(recommendForumInfo.member_count.intValue());
                                            ue9Var.u(recommendForumInfo.thread_count.intValue());
                                            ue9Var.t(recommendForumInfo.slogan);
                                            ue9Var.r(false);
                                            list.add(i2, ue9Var);
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

    public List<bn> b(List<re9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (re9 re9Var : list) {
                    if (re9Var != null) {
                        we9 we9Var = new we9();
                        we9Var.d(re9Var.b.intValue());
                        we9Var.c(re9Var.d);
                        we9Var.e(re9Var.c);
                        arrayList.add(we9Var);
                        List<xe9> list2 = re9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (xe9 xe9Var : list2) {
                                if (xe9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    ue9 ue9Var = new ue9();
                                    RecommendForumInfo recommendForumInfo = xe9Var.a;
                                    ue9Var.l(re9Var.b.intValue());
                                    ue9Var.m(re9Var.c);
                                    ue9Var.i(recommendForumInfo.avatar);
                                    ue9Var.n(recommendForumInfo.forum_id.longValue());
                                    ue9Var.o(recommendForumInfo.forum_name);
                                    ue9Var.q(recommendForumInfo.member_count.intValue());
                                    ue9Var.u(recommendForumInfo.thread_count.intValue());
                                    ue9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(ue9Var);
                                    a++;
                                }
                            }
                            ve9 ve9Var = new ve9();
                            ve9Var.d(re9Var.b.intValue());
                            ve9Var.e(re9Var.c);
                            arrayList.add(ve9Var);
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
        ue9 ue9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (bn bnVar : list2) {
                if ((bnVar instanceof ue9) && (ue9Var = (ue9) bnVar) != null && ue9Var.b() == i) {
                    list.add(Long.valueOf(ue9Var.c()));
                }
            }
        }
    }

    public final void d(bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bnVar) == null) && (bnVar instanceof ve9)) {
            ((ve9) bnVar).f(false);
        }
    }
}
