package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
import java.util.List;
/* loaded from: classes8.dex */
public interface wn6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IPrefetchManager");

    List<Pair<String, Long>> a(String str);
}
