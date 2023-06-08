package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class slb implements Framedata {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Framedata.Opcode b;
    public ByteBuffer c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public abstract void h() throws InvalidDataException;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-427198301, "Lcom/baidu/tieba/slb$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-427198301, "Lcom/baidu/tieba/slb$a;");
                    return;
                }
            }
            int[] iArr = new int[Framedata.Opcode.values().length];
            a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public slb(Framedata.Opcode opcode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opcode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = opcode;
        this.c = imb.a();
        this.a = true;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public static slb g(Framedata.Opcode opcode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, opcode)) == null) {
            if (opcode != null) {
                switch (a.a[opcode.ordinal()]) {
                    case 1:
                        return new tlb();
                    case 2:
                        return new ulb();
                    case 3:
                        return new vlb();
                    case 4:
                        return new nlb();
                    case 5:
                        return new olb();
                    case 6:
                        return new plb();
                    default:
                        throw new IllegalArgumentException("Supplied opcode is invalid");
                }
            }
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        return (slb) invokeL.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (Framedata.Opcode) invokeV.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            slb slbVar = (slb) obj;
            if (this.a != slbVar.a || this.d != slbVar.d || this.e != slbVar.e || this.f != slbVar.f || this.g != slbVar.g || this.b != slbVar.b) {
                return false;
            }
            ByteBuffer byteBuffer = this.c;
            ByteBuffer byteBuffer2 = slbVar.c;
            if (byteBuffer != null) {
                return byteBuffer.equals(byteBuffer2);
            }
            if (byteBuffer2 == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = (((this.a ? 1 : 0) * 31) + this.b.hashCode()) * 31;
            ByteBuffer byteBuffer = this.c;
            if (byteBuffer != null) {
                i = byteBuffer.hashCode();
            } else {
                i = 0;
            }
            return ((((((((hashCode + i) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }

    public void j(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, byteBuffer) == null) {
            this.c = byteBuffer;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.g = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Framedata{ optcode:");
            sb.append(d());
            sb.append(", fin:");
            sb.append(f());
            sb.append(", rsv1:");
            sb.append(b());
            sb.append(", rsv2:");
            sb.append(c());
            sb.append(", rsv3:");
            sb.append(e());
            sb.append(", payloadlength:[pos:");
            sb.append(this.c.position());
            sb.append(", len:");
            sb.append(this.c.remaining());
            sb.append("], payload:");
            if (this.c.remaining() > 1000) {
                str = "(too big to display)";
            } else {
                str = new String(this.c.array());
            }
            sb.append(str);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
