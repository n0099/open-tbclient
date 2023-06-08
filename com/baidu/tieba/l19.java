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
public class l19 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947890165, "Lcom/baidu/tieba/l19;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947890165, "Lcom/baidu/tieba/l19;");
        }
    }

    public l19() {
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

    public void a(int i, g19 g19Var, int i2, List<vn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<e19> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), g19Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && g19Var != null && (list2 = g19Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<e19> list3 = g19Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (e19 e19Var : list3) {
                    if (e19Var != null && i == e19Var.b.intValue()) {
                        List<k19> list4 = e19Var.a;
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
                                            h19 h19Var = new h19();
                                            h19Var.l(e19Var.b.intValue());
                                            h19Var.k(recommendForumInfo.avatar);
                                            h19Var.n(recommendForumInfo.forum_id.longValue());
                                            h19Var.o(recommendForumInfo.forum_name);
                                            h19Var.p(recommendForumInfo.member_count.intValue());
                                            h19Var.t(recommendForumInfo.thread_count.intValue());
                                            h19Var.s(recommendForumInfo.slogan);
                                            h19Var.q(false);
                                            list.add(i2, h19Var);
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

    public List<vn> b(List<e19> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (e19 e19Var : list) {
                    if (e19Var != null) {
                        j19 j19Var = new j19();
                        j19Var.d(e19Var.b.intValue());
                        j19Var.c(e19Var.d);
                        j19Var.e(e19Var.c);
                        arrayList.add(j19Var);
                        List<k19> list2 = e19Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (k19 k19Var : list2) {
                                if (k19Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    h19 h19Var = new h19();
                                    RecommendForumInfo recommendForumInfo = k19Var.a;
                                    h19Var.l(e19Var.b.intValue());
                                    h19Var.m(e19Var.c);
                                    h19Var.k(recommendForumInfo.avatar);
                                    h19Var.n(recommendForumInfo.forum_id.longValue());
                                    h19Var.o(recommendForumInfo.forum_name);
                                    h19Var.p(recommendForumInfo.member_count.intValue());
                                    h19Var.t(recommendForumInfo.thread_count.intValue());
                                    h19Var.s(recommendForumInfo.slogan);
                                    arrayList.add(h19Var);
                                    a++;
                                }
                            }
                            i19 i19Var = new i19();
                            i19Var.d(e19Var.b.intValue());
                            i19Var.e(e19Var.c);
                            arrayList.add(i19Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<vn> list2) {
        h19 h19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (vn vnVar : list2) {
                if ((vnVar instanceof h19) && (h19Var = (h19) vnVar) != null && h19Var.b() == i) {
                    list.add(Long.valueOf(h19Var.c()));
                }
            }
        }
    }

    public final void d(vn vnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, vnVar) == null) && (vnVar instanceof i19)) {
            ((i19) vnVar).f(false);
        }
    }
}
