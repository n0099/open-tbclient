package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dgb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* loaded from: classes7.dex */
public class ngb extends jgb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jgb
    public Map<String, String> f(ogb ogbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ogbVar)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jgb
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jgb
    public void j(ogb ogbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ogbVar) == null) {
        }
    }

    @Override // com.baidu.tieba.jgb
    public void n(ogb ogbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ogbVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ngb(ggb ggbVar, ogb ogbVar, dgb.a aVar) {
        super(ggbVar, ogbVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ggbVar, ogbVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ggb) objArr2[0], (ogb) objArr2[1], (dgb.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.jgb
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

    @Override // com.baidu.tieba.jgb
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ngb.class.getSimpleName();
        }
        return (String) invokeV.objValue;
    }
}
