package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public interface zm6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IPrerenderManager");

    @UiThread
    void a(@NonNull Activity activity, @NonNull String str, boolean z, boolean z2);

    @NonNull
    @UiThread
    android.webkit.WebView b(Context context, @NonNull String str);

    @UiThread
    boolean c(@NonNull String str, android.webkit.WebView webView);
}
