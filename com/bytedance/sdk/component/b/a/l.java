package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes9.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f64245a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731339087, "Lcom/bytedance/sdk/component/b/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731339087, "Lcom/bytedance/sdk/component/b/a/l;");
                return;
            }
        }
        f64245a = Logger.getLogger(l.class.getName());
    }

    public l() {
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

    public static e a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sVar)) == null) ? new n(sVar) : (e) invokeL.objValue;
    }

    public static s b(Socket socket) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, socket)) == null) {
            if (socket != null) {
                if (socket.getInputStream() != null) {
                    a c2 = c(socket);
                    return c2.a(a(socket.getInputStream(), c2));
                }
                throw new IOException("socket's input stream == null");
            }
            throw new IllegalArgumentException("socket == null");
        }
        return (s) invokeL.objValue;
    }

    public static a c(Socket socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, socket)) == null) ? new a(socket) { // from class: com.bytedance.sdk.component.b.a.l.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Socket f64250b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {socket};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64250b = socket;
            }

            @Override // com.bytedance.sdk.component.b.a.a
            public void a_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.f64250b.close();
                    } catch (AssertionError e2) {
                        if (l.a(e2)) {
                            Logger logger = l.f64245a;
                            Level level = Level.WARNING;
                            logger.log(level, "Failed to close timed out socket " + this.f64250b, (Throwable) e2);
                            return;
                        }
                        throw e2;
                    } catch (Exception e3) {
                        Logger logger2 = l.f64245a;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + this.f64250b, (Throwable) e3);
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.a
            public IOException b(IOException iOException) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
                    SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                    if (iOException != null) {
                        socketTimeoutException.initCause(iOException);
                    }
                    return socketTimeoutException;
                }
                return (IOException) invokeL2.objValue;
            }
        } : (a) invokeL.objValue;
    }

    public static d a(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rVar)) == null) ? new m(rVar) : (d) invokeL.objValue;
    }

    public static r a(OutputStream outputStream, t tVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, outputStream, tVar)) == null) {
            if (outputStream != null) {
                if (tVar != null) {
                    return new r(tVar, outputStream) { // from class: com.bytedance.sdk.component.b.a.l.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ t f64246a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ OutputStream f64247b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {tVar, outputStream};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64246a = tVar;
                            this.f64247b = outputStream;
                        }

                        @Override // com.bytedance.sdk.component.b.a.r
                        public t a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f64246a : (t) invokeV.objValue;
                        }

                        @Override // com.bytedance.sdk.component.b.a.r
                        public void a_(c cVar, long j2) throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) == null) {
                                u.a(cVar.f64226b, 0L, j2);
                                while (j2 > 0) {
                                    this.f64246a.g();
                                    o oVar = cVar.f64225a;
                                    int min = (int) Math.min(j2, oVar.f64260c - oVar.f64259b);
                                    this.f64247b.write(oVar.f64258a, oVar.f64259b, min);
                                    int i2 = oVar.f64259b + min;
                                    oVar.f64259b = i2;
                                    long j3 = min;
                                    j2 -= j3;
                                    cVar.f64226b -= j3;
                                    if (i2 == oVar.f64260c) {
                                        cVar.f64225a = oVar.b();
                                        p.a(oVar);
                                    }
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                this.f64247b.close();
                            }
                        }

                        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
                        public void flush() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                                this.f64247b.flush();
                            }
                        }

                        public String toString() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                                return "sink(" + this.f64247b + SmallTailInfo.EMOTION_SUFFIX;
                            }
                            return (String) invokeV.objValue;
                        }
                    };
                }
                throw new IllegalArgumentException("timeout == null");
            }
            throw new IllegalArgumentException("out == null");
        }
        return (r) invokeLL.objValue;
    }

    public static r a(Socket socket) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, socket)) == null) {
            if (socket != null) {
                if (socket.getOutputStream() != null) {
                    a c2 = c(socket);
                    return c2.a(a(socket.getOutputStream(), c2));
                }
                throw new IOException("socket's output stream == null");
            }
            throw new IllegalArgumentException("socket == null");
        }
        return (r) invokeL.objValue;
    }

    public static s a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream)) == null) ? a(inputStream, new t()) : (s) invokeL.objValue;
    }

    public static s a(InputStream inputStream, t tVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, inputStream, tVar)) == null) {
            if (inputStream != null) {
                if (tVar != null) {
                    return new s(tVar, inputStream) { // from class: com.bytedance.sdk.component.b.a.l.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ t f64248a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ InputStream f64249b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {tVar, inputStream};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64248a = tVar;
                            this.f64249b = inputStream;
                        }

                        @Override // com.bytedance.sdk.component.b.a.s
                        public long a(c cVar, long j2) throws IOException {
                            InterceptResult invokeLJ;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(1048576, this, cVar, j2)) == null) {
                                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                if (i2 < 0) {
                                    throw new IllegalArgumentException("byteCount < 0: " + j2);
                                } else if (i2 == 0) {
                                    return 0L;
                                } else {
                                    try {
                                        this.f64248a.g();
                                        o e2 = cVar.e(1);
                                        int read = this.f64249b.read(e2.f64258a, e2.f64260c, (int) Math.min(j2, 8192 - e2.f64260c));
                                        if (read == -1) {
                                            return -1L;
                                        }
                                        e2.f64260c += read;
                                        long j3 = read;
                                        cVar.f64226b += j3;
                                        return j3;
                                    } catch (AssertionError e3) {
                                        if (l.a(e3)) {
                                            throw new IOException(e3);
                                        }
                                        throw e3;
                                    }
                                }
                            }
                            return invokeLJ.longValue;
                        }

                        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                this.f64249b.close();
                            }
                        }

                        public String toString() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                                return "source(" + this.f64249b + SmallTailInfo.EMOTION_SUFFIX;
                            }
                            return (String) invokeV.objValue;
                        }

                        @Override // com.bytedance.sdk.component.b.a.s
                        public t a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64248a : (t) invokeV.objValue;
                        }
                    };
                }
                throw new IllegalArgumentException("timeout == null");
            }
            throw new IllegalArgumentException("in == null");
        }
        return (s) invokeLL.objValue;
    }

    public static boolean a(AssertionError assertionError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, assertionError)) == null) ? (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true : invokeL.booleanValue;
    }
}
