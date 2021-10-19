package com.bytedance.sdk.component.b.b.a.e;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.bytedance.sdk.component.b.a.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c[] f64971a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<com.bytedance.sdk.component.b.a.f, Integer> f64972b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c[] f64973a;

        /* renamed from: b  reason: collision with root package name */
        public int f64974b;

        /* renamed from: c  reason: collision with root package name */
        public int f64975c;

        /* renamed from: d  reason: collision with root package name */
        public int f64976d;

        /* renamed from: e  reason: collision with root package name */
        public final List<c> f64977e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.e f64978f;

        /* renamed from: g  reason: collision with root package name */
        public final int f64979g;

        /* renamed from: h  reason: collision with root package name */
        public int f64980h;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(int i2, s sVar) {
            this(i2, i2, sVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), sVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (s) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f64973a.length;
                    while (true) {
                        length--;
                        if (length < this.f64974b || i2 <= 0) {
                            break;
                        }
                        c[] cVarArr = this.f64973a;
                        i2 -= cVarArr[length].f64970i;
                        this.f64976d -= cVarArr[length].f64970i;
                        this.f64975c--;
                        i3++;
                    }
                    c[] cVarArr2 = this.f64973a;
                    int i4 = this.f64974b;
                    System.arraycopy(cVarArr2, i4 + 1, cVarArr2, i4 + 1 + i3, this.f64975c);
                    this.f64974b += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        private int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) ? this.f64974b + 1 + i2 : invokeI.intValue;
        }

        private void d() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (i2 = this.f64980h) >= (i3 = this.f64976d)) {
                return;
            }
            if (i2 == 0) {
                e();
            } else {
                a(i3 - i2);
            }
        }

        private void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, this) == null) {
                Arrays.fill(this.f64973a, (Object) null);
                this.f64974b = this.f64973a.length - 1;
                this.f64975c = 0;
                this.f64976d = 0;
            }
        }

        private void f() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, this) == null) {
                this.f64977e.add(new c(d.a(c()), c()));
            }
        }

        private void g() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                a(-1, new c(d.a(c()), c()));
            }
        }

        private int h() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.f64978f.h() & 255 : invokeV.intValue;
        }

        public List<c> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f64977e);
                this.f64977e.clear();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public a(int i2, int i3, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64977e = new ArrayList();
            c[] cVarArr = new c[8];
            this.f64973a = cVarArr;
            this.f64974b = cVarArr.length - 1;
            this.f64975c = 0;
            this.f64976d = 0;
            this.f64979g = i2;
            this.f64980h = i3;
            this.f64978f = com.bytedance.sdk.component.b.a.l.a(sVar);
        }

        public com.bytedance.sdk.component.b.a.f c() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int h2 = h();
                boolean z = (h2 & 128) == 128;
                int a2 = a(h2, 127);
                if (z) {
                    return com.bytedance.sdk.component.b.a.f.a(k.a().a(this.f64978f.g(a2)));
                }
                return this.f64978f.c(a2);
            }
            return (com.bytedance.sdk.component.b.a.f) invokeV.objValue;
        }

        private void b(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
                if (g(i2)) {
                    this.f64977e.add(d.f64971a[i2]);
                    return;
                }
                int c2 = c(i2 - d.f64971a.length);
                if (c2 >= 0) {
                    c[] cVarArr = this.f64973a;
                    if (c2 <= cVarArr.length - 1) {
                        this.f64977e.add(cVarArr[c2]);
                        return;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
        }

        private void d(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
                this.f64977e.add(new c(f(i2), c()));
            }
        }

        private com.bytedance.sdk.component.b.a.f f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i2)) == null) {
                if (g(i2)) {
                    return d.f64971a[i2].f64968g;
                }
                return this.f64973a[c(i2 - d.f64971a.length)].f64968g;
            }
            return (com.bytedance.sdk.component.b.a.f) invokeI.objValue;
        }

        private boolean g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) ? i2 >= 0 && i2 <= d.f64971a.length - 1 : invokeI.booleanValue;
        }

        private void e(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
                a(-1, new c(f(i2), c()));
            }
        }

        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                while (!this.f64978f.e()) {
                    int h2 = this.f64978f.h() & 255;
                    if (h2 == 128) {
                        throw new IOException("index == 0");
                    }
                    if ((h2 & 128) == 128) {
                        b(a(h2, 127) - 1);
                    } else if (h2 == 64) {
                        g();
                    } else if ((h2 & 64) == 64) {
                        e(a(h2, 63) - 1);
                    } else if ((h2 & 32) == 32) {
                        int a2 = a(h2, 31);
                        this.f64980h = a2;
                        if (a2 >= 0 && a2 <= this.f64979g) {
                            d();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.f64980h);
                        }
                    } else if (h2 != 16 && h2 != 0) {
                        d(a(h2, 15) - 1);
                    } else {
                        f();
                    }
                }
            }
        }

        private void a(int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65539, this, i2, cVar) == null) {
                this.f64977e.add(cVar);
                int i3 = cVar.f64970i;
                if (i2 != -1) {
                    i3 -= this.f64973a[c(i2)].f64970i;
                }
                int i4 = this.f64980h;
                if (i3 > i4) {
                    e();
                    return;
                }
                int a2 = a((this.f64976d + i3) - i4);
                if (i2 == -1) {
                    int i5 = this.f64975c + 1;
                    c[] cVarArr = this.f64973a;
                    if (i5 > cVarArr.length) {
                        c[] cVarArr2 = new c[cVarArr.length * 2];
                        System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                        this.f64974b = this.f64973a.length - 1;
                        this.f64973a = cVarArr2;
                    }
                    int i6 = this.f64974b;
                    this.f64974b = i6 - 1;
                    this.f64973a[i6] = cVar;
                    this.f64975c++;
                } else {
                    this.f64973a[i2 + c(i2) + a2] = cVar;
                }
                this.f64976d += i3;
            }
        }

        public int a(int i2, int i3) throws IOException {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeII = interceptable.invokeII(1048576, this, i2, i3)) != null) {
                return invokeII.intValue;
            }
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int h2 = h();
                if ((h2 & 128) == 0) {
                    return i3 + (h2 << i5);
                }
                i3 += (h2 & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f64981a;

        /* renamed from: b  reason: collision with root package name */
        public int f64982b;

        /* renamed from: c  reason: collision with root package name */
        public c[] f64983c;

        /* renamed from: d  reason: collision with root package name */
        public int f64984d;

        /* renamed from: e  reason: collision with root package name */
        public int f64985e;

        /* renamed from: f  reason: collision with root package name */
        public int f64986f;

        /* renamed from: g  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f64987g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f64988h;

        /* renamed from: i  reason: collision with root package name */
        public int f64989i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f64990j;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(com.bytedance.sdk.component.b.a.c cVar) {
            this(4096, true, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (com.bytedance.sdk.component.b.a.c) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                Arrays.fill(this.f64983c, (Object) null);
                this.f64984d = this.f64983c.length - 1;
                this.f64985e = 0;
                this.f64986f = 0;
            }
        }

        private int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f64983c.length;
                    while (true) {
                        length--;
                        if (length < this.f64984d || i2 <= 0) {
                            break;
                        }
                        c[] cVarArr = this.f64983c;
                        i2 -= cVarArr[length].f64970i;
                        this.f64986f -= cVarArr[length].f64970i;
                        this.f64985e--;
                        i3++;
                    }
                    c[] cVarArr2 = this.f64983c;
                    int i4 = this.f64984d;
                    System.arraycopy(cVarArr2, i4 + 1, cVarArr2, i4 + 1 + i3, this.f64985e);
                    c[] cVarArr3 = this.f64983c;
                    int i5 = this.f64984d;
                    Arrays.fill(cVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                    this.f64984d += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public b(int i2, boolean z, com.bytedance.sdk.component.b.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64989i = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f64983c = cVarArr;
            this.f64984d = cVarArr.length - 1;
            this.f64985e = 0;
            this.f64986f = 0;
            this.f64981a = i2;
            this.f64982b = i2;
            this.f64988h = z;
            this.f64987g = cVar;
        }

        private void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
                int i2 = cVar.f64970i;
                int i3 = this.f64982b;
                if (i2 > i3) {
                    a();
                    return;
                }
                b((this.f64986f + i2) - i3);
                int i4 = this.f64985e + 1;
                c[] cVarArr = this.f64983c;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f64984d = this.f64983c.length - 1;
                    this.f64983c = cVarArr2;
                }
                int i5 = this.f64984d;
                this.f64984d = i5 - 1;
                this.f64983c[i5] = cVar;
                this.f64985e++;
                this.f64986f += i2;
            }
        }

        private void b() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (i2 = this.f64982b) >= (i3 = this.f64986f)) {
                return;
            }
            if (i2 == 0) {
                a();
            } else {
                b(i3 - i2);
            }
        }

        public void a(List<c> list) throws IOException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                if (this.f64990j) {
                    int i4 = this.f64989i;
                    if (i4 < this.f64982b) {
                        a(i4, 31, 32);
                    }
                    this.f64990j = false;
                    this.f64989i = Integer.MAX_VALUE;
                    a(this.f64982b, 31, 32);
                }
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    c cVar = list.get(i5);
                    com.bytedance.sdk.component.b.a.f f2 = cVar.f64968g.f();
                    com.bytedance.sdk.component.b.a.f fVar = cVar.f64969h;
                    Integer num = d.f64972b.get(f2);
                    if (num != null) {
                        i2 = num.intValue() + 1;
                        if (i2 > 1 && i2 < 8) {
                            if (com.bytedance.sdk.component.b.b.a.c.a(d.f64971a[i2 - 1].f64969h, fVar)) {
                                i3 = i2;
                            } else if (com.bytedance.sdk.component.b.b.a.c.a(d.f64971a[i2].f64969h, fVar)) {
                                i3 = i2;
                                i2++;
                            }
                        }
                        i3 = i2;
                        i2 = -1;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    if (i2 == -1) {
                        int i6 = this.f64984d + 1;
                        int length = this.f64983c.length;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            if (com.bytedance.sdk.component.b.b.a.c.a(this.f64983c[i6].f64968g, f2)) {
                                if (com.bytedance.sdk.component.b.b.a.c.a(this.f64983c[i6].f64969h, fVar)) {
                                    i2 = d.f64971a.length + (i6 - this.f64984d);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i6 - this.f64984d) + d.f64971a.length;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        a(i2, 127, 128);
                    } else if (i3 == -1) {
                        this.f64987g.i(64);
                        a(f2);
                        a(fVar);
                        a(cVar);
                    } else if (f2.a(c.f64962a) && !c.f64967f.equals(f2)) {
                        a(i3, 15, 0);
                        a(fVar);
                    } else {
                        a(i3, 63, 64);
                        a(fVar);
                        a(cVar);
                    }
                }
            }
        }

        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4) == null) {
                if (i2 < i3) {
                    this.f64987g.i(i2 | i4);
                    return;
                }
                this.f64987g.i(i4 | i3);
                int i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f64987g.i(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                this.f64987g.i(i5);
            }
        }

        public void a(com.bytedance.sdk.component.b.a.f fVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                if (this.f64988h && k.a().a(fVar) < fVar.g()) {
                    com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
                    k.a().a(fVar, cVar);
                    com.bytedance.sdk.component.b.a.f n = cVar.n();
                    a(n.g(), 127, 128);
                    this.f64987g.a(n);
                    return;
                }
                a(fVar.g(), 127, 0);
                this.f64987g.a(fVar);
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f64981a = i2;
                int min = Math.min(i2, 16384);
                int i3 = this.f64982b;
                if (i3 == min) {
                    return;
                }
                if (min < i3) {
                    this.f64989i = Math.min(this.f64989i, min);
                }
                this.f64990j = true;
                this.f64982b = min;
                b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269810, "Lcom/bytedance/sdk/component/b/b/a/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269810, "Lcom/bytedance/sdk/component/b/b/a/e/d;");
                return;
            }
        }
        f64971a = new c[]{new c(c.f64967f, ""), new c(c.f64964c, "GET"), new c(c.f64964c, "POST"), new c(c.f64965d, "/"), new c(c.f64965d, "/index.html"), new c(c.f64966e, "http"), new c(c.f64966e, "https"), new c(c.f64963b, "200"), new c(c.f64963b, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204), new c(c.f64963b, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206), new c(c.f64963b, "304"), new c(c.f64963b, FontParser.sFontWeightDefault), new c(c.f64963b, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH), new c(c.f64963b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(BOSTokenRequest.ACCEPT, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};
        f64972b = a();
    }

    public static Map<com.bytedance.sdk.component.b.a.f, Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Map) invokeV.objValue;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f64971a.length);
        int i2 = 0;
        while (true) {
            c[] cVarArr = f64971a;
            if (i2 < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i2].f64968g)) {
                    linkedHashMap.put(f64971a[i2].f64968g, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    public static com.bytedance.sdk.component.b.a.f a(com.bytedance.sdk.component.b.a.f fVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            int g2 = fVar.g();
            for (int i2 = 0; i2 < g2; i2++) {
                byte a2 = fVar.a(i2);
                if (a2 >= 65 && a2 <= 90) {
                    throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
                }
            }
            return fVar;
        }
        return (com.bytedance.sdk.component.b.a.f) invokeL.objValue;
    }
}
