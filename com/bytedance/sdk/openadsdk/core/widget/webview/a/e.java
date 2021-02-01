package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
/* loaded from: classes6.dex */
public class e {
    public static a a(String str) {
        a aVar = a.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        aVar = a.CSS;
                    } else if (path.endsWith(".js")) {
                        aVar = a.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        aVar = a.IMAGE;
                    } else if (path.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                        aVar = a.HTML;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return aVar;
    }

    /* loaded from: classes6.dex */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        
        private String e;

        a(String str) {
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }
}
