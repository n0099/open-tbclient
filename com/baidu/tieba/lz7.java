package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lz7 extends kz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz7(im5 im5Var) {
        super(im5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {im5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((im5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
