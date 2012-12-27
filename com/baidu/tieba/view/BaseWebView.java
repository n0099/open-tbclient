package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private WebViewClient a;
    private e b;
    private Context c;
    private e d;

    public BaseWebView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = context;
        a();
    }

    private void b() {
        this.d = new c(this);
    }

    public void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        com.baidu.tieba.c.ag.a(getSettings());
        this.a = new d(this);
        setWebViewClient(this.a);
        setOnLongClickListener(new b(this));
    }

    public void setDownloadEnabled(boolean z) {
        if (!z) {
            setOnLoadUrlListener(null);
            return;
        }
        if (this.d == null) {
            b();
        }
        setOnLoadUrlListener(this.d);
    }

    public void setOnLoadUrlListener(e eVar) {
        this.b = eVar;
    }
}
