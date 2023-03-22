package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes6.dex */
public interface u81 extends a81 {
    void D(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void E0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void F0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void K0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean O(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean Q0(AbsNadBrowserView absNadBrowserView, String str);

    void U(AbsNadBrowserView absNadBrowserView, String str);

    void U0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void V0(AbsNadBrowserView absNadBrowserView, v81 v81Var, String str, String str2);

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void c1();

    void i(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void m0();

    void o1(AbsNadBrowserView absNadBrowserView, int i);

    x81 p0(AbsNadBrowserView absNadBrowserView, String str);

    void t0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void y(AbsNadBrowserView absNadBrowserView, String str);
}
