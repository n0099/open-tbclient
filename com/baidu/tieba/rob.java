package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class rob extends wob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int d;
    public final UploadDataProvider e;
    public ByteBuffer f;
    public boolean g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.wob
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rob a;

        public b(rob robVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {robVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = robVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void c(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                this.a.f.position(0);
                uploadDataSink.c();
            }
        }

        public /* synthetic */ b(rob robVar, a aVar) {
            this(robVar);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            int position;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.d == -1) {
                    if (this.a.g) {
                        position = this.a.f.limit();
                    } else {
                        position = this.a.f.position();
                    }
                    return position;
                }
                return this.a.d;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining < this.a.f.remaining()) {
                    byteBuffer.put(this.a.f.array(), this.a.f.position(), remaining);
                    this.a.f.position(this.a.f.position() + remaining);
                } else {
                    byteBuffer.put(this.a.f);
                }
                uploadDataSink.a(false);
            }
        }
    }

    public rob(uob uobVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uobVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new b(this, null);
        if (uobVar != null) {
            this.d = -1;
            this.f = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }

    public rob(uob uobVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uobVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new b(this, null);
        if (uobVar != null) {
            if (j <= 2147483647L) {
                if (j >= 0) {
                    int i3 = (int) j;
                    this.d = i3;
                    this.f = ByteBuffer.allocate(i3);
                    return;
                }
                throw new IllegalArgumentException("Content length < 0.");
            }
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        throw new NullPointerException("Argument connection cannot be null.");
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            c();
            o(1);
            this.f.put((byte) i);
        }
    }

    @Override // com.baidu.tieba.wob
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (UploadDataProvider) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wob
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = true;
            if (this.f.position() >= this.d) {
                this.f.flip();
                return;
            }
            throw new ProtocolException("Content received is less than Content-Length");
        }
    }

    public final void o(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.d != -1 && this.f.position() + i > this.d) {
                throw new ProtocolException("exceeded content-length limit of " + this.d + " bytes");
            } else if (!this.g) {
                if (this.d != -1 || this.f.limit() - this.f.position() > i) {
                    return;
                }
                ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.f.capacity() * 2, this.f.capacity() + i));
                this.f.flip();
                allocate.put(this.f);
                this.f = allocate;
            } else {
                throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
            c();
            o(i2);
            this.f.put(bArr, i, i2);
        }
    }
}
