package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes6.dex */
public class e {

    /* loaded from: classes6.dex */
    public enum a {
        HTML(SapiWebView.K),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE(BdUploadHandler.IMAGE_MIME_TYPE);
        

        /* renamed from: e  reason: collision with root package name */
        public String f29005e;

        a(String str) {
            this.f29005e = str;
        }

        public String a() {
            return this.f29005e;
        }
    }

    public static a a(String str) {
        a aVar;
        a aVar2 = a.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return aVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path != null) {
                if (path.endsWith(FileHelper.FILE_CACHE_CSS)) {
                    aVar = a.CSS;
                } else if (path.endsWith(".js")) {
                    aVar = a.JS;
                } else {
                    if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico")) {
                        if (!path.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                            return aVar2;
                        }
                        aVar = a.HTML;
                    }
                    aVar = a.IMAGE;
                }
                return aVar;
            }
            return aVar2;
        } catch (Throwable unused) {
            return aVar2;
        }
    }
}
