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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public final class ab implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final z f65130a;

    /* renamed from: b  reason: collision with root package name */
    public final x f65131b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65132c;

    /* renamed from: d  reason: collision with root package name */
    public final String f65133d;

    /* renamed from: e  reason: collision with root package name */
    public final r f65134e;

    /* renamed from: f  reason: collision with root package name */
    public final s f65135f;

    /* renamed from: g  reason: collision with root package name */
    public final ac f65136g;

    /* renamed from: h  reason: collision with root package name */
    public final ab f65137h;

    /* renamed from: i  reason: collision with root package name */
    public final ab f65138i;

    /* renamed from: j  reason: collision with root package name */
    public final ab f65139j;
    public final long k;
    public final long l;
    public volatile d m;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public z f65140a;

        /* renamed from: b  reason: collision with root package name */
        public x f65141b;

        /* renamed from: c  reason: collision with root package name */
        public int f65142c;

        /* renamed from: d  reason: collision with root package name */
        public String f65143d;

        /* renamed from: e  reason: collision with root package name */
        public r f65144e;

        /* renamed from: f  reason: collision with root package name */
        public s.a f65145f;

        /* renamed from: g  reason: collision with root package name */
        public ac f65146g;

        /* renamed from: h  reason: collision with root package name */
        public ab f65147h;

        /* renamed from: i  reason: collision with root package name */
        public ab f65148i;

        /* renamed from: j  reason: collision with root package name */
        public ab f65149j;
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
            this.f65142c = -1;
            this.f65145f = new s.a();
        }

        private void d(ab abVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, abVar) == null) && abVar.f65136g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zVar)) == null) {
                this.f65140a = zVar;
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
                this.f65148i = abVar;
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
                this.f65149j = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xVar)) == null) {
                this.f65141b = xVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f65142c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
                this.l = j2;
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
            this.f65142c = -1;
            this.f65140a = abVar.f65130a;
            this.f65141b = abVar.f65131b;
            this.f65142c = abVar.f65132c;
            this.f65143d = abVar.f65133d;
            this.f65144e = abVar.f65134e;
            this.f65145f = abVar.f65135f.c();
            this.f65146g = abVar.f65136g;
            this.f65147h = abVar.f65137h;
            this.f65148i = abVar.f65138i;
            this.f65149j = abVar.f65139j;
            this.k = abVar.k;
            this.l = abVar.l;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f65143d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
                this.f65144e = rVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                this.f65145f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a a(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
                this.f65145f = sVar.c();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, acVar)) == null) {
                this.f65146g = acVar;
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
                this.f65147h = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        private void a(String str, ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, abVar) == null) {
                if (abVar.f65136g == null) {
                    if (abVar.f65137h == null) {
                        if (abVar.f65138i == null) {
                            if (abVar.f65139j == null) {
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

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.k = j2;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public ab a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.f65140a != null) {
                    if (this.f65141b != null) {
                        if (this.f65142c >= 0) {
                            if (this.f65143d != null) {
                                return new ab(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f65142c);
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
        this.f65130a = aVar.f65140a;
        this.f65131b = aVar.f65141b;
        this.f65132c = aVar.f65142c;
        this.f65133d = aVar.f65143d;
        this.f65134e = aVar.f65144e;
        this.f65135f = aVar.f65145f.a();
        this.f65136g = aVar.f65146g;
        this.f65137h = aVar.f65147h;
        this.f65138i = aVar.f65148i;
        this.f65139j = aVar.f65149j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65130a : (z) invokeV.objValue;
    }

    public x b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65131b : (x) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65132c : invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ac acVar = this.f65136g;
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
            int i2 = this.f65132c;
            return i2 >= 200 && i2 < 300;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65133d : (String) invokeV.objValue;
    }

    public r f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f65134e : (r) invokeV.objValue;
    }

    public s g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f65135f : (s) invokeV.objValue;
    }

    public ac h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f65136g : (ac) invokeV.objValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public ab j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f65139j : (ab) invokeV.objValue;
    }

    public d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d dVar = this.m;
            if (dVar != null) {
                return dVar;
            }
            d a2 = d.a(this.f65135f);
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
            return "Response{protocol=" + this.f65131b + ", code=" + this.f65132c + ", message=" + this.f65133d + ", url=" + this.f65130a.a() + ExtendedMessageFormat.END_FE;
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
            String a2 = this.f65135f.a(str);
            return a2 != null ? a2 : str2;
        }
        return (String) invokeLL.objValue;
    }
}
