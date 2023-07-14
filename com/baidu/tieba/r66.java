package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class r66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r66 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public o66 b;
    public q66 c;
    public List<StatisticItem> d;

    public r66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(1);
        this.a.add(2);
        q66 q66Var = new q66();
        this.c = q66Var;
        this.b = new o66(q66Var, this.a);
        g(da5.p().q("key_abtest_channel", 0));
    }

    public static r66 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (q66.class) {
                    if (e == null) {
                        e = new r66();
                    }
                }
            }
            return e;
        }
        return (r66) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, statisticItem) != null) || statisticItem == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(statisticItem);
    }

    public void d(String str) {
        q66 q66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (xi.isEmpty(str) || (q66Var = this.c) == null || !q66Var.g()) {
                u4b.d(str);
            }
        }
    }

    public void e(String str) {
        q66 q66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (xi.isEmpty(str) || (q66Var = this.c) == null || !q66Var.g()) {
                u4b.e(str);
            }
        }
    }

    public void f(String str) {
        o66 o66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (o66Var = this.b) != null) {
            o66Var.b(str);
        }
    }

    public void g(int i) {
        q66 q66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (q66Var = this.c) != null) {
            q66Var.k(i);
        }
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            o66 o66Var = this.b;
            if (o66Var == null) {
                return 0;
            }
            return o66Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void h(String str, String str2) {
        q66 q66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && !ListUtils.isEmpty(this.d) && (q66Var = this.c) != null && q66Var.g()) {
            int i = -1;
            for (StatisticItem statisticItem : this.d) {
                if (statisticItem != null) {
                    if (statisticItem.getPosition() == 0) {
                        i(str, str2, statisticItem);
                    } else if (i != statisticItem.getPosition()) {
                        i = statisticItem.getPosition();
                        i(str, str2, statisticItem);
                    }
                }
            }
            this.d.clear();
        }
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        q66 q66Var;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) && statisticItem != null && (q66Var = this.c) != null && q66Var.g()) {
            HashMap hashMap = new HashMap();
            List<Object> params = statisticItem.getParams();
            if (params != null) {
                int size = params.size();
                for (int i = 0; i < size; i += 2) {
                    Object obj = params.get(i);
                    if (obj == null) {
                        str3 = "";
                    } else {
                        str3 = obj.toString();
                    }
                    Object obj2 = params.get(i + 1);
                    if (obj2 == null) {
                        str4 = "";
                    } else {
                        str4 = obj2.toString();
                    }
                    hashMap.put(str3, str4);
                }
            }
            u4b.c(str2 + statisticItem.getKey(), str, "", hashMap);
        }
    }
}
