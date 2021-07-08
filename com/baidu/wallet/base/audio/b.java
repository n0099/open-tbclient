package com.baidu.wallet.base.audio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f23950e = "RIFF";

    /* renamed from: f  reason: collision with root package name */
    public static final String f23951f = "WAVE";

    /* renamed from: g  reason: collision with root package name */
    public static final String f23952g = "fmt ";

    /* renamed from: h  reason: collision with root package name */
    public static final String f23953h = "data";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public short f23954a;

    /* renamed from: b  reason: collision with root package name */
    public int f23955b;

    /* renamed from: c  reason: collision with root package name */
    public short f23956c;

    /* renamed from: d  reason: collision with root package name */
    public int f23957d;

    /* renamed from: i  reason: collision with root package name */
    public final ByteBuffer f23958i;
    public int j;
    public int k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23958i = ByteBuffer.allocate(44);
    }

    public static b a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            b bVar = new b();
            try {
                bVar.f23958i.order(ByteOrder.LITTLE_ENDIAN);
                inputStream.read(bVar.f23958i.array());
                bVar.j = bVar.f23958i.getInt(4);
                bVar.f23954a = bVar.f23958i.getShort(22);
                bVar.f23955b = bVar.f23958i.getInt(24);
                bVar.f23956c = bVar.f23958i.getShort(34);
                int b2 = bVar.b(inputStream);
                bVar.k = b2;
                if (-1 != b2) {
                    bVar.f23957d = bVar.f23958i.getInt(40);
                    return bVar;
                }
                return bVar;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    private int b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, inputStream)) == null) {
            byte[] bArr = new byte[4];
            int i2 = 36;
            do {
                int i3 = -1;
                try {
                    this.f23958i.position(36);
                    this.f23958i.get(bArr);
                    int i4 = this.f23958i.getInt(40);
                    if (Arrays.equals("data".getBytes(), bArr)) {
                        i3 = i2 + 8;
                        return i3;
                    }
                    inputStream.skip(i4);
                    i2 += i4 + 8;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return i3;
                }
            } while (8 == inputStream.read(this.f23958i.array(), 36, 8));
            return -1;
        }
        return invokeL.intValue;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) == null) {
            b bVar = new b();
            bVar.f23958i.order(ByteOrder.LITTLE_ENDIAN);
            bVar.f23958i.put(f23950e.getBytes());
            int i6 = (i5 + 44) - 8;
            bVar.j = i6;
            bVar.f23958i.putInt(i6);
            bVar.f23958i.put(f23951f.getBytes());
            bVar.f23958i.put(f23952g.getBytes());
            bVar.f23958i.putInt(16);
            bVar.f23958i.putShort((short) 1);
            short s = (short) i2;
            bVar.f23954a = s;
            bVar.f23958i.putShort(s);
            bVar.f23955b = i4;
            bVar.f23958i.putInt(i4);
            short s2 = (short) ((i2 * i3) / 8);
            bVar.f23958i.putInt(i4 * s2);
            bVar.f23958i.putShort(s2);
            short s3 = (short) i3;
            bVar.f23956c = s3;
            bVar.f23958i.putShort(s3);
            bVar.f23958i.put("data".getBytes());
            bVar.k = 44;
            bVar.f23957d = i5;
            bVar.f23958i.putInt(i5);
            return bVar;
        }
        return (b) invokeIIII.objValue;
    }

    public void a(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
            try {
                outputStream.write(this.f23958i.array());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(DataOutput dataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataOutput) == null) {
            try {
                dataOutput.write(this.f23958i.array());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            System.out.println("--Wave Header--\nfile length:" + this.j + "\nchannels:" + ((int) this.f23954a) + "\nsample rate:" + this.f23955b + "\nbit depth:" + ((int) this.f23956c) + "\npcm length:" + this.f23957d + "\ndata offset:" + this.k + "\n");
        }
    }
}
