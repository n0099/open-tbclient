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
public abstract class zn8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<ao8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public zn8() {
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

    public bo8 addObserver(String str, bo8 bo8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, bo8Var, z)) == null) {
            if (bo8Var == null) {
                bo8Var = new bo8();
            }
            if (this.mNotificationNameList.contains(str)) {
                bo8Var.n(false);
                bo8Var.s(true);
                List<ao8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ao8 ao8Var = new ao8();
                ao8Var.e(bo8Var.c());
                ao8Var.d(z);
                ao8Var.f(bo8Var.e());
                list.add(ao8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return bo8Var;
        }
        return (bo8) invokeLLZ.objValue;
    }

    public abstract bo8 dispatch(do8 do8Var, bo8 bo8Var);

    public abstract List<bo8> processNotification(String str, HashMap hashMap);
}
