package com.baidu.turbonet.net;

import android.text.TextUtils;
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
/* loaded from: classes6.dex */
public interface UrlRequest {

    /* loaded from: classes6.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TurbonetEngine a;

        /* renamed from: b  reason: collision with root package name */
        public final String f48885b;

        /* renamed from: c  reason: collision with root package name */
        public final Callback f48886c;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f48887d;

        /* renamed from: e  reason: collision with root package name */
        public String f48888e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<Pair<String, String>> f48889f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48890g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f48891h;

        /* renamed from: i  reason: collision with root package name */
        public int f48892i;

        /* renamed from: j  reason: collision with root package name */
        public Collection<Object> f48893j;
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
        /* loaded from: classes6.dex */
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
            this.f48889f = new ArrayList<>();
            this.f48892i = 3;
            this.f48893j = Collections.emptyList();
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
                this.f48885b = str;
                this.f48886c = callback;
                this.f48887d = executor;
                this.a = turbonetEngine;
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
                            return this;
                        }
                        this.f48889f.add(Pair.create(str, str2));
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
                UrlRequest b2 = this.a.b(this.f48885b, this.f48886c, this.f48887d, this.f48892i, this.f48893j, this.f48890g, this.f48891h, this.n);
                String str = this.f48888e;
                if (str != null) {
                    b2.e(str);
                }
                Iterator<Pair<String, String>> it = this.f48889f.iterator();
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
                this.f48890g = true;
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
                    this.f48888e = str;
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
                        if (this.f48888e == null) {
                            this.f48888e = "POST";
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class Status {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
