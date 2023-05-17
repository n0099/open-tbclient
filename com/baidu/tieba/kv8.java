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
public class kv8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947926652, "Lcom/baidu/tieba/kv8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947926652, "Lcom/baidu/tieba/kv8;");
        }
    }

    public kv8() {
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

    public void a(int i, fv8 fv8Var, int i2, List<rn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<dv8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), fv8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && fv8Var != null && (list2 = fv8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<dv8> list3 = fv8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (dv8 dv8Var : list3) {
                    if (dv8Var != null && i == dv8Var.b.intValue()) {
                        List<jv8> list4 = dv8Var.a;
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
                                            gv8 gv8Var = new gv8();
                                            gv8Var.l(dv8Var.b.intValue());
                                            gv8Var.k(recommendForumInfo.avatar);
                                            gv8Var.n(recommendForumInfo.forum_id.longValue());
                                            gv8Var.o(recommendForumInfo.forum_name);
                                            gv8Var.p(recommendForumInfo.member_count.intValue());
                                            gv8Var.t(recommendForumInfo.thread_count.intValue());
                                            gv8Var.s(recommendForumInfo.slogan);
                                            gv8Var.q(false);
                                            list.add(i2, gv8Var);
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

    public List<rn> b(List<dv8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (dv8 dv8Var : list) {
                    if (dv8Var != null) {
                        iv8 iv8Var = new iv8();
                        iv8Var.d(dv8Var.b.intValue());
                        iv8Var.c(dv8Var.d);
                        iv8Var.e(dv8Var.c);
                        arrayList.add(iv8Var);
                        List<jv8> list2 = dv8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (jv8 jv8Var : list2) {
                                if (jv8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    gv8 gv8Var = new gv8();
                                    RecommendForumInfo recommendForumInfo = jv8Var.a;
                                    gv8Var.l(dv8Var.b.intValue());
                                    gv8Var.m(dv8Var.c);
                                    gv8Var.k(recommendForumInfo.avatar);
                                    gv8Var.n(recommendForumInfo.forum_id.longValue());
                                    gv8Var.o(recommendForumInfo.forum_name);
                                    gv8Var.p(recommendForumInfo.member_count.intValue());
                                    gv8Var.t(recommendForumInfo.thread_count.intValue());
                                    gv8Var.s(recommendForumInfo.slogan);
                                    arrayList.add(gv8Var);
                                    a++;
                                }
                            }
                            hv8 hv8Var = new hv8();
                            hv8Var.d(dv8Var.b.intValue());
                            hv8Var.e(dv8Var.c);
                            arrayList.add(hv8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<rn> list2) {
        gv8 gv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (rn rnVar : list2) {
                if ((rnVar instanceof gv8) && (gv8Var = (gv8) rnVar) != null && gv8Var.b() == i) {
                    list.add(Long.valueOf(gv8Var.c()));
                }
            }
        }
    }

    public final void d(rn rnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, rnVar) == null) && (rnVar instanceof hv8)) {
            ((hv8) rnVar).f(false);
        }
    }
}
