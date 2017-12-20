package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public interface e {
    public static final AtomicReference<a> eSK = new AtomicReference<>(null);

    /* loaded from: classes.dex */
    public interface a {
        e a(PbActivity pbActivity);
    }

    void W(int i, String str);

    WebView aSI();

    void aSJ();
}
