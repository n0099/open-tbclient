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
/* loaded from: classes4.dex */
public class d {
    private static final byte[] c = new byte[0];
    private static int d = 10;
    private static int e = 3;
    private static volatile d g = null;

    /* renamed from: a  reason: collision with root package name */
    private List<WeakReference<SSWebView>> f7143a;

    /* renamed from: b  reason: collision with root package name */
    private List<WeakReference<SSWebView>> f7144b;
    private final AtomicBoolean f = new AtomicBoolean(false);

    private d() {
        this.f7143a = new ArrayList();
        this.f7144b = new ArrayList();
        this.f7143a = new ArrayList();
        this.f7144b = new ArrayList();
    }

    public static d a() {
        if (g == null) {
            synchronized (d.class) {
                if (g == null) {
                    g = new d();
                }
            }
        }
        return g;
    }

    public void b() {
        if (!this.f.getAndSet(true)) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (int i = 0; i < e; i++) {
            SSWebView sSWebView = new SSWebView(p.a());
            sSWebView.loadUrl("about:blank");
            this.f7143a.add(new WeakReference<>(sSWebView));
        }
    }

    public WeakReference<SSWebView> c() {
        WeakReference<SSWebView> weakReference;
        WeakReference<SSWebView> weakReference2;
        u.f("webviewpool", "===start getWebView available:" + this.f7143a.size() + " ,inuse:" + this.f7144b.size());
        synchronized (c) {
            try {
                if (this.f7143a.size() > 0 && this.f7143a.get(0) != null) {
                    WeakReference<SSWebView> weakReference3 = this.f7143a.get(0);
                    if (weakReference3.get() != null) {
                        this.f7143a.remove(0);
                        this.f7144b.add(weakReference3);
                        weakReference2 = weakReference3;
                    } else {
                        this.f7143a.remove(0);
                        weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                        this.f7144b.add(weakReference2);
                    }
                } else {
                    weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                    this.f7144b.add(weakReference2);
                }
                u.f("webviewpool", "===end getWebView available:" + this.f7143a.size() + " ,inuse:" + this.f7144b.size());
                weakReference2.get().loadUrl("about:blank");
                weakReference = weakReference2;
            } catch (Exception e2) {
                weakReference = new WeakReference<>(new SSWebView(p.a()));
                this.f7144b.add(weakReference);
            }
        }
        return weakReference;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        u.f("webviewpool", "===start removeWebView available:" + this.f7143a.size() + " ,inuse:" + this.f7144b.size());
        if (z && weakReference != null && weakReference.get() != null) {
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
                synchronized (c) {
                    this.f7144b.remove(weakReference);
                    if (this.f7143a.size() < e) {
                        SSWebView sSWebView2 = new SSWebView(p.a());
                        sSWebView2.loadUrl("about:blank");
                        this.f7143a.add(new WeakReference<>(sSWebView2));
                    }
                }
            } catch (Exception e2) {
            }
            u.f("webviewpool", "===end removeWebView available:" + this.f7143a.size() + " ,inuse:" + this.f7144b.size());
        }
    }
}
