package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y69 extends x69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y69(r16 r16Var) {
        super(r16Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r16) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
