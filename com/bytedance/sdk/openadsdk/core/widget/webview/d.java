package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f29598c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static int f29599d = 10;

    /* renamed from: e  reason: collision with root package name */
    public static int f29600e = 3;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f29601g;

    /* renamed from: a  reason: collision with root package name */
    public List<WeakReference<SSWebView>> f29602a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<SSWebView>> f29603b;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f29604f = new AtomicBoolean(false);

    public d() {
        this.f29602a = new ArrayList();
        this.f29603b = new ArrayList();
        this.f29602a = new ArrayList();
        this.f29603b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (int i2 = 0; i2 < f29600e; i2++) {
            SSWebView sSWebView = new SSWebView(p.a());
            sSWebView.loadUrl("about:blank");
            this.f29602a.add(new WeakReference<>(sSWebView));
        }
    }

    public void b() {
        if (this.f29604f.getAndSet(true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d();
                }
            });
        }
    }

    public WeakReference<SSWebView> c() {
        WeakReference<SSWebView> weakReference;
        WeakReference<SSWebView> weakReference2;
        u.f("webviewpool", "===start getWebView available:" + this.f29602a.size() + " ,inuse:" + this.f29603b.size());
        synchronized (f29598c) {
            try {
            } catch (Exception unused) {
                WeakReference<SSWebView> weakReference3 = new WeakReference<>(new SSWebView(p.a()));
                this.f29603b.add(weakReference3);
                weakReference = weakReference3;
            }
            if (this.f29602a.size() > 0 && this.f29602a.get(0) != null) {
                weakReference = this.f29602a.get(0);
                if (weakReference.get() != null) {
                    this.f29602a.remove(0);
                    this.f29603b.add(weakReference);
                    u.f("webviewpool", "===end getWebView available:" + this.f29602a.size() + " ,inuse:" + this.f29603b.size());
                    weakReference.get().loadUrl("about:blank");
                } else {
                    this.f29602a.remove(0);
                    weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                    this.f29603b.add(weakReference2);
                }
            } else {
                weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                this.f29603b.add(weakReference2);
            }
            weakReference = weakReference2;
            u.f("webviewpool", "===end getWebView available:" + this.f29602a.size() + " ,inuse:" + this.f29603b.size());
            weakReference.get().loadUrl("about:blank");
        }
        return weakReference;
    }

    public static d a() {
        if (f29601g == null) {
            synchronized (d.class) {
                if (f29601g == null) {
                    f29601g = new d();
                }
            }
        }
        return f29601g;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        u.f("webviewpool", "===start removeWebView available:" + this.f29602a.size() + " ,inuse:" + this.f29603b.size());
        if (!z || weakReference == null || weakReference.get() == null) {
            return;
        }
        try {
            SSWebView sSWebView = weakReference.get();
            viewGroup.removeView(sSWebView);
            sSWebView.loadUrl("");
            sSWebView.stopLoading();
            sSWebView.setWebChromeClient(null);
            sSWebView.setWebViewClient(null);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            sSWebView.getSettings().setJavaScriptEnabled(true);
            sSWebView.getSettings().setCacheMode(2);
            sSWebView.getSettings().setAppCacheEnabled(false);
            sSWebView.getSettings().setSupportZoom(false);
            sSWebView.getSettings().setUseWideViewPort(true);
            sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.getSettings().setDomStorageEnabled(true);
            sSWebView.getSettings().setBuiltInZoomControls(false);
            sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            sSWebView.getSettings().setLoadWithOverviewMode(false);
            sSWebView.getSettings().setUserAgentString("android_client");
            sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
            sSWebView.getSettings().setDefaultFontSize(16);
            aa.a(p.a(), sSWebView);
            aa.a(sSWebView);
            synchronized (f29598c) {
                this.f29603b.remove(weakReference);
                if (this.f29602a.size() < f29600e) {
                    SSWebView sSWebView2 = new SSWebView(p.a());
                    sSWebView2.loadUrl("about:blank");
                    this.f29602a.add(new WeakReference<>(sSWebView2));
                }
            }
        } catch (Exception unused) {
        }
        u.f("webviewpool", "===end removeWebView available:" + this.f29602a.size() + " ,inuse:" + this.f29603b.size());
    }
}
