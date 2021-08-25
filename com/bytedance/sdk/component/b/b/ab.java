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
    public final z f64639a;

    /* renamed from: b  reason: collision with root package name */
    public final x f64640b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64641c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64642d;

    /* renamed from: e  reason: collision with root package name */
    public final r f64643e;

    /* renamed from: f  reason: collision with root package name */
    public final s f64644f;

    /* renamed from: g  reason: collision with root package name */
    public final ac f64645g;

    /* renamed from: h  reason: collision with root package name */
    public final ab f64646h;

    /* renamed from: i  reason: collision with root package name */
    public final ab f64647i;

    /* renamed from: j  reason: collision with root package name */
    public final ab f64648j;
    public final long k;
    public final long l;
    public volatile d m;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public z f64649a;

        /* renamed from: b  reason: collision with root package name */
        public x f64650b;

        /* renamed from: c  reason: collision with root package name */
        public int f64651c;

        /* renamed from: d  reason: collision with root package name */
        public String f64652d;

        /* renamed from: e  reason: collision with root package name */
        public r f64653e;

        /* renamed from: f  reason: collision with root package name */
        public s.a f64654f;

        /* renamed from: g  reason: collision with root package name */
        public ac f64655g;

        /* renamed from: h  reason: collision with root package name */
        public ab f64656h;

        /* renamed from: i  reason: collision with root package name */
        public ab f64657i;

        /* renamed from: j  reason: collision with root package name */
        public ab f64658j;
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
            this.f64651c = -1;
            this.f64654f = new s.a();
        }

        private void d(ab abVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, abVar) == null) && abVar.f64645g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zVar)) == null) {
                this.f64649a = zVar;
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
                this.f64657i = abVar;
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
                this.f64658j = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xVar)) == null) {
                this.f64650b = xVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f64651c = i2;
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
            this.f64651c = -1;
            this.f64649a = abVar.f64639a;
            this.f64650b = abVar.f64640b;
            this.f64651c = abVar.f64641c;
            this.f64652d = abVar.f64642d;
            this.f64653e = abVar.f64643e;
            this.f64654f = abVar.f64644f.c();
            this.f64655g = abVar.f64645g;
            this.f64656h = abVar.f64646h;
            this.f64657i = abVar.f64647i;
            this.f64658j = abVar.f64648j;
            this.k = abVar.k;
            this.l = abVar.l;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f64652d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
                this.f64653e = rVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                this.f64654f.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a a(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
                this.f64654f = sVar.c();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(ac acVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, acVar)) == null) {
                this.f64655g = acVar;
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
                this.f64656h = abVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        private void a(String str, ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, abVar) == null) {
                if (abVar.f64645g == null) {
                    if (abVar.f64646h == null) {
                        if (abVar.f64647i == null) {
                            if (abVar.f64648j == null) {
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
                if (this.f64649a != null) {
                    if (this.f64650b != null) {
                        if (this.f64651c >= 0) {
                            if (this.f64652d != null) {
                                return new ab(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.f64651c);
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
        this.f64639a = aVar.f64649a;
        this.f64640b = aVar.f64650b;
        this.f64641c = aVar.f64651c;
        this.f64642d = aVar.f64652d;
        this.f64643e = aVar.f64653e;
        this.f64644f = aVar.f64654f.a();
        this.f64645g = aVar.f64655g;
        this.f64646h = aVar.f64656h;
        this.f64647i = aVar.f64657i;
        this.f64648j = aVar.f64658j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64639a : (z) invokeV.objValue;
    }

    public x b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64640b : (x) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64641c : invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ac acVar = this.f64645g;
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
            int i2 = this.f64641c;
            return i2 >= 200 && i2 < 300;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64642d : (String) invokeV.objValue;
    }

    public r f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64643e : (r) invokeV.objValue;
    }

    public s g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64644f : (s) invokeV.objValue;
    }

    public ac h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64645g : (ac) invokeV.objValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public ab j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64648j : (ab) invokeV.objValue;
    }

    public d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d dVar = this.m;
            if (dVar != null) {
                return dVar;
            }
            d a2 = d.a(this.f64644f);
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
            return "Response{protocol=" + this.f64640b + ", code=" + this.f64641c + ", message=" + this.f64642d + ", url=" + this.f64639a.a() + ExtendedMessageFormat.END_FE;
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
            String a2 = this.f64644f.a(str);
            return a2 != null ? a2 : str2;
        }
        return (String) invokeLL.objValue;
    }
}
