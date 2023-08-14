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
public class ta9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948174621, "Lcom/baidu/tieba/ta9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948174621, "Lcom/baidu/tieba/ta9;");
        }
    }

    public ta9() {
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

    public void a(int i, oa9 oa9Var, int i2, List<ym> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<ma9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), oa9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && oa9Var != null && (list2 = oa9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ma9> list3 = oa9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ma9 ma9Var : list3) {
                    if (ma9Var != null && i == ma9Var.b.intValue()) {
                        List<sa9> list4 = ma9Var.a;
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
                                            pa9 pa9Var = new pa9();
                                            pa9Var.l(ma9Var.b.intValue());
                                            pa9Var.i(recommendForumInfo.avatar);
                                            pa9Var.n(recommendForumInfo.forum_id.longValue());
                                            pa9Var.o(recommendForumInfo.forum_name);
                                            pa9Var.q(recommendForumInfo.member_count.intValue());
                                            pa9Var.u(recommendForumInfo.thread_count.intValue());
                                            pa9Var.t(recommendForumInfo.slogan);
                                            pa9Var.r(false);
                                            list.add(i2, pa9Var);
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

    public List<ym> b(List<ma9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ma9 ma9Var : list) {
                    if (ma9Var != null) {
                        ra9 ra9Var = new ra9();
                        ra9Var.d(ma9Var.b.intValue());
                        ra9Var.c(ma9Var.d);
                        ra9Var.e(ma9Var.c);
                        arrayList.add(ra9Var);
                        List<sa9> list2 = ma9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (sa9 sa9Var : list2) {
                                if (sa9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    pa9 pa9Var = new pa9();
                                    RecommendForumInfo recommendForumInfo = sa9Var.a;
                                    pa9Var.l(ma9Var.b.intValue());
                                    pa9Var.m(ma9Var.c);
                                    pa9Var.i(recommendForumInfo.avatar);
                                    pa9Var.n(recommendForumInfo.forum_id.longValue());
                                    pa9Var.o(recommendForumInfo.forum_name);
                                    pa9Var.q(recommendForumInfo.member_count.intValue());
                                    pa9Var.u(recommendForumInfo.thread_count.intValue());
                                    pa9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(pa9Var);
                                    a++;
                                }
                            }
                            qa9 qa9Var = new qa9();
                            qa9Var.d(ma9Var.b.intValue());
                            qa9Var.e(ma9Var.c);
                            arrayList.add(qa9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<ym> list2) {
        pa9 pa9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (ym ymVar : list2) {
                if ((ymVar instanceof pa9) && (pa9Var = (pa9) ymVar) != null && pa9Var.b() == i) {
                    list.add(Long.valueOf(pa9Var.c()));
                }
            }
        }
    }

    public final void d(ym ymVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ymVar) == null) && (ymVar instanceof qa9)) {
            ((qa9) ymVar).f(false);
        }
    }
}
