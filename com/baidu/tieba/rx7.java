package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rx7 extends qx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx7(dl5 dl5Var) {
        super(dl5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dl5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((dl5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
