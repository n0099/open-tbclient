package com.baidu.ugc.audioedit;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qf9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.vinuxproject.sonic.Sonic;
/* loaded from: classes6.dex */
public class AudioSpeedOperator implements qf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Sonic mSonic;

    public AudioSpeedOperator() {
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

    @Override // com.baidu.tieba.qf9
    public int availableBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Sonic sonic = this.mSonic;
            if (sonic != null) {
                return sonic.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qf9
    public void close() {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (sonic = this.mSonic) != null) {
            sonic.b();
        }
    }

    @Override // com.baidu.tieba.qf9
    public void flush() {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (sonic = this.mSonic) != null) {
            sonic.c();
        }
    }

    @Override // com.baidu.tieba.qf9
    public byte[] getOutPutBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int availableBytes = availableBytes();
            byte[] bArr = new byte[availableBytes];
            receiveBytes(bArr, availableBytes);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf9
    public void init(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.mSonic = new Sonic(i, i2);
        }
    }

    @Override // com.baidu.tieba.qf9
    public boolean putBytes(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i)) == null) {
            Sonic sonic = this.mSonic;
            if (sonic != null) {
                sonic.d(bArr, i);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.qf9
    public int receiveBytes(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bArr, i)) == null) {
            Sonic sonic = this.mSonic;
            if (sonic != null) {
                return sonic.e(bArr, i);
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.qf9
    public void setSpeed(float f) {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048583, this, f) == null) && (sonic = this.mSonic) != null) {
            sonic.f(f);
        }
    }
}
