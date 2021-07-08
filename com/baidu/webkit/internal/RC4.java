package com.baidu.webkit.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes5.dex */
public class RC4 implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGTAG = "RC4";
    public static final int STATE_LENGTH = 256;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] engineState;
    public byte[] workingKey;
    public int x;
    public int y;

    /* loaded from: classes5.dex */
    public static class a extends GZIPOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((GZIPOutputStream) this).def.setLevel(9);
            }
        }
    }

    public RC4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.workingKey = str.getBytes();
    }

    public static byte[] kernelEncrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (WebKitFactory.getCurEngine() != 1) {
                return bArr;
            }
            byte[] bArr2 = new byte[bArr.length];
            Log.w(LOGTAG, "kernelEncrypt " + bArr.length);
            WebSettingsGlobalBlink.kernelEncrypt(bArr, bArr.length, bArr2);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] kernelGzipCompress(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a aVar = new a(byteArrayOutputStream);
            aVar.a();
            aVar.write(bArr);
            aVar.close();
            Log.w("rc4", "kernelGzipCompress " + byteArrayOutputStream.toByteArray().length);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    private void processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i5 = i2 + i3;
            if (i5 > bArr.length) {
                sb = new StringBuilder("input buffer too short, buffer length=");
                sb.append(bArr.length);
                str = ", input length=";
            } else if (i4 + i3 <= bArr2.length) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = (this.x + 1) & 255;
                    this.x = i7;
                    byte[] bArr3 = this.engineState;
                    int i8 = (bArr3[i7] + this.y) & 255;
                    this.y = i8;
                    byte b2 = bArr3[i7];
                    bArr3[i7] = bArr3[i8];
                    bArr3[i8] = b2;
                    bArr2[i6 + i4] = (byte) (bArr3[(bArr3[i7] + bArr3[i8]) & 255] ^ bArr[i6 + i2]);
                }
                return;
            } else {
                sb = new StringBuilder("output buffer too short, buffer length=");
                sb.append(bArr.length);
                str = ", output length=";
            }
            sb.append(str);
            sb.append(i5);
            Log.e(LOGTAG, sb.toString());
        }
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setKey(this.workingKey);
        }
    }

    private void setKey(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bArr) == null) {
            this.x = 0;
            this.y = 0;
            if (this.engineState == null) {
                this.engineState = new byte[256];
            }
            for (int i2 = 0; i2 < 256; i2++) {
                this.engineState[i2] = (byte) i2;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                byte[] bArr2 = this.engineState;
                i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
                byte b2 = bArr2[i5];
                bArr2[i5] = bArr2[i4];
                bArr2[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
        }
    }

    public byte[] decrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            reset();
            byte[] bArr2 = new byte[bArr.length];
            processBytes(bArr, 0, bArr.length, bArr2, 0);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] encrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            reset();
            byte[] bArr2 = new byte[bArr.length];
            processBytes(bArr, 0, bArr.length, bArr2, 0);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }
}
