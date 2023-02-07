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
public class t78 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948134228, "Lcom/baidu/tieba/t78;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948134228, "Lcom/baidu/tieba/t78;");
        }
    }

    public t78() {
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

    public void a(int i, o78 o78Var, int i2, List<Cdo> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<m78> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), o78Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && o78Var != null && (list2 = o78Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<m78> list3 = o78Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (m78 m78Var : list3) {
                    if (m78Var != null && i == m78Var.b.intValue()) {
                        List<s78> list4 = m78Var.a;
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
                                            p78 p78Var = new p78();
                                            p78Var.m(m78Var.b.intValue());
                                            p78Var.l(recommendForumInfo.avatar);
                                            p78Var.p(recommendForumInfo.forum_id.longValue());
                                            p78Var.q(recommendForumInfo.forum_name);
                                            p78Var.r(recommendForumInfo.member_count.intValue());
                                            p78Var.u(recommendForumInfo.thread_count.intValue());
                                            p78Var.t(recommendForumInfo.slogan);
                                            p78Var.s(false);
                                            list.add(i2, p78Var);
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

    public List<Cdo> b(List<m78> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (m78 m78Var : list) {
                    if (m78Var != null) {
                        r78 r78Var = new r78();
                        r78Var.f(m78Var.b.intValue());
                        r78Var.c(m78Var.d);
                        r78Var.g(m78Var.c);
                        arrayList.add(r78Var);
                        List<s78> list2 = m78Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (s78 s78Var : list2) {
                                if (s78Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    p78 p78Var = new p78();
                                    RecommendForumInfo recommendForumInfo = s78Var.a;
                                    p78Var.m(m78Var.b.intValue());
                                    p78Var.o(m78Var.c);
                                    p78Var.l(recommendForumInfo.avatar);
                                    p78Var.p(recommendForumInfo.forum_id.longValue());
                                    p78Var.q(recommendForumInfo.forum_name);
                                    p78Var.r(recommendForumInfo.member_count.intValue());
                                    p78Var.u(recommendForumInfo.thread_count.intValue());
                                    p78Var.t(recommendForumInfo.slogan);
                                    arrayList.add(p78Var);
                                    a++;
                                }
                            }
                            q78 q78Var = new q78();
                            q78Var.f(m78Var.b.intValue());
                            q78Var.g(m78Var.c);
                            arrayList.add(q78Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<Cdo> list2) {
        p78 p78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (Cdo cdo : list2) {
                if ((cdo instanceof p78) && (p78Var = (p78) cdo) != null && p78Var.b() == i) {
                    list.add(Long.valueOf(p78Var.c()));
                }
            }
        }
    }

    public final void d(Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) && (cdo instanceof q78)) {
            ((q78) cdo).h(false);
        }
    }
}
