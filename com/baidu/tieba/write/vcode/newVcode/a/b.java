package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes2.dex */
public interface b {
    boolean bzb();

    void d(NewWriteModel.d dVar);

    void onDestroy();

    void onPageFinished(WebView webView, String str);

    void onPostThreadCancle();

    boolean onUrlLoad(WebView webView, String str);

    void showErrorOnStart(boolean z, String str);

    void start(boolean z);
}
