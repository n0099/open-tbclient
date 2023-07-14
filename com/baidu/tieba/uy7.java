package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes8.dex */
public class uy7 implements yn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<ty7> b;
    public String c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948227414, "Lcom/baidu/tieba/uy7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948227414, "Lcom/baidu/tieba/uy7;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    public uy7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public List<ty7> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void c(Esport esport) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, esport) == null) && esport != null) {
            this.a = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.c = esportStatic.img;
                this.d = esportStatic.url;
            }
            this.b = new ArrayList();
            if (!StringUtils.isNull(this.c)) {
                ty7 ty7Var = new ty7();
                ty7Var.i(this.c);
                ty7Var.j(this.d);
                this.b.add(ty7Var);
            }
            if (!ListUtils.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    ty7 ty7Var2 = new ty7();
                    ty7Var2.h(esportRank);
                    this.b.add(ty7Var2);
                }
            }
        }
    }
}
