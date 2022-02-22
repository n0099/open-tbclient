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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes13.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f50681e = "RIFF";

    /* renamed from: f  reason: collision with root package name */
    public static final String f50682f = "WAVE";

    /* renamed from: g  reason: collision with root package name */
    public static final String f50683g = "fmt ";

    /* renamed from: h  reason: collision with root package name */
    public static final String f50684h = "data";
    public transient /* synthetic */ FieldHolder $fh;
    public short a;

    /* renamed from: b  reason: collision with root package name */
    public int f50685b;

    /* renamed from: c  reason: collision with root package name */
    public short f50686c;

    /* renamed from: d  reason: collision with root package name */
    public int f50687d;

    /* renamed from: i  reason: collision with root package name */
    public final ByteBuffer f50688i;

    /* renamed from: j  reason: collision with root package name */
    public int f50689j;
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
        this.f50688i = ByteBuffer.allocate(44);
    }

    public static b a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            b bVar = new b();
            try {
                bVar.f50688i.order(ByteOrder.LITTLE_ENDIAN);
                inputStream.read(bVar.f50688i.array());
                bVar.f50689j = bVar.f50688i.getInt(4);
                bVar.a = bVar.f50688i.getShort(22);
                bVar.f50685b = bVar.f50688i.getInt(24);
                bVar.f50686c = bVar.f50688i.getShort(34);
                int b2 = bVar.b(inputStream);
                bVar.k = b2;
                if (-1 != b2) {
                    bVar.f50687d = bVar.f50688i.getInt(40);
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
                    this.f50688i.position(36);
                    this.f50688i.get(bArr);
                    int i4 = this.f50688i.getInt(40);
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
            } while (8 == inputStream.read(this.f50688i.array(), 36, 8));
            return -1;
        }
        return invokeL.intValue;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) == null) {
            b bVar = new b();
            bVar.f50688i.order(ByteOrder.LITTLE_ENDIAN);
            bVar.f50688i.put(f50681e.getBytes());
            int i6 = (i5 + 44) - 8;
            bVar.f50689j = i6;
            bVar.f50688i.putInt(i6);
            bVar.f50688i.put(f50682f.getBytes());
            bVar.f50688i.put(f50683g.getBytes());
            bVar.f50688i.putInt(16);
            bVar.f50688i.putShort((short) 1);
            short s = (short) i2;
            bVar.a = s;
            bVar.f50688i.putShort(s);
            bVar.f50685b = i4;
            bVar.f50688i.putInt(i4);
            short s2 = (short) ((i2 * i3) / 8);
            bVar.f50688i.putInt(i4 * s2);
            bVar.f50688i.putShort(s2);
            short s3 = (short) i3;
            bVar.f50686c = s3;
            bVar.f50688i.putShort(s3);
            bVar.f50688i.put("data".getBytes());
            bVar.k = 44;
            bVar.f50687d = i5;
            bVar.f50688i.putInt(i5);
            return bVar;
        }
        return (b) invokeIIII.objValue;
    }

    public void a(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
            try {
                outputStream.write(this.f50688i.array());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(DataOutput dataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataOutput) == null) {
            try {
                dataOutput.write(this.f50688i.array());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            System.out.println("--Wave Header--\nfile length:" + this.f50689j + "\nchannels:" + ((int) this.a) + "\nsample rate:" + this.f50685b + "\nbit depth:" + ((int) this.f50686c) + "\npcm length:" + this.f50687d + "\ndata offset:" + this.k + StringUtils.LF);
        }
    }
}
