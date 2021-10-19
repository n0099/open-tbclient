package com.bytedance.sdk.component.b.b.a.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64991a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f64992b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f64993c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f64994d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269779, "Lcom/bytedance/sdk/component/b/b/a/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269779, "Lcom/bytedance/sdk/component/b/b/a/e/e;");
                return;
            }
        }
        f64991a = com.bytedance.sdk.component.b.a.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f64994d = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f64992b = new String[64];
        f64993c = new String[256];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f64993c;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = com.bytedance.sdk.component.b.b.a.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f64992b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            f64992b[i5 | 8] = f64992b[i5] + "|PADDED";
        }
        String[] strArr3 = f64992b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr4 = f64992b;
                int i10 = i9 | i7;
                strArr4[i10] = f64992b[i9] + '|' + f64992b[i7];
                f64992b[i10 | 8] = f64992b[i9] + '|' + f64992b[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f64992b;
            if (i2 >= strArr5.length) {
                return;
            }
            if (strArr5[i2] == null) {
                strArr5[i2] = f64993c[i2];
            }
            i2++;
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, objArr)) == null) {
            throw new IllegalArgumentException(com.bytedance.sdk.component.b.b.a.c.a(str, objArr));
        }
        return (IllegalArgumentException) invokeLL.objValue;
    }

    public static IOException b(String str, Object... objArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr)) == null) {
            throw new IOException(com.bytedance.sdk.component.b.b.a.c.a(str, objArr));
        }
        return (IOException) invokeLL.objValue;
    }

    public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            String[] strArr = f64994d;
            String a2 = b2 < strArr.length ? strArr[b2] : com.bytedance.sdk.component.b.b.a.c.a("0x%02x", Byte.valueOf(b2));
            String a3 = a(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = a2;
            objArr[4] = a3;
            return com.bytedance.sdk.component.b.b.a.c.a("%s 0x%08x %5d %-13s %s", objArr);
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (b3 == 0) {
                return "";
            }
            if (b2 != 2 && b2 != 3) {
                if (b2 == 4 || b2 == 6) {
                    return b3 == 1 ? "ACK" : f64993c[b3];
                } else if (b2 != 7 && b2 != 8) {
                    String[] strArr = f64992b;
                    String str = b3 < strArr.length ? strArr[b3] : f64993c[b3];
                    if (b2 != 5 || (b3 & 4) == 0) {
                        return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f64993c[b3];
        }
        return (String) invokeCommon.objValue;
    }
}
