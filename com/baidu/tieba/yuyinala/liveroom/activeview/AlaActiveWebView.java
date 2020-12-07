package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bQZ;
    private List<String> bRa;
    private SchemeCallback bRc;
    private String eFu;
    private boolean hbd;
    private a okL;

    /* loaded from: classes4.dex */
    public interface a {
        void na(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bRc = new SchemeCallback() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bQZ.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bQZ.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.okL = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bRa == null) {
            this.bRa = new ArrayList();
        }
        this.bRa.add(str);
        this.bQZ.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bQZ != null) {
            this.bQZ.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bQZ != null ? this.bQZ.getOriginalUrl() : "";
    }

    public boolean bYV() {
        return this.hbd;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bQZ != null) {
            this.bQZ.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStart() {
        if (this.bQZ != null) {
            this.bQZ.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bQZ.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStop() {
        if (this.bQZ != null) {
            this.bQZ.onPause();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void release() {
        this.okL = null;
        this.hbd = false;
        removeAllViews();
        if (this.bQZ != null) {
            if (this.bRa != null) {
                for (String str : this.bRa) {
                    this.bQZ.removeJavascriptInterface(str);
                }
                this.bRa.clear();
            }
            this.bQZ.stopLoading();
            this.bQZ.removeAllViews();
            this.bQZ.loadUrl("about:blank");
            this.bQZ.freeMemory();
            this.bQZ.destroy();
        }
    }

    private void init() {
        this.hbd = false;
        setBackgroundColor(0);
        this.bQZ = new CommonWebView(getContext());
        this.bQZ.setVerticalScrollEnabled(false);
        this.bQZ.setHorizontalScrollEnabled(false);
        this.bQZ.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.hbd = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.okL != null) {
                                AlaActiveWebView.this.okL.na(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.sl(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.sl(uri);
                }
            }
        });
        addView(this.bQZ, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bQZ.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(String str) {
        this.eFu = str;
        this.bQZ.loadUrl("file:///android_asset/web/error.html");
        this.bQZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bQZ != null && AlaActiveWebView.this.bQZ.getUrl() != null && AlaActiveWebView.this.bQZ.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.eFu)) {
                    AlaActiveWebView.this.bQZ.loadUrl(AlaActiveWebView.this.eFu);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bRc;
    }
}
