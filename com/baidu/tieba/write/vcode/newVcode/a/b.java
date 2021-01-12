package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes7.dex */
public interface b {
    void H(boolean z, String str);

    boolean c(WebView webView, String str);

    void d(NewWriteModel.d dVar);

    void dUs();

    void onDestroy();

    void onPageFinished(WebView webView, String str);

    void start(boolean z);
}
