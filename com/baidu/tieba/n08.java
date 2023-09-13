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
/* loaded from: classes7.dex */
public class n08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;
    public fd9 b;

    public n08() {
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

    public final void a(s98 s98Var) {
        fd9 fd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, s98Var) == null) && (fd9Var = this.b) != null && !ListUtils.isEmpty(fd9Var.b)) {
            s98Var.a.add(0, this.b);
        }
    }

    public s98 b(int i, boolean z, m08 m08Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), m08Var})) == null) {
            s98 s98Var = new s98();
            s98Var.c = m08Var.f();
            s98Var.e = m08Var.a();
            s98Var.f = m08Var.b();
            ArrayList<ThreadData> e = m08Var.e();
            if (z) {
                this.b = m08Var.d();
                if (!ListUtils.isEmpty(e)) {
                    this.a.clear();
                    this.a.addAll(e);
                    s98Var.d = 1;
                }
            } else if (!ListUtils.isEmpty(e)) {
                this.a.addAll(e);
                s98Var.d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            p88.e(true, arrayList, m08Var.c());
            s98Var.a = p88.c(arrayList);
            a(s98Var);
            fd9 fd9Var = this.b;
            if (fd9Var != null && fd9Var.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                s98Var.a.add(0, new p98());
            }
            return s98Var;
        }
        return (s98) invokeCommon.objValue;
    }
}
