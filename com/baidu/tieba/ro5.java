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
/* loaded from: classes5.dex */
public class ro5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ro5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public oo5 b;
    public qo5 c;
    public List<StatisticItem> d;

    public ro5() {
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
        qo5 qo5Var = new qo5();
        this.c = qo5Var;
        this.b = new oo5(qo5Var, this.a);
        g(ox4.k().l("key_abtest_channel", 0));
    }

    public static ro5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (qo5.class) {
                    if (e == null) {
                        e = new ro5();
                    }
                }
            }
            return e;
        }
        return (ro5) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(statisticItem);
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            oo5 oo5Var = this.b;
            if (oo5Var == null) {
                return 0;
            }
            return oo5Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (dj.isEmpty(str) || (qo5Var = this.c) == null || !qo5Var.g()) {
                fb9.d(str);
            }
        }
    }

    public void e(String str) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (dj.isEmpty(str) || (qo5Var = this.c) == null || !qo5Var.g()) {
                fb9.e(str);
            }
        }
    }

    public void f(String str) {
        oo5 oo5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (oo5Var = this.b) == null) {
            return;
        }
        oo5Var.b(str);
    }

    public void g(int i) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (qo5Var = this.c) == null) {
            return;
        }
        qo5Var.k(i);
    }

    public void h(String str, String str2) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.d) || (qo5Var = this.c) == null || !qo5Var.g()) {
            return;
        }
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

    public void i(String str, String str2, StatisticItem statisticItem) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (qo5Var = this.c) == null || !qo5Var.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = params.get(i);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        fb9.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
