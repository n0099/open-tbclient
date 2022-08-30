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
/* loaded from: classes6.dex */
public abstract class yl8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<zl8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public yl8() {
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

    public am8 addObserver(String str, am8 am8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, am8Var, z)) == null) {
            if (am8Var == null) {
                am8Var = new am8();
            }
            if (this.mNotificationNameList.contains(str)) {
                am8Var.n(false);
                am8Var.s(true);
                List<zl8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                zl8 zl8Var = new zl8();
                zl8Var.e(am8Var.c());
                zl8Var.d(z);
                zl8Var.f(am8Var.e());
                list.add(zl8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return am8Var;
        }
        return (am8) invokeLLZ.objValue;
    }

    public abstract am8 dispatch(cm8 cm8Var, am8 am8Var);

    public abstract List<am8> processNotification(String str, HashMap hashMap);
}
