package com.baidu.webkit.internal.utils;

import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class b {
    public static boolean a = false;
    public static int b = -1;

    public static synchronized void a() {
        synchronized (b.class) {
            File filesDir = WebViewFactory.getContext().getFilesDir();
            try {
                new File(filesDir, WebKitFactory.getProcessTypeString() + "zeus_init_model_opt").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized int b() {
        synchronized (b.class) {
            if (!a) {
                File filesDir = WebViewFactory.getContext().getFilesDir();
                StringBuilder sb = new StringBuilder();
                sb.append(WebKitFactory.getProcessTypeString());
                sb.append("zeus_init_model_opt");
                b = new File(filesDir, sb.toString()).exists() ? 1 : -1;
                a = true;
            }
        }
        return 1;
    }
}
