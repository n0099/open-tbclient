package com.baidu.ugc.audioedit;

import b.a.x0.g.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.vinuxproject.sonic.Sonic;
/* loaded from: classes10.dex */
public class AudioSpeedOperator implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Sonic mSonic;

    public AudioSpeedOperator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.x0.g.a
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

    @Override // b.a.x0.g.a
    public void close() {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sonic = this.mSonic) == null) {
            return;
        }
        sonic.b();
    }

    @Override // b.a.x0.g.a
    public void flush() {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sonic = this.mSonic) == null) {
            return;
        }
        sonic.c();
    }

    @Override // b.a.x0.g.a
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

    @Override // b.a.x0.g.a
    public void init(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.mSonic = new Sonic(i2, i3);
        }
    }

    @Override // b.a.x0.g.a
    public boolean putBytes(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i2)) == null) {
            Sonic sonic = this.mSonic;
            if (sonic != null) {
                sonic.d(bArr, i2);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // b.a.x0.g.a
    public int receiveBytes(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bArr, i2)) == null) {
            Sonic sonic = this.mSonic;
            if (sonic != null) {
                return sonic.e(bArr, i2);
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // b.a.x0.g.a
    public void setSpeed(float f2) {
        Sonic sonic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048583, this, f2) == null) || (sonic = this.mSonic) == null) {
            return;
        }
        sonic.f(f2);
    }
}
