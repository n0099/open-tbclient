package com.baidu.ufosdk.hybrid.base;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.f;
import com.baidu.ufosdk.g;
import com.baidu.ufosdk.h;
import com.baidu.ufosdk.hybrid.api.BDServiceTools;
import com.baidu.ufosdk.hybrid.api.PageOperationApi;
import com.baidu.ufosdk.hybrid.api.PassAccountApi;
import com.baidu.ufosdk.n;
import com.baidu.ufosdk.o;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.t;
import com.baidu.ufosdk.u;
import com.baidu.ufosdk.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FeedbackBrowserActivity extends BaseActivity implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView d;
    public g e;
    public f f;
    public boolean g;
    public View h;
    public FrameLayout i;
    public WebChromeClient.CustomViewCallback j;
    public int k;
    public int l;

    @Override // com.baidu.ufosdk.h
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
        }
    }

    @Override // com.baidu.ufosdk.h
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.ufosdk.h
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    @Override // com.baidu.ufosdk.h
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackBrowserActivity a;

        public a(FeedbackBrowserActivity feedbackBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackBrowserActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !Boolean.parseBoolean(str)) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h a;
        public WeakReference<WebView> b;
        public v c;
        public u d;

        public b(h hVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, webView};
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
            if (webView != null) {
                WeakReference<WebView> weakReference = new WeakReference<>(webView);
                this.b = weakReference;
                a(weakReference.get());
            }
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.a("ufo.apimodel.page", PageOperationApi.class);
                n.a("ufo.apimodel.toolbar", BDServiceTools.class);
                n.a("ufo.apimodel.account", PassAccountApi.class);
            }
        }

        public final void a(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) {
                this.c = new v(this.a);
                u uVar = new u(this.a);
                this.d = uVar;
                webView.setWebChromeClient(uVar);
                webView.setWebViewClient(this.c);
            }
        }

        public boolean a(WebView webView, String str) {
            InterceptResult invokeLL;
            String str2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (str.startsWith("http") || str.startsWith("https")) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    str2 = "";
                } else {
                    Uri parse = Uri.parse(str);
                    str2 = parse.getScheme() + "://" + parse.getHost();
                }
                if (!TextUtils.isEmpty(str2)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("ufobridge://ufo.apimodel.page");
                    arrayList.add("ufobridge://ufo.apimodel.toolbar");
                    arrayList.add("ufobridge://ufo.apimodel.account");
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equalsIgnoreCase(str2)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        n.a(webView, str);
                        return true;
                    }
                }
                if (!str.startsWith("baiduboxlite://") && !str.startsWith("baiduboxapp://")) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final o b;

        public c(Context context, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context.getApplicationContext();
            this.b = new o(webView);
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                if (TextUtils.isEmpty(str2)) {
                    o oVar = this.b;
                    oVar.a = str;
                    oVar.a("''");
                    return;
                }
                o oVar2 = this.b;
                oVar2.a = str;
                oVar2.a(str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setBackgroundColor(context.getResources().getColor(R.color.common_black));
        }
    }

    public FeedbackBrowserActivity() {
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
        this.g = false;
    }

    @Override // android.app.Activity
    public void onPause() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            f fVar = this.f;
            if (fVar != null && (webView = ((b) fVar).b.get()) != null) {
                webView.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            f fVar = this.f;
            if (fVar != null && (webView = ((b) fVar).b.get()) != null) {
                webView.resumeTimers();
                webView.onResume();
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            if (this.g) {
                ((c) this.e).a("window.onSdkShow", null);
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            if (this.g) {
                ((c) this.e).a("window.onSdkHide", null);
            }
        }
    }

    @Override // com.baidu.ufosdk.h
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h != null) {
            FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
            frameLayout.setSystemUiVisibility(this.k);
            frameLayout.removeView(this.i);
            frameLayout.clearFocus();
            if (this.i != null) {
                this.i = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            WebChromeClient.CustomViewCallback customViewCallback = this.j;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
                this.j = null;
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WebView webView = this.d;
            if (webView != null && webView.canGoBack()) {
                this.d.goBack();
                return;
            }
            WebView webView2 = this.d;
            if (webView2 != null && this.l == 1) {
                webView2.evaluateJavascript("javascript:evaRobotPop()", new a(this));
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.ufosdk.h
    public void a(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, customViewCallback) == null) {
            if (this.h != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            try {
                FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
                this.k = frameLayout.getSystemUiVisibility();
                this.i = new d(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.i.addView(view2, 0, layoutParams);
                frameLayout.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setSystemUiVisibility(5890);
                this.h = view2;
                this.j = customViewCallback;
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.ufosdk.h
    public void c(String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !this.g && (gVar = this.e) != null) {
            c cVar = (c) gVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("os", com.baidu.ufosdk.b.e(cVar.a));
                jSONObject.put("appid", e0.a(cVar.a).b);
                jSONObject.put("devid", e0.a(cVar.a).c);
                jSONObject.put("clientid", e0.a(cVar.a).a);
                jSONObject.put("pkgname", com.baidu.ufosdk.c.a());
                jSONObject.put("appvn", com.baidu.ufosdk.c.b());
                jSONObject.put("sdkvn", "4.1.9.1");
                jSONObject.put("user", com.baidu.ufosdk.b.b());
                jSONObject.put("uid", com.baidu.ufosdk.b.c());
                jSONObject.put("baiducuid", com.baidu.ufosdk.b.f());
                jSONObject.put(FpsTracer.UBC_KEY_NET_TYPE, p1.b(cVar.a));
                jSONObject.put("channel_id", com.baidu.ufosdk.b.h());
                jSONObject.put("nightMode", com.baidu.ufosdk.b.m());
                Context context = cVar.a;
                int i = 0;
                int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
                if (identifier > 0) {
                    i = context.getResources().getDimensionPixelOffset(identifier);
                }
                jSONObject.put("statusBarHeight", i);
                jSONObject.put("extras", com.baidu.ufosdk.b.g());
                cVar.a("window.onSdkLoad", jSONObject.toString());
            } catch (Exception unused) {
            }
            ((c) this.e).a("window.onSdkShow", null);
            this.g = true;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) && this.f != null && i == 1000) {
            if (i2 == -1 || i2 == 0) {
                u uVar = ((b) this.f).d;
                if (uVar.b == null) {
                    com.baidu.ufosdk.b.a("UFOWebChromeClient", "error! callback null");
                    return;
                }
                Uri[] uriArr = null;
                try {
                    if (i2 != 0 && intent != null) {
                        String dataString = intent.getDataString();
                        ClipData clipData = intent.getClipData();
                        if (clipData != null) {
                            uriArr = new Uri[clipData.getItemCount()];
                            for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                                uriArr[i3] = clipData.getItemAt(i3).getUri();
                            }
                        }
                        if (dataString != null) {
                            uriArr = new Uri[]{Uri.parse(dataString)};
                        }
                        ValueCallback<Uri[]> valueCallback = uVar.b;
                        if (valueCallback != null) {
                            valueCallback.onReceiveValue(uriArr);
                            return;
                        }
                        return;
                    }
                    Log.i("FeedbackSDK-V4.1.9.1", com.baidu.ufosdk.b.b("UFOWebChromeClient", "exit photo select"));
                    ValueCallback<Uri[]> valueCallback2 = uVar.b;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                    }
                } catch (Exception e) {
                    com.baidu.ufosdk.b.a("UFOWebChromeClient", "upload image Exception", e);
                }
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            int i2 = 0;
            if (intent != null) {
                try {
                    i2 = intent.getIntExtra("page_category", 0);
                } catch (Exception unused) {
                    intent.replaceExtras((Bundle) null);
                }
            }
            this.l = i2;
            try {
                t tVar = new t(this);
                this.d = tVar;
                if (com.baidu.ufosdk.b.m() == 1) {
                    i = BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG;
                } else {
                    i = -1;
                }
                tVar.setBackgroundColor(i);
                this.e = new c(this, this.d);
                this.f = new b(this, this.d);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.g) {
                ((c) this.e).a("window.onSdkUnload", null);
            }
            f fVar = this.f;
            if (fVar != null) {
                b bVar = (b) fVar;
                WebView webView = bVar.b.get();
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    webView.stopLoading();
                    webView.clearHistory();
                    webView.removeAllViews();
                    webView.setWebViewClient(null);
                    webView.setWebChromeClient(null);
                    webView.destroy();
                    bVar.b.clear();
                }
                this.d = null;
            }
            super.onDestroy();
        }
    }
}
