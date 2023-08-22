package com.baidu.tieba;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nk9 extends mk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nk9(c16 c16Var) {
        super(c16Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c16) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
