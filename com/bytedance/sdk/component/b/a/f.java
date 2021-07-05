package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class f implements Serializable, Comparable<f> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f27981a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f27982b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f27983c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f27984d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f27985e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731338901, "Lcom/bytedance/sdk/component/b/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731338901, "Lcom/bytedance/sdk/component/b/a/f;");
                return;
            }
        }
        f27981a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f27982b = a(new byte[0]);
    }

    public f(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27983c = bArr;
    }

    public static f a(byte... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr != null) {
                return new f((byte[]) bArr.clone());
            }
            throw new IllegalArgumentException("data == null");
        }
        return (f) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? b.a(this.f27983c) : (String) invokeV.objValue;
    }

    public f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c("SHA-1") : (f) invokeV.objValue;
    }

    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c("SHA-256") : (f) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.f27983c;
            char[] cArr = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = f27981a;
                cArr[i2] = cArr2[(b2 >> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                int g2 = fVar.g();
                byte[] bArr = this.f27983c;
                if (g2 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048590, this)) != null) {
            return (f) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f27983c;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i2++;
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f27983c.length : invokeV.intValue;
    }

    public byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (byte[]) this.f27983c.clone() : (byte[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = this.f27984d;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = Arrays.hashCode(this.f27983c);
            this.f27984d = hashCode;
            return hashCode;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f27983c.length == 0) {
                return "[size=0]";
            }
            String a2 = a();
            int a3 = a(a2, 64);
            if (a3 == -1) {
                if (this.f27983c.length <= 64) {
                    return "[hex=" + e() + PreferencesUtil.RIGHT_MOUNT;
                }
                return "[size=" + this.f27983c.length + " hex=" + a(0, 64).e() + "…]";
            }
            String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a3 < a2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.f27983c.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(replace);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static f b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (str != null) {
                if (str.length() % 2 == 0) {
                    int length = str.length() / 2;
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ((a(str.charAt(i3)) << 4) + a(str.charAt(i3 + 1)));
                    }
                    return a(bArr);
                }
                throw new IllegalArgumentException("Unexpected hex string: " + str);
            }
            throw new IllegalArgumentException("hex == null");
        }
        return (f) invokeL.objValue;
    }

    private f c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            try {
                return a(MessageDigest.getInstance(str).digest(this.f27983c));
            } catch (NoSuchAlgorithmException e2) {
                throw new AssertionError(e2);
            }
        }
        return (f) invokeL.objValue;
    }

    public static f a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (str != null) {
                f fVar = new f(str.getBytes(u.f28026a));
                fVar.f27985e = str;
                return fVar;
            }
            throw new IllegalArgumentException("s == null");
        }
        return (f) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.f27985e;
            if (str != null) {
                return str;
            }
            String str2 = new String(this.f27983c, u.f28026a);
            this.f27985e = str2;
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public static int a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public f a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (i2 >= 0) {
                byte[] bArr = this.f27983c;
                if (i3 > bArr.length) {
                    throw new IllegalArgumentException("endIndex > length(" + this.f27983c.length + SmallTailInfo.EMOTION_SUFFIX);
                }
                int i4 = i3 - i2;
                if (i4 >= 0) {
                    if (i2 == 0 && i3 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.f27983c, i2, bArr2, 0, i4);
                    return new f(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException("beginIndex < 0");
        }
        return (f) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            int g2 = g();
            int g3 = fVar.g();
            int min = Math.min(g2, g3);
            for (int i2 = 0; i2 < min; i2++) {
                int a2 = a(i2) & 255;
                int a3 = fVar.a(i2) & 255;
                if (a2 != a3) {
                    return a2 < a3 ? -1 : 1;
                }
            }
            if (g2 == g3) {
                return 0;
            }
            return g2 < g3 ? -1 : 1;
        }
        return invokeL.intValue;
    }

    public byte a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f27983c[i2] : invokeI.byteValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            byte[] bArr = this.f27983c;
            cVar.c(bArr, 0, bArr.length);
        }
    }

    public boolean a(int i2, f fVar, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), fVar, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? fVar.a(i3, this.f27983c, i2, i4) : invokeCommon.booleanValue;
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 >= 0) {
                byte[] bArr2 = this.f27983c;
                if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && u.a(bArr2, i2, bArr, i3, i4)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) ? a(0, fVar, 0, fVar.g()) : invokeL.booleanValue;
    }

    public static int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                if (i4 == i2) {
                    return i3;
                }
                int codePointAt = str.codePointAt(i3);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    return -1;
                }
                i4++;
                i3 += Character.charCount(codePointAt);
            }
            return str.length();
        }
        return invokeLI.intValue;
    }
}
