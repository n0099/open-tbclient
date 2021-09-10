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
    public final z f64819a;

    /* renamed from: b  reason: collision with root package name */
    public final x f64820b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64821c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64822d;

    /* renamed from: e  reason: collision with root package name */
    public final r f64823e;

    /* renamed from: f  reason: collision with root package name */
    public final s f64824f;

    /* renamed from: g  reason: collision with root package name */
    public final ac f64825g;

    /* renamed from: h  reason: collision with root package name */
    public final ab f64826h;

    /* renamed from: i  reason: collision with root package name */
    public final ab f64827i;

    /* renamed from: j  reason: collision with root package name */
    public final ab f64828j;
    public final long k;
    public final long l;
    public volatile d m;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public z f64829a;

        /* renamed from: b  reason: collision with root package name */
        public x f64830b;

        /* renamed from: c  reason: collision with root package name */
        public int f64831c;

        /* renamed from: d  reason: collision with root package name */
        public String f64832d;

        /* renamed from: e  reason: collision with root package name */
        public r f64833e;

        /* renamed from: f  reason: collision with root package name */
        public s.a f64834f;

        /* renamed from: g  reason: collision with root package name */
        public ac f64835g;

        /* renamed from: h  reason: collision with root package name */
        public ab f64836h;

        /* renamed from: i  reason: collision with root package name */
        public ab f64837i;

        /* renamed from: j  reason: collision with root package name */
        public ab f64838j;
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
            this.f64831c = -1;
            this.f64834f = new s.a();
        }

        private void d(ab abVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, abVar) == null) && abVar.f64825g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zVar)) == null) {
                this.f64829a = zVar;
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
                this.f64837i = abVar;
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
                this.f64838j = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xVar)) == null) {
                this.f64830b = xVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f64831c = i2;
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
            this.f64831c = -1;
            this.f64829a = abVar.f64819a;
            this.f64830b = abVar.f64820b;
            this.f64831c = abVar.f64821c;
            this.f64832d = abVar.f64822d;
            this.f64833e = abVar.f64823e;
            this.f64834f = abVar.f64824f.c();
            this.f64835g = abVar.f64825g;
            this.f64836h = abVar.f64826h;
            this.f64837i = abVar.f64827i;
            this.f64838j = abVar.f64828j;
            this.k = abVar.k;
            this.l = abVar.l;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f64832d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
                this.f64833e = rVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                this.f64834f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a a(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
                this.f64834f = sVar.c();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, acVar)) == null) {
                this.f64835g = acVar;
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
                this.f64836h = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        private void a(String str, ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, abVar) == null) {
                if (abVar.f64825g == null) {
                    if (abVar.f64826h == null) {
                        if (abVar.f64827i == null) {
                            if (abVar.f64828j == null) {
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
                if (this.f64829a != null) {
                    if (this.f64830b != null) {
                        if (this.f64831c >= 0) {
                            if (this.f64832d != null) {
                                return new ab(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f64831c);
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
        this.f64819a = aVar.f64829a;
        this.f64820b = aVar.f64830b;
        this.f64821c = aVar.f64831c;
        this.f64822d = aVar.f64832d;
        this.f64823e = aVar.f64833e;
        this.f64824f = aVar.f64834f.a();
        this.f64825g = aVar.f64835g;
        this.f64826h = aVar.f64836h;
        this.f64827i = aVar.f64837i;
        this.f64828j = aVar.f64838j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64819a : (z) invokeV.objValue;
    }

    public x b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64820b : (x) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64821c : invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ac acVar = this.f64825g;
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
            int i2 = this.f64821c;
            return i2 >= 200 && i2 < 300;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64822d : (String) invokeV.objValue;
    }

    public r f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64823e : (r) invokeV.objValue;
    }

    public s g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64824f : (s) invokeV.objValue;
    }

    public ac h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64825g : (ac) invokeV.objValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public ab j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64828j : (ab) invokeV.objValue;
    }

    public d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d dVar = this.m;
            if (dVar != null) {
                return dVar;
            }
            d a2 = d.a(this.f64824f);
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
            return "Response{protocol=" + this.f64820b + ", code=" + this.f64821c + ", message=" + this.f64822d + ", url=" + this.f64819a.a() + ExtendedMessageFormat.END_FE;
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
            String a2 = this.f64824f.a(str);
            return a2 != null ? a2 : str2;
        }
        return (String) invokeLL.objValue;
    }
}
