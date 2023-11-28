package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes9.dex */
public final class yec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BufferedSource a;
    public long b;
    public long c;
    public int d;
    public int e;
    public int f;
    public long g;
    public FieldEncoding h;

    public yec(BufferedSource bufferedSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.c = Long.MAX_VALUE;
        this.e = 2;
        this.f = -1;
        this.g = -1L;
        this.a = bufferedSource;
    }

    public final void a(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.e == i) {
                this.e = 6;
                return;
            }
            long j = this.b;
            long j2 = this.c;
            if (j <= j2) {
                if (j == j2) {
                    this.c = this.g;
                    this.g = -1L;
                    this.e = 6;
                    return;
                }
                this.e = 7;
                return;
            }
            throw new IOException("Expected to end at " + this.c + " but was " + this.b);
        }
    }

    public final long b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.e == 2) {
                long j = this.c - this.b;
                this.a.require(j);
                this.e = 6;
                this.b = this.c;
                this.c = this.g;
                this.g = -1L;
                return j;
            }
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
        }
        return invokeV.longValue;
    }

    public int i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.e;
            if (i != 5 && i != 2) {
                throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
            }
            this.a.require(4L);
            this.b += 4;
            int readIntLe = this.a.readIntLe();
            a(5);
            return readIntLe;
        }
        return invokeV.intValue;
    }

    public long j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.e;
            if (i != 1 && i != 2) {
                throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
            }
            this.a.require(8L);
            this.b += 8;
            long readLongLe = this.a.readLongLe();
            a(1);
            return readLongLe;
        }
        return invokeV.longValue;
    }

    public long m() throws IOException {
        InterceptResult invokeV;
        byte readByte;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.e;
            if (i != 0 && i != 2) {
                throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
            }
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.b++;
                j |= (readByte & ByteCompanionObject.MAX_VALUE) << i2;
                if ((this.a.readByte() & 128) == 0) {
                    a(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        return invokeV.longValue;
    }

    public long c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e == 2) {
                int i = this.d + 1;
                this.d = i;
                if (i <= 65) {
                    long j = this.g;
                    this.g = -1L;
                    this.e = 6;
                    return j;
                }
                throw new IOException("Wire recursion limit exceeded");
            }
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        return invokeV.longValue;
    }

    public int l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.e;
            if (i != 0 && i != 2) {
                throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
            }
            int e = e();
            a(0);
            return e;
        }
        return invokeV.intValue;
    }

    public void d(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (this.e == 6) {
                int i = this.d - 1;
                this.d = i;
                if (i >= 0 && this.g == -1) {
                    if (this.b != this.c && i != 0) {
                        throw new IOException("Expected to end at " + this.c + " but was " + this.b);
                    }
                    this.c = j;
                    return;
                }
                throw new IllegalStateException("No corresponding call to beginMessage()");
            }
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public final void n(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            while (this.b < this.c && !this.a.exhausted()) {
                int e = e();
                if (e != 0) {
                    int i2 = e >> 3;
                    int i3 = e & 7;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 == 5) {
                                            this.e = 5;
                                            i();
                                        } else {
                                            throw new ProtocolException("Unexpected field encoding: " + i3);
                                        }
                                    } else if (i2 == i) {
                                        return;
                                    } else {
                                        throw new ProtocolException("Unexpected end group");
                                    }
                                } else {
                                    n(i2);
                                }
                            } else {
                                long e2 = e();
                                this.b += e2;
                                this.a.skip(e2);
                            }
                        } else {
                            this.e = 1;
                            j();
                        }
                    } else {
                        this.e = 0;
                        m();
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            throw new EOFException();
        }
    }

    public final int e() throws IOException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.b++;
            byte readByte = this.a.readByte();
            if (readByte >= 0) {
                return readByte;
            }
            int i2 = readByte & ByteCompanionObject.MAX_VALUE;
            this.b++;
            byte readByte2 = this.a.readByte();
            if (readByte2 >= 0) {
                i = readByte2 << 7;
            } else {
                i2 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
                this.b++;
                byte readByte3 = this.a.readByte();
                if (readByte3 >= 0) {
                    i = readByte3 << 14;
                } else {
                    i2 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                    this.b++;
                    byte readByte4 = this.a.readByte();
                    if (readByte4 >= 0) {
                        i = readByte4 << 21;
                    } else {
                        int i3 = i2 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                        this.b++;
                        byte readByte5 = this.a.readByte();
                        int i4 = i3 | (readByte5 << 28);
                        if (readByte5 < 0) {
                            for (int i5 = 0; i5 < 5; i5++) {
                                this.b++;
                                if (this.a.readByte() >= 0) {
                                    return i4;
                                }
                            }
                            throw new ProtocolException("Malformed VARINT");
                        }
                        return i4;
                    }
                }
            }
            return i2 | i;
        }
        return invokeV.intValue;
    }

    public int f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.e;
            if (i == 7) {
                this.e = 2;
                return this.f;
            } else if (i == 6) {
                while (this.b < this.c && !this.a.exhausted()) {
                    int e = e();
                    if (e != 0) {
                        int i2 = e >> 3;
                        this.f = i2;
                        int i3 = e & 7;
                        if (i3 != 0) {
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 != 3) {
                                        if (i3 != 4) {
                                            if (i3 == 5) {
                                                this.h = FieldEncoding.FIXED32;
                                                this.e = 5;
                                                return i2;
                                            }
                                            throw new ProtocolException("Unexpected field encoding: " + i3);
                                        }
                                        throw new ProtocolException("Unexpected end group");
                                    }
                                    n(i2);
                                } else {
                                    this.h = FieldEncoding.LENGTH_DELIMITED;
                                    this.e = 2;
                                    int e2 = e();
                                    if (e2 >= 0) {
                                        if (this.g == -1) {
                                            long j = this.c;
                                            this.g = j;
                                            long j2 = this.b + e2;
                                            this.c = j2;
                                            if (j2 <= j) {
                                                return this.f;
                                            }
                                            throw new EOFException();
                                        }
                                        throw new IllegalStateException();
                                    }
                                    throw new ProtocolException("Negative length: " + e2);
                                }
                            } else {
                                this.h = FieldEncoding.FIXED64;
                                this.e = 1;
                                return i2;
                            }
                        } else {
                            this.h = FieldEncoding.VARINT;
                            this.e = 0;
                            return i2;
                        }
                    } else {
                        throw new ProtocolException("Unexpected tag 0");
                    }
                }
                return -1;
            } else {
                throw new IllegalStateException("Unexpected call to nextTag()");
            }
        }
        return invokeV.intValue;
    }

    public FieldEncoding g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (FieldEncoding) invokeV.objValue;
    }

    public ByteString h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.readByteString(b());
        }
        return (ByteString) invokeV.objValue;
    }

    public String k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.readUtf8(b());
        }
        return (String) invokeV.objValue;
    }
}
