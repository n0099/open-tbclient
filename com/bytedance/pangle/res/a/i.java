package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class i extends FilterInputStream implements DataInput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(byte b, byte b2, byte b3, byte b4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4)})) == null) ? (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255) : invokeCommon.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private byte b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int read = ((FilterInputStream) this).in.read();
            if (-1 != read) {
                return (byte) read;
            }
            throw new EOFException();
        }
        return invokeV.byteValue;
    }

    public final e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (e) ((FilterInputStream) this).in;
        }
        return (e) invokeV.objValue;
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (readUnsignedByte() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (byte) readUnsignedByte();
        }
        return invokeV.byteValue;
    }

    @Override // java.io.DataInput
    public final char readChar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (char) readUnsignedShort();
        }
        return invokeV.charValue;
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Double.longBitsToDouble(readLong());
        }
        return invokeV.doubleValue;
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Float.intBitsToFloat(readInt());
        }
        return invokeV.floatValue;
    }

    @Override // java.io.DataInput
    public final int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            byte b = b();
            return a(b(), b(), b(), b);
        }
        return invokeV.intValue;
    }

    @Override // java.io.DataInput
    public final String readLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new UnsupportedOperationException("readLine is not supported");
        }
        return (String) invokeV.objValue;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (short) readUnsignedShort();
        }
        return invokeV.shortValue;
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new DataInputStream(((FilterInputStream) this).in).readUTF();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int read = ((FilterInputStream) this).in.read();
            if (read >= 0) {
                return read;
            }
            throw new EOFException();
        }
        return invokeV.intValue;
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return a((byte) 0, (byte) 0, b(), b());
        }
        return invokeV.intValue;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            d.a(this, bArr, 0, bArr.length);
        }
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return (int) ((FilterInputStream) this).in.skip(i);
        }
        return invokeI.intValue;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i, i2) == null) {
            d.a(this, bArr, i, i2);
        }
    }

    @Override // java.io.DataInput
    public final long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            byte b = b();
            byte b2 = b();
            byte b3 = b();
            byte b4 = b();
            byte b5 = b();
            return ((b() & 255) << 56) | ((b() & 255) << 48) | ((b() & 255) << 40) | ((b5 & 255) << 32) | ((b4 & 255) << 24) | ((b3 & 255) << 16) | ((b2 & 255) << 8) | (b & 255);
        }
        return invokeV.longValue;
    }
}
