package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
/* loaded from: classes6.dex */
public interface v52 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);

        WebResourceResponse b(String str, Map<String, String> map, boolean z);

        boolean c();

        String d();

        String getMimeType();

        Map<String, String> getRequestHeaders();
    }

    WebResourceResponse a(@NonNull a aVar);
}
