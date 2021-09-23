package com.bytedance.sdk.component.b.b.a.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f65118a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65119b;

    /* renamed from: c  reason: collision with root package name */
    public int f65120c;

    /* renamed from: d  reason: collision with root package name */
    public int f65121d;

    /* renamed from: e  reason: collision with root package name */
    public int f65122e;

    /* renamed from: f  reason: collision with root package name */
    public int f65123f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f65124g;

    public d(X500Principal x500Principal) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x500Principal};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String name = x500Principal.getName("RFC2253");
        this.f65118a = name;
        this.f65119b = name.length();
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            while (true) {
                int i2 = this.f65120c;
                if (i2 >= this.f65119b || this.f65124g[i2] != ' ') {
                    break;
                }
                this.f65120c = i2 + 1;
            }
            int i3 = this.f65120c;
            if (i3 == this.f65119b) {
                return null;
            }
            this.f65121d = i3;
            this.f65120c = i3 + 1;
            while (true) {
                int i4 = this.f65120c;
                if (i4 >= this.f65119b) {
                    break;
                }
                char[] cArr = this.f65124g;
                if (cArr[i4] == '=' || cArr[i4] == ' ') {
                    break;
                }
                this.f65120c = i4 + 1;
            }
            int i5 = this.f65120c;
            if (i5 < this.f65119b) {
                this.f65122e = i5;
                if (this.f65124g[i5] == ' ') {
                    while (true) {
                        int i6 = this.f65120c;
                        if (i6 >= this.f65119b) {
                            break;
                        }
                        char[] cArr2 = this.f65124g;
                        if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                            break;
                        }
                        this.f65120c = i6 + 1;
                    }
                    char[] cArr3 = this.f65124g;
                    int i7 = this.f65120c;
                    if (cArr3[i7] != '=' || i7 == this.f65119b) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
                    }
                }
                this.f65120c++;
                while (true) {
                    int i8 = this.f65120c;
                    if (i8 >= this.f65119b || this.f65124g[i8] != ' ') {
                        break;
                    }
                    this.f65120c = i8 + 1;
                }
                int i9 = this.f65122e;
                int i10 = this.f65121d;
                if (i9 - i10 > 4) {
                    char[] cArr4 = this.f65124g;
                    if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                        char[] cArr5 = this.f65124g;
                        int i11 = this.f65121d;
                        if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                            char[] cArr6 = this.f65124g;
                            int i12 = this.f65121d;
                            if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                                this.f65121d += 4;
                            }
                        }
                    }
                }
                char[] cArr7 = this.f65124g;
                int i13 = this.f65121d;
                return new String(cArr7, i13, this.f65122e - i13);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
        }
        return (String) invokeV.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, this)) != null) {
            return (String) invokeV.objValue;
        }
        int i2 = this.f65120c + 1;
        this.f65120c = i2;
        this.f65121d = i2;
        this.f65122e = i2;
        while (true) {
            int i3 = this.f65120c;
            if (i3 != this.f65119b) {
                char[] cArr = this.f65124g;
                if (cArr[i3] == '\"') {
                    this.f65120c = i3 + 1;
                    while (true) {
                        int i4 = this.f65120c;
                        if (i4 >= this.f65119b || this.f65124g[i4] != ' ') {
                            break;
                        }
                        this.f65120c = i4 + 1;
                    }
                    char[] cArr2 = this.f65124g;
                    int i5 = this.f65121d;
                    return new String(cArr2, i5, this.f65122e - i5);
                }
                if (cArr[i3] == '\\') {
                    cArr[this.f65122e] = e();
                } else {
                    cArr[this.f65122e] = cArr[i3];
                }
                this.f65120c++;
                this.f65122e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
            }
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i2 = this.f65120c;
            if (i2 + 4 < this.f65119b) {
                this.f65121d = i2;
                this.f65120c = i2 + 1;
                while (true) {
                    int i3 = this.f65120c;
                    if (i3 == this.f65119b) {
                        break;
                    }
                    char[] cArr = this.f65124g;
                    if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                        break;
                    } else if (cArr[i3] == ' ') {
                        this.f65122e = i3;
                        this.f65120c = i3 + 1;
                        while (true) {
                            int i4 = this.f65120c;
                            if (i4 >= this.f65119b || this.f65124g[i4] != ' ') {
                                break;
                            }
                            this.f65120c = i4 + 1;
                        }
                    } else {
                        if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                            cArr[i3] = (char) (cArr[i3] + ' ');
                        }
                        this.f65120c++;
                    }
                }
                this.f65122e = this.f65120c;
                int i5 = this.f65122e;
                int i6 = this.f65121d;
                int i7 = i5 - i6;
                if (i7 >= 5 && (i7 & 1) != 0) {
                    int i8 = i7 / 2;
                    byte[] bArr = new byte[i8];
                    int i9 = i6 + 1;
                    for (int i10 = 0; i10 < i8; i10++) {
                        bArr[i10] = (byte) a(i9);
                        i9 += 2;
                    }
                    return new String(this.f65124g, this.f65121d, i7);
                }
                throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        return new java.lang.String(r1, r2, r8.f65123f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int i2 = this.f65120c;
            this.f65121d = i2;
            this.f65122e = i2;
            while (true) {
                int i3 = this.f65120c;
                if (i3 >= this.f65119b) {
                    char[] cArr = this.f65124g;
                    int i4 = this.f65121d;
                    return new String(cArr, i4, this.f65122e - i4);
                }
                char[] cArr2 = this.f65124g;
                char c2 = cArr2[i3];
                if (c2 == ' ') {
                    int i5 = this.f65122e;
                    this.f65123f = i5;
                    this.f65120c = i3 + 1;
                    this.f65122e = i5 + 1;
                    cArr2[i5] = ' ';
                    while (true) {
                        int i6 = this.f65120c;
                        if (i6 >= this.f65119b) {
                            break;
                        }
                        char[] cArr3 = this.f65124g;
                        if (cArr3[i6] != ' ') {
                            break;
                        }
                        int i7 = this.f65122e;
                        this.f65122e = i7 + 1;
                        cArr3[i7] = ' ';
                        this.f65120c = i6 + 1;
                    }
                    int i8 = this.f65120c;
                    if (i8 == this.f65119b) {
                        break;
                    }
                    char[] cArr4 = this.f65124g;
                    if (cArr4[i8] == ',' || cArr4[i8] == '+' || cArr4[i8] == ';') {
                        break;
                    }
                } else if (c2 == ';') {
                    break;
                } else if (c2 == '\\') {
                    int i9 = this.f65122e;
                    this.f65122e = i9 + 1;
                    cArr2[i9] = e();
                    this.f65120c++;
                } else if (c2 == '+' || c2 == ',') {
                    break;
                } else {
                    int i10 = this.f65122e;
                    this.f65122e = i10 + 1;
                    cArr2[i10] = cArr2[i3];
                    this.f65120c = i3 + 1;
                }
            }
            char[] cArr5 = this.f65124g;
            int i11 = this.f65121d;
            return new String(cArr5, i11, this.f65122e - i11);
        }
        return (String) invokeV.objValue;
    }

    private char e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int i2 = this.f65120c + 1;
            this.f65120c = i2;
            if (i2 != this.f65119b) {
                char c2 = this.f65124g[i2];
                if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                    switch (c2) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c2) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return f();
                            }
                    }
                }
                return this.f65124g[this.f65120c];
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f65118a);
        }
        return invokeV.charValue;
    }

    private char f() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int a2 = a(this.f65120c);
            this.f65120c++;
            if (a2 < 128) {
                return (char) a2;
            }
            if (a2 < 192 || a2 > 247) {
                return '?';
            }
            if (a2 <= 223) {
                i3 = a2 & 31;
                i2 = 1;
            } else if (a2 <= 239) {
                i2 = 2;
                i3 = a2 & 15;
            } else {
                i2 = 3;
                i3 = a2 & 7;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f65120c + 1;
                this.f65120c = i5;
                if (i5 == this.f65119b || this.f65124g[i5] != '\\') {
                    return '?';
                }
                int i6 = i5 + 1;
                this.f65120c = i6;
                int a3 = a(i6);
                this.f65120c++;
                if ((a3 & 192) != 128) {
                    return '?';
                }
                i3 = (i3 << 6) + (a3 & 63);
            }
            return (char) i3;
        }
        return invokeV.charValue;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int i5 = i2 + 1;
            if (i5 < this.f65119b) {
                char c2 = this.f65124g[i2];
                if (c2 >= '0' && c2 <= '9') {
                    i3 = c2 - '0';
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i3 = c2 - 'W';
                } else if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f65118a);
                } else {
                    i3 = c2 - '7';
                }
                char c3 = this.f65124g[i5];
                if (c3 >= '0' && c3 <= '9') {
                    i4 = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i4 = c3 - 'W';
                } else if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f65118a);
                } else {
                    i4 = c3 - '7';
                }
                return (i3 << 4) + i4;
            }
            throw new IllegalStateException("Malformed DN: " + this.f65118a);
        }
        return invokeI.intValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f65120c = 0;
            this.f65121d = 0;
            this.f65122e = 0;
            this.f65123f = 0;
            this.f65124g = this.f65118a.toCharArray();
            String a2 = a();
            if (a2 == null) {
                return null;
            }
            do {
                int i2 = this.f65120c;
                if (i2 == this.f65119b) {
                    return null;
                }
                char c2 = this.f65124g[i2];
                if (c2 == '\"') {
                    b2 = b();
                } else if (c2 != '#') {
                    b2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d();
                } else {
                    b2 = c();
                }
                if (str.equalsIgnoreCase(a2)) {
                    return b2;
                }
                int i3 = this.f65120c;
                if (i3 >= this.f65119b) {
                    return null;
                }
                char[] cArr = this.f65124g;
                if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                    throw new IllegalStateException("Malformed DN: " + this.f65118a);
                }
                this.f65120c++;
                a2 = a();
            } while (a2 != null);
            throw new IllegalStateException("Malformed DN: " + this.f65118a);
        }
        return (String) invokeL.objValue;
    }
}
