package com.baidu.wallet.core;

import android.content.Context;
import android.net.http.HttpResponseCache;
import com.baidu.mobstat.Config;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23909a = "HttpCache";

    public static void a(Context context) {
        try {
            HttpResponseCache.install(new File(context.getCacheDir(), "http"), Config.FULL_TRACE_LOG_LIMIT);
        } catch (IOException e2) {
            LogUtil.i(f23909a, "HTTP response cache installation failed:" + e2);
        }
    }

    public static void a() {
        HttpResponseCache installed = HttpResponseCache.getInstalled();
        if (installed != null) {
            installed.flush();
        }
    }
}
