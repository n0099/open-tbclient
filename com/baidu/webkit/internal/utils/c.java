package com.baidu.webkit.internal.utils;

import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class c {
    private static boolean a = false;
    private static int b = -1;

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                new File(WebViewFactory.getContext().getFilesDir(), WebKitFactory.getProcessTypeString() + "zeus_init_model_opt").createNewFile();
            } catch (IOException e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }
    }

    public static synchronized int b() {
        synchronized (c.class) {
            if (!a) {
                b = new File(WebViewFactory.getContext().getFilesDir(), new StringBuilder().append(WebKitFactory.getProcessTypeString()).append("zeus_init_model_opt").toString()).exists() ? 1 : -1;
                a = true;
            }
        }
        return 1;
    }
}
