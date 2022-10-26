package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import androidx.print.PrintHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yw4 extends tw4 implements qw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public final nw4 c;
    public final kw4 d;
    public final d e;
    public final HashMap f;
    public final HashMap g;
    public String h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a implements sw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ yw4 b;

        public a(yw4 yw4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yw4Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.sw4
        public void a(uw4 uw4Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, uw4Var, jSONObject) != null) {
                return;
            }
            this.b.t(uw4Var, this.a);
        }

        @Override // com.baidu.tieba.sw4
        public void b(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, th) != null) || i != 1) {
                return;
            }
            if (this.a < yw4.m.length) {
                this.b.u();
            }
            int i2 = this.a;
            if (i2 < 0 || i2 >= yw4.m.length) {
                BdLog.e("pingIndex " + this.a + " out of bounds.");
                String s = this.b.s();
                mw4.b(s, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + this.a);
                return;
            }
            this.b.x(String.valueOf(yw4.m[this.a]), "");
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends tw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.tw4
        public void e(String str, lw4 lw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, lw4Var) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView) {
            super(webView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (jw4) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // com.baidu.tieba.tw4
        public void c(uw4 uw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uw4Var) == null) {
                uw4Var.g(4, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements pw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tw4 a;
        public final String b;

        public c(tw4 tw4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tw4Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.pw4
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    mw4.a("scope " + this.b + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "cmd " + this.b + " not found");
                this.a.c(uw4.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference a;

        public d(qw4 qw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(qw4Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                qw4 qw4Var = (qw4) this.a.get();
                if (qw4Var == null) {
                    mw4.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        qw4Var.a((String) message.obj);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid message.");
                }
                qw4Var.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344563, "Lcom/baidu/tieba/yw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344563, "Lcom/baidu/tieba/yw4;");
                return;
            }
        }
        k = new int[]{1500, 2000, PrintHelper.MAX_PRINT_SIZE, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    @Override // com.baidu.tieba.qw4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j + 1;
            this.j = i;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", s());
            int[] iArr = k;
            l(uw4.i(hashMap, iArr[this.j % iArr.length], new a(this, i)), true);
            x("100", "");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yw4(WebView webView, jw4 jw4Var) {
        this(webView, new nw4(), new kw4(), jw4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, jw4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((WebView) objArr2[0], (nw4) objArr2[1], (kw4) objArr2[2], (jw4) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void t(uw4 uw4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, uw4Var, i) == null) {
            this.i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i >= 0) {
                int[] iArr = l;
                if (i < iArr.length) {
                    x(String.valueOf(iArr[i]), String.valueOf(currentTimeMillis - uw4Var.h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw4(WebView webView, nw4 nw4Var, kw4 kw4Var, jw4 jw4Var) {
        super(webView, jw4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, nw4Var, kw4Var, jw4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebView) objArr2[0], (jw4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        this.c = nw4Var;
        this.d = kw4Var;
        kw4Var.c(this);
        this.c.a(this);
        this.e = new d(this);
        this.f = new HashMap(16);
        this.g = new HashMap(8);
        q();
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            mw4.a("reInject for pingIndex " + this.j);
            r(this.a);
        }
    }

    @Override // com.baidu.tieba.tw4
    public void c(uw4 uw4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uw4Var) == null) {
            if (uw4Var.e == 3) {
                z = true;
            } else {
                z = false;
            }
            l(uw4Var, z);
        }
    }

    public static tw4 m(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, jw4 jw4Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient, jw4Var})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            yw4 yw4Var = new yw4(webView, jw4Var);
            yw4Var.c.b(webViewClient);
            yw4Var.d.d(webChromeClient);
            return yw4Var;
        }
        return (tw4) invokeCommon.objValue;
    }

    public static tw4 n(boolean z, BridgeWebView bridgeWebView, jw4 jw4Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), bridgeWebView, jw4Var})) == null) {
            if (!z) {
                return new b(bridgeWebView, null);
            }
            WebViewClient webViewClient = bridgeWebView.webViewClient;
            WebChromeClient webChromeClient = bridgeWebView.chromeClient;
            yw4 yw4Var = new yw4(bridgeWebView, jw4Var);
            yw4Var.c.b(webViewClient);
            yw4Var.d.d(webChromeClient);
            return yw4Var;
        }
        return (tw4) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qw4
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                mw4.a("invalid callbackId.");
                return;
            }
            uw4 uw4Var = (uw4) this.g.remove(str);
            if (uw4Var != null) {
                mw4.a("(" + uw4Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + uw4Var.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                uw4Var.g(1, null);
            }
        }
    }

    @Override // com.baidu.tieba.tw4
    public void e(String str, lw4 lw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, lw4Var) != null) || ((pw4) this.f.put(str, lw4Var)) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder k() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject.put("version", "1.0");
            jSONObject.put("logid", s());
            sb.append(jSONObject.toString());
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i == -1) {
                this.a.getSettings().setJavaScriptEnabled(true);
                this.a.setWebViewClient(this.c);
                this.a.setWebChromeClient(this.d);
                this.a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.i = 1;
                return;
            }
            throw new IllegalStateException("Can't init bridge more than once.");
        }
    }

    public final void l(uw4 uw4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, uw4Var, z) == null) {
            if (!z) {
                if (this.i != 0) {
                    String s = s();
                    mw4.b(s, "101", "(" + uw4Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + uw4Var.b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(uw4Var.a) || TextUtils.isEmpty(uw4Var.b)) {
                    mw4.b(s(), "102", "the alias class or method is empty");
                    uw4Var.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(uw4Var.f)) {
                if (uw4Var.e != 3) {
                    this.g.put(uw4Var.f, uw4Var);
                    if (uw4Var.g > 0) {
                        d dVar = this.e;
                        dVar.sendMessageDelayed(Message.obtain(dVar, 2, uw4Var.f), uw4Var.g);
                    } else if (uw4Var.a != null || uw4Var.b != null) {
                        mw4.a("ignore timeout check for method call (" + uw4Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + uw4Var.b + ").");
                    }
                } else {
                    mw4.a("ignore timeout check for response method, callbackId " + uw4Var.f);
                }
            }
            try {
                String b2 = uw4Var.b();
                if (Build.VERSION.SDK_INT >= 19) {
                    this.a.evaluateJavascript(b2, null);
                } else {
                    this.a.loadUrl(b2);
                }
                mw4.a(b2);
            } catch (NullPointerException e) {
                x("500", e.getMessage());
            } catch (JSONException e2) {
                if (z) {
                    x("102", e2.getMessage());
                } else {
                    mw4.a(e2.getMessage());
                }
                uw4Var.g(2, e2);
            }
        }
    }

    public String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            mw4.a("got js prompt in url:" + str + " with content:" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("messageType");
                if ("ping".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else if ("request".equals(optString)) {
                    w(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
                } else if ("response".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else {
                    String s = s();
                    mw4.b(s, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e) {
                mw4.b(s(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i = this.i;
            if (i != 2 && i != 1) {
                mw4.a("current status " + this.i + ", broken because url changed to " + str);
                this.i = 2;
            }
            if (xw4.b(str) && xw4.a(str)) {
                mw4.a("current status " + this.i + ", constructing bridge for " + str);
                jw4 jw4Var = this.b;
                if (jw4Var != null) {
                    jw4Var.b();
                }
                r(this.a);
                jw4 jw4Var2 = this.b;
                if (jw4Var2 != null) {
                    jw4Var2.a();
                }
            }
        }
    }

    public final void r(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webView) == null) {
            this.h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder k2 = k();
                k2.append(new String(bArr));
                webView.loadUrl("javascript:" + k2.toString());
                this.e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                x("102", th.getMessage());
                mw4.a(th.toString());
            }
        }
    }

    public final void v(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                mw4.a("invalid callbackId.");
                return;
            }
            this.e.removeMessages(2, str);
            uw4 uw4Var = (uw4) this.g.remove(str);
            if (uw4Var != null) {
                uw4Var.h(jSONObject);
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            mw4.c(s(), str, str2);
        }
    }

    public final void w(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.i != 0) {
                mw4.b(s(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
            }
            pw4 pw4Var = (pw4) this.f.get(str);
            if (pw4Var == null) {
                pw4Var = new c(this, str);
                String s = s();
                mw4.b(s, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
            }
            pw4Var.a(str2, jSONObject, jSONObject2);
        }
    }
}
