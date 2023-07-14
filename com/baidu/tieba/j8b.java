package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a8b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class j8b extends g8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.g8b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 206;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g8b
    public void j(l8b l8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l8bVar) == null) {
        }
    }

    @Override // com.baidu.tieba.g8b
    public void n(l8b l8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, l8bVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8b(d8b d8bVar, l8b l8bVar, a8b.a aVar) {
        super(d8bVar, l8bVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d8bVar, l8bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d8b) objArr2[0], (l8b) objArr2[1], (a8b.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.g8b
    public RandomAccessFile e(File file, String str, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, str, Long.valueOf(j)})) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            randomAccessFile.seek(j);
            return randomAccessFile;
        }
        return (RandomAccessFile) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.g8b
    public Map<String, String> f(l8b l8bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l8bVar)) == null) {
            HashMap hashMap = new HashMap();
            long c = l8bVar.c() + l8bVar.b();
            long a = l8bVar.a();
            hashMap.put("Range", "bytes=" + c + "-" + a);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g8b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return j8b.class.getSimpleName();
        }
        return (String) invokeV.objValue;
    }
}
