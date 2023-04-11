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
public class yq8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948338921, "Lcom/baidu/tieba/yq8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948338921, "Lcom/baidu/tieba/yq8;");
        }
    }

    public yq8() {
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

    public void a(int i, tq8 tq8Var, int i2, List<hn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<rq8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tq8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && tq8Var != null && (list2 = tq8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<rq8> list3 = tq8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (rq8 rq8Var : list3) {
                    if (rq8Var != null && i == rq8Var.b.intValue()) {
                        List<xq8> list4 = rq8Var.a;
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
                                            uq8 uq8Var = new uq8();
                                            uq8Var.l(rq8Var.b.intValue());
                                            uq8Var.k(recommendForumInfo.avatar);
                                            uq8Var.n(recommendForumInfo.forum_id.longValue());
                                            uq8Var.o(recommendForumInfo.forum_name);
                                            uq8Var.q(recommendForumInfo.member_count.intValue());
                                            uq8Var.u(recommendForumInfo.thread_count.intValue());
                                            uq8Var.s(recommendForumInfo.slogan);
                                            uq8Var.r(false);
                                            list.add(i2, uq8Var);
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

    public List<hn> b(List<rq8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (rq8 rq8Var : list) {
                    if (rq8Var != null) {
                        wq8 wq8Var = new wq8();
                        wq8Var.d(rq8Var.b.intValue());
                        wq8Var.c(rq8Var.d);
                        wq8Var.e(rq8Var.c);
                        arrayList.add(wq8Var);
                        List<xq8> list2 = rq8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (xq8 xq8Var : list2) {
                                if (xq8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    uq8 uq8Var = new uq8();
                                    RecommendForumInfo recommendForumInfo = xq8Var.a;
                                    uq8Var.l(rq8Var.b.intValue());
                                    uq8Var.m(rq8Var.c);
                                    uq8Var.k(recommendForumInfo.avatar);
                                    uq8Var.n(recommendForumInfo.forum_id.longValue());
                                    uq8Var.o(recommendForumInfo.forum_name);
                                    uq8Var.q(recommendForumInfo.member_count.intValue());
                                    uq8Var.u(recommendForumInfo.thread_count.intValue());
                                    uq8Var.s(recommendForumInfo.slogan);
                                    arrayList.add(uq8Var);
                                    a++;
                                }
                            }
                            vq8 vq8Var = new vq8();
                            vq8Var.d(rq8Var.b.intValue());
                            vq8Var.e(rq8Var.c);
                            arrayList.add(vq8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<hn> list2) {
        uq8 uq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (hn hnVar : list2) {
                if ((hnVar instanceof uq8) && (uq8Var = (uq8) hnVar) != null && uq8Var.b() == i) {
                    list.add(Long.valueOf(uq8Var.c()));
                }
            }
        }
    }

    public final void d(hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hnVar) == null) && (hnVar instanceof vq8)) {
            ((vq8) hnVar).f(false);
        }
    }
}
