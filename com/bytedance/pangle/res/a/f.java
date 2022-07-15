package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInput;
/* loaded from: classes4.dex */
public abstract class f implements DataInput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i a;

    public f(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.readBoolean() : invokeV.booleanValue;
    }

    @Override // java.io.DataInput
    public byte readByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.readByte() : invokeV.byteValue;
    }

    @Override // java.io.DataInput
    public char readChar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.readChar() : invokeV.charValue;
    }

    @Override // java.io.DataInput
    public double readDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.readDouble() : invokeV.doubleValue;
    }

    @Override // java.io.DataInput
    public float readFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.readFloat() : invokeV.floatValue;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i, i2) == null) {
            this.a.readFully(bArr, i, i2);
        }
    }

    @Override // java.io.DataInput
    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.readInt() : invokeV.intValue;
    }

    @Override // java.io.DataInput
    public String readLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.readLine() : (String) invokeV.objValue;
    }

    @Override // java.io.DataInput
    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.readLong() : invokeV.longValue;
    }

    @Override // java.io.DataInput
    public short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.readShort() : invokeV.shortValue;
    }

    @Override // java.io.DataInput
    public String readUTF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.readUTF() : (String) invokeV.objValue;
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.readUnsignedByte() : invokeV.intValue;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.readUnsignedShort() : invokeV.intValue;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? this.a.skipBytes(i) : invokeI.intValue;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            this.a.readFully(bArr);
        }
    }
}
