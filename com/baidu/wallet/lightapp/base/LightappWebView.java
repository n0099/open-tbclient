package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.webmanager.SafeWebView;
/* loaded from: classes5.dex */
public class LightappWebView extends SafeWebView {

    /* renamed from: a  reason: collision with root package name */
    public a f25329a;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);
    }

    public LightappWebView(Context context) {
        super(new MutableContextWrapper(context));
    }

    @Override // com.baidu.apollon.webmanager.SafeWebView
    public void impactJavascriptInterfaces() {
        super.impactJavascriptInterfaces();
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript("(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()", null);
            } else {
                super.loadUrl("javascript:(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()");
            }
        } catch (Throwable unused) {
        }
        LogUtil.d("LightappWebView", "RuntimeReady:(function JsSendRuntimeReadyToClouda_(){    var event = document.createEvent('Events');    event.initEvent('runtimeready', false,false);    document.dispatchEvent(event);})()");
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f25329a;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void setBaseContext(Context context) {
        ((MutableContextWrapper) getContext()).setBaseContext(context);
    }

    public void setOnMyScrollChangeListener(a aVar) {
        this.f25329a = aVar;
    }

    public LightappWebView(Context context, AttributeSet attributeSet) {
        super(new MutableContextWrapper(context), attributeSet);
    }
}
