package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f28502d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f28503a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28504b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28505c;

    /* renamed from: e  reason: collision with root package name */
    public final String f28506e;

    /* renamed from: f  reason: collision with root package name */
    public final String f28507f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f28508g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f28509h;

    /* renamed from: i  reason: collision with root package name */
    public final String f28510i;
    public final String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731369126, "Lcom/bytedance/sdk/component/b/b/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731369126, "Lcom/bytedance/sdk/component/b/b/t;");
                return;
            }
        }
        f28502d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public t(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28503a = aVar.f28511a;
        this.f28506e = a(aVar.f28512b, false);
        this.f28507f = a(aVar.f28513c, false);
        this.f28504b = aVar.f28514d;
        this.f28505c = aVar.a();
        this.f28508g = a(aVar.f28516f, false);
        List<String> list = aVar.f28517g;
        this.f28509h = list != null ? a(list, true) : null;
        String str = aVar.f28518h;
        this.f28510i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    public URL a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return new URL(this.j);
            } catch (MalformedURLException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (URL) invokeV.objValue;
    }

    public URI b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String aVar = o().b().toString();
            try {
                return new URI(aVar);
            } catch (URISyntaxException e2) {
                try {
                    return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                } catch (Exception unused) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return (URI) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28503a : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28503a.equals("https") : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f28506e.isEmpty()) {
                return "";
            }
            int length = this.f28503a.length() + 3;
            String str = this.j;
            return this.j.substring(length, com.bytedance.sdk.component.b.b.a.c.a(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? (obj instanceof t) && ((t) obj).j.equals(this.j) : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f28507f.isEmpty()) {
                return "";
            }
            return this.j.substring(this.j.indexOf(58, this.f28503a.length() + 3) + 1, this.j.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28504b : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28505c : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j.hashCode() : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int indexOf = this.j.indexOf(47, this.f28503a.length() + 3);
            String str = this.j;
            return this.j.substring(indexOf, com.bytedance.sdk.component.b.b.a.c.a(str, indexOf, str.length(), "?#"));
        }
        return (String) invokeV.objValue;
    }

    public List<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int indexOf = this.j.indexOf(47, this.f28503a.length() + 3);
            String str = this.j;
            int a2 = com.bytedance.sdk.component.b.b.a.c.a(str, indexOf, str.length(), "?#");
            ArrayList arrayList = new ArrayList();
            while (indexOf < a2) {
                int i2 = indexOf + 1;
                int a3 = com.bytedance.sdk.component.b.b.a.c.a(this.j, i2, a2, '/');
                arrayList.add(this.j.substring(i2, a3));
                indexOf = a3;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f28509h == null) {
                return null;
            }
            int indexOf = this.j.indexOf(63) + 1;
            String str = this.j;
            return this.j.substring(indexOf, com.bytedance.sdk.component.b.b.a.c.a(str, indexOf, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f28509h == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            b(sb, this.f28509h);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f28510i == null) {
                return null;
            }
            return this.j.substring(this.j.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? d("/...").b("").c("").c().toString() : (String) invokeV.objValue;
    }

    public a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            a aVar = new a();
            aVar.f28511a = this.f28503a;
            aVar.f28512b = e();
            aVar.f28513c = f();
            aVar.f28514d = this.f28504b;
            aVar.f28515e = this.f28505c != a(this.f28503a) ? this.f28505c : -1;
            aVar.f28516f.clear();
            aVar.f28516f.addAll(j());
            aVar.f(k());
            aVar.f28518h = m();
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28511a;

        /* renamed from: b  reason: collision with root package name */
        public String f28512b;

        /* renamed from: c  reason: collision with root package name */
        public String f28513c;

        /* renamed from: d  reason: collision with root package name */
        public String f28514d;

        /* renamed from: e  reason: collision with root package name */
        public int f28515e;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f28516f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f28517g;

        /* renamed from: h  reason: collision with root package name */
        public String f28518h;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* renamed from: com.bytedance.sdk.component.b.b.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class EnumC0320a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static final EnumC0320a f28519a;

            /* renamed from: b  reason: collision with root package name */
            public static final EnumC0320a f28520b;

            /* renamed from: c  reason: collision with root package name */
            public static final EnumC0320a f28521c;

            /* renamed from: d  reason: collision with root package name */
            public static final EnumC0320a f28522d;

            /* renamed from: e  reason: collision with root package name */
            public static final EnumC0320a f28523e;

            /* renamed from: f  reason: collision with root package name */
            public static final /* synthetic */ EnumC0320a[] f28524f;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-418604500, "Lcom/bytedance/sdk/component/b/b/t$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-418604500, "Lcom/bytedance/sdk/component/b/b/t$a$a;");
                        return;
                    }
                }
                f28519a = new EnumC0320a(com.alipay.security.mobile.module.http.model.c.f2102g, 0);
                f28520b = new EnumC0320a("MISSING_SCHEME", 1);
                f28521c = new EnumC0320a("UNSUPPORTED_SCHEME", 2);
                f28522d = new EnumC0320a("INVALID_PORT", 3);
                EnumC0320a enumC0320a = new EnumC0320a("INVALID_HOST", 4);
                f28523e = enumC0320a;
                f28524f = new EnumC0320a[]{f28519a, f28520b, f28521c, f28522d, enumC0320a};
            }

            public EnumC0320a(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static EnumC0320a valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0320a) Enum.valueOf(EnumC0320a.class, str) : (EnumC0320a) invokeL.objValue;
            }

            public static EnumC0320a[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0320a[]) f28524f.clone() : (EnumC0320a[]) invokeV.objValue;
            }
        }

        public a() {
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
            this.f28512b = "";
            this.f28513c = "";
            this.f28515e = -1;
            ArrayList arrayList = new ArrayList();
            this.f28516f = arrayList;
            arrayList.add("");
        }

        private boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) ? str.equals(".") || str.equalsIgnoreCase("%2e") : invokeL.booleanValue;
        }

        private boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) ? str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e") : invokeL.booleanValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    if (str.equalsIgnoreCase("http")) {
                        this.f28511a = "http";
                    } else if (str.equalsIgnoreCase("https")) {
                        this.f28511a = "https";
                    } else {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                    return this;
                }
                throw new NullPointerException("scheme == null");
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (str != null) {
                    this.f28512b = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("username == null");
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str != null) {
                    this.f28513c = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("password == null");
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (str != null) {
                    String e2 = e(str, 0, str.length());
                    if (e2 != null) {
                        this.f28514d = e2;
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected host: " + str);
                }
                throw new NullPointerException("host == null");
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                if (str != null) {
                    return a(str, true);
                }
                throw new NullPointerException("encodedPathSegments == null");
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f28517g = str != null ? t.b(t.a(str, " \"'<>#", true, false, true, true)) : null;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f28511a);
                sb.append("://");
                if (!this.f28512b.isEmpty() || !this.f28513c.isEmpty()) {
                    sb.append(this.f28512b);
                    if (!this.f28513c.isEmpty()) {
                        sb.append(':');
                        sb.append(this.f28513c);
                    }
                    sb.append('@');
                }
                if (this.f28514d.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f28514d);
                    sb.append(']');
                } else {
                    sb.append(this.f28514d);
                }
                int a2 = a();
                if (a2 != t.a(this.f28511a)) {
                    sb.append(':');
                    sb.append(a2);
                }
                t.a(sb, this.f28516f);
                if (this.f28517g != null) {
                    sb.append('?');
                    t.b(sb, this.f28517g);
                }
                if (this.f28518h != null) {
                    sb.append('#');
                    sb.append(this.f28518h);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public static String e(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) ? com.bytedance.sdk.component.b.b.a.c.a(t.a(str, i2, i3, false)) : (String) invokeLII.objValue;
        }

        public static int f(String str, int i2, int i3) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i2, i3)) == null) {
                try {
                    parseInt = Integer.parseInt(t.a(str, i2, i3, "", false, false, false, true, null));
                } catch (NumberFormatException unused) {
                }
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            }
            return invokeLII.intValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int size = this.f28516f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f28516f.set(i2, t.a(this.f28516f.get(i2), "[]", true, true, false, true));
                }
                List<String> list = this.f28517g;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        String str = this.f28517g.get(i3);
                        if (str != null) {
                            this.f28517g.set(i3, t.a(str, "\\^`{|}", true, true, true, true));
                        }
                    }
                }
                String str2 = this.f28518h;
                if (str2 != null) {
                    this.f28518h = t.a(str2, " \"#<>\\^`{|}", true, true, false, false);
                }
                return this;
            }
            return (a) invokeV.objValue;
        }

        public t c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f28511a != null) {
                    if (this.f28514d != null) {
                        return new t(this);
                    }
                    throw new IllegalStateException("host == null");
                }
                throw new IllegalStateException("scheme == null");
            }
            return (t) invokeV.objValue;
        }

        private void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                List<String> list = this.f28516f;
                if (list.remove(list.size() - 1).isEmpty() && !this.f28516f.isEmpty()) {
                    List<String> list2 = this.f28516f;
                    list2.set(list2.size() - 1, "");
                    return;
                }
                this.f28516f.add("");
            }
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 > 0 && i2 <= 65535) {
                    this.f28515e = i2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            return (a) invokeI.objValue;
        }

        public static int c(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, str, i2, i3)) == null) {
                int i4 = 0;
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i4++;
                    i2++;
                }
                return i4;
            }
            return invokeLII.intValue;
        }

        public static int d(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, i3)) == null) {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt == ':') {
                        return i2;
                    }
                    if (charAt == '[') {
                        do {
                            i2++;
                            if (i2 < i3) {
                            }
                        } while (str.charAt(i2) != ']');
                    }
                    i2++;
                }
                return i3;
            }
            return invokeLII.intValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f28515e;
                return i2 != -1 ? i2 : t.a(this.f28511a);
            }
            return invokeV.intValue;
        }

        private a a(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, str, z)) == null) {
                int i2 = 0;
                do {
                    int a2 = com.bytedance.sdk.component.b.b.a.c.a(str, i2, str.length(), "/\\");
                    a(str, i2, a2, a2 < str.length(), z);
                    i2 = a2 + 1;
                } while (i2 <= str.length());
                return this;
            }
            return (a) invokeLZ.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                if (str != null) {
                    if (this.f28517g == null) {
                        this.f28517g = new ArrayList();
                    }
                    this.f28517g.add(t.a(str, " \"'<>#&=", true, false, true, true));
                    this.f28517g.add(str2 != null ? t.a(str2, " \"'<>#&=", true, false, true, true) : null);
                    return this;
                }
                throw new NullPointerException("encodedName == null");
            }
            return (a) invokeLL.objValue;
        }

        public static int b(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65540, null, str, i2, i3)) == null) {
                if (i3 - i2 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    while (true) {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 'a' || charAt2 > 'z') {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                if (charAt2 < '0' || charAt2 > '9') {
                                    if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                        if (charAt2 == ':') {
                                            return i2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }
            return invokeLII.intValue;
        }

        public EnumC0320a a(t tVar, String str) {
            InterceptResult invokeLL;
            int a2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar, str)) == null) {
                int a3 = com.bytedance.sdk.component.b.b.a.c.a(str, 0, str.length());
                int b2 = com.bytedance.sdk.component.b.b.a.c.b(str, a3, str.length());
                if (b(str, a3, b2) != -1) {
                    if (str.regionMatches(true, a3, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                        this.f28511a = "https";
                        a3 += 6;
                    } else if (str.regionMatches(true, a3, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                        this.f28511a = "http";
                        a3 += 5;
                    } else {
                        return EnumC0320a.f28521c;
                    }
                } else if (tVar != null) {
                    this.f28511a = tVar.f28503a;
                } else {
                    return EnumC0320a.f28520b;
                }
                int c2 = c(str, a3, b2);
                char c3 = '?';
                char c4 = '#';
                if (c2 < 2 && tVar != null && tVar.f28503a.equals(this.f28511a)) {
                    this.f28512b = tVar.e();
                    this.f28513c = tVar.f();
                    this.f28514d = tVar.f28504b;
                    this.f28515e = tVar.f28505c;
                    this.f28516f.clear();
                    this.f28516f.addAll(tVar.j());
                    if (a3 == b2 || str.charAt(a3) == '#') {
                        f(tVar.k());
                    }
                } else {
                    int i3 = a3 + c2;
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        a2 = com.bytedance.sdk.component.b.b.a.c.a(str, i3, b2, "@/\\?#");
                        char charAt = a2 != b2 ? str.charAt(a2) : (char) 65535;
                        if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                            break;
                        }
                        if (charAt == '@') {
                            if (!z) {
                                int a4 = com.bytedance.sdk.component.b.b.a.c.a(str, i3, a2, ':');
                                i2 = a2;
                                String a5 = t.a(str, i3, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    a5 = this.f28512b + "%40" + a5;
                                }
                                this.f28512b = a5;
                                if (a4 != i2) {
                                    this.f28513c = t.a(str, a4 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = a2;
                                this.f28513c += "%40" + t.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i3 = i2 + 1;
                        }
                        c3 = '?';
                        c4 = '#';
                    }
                    int d2 = d(str, i3, a2);
                    int i4 = d2 + 1;
                    if (i4 < a2) {
                        this.f28514d = e(str, i3, d2);
                        int f2 = f(str, i4, a2);
                        this.f28515e = f2;
                        if (f2 == -1) {
                            return EnumC0320a.f28522d;
                        }
                    } else {
                        this.f28514d = e(str, i3, d2);
                        this.f28515e = t.a(this.f28511a);
                    }
                    if (this.f28514d == null) {
                        return EnumC0320a.f28523e;
                    }
                    a3 = a2;
                }
                int a6 = com.bytedance.sdk.component.b.b.a.c.a(str, a3, b2, "?#");
                a(str, a3, a6);
                if (a6 < b2 && str.charAt(a6) == '?') {
                    int a7 = com.bytedance.sdk.component.b.b.a.c.a(str, a6, b2, '#');
                    this.f28517g = t.b(t.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                    a6 = a7;
                }
                if (a6 < b2 && str.charAt(a6) == '#') {
                    this.f28518h = t.a(str, 1 + a6, b2, "", true, false, false, false, null);
                }
                return EnumC0320a.f28519a;
            }
            return (EnumC0320a) invokeLL.objValue;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0045 -> B:13:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.bytedance.sdk.component.b.b.t.a.$ic
                if (r0 != 0) goto L49
            L4:
                if (r12 != r13) goto L7
                return
            L7:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L22
                r1 = 92
                if (r0 != r1) goto L17
                goto L22
            L17:
                java.util.List<java.lang.String> r0 = r10.f28516f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2d
            L22:
                java.util.List<java.lang.String> r0 = r10.f28516f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f28516f
                r0.add(r2)
                goto L45
            L2d:
                r6 = r12
                if (r6 >= r13) goto L48
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.component.b.b.a.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L3a
                r0 = 1
                goto L3b
            L3a:
                r0 = 0
            L3b:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2d
            L45:
                int r12 = r12 + 1
                goto L2d
            L48:
                return
            L49:
                r8 = r0
                r9 = 65538(0x10002, float:9.1838E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeLII(r9, r10, r11, r12, r13)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.b.t.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                String a2 = t.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
                if (g(a2)) {
                    return;
                }
                if (h(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f28516f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f28516f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f28516f.add(a2);
                }
                if (z) {
                    this.f28516f.add("");
                }
            }
        }
    }

    public t c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            a d2 = d(str);
            if (d2 != null) {
                return d2.c();
            }
            return null;
        }
        return (t) invokeL.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            a aVar = new a();
            if (aVar.a(this, str) == a.EnumC0320a.f28519a) {
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return Constants.SOCKET_PORT_SSL;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void a(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }
    }

    public static t e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            a aVar = new a();
            if (aVar.a((t) null, str) == a.EnumC0320a.f28519a) {
                return aVar.c();
            }
            return null;
        }
        return (t) invokeL.objValue;
    }

    public static void b(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                String str = list.get(i2);
                String str2 = list.get(i2 + 1);
                if (i2 > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(com.alipay.sdk.encrypt.a.f1889h);
                    sb.append(str2);
                }
            }
        }
    }

    public static t a(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, url)) == null) ? e(url.toString()) : (t) invokeL.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, str, z)) == null) ? a(str, 0, str.length(), z) : (String) invokeLZ.objValue;
    }

    private List<String> a(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, this, list, z)) == null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
                arrayList.add(str != null ? a(str, z) : null);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int indexOf = str.indexOf(38, i2);
                if (indexOf == -1) {
                    indexOf = str.length();
                }
                int indexOf2 = str.indexOf(61, i2);
                if (indexOf2 != -1 && indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i2, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                } else {
                    arrayList.add(str.substring(i2, indexOf));
                    arrayList.add(null);
                }
                i2 = indexOf + 1;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String a(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z)) {
                    com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
                    cVar.a(str, i2, i4);
                    a(cVar, str, i4, i3, z);
                    return cVar.o();
                }
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(com.bytedance.sdk.component.b.a.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{cVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                    int a2 = com.bytedance.sdk.component.b.b.a.c.a(str.charAt(i2 + 1));
                    int a3 = com.bytedance.sdk.component.b.b.a.c.a(str.charAt(i4));
                    if (a2 != -1 && a3 != -1) {
                        cVar.i((a2 << 4) + a3);
                        i2 = i4;
                    }
                    cVar.a(codePointAt);
                } else {
                    if (codePointAt == 43 && z) {
                        cVar.i(32);
                    }
                    cVar.a(codePointAt);
                }
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    public static boolean a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, str, i2, i3)) == null) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && com.bytedance.sdk.component.b.b.a.c.a(str.charAt(i2 + 1)) != -1 && com.bytedance.sdk.component.b.b.a.c.a(str.charAt(i4)) != -1;
        }
        return invokeLII.booleanValue;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) {
            int i4 = i2;
            while (i4 < i3) {
                int codePointAt = str.codePointAt(i4);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                    if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                        i4 += Character.charCount(codePointAt);
                    }
                }
                com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
                return cVar.o();
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(com.bytedance.sdk.component.b.a.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{cVar, str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset}) == null) {
            com.bytedance.sdk.component.b.a.c cVar2 = null;
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z3) {
                        cVar.b(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                    } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                        cVar.a(codePointAt);
                    } else {
                        if (cVar2 == null) {
                            cVar2 = new com.bytedance.sdk.component.b.a.c();
                        }
                        if (charset != null && !charset.equals(com.bytedance.sdk.component.b.b.a.c.f28115e)) {
                            cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                        } else {
                            cVar2.a(codePointAt);
                        }
                        while (!cVar2.e()) {
                            int h2 = cVar2.h() & 255;
                            cVar.i(37);
                            cVar.i((int) f28502d[(h2 >> 4) & 15]);
                            cVar.i((int) f28502d[h2 & 15]);
                        }
                    }
                }
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) ? a(str, 0, str.length(), str2, z, z2, z3, z4, charset) : (String) invokeCommon.objValue;
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? a(str, 0, str.length(), str2, z, z2, z3, z4, null) : (String) invokeCommon.objValue;
    }
}
