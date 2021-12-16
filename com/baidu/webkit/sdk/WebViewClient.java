package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.b.a;
import com.baidu.webkit.internal.b.b;
import com.baidu.webkit.internal.b.c;
import com.baidu.webkit.internal.b.d;
import com.baidu.webkit.internal.b.e;
import com.baidu.webkit.internal.b.f;
import com.baidu.webkit.internal.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class WebViewClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final String LOG_TAG = "WebViewClient";
    public static final String SCHEMA_HTTP = "http://";
    public static final String SCHEMA_HTTPS = "https://";
    public static final String TAG = "WebViewClient";
    public transient /* synthetic */ FieldHolder $fh;
    public List<g> mUrlHandlers;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class InteractionType {
        public static final /* synthetic */ InteractionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InteractionType CONTENT_CHANGE;
        public static final InteractionType FORM_SUBMIT;
        public static final InteractionType INPUT;
        public static final InteractionType OTHERS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273458109, "Lcom/baidu/webkit/sdk/WebViewClient$InteractionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-273458109, "Lcom/baidu/webkit/sdk/WebViewClient$InteractionType;");
                    return;
                }
            }
            INPUT = new InteractionType("INPUT", 0);
            CONTENT_CHANGE = new InteractionType("CONTENT_CHANGE", 1);
            FORM_SUBMIT = new InteractionType("FORM_SUBMIT", 2);
            InteractionType interactionType = new InteractionType("OTHERS", 3);
            OTHERS = interactionType;
            $VALUES = new InteractionType[]{INPUT, CONTENT_CHANGE, FORM_SUBMIT, interactionType};
        }

        public InteractionType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InteractionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InteractionType) Enum.valueOf(InteractionType.class, str) : (InteractionType) invokeL.objValue;
        }

        public static InteractionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InteractionType[]) $VALUES.clone() : (InteractionType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class SecurityInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebSiteInfo info;
        public SecurityLevel level;

        public SecurityInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.level = SecurityLevel.UNCERTAIN;
        }

        public SecurityLevel getSecurityLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.level : (SecurityLevel) invokeV.objValue;
        }

        public WebSiteInfo getWebSiteInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.info : (WebSiteInfo) invokeV.objValue;
        }

        public void setSecurityLevel(SecurityLevel securityLevel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, securityLevel) == null) {
                this.level = securityLevel;
            }
        }

        public void setWebSiteInfo(WebSiteInfo webSiteInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webSiteInfo) == null) {
                this.info = webSiteInfo;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class SecurityLevel {
        public static final /* synthetic */ SecurityLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SecurityLevel DANGEROUS;
        public static final SecurityLevel DEFAULT;
        public static final SecurityLevel FAKE_BAIDU;
        public static final SecurityLevel FAKE_SITE;
        public static final SecurityLevel FORBIDDEN;
        public static final SecurityLevel MALCIOUS_RESOURCE;
        public static final SecurityLevel SECURE;
        public static final SecurityLevel UNCERTAIN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-905069429, "Lcom/baidu/webkit/sdk/WebViewClient$SecurityLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-905069429, "Lcom/baidu/webkit/sdk/WebViewClient$SecurityLevel;");
                    return;
                }
            }
            SECURE = new SecurityLevel("SECURE", 0);
            DANGEROUS = new SecurityLevel("DANGEROUS", 1);
            UNCERTAIN = new SecurityLevel("UNCERTAIN", 2);
            FORBIDDEN = new SecurityLevel("FORBIDDEN", 3);
            FAKE_BAIDU = new SecurityLevel("FAKE_BAIDU", 4);
            FAKE_SITE = new SecurityLevel("FAKE_SITE", 5);
            MALCIOUS_RESOURCE = new SecurityLevel("MALCIOUS_RESOURCE", 6);
            SecurityLevel securityLevel = new SecurityLevel("DEFAULT", 7);
            DEFAULT = securityLevel;
            $VALUES = new SecurityLevel[]{SECURE, DANGEROUS, UNCERTAIN, FORBIDDEN, FAKE_BAIDU, FAKE_SITE, MALCIOUS_RESOURCE, securityLevel};
        }

        public SecurityLevel(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SecurityLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SecurityLevel) Enum.valueOf(SecurityLevel.class, str) : (SecurityLevel) invokeL.objValue;
        }

        public static SecurityLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SecurityLevel[]) $VALUES.clone() : (SecurityLevel[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class WebSiteInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public WebSiteType type;

        public WebSiteInfo(WebSiteType webSiteType, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webSiteType, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = WebSiteType.UNCERTAIN;
            this.type = webSiteType;
            this.name = str;
        }

        public String getWebSiteName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public WebSiteType getWebSiteType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (WebSiteType) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class WebSiteType {
        public static final /* synthetic */ WebSiteType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WebSiteType BANK;
        public static final WebSiteType DEFAULT;
        public static final WebSiteType EBUSINESS;
        public static final WebSiteType EVIL_DOWNLOAD;
        public static final WebSiteType FAKEBAIDU;
        public static final WebSiteType PAYMENT;
        public static final WebSiteType PHONE_STATE;
        public static final WebSiteType UNCERTAIN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-541380294, "Lcom/baidu/webkit/sdk/WebViewClient$WebSiteType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-541380294, "Lcom/baidu/webkit/sdk/WebViewClient$WebSiteType;");
                    return;
                }
            }
            BANK = new WebSiteType("BANK", 0);
            PAYMENT = new WebSiteType("PAYMENT", 1);
            EBUSINESS = new WebSiteType("EBUSINESS", 2);
            FAKEBAIDU = new WebSiteType("FAKEBAIDU", 3);
            UNCERTAIN = new WebSiteType("UNCERTAIN", 4);
            PHONE_STATE = new WebSiteType("PHONE_STATE", 5);
            EVIL_DOWNLOAD = new WebSiteType("EVIL_DOWNLOAD", 6);
            WebSiteType webSiteType = new WebSiteType("DEFAULT", 7);
            DEFAULT = webSiteType;
            $VALUES = new WebSiteType[]{BANK, PAYMENT, EBUSINESS, FAKEBAIDU, UNCERTAIN, PHONE_STATE, EVIL_DOWNLOAD, webSiteType};
        }

        public WebSiteType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static WebSiteType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebSiteType) Enum.valueOf(WebSiteType.class, str) : (WebSiteType) invokeL.objValue;
        }

        public static WebSiteType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebSiteType[]) $VALUES.clone() : (WebSiteType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface ZeusVideoInfoDelegate {
        void notifyUpdateVideoInfo(String str);
    }

    public WebViewClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUrlHandlers = new ArrayList();
        addUrlHandler(new c());
        addUrlHandler(new b());
        addUrlHandler(new d());
        addUrlHandler(new f());
        addUrlHandler(new a());
        addUrlHandler(new e());
    }

    public void AntiHijackSign(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
        }
    }

    public void addUrlHandler(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.mUrlHandlers.add(gVar);
    }

    public boolean canHandleImage(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public int computeHookH5NavigationStep(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
        }
    }

    public void onAbortResourceRequest(WebView webView, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{webView, str, str2, Long.valueOf(j2)}) == null) {
        }
    }

    public void onBaiduSearchPVCollected(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, webView) == null) {
        }
    }

    public void onCancel(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
        }
    }

    public void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{webView, str, str2, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onDiTingUploadFeatures(WebView webView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, webView, str, str2, str3) == null) {
        }
    }

    public void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{webView, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    public void onDisplaySoftKeyboard(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, webView) == null) {
        }
    }

    public void onDownloadStart(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, webView, str) == null) {
        }
    }

    public void onFirstContentfulPaint(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, webView, str) == null) {
        }
    }

    public void onFirstDrawnDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, webView, str) == null) {
        }
    }

    public void onFirstImagePaint(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, webView, str) == null) {
        }
    }

    public void onFirstLayoutDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, webView, str) == null) {
        }
    }

    public void onFirstMeaningfulPaint(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webView, str) == null) {
        }
    }

    public void onFirstPaintDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, webView, str) == null) {
        }
    }

    public void onFirstScreenImagePaintFinished(WebView webView, FirstScreenImageInfomation firstScreenImageInfomation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, webView, firstScreenImageInfomation) == null) {
        }
    }

    public void onFirstScreenPaintFinished(WebView webView, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{webView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
        }
    }

    public void onFirstTextPaint(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, webView, str) == null) {
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, webView, message, message2) == null) {
            message.sendToTarget();
        }
    }

    public void onFullScreenMode(WebView webView, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{webView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
        }
    }

    public void onGestureFlingEnded(WebView webView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048600, this, webView, i2, i3) == null) {
        }
    }

    public void onGestureScrollEnded(WebView webView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048601, this, webView, i2, i3) == null) {
        }
    }

    public void onGestureScrollStarted(WebView webView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048602, this, webView, i2, i3) == null) {
        }
    }

    public String onGetErrorContent(WebView webView, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048603, this, webView, i2, str, str2)) == null) {
            return null;
        }
        return (String) invokeLILL.objValue;
    }

    public void onGoBackOrForward(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, webView, i2) == null) {
        }
    }

    public void onGoBackOrForwardAnimationFinish(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, webView, i2) == null) {
        }
    }

    public void onGoBackOrForwardAnimationStart(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, webView, i2) == null) {
        }
    }

    public void onGotNotResponse(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, webView) == null) {
        }
    }

    public void onHandleBackForwardBeyondHistory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    public void onHasVideo(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, webView) == null) {
        }
    }

    public void onHideSoftKeyboard(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, webView) == null) {
        }
    }

    public void onHyperLink(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, webView, str, str2) == null) {
        }
    }

    public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jsCodeCacheResult) == null) {
        }
    }

    public void onJsJumpDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, webView, str) == null) {
        }
    }

    public void onKeywordExtension(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, webView, str, str2) == null) {
        }
    }

    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, webView, str) == null) {
        }
    }

    public void onMagicFilterAbortResourceRequest(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048616, this, str, str2, z) == null) {
        }
    }

    public void onMagicFilterHideElement(WebView webView, String str, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{webView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
        }
    }

    public void onMainActionsCollected(WebView webView, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{webView, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
        }
    }

    public void onMainResourceHttpcodeDid(WebView webView, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048619, this, webView, i2, str) == null) {
        }
    }

    public void onMainResourceIdDid(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, webView, i2) == null) {
        }
    }

    public void onMainResourceNetcodeDid(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, webView, i2) == null) {
        }
    }

    public void onMainResourceResponseDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, webView, str) == null) {
        }
    }

    public void onManifestChanged(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, webView) == null) {
        }
    }

    public void onNavigationAnimationFinish(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, webView) == null) {
        }
    }

    public void onNavigationAnimationFinish(WebView webView, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public void onNavigationAnimationStart(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, webView) == null) {
        }
    }

    public void onNavigationAnimationStart(WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, webView, z) == null) {
        }
    }

    public void onNewHistoryItem(WebView webView, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048628, this, webView, str, i2) == null) {
        }
    }

    public void onNotifyVideoInfo(VideoSniffingInfo videoSniffingInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, videoSniffingInfo) == null) {
        }
    }

    public void onPageCanBeScaled(WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048630, this, webView, z) == null) {
        }
    }

    public void onPageCommitVisible(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, webView, str, z) == null) {
        }
    }

    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048632, this, webView, str) == null) && webView != null && webView.getContext().getPackageName().contains("com.baidu.searchbox")) {
            webView.getSecureProcessor().c();
        }
    }

    public void onPageLoadTime(WebView webView, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{webView, str, Long.valueOf(j2)}) == null) {
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048634, this, webView, str, bitmap) == null) && webView != null && webView.getContext().getPackageName().contains("com.baidu.searchbox")) {
            webView.getSecureProcessor().c();
        }
    }

    public void onPageSwitching(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, webView) == null) {
        }
    }

    public void onPageWithHSTSDid(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onPausePlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
        }
    }

    public void onPlayPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
        }
    }

    public void onPreloadUrlFound(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, webView, str) == null) {
        }
    }

    public void onProceededAfterSslError(WebView webView, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, webView, sslError) == null) {
        }
    }

    public String onProcessWebSearchUrl(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, webView, str)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, webView, clientCertRequest) == null) {
            clientCertRequest.cancel();
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048643, this, webView, clientCertRequest, str) == null) {
            onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Deprecated
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048644, this, webView, i2, str, str2) == null) {
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048645, this, webView, webResourceRequest, webResourceError) == null) {
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048646, this, webView, httpAuthHandler, str, str2) == null) {
            httpAuthHandler.cancel();
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048647, this, webView, webResourceRequest, webResourceResponse) == null) {
        }
    }

    public void onReceivedImageDataCompleted(String str, String str2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048648, this, str, str2, bArr) == null) {
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048649, this, webView, str, str2, str3) == null) {
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048650, this, webView, sslErrorHandler, sslError) == null) {
            sslErrorHandler.cancel();
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048651, this, webView, renderProcessGoneDetail)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onResourceLoaded(WebView webView, String str, long j2, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{webView, str, Long.valueOf(j2), str2, str3, Integer.valueOf(i2)}) == null) {
        }
    }

    public void onRestoreFromCache(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, webView, str) == null) {
        }
    }

    public void onRestoreFromPageCacheDid(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048654, this, webView, str) == null) {
        }
    }

    public void onResumePlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
        }
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{webView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    public void onSearchLandingPageClicked(WebView webView, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048657, this, new Object[]{webView, str, str2, Long.valueOf(j2)}) == null) {
        }
    }

    public void onSecurityCheckResult(WebView webView, String str, SecurityInfo securityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048658, this, webView, str, securityInfo) == null) {
        }
    }

    public void onStartFirstNavigation(WebView webView, String str, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
        }
    }

    public boolean onSubFrameBeforeRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048660, this, webView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void onSubjectsCollected(WebView webView, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{webView, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
        }
    }

    public boolean onSupportsForceZoomScale(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, webView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean onTextCopied(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, webView)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onThemeColorChanged(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048664, this, webView, i2) == null) {
        }
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048665, this, webView, message, message2) == null) {
            message.sendToTarget();
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, webView, keyEvent) == null) {
        }
    }

    public void onUpdateTextFieldNextPreStatus(WebView webView, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public void onUrlRedirectedDid(WebView webView, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048668, this, webView, str, str2, i2) == null) {
        }
    }

    public void onUserInteraction(WebView webView, String str, InteractionType interactionType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048669, this, webView, str, interactionType) == null) {
        }
    }

    public void removeUrlHander(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, gVar) == null) || gVar == null) {
            return;
        }
        this.mUrlHandlers.remove(gVar);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048671, this, webView, webResourceRequest)) == null) ? shouldInterceptRequest(webView, webResourceRequest.getUrl().toString()) : (WebResourceResponse) invokeLL.objValue;
    }

    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048672, this, webView, str)) == null) {
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public boolean shouldKeywordExtension(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048673, this, webView, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldLoadInNewWebView(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048674, this, webView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOpenFlash(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048675, this, webView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048676, this, webView, keyEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048677, this, webView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048678, this, webView, webResourceRequest)) == null) ? shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString()) : invokeLL.booleanValue;
    }

    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048679, this, webView, str)) == null) {
            for (g gVar : this.mUrlHandlers) {
                if (gVar.a(webView.getContext(), str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void shouldPageRollBack(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, webView, str) == null) {
        }
    }

    public boolean shouldShowSubject(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048681, this, webView, str, str2, str3)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
