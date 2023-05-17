package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes6.dex */
public interface o91 extends u81 {
    void F(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void F0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void G0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void L0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean O0(AbsNadBrowserView absNadBrowserView, String str);

    boolean P(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    void V(AbsNadBrowserView absNadBrowserView, String str);

    void V0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void X0(AbsNadBrowserView absNadBrowserView, p91 p91Var, String str, String str2);

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void b1();

    void i(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void n0();

    r91 q0(AbsNadBrowserView absNadBrowserView, String str);

    void q1(AbsNadBrowserView absNadBrowserView, int i);

    void u0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void y(AbsNadBrowserView absNadBrowserView, String str);
}
