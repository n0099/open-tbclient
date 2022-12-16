package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class xx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public hy5 d;
    public List<xn> e;
    public boolean f;
    public String g;
    public String h;

    public xx5(ax5 ax5Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ax5Var, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f = false;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f = true;
        }
        this.g = str;
        this.h = str2;
        a(ax5Var);
    }

    public boolean a(ax5 ax5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ax5Var)) == null) {
            if (ax5Var == null) {
                return false;
            }
            boolean e = e(ax5Var.b);
            this.a = ax5Var.a;
            return e;
        }
        return invokeL.booleanValue;
    }

    public void g(hy5 hy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hy5Var) == null) {
            this.d = hy5Var;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List<String> list = this.b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.c;
            if (list2 != null) {
                list2.clear();
            }
            List<xn> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final ArrayList<xn> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                ww5 ww5Var = new ww5();
                jw5 jw5Var = new jw5();
                jw5Var.a = list.get(i);
                jw5Var.f = true;
                jw5Var.b = this.f;
                jw5Var.c = this.g;
                jw5Var.d = this.h;
                int i2 = i + 1;
                jw5Var.e = i2;
                ww5Var.a = jw5Var;
                if (i2 < size) {
                    jw5 jw5Var2 = new jw5();
                    jw5Var2.a = list.get(i2);
                    jw5Var2.b = this.f;
                    jw5Var2.c = this.g;
                    jw5Var2.d = this.h;
                    jw5Var2.e = i + 2;
                    ww5Var.b = jw5Var2;
                    jw5Var2.g = true;
                } else {
                    jw5Var.f = false;
                    jw5Var.h = true;
                }
                arrayList.add(ww5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<xn> d() {
        InterceptResult invokeV;
        l56 l56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                arrayList.addAll(this.e);
            }
            hy5 hy5Var = this.d;
            if (hy5Var != null && (l56Var = hy5Var.a) != null && !ListUtils.isEmpty(l56Var.c())) {
                arrayList.add(0, this.d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : list) {
                if (sdkLiveInfoData != null) {
                    String str = sdkLiveInfoData.liveId;
                    if (!this.b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.c.addAll(arrayList);
            ArrayList<xn> c = c(this.c);
            this.e = c;
            if (ListUtils.isEmpty(c)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
