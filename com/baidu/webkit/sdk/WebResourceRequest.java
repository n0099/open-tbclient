package com.baidu.webkit.sdk;

import android.net.Uri;
import java.util.Map;
/* loaded from: classes6.dex */
public interface WebResourceRequest {
    String getMethod();

    Map getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();

    boolean isRedirect();
}
