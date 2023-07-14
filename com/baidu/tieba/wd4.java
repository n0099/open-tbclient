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
/* loaded from: classes8.dex */
public final class wd4 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public DatagramSocket b;
    public int c;
    public ae4 d;
    public qd4 e;
    public ArrayList<JsFunction> f;
    public ArrayList<JsFunction> g;
    public ArrayList<JsFunction> h;
    public ArrayList<JsFunction> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd4(JSRuntime jsRuntime) {
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
        this.d = new ae4();
        this.e = new qd4();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    public final void G(sd4 sd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, sd4Var) != null) || zd4.c.c(this)) {
            return;
        }
        try {
            if (!this.d.a().offer(new rd4(new DatagramPacket(sd4Var.b(), sd4Var.d(), sd4Var.c(), InetAddress.getByName(sd4Var.a()), sd4Var.e()), this))) {
                D("send", "send queue is full");
                return;
            }
            if (!this.d.b()) {
                this.d.c(true);
                this.d.start();
            }
            if (!this.e.a()) {
                this.e.b(true);
                this.e.c(this);
                E();
                this.e.start();
            }
        } catch (Throwable unused) {
        }
    }

    public final void z(DatagramPacket dp) {
        String str;
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dp) == null) {
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
                    it.next().call(new ud4(bArr, new vd4(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    y(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 49152; i <= 65535; i++) {
                try {
                    this.b = new DatagramSocket(i);
                    x(i);
                    return i;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (DatagramSocket) invokeV.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Iterator<JsFunction> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final void D(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.h.iterator();
            while (it.hasNext()) {
                y(it.next(), method, error);
            }
        }
    }

    public final c42 F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            c42 F = c42.F(jsObject);
            if (F == null) {
                return new c42();
            }
            return F;
        }
        return (c42) invokeL.objValue;
    }

    @JavascriptInterface
    public final int bind(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != -1 && !zd4.c.d(i)) {
                try {
                    this.b = new DatagramSocket(i);
                    x(i);
                    return i;
                } catch (Throwable unused) {
                    return B();
                }
            }
            return B();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.i.remove(d64.e(c42.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.h.remove(d64.e(c42.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.remove(d64.e(c42.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f.remove(d64.e(c42.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c42 F = F(jsObject);
            if (F != null) {
                this.i.add(d64.e(F).a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c42 F = F(jsObject);
            if (F != null) {
                this.h.add(d64.e(F).a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.add(d64.e(c42.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        c42 F;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (!zd4.c.c(this) && (F = F(jsObject)) != null) {
                this.f.add(d64.e(F).a);
            }
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            zd4.c.a(i);
            this.c = i;
        }
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                DatagramSocket datagramSocket = this.b;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.d.c(false);
                this.d.interrupt();
                this.e.b(false);
                this.e.interrupt();
                zd4.c.e(this);
                Iterator<JsFunction> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                D("close", "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            c42 F = c42.F(jsObject);
            sd4 sd4Var = new sd4();
            String C = F.C("address", "");
            Intrinsics.checkNotNullExpressionValue(C, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            sd4Var.f(C);
            String B = F.B("message");
            boolean z2 = false;
            if (B != null && B.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                byte[] buffer = F.s("message").buffer();
                if (buffer != null) {
                    sd4Var.h(F.r("length", buffer.length));
                    sd4Var.i(F.q("offset"));
                    sd4Var.g(buffer);
                }
            } else {
                Charset charset = Charsets.UTF_8;
                if (B != null) {
                    byte[] bytes = B.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    sd4Var.g(bytes);
                    Charset charset2 = Charsets.UTF_8;
                    if (B != null) {
                        byte[] bytes2 = B.getBytes(charset2);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        sd4Var.h(bytes2.length);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            sd4Var.j(F.r(ClientCookie.PORT_ATTR, -1));
            if (sd4Var.e() == -1) {
                D("send", "port is empty");
                return;
            }
            if (sd4Var.a().length() == 0) {
                z2 = true;
            }
            if (z2) {
                D("send", "address is empty");
            } else {
                G(sd4Var);
            }
        }
    }

    public final void y(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.a, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new td4(format));
            }
        }
    }
}
