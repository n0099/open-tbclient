package com.bytedance.sdk.openadsdk;

import android.webkit.WebResourceResponse;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public interface IKGUtils {
    WebResourceResponse findRes(String str, String str2, FindResProxy findResProxy);

    Map<String, Long> getChannelVersion();

    void preload(List<String> list);

    void releaseLoader();
}
