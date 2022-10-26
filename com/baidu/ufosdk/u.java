package com.baidu.ufosdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.hybrid.base.FeedbackBrowserActivity;
import com.baidu.ufosdk.hybrid.base.WebLoaderActivity;
/* loaded from: classes6.dex */
public class u extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h a;
    public ValueCallback b;

    public u(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView) == null) {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, consoleMessage)) == null) {
            h hVar = this.a;
            if (hVar != null) {
                consoleMessage.message();
                consoleMessage.lineNumber();
                consoleMessage.sourceId();
                if (((FeedbackBrowserActivity) hVar) != null) {
                    return false;
                }
                throw null;
            }
            return super.onConsoleMessage(consoleMessage);
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.a;
            if (hVar != null) {
                FeedbackBrowserActivity feedbackBrowserActivity = (FeedbackBrowserActivity) hVar;
                if (feedbackBrowserActivity != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
                    createBitmap.eraseColor(feedbackBrowserActivity.getResources().getColor(com.baidu.tieba.R.color.common_black));
                    return createBitmap;
                }
                throw null;
            }
            return super.getDefaultVideoPoster();
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h hVar = this.a;
            if (hVar != null) {
                FeedbackBrowserActivity feedbackBrowserActivity = (FeedbackBrowserActivity) hVar;
                if (feedbackBrowserActivity != null) {
                    FrameLayout frameLayout = new FrameLayout(feedbackBrowserActivity);
                    frameLayout.setBackgroundColor(feedbackBrowserActivity.getResources().getColor(com.baidu.tieba.R.color.common_transparent));
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    return frameLayout;
                }
                throw null;
            }
            return super.getVideoLoadingProgressView();
        }
        return (View) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
            return super.onCreateWindow(webView, z, z2, message);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h hVar = this.a;
            if (hVar != null) {
                hVar.a();
            } else {
                super.onHideCustomView();
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (str2.startsWith("ufobridge://")) {
                jsPromptResult.confirm(n.a(webView, str2));
            }
            if (this.a != null && !TextUtils.isEmpty(str2)) {
                f fVar = ((FeedbackBrowserActivity) this.a).f;
                if (fVar != null) {
                    z = ((FeedbackBrowserActivity.b) fVar).a(webView, str2);
                } else {
                    z = false;
                }
                if (z) {
                    jsPromptResult.confirm("");
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, webView, i) == null) && (hVar = this.a) != null) {
            hVar.b(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, bitmap) == null) {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) && !TextUtils.isEmpty(str) && str.length() <= 10) {
            this.a.b(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, customViewCallback) == null) {
            h hVar = this.a;
            if (hVar != null) {
                hVar.a(view2, customViewCallback);
            } else {
                super.onShowCustomView(view2, customViewCallback);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, webView, valueCallback, fileChooserParams)) == null) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            try {
                Intent intent = new Intent("android.intent.action.PICK");
                if (acceptTypes != null) {
                    int length = acceptTypes.length;
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (acceptTypes[i].contains("video")) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        intent.setType("image/*;video/*");
                    } else {
                        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    }
                }
                if (this.a instanceof WebLoaderActivity) {
                    ((WebLoaderActivity) this.a).startActivityForResult(intent, 1000);
                }
            } catch (Exception e) {
                b.a("UFOWebChromeClient", "Unknow Error! ", e);
            }
            this.b = valueCallback;
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
