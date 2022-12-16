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
/* loaded from: classes7.dex */
public interface UrlRequest {
    void a(int i);

    void addHeader(String str, String str2);

    void b(int i);

    void c(int i);

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

    void l(int i);

    void read(ByteBuffer byteBuffer);

    void start();

    /* loaded from: classes7.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TurbonetEngine a;
        public final String b;
        public final Callback c;
        public final Executor d;
        public String e;
        public final ArrayList<Pair<String, String>> f;
        public boolean g;
        public boolean h;
        public int i;
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
        /* loaded from: classes7.dex */
        public @interface RequestPriority {
        }

        public Builder(String str, Callback callback, Executor executor, TurbonetEngine turbonetEngine) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, callback, executor, turbonetEngine};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = new ArrayList<>();
            this.i = 3;
            this.j = Collections.emptyList();
            if (str != null) {
                if (callback != null) {
                    if (executor != null) {
                        if (turbonetEngine != null) {
                            this.b = str;
                            this.c = callback;
                            this.d = executor;
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
                    throw new NullPointerException("Executor is required.");
                }
                throw new NullPointerException("Callback is required.");
            }
            throw new NullPointerException("URL is required.");
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
                        this.f.add(Pair.create(str, str2));
                        return this;
                    }
                    throw new NullPointerException("Invalid header value.");
                }
                throw new NullPointerException("Invalid header name.");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder k(UploadDataProvider uploadDataProvider, Executor executor) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uploadDataProvider, executor)) == null) {
                if (uploadDataProvider != null) {
                    if (executor != null) {
                        if (this.e == null) {
                            this.e = "POST";
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

        public UrlRequest b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                UrlRequest b = this.a.b(this.b, this.c, this.d, this.i, this.j, this.g, this.h, this.n);
                String str = this.e;
                if (str != null) {
                    b.e(str);
                }
                Iterator<Pair<String, String>> it = this.f.iterator();
                while (it.hasNext()) {
                    Pair<String, String> next = it.next();
                    b.addHeader((String) next.first, (String) next.second);
                }
                UploadDataProvider uploadDataProvider = this.k;
                if (uploadDataProvider != null) {
                    b.i(uploadDataProvider, this.l);
                }
                if (this.m) {
                    b.h();
                }
                if (this.o) {
                    b.g();
                }
                int i = this.p;
                if (i > 0) {
                    b.b(i);
                }
                int i2 = this.q;
                if (i2 > 0) {
                    b.l(i2);
                }
                int i3 = this.r;
                if (i3 > 0) {
                    b.c(i3);
                }
                int i4 = this.s;
                if (i4 > 0) {
                    b.a(i4);
                }
                Object obj = this.t;
                if (obj != null) {
                    b.f(obj);
                }
                if (!TextUtils.isEmpty(this.u)) {
                    b.k(this.u);
                }
                if (!TextUtils.isEmpty(this.v)) {
                    b.j(this.v);
                }
                return b;
            }
            return (UrlRequest) invokeV.objValue;
        }

        public Builder c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.g = true;
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

        public Builder l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                this.n = true;
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
                    this.e = str;
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

        public Builder h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.r = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.q = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.p = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class Status {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                switch (i) {
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

    /* loaded from: classes7.dex */
    public static abstract class StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(int i);

        public StatusListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
