package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jb9 extends ib9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb9(w16 w16Var) {
        super(w16Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((w16) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
