package com.baidu.webkit.internal.utils;

import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f27455a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f27456b = -1;

    public static synchronized void a() {
        synchronized (b.class) {
            File filesDir = WebViewFactory.getContext().getFilesDir();
            try {
                new File(filesDir, WebKitFactory.getProcessTypeString() + "zeus_init_model_opt").createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized int b() {
        synchronized (b.class) {
            if (!f27455a) {
                File filesDir = WebViewFactory.getContext().getFilesDir();
                StringBuilder sb = new StringBuilder();
                sb.append(WebKitFactory.getProcessTypeString());
                sb.append("zeus_init_model_opt");
                f27456b = new File(filesDir, sb.toString()).exists() ? 1 : -1;
                f27455a = true;
            }
        }
        return 1;
    }
}
