package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes7.dex */
public interface mb1 extends sa1 {
    void A(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void A0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void B0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void F0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean L(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean M0(AbsNadBrowserView absNadBrowserView, String str);

    void Q(AbsNadBrowserView absNadBrowserView, String str);

    void S0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void T0(AbsNadBrowserView absNadBrowserView, nb1 nb1Var, String str, String str2);

    void W0();

    void c(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void e(AbsNadBrowserView absNadBrowserView, String str);

    void f(AbsNadBrowserView absNadBrowserView);

    void k0();

    void l1(AbsNadBrowserView absNadBrowserView, int i);

    pb1 n0(AbsNadBrowserView absNadBrowserView, String str);

    void s(AbsNadBrowserView absNadBrowserView, String str);

    void s0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);
}
