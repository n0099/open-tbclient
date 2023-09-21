package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class ub1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void a(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    public abstract sb1 b(AbsNadBrowserView absNadBrowserView, String str);

    public abstract void c(AbsNadBrowserView absNadBrowserView, String str);

    public abstract boolean d(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    public abstract boolean e(AbsNadBrowserView absNadBrowserView, String str);

    public abstract void f(AbsNadBrowserView absNadBrowserView, String str);

    public abstract void g(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    public abstract void h(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    public abstract void i(AbsNadBrowserView absNadBrowserView, qb1 qb1Var, String str, String str2);

    public abstract void j(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    public abstract void k(AbsNadBrowserView absNadBrowserView, float f, float f2);

    public abstract void l(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    public abstract void m(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    public ub1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
