package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class lc6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<cn> b;
    public List<cn> c;
    public List<cn> d;
    public List<cn> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947938122, "Lcom/baidu/tieba/lc6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947938122, "Lcom/baidu/tieba/lc6;");
        }
    }

    public lc6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<cn> list = this.c;
            if (list != null) {
                list.clear();
            }
            List<cn> list2 = this.d;
            if (list2 != null) {
                list2.clear();
            }
            List<cn> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
            List<cn> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public List<cn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final List<cn> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new hc6());
                }
                if (!ListUtils.isEmpty(this.d)) {
                    td6 td6Var = new td6();
                    td6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bda, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(td6Var);
                }
                if (!ListUtils.isEmpty(this.d)) {
                    for (cn cnVar : this.d) {
                        arrayList.add(cnVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<cn> g(List<cn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i += 3) {
                    jc6 jc6Var = new jc6();
                    ib6 ib6Var = new ib6();
                    ib6Var.d = (ThreadData) list.get(i);
                    jc6Var.a = ib6Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        ib6 ib6Var2 = new ib6();
                        ib6Var2.d = (ThreadData) list.get(i2);
                        jc6Var.b = ib6Var2;
                    }
                    int i3 = i + 2;
                    if (i3 < size) {
                        ib6 ib6Var3 = new ib6();
                        ib6Var3.d = (ThreadData) list.get(i3);
                        jc6Var.c = ib6Var3;
                    }
                    arrayList.add(jc6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<cn> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                td6 td6Var = new td6();
                td6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bdb, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(td6Var);
            }
            if (!ListUtils.isEmpty(this.c)) {
                arrayList.addAll(f());
            } else if (z) {
                sd6 sd6Var = new sd6();
                sd6Var.a = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(sd6Var);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void e(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, alaLiveTabMyConcernResponse, z) != null) || alaLiveTabMyConcernResponse == null) {
            return;
        }
        if (z) {
            this.b.clear();
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList)) {
            this.c.addAll(alaLiveTabMyConcernResponse.followList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
            this.d.addAll(alaLiveTabMyConcernResponse.followCloseList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
            this.e.addAll(alaLiveTabMyConcernResponse.recommendList);
        }
        this.b = i(alaLiveTabMyConcernResponse, z);
    }

    public final List<cn> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                td6 td6Var = new td6();
                td6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bdf);
                arrayList.add(td6Var);
                arrayList.addAll(g(this.e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<cn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.c)) {
                int size = this.c.size();
                for (int i = 0; i < size; i += 2) {
                    zb6 zb6Var = new zb6();
                    ib6 ib6Var = new ib6();
                    ib6Var.d = (ThreadData) this.c.get(i);
                    ib6Var.f = true;
                    zb6Var.a = ib6Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        ib6 ib6Var2 = new ib6();
                        ib6Var2.d = (ThreadData) this.c.get(i2);
                        zb6Var.b = ib6Var2;
                        ib6Var2.g = true;
                    } else {
                        ib6Var.f = false;
                        ib6Var.h = true;
                    }
                    int i3 = size % 2;
                    if ((i3 == 0 && i == size - 2) || (i3 != 0 && i == size - 1)) {
                        zb6Var.c = true;
                    }
                    arrayList.add(zb6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<cn> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<cn> c = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c)) {
                arrayList.addAll(c);
            }
            List<cn> b = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
            List<cn> d = d();
            if (!ListUtils.isEmpty(d)) {
                arrayList.addAll(d);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void j(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, cls) != null) || ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int size = this.b.size() - 1; size >= 0; size--) {
            cn cnVar = (cn) ListUtils.getItem(this.b, size);
            if (cnVar != null && cnVar.getClass().equals(cls)) {
                this.b.remove(size);
            }
        }
    }

    public final boolean k(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, alaLiveTabMyConcernResponse)) == null) {
            if (alaLiveTabMyConcernResponse == null) {
                return false;
            }
            if (System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L) > f) {
                z = true;
            } else {
                z = false;
            }
            if (alaLiveTabMyConcernResponse.followStatus == 1 || kc6.a(this.a) || !z) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
