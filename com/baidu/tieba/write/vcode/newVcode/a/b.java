package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes3.dex */
public interface b {
    void D(boolean z, String str);

    boolean c(WebView webView, String str);

    void d(NewWriteModel.d dVar);

    void dus();

    void onDestroy();

    void onPageFinished(WebView webView, String str);

    void start(boolean z);
}
