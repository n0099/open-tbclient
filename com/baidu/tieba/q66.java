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
public class q66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<u66> a;
    public List<u66> b;

    public q66() {
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

    public List<u66> a() {
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

    public final boolean b(List<u66> list, df5 df5Var) {
        InterceptResult invokeLL;
        List<df5> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, df5Var)) == null) {
            if (list != null && df5Var != null) {
                for (u66 u66Var : list) {
                    if (u66Var != null && (a = u66Var.a()) != null) {
                        for (df5 df5Var2 : a) {
                            if (df5Var2 != null && df5Var2.d() == df5Var.d()) {
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
                        u66 u66Var = new u66();
                        u66Var.d(robotslist);
                        this.b.add(u66Var);
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
                        u66 u66Var2 = new u66();
                        u66Var2.c(listdata);
                        if (u66Var2.a() != null) {
                            for (df5 df5Var : u66Var2.a()) {
                                if (b(this.b, df5Var)) {
                                    df5Var.q(1);
                                } else {
                                    df5Var.q(0);
                                }
                            }
                        }
                        this.a.add(u66Var2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
