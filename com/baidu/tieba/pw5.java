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
/* loaded from: classes5.dex */
public class pw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<String> b;
    public List<SdkLiveInfoData> c;
    public zw5 d;
    public List<wn> e;
    public boolean f;
    public String g;
    public String h;

    public pw5(sv5 sv5Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sv5Var, str, str2};
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
        a(sv5Var);
    }

    public boolean a(sv5 sv5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sv5Var)) == null) {
            if (sv5Var == null) {
                return false;
            }
            boolean e = e(sv5Var.b);
            this.a = sv5Var.a;
            return e;
        }
        return invokeL.booleanValue;
    }

    public void g(zw5 zw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zw5Var) == null) {
            this.d = zw5Var;
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
            List<wn> list3 = this.e;
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

    public final ArrayList<wn> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<wn> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                ov5 ov5Var = new ov5();
                bv5 bv5Var = new bv5();
                bv5Var.a = list.get(i);
                bv5Var.f = true;
                bv5Var.b = this.f;
                bv5Var.c = this.g;
                bv5Var.d = this.h;
                int i2 = i + 1;
                bv5Var.e = i2;
                ov5Var.a = bv5Var;
                if (i2 < size) {
                    bv5 bv5Var2 = new bv5();
                    bv5Var2.a = list.get(i2);
                    bv5Var2.b = this.f;
                    bv5Var2.c = this.g;
                    bv5Var2.d = this.h;
                    bv5Var2.e = i + 2;
                    ov5Var.b = bv5Var2;
                    bv5Var2.g = true;
                } else {
                    bv5Var.f = false;
                    bv5Var.h = true;
                }
                arrayList.add(ov5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<wn> d() {
        InterceptResult invokeV;
        d46 d46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                arrayList.addAll(this.e);
            }
            zw5 zw5Var = this.d;
            if (zw5Var != null && (d46Var = zw5Var.a) != null && !ListUtils.isEmpty(d46Var.c())) {
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
            ArrayList<wn> c = c(this.c);
            this.e = c;
            if (ListUtils.isEmpty(c)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
