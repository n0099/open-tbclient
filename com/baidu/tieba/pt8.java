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
public class pt8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948073685, "Lcom/baidu/tieba/pt8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948073685, "Lcom/baidu/tieba/pt8;");
        }
    }

    public pt8() {
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

    public void a(int i, kt8 kt8Var, int i2, List<in> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<it8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), kt8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && kt8Var != null && (list2 = kt8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<it8> list3 = kt8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (it8 it8Var : list3) {
                    if (it8Var != null && i == it8Var.b.intValue()) {
                        List<ot8> list4 = it8Var.a;
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
                                            lt8 lt8Var = new lt8();
                                            lt8Var.k(it8Var.b.intValue());
                                            lt8Var.j(recommendForumInfo.avatar);
                                            lt8Var.n(recommendForumInfo.forum_id.longValue());
                                            lt8Var.o(recommendForumInfo.forum_name);
                                            lt8Var.p(recommendForumInfo.member_count.intValue());
                                            lt8Var.t(recommendForumInfo.thread_count.intValue());
                                            lt8Var.r(recommendForumInfo.slogan);
                                            lt8Var.q(false);
                                            list.add(i2, lt8Var);
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

    public List<in> b(List<it8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (it8 it8Var : list) {
                    if (it8Var != null) {
                        nt8 nt8Var = new nt8();
                        nt8Var.d(it8Var.b.intValue());
                        nt8Var.c(it8Var.d);
                        nt8Var.e(it8Var.c);
                        arrayList.add(nt8Var);
                        List<ot8> list2 = it8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (ot8 ot8Var : list2) {
                                if (ot8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    lt8 lt8Var = new lt8();
                                    RecommendForumInfo recommendForumInfo = ot8Var.a;
                                    lt8Var.k(it8Var.b.intValue());
                                    lt8Var.m(it8Var.c);
                                    lt8Var.j(recommendForumInfo.avatar);
                                    lt8Var.n(recommendForumInfo.forum_id.longValue());
                                    lt8Var.o(recommendForumInfo.forum_name);
                                    lt8Var.p(recommendForumInfo.member_count.intValue());
                                    lt8Var.t(recommendForumInfo.thread_count.intValue());
                                    lt8Var.r(recommendForumInfo.slogan);
                                    arrayList.add(lt8Var);
                                    a++;
                                }
                            }
                            mt8 mt8Var = new mt8();
                            mt8Var.d(it8Var.b.intValue());
                            mt8Var.e(it8Var.c);
                            arrayList.add(mt8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<in> list2) {
        lt8 lt8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (in inVar : list2) {
                if ((inVar instanceof lt8) && (lt8Var = (lt8) inVar) != null && lt8Var.b() == i) {
                    list.add(Long.valueOf(lt8Var.c()));
                }
            }
        }
    }

    public final void d(in inVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, inVar) == null) && (inVar instanceof mt8)) {
            ((mt8) inVar).f(false);
        }
    }
}
