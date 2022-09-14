package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class kn8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<ln8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public kn8() {
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

    public mn8 addObserver(String str, mn8 mn8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, mn8Var, z)) == null) {
            if (mn8Var == null) {
                mn8Var = new mn8();
            }
            if (this.mNotificationNameList.contains(str)) {
                mn8Var.n(false);
                mn8Var.s(true);
                List<ln8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ln8 ln8Var = new ln8();
                ln8Var.e(mn8Var.c());
                ln8Var.d(z);
                ln8Var.f(mn8Var.e());
                list.add(ln8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return mn8Var;
        }
        return (mn8) invokeLLZ.objValue;
    }

    public abstract mn8 dispatch(on8 on8Var, mn8 mn8Var);

    public abstract List<mn8> processNotification(String str, HashMap hashMap);
}
