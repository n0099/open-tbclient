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
/* loaded from: classes5.dex */
public class ns7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948013111, "Lcom/baidu/tieba/ns7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948013111, "Lcom/baidu/tieba/ns7;");
        }
    }

    public ns7() {
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

    public void a(int i, is7 is7Var, int i2, List<Cdo> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<gs7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), is7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || is7Var == null || (list2 = is7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<gs7> list3 = is7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (gs7 gs7Var : list3) {
            if (gs7Var != null && i == gs7Var.b.intValue()) {
                List<ms7> list4 = gs7Var.a;
                if (list4 == null || list4.size() <= 0) {
                    return;
                }
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
                                js7 js7Var = new js7();
                                js7Var.n(gs7Var.b.intValue());
                                js7Var.l(recommendForumInfo.avatar);
                                js7Var.q(recommendForumInfo.forum_id.longValue());
                                js7Var.r(recommendForumInfo.forum_name);
                                js7Var.s(recommendForumInfo.member_count.intValue());
                                js7Var.w(recommendForumInfo.thread_count.intValue());
                                js7Var.v(recommendForumInfo.slogan);
                                js7Var.t(false);
                                list.add(i2, js7Var);
                                arrayList.add(recommendForumInfo.forum_id);
                                i2++;
                                i3++;
                            }
                        }
                    }
                }
                bdTypeRecyclerView.setData(list);
            }
        }
    }

    public List<Cdo> b(List<gs7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (gs7 gs7Var : list) {
                if (gs7Var != null) {
                    ls7 ls7Var = new ls7();
                    ls7Var.f(gs7Var.b.intValue());
                    ls7Var.c(gs7Var.d);
                    ls7Var.g(gs7Var.c);
                    arrayList.add(ls7Var);
                    List<ms7> list2 = gs7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (ms7 ms7Var : list2) {
                            if (ms7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                js7 js7Var = new js7();
                                RecommendForumInfo recommendForumInfo = ms7Var.a;
                                js7Var.n(gs7Var.b.intValue());
                                js7Var.o(gs7Var.c);
                                js7Var.l(recommendForumInfo.avatar);
                                js7Var.q(recommendForumInfo.forum_id.longValue());
                                js7Var.r(recommendForumInfo.forum_name);
                                js7Var.s(recommendForumInfo.member_count.intValue());
                                js7Var.w(recommendForumInfo.thread_count.intValue());
                                js7Var.v(recommendForumInfo.slogan);
                                arrayList.add(js7Var);
                                a++;
                            }
                        }
                        ks7 ks7Var = new ks7();
                        ks7Var.f(gs7Var.b.intValue());
                        ks7Var.g(gs7Var.c);
                        arrayList.add(ks7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<Cdo> list2) {
        js7 js7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (Cdo cdo : list2) {
                if ((cdo instanceof js7) && (js7Var = (js7) cdo) != null && js7Var.b() == i) {
                    list.add(Long.valueOf(js7Var.c()));
                }
            }
        }
    }

    public final void d(Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) && (cdo instanceof ks7)) {
            ((ks7) cdo).h(false);
        }
    }
}
