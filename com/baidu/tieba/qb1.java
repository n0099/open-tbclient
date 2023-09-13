package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes7.dex */
public interface qb1 extends wa1 {
    void A0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void B0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void F0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean J(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean M0(AbsNadBrowserView absNadBrowserView, String str);

    void Q(AbsNadBrowserView absNadBrowserView, String str);

    void T0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void U0(AbsNadBrowserView absNadBrowserView, rb1 rb1Var, String str, String str2);

    void X0();

    void c(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void f(AbsNadBrowserView absNadBrowserView, String str);

    void g(AbsNadBrowserView absNadBrowserView);

    void g0();

    void m1(AbsNadBrowserView absNadBrowserView, int i);

    tb1 n0(AbsNadBrowserView absNadBrowserView, String str);

    void s(AbsNadBrowserView absNadBrowserView, String str);

    void s0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void z(AbsNadBrowserView absNadBrowserView, float f, float f2);
}
