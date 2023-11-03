package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes8.dex */
public interface t61 extends z51 {
    void D0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean F(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean H0(AbsNadBrowserView absNadBrowserView, String str);

    void J(AbsNadBrowserView absNadBrowserView, String str);

    void O0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void P0(AbsNadBrowserView absNadBrowserView, u61 u61Var, String str, String str2);

    void S0();

    void V();

    w61 Y(AbsNadBrowserView absNadBrowserView, String str);

    void e(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void f(AbsNadBrowserView absNadBrowserView, String str);

    void f0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void g(AbsNadBrowserView absNadBrowserView);

    void i1(AbsNadBrowserView absNadBrowserView, int i);

    void r(AbsNadBrowserView absNadBrowserView, String str);

    void w0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void x(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void y0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);
}
