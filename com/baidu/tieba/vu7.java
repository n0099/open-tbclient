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
public class vu7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948253361, "Lcom/baidu/tieba/vu7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948253361, "Lcom/baidu/tieba/vu7;");
        }
    }

    public vu7() {
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

    public void a(int i, qu7 qu7Var, int i2, List<wn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<ou7> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), qu7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && qu7Var != null && (list2 = qu7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ou7> list3 = qu7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ou7 ou7Var : list3) {
                    if (ou7Var != null && i == ou7Var.b.intValue()) {
                        List<uu7> list4 = ou7Var.a;
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
                                            ru7 ru7Var = new ru7();
                                            ru7Var.n(ou7Var.b.intValue());
                                            ru7Var.l(recommendForumInfo.avatar);
                                            ru7Var.q(recommendForumInfo.forum_id.longValue());
                                            ru7Var.r(recommendForumInfo.forum_name);
                                            ru7Var.s(recommendForumInfo.member_count.intValue());
                                            ru7Var.w(recommendForumInfo.thread_count.intValue());
                                            ru7Var.v(recommendForumInfo.slogan);
                                            ru7Var.t(false);
                                            list.add(i2, ru7Var);
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

    public List<wn> b(List<ou7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ou7 ou7Var : list) {
                    if (ou7Var != null) {
                        tu7 tu7Var = new tu7();
                        tu7Var.f(ou7Var.b.intValue());
                        tu7Var.c(ou7Var.d);
                        tu7Var.g(ou7Var.c);
                        arrayList.add(tu7Var);
                        List<uu7> list2 = ou7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (uu7 uu7Var : list2) {
                                if (uu7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    ru7 ru7Var = new ru7();
                                    RecommendForumInfo recommendForumInfo = uu7Var.a;
                                    ru7Var.n(ou7Var.b.intValue());
                                    ru7Var.o(ou7Var.c);
                                    ru7Var.l(recommendForumInfo.avatar);
                                    ru7Var.q(recommendForumInfo.forum_id.longValue());
                                    ru7Var.r(recommendForumInfo.forum_name);
                                    ru7Var.s(recommendForumInfo.member_count.intValue());
                                    ru7Var.w(recommendForumInfo.thread_count.intValue());
                                    ru7Var.v(recommendForumInfo.slogan);
                                    arrayList.add(ru7Var);
                                    a++;
                                }
                            }
                            su7 su7Var = new su7();
                            su7Var.f(ou7Var.b.intValue());
                            su7Var.g(ou7Var.c);
                            arrayList.add(su7Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<wn> list2) {
        ru7 ru7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (wn wnVar : list2) {
                if ((wnVar instanceof ru7) && (ru7Var = (ru7) wnVar) != null && ru7Var.b() == i) {
                    list.add(Long.valueOf(ru7Var.c()));
                }
            }
        }
    }

    public final void d(wn wnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wnVar) == null) && (wnVar instanceof su7)) {
            ((su7) wnVar).h(false);
        }
    }
}
