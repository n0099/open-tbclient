package com.bytedance.sdk.openadsdk.component.reward.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.component.reward.b.e;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends a implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u t;
    public String u;
    public boolean v;
    public final PlayableLoadingView w;
    public e.a x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        super(activity, mVar, str, i2, i3, i4, f2, z, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {activity, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Float) objArr2[6]).floatValue(), ((Boolean) objArr2[7]).booleanValue(), (String) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = true;
        this.t = new u(Looper.getMainLooper(), this);
        Activity activity2 = this.f29371a;
        this.f29376f = (SSWebView) activity2.findViewById(r.e(activity2, "tt_browser_webview_loading"));
        Activity activity3 = this.f29371a;
        this.w = (PlayableLoadingView) activity3.findViewById(r.e(activity3, "tt_reward_playable_loading"));
    }

    private void y() {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.u = o.h().p();
            j.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + this.u);
            if (TextUtils.isEmpty(this.u) || (mVar = this.f29372b) == null || mVar.al() == null) {
                return;
            }
            String c2 = this.f29372b.al().c();
            int e2 = this.f29372b.al().e();
            int f2 = this.f29372b.al().f();
            String a2 = this.f29372b.Y().a();
            String ak = this.f29372b.ak();
            String d2 = this.f29372b.al().d();
            String b2 = this.f29372b.al().b();
            String c3 = this.f29372b.al().c();
            String ah = this.f29372b.ah();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("appname=");
            stringBuffer.append(URLEncoder.encode(c2));
            stringBuffer.append("&stars=");
            stringBuffer.append(e2);
            stringBuffer.append("&comments=");
            stringBuffer.append(f2);
            stringBuffer.append("&icon=");
            stringBuffer.append(URLEncoder.encode(a2));
            stringBuffer.append("&downloading=");
            stringBuffer.append(true);
            stringBuffer.append("&id=");
            stringBuffer.append(URLEncoder.encode(ak));
            stringBuffer.append("&pkg_name=");
            stringBuffer.append(URLEncoder.encode(d2));
            stringBuffer.append("&download_url=");
            stringBuffer.append(URLEncoder.encode(b2));
            stringBuffer.append("&name=");
            stringBuffer.append(URLEncoder.encode(c3));
            stringBuffer.append("&orientation=");
            stringBuffer.append(this.n == 1 ? "portrait" : "landscape");
            stringBuffer.append("&apptitle=");
            stringBuffer.append(URLEncoder.encode(ah));
            this.u += "?" + stringBuffer.toString();
            j.c("Playable", "Playable-loadH5Url=" + this.u);
        }
    }

    public void u() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (sSWebView = this.f29376f) == null) {
            return;
        }
        sSWebView.loadUrl(this.u);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (com.bytedance.sdk.openadsdk.core.e.o.f(this.f29372b)) {
                PlayableLoadingView playableLoadingView = this.w;
                if (playableLoadingView != null) {
                    playableLoadingView.b();
                    if (com.bytedance.sdk.openadsdk.core.e.o.h(this.f29372b)) {
                        this.t.sendMessageDelayed(a(2), 10000L);
                        return;
                    }
                    return;
                }
                return;
            }
            d(false);
            PlayableLoadingView playableLoadingView2 = this.w;
            if (playableLoadingView2 != null) {
                playableLoadingView2.a();
            }
        }
    }

    public com.bytedance.sdk.openadsdk.j.d w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new com.bytedance.sdk.openadsdk.j.d(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f29397a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29397a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.j.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.f29397a.f29371a.isFinishing() && com.bytedance.sdk.openadsdk.core.e.o.f(this.f29397a.f29372b) && com.bytedance.sdk.openadsdk.core.e.o.h(this.f29397a.f29372b)) {
                    this.f29397a.t.removeMessages(10);
                    d dVar = this.f29397a;
                    dVar.t.sendMessage(dVar.a(1));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.f29397a.f29371a.isFinishing() && com.bytedance.sdk.openadsdk.core.e.o.j(this.f29397a.f29372b) && com.bytedance.sdk.openadsdk.core.e.o.f(this.f29397a.f29372b) && com.bytedance.sdk.openadsdk.core.e.o.g(this.f29397a.f29372b)) {
                    d dVar = this.f29397a;
                    dVar.t.sendMessageDelayed(dVar.a(0), 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.d
            public boolean c() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.f29397a.w != null && this.f29397a.w.getVisibility() == 0 : invokeV2.booleanValue;
            }

            @Override // com.bytedance.sdk.openadsdk.j.d
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || !com.bytedance.sdk.openadsdk.core.e.o.f(this.f29397a.f29372b) || this.f29397a.f29371a.isFinishing() || this.f29397a.w == null) {
                    return;
                }
                this.f29397a.w.setProgress(i2);
            }
        } : (com.bytedance.sdk.openadsdk.j.d) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PlayableLoadingView playableLoadingView = this.w;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
            e();
        }
    }

    public void a(boolean z, Map<String, Object> map, View view, com.bytedance.sdk.openadsdk.j.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), map, view, eVar}) == null) {
            this.f29379i = new com.bytedance.sdk.openadsdk.e.j(this.f29371a, this.f29372b, this.f29376f).b(true);
            w wVar = new w(this.f29371a);
            this.f29377g = wVar;
            wVar.b(this.f29376f).a(this.f29372b).b(this.f29372b.ak()).c(this.f29372b.ao()).a(z ? 7 : 5).a(this.f29376f).a(this.f29378h).a(this.f29373c).d(com.bytedance.sdk.openadsdk.r.o.i(this.f29372b)).a(view);
            y();
        }
    }

    public void a(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadListener) == null) {
            a(this.f29376f);
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29372b)) {
                this.f29376f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this, this.f29371a, this.f29377g, this.f29372b.ak(), null) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f29396a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r11, r12, r13, r14);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r11, r12, r13, r14};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2], (com.bytedance.sdk.openadsdk.e.j) objArr2[3]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29396a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                            if (this.f29396a.v) {
                                Context context = this.f30962c;
                                d dVar = this.f29396a;
                                com.bytedance.sdk.openadsdk.e.d.c(context, dVar.f29372b, dVar.f29373c, "loading_h5_success", (JSONObject) null);
                            }
                            super.onPageFinished(webView, str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                            super.onReceivedError(webView, webResourceRequest, webResourceError);
                            this.f29396a.v = false;
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceResponse) == null) {
                            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                            this.f29396a.v = false;
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                            super.onReceivedError(webView, i2, str, str2);
                            this.f29396a.v = false;
                        }
                    }
                });
                this.f29376f.setBackgroundColor(-16777216);
                this.f29376f.getSettings().setDisplayZoomControls(false);
                this.f29376f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.f29377g, this.f29379i));
                this.f29376f.setDownloadListener(downloadListener);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        PlayableLoadingView playableLoadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || (playableLoadingView = this.w) == null || playableLoadingView.getPlayView() == null) {
            return;
        }
        this.w.getPlayView().setOnClickListener(eVar);
        this.w.getPlayView().setOnTouchListener(eVar);
    }

    public void a(e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.x = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            Message obtain = Message.obtain();
            obtain.what = 10;
            obtain.arg1 = i2;
            return obtain;
        }
        return (Message) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 10) {
            j.b("lfz", "hide playable loading");
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.f29372b.V() != null) {
                hashMap.put("playable_url", com.bytedance.sdk.openadsdk.core.e.o.e(this.f29372b) + "");
            }
            com.bytedance.sdk.openadsdk.e.d.k(this.f29371a, this.f29372b, this.f29373c, "remove_loading_page", hashMap);
            this.t.removeMessages(10);
            PlayableLoadingView playableLoadingView = this.w;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
            e.a aVar = this.x;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
