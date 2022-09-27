package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jk6 implements sl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fu6 a;

    public jk6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sl6
    public tt6 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.R3()) {
                return null;
            }
            return new tt6(frsFragment, noPressedRelativeLayout);
        }
        return (tt6) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sl6
    public rl6 b(FrsFragment frsFragment, jo joVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, joVar, z)) == null) ? new dl6(frsFragment, joVar, z) : (rl6) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.sl6
    public tl6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new lk6() : (tl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl6
    public ul6 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new rt6(frsFragment, noPressedRelativeLayout) : (ul6) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sl6
    public fu6 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            kk6 kk6Var = new kk6(frsFragment, null, null, i);
            this.a = kk6Var;
            kk6Var.R(frsFragment.p3());
            return this.a;
        }
        return (fu6) invokeLLI.objValue;
    }
}
