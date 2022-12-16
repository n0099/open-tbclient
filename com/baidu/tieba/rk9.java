package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes6.dex */
public class rk9 extends nk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nk9
    public Map<String, String> f(sk9 sk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sk9Var)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nk9
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nk9
    public void j(sk9 sk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sk9Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nk9
    public void n(sk9 sk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sk9Var) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk9(kk9 kk9Var, sk9 sk9Var, hk9.a aVar) {
        super(kk9Var, sk9Var, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kk9Var, sk9Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((kk9) objArr2[0], (sk9) objArr2[1], (hk9.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.nk9
    public RandomAccessFile e(File file, String str, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, str, Long.valueOf(j)})) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            randomAccessFile.seek(0L);
            return randomAccessFile;
        }
        return (RandomAccessFile) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.nk9
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return rk9.class.getSimpleName();
        }
        return (String) invokeV.objValue;
    }
}
