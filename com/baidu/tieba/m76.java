package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes7.dex */
public class m76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<q76> a;
    public List<q76> b;

    public m76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<q76> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(List<q76> list, nf5 nf5Var) {
        InterceptResult invokeLL;
        List<nf5> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, nf5Var)) == null) {
            if (list != null && nf5Var != null) {
                for (q76 q76Var : list) {
                    if (q76Var != null && (a = q76Var.a()) != null) {
                        for (nf5 nf5Var2 : a) {
                            if (nf5Var2 != null && nf5Var2.d() == nf5Var.d()) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean c(DataRes dataRes) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes)) == null) {
            if (dataRes != null && dataRes.robots_list != null) {
                this.b = new ArrayList();
                z = false;
                for (robotsList robotslist : dataRes.robots_list) {
                    if (TextUtils.isEmpty(robotslist.key)) {
                        z = true;
                    } else {
                        q76 q76Var = new q76();
                        q76Var.d(robotslist);
                        this.b.add(q76Var);
                    }
                }
            } else {
                z = false;
            }
            if (dataRes != null && dataRes.address_list != null) {
                this.a = new ArrayList();
                for (listData listdata : dataRes.address_list) {
                    if (TextUtils.isEmpty(listdata.key)) {
                        z = true;
                    } else {
                        q76 q76Var2 = new q76();
                        q76Var2.c(listdata);
                        if (q76Var2.a() != null) {
                            for (nf5 nf5Var : q76Var2.a()) {
                                if (b(this.b, nf5Var)) {
                                    nf5Var.q(1);
                                } else {
                                    nf5Var.q(0);
                                }
                            }
                        }
                        this.a.add(q76Var2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
