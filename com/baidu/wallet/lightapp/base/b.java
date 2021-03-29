package com.baidu.wallet.lightapp.base;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f24886a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24887b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24888c;

    /* renamed from: d  reason: collision with root package name */
    public URL f24889d;

    public b(WebView webView, String str, String str2) {
        this.f24886a = webView;
        this.f24887b = str;
        this.f24888c = str2;
        if (webView != null) {
            a(new Runnable() { // from class: com.baidu.wallet.lightapp.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.f24886a == null) {
                            return;
                        }
                        b.this.f24889d = new URL(b.this.f24886a.getUrl());
                    } catch (MalformedURLException unused) {
                    }
                }
            });
        }
    }

    public void b(final String str) {
        if (TextUtils.isEmpty(this.f24888c) || this.f24886a == null) {
            return;
        }
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.base.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URL url = new URL(b.this.f24886a.getUrl());
                    if (b.this.f24889d != null && !url.sameFile(b.this.f24889d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(b.this.f24889d.toString());
                        PayStatisticsUtil.onEventWithValues(StatServiceEvent.CALL_JS_NOT_SAME_FILE, hashSet);
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str2 = b.this.f24888c;
                if (!TextUtils.isEmpty(str)) {
                    str2 = str2 + "(" + str + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str2);
                }
                try {
                    if (b.this.f24886a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        b.this.f24886a.evaluateJavascript(str2, null);
                        return;
                    }
                    b.this.f24886a.loadUrl("javascript:" + str2);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public void a(final String str) {
        if (LogUtil.DEBUG) {
            LogUtil.logd("sucessJsCallback=" + str + "#" + this.f24887b);
        }
        if (TextUtils.isEmpty(this.f24887b) || this.f24886a == null) {
            return;
        }
        a(new Runnable() { // from class: com.baidu.wallet.lightapp.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URL url = new URL(b.this.f24886a.getUrl());
                    if (b.this.f24889d != null && !url.sameFile(b.this.f24889d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(url.toString());
                        hashSet.add(b.this.f24889d.toString());
                        PayStatisticsUtil.onEventWithValues(StatServiceEvent.CALL_JS_NOT_SAME_FILE, hashSet);
                        return;
                    }
                } catch (MalformedURLException unused) {
                }
                String str2 = b.this.f24887b;
                if (!TextUtils.isEmpty(str)) {
                    str2 = str2 + "(" + str + SmallTailInfo.EMOTION_SUFFIX;
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("loadUrl=" + str2);
                }
                try {
                    if (b.this.f24886a == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        b.this.f24886a.evaluateJavascript(str2, null);
                        return;
                    }
                    b.this.f24886a.loadUrl("javascript:" + str2);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
