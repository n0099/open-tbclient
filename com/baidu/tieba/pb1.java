package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes7.dex */
public interface pb1 extends va1 {
    void A0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    boolean F(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    void F0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean I0(AbsNadBrowserView absNadBrowserView, String str);

    void J(AbsNadBrowserView absNadBrowserView, String str);

    void O0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void T0(AbsNadBrowserView absNadBrowserView, qb1 qb1Var, String str, String str2);

    void W0();

    void Y();

    sb1 b0(AbsNadBrowserView absNadBrowserView, String str);

    void c(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void f(AbsNadBrowserView absNadBrowserView, String str);

    void g(AbsNadBrowserView absNadBrowserView);

    void i0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void j1(AbsNadBrowserView absNadBrowserView, int i);

    void q(AbsNadBrowserView absNadBrowserView, String str);

    void x(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void z0(AbsNadBrowserView absNadBrowserView, String str, boolean z);
}
