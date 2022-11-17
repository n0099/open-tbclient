package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xz7 extends wz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz7(tm5 tm5Var) {
        super(tm5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tm5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tm5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
