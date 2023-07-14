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
/* loaded from: classes7.dex */
public class od6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public yd6 d;
    public List<yn> e;
    public boolean f;
    public String g;
    public String h;

    public od6(rc6 rc6Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rc6Var, str, str2};
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
        a(rc6Var);
    }

    public boolean a(rc6 rc6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rc6Var)) == null) {
            if (rc6Var == null) {
                return false;
            }
            boolean e = e(rc6Var.b);
            this.a = rc6Var.a;
            return e;
        }
        return invokeL.booleanValue;
    }

    public void g(yd6 yd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yd6Var) == null) {
            this.d = yd6Var;
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
            List<yn> list3 = this.e;
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

    public final ArrayList<yn> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<yn> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                nc6 nc6Var = new nc6();
                ac6 ac6Var = new ac6();
                ac6Var.a = list.get(i);
                ac6Var.f = true;
                ac6Var.b = this.f;
                ac6Var.c = this.g;
                ac6Var.d = this.h;
                int i2 = i + 1;
                ac6Var.e = i2;
                nc6Var.a = ac6Var;
                if (i2 < size) {
                    ac6 ac6Var2 = new ac6();
                    ac6Var2.a = list.get(i2);
                    ac6Var2.b = this.f;
                    ac6Var2.c = this.g;
                    ac6Var2.d = this.h;
                    ac6Var2.e = i + 2;
                    nc6Var.b = ac6Var2;
                    ac6Var2.g = true;
                } else {
                    ac6Var.f = false;
                    ac6Var.h = true;
                }
                arrayList.add(nc6Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<yn> d() {
        InterceptResult invokeV;
        yp6 yp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                arrayList.addAll(this.e);
            }
            yd6 yd6Var = this.d;
            if (yd6Var != null && (yp6Var = yd6Var.a) != null && !ListUtils.isEmpty(yp6Var.c())) {
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
            ArrayList<yn> c = c(this.c);
            this.e = c;
            if (ListUtils.isEmpty(c)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
