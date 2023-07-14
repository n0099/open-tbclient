package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes8.dex */
public class vj {
    public static /* synthetic */ Interceptable $ic;
    public static sj a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        int a();

        String b();

        long c();

        void close() throws IOException;

        String d();

        String getLocalDns();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes8.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SocketChannel a;
        public long b;
        public String c;
        public String d;
        public String e;

        @Override // com.baidu.tieba.vj.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public b(String str, int i, uk ukVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), ukVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = 0L;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.c = inetSocketAddress.getAddress().getHostAddress();
                this.b = System.currentTimeMillis() - currentTimeMillis;
            }
            this.a.socket().connect(inetSocketAddress, ukVar.e());
            this.a.socket().setSoTimeout(ukVar.f());
            this.a.socket().setTcpNoDelay(ukVar.g());
            this.d = yi.p();
            this.e = yi.q();
        }

        @Override // com.baidu.tieba.vj.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.tieba.vj.a
        public void close() throws IOException {
            SocketChannel socketChannel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (socketChannel = this.a) != null) {
                socketChannel.close();
            }
        }

        @Override // com.baidu.tieba.vj.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                SocketChannel socketChannel = this.a;
                if (socketChannel != null) {
                    return socketChannel.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vj.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
                return this.a.read(byteBuffer);
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.vj.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                return this.a.write(byteBuffer);
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Socket a;
        public InputStream b;
        public OutputStream c;
        public byte[] d;
        public long e;
        public String f;
        public String g;
        public String h;

        @Override // com.baidu.tieba.vj.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(String str, int i, uk ukVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), ukVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = 0L;
            this.f = null;
            this.g = null;
            this.h = null;
            this.a = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.f = inetSocketAddress.getAddress().getHostAddress();
                this.e = System.currentTimeMillis() - currentTimeMillis;
            }
            this.a.connect(inetSocketAddress, ukVar.e());
            this.a.setSoTimeout(ukVar.f());
            this.a.setTcpNoDelay(ukVar.g());
            this.b = this.a.getInputStream();
            this.c = this.a.getOutputStream();
            this.d = new byte[1024];
            this.g = yi.p();
            this.h = yi.q();
        }

        @Override // com.baidu.tieba.vj.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.e;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.tieba.vj.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public String getLocalDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vj.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Socket socket = this.a;
                if (socket != null) {
                    return socket.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vj.a
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    this.b.close();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                try {
                    this.c.close();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                Socket socket = this.a;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // com.baidu.tieba.vj.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
                int read = this.b.read(this.d);
                if (read > 0) {
                    byteBuffer.put(this.d, 0, read);
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.vj.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    this.c.write(bArr);
                }
                return remaining;
            }
            return invokeL.intValue;
        }
    }

    public vj() {
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

    public a a(String str, int i, uk ukVar, boolean z) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), ukVar, Boolean.valueOf(z)})) == null) {
            sj sjVar = a;
            if (sjVar != null) {
                return sjVar.a(str, i, ukVar);
            }
            if (z) {
                return new b(str, i, ukVar);
            }
            return new c(str, i, ukVar);
        }
        return (a) invokeCommon.objValue;
    }
}
