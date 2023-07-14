package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ura implements yn {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<rra> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221989, "Lcom/baidu/tieba/ura;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221989, "Lcom/baidu/tieba/ura;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        b = gen;
    }

    public ura() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public final List<rra> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void b(qra qraVar, int i, String fid, String fname) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qraVar, i, fid, fname) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(fname, "fname");
            if (qraVar == null) {
                return;
            }
            this.a.clear();
            if (!ListUtils.isEmpty(qraVar.l())) {
                List<rra> list = this.a;
                ArrayList<rra> l = qraVar.l();
                Intrinsics.checkNotNull(l);
                list.addAll(l);
                for (rra rraVar : this.a) {
                    rraVar.v(i);
                    rraVar.t(fid);
                    rraVar.u(fname);
                    Integer g = qraVar.g();
                    Intrinsics.checkNotNull(g);
                    rraVar.z(g.intValue());
                }
            }
        }
    }
}
