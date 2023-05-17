package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wz8 extends vz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wz8(jx5 jx5Var) {
        super(jx5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jx5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jx5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
