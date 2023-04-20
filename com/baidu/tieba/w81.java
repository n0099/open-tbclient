package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes6.dex */
public interface w81 extends c81 {
    void F(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void F0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void G0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void L0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean P(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean P0(AbsNadBrowserView absNadBrowserView, String str);

    void U0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void V(AbsNadBrowserView absNadBrowserView, String str);

    void V0(AbsNadBrowserView absNadBrowserView, x81 x81Var, String str, String str2);

    void a1();

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void i(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void n0();

    void o1(AbsNadBrowserView absNadBrowserView, int i);

    z81 q0(AbsNadBrowserView absNadBrowserView, String str);

    void u0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void y(AbsNadBrowserView absNadBrowserView, String str);
}
