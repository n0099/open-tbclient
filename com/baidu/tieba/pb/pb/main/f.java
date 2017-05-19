package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public interface f {
    public static final AtomicReference<a> efI = new AtomicReference<>(null);

    /* loaded from: classes.dex */
    public interface a {
        f a(PbActivity pbActivity);
    }

    void M(int i, String str);

    WebView aIF();

    void aIG();
}
