package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public interface f {
    public static final AtomicReference<a> dOi = new AtomicReference<>(null);

    /* loaded from: classes.dex */
    public interface a {
        f a(PbActivity pbActivity);
    }

    void L(int i, String str);

    WebView aEw();

    void aEx();
}
