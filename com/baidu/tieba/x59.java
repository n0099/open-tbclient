package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x59 extends w59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x59(k16 k16Var) {
        super(k16Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k16) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
