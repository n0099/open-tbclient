package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class xb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<bc9> a;

    public xb9() {
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
        this.a = new ArrayList<>();
    }

    public ArrayList<bc9> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean b(ExcContent excContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, excContent)) == null) {
            long longValue = excContent.type.longValue();
            if (longValue == 2 || longValue == 0 || longValue == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void c(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        ec9 ec9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, list) == null) && list != null && !list.isEmpty()) {
            loop0: while (true) {
                ec9Var = null;
                for (ExcContent excContent : list) {
                    if (excContent != null && excContent.type != null) {
                        if (b(excContent)) {
                            ac9 a = dc9.a(tbPageContext, excContent);
                            if (a == null) {
                                continue;
                            } else if (a.a()) {
                                if (ec9Var != null) {
                                    this.a.add(ec9Var);
                                }
                                this.a.add(a);
                            } else {
                                if (ec9Var == null) {
                                    ec9Var = new ec9();
                                }
                                ec9Var.c(a.b());
                            }
                        } else {
                            if (ec9Var != null) {
                                this.a.add(ec9Var);
                            }
                            this.a.add(dc9.b(excContent));
                        }
                    }
                }
                break loop0;
            }
            if (ec9Var != null) {
                this.a.add(ec9Var);
            }
        }
    }
}
