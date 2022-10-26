package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class te5 implements ue5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;

    public te5() {
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
        this.a = true;
        this.b = 1;
        this.c = 1;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ue5
    public void a(vf5 vf5Var, wf5 wf5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, vf5Var, wf5Var) != null) || wf5Var == null) {
            return;
        }
        if (wf5Var.getPageInfo() != null) {
            qf5 pageInfo = wf5Var.getPageInfo();
            this.c = pageInfo.a;
            this.a = pageInfo.b;
            if (vf5Var != null && vf5Var.c() != null) {
                vf5Var.c().d = pageInfo.c;
            }
        }
        if (this.c <= 0 && vf5Var != null && vf5Var.c() != null && vf5Var.c().c > 0) {
            this.c = vf5Var.c().c;
            this.a = true;
        }
        lg5.b("onResp--->pn=" + this.c + ",hasMore=" + this.a);
    }

    @Override // com.baidu.tieba.ue5
    public void b(vf5 vf5Var, boolean z) {
        LoadType loadType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vf5Var, z) == null) && vf5Var != null && vf5Var.c() != null) {
            pf5 c = vf5Var.c();
            if (z) {
                if (!c.a()) {
                    this.c = this.b;
                }
                if (c.a()) {
                    loadType = LoadType.PREPEND;
                } else {
                    loadType = LoadType.REFRESH;
                }
                c.b = loadType;
                c.c = this.c;
            } else {
                int i = this.c + 1;
                this.c = i;
                c.b = LoadType.APPEND;
                c.c = i;
            }
            lg5.b("onReq--->pn=" + this.c + ",hasMore=" + this.a + ",isPullRefresh=" + z + ",loadType=" + c.b);
        }
    }
}
