package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class n25 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebViewClient a;
    public WebViewBridge b;
    public final HashSet<String> c;

    public n25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new HashSet<>(6);
    }

    public void a(WebViewBridge webViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webViewBridge) == null) {
            this.b = webViewBridge;
        }
    }

    public void b(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webViewClient) == null) {
            this.a = webViewClient;
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, webView, str, z) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, message, message2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, str, bitmap) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, webView, sslErrorHandler, sslError) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, webView, message, message2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, renderProcessGoneDetail)) == null) {
            qu4.a("BridgeWebViewClient", webView);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, webView, keyEvent) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, keyEvent)) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webView, str) == null) {
            m25.a("page " + str + " load finished.");
            if (!this.c.contains(str)) {
                this.b.p(str);
            }
            this.c.clear();
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, webView, i, str, str2) == null) {
            m25.a("Failed url " + str2 + " with description:" + str);
            this.c.add(str2);
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, httpAuthHandler, str, str2) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, webView, str, str2, str3) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:120:0x00c9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0157 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0159 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x015b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x0193 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ab  */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        WebViewClient webViewClient;
        Object obj;
        Reader reader;
        Object obj2;
        Reader reader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, webResourceRequest)) == null) {
            if (webResourceRequest != null && webResourceRequest.getUrl() != null && QuickWebViewSwitch.getInOn()) {
                String uri = webResourceRequest.getUrl().toString();
                if (kq8.v(uri)) {
                    WebViewClient webViewClient2 = this.a;
                    if (webViewClient2 != null) {
                        return webViewClient2.shouldInterceptRequest(webView, webResourceRequest);
                    }
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                try {
                    String path = new URL(uri).getPath();
                    mq8 c = lq8.a().c(path);
                    if (c == null) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else if (!c.e) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else if (!c.f) {
                        if (this.a != null) {
                            return this.a.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    } else {
                        ?? s = kq8.q().s(c.b);
                        ?? sb = new StringBuilder();
                        String p = kq8.q().p();
                        sb.append(p);
                        sb.append("/");
                        sb.append(c.b);
                        sb.append("/");
                        sb.append(s);
                        sb.append("/");
                        String str = sb.toString() + lq8.a().e(path);
                        InputStreamReader inputStreamReader = null;
                        try {
                            try {
                                s = new FileInputStream(new File(str));
                                try {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    InputStreamReader inputStreamReader2 = new InputStreamReader(s);
                                    try {
                                        p = new BufferedReader(inputStreamReader2);
                                        try {
                                            for (String readLine = p.readLine(); readLine != null; readLine = p.readLine()) {
                                                stringBuffer.append(readLine);
                                                stringBuffer.append("\n");
                                            }
                                            p.close();
                                            String stringBuffer2 = stringBuffer.toString();
                                            if (str.contains(".js")) {
                                                WebResourceResponse webResourceResponse = new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(stringBuffer2.getBytes()));
                                                fj.g(inputStreamReader2);
                                                fj.g(p);
                                                fj.e(s);
                                                return webResourceResponse;
                                            } else if (str.contains(FileHelper.FILE_CACHE_CSS)) {
                                                WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/css", "UTF-8", new ByteArrayInputStream(stringBuffer2.getBytes()));
                                                fj.g(inputStreamReader2);
                                                fj.g(p);
                                                fj.e(s);
                                                return webResourceResponse2;
                                            } else {
                                                WebResourceResponse webResourceResponse3 = new WebResourceResponse(SapiWebView.DATA_MIME_TYPE, "UTF-8", new ByteArrayInputStream(stringBuffer2.getBytes()));
                                                fj.g(inputStreamReader2);
                                                fj.g(p);
                                                fj.e(s);
                                                return webResourceResponse3;
                                            }
                                        } catch (FileNotFoundException e) {
                                            e = e;
                                            inputStreamReader = inputStreamReader2;
                                            obj2 = s;
                                            reader2 = p;
                                            e.printStackTrace();
                                            fj.g(inputStreamReader);
                                            fj.g(reader2);
                                            s = obj2;
                                            p = reader2;
                                            fj.e(s);
                                            webViewClient = this.a;
                                            if (webViewClient == null) {
                                                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                                            }
                                            return super.shouldInterceptRequest(webView, webResourceRequest);
                                        } catch (IOException e2) {
                                            e = e2;
                                            inputStreamReader = inputStreamReader2;
                                            obj = s;
                                            reader = p;
                                            e.printStackTrace();
                                            fj.g(inputStreamReader);
                                            fj.g(reader);
                                            s = obj;
                                            p = reader;
                                            fj.e(s);
                                            webViewClient = this.a;
                                            if (webViewClient == null) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStreamReader = inputStreamReader2;
                                            fj.g(inputStreamReader);
                                            fj.g(p);
                                            fj.e(s);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e3) {
                                        e = e3;
                                        p = 0;
                                    } catch (IOException e4) {
                                        e = e4;
                                        p = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        p = 0;
                                    }
                                } catch (FileNotFoundException e5) {
                                    e = e5;
                                    reader2 = null;
                                    obj2 = s;
                                } catch (IOException e6) {
                                    e = e6;
                                    reader = null;
                                    obj = s;
                                } catch (Throwable th3) {
                                    th = th3;
                                    p = 0;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (FileNotFoundException e7) {
                            e = e7;
                            obj2 = null;
                            reader2 = null;
                        } catch (IOException e8) {
                            e = e8;
                            obj = null;
                            reader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            s = 0;
                            p = 0;
                        }
                    }
                } catch (MalformedURLException e9) {
                    e9.printStackTrace();
                }
            } else {
                WebViewClient webViewClient3 = this.a;
                if (webViewClient3 != null) {
                    return webViewClient3.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        } else {
            return (WebResourceResponse) invokeLL.objValue;
        }
    }
}
