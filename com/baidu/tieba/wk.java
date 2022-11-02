package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class wk extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;
    public final Handler b;
    public final Looper c;
    public final uj.a d;
    public final tk e;
    public final qj f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448320857, "Lcom/baidu/tieba/wk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448320857, "Lcom/baidu/tieba/wk;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk(Looper looper, Handler handler, uj.a aVar, tk tkVar) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, handler, aVar, tkVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Random();
        this.c = looper;
        this.b = handler;
        this.d = aVar;
        this.e = tkVar;
        this.f = new qj(tkVar.b() + 14, 262144);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (wk.class) {
                g = 0L;
            }
        }
    }

    public long c() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (wk.class) {
                j = g;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            byte[] bArr = new byte[16];
            this.a.nextBytes(bArr);
            return pi.j(bArr);
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.c.quit();
            } catch (Exception unused) {
            }
            try {
                this.d.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = obj;
            return sendMessage(obtainMessage);
        }
        return invokeL.booleanValue;
    }

    public final void f(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.obj = obj;
            this.b.sendMessage(obtainMessage);
        }
    }

    public void g(Object obj) throws WebSocketException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            throw new WebSocketException("unknown message received by WebSocketWriter");
        }
    }

    public final void j(ak akVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, akVar) == null) {
            if (akVar.a.length <= this.e.c()) {
                m(2, true, akVar.a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final boolean o(ik ikVar) throws IOException, WebSocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, ikVar)) == null) {
            byte[] e = ikVar.a.e();
            if (e == null) {
                return false;
            }
            if (e.length <= this.e.c()) {
                m(2, true, e);
                return true;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
        return invokeL.booleanValue;
    }

    public final void p(jk jkVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jkVar) == null) {
            byte[] bArr = jkVar.a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("ping payload exceeds 125 octets");
            }
            m(9, true, jkVar.a);
        }
    }

    public final void q(kk kkVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kkVar) == null) {
            byte[] bArr = kkVar.a;
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("pong payload exceeds 125 octets");
            }
            m(10, true, kkVar.a);
        }
    }

    public final void r(mk mkVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mkVar) == null) {
            if (mkVar.a.length <= this.e.c()) {
                m(1, true, mkVar.a);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public final void s(sk skVar) throws IOException, WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, skVar) == null) {
            byte[] bytes = skVar.a.getBytes("UTF-8");
            if (bytes.length <= this.e.c()) {
                m(1, true, bytes);
                return;
            }
            throw new WebSocketException("message payload exceeds payload limit");
        }
    }

    public boolean h(Object obj) throws IOException, WebSocketException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof ik) {
                return o((ik) obj);
            }
            if (obj instanceof sk) {
                s((sk) obj);
                return true;
            } else if (obj instanceof mk) {
                r((mk) obj);
                return true;
            } else if (obj instanceof ak) {
                j((ak) obj);
                return true;
            } else if (obj instanceof jk) {
                p((jk) obj);
                return true;
            } else if (obj instanceof kk) {
                q((kk) obj);
                return true;
            } else if (obj instanceof ck) {
                l((ck) obj);
                return true;
            } else if (obj instanceof bk) {
                k((bk) obj);
                return true;
            } else {
                g(obj);
                throw null;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
            try {
                if (message.obj == null) {
                    return;
                }
                sj sjVar = null;
                if (message.obj instanceof ik) {
                    sjVar = ((ik) message.obj).a;
                }
                this.f.a();
                if (!h(message.obj)) {
                    f(new nk(sjVar));
                    return;
                }
                this.f.e();
                if (sjVar != null) {
                    f(new rk(sjVar));
                }
                while (this.f.g() > 0) {
                    if (this.d == null) {
                        f(new dk(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.d.write(this.f.f());
                    if (write > 0) {
                        synchronized (wk.class) {
                            g += write;
                        }
                    }
                }
                if (sjVar != null) {
                    f(new gk(sjVar));
                }
            } catch (SocketException e) {
                f(new dk(e));
            } catch (Exception e2) {
                if (d()) {
                    e2.printStackTrace();
                }
                f(new fk(e2));
            }
        }
    }

    public final void k(bk bkVar) throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bkVar) == null) {
            if (bkVar.c != null) {
                str = bkVar.b + "?" + bkVar.c;
            } else {
                str = bkVar.b;
            }
            this.f.h("GET " + str + " HTTP/1.1");
            this.f.c();
            this.f.h("Host: " + bkVar.a);
            this.f.c();
            this.f.h("Upgrade: WebSocket");
            this.f.c();
            this.f.h("Connection: Upgrade");
            this.f.c();
            this.f.h("Sec-WebSocket-Key: " + e());
            this.f.c();
            tk tkVar = this.e;
            if (tkVar != null && tkVar.i() != null && this.e.i().length() > 0) {
                this.f.h("Sec-WebSocket-Extensions: " + this.e.i());
                this.f.c();
            }
            String str2 = bkVar.d;
            if (str2 != null && !str2.equals("")) {
                this.f.h("Origin: " + bkVar.d);
                this.f.c();
            }
            String[] strArr = bkVar.e;
            if (strArr != null && strArr.length > 0) {
                this.f.h("Sec-WebSocket-Protocol: ");
                int i = 0;
                while (true) {
                    String[] strArr2 = bkVar.e;
                    if (i >= strArr2.length) {
                        break;
                    }
                    this.f.h(strArr2[i]);
                    this.f.h(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    i++;
                }
                this.f.c();
            }
            this.f.h("Sec-WebSocket-Version: 13");
            this.f.c();
            List<BasicNameValuePair> list = bkVar.f;
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.f.h(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                    this.f.c();
                }
            }
            this.f.c();
        }
    }

    public final void l(ck ckVar) throws IOException, WebSocketException {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ckVar) == null) {
            if (ckVar.a > 0) {
                String str = ckVar.b;
                if (str != null && !str.equals("")) {
                    byte[] bytes = ckVar.b.getBytes("UTF-8");
                    bArr = new byte[bytes.length + 2];
                    for (int i = 0; i < bytes.length; i++) {
                        bArr[i + 2] = bytes[i];
                    }
                } else {
                    bArr = new byte[2];
                }
                if (bArr.length <= 125) {
                    int i2 = ckVar.a;
                    bArr[0] = (byte) ((i2 >> 8) & 255);
                    bArr[1] = (byte) (i2 & 255);
                    m(8, true, bArr);
                    return;
                }
                throw new WebSocketException("close payload exceeds 125 octets");
            }
            m(8, true, null);
        }
    }

    public void m(int i, boolean z, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bArr}) == null) {
            if (bArr != null) {
                n(i, z, bArr, 0, bArr.length);
            } else {
                n(i, z, null, 0, 0);
            }
        }
    }

    public void n(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        byte b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bArr, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            byte b2 = Byte.MIN_VALUE;
            if (z) {
                b = (byte) (-128);
                i4 = i;
            } else {
                i4 = i;
                b = 0;
            }
            this.f.write((byte) (b | ((byte) i4)));
            if (!this.e.a()) {
                b2 = 0;
            }
            long j = i3;
            if (j <= 125) {
                this.f.write((byte) (b2 | ((byte) j)));
            } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.f.write((byte) (b2 | 126));
                this.f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (j & 255)});
            } else {
                this.f.write((byte) (b2 | ByteCompanionObject.MAX_VALUE));
                this.f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)});
            }
            if (this.e.a()) {
                this.f.write(0);
                this.f.write(0);
                this.f.write(0);
                this.f.write(0);
            }
            if (j > 0) {
                this.e.a();
                this.f.write(bArr, i2, i3);
            }
        }
    }
}
