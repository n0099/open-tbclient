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
/* loaded from: classes5.dex */
public abstract class pp8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<qp8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public abstract rp8 dispatch(tp8 tp8Var, rp8 rp8Var);

    public abstract List<rp8> processNotification(String str, HashMap hashMap);

    public pp8() {
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

    public rp8 addObserver(String str, rp8 rp8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, rp8Var, z)) == null) {
            if (rp8Var == null) {
                rp8Var = new rp8();
            }
            if (this.mNotificationNameList.contains(str)) {
                rp8Var.n(false);
                rp8Var.s(true);
                List<qp8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                qp8 qp8Var = new qp8();
                qp8Var.e(rp8Var.c());
                qp8Var.d(z);
                qp8Var.f(rp8Var.e());
                list.add(qp8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return rp8Var;
        }
        return (rp8) invokeLLZ.objValue;
    }
}
