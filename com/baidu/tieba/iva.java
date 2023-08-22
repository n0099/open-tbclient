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
/* loaded from: classes6.dex */
public final class iva implements bn {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<fva> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947868341, "Lcom/baidu/tieba/iva;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947868341, "Lcom/baidu/tieba/iva;");
                return;
            }
        }
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        b = gen;
    }

    public iva() {
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

    public final List<fva> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void b(eva evaVar, int i, String fid, String fname) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, evaVar, i, fid, fname) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(fname, "fname");
            if (evaVar == null) {
                return;
            }
            this.a.clear();
            if (!ListUtils.isEmpty(evaVar.l())) {
                List<fva> list = this.a;
                ArrayList<fva> l = evaVar.l();
                Intrinsics.checkNotNull(l);
                list.addAll(l);
                for (fva fvaVar : this.a) {
                    fvaVar.v(i);
                    fvaVar.t(fid);
                    fvaVar.u(fname);
                    Integer g = evaVar.g();
                    Intrinsics.checkNotNull(g);
                    fvaVar.z(g.intValue());
                }
            }
        }
    }
}
