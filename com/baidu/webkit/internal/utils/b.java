package com.baidu.webkit.internal.utils;

import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5981a;

    /* renamed from: b  reason: collision with root package name */
    private static int f5982b = -1;

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
            if (!f5981a) {
                f5982b = new File(WebViewFactory.getContext().getFilesDir(), new StringBuilder().append(WebKitFactory.getProcessTypeString()).append("zeus_init_model_opt").toString()).exists() ? 1 : -1;
                f5981a = true;
            }
        }
        return 1;
    }
}
