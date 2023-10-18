package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes8.dex */
public class wz5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wz5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public tz5 b;
    public vz5 c;
    public List<StatisticItem> d;

    public wz5() {
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
        vz5 vz5Var = new vz5();
        this.c = vz5Var;
        this.b = new tz5(vz5Var, this.a);
        g(SharedPrefHelper.getInstance().getInt("key_abtest_channel", 0));
    }

    public static wz5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (vz5.class) {
                    if (e == null) {
                        e = new wz5();
                    }
                }
            }
            return e;
        }
        return (wz5) invokeV.objValue;
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
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (ad.isEmpty(str) || (vz5Var = this.c) == null || !vz5Var.g()) {
                k9b.d(str);
            }
        }
    }

    public void e(String str) {
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (ad.isEmpty(str) || (vz5Var = this.c) == null || !vz5Var.g()) {
                k9b.e(str);
            }
        }
    }

    public void f(String str) {
        tz5 tz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (tz5Var = this.b) != null) {
            tz5Var.b(str);
        }
    }

    public void g(int i) {
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (vz5Var = this.c) != null) {
            vz5Var.k(i);
        }
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            tz5 tz5Var = this.b;
            if (tz5Var == null) {
                return 0;
            }
            return tz5Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void h(String str, String str2) {
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && !ListUtils.isEmpty(this.d) && (vz5Var = this.c) != null && vz5Var.g()) {
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
        vz5 vz5Var;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) && statisticItem != null && (vz5Var = this.c) != null && vz5Var.g()) {
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
            k9b.c(str2 + statisticItem.getKey(), str, "", hashMap);
        }
    }
}
