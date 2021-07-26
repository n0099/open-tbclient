package com.bytedance.sdk.component.b.b;

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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f28619a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f28620b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f28621c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28622d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28623e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28624f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28625g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f28626h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f28627i;
    public final boolean j;
    public final int k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28628a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28629b;

        /* renamed from: c  reason: collision with root package name */
        public int f28630c;

        /* renamed from: d  reason: collision with root package name */
        public int f28631d;

        /* renamed from: e  reason: collision with root package name */
        public int f28632e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28633f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28634g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28635h;

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
            this.f28630c = -1;
            this.f28631d = -1;
            this.f28632e = -1;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f28628a = true;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f28633f = true;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public d c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new d(this) : (d) invokeV.objValue;
        }

        public a a(int i2, TimeUnit timeUnit) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, timeUnit)) == null) {
                if (i2 >= 0) {
                    long seconds = timeUnit.toSeconds(i2);
                    this.f28631d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                    return this;
                }
                throw new IllegalArgumentException("maxStale < 0: " + i2);
            }
            return (a) invokeIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731368630, "Lcom/bytedance/sdk/component/b/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731368630, "Lcom/bytedance/sdk/component/b/b/d;");
                return;
            }
        }
        f28619a = new a().a().c();
        f28620b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    }

    public d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28622d = z;
        this.f28623e = z2;
        this.f28624f = i2;
        this.f28625g = i3;
        this.f28626h = z3;
        this.f28627i = z4;
        this.j = z5;
        this.k = i4;
        this.l = i5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.f28621c = str;
    }

    private String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f28622d) {
                sb.append("no-cache, ");
            }
            if (this.f28623e) {
                sb.append("no-store, ");
            }
            if (this.f28624f != -1) {
                sb.append("max-age=");
                sb.append(this.f28624f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28625g != -1) {
                sb.append("s-maxage=");
                sb.append(this.f28625g);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28626h) {
                sb.append("private, ");
            }
            if (this.f28627i) {
                sb.append("public, ");
            }
            if (this.j) {
                sb.append("must-revalidate, ");
            }
            if (this.k != -1) {
                sb.append("max-stale=");
                sb.append(this.k);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.l != -1) {
                sb.append("min-fresh=");
                sb.append(this.l);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.m) {
                sb.append("only-if-cached, ");
            }
            if (this.n) {
                sb.append("no-transform, ");
            }
            if (this.o) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28622d : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28623e : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28624f : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28626h : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28627i : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.f28621c;
            if (str != null) {
                return str;
            }
            String k = k();
            this.f28621c = k;
            return k;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d a(s sVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sVar)) == null) {
            s sVar2 = sVar;
            int a2 = sVar.a();
            int i4 = 0;
            boolean z = true;
            String str2 = null;
            boolean z2 = false;
            boolean z3 = false;
            int i5 = -1;
            int i6 = -1;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i7 = -1;
            int i8 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            while (i4 < a2) {
                String a3 = sVar2.a(i4);
                String b2 = sVar2.b(i4);
                if (a3.equalsIgnoreCase("Cache-Control")) {
                    if (str2 == null) {
                        str2 = b2;
                        for (i2 = 0; i2 < b2.length(); i2 = i3) {
                            int a4 = com.bytedance.sdk.component.b.b.a.c.e.a(b2, i2, "=,;");
                            String trim = b2.substring(i2, a4).trim();
                            if (a4 == b2.length() || b2.charAt(a4) == ',' || b2.charAt(a4) == ';') {
                                i3 = a4 + 1;
                                str = null;
                            } else {
                                int a5 = com.bytedance.sdk.component.b.b.a.c.e.a(b2, a4 + 1);
                                if (a5 < b2.length() && b2.charAt(a5) == '\"') {
                                    int i9 = a5 + 1;
                                    int a6 = com.bytedance.sdk.component.b.b.a.c.e.a(b2, i9, "\"");
                                    str = b2.substring(i9, a6);
                                    i3 = a6 + 1;
                                } else {
                                    i3 = com.bytedance.sdk.component.b.b.a.c.e.a(b2, a5, ",;");
                                    str = b2.substring(a5, i3).trim();
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(trim)) {
                                z2 = true;
                            } else if ("no-store".equalsIgnoreCase(trim)) {
                                z3 = true;
                            } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                                i5 = com.bytedance.sdk.component.b.b.a.c.e.b(str, -1);
                            } else if ("s-maxage".equalsIgnoreCase(trim)) {
                                i6 = com.bytedance.sdk.component.b.b.a.c.e.b(str, -1);
                            } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                                z4 = true;
                            } else if ("public".equalsIgnoreCase(trim)) {
                                z5 = true;
                            } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                                z6 = true;
                            } else if ("max-stale".equalsIgnoreCase(trim)) {
                                i7 = com.bytedance.sdk.component.b.b.a.c.e.b(str, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(trim)) {
                                i8 = com.bytedance.sdk.component.b.b.a.c.e.b(str, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                                z7 = true;
                            } else if ("no-transform".equalsIgnoreCase(trim)) {
                                z8 = true;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z9 = true;
                            }
                        }
                        i4++;
                        sVar2 = sVar;
                    }
                } else if (!a3.equalsIgnoreCase("Pragma")) {
                    i4++;
                    sVar2 = sVar;
                }
                z = false;
                while (i2 < b2.length()) {
                }
                i4++;
                sVar2 = sVar;
            }
            return new d(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
        }
        return (d) invokeL.objValue;
    }

    public d(a aVar) {
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
        this.f28622d = aVar.f28628a;
        this.f28623e = aVar.f28629b;
        this.f28624f = aVar.f28630c;
        this.f28625g = -1;
        this.f28626h = false;
        this.f28627i = false;
        this.j = false;
        this.k = aVar.f28631d;
        this.l = aVar.f28632e;
        this.m = aVar.f28633f;
        this.n = aVar.f28634g;
        this.o = aVar.f28635h;
    }
}
