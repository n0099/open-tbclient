package com.bytedance.sdk.component.b.b.a.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.j;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.b.a.c;
import com.bytedance.sdk.component.b.b.a.g.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f64617a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f64618b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f64619c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f64620d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f64621e;

    /* renamed from: f  reason: collision with root package name */
    public final CountDownLatch f64622f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f64623g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f64624h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952180530, "Lcom/bytedance/sdk/component/b/b/a/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952180530, "Lcom/bytedance/sdk/component/b/b/a/h/a;");
                return;
            }
        }
        f64617a = new byte[]{42};
        f64618b = new String[0];
        f64619c = new String[]{"*"};
        f64620d = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64621e = new AtomicBoolean(false);
        this.f64622f = new CountDownLatch(1);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f64620d : (a) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            boolean z = false;
            while (true) {
                try {
                    try {
                        c();
                        break;
                    } catch (InterruptedIOException unused) {
                        z = true;
                    } catch (IOException e2) {
                        e.b().a(5, "Failed to read public suffix list", e2);
                        if (z) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (resourceAsStream = a.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE)) == null) {
            return;
        }
        com.bytedance.sdk.component.b.a.e a2 = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a2.j()];
            a2.a(bArr);
            byte[] bArr2 = new byte[a2.j()];
            a2.a(bArr2);
            synchronized (this) {
                this.f64623g = bArr;
                this.f64624h = bArr2;
            }
            this.f64622f.countDown();
        } finally {
            c.a(a2);
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                String[] split = IDN.toUnicode(str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] a2 = a(split);
                if (split.length != a2.length || a2[0].charAt(0) == '!') {
                    if (a2[0].charAt(0) == '!') {
                        length = split.length;
                        length2 = a2.length;
                    } else {
                        length = split.length;
                        length2 = a2.length + 1;
                    }
                    StringBuilder sb = new StringBuilder();
                    String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    for (int i2 = length - length2; i2 < split2.length; i2++) {
                        sb.append(split2[i2]);
                        sb.append('.');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
                return null;
            }
            throw new NullPointerException("domain == null");
        }
        return (String) invokeL.objValue;
    }

    private String[] a(String[] strArr) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, strArr)) == null) {
            int i2 = 0;
            if (!this.f64621e.get() && this.f64621e.compareAndSet(false, true)) {
                b();
            } else {
                try {
                    this.f64622f.await();
                } catch (InterruptedException unused) {
                }
            }
            synchronized (this) {
                if (this.f64623g == null) {
                    throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
                }
            }
            int length = strArr.length;
            byte[][] bArr = new byte[length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                bArr[i3] = strArr[i3].getBytes(c.f64367e);
            }
            int i4 = 0;
            while (true) {
                str = null;
                if (i4 >= length) {
                    str2 = null;
                    break;
                }
                str2 = a(this.f64623g, bArr, i4);
                if (str2 != null) {
                    break;
                }
                i4++;
            }
            if (length > 1) {
                byte[][] bArr2 = (byte[][]) bArr.clone();
                for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                    bArr2[i5] = f64617a;
                    str3 = a(this.f64623g, bArr2, i5);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                while (true) {
                    if (i2 >= length - 1) {
                        break;
                    }
                    String a2 = a(this.f64624h, bArr, i2);
                    if (a2 != null) {
                        str = a2;
                        break;
                    }
                    i2++;
                }
            }
            if (str != null) {
                return ("!" + str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            } else if (str2 == null && str3 == null) {
                return f64619c;
            } else {
                String[] split = str2 != null ? str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f64618b;
                String[] split2 = str3 != null ? str3.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f64618b;
                return split.length > split2.length ? split : split2;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static String a(byte[] bArr, byte[][] bArr2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        boolean z;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, bArr, bArr2, i2)) == null) {
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > -1 && bArr[i7] != 10) {
                    i7--;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i3 = i8 + i9;
                    if (bArr[i3] == 10) {
                        break;
                    }
                    i9++;
                }
                int i10 = i3 - i8;
                int i11 = i2;
                boolean z2 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z2) {
                        i4 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i4 = bArr2[i11][i12] & 255;
                    }
                    i5 = i4 - (bArr[i8 + i13] & 255);
                    if (i5 == 0) {
                        i13++;
                        i12++;
                        if (i13 == i10) {
                            break;
                        } else if (bArr2[i11].length != i12) {
                            z2 = z;
                        } else if (i11 == bArr2.length - 1) {
                            break;
                        } else {
                            i11++;
                            z2 = true;
                            i12 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i5 >= 0) {
                    if (i5 <= 0) {
                        int i14 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        while (true) {
                            i11++;
                            if (i11 >= bArr2.length) {
                                break;
                            }
                            length2 += bArr2[i11].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i8, i10, c.f64367e);
                            }
                        }
                    }
                    i6 = i3 + 1;
                }
                length = i8 - 1;
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }
}
