package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.s;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class ab implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final z f28585a;

    /* renamed from: b  reason: collision with root package name */
    public final x f28586b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28587c;

    /* renamed from: d  reason: collision with root package name */
    public final String f28588d;

    /* renamed from: e  reason: collision with root package name */
    public final r f28589e;

    /* renamed from: f  reason: collision with root package name */
    public final s f28590f;

    /* renamed from: g  reason: collision with root package name */
    public final ac f28591g;

    /* renamed from: h  reason: collision with root package name */
    public final ab f28592h;

    /* renamed from: i  reason: collision with root package name */
    public final ab f28593i;
    public final ab j;
    public final long k;
    public final long l;
    public volatile d m;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public z f28594a;

        /* renamed from: b  reason: collision with root package name */
        public x f28595b;

        /* renamed from: c  reason: collision with root package name */
        public int f28596c;

        /* renamed from: d  reason: collision with root package name */
        public String f28597d;

        /* renamed from: e  reason: collision with root package name */
        public r f28598e;

        /* renamed from: f  reason: collision with root package name */
        public s.a f28599f;

        /* renamed from: g  reason: collision with root package name */
        public ac f28600g;

        /* renamed from: h  reason: collision with root package name */
        public ab f28601h;

        /* renamed from: i  reason: collision with root package name */
        public ab f28602i;
        public ab j;
        public long k;
        public long l;

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
            this.f28596c = -1;
            this.f28599f = new s.a();
        }

        private void d(ab abVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, abVar) == null) && abVar.f28591g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zVar)) == null) {
                this.f28594a = zVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(ab abVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, abVar)) == null) {
                if (abVar != null) {
                    a("cacheResponse", abVar);
                }
                this.f28602i = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(ab abVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, abVar)) == null) {
                if (abVar != null) {
                    d(abVar);
                }
                this.j = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xVar)) == null) {
                this.f28595b = xVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f28596c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
                this.l = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a(ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28596c = -1;
            this.f28594a = abVar.f28585a;
            this.f28595b = abVar.f28586b;
            this.f28596c = abVar.f28587c;
            this.f28597d = abVar.f28588d;
            this.f28598e = abVar.f28589e;
            this.f28599f = abVar.f28590f.c();
            this.f28600g = abVar.f28591g;
            this.f28601h = abVar.f28592h;
            this.f28602i = abVar.f28593i;
            this.j = abVar.j;
            this.k = abVar.k;
            this.l = abVar.l;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f28597d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
                this.f28598e = rVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                this.f28599f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a a(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
                this.f28599f = sVar.c();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, acVar)) == null) {
                this.f28600g = acVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(ab abVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, abVar)) == null) {
                if (abVar != null) {
                    a("networkResponse", abVar);
                }
                this.f28601h = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        private void a(String str, ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, abVar) == null) {
                if (abVar.f28591g == null) {
                    if (abVar.f28592h == null) {
                        if (abVar.f28593i == null) {
                            if (abVar.j == null) {
                                return;
                            }
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        throw new IllegalArgumentException(str + ".cacheResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".networkResponse != null");
                }
                throw new IllegalArgumentException(str + ".body != null");
            }
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.k = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public ab a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.f28594a != null) {
                    if (this.f28595b != null) {
                        if (this.f28596c >= 0) {
                            if (this.f28597d != null) {
                                return new ab(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f28596c);
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            return (ab) invokeV.objValue;
        }
    }

    public ab(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28585a = aVar.f28594a;
        this.f28586b = aVar.f28595b;
        this.f28587c = aVar.f28596c;
        this.f28588d = aVar.f28597d;
        this.f28589e = aVar.f28598e;
        this.f28590f = aVar.f28599f.a();
        this.f28591g = aVar.f28600g;
        this.f28592h = aVar.f28601h;
        this.f28593i = aVar.f28602i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28585a : (z) invokeV.objValue;
    }

    public x b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28586b : (x) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28587c : invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ac acVar = this.f28591g;
            if (acVar != null) {
                acVar.close();
                return;
            }
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f28587c;
            return i2 >= 200 && i2 < 300;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28588d : (String) invokeV.objValue;
    }

    public r f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28589e : (r) invokeV.objValue;
    }

    public s g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28590f : (s) invokeV.objValue;
    }

    public ac h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28591g : (ac) invokeV.objValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public ab j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (ab) invokeV.objValue;
    }

    public d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d dVar = this.m;
            if (dVar != null) {
                return dVar;
            }
            d a2 = d.a(this.f28590f);
            this.m = a2;
            return a2;
        }
        return (d) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "Response{protocol=" + this.f28586b + ", code=" + this.f28587c + ", message=" + this.f28588d + ", url=" + this.f28585a.a() + '}';
        }
        return (String) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a(str, null) : (String) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = this.f28590f.a(str);
            return a2 != null ? a2 : str2;
        }
        return (String) invokeLL.objValue;
    }
}
