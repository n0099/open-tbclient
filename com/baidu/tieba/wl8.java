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
public abstract class wl8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<xl8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public wl8() {
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

    public yl8 addObserver(String str, yl8 yl8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, yl8Var, z)) == null) {
            if (yl8Var == null) {
                yl8Var = new yl8();
            }
            if (this.mNotificationNameList.contains(str)) {
                yl8Var.n(false);
                yl8Var.s(true);
                List<xl8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                xl8 xl8Var = new xl8();
                xl8Var.e(yl8Var.c());
                xl8Var.d(z);
                xl8Var.f(yl8Var.e());
                list.add(xl8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return yl8Var;
        }
        return (yl8) invokeLLZ.objValue;
    }

    public abstract yl8 dispatch(am8 am8Var, yl8 yl8Var);

    public abstract List<yl8> processNotification(String str, HashMap hashMap);
}
