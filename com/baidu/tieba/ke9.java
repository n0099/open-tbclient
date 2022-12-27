package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class ke9 extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;
    public le9 b;
    public long c;
    public boolean d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947910346, "Lcom/baidu/tieba/ke9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947910346, "Lcom/baidu/tieba/ke9;");
                return;
            }
        }
        e = ke9.class.getName();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.a.available();
            } catch (IOException e2) {
                this.b.b(e2, this.c);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                try {
                    this.a.reset();
                } catch (IOException e2) {
                    this.b.b(e2, this.c);
                    throw e2;
                }
            }
        }
    }

    public ke9(InputStream inputStream, le9 le9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, le9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0L;
        this.d = false;
        this.a = inputStream;
        this.b = le9Var;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.d) {
            this.d = true;
            try {
                try {
                    if (this.a.read() == -1) {
                        this.b.onComplete(this.c);
                    } else {
                        this.b.a(this.c);
                    }
                    this.a.close();
                } catch (Exception unused) {
                    this.a.close();
                } catch (Throwable th) {
                    try {
                        this.a.close();
                    } catch (Exception e2) {
                        this.b.b(e2, this.c);
                    }
                    throw th;
                }
            } catch (Exception e3) {
                this.b.b(e3, this.c);
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d) {
                return -1;
            }
            try {
                int read = this.a.read();
                if (read >= 0) {
                    this.c += read;
                } else {
                    this.d = true;
                    this.b.onComplete(this.c);
                }
                return read;
            } catch (IOException e2) {
                this.b.b(e2, this.c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(e, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.d) {
                return -1;
            }
            try {
                int read = this.a.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.c += read;
                } else {
                    this.d = true;
                    this.b.onComplete(this.c);
                }
                return read;
            } catch (IOException e2) {
                this.b.b(e2, this.c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(e, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            if (this.d) {
                return -1;
            }
            try {
                int read = this.a.read(bArr, i, i2);
                if (read >= 0) {
                    this.c += read;
                } else {
                    this.d = true;
                    this.b.onComplete(this.c);
                }
                return read;
            } catch (IOException e2) {
                this.b.b(e2, this.c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(e, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeLII.intValue;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            long skip = this.a.skip(j);
            this.c += skip;
            return skip;
        }
        return invokeJ.longValue;
    }
}
