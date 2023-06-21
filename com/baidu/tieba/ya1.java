package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes8.dex */
public interface ya1 extends ea1 {
    void F(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void F0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void G0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void L0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean O(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean O0(AbsNadBrowserView absNadBrowserView, String str);

    void V(AbsNadBrowserView absNadBrowserView, String str);

    void V0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void W0(AbsNadBrowserView absNadBrowserView, za1 za1Var, String str, String str2);

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void b1();

    void i(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void n0();

    bb1 q0(AbsNadBrowserView absNadBrowserView, String str);

    void q1(AbsNadBrowserView absNadBrowserView, int i);

    void u0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void y(AbsNadBrowserView absNadBrowserView, String str);
}
