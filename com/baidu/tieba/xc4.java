package com.baidu.tieba;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes9.dex */
public interface xc4 {
    CookieManager f();

    int g();

    Context getAppContext();

    int getReadTimeout();

    String getUserAgent();

    boolean h();

    boolean i();

    boolean isDebug();

    void j(String str, HttpRequestBuilder httpRequestBuilder);

    int k();

    List<Interceptor> l();

    int m();
}
