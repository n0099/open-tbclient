package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oh9 extends nh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh9(a36 a36Var) {
        super(a36Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a36Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a36) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
