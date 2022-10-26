package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.IOException;
import java.util.Arrays;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes4.dex */
public class k8 implements Appendable, CharSequence {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public char[] a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307744, "Lcom/baidu/tieba/k8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307744, "Lcom/baidu/tieba/k8;");
                return;
            }
        }
        c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            int i = this.b + 4;
            if (i > this.a.length) {
                x(i);
            }
            char[] cArr = this.a;
            int i2 = this.b;
            int i3 = i2 + 1;
            this.b = i3;
            cArr[i2] = 'n';
            int i4 = i3 + 1;
            this.b = i4;
            cArr[i3] = 'u';
            int i5 = i4 + 1;
            this.b = i5;
            cArr[i4] = 'l';
            this.b = i5 + 1;
            cArr[i5] = 'l';
        }
    }

    public k8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new char[16];
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = this.b + 31;
            for (int i2 = 0; i2 < this.b; i2++) {
                i = (i * 31) + this.a[i2];
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.CharSequence
    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.b == 0) {
                return "";
            }
            return new String(this.a, 0, this.b);
        }
        return (String) invokeV.objValue;
    }

    public k8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i >= 0) {
            this.a = new char[i];
            return;
        }
        throw new NegativeArraySizeException();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || k8.class != obj.getClass()) {
                return false;
            }
            k8 k8Var = (k8) obj;
            int i = this.b;
            if (i != k8Var.b) {
                return false;
            }
            char[] cArr = this.a;
            char[] cArr2 = k8Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                if (cArr[i2] != cArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public k8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        int length = str.length();
        this.b = length;
        char[] cArr = new char[length + 16];
        this.a = cArr;
        str.getChars(0, length, cArr, 0);
    }

    public static int E(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            if (i < 0) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            while (true) {
                i /= i2;
                if (i != 0) {
                    i3++;
                } else {
                    return i3;
                }
            }
        } else {
            return invokeII.intValue;
        }
    }

    public final void B(int i, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cArr) == null) {
            if (i >= 0 && i <= this.b) {
                if (cArr.length != 0) {
                    D(cArr.length, i);
                    System.arraycopy(cArr, 0, cArr, i, cArr.length);
                    this.b += cArr.length;
                    return;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public String J(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            if (i >= 0 && i <= i2 && i2 <= this.b) {
                if (i == i2) {
                    return "";
                }
                return new String(this.a, i, i2 - i);
            }
            throw new StringIndexOutOfBoundsException();
        }
        return (String) invokeII.objValue;
    }

    public k8 delete(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i, i2)) == null) {
            w(i, i2);
            return this;
        }
        return (k8) invokeII.objValue;
    }

    public k8 e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            f(i, i2, '0');
            return this;
        }
        return (k8) invokeII.objValue;
    }

    public k8 h(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            i(j, i, '0');
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Character.valueOf(c2)})) == null) {
            y(i, c2);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048623, this, i, i2)) == null) {
            return J(i, i2);
        }
        return (CharSequence) invokeII.objValue;
    }

    public final void w(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i, i2) == null) {
            if (i >= 0) {
                int i3 = this.b;
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i2 == i) {
                    return;
                }
                if (i2 > i) {
                    int i4 = this.b - i2;
                    if (i4 >= 0) {
                        char[] cArr = this.a;
                        System.arraycopy(cArr, i2, cArr, i, i4);
                    }
                    this.b -= i2 - i;
                    return;
                }
            }
            throw new StringIndexOutOfBoundsException();
        }
    }

    public static int F(long j, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (j < 0) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            while (true) {
                j /= i;
                if (j != 0) {
                    i2++;
                } else {
                    return i2;
                }
            }
        } else {
            return invokeCommon.intValue;
        }
    }

    public final void A(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            if (i >= 0 && i <= this.b) {
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                int length = str.length();
                if (length != 0) {
                    D(length, i);
                    str.getChars(0, length, this.a, i);
                    this.b += length;
                    return;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public final void D(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            char[] cArr = this.a;
            int length = cArr.length;
            int i3 = this.b;
            if (length - i3 >= i) {
                System.arraycopy(cArr, i2, cArr, i + i2, i3 - i2);
                return;
            }
            int i4 = i3 + i;
            int length2 = (cArr.length << 1) + 2;
            if (i4 <= length2) {
                i4 = length2;
            }
            char[] cArr2 = new char[i4];
            System.arraycopy(this.a, 0, cArr2, 0, i2);
            System.arraycopy(this.a, i2, cArr2, i + i2, this.b - i2);
            this.a = cArr2;
        }
    }

    public k8 G(char c2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Character.valueOf(c2), str})) == null) {
            int length = str.length();
            int i = 0;
            while (i != this.b) {
                if (this.a[i] == c2) {
                    H(i, i + 1, str);
                    i += length;
                } else {
                    i++;
                }
            }
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public final void y(int i, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i), Character.valueOf(c2)}) == null) {
            if (i >= 0 && i <= this.b) {
                D(1, i);
                this.a[i] = c2;
                this.b++;
                return;
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public final void C(int i, char[] cArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), cArr, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (i >= 0 && i <= i3) {
                if (i2 >= 0 && i3 >= 0 && i3 <= cArr.length - i2) {
                    if (i3 != 0) {
                        D(i3, i);
                        System.arraycopy(cArr, i2, this.a, i, i3);
                        this.b += i3;
                        return;
                    }
                    return;
                }
                throw new StringIndexOutOfBoundsException("offset " + i2 + ", length " + i3 + ", char[].length " + cArr.length);
            }
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public final void H(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
            if (i >= 0) {
                int i3 = this.b;
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i2 > i) {
                    int length = str.length();
                    int i4 = (i2 - i) - length;
                    if (i4 > 0) {
                        char[] cArr = this.a;
                        System.arraycopy(cArr, i2, cArr, i + length, this.b - i2);
                    } else if (i4 < 0) {
                        D(-i4, i2);
                    }
                    str.getChars(0, length, this.a, i);
                    this.b -= i4;
                    return;
                } else if (i == i2) {
                    if (str != null) {
                        A(i, str);
                        return;
                    }
                    throw null;
                }
            }
            throw new StringIndexOutOfBoundsException();
        }
    }

    public final void u(char[] cArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048626, this, cArr, i, i2) == null) {
            if (i <= cArr.length && i >= 0) {
                if (i2 >= 0 && cArr.length - i >= i2) {
                    int i3 = this.b + i2;
                    if (i3 > this.a.length) {
                        x(i3);
                    }
                    System.arraycopy(cArr, i, this.a, this.b, i2);
                    this.b = i3;
                    return;
                }
                throw new ArrayIndexOutOfBoundsException("Length out of bounds: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Offset out of bounds: " + i);
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i >= 0) {
                char[] cArr = this.a;
                if (i > cArr.length) {
                    x(i);
                } else {
                    int i2 = this.b;
                    if (i2 < i) {
                        Arrays.fill(cArr, i2, i, (char) 0);
                    }
                }
                this.b = i;
                return;
            }
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public k8 a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2)})) == null) {
            q(c2);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c2) throws IOException {
        a(c2);
        return this;
    }

    public k8 b(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d)})) == null) {
            s(Double.toString(d));
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            s(Float.toString(f));
            return this;
        }
        return (k8) invokeF.objValue;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (i >= 0 && i < this.b) {
                return this.a[i];
            }
            throw new StringIndexOutOfBoundsException(i);
        }
        return invokeI.charValue;
    }

    public k8 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            e(i, 0);
            return this;
        }
        return (k8) invokeI.objValue;
    }

    public k8 g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
            h(j, 0);
            return this;
        }
        return (k8) invokeJ.objValue;
    }

    public k8 j(k8 k8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, k8Var)) == null) {
            if (k8Var == null) {
                v();
            } else {
                u(k8Var.a, 0, k8Var.b);
            }
            return this;
        }
        return (k8) invokeL.objValue;
    }

    public k8 k(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, charSequence)) == null) {
            if (charSequence == null) {
                v();
            } else if (charSequence instanceof k8) {
                k8 k8Var = (k8) charSequence;
                u(k8Var.a, 0, k8Var.b);
            } else {
                s(charSequence.toString());
            }
            return this;
        }
        return (k8) invokeL.objValue;
    }

    public k8 m(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, obj)) == null) {
            if (obj == null) {
                v();
            } else {
                s(obj.toString());
            }
            return this;
        }
        return (k8) invokeL.objValue;
    }

    public k8 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            s(str);
            return this;
        }
        return (k8) invokeL.objValue;
    }

    public k8 o(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            if (z) {
                str = "true";
            } else {
                str = "false";
            }
            s(str);
            return this;
        }
        return (k8) invokeZ.objValue;
    }

    public k8 p(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, cArr)) == null) {
            t(cArr);
            return this;
        }
        return (k8) invokeL.objValue;
    }

    public final void q(char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Character.valueOf(c2)}) == null) {
            int i = this.b;
            if (i == this.a.length) {
                x(i + 1);
            }
            char[] cArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            cArr[i2] = c2;
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            if (str == null) {
                v();
                return;
            }
            int length = str.length();
            int i = this.b + length;
            if (i > this.a.length) {
                x(i);
            }
            str.getChars(0, length, this.a, this.b);
            this.b = i;
        }
    }

    public final void t(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cArr) == null) {
            int length = this.b + cArr.length;
            if (length > this.a.length) {
                x(length);
            }
            System.arraycopy(cArr, 0, this.a, this.b, cArr.length);
            this.b = length;
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            char[] cArr = this.a;
            int length = (cArr.length >> 1) + cArr.length + 2;
            if (i <= length) {
                i = length;
            }
            char[] cArr2 = new char[i];
            System.arraycopy(this.a, 0, cArr2, 0, this.b);
            this.a = cArr2;
        }
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        k(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        l(charSequence, i, i2);
        return this;
    }

    public k8 l(CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048614, this, charSequence, i, i2)) == null) {
            r(charSequence, i, i2);
            return this;
        }
        return (k8) invokeLII.objValue;
    }

    public final void r(CharSequence charSequence, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, charSequence, i, i2) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            if (i >= 0 && i2 >= 0 && i <= i2 && i2 <= charSequence.length()) {
                s(charSequence.subSequence(i, i2).toString());
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public k8 f(int i, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (i == Integer.MIN_VALUE) {
                s("-2147483648");
                return this;
            }
            if (i < 0) {
                q(SignatureImpl.SEP);
                i = -i;
            }
            if (i2 > 1) {
                for (int E = i2 - E(i, 10); E > 0; E--) {
                    a(c2);
                }
            }
            if (i >= 10000) {
                if (i >= 1000000000) {
                    q(c[(int) ((i % 10000000000L) / C.NANOS_PER_SECOND)]);
                }
                if (i >= 100000000) {
                    q(c[(i % 1000000000) / 100000000]);
                }
                if (i >= 10000000) {
                    q(c[(i % 100000000) / 10000000]);
                }
                if (i >= 1000000) {
                    q(c[(i % 10000000) / 1000000]);
                }
                if (i >= 100000) {
                    q(c[(i % 1000000) / 100000]);
                }
                q(c[(i % 100000) / 10000]);
            }
            if (i >= 1000) {
                q(c[(i % 10000) / 1000]);
            }
            if (i >= 100) {
                q(c[(i % 1000) / 100]);
            }
            if (i >= 10) {
                q(c[(i % 100) / 10]);
            }
            q(c[i % 10]);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 i(long j, int i, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Character.valueOf(c2)})) == null) {
            if (j == Long.MIN_VALUE) {
                s("-9223372036854775808");
                return this;
            }
            if (j < 0) {
                q(SignatureImpl.SEP);
                j = -j;
            }
            if (i > 1) {
                for (int F = i - F(j, 10); F > 0; F--) {
                    a(c2);
                }
            }
            if (j >= 10000) {
                if (j >= 1000000000000000000L) {
                    q(c[(int) ((j % 1.0E19d) / 1.0E18d)]);
                }
                if (j >= 100000000000000000L) {
                    q(c[(int) ((j % 1000000000000000000L) / 100000000000000000L)]);
                }
                if (j >= 10000000000000000L) {
                    q(c[(int) ((j % 100000000000000000L) / 10000000000000000L)]);
                }
                if (j >= 1000000000000000L) {
                    q(c[(int) ((j % 10000000000000000L) / 1000000000000000L)]);
                }
                if (j >= 100000000000000L) {
                    q(c[(int) ((j % 1000000000000000L) / 100000000000000L)]);
                }
                if (j >= 10000000000000L) {
                    q(c[(int) ((j % 100000000000000L) / 10000000000000L)]);
                }
                if (j >= BasicLabelFormatter.TRILLION) {
                    q(c[(int) ((j % 10000000000000L) / BasicLabelFormatter.TRILLION)]);
                }
                if (j >= 100000000000L) {
                    q(c[(int) ((j % BasicLabelFormatter.TRILLION) / 100000000000L)]);
                }
                if (j >= 10000000000L) {
                    q(c[(int) ((j % 100000000000L) / 10000000000L)]);
                }
                if (j >= C.NANOS_PER_SECOND) {
                    q(c[(int) ((j % 10000000000L) / C.NANOS_PER_SECOND)]);
                }
                if (j >= 100000000) {
                    q(c[(int) ((j % C.NANOS_PER_SECOND) / 100000000)]);
                }
                if (j >= 10000000) {
                    q(c[(int) ((j % 100000000) / 10000000)]);
                }
                if (j >= 1000000) {
                    q(c[(int) ((j % 10000000) / 1000000)]);
                }
                if (j >= 100000) {
                    q(c[(int) ((j % 1000000) / 100000)]);
                }
                q(c[(int) ((j % 100000) / 10000)]);
            }
            if (j >= 1000) {
                q(c[(int) ((j % 10000) / 1000)]);
            }
            if (j >= 100) {
                q(c[(int) ((j % 1000) / 100)]);
            }
            if (j >= 10) {
                q(c[(int) ((j % 100) / 10)]);
            }
            q(c[(int) (j % 10)]);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)})) == null) {
            A(i, Double.toString(d));
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            A(i, Float.toString(f));
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i, i2)) == null) {
            A(i, Integer.toString(i2));
            return this;
        }
        return (k8) invokeII.objValue;
    }

    public k8 insert(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            A(i, Long.toString(j));
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, CharSequence charSequence) {
        InterceptResult invokeIL;
        String charSequence2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i, charSequence)) == null) {
            if (charSequence == null) {
                charSequence2 = StringUtil.NULL_STRING;
            } else {
                charSequence2 = charSequence.toString();
            }
            A(i, charSequence2);
            return this;
        }
        return (k8) invokeIL.objValue;
    }

    public k8 insert(int i, CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), charSequence, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            z(i, charSequence, i2, i3);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, Object obj) {
        InterceptResult invokeIL;
        String obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i, obj)) == null) {
            if (obj == null) {
                obj2 = StringUtil.NULL_STRING;
            } else {
                obj2 = obj.toString();
            }
            A(i, obj2);
            return this;
        }
        return (k8) invokeIL.objValue;
    }

    public k8 insert(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i, str)) == null) {
            A(i, str);
            return this;
        }
        return (k8) invokeIL.objValue;
    }

    public k8 insert(int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                str = "true";
            } else {
                str = "false";
            }
            A(i, str);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public k8 insert(int i, char[] cArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i, cArr)) == null) {
            B(i, cArr);
            return this;
        }
        return (k8) invokeIL.objValue;
    }

    public k8 insert(int i, char[] cArr, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), cArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            C(i, cArr, i2, i3);
            return this;
        }
        return (k8) invokeCommon.objValue;
    }

    public final void z(int i, CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), charSequence, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            if (i >= 0 && i <= this.b && i2 >= 0 && i3 >= 0 && i2 <= i3 && i3 <= charSequence.length()) {
                A(i, charSequence.subSequence(i2, i3).toString());
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
