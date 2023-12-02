package com.baidu.tieba;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes7.dex */
public final class l84 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public DatagramSocket b;
    public int c;
    public p84 d;
    public f84 e;
    public ArrayList<JsFunction> f;
    public ArrayList<JsFunction> g;
    public ArrayList<JsFunction> h;
    public ArrayList<JsFunction> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l84(JSRuntime jsRuntime) {
        super(jsRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.a = "%s:fail %s";
        this.d = new p84();
        this.e = new f84();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    public final void F(h84 h84Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, h84Var) != null) || o84.c.c(this)) {
            return;
        }
        try {
            if (!this.d.a().offer(new g84(new DatagramPacket(h84Var.b(), h84Var.d(), h84Var.c(), InetAddress.getByName(h84Var.a()), h84Var.e()), this))) {
                C("send", "send queue is full");
                return;
            }
            if (!this.d.b()) {
                this.d.c(true);
                this.d.start();
            }
            if (!this.e.a()) {
                this.e.b(true);
                this.e.c(this);
                D();
                this.e.start();
            }
        } catch (Throwable unused) {
        }
    }

    public final void y(DatagramPacket dp) {
        String str;
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dp) == null) {
            Intrinsics.checkNotNullParameter(dp, "dp");
            try {
                byte[] bArr = new byte[dp.getLength()];
                System.arraycopy(dp.getData(), dp.getOffset(), bArr, 0, dp.getLength());
                InetAddress address2 = dp.getAddress();
                if (address2 != null && (address = address2.getAddress()) != null && address.length == 4) {
                    str = "IPv4";
                } else {
                    str = "IPv6";
                }
                Iterator<JsFunction> it = this.f.iterator();
                while (it.hasNext()) {
                    String inetAddress = dp.getAddress().toString();
                    Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                    it.next().call(new j84(bArr, new k84(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    x(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (int i = 49152; i <= 65535; i++) {
                try {
                    this.b = new DatagramSocket(i);
                    w(i);
                    return i;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (DatagramSocket) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<JsFunction> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void C(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.h.iterator();
            while (it.hasNext()) {
                x(it.next(), method, error);
            }
        }
    }

    public final sy1 E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                return new sy1();
            }
            return G;
        }
        return (sy1) invokeL.objValue;
    }

    @JavascriptInterface
    public final int bind(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != -1 && !o84.c.d(i)) {
                try {
                    this.b = new DatagramSocket(i);
                    w(i);
                    return i;
                } catch (Throwable unused) {
                    return A();
                }
            }
            return A();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.i.remove(s04.e(sy1.G(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.h.remove(s04.e(sy1.G(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.remove(s04.e(sy1.G(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f.remove(s04.e(sy1.G(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            sy1 E = E(jsObject);
            if (E != null) {
                this.i.add(s04.e(E).a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            sy1 E = E(jsObject);
            if (E != null) {
                this.h.add(s04.e(E).a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.add(s04.e(sy1.G(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        sy1 E;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (!o84.c.c(this) && (E = E(jsObject)) != null) {
                this.f.add(s04.e(E).a);
            }
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            o84.c.a(i);
            this.c = i;
        }
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                DatagramSocket datagramSocket = this.b;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.d.c(false);
                this.d.interrupt();
                this.e.b(false);
                this.e.interrupt();
                o84.c.e(this);
                Iterator<JsFunction> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                C("close", "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            sy1 G = sy1.G(jsObject);
            h84 h84Var = new h84();
            String D = G.D("address", "");
            Intrinsics.checkNotNullExpressionValue(D, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            h84Var.f(D);
            String C = G.C("message");
            boolean z2 = false;
            if (C != null && C.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                byte[] buffer = G.t("message").buffer();
                if (buffer != null) {
                    h84Var.h(G.s("length", buffer.length));
                    h84Var.i(G.r("offset"));
                    h84Var.g(buffer);
                }
            } else {
                Charset charset = Charsets.UTF_8;
                if (C != null) {
                    byte[] bytes = C.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    h84Var.g(bytes);
                    Charset charset2 = Charsets.UTF_8;
                    if (C != null) {
                        byte[] bytes2 = C.getBytes(charset2);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        h84Var.h(bytes2.length);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            h84Var.j(G.s(ClientCookie.PORT_ATTR, -1));
            if (h84Var.e() == -1) {
                C("send", "port is empty");
                return;
            }
            if (h84Var.a().length() == 0) {
                z2 = true;
            }
            if (z2) {
                C("send", "address is empty");
            } else {
                F(h84Var);
            }
        }
    }

    public final void x(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.a, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new i84(format));
            }
        }
    }
}
