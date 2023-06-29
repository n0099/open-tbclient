package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.tieba.av5;
import com.baidu.tieba.zu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xt5<Q extends zu5, P extends av5> implements yt5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;

    public xt5() {
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

    @Override // com.baidu.tieba.yt5
    public void a(Q q, P p) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, q, p) != null) || p == null) {
            return;
        }
        if (p.getPageInfo() != null) {
            uu5 pageInfo = p.getPageInfo();
            this.c = pageInfo.a;
            this.a = pageInfo.b;
            if (q != null && q.c() != null) {
                q.c().d = pageInfo.c;
            }
        }
        if (this.c <= 0 && q != null && q.c() != null && q.c().c > 0) {
            this.c = q.c().c;
            this.a = true;
        }
        pv5.b("onResp--->pn=" + this.c + ",hasMore=" + this.a);
    }

    @Override // com.baidu.tieba.yt5
    public void b(Q q, boolean z) {
        LoadType loadType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q, z) == null) && q != null && q.c() != null) {
            tu5 c = q.c();
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
            pv5.b("onReq--->pn=" + this.c + ",hasMore=" + this.a + ",isPullRefresh=" + z + ",loadType=" + c.b);
        }
    }
}
