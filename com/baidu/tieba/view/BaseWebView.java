package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {
    private WebViewClient a;
    private e b;
    private Context c;
    private e d;
    private g e;
    private f f;

    public BaseWebView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = context;
        a();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.d == null) {
                this.d = new c(this);
            }
            setOnLoadUrlListener(this.d);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = context;
        a();
    }

    private void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        UtilHelper.a(getSettings());
        this.a = new d(this);
        setWebViewClient(this.a);
        setOnLongClickListener(new b(this));
    }

    public void setOnLoadUrlListener(e eVar) {
        this.b = eVar;
    }

    public void setOnPageStartedListener(g gVar) {
        this.e = gVar;
    }

    public void setOnPageFinishedListener(f fVar) {
        this.f = fVar;
    }
}
