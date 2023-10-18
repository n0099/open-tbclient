package com.baidu.tieba;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class w6b extends z6b {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static int i = 16384;
    public transient /* synthetic */ FieldHolder $fh;
    public final a7b d;
    public final long e;
    public final ByteBuffer f;
    public final UploadDataProvider g;
    public long h;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948223942, "Lcom/baidu/tieba/w6b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948223942, "Lcom/baidu/tieba/w6b;");
        }
    }

    @Override // com.baidu.tieba.z6b
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w6b a;

        public b(w6b w6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w6bVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void c(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
            }
        }

        public /* synthetic */ b(w6b w6bVar, a aVar) {
            this(w6bVar);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.e;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.a.f.remaining()) {
                    byteBuffer.put(this.a.f);
                    this.a.f.clear();
                    uploadDataSink.a(false);
                    this.a.d.quit();
                    return;
                }
                int limit = this.a.f.limit();
                this.a.f.limit(this.a.f.position() + byteBuffer.remaining());
                byteBuffer.put(this.a.f);
                this.a.f.limit(limit);
                uploadDataSink.a(false);
            }
        }
    }

    public w6b(x6b x6bVar, long j, a7b a7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x6bVar, Long.valueOf(j), a7bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new b(this, null);
        if (x6bVar != null) {
            if (j >= 0) {
                this.e = j;
                this.f = ByteBuffer.allocate((int) Math.min(j, i));
                this.d = a7bVar;
                this.h = 0L;
                return;
            }
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        throw null;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            c();
            o(1);
            p();
            this.f.put((byte) i2);
            this.h++;
            r();
        }
    }

    @Override // com.baidu.tieba.z6b
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.h >= this.e) {
            return;
        }
        throw new ProtocolException("Content received is less than Content-Length.");
    }

    @Override // com.baidu.tieba.z6b
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (UploadDataProvider) invokeV.objValue;
    }

    public final void p() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.f.hasRemaining()) {
            q();
        }
    }

    public final void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c();
            this.f.flip();
            this.d.a();
            a();
        }
    }

    public final void r() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.h == this.e) {
            q();
        }
    }

    public final void o(int i2) throws ProtocolException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i2) != null) || this.h + i2 <= this.e) {
            return;
        }
        throw new ProtocolException("expected " + (this.e - this.h) + " bytes but received " + i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            c();
            if (bArr.length - i2 >= i3 && i2 >= 0 && i3 >= 0) {
                o(i3);
                int i4 = i3;
                while (i4 > 0) {
                    p();
                    int min = Math.min(i4, this.f.remaining());
                    this.f.put(bArr, (i2 + i3) - i4, min);
                    i4 -= min;
                }
                this.h += i3;
                r();
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
