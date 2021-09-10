package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.s;
import java.net.URL;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes9.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f65009a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65010b;

    /* renamed from: c  reason: collision with root package name */
    public final s f65011c;

    /* renamed from: d  reason: collision with root package name */
    public final aa f65012d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f65013e;

    /* renamed from: f  reason: collision with root package name */
    public volatile d f65014f;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public t f65015a;

        /* renamed from: b  reason: collision with root package name */
        public String f65016b;

        /* renamed from: c  reason: collision with root package name */
        public s.a f65017c;

        /* renamed from: d  reason: collision with root package name */
        public aa f65018d;

        /* renamed from: e  reason: collision with root package name */
        public Object f65019e;

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
            this.f65016b = "GET";
            this.f65017c = new s.a();
        }

        public a a(t tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tVar)) == null) {
                if (tVar != null) {
                    this.f65015a = tVar;
                    return this;
                }
                throw new NullPointerException("url == null");
            }
            return (a) invokeL.objValue;
        }

        public a b(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
                this.f65017c.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? b(com.bytedance.sdk.component.b.b.a.c.f64546d) : (a) invokeV.objValue;
        }

        public a d(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aaVar)) == null) ? a("PATCH", aaVar) : (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f65017c.b(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aaVar)) == null) ? a(HttpPut.METHOD_NAME, aaVar) : (a) invokeL.objValue;
        }

        public z d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (this.f65015a != null) {
                    return new z(this);
                }
                throw new IllegalStateException("url == null");
            }
            return (z) invokeV.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (str != null) {
                    if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                    } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                    }
                    t e2 = t.e(str);
                    if (e2 != null) {
                        return a(e2);
                    }
                    throw new IllegalArgumentException("unexpected url: " + str);
                }
                throw new NullPointerException("url == null");
            }
            return (a) invokeL.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? a("HEAD", (aa) null) : (a) invokeV.objValue;
        }

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f65015a = zVar.f65009a;
            this.f65016b = zVar.f65010b;
            this.f65018d = zVar.f65012d;
            this.f65019e = zVar.f65013e;
            this.f65017c = zVar.f65011c.c();
        }

        public a b(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aaVar)) == null) ? a(HttpDelete.METHOD_NAME, aaVar) : (a) invokeL.objValue;
        }

        public a a(URL url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, url)) == null) {
                if (url != null) {
                    t a2 = t.a(url);
                    if (a2 != null) {
                        return a(a2);
                    }
                    throw new IllegalArgumentException("unexpected url: " + url);
                }
                throw new NullPointerException("url == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                this.f65017c.c(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a a(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sVar)) == null) {
                this.f65017c = sVar.c();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
                String dVar2 = dVar.toString();
                return dVar2.isEmpty() ? b("Cache-Control") : a("Cache-Control", dVar2);
            }
            return (a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a("GET", (aa) null) : (a) invokeV.objValue;
        }

        public a a(aa aaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aaVar)) == null) ? a("POST", aaVar) : (a) invokeL.objValue;
        }

        public a a(String str, aa aaVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, aaVar)) == null) {
                if (str != null) {
                    if (str.length() != 0) {
                        if (aaVar != null && !com.bytedance.sdk.component.b.b.a.c.f.c(str)) {
                            throw new IllegalArgumentException("method " + str + " must not have a request body.");
                        } else if (aaVar == null && com.bytedance.sdk.component.b.b.a.c.f.b(str)) {
                            throw new IllegalArgumentException("method " + str + " must have a request body.");
                        } else {
                            this.f65016b = str;
                            this.f65018d = aaVar;
                            return this;
                        }
                    }
                    throw new IllegalArgumentException("method.length() == 0");
                }
                throw new NullPointerException("method == null");
            }
            return (a) invokeLL.objValue;
        }

        public a a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                this.f65019e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public z(a aVar) {
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
        this.f65009a = aVar.f65015a;
        this.f65010b = aVar.f65016b;
        this.f65011c = aVar.f65017c.a();
        this.f65012d = aVar.f65018d;
        Object obj = aVar.f65019e;
        this.f65013e = obj == null ? this : obj;
    }

    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65009a : (t) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65010b : (String) invokeV.objValue;
    }

    public s c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65011c : (s) invokeV.objValue;
    }

    public aa d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65012d : (aa) invokeV.objValue;
    }

    public Object e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65013e : invokeV.objValue;
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f65014f;
            if (dVar != null) {
                return dVar;
            }
            d a2 = d.a(this.f65011c);
            this.f65014f = a2;
            return a2;
        }
        return (d) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f65009a.d() : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Request{method=");
            sb.append(this.f65010b);
            sb.append(", url=");
            sb.append(this.f65009a);
            sb.append(", tag=");
            Object obj = this.f65013e;
            if (obj == this) {
                obj = null;
            }
            sb.append(obj);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f65011c.a(str) : (String) invokeL.objValue;
    }
}
