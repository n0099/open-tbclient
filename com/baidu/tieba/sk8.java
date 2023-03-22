package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sk8 extends rk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sk8(qt5 qt5Var) {
        super(qt5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qt5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qt5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
