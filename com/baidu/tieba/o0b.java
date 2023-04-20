package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public class o0b extends q0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public String i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0b() {
        super(Framedata.Opcode.CLOSING);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Framedata.Opcode) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r("");
        q(1000);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            byte[] f = j1b.f(this.i);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(this.h);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(f.length + 2);
            allocate2.put(allocate);
            allocate2.put(f);
            allocate2.rewind();
            super.j(allocate2);
        }
    }

    @Override // com.baidu.tieba.s0b, org.java_websocket.framing.Framedata
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == 1005) {
                return i1b.a();
            }
            return super.a();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s0b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.toString() + "code: " + this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q0b, com.baidu.tieba.s0b
    public void h() throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.h();
            if (this.h == 1007 && this.i == null) {
                throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
            }
            if (this.h == 1005 && this.i.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            int i = this.h;
            if (i > 1015 && i < 3000) {
                throw new InvalidDataException(1002, "Trying to send an illegal close code!");
            }
            int i2 = this.h;
            if (i2 != 1006 && i2 != 1015 && i2 != 1005 && i2 <= 4999 && i2 >= 1000 && i2 != 1004) {
                return;
            }
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.h);
        }
    }

    @Override // com.baidu.tieba.s0b
    public void j(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.h = 1005;
            this.i = "";
            byteBuffer.mark();
            if (byteBuffer.remaining() == 0) {
                this.h = 1000;
            } else if (byteBuffer.remaining() == 1) {
                this.h = 1002;
            } else {
                if (byteBuffer.remaining() >= 2) {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    allocate.position(2);
                    allocate.putShort(byteBuffer.getShort());
                    allocate.position(0);
                    this.h = allocate.getInt();
                }
                byteBuffer.reset();
                try {
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(byteBuffer.position() + 2);
                        this.i = j1b.e(byteBuffer);
                        byteBuffer.position(position);
                    } catch (IllegalArgumentException unused) {
                        throw new InvalidDataException(1007);
                    }
                } catch (InvalidDataException unused2) {
                    this.h = 1007;
                    this.i = null;
                }
            }
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            if (i == 1015) {
                this.h = 1005;
                this.i = "";
            }
            s();
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.i = str;
            s();
        }
    }
}
