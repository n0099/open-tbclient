package com.baidu.turbonet.net;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public interface UrlRequest {

    /* loaded from: classes4.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TurbonetEngine f23231a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23232b;

        /* renamed from: c  reason: collision with root package name */
        public final Callback f23233c;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f23234d;

        /* renamed from: e  reason: collision with root package name */
        public String f23235e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<Pair<String, String>> f23236f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23237g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f23238h;

        /* renamed from: i  reason: collision with root package name */
        public int f23239i;
        public Collection<Object> j;
        public UploadDataProvider k;
        public Executor l;
        public boolean m;
        public boolean n;
        public boolean o;
        public int p;
        public int q;
        public int r;
        public int s;
        public Object t;
        public String u;
        public String v;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
        public @interface RequestPriority {
        }

        public Builder(String str, Callback callback, Executor executor, TurbonetEngine turbonetEngine) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, callback, executor, turbonetEngine};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23236f = new ArrayList<>();
            this.f23239i = 3;
            this.j = Collections.emptyList();
            if (str == null) {
                throw new NullPointerException("URL is required.");
            }
            if (callback == null) {
                throw new NullPointerException("Callback is required.");
            }
            if (executor == null) {
                throw new NullPointerException("Executor is required.");
            }
            if (turbonetEngine != null) {
                this.f23232b = str;
                this.f23233c = callback;
                this.f23234d = executor;
                this.f23231a = turbonetEngine;
                this.m = false;
                this.o = false;
                this.p = 0;
                this.q = 0;
                this.r = 0;
                this.s = 0;
                this.t = null;
                this.u = null;
                this.v = null;
                return;
            }
            throw new NullPointerException("TurbonetEngine is required.");
        }

        public Builder a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (str != null) {
                    if (str2 != null) {
                        if ("Accept-Encoding".equalsIgnoreCase(str)) {
                            Log.w("cronet", "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
                            return this;
                        }
                        this.f23236f.add(Pair.create(str, str2));
                        return this;
                    }
                    throw new NullPointerException("Invalid header value.");
                }
                throw new NullPointerException("Invalid header name.");
            }
            return (Builder) invokeLL.objValue;
        }

        public UrlRequest b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                UrlRequest b2 = this.f23231a.b(this.f23232b, this.f23233c, this.f23234d, this.f23239i, this.j, this.f23237g, this.f23238h, this.n);
                String str = this.f23235e;
                if (str != null) {
                    b2.e(str);
                }
                Iterator<Pair<String, String>> it = this.f23236f.iterator();
                while (it.hasNext()) {
                    Pair<String, String> next = it.next();
                    b2.addHeader((String) next.first, (String) next.second);
                }
                UploadDataProvider uploadDataProvider = this.k;
                if (uploadDataProvider != null) {
                    b2.i(uploadDataProvider, this.l);
                }
                if (this.m) {
                    b2.h();
                }
                if (this.o) {
                    b2.g();
                }
                int i2 = this.p;
                if (i2 > 0) {
                    b2.b(i2);
                }
                int i3 = this.q;
                if (i3 > 0) {
                    b2.l(i3);
                }
                int i4 = this.r;
                if (i4 > 0) {
                    b2.c(i4);
                }
                int i5 = this.s;
                if (i5 > 0) {
                    b2.a(i5);
                }
                Object obj = this.t;
                if (obj != null) {
                    b2.f(obj);
                }
                if (!TextUtils.isEmpty(this.u)) {
                    b2.k(this.u);
                }
                if (!TextUtils.isEmpty(this.v)) {
                    b2.j(this.v);
                }
                return b2;
            }
            return (UrlRequest) invokeV.objValue;
        }

        public Builder c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f23237g = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.m = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.u = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str != null) {
                    this.f23235e = str;
                    return this;
                }
                throw new NullPointerException("Method is required.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.v = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.r = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.q = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder j(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.p = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder k(UploadDataProvider uploadDataProvider, Executor executor) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uploadDataProvider, executor)) == null) {
                if (uploadDataProvider != null) {
                    if (executor != null) {
                        if (this.f23235e == null) {
                            this.f23235e = "POST";
                        }
                        this.k = uploadDataProvider;
                        this.l = executor;
                        return this;
                    }
                    throw new NullPointerException("Invalid UploadDataProvider Executor.");
                }
                throw new NullPointerException("Invalid UploadDataProvider.");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                this.n = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
            }
        }

        public abstract void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

        public abstract void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void d(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);
    }

    /* loaded from: classes4.dex */
    public static class Status {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
        public @interface StatusValues {
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1379236295, "Lcom/baidu/turbonet/net/UrlRequest$Status;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1379236295, "Lcom/baidu/turbonet/net/UrlRequest$Status;");
            }
        }

        public Status() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                switch (i2) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                    default:
                        throw new IllegalArgumentException("No request status found.");
                    case 6:
                        return 5;
                    case 7:
                        return 6;
                    case 8:
                        return 7;
                    case 9:
                        return 8;
                    case 10:
                        return 9;
                    case 11:
                        return 10;
                    case 12:
                        return 11;
                    case 13:
                        return 12;
                    case 14:
                        return 13;
                    case 15:
                        return 14;
                }
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public StatusListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(int i2);
    }

    void a(int i2);

    void addHeader(String str, String str2);

    void b(int i2);

    void c(int i2);

    void cancel();

    void d();

    void e(String str);

    void f(Object obj);

    void g();

    Object getTag();

    void h();

    void i(UploadDataProvider uploadDataProvider, Executor executor);

    void j(String str);

    void k(String str);

    void l(int i2);

    void read(ByteBuffer byteBuffer);

    void start();
}
