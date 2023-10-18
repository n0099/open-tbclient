package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class j3 implements Appendable, CharSequence {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public char[] a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448306628, "Lcom/baidu/tieba/j3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448306628, "Lcom/baidu/tieba/j3;");
        }
    }

    public j3() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.b == 0) {
                return "";
            }
            return new String(this.a, 0, this.b);
        }
        return (String) invokeV.objValue;
    }

    public j3(int i) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || j3.class != obj.getClass()) {
                return false;
            }
            j3 j3Var = (j3) obj;
            int i = this.b;
            if (i != j3Var.b) {
                return false;
            }
            char[] cArr = this.a;
            char[] cArr2 = j3Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                if (cArr[i2] != cArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public j3(String str) {
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

    public j3 a(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c)})) == null) {
            g(c);
            return this;
        }
        return (j3) invokeCommon.objValue;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c) throws IOException {
        a(c);
        return this;
    }

    public j3 b(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, j3Var)) == null) {
            if (j3Var == null) {
                k();
            } else {
                j(j3Var.a, 0, j3Var.b);
            }
            return this;
        }
        return (j3) invokeL.objValue;
    }

    public j3 c(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequence)) == null) {
            if (charSequence == null) {
                k();
            } else if (charSequence instanceof j3) {
                j3 j3Var = (j3) charSequence;
                j(j3Var.a, 0, j3Var.b);
            } else {
                i(charSequence.toString());
            }
            return this;
        }
        return (j3) invokeL.objValue;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i >= 0 && i < this.b) {
                return this.a[i];
            }
            throw new StringIndexOutOfBoundsException(i);
        }
        return invokeI.charValue;
    }

    public j3 e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == null) {
                k();
            } else {
                i(obj.toString());
            }
            return this;
        }
        return (j3) invokeL.objValue;
    }

    public j3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            i(str);
            return this;
        }
        return (j3) invokeL.objValue;
    }

    public final void g(char c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Character.valueOf(c)}) == null) {
            int i = this.b;
            if (i == this.a.length) {
                l(i + 1);
            }
            char[] cArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            cArr[i2] = c;
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null) {
                k();
                return;
            }
            int length = str.length();
            int i = this.b + length;
            if (i > this.a.length) {
                l(i);
            }
            str.getChars(0, length, this.a, this.b);
            this.b = i;
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
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
        c(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        d(charSequence, i, i2);
        return this;
    }

    public j3 d(CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, charSequence, i, i2)) == null) {
            h(charSequence, i, i2);
            return this;
        }
        return (j3) invokeLII.objValue;
    }

    public final void h(CharSequence charSequence, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, charSequence, i, i2) == null) {
            if (charSequence == null) {
                charSequence = StringUtil.NULL_STRING;
            }
            if (i >= 0 && i2 >= 0 && i <= i2 && i2 <= charSequence.length()) {
                i(charSequence.subSequence(i, i2).toString());
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public final void j(char[] cArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, cArr, i, i2) == null) {
            if (i <= cArr.length && i >= 0) {
                if (i2 >= 0 && cArr.length - i >= i2) {
                    int i3 = this.b + i2;
                    if (i3 > this.a.length) {
                        l(i3);
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

    public final void p(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i, i2, str) == null) {
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
                        n(-i4, i2);
                    }
                    str.getChars(0, length, this.a, i);
                    this.b -= i4;
                    return;
                } else if (i == i2) {
                    if (str != null) {
                        m(i, str);
                        return;
                    }
                    throw null;
                }
            }
            throw new StringIndexOutOfBoundsException();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.b + 4;
            if (i > this.a.length) {
                l(i);
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

    public final void m(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) {
            if (i >= 0 && i <= this.b) {
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                int length = str.length();
                if (length != 0) {
                    n(length, i);
                    str.getChars(0, length, this.a, i);
                    this.b += length;
                    return;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public final void n(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
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

    public j3 o(char c, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Character.valueOf(c), str})) == null) {
            int length = str.length();
            int i = 0;
            while (i != this.b) {
                if (this.a[i] == c) {
                    p(i, i + 1, str);
                    i += length;
                } else {
                    i++;
                }
            }
            return this;
        }
        return (j3) invokeCommon.objValue;
    }

    public String q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
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

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i, i2)) == null) {
            return q(i, i2);
        }
        return (CharSequence) invokeII.objValue;
    }
}
