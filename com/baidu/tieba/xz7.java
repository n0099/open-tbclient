package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;
    public aa9 b;

    public xz7() {
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

    public List<ThreadData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }

    public final void a(q88 q88Var) {
        aa9 aa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, q88Var) == null) && (aa9Var = this.b) != null && !ListUtils.isEmpty(aa9Var.b)) {
            q88Var.a.add(0, this.b);
        }
    }

    public q88 b(int i, boolean z, wz7 wz7Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), wz7Var})) == null) {
            q88 q88Var = new q88();
            q88Var.c = wz7Var.f();
            q88Var.e = wz7Var.a();
            q88Var.f = wz7Var.b();
            ArrayList<ThreadData> e = wz7Var.e();
            if (z) {
                this.b = wz7Var.d();
                if (!ListUtils.isEmpty(e)) {
                    this.a.clear();
                    this.a.addAll(e);
                    q88Var.d = 1;
                }
            } else if (!ListUtils.isEmpty(e)) {
                this.a.addAll(e);
                q88Var.d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            n78.e(true, arrayList, wz7Var.c());
            q88Var.a = n78.c(arrayList);
            a(q88Var);
            aa9 aa9Var = this.b;
            if (aa9Var != null && aa9Var.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                q88Var.a.add(0, new n88());
            }
            return q88Var;
        }
        return (q88) invokeCommon.objValue;
    }
}
