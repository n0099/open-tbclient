package com.baidu.webkit.internal.utils;

import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3950a;
    private static int b = -1;

    public static synchronized void a() {
        synchronized (b.class) {
            try {
                new File(WebViewFactory.getContext().getFilesDir(), WebKitFactory.getProcessTypeString() + "zeus_init_model_opt").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized int b() {
        synchronized (b.class) {
            if (!f3950a) {
                b = new File(WebViewFactory.getContext().getFilesDir(), new StringBuilder().append(WebKitFactory.getProcessTypeString()).append("zeus_init_model_opt").toString()).exists() ? 1 : -1;
                f3950a = true;
            }
        }
        return 1;
    }
}
