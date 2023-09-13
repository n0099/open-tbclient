package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ql7 implements fn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rx7 a;

    public ql7() {
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

    @Override // com.baidu.tieba.fn7
    public gn7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new sl7();
        }
        return (gn7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fn7
    public bx7 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (!frsFragment.A4()) {
                return new bx7(frsFragment, noPressedRelativeLayout);
            }
            return null;
        }
        return (bx7) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fn7
    public hn7 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) {
            return new zw7(frsFragment, noPressedRelativeLayout);
        }
        return (hn7) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fn7
    public dn7 b(FrsFragment frsFragment, in inVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, inVar, z)) == null) {
            return new pm7(frsFragment, inVar, z);
        }
        return (dn7) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.fn7
    public rx7 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            rl7 rl7Var = new rl7(frsFragment, null, null, i);
            this.a = rl7Var;
            rl7Var.T(frsFragment.U3());
            return this.a;
        }
        return (rx7) invokeLLI.objValue;
    }
}
