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
public class sa9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948144830, "Lcom/baidu/tieba/sa9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948144830, "Lcom/baidu/tieba/sa9;");
        }
    }

    public sa9() {
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

    public void a(int i, na9 na9Var, int i2, List<ym> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<la9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), na9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && na9Var != null && (list2 = na9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<la9> list3 = na9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (la9 la9Var : list3) {
                    if (la9Var != null && i == la9Var.b.intValue()) {
                        List<ra9> list4 = la9Var.a;
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
                                            oa9 oa9Var = new oa9();
                                            oa9Var.l(la9Var.b.intValue());
                                            oa9Var.i(recommendForumInfo.avatar);
                                            oa9Var.n(recommendForumInfo.forum_id.longValue());
                                            oa9Var.o(recommendForumInfo.forum_name);
                                            oa9Var.q(recommendForumInfo.member_count.intValue());
                                            oa9Var.u(recommendForumInfo.thread_count.intValue());
                                            oa9Var.t(recommendForumInfo.slogan);
                                            oa9Var.r(false);
                                            list.add(i2, oa9Var);
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

    public List<ym> b(List<la9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (la9 la9Var : list) {
                    if (la9Var != null) {
                        qa9 qa9Var = new qa9();
                        qa9Var.d(la9Var.b.intValue());
                        qa9Var.c(la9Var.d);
                        qa9Var.e(la9Var.c);
                        arrayList.add(qa9Var);
                        List<ra9> list2 = la9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (ra9 ra9Var : list2) {
                                if (ra9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    oa9 oa9Var = new oa9();
                                    RecommendForumInfo recommendForumInfo = ra9Var.a;
                                    oa9Var.l(la9Var.b.intValue());
                                    oa9Var.m(la9Var.c);
                                    oa9Var.i(recommendForumInfo.avatar);
                                    oa9Var.n(recommendForumInfo.forum_id.longValue());
                                    oa9Var.o(recommendForumInfo.forum_name);
                                    oa9Var.q(recommendForumInfo.member_count.intValue());
                                    oa9Var.u(recommendForumInfo.thread_count.intValue());
                                    oa9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(oa9Var);
                                    a++;
                                }
                            }
                            pa9 pa9Var = new pa9();
                            pa9Var.d(la9Var.b.intValue());
                            pa9Var.e(la9Var.c);
                            arrayList.add(pa9Var);
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
        oa9 oa9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (ym ymVar : list2) {
                if ((ymVar instanceof oa9) && (oa9Var = (oa9) ymVar) != null && oa9Var.b() == i) {
                    list.add(Long.valueOf(oa9Var.c()));
                }
            }
        }
    }

    public final void d(ym ymVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ymVar) == null) && (ymVar instanceof pa9)) {
            ((pa9) ymVar).f(false);
        }
    }
}
