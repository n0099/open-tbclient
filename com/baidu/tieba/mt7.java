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
import java.util.Iterator;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class mt7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947984281, "Lcom/baidu/tieba/mt7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947984281, "Lcom/baidu/tieba/mt7;");
        }
    }

    public mt7() {
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

    public void a(int i, ht7 ht7Var, int i2, List list, BdTypeRecyclerView bdTypeRecyclerView) {
        List list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ht7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && ht7Var != null && (list2 = ht7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ft7> list3 = ht7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ft7 ft7Var : list3) {
                    if (ft7Var != null && i == ft7Var.b.intValue()) {
                        List list4 = ft7Var.a;
                        if (list4 != null && list4.size() > 0) {
                            for (int i4 = 0; i4 < list4.size(); i4++) {
                                if (list4.get(i4) != null) {
                                    if (arrayList.size() >= 20) {
                                        d((eo) list.get(i2));
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else if (i3 >= 4) {
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else {
                                        if (i4 == list4.size() - 1) {
                                            d((eo) list.get(i2));
                                        }
                                        RecommendForumInfo recommendForumInfo = ((lt7) list4.get(i4)).a;
                                        if (!arrayList.contains(recommendForumInfo.forum_id)) {
                                            it7 it7Var = new it7();
                                            it7Var.n(ft7Var.b.intValue());
                                            it7Var.l(recommendForumInfo.avatar);
                                            it7Var.q(recommendForumInfo.forum_id.longValue());
                                            it7Var.r(recommendForumInfo.forum_name);
                                            it7Var.s(recommendForumInfo.member_count.intValue());
                                            it7Var.w(recommendForumInfo.thread_count.intValue());
                                            it7Var.v(recommendForumInfo.slogan);
                                            it7Var.t(false);
                                            list.add(i2, it7Var);
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

    public List b(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ft7 ft7Var = (ft7) it.next();
                    if (ft7Var != null) {
                        kt7 kt7Var = new kt7();
                        kt7Var.f(ft7Var.b.intValue());
                        kt7Var.c(ft7Var.d);
                        kt7Var.g(ft7Var.c);
                        arrayList.add(kt7Var);
                        List<lt7> list2 = ft7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (lt7 lt7Var : list2) {
                                if (lt7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    it7 it7Var = new it7();
                                    RecommendForumInfo recommendForumInfo = lt7Var.a;
                                    it7Var.n(ft7Var.b.intValue());
                                    it7Var.o(ft7Var.c);
                                    it7Var.l(recommendForumInfo.avatar);
                                    it7Var.q(recommendForumInfo.forum_id.longValue());
                                    it7Var.r(recommendForumInfo.forum_name);
                                    it7Var.s(recommendForumInfo.member_count.intValue());
                                    it7Var.w(recommendForumInfo.thread_count.intValue());
                                    it7Var.v(recommendForumInfo.slogan);
                                    arrayList.add(it7Var);
                                    a++;
                                }
                            }
                            jt7 jt7Var = new jt7();
                            jt7Var.f(ft7Var.b.intValue());
                            jt7Var.g(ft7Var.c);
                            arrayList.add(jt7Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List list, List list2) {
        it7 it7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if ((eoVar instanceof it7) && (it7Var = (it7) eoVar) != null && it7Var.b() == i) {
                    list.add(Long.valueOf(it7Var.c()));
                }
            }
        }
    }

    public final void d(eo eoVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, eoVar) == null) && (eoVar instanceof jt7)) {
            ((jt7) eoVar).h(false);
        }
    }
}
