package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes7.dex */
public interface y81 extends e81 {
    void F(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void G0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void H0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void M0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean O(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean Q0(AbsNadBrowserView absNadBrowserView, String str);

    void V(AbsNadBrowserView absNadBrowserView, String str);

    void V0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void Y0(AbsNadBrowserView absNadBrowserView, z81 z81Var, String str, String str2);

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void e1();

    void f(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void o0();

    void q1(AbsNadBrowserView absNadBrowserView, int i);

    b91 r0(AbsNadBrowserView absNadBrowserView, String str);

    void v0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void y(AbsNadBrowserView absNadBrowserView, String str);
}
