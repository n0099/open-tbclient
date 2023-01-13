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
public class w28 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948218796, "Lcom/baidu/tieba/w28;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948218796, "Lcom/baidu/tieba/w28;");
        }
    }

    public w28() {
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

    public void a(int i, r28 r28Var, int i2, List<yn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<p28> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), r28Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && r28Var != null && (list2 = r28Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<p28> list3 = r28Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (p28 p28Var : list3) {
                    if (p28Var != null && i == p28Var.b.intValue()) {
                        List<v28> list4 = p28Var.a;
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
                                            s28 s28Var = new s28();
                                            s28Var.m(p28Var.b.intValue());
                                            s28Var.l(recommendForumInfo.avatar);
                                            s28Var.p(recommendForumInfo.forum_id.longValue());
                                            s28Var.q(recommendForumInfo.forum_name);
                                            s28Var.r(recommendForumInfo.member_count.intValue());
                                            s28Var.v(recommendForumInfo.thread_count.intValue());
                                            s28Var.t(recommendForumInfo.slogan);
                                            s28Var.s(false);
                                            list.add(i2, s28Var);
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

    public List<yn> b(List<p28> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (p28 p28Var : list) {
                    if (p28Var != null) {
                        u28 u28Var = new u28();
                        u28Var.f(p28Var.b.intValue());
                        u28Var.c(p28Var.d);
                        u28Var.g(p28Var.c);
                        arrayList.add(u28Var);
                        List<v28> list2 = p28Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (v28 v28Var : list2) {
                                if (v28Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    s28 s28Var = new s28();
                                    RecommendForumInfo recommendForumInfo = v28Var.a;
                                    s28Var.m(p28Var.b.intValue());
                                    s28Var.o(p28Var.c);
                                    s28Var.l(recommendForumInfo.avatar);
                                    s28Var.p(recommendForumInfo.forum_id.longValue());
                                    s28Var.q(recommendForumInfo.forum_name);
                                    s28Var.r(recommendForumInfo.member_count.intValue());
                                    s28Var.v(recommendForumInfo.thread_count.intValue());
                                    s28Var.t(recommendForumInfo.slogan);
                                    arrayList.add(s28Var);
                                    a++;
                                }
                            }
                            t28 t28Var = new t28();
                            t28Var.f(p28Var.b.intValue());
                            t28Var.g(p28Var.c);
                            arrayList.add(t28Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<yn> list2) {
        s28 s28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (yn ynVar : list2) {
                if ((ynVar instanceof s28) && (s28Var = (s28) ynVar) != null && s28Var.b() == i) {
                    list.add(Long.valueOf(s28Var.c()));
                }
            }
        }
    }

    public final void d(yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ynVar) == null) && (ynVar instanceof t28)) {
            ((t28) ynVar).h(false);
        }
    }
}
