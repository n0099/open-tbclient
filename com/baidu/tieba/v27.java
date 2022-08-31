package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class v27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    public v27() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public u27 a(boolean z, s27 s27Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, s27Var)) == null) {
            u27 u27Var = new u27();
            u27Var.c = s27Var.i();
            u27Var.e = s27Var.a();
            u27Var.f = s27Var.c();
            ArrayList<ThreadData> h = s27Var.h();
            if (z) {
                if (!ListUtils.isEmpty(h)) {
                    this.a.clear();
                    this.a.addAll(h);
                }
            } else if (!ListUtils.isEmpty(h)) {
                this.a.addAll(h);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            r17.h(true, arrayList, s27Var.e());
            r17.h(true, arrayList, s27Var.f());
            r17.h(true, arrayList, s27Var.d());
            r17.h(true, arrayList, s27Var.g());
            u27Var.a = r17.c(arrayList);
            return u27Var;
        }
        return (u27) invokeZL.objValue;
    }

    public List<ThreadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
