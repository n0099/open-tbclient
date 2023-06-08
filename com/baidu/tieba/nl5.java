package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class nl5 implements ol5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ol5 a;

    public nl5(ol5 ol5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ol5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ol5Var;
    }

    @Override // com.baidu.tieba.ol5
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            return this.a.skip(j);
        }
        return invokeJ.longValue;
    }

    @Override // com.baidu.tieba.ol5
    public InputStream a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            reset();
            return this.a.a();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ol5
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.available();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ol5
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.close();
        }
    }

    @Override // com.baidu.tieba.ol5
    public byte peek() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.peek();
        }
        return invokeV.byteValue;
    }

    @Override // com.baidu.tieba.ol5
    public int position() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.position();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ol5
    public void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.reset();
        }
    }

    @Override // com.baidu.tieba.ol5
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            return this.a.read(bArr, i, i2);
        }
        return invokeLII.intValue;
    }
}
