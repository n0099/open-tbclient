package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes8.dex */
public interface w61 extends c61 {
    void C0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean F(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean G0(AbsNadBrowserView absNadBrowserView, String str);

    void J(AbsNadBrowserView absNadBrowserView, String str);

    void N0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void O0(AbsNadBrowserView absNadBrowserView, x61 x61Var, String str, String str2);

    void S0();

    void U();

    z61 X(AbsNadBrowserView absNadBrowserView, String str);

    void e(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void f(AbsNadBrowserView absNadBrowserView, String str);

    void f0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void g(AbsNadBrowserView absNadBrowserView);

    void g1(AbsNadBrowserView absNadBrowserView, int i);

    void p0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void r(AbsNadBrowserView absNadBrowserView, String str);

    void s0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void x(AbsNadBrowserView absNadBrowserView, float f, float f2);
}
