package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s06 implements cg<n06> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public n06 e(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, n06Var)) == null) ? n06Var : (n06) invokeL.objValue;
    }

    public n06 i(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n06Var)) == null) ? n06Var : (n06) invokeL.objValue;
    }

    public s06(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.cg
    public /* bridge */ /* synthetic */ n06 a(n06 n06Var) {
        n06 n06Var2 = n06Var;
        e(n06Var2);
        return n06Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.cg
    public /* bridge */ /* synthetic */ n06 c(n06 n06Var) {
        n06 n06Var2 = n06Var;
        i(n06Var2);
        return n06Var2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cg
    /* renamed from: f */
    public void b(n06 n06Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, n06Var) == null) && n06Var != null && n06Var.b() != null) {
            n06Var.b().recycle();
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cg
    /* renamed from: h */
    public n06 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new n06(this.a);
        }
        return (n06) invokeV.objValue;
    }
}
