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
/* loaded from: classes8.dex */
public class y66 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<yh> b;
    public List<yh> c;
    public List<yh> d;
    public List<yh> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948282160, "Lcom/baidu/tieba/y66;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948282160, "Lcom/baidu/tieba/y66;");
        }
    }

    public y66(TbPageContext tbPageContext) {
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
            List<yh> list = this.c;
            if (list != null) {
                list.clear();
            }
            List<yh> list2 = this.d;
            if (list2 != null) {
                list2.clear();
            }
            List<yh> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
            List<yh> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public List<yh> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final List<yh> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new u66());
                }
                if (!ListUtils.isEmpty(this.d)) {
                    g86 g86Var = new g86();
                    g86Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be9, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(g86Var);
                }
                if (!ListUtils.isEmpty(this.d)) {
                    for (yh yhVar : this.d) {
                        arrayList.add(yhVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<yh> g(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i += 3) {
                    w66 w66Var = new w66();
                    v56 v56Var = new v56();
                    v56Var.d = (ThreadData) list.get(i);
                    w66Var.a = v56Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        v56 v56Var2 = new v56();
                        v56Var2.d = (ThreadData) list.get(i2);
                        w66Var.b = v56Var2;
                    }
                    int i3 = i + 2;
                    if (i3 < size) {
                        v56 v56Var3 = new v56();
                        v56Var3.d = (ThreadData) list.get(i3);
                        w66Var.c = v56Var3;
                    }
                    arrayList.add(w66Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<yh> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g86 g86Var = new g86();
                g86Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bea, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(g86Var);
            }
            if (!ListUtils.isEmpty(this.c)) {
                arrayList.addAll(f());
            } else if (z) {
                f86 f86Var = new f86();
                f86Var.a = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(f86Var);
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

    public final List<yh> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                g86 g86Var = new g86();
                g86Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bee);
                arrayList.add(g86Var);
                arrayList.addAll(g(this.e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<yh> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.c)) {
                int size = this.c.size();
                for (int i = 0; i < size; i += 2) {
                    m66 m66Var = new m66();
                    v56 v56Var = new v56();
                    v56Var.d = (ThreadData) this.c.get(i);
                    v56Var.f = true;
                    m66Var.a = v56Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        v56 v56Var2 = new v56();
                        v56Var2.d = (ThreadData) this.c.get(i2);
                        m66Var.b = v56Var2;
                        v56Var2.g = true;
                    } else {
                        v56Var.f = false;
                        v56Var.h = true;
                    }
                    int i3 = size % 2;
                    if ((i3 == 0 && i == size - 2) || (i3 != 0 && i == size - 1)) {
                        m66Var.c = true;
                    }
                    arrayList.add(m66Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<yh> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<yh> c = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c)) {
                arrayList.addAll(c);
            }
            List<yh> b = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
            List<yh> d = d();
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
            yh yhVar = (yh) ListUtils.getItem(this.b, size);
            if (yhVar != null && yhVar.getClass().equals(cls)) {
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
            if (alaLiveTabMyConcernResponse.followStatus == 1 || x66.a(this.a) || !z) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
