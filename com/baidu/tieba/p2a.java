package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes5.dex */
public interface p2a {
    void a(boolean z);

    boolean b(WebView webView, String str);

    void c(NewWriteModel.d dVar);

    void d();

    void e(boolean z, String str);

    void onDestroy();

    void onPageFinished(WebView webView, String str);
}
